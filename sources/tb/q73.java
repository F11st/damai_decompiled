package tb;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class q73 extends p33 {
    @Override // tb.p33
    public final void a(j43 j43Var) {
        Double d;
        com.efs.sdk.base.a.c.a.c a = com.efs.sdk.base.a.c.a.c.a();
        String str = j43Var.a.a;
        com.efs.sdk.base.a.c.a.a aVar = a.e;
        if (com.efs.sdk.base.a.c.a.c.a.nextDouble() * 100.0d <= ((!aVar.e.containsKey(str) || (d = aVar.e.get(str)) == null) ? 100.0d : d.doubleValue())) {
            b(j43Var);
        }
    }
}
