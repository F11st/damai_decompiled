package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class dz extends ea {
    protected int a;
    protected long b;
    private String d;
    private Context e;

    public dz(Context context, int i, String str, ea eaVar) {
        super(eaVar);
        this.a = i;
        this.d = str;
        this.e = context;
    }

    @Override // com.amap.api.col.s.ea
    protected final boolean a() {
        if (this.b == 0) {
            String a = cj.a(this.e, this.d);
            this.b = TextUtils.isEmpty(a) ? 0L : Long.parseLong(a);
        }
        return System.currentTimeMillis() - this.b >= ((long) this.a);
    }

    @Override // com.amap.api.col.s.ea
    public final void a(boolean z) {
        super.a(z);
        if (z) {
            String str = this.d;
            long currentTimeMillis = System.currentTimeMillis();
            this.b = currentTimeMillis;
            cj.a(this.e, str, String.valueOf(currentTimeMillis));
        }
    }
}
