package com.xiaomi.push.service;

import android.content.Context;
import android.os.Messenger;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.Cif;
import com.xiaomi.push.db;
import com.xiaomi.push.fl;
import com.xiaomi.push.fw;
import com.xiaomi.push.gh;
import com.xiaomi.push.gn;
import com.xiaomi.push.hj;
import com.xiaomi.push.ht;
import com.xiaomi.push.hw;
import com.xiaomi.push.hy;
import com.xiaomi.push.ii;
import com.xiaomi.push.it;
import com.xiaomi.push.iu;
import com.xiaomi.push.iz;
import com.xiaomi.push.service.bg;
import java.nio.ByteBuffer;
import java.util.Map;
import tb.m80;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class ah {
    static fl a(XMPushService xMPushService, byte[] bArr) {
        Cif cif = new Cif();
        try {
            it.a(cif, bArr);
            return a(u.m1238a((Context) xMPushService), xMPushService, cif);
        } catch (iz e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return null;
        }
    }

    static fl a(t tVar, Context context, Cif cif) {
        try {
            fl flVar = new fl();
            flVar.a(5);
            flVar.c(tVar.f996a);
            flVar.b(a(cif));
            flVar.a("SECMSG", "message");
            String str = tVar.f996a;
            cif.f619a.f546a = str.substring(0, str.indexOf(m80.DINAMIC_PREFIX_AT));
            cif.f619a.f550c = str.substring(str.indexOf("/") + 1);
            flVar.a(it.a(cif), tVar.c);
            flVar.a((short) 1);
            com.xiaomi.channel.commonutils.logger.b.m586a("try send mi push message. packagename:" + cif.f624b + " action:" + cif.f617a);
            return flVar;
        } catch (NullPointerException e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Cif a(String str, String str2) {
        ii iiVar = new ii();
        iiVar.b(str2);
        iiVar.c("package uninstalled");
        iiVar.a(gn.i());
        iiVar.a(false);
        return a(str, str2, iiVar, hj.Notification);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends iu<T, ?>> Cif a(String str, String str2, T t, hj hjVar) {
        return a(str, str2, t, hjVar, true);
    }

    private static <T extends iu<T, ?>> Cif a(String str, String str2, T t, hj hjVar, boolean z) {
        byte[] a = it.a(t);
        Cif cif = new Cif();
        hy hyVar = new hy();
        hyVar.f545a = 5L;
        hyVar.f546a = "fakeid";
        cif.a(hyVar);
        cif.a(ByteBuffer.wrap(a));
        cif.a(hjVar);
        cif.b(z);
        cif.b(str);
        cif.a(false);
        cif.a(str2);
        return cif;
    }

    private static String a(Cif cif) {
        Map<String, String> map;
        hw hwVar = cif.f618a;
        if (hwVar != null && (map = hwVar.f536b) != null) {
            String str = map.get("ext_traffic_source_pkg");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return cif.f624b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str) {
        return str + ".permission.MIPUSH_RECEIVE";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(XMPushService xMPushService) {
        t m1238a = u.m1238a(xMPushService.getApplicationContext());
        if (m1238a != null) {
            bg.b a = u.m1238a(xMPushService.getApplicationContext()).a(xMPushService);
            com.xiaomi.channel.commonutils.logger.b.m586a("prepare account. " + a.f925a);
            a(xMPushService, a);
            bg.a().a(a);
            bx.a(xMPushService).a(new ai("GAID", 172800L, xMPushService, m1238a));
            a(xMPushService, m1238a, 172800);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(XMPushService xMPushService, Cif cif) {
        db.a(cif.b(), xMPushService.getApplicationContext(), cif, -1);
        fw m1147a = xMPushService.m1147a();
        if (m1147a == null) {
            throw new gh("try send msg while connection is null.");
        }
        if (!m1147a.mo902a()) {
            throw new gh("Don't support XMPP connection.");
        }
        fl a = a(u.m1238a((Context) xMPushService), xMPushService, cif);
        if (a != null) {
            m1147a.b(a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(XMPushService xMPushService, bg.b bVar) {
        bVar.a((Messenger) null);
        bVar.a(new ak(xMPushService));
    }

    private static void a(XMPushService xMPushService, t tVar, int i) {
        bx.a(xMPushService).a(new aj("MSAID", i, xMPushService, tVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(XMPushService xMPushService, String str, byte[] bArr) {
        db.a(str, xMPushService.getApplicationContext(), bArr);
        fw m1147a = xMPushService.m1147a();
        if (m1147a == null) {
            throw new gh("try send msg while connection is null.");
        }
        if (!m1147a.mo902a()) {
            throw new gh("Don't support XMPP connection.");
        }
        fl a = a(xMPushService, bArr);
        if (a != null) {
            m1147a.b(a);
        } else {
            x.a(xMPushService, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, "not a valid message");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Cif b(String str, String str2) {
        ii iiVar = new ii();
        iiVar.b(str2);
        iiVar.c(ht.AppDataCleared.f497a);
        iiVar.a(bd.a());
        iiVar.a(false);
        return a(str, str2, iiVar, hj.Notification);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends iu<T, ?>> Cif b(String str, String str2, T t, hj hjVar) {
        return a(str, str2, t, hjVar, false);
    }
}
