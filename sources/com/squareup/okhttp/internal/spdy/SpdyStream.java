package com.squareup.okhttp.internal.spdy;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.BufferedSource;
import okio.C8857o;
import okio.Sink;
import okio.Source;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class SpdyStream {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    long bytesLeftInWriteWindow;
    private final SpdyConnection connection;
    private final int id;
    private final List<Header> requestHeaders;
    private List<Header> responseHeaders;
    final SpdyDataSink sink;
    private final SpdyDataSource source;
    long unacknowledgedBytesRead = 0;
    private final SpdyTimeout readTimeout = new SpdyTimeout();
    private final SpdyTimeout writeTimeout = new SpdyTimeout();
    private ErrorCode errorCode = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public final class SpdyDataSink implements Sink {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final long EMIT_BUFFER_SIZE = 16384;
        private boolean closed;
        private boolean finished;
        private final Buffer sendBuffer = new Buffer();

        SpdyDataSink() {
        }

        private void emitDataFrame(boolean z) throws IOException {
            long min;
            SpdyStream spdyStream;
            synchronized (SpdyStream.this) {
                SpdyStream.this.writeTimeout.enter();
                while (true) {
                    SpdyStream spdyStream2 = SpdyStream.this;
                    if (spdyStream2.bytesLeftInWriteWindow > 0 || this.finished || this.closed || spdyStream2.errorCode != null) {
                        break;
                    }
                    SpdyStream.this.waitForIo();
                }
                SpdyStream.this.writeTimeout.exitAndThrowIfTimedOut();
                SpdyStream.this.checkOutNotClosed();
                min = Math.min(SpdyStream.this.bytesLeftInWriteWindow, this.sendBuffer.size());
                spdyStream = SpdyStream.this;
                spdyStream.bytesLeftInWriteWindow -= min;
            }
            spdyStream.connection.writeData(SpdyStream.this.id, z && min == this.sendBuffer.size(), this.sendBuffer, min);
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (SpdyStream.this) {
                if (this.closed) {
                    return;
                }
                if (!SpdyStream.this.sink.finished) {
                    if (this.sendBuffer.size() <= 0) {
                        SpdyStream.this.connection.writeData(SpdyStream.this.id, true, null, 0L);
                    } else {
                        while (this.sendBuffer.size() > 0) {
                            emitDataFrame(true);
                        }
                    }
                }
                synchronized (SpdyStream.this) {
                    this.closed = true;
                }
                SpdyStream.this.connection.flush();
                SpdyStream.this.cancelStreamIfNecessary();
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            synchronized (SpdyStream.this) {
                SpdyStream.this.checkOutNotClosed();
            }
            while (this.sendBuffer.size() > 0) {
                emitDataFrame(false);
            }
            SpdyStream.this.connection.flush();
        }

        @Override // okio.Sink
        public C8857o timeout() {
            return SpdyStream.this.writeTimeout;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            this.sendBuffer.write(buffer, j);
            while (this.sendBuffer.size() >= 16384) {
                emitDataFrame(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public final class SpdyDataSource implements Source {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private boolean closed;
        private boolean finished;
        private final long maxByteCount;
        private final Buffer readBuffer;
        private final Buffer receiveBuffer;

        private void checkNotClosed() throws IOException {
            if (!this.closed) {
                if (SpdyStream.this.errorCode == null) {
                    return;
                }
                throw new IOException("stream was reset: " + SpdyStream.this.errorCode);
            }
            throw new IOException("stream closed");
        }

        private void waitUntilReadable() throws IOException {
            SpdyStream.this.readTimeout.enter();
            while (this.readBuffer.size() == 0 && !this.finished && !this.closed && SpdyStream.this.errorCode == null) {
                try {
                    SpdyStream.this.waitForIo();
                } finally {
                    SpdyStream.this.readTimeout.exitAndThrowIfTimedOut();
                }
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (SpdyStream.this) {
                this.closed = true;
                this.readBuffer.clear();
                SpdyStream.this.notifyAll();
            }
            SpdyStream.this.cancelStreamIfNecessary();
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            if (j >= 0) {
                synchronized (SpdyStream.this) {
                    waitUntilReadable();
                    checkNotClosed();
                    if (this.readBuffer.size() == 0) {
                        return -1L;
                    }
                    Buffer buffer2 = this.readBuffer;
                    long read = buffer2.read(buffer, Math.min(j, buffer2.size()));
                    SpdyStream spdyStream = SpdyStream.this;
                    long j2 = spdyStream.unacknowledgedBytesRead + read;
                    spdyStream.unacknowledgedBytesRead = j2;
                    if (j2 >= spdyStream.connection.okHttpSettings.getInitialWindowSize(65536) / 2) {
                        SpdyStream.this.connection.writeWindowUpdateLater(SpdyStream.this.id, SpdyStream.this.unacknowledgedBytesRead);
                        SpdyStream.this.unacknowledgedBytesRead = 0L;
                    }
                    synchronized (SpdyStream.this.connection) {
                        SpdyStream.this.connection.unacknowledgedBytesRead += read;
                        if (SpdyStream.this.connection.unacknowledgedBytesRead >= SpdyStream.this.connection.okHttpSettings.getInitialWindowSize(65536) / 2) {
                            SpdyStream.this.connection.writeWindowUpdateLater(0, SpdyStream.this.connection.unacknowledgedBytesRead);
                            SpdyStream.this.connection.unacknowledgedBytesRead = 0L;
                        }
                    }
                    return read;
                }
            }
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }

        void receive(BufferedSource bufferedSource, long j) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            while (j > 0) {
                synchronized (SpdyStream.this) {
                    z = this.finished;
                    z2 = true;
                    z3 = this.readBuffer.size() + j > this.maxByteCount;
                }
                if (z3) {
                    bufferedSource.skip(j);
                    SpdyStream.this.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
                    return;
                } else if (z) {
                    bufferedSource.skip(j);
                    return;
                } else {
                    long read = bufferedSource.read(this.receiveBuffer, j);
                    if (read != -1) {
                        j -= read;
                        synchronized (SpdyStream.this) {
                            if (this.readBuffer.size() != 0) {
                                z2 = false;
                            }
                            this.readBuffer.writeAll(this.receiveBuffer);
                            if (z2) {
                                SpdyStream.this.notifyAll();
                            }
                        }
                    } else {
                        throw new EOFException();
                    }
                }
            }
        }

        @Override // okio.Source
        public C8857o timeout() {
            return SpdyStream.this.readTimeout;
        }

        private SpdyDataSource(long j) {
            this.receiveBuffer = new Buffer();
            this.readBuffer = new Buffer();
            this.maxByteCount = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class SpdyTimeout extends AsyncTimeout {
        SpdyTimeout() {
        }

        public void exitAndThrowIfTimedOut() throws InterruptedIOException {
            if (exit()) {
                throw new InterruptedIOException("timeout");
            }
        }

        @Override // okio.AsyncTimeout
        protected void timedOut() {
            SpdyStream.this.closeLater(ErrorCode.CANCEL);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SpdyStream(int i, SpdyConnection spdyConnection, boolean z, boolean z2, List<Header> list) {
        Objects.requireNonNull(spdyConnection, "connection == null");
        Objects.requireNonNull(list, "requestHeaders == null");
        this.id = i;
        this.connection = spdyConnection;
        this.bytesLeftInWriteWindow = spdyConnection.peerSettings.getInitialWindowSize(65536);
        SpdyDataSource spdyDataSource = new SpdyDataSource(spdyConnection.okHttpSettings.getInitialWindowSize(65536));
        this.source = spdyDataSource;
        SpdyDataSink spdyDataSink = new SpdyDataSink();
        this.sink = spdyDataSink;
        spdyDataSource.finished = z2;
        spdyDataSink.finished = z;
        this.requestHeaders = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelStreamIfNecessary() throws IOException {
        boolean z;
        boolean isOpen;
        synchronized (this) {
            z = !this.source.finished && this.source.closed && (this.sink.finished || this.sink.closed);
            isOpen = isOpen();
        }
        if (z) {
            close(ErrorCode.CANCEL);
        } else if (isOpen) {
        } else {
            this.connection.removeStream(this.id);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkOutNotClosed() throws IOException {
        if (!this.sink.closed) {
            if (!this.sink.finished) {
                if (this.errorCode == null) {
                    return;
                }
                throw new IOException("stream was reset: " + this.errorCode);
            }
            throw new IOException("stream finished");
        }
        throw new IOException("stream closed");
    }

    private boolean closeInternal(ErrorCode errorCode) {
        synchronized (this) {
            if (this.errorCode != null) {
                return false;
            }
            if (this.source.finished && this.sink.finished) {
                return false;
            }
            this.errorCode = errorCode;
            notifyAll();
            this.connection.removeStream(this.id);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void waitForIo() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            throw new InterruptedIOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addBytesToWriteWindow(long j) {
        this.bytesLeftInWriteWindow += j;
        if (j > 0) {
            notifyAll();
        }
    }

    public void close(ErrorCode errorCode) throws IOException {
        if (closeInternal(errorCode)) {
            this.connection.writeSynReset(this.id, errorCode);
        }
    }

    public void closeLater(ErrorCode errorCode) {
        if (closeInternal(errorCode)) {
            this.connection.writeSynResetLater(this.id, errorCode);
        }
    }

    public SpdyConnection getConnection() {
        return this.connection;
    }

    public synchronized ErrorCode getErrorCode() {
        return this.errorCode;
    }

    public int getId() {
        return this.id;
    }

    public List<Header> getRequestHeaders() {
        return this.requestHeaders;
    }

    public synchronized List<Header> getResponseHeaders() throws IOException {
        List<Header> list;
        this.readTimeout.enter();
        while (this.responseHeaders == null && this.errorCode == null) {
            waitForIo();
        }
        this.readTimeout.exitAndThrowIfTimedOut();
        list = this.responseHeaders;
        if (list == null) {
            throw new IOException("stream was reset: " + this.errorCode);
        }
        return list;
    }

    public Sink getSink() {
        synchronized (this) {
            if (this.responseHeaders == null && !isLocallyInitiated()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.sink;
    }

    public Source getSource() {
        return this.source;
    }

    public boolean isLocallyInitiated() {
        return this.connection.client == ((this.id & 1) == 1);
    }

    public synchronized boolean isOpen() {
        if (this.errorCode != null) {
            return false;
        }
        if ((this.source.finished || this.source.closed) && (this.sink.finished || this.sink.closed)) {
            if (this.responseHeaders != null) {
                return false;
            }
        }
        return true;
    }

    public C8857o readTimeout() {
        return this.readTimeout;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void receiveData(BufferedSource bufferedSource, int i) throws IOException {
        this.source.receive(bufferedSource, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void receiveFin() {
        boolean isOpen;
        synchronized (this) {
            this.source.finished = true;
            isOpen = isOpen();
            notifyAll();
        }
        if (isOpen) {
            return;
        }
        this.connection.removeStream(this.id);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void receiveHeaders(List<Header> list, HeadersMode headersMode) {
        ErrorCode errorCode = null;
        boolean z = true;
        synchronized (this) {
            if (this.responseHeaders == null) {
                if (headersMode.failIfHeadersAbsent()) {
                    errorCode = ErrorCode.PROTOCOL_ERROR;
                } else {
                    this.responseHeaders = list;
                    z = isOpen();
                    notifyAll();
                }
            } else if (headersMode.failIfHeadersPresent()) {
                errorCode = ErrorCode.STREAM_IN_USE;
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.responseHeaders);
                arrayList.addAll(list);
                this.responseHeaders = arrayList;
            }
        }
        if (errorCode != null) {
            closeLater(errorCode);
        } else if (z) {
        } else {
            this.connection.removeStream(this.id);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void receiveRstStream(ErrorCode errorCode) {
        if (this.errorCode == null) {
            this.errorCode = errorCode;
            notifyAll();
        }
    }

    public void reply(List<Header> list, boolean z) throws IOException {
        boolean z2 = false;
        synchronized (this) {
            try {
                if (list != null) {
                    if (this.responseHeaders == null) {
                        this.responseHeaders = list;
                        if (!z) {
                            this.sink.finished = true;
                            z2 = true;
                        }
                    } else {
                        throw new IllegalStateException("reply already sent");
                    }
                } else {
                    throw new NullPointerException("responseHeaders == null");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.connection.writeSynReply(this.id, z2, list);
        if (z2) {
            this.connection.flush();
        }
    }

    public C8857o writeTimeout() {
        return this.writeTimeout;
    }
}
