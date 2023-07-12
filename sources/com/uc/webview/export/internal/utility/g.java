package com.uc.webview.export.internal.utility;

import android.os.Build;
import java.io.File;
import java.io.IOException;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class g {
    public static boolean a(File file) {
        if (file != null) {
            try {
                if (!file.exists() || c(file)) {
                    return true;
                }
                if (Build.VERSION.SDK_INT >= 9) {
                    return file.setReadable(true, false);
                }
                Runtime runtime = Runtime.getRuntime();
                runtime.exec("chmod 644 " + file.getAbsolutePath());
            } catch (Exception e) {
                Log.e("FileUtils", "setReadable failed", e);
                return false;
            }
        }
        return true;
    }

    public static boolean b(File file) {
        if (file != null) {
            try {
                if (!file.exists() || c(file)) {
                    return true;
                }
                if (Build.VERSION.SDK_INT >= 9) {
                    return file.setExecutable(true, false);
                }
                Runtime runtime = Runtime.getRuntime();
                runtime.exec("chmod 711 " + file.getAbsolutePath());
            } catch (Exception e) {
                Log.e("FileUtils", "setExecutable", e);
                return false;
            }
        }
        return true;
    }

    private static boolean c(File file) {
        try {
            String canonicalPath = file.getCanonicalPath();
            if (canonicalPath.contains("/data/app/")) {
                return true;
            }
            return canonicalPath.contains("/system/");
        } catch (IOException e) {
            Log.e("FileUtils", "isSystemFile failed", e);
            return false;
        }
    }

    private static void d(File file) {
        try {
            boolean exists = file.exists();
            if (exists) {
                file.delete();
            }
            StringBuilder sb = new StringBuilder("delete ");
            sb.append(file.getAbsolutePath());
            sb.append(exists ? ", exists" : ", not exists");
            Log.d("FileUtils", sb.toString());
        } catch (Throwable th) {
            Log.w("FileUtils", "delete " + file.getAbsolutePath() + ", failed", th);
        }
    }

    public static final void a(String str) {
        d(new File(str));
    }

    public static final void a(String str, String str2) {
        d(new File(str, str2));
    }
}
