package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.push.Cif;
import com.xiaomi.push.gh;
import com.xiaomi.push.service.XMPushService;

/* compiled from: Taobao */
/* renamed from: com.xiaomi.push.service.z */
/* loaded from: classes11.dex */
final class C7783z extends XMPushService.AbstractC7707j {
    final /* synthetic */ Cif a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f1003a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C7783z(int i, XMPushService xMPushService, Cif cif) {
        super(i);
        this.f1003a = xMPushService;
        this.a = cif;
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC7707j
    /* renamed from: a */
    public String mo1157a() {
        return "send app absent message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC7707j
    /* renamed from: a */
    public void mo878a() {
        try {
            ah.a(this.f1003a, ah.a(this.a.b(), this.a.m1023a()));
        } catch (gh e) {
            AbstractC7535b.a(e);
            this.f1003a.a(10, e);
        }
    }
}
