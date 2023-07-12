package com.huawei.secure.android.common.ssl.util;

import android.content.Context;

/* compiled from: Taobao */
/* renamed from: com.huawei.secure.android.common.ssl.util.c */
/* loaded from: classes10.dex */
public class C5751c {
    private static Context a;

    public static Context a() {
        return a;
    }

    public static void a(Context context) {
        if (context == null || a != null) {
            return;
        }
        a = context.getApplicationContext();
    }
}
