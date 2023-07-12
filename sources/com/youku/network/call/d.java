package com.youku.network.call;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class d implements com.youku.network.a {
    private com.youku.network.a a;
    private e b;

    public d(com.youku.network.a aVar, e eVar) {
        this.a = aVar;
        this.b = eVar;
    }

    private void b(com.youku.network.d dVar) {
        this.b.a(dVar);
    }

    @Override // com.youku.network.a
    public void a(com.youku.network.d dVar) {
        b(dVar);
        com.youku.network.a aVar = this.a;
        if (aVar != null) {
            aVar.a(dVar);
        }
    }
}
