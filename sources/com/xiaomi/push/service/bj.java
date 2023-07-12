package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.bg;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class bj extends XMPushService.AbstractC7707j {
    final /* synthetic */ bg.C7737b.C7740c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bj(bg.C7737b.C7740c c7740c, int i) {
        super(i);
        this.a = c7740c;
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC7707j
    /* renamed from: a */
    public String mo1157a() {
        return "check peer job";
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC7707j
    /* renamed from: a */
    public void mo878a() {
        bg a = bg.a();
        bg.C7737b c7737b = this.a.f932a;
        if (a.a(c7737b.g, c7737b.f928b).f919a == null) {
            XMPushService xMPushService = bg.C7737b.this.f921a;
            bg.C7737b c7737b2 = this.a.f932a;
            xMPushService.a(c7737b2.g, c7737b2.f928b, 2, null, null);
        }
    }
}
