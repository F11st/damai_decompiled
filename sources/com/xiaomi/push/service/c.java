package com.xiaomi.push.service;

import com.xiaomi.push.fl;
import com.xiaomi.push.gh;
import com.xiaomi.push.service.XMPushService;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class c extends XMPushService.j {
    private XMPushService a;

    /* renamed from: a  reason: collision with other field name */
    private fl[] f955a;

    public c(XMPushService xMPushService, fl[] flVarArr) {
        super(4);
        this.a = null;
        this.a = xMPushService;
        this.f955a = flVarArr;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public String mo1157a() {
        return "batch send message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo878a() {
        try {
            fl[] flVarArr = this.f955a;
            if (flVarArr != null) {
                this.a.a(flVarArr);
            }
        } catch (gh e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.a.a(10, e);
        }
    }
}
