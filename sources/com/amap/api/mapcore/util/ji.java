package com.amap.api.mapcore.util;

import android.content.Context;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class ji extends jh {
    private Context b;
    private boolean c;

    public ji(Context context, boolean z) {
        this.c = false;
        this.b = context;
        this.c = z;
    }

    @Override // com.amap.api.mapcore.util.jh
    protected boolean a() {
        return gg.r(this.b) == 1 || this.c;
    }
}
