package tb;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class lc {
    public int b = 0;
    public int[] a = new int[1];

    private void d(int i) {
        if (i > (this.a.length << 5)) {
            int[] h = h(i);
            int[] iArr = this.a;
            System.arraycopy(iArr, 0, h, 0, iArr.length);
            this.a = h;
        }
    }

    private static int[] h(int i) {
        return new int[(i + 31) >> 5];
    }

    public void a(boolean z) {
        d(this.b + 1);
        if (z) {
            int[] iArr = this.a;
            int i = this.b;
            int i2 = i >> 5;
            iArr[i2] = (1 << (i & 31)) | iArr[i2];
        }
        this.b++;
    }

    public void b(lc lcVar) {
        int f = lcVar.f();
        d(this.b + f);
        for (int i = 0; i < f; i++) {
            a(lcVar.e(i));
        }
    }

    public void c(int i, int i2) {
        if (i2 >= 0 && i2 <= 32) {
            d(this.b + i2);
            while (i2 > 0) {
                boolean z = true;
                if (((i >> (i2 - 1)) & 1) != 1) {
                    z = false;
                }
                a(z);
                i2--;
            }
            return;
        }
        throw new IllegalArgumentException("Num bits must be between 0 and 32");
    }

    public boolean e(int i) {
        return ((1 << (i & 31)) & this.a[i >> 5]) != 0;
    }

    public int f() {
        return this.b;
    }

    public int g() {
        return (this.b + 7) >> 3;
    }

    public void i(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = 0;
            for (int i6 = 0; i6 < 8; i6++) {
                if (e(i)) {
                    i5 |= 1 << (7 - i6);
                }
                i++;
            }
            bArr[i2 + i4] = (byte) i5;
        }
    }

    public void j(lc lcVar) {
        if (this.a.length != lcVar.a.length) {
            throw new IllegalArgumentException("Sizes don't match");
        }
        int i = 0;
        while (true) {
            int[] iArr = this.a;
            if (i >= iArr.length) {
                return;
            }
            iArr[i] = iArr[i] ^ lcVar.a[i];
            i++;
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(this.b);
        for (int i = 0; i < this.b; i++) {
            if ((i & 7) == 0) {
                stringBuffer.append(' ');
            }
            stringBuffer.append(e(i) ? 'X' : '.');
        }
        return stringBuffer.toString();
    }
}
