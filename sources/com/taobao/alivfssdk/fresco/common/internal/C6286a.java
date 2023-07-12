package com.taobao.alivfssdk.fresco.common.internal;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import tb.bu1;

/* compiled from: Taobao */
/* renamed from: com.taobao.alivfssdk.fresco.common.internal.a */
/* loaded from: classes8.dex */
public final class C6286a {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.alivfssdk.fresco.common.internal.a$b */
    /* loaded from: classes8.dex */
    public static class C6288b {
        private static final Object c = new Object();
        private static C6288b d;
        private static int e;
        byte[] a = new byte[4096];
        private C6288b b;

        private C6288b() {
        }

        public static C6288b a() {
            synchronized (c) {
                C6288b c6288b = d;
                if (c6288b != null) {
                    d = c6288b.b;
                    c6288b.b = null;
                    e--;
                    return c6288b;
                }
                return new C6288b();
            }
        }

        private void c() {
        }

        public void b() {
            synchronized (c) {
                if (e < 2) {
                    c();
                    e++;
                    C6288b c6288b = d;
                    if (c6288b != null) {
                        this.b = c6288b;
                    }
                    d = this;
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.alivfssdk.fresco.common.internal.a$c */
    /* loaded from: classes8.dex */
    private static final class C6289c extends ByteArrayOutputStream {
        private C6289c() {
        }

        void a(byte[] bArr, int i) {
            System.arraycopy(((ByteArrayOutputStream) this).buf, 0, bArr, i, ((ByteArrayOutputStream) this).count);
        }
    }

    public static long a(InputStream inputStream, OutputStream outputStream) throws IOException {
        bu1.a(inputStream);
        bu1.a(outputStream);
        C6288b a = C6288b.a();
        try {
            byte[] bArr = a.a;
            long j = 0;
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return j;
                }
                outputStream.write(bArr, 0, read);
                j += read;
            }
        } finally {
            a.b();
        }
    }

    public static byte[] b(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        a(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] c(InputStream inputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        int i2 = i;
        while (i2 > 0) {
            int i3 = i - i2;
            int read = inputStream.read(bArr, i3, i2);
            if (read == -1) {
                return Arrays.copyOf(bArr, i3);
            }
            i2 -= read;
        }
        int read2 = inputStream.read();
        if (read2 == -1) {
            return bArr;
        }
        C6289c c6289c = new C6289c();
        c6289c.write(read2);
        a(inputStream, c6289c);
        byte[] bArr2 = new byte[c6289c.size() + i];
        System.arraycopy(bArr, 0, bArr2, 0, i);
        c6289c.a(bArr2, i);
        return bArr2;
    }
}
