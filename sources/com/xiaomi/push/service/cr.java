package com.xiaomi.push.service;

import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.push.service.XMPushService;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class cr extends ContentObserver {
    final /* synthetic */ XMPushService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cr(XMPushService xMPushService, Handler handler) {
        super(handler);
        this.a = xMPushService;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        boolean m1144g;
        super.onChange(z);
        m1144g = this.a.m1144g();
        com.xiaomi.channel.commonutils.logger.b.m586a("SuperPowerMode:" + m1144g);
        this.a.e();
        if (!m1144g) {
            this.a.a(true);
            return;
        }
        XMPushService xMPushService = this.a;
        xMPushService.a(new XMPushService.g(24, null));
    }
}
