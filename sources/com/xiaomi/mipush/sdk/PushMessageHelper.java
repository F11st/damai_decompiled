package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.xiaomi.push.hw;
import com.xiaomi.push.im;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class PushMessageHelper {
    public static final String ERROR_MESSAGE = "error_message";
    public static final String ERROR_TYPE = "error_type";
    public static final String ERROR_TYPE_NEED_PERMISSION = "error_lack_of_permission";
    public static final String KEY_COMMAND = "key_command";
    public static final String KEY_MESSAGE = "key_message";
    public static final int MESSAGE_COMMAND = 3;
    public static final int MESSAGE_ERROR = 5;
    public static final int MESSAGE_QUIT = 4;
    public static final int MESSAGE_RAW = 1;
    public static final int MESSAGE_SENDMESSAGE = 2;
    public static final String MESSAGE_TYPE = "message_type";
    public static final int PUSH_MODE_BROADCAST = 2;
    public static final int PUSH_MODE_CALLBACK = 1;
    private static int pushMode;

    public static MiPushCommandMessage generateCommandMessage(String str, List<String> list, long j, String str2, String str3, List<String> list2) {
        MiPushCommandMessage miPushCommandMessage = new MiPushCommandMessage();
        miPushCommandMessage.setCommand(str);
        miPushCommandMessage.setCommandArguments(list);
        miPushCommandMessage.setResultCode(j);
        miPushCommandMessage.setReason(str2);
        miPushCommandMessage.setCategory(str3);
        miPushCommandMessage.setAutoMarkPkgs(list2);
        return miPushCommandMessage;
    }

    public static MiPushMessage generateMessage(im imVar, hw hwVar, boolean z) {
        MiPushMessage miPushMessage = new MiPushMessage();
        miPushMessage.setMessageId(imVar.m1060a());
        if (!TextUtils.isEmpty(imVar.d())) {
            miPushMessage.setMessageType(1);
            miPushMessage.setAlias(imVar.d());
        } else if (!TextUtils.isEmpty(imVar.c())) {
            miPushMessage.setMessageType(2);
            miPushMessage.setTopic(imVar.c());
        } else if (TextUtils.isEmpty(imVar.f())) {
            miPushMessage.setMessageType(0);
        } else {
            miPushMessage.setMessageType(3);
            miPushMessage.setUserAccount(imVar.f());
        }
        miPushMessage.setCategory(imVar.e());
        if (imVar.a() != null) {
            miPushMessage.setContent(imVar.a().c());
        }
        if (hwVar != null) {
            if (TextUtils.isEmpty(miPushMessage.getMessageId())) {
                miPushMessage.setMessageId(hwVar.m988a());
            }
            if (TextUtils.isEmpty(miPushMessage.getTopic())) {
                miPushMessage.setTopic(hwVar.m993b());
            }
            miPushMessage.setDescription(hwVar.d());
            miPushMessage.setTitle(hwVar.m996c());
            miPushMessage.setNotifyType(hwVar.a());
            miPushMessage.setNotifyId(hwVar.c());
            miPushMessage.setPassThrough(hwVar.b());
            miPushMessage.setExtra(hwVar.m989a());
        }
        miPushMessage.setNotified(z);
        return miPushMessage;
    }

    public static hw generateMessage(MiPushMessage miPushMessage) {
        hw hwVar = new hw();
        hwVar.a(miPushMessage.getMessageId());
        hwVar.b(miPushMessage.getTopic());
        hwVar.d(miPushMessage.getDescription());
        hwVar.c(miPushMessage.getTitle());
        hwVar.c(miPushMessage.getNotifyId());
        hwVar.a(miPushMessage.getNotifyType());
        hwVar.b(miPushMessage.getPassThrough());
        hwVar.a(miPushMessage.getExtra());
        return hwVar;
    }

    public static int getPushMode(Context context) {
        if (pushMode == 0) {
            setPushMode(isUseCallbackPushMode(context) ? 1 : 2);
        }
        return pushMode;
    }

    private static boolean isIntentAvailable(Context context, Intent intent) {
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

    public static boolean isUseCallbackPushMode(Context context) {
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setClassName(context.getPackageName(), "com.xiaomi.mipush.sdk.PushServiceReceiver");
        return isIntentAvailable(context, intent);
    }

    public static void sendCommandMessageBroadcast(Context context, MiPushCommandMessage miPushCommandMessage) {
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setPackage(context.getPackageName());
        intent.putExtra("message_type", 3);
        intent.putExtra(KEY_COMMAND, miPushCommandMessage);
        new PushServiceReceiver().onReceive(context, intent);
    }

    public static void sendQuitMessageBroadcast(Context context) {
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setPackage(context.getPackageName());
        intent.putExtra("message_type", 4);
        new PushServiceReceiver().onReceive(context, intent);
    }

    private static void setPushMode(int i) {
        pushMode = i;
    }
}
