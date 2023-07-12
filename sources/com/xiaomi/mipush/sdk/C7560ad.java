package com.xiaomi.mipush.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;

/* compiled from: Taobao */
/* renamed from: com.xiaomi.mipush.sdk.ad */
/* loaded from: classes11.dex */
class C7560ad extends BroadcastReceiver {
    final /* synthetic */ NotificationClickedActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C7560ad(NotificationClickedActivity notificationClickedActivity) {
        this.a = notificationClickedActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        AbstractC7535b.b("clicked activity finish by normal.");
        this.a.finish();
    }
}
