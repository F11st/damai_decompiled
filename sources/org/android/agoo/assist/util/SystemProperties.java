package org.android.agoo.assist.util;

import android.util.Log;
import tb.gn1;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class SystemProperties {
    private static final String TAG = "SystemProperties";

    public static String get(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(gn1.TYPE_OPEN_URL_METHOD_GET, String.class).invoke(cls.newInstance(), str);
        } catch (Exception e) {
            Log.e(TAG, "get() ERROR!!! Exception!", e);
            return "";
        }
    }

    public static String get(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(gn1.TYPE_OPEN_URL_METHOD_GET, String.class, String.class).invoke(cls.newInstance(), str, str2);
        } catch (Exception e) {
            Log.e(TAG, "get() ERROR!!! Exception!", e);
            return "";
        }
    }
}
