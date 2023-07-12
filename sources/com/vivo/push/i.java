package com.vivo.push;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class i implements IPushActionListener {
    final /* synthetic */ e a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(e eVar) {
        this.a = eVar;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i) {
        com.vivo.push.util.b bVar;
        com.vivo.push.util.b bVar2;
        if (i == 0) {
            this.a.k = "";
            bVar2 = this.a.j;
            bVar2.a("APP_TOKEN", "");
            this.a.m();
            this.a.j.b("APP_TAGS");
            return;
        }
        this.a.k = null;
        bVar = this.a.j;
        bVar.b("APP_TOKEN");
    }
}
