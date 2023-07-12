package tb;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class df2 {
    public static final df2 FixedBehind;
    public static final df2 FixedFront;
    public static final df2 MatchLayout;
    @Deprecated
    public static final df2 Scale;
    public static final df2 Translate;
    public static final df2[] values;
    public final int a;
    public final boolean b;
    public final boolean c;

    static {
        df2 df2Var = new df2(0, true, false);
        Translate = df2Var;
        df2 df2Var2 = new df2(1, true, true);
        Scale = df2Var2;
        df2 df2Var3 = new df2(2, false, false);
        FixedBehind = df2Var3;
        df2 df2Var4 = new df2(3, true, false);
        FixedFront = df2Var4;
        df2 df2Var5 = new df2(4, true, false);
        MatchLayout = df2Var5;
        values = new df2[]{df2Var, df2Var2, df2Var3, df2Var4, df2Var5};
    }

    private df2(int i, boolean z, boolean z2) {
        this.a = i;
        this.b = z;
        this.c = z2;
    }
}
