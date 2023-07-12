package com.huawei.hms.hatool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.analytics.core.network.NetworkUtil;
import com.alibaba.motu.crashreporter.Constants;
import com.alibaba.wireless.security.aopsdk.replace.android.provider.Settings;
import com.alipay.sdk.m.c.C4151a;
import java.lang.reflect.InvocationTargetException;
import tb.gn1;

/* compiled from: Taobao */
/* renamed from: com.huawei.hms.hatool.f */
/* loaded from: classes10.dex */
public abstract class AbstractC5616f {

    /* compiled from: Taobao */
    /* renamed from: com.huawei.hms.hatool.f$a */
    /* loaded from: classes10.dex */
    public static class C5617a extends Exception {
        public C5617a(String str) {
            super(str);
        }
    }

    public static Object a(Class cls, String str, Class[] clsArr, Object[] objArr) {
        String str2;
        if (cls == null) {
            throw new C5617a("class is null in invokeStaticFun");
        }
        if (clsArr == null) {
            if (objArr != null) {
                throw new C5617a("paramsType is null, but params is not null");
            }
        } else if (objArr == null) {
            throw new C5617a("paramsType or params should be same");
        } else {
            if (clsArr.length != objArr.length) {
                throw new C5617a("paramsType len:" + clsArr.length + " should equal params.len:" + objArr.length);
            }
        }
        try {
            try {
                return cls.getMethod(str, clsArr).invoke(null, objArr);
            } catch (IllegalAccessException unused) {
                str2 = "invokeStaticFun(): method invoke Exception!";
                C5653y.f("hmsSdk", str2);
                return null;
            } catch (IllegalArgumentException unused2) {
                str2 = "invokeStaticFun(): Illegal Argument!";
                C5653y.f("hmsSdk", str2);
                return null;
            } catch (InvocationTargetException unused3) {
                str2 = "invokeStaticFun(): Invocation Target Exception!";
                C5653y.f("hmsSdk", str2);
                return null;
            }
        } catch (NoSuchMethodException unused4) {
            C5653y.f("hmsSdk", "invokeStaticFun(): cls.getMethod(),No Such Method !");
        }
    }

    public static Object a(String str, String str2, Class[] clsArr, Object[] objArr) {
        String str3;
        try {
            return a(Class.forName(str), str2, clsArr, objArr);
        } catch (C5617a unused) {
            str3 = "invokeStaticFun(): Static function call Exception ";
            C5653y.f("hmsSdk", str3);
            return null;
        } catch (ClassNotFoundException unused2) {
            str3 = "invokeStaticFun() Not found class!";
            C5653y.f("hmsSdk", str3);
            return null;
        }
    }

    public static String a() {
        return a(C4151a.a, "");
    }

    @SuppressLint({"HardwareIds"})
    public static String a(Context context) {
        return context == null ? "" : Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        String a = a("android.os.SystemProperties", str, str2);
        return TextUtils.isEmpty(a) ? a("com.huawei.android.os.SystemPropertiesEx", str, str2) : a;
    }

    public static String a(String str, String str2, String str3) {
        Object a = a(str, gn1.TYPE_OPEN_URL_METHOD_GET, new Class[]{String.class, String.class}, new Object[]{str2, str3});
        return a != null ? (String) a : str3;
    }

    public static String b() {
        String a = a("com.huawei.android.os.SystemPropertiesEx", "ro.huawei.build.display.id", "");
        C5653y.c("hmsSdk", "SystemPropertiesEx: get rom_ver: " + a);
        if (TextUtils.isEmpty(a)) {
            String str = Build.DISPLAY;
            C5653y.c("hmsSdk", "SystemProperties: get rom_ver: " + str);
            return str;
        }
        return a;
    }

    public static String b(Context context) {
        Bundle bundle;
        Object obj;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null || (obj = bundle.get(Constants.CHANNEL)) == null) {
                return NetworkUtil.NETWORK_CLASS_UNKNOWN;
            }
            String obj2 = obj.toString();
            return obj2.length() > 256 ? NetworkUtil.NETWORK_CLASS_UNKNOWN : obj2;
        } catch (PackageManager.NameNotFoundException unused) {
            C5653y.f("hmsSdk", "getChannel(): The packageName is not correct!");
            return NetworkUtil.NETWORK_CLASS_UNKNOWN;
        }
    }

    public static String c(Context context) {
        return context == null ? "" : context.getPackageName();
    }

    public static String d(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return context.getPackageManager().getPackageInfo(c(context), 16384).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            C5653y.f("hmsSdk", "getVersion(): The package name is not correct!");
            return "";
        }
    }
}
