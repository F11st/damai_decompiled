package com.ta.utdid2.android.utils;

import android.os.Build;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class BuildCompatUtils {
    public static boolean isAtLeastM() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public static boolean isAtLeastQ() {
        if (Build.VERSION.SDK_INT < 29) {
            String str = Build.VERSION.CODENAME;
            return str.length() == 1 && str.charAt(0) >= 'Q' && str.charAt(0) <= 'Z';
        }
        return true;
    }
}
