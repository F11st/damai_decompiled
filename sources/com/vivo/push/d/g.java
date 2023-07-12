package com.vivo.push.d;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class g extends z {
    /* JADX INFO: Access modifiers changed from: package-private */
    public g(com.vivo.push.o oVar) {
        super(oVar);
    }

    @Override // com.vivo.push.l
    protected final void a(com.vivo.push.o oVar) {
        com.vivo.push.util.p.d("OnClearCacheTask", "delete push info " + this.a.getPackageName());
        com.vivo.push.util.y.b(this.a).a();
    }
}
