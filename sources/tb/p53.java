package tb;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class p53 extends d83 {
    private static int a(c83 c83Var) {
        return c83Var.n();
    }

    public static int b(c83 c83Var, int i, int i2, int i3) {
        c83Var.q(3);
        h(c83Var, i3);
        g(c83Var, i2);
        e(c83Var, i);
        return a(c83Var);
    }

    public static int c(c83 c83Var, byte[] bArr) {
        c83Var.h(1, bArr.length, 1);
        for (int length = bArr.length - 1; length >= 0; length--) {
            c83Var.d(bArr[length]);
        }
        return c83Var.a();
    }

    public static int d(c83 c83Var, int[] iArr) {
        c83Var.h(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            c83Var.e(iArr[length]);
        }
        return c83Var.a();
    }

    private static void e(c83 c83Var, int i) {
        c83Var.r(0, i);
    }

    public static int f(c83 c83Var, byte[] bArr) {
        c83Var.h(1, bArr.length, 1);
        for (int length = bArr.length - 1; length >= 0; length--) {
            c83Var.d(bArr[length]);
        }
        return c83Var.a();
    }

    private static void g(c83 c83Var, int i) {
        c83Var.r(1, i);
    }

    private static void h(c83 c83Var, int i) {
        c83Var.r(2, i);
    }
}
