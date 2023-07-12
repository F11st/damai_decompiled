package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.bg;
import org.apache.commons.lang3.time.DateUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class bh implements bg.C7737b.InterfaceC7738a {
    final /* synthetic */ bg.C7737b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(bg.C7737b c7737b) {
        this.a = c7737b;
    }

    @Override // com.xiaomi.push.service.bg.C7737b.InterfaceC7738a
    public void a(bg.EnumC7741c enumC7741c, bg.EnumC7741c enumC7741c2, int i) {
        XMPushService.C7700c c7700c;
        XMPushService.C7700c c7700c2;
        if (enumC7741c2 == bg.EnumC7741c.binding) {
            XMPushService xMPushService = this.a.f921a;
            c7700c2 = this.a.f920a;
            xMPushService.a(c7700c2, DateUtils.MILLIS_PER_MINUTE);
            return;
        }
        XMPushService xMPushService2 = this.a.f921a;
        c7700c = this.a.f920a;
        xMPushService2.b(c7700c);
    }
}
