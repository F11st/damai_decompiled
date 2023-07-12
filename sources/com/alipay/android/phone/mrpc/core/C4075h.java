package com.alipay.android.phone.mrpc.core;

import android.content.Context;

/* compiled from: Taobao */
/* renamed from: com.alipay.android.phone.mrpc.core.h */
/* loaded from: classes10.dex */
public final class C4075h extends AbstractC4091w {
    public Context a;

    public C4075h(Context context) {
        this.a = context;
    }

    @Override // com.alipay.android.phone.mrpc.core.AbstractC4091w
    public final <T> T a(Class<T> cls, aa aaVar) {
        return (T) new C4092x(new C4076i(this, aaVar)).a(cls);
    }
}
