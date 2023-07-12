package com.youku.skinmanager.utils;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.util.Log;
import com.youku.skinmanager.SkinManager;
import java.io.File;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class Utils {
    private static final String SP_NAME = "youku_skin_manager";
    private static final String TAG = "YoukuSkinManager";

    public static boolean fileIsExists(String str) {
        try {
            return new File(str).exists();
        } catch (Exception unused) {
            return false;
        }
    }

    public static long getAvailableInternalMemorySize() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return statFs.getAvailableBlocks() * statFs.getBlockSize();
    }

    public static String getPreference(Context context, String str) {
        return getPreference(context, str, "");
    }

    public static void savePreference(Context context, String str, String str2) {
        if (context == null) {
            Log.e(TAG, "savePreference context is null");
        } else {
            SkinManager.sContext.getSharedPreferences(SP_NAME, 0).edit().putString(str, str2).apply();
        }
    }

    public static String getPreference(Context context, String str, String str2) {
        if (context == null) {
            Log.e(TAG, "savePreference context is null");
            return null;
        }
        return SkinManager.sContext.getSharedPreferences(SP_NAME, 0).getString(str, str2);
    }
}
