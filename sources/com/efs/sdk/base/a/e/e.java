package com.efs.sdk.base.a.e;

import tb.j43;
import tb.l01;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class e implements Runnable {
    private j43 a;
    private c b;
    private String c;

    public e(j43 j43Var, c cVar, String str) {
        this.a = j43Var;
        this.b = cVar;
        this.c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c cVar;
        j43 j43Var = this.a;
        l01 l01Var = (j43Var == null || (cVar = this.b) == null) ? new l01() : cVar.a(j43Var, true);
        a.a().b(this.c, l01Var.a ? 0 : l01Var.b());
        this.c = null;
        this.b = null;
    }
}
