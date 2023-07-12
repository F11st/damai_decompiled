package kotlin.reflect.jvm.internal.impl.protobuf;

import com.youku.media.arch.instruments.statistics.ConfigReporter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import tb.cu2;
import tb.m8;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
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
    /* loaded from: classes3.dex */
    public interface RefillCallback {
        void onRefill();
    }

    private CodedInputStream(InputStream inputStream) {
        this.h = false;
        this.j = Integer.MAX_VALUE;
        this.l = 64;
        this.m = ConfigReporter.BIT_GETTER_IMP;
        this.n = null;
        this.a = new byte[4096];
        this.c = 0;
        this.e = 0;
        this.i = 0;
        this.f = inputStream;
        this.b = false;
    }

    public static int B(int i, InputStream inputStream) throws IOException {
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

    private void N() {
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

    private void O(int i) throws IOException {
        if (!T(i)) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
    }

    private void S(int i) throws IOException {
        if (i >= 0) {
            int i2 = this.i;
            int i3 = this.e;
            int i4 = i2 + i3 + i;
            int i5 = this.j;
            if (i4 <= i5) {
                int i6 = this.c;
                int i7 = i6 - i3;
                this.e = i6;
                O(1);
                while (true) {
                    int i8 = i - i7;
                    int i9 = this.c;
                    if (i8 > i9) {
                        i7 += i9;
                        this.e = i9;
                        O(1);
                    } else {
                        this.e = i8;
                        return;
                    }
                }
            } else {
                R((i5 - i2) - i3);
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        } else {
            throw InvalidProtocolBufferException.negativeSize();
        }
    }

    private boolean T(int i) throws IOException {
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
                    StringBuilder sb = new StringBuilder(102);
                    sb.append("InputStream#read(byte[]) returned invalid result: ");
                    sb.append(read);
                    sb.append("\nThe InputStream implementation is buggy.");
                    throw new IllegalStateException(sb.toString());
                } else if (read > 0) {
                    this.c += read;
                    if ((this.i + i) - this.m <= 0) {
                        N();
                        if (this.c >= i) {
                            return true;
                        }
                        return T(i);
                    }
                    throw InvalidProtocolBufferException.sizeLimitExceeded();
                }
            }
            return false;
        }
        StringBuilder sb2 = new StringBuilder(77);
        sb2.append("refillBuffer() called when ");
        sb2.append(i);
        sb2.append(" bytes were already available in buffer");
        throw new IllegalStateException(sb2.toString());
    }

    public static int b(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public static long c(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    private void d(int i) throws IOException {
        if (this.c - this.e < i) {
            O(i);
        }
    }

    public static CodedInputStream g(InputStream inputStream) {
        return new CodedInputStream(inputStream);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CodedInputStream h(C8453e c8453e) {
        CodedInputStream codedInputStream = new CodedInputStream(c8453e);
        try {
            codedInputStream.j(c8453e.size());
            return codedInputStream;
        } catch (InvalidProtocolBufferException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private byte[] x(int i) throws IOException {
        if (i <= 0) {
            if (i == 0) {
                return Internal.EMPTY_BYTE_ARRAY;
            }
            throw InvalidProtocolBufferException.negativeSize();
        }
        int i2 = this.i;
        int i3 = this.e;
        int i4 = i2 + i3 + i;
        int i5 = this.j;
        if (i4 > i5) {
            R((i5 - i2) - i3);
            throw InvalidProtocolBufferException.truncatedMessage();
        } else if (i < 4096) {
            byte[] bArr = new byte[i];
            int i6 = this.c - i3;
            System.arraycopy(this.a, i3, bArr, 0, i6);
            this.e = this.c;
            int i7 = i - i6;
            d(i7);
            System.arraycopy(this.a, 0, bArr, i6, i7);
            this.e = i7;
            return bArr;
        } else {
            int i8 = this.c;
            this.i = i2 + i8;
            this.e = 0;
            this.c = 0;
            int i9 = i8 - i3;
            int i10 = i - i9;
            ArrayList<byte[]> arrayList = new ArrayList();
            while (i10 > 0) {
                int min = Math.min(i10, 4096);
                byte[] bArr2 = new byte[min];
                int i11 = 0;
                while (i11 < min) {
                    InputStream inputStream = this.f;
                    int read = inputStream == null ? -1 : inputStream.read(bArr2, i11, min - i11);
                    if (read == -1) {
                        throw InvalidProtocolBufferException.truncatedMessage();
                    }
                    this.i += read;
                    i11 += read;
                }
                i10 -= min;
                arrayList.add(bArr2);
            }
            byte[] bArr3 = new byte[i];
            System.arraycopy(this.a, i3, bArr3, 0, i9);
            for (byte[] bArr4 : arrayList) {
                System.arraycopy(bArr4, 0, bArr3, i9, bArr4.length);
                i9 += bArr4.length;
            }
            return bArr3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x007a, code lost:
        if (r2[r3] < 0) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int A() throws java.io.IOException {
        /*
            r9 = this;
            int r0 = r9.e
            int r1 = r9.c
            if (r1 != r0) goto L8
            goto L7c
        L8:
            byte[] r2 = r9.a
            int r3 = r0 + 1
            r0 = r2[r0]
            if (r0 < 0) goto L13
            r9.e = r3
            return r0
        L13:
            int r1 = r1 - r3
            r4 = 9
            if (r1 >= r4) goto L19
            goto L7c
        L19:
            int r1 = r3 + 1
            r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            long r3 = (long) r0
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 >= 0) goto L2d
            r5 = -128(0xffffffffffffff80, double:NaN)
        L29:
            long r2 = r3 ^ r5
            int r0 = (int) r2
            goto L82
        L2d:
            int r3 = r1 + 1
            r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            long r7 = (long) r0
            int r1 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r1 < 0) goto L3f
            r0 = 16256(0x3f80, double:8.0315E-320)
            long r0 = r0 ^ r7
            int r0 = (int) r0
        L3d:
            r1 = r3
            goto L82
        L3f:
            int r1 = r3 + 1
            r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            long r3 = (long) r0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 >= 0) goto L4f
            r5 = -2080896(0xffffffffffe03f80, double:NaN)
            goto L29
        L4f:
            int r3 = r1 + 1
            r1 = r2[r1]
            int r4 = r1 << 28
            r0 = r0 ^ r4
            long r4 = (long) r0
            r6 = 266354560(0xfe03f80, double:1.315966377E-315)
            long r4 = r4 ^ r6
            int r0 = (int) r4
            if (r1 >= 0) goto L3d
            int r1 = r3 + 1
            r3 = r2[r3]
            if (r3 >= 0) goto L82
            int r3 = r1 + 1
            r1 = r2[r1]
            if (r1 >= 0) goto L3d
            int r1 = r3 + 1
            r3 = r2[r3]
            if (r3 >= 0) goto L82
            int r3 = r1 + 1
            r1 = r2[r1]
            if (r1 >= 0) goto L3d
            int r1 = r3 + 1
            r2 = r2[r3]
            if (r2 >= 0) goto L82
        L7c:
            long r0 = r9.D()
            int r1 = (int) r0
            return r1
        L82:
            r9.e = r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.A():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b6, code lost:
        if (r2[r0] < 0) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long C() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 194
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.C():long");
    }

    long D() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte w = w();
            j |= (w & m8.DEL) << i;
            if ((w & cu2.MAX_POWER_OF_TWO) == 0) {
                return j;
            }
        }
        throw InvalidProtocolBufferException.malformedVarint();
    }

    public int E() throws IOException {
        return y();
    }

    public long F() throws IOException {
        return z();
    }

    public int G() throws IOException {
        return b(A());
    }

    public long H() throws IOException {
        return c(C());
    }

    public String I() throws IOException {
        int A = A();
        int i = this.c;
        int i2 = this.e;
        if (A > i - i2 || A <= 0) {
            return A == 0 ? "" : new String(x(A), "UTF-8");
        }
        String str = new String(this.a, i2, A, "UTF-8");
        this.e += A;
        return str;
    }

    public String J() throws IOException {
        byte[] x;
        int A = A();
        int i = this.e;
        if (A <= this.c - i && A > 0) {
            x = this.a;
            this.e = i + A;
        } else if (A == 0) {
            return "";
        } else {
            x = x(A);
            i = 0;
        }
        if (C8470h.f(x, i, i + A)) {
            return new String(x, i, A, "UTF-8");
        }
        throw InvalidProtocolBufferException.invalidUtf8();
    }

    public int K() throws IOException {
        if (f()) {
            this.g = 0;
            return 0;
        }
        int A = A();
        this.g = A;
        if (WireFormat.a(A) != 0) {
            return this.g;
        }
        throw InvalidProtocolBufferException.invalidTag();
    }

    public int L() throws IOException {
        return A();
    }

    public long M() throws IOException {
        return C();
    }

    public boolean P(int i, CodedOutputStream codedOutputStream) throws IOException {
        int b = WireFormat.b(i);
        if (b == 0) {
            long t = t();
            codedOutputStream.o0(i);
            codedOutputStream.z0(t);
            return true;
        } else if (b == 1) {
            long z = z();
            codedOutputStream.o0(i);
            codedOutputStream.V(z);
            return true;
        } else if (b == 2) {
            ByteString l = l();
            codedOutputStream.o0(i);
            codedOutputStream.P(l);
            return true;
        } else if (b == 3) {
            codedOutputStream.o0(i);
            Q(codedOutputStream);
            int c = WireFormat.c(WireFormat.a(i), 4);
            a(c);
            codedOutputStream.o0(c);
            return true;
        } else if (b != 4) {
            if (b == 5) {
                int y = y();
                codedOutputStream.o0(i);
                codedOutputStream.U(y);
                return true;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        } else {
            return false;
        }
    }

    public void Q(CodedOutputStream codedOutputStream) throws IOException {
        int K;
        do {
            K = K();
            if (K == 0) {
                return;
            }
        } while (P(K, codedOutputStream));
    }

    public void R(int i) throws IOException {
        int i2 = this.c;
        int i3 = this.e;
        if (i <= i2 - i3 && i >= 0) {
            this.e = i3 + i;
        } else {
            S(i);
        }
    }

    public void a(int i) throws InvalidProtocolBufferException {
        if (this.g != i) {
            throw InvalidProtocolBufferException.invalidEndTag();
        }
    }

    public int e() {
        int i = this.j;
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i - (this.i + this.e);
    }

    public boolean f() throws IOException {
        return this.e == this.c && !T(1);
    }

    public void i(int i) {
        this.j = i;
        N();
    }

    public int j(int i) throws InvalidProtocolBufferException {
        if (i >= 0) {
            int i2 = i + this.i + this.e;
            int i3 = this.j;
            if (i2 <= i3) {
                this.j = i2;
                N();
                return i3;
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        throw InvalidProtocolBufferException.negativeSize();
    }

    public boolean k() throws IOException {
        return C() != 0;
    }

    public ByteString l() throws IOException {
        int A = A();
        int i = this.c;
        int i2 = this.e;
        if (A > i - i2 || A <= 0) {
            if (A == 0) {
                return ByteString.EMPTY;
            }
            return new C8453e(x(A));
        }
        ByteString c8444b = (this.b && this.h) ? new C8444b(this.a, this.e, A) : ByteString.e(this.a, i2, A);
        this.e += A;
        return c8444b;
    }

    public double m() throws IOException {
        return Double.longBitsToDouble(z());
    }

    public int n() throws IOException {
        return A();
    }

    public int o() throws IOException {
        return y();
    }

    public long p() throws IOException {
        return z();
    }

    public float q() throws IOException {
        return Float.intBitsToFloat(y());
    }

    public void r(int i, MessageLite.Builder builder, C8447c c8447c) throws IOException {
        int i2 = this.k;
        if (i2 < this.l) {
            this.k = i2 + 1;
            builder.mergeFrom(this, c8447c);
            a(WireFormat.c(i, 4));
            this.k--;
            return;
        }
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }

    public int s() throws IOException {
        return A();
    }

    public long t() throws IOException {
        return C();
    }

    public <T extends MessageLite> T u(Parser<T> parser, C8447c c8447c) throws IOException {
        int A = A();
        if (this.k < this.l) {
            int j = j(A);
            this.k++;
            T parsePartialFrom = parser.parsePartialFrom(this, c8447c);
            a(0);
            this.k--;
            i(j);
            return parsePartialFrom;
        }
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }

    public void v(MessageLite.Builder builder, C8447c c8447c) throws IOException {
        int A = A();
        if (this.k < this.l) {
            int j = j(A);
            this.k++;
            builder.mergeFrom(this, c8447c);
            a(0);
            this.k--;
            i(j);
            return;
        }
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }

    public byte w() throws IOException {
        if (this.e == this.c) {
            O(1);
        }
        byte[] bArr = this.a;
        int i = this.e;
        this.e = i + 1;
        return bArr[i];
    }

    public int y() throws IOException {
        int i = this.e;
        if (this.c - i < 4) {
            O(4);
            i = this.e;
        }
        byte[] bArr = this.a;
        this.e = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public long z() throws IOException {
        int i = this.e;
        if (this.c - i < 8) {
            O(8);
            i = this.e;
        }
        byte[] bArr = this.a;
        this.e = i + 8;
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    private CodedInputStream(C8453e c8453e) {
        this.h = false;
        this.j = Integer.MAX_VALUE;
        this.l = 64;
        this.m = ConfigReporter.BIT_GETTER_IMP;
        this.n = null;
        this.a = c8453e.a;
        int y = c8453e.y();
        this.e = y;
        this.c = y + c8453e.size();
        this.i = -this.e;
        this.f = null;
        this.b = true;
    }
}
