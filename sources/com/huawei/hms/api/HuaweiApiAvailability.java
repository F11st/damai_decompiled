package com.huawei.hms.api;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.api.HuaweiApiCallable;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class HuaweiApiAvailability {
    public static final String ACTIVITY_NAME = "com.huawei.hms.core.activity.JumpActivity";
    public static final String APPID_HMS = "C10132067";
    public static final String APPID_HMS_TV = "C100636709";
    public static final String HMS_API_NAME_GAME = "HuaweiGame.API";
    public static final String HMS_API_NAME_IAP = "HuaweiIap.API";
    public static final String HMS_API_NAME_ID = "HuaweiID.API";
    public static final String HMS_API_NAME_OD = "HuaweiOpenDevice.API";
    public static final String HMS_API_NAME_PAY = "HuaweiPay.API";
    public static final String HMS_API_NAME_PPS = "HuaweiPPSkit.API";
    public static final String HMS_API_NAME_PUSH = "HuaweiPush.API";
    public static final String HMS_API_NAME_SNS = "HuaweiSns.API";
    public static final int HMS_JSON_VERSION_MIN = 30000000;
    public static final int HMS_SDK_VERSION_CODE = 60400302;
    public static final String HMS_SDK_VERSION_NAME = "6.4.0.302";
    public static final int HMS_VERSION_CODE_GAME = 20503000;
    public static final int HMS_VERSION_CODE_IAP = 20700300;
    public static final int HMS_VERSION_CODE_ID = 30000000;
    public static final int HMS_VERSION_CODE_MIN = 20503000;
    public static final int HMS_VERSION_CODE_OD = 20601000;
    public static final int HMS_VERSION_CODE_PAY = 20503000;
    public static final int HMS_VERSION_CODE_PPS = 20700300;
    public static final int HMS_VERSION_CODE_PUSH = 20503000;
    public static final int HMS_VERSION_CODE_SNS = 20503000;
    public static final int HMS_VERSION_MAX = 20600000;
    public static final int HMS_VERSION_MIN = 20503000;
    public static final int NOTICE_VERSION_CODE = 20600000;
    public static final String SERVICES_ACTION = "com.huawei.hms.core.aidlservice";
    @Deprecated
    public static final String SERVICES_PACKAGE = "com.huawei.hwid";
    @Deprecated
    public static final String SERVICES_PACKAGE_TV = "com.huawei.hwid.tv";
    @Deprecated
    public static final String SERVICES_SIGNATURE = "B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05";
    @Deprecated
    public static final String SERVICES_SIGNATURE_CAR = "3517262215D8D3008CBF888750B6418EDC4D562AC33ED6874E0D73ABA667BC3C";
    @Deprecated
    public static final String SERVICES_SIGNATURE_TV = "3517262215D8D3008CBF888750B6418EDC4D562AC33ED6874E0D73ABA667BC3C";
    public static int SERVICES_VERSION_CODE = 30000100;
    private static final Map<String, Integer> a;

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put(HMS_API_NAME_ID, 30000000);
        hashMap.put(HMS_API_NAME_SNS, 20503000);
        hashMap.put(HMS_API_NAME_PAY, 20503000);
        hashMap.put(HMS_API_NAME_PUSH, 20503000);
        hashMap.put(HMS_API_NAME_GAME, 20503000);
        hashMap.put(HMS_API_NAME_OD, Integer.valueOf((int) HMS_VERSION_CODE_OD));
        hashMap.put(HMS_API_NAME_IAP, 20700300);
        hashMap.put(HMS_API_NAME_PPS, 20700300);
    }

    public static Map<String, Integer> getApiMap() {
        return a;
    }

    public static HuaweiApiAvailability getInstance() {
        return b.getInstance();
    }

    public static int getServicesVersionCode() {
        return SERVICES_VERSION_CODE;
    }

    public static void setServicesVersionCode(int i) {
        SERVICES_VERSION_CODE = i;
    }

    public abstract Task<Void> checkApiAccessible(HuaweiApi<?> huaweiApi, HuaweiApi<?>... huaweiApiArr);

    public abstract Task<Void> checkApiAccessible(HuaweiApiCallable huaweiApiCallable, HuaweiApiCallable... huaweiApiCallableArr);

    public abstract PendingIntent getErrPendingIntent(Context context, int i, int i2);

    public abstract PendingIntent getErrPendingIntent(Context context, ConnectionResult connectionResult);

    public abstract Dialog getErrorDialog(Activity activity, int i, int i2);

    public abstract Dialog getErrorDialog(Activity activity, int i, int i2, DialogInterface.OnCancelListener onCancelListener);

    public abstract String getErrorString(int i);

    public abstract Task<Void> getHuaweiServicesReady(Activity activity);

    public abstract Intent getResolveErrorIntent(Activity activity, int i);

    public abstract PendingIntent getResolveErrorPendingIntent(Activity activity, int i);

    public abstract int isHuaweiMobileNoticeAvailable(Context context);

    public abstract int isHuaweiMobileServicesAvailable(Context context);

    public abstract int isHuaweiMobileServicesAvailable(Context context, int i);

    public abstract boolean isUserResolvableError(int i);

    public abstract boolean isUserResolvableError(int i, PendingIntent pendingIntent);

    public abstract void popupErrNotification(Context context, ConnectionResult connectionResult);

    public abstract void resolveError(Activity activity, int i, int i2);

    public abstract void resolveError(Activity activity, int i, int i2, PendingIntent pendingIntent);

    public abstract boolean showErrorDialogFragment(Activity activity, int i, int i2);

    public abstract boolean showErrorDialogFragment(Activity activity, int i, int i2, DialogInterface.OnCancelListener onCancelListener);

    public abstract boolean showErrorDialogFragment(Activity activity, int i, Fragment fragment, int i2, DialogInterface.OnCancelListener onCancelListener);

    public abstract void showErrorNotification(Context context, int i);
}
