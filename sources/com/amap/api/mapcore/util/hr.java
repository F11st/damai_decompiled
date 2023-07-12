package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class hr {
    private String a;

    public hr(String str) {
        this.a = gk.b(TextUtils.isDigitsOnly(str) ? "SPUtil" : str);
    }

    public void a(Context context, String str, boolean z) {
        a(context, str, Boolean.toString(z));
    }

    public boolean b(Context context, String str, boolean z) {
        try {
            return Boolean.parseBoolean(a(context, str));
        } catch (Throwable unused) {
            return z;
        }
    }

    public void a(Context context, String str, String str2) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences(this.a, 0).edit();
                edit.putString(str, gn.g(ga.a(context, gn.a(str2))));
                a(edit);
            } catch (Throwable unused) {
            }
        }
    }

    public String a(Context context, String str) {
        if (context == null) {
            return "";
        }
        try {
            return gn.a(ga.b(context, gn.e(context.getSharedPreferences(this.a, 0).getString(str, ""))));
        } catch (Throwable unused) {
            return "";
        }
    }

    private void a(SharedPreferences.Editor editor) {
        if (editor == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 9) {
            editor.apply();
        } else {
            editor.commit();
        }
    }
}
