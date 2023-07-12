package com.xiaomi.push;

import com.youku.media.arch.instruments.statistics.ConfigReporter;
import java.io.InputStream;
import java.util.Vector;
import tb.cu2;
import tb.m8;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class b {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private final InputStream f118a;

    /* renamed from: a  reason: collision with other field name */
    private final byte[] f119a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;

    private b(InputStream inputStream) {
        this.f = Integer.MAX_VALUE;
        this.h = 64;
        this.i = ConfigReporter.BIT_GETTER_IMP;
        this.f119a = new byte[4096];
        this.a = 0;
        this.c = 0;
        this.f118a = inputStream;
    }

    private b(byte[] bArr, int i, int i2) {
        this.f = Integer.MAX_VALUE;
        this.h = 64;
        this.i = ConfigReporter.BIT_GETTER_IMP;
        this.f119a = bArr;
        this.a = i2 + i;
        this.c = i;
        this.f118a = null;
    }

    public static b a(InputStream inputStream) {
        return new b(inputStream);
    }

    public static b a(byte[] bArr, int i, int i2) {
        return new b(bArr, i, i2);
    }

    private boolean a(boolean z) {
        int i = this.c;
        int i2 = this.a;
        if (i >= i2) {
            int i3 = this.e;
            if (i3 + i2 == this.f) {
                if (z) {
                    throw d.a();
                }
                return false;
            }
            this.e = i3 + i2;
            this.c = 0;
            InputStream inputStream = this.f118a;
            int read = inputStream == null ? -1 : inputStream.read(this.f119a);
            this.a = read;
            if (read == 0 || read < -1) {
                throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + this.a + "\nThe InputStream implementation is buggy.");
            } else if (read == -1) {
                this.a = 0;
                if (z) {
                    throw d.a();
                }
                return false;
            } else {
                b();
                int i4 = this.e + this.a + this.b;
                if (i4 > this.i || i4 < 0) {
                    throw d.h();
                }
                return true;
            }
        }
        throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
    }

    private void b() {
        int i = this.a + this.b;
        this.a = i;
        int i2 = this.e + i;
        int i3 = this.f;
        if (i2 <= i3) {
            this.b = 0;
            return;
        }
        int i4 = i2 - i3;
        this.b = i4;
        this.a = i - i4;
    }

    public byte a() {
        if (this.c == this.a) {
            a(true);
        }
        byte[] bArr = this.f119a;
        int i = this.c;
        this.c = i + 1;
        return bArr[i];
    }

    /* renamed from: a  reason: collision with other method in class */
    public int m673a() {
        if (m684b()) {
            this.d = 0;
            return 0;
        }
        int d = d();
        this.d = d;
        if (d != 0) {
            return d;
        }
        throw d.d();
    }

    public int a(int i) {
        if (i >= 0) {
            int i2 = i + this.e + this.c;
            int i3 = this.f;
            if (i2 <= i3) {
                this.f = i2;
                b();
                return i3;
            }
            throw d.a();
        }
        throw d.b();
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m674a() {
        return m685c();
    }

    /* renamed from: a  reason: collision with other method in class */
    public a m675a() {
        int d = d();
        int i = this.a;
        int i2 = this.c;
        if (d > i - i2 || d <= 0) {
            return a.a(m681a(d));
        }
        a a = a.a(this.f119a, i2, d);
        this.c += d;
        return a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m676a() {
        int d = d();
        int i = this.a;
        int i2 = this.c;
        if (d > i - i2 || d <= 0) {
            return new String(m681a(d), "UTF-8");
        }
        String str = new String(this.f119a, i2, d, "UTF-8");
        this.c += d;
        return str;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m677a() {
        int m673a;
        do {
            m673a = m673a();
            if (m673a == 0) {
                return;
            }
        } while (m680a(m673a));
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m678a(int i) {
        if (this.d != i) {
            throw d.e();
        }
    }

    public void a(e eVar) {
        int d = d();
        if (this.g >= this.h) {
            throw d.g();
        }
        int a = a(d);
        this.g++;
        eVar.a(this);
        m678a(0);
        this.g--;
        b(a);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m679a() {
        return d() != 0;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m680a(int i) {
        int a = f.a(i);
        if (a == 0) {
            m682b();
            return true;
        } else if (a == 1) {
            m686d();
            return true;
        } else if (a == 2) {
            c(d());
            return true;
        } else if (a == 3) {
            m677a();
            m678a(f.a(f.b(i), 4));
            return true;
        } else if (a != 4) {
            if (a == 5) {
                e();
                return true;
            }
            throw d.f();
        } else {
            return false;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m681a(int i) {
        if (i < 0) {
            throw d.b();
        }
        int i2 = this.e;
        int i3 = this.c;
        int i4 = i2 + i3 + i;
        int i5 = this.f;
        if (i4 > i5) {
            c((i5 - i2) - i3);
            throw d.a();
        }
        int i6 = this.a;
        if (i <= i6 - i3) {
            byte[] bArr = new byte[i];
            System.arraycopy(this.f119a, i3, bArr, 0, i);
            this.c += i;
            return bArr;
        } else if (i >= 4096) {
            this.e = i2 + i6;
            this.c = 0;
            this.a = 0;
            int i7 = i6 - i3;
            int i8 = i - i7;
            Vector vector = new Vector();
            while (i8 > 0) {
                int min = Math.min(i8, 4096);
                byte[] bArr2 = new byte[min];
                int i9 = 0;
                while (i9 < min) {
                    InputStream inputStream = this.f118a;
                    int read = inputStream == null ? -1 : inputStream.read(bArr2, i9, min - i9);
                    if (read == -1) {
                        throw d.a();
                    }
                    this.e += read;
                    i9 += read;
                }
                i8 -= min;
                vector.addElement(bArr2);
            }
            byte[] bArr3 = new byte[i];
            System.arraycopy(this.f119a, i3, bArr3, 0, i7);
            for (int i10 = 0; i10 < vector.size(); i10++) {
                byte[] bArr4 = (byte[]) vector.elementAt(i10);
                System.arraycopy(bArr4, 0, bArr3, i7, bArr4.length);
                i7 += bArr4.length;
            }
            return bArr3;
        } else {
            byte[] bArr5 = new byte[i];
            int i11 = i6 - i3;
            System.arraycopy(this.f119a, i3, bArr5, 0, i11);
            this.c = this.a;
            while (true) {
                a(true);
                int i12 = i - i11;
                int i13 = this.a;
                if (i12 <= i13) {
                    System.arraycopy(this.f119a, 0, bArr5, i11, i12);
                    this.c = i12;
                    return bArr5;
                }
                System.arraycopy(this.f119a, 0, bArr5, i11, i13);
                int i14 = this.a;
                i11 += i14;
                this.c = i14;
            }
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public int m682b() {
        return d();
    }

    /* renamed from: b  reason: collision with other method in class */
    public long m683b() {
        return m685c();
    }

    public void b(int i) {
        this.f = i;
        b();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m684b() {
        return this.c == this.a && !a(false);
    }

    public int c() {
        return d();
    }

    /* renamed from: c  reason: collision with other method in class */
    public long m685c() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte a = a();
            j |= (a & m8.DEL) << i;
            if ((a & cu2.MAX_POWER_OF_TWO) == 0) {
                return j;
            }
        }
        throw d.c();
    }

    public void c(int i) {
        if (i < 0) {
            throw d.b();
        }
        int i2 = this.e;
        int i3 = this.c;
        int i4 = i2 + i3 + i;
        int i5 = this.f;
        if (i4 > i5) {
            c((i5 - i2) - i3);
            throw d.a();
        }
        int i6 = this.a;
        if (i <= i6 - i3) {
            this.c = i3 + i;
            return;
        }
        int i7 = i6 - i3;
        this.e = i2 + i6;
        this.c = 0;
        this.a = 0;
        while (i7 < i) {
            InputStream inputStream = this.f118a;
            int skip = inputStream == null ? -1 : (int) inputStream.skip(i - i7);
            if (skip <= 0) {
                throw d.a();
            }
            i7 += skip;
            this.e += skip;
        }
    }

    public int d() {
        int i;
        byte a = a();
        if (a >= 0) {
            return a;
        }
        int i2 = a & m8.DEL;
        byte a2 = a();
        if (a2 >= 0) {
            i = a2 << 7;
        } else {
            i2 |= (a2 & m8.DEL) << 7;
            byte a3 = a();
            if (a3 >= 0) {
                i = a3 << 14;
            } else {
                i2 |= (a3 & m8.DEL) << 14;
                byte a4 = a();
                if (a4 < 0) {
                    int i3 = i2 | ((a4 & m8.DEL) << 21);
                    byte a5 = a();
                    int i4 = i3 | (a5 << 28);
                    if (a5 < 0) {
                        for (int i5 = 0; i5 < 5; i5++) {
                            if (a() >= 0) {
                                return i4;
                            }
                        }
                        throw d.c();
                    }
                    return i4;
                }
                i = a4 << 21;
            }
        }
        return i2 | i;
    }

    /* renamed from: d  reason: collision with other method in class */
    public long m686d() {
        byte a = a();
        byte a2 = a();
        return ((a2 & 255) << 8) | (a & 255) | ((a() & 255) << 16) | ((a() & 255) << 24) | ((a() & 255) << 32) | ((a() & 255) << 40) | ((a() & 255) << 48) | ((a() & 255) << 56);
    }

    public int e() {
        return (a() & 255) | ((a() & 255) << 8) | ((a() & 255) << 16) | ((a() & 255) << 24);
    }
}
