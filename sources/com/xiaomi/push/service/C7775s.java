package com.xiaomi.push.service;

import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.push.Cif;
import com.xiaomi.push.hj;
import com.xiaomi.push.hw;
import com.xiaomi.push.ii;
import com.xiaomi.push.it;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
/* renamed from: com.xiaomi.push.service.s */
/* loaded from: classes11.dex */
class C7775s extends XMPushService.AbstractC7707j {
    final /* synthetic */ C7773r a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f994a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ List f995a;
    final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C7775s(C7773r c7773r, int i, String str, List list, String str2) {
        super(i);
        this.a = c7773r;
        this.f994a = str;
        this.f995a = list;
        this.b = str2;
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC7707j
    /* renamed from: a */
    public String mo1157a() {
        return "Send tiny data.";
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC7707j
    /* renamed from: a */
    public void mo878a() {
        String a;
        XMPushService xMPushService;
        a = this.a.a(this.f994a);
        ArrayList<ii> a2 = bz.a(this.f995a, this.f994a, a, 32768);
        if (a2 == null) {
            AbstractC7535b.d("TinyData LongConnUploader.upload Get a null XmPushActionNotification list when TinyDataHelper.pack() in XMPushService.");
            return;
        }
        Iterator<ii> it = a2.iterator();
        while (it.hasNext()) {
            ii next = it.next();
            next.a("uploadWay", "longXMPushService");
            Cif a3 = ah.a(this.f994a, a, next, hj.Notification);
            if (!TextUtils.isEmpty(this.b) && !TextUtils.equals(this.f994a, this.b)) {
                if (a3.m1022a() == null) {
                    hw hwVar = new hw();
                    hwVar.a("-1");
                    a3.a(hwVar);
                }
                a3.m1022a().b("ext_traffic_source_pkg", this.b);
            }
            byte[] a4 = it.a(a3);
            xMPushService = this.a.a;
            xMPushService.a(this.f994a, a4, true);
        }
    }
}
