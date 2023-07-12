package com.google.protobuf;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;

/* compiled from: Taobao */
/* renamed from: com.google.protobuf.c */
/* loaded from: classes10.dex */
final class C5397c {
    private static final ThreadLocal<SoftReference<byte[]>> a = new ThreadLocal<>();

    private static byte[] a() {
        SoftReference<byte[]> softReference = a.get();
        if (softReference == null) {
            return null;
        }
        return softReference.get();
    }

    private static byte[] b(int i) {
        int max = Math.max(i, 1024);
        byte[] a2 = a();
        if (a2 == null || c(max, a2.length)) {
            a2 = new byte[max];
            if (max <= 16384) {
                d(a2);
            }
        }
        return a2;
    }

    private static boolean c(int i, int i2) {
        return i2 < i && ((float) i2) < ((float) i) * 0.5f;
    }

    private static void d(byte[] bArr) {
        a.set(new SoftReference<>(bArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(ByteBuffer byteBuffer, OutputStream outputStream) throws IOException {
        int position = byteBuffer.position();
        try {
            if (byteBuffer.hasArray()) {
                outputStream.write(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            } else if (outputStream instanceof FileOutputStream) {
                ((FileOutputStream) outputStream).getChannel().write(byteBuffer);
            } else {
                byte[] b = b(byteBuffer.remaining());
                while (byteBuffer.hasRemaining()) {
                    int min = Math.min(byteBuffer.remaining(), b.length);
                    byteBuffer.get(b, 0, min);
                    outputStream.write(b, 0, min);
                }
            }
        } finally {
            byteBuffer.position(position);
        }
    }
}
