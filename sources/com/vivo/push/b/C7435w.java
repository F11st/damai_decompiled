package com.vivo.push.b;

import com.vivo.push.AbstractC7496o;
import com.vivo.push.C7410a;

/* compiled from: Taobao */
/* renamed from: com.vivo.push.b.w */
/* loaded from: classes11.dex */
public final class C7435w extends AbstractC7496o {
    private int a;

    public C7435w() {
        super(2011);
        this.a = 0;
    }

    @Override // com.vivo.push.AbstractC7496o
    protected final void c(C7410a c7410a) {
        c7410a.a("com.bbk.push.ikey.MODE_TYPE", this.a);
    }

    @Override // com.vivo.push.AbstractC7496o
    public final boolean c() {
        return true;
    }

    public final int d() {
        return this.a;
    }

    @Override // com.vivo.push.AbstractC7496o
    public final String toString() {
        return "PushModeCommand";
    }

    @Override // com.vivo.push.AbstractC7496o
    protected final void d(C7410a c7410a) {
        this.a = c7410a.b("com.bbk.push.ikey.MODE_TYPE", 0);
    }
}
