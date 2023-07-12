package com.vivo.push.b;

import com.vivo.push.AbstractC7496o;
import com.vivo.push.C7410a;

/* compiled from: Taobao */
/* renamed from: com.vivo.push.b.s */
/* loaded from: classes11.dex */
public class C7431s extends AbstractC7496o {
    private String a;
    private int b;

    public C7431s(int i) {
        super(i);
        this.a = null;
        this.b = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.AbstractC7496o
    public void c(C7410a c7410a) {
        c7410a.a("req_id", this.a);
        c7410a.a("status_msg_code", this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.AbstractC7496o
    public void d(C7410a c7410a) {
        this.a = c7410a.a("req_id");
        this.b = c7410a.b("status_msg_code", this.b);
    }

    public final String g() {
        return this.a;
    }

    public final int h() {
        return this.b;
    }

    @Override // com.vivo.push.AbstractC7496o
    public String toString() {
        return "OnReceiveCommand";
    }
}
