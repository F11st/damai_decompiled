package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class jg extends jh {
    private int b;
    private long c;
    private String d;
    private Context e;

    public jg(Context context, int i, String str, jh jhVar) {
        super(jhVar);
        this.b = i;
        this.d = str;
        this.e = context;
    }

    @Override // com.amap.api.mapcore.util.jh
    protected boolean a() {
        if (this.c == 0) {
            this.c = a(this.d);
        }
        return System.currentTimeMillis() - this.c >= ((long) this.b);
    }

    @Override // com.amap.api.mapcore.util.jh
    public void a(boolean z) {
        super.a(z);
        if (z) {
            a(this.d, System.currentTimeMillis());
        }
    }

    private void a(String str, long j) {
        this.c = j;
        hb.a(this.e, str, String.valueOf(j));
    }

    private long a(String str) {
        String a = hb.a(this.e, str);
        if (TextUtils.isEmpty(a)) {
            return 0L;
        }
        return Long.parseLong(a);
    }
}
