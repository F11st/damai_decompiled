package tb;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class r53 extends d83 {
    private static int a(c83 c83Var) {
        return c83Var.n();
    }

    public static int b(c83 c83Var, int i, byte b, int i2, int i3) {
        c83Var.q(4);
        h(c83Var, i3);
        g(c83Var, i2);
        e(c83Var, i);
        d(c83Var, b);
        return a(c83Var);
    }

    public static int c(c83 c83Var, int[] iArr) {
        c83Var.h(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            c83Var.e(iArr[length]);
        }
        return c83Var.a();
    }

    private static void d(c83 c83Var, byte b) {
        c83Var.f(1, b);
    }

    private static void e(c83 c83Var, int i) {
        c83Var.r(0, i);
    }

    public static int f(c83 c83Var, int[] iArr) {
        c83Var.h(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            c83Var.e(iArr[length]);
        }
        return c83Var.a();
    }

    private static void g(c83 c83Var, int i) {
        c83Var.r(2, i);
    }

    private static void h(c83 c83Var, int i) {
        c83Var.r(3, i);
    }
}
