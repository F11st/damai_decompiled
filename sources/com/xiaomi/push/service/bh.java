package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.bg;
import org.apache.commons.lang3.time.DateUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class bh implements bg.b.a {
    final /* synthetic */ bg.b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(bg.b bVar) {
        this.a = bVar;
    }

    @Override // com.xiaomi.push.service.bg.b.a
    public void a(bg.c cVar, bg.c cVar2, int i) {
        XMPushService.c cVar3;
        XMPushService.c cVar4;
        if (cVar2 == bg.c.binding) {
            XMPushService xMPushService = this.a.f921a;
            cVar4 = this.a.f920a;
            xMPushService.a(cVar4, DateUtils.MILLIS_PER_MINUTE);
            return;
        }
        XMPushService xMPushService2 = this.a.f921a;
        cVar3 = this.a.f920a;
        xMPushService2.b(cVar3);
    }
}
