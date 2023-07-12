package com.vivo.push.b;

import com.vivo.push.C7410a;

/* compiled from: Taobao */
/* renamed from: com.vivo.push.b.b */
/* loaded from: classes11.dex */
public final class C7414b extends C7415c {
    private String a;
    private String b;
    private String c;
    private String d;
    private boolean e;

    public C7414b(boolean z, String str) {
        super(z ? 2006 : 2007, str);
        this.e = false;
    }

    @Override // com.vivo.push.b.C7415c, com.vivo.push.AbstractC7496o
    public final void c(C7410a c7410a) {
        super.c(c7410a);
        c7410a.a("sdk_clients", this.a);
        c7410a.a("sdk_version", 323L);
        c7410a.a("BaseAppCommand.EXTRA_APPID", this.c);
        c7410a.a("BaseAppCommand.EXTRA_APPKEY", this.b);
        c7410a.a("PUSH_REGID", this.d);
    }

    public final void d() {
        this.c = null;
    }

    public final void e() {
        this.b = null;
    }

    @Override // com.vivo.push.b.C7415c, com.vivo.push.AbstractC7496o
    public final String toString() {
        return "AppCommand:" + b();
    }

    @Override // com.vivo.push.b.C7415c, com.vivo.push.AbstractC7496o
    public final void d(C7410a c7410a) {
        super.d(c7410a);
        this.a = c7410a.a("sdk_clients");
        this.c = c7410a.a("BaseAppCommand.EXTRA_APPID");
        this.b = c7410a.a("BaseAppCommand.EXTRA_APPKEY");
        this.d = c7410a.a("PUSH_REGID");
    }
}
