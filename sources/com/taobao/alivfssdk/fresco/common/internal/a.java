package com.taobao.alivfssdk.fresco.common.internal;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import tb.bu1;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class a {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class b {
        private static final Object c = new Object();
        private static b d;
        private static int e;
        byte[] a = new byte[4096];
        private b b;

        private b() {
        }

        public static b a() {
            synchronized (c) {
                b bVar = d;
                if (bVar != null) {
                    d = bVar.b;
                    bVar.b = null;
                    e--;
                    return bVar;
                }
                return new b();
            }
        }

        private void c() {
        }

        public void b() {
            synchronized (c) {
                if (e < 2) {
                    c();
                    e++;
                    b bVar = d;
                    if (bVar != null) {
                        this.b = bVar;
                    }
                    d = this;
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    private static final class c extends ByteArrayOutputStream {
        private c() {
        }

        void a(byte[] bArr, int i) {
            System.arraycopy(((ByteArrayOutputStream) this).buf, 0, bArr, i, ((ByteArrayOutputStream) this).count);
        }
    }

    public static long a(InputStream inputStream, OutputStream outputStream) throws IOException {
        bu1.a(inputStream);
        bu1.a(outputStream);
        b a = b.a();
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
        c cVar = new c();
        cVar.write(read2);
        a(inputStream, cVar);
        byte[] bArr2 = new byte[cVar.size() + i];
        System.arraycopy(bArr, 0, bArr2, 0, i);
        cVar.a(bArr2, i);
        return bArr2;
    }
}
