package tb;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class l80 {
    public static final l80 CodeExact;
    public static final l80 CodeExactUnNotify;
    public static final l80 DeadLock;
    public static final l80 DeadLockUnNotify;
    public static final l80 Default;
    public static final l80 DefaultUnNotify;
    public static final l80 XmlExact;
    public static final l80 XmlExactUnNotify;
    public static final l80 XmlLayout;
    public static final l80 XmlLayoutUnNotify;
    public static final l80 XmlWrap;
    public static final l80 XmlWrapUnNotify;
    public static final l80[] values;
    public final int a;
    public final boolean b;

    static {
        l80 l80Var = new l80(0, false);
        DefaultUnNotify = l80Var;
        l80 l80Var2 = new l80(1, true);
        Default = l80Var2;
        l80 l80Var3 = new l80(2, false);
        XmlWrapUnNotify = l80Var3;
        l80 l80Var4 = new l80(3, true);
        XmlWrap = l80Var4;
        l80 l80Var5 = new l80(4, false);
        XmlExactUnNotify = l80Var5;
        l80 l80Var6 = new l80(5, true);
        XmlExact = l80Var6;
        l80 l80Var7 = new l80(6, false);
        XmlLayoutUnNotify = l80Var7;
        l80 l80Var8 = new l80(7, true);
        XmlLayout = l80Var8;
        l80 l80Var9 = new l80(8, false);
        CodeExactUnNotify = l80Var9;
        l80 l80Var10 = new l80(9, true);
        CodeExact = l80Var10;
        l80 l80Var11 = new l80(10, false);
        DeadLockUnNotify = l80Var11;
        l80 l80Var12 = new l80(10, true);
        DeadLock = l80Var12;
        values = new l80[]{l80Var, l80Var2, l80Var3, l80Var4, l80Var5, l80Var6, l80Var7, l80Var8, l80Var9, l80Var10, l80Var11, l80Var12};
    }

    private l80(int i, boolean z) {
        this.a = i;
        this.b = z;
    }

    public boolean a(l80 l80Var) {
        int i = this.a;
        int i2 = l80Var.a;
        return i < i2 || ((!this.b || CodeExact == this) && i == i2);
    }

    public l80 b() {
        return !this.b ? values[this.a + 1] : this;
    }

    public l80 c() {
        if (this.b) {
            l80 l80Var = values[this.a - 1];
            return !l80Var.b ? l80Var : DefaultUnNotify;
        }
        return this;
    }
}
