package com.alibaba.android.newsharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: com.alibaba.android.newsharedpreferences.a */
/* loaded from: classes5.dex */
public class C3236a {
    private static final HashMap<String, Object> a = new HashMap<>();

    private static SharedPreferences a(Context context, String str) {
        SharedPreferences sharedPreferences;
        HashMap<String, Object> hashMap = a;
        synchronized (hashMap) {
            if (!hashMap.containsKey(str)) {
                hashMap.put(str, new SharedPreferencesNewImpl(b(context, str)));
            }
            sharedPreferences = (SharedPreferences) hashMap.get(str);
        }
        return sharedPreferences;
    }

    public static File b(Context context, String str) {
        String absolutePath = d(context, str).getAbsolutePath();
        return new File(absolutePath.substring(0, absolutePath.length() - 4) + ".sp");
    }

    public static SharedPreferences c(Context context, String str) {
        e(context, str);
        return a(context, str);
    }

    public static File d(Context context, String str) {
        return (File) f(context, "getSharedPrefsFile", new Class[]{String.class}, new Object[]{str});
    }

    private static synchronized void e(Context context, String str) {
        synchronized (C3236a.class) {
            if (context == null) {
                return;
            }
            SharedPreferences a2 = a(context, "sp_replace_flag");
            if (!a2.contains(str)) {
                SharedPreferences a3 = a(context, str);
                SharedPreferences.Editor edit = a3.edit();
                if (((SharedPreferencesNewImpl) a3).s() <= 1) {
                    Map<String, ?> all = context.getSharedPreferences(str, 0).getAll();
                    if (all.size() > 0) {
                        for (Map.Entry<String, ?> entry : all.entrySet()) {
                            String key = entry.getKey();
                            Object value = entry.getValue();
                            if (key != null && key.trim().length() > 0 && value != null) {
                                if (value instanceof String) {
                                    edit.putString(key, (String) value);
                                } else if (value instanceof Long) {
                                    edit.putLong(key, ((Long) value).longValue());
                                } else if (value instanceof Integer) {
                                    edit.putInt(key, ((Integer) value).intValue());
                                } else if (value instanceof Float) {
                                    edit.putFloat(key, ((Float) value).floatValue());
                                } else if (value instanceof Boolean) {
                                    edit.putBoolean(key, ((Boolean) value).booleanValue());
                                }
                            }
                        }
                        edit.apply();
                    }
                }
                a2.edit().putBoolean(str, true).apply();
            }
        }
    }

    private static Object f(Object obj, String str, Class[] clsArr, Object[] objArr) {
        try {
            Method method = obj.getClass().getMethod(str, clsArr);
            method.setAccessible(true);
            return method.invoke(obj, objArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
