package com.vivo.push.b;

import com.vivo.push.C7410a;

/* compiled from: Taobao */
/* renamed from: com.vivo.push.b.n */
/* loaded from: classes11.dex */
public final class C7426n extends C7431s {
    private String a;
    private int b;
    private boolean c;

    public C7426n() {
        super(7);
        this.b = 0;
        this.c = false;
    }

    public final void a(int i) {
        this.b = i;
    }

    public final void b(String str) {
        this.a = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.C7431s, com.vivo.push.AbstractC7496o
    public final void c(C7410a c7410a) {
        super.c(c7410a);
        c7410a.a("content", this.a);
        c7410a.a("log_level", this.b);
        c7410a.a("is_server_log", this.c);
    }

    public final String d() {
        return this.a;
    }

    public final int e() {
        return this.b;
    }

    public final boolean f() {
        return this.c;
    }

    @Override // com.vivo.push.b.C7431s, com.vivo.push.AbstractC7496o
    public final String toString() {
        return "OnLogCommand";
    }

    public final void a(boolean z) {
        this.c = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.C7431s, com.vivo.push.AbstractC7496o
    public final void d(C7410a c7410a) {
        super.d(c7410a);
        this.a = c7410a.a("content");
        this.b = c7410a.b("log_level", 0);
        this.c = c7410a.e("is_server_log");
    }
}
