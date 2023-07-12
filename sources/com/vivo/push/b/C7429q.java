package com.vivo.push.b;

import android.text.TextUtils;
import com.vivo.push.C7410a;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.util.C7524q;

/* compiled from: Taobao */
/* renamed from: com.vivo.push.b.q */
/* loaded from: classes11.dex */
public final class C7429q extends AbstractC7434v {
    protected InsideNotificationItem a;
    private String b;

    public C7429q() {
        super(4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.AbstractC7434v, com.vivo.push.b.C7431s, com.vivo.push.AbstractC7496o
    public final void c(C7410a c7410a) {
        super.c(c7410a);
        String b = C7524q.b(this.a);
        this.b = b;
        c7410a.a("notification_v1", b);
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
            return C7524q.b(insideNotificationItem);
        }
        return this.b;
    }

    @Override // com.vivo.push.b.C7431s, com.vivo.push.AbstractC7496o
    public final String toString() {
        return "OnNotifyArrivedCommand";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.AbstractC7434v, com.vivo.push.b.C7431s, com.vivo.push.AbstractC7496o
    public final void d(C7410a c7410a) {
        super.d(c7410a);
        String a = c7410a.a("notification_v1");
        this.b = a;
        if (TextUtils.isEmpty(a)) {
            return;
        }
        InsideNotificationItem a2 = C7524q.a(this.b);
        this.a = a2;
        if (a2 != null) {
            a2.setMsgId(f());
        }
    }
}
