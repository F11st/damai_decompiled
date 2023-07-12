package com.squareup.okhttp.internal.ws;

import com.alimm.xadsdk.request.builder.IRequestConst;
import com.squareup.okhttp.ws.WebSocket;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.Objects;
import okio.Buffer;
import okio.BufferedSource;
import okio.Source;
import okio.h;
import okio.o;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class WebSocketReader {
    private boolean closed;
    private long frameBytesRead;
    private final FrameCallback frameCallback;
    private long frameLength;
    private final boolean isClient;
    private boolean isControlFrame;
    private boolean isFinalFrame;
    private boolean isMasked;
    private boolean messageClosed;
    private int opcode;
    private final BufferedSource source;
    private final Source framedMessageSource = new FramedMessageSource();
    private final byte[] maskKey = new byte[4];
    private final byte[] maskBuffer = new byte[2048];

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface FrameCallback {
        void onClose(int i, String str);

        void onMessage(BufferedSource bufferedSource, WebSocket.PayloadType payloadType) throws IOException;

        void onPing(Buffer buffer);

        void onPong(Buffer buffer);
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    private final class FramedMessageSource implements Source {
        private FramedMessageSource() {
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (WebSocketReader.this.messageClosed) {
                return;
            }
            WebSocketReader.this.messageClosed = true;
            if (WebSocketReader.this.closed) {
                return;
            }
            WebSocketReader.this.source.skip(WebSocketReader.this.frameLength - WebSocketReader.this.frameBytesRead);
            while (!WebSocketReader.this.isFinalFrame) {
                WebSocketReader.this.readUntilNonControlFrame();
                WebSocketReader.this.source.skip(WebSocketReader.this.frameLength);
            }
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            long read;
            if (!WebSocketReader.this.closed) {
                if (!WebSocketReader.this.messageClosed) {
                    if (WebSocketReader.this.frameBytesRead == WebSocketReader.this.frameLength) {
                        if (WebSocketReader.this.isFinalFrame) {
                            return -1L;
                        }
                        WebSocketReader.this.readUntilNonControlFrame();
                        if (WebSocketReader.this.opcode == 0) {
                            if (WebSocketReader.this.isFinalFrame && WebSocketReader.this.frameLength == 0) {
                                return -1L;
                            }
                        } else {
                            throw new ProtocolException("Expected continuation opcode. Got: " + Integer.toHexString(WebSocketReader.this.opcode));
                        }
                    }
                    long min = Math.min(j, WebSocketReader.this.frameLength - WebSocketReader.this.frameBytesRead);
                    if (WebSocketReader.this.isMasked) {
                        read = WebSocketReader.this.source.read(WebSocketReader.this.maskBuffer, 0, (int) Math.min(min, WebSocketReader.this.maskBuffer.length));
                        if (read != -1) {
                            WebSocketProtocol.toggleMask(WebSocketReader.this.maskBuffer, read, WebSocketReader.this.maskKey, WebSocketReader.this.frameBytesRead);
                            buffer.write(WebSocketReader.this.maskBuffer, 0, (int) read);
                        } else {
                            throw new EOFException();
                        }
                    } else {
                        read = WebSocketReader.this.source.read(buffer, min);
                        if (read == -1) {
                            throw new EOFException();
                        }
                    }
                    WebSocketReader.this.frameBytesRead += read;
                    return read;
                }
                throw new IllegalStateException(IRequestConst.CLOSED);
            }
            throw new IOException(IRequestConst.CLOSED);
        }

        @Override // okio.Source
        public o timeout() {
            return WebSocketReader.this.source.timeout();
        }
    }

    public WebSocketReader(boolean z, BufferedSource bufferedSource, FrameCallback frameCallback) {
        Objects.requireNonNull(bufferedSource, "source == null");
        Objects.requireNonNull(frameCallback, "frameCallback == null");
        this.isClient = z;
        this.source = bufferedSource;
        this.frameCallback = frameCallback;
    }

    private void readControlFrame() throws IOException {
        Buffer buffer;
        String str;
        short s = 0;
        if (this.frameBytesRead < this.frameLength) {
            buffer = new Buffer();
            if (!this.isClient) {
                while (true) {
                    long j = this.frameBytesRead;
                    long j2 = this.frameLength;
                    if (j >= j2) {
                        break;
                    }
                    int read = this.source.read(this.maskBuffer, 0, (int) Math.min(j2 - j, this.maskBuffer.length));
                    if (read != -1) {
                        long j3 = read;
                        WebSocketProtocol.toggleMask(this.maskBuffer, j3, this.maskKey, this.frameBytesRead);
                        buffer.write(this.maskBuffer, 0, read);
                        this.frameBytesRead += j3;
                    } else {
                        throw new EOFException();
                    }
                }
            } else {
                this.source.readFully(buffer, this.frameLength);
            }
        } else {
            buffer = null;
        }
        switch (this.opcode) {
            case 8:
                if (buffer != null) {
                    s = buffer.readShort();
                    str = buffer.readUtf8();
                } else {
                    str = "";
                }
                this.frameCallback.onClose(s, str);
                this.closed = true;
                return;
            case 9:
                this.frameCallback.onPing(buffer);
                return;
            case 10:
                this.frameCallback.onPong(buffer);
                return;
            default:
                throw new IllegalStateException("Unknown control opcode: " + Integer.toHexString(this.opcode));
        }
    }

    private void readHeader() throws IOException {
        if (!this.closed) {
            int readByte = this.source.readByte() & 255;
            this.opcode = readByte & 15;
            boolean z = (readByte & 128) != 0;
            this.isFinalFrame = z;
            boolean z2 = (readByte & 8) != 0;
            this.isControlFrame = z2;
            if (z2 && !z) {
                throw new ProtocolException("Control frames must be final.");
            }
            boolean z3 = (readByte & 64) != 0;
            boolean z4 = (readByte & 32) != 0;
            boolean z5 = (readByte & 16) != 0;
            if (!z3 && !z4 && !z5) {
                int readByte2 = this.source.readByte() & 255;
                boolean z6 = (readByte2 & 128) != 0;
                this.isMasked = z6;
                if (z6 != this.isClient) {
                    long j = readByte2 & 127;
                    this.frameLength = j;
                    if (j == 126) {
                        this.frameLength = this.source.readShort() & 65535;
                    } else if (j == 127) {
                        long readLong = this.source.readLong();
                        this.frameLength = readLong;
                        if (readLong < 0) {
                            throw new ProtocolException("Frame length 0x" + Long.toHexString(this.frameLength) + " > 0x7FFFFFFFFFFFFFFF");
                        }
                    }
                    this.frameBytesRead = 0L;
                    if (this.isControlFrame && this.frameLength > 125) {
                        throw new ProtocolException("Control frame must be less than 125B.");
                    }
                    if (this.isMasked) {
                        this.source.readFully(this.maskKey);
                        return;
                    }
                    return;
                }
                throw new ProtocolException("Client-sent frames must be masked. Server sent must not.");
            }
            throw new ProtocolException("Reserved flags are unsupported.");
        }
        throw new IOException(IRequestConst.CLOSED);
    }

    private void readMessageFrame() throws IOException {
        WebSocket.PayloadType payloadType;
        int i = this.opcode;
        if (i == 1) {
            payloadType = WebSocket.PayloadType.TEXT;
        } else if (i == 2) {
            payloadType = WebSocket.PayloadType.BINARY;
        } else {
            throw new IllegalStateException("Unknown opcode: " + Integer.toHexString(this.opcode));
        }
        this.messageClosed = false;
        this.frameCallback.onMessage(h.d(this.framedMessageSource), payloadType);
        if (!this.messageClosed) {
            throw new IllegalStateException("Listener failed to call close on message payload.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void readUntilNonControlFrame() throws IOException {
        while (!this.closed) {
            readHeader();
            if (!this.isControlFrame) {
                return;
            }
            readControlFrame();
        }
    }

    public void processNextFrame() throws IOException {
        readHeader();
        if (this.isControlFrame) {
            readControlFrame();
        } else {
            readMessageFrame();
        }
    }
}
