package com.huawei.hms.push;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.push.utils.PluginUtil;
import com.huawei.hms.support.log.HMSLog;

/* compiled from: Taobao */
/* renamed from: com.huawei.hms.push.i */
/* loaded from: classes10.dex */
public class C5688i {
    public static void a(Context context, Intent intent) {
        try {
            if (context != null && intent != null) {
                String action = intent.getAction();
                if ("com.huawei.intent.action.PUSH".equals(action) || "com.huawei.push.msg.NOTIFY_MSG".equals(action) || "com.huawei.intent.action.PUSH_DELAY_NOTIFY".equals(action)) {
                    byte[] byteArrayExtra = intent.getByteArrayExtra("selfshow_info");
                    byte[] byteArrayExtra2 = intent.getByteArrayExtra("selfshow_token");
                    if (byteArrayExtra != null && byteArrayExtra2 != null && byteArrayExtra.length != 0 && byteArrayExtra2.length != 0) {
                        a(context, intent, byteArrayExtra, byteArrayExtra2);
                        return;
                    }
                    HMSLog.i("PushSelfShowLog", "self show info or token is null.");
                    return;
                }
                return;
            }
            HMSLog.d("PushSelfShowLog", "enter SelfShowReceiver receiver, context or intent is null");
        } catch (RuntimeException e) {
            HMSLog.e("PushSelfShowLog", "onReceive RuntimeException.", e);
        } catch (Exception unused) {
            HMSLog.d("PushSelfShowLog", "onReceive Exception.");
        }
    }

    public static void a(Context context, Intent intent, byte[] bArr, byte[] bArr2) {
        String stringExtra = intent.getStringExtra("selfshow_event_id");
        int intExtra = intent.getIntExtra("selfshow_notify_id", 0);
        HMSLog.i("PushSelfShowLog", "get notifyId:" + intExtra);
        C5690k c5690k = new C5690k(bArr, bArr2);
        if (!c5690k.z()) {
            HMSLog.d("PushSelfShowLog", "parseMessage failed");
            return;
        }
        HMSLog.i("PushSelfShowLog", "onReceive the msg id = " + c5690k.p() + ",and cmd is " + c5690k.i() + ",and the eventId is " + stringExtra);
        if (stringExtra == null) {
            a(context, intent, c5690k);
        } else {
            a(context, intent, stringExtra, c5690k, intExtra);
        }
    }

    public static void a(Context context, Intent intent, C5690k c5690k) {
        HMSLog.i("PushSelfShowLog", "receive a selfshow message, the cmd type is " + c5690k.i());
        if (C5689j.a(c5690k.i())) {
            long a = C5696q.a(c5690k.c());
            if (a == 0) {
                new C5695p(context, c5690k).start();
                return;
            }
            HMSLog.d("PushSelfShowLog", "waiting...");
            intent.setPackage(context.getPackageName());
            C5696q.a(context, intent, a);
        }
    }

    public static void a(Context context, Intent intent, String str, C5690k c5690k, int i) {
        HMSLog.d("PushSelfShowLog", "receive a selfshow user handle message eventId = " + str);
        if (!"-1".equals(str)) {
            C5696q.a(context, intent);
        } else {
            C5696q.a(context, i);
        }
        if ("1".equals(str)) {
            new C5689j(context, c5690k).c();
            PluginUtil.onNotificationClicked(context, c5690k.p(), c5690k.b());
        } else if ("2".equals(str)) {
            C5684e.a(context, c5690k.p(), c5690k.b(), "2");
        } else {
            HMSLog.d("PushSelfShowLog", "other event");
        }
    }
}
