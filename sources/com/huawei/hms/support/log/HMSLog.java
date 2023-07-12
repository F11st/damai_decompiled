package com.huawei.hms.support.log;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.huawei.hms.base.log.C5535a;
import com.huawei.hms.base.log.C5538d;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class HMSLog {
    public static final C5535a a = new C5535a();

    public static String a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 16384);
                return "HMS-" + packageInfo.versionName + jn1.BRACKET_START_STR + packageInfo.versionCode + jn1.BRACKET_END_STR;
            } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            }
        }
        return "HMS-[unknown-version]";
    }

    public static void d(String str, String str2) {
        a.a(3, str, str2);
    }

    public static void e(String str, String str2) {
        a.a(6, str, str2);
    }

    public static void i(String str, String str2) {
        a.a(4, str, str2);
    }

    public static void init(Context context, int i, String str) {
        C5535a c5535a = a;
        c5535a.a(context, i, str);
        c5535a.a(str, "============================================================================\n====== " + a(context) + "\n============================================================================");
    }

    public static boolean isErrorEnable() {
        return a.a(6);
    }

    public static boolean isInfoEnable() {
        return a.a(4);
    }

    public static boolean isWarnEnable() {
        return a.a(5);
    }

    public static void setExtLogger(HMSExtLogger hMSExtLogger, boolean z) throws IllegalArgumentException {
        if (hMSExtLogger != null) {
            C5538d c5538d = new C5538d(hMSExtLogger);
            if (z) {
                a.a(c5538d);
                return;
            } else {
                a.a().a(c5538d);
                return;
            }
        }
        throw new IllegalArgumentException("extLogger is not able to be null");
    }

    public static void w(String str, String str2) {
        a.a(5, str, str2);
    }

    public static void e(String str, String str2, Throwable th) {
        a.b(6, str, str2, th);
    }

    public static void e(String str, long j, String str2) {
        C5535a c5535a = a;
        c5535a.a(6, str, jn1.ARRAY_START_STR + j + "] " + str2);
    }

    public static void e(String str, long j, String str2, Throwable th) {
        C5535a c5535a = a;
        c5535a.b(6, str, jn1.ARRAY_START_STR + j + "] " + str2, th);
    }
}
