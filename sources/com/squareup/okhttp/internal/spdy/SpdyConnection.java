package com.squareup.okhttp.internal.spdy;

import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.NamedRunnable;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.spdy.FrameReader;
import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.h;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class SpdyConnection implements Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int OKHTTP_CLIENT_WINDOW_SIZE = 16777216;
    private static final ExecutorService executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp SpdyConnection", true));
    long bytesLeftInWriteWindow;
    final boolean client;
    private final Set<Integer> currentPushRequests;
    final FrameWriter frameWriter;
    private final IncomingStreamHandler handler;
    private final String hostName;
    private long idleStartTimeNs;
    private int lastGoodStreamId;
    private int nextPingId;
    private int nextStreamId;
    final Settings okHttpSettings;
    final Settings peerSettings;
    private Map<Integer, Ping> pings;
    final Protocol protocol;
    private final ExecutorService pushExecutor;
    private final PushObserver pushObserver;
    final Reader readerRunnable;
    private boolean receivedInitialPeerSettings;
    private boolean shutdown;
    final Socket socket;
    private final Map<Integer, SpdyStream> streams;
    long unacknowledgedBytesRead;
    final Variant variant;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static class Builder {
        private boolean client;
        private IncomingStreamHandler handler;
        private String hostName;
        private Protocol protocol;
        private PushObserver pushObserver;
        private Socket socket;

        public Builder(boolean z, Socket socket) throws IOException {
            this(((InetSocketAddress) socket.getRemoteSocketAddress()).getHostName(), z, socket);
        }

        public SpdyConnection build() throws IOException {
            return new SpdyConnection(this);
        }

        public Builder handler(IncomingStreamHandler incomingStreamHandler) {
            this.handler = incomingStreamHandler;
            return this;
        }

        public Builder protocol(Protocol protocol) {
            this.protocol = protocol;
            return this;
        }

        public Builder pushObserver(PushObserver pushObserver) {
            this.pushObserver = pushObserver;
            return this;
        }

        public Builder(String str, boolean z, Socket socket) throws IOException {
            this.handler = IncomingStreamHandler.REFUSE_INCOMING_STREAMS;
            this.protocol = Protocol.SPDY_3;
            this.pushObserver = PushObserver.CANCEL;
            this.hostName = str;
            this.client = z;
            this.socket = socket;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    class Reader extends NamedRunnable implements FrameReader.Handler {
        FrameReader frameReader;

        private void ackSettingsLater(final Settings settings) {
            SpdyConnection.executor.execute(new NamedRunnable("OkHttp %s ACK Settings", new Object[]{SpdyConnection.this.hostName}) { // from class: com.squareup.okhttp.internal.spdy.SpdyConnection.Reader.2
                @Override // com.squareup.okhttp.internal.NamedRunnable
                public void execute() {
                    try {
                        SpdyConnection.this.frameWriter.ackSettings(settings);
                    } catch (IOException unused) {
                    }
                }
            });
        }

        @Override // com.squareup.okhttp.internal.spdy.FrameReader.Handler
        public void ackSettings() {
        }

        @Override // com.squareup.okhttp.internal.spdy.FrameReader.Handler
        public void alternateService(int i, String str, ByteString byteString, String str2, int i2, long j) {
        }

        @Override // com.squareup.okhttp.internal.spdy.FrameReader.Handler
        public void data(boolean z, int i, BufferedSource bufferedSource, int i2) throws IOException {
            if (SpdyConnection.this.pushedStream(i)) {
                SpdyConnection.this.pushDataLater(i, bufferedSource, i2, z);
                return;
            }
            SpdyStream stream = SpdyConnection.this.getStream(i);
            if (stream == null) {
                SpdyConnection.this.writeSynResetLater(i, ErrorCode.INVALID_STREAM);
                bufferedSource.skip(i2);
                return;
            }
            stream.receiveData(bufferedSource, i2);
            if (z) {
                stream.receiveFin();
            }
        }

        @Override // com.squareup.okhttp.internal.NamedRunnable
        protected void execute() {
            ErrorCode errorCode;
            ErrorCode errorCode2;
            ErrorCode errorCode3 = ErrorCode.INTERNAL_ERROR;
            try {
                try {
                    SpdyConnection spdyConnection = SpdyConnection.this;
                    FrameReader newReader = spdyConnection.variant.newReader(h.d(h.m(spdyConnection.socket)), SpdyConnection.this.client);
                    this.frameReader = newReader;
                    if (!SpdyConnection.this.client) {
                        newReader.readConnectionPreface();
                    }
                    while (this.frameReader.nextFrame(this)) {
                    }
                    errorCode2 = ErrorCode.NO_ERROR;
                } catch (IOException unused) {
                    errorCode2 = errorCode3;
                } catch (Throwable th) {
                    th = th;
                    errorCode = errorCode3;
                    try {
                        SpdyConnection.this.close(errorCode, errorCode3);
                    } catch (IOException unused2) {
                    }
                    Util.closeQuietly(this.frameReader);
                    throw th;
                }
            } catch (IOException unused3) {
            }
            try {
                try {
                    SpdyConnection.this.close(errorCode2, ErrorCode.CANCEL);
                } catch (Throwable th2) {
                    errorCode = errorCode2;
                    th = th2;
                    SpdyConnection.this.close(errorCode, errorCode3);
                    Util.closeQuietly(this.frameReader);
                    throw th;
                }
            } catch (IOException unused4) {
                ErrorCode errorCode4 = ErrorCode.PROTOCOL_ERROR;
                SpdyConnection.this.close(errorCode4, errorCode4);
                Util.closeQuietly(this.frameReader);
            }
            Util.closeQuietly(this.frameReader);
        }

        @Override // com.squareup.okhttp.internal.spdy.FrameReader.Handler
        public void goAway(int i, ErrorCode errorCode, ByteString byteString) {
            SpdyStream[] spdyStreamArr;
            byteString.size();
            synchronized (SpdyConnection.this) {
                spdyStreamArr = (SpdyStream[]) SpdyConnection.this.streams.values().toArray(new SpdyStream[SpdyConnection.this.streams.size()]);
                SpdyConnection.this.shutdown = true;
            }
            for (SpdyStream spdyStream : spdyStreamArr) {
                if (spdyStream.getId() > i && spdyStream.isLocallyInitiated()) {
                    spdyStream.receiveRstStream(ErrorCode.REFUSED_STREAM);
                    SpdyConnection.this.removeStream(spdyStream.getId());
                }
            }
        }

        @Override // com.squareup.okhttp.internal.spdy.FrameReader.Handler
        public void headers(boolean z, boolean z2, int i, int i2, List<Header> list, HeadersMode headersMode) {
            if (SpdyConnection.this.pushedStream(i)) {
                SpdyConnection.this.pushHeadersLater(i, list, z2);
                return;
            }
            synchronized (SpdyConnection.this) {
                if (SpdyConnection.this.shutdown) {
                    return;
                }
                SpdyStream stream = SpdyConnection.this.getStream(i);
                if (stream == null) {
                    if (!headersMode.failIfStreamAbsent()) {
                        if (i <= SpdyConnection.this.lastGoodStreamId) {
                            return;
                        }
                        if (i % 2 == SpdyConnection.this.nextStreamId % 2) {
                            return;
                        }
                        final SpdyStream spdyStream = new SpdyStream(i, SpdyConnection.this, z, z2, list);
                        SpdyConnection.this.lastGoodStreamId = i;
                        SpdyConnection.this.streams.put(Integer.valueOf(i), spdyStream);
                        SpdyConnection.executor.execute(new NamedRunnable("OkHttp %s stream %d", new Object[]{SpdyConnection.this.hostName, Integer.valueOf(i)}) { // from class: com.squareup.okhttp.internal.spdy.SpdyConnection.Reader.1
                            @Override // com.squareup.okhttp.internal.NamedRunnable
                            public void execute() {
                                try {
                                    SpdyConnection.this.handler.receive(spdyStream);
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                        });
                        return;
                    }
                    SpdyConnection.this.writeSynResetLater(i, ErrorCode.INVALID_STREAM);
                } else if (headersMode.failIfStreamPresent()) {
                    stream.closeLater(ErrorCode.PROTOCOL_ERROR);
                    SpdyConnection.this.removeStream(i);
                } else {
                    stream.receiveHeaders(list, headersMode);
                    if (z2) {
                        stream.receiveFin();
                    }
                }
            }
        }

        @Override // com.squareup.okhttp.internal.spdy.FrameReader.Handler
        public void ping(boolean z, int i, int i2) {
            if (z) {
                Ping removePing = SpdyConnection.this.removePing(i);
                if (removePing != null) {
                    removePing.receive();
                    return;
                }
                return;
            }
            SpdyConnection.this.writePingLater(true, i, i2, null);
        }

        @Override // com.squareup.okhttp.internal.spdy.FrameReader.Handler
        public void priority(int i, int i2, int i3, boolean z) {
        }

        @Override // com.squareup.okhttp.internal.spdy.FrameReader.Handler
        public void pushPromise(int i, int i2, List<Header> list) {
            SpdyConnection.this.pushRequestLater(i2, list);
        }

        @Override // com.squareup.okhttp.internal.spdy.FrameReader.Handler
        public void rstStream(int i, ErrorCode errorCode) {
            if (SpdyConnection.this.pushedStream(i)) {
                SpdyConnection.this.pushResetLater(i, errorCode);
                return;
            }
            SpdyStream removeStream = SpdyConnection.this.removeStream(i);
            if (removeStream != null) {
                removeStream.receiveRstStream(errorCode);
            }
        }

        @Override // com.squareup.okhttp.internal.spdy.FrameReader.Handler
        public void settings(boolean z, Settings settings) {
            SpdyStream[] spdyStreamArr;
            long j;
            synchronized (SpdyConnection.this) {
                int initialWindowSize = SpdyConnection.this.peerSettings.getInitialWindowSize(65536);
                if (z) {
                    SpdyConnection.this.peerSettings.clear();
                }
                SpdyConnection.this.peerSettings.merge(settings);
                if (SpdyConnection.this.getProtocol() == Protocol.HTTP_2) {
                    ackSettingsLater(settings);
                }
                int initialWindowSize2 = SpdyConnection.this.peerSettings.getInitialWindowSize(65536);
                spdyStreamArr = null;
                if (initialWindowSize2 == -1 || initialWindowSize2 == initialWindowSize) {
                    j = 0;
                } else {
                    j = initialWindowSize2 - initialWindowSize;
                    if (!SpdyConnection.this.receivedInitialPeerSettings) {
                        SpdyConnection.this.addBytesToWriteWindow(j);
                        SpdyConnection.this.receivedInitialPeerSettings = true;
                    }
                    if (!SpdyConnection.this.streams.isEmpty()) {
                        spdyStreamArr = (SpdyStream[]) SpdyConnection.this.streams.values().toArray(new SpdyStream[SpdyConnection.this.streams.size()]);
                    }
                }
            }
            if (spdyStreamArr == null || j == 0) {
                return;
            }
            for (SpdyStream spdyStream : spdyStreamArr) {
                synchronized (spdyStream) {
                    spdyStream.addBytesToWriteWindow(j);
                }
            }
        }

        @Override // com.squareup.okhttp.internal.spdy.FrameReader.Handler
        public void windowUpdate(int i, long j) {
            if (i == 0) {
                synchronized (SpdyConnection.this) {
                    SpdyConnection spdyConnection = SpdyConnection.this;
                    spdyConnection.bytesLeftInWriteWindow += j;
                    spdyConnection.notifyAll();
                }
                return;
            }
            SpdyStream stream = SpdyConnection.this.getStream(i);
            if (stream != null) {
                synchronized (stream) {
                    stream.addBytesToWriteWindow(j);
                }
            }
        }

        private Reader() {
            super("OkHttp %s", SpdyConnection.this.hostName);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pushDataLater(final int i, BufferedSource bufferedSource, final int i2, final boolean z) throws IOException {
        final Buffer buffer = new Buffer();
        long j = i2;
        bufferedSource.require(j);
        bufferedSource.read(buffer, j);
        if (buffer.size() == j) {
            this.pushExecutor.execute(new NamedRunnable("OkHttp %s Push Data[%s]", new Object[]{this.hostName, Integer.valueOf(i)}) { // from class: com.squareup.okhttp.internal.spdy.SpdyConnection.6
                @Override // com.squareup.okhttp.internal.NamedRunnable
                public void execute() {
                    try {
                        boolean onData = SpdyConnection.this.pushObserver.onData(i, buffer, i2, z);
                        if (onData) {
                            SpdyConnection.this.frameWriter.rstStream(i, ErrorCode.CANCEL);
                        }
                        if (onData || z) {
                            synchronized (SpdyConnection.this) {
                                SpdyConnection.this.currentPushRequests.remove(Integer.valueOf(i));
                            }
                        }
                    } catch (IOException unused) {
                    }
                }
            });
            return;
        }
        throw new IOException(buffer.size() + " != " + i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pushHeadersLater(final int i, final List<Header> list, final boolean z) {
        this.pushExecutor.execute(new NamedRunnable("OkHttp %s Push Headers[%s]", new Object[]{this.hostName, Integer.valueOf(i)}) { // from class: com.squareup.okhttp.internal.spdy.SpdyConnection.5
            @Override // com.squareup.okhttp.internal.NamedRunnable
            public void execute() {
                boolean onHeaders = SpdyConnection.this.pushObserver.onHeaders(i, list, z);
                if (onHeaders) {
                    try {
                        SpdyConnection.this.frameWriter.rstStream(i, ErrorCode.CANCEL);
                    } catch (IOException unused) {
                        return;
                    }
                }
                if (onHeaders || z) {
                    synchronized (SpdyConnection.this) {
                        SpdyConnection.this.currentPushRequests.remove(Integer.valueOf(i));
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pushRequestLater(final int i, final List<Header> list) {
        synchronized (this) {
            if (this.currentPushRequests.contains(Integer.valueOf(i))) {
                writeSynResetLater(i, ErrorCode.PROTOCOL_ERROR);
                return;
            }
            this.currentPushRequests.add(Integer.valueOf(i));
            this.pushExecutor.execute(new NamedRunnable("OkHttp %s Push Request[%s]", new Object[]{this.hostName, Integer.valueOf(i)}) { // from class: com.squareup.okhttp.internal.spdy.SpdyConnection.4
                @Override // com.squareup.okhttp.internal.NamedRunnable
                public void execute() {
                    if (SpdyConnection.this.pushObserver.onRequest(i, list)) {
                        try {
                            SpdyConnection.this.frameWriter.rstStream(i, ErrorCode.CANCEL);
                            synchronized (SpdyConnection.this) {
                                SpdyConnection.this.currentPushRequests.remove(Integer.valueOf(i));
                            }
                        } catch (IOException unused) {
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pushResetLater(final int i, final ErrorCode errorCode) {
        this.pushExecutor.execute(new NamedRunnable("OkHttp %s Push Reset[%s]", new Object[]{this.hostName, Integer.valueOf(i)}) { // from class: com.squareup.okhttp.internal.spdy.SpdyConnection.7
            @Override // com.squareup.okhttp.internal.NamedRunnable
            public void execute() {
                SpdyConnection.this.pushObserver.onReset(i, errorCode);
                synchronized (SpdyConnection.this) {
                    SpdyConnection.this.currentPushRequests.remove(Integer.valueOf(i));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pushedStream(int i) {
        return this.protocol == Protocol.HTTP_2 && i != 0 && (i & 1) == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized Ping removePing(int i) {
        Map<Integer, Ping> map;
        map = this.pings;
        return map != null ? map.remove(Integer.valueOf(i)) : null;
    }

    private synchronized void setIdle(boolean z) {
        long nanoTime;
        if (z) {
            try {
                nanoTime = System.nanoTime();
            } catch (Throwable th) {
                throw th;
            }
        } else {
            nanoTime = AbsPerformance.LONG_NIL;
        }
        this.idleStartTimeNs = nanoTime;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writePing(boolean z, int i, int i2, Ping ping) throws IOException {
        synchronized (this.frameWriter) {
            if (ping != null) {
                ping.send();
            }
            this.frameWriter.ping(z, i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writePingLater(final boolean z, final int i, final int i2, final Ping ping) {
        executor.execute(new NamedRunnable("OkHttp %s ping %08x%08x", new Object[]{this.hostName, Integer.valueOf(i), Integer.valueOf(i2)}) { // from class: com.squareup.okhttp.internal.spdy.SpdyConnection.3
            @Override // com.squareup.okhttp.internal.NamedRunnable
            public void execute() {
                try {
                    SpdyConnection.this.writePing(z, i, i2, ping);
                } catch (IOException unused) {
                }
            }
        });
    }

    void addBytesToWriteWindow(long j) {
        this.bytesLeftInWriteWindow += j;
        if (j > 0) {
            notifyAll();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        close(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
    }

    public void flush() throws IOException {
        this.frameWriter.flush();
    }

    public synchronized long getIdleStartTimeNs() {
        return this.idleStartTimeNs;
    }

    public Protocol getProtocol() {
        return this.protocol;
    }

    synchronized SpdyStream getStream(int i) {
        return this.streams.get(Integer.valueOf(i));
    }

    public synchronized boolean isIdle() {
        return this.idleStartTimeNs != AbsPerformance.LONG_NIL;
    }

    public SpdyStream newStream(List<Header> list, boolean z, boolean z2) throws IOException {
        return newStream(0, list, z, z2);
    }

    public synchronized int openStreamCount() {
        return this.streams.size();
    }

    public Ping ping() throws IOException {
        int i;
        Ping ping = new Ping();
        synchronized (this) {
            if (!this.shutdown) {
                i = this.nextPingId;
                this.nextPingId = i + 2;
                if (this.pings == null) {
                    this.pings = new HashMap();
                }
                this.pings.put(Integer.valueOf(i), ping);
            } else {
                throw new IOException("shutdown");
            }
        }
        writePing(false, i, 1330343787, ping);
        return ping;
    }

    public SpdyStream pushStream(int i, List<Header> list, boolean z) throws IOException {
        if (!this.client) {
            if (this.protocol == Protocol.HTTP_2) {
                return newStream(i, list, z, false);
            }
            throw new IllegalStateException("protocol != HTTP_2");
        }
        throw new IllegalStateException("Client cannot push requests.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized SpdyStream removeStream(int i) {
        SpdyStream remove;
        remove = this.streams.remove(Integer.valueOf(i));
        if (remove != null && this.streams.isEmpty()) {
            setIdle(true);
        }
        return remove;
    }

    public void sendConnectionPreface() throws IOException {
        this.frameWriter.connectionPreface();
        this.frameWriter.settings(this.okHttpSettings);
        int initialWindowSize = this.okHttpSettings.getInitialWindowSize(65536);
        if (initialWindowSize != 65536) {
            this.frameWriter.windowUpdate(0, initialWindowSize - 65536);
        }
    }

    public void shutdown(ErrorCode errorCode) throws IOException {
        synchronized (this.frameWriter) {
            synchronized (this) {
                if (this.shutdown) {
                    return;
                }
                this.shutdown = true;
                this.frameWriter.goAway(this.lastGoodStreamId, errorCode, Util.EMPTY_BYTE_ARRAY);
            }
        }
    }

    public void writeData(int i, boolean z, Buffer buffer, long j) throws IOException {
        long j2;
        int min;
        long j3;
        if (j == 0) {
            this.frameWriter.data(z, i, buffer, 0);
            return;
        }
        while (j > 0) {
            synchronized (this) {
                while (true) {
                    try {
                        j2 = this.bytesLeftInWriteWindow;
                        if (j2 > 0) {
                            break;
                        }
                        wait();
                    } catch (InterruptedException unused) {
                        throw new InterruptedIOException();
                    }
                }
                min = Math.min((int) Math.min(j, j2), this.frameWriter.maxDataLength());
                j3 = min;
                this.bytesLeftInWriteWindow -= j3;
            }
            j -= j3;
            this.frameWriter.data(z && j == 0, i, buffer, min);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeSynReply(int i, boolean z, List<Header> list) throws IOException {
        this.frameWriter.synReply(z, i, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeSynReset(int i, ErrorCode errorCode) throws IOException {
        this.frameWriter.rstStream(i, errorCode);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeSynResetLater(final int i, final ErrorCode errorCode) {
        executor.submit(new NamedRunnable("OkHttp %s stream %d", new Object[]{this.hostName, Integer.valueOf(i)}) { // from class: com.squareup.okhttp.internal.spdy.SpdyConnection.1
            @Override // com.squareup.okhttp.internal.NamedRunnable
            public void execute() {
                try {
                    SpdyConnection.this.writeSynReset(i, errorCode);
                } catch (IOException unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeWindowUpdateLater(final int i, final long j) {
        executor.execute(new NamedRunnable("OkHttp Window Update %s stream %d", new Object[]{this.hostName, Integer.valueOf(i)}) { // from class: com.squareup.okhttp.internal.spdy.SpdyConnection.2
            @Override // com.squareup.okhttp.internal.NamedRunnable
            public void execute() {
                try {
                    SpdyConnection.this.frameWriter.windowUpdate(i, j);
                } catch (IOException unused) {
                }
            }
        });
    }

    private SpdyConnection(Builder builder) throws IOException {
        this.streams = new HashMap();
        this.idleStartTimeNs = System.nanoTime();
        this.unacknowledgedBytesRead = 0L;
        Settings settings = new Settings();
        this.okHttpSettings = settings;
        Settings settings2 = new Settings();
        this.peerSettings = settings2;
        this.receivedInitialPeerSettings = false;
        this.currentPushRequests = new LinkedHashSet();
        Protocol protocol = builder.protocol;
        this.protocol = protocol;
        this.pushObserver = builder.pushObserver;
        boolean z = builder.client;
        this.client = z;
        this.handler = builder.handler;
        this.nextStreamId = builder.client ? 1 : 2;
        if (builder.client && protocol == Protocol.HTTP_2) {
            this.nextStreamId += 2;
        }
        this.nextPingId = builder.client ? 1 : 2;
        if (builder.client) {
            settings.set(7, 0, 16777216);
        }
        String str = builder.hostName;
        this.hostName = str;
        if (protocol == Protocol.HTTP_2) {
            this.variant = new Http2();
            this.pushExecutor = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory(String.format("OkHttp %s Push Observer", str), true));
            settings2.set(7, 0, 65535);
            settings2.set(5, 0, 16384);
        } else if (protocol == Protocol.SPDY_3) {
            this.variant = new Spdy3();
            this.pushExecutor = null;
        } else {
            throw new AssertionError(protocol);
        }
        this.bytesLeftInWriteWindow = settings2.getInitialWindowSize(65536);
        this.socket = builder.socket;
        this.frameWriter = this.variant.newWriter(h.c(h.i(builder.socket)), z);
        Reader reader = new Reader();
        this.readerRunnable = reader;
        new Thread(reader).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void close(ErrorCode errorCode, ErrorCode errorCode2) throws IOException {
        int i;
        SpdyStream[] spdyStreamArr;
        Ping[] pingArr = null;
        try {
            shutdown(errorCode);
            e = null;
        } catch (IOException e) {
            e = e;
        }
        synchronized (this) {
            if (this.streams.isEmpty()) {
                spdyStreamArr = null;
            } else {
                spdyStreamArr = (SpdyStream[]) this.streams.values().toArray(new SpdyStream[this.streams.size()]);
                this.streams.clear();
                setIdle(false);
            }
            Map<Integer, Ping> map = this.pings;
            if (map != null) {
                this.pings = null;
                pingArr = (Ping[]) map.values().toArray(new Ping[this.pings.size()]);
            }
        }
        if (spdyStreamArr != null) {
            for (SpdyStream spdyStream : spdyStreamArr) {
                try {
                    spdyStream.close(errorCode2);
                } catch (IOException e2) {
                    if (e != null) {
                        e = e2;
                    }
                }
            }
        }
        if (pingArr != null) {
            for (Ping ping : pingArr) {
                ping.cancel();
            }
        }
        try {
            this.frameWriter.close();
        } catch (IOException e3) {
            if (e == null) {
                e = e3;
            }
        }
        try {
            this.socket.close();
        } catch (IOException e4) {
            e = e4;
        }
        if (e != null) {
            throw e;
        }
    }

    private SpdyStream newStream(int i, List<Header> list, boolean z, boolean z2) throws IOException {
        int i2;
        SpdyStream spdyStream;
        boolean z3 = !z;
        boolean z4 = !z2;
        synchronized (this.frameWriter) {
            synchronized (this) {
                if (!this.shutdown) {
                    i2 = this.nextStreamId;
                    this.nextStreamId = i2 + 2;
                    spdyStream = new SpdyStream(i2, this, z3, z4, list);
                    if (spdyStream.isOpen()) {
                        this.streams.put(Integer.valueOf(i2), spdyStream);
                        setIdle(false);
                    }
                } else {
                    throw new IOException("shutdown");
                }
            }
            if (i == 0) {
                this.frameWriter.synStream(z3, z4, i2, i, list);
            } else if (!this.client) {
                this.frameWriter.pushPromise(i, i2, list);
            } else {
                throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
            }
        }
        if (!z) {
            this.frameWriter.flush();
        }
        return spdyStream;
    }
}
