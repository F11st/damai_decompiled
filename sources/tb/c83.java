package tb;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.util.Arrays;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class c83 {
    static final Charset o = Charset.forName("UTF-8");
    static final /* synthetic */ boolean p = true;
    ByteBuffer a;
    int b;
    int h;
    ByteBuffer n;
    int c = 1;
    int[] d = null;
    int e = 0;
    boolean f = false;
    boolean g = false;
    int[] i = new int[16];
    int j = 0;
    int k = 0;
    boolean l = false;
    CharsetEncoder m = o.newEncoder();

    public c83(ByteBuffer byteBuffer) {
        c(byteBuffer);
    }

    private int A() {
        return this.a.capacity() - this.b;
    }

    private static ByteBuffer B(int i) {
        ByteBuffer allocate = ByteBuffer.allocate(i);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        return allocate;
    }

    private byte[] C(int i, int i2) {
        D();
        byte[] bArr = new byte[i2];
        this.a.position(i);
        this.a.get(bArr);
        return bArr;
    }

    private void D() {
        if (!this.g) {
            throw new AssertionError("FlatBuffers: you can only access the serialized buffer after it has been finished by FlatBufferBuilder.finish().");
        }
    }

    private void E(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            ByteBuffer byteBuffer = this.a;
            int i3 = this.b - 1;
            this.b = i3;
            byteBuffer.put(i3, (byte) 0);
        }
    }

    private void F() {
        if (this.f) {
            throw new AssertionError("FlatBuffers: object serialization must not be nested.");
        }
    }

    private void G(int i) {
        ByteBuffer byteBuffer = this.a;
        int i2 = this.b - 4;
        this.b = i2;
        byteBuffer.putInt(i2, i);
    }

    private void H(int i) {
        x(4, 0);
        G(i);
    }

    private void I(int i) {
        this.d[i] = A();
    }

    private void k(long j) {
        ByteBuffer byteBuffer = this.a;
        int i = this.b - 8;
        this.b = i;
        byteBuffer.putLong(i, j);
    }

    private void l(short s) {
        ByteBuffer byteBuffer = this.a;
        int i = this.b - 2;
        this.b = i;
        byteBuffer.putShort(i, s);
    }

    private static ByteBuffer o(ByteBuffer byteBuffer) {
        int capacity = byteBuffer.capacity();
        if (((-1073741824) & capacity) == 0) {
            int i = capacity << 1;
            byteBuffer.position(0);
            ByteBuffer B = B(i);
            B.position(i - capacity);
            B.put(byteBuffer);
            return B;
        }
        throw new AssertionError("FlatBuffers: cannot grow buffer beyond 2 gigabytes.");
    }

    private void p(byte b) {
        ByteBuffer byteBuffer = this.a;
        int i = this.b - 1;
        this.b = i;
        byteBuffer.put(i, b);
    }

    private void s(long j) {
        x(8, 0);
        k(j);
    }

    private void t(short s) {
        x(2, 0);
        l(s);
    }

    private void u(boolean z) {
        ByteBuffer byteBuffer = this.a;
        int i = this.b - 1;
        this.b = i;
        byteBuffer.put(i, z ? (byte) 1 : (byte) 0);
    }

    private int v(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        d((byte) 0);
        h(1, remaining, 1);
        ByteBuffer byteBuffer2 = this.a;
        int i = this.b - remaining;
        this.b = i;
        byteBuffer2.position(i);
        this.a.put(byteBuffer);
        return a();
    }

    private void x(int i, int i2) {
        if (i > this.c) {
            this.c = i;
        }
        int i3 = ((~((this.a.capacity() - this.b) + i2)) + 1) & (i - 1);
        while (this.b < i3 + i + i2) {
            int capacity = this.a.capacity();
            ByteBuffer o2 = o(this.a);
            this.a = o2;
            this.b += o2.capacity() - capacity;
        }
        E(i3);
    }

    private void y(boolean z) {
        x(1, 0);
        u(z);
    }

    public final int a() {
        if (this.f) {
            this.f = false;
            G(this.k);
            return A();
        }
        throw new AssertionError("FlatBuffers: endVector called without startVector");
    }

    public int b(CharSequence charSequence) {
        int length = (int) (charSequence.length() * this.m.maxBytesPerChar());
        ByteBuffer byteBuffer = this.n;
        if (byteBuffer == null || byteBuffer.capacity() < length) {
            this.n = ByteBuffer.allocate(Math.max(128, length));
        }
        this.n.clear();
        CoderResult encode = this.m.encode(charSequence instanceof CharBuffer ? (CharBuffer) charSequence : CharBuffer.wrap(charSequence), this.n, true);
        if (encode.isError()) {
            try {
                encode.throwException();
            } catch (CharacterCodingException e) {
                throw new Error(e);
            }
        }
        this.n.flip();
        return v(this.n);
    }

    public final c83 c(ByteBuffer byteBuffer) {
        this.a = byteBuffer;
        byteBuffer.clear();
        this.a.order(ByteOrder.LITTLE_ENDIAN);
        this.c = 1;
        this.b = this.a.capacity();
        this.e = 0;
        this.f = false;
        this.g = false;
        this.h = 0;
        this.j = 0;
        this.k = 0;
        return this;
    }

    public final void d(byte b) {
        x(1, 0);
        p(b);
    }

    public final void e(int i) {
        x(4, 0);
        if (!p && i > A()) {
            throw new AssertionError();
        }
        G((A() - i) + 4);
    }

    public final void f(int i, byte b) {
        if (this.l || b != 0) {
            d(b);
            I(i);
        }
    }

    public final void g(int i, int i2) {
        if (this.l || i2 != 0) {
            H(i2);
            I(i);
        }
    }

    public final void h(int i, int i2, int i3) {
        F();
        this.k = i2;
        int i4 = i * i2;
        x(4, i4);
        x(i3, i4);
        this.f = true;
    }

    public final void i(int i, long j) {
        if (this.l || j != 0) {
            s(j);
            I(i);
        }
    }

    public final void j(int i, short s) {
        if (this.l || s != 0) {
            t(s);
            I(i);
        }
    }

    public final void m(boolean z) {
        if (this.l || z) {
            y(z);
            I(0);
        }
    }

    public final int n() {
        int i;
        int i2;
        if (this.d == null || !this.f) {
            throw new AssertionError("FlatBuffers: endObject called without startObject");
        }
        H(0);
        int A = A();
        for (int i3 = this.e - 1; i3 >= 0; i3--) {
            int[] iArr = this.d;
            t((short) (iArr[i3] != 0 ? A - iArr[i3] : 0));
        }
        t((short) (A - this.h));
        t((short) ((this.e + 2) * 2));
        int i4 = 0;
        loop1: while (true) {
            if (i4 >= this.j) {
                i = 0;
                break;
            }
            int capacity = this.a.capacity() - this.i[i4];
            int i5 = this.b;
            short s = this.a.getShort(capacity);
            if (s == this.a.getShort(i5)) {
                while (i2 < s) {
                    i2 = this.a.getShort(capacity + i2) == this.a.getShort(i5 + i2) ? i2 + 2 : 2;
                }
                i = this.i[i4];
                break loop1;
            }
            i4++;
        }
        if (i != 0) {
            int capacity2 = this.a.capacity() - A;
            this.b = capacity2;
            this.a.putInt(capacity2, i - A);
        } else {
            int i6 = this.j;
            int[] iArr2 = this.i;
            if (i6 == iArr2.length) {
                this.i = Arrays.copyOf(iArr2, i6 * 2);
            }
            int[] iArr3 = this.i;
            int i7 = this.j;
            this.j = i7 + 1;
            iArr3[i7] = A();
            ByteBuffer byteBuffer = this.a;
            byteBuffer.putInt(byteBuffer.capacity() - A, A() - A);
        }
        this.f = false;
        return A;
    }

    public final void q(int i) {
        F();
        int[] iArr = this.d;
        if (iArr == null || iArr.length < i) {
            this.d = new int[i];
        }
        this.e = i;
        Arrays.fill(this.d, 0, i, 0);
        this.f = true;
        this.h = A();
    }

    public final void r(int i, int i2) {
        if (this.l || i2 != 0) {
            e(i2);
            I(i);
        }
    }

    public final void w(int i) {
        x(this.c, 4);
        e(i);
        this.a.position(this.b);
        this.g = true;
    }

    public final byte[] z() {
        return C(this.b, this.a.capacity() - this.b);
    }
}
