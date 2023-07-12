package com.android.alibaba.ip.utils;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class PreferencesUtils {
    public static boolean getBoolean(Context context, String str, String str2) {
        return getBoolean(context, str, str2, false);
    }

    public static SharedPreferences.Editor getEditor(Context context, String str) {
        return context.getSharedPreferences(str, 0).edit();
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
        return getString(context, str, str2, null);
    }

    public static boolean putBoolean(Context context, String str, String str2, boolean z) {
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putBoolean(str2, z);
        return edit.commit();
    }

    public static boolean putFloat(Context context, String str, String str2, float f) {
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putFloat(str2, f);
        return edit.commit();
    }

    public static boolean putInt(Context context, String str, String str2, int i) {
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putInt(str2, i);
        return edit.commit();
    }

    public static boolean putLong(Context context, String str, String str2, long j) {
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putLong(str2, j);
        return edit.commit();
    }

    public static boolean putString(Context context, String str, String str2, String str3) {
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putString(str2, str3);
        return edit.commit();
    }

    public static boolean remove(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.remove(str2);
        return edit.commit();
    }

    public static boolean getBoolean(Context context, String str, String str2, boolean z) {
        return context.getSharedPreferences(str, 0).getBoolean(str2, z);
    }

    public static float getFloat(Context context, String str, String str2, float f) {
        return context.getSharedPreferences(str, 0).getFloat(str2, f);
    }

    public static int getInt(Context context, String str, String str2, int i) {
        return context.getSharedPreferences(str, 0).getInt(str2, i);
    }

    public static long getLong(Context context, String str, String str2, long j) {
        return context.getSharedPreferences(str, 0).getLong(str2, j);
    }

    public static String getString(Context context, String str, String str2, String str3) {
        return context.getSharedPreferences(str, 0).getString(str2, str3);
    }
}
