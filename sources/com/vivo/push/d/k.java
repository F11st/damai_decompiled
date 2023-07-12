package com.vivo.push.d;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class k extends z {
    /* JADX INFO: Access modifiers changed from: package-private */
    public k(com.vivo.push.o oVar) {
        super(oVar);
    }

    @Override // com.vivo.push.l
    protected final void a(com.vivo.push.o oVar) {
        com.vivo.push.b.l lVar = (com.vivo.push.b.l) oVar;
        int d = lVar.d();
        int e = lVar.e();
        com.vivo.push.util.w.b().a("key_dispatch_environment", d);
        com.vivo.push.util.w.b().a("key_dispatch_area", e);
    }
}
