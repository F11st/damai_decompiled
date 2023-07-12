package com.alipay.android.phone.mobilesdk.socketcraft;

import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SocketChannel;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class AbstractWrappedByteChannel implements WrappedByteChannel {
    private final ByteChannel a;

    public AbstractWrappedByteChannel(ByteChannel byteChannel) {
        this.a = byteChannel;
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.a.close();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WrappedByteChannel
    public boolean isBlocking() {
        ByteChannel byteChannel = this.a;
        if (byteChannel instanceof SocketChannel) {
            return ((SocketChannel) byteChannel).isBlocking();
        }
        if (byteChannel instanceof WrappedByteChannel) {
            return ((WrappedByteChannel) byteChannel).isBlocking();
        }
        return false;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WrappedByteChannel
    public boolean isNeedRead() {
        ByteChannel byteChannel = this.a;
        if (byteChannel instanceof WrappedByteChannel) {
            return ((WrappedByteChannel) byteChannel).isNeedRead();
        }
        return false;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WrappedByteChannel
    public boolean isNeedWrite() {
        ByteChannel byteChannel = this.a;
        if (byteChannel instanceof WrappedByteChannel) {
            return ((WrappedByteChannel) byteChannel).isNeedWrite();
        }
        return false;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return this.a.isOpen();
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        return this.a.read(byteBuffer);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WrappedByteChannel
    public int readMore(ByteBuffer byteBuffer) {
        ByteChannel byteChannel = this.a;
        if (byteChannel instanceof WrappedByteChannel) {
            return ((WrappedByteChannel) byteChannel).readMore(byteBuffer);
        }
        return 0;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        return this.a.write(byteBuffer);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WrappedByteChannel
    public void writeMore() {
        ByteChannel byteChannel = this.a;
        if (byteChannel instanceof WrappedByteChannel) {
            ((WrappedByteChannel) byteChannel).writeMore();
        }
    }

    public AbstractWrappedByteChannel(WrappedByteChannel wrappedByteChannel) {
        this.a = wrappedByteChannel;
    }
}
