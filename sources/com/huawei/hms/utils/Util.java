package com.huawei.hms.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.huawei.hms.android.SystemUtils;
import com.huawei.hms.common.util.AGCUtils;
import com.huawei.hms.support.log.HMSLog;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class Util {
    private static final String AVAILABLE_LOADED = "availableLoaded";
    private static final Object LOCK_OBJECT = new Object();
    private static final String META_HMSVERSION_NAME = "com.huawei.hms.version";
    private static final String SERVICE_ACTION = "com.huawei.hms.core.internal";
    private static final String TAG = "Util";
    private static boolean availableInit;
    private static boolean isAvailableAvailable;
    private static String serviceAction;

    public static int compareHmsVersion(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (TextUtils.isEmpty(str2)) {
            return 1;
        }
        if (StringUtil.checkVersion(str) && StringUtil.checkVersion(str2)) {
            String[] split = str.split("\\.");
            String[] split2 = str2.split("\\.");
            if (2 < split.length && 2 < split2.length) {
                if (Integer.parseInt(split[0]) > Integer.parseInt(split2[0])) {
                    return 1;
                }
                if (Integer.parseInt(split[0]) < Integer.parseInt(split2[0])) {
                    return -1;
                }
                if (Integer.parseInt(split[1]) > Integer.parseInt(split2[1])) {
                    return 1;
                }
                if (Integer.parseInt(split[1]) < Integer.parseInt(split2[1])) {
                    return -1;
                }
                if (Integer.parseInt(split[2]) > Integer.parseInt(split2[2])) {
                    return 1;
                }
                if (Integer.parseInt(split[2]) < Integer.parseInt(split2[2])) {
                    return -1;
                }
            }
        }
        return 0;
    }

    public static Activity getActiveActivity(Activity activity, Context context) {
        return UIUtil.getActiveActivity(activity, context);
    }

    public static String getAppId(Context context) {
        return AGCUtils.getAppId(context);
    }

    public static String getAppName(Context context, String str) {
        if (context == null) {
            HMSLog.e(TAG, "In getAppName, context is null.");
            return "";
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            HMSLog.e(TAG, "In getAppName, Failed to get 'PackageManager' instance.");
            return "";
        }
        try {
            if (TextUtils.isEmpty(str)) {
                str = context.getPackageName();
            }
            CharSequence applicationLabel = packageManager.getApplicationLabel(packageManager.getApplicationInfo(str, 128));
            return applicationLabel == null ? "" : applicationLabel.toString();
        } catch (PackageManager.NameNotFoundException | Resources.NotFoundException unused) {
            HMSLog.e(TAG, "In getAppName, Failed to get app name.");
            return "";
        }
    }

    public static String getCpId(Context context) {
        return AGCUtils.getCpId(context);
    }

    public static int getHmsVersion(Context context) {
        Bundle bundle;
        Object obj;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            HMSLog.e(TAG, "In getHmsVersion, Failed to get 'PackageManager' instance.");
            return 0;
        }
        try {
            ApplicationInfo applicationInfo = packageManager.getPackageInfo(context.getPackageName(), 128).applicationInfo;
            if (applicationInfo != null && (bundle = applicationInfo.metaData) != null && (obj = bundle.get(META_HMSVERSION_NAME)) != null) {
                String valueOf = String.valueOf(obj);
                if (!TextUtils.isEmpty(valueOf)) {
                    return StringUtil.convertVersion2Integer(valueOf);
                }
            }
            HMSLog.i(TAG, "In getHmsVersion, Failed to read meta data for the HMS VERSION.");
            return 0;
        } catch (PackageManager.NameNotFoundException unused) {
            HMSLog.e(TAG, "In getHmsVersion, Failed to read meta data for the HMS VERSION.");
            return 0;
        } catch (RuntimeException e) {
            HMSLog.e(TAG, "In getHmsVersion, Failed to read meta data for the HMS VERSION.", e);
            return 0;
        }
    }

    public static String getNetType(Context context) {
        return SystemUtils.getNetType(context);
    }

    public static String getProcessName(Context context, int i) {
        return UIUtil.getProcessName(context, i);
    }

    @Deprecated
    public static String getProductCountry() {
        int lastIndexOf;
        String systemProperties = getSystemProperties("ro.product.locale.region", "");
        if (TextUtils.isEmpty(systemProperties)) {
            String systemProperties2 = getSystemProperties("ro.product.locale", "");
            if (!TextUtils.isEmpty(systemProperties2) && (lastIndexOf = systemProperties2.lastIndexOf("-")) != -1) {
                return systemProperties2.substring(lastIndexOf + 1);
            }
            String localCountry = SystemUtils.getLocalCountry();
            return !TextUtils.isEmpty(localCountry) ? localCountry : "";
        }
        return systemProperties;
    }

    public static String getServiceActionMetadata(Context context) {
        String str = serviceAction;
        if (str != null) {
            return str;
        }
        Intent intent = new Intent("com.huawei.hms.core.internal");
        intent.setPackage(context.getPackageName());
        if (context.getPackageManager().resolveService(intent, 128) != null) {
            serviceAction = "com.huawei.hms.core.internal";
            return "com.huawei.hms.core.internal";
        }
        serviceAction = "";
        return "";
    }

    public static String getSystemProperties(String str, String str2) {
        return SystemUtils.getSystemProperties(str, str2);
    }

    public static Activity getValidActivity(Activity activity, Activity activity2) {
        if (activity == null || activity.isFinishing()) {
            if (activity2 == null || activity2.isFinishing()) {
                return null;
            }
            return activity2;
        }
        return activity;
    }

    public static boolean isAvailableLibExist(Context context) {
        Bundle bundle;
        Object obj;
        synchronized (LOCK_OBJECT) {
            if (!availableInit) {
                boolean z = false;
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    HMSLog.e(TAG, "In isAvailableLibExist, Failed to get 'PackageManager' instance.");
                } else {
                    try {
                        ApplicationInfo applicationInfo = packageManager.getPackageInfo(context.getPackageName(), 128).applicationInfo;
                        if (applicationInfo != null && (bundle = applicationInfo.metaData) != null && (obj = bundle.get(AVAILABLE_LOADED)) != null && String.valueOf(obj).equalsIgnoreCase(BQCCameraParam.VALUE_YES)) {
                            HMSLog.i(TAG, "available exist: true");
                        }
                    } catch (PackageManager.NameNotFoundException unused) {
                        HMSLog.e(TAG, "In isAvailableLibExist, Failed to read meta data for the availableLoaded.");
                    } catch (RuntimeException e) {
                        HMSLog.e(TAG, "In isAvailableLibExist, Failed to read meta data for the availableLoaded.", e);
                    }
                    isAvailableAvailable = z;
                    availableInit = true;
                }
                z = true;
                isAvailableAvailable = z;
                availableInit = true;
            }
        }
        HMSLog.i(TAG, "available exist: " + isAvailableAvailable);
        return isAvailableAvailable;
    }

    public static boolean isChinaROM() {
        return SystemUtils.isChinaROM();
    }

    public static boolean isEMUI() {
        return SystemUtils.isEMUI();
    }

    public static void unBindServiceCatchException(Context context, ServiceConnection serviceConnection) {
        try {
            HMSLog.i(TAG, "Trying to unbind service from " + serviceConnection);
            context.unbindService(serviceConnection);
        } catch (Exception e) {
            HMSLog.e(TAG, "On unBindServiceException:" + e.getMessage());
        }
    }
}
