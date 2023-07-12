package tb;

import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import com.youku.upsplayer.util.YKUpsConvert;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.JvmInline;
import kotlin.text.StringsKt__StringsKt;
import kotlin.time.DurationUnit;
import kotlin.time.ExperimentalTime;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@SinceKotlin(version = "1.6")
@JvmInline
@WasExperimental(markerClass = {ExperimentalTime.class})
/* loaded from: classes3.dex */
public final class ed0 implements Comparable<ed0> {
    @NotNull
    public static final C9098a Companion = new C9098a(null);
    private static final long b;
    private static final long c;
    private final long a;

    /* compiled from: Taobao */
    /* renamed from: tb.ed0$a */
    /* loaded from: classes3.dex */
    public static final class C9098a {
        private C9098a() {
        }

        public /* synthetic */ C9098a(k50 k50Var) {
            this();
        }
    }

    static {
        long e;
        long e2;
        d(0L);
        e = hd0.e(hd0.MAX_MILLIS);
        b = e;
        e2 = hd0.e(-4611686018427387903L);
        c = e2;
    }

    private static final void a(long j, StringBuilder sb, int i, int i2, int i3, String str, boolean z) {
        String k0;
        sb.append(i);
        if (i2 != 0) {
            sb.append('.');
            k0 = StringsKt__StringsKt.k0(String.valueOf(i2), i3, YKUpsConvert.CHAR_ZERO);
            int i4 = -1;
            int length = k0.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i5 = length - 1;
                    if (k0.charAt(length) != '0') {
                        i4 = length;
                        break;
                    } else if (i5 < 0) {
                        break;
                    } else {
                        length = i5;
                    }
                }
            }
            int i6 = i4 + 1;
            if (!z && i6 < 3) {
                sb.append((CharSequence) k0, 0, i6);
                b41.h(sb, "this.append(value, startIndex, endIndex)");
            } else {
                sb.append((CharSequence) k0, 0, ((i6 + 2) / 3) * 3);
                b41.h(sb, "this.append(value, startIndex, endIndex)");
            }
        }
        sb.append(str);
    }

    public static int c(long j, long j2) {
        long j3 = j ^ j2;
        if (j3 < 0 || (((int) j3) & 1) == 0) {
            return b41.l(j, j2);
        }
        int i = (((int) j) & 1) - (((int) j2) & 1);
        return u(j) ? -i : i;
    }

    public static long d(long j) {
        if (gd0.a()) {
            if (s(j)) {
                if (!new ec1(-4611686018426999999L, hd0.MAX_NANOS).d(p(j))) {
                    throw new AssertionError(p(j) + " ns is out of nanoseconds range");
                }
            } else if (new ec1(-4611686018427387903L, hd0.MAX_MILLIS).d(p(j))) {
                if (new ec1(-4611686018426L, 4611686018426L).d(p(j))) {
                    throw new AssertionError(p(j) + " ms is denormalized");
                }
            } else {
                throw new AssertionError(p(j) + " ms is out of milliseconds range");
            }
        }
        return j;
    }

    public static boolean e(long j, Object obj) {
        return (obj instanceof ed0) && j == ((ed0) obj).y();
    }

    public static final long f(long j) {
        return u(j) ? x(j) : j;
    }

    public static final int g(long j) {
        if (t(j)) {
            return 0;
        }
        return (int) (i(j) % 24);
    }

    public static final long h(long j) {
        return v(j, DurationUnit.DAYS);
    }

    public static final long i(long j) {
        return v(j, DurationUnit.HOURS);
    }

    public static final long j(long j) {
        return v(j, DurationUnit.MINUTES);
    }

    public static final long k(long j) {
        return v(j, DurationUnit.SECONDS);
    }

    public static final int l(long j) {
        if (t(j)) {
            return 0;
        }
        return (int) (j(j) % 60);
    }

    public static final int m(long j) {
        long p;
        if (t(j)) {
            return 0;
        }
        if (r(j)) {
            p = hd0.f(p(j) % 1000);
        } else {
            p = p(j) % ((long) aw2.SECOND_IN_NANOS);
        }
        return (int) p;
    }

    public static final int n(long j) {
        if (t(j)) {
            return 0;
        }
        return (int) (k(j) % 60);
    }

    private static final DurationUnit o(long j) {
        return s(j) ? DurationUnit.NANOSECONDS : DurationUnit.MILLISECONDS;
    }

    private static final long p(long j) {
        return j >> 1;
    }

    public static int q(long j) {
        return (int) (j ^ (j >>> 32));
    }

    private static final boolean r(long j) {
        return (((int) j) & 1) == 1;
    }

    private static final boolean s(long j) {
        return (((int) j) & 1) == 0;
    }

    public static final boolean t(long j) {
        return j == b || j == c;
    }

    public static final boolean u(long j) {
        return j < 0;
    }

    public static final long v(long j, @NotNull DurationUnit durationUnit) {
        b41.i(durationUnit, "unit");
        if (j == b) {
            return AbsPerformance.LONG_NIL;
        }
        if (j == c) {
            return Long.MIN_VALUE;
        }
        return id0.a(p(j), o(j), durationUnit);
    }

    @NotNull
    public static String w(long j) {
        if (j == 0) {
            return "0s";
        }
        if (j == b) {
            return "Infinity";
        }
        if (j == c) {
            return "-Infinity";
        }
        boolean u = u(j);
        StringBuilder sb = new StringBuilder();
        if (u) {
            sb.append('-');
        }
        long f = f(j);
        long h = h(f);
        int g = g(f);
        int l = l(f);
        int n = n(f);
        int m = m(f);
        int i = 0;
        boolean z = h != 0;
        boolean z2 = g != 0;
        boolean z3 = l != 0;
        boolean z4 = (n == 0 && m == 0) ? false : true;
        if (z) {
            sb.append(h);
            sb.append('d');
            i = 1;
        }
        if (z2 || (z && (z3 || z4))) {
            int i2 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(g);
            sb.append('h');
            i = i2;
        }
        if (z3 || (z4 && (z2 || z))) {
            int i3 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(l);
            sb.append('m');
            i = i3;
        }
        if (z4) {
            int i4 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            if (n != 0 || z || z2 || z3) {
                a(j, sb, n, m, 9, "s", false);
            } else if (m >= 1000000) {
                a(j, sb, m / 1000000, m % 1000000, 6, "ms", false);
            } else if (m >= 1000) {
                a(j, sb, m / 1000, m % 1000, 3, "us", false);
            } else {
                sb.append(m);
                sb.append(NotificationStyle.NOTIFICATION_STYLE);
            }
            i = i4;
        }
        if (u && i > 1) {
            sb.insert(1, '(').append(')');
        }
        String sb2 = sb.toString();
        b41.h(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public static final long x(long j) {
        long d;
        d = hd0.d(-p(j), ((int) j) & 1);
        return d;
    }

    public int b(long j) {
        return c(this.a, j);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(ed0 ed0Var) {
        return b(ed0Var.y());
    }

    public boolean equals(Object obj) {
        return e(this.a, obj);
    }

    public int hashCode() {
        return q(this.a);
    }

    @NotNull
    public String toString() {
        return w(this.a);
    }

    public final /* synthetic */ long y() {
        return this.a;
    }
}
