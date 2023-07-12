package com.vivo.push.util;

import android.content.Context;
import com.vivo.push.d.C7471r;
import com.vivo.push.model.InsideNotificationItem;
import java.util.List;

/* compiled from: Taobao */
/* renamed from: com.vivo.push.util.l */
/* loaded from: classes11.dex */
final class RunnableC7519l implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ AsyncTaskC7518k b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC7519l(AsyncTaskC7518k asyncTaskC7518k, List list) {
        this.b = asyncTaskC7518k;
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
        C7471r.InterfaceC7472a interfaceC7472a;
        insideNotificationItem = this.b.b;
        if (insideNotificationItem != null) {
            C7530w b = C7530w.b();
            j = this.b.c;
            b.a("com.vivo.push.notify_key", j);
            context = this.b.a;
            List list = this.a;
            insideNotificationItem2 = this.b.b;
            j2 = this.b.c;
            i = this.b.e;
            interfaceC7472a = this.b.f;
            NotifyAdapterUtil.pushNotification(context, list, insideNotificationItem2, j2, i, interfaceC7472a);
        }
    }
}
