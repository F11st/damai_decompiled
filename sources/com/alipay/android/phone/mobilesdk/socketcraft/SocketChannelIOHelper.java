package com.alipay.android.phone.mobilesdk.socketcraft;

import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class SocketChannelIOHelper {
    /* JADX WARN: Removed duplicated region for block: B:38:0x0061 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean batch(com.alipay.android.phone.mobilesdk.socketcraft.WebSocketImpl r4, java.nio.channels.ByteChannel r5) {
        /*
            java.util.concurrent.BlockingQueue<java.nio.ByteBuffer> r0 = r4.outQueue
            java.lang.Object r0 = r0.peek()
            java.nio.ByteBuffer r0 = (java.nio.ByteBuffer) r0
            r1 = 0
            if (r0 != 0) goto L1c
            boolean r0 = r5 instanceof com.alipay.android.phone.mobilesdk.socketcraft.WrappedByteChannel
            if (r0 == 0) goto L35
            r0 = r5
            com.alipay.android.phone.mobilesdk.socketcraft.WrappedByteChannel r0 = (com.alipay.android.phone.mobilesdk.socketcraft.WrappedByteChannel) r0
            boolean r2 = r0.isNeedWrite()
            if (r2 == 0) goto L36
            r0.writeMore()
            goto L36
        L1c:
            r5.write(r0)
            int r0 = r0.remaining()
            if (r0 <= 0) goto L26
            return r1
        L26:
            java.util.concurrent.BlockingQueue<java.nio.ByteBuffer> r0 = r4.outQueue
            r0.poll()
            java.util.concurrent.BlockingQueue<java.nio.ByteBuffer> r0 = r4.outQueue
            java.lang.Object r0 = r0.peek()
            java.nio.ByteBuffer r0 = (java.nio.ByteBuffer) r0
            if (r0 != 0) goto L1c
        L35:
            r0 = 0
        L36:
            java.util.concurrent.BlockingQueue<java.nio.ByteBuffer> r2 = r4.outQueue
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L69
            boolean r2 = r4.isFlushAndClose()
            if (r2 == 0) goto L69
            com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft r2 = r4.getDraft()
            if (r2 == 0) goto L69
            com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft r2 = r4.getDraft()
            com.alipay.android.phone.mobilesdk.socketcraft.WebSocket$Role r2 = r2.getRole()
            if (r2 == 0) goto L69
            com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft r2 = r4.getDraft()
            com.alipay.android.phone.mobilesdk.socketcraft.WebSocket$Role r2 = r2.getRole()
            com.alipay.android.phone.mobilesdk.socketcraft.WebSocket$Role r3 = com.alipay.android.phone.mobilesdk.socketcraft.WebSocket.Role.SERVER
            if (r2 != r3) goto L69
            monitor-enter(r4)
            r4.closeConnection()     // Catch: java.lang.Throwable -> L66
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L66
            goto L69
        L66:
            r5 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L66
            throw r5
        L69:
            if (r0 == 0) goto L74
            com.alipay.android.phone.mobilesdk.socketcraft.WrappedByteChannel r5 = (com.alipay.android.phone.mobilesdk.socketcraft.WrappedByteChannel) r5
            boolean r4 = r5.isNeedWrite()
            if (r4 == 0) goto L74
            return r1
        L74:
            r4 = 1
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.android.phone.mobilesdk.socketcraft.SocketChannelIOHelper.batch(com.alipay.android.phone.mobilesdk.socketcraft.WebSocketImpl, java.nio.channels.ByteChannel):boolean");
    }

    public static boolean read(ByteBuffer byteBuffer, WebSocketImpl webSocketImpl, ByteChannel byteChannel) {
        byteBuffer.clear();
        int read = byteChannel.read(byteBuffer);
        byteBuffer.flip();
        if (read != -1) {
            return read != 0;
        }
        webSocketImpl.eot();
        return false;
    }

    public static boolean readMore(ByteBuffer byteBuffer, WebSocketImpl webSocketImpl, WrappedByteChannel wrappedByteChannel) {
        byteBuffer.clear();
        int readMore = wrappedByteChannel.readMore(byteBuffer);
        byteBuffer.flip();
        if (readMore == -1) {
            webSocketImpl.eot();
            return false;
        }
        return wrappedByteChannel.isNeedRead();
    }
}
