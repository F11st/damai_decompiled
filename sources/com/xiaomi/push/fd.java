package com.xiaomi.push;

import com.xiaomi.push.service.XMPushService;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class fd extends XMPushService.AbstractC7707j {
    final /* synthetic */ C7651fc a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fd(C7651fc c7651fc, int i) {
        super(i);
        this.a = c7651fc;
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC7707j
    /* renamed from: a */
    public String mo1157a() {
        return "Handling bind stats";
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC7707j
    /* renamed from: a  reason: collision with other method in class */
    public void mo878a() {
        this.a.c();
    }
}
