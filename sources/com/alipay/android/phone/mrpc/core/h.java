package com.alipay.android.phone.mrpc.core;

import android.content.Context;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class h extends w {
    public Context a;

    public h(Context context) {
        this.a = context;
    }

    @Override // com.alipay.android.phone.mrpc.core.w
    public final <T> T a(Class<T> cls, aa aaVar) {
        return (T) new x(new i(this, aaVar)).a(cls);
    }
}
