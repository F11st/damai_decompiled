package org.android.agoo.huawei;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.push.HmsMessaging;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.agoo.BaseNotifyClickActivity;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import org.android.agoo.assist.common.AssistConstant;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.control.NotifManager;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes2.dex */
public class HuaWeiRegister {
    private static final String TAG = "HuaWeiRegister";
    public static boolean isChannelRegister;

    private static boolean checkDevice() {
        String brand = Build.getBRAND();
        return brand.equalsIgnoreCase("huawei") || brand.equalsIgnoreCase(AgooConstants.MESSAGE_SYSTEM_SOURCE_HONOR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void getToken(final Context context) {
        ThreadPoolExecutorFactory.execute(new Runnable() { // from class: org.android.agoo.huawei.HuaWeiRegister.2
            @Override // java.lang.Runnable
            public void run() {
                String token;
                try {
                    String string = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("com.huawei.hms.client.appid");
                    String replace = TextUtils.isEmpty(string) ? "" : string.replace("appid=", "");
                    ALog.i(HuaWeiRegister.TAG, "onToken", ALBiometricsKeys.KEY_APP_ID, replace);
                    if (TextUtils.isEmpty(replace)) {
                        token = HmsInstanceId.getInstance(context).getToken();
                    } else {
                        token = HmsInstanceId.getInstance(context).getToken(replace, HmsMessaging.DEFAULT_TOKEN_SCOPE);
                    }
                    if (TextUtils.isEmpty(token)) {
                        return;
                    }
                    ALog.i(HuaWeiRegister.TAG, "onToken", "token", token);
                    NotifManager notifManager = new NotifManager();
                    notifManager.init(context);
                    notifManager.reportThirdPushToken(token, AssistConstant.TOKEN_TYPE_HW);
                } catch (Exception e) {
                    Log.e(HuaWeiRegister.TAG, "getToken failed.", e);
                }
            }
        });
    }

    public static void register(Context context) {
        registerBundle(context, false);
    }

    public static void registerBundle(final Context context, boolean z) {
        try {
            isChannelRegister = z;
            if (!z && !UtilityImpl.isMainProcess(context)) {
                ALog.e(TAG, "register not in main process, return", new Object[0]);
            } else if (checkDevice() && Build.VERSION.SDK_INT >= 17) {
                BaseNotifyClickActivity.addNotifyListener(new HuaweiMsgParseImpl());
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: org.android.agoo.huawei.HuaWeiRegister.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ALog.i(HuaWeiRegister.TAG, "register begin", "isChannel", Boolean.valueOf(HuaWeiRegister.isChannelRegister));
                        HuaWeiRegister.getToken(context.getApplicationContext());
                    }
                }, DanmakuFactory.DEFAULT_DANMAKU_DURATION_V);
            } else {
                ALog.e(TAG, "register checkDevice false", new Object[0]);
            }
        } catch (Throwable th) {
            ALog.e(TAG, "register", th, new Object[0]);
        }
    }
}
