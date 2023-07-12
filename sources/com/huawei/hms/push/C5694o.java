package com.huawei.hms.push;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.support.api.push.TransActivity;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;
import org.android.agoo.message.MessageService;

/* compiled from: Taobao */
/* renamed from: com.huawei.hms.push.o */
/* loaded from: classes10.dex */
public class C5694o {
    public static int a;

    public static synchronized void a(Context context, C5690k c5690k) {
        int hashCode;
        int i;
        int i2;
        int hashCode2;
        synchronized (C5694o.class) {
            if (context != null) {
                if (!a(c5690k)) {
                    HMSLog.d("PushSelfShowLog", "showNotification, the msg id = " + c5690k.p());
                    if (a == 0) {
                        a = (context.getPackageName() + System.currentTimeMillis()).hashCode();
                    }
                    if (TextUtils.isEmpty(c5690k.l())) {
                        String q = c5690k.q();
                        if (!TextUtils.isEmpty(q)) {
                            int hashCode3 = q.hashCode();
                            c5690k.a(hashCode3);
                            HMSLog.d("PushSelfShowLog", "notification msgTag = " + hashCode3);
                        }
                        if (c5690k.s() != -1) {
                            hashCode = c5690k.s();
                            i = (c5690k.k() + System.currentTimeMillis()).hashCode();
                            i2 = i + 1;
                            hashCode2 = (c5690k.s() + c5690k.k() + context.getPackageName()).hashCode();
                        } else {
                            hashCode = a + 1;
                            a = hashCode;
                            i = hashCode + 1;
                            a = i;
                            i2 = i + 1;
                            a = i2;
                            hashCode2 = i2 + 1;
                            a = hashCode2;
                        }
                    } else {
                        hashCode = (c5690k.l() + c5690k.k()).hashCode();
                        i = a + 1;
                        a = i;
                        i2 = i + 1;
                        a = i2;
                        hashCode2 = (c5690k.l() + c5690k.k() + context.getPackageName()).hashCode();
                    }
                    HMSLog.d("PushSelfShowLog", "notifyId:" + hashCode + ",openNotifyId:" + i + ",delNotifyId:" + i2 + ",alarmNotifyId:" + hashCode2);
                    int[] iArr = new int[4];
                    iArr[0] = hashCode;
                    iArr[1] = i;
                    iArr[2] = i2;
                    if (c5690k.f() <= 0) {
                        hashCode2 = 0;
                    }
                    iArr[3] = hashCode2;
                    Notification a2 = C5696q.e() ? a(context, c5690k, iArr) : null;
                    NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                    if (notificationManager != null && a2 != null) {
                        if (Build.VERSION.SDK_INT >= 26) {
                            notificationManager.createNotificationChannel(new NotificationChannel("HwPushChannelID", context.getString(ResourceLoaderUtil.getStringId("hms_push_channel")), 3));
                        }
                        notificationManager.notify(hashCode, a2);
                        d(context, c5690k, iArr);
                        C5684e.a(context, c5690k.p(), c5690k.b(), MessageService.MSG_DB_COMPLETE);
                    }
                }
            }
        }
    }

    public static PendingIntent b(Context context, C5690k c5690k, int[] iArr) {
        Intent a2 = a(context, c5690k, iArr, "2", 268435456);
        if (a()) {
            a2.setClass(context, TransActivity.class);
            a2.setFlags(268468224);
            return PendingIntent.getActivity(context, iArr[2], a2, C5696q.b());
        }
        return PendingIntent.getBroadcast(context, iArr[2], a2, C5696q.b());
    }

    public static PendingIntent c(Context context, C5690k c5690k, int[] iArr) {
        Intent a2 = a(context, c5690k, iArr, "1", 268435456);
        if (a()) {
            a2.setClass(context, TransActivity.class);
            a2.setFlags(268468224);
            return PendingIntent.getActivity(context, iArr[1], a2, C5696q.b());
        }
        return PendingIntent.getBroadcast(context, iArr[1], a2, C5696q.b());
    }

    public static void d(Context context, C5690k c5690k, int[] iArr) {
        HMSLog.i("PushSelfShowLog", "setAutoClear time is: " + c5690k.f());
        if (c5690k.f() <= 0) {
            return;
        }
        a(context, a(context, c5690k, iArr, "-1", 32), c5690k.f(), iArr[3]);
    }

    public static void d(C5690k c5690k, Notification.Builder builder) {
        String u = c5690k.u();
        String j = c5690k.j();
        if (TextUtils.isEmpty(j)) {
            builder.setContentText(u);
            return;
        }
        builder.setContentText(j);
        if (TextUtils.isEmpty(u)) {
            return;
        }
        builder.setContentTitle(u);
    }

    public static void c(C5690k c5690k, Notification.Builder builder) {
        builder.setTicker(c5690k.x());
    }

    @SuppressLint({"NewApi"})
    public static void b(Context context, Notification.Builder builder, C5690k c5690k) {
        if ("com.huawei.android.pushagent".equals(context.getPackageName())) {
            Bundle bundle = new Bundle();
            String k = c5690k.k();
            if (TextUtils.isEmpty(k)) {
                return;
            }
            bundle.putString("hw_origin_sender_package_name", k);
            builder.setExtras(bundle);
        }
    }

    public static void b(C5690k c5690k, Notification.Builder builder) {
        String t = c5690k.t();
        if (TextUtils.isEmpty(t)) {
            return;
        }
        builder.setSubText(t);
    }

    public static boolean a() {
        return Build.VERSION.SDK_INT >= 30;
    }

    public static Intent a(Context context, C5690k c5690k, int[] iArr, String str, int i) {
        Intent intent = new Intent("com.huawei.intent.action.PUSH_DELAY_NOTIFY");
        intent.putExtra("selfshow_info", c5690k.o()).putExtra("selfshow_token", c5690k.y()).putExtra("selfshow_event_id", str).putExtra("selfshow_notify_id", iArr[0]).putExtra("selfshow_auto_clear_id", iArr[3]).setPackage(context.getPackageName()).setFlags(i);
        return intent;
    }

    public static Notification a(Context context, C5690k c5690k, int[] iArr) {
        Notification.Builder builder = new Notification.Builder(context);
        if (C5692m.a(c5690k) == EnumC5693n.STYLE_BIGTEXT) {
            C5692m.a(builder, c5690k.g(), c5690k);
        }
        C5691l.a(context, builder, c5690k);
        b(c5690k, builder);
        d(c5690k, builder);
        a(context, c5690k, builder);
        a(builder);
        a(c5690k, builder);
        c(c5690k, builder);
        builder.setContentIntent(c(context, c5690k, iArr));
        builder.setDeleteIntent(b(context, c5690k, iArr));
        if (Build.VERSION.SDK_INT >= 26) {
            builder.setChannelId("HwPushChannelID");
        }
        b(context, builder, c5690k);
        a(context, builder, c5690k);
        return builder.build();
    }

    @SuppressLint({"NewApi"})
    public static void a(Context context, Notification.Builder builder, C5690k c5690k) {
        if (HwBuildEx.VERSION.EMUI_SDK_INT < 11 || !C5696q.a(context)) {
            return;
        }
        Bundle bundle = new Bundle();
        String k = c5690k.k();
        HMSLog.i("PushSelfShowLog", "the package name of notification is:" + k);
        if (!TextUtils.isEmpty(k)) {
            String a2 = C5696q.a(context, k);
            HMSLog.i("PushSelfShowLog", "the app name is:" + a2);
            if (a2 != null) {
                bundle.putCharSequence("android.extraAppName", a2);
            }
        }
        builder.setExtras(bundle);
    }

    public static void a(Context context, Intent intent, long j, int i) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("enter setDelayAlarm(interval:");
            sb.append(j);
            sb.append("ms.");
            HMSLog.d("PushSelfShowLog", sb.toString());
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            if (alarmManager != null) {
                alarmManager.set(0, System.currentTimeMillis() + j, PendingIntent.getBroadcast(context, i, intent, C5696q.b()));
            }
        } catch (Exception e) {
            HMSLog.w("PushSelfShowLog", "set DelayAlarm error." + e.toString());
        }
    }

    public static void a(Context context, C5690k c5690k, Notification.Builder builder) {
        Bitmap a2 = C5691l.a(context, c5690k);
        if (a2 != null) {
            builder.setLargeIcon(a2);
        }
    }

    public static void a(Notification.Builder builder) {
        builder.setShowWhen(true);
        builder.setWhen(System.currentTimeMillis());
    }

    public static void a(C5690k c5690k, Notification.Builder builder) {
        builder.setAutoCancel(c5690k.e() == 1);
        builder.setOngoing(false);
    }

    public static boolean a(C5690k c5690k) {
        return c5690k == null || (TextUtils.isEmpty(c5690k.u()) && TextUtils.isEmpty(c5690k.j()));
    }
}
