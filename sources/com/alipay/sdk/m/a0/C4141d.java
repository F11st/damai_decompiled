package com.alipay.sdk.m.a0;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.alibaba.security.common.track.model.C3834a;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alibaba.wireless.security.aopsdk.replace.android.provider.Settings;
import com.alipay.sdk.m.z.C4368a;
import java.io.File;
import tb.gn1;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.a0.d */
/* loaded from: classes12.dex */
public final class C4141d {
    public static C4141d a = new C4141d();

    public static C4141d a() {
        return a;
    }

    public static String a(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod(gn1.TYPE_OPEN_URL_METHOD_GET, String.class, String.class).invoke(null, str, str2);
        } catch (Exception unused) {
            return str2;
        }
    }

    public static boolean a(Context context) {
        boolean z;
        int length;
        try {
            if (!Build.HARDWARE.contains("goldfish") && !com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getPRODUCT().contains(C3834a.C3835a.a) && !Build.FINGERPRINT.contains("generic")) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    String deviceId = com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getDeviceId(telephonyManager);
                    if (deviceId != null && (length = deviceId.length()) != 0) {
                        for (int i = 0; i < length; i++) {
                            if (!Character.isWhitespace(deviceId.charAt(i)) && deviceId.charAt(i) != '0') {
                                z = false;
                                break;
                            }
                        }
                    }
                    z = true;
                    if (z) {
                        return true;
                    }
                }
                return C4368a.a(Settings.Secure.getString(context.getContentResolver(), "android_id"));
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String b() {
        return "android";
    }

    public static boolean c() {
        String[] strArr = {"/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
        for (int i = 0; i < 5; i++) {
            try {
                if (new File(strArr[i] + "su").exists()) {
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static String d() {
        return Build.BOARD;
    }

    public static String e() {
        return com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getBRAND();
    }

    public static String f() {
        return Build.DEVICE;
    }

    public static String g() {
        return Build.DISPLAY;
    }

    public static String h() {
        return Build.VERSION.INCREMENTAL;
    }

    public static String i() {
        return com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMANUFACTURER();
    }

    public static String j() {
        return com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMODEL();
    }

    public static String k() {
        return com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getPRODUCT();
    }

    public static String l() {
        return Build.VERSION.getRELEASE();
    }

    public static String m() {
        return Build.VERSION.SDK;
    }

    public static String n() {
        return android.os.Build.TAGS;
    }

    public static String o() {
        return a("ro.kernel.qemu", "0");
    }
}
