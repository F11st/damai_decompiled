package io.flutter.util;

import android.content.Context;
import android.os.Build;
import io.flutter.stat.StatServices;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class PathUtils {
    public static String getCacheDirectory(Context context) {
        if (Build.VERSION.SDK_INT >= 21) {
            return context.getCodeCacheDir().getPath();
        }
        return context.getCacheDir().getPath();
    }

    public static String getDataDirectory(Context context) {
        return context.getDir(StatServices.EVENTCATEGORY, 0).getPath();
    }

    public static String getFilesDir(Context context) {
        return context.getFilesDir().getPath();
    }
}
