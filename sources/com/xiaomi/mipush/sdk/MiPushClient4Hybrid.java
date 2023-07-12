package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.b;
import com.xiaomi.push.bp;
import com.xiaomi.push.ey;
import com.xiaomi.push.h;
import com.xiaomi.push.hj;
import com.xiaomi.push.ht;
import com.xiaomi.push.hw;
import com.xiaomi.push.hx;
import com.xiaomi.push.hz;
import com.xiaomi.push.ii;
import com.xiaomi.push.ij;
import com.xiaomi.push.ik;
import com.xiaomi.push.ip;
import com.xiaomi.push.iq;
import com.xiaomi.push.it;
import com.xiaomi.push.service.bd;
import com.xiaomi.push.service.br;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class MiPushClient4Hybrid {
    private static MiPushCallback sCallback;
    private static Map<String, b.a> dataMap = new HashMap();
    private static Map<String, Long> sRegisterTimeMap = new HashMap();

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class MiPushCallback {
        public void onCommandResult(String str, MiPushCommandMessage miPushCommandMessage) {
        }

        public void onReceiveRegisterResult(String str, MiPushCommandMessage miPushCommandMessage) {
        }

        public void onReceiveUnregisterResult(String str, MiPushCommandMessage miPushCommandMessage) {
        }
    }

    private static void addPullNotificationTime(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        sharedPreferences.edit().putLong("last_pull_notification_" + str, System.currentTimeMillis()).commit();
    }

    private static short getDeviceStatus(MiPushMessage miPushMessage, boolean z) {
        String str = miPushMessage.getExtra() == null ? "" : miPushMessage.getExtra().get(Constants.EXTRA_KEY_HYBRID_DEVICE_STATUS);
        int intValue = TextUtils.isEmpty(str) ? 0 : Integer.valueOf(str).intValue();
        if (!z) {
            intValue = (intValue & (-4)) + h.a.NOT_ALLOWED.a();
        }
        return (short) intValue;
    }

    public static boolean isRegistered(Context context, String str) {
        return b.m629a(context).a(str) != null;
    }

    public static void onReceiveRegisterResult(Context context, ik ikVar) {
        b.a aVar;
        String c = ikVar.c();
        if (ikVar.a() == 0 && (aVar = dataMap.get(c)) != null) {
            aVar.a(ikVar.f692e, ikVar.f693f);
            b.m629a(context).a(c, aVar);
        }
        ArrayList arrayList = null;
        if (!TextUtils.isEmpty(ikVar.f692e)) {
            arrayList = new ArrayList();
            arrayList.add(ikVar.f692e);
        }
        MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(ey.COMMAND_REGISTER.f325a, arrayList, ikVar.f680a, ikVar.f691d, null, null);
        MiPushCallback miPushCallback = sCallback;
        if (miPushCallback != null) {
            miPushCallback.onReceiveRegisterResult(c, generateCommandMessage);
        }
    }

    public static void onReceiveUnregisterResult(Context context, iq iqVar) {
        MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(ey.COMMAND_UNREGISTER.f325a, null, iqVar.f758a, iqVar.f766d, null, null);
        String a = iqVar.a();
        MiPushCallback miPushCallback = sCallback;
        if (miPushCallback != null) {
            miPushCallback.onReceiveUnregisterResult(a, generateCommandMessage);
        }
    }

    public static void registerPush(Context context, String str, String str2, String str3) {
        if (b.m629a(context).m634a(str2, str3, str)) {
            ArrayList arrayList = new ArrayList();
            b.a a = b.m629a(context).a(str);
            if (a != null) {
                arrayList.add(a.c);
                MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(ey.COMMAND_REGISTER.f325a, arrayList, 0L, null, null, null);
                MiPushCallback miPushCallback = sCallback;
                if (miPushCallback != null) {
                    miPushCallback.onReceiveRegisterResult(str, generateCommandMessage);
                }
            }
            if (shouldPullNotification(context, str)) {
                ii iiVar = new ii();
                iiVar.b(str2);
                iiVar.c(ht.PullOfflineMessage.f497a);
                iiVar.a(bd.a());
                iiVar.a(false);
                ao.a(context).a(iiVar, hj.Notification, false, true, null, false, str, str2);
                com.xiaomi.channel.commonutils.logger.b.b("MiPushClient4Hybrid pull offline pass through message");
                addPullNotificationTime(context, str);
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - (sRegisterTimeMap.get(str) != null ? sRegisterTimeMap.get(str).longValue() : 0L)) < DanmakuFactory.DEFAULT_DANMAKU_DURATION_V) {
            com.xiaomi.channel.commonutils.logger.b.m586a("MiPushClient4Hybrid  Could not send register message within 5s repeatedly.");
            return;
        }
        sRegisterTimeMap.put(str, Long.valueOf(currentTimeMillis));
        String a2 = bp.a(6);
        b.a aVar = new b.a(context);
        aVar.c(str2, str3, a2);
        dataMap.put(str, aVar);
        ij ijVar = new ij();
        ijVar.a(bd.a());
        ijVar.b(str2);
        ijVar.e(str3);
        ijVar.d(str);
        ijVar.f(a2);
        ijVar.c(com.xiaomi.push.h.m941a(context, context.getPackageName()));
        ijVar.b(com.xiaomi.push.h.a(context, context.getPackageName()));
        ijVar.h("4_9_1");
        ijVar.a(40091);
        ijVar.a(hx.Init);
        if (!com.xiaomi.push.m.m1124d()) {
            String e = com.xiaomi.push.j.e(context);
            if (!TextUtils.isEmpty(e)) {
                ijVar.i(bp.a(e));
            }
        }
        int a3 = com.xiaomi.push.j.a();
        if (a3 >= 0) {
            ijVar.c(a3);
        }
        ii iiVar2 = new ii();
        iiVar2.c(ht.HybridRegister.f497a);
        iiVar2.b(b.m629a(context).m630a());
        iiVar2.d(context.getPackageName());
        iiVar2.a(it.a(ijVar));
        iiVar2.a(bd.a());
        ao.a(context).a((ao) iiVar2, hj.Notification, (hw) null);
    }

    public static void removeDuplicateCache(Context context, MiPushMessage miPushMessage) {
        String str = miPushMessage.getExtra() != null ? miPushMessage.getExtra().get("jobkey") : null;
        if (TextUtils.isEmpty(str)) {
            str = miPushMessage.getMessageId();
        }
        am.a(context, str);
    }

    public static void reportMessageArrived(Context context, MiPushMessage miPushMessage, boolean z) {
        if (miPushMessage == null || miPushMessage.getExtra() == null) {
            com.xiaomi.channel.commonutils.logger.b.m586a("do not ack message, message is null");
            return;
        }
        try {
            hz hzVar = new hz();
            hzVar.b(b.m629a(context).m630a());
            hzVar.a(miPushMessage.getMessageId());
            hzVar.a(Long.valueOf(miPushMessage.getExtra().get(Constants.EXTRA_KEY_HYBRID_MESSAGE_TS)).longValue());
            hzVar.a(getDeviceStatus(miPushMessage, z));
            if (!TextUtils.isEmpty(miPushMessage.getTopic())) {
                hzVar.c(miPushMessage.getTopic());
            }
            ao.a(context).a((ao) hzVar, hj.AckMessage, false, br.a(PushMessageHelper.generateMessage(miPushMessage)));
            com.xiaomi.channel.commonutils.logger.b.b("MiPushClient4Hybrid ack mina message, messageId is " + miPushMessage.getMessageId());
        } finally {
            try {
            } finally {
            }
        }
    }

    public static void reportMessageClicked(Context context, MiPushMessage miPushMessage) {
        MiPushClient.reportMessageClicked(context, miPushMessage);
    }

    public static void setCallback(MiPushCallback miPushCallback) {
        sCallback = miPushCallback;
    }

    private static boolean shouldPullNotification(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        StringBuilder sb = new StringBuilder();
        sb.append("last_pull_notification_");
        sb.append(str);
        return Math.abs(System.currentTimeMillis() - sharedPreferences.getLong(sb.toString(), -1L)) > 300000;
    }

    public static void unregisterPush(Context context, String str) {
        sRegisterTimeMap.remove(str);
        b.a a = b.m629a(context).a(str);
        if (a == null) {
            return;
        }
        ip ipVar = new ip();
        ipVar.a(bd.a());
        ipVar.d(str);
        ipVar.b(a.f65a);
        ipVar.c(a.c);
        ipVar.e(a.b);
        ii iiVar = new ii();
        iiVar.c(ht.HybridUnregister.f497a);
        iiVar.b(b.m629a(context).m630a());
        iiVar.d(context.getPackageName());
        iiVar.a(it.a(ipVar));
        iiVar.a(bd.a());
        ao.a(context).a((ao) iiVar, hj.Notification, (hw) null);
        b.m629a(context).b(str);
    }

    public static void uploadClearMessageData(Context context, LinkedList<? extends Object> linkedList) {
        com.xiaomi.push.service.al.a(context, linkedList);
    }
}
