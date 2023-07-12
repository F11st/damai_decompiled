package tb;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class e63 extends d83 {
    private static int a(c83 c83Var) {
        return c83Var.n();
    }

    public static int b(c83 c83Var, byte b, int i) {
        c83Var.q(2);
        e(c83Var, i);
        d(c83Var, b);
        return a(c83Var);
    }

    public static int c(c83 c83Var, byte[] bArr) {
        c83Var.h(1, bArr.length, 1);
        for (int length = bArr.length - 1; length >= 0; length--) {
            c83Var.d(bArr[length]);
        }
        return c83Var.a();
    }

    private static void d(c83 c83Var, byte b) {
        c83Var.f(0, b);
    }

    private static void e(c83 c83Var, int i) {
        c83Var.r(1, i);
    }
}
