package tb;

import com.efs.sdk.base.a.d.C4786a;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class n73 {
    public a53 a;
    public C4786a b;
    public y53 c;
    public e83 d;

    /* compiled from: Taobao */
    /* renamed from: tb.n73$a */
    /* loaded from: classes10.dex */
    public static class C9462a {
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
        C4786a c4786a = this.b;
        if (c4786a != null) {
            c4786a.b(a("flow_limit", i));
        }
    }

    public final void c(int i, String str) {
        if (this.b != null || C4786a.a().d) {
            o43 a = a("flow_limit_type", i);
            a.a("code", str);
            this.b.b(a);
        }
    }

    public final void d(String str, String str2, String str3) {
        this.d.b(str, str2, str3);
    }
}
