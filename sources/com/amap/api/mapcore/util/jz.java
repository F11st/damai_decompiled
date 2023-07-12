package com.amap.api.mapcore.util;

import java.util.Calendar;
import java.util.Date;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class jz {
    private static long a(long j) {
        return j - b(j);
    }

    public static long a(long j, long j2) {
        try {
            return Math.abs(j - j2) > 31536000000L ? b(j, j2) : j;
        } catch (Throwable unused) {
            return j;
        }
    }

    private static long b(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j));
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    private static long b(long j, long j2) {
        long b = b(j2) + a(j);
        long abs = Math.abs(b - j2);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(b));
        int i = calendar.get(11);
        if (i == 23 && abs >= 82800000) {
            b -= 86400000;
        }
        return (i != 0 || abs < 82800000) ? b : b + 86400000;
    }
}
