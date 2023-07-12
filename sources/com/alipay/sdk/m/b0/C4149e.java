package com.alipay.sdk.m.b0;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.b0.e */
/* loaded from: classes12.dex */
public final class C4149e {
    public static String a(Context context, String str, String str2, String str3) {
        return context.getSharedPreferences(str, 0).getString(str2, str3);
    }

    public static void a(Context context, String str, Map<String, String> map) {
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        if (edit != null) {
            for (String str2 : map.keySet()) {
                edit.putString(str2, map.get(str2));
            }
            edit.commit();
        }
    }
}
