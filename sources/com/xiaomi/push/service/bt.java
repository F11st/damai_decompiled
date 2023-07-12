package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.push.fl;
import com.xiaomi.push.gh;
import com.xiaomi.push.hi;
import com.xiaomi.push.service.XMPushService;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class bt extends XMPushService.AbstractC7707j {
    private fl a;

    /* renamed from: a  reason: collision with other field name */
    private XMPushService f941a;

    public bt(XMPushService xMPushService, fl flVar) {
        super(4);
        this.f941a = null;
        this.f941a = xMPushService;
        this.a = flVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC7707j
    /* renamed from: a */
    public String mo1157a() {
        return "send a message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC7707j
    /* renamed from: a */
    public void mo878a() {
        try {
            fl flVar = this.a;
            if (flVar != null) {
                this.f941a.a(flVar);
                if (this.a.f364a == null || !hi.a(this.f941a, 1)) {
                    return;
                }
                this.a.f364a.d = System.currentTimeMillis();
                bz.a("category_coord_up", "coord_up", "com.xiaomi.xmsf", this.a.f364a);
            }
        } catch (gh e) {
            AbstractC7535b.a(e);
            this.f941a.a(10, e);
        }
    }
}
