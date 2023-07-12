package com.amap.api.mapcore.util;

import android.content.Context;
import android.util.Log;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class ds {
    static String a;

    static {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 80; i++) {
            sb.append("=");
        }
        a = sb.toString();
    }

    public static void a() {
        b(a);
        b("当前使用的自定义地图样式文件和目前版本不匹配，请到官网(lbs.amap.com)更新新版样式文件");
        b(a);
    }

    private static void b(String str) {
        Log.i("authErrLog", str);
    }

    public static void a(Context context, String str) {
        b(a);
        if (context != null) {
            a("key:" + gc.f(context));
        }
        b(str);
        b(a);
    }

    static void a(String str) {
        if (str.length() < 78) {
            StringBuilder sb = new StringBuilder();
            sb.append("|");
            sb.append(str);
            for (int i = 0; i < 78 - str.length(); i++) {
                sb.append(" ");
            }
            sb.append("|");
            b(sb.toString());
            return;
        }
        String substring = str.substring(0, 78);
        b("|" + substring + "|");
        a(str.substring(78));
    }
}
