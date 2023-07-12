package com.alibaba.android.umbrella.performance;

import android.text.TextUtils;
import androidx.annotation.Keep;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.kt2;
import tb.lt2;

/* compiled from: Taobao */
@Keep
/* loaded from: classes15.dex */
public class UmbrellaPerformanceTracker {
    public static void add(String str, String str2, String str3, long j, Map<String, String> map) {
    }

    public static void addArgs(String str, String str2, Map<String, String> map) {
    }

    public static void commit(String str, String str2) {
    }

    public static void commitPerformancePoint(String str, String str2, String str3, long j) {
        commitPerformancePoint(str, str2, str3, j, null);
    }

    public static void end(String str, String str2, String str3) {
    }

    public static void end(String str, String str2, String str3, long j) {
    }

    public static void end(String str, String str2, String str3, long j, Map<String, String> map) {
    }

    @Deprecated
    public static void register(String str, String str2, List<String> list) {
    }

    public static void start(String str, String str2, String str3) {
    }

    public static void start(String str, String str2, String str3, long j) {
    }

    public static void start(String str, String str2, String str3, long j, Map<String, String> map) {
    }

    public static void commitPerformancePoint(String str, String str2, String str3, long j, Map<String, String> map) {
        HashMap hashMap = new HashMap();
        hashMap.put(str3, Long.valueOf(j));
        commitPerformancePoint(str, str2, hashMap, map);
    }

    public static void commitPerformancePoint(String str, String str2, Map<String, Long> map, Map<String, String> map2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || map == null || map.size() < 1 || kt2.A()) {
            return;
        }
        if ((kt2.D() && kt2.o()) || kt2.v(str, str2)) {
            PerformanceEngine.commitPerformancePoint(lt2.c(str, str2, map, map2));
        }
    }
}
