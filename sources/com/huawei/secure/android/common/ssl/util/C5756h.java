package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import android.content.pm.PackageManager;

/* compiled from: Taobao */
/* renamed from: com.huawei.secure.android.common.ssl.util.h */
/* loaded from: classes10.dex */
public class C5756h {
    private static final String a = "h";

    public static String a(String str) {
        Context a2 = C5751c.a();
        if (a2 == null) {
            return "";
        }
        try {
            return a2.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            String str2 = a;
            C5755g.b(str2, "getVersion NameNotFoundException : " + e.getMessage());
            return "";
        } catch (Exception e2) {
            String str3 = a;
            C5755g.b(str3, "getVersion: " + e2.getMessage());
            return "";
        } catch (Throwable unused) {
            C5755g.b(a, "throwable");
            return "";
        }
    }

    public static int b(String str) {
        Context a2 = C5751c.a();
        if (a2 == null) {
            return 0;
        }
        try {
            return a2.getPackageManager().getPackageInfo(str, 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            C5755g.b(a, "getVersion NameNotFoundException");
            return 0;
        } catch (Exception e) {
            String str2 = a;
            C5755g.b(str2, "getVersion: " + e.getMessage());
            return 0;
        }
    }
}
