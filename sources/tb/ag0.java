package tb;

import com.youku.live.livesdk.monitor.performance.AbsPerformance;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class ag0 {
    private static final kj2 a = new kj2("REMOVED_TASK");
    private static final kj2 b = new kj2("CLOSED_EMPTY");

    public static final long c(long j) {
        return j / 1000000;
    }

    public static final long d(long j) {
        if (j <= 0) {
            return 0L;
        }
        return j >= 9223372036854L ? AbsPerformance.LONG_NIL : 1000000 * j;
    }
}
