package com.efs.sdk.base.a.e;

import tb.j43;
import tb.l01;

/* compiled from: Taobao */
/* renamed from: com.efs.sdk.base.a.e.e */
/* loaded from: classes10.dex */
public final class RunnableC4793e implements Runnable {
    private j43 a;
    private InterfaceC4792c b;
    private String c;

    public RunnableC4793e(j43 j43Var, InterfaceC4792c interfaceC4792c, String str) {
        this.a = j43Var;
        this.b = interfaceC4792c;
        this.c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        InterfaceC4792c interfaceC4792c;
        j43 j43Var = this.a;
        l01 l01Var = (j43Var == null || (interfaceC4792c = this.b) == null) ? new l01() : interfaceC4792c.a(j43Var, true);
        HandlerC4788a.a().b(this.c, l01Var.a ? 0 : l01Var.b());
        this.c = null;
        this.b = null;
    }
}
