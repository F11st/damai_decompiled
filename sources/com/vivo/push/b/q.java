package com.vivo.push.b;

import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class q extends v {
    protected InsideNotificationItem a;
    private String b;

    public q() {
        super(4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.v, com.vivo.push.b.s, com.vivo.push.o
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        String b = com.vivo.push.util.q.b(this.a);
        this.b = b;
        aVar.a("notification_v1", b);
    }

    public final InsideNotificationItem d() {
        return this.a;
    }

    public final String e() {
        if (TextUtils.isEmpty(this.b)) {
            InsideNotificationItem insideNotificationItem = this.a;
            if (insideNotificationItem == null) {
                return null;
            }
            return com.vivo.push.util.q.b(insideNotificationItem);
        }
        return this.b;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final String toString() {
        return "OnNotifyArrivedCommand";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.v, com.vivo.push.b.s, com.vivo.push.o
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        String a = aVar.a("notification_v1");
        this.b = a;
        if (TextUtils.isEmpty(a)) {
            return;
        }
        InsideNotificationItem a2 = com.vivo.push.util.q.a(this.b);
        this.a = a2;
        if (a2 != null) {
            a2.setMsgId(f());
        }
    }
}
