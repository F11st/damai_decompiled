package com.alipay.android.phone.mobilesdk.socketcraft;

import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLSession;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class SSLSocketChannel2 implements WrappedByteChannel, ByteChannel {
    protected static ByteBuffer k = ByteBuffer.allocate(0);
    protected ExecutorService a;
    protected List<Future<?>> b;
    protected ByteBuffer c;
    protected ByteBuffer d;
    protected ByteBuffer e;
    protected SocketChannel f;
    protected SSLEngine g;
    protected SSLEngineResult h;
    protected SSLEngineResult i;
    protected int j = 0;

    public SSLSocketChannel2(SocketChannel socketChannel, SSLEngine sSLEngine, ExecutorService executorService, SelectionKey selectionKey) {
        if (socketChannel != null && sSLEngine != null && executorService != null) {
            this.f = socketChannel;
            this.g = sSLEngine;
            this.a = executorService;
            SSLEngineResult sSLEngineResult = new SSLEngineResult(SSLEngineResult.Status.BUFFER_UNDERFLOW, sSLEngine.getHandshakeStatus(), 0, 0);
            this.i = sSLEngineResult;
            this.h = sSLEngineResult;
            this.b = new ArrayList(3);
            if (selectionKey != null) {
                selectionKey.interestOps(selectionKey.interestOps() | 4);
            }
            c(sSLEngine.getSession());
            this.f.write(k(k));
            f();
            return;
        }
        throw new IllegalArgumentException("parameter must not be null");
    }

    private void b(Future<?> future) {
        boolean z = false;
        while (true) {
            try {
                try {
                    future.get();
                    break;
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                }
            } catch (InterruptedException unused) {
                z = true;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    private boolean e() {
        SSLEngineResult.HandshakeStatus handshakeStatus = this.g.getHandshakeStatus();
        return handshakeStatus == SSLEngineResult.HandshakeStatus.FINISHED || handshakeStatus == SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
    }

    private synchronized void f() {
        if (this.g.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING) {
            return;
        }
        if (!this.b.isEmpty()) {
            Iterator<Future<?>> it = this.b.iterator();
            while (it.hasNext()) {
                Future<?> next = it.next();
                if (next.isDone()) {
                    it.remove();
                } else {
                    if (isBlocking()) {
                        b(next);
                    }
                    return;
                }
            }
        }
        if (this.g.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NEED_UNWRAP) {
            if (!isBlocking() || this.h.getStatus() == SSLEngineResult.Status.BUFFER_UNDERFLOW) {
                this.e.compact();
                if (this.f.read(this.e) != -1) {
                    this.e.flip();
                } else {
                    throw new IOException("connection closed unexpectedly by peer");
                }
            }
            this.c.compact();
            j();
            if (this.h.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.FINISHED) {
                c(this.g.getSession());
                return;
            }
        }
        a();
        if (this.b.isEmpty() || this.g.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NEED_WRAP) {
            this.f.write(k(k));
            if (this.i.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.FINISHED) {
                c(this.g.getSession());
                return;
            }
        }
        this.j = 1;
    }

    private int g(ByteBuffer byteBuffer) {
        if (this.c.hasRemaining()) {
            return h(this.c, byteBuffer);
        }
        if (!this.c.hasRemaining()) {
            this.c.clear();
        }
        if (this.e.hasRemaining()) {
            j();
            int h = h(this.c, byteBuffer);
            if (this.h.getStatus() == SSLEngineResult.Status.CLOSED) {
                return -1;
            }
            if (h > 0) {
                return h;
            }
            return 0;
        }
        return 0;
    }

    private int h(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        int remaining = byteBuffer.remaining();
        int remaining2 = byteBuffer2.remaining();
        if (remaining > remaining2) {
            int min = Math.min(remaining, remaining2);
            for (int i = 0; i < min; i++) {
                byteBuffer2.put(byteBuffer.get());
            }
            return min;
        }
        byteBuffer2.put(byteBuffer);
        return remaining;
    }

    private synchronized ByteBuffer j() {
        while (true) {
            int remaining = this.c.remaining();
            SSLEngineResult unwrap = this.g.unwrap(this.e, this.c);
            this.h = unwrap;
            if (unwrap.getStatus() != SSLEngineResult.Status.OK || (remaining == this.c.remaining() && this.g.getHandshakeStatus() != SSLEngineResult.HandshakeStatus.NEED_UNWRAP)) {
                break;
            }
        }
        this.c.flip();
        return this.c;
    }

    private synchronized ByteBuffer k(ByteBuffer byteBuffer) {
        this.d.compact();
        this.i = this.g.wrap(byteBuffer, this.d);
        this.d.flip();
        return this.d;
    }

    protected void a() {
        while (true) {
            Runnable delegatedTask = this.g.getDelegatedTask();
            if (delegatedTask == null) {
                return;
            }
            this.b.add(this.a.submit(delegatedTask));
        }
    }

    protected void c(SSLSession sSLSession) {
        int packetBufferSize = sSLSession.getPacketBufferSize();
        int max = Math.max(sSLSession.getApplicationBufferSize(), packetBufferSize);
        ByteBuffer byteBuffer = this.c;
        if (byteBuffer == null) {
            this.c = ByteBuffer.allocate(max);
            this.d = ByteBuffer.allocate(packetBufferSize);
            this.e = ByteBuffer.allocate(packetBufferSize);
        } else {
            if (byteBuffer.capacity() != max) {
                this.c = ByteBuffer.allocate(max);
            }
            if (this.d.capacity() != packetBufferSize) {
                this.d = ByteBuffer.allocate(packetBufferSize);
            }
            if (this.e.capacity() != packetBufferSize) {
                this.e = ByteBuffer.allocate(packetBufferSize);
            }
        }
        this.c.rewind();
        this.c.flip();
        this.e.rewind();
        this.e.flip();
        this.d.rewind();
        this.d.flip();
        this.j++;
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.g.closeOutbound();
        this.g.getSession().invalidate();
        if (this.f.isOpen()) {
            this.f.write(k(k));
        }
        this.f.close();
        this.a.shutdownNow();
    }

    public SelectableChannel configureBlocking(boolean z) {
        return this.f.configureBlocking(z);
    }

    public boolean connect(SocketAddress socketAddress) {
        return this.f.connect(socketAddress);
    }

    public boolean finishConnect() {
        return this.f.finishConnect();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WrappedByteChannel
    public boolean isBlocking() {
        return this.f.isBlocking();
    }

    public boolean isConnected() {
        return this.f.isConnected();
    }

    public boolean isInboundDone() {
        return this.g.isInboundDone();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WrappedByteChannel
    public boolean isNeedRead() {
        if (this.c.hasRemaining()) {
            return true;
        }
        return (!this.e.hasRemaining() || this.h.getStatus() == SSLEngineResult.Status.BUFFER_UNDERFLOW || this.h.getStatus() == SSLEngineResult.Status.CLOSED) ? false : true;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WrappedByteChannel
    public boolean isNeedWrite() {
        return this.d.hasRemaining() || !e();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return this.f.isOpen();
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            if (!e()) {
                if (isBlocking()) {
                    while (!e()) {
                        f();
                    }
                } else {
                    f();
                    if (!e()) {
                        return 0;
                    }
                }
            }
            int g = g(byteBuffer);
            if (g != 0) {
                return g;
            }
            this.c.clear();
            if (!this.e.hasRemaining()) {
                this.e.clear();
            } else {
                this.e.compact();
            }
            if ((isBlocking() || this.h.getStatus() == SSLEngineResult.Status.BUFFER_UNDERFLOW) && this.f.read(this.e) == -1) {
                return -1;
            }
            this.e.flip();
            j();
            int h = h(this.c, byteBuffer);
            return (h == 0 && isBlocking()) ? read(byteBuffer) : h;
        }
        return 0;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WrappedByteChannel
    public int readMore(ByteBuffer byteBuffer) {
        return g(byteBuffer);
    }

    public Socket socket() {
        return this.f.socket();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        if (!e()) {
            f();
            return 0;
        }
        int write = this.f.write(k(byteBuffer));
        if (this.i.getStatus() != SSLEngineResult.Status.CLOSED) {
            return write;
        }
        throw new EOFException("Connection is closed");
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WrappedByteChannel
    public void writeMore() {
        write(this.d);
    }
}
