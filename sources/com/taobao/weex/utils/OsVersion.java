package com.taobao.weex.utils;

import android.os.Build;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class OsVersion {
    private static boolean a;

    static {
        a = getApiVersion() >= 18;
    }

    public static int getApiVersion() {
        return Build.VERSION.SDK_INT;
    }

    public static boolean isAtLeastJB_MR2() {
        return a;
    }
}
