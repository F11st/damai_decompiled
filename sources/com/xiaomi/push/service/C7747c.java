package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.push.fl;
import com.xiaomi.push.gh;
import com.xiaomi.push.service.XMPushService;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.xiaomi.push.service.c */
/* loaded from: classes11.dex */
public class C7747c extends XMPushService.AbstractC7707j {
    private XMPushService a;

    /* renamed from: a  reason: collision with other field name */
    private fl[] f955a;

    public C7747c(XMPushService xMPushService, fl[] flVarArr) {
        super(4);
        this.a = null;
        this.a = xMPushService;
        this.f955a = flVarArr;
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC7707j
    /* renamed from: a */
    public String mo1157a() {
        return "batch send message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC7707j
    /* renamed from: a */
    public void mo878a() {
        try {
            fl[] flVarArr = this.f955a;
            if (flVarArr != null) {
                this.a.a(flVarArr);
            }
        } catch (gh e) {
            AbstractC7535b.a(e);
            this.a.a(10, e);
        }
    }
}
