package com.xiaomi.mipush.sdk;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class ac implements Runnable {
    final /* synthetic */ NotificationClickedActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(NotificationClickedActivity notificationClickedActivity) {
        this.a = notificationClickedActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.xiaomi.channel.commonutils.logger.b.e("clicked activity finish by timeout.");
        this.a.finish();
    }
}
