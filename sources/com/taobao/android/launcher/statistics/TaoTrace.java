package com.taobao.android.launcher.statistics;

import android.text.TextUtils;
import com.taobao.android.job.core.base.Log;
import com.taobao.android.launcher.common.Switches;
import com.taobao.android.launcher.statistics.LazyExecutor;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class TaoTrace {
    private static final String SWITCH_CUSTOM_POINT = ".report_custom_dag_point";
    private static final String TAG = "TaoTrace";
    static Map<String, Set<Point>> sCustomPoints;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    static final class Point {
        final String category;
        long endTime;
        final String name;
        long startTime;

        Point(String str, String str2) {
            this.category = str;
            this.name = str2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Point.class != obj.getClass()) {
                return false;
            }
            Point point = (Point) obj;
            if (this.category.equals(point.category)) {
                return this.name.equals(point.name);
            }
            return false;
        }

        public int hashCode() {
            return (this.category.hashCode() * 31) + this.name.hashCode();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean isValid() {
            long j = this.startTime;
            if (j > 0) {
                long j2 = this.endTime;
                if (j2 > 0 && j2 >= j) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void duration(final String str, final String str2, final long j, final long j2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if ((j2 <= 0 || j <= j2) && isSwitchOn()) {
            LazyExecutor.Startup.EXECUTOR.submit(new Runnable() { // from class: com.taobao.android.launcher.statistics.TaoTrace.2
                @Override // java.lang.Runnable
                public void run() {
                    if (TaoTrace.sCustomPoints == null) {
                        TaoTrace.sCustomPoints = new LinkedHashMap();
                    }
                    Set<Point> set = TaoTrace.sCustomPoints.get(str);
                    Point point = new Point(str, str2);
                    point.startTime = j;
                    point.endTime = j2;
                    if (set != null) {
                        Log.e(TaoTrace.TAG, "add point {%s,%s}'s duration:[%d, %d] result:%b", str, str2, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(set.add(point)));
                        return;
                    }
                    HashSet hashSet = new HashSet();
                    hashSet.add(point);
                    Log.e(TaoTrace.TAG, "add point {%s,%s}'s duration:[%d, %d] result:%b", str, str2, Long.valueOf(j), Long.valueOf(j2), Boolean.TRUE);
                    TaoTrace.sCustomPoints.put(str, hashSet);
                }
            });
        }
    }

    public static void end(final String str, final String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        if (isSwitchOn()) {
            LazyExecutor.Startup.EXECUTOR.submit(new Runnable() { // from class: com.taobao.android.launcher.statistics.TaoTrace.1
                @Override // java.lang.Runnable
                public void run() {
                    Set<Point> set;
                    Map<String, Set<Point>> map = TaoTrace.sCustomPoints;
                    if (map == null || (set = map.get(str)) == null) {
                        return;
                    }
                    Point point = new Point(str, str2);
                    for (Point point2 : set) {
                        if (point.equals(point2)) {
                            point2.endTime = currentTimeMillis;
                            Log.e(TaoTrace.TAG, "update point {%s,%s}'s duration:[%d, %d] result:%b", str, str2, Long.valueOf(point2.startTime), Long.valueOf(currentTimeMillis), Boolean.TRUE);
                            return;
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isSwitchOn() {
        return Switches.isSwitchOn(SWITCH_CUSTOM_POINT);
    }

    public static void start(String str, String str2) {
        duration(str, str2, System.currentTimeMillis(), 0L);
    }
}
