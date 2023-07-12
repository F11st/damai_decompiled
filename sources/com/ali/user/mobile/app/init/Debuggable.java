package com.ali.user.mobile.app.init;

import android.content.Context;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class Debuggable {
    private static boolean DEBUG;

    public static void init(Context context) {
        try {
            DEBUG = (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception unused) {
        }
    }

    public static boolean isDebug() {
        return DEBUG;
    }
}
