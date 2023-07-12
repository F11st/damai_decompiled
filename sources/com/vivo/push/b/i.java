package com.vivo.push.b;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class i extends s {
    private String a;
    private String b;
    private String c;

    public i(int i) {
        super(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("app_id", this.a);
        aVar.a("client_id", this.b);
        aVar.a("client_token", this.c);
    }

    public final String d() {
        return this.a;
    }

    public final String e() {
        return this.c;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final String toString() {
        return "OnBindCommand";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.a = aVar.a("app_id");
        this.b = aVar.a("client_id");
        this.c = aVar.a("client_token");
    }
}
