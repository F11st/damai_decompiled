package com.alibaba.gaiax.studio.third.socket.java_websocket;

import androidx.annotation.Keep;
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
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

/* compiled from: Taobao */
@Keep
/* loaded from: classes6.dex */
public class SSLSocketChannel2 implements WrappedByteChannel, ByteChannel {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    protected static ByteBuffer emptybuffer = ByteBuffer.allocate(0);
    protected int bufferallocations = 0;
    protected ExecutorService exec;
    protected ByteBuffer inCrypt;
    protected ByteBuffer inData;
    protected ByteBuffer outCrypt;
    protected SSLEngineResult readEngineResult;
    protected SelectionKey selectionKey;
    protected SocketChannel socketChannel;
    protected SSLEngine sslEngine;
    protected List<Future<?>> tasks;
    protected SSLEngineResult writeEngineResult;

    public SSLSocketChannel2(SocketChannel socketChannel, SSLEngine sSLEngine, ExecutorService executorService, SelectionKey selectionKey) throws IOException {
        if (socketChannel != null && sSLEngine != null && executorService != null) {
            this.socketChannel = socketChannel;
            this.sslEngine = sSLEngine;
            this.exec = executorService;
            SSLEngineResult sSLEngineResult = new SSLEngineResult(SSLEngineResult.Status.BUFFER_UNDERFLOW, sSLEngine.getHandshakeStatus(), 0, 0);
            this.writeEngineResult = sSLEngineResult;
            this.readEngineResult = sSLEngineResult;
            this.tasks = new ArrayList(3);
            if (selectionKey != null) {
                selectionKey.interestOps(selectionKey.interestOps() | 4);
                this.selectionKey = selectionKey;
            }
            createBuffers(sSLEngine.getSession());
            this.socketChannel.write(wrap(emptybuffer));
            processHandshake();
            return;
        }
        throw new IllegalArgumentException("parameter must not be null");
    }

    private void consumeFutureUninterruptible(Future<?> future) {
        while (true) {
            try {
                try {
                    future.get();
                    return;
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private boolean isHandShakeComplete() {
        SSLEngineResult.HandshakeStatus handshakeStatus = this.sslEngine.getHandshakeStatus();
        return handshakeStatus == SSLEngineResult.HandshakeStatus.FINISHED || handshakeStatus == SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
    }

    private synchronized void processHandshake() throws IOException {
        if (this.sslEngine.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING) {
            return;
        }
        if (!this.tasks.isEmpty()) {
            Iterator<Future<?>> it = this.tasks.iterator();
            while (it.hasNext()) {
                Future<?> next = it.next();
                if (next.isDone()) {
                    it.remove();
                } else {
                    if (isBlocking()) {
                        consumeFutureUninterruptible(next);
                    }
                    return;
                }
            }
        }
        if (this.sslEngine.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NEED_UNWRAP) {
            if (!isBlocking() || this.readEngineResult.getStatus() == SSLEngineResult.Status.BUFFER_UNDERFLOW) {
                this.inCrypt.compact();
                if (this.socketChannel.read(this.inCrypt) != -1) {
                    this.inCrypt.flip();
                } else {
                    throw new IOException("connection closed unexpectedly by peer");
                }
            }
            this.inData.compact();
            unwrap();
            if (this.readEngineResult.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.FINISHED) {
                createBuffers(this.sslEngine.getSession());
                return;
            }
        }
        consumeDelegatedTasks();
        if (this.tasks.isEmpty() || this.sslEngine.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NEED_WRAP) {
            this.socketChannel.write(wrap(emptybuffer));
            if (this.writeEngineResult.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.FINISHED) {
                createBuffers(this.sslEngine.getSession());
                return;
            }
        }
        this.bufferallocations = 1;
    }

    private int readRemaining(ByteBuffer byteBuffer) throws SSLException {
        if (this.inData.hasRemaining()) {
            return transfereTo(this.inData, byteBuffer);
        }
        if (!this.inData.hasRemaining()) {
            this.inData.clear();
        }
        if (this.inCrypt.hasRemaining()) {
            unwrap();
            int transfereTo = transfereTo(this.inData, byteBuffer);
            if (this.readEngineResult.getStatus() == SSLEngineResult.Status.CLOSED) {
                return -1;
            }
            if (transfereTo > 0) {
                return transfereTo;
            }
            return 0;
        }
        return 0;
    }

    private int transfereTo(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
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

    private synchronized ByteBuffer unwrap() throws SSLException {
        if (this.readEngineResult.getStatus() == SSLEngineResult.Status.CLOSED && this.sslEngine.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING) {
            try {
                close();
            } catch (IOException unused) {
            }
        }
        while (true) {
            int remaining = this.inData.remaining();
            SSLEngineResult unwrap = this.sslEngine.unwrap(this.inCrypt, this.inData);
            this.readEngineResult = unwrap;
            if (unwrap.getStatus() != SSLEngineResult.Status.OK || (remaining == this.inData.remaining() && this.sslEngine.getHandshakeStatus() != SSLEngineResult.HandshakeStatus.NEED_UNWRAP)) {
                break;
            }
        }
        this.inData.flip();
        return this.inData;
    }

    private synchronized ByteBuffer wrap(ByteBuffer byteBuffer) throws SSLException {
        this.outCrypt.compact();
        this.writeEngineResult = this.sslEngine.wrap(byteBuffer, this.outCrypt);
        this.outCrypt.flip();
        return this.outCrypt;
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.sslEngine.closeOutbound();
        this.sslEngine.getSession().invalidate();
        if (this.socketChannel.isOpen()) {
            this.socketChannel.write(wrap(emptybuffer));
        }
        this.socketChannel.close();
    }

    public SelectableChannel configureBlocking(boolean z) throws IOException {
        return this.socketChannel.configureBlocking(z);
    }

    public boolean connect(SocketAddress socketAddress) throws IOException {
        return this.socketChannel.connect(socketAddress);
    }

    protected void consumeDelegatedTasks() {
        while (true) {
            Runnable delegatedTask = this.sslEngine.getDelegatedTask();
            if (delegatedTask == null) {
                return;
            }
            this.tasks.add(this.exec.submit(delegatedTask));
        }
    }

    protected void createBuffers(SSLSession sSLSession) {
        int packetBufferSize = sSLSession.getPacketBufferSize();
        int max = Math.max(sSLSession.getApplicationBufferSize(), packetBufferSize);
        ByteBuffer byteBuffer = this.inData;
        if (byteBuffer == null) {
            this.inData = ByteBuffer.allocate(max);
            this.outCrypt = ByteBuffer.allocate(packetBufferSize);
            this.inCrypt = ByteBuffer.allocate(packetBufferSize);
        } else {
            if (byteBuffer.capacity() != max) {
                this.inData = ByteBuffer.allocate(max);
            }
            if (this.outCrypt.capacity() != packetBufferSize) {
                this.outCrypt = ByteBuffer.allocate(packetBufferSize);
            }
            if (this.inCrypt.capacity() != packetBufferSize) {
                this.inCrypt = ByteBuffer.allocate(packetBufferSize);
            }
        }
        this.inData.rewind();
        this.inData.flip();
        this.inCrypt.rewind();
        this.inCrypt.flip();
        this.outCrypt.rewind();
        this.outCrypt.flip();
        this.bufferallocations++;
    }

    public boolean finishConnect() throws IOException {
        return this.socketChannel.finishConnect();
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WrappedByteChannel
    public boolean isBlocking() {
        return this.socketChannel.isBlocking();
    }

    public boolean isConnected() {
        return this.socketChannel.isConnected();
    }

    public boolean isInboundDone() {
        return this.sslEngine.isInboundDone();
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WrappedByteChannel
    public boolean isNeedRead() {
        return this.inData.hasRemaining() || !(!this.inCrypt.hasRemaining() || this.readEngineResult.getStatus() == SSLEngineResult.Status.BUFFER_UNDERFLOW || this.readEngineResult.getStatus() == SSLEngineResult.Status.CLOSED);
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WrappedByteChannel
    public boolean isNeedWrite() {
        return this.outCrypt.hasRemaining() || !isHandShakeComplete();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return this.socketChannel.isOpen();
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0008  */
    @Override // java.nio.channels.ReadableByteChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int read(java.nio.ByteBuffer r3) throws java.io.IOException {
        /*
            r2 = this;
        L0:
            boolean r0 = r3.hasRemaining()
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            boolean r0 = r2.isHandShakeComplete()
            if (r0 != 0) goto L28
            boolean r0 = r2.isBlocking()
            if (r0 == 0) goto L1e
        L14:
            boolean r0 = r2.isHandShakeComplete()
            if (r0 != 0) goto L28
            r2.processHandshake()
            goto L14
        L1e:
            r2.processHandshake()
            boolean r0 = r2.isHandShakeComplete()
            if (r0 != 0) goto L28
            return r1
        L28:
            int r0 = r2.readRemaining(r3)
            if (r0 == 0) goto L2f
            return r0
        L2f:
            java.nio.ByteBuffer r0 = r2.inData
            r0.clear()
            java.nio.ByteBuffer r0 = r2.inCrypt
            boolean r0 = r0.hasRemaining()
            if (r0 != 0) goto L42
            java.nio.ByteBuffer r0 = r2.inCrypt
            r0.clear()
            goto L47
        L42:
            java.nio.ByteBuffer r0 = r2.inCrypt
            r0.compact()
        L47:
            boolean r0 = r2.isBlocking()
            if (r0 != 0) goto L57
            javax.net.ssl.SSLEngineResult r0 = r2.readEngineResult
            javax.net.ssl.SSLEngineResult$Status r0 = r0.getStatus()
            javax.net.ssl.SSLEngineResult$Status r1 = javax.net.ssl.SSLEngineResult.Status.BUFFER_UNDERFLOW
            if (r0 != r1) goto L63
        L57:
            java.nio.channels.SocketChannel r0 = r2.socketChannel
            java.nio.ByteBuffer r1 = r2.inCrypt
            int r0 = r0.read(r1)
            r1 = -1
            if (r0 != r1) goto L63
            return r1
        L63:
            java.nio.ByteBuffer r0 = r2.inCrypt
            r0.flip()
            r2.unwrap()
            java.nio.ByteBuffer r0 = r2.inData
            int r0 = r2.transfereTo(r0, r3)
            if (r0 != 0) goto L7a
            boolean r1 = r2.isBlocking()
            if (r1 == 0) goto L7a
            goto L0
        L7a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.gaiax.studio.third.socket.java_websocket.SSLSocketChannel2.read(java.nio.ByteBuffer):int");
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WrappedByteChannel
    public int readMore(ByteBuffer byteBuffer) throws SSLException {
        return readRemaining(byteBuffer);
    }

    public Socket socket() {
        return this.socketChannel.socket();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (!isHandShakeComplete()) {
            processHandshake();
            return 0;
        }
        int write = this.socketChannel.write(wrap(byteBuffer));
        if (this.writeEngineResult.getStatus() != SSLEngineResult.Status.CLOSED) {
            return write;
        }
        throw new EOFException("Connection is closed");
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WrappedByteChannel
    public void writeMore() throws IOException {
        write(this.outCrypt);
    }
}
