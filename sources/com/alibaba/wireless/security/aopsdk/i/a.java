package com.alibaba.wireless.security.aopsdk.i;

import android.util.Log;
import com.alibaba.wireless.security.aopsdk.config.ConfigManager;

/* compiled from: LogUtils.java */
/* loaded from: classes.dex */
public class a {
    private static int a(int i) {
        return i;
    }

    public static int a(String str, String str2) {
        return a(Log.e(str, str2));
    }

    public static int b(String str, String str2) {
        if (ConfigManager.DEBUG) {
            Log.d(str, str2);
            return 0;
        }
        return 0;
    }

    public static int a(String str, String str2, Throwable th) {
        return a(Log.e(str, str2, th));
    }
}
