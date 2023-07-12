package tb;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class l63 extends d83 {
    private static int a(c83 c83Var) {
        return c83Var.n();
    }

    public static int b(c83 c83Var, int i) {
        c83Var.q(1);
        d(c83Var, i);
        return a(c83Var);
    }

    public static int c(c83 c83Var, int[] iArr) {
        c83Var.h(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            c83Var.e(iArr[length]);
        }
        return c83Var.a();
    }

    private static void d(c83 c83Var, int i) {
        c83Var.r(0, i);
    }
}
