package com.meizu.cloud.pushsdk.handler.a;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.NotificationService;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.handler.MzPushMessage;
import com.meizu.cloud.pushsdk.notification.PushNotificationBuilder;
import com.meizu.cloud.pushsdk.notification.model.styleenum.BaseStyleModel;
import com.meizu.cloud.pushsdk.notification.model.styleenum.InnerStyleLayout;
import com.meizu.cloud.pushsdk.util.MinSdkChecker;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import com.youku.media.arch.instruments.statistics.ConfigReporter;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class c extends a<MessageV3> {
    public c(Context context, com.meizu.cloud.pushsdk.handler.a aVar) {
        super(context, aVar);
    }

    private String k(MessageV3 messageV3) {
        String selfDefineContentString = MzPushMessage.fromMessageV3(messageV3).getSelfDefineContentString();
        if (!TextUtils.isEmpty(selfDefineContentString)) {
            try {
                return new JSONObject(selfDefineContentString).getString("package_name");
            } catch (JSONException unused) {
                DebugLogger.e("AbstractMessageHandler", "no quick json message");
            }
        }
        return null;
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public int a() {
        return 4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    public void a(MessageV3 messageV3, com.meizu.cloud.pushsdk.notification.c cVar) {
        if (cVar != null) {
            cVar.b(messageV3);
            a(messageV3);
        }
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public boolean a(Intent intent) {
        DebugLogger.i("AbstractMessageHandler", "start MessageV3Handler match");
        if (a(0, g(intent))) {
            if (PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction()) && PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_NOTIFICATION_SHOW_V3.equals(k(intent))) {
                return true;
            }
            if (TextUtils.isEmpty(k(intent))) {
                String stringExtra = intent.getStringExtra("message");
                if (!TextUtils.isEmpty(stringExtra) && a(stringExtra)) {
                    DebugLogger.e("AbstractMessageHandler", "old cloud notification message");
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: b */
    public boolean a(MessageV3 messageV3, String str) {
        return a(messageV3, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: d */
    public void b(MessageV3 messageV3) {
        com.meizu.cloud.pushsdk.util.d.b(d(), messageV3.getUploadDataPackageName(), messageV3.getDeviceId(), messageV3.getTaskId(), messageV3.getSeqId(), messageV3.getPushTimestamp(), messageV3.getDelayedReportMillis());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: e */
    public void c(MessageV3 messageV3) {
        com.meizu.cloud.pushsdk.util.d.a(d(), messageV3.getUploadDataPackageName(), messageV3.getDeviceId(), messageV3.getTaskId(), messageV3.getSeqId(), messageV3.getPushTimestamp(), messageV3.getDelayedReportMillis());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: f  reason: avoid collision after fix types in other method */
    public com.meizu.cloud.pushsdk.notification.c a(MessageV3 messageV3) {
        PushNotificationBuilder pushNotificationBuilder = new PushNotificationBuilder(d());
        pushNotificationBuilder.setClickPackageName(k(messageV3));
        c().a(pushNotificationBuilder);
        com.meizu.cloud.pushsdk.notification.c cVar = null;
        if (messageV3.getNotificationStyle() != null) {
            int baseStyle = messageV3.getNotificationStyle().getBaseStyle();
            if (BaseStyleModel.FLYME.getCode() == baseStyle) {
                int innerStyle = messageV3.getNotificationStyle().getInnerStyle();
                if (InnerStyleLayout.EXPANDABLE_STANDARD.getCode() == innerStyle) {
                    DebugLogger.i("AbstractMessageHandler", "show Standard Notification with Expandable disable");
                    cVar = new com.meizu.cloud.pushsdk.notification.b.c(d(), pushNotificationBuilder);
                } else if (InnerStyleLayout.EXPANDABLE_TEXT.getCode() == innerStyle) {
                    DebugLogger.i("AbstractMessageHandler", "show Standard Notification with Expandable Text");
                    cVar = new com.meizu.cloud.pushsdk.notification.b.b(d(), pushNotificationBuilder);
                } else if (InnerStyleLayout.EXPANDABLE_PIC.getCode() == innerStyle) {
                    DebugLogger.i("AbstractMessageHandler", "show Standard Notification with Expandable Picture");
                    cVar = new com.meizu.cloud.pushsdk.notification.b.a(d(), pushNotificationBuilder);
                } else if (InnerStyleLayout.EXPANDABLE_VIDEO.getCode() == innerStyle) {
                    DebugLogger.i("AbstractMessageHandler", "show Flyme Video notification");
                    cVar = new com.meizu.cloud.pushsdk.notification.a.d(d(), pushNotificationBuilder);
                }
            } else if (BaseStyleModel.PURE_PICTURE.getCode() == baseStyle) {
                cVar = new com.meizu.cloud.pushsdk.notification.b(d(), pushNotificationBuilder);
                DebugLogger.i("AbstractMessageHandler", "show Pure Picture Notification");
            } else if (BaseStyleModel.ANDROID.getCode() == baseStyle) {
                int innerStyle2 = messageV3.getNotificationStyle().getInnerStyle();
                if (InnerStyleLayout.EXPANDABLE_STANDARD.getCode() == innerStyle2) {
                    DebugLogger.i("AbstractMessageHandler", "show Android  Notification with Expandable disable");
                    cVar = new com.meizu.cloud.pushsdk.notification.a.c(d(), pushNotificationBuilder);
                } else if (InnerStyleLayout.EXPANDABLE_TEXT.getCode() == innerStyle2) {
                    DebugLogger.i("AbstractMessageHandler", "show Android  Notification with Expandable Text");
                    cVar = new com.meizu.cloud.pushsdk.notification.a.b(d(), pushNotificationBuilder);
                } else if (InnerStyleLayout.EXPANDABLE_PIC.getCode() == innerStyle2) {
                    DebugLogger.i("AbstractMessageHandler", "show Android  Notification with Expandable Picture");
                    cVar = new com.meizu.cloud.pushsdk.notification.a.a(d(), pushNotificationBuilder);
                } else if (InnerStyleLayout.EXPANDABLE_VIDEO.getCode() == innerStyle2) {
                    DebugLogger.i("AbstractMessageHandler", "show Flyme Video notification");
                    cVar = new com.meizu.cloud.pushsdk.notification.a.d(d(), pushNotificationBuilder);
                }
            }
        }
        if (cVar == null) {
            DebugLogger.e("AbstractMessageHandler", "use standard v2 notification");
            return new com.meizu.cloud.pushsdk.notification.d(d(), pushNotificationBuilder);
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    public boolean g(MessageV3 messageV3) {
        String uriPackageName = messageV3.getUriPackageName();
        if (TextUtils.isEmpty(uriPackageName)) {
            return true;
        }
        return MzSystemUtils.isPackageInstalled(d(), uriPackageName);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: h */
    public int d(MessageV3 messageV3) {
        int i;
        Context d;
        int i2;
        String taskId;
        String deviceId;
        String str;
        if (messageV3.getBrightRemindSetting() == null || !messageV3.getBrightRemindSetting().getIsBrightRemind() || MzSystemUtils.isInteractive(d())) {
            if (messageV3.getAdvertisementOption() != null && !TextUtils.isEmpty(messageV3.getAdvertisementOption().getAdInstallPackage())) {
                long m = com.meizu.cloud.pushsdk.util.b.m(d(), messageV3.getAdvertisementOption().getAdPackage());
                DebugLogger.i("AbstractMessageHandler", "ad message last click time is: " + m);
                if (m == 0 || m + 1209600000 <= System.currentTimeMillis()) {
                    return 0;
                }
                com.meizu.cloud.pushsdk.util.d.f(d(), messageV3.getAdvertisementOption().getAdInstallPackage(), messageV3.getDeviceId(), messageV3.getTaskId(), messageV3.getSeqId(), messageV3.getPushTimestamp());
                return 5;
            } else if (messageV3.getTimeDisplaySetting() == null || !messageV3.getTimeDisplaySetting().isTimeDisplay()) {
                return 0;
            } else {
                if (System.currentTimeMillis() > Long.valueOf(messageV3.getTimeDisplaySetting().getEndShowTime()).longValue()) {
                    i = 1;
                    d = d();
                    i2 = 2200;
                    taskId = messageV3.getTaskId();
                    deviceId = messageV3.getDeviceId();
                    str = "schedule notification expire";
                } else if (System.currentTimeMillis() > Long.valueOf(messageV3.getTimeDisplaySetting().getStartShowTime()).longValue()) {
                    i = 2;
                    d = d();
                    i2 = 2201;
                    taskId = messageV3.getTaskId();
                    deviceId = messageV3.getDeviceId();
                    str = "schedule notification on time";
                } else {
                    i = 3;
                    d = d();
                    i2 = 2202;
                    taskId = messageV3.getTaskId();
                    deviceId = messageV3.getDeviceId();
                    str = "schedule notification delay";
                }
                com.meizu.cloud.pushsdk.util.d.a(d, str, i2, taskId, deviceId);
                return i;
            }
        }
        return 4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: i */
    public void e(MessageV3 messageV3) {
        AlarmManager alarmManager = (AlarmManager) d().getSystemService(NotificationCompat.CATEGORY_ALARM);
        Intent intent = new Intent(d(), NotificationService.class);
        intent.setPackage(messageV3.getPackageName());
        intent.addCategory(messageV3.getPackageName());
        intent.setData(Uri.parse("custom://" + System.currentTimeMillis()));
        intent.putExtra("command_type", "reflect_receiver");
        intent.setAction(PushConstants.MZ_PUSH_ON_MESSAGE_ACTION);
        intent.putExtra(PushConstants.EXTRA_APP_PUSH_SCHEDULE_NOTIFICATION_MESSAGE, messageV3);
        intent.putExtra("method", PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_SCHEDULE_NOTIFICATION);
        PendingIntent service = PendingIntent.getService(d(), 0, intent, MinSdkChecker.isSupportSetDrawableSmallIcon() ? ConfigReporter.BIT_GETTER_IMP : 1073741824);
        String startShowTime = messageV3.getTimeDisplaySetting().getStartShowTime();
        String format = TextUtils.isEmpty(startShowTime) ? null : new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(Long.valueOf(startShowTime).longValue()));
        long longValue = Long.valueOf(startShowTime).longValue() - System.currentTimeMillis();
        DebugLogger.i("AbstractMessageHandler", "after " + (longValue / 1000) + " seconds Notification AlarmManager execute At " + format);
        if (alarmManager != null && Build.VERSION.SDK_INT >= 19) {
            DebugLogger.i("AbstractMessageHandler", "setAlarmManager setExact ELAPSED_REALTIME_WAKEUP");
            alarmManager.setExact(2, SystemClock.elapsedRealtime() + longValue, service);
        } else if (alarmManager != null) {
            DebugLogger.i("AbstractMessageHandler", "setAlarmManager set ELAPSED_REALTIME_WAKEUP");
            alarmManager.set(2, SystemClock.elapsedRealtime() + longValue, service);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: j */
    public void f(MessageV3 messageV3) {
        Intent intent = new Intent(d(), NotificationService.class);
        intent.setPackage(messageV3.getPackageName());
        intent.addCategory(messageV3.getPackageName());
        intent.setData(Uri.parse("custom://" + System.currentTimeMillis()));
        intent.putExtra("command_type", "reflect_receiver");
        intent.setAction(PushConstants.MZ_PUSH_ON_MESSAGE_ACTION);
        intent.putExtra(PushConstants.EXTRA_APP_PUSH_BRIGHT_NOTIFICATION_MESSAGE, messageV3);
        intent.putExtra("method", PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_BRIGHT_NOTIFICATION_MESSAGE);
        com.meizu.cloud.pushsdk.handler.a.f.a a = com.meizu.cloud.pushsdk.b.a(d()).a();
        if (a != null) {
            a.a(intent, messageV3.getUploadDataPackageName());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: l */
    public MessageV3 c(Intent intent) {
        return MessageV3.parse(d().getPackageName(), g(intent), h(intent), d(intent), e(intent), f(intent), intent.getStringExtra(PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_NOTIFICATION_SHOW_V3.equals(k(intent)) ? PushConstants.MZ_PUSH_PRIVATE_MESSAGE : "message"), i(intent), j(intent));
    }
}
