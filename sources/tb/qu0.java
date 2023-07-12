package tb;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class qu0 {
    private final float[] a;
    private final int[] b;

    public qu0(float[] fArr, int[] iArr) {
        this.a = fArr;
        this.b = iArr;
    }

    public int[] a() {
        return this.b;
    }

    public float[] b() {
        return this.a;
    }

    public int c() {
        return this.b.length;
    }

    public void d(qu0 qu0Var, qu0 qu0Var2, float f) {
        if (qu0Var.b.length == qu0Var2.b.length) {
            for (int i = 0; i < qu0Var.b.length; i++) {
                this.a[i] = eg1.k(qu0Var.a[i], qu0Var2.a[i], f);
                this.b[i] = it0.c(f, qu0Var.b[i], qu0Var2.b[i]);
            }
            return;
        }
        throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + qu0Var.b.length + " vs " + qu0Var2.b.length + jn1.BRACKET_END_STR);
    }
}
