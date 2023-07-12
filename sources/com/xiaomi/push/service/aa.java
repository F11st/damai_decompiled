package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.Cif;
import com.xiaomi.push.gh;
import com.xiaomi.push.service.XMPushService;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class aa extends XMPushService.j {
    final /* synthetic */ Cif a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f869a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aa(int i, XMPushService xMPushService, Cif cif) {
        super(i);
        this.f869a = xMPushService;
        this.a = cif;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public String mo1157a() {
        return "send ack message for message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo878a() {
        Map<String, String> map = null;
        try {
            if (com.xiaomi.push.m.m1119a((Context) this.f869a)) {
                try {
                    map = ag.a((Context) this.f869a, this.a);
                } catch (Throwable unused) {
                }
            }
            ah.a(this.f869a, y.a(this.f869a, this.a, map));
        } catch (gh e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f869a.a(10, e);
        }
    }
}
