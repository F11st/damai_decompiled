package tb;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class xp0 {
    private final wp0 a;
    private final int[] b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public xp0(wp0 wp0Var, int[] iArr) {
        if (iArr != null && iArr.length != 0) {
            this.a = wp0Var;
            int length = iArr.length;
            int i = 1;
            if (length > 1 && iArr[0] == 0) {
                while (i < length && iArr[i] == 0) {
                    i++;
                }
                if (i == length) {
                    this.b = wp0Var.d().b;
                    return;
                }
                int[] iArr2 = new int[length - i];
                this.b = iArr2;
                System.arraycopy(iArr, i, iArr2, 0, iArr2.length);
                return;
            }
            this.b = iArr;
            return;
        }
        throw new IllegalArgumentException();
    }

    xp0 a(xp0 xp0Var) {
        if (this.a.equals(xp0Var.a)) {
            if (f()) {
                return xp0Var;
            }
            if (xp0Var.f()) {
                return this;
            }
            int[] iArr = this.b;
            int[] iArr2 = xp0Var.b;
            if (iArr.length <= iArr2.length) {
                iArr = iArr2;
                iArr2 = iArr;
            }
            int[] iArr3 = new int[iArr.length];
            int length = iArr.length - iArr2.length;
            System.arraycopy(iArr, 0, iArr3, 0, length);
            for (int i = length; i < iArr.length; i++) {
                iArr3[i] = wp0.a(iArr2[i - length], iArr[i]);
            }
            return new xp0(this.a, iArr3);
        }
        throw new IllegalArgumentException("GF256Polys do not have same GF256 field");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public xp0[] b(xp0 xp0Var) {
        if (this.a.equals(xp0Var.a)) {
            if (!xp0Var.f()) {
                xp0 d = this.a.d();
                int e = this.a.e(xp0Var.c(xp0Var.e()));
                xp0 xp0Var2 = this;
                while (xp0Var2.e() >= xp0Var.e() && !xp0Var2.f()) {
                    int e2 = xp0Var2.e() - xp0Var.e();
                    int g = this.a.g(xp0Var2.c(xp0Var2.e()), e);
                    xp0 h = xp0Var.h(e2, g);
                    d = d.a(this.a.b(e2, g));
                    xp0Var2 = xp0Var2.a(h);
                }
                return new xp0[]{d, xp0Var2};
            }
            throw new IllegalArgumentException("Divide by 0");
        }
        throw new IllegalArgumentException("GF256Polys do not have same GF256 field");
    }

    int c(int i) {
        int[] iArr = this.b;
        return iArr[(iArr.length - 1) - i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] d() {
        return this.b;
    }

    int e() {
        return this.b.length - 1;
    }

    boolean f() {
        return this.b[0] == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public xp0 g(xp0 xp0Var) {
        if (this.a.equals(xp0Var.a)) {
            if (!f() && !xp0Var.f()) {
                int[] iArr = this.b;
                int length = iArr.length;
                int[] iArr2 = xp0Var.b;
                int length2 = iArr2.length;
                int[] iArr3 = new int[(length + length2) - 1];
                for (int i = 0; i < length; i++) {
                    int i2 = iArr[i];
                    for (int i3 = 0; i3 < length2; i3++) {
                        int i4 = i + i3;
                        iArr3[i4] = wp0.a(iArr3[i4], this.a.g(i2, iArr2[i3]));
                    }
                }
                return new xp0(this.a, iArr3);
            }
            return this.a.d();
        }
        throw new IllegalArgumentException("GF256Polys do not have same GF256 field");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public xp0 h(int i, int i2) {
        if (i >= 0) {
            if (i2 == 0) {
                return this.a.d();
            }
            int length = this.b.length;
            int[] iArr = new int[i + length];
            for (int i3 = 0; i3 < length; i3++) {
                iArr[i3] = this.a.g(this.b[i3], i2);
            }
            return new xp0(this.a, iArr);
        }
        throw new IllegalArgumentException();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(e() * 8);
        for (int e = e(); e >= 0; e--) {
            int c = c(e);
            if (c != 0) {
                if (c < 0) {
                    stringBuffer.append(" - ");
                    c = -c;
                } else if (stringBuffer.length() > 0) {
                    stringBuffer.append(" + ");
                }
                if (e == 0 || c != 1) {
                    int f = this.a.f(c);
                    if (f == 0) {
                        stringBuffer.append('1');
                    } else if (f == 1) {
                        stringBuffer.append('a');
                    } else {
                        stringBuffer.append("a^");
                        stringBuffer.append(f);
                    }
                }
                if (e != 0) {
                    if (e == 1) {
                        stringBuffer.append('x');
                    } else {
                        stringBuffer.append("x^");
                        stringBuffer.append(e);
                    }
                }
            }
        }
        return stringBuffer.toString();
    }
}
