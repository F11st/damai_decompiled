package com.taobao.android.job.core.helper;

import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class TimeHelpers {
    public static long between(long j, long j2) {
        return TimeUnit.MILLISECONDS.toMillis(j2 - j);
    }

    public static long duration(long j) {
        return TimeUnit.MILLISECONDS.toMillis(j);
    }

    public static long since(long j) {
        return between(j, System.currentTimeMillis());
    }
}
