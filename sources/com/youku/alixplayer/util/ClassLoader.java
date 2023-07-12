package com.youku.alixplayer.util;

import android.content.Context;
import androidx.annotation.Keep;

/* compiled from: Taobao */
@Keep
/* loaded from: classes5.dex */
public class ClassLoader {
    private static java.lang.ClassLoader sApplicationClassLoader = null;
    private static int sDebuggable = -1;

    public static boolean isDebug() {
        if (sDebuggable == -1) {
            try {
                Context applicationContext = SystemUtil.getApplicationContext();
                if (applicationContext != null) {
                    if ((applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 0).flags & 2) != 0) {
                        sDebuggable = 1;
                    } else {
                        sDebuggable = 0;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return sDebuggable == 1;
    }

    public static Class<?> loadClass(String str) {
        try {
            java.lang.ClassLoader classLoader = sApplicationClassLoader;
            return classLoader != null ? classLoader.loadClass(str) : Class.forName(str);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void setApplicationClassLoader(java.lang.ClassLoader classLoader) {
        if (sApplicationClassLoader != null || classLoader == null) {
            return;
        }
        sApplicationClassLoader = classLoader;
    }
}
