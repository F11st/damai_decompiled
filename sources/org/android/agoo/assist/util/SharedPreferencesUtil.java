package org.android.agoo.assist.util;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class SharedPreferencesUtil {
    private static final String SP_NAME = "ACCS_SDK";

    public static SharedPreferences.Editor editor(Context context) {
        return getSP(context).edit();
    }

    private static SharedPreferences getSP(Context context) {
        return context.getSharedPreferences("ACCS_SDK", 4);
    }

    public static String getStringVal(Context context, String str, String str2) {
        return getSP(context).getString(str, str2);
    }
}
