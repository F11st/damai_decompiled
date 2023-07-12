package com.taobao.orange.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import androidx.annotation.NonNull;
import java.util.HashSet;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class SPUtil {
    private static final String TAG = "SPUtil";

    public static Object getFromSharePreference(Context context, @NonNull String str, Object obj) {
        SharedPreferences sharedPreferences;
        if (context == null) {
            return obj;
        }
        try {
            sharedPreferences = context.getSharedPreferences("orange", 0);
        } catch (Throwable th) {
            OLog.e(TAG, "get from share preference failed", th.toString());
        }
        if (obj instanceof String) {
            return sharedPreferences.getString(str, (String) obj);
        }
        if (obj instanceof Integer) {
            return Integer.valueOf(sharedPreferences.getInt(str, ((Integer) obj).intValue()));
        }
        if (obj instanceof Boolean) {
            return Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) obj).booleanValue()));
        }
        if (obj instanceof Float) {
            return Float.valueOf(sharedPreferences.getFloat(str, ((Float) obj).floatValue()));
        }
        if (obj instanceof Long) {
            return Long.valueOf(sharedPreferences.getLong(str, ((Long) obj).longValue()));
        }
        return obj;
    }

    public static Set<String> getSetFromSharePreference(Context context, @NonNull String str, Set<String> set) {
        if (context == null) {
            return set;
        }
        try {
            return new HashSet(context.getSharedPreferences("orange", 0).getStringSet(str, set));
        } catch (Throwable th) {
            OLog.e(TAG, "get set from share preference failed", th.toString());
            return set;
        }
    }

    public static void saveSetToSharePreference(Context context, @NonNull String str, Set<String> set) {
        if (context == null) {
            return;
        }
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("orange", 0).edit();
            edit.putStringSet(str, set);
            if (Build.VERSION.SDK_INT >= 9) {
                edit.apply();
            } else {
                edit.commit();
            }
        } catch (Throwable th) {
            OLog.e(TAG, "save set to share preference failed", th.toString());
        }
    }

    public static void saveToSharePreference(Context context, @NonNull String str, Object obj) {
        if (context == null) {
            return;
        }
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("orange", 0).edit();
            if (obj instanceof String) {
                edit.putString(str, (String) obj);
            } else if (obj instanceof Integer) {
                edit.putInt(str, ((Integer) obj).intValue());
            } else if (obj instanceof Boolean) {
                edit.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Float) {
                edit.putFloat(str, ((Float) obj).floatValue());
            } else if (obj instanceof Long) {
                edit.putLong(str, ((Long) obj).longValue());
            } else {
                edit.putString(str, obj.toString());
            }
            if (Build.VERSION.SDK_INT >= 9) {
                edit.apply();
            } else {
                edit.commit();
            }
        } catch (Throwable th) {
            OLog.e(TAG, "save to share preference failed", th.toString());
        }
    }
}
