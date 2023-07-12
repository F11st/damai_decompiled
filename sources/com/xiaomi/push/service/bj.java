package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.bg;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class bj extends XMPushService.j {
    final /* synthetic */ bg.b.c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bj(bg.b.c cVar, int i) {
        super(i);
        this.a = cVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public String mo1157a() {
        return "check peer job";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo878a() {
        bg a = bg.a();
        bg.b bVar = this.a.f932a;
        if (a.a(bVar.g, bVar.f928b).f919a == null) {
            XMPushService xMPushService = bg.b.this.f921a;
            bg.b bVar2 = this.a.f932a;
            xMPushService.a(bVar2.g, bVar2.f928b, 2, null, null);
        }
    }
}
