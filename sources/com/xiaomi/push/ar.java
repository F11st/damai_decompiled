package com.xiaomi.push;

import android.os.Looper;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ar {
    public static void a() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            throw new RuntimeException("can't do this on ui thread");
        }
    }
}
