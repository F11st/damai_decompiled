package com.meizu.cloud.pushsdk.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.youku.live.dago.widgetlib.ailpbaselib.utils.DeviceUtils;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class c {
    private static String a = "";

    public static String a(Context context) {
        if (TextUtils.isEmpty(a)) {
            a = !a() ? d(context) : b(context);
            return a;
        }
        return a;
    }

    public static boolean a() {
        String a2 = i.a("ro.target.product");
        if (TextUtils.isEmpty(a2)) {
            DebugLogger.i(DeviceUtils.TAG, "current product is phone");
            return true;
        }
        DebugLogger.i(DeviceUtils.TAG, "current product is " + a2);
        return false;
    }

    @SuppressLint({"MissingPermission", "HardwareIds"})
    public static String b(Context context) {
        String deviceId;
        try {
            com.meizu.cloud.pushsdk.b.b.d a2 = com.meizu.cloud.pushsdk.b.b.a.a("android.telephony.MzTelephonyManager").a("getDeviceId", new Class[0]).a(new Object[0]);
            if (!a2.a || TextUtils.isEmpty((CharSequence) a2.b)) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager == null) {
                    return null;
                }
                deviceId = com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getDeviceId(telephonyManager);
            } else {
                deviceId = (String) a2.b;
            }
            return deviceId;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @SuppressLint({"HardwareIds"})
    public static String c(Context context) {
        return null;
    }

    private static String d(Context context) {
        StringBuilder sb = new StringBuilder();
        String serial = Build.getSERIAL();
        DebugLogger.i(DeviceUtils.TAG, "device serial " + serial);
        if (!TextUtils.isEmpty(serial)) {
            sb.append(serial);
            String c = c(context);
            DebugLogger.e(DeviceUtils.TAG, "mac address " + c);
            if (!TextUtils.isEmpty(c)) {
                sb.append(c.replace(":", "").toUpperCase());
                return sb.toString();
            }
        }
        return null;
    }
}
