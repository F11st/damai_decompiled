package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.fx;
import com.xiaomi.push.service.XMPushService;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class cu extends XMPushService.j {
    final /* synthetic */ XMPushService a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f966a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ byte[] f967a;
    final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cu(XMPushService xMPushService, int i, int i2, String str, byte[] bArr) {
        super(i);
        this.a = xMPushService;
        this.b = i2;
        this.f966a = str;
        this.f967a = bArr;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public String mo1157a() {
        return "clear account cache.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo878a() {
        fx fxVar;
        u.m1240a((Context) this.a);
        bg.a().m1198a("5");
        com.xiaomi.push.ae.a(this.b);
        fxVar = this.a.f837a;
        fxVar.c(fx.a());
        com.xiaomi.channel.commonutils.logger.b.m586a("clear account and start registration. " + this.f966a);
        this.a.a(this.f967a, this.f966a);
    }
}
