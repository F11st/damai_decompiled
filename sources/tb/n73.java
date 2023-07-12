package tb;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class n73 {
    public a53 a;
    public com.efs.sdk.base.a.d.a b;
    public y53 c;
    public e83 d;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class a {
        private static final n73 a = new n73((byte) 0);

        public static /* synthetic */ n73 a() {
            return a;
        }
    }

    private n73() {
        this.a = new a53();
        this.c = new y53();
        this.d = new e83();
    }

    /* synthetic */ n73(byte b) {
        this();
    }

    public final o43 a(String str, int i) {
        o43 o43Var = new o43("efs_core", str, this.a.c);
        o43Var.a("cver", Integer.valueOf(i));
        return o43Var;
    }

    public final void b(int i) {
        com.efs.sdk.base.a.d.a aVar = this.b;
        if (aVar != null) {
            aVar.b(a("flow_limit", i));
        }
    }

    public final void c(int i, String str) {
        if (this.b != null || com.efs.sdk.base.a.d.a.a().d) {
            o43 a2 = a("flow_limit_type", i);
            a2.a("code", str);
            this.b.b(a2);
        }
    }

    public final void d(String str, String str2, String str3) {
        this.d.b(str, str2, str3);
    }
}
