package com.squareup.okhttp.internal.ws;

import com.alimm.xadsdk.request.builder.IRequestConst;
import com.squareup.okhttp.ws.WebSocket;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.C8844h;
import okio.C8857o;
import okio.Sink;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class WebSocketWriter {
    private boolean activeWriter;
    private boolean closed;
    private final FrameSink frameSink = new FrameSink(this, null);
    private final boolean isClient;
    private final byte[] maskBuffer;
    private final byte[] maskKey;
    private final Random random;
    private final BufferedSink sink;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.squareup.okhttp.internal.ws.WebSocketWriter$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$squareup$okhttp$ws$WebSocket$PayloadType;

        static {
            int[] iArr = new int[WebSocket.PayloadType.values().length];
            $SwitchMap$com$squareup$okhttp$ws$WebSocket$PayloadType = iArr;
            try {
                iArr[WebSocket.PayloadType.TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$squareup$okhttp$ws$WebSocket$PayloadType[WebSocket.PayloadType.BINARY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    private final class FrameSink implements Sink {
        private boolean isFirstFrame;
        private WebSocket.PayloadType payloadType;

        private FrameSink() {
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!WebSocketWriter.this.closed) {
                synchronized (WebSocketWriter.this.sink) {
                    WebSocketWriter.this.sink.writeByte(128);
                    if (WebSocketWriter.this.isClient) {
                        WebSocketWriter.this.sink.writeByte(128);
                        WebSocketWriter.this.random.nextBytes(WebSocketWriter.this.maskKey);
                        WebSocketWriter.this.sink.write(WebSocketWriter.this.maskKey);
                    } else {
                        WebSocketWriter.this.sink.writeByte(0);
                    }
                    WebSocketWriter.this.sink.flush();
                }
                WebSocketWriter.this.activeWriter = false;
                return;
            }
            throw new IOException(IRequestConst.CLOSED);
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            if (!WebSocketWriter.this.closed) {
                synchronized (WebSocketWriter.this.sink) {
                    WebSocketWriter.this.sink.flush();
                }
                return;
            }
            throw new IOException(IRequestConst.CLOSED);
        }

        @Override // okio.Sink
        public C8857o timeout() {
            return WebSocketWriter.this.sink.timeout();
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            WebSocketWriter.this.writeFrame(this.payloadType, buffer, j, this.isFirstFrame, false);
            this.isFirstFrame = false;
        }

        /* synthetic */ FrameSink(WebSocketWriter webSocketWriter, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public WebSocketWriter(boolean z, BufferedSink bufferedSink, Random random) {
        Objects.requireNonNull(bufferedSink, "sink == null");
        Objects.requireNonNull(random, "random == null");
        this.isClient = z;
        this.sink = bufferedSink;
        this.random = random;
        this.maskKey = z ? new byte[4] : null;
        this.maskBuffer = z ? new byte[2048] : null;
    }

    private void writeAllMasked(BufferedSource bufferedSource, long j) throws IOException {
        long j2 = 0;
        while (j2 < j) {
            int read = bufferedSource.read(this.maskBuffer, 0, (int) Math.min(j, this.maskBuffer.length));
            if (read != -1) {
                long j3 = read;
                WebSocketProtocol.toggleMask(this.maskBuffer, j3, this.maskKey, j2);
                this.sink.write(this.maskBuffer, 0, read);
                j2 += j3;
            } else {
                throw new AssertionError();
            }
        }
    }

    private void writeControlFrame(int i, Buffer buffer) throws IOException {
        if (this.closed) {
            throw new IOException(IRequestConst.CLOSED);
        }
        int i2 = 0;
        if (buffer != null && (i2 = (int) buffer.size()) > 125) {
            throw new IllegalArgumentException("Payload size must be less than or equal to 125");
        }
        this.sink.writeByte(i | 128);
        if (this.isClient) {
            this.sink.writeByte(i2 | 128);
            this.random.nextBytes(this.maskKey);
            this.sink.write(this.maskKey);
            if (buffer != null) {
                writeAllMasked(buffer, i2);
            }
        } else {
            this.sink.writeByte(i2);
            if (buffer != null) {
                this.sink.writeAll(buffer);
            }
        }
        this.sink.flush();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writeFrame(WebSocket.PayloadType payloadType, Buffer buffer, long j, boolean z, boolean z2) throws IOException {
        if (!this.closed) {
            int i = 2;
            int i2 = 0;
            if (z) {
                int i3 = AnonymousClass1.$SwitchMap$com$squareup$okhttp$ws$WebSocket$PayloadType[payloadType.ordinal()];
                if (i3 == 1) {
                    i = 1;
                } else if (i3 != 2) {
                    throw new IllegalStateException("Unknown payload type: " + payloadType);
                }
            } else {
                i = 0;
            }
            synchronized (this.sink) {
                if (z2) {
                    i |= 128;
                }
                this.sink.writeByte(i);
                if (this.isClient) {
                    this.random.nextBytes(this.maskKey);
                    i2 = 128;
                }
                if (j <= 125) {
                    this.sink.writeByte(((int) j) | i2);
                } else if (j <= 65535) {
                    this.sink.writeByte(i2 | 126);
                    this.sink.writeShort((int) j);
                } else {
                    this.sink.writeByte(i2 | 127);
                    this.sink.writeLong(j);
                }
                if (this.isClient) {
                    this.sink.write(this.maskKey);
                    writeAllMasked(buffer, j);
                } else {
                    this.sink.write(buffer, j);
                }
                this.sink.flush();
            }
            return;
        }
        throw new IOException(IRequestConst.CLOSED);
    }

    public BufferedSink newMessageSink(WebSocket.PayloadType payloadType) {
        Objects.requireNonNull(payloadType, "type == null");
        if (!this.activeWriter) {
            this.activeWriter = true;
            this.frameSink.payloadType = payloadType;
            this.frameSink.isFirstFrame = true;
            return C8844h.c(this.frameSink);
        }
        throw new IllegalStateException("Another message writer is active. Did you call close()?");
    }

    public void sendMessage(WebSocket.PayloadType payloadType, Buffer buffer) throws IOException {
        Objects.requireNonNull(payloadType, "type == null");
        Objects.requireNonNull(buffer, "payload == null");
        if (!this.activeWriter) {
            writeFrame(payloadType, buffer, buffer.size(), true, true);
            return;
        }
        throw new IllegalStateException("A message writer is active. Did you call close()?");
    }

    public void writeClose(int i, String str) throws IOException {
        Buffer buffer;
        if (i != 0) {
            if (i >= 1000 && i < 5000) {
                buffer = new Buffer();
                buffer.writeShort(i);
                if (str != null) {
                    buffer.writeUtf8(str);
                }
            } else {
                throw new IllegalArgumentException("Code must be in range [1000,5000).");
            }
        } else if (str != null) {
            throw new IllegalArgumentException("Code required to include reason.");
        } else {
            buffer = null;
        }
        synchronized (this.sink) {
            writeControlFrame(8, buffer);
            this.closed = true;
        }
    }

    public void writePing(Buffer buffer) throws IOException {
        synchronized (this.sink) {
            writeControlFrame(9, buffer);
        }
    }

    public void writePong(Buffer buffer) throws IOException {
        synchronized (this.sink) {
            writeControlFrame(10, buffer);
        }
    }
}
