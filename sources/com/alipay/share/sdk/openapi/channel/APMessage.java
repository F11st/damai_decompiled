package com.alipay.share.sdk.openapi.channel;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.alipay.share.sdk.Constant;
import com.android.dingtalk.share.ddsharemodule.ShareConstant;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class APMessage {

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface CallBack {
        void handleMessage(Intent intent);
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static final class Receiver extends BroadcastReceiver {
        public static final Map<String, CallBack> callbacks = new HashMap();
        private final CallBack a;

        public Receiver() {
            this(null);
        }

        public static void registerCallBack(String str, CallBack callBack) {
            callbacks.put(str, callBack);
        }

        public static void unregisterCallBack(String str) {
            callbacks.remove(str);
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            Log.d("APSDK.APMessage", "receive intent=" + intent);
            CallBack callBack = this.a;
            if (callBack != null) {
                callBack.handleMessage(intent);
                Log.d("APSDK.APMessage", "mm message self-handled");
                return;
            }
            CallBack callBack2 = callbacks.get(intent.getAction());
            if (callBack2 != null) {
                callBack2.handleMessage(intent);
                Log.d("APSDK.APMessage", "mm message handled");
            }
        }

        public Receiver(CallBack callBack) {
            this.a = callBack;
        }
    }

    public static boolean send(Context context, String str, String str2, String str3, Bundle bundle) {
        String str4 = String.valueOf(str) + ".permission.MM_MESSAGE";
        Intent intent = new Intent(str2);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        String packageName = context.getPackageName();
        intent.putExtra(Constant.EXTRA_MESSAGE_SDK_VERSION, Constant.SDK_VERSION);
        intent.putExtra(Constant.EXTRA_MESSAGE_APP_PACKAGE_NAME, packageName);
        intent.putExtra(Constant.EXTRA_MESSAGE_CONTENT, str3);
        intent.putExtra(Constant.EXTRA_MESSAGE_CHECK_SUM, MMessageUtil.a(str3, packageName));
        context.sendBroadcast(intent, str4);
        Log.d("APSDK.APMessage", "send ap message, intent=" + intent + ", perm=" + str4);
        return true;
    }

    public static void send(Context context, String str, String str2) {
        send(context, str, ShareConstant.ACTION_MESSAGE, str2);
    }

    public static void send(Context context, String str, String str2, String str3) {
        send(context, str, str2, str3, null);
    }
}
