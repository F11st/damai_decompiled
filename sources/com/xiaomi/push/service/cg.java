package com.xiaomi.push.service;

import android.content.Context;
import android.util.Log;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.push.C7787w;
import com.xiaomi.push.ht;
import com.xiaomi.push.ii;
import com.xiaomi.push.service.XMPushService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class cg implements XMPushService.InterfaceC7711n {
    private static Context a;

    /* renamed from: a  reason: collision with other field name */
    private static final boolean f962a = Log.isLoggable("UNDatas", 3);

    /* renamed from: a  reason: collision with other field name */
    private static final Map<Integer, Map<String, List<String>>> f961a = new HashMap();

    public cg(Context context) {
        a = context;
    }

    private static ii a(String str, String str2, String str3, String str4) {
        ii iiVar = new ii();
        if (str3 != null) {
            iiVar.c(str3);
        }
        if (str != null) {
            iiVar.b(str);
        }
        if (str2 != null) {
            iiVar.a(str2);
        }
        if (str4 != null) {
            iiVar.d(str4);
        }
        iiVar.a(false);
        return iiVar;
    }

    private static void a(Context context, ii iiVar) {
        if (f962a) {
            AbstractC7535b.b("UNDatas upload message notification:" + iiVar);
        }
        com.xiaomi.push.al.a(context).a(new ch(iiVar));
    }

    private static void b() {
        HashMap hashMap = new HashMap();
        hashMap.putAll(f961a);
        if (hashMap.size() > 0) {
            for (Integer num : hashMap.keySet()) {
                Map map = (Map) hashMap.get(num);
                if (map != null && map.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    for (String str : map.keySet()) {
                        sb.append(str);
                        sb.append(":");
                        List list = (List) map.get(str);
                        if (!C7787w.a(list)) {
                            for (int i = 0; i < list.size(); i++) {
                                if (i != 0) {
                                    sb.append(",");
                                }
                                sb.append((String) list.get(i));
                            }
                        }
                        sb.append(";");
                    }
                    ii a2 = a(null, bd.a(), ht.NotificationRemoved.f497a, null);
                    a2.a("removed_reason", String.valueOf(num));
                    a2.a("all_delete_msgId_appId", sb.toString());
                    AbstractC7535b.b("UNDatas upload all removed messages reason: " + num + " allIds: " + sb.toString());
                    a(a, a2);
                }
                f961a.remove(num);
            }
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.InterfaceC7711n
    /* renamed from: a */
    public void mo951a() {
        Map<Integer, Map<String, List<String>>> map = f961a;
        if (map.size() > 0) {
            synchronized (map) {
                b();
            }
        }
    }
}
