package com.xiaomi.push;

import com.xiaomi.push.ao;
import com.xiaomi.push.df;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class dh extends ao.AbstractC7600b {
    ao.AbstractC7600b a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ df f211a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dh(df dfVar) {
        this.f211a = dfVar;
    }

    @Override // com.xiaomi.push.ao.AbstractC7600b
    public void b() {
        df.C7630b c7630b = (df.C7630b) this.f211a.f199a.peek();
        if (c7630b == null || !c7630b.a()) {
            return;
        }
        if (this.f211a.f199a.remove(c7630b)) {
            this.a = c7630b;
        }
        ao.AbstractC7600b abstractC7600b = this.a;
        if (abstractC7600b != null) {
            abstractC7600b.b();
        }
    }

    @Override // com.xiaomi.push.ao.AbstractC7600b
    /* renamed from: c */
    public void mo765c() {
        ao.AbstractC7600b abstractC7600b = this.a;
        if (abstractC7600b != null) {
            abstractC7600b.mo765c();
        }
    }
}
