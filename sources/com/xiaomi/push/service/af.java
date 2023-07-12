package com.xiaomi.push.service;

import com.xiaomi.push.Cif;
import com.xiaomi.push.gh;
import com.xiaomi.push.hj;
import com.xiaomi.push.ht;
import com.xiaomi.push.ia;
import com.xiaomi.push.ii;
import com.xiaomi.push.service.XMPushService;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class af extends XMPushService.j {
    final /* synthetic */ Cif a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ ii f876a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f877a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public af(int i, ii iiVar, Cif cif, XMPushService xMPushService) {
        super(i);
        this.f876a = iiVar;
        this.a = cif;
        this.f877a = xMPushService;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public String mo1157a() {
        return "send ack message for clear push message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo878a() {
        try {
            ia iaVar = new ia();
            iaVar.c(ht.CancelPushMessageACK.f497a);
            iaVar.a(this.f876a.m1037a());
            iaVar.a(this.f876a.a());
            iaVar.b(this.f876a.b());
            iaVar.e(this.f876a.c());
            iaVar.a(0L);
            iaVar.d("success clear push message.");
            ah.a(this.f877a, ah.b(this.a.b(), this.a.m1023a(), iaVar, hj.Notification));
        } catch (gh e) {
            com.xiaomi.channel.commonutils.logger.b.d("clear push message. " + e);
            this.f877a.a(10, e);
        }
    }
}
