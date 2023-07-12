package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.push.hj;
import com.xiaomi.push.ii;
import com.xiaomi.push.it;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class ch implements Runnable {
    final /* synthetic */ ii a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(ii iiVar) {
        this.a = iiVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        byte[] a = it.a(ah.a(this.a.c(), this.a.b(), this.a, hj.Notification));
        context = cg.a;
        if (!(context instanceof XMPushService)) {
            AbstractC7535b.m586a("UNDatas UploadNotificationDatas failed because not xmsf");
            return;
        }
        context2 = cg.a;
        ((XMPushService) context2).a(this.a.c(), a, true);
    }
}
