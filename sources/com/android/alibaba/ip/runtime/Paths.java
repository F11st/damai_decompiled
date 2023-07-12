package com.android.alibaba.ip.runtime;

import android.content.Context;
import java.io.File;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class Paths {
    public static String getDataDirectory(String str) {
        return "/data/data/" + str + "/files/instant-patch";
    }

    public static String getExternalDataDirectory(Context context) {
        File externalFilesDir = context.getExternalFilesDir("instant-patch");
        if (externalFilesDir != null) {
            return externalFilesDir.getPath();
        }
        return null;
    }

    public static String getMainApkDataDirectory(String str) {
        return "/data/data/" + str;
    }

    public static String getMainApkFilesDirectory(String str) {
        return "/data/data/" + str + "/files";
    }

    public static String getDataDirectory(Context context) {
        return new File(context.getFilesDir(), "instant-patch").getPath();
    }

    public static String getMainApkDataDirectory(Context context) {
        return context.getFilesDir().getParentFile().getPath();
    }

    public static String getMainApkFilesDirectory(Context context) {
        return context.getFilesDir().getPath();
    }
}
