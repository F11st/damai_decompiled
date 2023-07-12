package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.push.Cif;
import com.xiaomi.push.gh;
import com.xiaomi.push.service.XMPushService;

/* compiled from: Taobao */
/* renamed from: com.xiaomi.push.service.ab */
/* loaded from: classes11.dex */
final class C7719ab extends XMPushService.AbstractC7707j {
    final /* synthetic */ Cif a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f870a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C7719ab(int i, XMPushService xMPushService, Cif cif) {
        super(i);
        this.f870a = xMPushService;
        this.a = cif;
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC7707j
    /* renamed from: a */
    public String mo1157a() {
        return "send ack message for obsleted message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC7707j
    /* renamed from: a */
    public void mo878a() {
        try {
            Cif a = C7782y.a((Context) this.f870a, this.a);
            a.m1022a().a("message_obsleted", "1");
            ah.a(this.f870a, a);
        } catch (gh e) {
            AbstractC7535b.a(e);
            this.f870a.a(10, e);
        }
    }
}
