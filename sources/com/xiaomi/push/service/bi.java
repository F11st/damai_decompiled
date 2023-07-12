package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.bg;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class bi extends XMPushService.j {
    final /* synthetic */ bg.b.c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bi(bg.b.c cVar, int i) {
        super(i);
        this.a = cVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public String mo1157a() {
        return "clear peer job";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo878a() {
        bg.b.c cVar = this.a;
        if (cVar.a == cVar.f932a.f919a) {
            com.xiaomi.channel.commonutils.logger.b.b("clean peer, chid = " + this.a.f932a.g);
            this.a.f932a.f919a = null;
        }
    }
}
