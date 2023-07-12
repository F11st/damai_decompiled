package com.vivo.push.util;

import android.content.Context;
import com.vivo.push.d.r;
import com.vivo.push.model.InsideNotificationItem;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class l implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ k b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar, List list) {
        this.b = kVar;
        this.a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        InsideNotificationItem insideNotificationItem;
        long j;
        Context context;
        InsideNotificationItem insideNotificationItem2;
        long j2;
        int i;
        r.a aVar;
        insideNotificationItem = this.b.b;
        if (insideNotificationItem != null) {
            w b = w.b();
            j = this.b.c;
            b.a("com.vivo.push.notify_key", j);
            context = this.b.a;
            List list = this.a;
            insideNotificationItem2 = this.b.b;
            j2 = this.b.c;
            i = this.b.e;
            aVar = this.b.f;
            NotifyAdapterUtil.pushNotification(context, list, insideNotificationItem2, j2, i, aVar);
        }
    }
}
