package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import mtopsdk.common.util.SymbolExpUtil;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class dx extends ea {
    private Context b;
    private boolean d;
    private int e;
    private int f;
    private String a = "iKey";
    private int g = 0;

    public dx(Context context, boolean z, int i, int i2, String str, int i3) {
        a(context, z, i, i2, str, i3);
    }

    private void a(Context context, boolean z, int i, int i2, String str, int i3) {
        this.b = context;
        this.d = z;
        this.e = i;
        this.f = i2;
        this.a = str;
        this.g = i3;
    }

    @Override // com.amap.api.col.s.ea
    public final int b() {
        int i;
        int i2 = Integer.MAX_VALUE;
        if ((bo.n(this.b) != 1 && (i = this.e) > 0) || ((i = this.g) > 0 && i < Integer.MAX_VALUE)) {
            i2 = i;
        }
        ea eaVar = this.c;
        return eaVar != null ? Math.max(i2, eaVar.b()) : i2;
    }

    @Override // com.amap.api.col.s.ea
    protected final boolean a() {
        if (bo.n(this.b) == 1) {
            return true;
        }
        if (this.d) {
            String a = cj.a(this.b, this.a);
            if (TextUtils.isEmpty(a)) {
                return true;
            }
            String[] split = a.split(SymbolExpUtil.SYMBOL_VERTICALBAR);
            if (split != null && split.length >= 2) {
                return !bw.a(System.currentTimeMillis(), "yyyyMMdd").equals(split[0]) || Integer.parseInt(split[1]) < this.f;
            }
            cj.b(this.b, this.a);
            return true;
        }
        return false;
    }

    @Override // com.amap.api.col.s.ea
    public final void a(int i) {
        if (bo.n(this.b) == 1) {
            return;
        }
        String a = bw.a(System.currentTimeMillis(), "yyyyMMdd");
        String a2 = cj.a(this.b, this.a);
        if (!TextUtils.isEmpty(a2)) {
            String[] split = a2.split(SymbolExpUtil.SYMBOL_VERTICALBAR);
            if (split != null && split.length >= 2) {
                if (a.equals(split[0])) {
                    i += Integer.parseInt(split[1]);
                }
            } else {
                cj.b(this.b, this.a);
            }
        }
        Context context = this.b;
        String str = this.a;
        cj.a(context, str, a + "|" + i);
    }
}
