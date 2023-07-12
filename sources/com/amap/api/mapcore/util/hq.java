package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class hq {
    private static HashMap<String, String> a = new HashMap<>();

    public static void a(Context context, gm gmVar, String str, String str2) {
        if (gmVar == null || TextUtils.isEmpty(gmVar.a())) {
            return;
        }
        String str3 = str + gmVar.a();
        a.put(gmVar.a() + str, str2);
        if (context == null || TextUtils.isEmpty(str3) || TextUtils.isEmpty("d7afbc6a38848a6801f6e449f3ec8e53") || TextUtils.isEmpty(str2)) {
            return;
        }
        String g = gn.g(ga.a(gn.a(str2)));
        SharedPreferences.Editor edit = context.getSharedPreferences("d7afbc6a38848a6801f6e449f3ec8e53", 0).edit();
        edit.putString(str3, g);
        edit.commit();
    }

    public static String a(Context context, gm gmVar, String str) {
        if (gmVar == null || TextUtils.isEmpty(gmVar.a())) {
            return null;
        }
        String str2 = a.get(gmVar.a() + str);
        if (TextUtils.isEmpty(str2)) {
            String str3 = str + gmVar.a();
            return (context == null || TextUtils.isEmpty(str3)) ? "" : gn.a(ga.b(gn.e(context.getSharedPreferences("d7afbc6a38848a6801f6e449f3ec8e53", 0).getString(str3, ""))));
        }
        return str2;
    }
}
