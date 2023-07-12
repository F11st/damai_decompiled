package com.xiaomi.push.service;

import com.xiaomi.push.dx;
import com.xiaomi.push.fx;
import com.xiaomi.push.ga;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class cp extends fx {
    final /* synthetic */ XMPushService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cp(XMPushService xMPushService, Map map, int i, String str, ga gaVar) {
        super(map, i, str, gaVar);
        this.a = xMPushService;
    }

    @Override // com.xiaomi.push.fx
    /* renamed from: a */
    public byte[] mo918a() {
        try {
            dx.b bVar = new dx.b();
            bVar.a(bv.a().m1209a());
            return bVar.m852a();
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m586a("getOBBString err: " + e.toString());
            return null;
        }
    }
}
