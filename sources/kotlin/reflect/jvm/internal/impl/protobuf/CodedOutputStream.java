package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import tb.p81;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class CodedOutputStream {
    private final byte[] a;
    private final int b;
    private final OutputStream e;
    private int d = 0;
    private int c = 0;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static class OutOfSpaceException extends IOException {
        OutOfSpaceException() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    private CodedOutputStream(OutputStream outputStream, byte[] bArr) {
        this.e = outputStream;
        this.a = bArr;
        this.b = bArr.length;
    }

    public static int A(int i, long j) {
        return D(i) + B(j);
    }

    public static int B(long j) {
        return w(H(j));
    }

    public static int C(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return v(bytes.length) + bytes.length;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported.", e);
        }
    }

    public static int D(int i) {
        return v(WireFormat.c(i, 0));
    }

    public static int E(int i) {
        return v(i);
    }

    public static int F(long j) {
        return w(j);
    }

    public static int G(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public static long H(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static CodedOutputStream J(OutputStream outputStream, int i) {
        return new CodedOutputStream(outputStream, new byte[i]);
    }

    private void K() throws IOException {
        OutputStream outputStream = this.e;
        if (outputStream != null) {
            outputStream.write(this.a, 0, this.c);
            this.c = 0;
            return;
        }
        throw new OutOfSpaceException();
    }

    public static int a(int i, boolean z) {
        return D(i) + b(z);
    }

    public static int b(boolean z) {
        return 1;
    }

    public static int c(byte[] bArr) {
        return v(bArr.length) + bArr.length;
    }

    public static int d(int i, ByteString byteString) {
        return D(i) + e(byteString);
    }

    public static int e(ByteString byteString) {
        return v(byteString.size()) + byteString.size();
    }

    public static int f(int i, double d) {
        return D(i) + g(d);
    }

    public static int g(double d) {
        return 8;
    }

    public static int h(int i, int i2) {
        return D(i) + i(i2);
    }

    public static int i(int i) {
        return p(i);
    }

    public static int j(int i) {
        return 4;
    }

    public static int k(long j) {
        return 8;
    }

    public static int l(int i, float f) {
        return D(i) + m(f);
    }

    public static int m(float f) {
        return 4;
    }

    public static int n(MessageLite messageLite) {
        return messageLite.getSerializedSize();
    }

    public static int o(int i, int i2) {
        return D(i) + p(i2);
    }

    public static int p(int i) {
        if (i >= 0) {
            return v(i);
        }
        return 10;
    }

    public static int q(long j) {
        return w(j);
    }

    public static int r(p81 p81Var) {
        int b = p81Var.b();
        return v(b) + b;
    }

    public static int s(int i, MessageLite messageLite) {
        return D(i) + t(messageLite);
    }

    public static int t(MessageLite messageLite) {
        int serializedSize = messageLite.getSerializedSize();
        return v(serializedSize) + serializedSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int u(int i) {
        if (i > 4096) {
            return 4096;
        }
        return i;
    }

    public static int v(int i) {
        if ((i & com.alipay.sdk.m.n.a.g) == 0) {
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

    public static int w(long j) {
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

    public static int x(int i) {
        return 4;
    }

    public static int y(long j) {
        return 8;
    }

    public static int z(int i) {
        return v(G(i));
    }

    public void I() throws IOException {
        if (this.e != null) {
            K();
        }
    }

    public void L(int i, boolean z) throws IOException {
        w0(i, 0);
        M(z);
    }

    public void M(boolean z) throws IOException {
        h0(z ? 1 : 0);
    }

    public void N(byte[] bArr) throws IOException {
        o0(bArr.length);
        k0(bArr);
    }

    public void O(int i, ByteString byteString) throws IOException {
        w0(i, 2);
        P(byteString);
    }

    public void P(ByteString byteString) throws IOException {
        o0(byteString.size());
        i0(byteString);
    }

    public void Q(int i, double d) throws IOException {
        w0(i, 1);
        R(d);
    }

    public void R(double d) throws IOException {
        n0(Double.doubleToRawLongBits(d));
    }

    public void S(int i, int i2) throws IOException {
        w0(i, 0);
        T(i2);
    }

    public void T(int i) throws IOException {
        b0(i);
    }

    public void U(int i) throws IOException {
        m0(i);
    }

    public void V(long j) throws IOException {
        n0(j);
    }

    public void W(int i, float f) throws IOException {
        w0(i, 5);
        X(f);
    }

    public void X(float f) throws IOException {
        m0(Float.floatToRawIntBits(f));
    }

    public void Y(int i, MessageLite messageLite) throws IOException {
        w0(i, 3);
        Z(messageLite);
        w0(i, 4);
    }

    public void Z(MessageLite messageLite) throws IOException {
        messageLite.writeTo(this);
    }

    public void a0(int i, int i2) throws IOException {
        w0(i, 0);
        b0(i2);
    }

    public void b0(int i) throws IOException {
        if (i >= 0) {
            o0(i);
        } else {
            p0(i);
        }
    }

    public void c0(long j) throws IOException {
        p0(j);
    }

    public void d0(int i, MessageLite messageLite) throws IOException {
        w0(i, 2);
        e0(messageLite);
    }

    public void e0(MessageLite messageLite) throws IOException {
        o0(messageLite.getSerializedSize());
        messageLite.writeTo(this);
    }

    public void f0(int i, MessageLite messageLite) throws IOException {
        w0(1, 3);
        x0(2, i);
        d0(3, messageLite);
        w0(1, 4);
    }

    public void g0(byte b) throws IOException {
        if (this.c == this.b) {
            K();
        }
        byte[] bArr = this.a;
        int i = this.c;
        this.c = i + 1;
        bArr[i] = b;
        this.d++;
    }

    public void h0(int i) throws IOException {
        g0((byte) i);
    }

    public void i0(ByteString byteString) throws IOException {
        j0(byteString, 0, byteString.size());
    }

    public void j0(ByteString byteString, int i, int i2) throws IOException {
        int i3 = this.b;
        int i4 = this.c;
        if (i3 - i4 >= i2) {
            byteString.g(this.a, i, i4, i2);
            this.c += i2;
            this.d += i2;
            return;
        }
        int i5 = i3 - i4;
        byteString.g(this.a, i, i4, i5);
        int i6 = i + i5;
        int i7 = i2 - i5;
        this.c = this.b;
        this.d += i5;
        K();
        if (i7 <= this.b) {
            byteString.g(this.a, i6, 0, i7);
            this.c = i7;
        } else {
            byteString.u(this.e, i6, i7);
        }
        this.d += i7;
    }

    public void k0(byte[] bArr) throws IOException {
        l0(bArr, 0, bArr.length);
    }

    public void l0(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.b;
        int i4 = this.c;
        if (i3 - i4 >= i2) {
            System.arraycopy(bArr, i, this.a, i4, i2);
            this.c += i2;
            this.d += i2;
            return;
        }
        int i5 = i3 - i4;
        System.arraycopy(bArr, i, this.a, i4, i5);
        int i6 = i + i5;
        int i7 = i2 - i5;
        this.c = this.b;
        this.d += i5;
        K();
        if (i7 <= this.b) {
            System.arraycopy(bArr, i6, this.a, 0, i7);
            this.c = i7;
        } else {
            this.e.write(bArr, i6, i7);
        }
        this.d += i7;
    }

    public void m0(int i) throws IOException {
        h0(i & 255);
        h0((i >> 8) & 255);
        h0((i >> 16) & 255);
        h0((i >> 24) & 255);
    }

    public void n0(long j) throws IOException {
        h0(((int) j) & 255);
        h0(((int) (j >> 8)) & 255);
        h0(((int) (j >> 16)) & 255);
        h0(((int) (j >> 24)) & 255);
        h0(((int) (j >> 32)) & 255);
        h0(((int) (j >> 40)) & 255);
        h0(((int) (j >> 48)) & 255);
        h0(((int) (j >> 56)) & 255);
    }

    public void o0(int i) throws IOException {
        while ((i & com.alipay.sdk.m.n.a.g) != 0) {
            h0((i & 127) | 128);
            i >>>= 7;
        }
        h0(i);
    }

    public void p0(long j) throws IOException {
        while (((-128) & j) != 0) {
            h0((((int) j) & 127) | 128);
            j >>>= 7;
        }
        h0((int) j);
    }

    public void q0(int i) throws IOException {
        m0(i);
    }

    public void r0(long j) throws IOException {
        n0(j);
    }

    public void s0(int i) throws IOException {
        o0(G(i));
    }

    public void t0(int i, long j) throws IOException {
        w0(i, 0);
        u0(j);
    }

    public void u0(long j) throws IOException {
        p0(H(j));
    }

    public void v0(String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        o0(bytes.length);
        k0(bytes);
    }

    public void w0(int i, int i2) throws IOException {
        o0(WireFormat.c(i, i2));
    }

    public void x0(int i, int i2) throws IOException {
        w0(i, 0);
        y0(i2);
    }

    public void y0(int i) throws IOException {
        o0(i);
    }

    public void z0(long j) throws IOException {
        p0(j);
    }
}
