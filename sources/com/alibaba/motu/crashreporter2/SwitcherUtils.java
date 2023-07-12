package com.alibaba.motu.crashreporter2;

import android.preference.PreferenceManager;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
class SwitcherUtils {
    SwitcherUtils() {
    }

    public static String valueOf(String str, String str2) {
        return PreferenceManager.getDefaultSharedPreferences(Global.getContext()).getString(str, str2);
    }
}
