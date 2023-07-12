package com.vivo.push.b;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class s extends com.vivo.push.o {
    private String a;
    private int b;

    public s(int i) {
        super(i);
        this.a = null;
        this.b = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.o
    public void c(com.vivo.push.a aVar) {
        aVar.a("req_id", this.a);
        aVar.a("status_msg_code", this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.o
    public void d(com.vivo.push.a aVar) {
        this.a = aVar.a("req_id");
        this.b = aVar.b("status_msg_code", this.b);
    }

    public final String g() {
        return this.a;
    }

    public final int h() {
        return this.b;
    }

    @Override // com.vivo.push.o
    public String toString() {
        return "OnReceiveCommand";
    }
}
