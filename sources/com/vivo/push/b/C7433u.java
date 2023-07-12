package com.vivo.push.b;

import com.vivo.push.C7410a;

/* compiled from: Taobao */
/* renamed from: com.vivo.push.b.u */
/* loaded from: classes11.dex */
public final class C7433u extends AbstractC7434v {
    private long a;
    private int b;

    public C7433u() {
        super(20);
        this.a = -1L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.AbstractC7434v, com.vivo.push.b.C7431s, com.vivo.push.AbstractC7496o
    public final void c(C7410a c7410a) {
        super.c(c7410a);
        c7410a.a("undo_msg_v1", this.a);
        c7410a.a("undo_msg_type_v1", this.b);
    }

    public final long d() {
        return this.a;
    }

    public final String e() {
        long j = this.a;
        if (j != -1) {
            return String.valueOf(j);
        }
        return null;
    }

    @Override // com.vivo.push.b.C7431s, com.vivo.push.AbstractC7496o
    public final String toString() {
        return "OnUndoMsgCommand";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.AbstractC7434v, com.vivo.push.b.C7431s, com.vivo.push.AbstractC7496o
    public final void d(C7410a c7410a) {
        super.d(c7410a);
        this.a = c7410a.b("undo_msg_v1", this.a);
        this.b = c7410a.b("undo_msg_type_v1", 0);
    }
}
