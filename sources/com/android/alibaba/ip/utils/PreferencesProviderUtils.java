package com.android.alibaba.ip.utils;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.android.alibaba.ip.server.PreferencesProvider;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class PreferencesProviderUtils {
    private static Uri buildUri(Context context, int i, String str, String str2, Object obj) {
        String string = PreferencesUtils.getString(context, PreferencesProvider.AUTHORITIES_SPNAME, PreferencesProvider.AUTHORITIES_KEY);
        switch (i) {
            case 100:
                return Uri.parse("content://" + string + "/string/" + str + "/" + str2 + "/" + obj);
            case 101:
                return Uri.parse("content://" + string + "/integer/" + str + "/" + str2 + "/" + obj);
            case 102:
                return Uri.parse("content://" + string + "/long/" + str + "/" + str2 + "/" + obj);
            case 103:
            default:
                return null;
            case 104:
                return Uri.parse("content://" + string + "/float/" + str + "/" + str2 + "/" + obj);
            case 105:
                return Uri.parse("content://" + string + "/boolean/" + str + "/" + str2 + "/" + obj);
            case 106:
                return Uri.parse("content://" + string + "/delete/" + str + "/" + str2);
            case 107:
                return Uri.parse("content://" + string + "/puts");
            case 108:
                return Uri.parse("content://" + string + "/clear/" + str);
        }
    }

    public static boolean clear(Context context, String str) {
        try {
            context.getContentResolver().delete(buildUri(context, 108, str, null, null), null, null);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean getBoolean(Context context, String str, String str2) {
        return getBoolean(context, str, str2, false);
    }

    public static float getFloat(Context context, String str, String str2) {
        return getFloat(context, str, str2, -1.0f);
    }

    public static int getInt(Context context, String str, String str2) {
        return getInt(context, str, str2, -1);
    }

    public static long getLong(Context context, String str, String str2) {
        return getLong(context, str, str2, -1L);
    }

    public static String getString(Context context, String str, String str2) {
        return getString(context, str, str2, "");
    }

    public static boolean put(Context context, String str, ContentValues contentValues) {
        try {
            context.getContentResolver().insert(buildUri(context, 107, str, null, null), contentValues);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean putBoolean(Context context, String str, String str2, boolean z) {
        Uri buildUri = buildUri(context, 105, str, str2, Boolean.valueOf(z));
        ContentResolver contentResolver = context.getContentResolver();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(str2, Boolean.valueOf(z));
            contentResolver.insert(buildUri, contentValues);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean putFloat(Context context, String str, String str2, float f) {
        Uri buildUri = buildUri(context, 104, str, str2, Float.valueOf(f));
        ContentResolver contentResolver = context.getContentResolver();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(str2, Float.valueOf(f));
            contentResolver.insert(buildUri, contentValues);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean putInt(Context context, String str, String str2, int i) {
        Uri buildUri = buildUri(context, 101, str, str2, Integer.valueOf(i));
        ContentResolver contentResolver = context.getContentResolver();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(str2, Integer.valueOf(i));
            contentResolver.insert(buildUri, contentValues);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean putLong(Context context, String str, String str2, long j) {
        Uri buildUri = buildUri(context, 102, str, str2, Long.valueOf(j));
        ContentResolver contentResolver = context.getContentResolver();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(str2, Long.valueOf(j));
            contentResolver.insert(buildUri, contentValues);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean putString(Context context, String str, String str2, String str3) {
        Uri buildUri = buildUri(context, 100, str, str2, str3);
        ContentResolver contentResolver = context.getContentResolver();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(str2, str3);
            contentResolver.insert(buildUri, contentValues);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean remove(Context context, String str, String str2) {
        try {
            context.getContentResolver().delete(buildUri(context, 106, str, str2, null), null, null);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean getBoolean(Context context, String str, String str2, boolean z) {
        Cursor query = context.getContentResolver().query(buildUri(context, 105, str, str2, Boolean.valueOf(z)), null, null, null, null);
        return (query != null && query.moveToNext()) ? Boolean.valueOf(query.getString(query.getColumnIndex(PreferencesProvider.COLUMNNAME))).booleanValue() : z;
    }

    public static float getFloat(Context context, String str, String str2, float f) {
        Cursor query = context.getContentResolver().query(buildUri(context, 104, str, str2, Float.valueOf(f)), null, null, null, null);
        return (query != null && query.moveToNext()) ? query.getFloat(query.getColumnIndex(PreferencesProvider.COLUMNNAME)) : f;
    }

    public static int getInt(Context context, String str, String str2, int i) {
        Cursor query = context.getContentResolver().query(buildUri(context, 101, str, str2, Integer.valueOf(i)), null, null, null, null);
        return (query != null && query.moveToNext()) ? query.getInt(query.getColumnIndex(PreferencesProvider.COLUMNNAME)) : i;
    }

    public static long getLong(Context context, String str, String str2, long j) {
        Cursor query = context.getContentResolver().query(buildUri(context, 102, str, str2, Long.valueOf(j)), null, null, null, null);
        return (query != null && query.moveToNext()) ? query.getLong(query.getColumnIndex(PreferencesProvider.COLUMNNAME)) : j;
    }

    public static String getString(Context context, String str, String str2, String str3) {
        Cursor query = context.getContentResolver().query(buildUri(context, 100, str, str2, str3), null, null, null, null);
        return (query != null && query.moveToNext()) ? query.getString(query.getColumnIndex(PreferencesProvider.COLUMNNAME)) : str3;
    }
}
