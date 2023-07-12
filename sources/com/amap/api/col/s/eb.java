package com.amap.api.col.s;

import android.content.Context;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class eb extends ea {
    private Context a;
    private boolean b;

    public eb(Context context) {
        this.b = false;
        this.a = context;
        this.b = false;
    }

    @Override // com.amap.api.col.s.ea
    protected final boolean a() {
        return bo.n(this.a) == 1 || this.b;
    }
}
