package com.ali.user.mobile.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.provider.Settings;
import android.taobao.windvane.util.NetWork;
import android.telephony.TelephonyManager;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.log.TLogAdapter;
import java.io.File;
import java.lang.reflect.Method;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class NetworkUtil {
    public static String TAG = "login.util";

    public static boolean checkEnv(Context context) {
        return hasSimCard(context) && !isAirModeEnable(context) && isMobileNetworkOpen(context);
    }

    public static String getNetworkType(Context context) {
        ConnectivityManager connectivityManager;
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (connectivityManager == null) {
            return "none";
        }
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        if (networkInfo != null) {
            if (NetworkInfo.State.CONNECTED == networkInfo.getState()) {
                return "wifi";
            }
        }
        NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
        if (networkInfo2 != null) {
            if (NetworkInfo.State.CONNECTED == networkInfo2.getState()) {
                return NetWork.CONN_TYPE_GPRS;
            }
        }
        return "none";
    }

    public static void goSettings(Activity activity) {
        if (activity == null) {
            return;
        }
        try {
            activity.startActivity(new Intent("android.settings.SETTINGS"));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static boolean hasSimCard(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getSimState() == 5;
    }

    public static boolean isAirModeEnable(Context context) {
        boolean z = false;
        try {
            if (Build.VERSION.SDK_INT >= 17 ? Settings.Global.getInt(context.getContentResolver(), "airplane_mode_on", 0) == 1 : Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0) == 1) {
                z = true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return z;
    }

    public static boolean isMobileNetworkOpen(Context context) {
        try {
            Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity"), new Object[0])).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public static boolean isNetworkConnected() {
        try {
            NetworkInfo activeNetworkInfo = com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo((ConnectivityManager) DataProviderFactory.getApplicationContext().getSystemService("connectivity"));
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isAvailable()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public static boolean isSuEnable() {
        String[] strArr = {"/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/", "/su/bin/", "/data/local/xbin/su", "/data/local/bin/su", "/data/local/su", "/system/sd/xbin/su"};
        for (int i = 0; i < 10; i++) {
            try {
                String str = strArr[i];
                File file = new File(str + "su");
                if (file.exists() && file.canExecute()) {
                    String str2 = TAG;
                    TLogAdapter.i(str2, "find su in : " + str);
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
