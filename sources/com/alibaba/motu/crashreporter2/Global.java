package com.alibaba.motu.crashreporter2;

import android.content.Context;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
class Global {
    private static Context context;
    private static String processName;

    Global() {
    }

    public static Context getContext() {
        return context;
    }

    public static String getProcessName() {
        return processName;
    }

    public static void setContext(Context context2) {
        context = context2;
    }

    public static void setProcessName(String str) {
        processName = str;
    }
}
