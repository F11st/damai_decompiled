package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import mtopsdk.common.util.SymbolExpUtil;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class je extends jh {
    private String b;
    private Context c;
    private boolean d;
    private int e;
    private int f;

    public je(Context context, boolean z, int i, int i2, String str) {
        this.b = "iKey";
        this.c = context;
        this.d = z;
        this.e = i;
        this.f = i2;
        this.b = str;
    }

    @Override // com.amap.api.mapcore.util.jh
    protected boolean a() {
        if (gg.r(this.c) == 1) {
            return true;
        }
        if (this.d) {
            String a = hb.a(this.c, this.b);
            if (TextUtils.isEmpty(a)) {
                return true;
            }
            String[] split = a.split(SymbolExpUtil.SYMBOL_VERTICALBAR);
            if (split != null && split.length >= 2) {
                return !gn.a(System.currentTimeMillis(), "yyyyMMdd").equals(split[0]) || Integer.parseInt(split[1]) < this.f;
            }
            hb.b(this.c, this.b);
            return true;
        }
        return false;
    }

    @Override // com.amap.api.mapcore.util.jh
    public int b() {
        int i = (gg.r(this.c) == 1 || (i = this.e) <= 0) ? Integer.MAX_VALUE : Integer.MAX_VALUE;
        jh jhVar = this.a;
        return jhVar != null ? Math.max(i, jhVar.b()) : i;
    }

    @Override // com.amap.api.mapcore.util.jh
    public void a(int i) {
        if (gg.r(this.c) == 1) {
            return;
        }
        String a = gn.a(System.currentTimeMillis(), "yyyyMMdd");
        String a2 = hb.a(this.c, this.b);
        if (!TextUtils.isEmpty(a2)) {
            String[] split = a2.split(SymbolExpUtil.SYMBOL_VERTICALBAR);
            if (split != null && split.length >= 2) {
                if (a.equals(split[0])) {
                    i += Integer.parseInt(split[1]);
                }
            } else {
                hb.b(this.c, this.b);
            }
        }
        Context context = this.c;
        String str = this.b;
        hb.a(context, str, a + "|" + i);
    }
}
