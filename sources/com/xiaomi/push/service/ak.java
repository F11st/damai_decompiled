package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.service.bg;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class ak implements bg.C7737b.InterfaceC7738a {
    final /* synthetic */ XMPushService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    @Override // com.xiaomi.push.service.bg.C7737b.InterfaceC7738a
    public void a(bg.EnumC7741c enumC7741c, bg.EnumC7741c enumC7741c2, int i) {
        if (enumC7741c2 == bg.EnumC7741c.binded) {
            C7781x.a(this.a, true);
            C7781x.a(this.a);
        } else if (enumC7741c2 == bg.EnumC7741c.unbind) {
            AbstractC7535b.m586a("onChange unbind");
            C7781x.a(this.a, ErrorCode.ERROR_SERVICE_UNAVAILABLE, " the push is not connected.");
        }
    }
}
