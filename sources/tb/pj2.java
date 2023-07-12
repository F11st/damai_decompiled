package tb;

import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import kotlin.text.C8603n;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final /* synthetic */ class pj2 {
    public static final int a(@NotNull String str, int i, int i2, int i3) {
        return (int) nj2.c(str, i, i2, i3);
    }

    public static final long b(@NotNull String str, long j, long j2, long j3) {
        Long k;
        String d = nj2.d(str);
        if (d != null) {
            k = C8603n.k(d);
            if (k == null) {
                throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + d + '\'').toString());
            }
            long longValue = k.longValue();
            if (j2 > longValue || j3 < longValue) {
                throw new IllegalStateException(("System property '" + str + "' should be in range " + j2 + ".." + j3 + ", but is '" + longValue + '\'').toString());
            }
            return longValue;
        }
        return j;
    }

    public static final boolean c(@NotNull String str, boolean z) {
        String d = nj2.d(str);
        return d != null ? Boolean.parseBoolean(d) : z;
    }

    public static /* synthetic */ int d(String str, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 1;
        }
        if ((i4 & 8) != 0) {
            i3 = Integer.MAX_VALUE;
        }
        return nj2.b(str, i, i2, i3);
    }

    public static /* synthetic */ long e(String str, long j, long j2, long j3, int i, Object obj) {
        if ((i & 4) != 0) {
            j2 = 1;
        }
        long j4 = j2;
        if ((i & 8) != 0) {
            j3 = AbsPerformance.LONG_NIL;
        }
        return nj2.c(str, j, j4, j3);
    }
}
