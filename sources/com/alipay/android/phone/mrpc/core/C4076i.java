package com.alipay.android.phone.mrpc.core;

import android.content.Context;

/* compiled from: Taobao */
/* renamed from: com.alipay.android.phone.mrpc.core.i */
/* loaded from: classes10.dex */
public final class C4076i implements InterfaceC4074g {
    public final /* synthetic */ aa a;
    public final /* synthetic */ C4075h b;

    public C4076i(C4075h c4075h, aa aaVar) {
        this.b = c4075h;
        this.a = aaVar;
    }

    @Override // com.alipay.android.phone.mrpc.core.InterfaceC4074g
    public final String a() {
        return this.a.a();
    }

    @Override // com.alipay.android.phone.mrpc.core.InterfaceC4074g
    public final InterfaceC4065ab b() {
        Context context;
        context = this.b.a;
        return C4080l.a(context.getApplicationContext());
    }

    @Override // com.alipay.android.phone.mrpc.core.InterfaceC4074g
    public final aa c() {
        return this.a;
    }

    @Override // com.alipay.android.phone.mrpc.core.InterfaceC4074g
    public final boolean d() {
        return this.a.c();
    }
}
