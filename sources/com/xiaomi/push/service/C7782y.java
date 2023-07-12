package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.push.C7667h;
import com.xiaomi.push.C7680j;
import com.xiaomi.push.C7688m;
import com.xiaomi.push.Cif;
import com.xiaomi.push.eo;
import com.xiaomi.push.fl;
import com.xiaomi.push.gh;
import com.xiaomi.push.gk;
import com.xiaomi.push.gm;
import com.xiaomi.push.gn;
import com.xiaomi.push.hb;
import com.xiaomi.push.hj;
import com.xiaomi.push.ht;
import com.xiaomi.push.hw;
import com.xiaomi.push.hz;
import com.xiaomi.push.ii;
import com.xiaomi.push.it;
import com.xiaomi.push.service.al;
import com.xiaomi.push.service.bg;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: com.xiaomi.push.service.y */
/* loaded from: classes11.dex */
public class C7782y {
    public static Intent a(byte[] bArr, long j) {
        Cif a = a(bArr);
        if (a == null) {
            return null;
        }
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.putExtra("mipush_payload", bArr);
        intent.putExtra("mrt", Long.toString(j));
        intent.setPackage(a.f624b);
        return intent;
    }

    public static Cif a(Context context, Cif cif) {
        return a(context, cif, (Map<String, String>) null);
    }

    public static Cif a(Context context, Cif cif, Map<String, String> map) {
        hz hzVar = new hz();
        hzVar.b(cif.m1023a());
        hw m1022a = cif.m1022a();
        if (m1022a != null) {
            hzVar.a(m1022a.m988a());
            hzVar.a(m1022a.m986a());
            if (!TextUtils.isEmpty(m1022a.m993b())) {
                hzVar.c(m1022a.m993b());
            }
        }
        hzVar.a(it.a(context, cif));
        Cif a = ah.a(cif.b(), cif.m1023a(), hzVar, hj.AckMessage);
        hw m1022a2 = cif.m1022a();
        if (m1022a2 != null) {
            m1022a2 = br.a(m1022a2.m987a());
        }
        m1022a2.a("mat", Long.toString(System.currentTimeMillis()));
        if (map != null) {
            try {
                if (map.size() > 0) {
                    for (String str : map.keySet()) {
                        m1022a2.a(str, map.get(str));
                    }
                }
            } catch (Throwable unused) {
            }
        }
        a.a(m1022a2);
        return a;
    }

    public static Cif a(byte[] bArr) {
        Cif cif = new Cif();
        try {
            it.a(cif, bArr);
            return cif;
        } catch (Throwable th) {
            AbstractC7535b.a(th);
            return null;
        }
    }

    public static void a(Context context, Cif cif, byte[] bArr) {
        try {
            al.a(cif);
            cif.m1022a();
            al.C7726c m1163a = al.m1163a(context, cif, bArr);
            if (m1163a.a > 0 && !TextUtils.isEmpty(m1163a.f887a)) {
                hb.a(context, m1163a.f887a, m1163a.a, true, false, System.currentTimeMillis());
            }
            if (!C7688m.m1119a(context) || !ag.a(context, cif, m1163a.f888a)) {
                b(context, cif, bArr);
                return;
            }
            ag.m1158a(context, cif);
            AbstractC7535b.m586a("consume this broadcast by tts");
        } catch (Exception e) {
            AbstractC7535b.m586a("notify push msg error " + e);
            e.printStackTrace();
        }
    }

    private static void a(XMPushService xMPushService, Cif cif) {
        xMPushService.a(new C7783z(4, xMPushService, cif));
    }

    private static void a(XMPushService xMPushService, Cif cif, ii iiVar) {
        xMPushService.a(new af(4, iiVar, cif, xMPushService));
    }

    private static void a(XMPushService xMPushService, Cif cif, String str) {
        xMPushService.a(new C7720ad(4, xMPushService, cif, str));
    }

    private static void a(XMPushService xMPushService, Cif cif, String str, String str2) {
        xMPushService.a(new C7721ae(4, xMPushService, cif, str, str2));
    }

    /* JADX WARN: Removed duplicated region for block: B:137:0x03c1  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x03db  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0425  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x03a3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(com.xiaomi.push.service.XMPushService r19, java.lang.String r20, byte[] r21, android.content.Intent r22) {
        /*
            Method dump skipped, instructions count: 1203
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.C7782y.a(com.xiaomi.push.service.XMPushService, java.lang.String, byte[], android.content.Intent):void");
    }

    private static void a(XMPushService xMPushService, byte[] bArr, long j) {
        Map<String, String> m989a;
        Cif a = a(bArr);
        if (a == null) {
            return;
        }
        if (TextUtils.isEmpty(a.f624b)) {
            AbstractC7535b.m586a("receive a mipush message without package name");
            return;
        }
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        Intent a2 = a(bArr, valueOf.longValue());
        String a3 = al.a(a);
        hb.a(xMPushService, a3, j, true, true, System.currentTimeMillis());
        hw m1022a = a.m1022a();
        if (m1022a != null && m1022a.m988a() != null) {
            AbstractC7535b.e(String.format("receive a message. appid=%1$s, msgid= %2$s, action=%3$s", a.m1023a(), bd.a(m1022a.m988a()), a.a()));
        }
        if (m1022a != null) {
            m1022a.a("mrt", Long.toString(valueOf.longValue()));
        }
        hj hjVar = hj.SendMessage;
        String str = "";
        if (hjVar == a.a() && C7779v.a(xMPushService).m1242a(a.f624b) && !al.m1167a(a)) {
            if (m1022a != null) {
                str = m1022a.m988a();
                if (al.e(a)) {
                    eo.a(xMPushService.getApplicationContext()).a(a.b(), al.b(a), str, "1");
                }
            }
            AbstractC7535b.m586a("Drop a message for unregistered, msgid=" + str);
            a(xMPushService, a, a.f624b);
        } else if (hjVar == a.a() && C7779v.a(xMPushService).m1244c(a.f624b) && !al.m1167a(a)) {
            if (m1022a != null) {
                str = m1022a.m988a();
                if (al.e(a)) {
                    eo.a(xMPushService.getApplicationContext()).a(a.b(), al.b(a), str, "2");
                }
            }
            AbstractC7535b.m586a("Drop a message for push closed, msgid=" + str);
            a(xMPushService, a, a.f624b);
        } else if (hjVar == a.a() && !TextUtils.equals(xMPushService.getPackageName(), "com.xiaomi.xmsf") && !TextUtils.equals(xMPushService.getPackageName(), a.f624b)) {
            AbstractC7535b.m586a("Receive a message with wrong package name, expect " + xMPushService.getPackageName() + ", received " + a.f624b);
            a(xMPushService, a, "unmatched_package", "package should be " + xMPushService.getPackageName() + ", but got " + a.f624b);
            if (m1022a == null || !al.e(a)) {
                return;
            }
            eo.a(xMPushService.getApplicationContext()).a(a.b(), al.b(a), m1022a.m988a(), "3");
        } else if (hjVar != a.a() || C7680j.a() != 999 || !C7680j.a(xMPushService, a3)) {
            if (m1022a == null || (m989a = m1022a.m989a()) == null || !m989a.containsKey("hide") || !"true".equalsIgnoreCase(m989a.get("hide"))) {
                a(xMPushService, a3, bArr, a2);
            } else {
                b(xMPushService, a);
            }
        } else {
            AbstractC7535b.m586a("Receive the uninstalled dual app message");
            try {
                ah.a(xMPushService, ah.a(a3, a.m1023a()));
                AbstractC7535b.m586a("uninstall " + a3 + " msg sent");
            } catch (gh e) {
                AbstractC7535b.d("Fail to send Message: " + e.getMessage());
                xMPushService.a(10, e);
            }
            al.m1164a((Context) xMPushService, a3);
        }
    }

    private static boolean a(Context context, Intent intent) {
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 32);
            if (queryBroadcastReceivers != null) {
                if (!queryBroadcastReceivers.isEmpty()) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    private static boolean a(Context context, String str) {
        Intent intent = new Intent("com.xiaomi.mipush.miui.CLICK_MESSAGE");
        intent.setPackage(str);
        Intent intent2 = new Intent("com.xiaomi.mipush.miui.RECEIVE_MESSAGE");
        intent2.setPackage(str);
        PackageManager packageManager = context.getPackageManager();
        try {
            List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 32);
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 32);
            if (queryBroadcastReceivers.isEmpty()) {
                if (queryIntentServices.isEmpty()) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            AbstractC7535b.a(e);
            return false;
        }
    }

    public static boolean a(Context context, String str, byte[] bArr) {
        if (C7667h.m943a(context, str)) {
            Intent intent = new Intent("com.xiaomi.mipush.MESSAGE_ARRIVED");
            intent.putExtra("mipush_payload", bArr);
            intent.setPackage(str);
            try {
                if (context.getPackageManager().queryBroadcastReceivers(intent, 0).isEmpty()) {
                    return false;
                }
                AbstractC7535b.m586a("broadcast message arrived.");
                context.sendBroadcast(intent, ah.a(str));
                return true;
            } catch (Exception e) {
                AbstractC7535b.m586a("meet error when broadcast message arrived. " + e);
                return false;
            }
        }
        return false;
    }

    private static boolean a(Cif cif) {
        return "com.xiaomi.xmsf".equals(cif.f624b) && cif.m1022a() != null && cif.m1022a().m989a() != null && cif.m1022a().m989a().containsKey("miui_package_name");
    }

    private static boolean a(XMPushService xMPushService, String str, Cif cif, hw hwVar) {
        boolean z = true;
        if (hwVar != null && hwVar.m989a() != null && hwVar.m989a().containsKey("__check_alive") && hwVar.m989a().containsKey("__awake")) {
            ii iiVar = new ii();
            iiVar.b(cif.m1023a());
            iiVar.d(str);
            iiVar.c(ht.AwakeSystemApp.f497a);
            iiVar.a(hwVar.m988a());
            iiVar.f636a = new HashMap();
            boolean m943a = C7667h.m943a(xMPushService.getApplicationContext(), str);
            iiVar.f636a.put("app_running", Boolean.toString(m943a));
            if (!m943a) {
                boolean parseBoolean = Boolean.parseBoolean(hwVar.m989a().get("__awake"));
                iiVar.f636a.put("awaked", Boolean.toString(parseBoolean));
                if (!parseBoolean) {
                    z = false;
                }
            }
            try {
                ah.a(xMPushService, ah.a(cif.b(), cif.m1023a(), iiVar, hj.Notification));
            } catch (gh e) {
                AbstractC7535b.a(e);
            }
        }
        return z;
    }

    private static void b(Context context, Cif cif, byte[] bArr) {
        if (al.m1167a(cif)) {
            return;
        }
        String a = al.a(cif);
        if (TextUtils.isEmpty(a) || a(context, a, bArr)) {
            return;
        }
        eo.a(context).b(a, al.b(cif), cif.m1022a().m988a(), "1");
    }

    private static void b(XMPushService xMPushService, Cif cif) {
        xMPushService.a(new aa(4, xMPushService, cif));
    }

    private static boolean b(Cif cif) {
        Map<String, String> m989a = cif.m1022a().m989a();
        return m989a != null && m989a.containsKey("notify_effect");
    }

    private static void c(XMPushService xMPushService, Cif cif) {
        xMPushService.a(new C7719ab(4, xMPushService, cif));
    }

    private static boolean c(Cif cif) {
        if (cif.m1022a() == null || cif.m1022a().m989a() == null) {
            return false;
        }
        return "1".equals(cif.m1022a().m989a().get("obslete_ads_message"));
    }

    private static void d(XMPushService xMPushService, Cif cif) {
        xMPushService.a(new ac(4, xMPushService, cif));
    }

    public void a(Context context, bg.C7737b c7737b, boolean z, int i, String str) {
        C7776t m1238a;
        if (z || (m1238a = C7777u.m1238a(context)) == null || !"token-expired".equals(str)) {
            return;
        }
        C7777u.a(context, m1238a.f, m1238a.d, m1238a.e);
    }

    public void a(XMPushService xMPushService, fl flVar, bg.C7737b c7737b) {
        try {
            a(xMPushService, flVar.m893a(c7737b.h), flVar.c());
        } catch (IllegalArgumentException e) {
            AbstractC7535b.a(e);
        }
    }

    public void a(XMPushService xMPushService, gn gnVar, bg.C7737b c7737b) {
        if (!(gnVar instanceof gm)) {
            AbstractC7535b.m586a("not a mipush message");
            return;
        }
        gm gmVar = (gm) gnVar;
        gk a = gmVar.a("s");
        if (a != null) {
            try {
                a(xMPushService, bp.a(bp.a(c7737b.h, gmVar.j()), a.c()), hb.a(gnVar.mo926a()));
            } catch (IllegalArgumentException e) {
                AbstractC7535b.a(e);
            }
        }
    }
}
