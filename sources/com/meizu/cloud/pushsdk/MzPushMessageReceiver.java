package com.meizu.cloud.pushsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushinternal.R;
import com.meizu.cloud.pushsdk.handler.MzPushMessage;
import com.meizu.cloud.pushsdk.notification.PushNotificationBuilder;
import com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus;
import com.meizu.cloud.pushsdk.platform.message.RegisterStatus;
import com.meizu.cloud.pushsdk.platform.message.SubAliasStatus;
import com.meizu.cloud.pushsdk.platform.message.SubTagsStatus;
import com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class MzPushMessageReceiver extends BroadcastReceiver {
    private static final String TAG = "MzPushMessageReceiver";
    private static boolean bInitLog;

    private com.meizu.cloud.pushsdk.handler.a getAbstractAppLogicListener() {
        return new com.meizu.cloud.pushsdk.handler.a() { // from class: com.meizu.cloud.pushsdk.MzPushMessageReceiver.2
            @Override // com.meizu.cloud.pushsdk.handler.a
            public void a(Context context, Intent intent) {
                DebugLogger.i(MzPushMessageReceiver.TAG, "onMessage Flyme3 " + intent);
                MzPushMessageReceiver.this.onMessage(context, intent);
            }

            @Override // com.meizu.cloud.pushsdk.handler.b
            public void a(Context context, MzPushMessage mzPushMessage) {
                DebugLogger.i(MzPushMessageReceiver.TAG, "onNotificationClicked title " + mzPushMessage.getTitle() + "content " + mzPushMessage.getContent() + " selfDefineContentString " + mzPushMessage.getSelfDefineContentString());
                MzPushMessageReceiver.this.onNotificationClicked(context, mzPushMessage);
            }

            @Override // com.meizu.cloud.pushsdk.handler.b
            public void a(Context context, PushSwitchStatus pushSwitchStatus) {
                DebugLogger.i(MzPushMessageReceiver.TAG, "onPushStatus " + pushSwitchStatus);
                MzPushMessageReceiver.this.onPushStatus(context, pushSwitchStatus);
            }

            @Override // com.meizu.cloud.pushsdk.handler.b
            public void a(Context context, RegisterStatus registerStatus) {
                DebugLogger.i(MzPushMessageReceiver.TAG, "onRegisterStatus " + registerStatus);
                MzPushMessageReceiver.this.onRegisterStatus(context, registerStatus);
            }

            @Override // com.meizu.cloud.pushsdk.handler.b
            public void a(Context context, SubAliasStatus subAliasStatus) {
                DebugLogger.i(MzPushMessageReceiver.TAG, "onSubAliasStatus " + subAliasStatus);
                MzPushMessageReceiver.this.onSubAliasStatus(context, subAliasStatus);
            }

            @Override // com.meizu.cloud.pushsdk.handler.b
            public void a(Context context, SubTagsStatus subTagsStatus) {
                DebugLogger.i(MzPushMessageReceiver.TAG, "onSubTagsStatus " + subTagsStatus);
                MzPushMessageReceiver.this.onSubTagsStatus(context, subTagsStatus);
            }

            @Override // com.meizu.cloud.pushsdk.handler.b
            public void a(Context context, UnRegisterStatus unRegisterStatus) {
                DebugLogger.i(MzPushMessageReceiver.TAG, "onUnRegisterStatus " + unRegisterStatus);
                MzPushMessageReceiver.this.onUnRegisterStatus(context, unRegisterStatus);
            }

            @Override // com.meizu.cloud.pushsdk.handler.b
            public void a(Context context, String str) {
                DebugLogger.i(MzPushMessageReceiver.TAG, "onRegister " + str);
                MzPushMessageReceiver.this.onRegister(context, str);
            }

            @Override // com.meizu.cloud.pushsdk.handler.b
            public void a(Context context, String str, String str2) {
                MzPushMessageReceiver.this.onMessage(context, str, str2);
                DebugLogger.i(MzPushMessageReceiver.TAG, "receive message " + str + " platformExtra " + str2);
            }

            @Override // com.meizu.cloud.pushsdk.handler.b
            public void a(Context context, boolean z) {
                DebugLogger.i(MzPushMessageReceiver.TAG, "onUnRegister " + z);
                MzPushMessageReceiver.this.onUnRegister(context, z);
            }

            @Override // com.meizu.cloud.pushsdk.handler.b
            public void a(PushNotificationBuilder pushNotificationBuilder) {
                MzPushMessageReceiver.this.onUpdateNotificationBuilder(pushNotificationBuilder);
            }

            @Override // com.meizu.cloud.pushsdk.handler.b
            public void b(Context context, MzPushMessage mzPushMessage) {
                DebugLogger.i(MzPushMessageReceiver.TAG, "onNotificationArrived title " + mzPushMessage.getTitle() + "content " + mzPushMessage.getContent() + " selfDefineContentString " + mzPushMessage.getSelfDefineContentString());
                MzPushMessageReceiver.this.onNotificationArrived(context, mzPushMessage);
            }

            @Override // com.meizu.cloud.pushsdk.handler.b
            public void b(Context context, String str) {
                MzPushMessageReceiver.this.onMessage(context, str);
                DebugLogger.i(MzPushMessageReceiver.TAG, "receive message " + str);
            }

            @Override // com.meizu.cloud.pushsdk.handler.b
            public void c(Context context, MzPushMessage mzPushMessage) {
                DebugLogger.i(MzPushMessageReceiver.TAG, "onNotificationDeleted title " + mzPushMessage.getTitle() + "content " + mzPushMessage.getContent() + " selfDefineContentString " + mzPushMessage.getSelfDefineContentString());
                MzPushMessageReceiver.this.onNotificationDeleted(context, mzPushMessage);
            }

            @Override // com.meizu.cloud.pushsdk.handler.b
            public void c(Context context, String str) {
                DebugLogger.i(MzPushMessageReceiver.TAG, "onNotifyMessageArrived " + str);
                MzPushMessageReceiver.this.onNotifyMessageArrived(context, str);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onHandleIntent(Context context, Intent intent) {
        b.a(context).a(TAG, getAbstractAppLogicListener()).a(intent);
    }

    public void onMessage(Context context, Intent intent) {
    }

    public void onMessage(Context context, String str) {
    }

    public void onMessage(Context context, String str, String str2) {
    }

    public void onNotificationArrived(Context context, MzPushMessage mzPushMessage) {
    }

    public void onNotificationClicked(Context context, MzPushMessage mzPushMessage) {
    }

    public void onNotificationDeleted(Context context, MzPushMessage mzPushMessage) {
    }

    public void onNotifyMessageArrived(Context context, String str) {
    }

    public abstract void onPushStatus(Context context, PushSwitchStatus pushSwitchStatus);

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, final Intent intent) {
        final Context applicationContext = context.getApplicationContext();
        com.meizu.cloud.pushsdk.b.c.b.a().execute(new Runnable() { // from class: com.meizu.cloud.pushsdk.MzPushMessageReceiver.1
            @Override // java.lang.Runnable
            public void run() {
                if (!MzPushMessageReceiver.bInitLog) {
                    boolean unused = MzPushMessageReceiver.bInitLog = true;
                    DebugLogger.init(applicationContext);
                }
                MzPushMessageReceiver.this.onHandleIntent(applicationContext, intent);
            }
        });
    }

    @Deprecated
    public void onRegister(Context context, String str) {
    }

    public abstract void onRegisterStatus(Context context, RegisterStatus registerStatus);

    public abstract void onSubAliasStatus(Context context, SubAliasStatus subAliasStatus);

    public abstract void onSubTagsStatus(Context context, SubTagsStatus subTagsStatus);

    @Deprecated
    public void onUnRegister(Context context, boolean z) {
    }

    public abstract void onUnRegisterStatus(Context context, UnRegisterStatus unRegisterStatus);

    public void onUpdateNotificationBuilder(PushNotificationBuilder pushNotificationBuilder) {
        pushNotificationBuilder.setStatusBarIcon(R.drawable.stat_sys_third_app_notify);
    }
}
