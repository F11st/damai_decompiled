package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.ba;
import com.xiaomi.push.bp;
import com.xiaomi.push.hj;
import com.xiaomi.push.ht;
import com.xiaomi.push.hw;
import com.xiaomi.push.ii;
import com.xiaomi.push.service.bd;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class aw implements Runnable {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ boolean f59a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(Context context, boolean z) {
        this.a = context;
        this.f59a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        String d;
        String d2;
        Map<String, String> map;
        String d3;
        String str;
        String c;
        String c2;
        com.xiaomi.channel.commonutils.logger.b.m586a("do sync info");
        ii iiVar = new ii(bd.a(), false);
        b m629a = b.m629a(this.a);
        iiVar.c(ht.SyncInfo.f497a);
        iiVar.b(m629a.m630a());
        iiVar.d(this.a.getPackageName());
        HashMap hashMap = new HashMap();
        iiVar.f636a = hashMap;
        Context context = this.a;
        com.xiaomi.push.n.a(hashMap, "app_version", com.xiaomi.push.h.m941a(context, context.getPackageName()));
        Map<String, String> map2 = iiVar.f636a;
        Context context2 = this.a;
        com.xiaomi.push.n.a(map2, Constants.EXTRA_KEY_APP_VERSION_CODE, Integer.toString(com.xiaomi.push.h.a(context2, context2.getPackageName())));
        com.xiaomi.push.n.a(iiVar.f636a, "push_sdk_vn", "4_9_1");
        com.xiaomi.push.n.a(iiVar.f636a, "push_sdk_vc", Integer.toString(40091));
        com.xiaomi.push.n.a(iiVar.f636a, "token", m629a.b());
        if (!com.xiaomi.push.m.m1124d()) {
            String a = bp.a(com.xiaomi.push.j.d(this.a));
            String f = com.xiaomi.push.j.f(this.a);
            if (!TextUtils.isEmpty(f)) {
                a = a + "," + f;
            }
            if (!TextUtils.isEmpty(a)) {
                com.xiaomi.push.n.a(iiVar.f636a, Constants.EXTRA_KEY_IMEI_MD5, a);
            }
        }
        ba.a(this.a).a(iiVar.f636a);
        com.xiaomi.push.n.a(iiVar.f636a, Constants.EXTRA_KEY_REG_ID, m629a.m637c());
        com.xiaomi.push.n.a(iiVar.f636a, Constants.EXTRA_KEY_REG_SECRET, m629a.d());
        com.xiaomi.push.n.a(iiVar.f636a, Constants.EXTRA_KEY_ACCEPT_TIME, MiPushClient.getAcceptTime(this.a).replace(",", "-"));
        if (this.f59a) {
            Map<String, String> map3 = iiVar.f636a;
            c = av.c(MiPushClient.getAllAlias(this.a));
            com.xiaomi.push.n.a(map3, Constants.EXTRA_KEY_ALIASES_MD5, c);
            Map<String, String> map4 = iiVar.f636a;
            c2 = av.c(MiPushClient.getAllTopic(this.a));
            com.xiaomi.push.n.a(map4, Constants.EXTRA_KEY_TOPICS_MD5, c2);
            map = iiVar.f636a;
            d3 = av.c(MiPushClient.getAllUserAccount(this.a));
            str = Constants.EXTRA_KEY_ACCOUNTS_MD5;
        } else {
            Map<String, String> map5 = iiVar.f636a;
            d = av.d(MiPushClient.getAllAlias(this.a));
            com.xiaomi.push.n.a(map5, Constants.EXTRA_KEY_ALIASES, d);
            Map<String, String> map6 = iiVar.f636a;
            d2 = av.d(MiPushClient.getAllTopic(this.a));
            com.xiaomi.push.n.a(map6, Constants.EXTRA_KEY_TOPICS, d2);
            map = iiVar.f636a;
            d3 = av.d(MiPushClient.getAllUserAccount(this.a));
            str = Constants.EXTRA_KEY_ACCOUNTS;
        }
        com.xiaomi.push.n.a(map, str, d3);
        ao.a(this.a).a((ao) iiVar, hj.Notification, false, (hw) null);
    }
}
