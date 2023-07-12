package com.xiaomi.push;

import com.xiaomi.push.ao;
import com.xiaomi.push.df;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class dh extends ao.b {
    ao.b a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ df f211a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dh(df dfVar) {
        this.f211a = dfVar;
    }

    @Override // com.xiaomi.push.ao.b
    public void b() {
        df.b bVar = (df.b) this.f211a.f199a.peek();
        if (bVar == null || !bVar.a()) {
            return;
        }
        if (this.f211a.f199a.remove(bVar)) {
            this.a = bVar;
        }
        ao.b bVar2 = this.a;
        if (bVar2 != null) {
            bVar2.b();
        }
    }

    @Override // com.xiaomi.push.ao.b
    /* renamed from: c */
    public void mo765c() {
        ao.b bVar = this.a;
        if (bVar != null) {
            bVar.mo765c();
        }
    }
}
