package com.xiaomi.push.service;

import com.xiaomi.push.fl;
import com.xiaomi.push.gb;
import com.xiaomi.push.gn;
import com.xiaomi.push.service.XMPushService;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class ci implements gb {
    final /* synthetic */ XMPushService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ci(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    @Override // com.xiaomi.push.gb
    public void a(fl flVar) {
        XMPushService xMPushService = this.a;
        xMPushService.a(new XMPushService.C7701d(flVar));
    }

    @Override // com.xiaomi.push.gb
    public void a(gn gnVar) {
        XMPushService xMPushService = this.a;
        xMPushService.a(new XMPushService.C7710m(gnVar));
    }
}
