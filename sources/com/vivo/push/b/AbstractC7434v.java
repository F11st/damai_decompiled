package com.vivo.push.b;

import com.vivo.push.C7410a;

/* compiled from: Taobao */
/* renamed from: com.vivo.push.b.v */
/* loaded from: classes11.dex */
public abstract class AbstractC7434v extends C7431s {
    private String a;
    private long b;

    public AbstractC7434v(int i) {
        super(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.C7431s, com.vivo.push.AbstractC7496o
    public void c(C7410a c7410a) {
        super.c(c7410a);
        c7410a.a("OnVerifyCallBackCommand.EXTRA_SECURITY_CONTENT", this.a);
        c7410a.a("notify_id", this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.C7431s, com.vivo.push.AbstractC7496o
    public void d(C7410a c7410a) {
        super.d(c7410a);
        this.a = c7410a.a("OnVerifyCallBackCommand.EXTRA_SECURITY_CONTENT");
        this.b = c7410a.b("notify_id", -1L);
    }

    public final long f() {
        return this.b;
    }

    public final String i() {
        return this.a;
    }
}
