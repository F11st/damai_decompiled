package com.vivo.push.b;

import com.vivo.push.C7410a;

/* compiled from: Taobao */
/* renamed from: com.vivo.push.b.l */
/* loaded from: classes11.dex */
public final class C7424l extends C7431s {
    private int a;
    private int b;

    public C7424l() {
        super(2016);
        this.a = -1;
        this.b = -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.C7431s, com.vivo.push.AbstractC7496o
    public final void c(C7410a c7410a) {
        super.c(c7410a);
        c7410a.a("key_dispatch_environment", this.a);
        c7410a.a("key_dispatch_area", this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.C7431s, com.vivo.push.AbstractC7496o
    public final void d(C7410a c7410a) {
        super.d(c7410a);
        this.a = c7410a.b("key_dispatch_environment", 1);
        this.b = c7410a.b("key_dispatch_area", 1);
    }

    public final int e() {
        return this.b;
    }

    public final int d() {
        return this.a;
    }
}
