package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.Cif;
import com.xiaomi.push.gh;
import com.xiaomi.push.service.XMPushService;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class ac extends XMPushService.j {
    final /* synthetic */ Cif a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f871a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ac(int i, XMPushService xMPushService, Cif cif) {
        super(i);
        this.f871a = xMPushService;
        this.a = cif;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public String mo1157a() {
        return "send ack message for unrecognized new miui message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo878a() {
        try {
            Cif a = y.a((Context) this.f871a, this.a);
            a.m1022a().a("miui_message_unrecognized", "1");
            ah.a(this.f871a, a);
        } catch (gh e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f871a.a(10, e);
        }
    }
}
