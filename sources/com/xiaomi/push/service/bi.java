package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.bg;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class bi extends XMPushService.AbstractC7707j {
    final /* synthetic */ bg.C7737b.C7740c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bi(bg.C7737b.C7740c c7740c, int i) {
        super(i);
        this.a = c7740c;
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC7707j
    /* renamed from: a */
    public String mo1157a() {
        return "clear peer job";
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC7707j
    /* renamed from: a */
    public void mo878a() {
        bg.C7737b.C7740c c7740c = this.a;
        if (c7740c.a == c7740c.f932a.f919a) {
            AbstractC7535b.b("clean peer, chid = " + this.a.f932a.g);
            this.a.f932a.f919a = null;
        }
    }
}
