package com.youku.android.utils;

import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class CalculateUtils {
    public static Double calculateAverage(List<Long> list) {
        Double valueOf = Double.valueOf(0.0d);
        if (list.isEmpty()) {
            return valueOf;
        }
        for (Long l : list) {
            valueOf = Double.valueOf(valueOf.doubleValue() + l.longValue());
        }
        return Double.valueOf(valueOf.doubleValue() / list.size());
    }
}
