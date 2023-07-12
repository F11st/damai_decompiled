package com.alient.oneservice.provider.impl.kvdata;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class DefaultShareperfence {
    private static SharedPreferences mPreferences;

    public static boolean getBoolean(String str) {
        if (mPreferences == null) {
            init();
        }
        SharedPreferences sharedPreferences = mPreferences;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean(str, false);
        }
        return false;
    }

    public static int getInt(String str) {
        if (mPreferences == null) {
            init();
        }
        SharedPreferences sharedPreferences = mPreferences;
        if (sharedPreferences != null) {
            return sharedPreferences.getInt(str, 0);
        }
        return 0;
    }

    public static long getLong(String str) {
        if (mPreferences == null) {
            init();
        }
        SharedPreferences sharedPreferences = mPreferences;
        if (sharedPreferences != null) {
            return sharedPreferences.getLong(str, 0L);
        }
        return 0L;
    }

    public static SharedPreferences getSp() {
        return mPreferences;
    }

    public static String getString(String str) {
        if (mPreferences == null) {
            init();
        }
        SharedPreferences sharedPreferences = mPreferences;
        return sharedPreferences != null ? sharedPreferences.getString(str, "") : "";
    }

    private static void init() {
        if (AppInfoProviderProxy.getApplication() != null) {
            mPreferences = PreferenceManager.getDefaultSharedPreferences(AppInfoProviderProxy.getApplication().getApplicationContext());
        }
    }

    public static void putString(String str, String str2) {
        if (mPreferences == null) {
            init();
        }
        SharedPreferences sharedPreferences = mPreferences;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(str, str2).commit();
        }
    }

    public static void savePreference(String str, String str2) {
        if (mPreferences == null) {
            init();
        }
        SharedPreferences sharedPreferences = mPreferences;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(str, str2).apply();
        }
    }

    public static boolean getBoolean(String str, boolean z) {
        if (mPreferences == null) {
            init();
        }
        SharedPreferences sharedPreferences = mPreferences;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean(str, z);
        }
        return false;
    }

    public static int getInt(String str, int i) {
        if (mPreferences == null) {
            init();
        }
        SharedPreferences sharedPreferences = mPreferences;
        if (sharedPreferences != null) {
            return sharedPreferences.getInt(str, i);
        }
        return 0;
    }

    public static long getLong(String str, long j) {
        if (mPreferences == null) {
            init();
        }
        SharedPreferences sharedPreferences = mPreferences;
        if (sharedPreferences != null) {
            return sharedPreferences.getLong(str, j);
        }
        return 0L;
    }

    public static String getString(String str, String str2) {
        if (mPreferences == null) {
            init();
        }
        SharedPreferences sharedPreferences = mPreferences;
        return sharedPreferences != null ? sharedPreferences.getString(str, str2) : "";
    }

    public static void savePreference(String str, int i) {
        if (mPreferences == null) {
            init();
        }
        SharedPreferences sharedPreferences = mPreferences;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt(str, i).apply();
        }
    }

    public static void savePreference(String str, long j) {
        if (mPreferences == null) {
            init();
        }
        SharedPreferences sharedPreferences = mPreferences;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong(str, j).apply();
        }
    }

    public static void savePreference(String str, boolean z) {
        if (mPreferences == null) {
            init();
        }
        SharedPreferences sharedPreferences = mPreferences;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(str, z).apply();
        }
    }
}
