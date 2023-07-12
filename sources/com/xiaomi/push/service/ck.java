package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class ck extends XMPushService.AbstractC7707j {
    final /* synthetic */ XMPushService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ck(XMPushService xMPushService, int i) {
        super(i);
        this.a = xMPushService;
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC7707j
    /* renamed from: a */
    public String mo1157a() {
        return "disconnect for service destroy.";
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC7707j
    /* renamed from: a */
    public void mo878a() {
        if (this.a.f836a != null) {
            this.a.f836a.b(15, (Exception) null);
            this.a.f836a = null;
        }
    }
}
