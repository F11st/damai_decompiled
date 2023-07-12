package com.vivo.push.b;

import android.text.TextUtils;
import com.vivo.push.AbstractC7496o;
import com.vivo.push.C7410a;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.util.C7524q;

/* compiled from: Taobao */
/* renamed from: com.vivo.push.b.p */
/* loaded from: classes11.dex */
public final class C7428p extends AbstractC7496o {
    private String a;
    private String b;
    private byte[] c;
    private long d;
    private InsideNotificationItem e;

    public C7428p(String str, long j, InsideNotificationItem insideNotificationItem) {
        super(5);
        this.a = str;
        this.d = j;
        this.e = insideNotificationItem;
    }

    @Override // com.vivo.push.AbstractC7496o
    protected final void c(C7410a c7410a) {
        c7410a.a("package_name", this.a);
        c7410a.a("notify_id", this.d);
        c7410a.a("notification_v1", C7524q.b(this.e));
        c7410a.a("open_pkg_name", this.b);
        c7410a.a("open_pkg_name_encode", this.c);
    }

    public final String d() {
        return this.a;
    }

    public final long e() {
        return this.d;
    }

    public final InsideNotificationItem f() {
        return this.e;
    }

    @Override // com.vivo.push.AbstractC7496o
    public final String toString() {
        return "OnNotificationClickCommand";
    }

    @Override // com.vivo.push.AbstractC7496o
    protected final void d(C7410a c7410a) {
        this.a = c7410a.a("package_name");
        this.d = c7410a.b("notify_id", -1L);
        this.b = c7410a.a("open_pkg_name");
        this.c = c7410a.b("open_pkg_name_encode");
        String a = c7410a.a("notification_v1");
        if (!TextUtils.isEmpty(a)) {
            this.e = C7524q.a(a);
        }
        InsideNotificationItem insideNotificationItem = this.e;
        if (insideNotificationItem != null) {
            insideNotificationItem.setMsgId(this.d);
        }
    }

    public C7428p() {
        super(5);
    }
}
