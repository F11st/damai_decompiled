package com.vivo.push.d;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class ai extends com.vivo.push.l {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(com.vivo.push.o oVar) {
        super(oVar);
    }

    @Override // com.vivo.push.l
    protected final void a(com.vivo.push.o oVar) {
        com.vivo.push.b.c cVar = (com.vivo.push.b.c) oVar;
        com.vivo.push.model.b a = com.vivo.push.util.t.a(this.a);
        if (a == null) {
            com.vivo.push.e.a().a(cVar.h(), 1005, new Object[0]);
            return;
        }
        String a2 = a.a();
        if (a.c()) {
            com.vivo.push.e.a().a(cVar.h(), 1004, new Object[0]);
            oVar = new com.vivo.push.b.e();
        } else {
            int a3 = com.vivo.push.util.s.a(cVar);
            if (a3 != 0) {
                com.vivo.push.e.a().a(cVar.h(), a3, new Object[0]);
                return;
            }
        }
        com.vivo.push.a.a.a(this.a, a2, oVar);
    }
}
