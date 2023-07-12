package com.vivo.push.b;

import com.vivo.push.C7410a;

/* compiled from: Taobao */
/* renamed from: com.vivo.push.b.i */
/* loaded from: classes11.dex */
public final class C7421i extends C7431s {
    private String a;
    private String b;
    private String c;

    public C7421i(int i) {
        super(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.C7431s, com.vivo.push.AbstractC7496o
    public final void c(C7410a c7410a) {
        super.c(c7410a);
        c7410a.a("app_id", this.a);
        c7410a.a("client_id", this.b);
        c7410a.a("client_token", this.c);
    }

    public final String d() {
        return this.a;
    }

    public final String e() {
        return this.c;
    }

    @Override // com.vivo.push.b.C7431s, com.vivo.push.AbstractC7496o
    public final String toString() {
        return "OnBindCommand";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.C7431s, com.vivo.push.AbstractC7496o
    public final void d(C7410a c7410a) {
        super.d(c7410a);
        this.a = c7410a.a("app_id");
        this.b = c7410a.a("client_id");
        this.c = c7410a.a("client_token");
    }
}
