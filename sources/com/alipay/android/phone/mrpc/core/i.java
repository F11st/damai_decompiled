package com.alipay.android.phone.mrpc.core;

import android.content.Context;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class i implements g {
    public final /* synthetic */ aa a;
    public final /* synthetic */ h b;

    public i(h hVar, aa aaVar) {
        this.b = hVar;
        this.a = aaVar;
    }

    @Override // com.alipay.android.phone.mrpc.core.g
    public final String a() {
        return this.a.a();
    }

    @Override // com.alipay.android.phone.mrpc.core.g
    public final ab b() {
        Context context;
        context = this.b.a;
        return l.a(context.getApplicationContext());
    }

    @Override // com.alipay.android.phone.mrpc.core.g
    public final aa c() {
        return this.a;
    }

    @Override // com.alipay.android.phone.mrpc.core.g
    public final boolean d() {
        return this.a.c();
    }
}
