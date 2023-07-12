package tb;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class qq {
    public static int f = 32768;
    public static int g = 10000;
    public static int h = 15000;
    public static boolean i = true;
    public int a;
    public int b;
    private l41 c;
    private int d;
    private int e;

    public qq(id2 id2Var) {
        this.a = 3;
        this.b = 3;
        this.c = id2Var.e;
        int i2 = id2Var.f.l;
        if (i2 > 0) {
            this.a = i2;
            this.b = i2;
        }
    }

    public int a() {
        return this.d;
    }

    public int b() {
        return g;
    }

    public int c() {
        long j = this.c.b;
        if (0 == j) {
            return h * 10;
        }
        int i2 = (int) (j / 10);
        int i3 = h;
        return i2 > i3 ? i2 : i3;
    }

    public boolean d() {
        return this.a - this.d == 1;
    }

    public boolean e() {
        return this.b - this.e == 1;
    }
}
