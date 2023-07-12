package com.youku.danmaku.engine.danmaku.util;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class SystemClock {
    public static final void sleep(long j) {
        android.os.SystemClock.sleep(j);
    }

    public static final long uptimeMillis() {
        return android.os.SystemClock.elapsedRealtime();
    }
}
