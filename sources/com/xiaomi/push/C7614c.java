package com.xiaomi.push;

import com.alipay.sdk.m.n.C4250a;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/* compiled from: Taobao */
/* renamed from: com.xiaomi.push.c */
/* loaded from: classes11.dex */
public final class C7614c {
    private final int a;

    /* renamed from: a  reason: collision with other field name */
    private final OutputStream f148a;

    /* renamed from: a  reason: collision with other field name */
    private final byte[] f149a;
    private int b;

    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.c$a */
    /* loaded from: classes11.dex */
    public static class C7615a extends IOException {
        C7615a() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    private C7614c(OutputStream outputStream, byte[] bArr) {
        this.f148a = outputStream;
        this.f149a = bArr;
        this.b = 0;
        this.a = bArr.length;
    }

    private C7614c(byte[] bArr, int i, int i2) {
        this.f148a = null;
        this.f149a = bArr;
        this.b = i;
        this.a = i + i2;
    }

    public static int a(int i) {
        if (i >= 0) {
            return d(i);
        }
        return 10;
    }

    public static int a(int i, int i2) {
        return c(i) + a(i2);
    }

    public static int a(int i, long j) {
        return c(i) + a(j);
    }

    public static int a(int i, C7593a c7593a) {
        return c(i) + a(c7593a);
    }

    public static int a(int i, AbstractC7646e abstractC7646e) {
        return c(i) + a(abstractC7646e);
    }

    public static int a(int i, String str) {
        return c(i) + a(str);
    }

    public static int a(int i, boolean z) {
        return c(i) + a(z);
    }

    public static int a(long j) {
        return c(j);
    }

    public static int a(C7593a c7593a) {
        return d(c7593a.a()) + c7593a.a();
    }

    public static int a(AbstractC7646e abstractC7646e) {
        int b = abstractC7646e.b();
        return d(b) + b;
    }

    public static int a(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return d(bytes.length) + bytes.length;
        } catch (UnsupportedEncodingException unused) {
            throw new RuntimeException("UTF-8 not supported.");
        }
    }

    public static int a(boolean z) {
        return 1;
    }

    public static C7614c a(OutputStream outputStream) {
        return a(outputStream, 4096);
    }

    public static C7614c a(OutputStream outputStream, int i) {
        return new C7614c(outputStream, new byte[i]);
    }

    public static C7614c a(byte[] bArr, int i, int i2) {
        return new C7614c(bArr, i, i2);
    }

    public static int b(int i) {
        return d(i);
    }

    public static int b(int i, int i2) {
        return c(i) + b(i2);
    }

    public static int b(int i, long j) {
        return c(i) + b(j);
    }

    public static int b(long j) {
        return c(j);
    }

    public static int c(int i) {
        return d(C7650f.a(i, 0));
    }

    public static int c(long j) {
        if (((-128) & j) == 0) {
            return 1;
        }
        if (((-16384) & j) == 0) {
            return 2;
        }
        if (((-2097152) & j) == 0) {
            return 3;
        }
        if (((-268435456) & j) == 0) {
            return 4;
        }
        if (((-34359738368L) & j) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j) == 0) {
            return 8;
        }
        return (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    private void c() {
        OutputStream outputStream = this.f148a;
        if (outputStream == null) {
            throw new C7615a();
        }
        outputStream.write(this.f149a, 0, this.b);
        this.b = 0;
    }

    public static int d(int i) {
        if ((i & C4250a.g) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    public int a() {
        if (this.f148a == null) {
            return this.a - this.b;
        }
        throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m715a() {
        if (this.f148a != null) {
            c();
        }
    }

    public void a(byte b) {
        if (this.b == this.a) {
            c();
        }
        byte[] bArr = this.f149a;
        int i = this.b;
        this.b = i + 1;
        bArr[i] = b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m716a(int i) {
        if (i >= 0) {
            m735d(i);
        } else {
            m734c(i);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m717a(int i, int i2) {
        c(i, 0);
        m716a(i2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m718a(int i, long j) {
        c(i, 0);
        m723a(j);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m719a(int i, C7593a c7593a) {
        c(i, 2);
        m724a(c7593a);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m720a(int i, AbstractC7646e abstractC7646e) {
        c(i, 2);
        m725a(abstractC7646e);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m721a(int i, String str) {
        c(i, 2);
        m726a(str);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m722a(int i, boolean z) {
        c(i, 0);
        m727a(z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m723a(long j) {
        m734c(j);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m724a(C7593a c7593a) {
        byte[] m658a = c7593a.m658a();
        m735d(m658a.length);
        a(m658a);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m725a(AbstractC7646e abstractC7646e) {
        m735d(abstractC7646e.a());
        abstractC7646e.a(this);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m726a(String str) {
        byte[] bytes = str.getBytes("UTF-8");
        m735d(bytes.length);
        a(bytes);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m727a(boolean z) {
        m733c(z ? 1 : 0);
    }

    public void a(byte[] bArr) {
        m728a(bArr, 0, bArr.length);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m728a(byte[] bArr, int i, int i2) {
        int i3 = this.a;
        int i4 = this.b;
        if (i3 - i4 >= i2) {
            System.arraycopy(bArr, i, this.f149a, i4, i2);
            this.b += i2;
            return;
        }
        int i5 = i3 - i4;
        System.arraycopy(bArr, i, this.f149a, i4, i5);
        int i6 = i + i5;
        int i7 = i2 - i5;
        this.b = this.a;
        c();
        if (i7 > this.a) {
            this.f148a.write(bArr, i6, i7);
            return;
        }
        System.arraycopy(bArr, i6, this.f149a, 0, i7);
        this.b = i7;
    }

    public void b() {
        if (a() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m729b(int i) {
        m735d(i);
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m730b(int i, int i2) {
        c(i, 0);
        m729b(i2);
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m731b(int i, long j) {
        c(i, 0);
        m732b(j);
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m732b(long j) {
        m734c(j);
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m733c(int i) {
        a((byte) i);
    }

    public void c(int i, int i2) {
        m735d(C7650f.a(i, i2));
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m734c(long j) {
        while (((-128) & j) != 0) {
            m733c((((int) j) & 127) | 128);
            j >>>= 7;
        }
        m733c((int) j);
    }

    /* renamed from: d  reason: collision with other method in class */
    public void m735d(int i) {
        while ((i & C4250a.g) != 0) {
            m733c((i & 127) | 128);
            i >>>= 7;
        }
        m733c(i);
    }
}
