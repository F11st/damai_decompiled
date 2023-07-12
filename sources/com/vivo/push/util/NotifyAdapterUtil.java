package com.vivo.push.util;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.vivo.push.C7481e;
import com.vivo.push.b.C7428p;
import com.vivo.push.c.C7443d;
import com.vivo.push.d.C7471r;
import com.vivo.push.model.InsideNotificationItem;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class NotifyAdapterUtil {
    private static final int HIDE_TITLE = 1;
    public static final int NOTIFY_MULTITERM_STYLE = 1;
    public static final int NOTIFY_SINGLE_STYLE = 0;
    public static final String PRIMARY_CHANNEL = "vivo_push_channel";
    private static final String PUSH_EN = "PUSH";
    private static final String PUSH_ID = "pushId";
    private static final String PUSH_ZH = "推送通知";
    private static final String TAG = "NotifyManager";
    private static NotificationManager sNotificationManager = null;
    private static int sNotifyId = 20000000;

    private static boolean cancelNotify(Context context, int i) {
        initAdapter(context);
        NotificationManager notificationManager = sNotificationManager;
        if (notificationManager != null) {
            notificationManager.cancel(i);
            return true;
        }
        return false;
    }

    private static synchronized void initAdapter(Context context) {
        NotificationManager notificationManager;
        synchronized (NotifyAdapterUtil.class) {
            if (sNotificationManager == null) {
                sNotificationManager = (NotificationManager) context.getSystemService("notification");
            }
            if (Build.VERSION.SDK_INT >= 26 && (notificationManager = sNotificationManager) != null) {
                NotificationChannel notificationChannel = notificationManager.getNotificationChannel("default");
                if (notificationChannel != null) {
                    CharSequence name = notificationChannel.getName();
                    if (PUSH_ZH.equals(name) || PUSH_EN.equals(name)) {
                        sNotificationManager.deleteNotificationChannel("default");
                    }
                }
                NotificationChannel notificationChannel2 = new NotificationChannel(PRIMARY_CHANNEL, isZh(context) ? PUSH_ZH : PUSH_EN, 4);
                notificationChannel2.setLightColor(-16711936);
                notificationChannel2.enableVibration(true);
                notificationChannel2.setLockscreenVisibility(1);
                sNotificationManager.createNotificationChannel(notificationChannel2);
            }
        }
    }

    private static boolean isZh(Context context) {
        return context.getResources().getConfiguration().locale.getLanguage().endsWith("zh");
    }

    public static void pushNotification(Context context, List<Bitmap> list, InsideNotificationItem insideNotificationItem, long j, int i, C7471r.InterfaceC7472a interfaceC7472a) {
        C7523p.d(TAG, "pushNotification");
        initAdapter(context);
        int notifyMode = NotifyUtil.getNotifyDataAdapter(context).getNotifyMode(insideNotificationItem);
        if (!TextUtils.isEmpty(insideNotificationItem.getPurePicUrl()) && list != null && list.size() > 1 && list.get(1) != null) {
            notifyMode = 1;
        }
        if (notifyMode == 2) {
            pushNotificationBySystem(context, list, insideNotificationItem, j, i, interfaceC7472a);
        } else if (notifyMode == 1) {
            pushNotificationByCustom(context, list, insideNotificationItem, j, interfaceC7472a);
        }
    }

    private static void pushNotificationByCustom(Context context, List<Bitmap> list, InsideNotificationItem insideNotificationItem, long j, C7471r.InterfaceC7472a interfaceC7472a) {
        Notification notification;
        int i;
        int i2;
        Bitmap bitmap;
        Resources resources = context.getResources();
        String packageName = context.getPackageName();
        String title = insideNotificationItem.getTitle();
        int defaultNotifyIcon = NotifyUtil.getNotifyDataAdapter(context).getDefaultNotifyIcon();
        int i3 = context.getApplicationInfo().icon;
        Bundle bundle = new Bundle();
        bundle.putLong("pushId", j);
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 26) {
            Notification.Builder builder = new Notification.Builder(context, PRIMARY_CHANNEL);
            if (defaultNotifyIcon > 0) {
                bundle.putInt("vivo.summaryIconRes", defaultNotifyIcon);
            }
            builder.setExtras(bundle);
            notification = builder.build();
        } else if (i4 >= 19) {
            Notification.Builder builder2 = new Notification.Builder(context);
            builder2.setExtras(bundle);
            notification = builder2.build();
        } else {
            notification = new Notification();
        }
        notification.priority = 2;
        notification.flags = 16;
        notification.tickerText = title;
        int defaultSmallIconId = NotifyUtil.getNotifyDataAdapter(context).getDefaultSmallIconId();
        if (defaultSmallIconId <= 0) {
            defaultSmallIconId = i3;
        }
        notification.icon = defaultSmallIconId;
        RemoteViews remoteViews = new RemoteViews(packageName, NotifyUtil.getNotifyLayoutAdapter(context).getNotificationLayout());
        remoteViews.setTextViewText(resources.getIdentifier("notify_title", "id", packageName), title);
        remoteViews.setTextColor(resources.getIdentifier("notify_title", "id", packageName), NotifyUtil.getNotifyLayoutAdapter(context).getTitleColor());
        remoteViews.setTextViewText(resources.getIdentifier("notify_msg", "id", packageName), insideNotificationItem.getContent());
        if (insideNotificationItem.isShowTime()) {
            i = i3;
            remoteViews.setTextViewText(resources.getIdentifier("notify_when", "id", packageName), new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date()));
            i2 = 0;
            remoteViews.setViewVisibility(resources.getIdentifier("notify_when", "id", packageName), 0);
        } else {
            i = i3;
            i2 = 0;
            remoteViews.setViewVisibility(resources.getIdentifier("notify_when", "id", packageName), 8);
        }
        int suitIconId = NotifyUtil.getNotifyLayoutAdapter(context).getSuitIconId();
        remoteViews.setViewVisibility(suitIconId, i2);
        if (list != null && !list.isEmpty() && (bitmap = list.get(i2)) != null) {
            remoteViews.setImageViewBitmap(suitIconId, bitmap);
        } else {
            if (defaultNotifyIcon <= 0) {
                defaultNotifyIcon = i;
            }
            remoteViews.setImageViewResource(suitIconId, defaultNotifyIcon);
        }
        Bitmap bitmap2 = null;
        if (list != null && list.size() > 1) {
            bitmap2 = list.get(1);
        }
        if (bitmap2 != null) {
            if (!TextUtils.isEmpty(insideNotificationItem.getPurePicUrl())) {
                remoteViews.setViewVisibility(resources.getIdentifier("notify_content", "id", packageName), 8);
                remoteViews.setViewVisibility(resources.getIdentifier("notify_cover", "id", packageName), 8);
                remoteViews.setViewVisibility(resources.getIdentifier("notify_pure_cover", "id", packageName), 0);
                remoteViews.setImageViewBitmap(resources.getIdentifier("notify_pure_cover", "id", packageName), bitmap2);
            } else {
                remoteViews.setViewVisibility(resources.getIdentifier("notify_cover", "id", packageName), 0);
                remoteViews.setImageViewBitmap(resources.getIdentifier("notify_cover", "id", packageName), bitmap2);
            }
        } else {
            remoteViews.setViewVisibility(resources.getIdentifier("notify_cover", "id", packageName), 8);
        }
        notification.contentView = remoteViews;
        if (i4 >= 16 && TextUtils.isEmpty(insideNotificationItem.getPurePicUrl())) {
            notification.bigContentView = remoteViews;
        }
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        int ringerMode = audioManager.getRingerMode();
        int vibrateSetting = audioManager.getVibrateSetting(0);
        C7523p.d(TAG, "ringMode=" + ringerMode + " callVibrateSetting=" + vibrateSetting);
        int notifyType = insideNotificationItem.getNotifyType();
        if (notifyType != 2) {
            if (notifyType != 3) {
                if (notifyType == 4) {
                    if (ringerMode == 2) {
                        notification.defaults = 1;
                    }
                    if (vibrateSetting == 1) {
                        notification.defaults |= 2;
                        notification.vibrate = new long[]{0, 100, 200, 300};
                    }
                }
            } else if (vibrateSetting == 1) {
                notification.defaults = 2;
                notification.vibrate = new long[]{0, 100, 200, 300};
            }
        } else if (ringerMode == 2) {
            notification.defaults = 1;
        }
        Intent intent = new Intent("com.vivo.pushservice.action.RECEIVE");
        intent.setPackage(context.getPackageName());
        intent.setClassName(context.getPackageName(), "com.vivo.push.sdk.service.CommandService");
        intent.putExtra("command_type", "reflect_receiver");
        try {
            intent.putExtra("security_avoid_pull", C7508a.a(context).a("com.vivo.pushservice"));
            if (i4 >= 18) {
                intent.putExtra("security_avoid_pull_rsa", C7443d.a(context).a().a("com.vivo.pushservice"));
                intent.putExtra("security_avoid_rsa_public_key", C7528u.a(C7443d.a(context).a().a()));
            }
        } catch (Exception e) {
            C7523p.a(TAG, "pushNotificationByCustom encrypt ：" + e.getMessage());
        }
        new C7428p(packageName, j, insideNotificationItem).b(intent);
        notification.contentIntent = PendingIntent.getService(context, (int) SystemClock.uptimeMillis(), intent, 268435456);
        if (sNotificationManager != null) {
            int k = C7481e.a().k();
            try {
                if (k == 0) {
                    sNotificationManager.notify(sNotifyId, notification);
                    if (interfaceC7472a != null) {
                        interfaceC7472a.a();
                    }
                } else if (k == 1) {
                    sNotificationManager.notify((int) j, notification);
                    if (interfaceC7472a != null) {
                        interfaceC7472a.a();
                    }
                } else {
                    C7523p.a(TAG, "unknow notify style ".concat(String.valueOf(k)));
                }
            } catch (Exception e2) {
                C7523p.a(TAG, e2);
                if (interfaceC7472a != null) {
                    interfaceC7472a.b();
                }
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(26:1|(1:98)(2:5|(1:97)(1:10))|11|(3:13|(1:15)|(1:17))(2:91|(1:93)(2:94|(1:96)))|18|(1:20)|21|(1:23)|24|(1:26)|27|(1:29)(1:90)|30|(2:32|(1:(1:(1:82)(2:83|(1:85))))(1:(1:87)))(1:(11:89|(1:80)(1:39)|(1:41)|(1:43)|44|45|46|(1:48)|50|51|(2:53|(2:55|(2:57|58)(1:60))(2:61|(2:63|(2:65|66)(1:67))(2:68|69)))(1:77)))|35|(1:37)|80|(0)|(0)|44|45|46|(0)|50|51|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01b9, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x01ba, code lost:
        r4 = r17;
        com.vivo.push.util.C7523p.a(r4, "pushNotificationBySystem encrypt ：" + r0.getMessage());
     */
    /* JADX WARN: Removed duplicated region for block: B:62:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0190 A[Catch: Exception -> 0x01b9, TRY_LEAVE, TryCatch #0 {Exception -> 0x01b9, blocks: (B:66:0x017f, B:68:0x0190), top: B:93:0x017f }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01fb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void pushNotificationBySystem(android.content.Context r20, java.util.List<android.graphics.Bitmap> r21, com.vivo.push.model.InsideNotificationItem r22, long r23, int r25, com.vivo.push.d.C7471r.InterfaceC7472a r26) {
        /*
            Method dump skipped, instructions count: 618
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.util.NotifyAdapterUtil.pushNotificationBySystem(android.content.Context, java.util.List, com.vivo.push.model.InsideNotificationItem, long, int, com.vivo.push.d.r$a):void");
    }

    public static boolean repealNotifyById(Context context, long j) {
        int k = C7481e.a().k();
        if (k != 0) {
            if (k == 1) {
                return cancelNotify(context, (int) j);
            }
            C7523p.a(TAG, "unknow cancle notify style ".concat(String.valueOf(k)));
            return false;
        }
        long b = C7530w.b().b("com.vivo.push.notify_key", -1L);
        if (b == j) {
            C7523p.d(TAG, "undo showed message ".concat(String.valueOf(j)));
            C7523p.a(context, "回收已展示的通知： ".concat(String.valueOf(j)));
            return cancelNotify(context, sNotifyId);
        }
        C7523p.d(TAG, "current showing message id " + b + " not match " + j);
        C7523p.a(context, "与已展示的通知" + b + "与待回收的通知" + j + "不匹配");
        return false;
    }

    public static void setNotifyId(int i) {
        sNotifyId = i;
    }

    public static void cancelNotify(Context context) {
        cancelNotify(context, sNotifyId);
    }
}
