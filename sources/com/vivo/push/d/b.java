package com.vivo.push.d;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class b extends com.vivo.push.l {
    /* JADX INFO: Access modifiers changed from: package-private */
    public b(com.vivo.push.o oVar) {
        super(oVar);
    }

    @Override // com.vivo.push.l
    protected final void a(com.vivo.push.o oVar) {
        boolean b;
        com.vivo.push.model.b a = com.vivo.push.util.t.a(this.a);
        try {
            if (((com.vivo.push.b.d) oVar).d()) {
                b = f.a(this.a);
            } else {
                b = f.b(this.a);
            }
            if (b) {
                com.vivo.push.model.b a2 = com.vivo.push.util.t.a(this.a);
                if (a == null || a2 == null || a2.a() == null || !a2.a().equals(a.a())) {
                    if (a != null && a.a() != null) {
                        com.vivo.push.a.a.a(this.a, a.a(), new com.vivo.push.b.y(a.a()));
                    }
                    if (a2 == null || a2.a() == null) {
                        return;
                    }
                    com.vivo.push.a.a.a(this.a, a2.a(), new com.vivo.push.b.f());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
