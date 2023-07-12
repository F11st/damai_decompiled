package org.android.agoo.xiaomi;

import android.content.Context;
import android.content.Intent;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.agoo.BaseNotifyClickActivity;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.mipush.sdk.PushMessageHelper;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes2.dex */
public class MiPushRegistar {
    private static final String REDMI = "Redmi";
    private static final String TAG = "MiPushRegistar";
    private static final String XIAOMI = "Xiaomi";

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class XiaoMiNotifyListener implements BaseNotifyClickActivity.INotifyListener {
        private XiaoMiNotifyListener() {
        }

        @Override // com.taobao.agoo.BaseNotifyClickActivity.INotifyListener
        public String getMsgSource() {
            return "xiaomi";
        }

        @Override // com.taobao.agoo.BaseNotifyClickActivity.INotifyListener
        public String parseMsgFromIntent(Intent intent) {
            String str;
            try {
                str = ((MiPushMessage) intent.getSerializableExtra(PushMessageHelper.KEY_MESSAGE)).getContent();
            } catch (Exception unused) {
                str = null;
            }
            ALog.i(MiPushRegistar.TAG, "parseMsgFromIntent", "msg", str);
            return str;
        }

        public String toString() {
            return "INotifyListener: " + getMsgSource();
        }
    }

    public static boolean checkDevice() {
        String brand = Build.getBRAND();
        return XIAOMI.equalsIgnoreCase(brand.toLowerCase()) || REDMI.equalsIgnoreCase(brand.toLowerCase());
    }

    public static void register(Context context, String str, String str2, boolean z) {
        try {
            if (!UtilityImpl.isMainProcess(context)) {
                ALog.e(TAG, "register not in main process, return", new Object[0]);
            } else if (checkDevice() || z) {
                ALog.i(TAG, "register begin", new Object[0]);
                BaseNotifyClickActivity.addNotifyListener(new XiaoMiNotifyListener());
                MiPushClient.registerPush(context, str, str2);
            }
        } catch (Throwable th) {
            ALog.e(TAG, "register", th, new Object[0]);
        }
    }

    public static void unregister(Context context) {
        try {
            MiPushClient.unregisterPush(context);
        } catch (Throwable th) {
            ALog.e(TAG, MiPushClient.COMMAND_UNREGISTER, th, new Object[0]);
        }
    }

    public static void register(Context context, String str, String str2) {
        register(context, str, str2, false);
    }
}
