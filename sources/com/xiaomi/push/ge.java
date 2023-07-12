package com.xiaomi.push;

import com.xiaomi.push.service.C7764o;
import com.xiaomi.push.service.XMPushService;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class ge extends XMPushService.AbstractC7707j {
    final /* synthetic */ long a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ gd f417a;
    final /* synthetic */ long b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ge(gd gdVar, int i, long j, long j2) {
        super(i);
        this.f417a = gdVar;
        this.a = j;
        this.b = j2;
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC7707j
    /* renamed from: a */
    public String mo1157a() {
        return "check the ping-pong." + this.b;
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC7707j
    /* renamed from: a */
    public void mo878a() {
        Thread.yield();
        if (!this.f417a.m915c() || this.f417a.a(this.a)) {
            return;
        }
        C7764o.a(this.f417a.b).m1224b();
        this.f417a.b.a(22, (Exception) null);
    }
}
