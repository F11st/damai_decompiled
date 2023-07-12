package com.huawei.secure.android.common.util;

import android.os.Handler;
import android.os.Looper;

/* compiled from: Taobao */
/* renamed from: com.huawei.secure.android.common.util.c */
/* loaded from: classes10.dex */
public class C5763c {
    private static Handler a = new Handler(Looper.getMainLooper());

    public static void a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        a.post(runnable);
    }
}
