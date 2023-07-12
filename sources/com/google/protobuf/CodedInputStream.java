package com.google.protobuf;

import com.youku.media.arch.instruments.statistics.ConfigReporter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import tb.cu2;
import tb.m8;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class CodedInputStream {
    private final byte[] a;
    private final boolean b;
    private int c;
    private int d;
    private int e;
    private final InputStream f;
    private int g;
    private boolean h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private RefillCallback n;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface RefillCallback {
        void onRefill();
    }

    private CodedInputStream(byte[] bArr, int i, int i2, boolean z) {
        this.h = false;
        this.j = Integer.MAX_VALUE;
        this.l = 100;
        this.m = ConfigReporter.BIT_GETTER_IMP;
        this.n = null;
        this.a = bArr;
        this.c = i2 + i;
        this.e = i;
        this.i = -i;
        this.f = null;
        this.b = z;
    }

    private void D(int i) throws IOException {
        if (i >= 0) {
            int i2 = this.i;
            int i3 = this.e;
            int i4 = i2 + i3 + i;
            int i5 = this.j;
            if (i4 <= i5) {
                int i6 = this.c;
                int i7 = i6 - i3;
                this.e = i6;
                z(1);
                while (true) {
                    int i8 = i - i7;
                    int i9 = this.c;
                    if (i8 > i9) {
                        i7 += i9;
                        this.e = i9;
                        z(1);
                    } else {
                        this.e = i8;
                        return;
                    }
                }
            } else {
                C((i5 - i2) - i3);
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        } else {
            throw InvalidProtocolBufferException.negativeSize();
        }
    }

    private void E() throws IOException {
        int i = this.c;
        int i2 = this.e;
        if (i - i2 >= 10) {
            byte[] bArr = this.a;
            int i3 = 0;
            while (i3 < 10) {
                int i4 = i2 + 1;
                if (bArr[i2] >= 0) {
                    this.e = i4;
                    return;
                } else {
                    i3++;
                    i2 = i4;
                }
            }
        }
        F();
    }

    private void F() throws IOException {
        for (int i = 0; i < 10; i++) {
            if (m() >= 0) {
                return;
            }
        }
        throw InvalidProtocolBufferException.malformedVarint();
    }

    private boolean G(int i) throws IOException {
        int i2 = this.e;
        if (i2 + i > this.c) {
            if (this.i + i2 + i > this.j) {
                return false;
            }
            RefillCallback refillCallback = this.n;
            if (refillCallback != null) {
                refillCallback.onRefill();
            }
            if (this.f != null) {
                int i3 = this.e;
                if (i3 > 0) {
                    int i4 = this.c;
                    if (i4 > i3) {
                        byte[] bArr = this.a;
                        System.arraycopy(bArr, i3, bArr, 0, i4 - i3);
                    }
                    this.i += i3;
                    this.c -= i3;
                    this.e = 0;
                }
                InputStream inputStream = this.f;
                byte[] bArr2 = this.a;
                int i5 = this.c;
                int read = inputStream.read(bArr2, i5, bArr2.length - i5);
                if (read == 0 || read < -1 || read > this.a.length) {
                    throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + read + "\nThe InputStream implementation is buggy.");
                } else if (read > 0) {
                    this.c += read;
                    if ((this.i + i) - this.m <= 0) {
                        y();
                        if (this.c >= i) {
                            return true;
                        }
                        return G(i);
                    }
                    throw InvalidProtocolBufferException.sizeLimitExceeded();
                }
            }
            return false;
        }
        throw new IllegalStateException("refillBuffer() called when " + i + " bytes were already available in buffer");
    }

    public static CodedInputStream c(InputStream inputStream) {
        return new CodedInputStream(inputStream, 4096);
    }

    public static CodedInputStream d(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return f(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
        }
        ByteBuffer duplicate = byteBuffer.duplicate();
        byte[] bArr = new byte[duplicate.remaining()];
        duplicate.get(bArr);
        return e(bArr);
    }

    public static CodedInputStream e(byte[] bArr) {
        return f(bArr, 0, bArr.length);
    }

    public static CodedInputStream f(byte[] bArr, int i, int i2) {
        return g(bArr, i, i2, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CodedInputStream g(byte[] bArr, int i, int i2, boolean z) {
        CodedInputStream codedInputStream = new CodedInputStream(bArr, i, i2, z);
        try {
            codedInputStream.i(i2);
            return codedInputStream;
        } catch (InvalidProtocolBufferException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private byte[] n(int i) throws IOException {
        if (i <= 0) {
            if (i == 0) {
                return Internal.EMPTY_BYTE_ARRAY;
            }
            throw InvalidProtocolBufferException.negativeSize();
        }
        int i2 = this.i;
        int i3 = this.e;
        int i4 = i2 + i3 + i;
        if (i4 <= this.m) {
            int i5 = this.j;
            if (i4 <= i5) {
                InputStream inputStream = this.f;
                if (inputStream != null) {
                    int i6 = this.c;
                    int i7 = i6 - i3;
                    this.i = i2 + i6;
                    this.e = 0;
                    this.c = 0;
                    int i8 = i - i7;
                    if (i8 >= 4096 && i8 > inputStream.available()) {
                        ArrayList<byte[]> arrayList = new ArrayList();
                        while (i8 > 0) {
                            int min = Math.min(i8, 4096);
                            byte[] bArr = new byte[min];
                            int i9 = 0;
                            while (i9 < min) {
                                int read = this.f.read(bArr, i9, min - i9);
                                if (read == -1) {
                                    throw InvalidProtocolBufferException.truncatedMessage();
                                }
                                this.i += read;
                                i9 += read;
                            }
                            i8 -= min;
                            arrayList.add(bArr);
                        }
                        byte[] bArr2 = new byte[i];
                        System.arraycopy(this.a, i3, bArr2, 0, i7);
                        for (byte[] bArr3 : arrayList) {
                            System.arraycopy(bArr3, 0, bArr2, i7, bArr3.length);
                            i7 += bArr3.length;
                        }
                        return bArr2;
                    }
                    byte[] bArr4 = new byte[i];
                    System.arraycopy(this.a, i3, bArr4, 0, i7);
                    while (i7 < i) {
                        int read2 = this.f.read(bArr4, i7, i - i7);
                        if (read2 == -1) {
                            throw InvalidProtocolBufferException.truncatedMessage();
                        }
                        this.i += read2;
                        i7 += read2;
                    }
                    return bArr4;
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            C((i5 - i2) - i3);
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        throw InvalidProtocolBufferException.sizeLimitExceeded();
    }

    public static int q(int i, InputStream inputStream) throws IOException {
        if ((i & 128) == 0) {
            return i;
        }
        int i2 = i & 127;
        int i3 = 7;
        while (i3 < 32) {
            int read = inputStream.read();
            if (read == -1) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            i2 |= (read & 127) << i3;
            if ((read & 128) == 0) {
                return i2;
            }
            i3 += 7;
        }
        while (i3 < 64) {
            int read2 = inputStream.read();
            if (read2 == -1) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if ((read2 & 128) == 0) {
                return i2;
            }
            i3 += 7;
        }
        throw InvalidProtocolBufferException.malformedVarint();
    }

    private void y() {
        int i = this.c + this.d;
        this.c = i;
        int i2 = this.i + i;
        int i3 = this.j;
        if (i2 > i3) {
            int i4 = i2 - i3;
            this.d = i4;
            this.c = i - i4;
            return;
        }
        this.d = 0;
    }

    private void z(int i) throws IOException {
        if (!G(i)) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
    }

    public boolean A(int i) throws IOException {
        int b = WireFormat.b(i);
        if (b == 0) {
            E();
            return true;
        } else if (b == 1) {
            C(8);
            return true;
        } else if (b == 2) {
            C(p());
            return true;
        } else if (b == 3) {
            B();
            a(WireFormat.c(WireFormat.a(i), 4));
            return true;
        } else if (b != 4) {
            if (b == 5) {
                C(4);
                return true;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        } else {
            return false;
        }
    }

    public void B() throws IOException {
        int v;
        do {
            v = v();
            if (v == 0) {
                return;
            }
        } while (A(v));
    }

    public void C(int i) throws IOException {
        int i2 = this.c;
        int i3 = this.e;
        if (i <= i2 - i3 && i >= 0) {
            this.e = i3 + i;
        } else {
            D(i);
        }
    }

    public void a(int i) throws InvalidProtocolBufferException {
        if (this.g != i) {
            throw InvalidProtocolBufferException.invalidEndTag();
        }
    }

    public boolean b() throws IOException {
        return this.e == this.c && !G(1);
    }

    public void h(int i) {
        this.j = i;
        y();
    }

    public int i(int i) throws InvalidProtocolBufferException {
        if (i >= 0) {
            int i2 = i + this.i + this.e;
            int i3 = this.j;
            if (i2 <= i3) {
                this.j = i2;
                y();
                return i3;
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        throw InvalidProtocolBufferException.negativeSize();
    }

    public ByteString j() throws IOException {
        ByteString copyFrom;
        int p = p();
        int i = this.c;
        int i2 = this.e;
        if (p > i - i2 || p <= 0) {
            if (p == 0) {
                return ByteString.EMPTY;
            }
            return ByteString.wrap(n(p));
        }
        if (this.b && this.h) {
            copyFrom = ByteString.wrap(this.a, i2, p);
        } else {
            copyFrom = ByteString.copyFrom(this.a, i2, p);
        }
        this.e += p;
        return copyFrom;
    }

    public double k() throws IOException {
        return Double.longBitsToDouble(o());
    }

    public <T extends MessageLite> T l(Parser<T> parser, g gVar) throws IOException {
        int p = p();
        if (this.k < this.l) {
            int i = i(p);
            this.k++;
            T parsePartialFrom = parser.parsePartialFrom(this, gVar);
            a(0);
            this.k--;
            h(i);
            return parsePartialFrom;
        }
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }

    public byte m() throws IOException {
        if (this.e == this.c) {
            z(1);
        }
        byte[] bArr = this.a;
        int i = this.e;
        this.e = i + 1;
        return bArr[i];
    }

    public long o() throws IOException {
        int i = this.e;
        if (this.c - i < 8) {
            z(8);
            i = this.e;
        }
        byte[] bArr = this.a;
        this.e = i + 8;
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0068, code lost:
        if (r2[r3] < 0) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int p() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.e
            int r1 = r5.c
            if (r1 != r0) goto L7
            goto L6a
        L7:
            byte[] r2 = r5.a
            int r3 = r0 + 1
            r0 = r2[r0]
            if (r0 < 0) goto L12
            r5.e = r3
            return r0
        L12:
            int r1 = r1 - r3
            r4 = 9
            if (r1 >= r4) goto L18
            goto L6a
        L18:
            int r1 = r3 + 1
            r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L24
            r0 = r0 ^ (-128(0xffffffffffffff80, float:NaN))
            goto L70
        L24:
            int r3 = r1 + 1
            r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L31
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
        L2f:
            r1 = r3
            goto L70
        L31:
            int r1 = r3 + 1
            r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L3f
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L70
        L3f:
            int r3 = r1 + 1
            r1 = r2[r1]
            int r4 = r1 << 28
            r0 = r0 ^ r4
            r4 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r4
            if (r1 >= 0) goto L2f
            int r1 = r3 + 1
            r3 = r2[r3]
            if (r3 >= 0) goto L70
            int r3 = r1 + 1
            r1 = r2[r1]
            if (r1 >= 0) goto L2f
            int r1 = r3 + 1
            r3 = r2[r3]
            if (r3 >= 0) goto L70
            int r3 = r1 + 1
            r1 = r2[r1]
            if (r1 >= 0) goto L2f
            int r1 = r3 + 1
            r2 = r2[r3]
            if (r2 >= 0) goto L70
        L6a:
            long r0 = r5.s()
            int r1 = (int) r0
            return r1
        L70:
            r5.e = r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.p():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b4, code lost:
        if (r2[r0] < 0) goto L42;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long r() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 192
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.r():long");
    }

    long s() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte m = m();
            j |= (m & m8.DEL) << i;
            if ((m & cu2.MAX_POWER_OF_TWO) == 0) {
                return j;
            }
        }
        throw InvalidProtocolBufferException.malformedVarint();
    }

    public String t() throws IOException {
        int p = p();
        int i = this.c;
        int i2 = this.e;
        if (p <= i - i2 && p > 0) {
            String str = new String(this.a, i2, p, Internal.a);
            this.e += p;
            return str;
        } else if (p == 0) {
            return "";
        } else {
            if (p <= i) {
                z(p);
                String str2 = new String(this.a, this.e, p, Internal.a);
                this.e += p;
                return str2;
            }
            return new String(n(p), Internal.a);
        }
    }

    public String u() throws IOException {
        byte[] n;
        int p = p();
        int i = this.e;
        int i2 = this.c;
        if (p <= i2 - i && p > 0) {
            n = this.a;
            this.e = i + p;
        } else if (p == 0) {
            return "";
        } else {
            if (p <= i2) {
                z(p);
                n = this.a;
                this.e = p + 0;
            } else {
                n = n(p);
            }
            i = 0;
        }
        if (Utf8.q(n, i, i + p)) {
            return new String(n, i, p, Internal.a);
        }
        throw InvalidProtocolBufferException.invalidUtf8();
    }

    public int v() throws IOException {
        if (b()) {
            this.g = 0;
            return 0;
        }
        int p = p();
        this.g = p;
        if (WireFormat.a(p) != 0) {
            return this.g;
        }
        throw InvalidProtocolBufferException.invalidTag();
    }

    public int w() throws IOException {
        return p();
    }

    public long x() throws IOException {
        return r();
    }

    private CodedInputStream(InputStream inputStream, int i) {
        this.h = false;
        this.j = Integer.MAX_VALUE;
        this.l = 100;
        this.m = ConfigReporter.BIT_GETTER_IMP;
        this.n = null;
        this.a = new byte[i];
        this.e = 0;
        this.i = 0;
        this.f = inputStream;
        this.b = false;
    }
}
