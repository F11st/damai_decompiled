package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Base64;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.push.C7675im;
import com.xiaomi.push.C7688m;
import com.xiaomi.push.Cif;
import com.xiaomi.push.hj;
import com.xiaomi.push.it;
import com.xiaomi.push.service.C7782y;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class FCMPushHelper {
    private static Map<String, String> a(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("actionType", String.valueOf(hj.AckMessage.a()));
        hashMap.put("deviceStatus", String.valueOf((int) it.a(context, context.getPackageName())));
        hashMap.put("mat", Long.toString(System.currentTimeMillis()));
        return hashMap;
    }

    private static void a(Context context, Cif cif) {
        try {
            MiPushMessage generateMessage = PushMessageHelper.generateMessage((C7675im) ai.a(context, cif), cif.m1022a(), false);
            PushMessageReceiver a = C7572i.a(context);
            if (a != null) {
                a.onNotificationMessageArrived(context, generateMessage);
            }
        } catch (Throwable th) {
            AbstractC7535b.a("fcm broadcast notification come error ", th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(android.content.Context r7, byte[] r8) {
        /*
            com.xiaomi.mipush.sdk.ao r0 = com.xiaomi.mipush.sdk.ao.a(r7)
            boolean r0 = r0.m622a()
            java.lang.String r1 = r7.getPackageName()
            java.lang.String r2 = "com.xiaomi.xmsf"
            boolean r1 = r2.equals(r1)
            r3 = 1
            r1 = r1 ^ r3
            boolean r4 = m599a(r7)
            r5 = 2
            r6 = 0
            if (r0 == 0) goto L69
            if (r1 == 0) goto L69
            if (r4 == 0) goto L69
            com.xiaomi.mipush.sdk.b r0 = com.xiaomi.mipush.sdk.C7564b.m629a(r7)
            java.lang.String r0 = r0.d()
            byte[] r8 = com.xiaomi.push.service.C7763n.a(r8, r0)
            if (r8 != 0) goto L31
            java.lang.String r0 = "fcm message encrypt failed"
            goto L84
        L31:
            java.lang.String r0 = android.util.Base64.encodeToString(r8, r5)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L42
            java.lang.String r0 = "fcm message buf base64 encode failed"
            com.xiaomi.channel.commonutils.logger.AbstractC7535b.m586a(r0)
            r3 = 0
            goto L67
        L42:
            android.content.Intent r1 = new android.content.Intent
            java.lang.String r4 = com.xiaomi.push.service.bk.n
            r1.<init>(r4)
            r1.setPackage(r2)
            java.lang.String r4 = "com.xiaomi.push.service.XMPushService"
            r1.setClassName(r2, r4)
            java.lang.String r2 = "ext_fcm_container_buffer"
            r1.putExtra(r2, r0)
            java.lang.String r0 = r7.getPackageName()
            java.lang.String r2 = "mipush_app_package"
            r1.putExtra(r2, r0)
            r7.startService(r1)
            java.lang.String r0 = "fcm message reroute to xmsf"
            com.xiaomi.channel.commonutils.logger.AbstractC7535b.m586a(r0)
        L67:
            r6 = r3
            goto L87
        L69:
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r2[r6] = r0
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)
            r2[r3] = r0
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r4)
            r2[r5] = r0
            java.lang.String r0 = "xmsf can not receive fcm msg - shouldUseMIUIPush=%s;isNotXmsf=%s;xmsfSupport=%s"
            java.lang.String r0 = java.lang.String.format(r0, r2)
        L84:
            com.xiaomi.channel.commonutils.logger.AbstractC7535b.m586a(r0)
        L87:
            if (r6 != 0) goto L95
            java.lang.String r0 = "fcm message post local"
            com.xiaomi.channel.commonutils.logger.AbstractC7535b.b(r0)
            com.xiaomi.push.if r0 = com.xiaomi.push.service.C7782y.a(r8)
            com.xiaomi.push.service.al.m1163a(r7, r0, r8)
        L95:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.FCMPushHelper.a(android.content.Context, byte[]):void");
    }

    /* renamed from: a  reason: collision with other method in class */
    private static boolean m599a(Context context) {
        return ((long) C7688m.b(context)) >= 50002000 && b(context);
    }

    private static boolean b(Context context) {
        return context.getSharedPreferences("mipush_extra", 0).getBoolean("is_xmsf_sup_decrypt", false);
    }

    public static void clearToken(Context context) {
        C7572i.m650a(context, EnumC7568e.ASSEMBLE_PUSH_FCM);
    }

    public static void convertMessage(Intent intent) {
        C7572i.a(intent);
    }

    public static boolean isFCMSwitchOpen(Context context) {
        return C7572i.m653a(context, EnumC7568e.ASSEMBLE_PUSH_FCM) && MiPushClient.getOpenFCMPush(context);
    }

    public static void notifyFCMNotificationCome(Context context, Map<String, String> map) {
        PushMessageReceiver a;
        String str = map.get("pushMsg");
        if (TextUtils.isEmpty(str) || (a = C7572i.a(context)) == null) {
            return;
        }
        a.onNotificationMessageArrived(context, C7572i.a(str));
    }

    public static Map<String, String> notifyFCMPassThoughMessageCome(Context context, Map<String, String> map) {
        PushMessageReceiver a;
        String str = map.get("pushMsg");
        if (!TextUtils.isEmpty(str) && (a = C7572i.a(context)) != null) {
            a.onReceivePassThroughMessage(context, C7572i.a(str));
        }
        String str2 = map.get("mipushContainer");
        if (TextUtils.isEmpty(str2)) {
            return new HashMap();
        }
        try {
            byte[] decode = Base64.decode(str2, 2);
            a(context, C7782y.a(decode));
            a(context, decode);
        } catch (Throwable th) {
            AbstractC7535b.a("fcm notify notification error ", th);
        }
        return a(context);
    }

    public static void persistIfXmsfSupDecrypt(Context context) {
        context.getSharedPreferences("mipush_extra", 0).edit().putBoolean("is_xmsf_sup_decrypt", ((long) C7688m.b(context)) >= 50002000).apply();
    }

    public static void reportFCMMessageDelete() {
        MiTinyDataClient.upload(C7572i.c(EnumC7568e.ASSEMBLE_PUSH_FCM), "fcm", 1L, "some fcm messages was deleted ");
    }

    public static void uploadToken(Context context, String str) {
        C7572i.m651a(context, EnumC7568e.ASSEMBLE_PUSH_FCM, str);
    }
}
