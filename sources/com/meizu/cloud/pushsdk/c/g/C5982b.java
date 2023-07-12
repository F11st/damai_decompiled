package com.meizu.cloud.pushsdk.c.g;

import androidx.annotation.NonNull;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import tb.jn1;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.c.g.b */
/* loaded from: classes10.dex */
public final class C5982b implements InterfaceC5983c, InterfaceC5984d, Cloneable {
    private static final byte[] c = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    C5990j a;
    long b;

    public int a(byte[] bArr, int i, int i2) {
        C5995o.a(bArr.length, i, i2);
        C5990j c5990j = this.a;
        if (c5990j == null) {
            return -1;
        }
        int min = Math.min(i2, c5990j.c - c5990j.b);
        System.arraycopy(c5990j.a, c5990j.b, bArr, i, min);
        int i3 = c5990j.b + min;
        c5990j.b = i3;
        this.b -= min;
        if (i3 == c5990j.c) {
            this.a = c5990j.a();
            C5991k.a(c5990j);
        }
        return min;
    }

    public long a() {
        return this.b;
    }

    @Override // com.meizu.cloud.pushsdk.c.g.InterfaceC5983c
    public long a(InterfaceC5993m interfaceC5993m) throws IOException {
        if (interfaceC5993m == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long b = interfaceC5993m.b(this, 2048L);
            if (b == -1) {
                return j;
            }
            j += b;
        }
    }

    public C5982b a(int i) {
        int i2;
        int i3;
        if (i >= 128) {
            if (i < 2048) {
                i3 = (i >> 6) | 192;
            } else {
                if (i < 65536) {
                    if (i >= 55296 && i <= 57343) {
                        throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
                    }
                    i2 = (i >> 12) | 224;
                } else if (i > 1114111) {
                    throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
                } else {
                    b((i >> 18) | GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN);
                    i2 = ((i >> 12) & 63) | 128;
                }
                b(i2);
                i3 = ((i >> 6) & 63) | 128;
            }
            b(i3);
            i = (i & 63) | 128;
        }
        b(i);
        return this;
    }

    @Override // com.meizu.cloud.pushsdk.c.g.InterfaceC5983c
    /* renamed from: a */
    public C5982b b(C5985e c5985e) {
        if (c5985e != null) {
            c5985e.a(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    @Override // com.meizu.cloud.pushsdk.c.g.InterfaceC5983c
    /* renamed from: a */
    public C5982b b(String str) {
        return a(str, 0, str.length());
    }

    public C5982b a(String str, int i, int i2) {
        int i3;
        if (str != null) {
            if (i < 0) {
                throw new IllegalAccessError("beginIndex < 0: " + i);
            } else if (i2 < i) {
                throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
            } else if (i2 > str.length()) {
                throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
            } else {
                while (i < i2) {
                    char charAt = str.charAt(i);
                    if (charAt < 128) {
                        C5990j c2 = c(1);
                        byte[] bArr = c2.a;
                        int i4 = c2.c - i;
                        int min = Math.min(i2, 2048 - i4);
                        int i5 = i + 1;
                        bArr[i + i4] = (byte) charAt;
                        while (i5 < min) {
                            char charAt2 = str.charAt(i5);
                            if (charAt2 >= 128) {
                                break;
                            }
                            bArr[i5 + i4] = (byte) charAt2;
                            i5++;
                        }
                        int i6 = c2.c;
                        int i7 = (i4 + i5) - i6;
                        c2.c = i6 + i7;
                        this.b += i7;
                        i = i5;
                    } else {
                        if (charAt < 2048) {
                            i3 = (charAt >> 6) | 192;
                        } else if (charAt < 55296 || charAt > 57343) {
                            b((charAt >> '\f') | 224);
                            i3 = ((charAt >> 6) & 63) | 128;
                        } else {
                            int i8 = i + 1;
                            char charAt3 = i8 < i2 ? str.charAt(i8) : (char) 0;
                            if (charAt > 56319 || charAt3 < 56320 || charAt3 > 57343) {
                                b(63);
                                i = i8;
                            } else {
                                int i9 = (((charAt & 10239) << 10) | (9215 & charAt3)) + 65536;
                                b((i9 >> 18) | GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN);
                                b(((i9 >> 12) & 63) | 128);
                                b(((i9 >> 6) & 63) | 128);
                                b((i9 & 63) | 128);
                                i += 2;
                            }
                        }
                        b(i3);
                        b((charAt & jn1.CONDITION_IF) | 128);
                        i++;
                    }
                }
                return this;
            }
        }
        throw new IllegalArgumentException("string == null");
    }

    public String a(long j, Charset charset) throws EOFException {
        C5995o.a(this.b, 0L, j);
        if (charset != null) {
            if (j > 2147483647L) {
                throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
            } else if (j == 0) {
                return "";
            } else {
                C5990j c5990j = this.a;
                int i = c5990j.b;
                if (i + j > c5990j.c) {
                    return new String(a(j), charset);
                }
                String str = new String(c5990j.a, i, (int) j, charset);
                int i2 = (int) (c5990j.b + j);
                c5990j.b = i2;
                this.b -= j;
                if (i2 == c5990j.c) {
                    this.a = c5990j.a();
                    C5991k.a(c5990j);
                }
                return str;
            }
        }
        throw new IllegalArgumentException("charset == null");
    }

    @Override // com.meizu.cloud.pushsdk.c.g.InterfaceC5992l
    public void a(C5982b c5982b, long j) {
        if (c5982b == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (c5982b == this) {
            throw new IllegalArgumentException("source == this");
        }
        C5995o.a(c5982b.b, 0L, j);
        while (j > 0) {
            C5990j c5990j = c5982b.a;
            if (j < c5990j.c - c5990j.b) {
                C5990j c5990j2 = this.a;
                C5990j c5990j3 = c5990j2 != null ? c5990j2.g : null;
                if (c5990j3 != null && c5990j3.e) {
                    if ((c5990j3.c + j) - (c5990j3.d ? 0 : c5990j3.b) <= 2048) {
                        c5990j.a(c5990j3, (int) j);
                        c5982b.b -= j;
                        this.b += j;
                        return;
                    }
                }
                c5982b.a = c5990j.a((int) j);
            }
            C5990j c5990j4 = c5982b.a;
            long j2 = c5990j4.c - c5990j4.b;
            c5982b.a = c5990j4.a();
            C5990j c5990j5 = this.a;
            if (c5990j5 == null) {
                this.a = c5990j4;
                c5990j4.g = c5990j4;
                c5990j4.f = c5990j4;
            } else {
                c5990j5.g.a(c5990j4).b();
            }
            c5982b.b -= j2;
            this.b += j2;
            j -= j2;
        }
    }

    public void a(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int a = a(bArr, i, bArr.length - i);
            if (a == -1) {
                throw new EOFException();
            }
            i += a;
        }
    }

    public byte[] a(long j) throws EOFException {
        C5995o.a(this.b, 0L, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[(int) j];
            a(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
    }

    @Override // com.meizu.cloud.pushsdk.c.g.InterfaceC5993m
    public long b(C5982b c5982b, long j) {
        if (c5982b != null) {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            long j2 = this.b;
            if (j2 == 0) {
                return -1L;
            }
            if (j > j2) {
                j = j2;
            }
            c5982b.a(this, j);
            return j;
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // com.meizu.cloud.pushsdk.c.g.InterfaceC5983c
    public C5982b b() {
        return this;
    }

    public C5982b b(int i) {
        C5990j c2 = c(1);
        byte[] bArr = c2.a;
        int i2 = c2.c;
        c2.c = i2 + 1;
        bArr[i2] = (byte) i;
        this.b++;
        return this;
    }

    @Override // com.meizu.cloud.pushsdk.c.g.InterfaceC5983c
    /* renamed from: b */
    public C5982b c(byte[] bArr) {
        if (bArr != null) {
            return c(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // com.meizu.cloud.pushsdk.c.g.InterfaceC5983c
    /* renamed from: b */
    public C5982b c(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            long j = i2;
            C5995o.a(bArr.length, i, j);
            int i3 = i2 + i;
            while (i < i3) {
                C5990j c2 = c(1);
                int min = Math.min(i3 - i, 2048 - c2.c);
                System.arraycopy(bArr, i, c2.a, c2.c, min);
                i += min;
                c2.c += min;
            }
            this.b += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public void b(long j) throws EOFException {
        C5990j c5990j;
        while (j > 0) {
            if (this.a == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j, c5990j.c - c5990j.b);
            long j2 = min;
            this.b -= j2;
            j -= j2;
            C5990j c5990j2 = this.a;
            int i = c5990j2.b + min;
            c5990j2.b = i;
            if (i == c5990j2.c) {
                this.a = c5990j2.a();
                C5991k.a(c5990j2);
            }
        }
    }

    @Override // com.meizu.cloud.pushsdk.c.g.InterfaceC5983c
    /* renamed from: c */
    public C5982b e(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i == 0) {
            return b(48);
        }
        boolean z = false;
        int i2 = 1;
        if (i < 0) {
            j = -j;
            if (j < 0) {
                return b("-9223372036854775808");
            }
            z = true;
        }
        if (j >= 100000000) {
            i2 = j < 1000000000000L ? j < 10000000000L ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= 10000) {
            i2 = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i2 = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i2 = 2;
        }
        if (z) {
            i2++;
        }
        C5990j c2 = c(i2);
        byte[] bArr = c2.a;
        int i3 = c2.c + i2;
        while (j != 0) {
            i3--;
            bArr[i3] = c[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i3 - 1] = 45;
        }
        c2.c += i2;
        this.b += i2;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C5990j c(int i) {
        if (i < 1 || i > 2048) {
            throw new IllegalArgumentException();
        }
        C5990j c5990j = this.a;
        if (c5990j != null) {
            C5990j c5990j2 = c5990j.g;
            return (c5990j2.c + i > 2048 || !c5990j2.e) ? c5990j2.a(C5991k.a()) : c5990j2;
        }
        C5990j a = C5991k.a();
        this.a = a;
        a.g = a;
        a.f = a;
        return a;
    }

    public boolean c() {
        return this.b == 0;
    }

    @Override // com.meizu.cloud.pushsdk.c.g.InterfaceC5992l, java.io.Closeable, java.lang.AutoCloseable, com.meizu.cloud.pushsdk.c.g.InterfaceC5993m
    public void close() {
    }

    public C5982b d(long j) {
        if (j == 0) {
            return b(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        C5990j c2 = c(numberOfTrailingZeros);
        byte[] bArr = c2.a;
        int i = c2.c;
        for (int i2 = (i + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = c[(int) (15 & j)];
            j >>>= 4;
        }
        c2.c += numberOfTrailingZeros;
        this.b += numberOfTrailingZeros;
        return this;
    }

    @Override // com.meizu.cloud.pushsdk.c.g.InterfaceC5984d
    public InputStream d() {
        return new InputStream() { // from class: com.meizu.cloud.pushsdk.c.g.b.1
            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(C5982b.this.b, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.InputStream
            public int read() {
                C5982b c5982b = C5982b.this;
                if (c5982b.b > 0) {
                    return c5982b.f() & 255;
                }
                return -1;
            }

            @Override // java.io.InputStream
            public int read(@NonNull byte[] bArr, int i, int i2) {
                return C5982b.this.a(bArr, i, i2);
            }

            public String toString() {
                return C5982b.this + ".inputStream()";
            }
        };
    }

    public long e() {
        long j = this.b;
        if (j == 0) {
            return 0L;
        }
        C5990j c5990j = this.a.g;
        int i = c5990j.c;
        return (i >= 2048 || !c5990j.e) ? j : j - (i - c5990j.b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C5982b) {
            C5982b c5982b = (C5982b) obj;
            long j = this.b;
            if (j != c5982b.b) {
                return false;
            }
            long j2 = 0;
            if (j == 0) {
                return true;
            }
            C5990j c5990j = this.a;
            C5990j c5990j2 = c5982b.a;
            int i = c5990j.b;
            int i2 = c5990j2.b;
            while (j2 < this.b) {
                long min = Math.min(c5990j.c - i, c5990j2.c - i2);
                int i3 = 0;
                while (i3 < min) {
                    int i4 = i + 1;
                    int i5 = i2 + 1;
                    if (c5990j.a[i] != c5990j2.a[i2]) {
                        return false;
                    }
                    i3++;
                    i = i4;
                    i2 = i5;
                }
                if (i == c5990j.c) {
                    c5990j = c5990j.f;
                    i = c5990j.b;
                }
                if (i2 == c5990j2.c) {
                    c5990j2 = c5990j2.f;
                    i2 = c5990j2.b;
                }
                j2 += min;
            }
            return true;
        }
        return false;
    }

    public byte f() {
        long j = this.b;
        if (j != 0) {
            C5990j c5990j = this.a;
            int i = c5990j.b;
            int i2 = c5990j.c;
            int i3 = i + 1;
            byte b = c5990j.a[i];
            this.b = j - 1;
            if (i3 == i2) {
                this.a = c5990j.a();
                C5991k.a(c5990j);
            } else {
                c5990j.b = i3;
            }
            return b;
        }
        throw new IllegalStateException("size == 0");
    }

    @Override // com.meizu.cloud.pushsdk.c.g.InterfaceC5992l, java.io.Flushable
    public void flush() {
    }

    public C5985e g() {
        return new C5985e(i());
    }

    @Override // com.meizu.cloud.pushsdk.c.g.InterfaceC5984d
    public String h() {
        try {
            return a(this.b, C5995o.a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public int hashCode() {
        C5990j c5990j = this.a;
        if (c5990j == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = c5990j.c;
            for (int i3 = c5990j.b; i3 < i2; i3++) {
                i = (i * 31) + c5990j.a[i3];
            }
            c5990j = c5990j.f;
        } while (c5990j != this.a);
        return i;
    }

    @Override // com.meizu.cloud.pushsdk.c.g.InterfaceC5984d
    public byte[] i() {
        try {
            return a(this.b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public void j() {
        try {
            b(this.b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: k */
    public C5982b clone() {
        C5982b c5982b = new C5982b();
        if (this.b == 0) {
            return c5982b;
        }
        C5990j c5990j = new C5990j(this.a);
        c5982b.a = c5990j;
        c5990j.g = c5990j;
        c5990j.f = c5990j;
        C5990j c5990j2 = this.a;
        while (true) {
            c5990j2 = c5990j2.f;
            if (c5990j2 == this.a) {
                c5982b.b = this.b;
                return c5982b;
            }
            c5982b.a.g.a(new C5990j(c5990j2));
        }
    }

    public String toString() {
        long j = this.b;
        if (j == 0) {
            return "Buffer[size=0]";
        }
        if (j <= 16) {
            return String.format("Buffer[size=%s data=%s]", Long.valueOf(this.b), clone().g().c());
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            C5990j c5990j = this.a;
            byte[] bArr = c5990j.a;
            int i = c5990j.b;
            messageDigest.update(bArr, i, c5990j.c - i);
            C5990j c5990j2 = this.a;
            while (true) {
                c5990j2 = c5990j2.f;
                if (c5990j2 == this.a) {
                    return String.format("Buffer[size=%s md5=%s]", Long.valueOf(this.b), C5985e.a(messageDigest.digest()).c());
                }
                byte[] bArr2 = c5990j2.a;
                int i2 = c5990j2.b;
                messageDigest.update(bArr2, i2, c5990j2.c - i2);
            }
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }
}
