package com.tencent.stat.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class StatPreferences {
    private static SharedPreferences defaultPerferences;

    static SharedPreferences getInstance(Context context) {
        if (defaultPerferences == null) {
            defaultPerferences = PreferenceManager.getDefaultSharedPreferences(context);
        }
        return defaultPerferences;
    }

    public static long getLong(Context context, String str, long j) {
        return getInstance(context).getLong("" + str, j);
    }

    public static String getString(Context context, String str, String str2) {
        return getInstance(context).getString("" + str, str2);
    }

    public static void putLong(Context context, String str, long j) {
        SharedPreferences.Editor edit = getInstance(context).edit();
        edit.putLong("" + str, j);
        edit.commit();
    }

    public static void putString(Context context, String str, String str2) {
        SharedPreferences.Editor edit = getInstance(context).edit();
        edit.putString("" + str, str2);
        edit.commit();
    }
}
