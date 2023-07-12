package com.huawei.hms.framework.common;

import android.content.ContentResolver;
import android.provider.Settings;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class SettingUtil {
    private static final String TAG = "SettingUtil";

    public static int getSecureInt(ContentResolver contentResolver, String str, int i) {
        try {
            return Settings.Secure.getInt(contentResolver, str, i);
        } catch (RuntimeException e) {
            Logger.e(TAG, "Settings Secure getInt throwFromSystemServer:", e);
            return i;
        }
    }

    public static int getSystemInt(ContentResolver contentResolver, String str, int i) {
        try {
            return Settings.System.getInt(contentResolver, str, i);
        } catch (RuntimeException e) {
            Logger.e(TAG, "Settings System getInt throwFromSystemServer:", e);
            return i;
        }
    }
}
