package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.bg;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class cq implements bg.a {
    final /* synthetic */ XMPushService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cq(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    @Override // com.xiaomi.push.service.bg.a
    public void a() {
        this.a.e();
        if (bg.a().m1193a() <= 0) {
            XMPushService xMPushService = this.a;
            xMPushService.a(new XMPushService.g(12, null));
        }
    }
}
