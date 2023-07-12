package tb;

import com.taobao.weex.utils.WXLogUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class sg2 {
    private static final ThreadLocal<sg2> d = new ThreadLocal<>();
    private long a;
    private List<a> b = new ArrayList();
    private long c;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class a {
    }

    public static double a(long j) {
        return j / 1000000.0d;
    }

    private static void b() {
        ThreadLocal<sg2> threadLocal = d;
        if (threadLocal.get() == null) {
            threadLocal.set(new sg2());
        }
    }

    public static void c(String str) {
        if (wz2.b()) {
            try {
                a aVar = new a();
                ThreadLocal<sg2> threadLocal = d;
                long j = threadLocal.get().c;
                e();
                threadLocal.get().b.add(aVar);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static double d() {
        if (wz2.b()) {
            try {
                ThreadLocal<sg2> threadLocal = d;
                long j = threadLocal.get().a;
                if (j == 0) {
                    WXLogUtils.w("Stopwatch", "Should call Stopwatch.tick() before Stopwatch.tack() called");
                }
                threadLocal.get().a = 0L;
                return a(System.nanoTime() - j);
            } catch (Throwable th) {
                th.printStackTrace();
                return -1.0d;
            }
        }
        return -1.0d;
    }

    public static double e() {
        double d2 = d();
        f();
        return d2;
    }

    public static void f() {
        if (wz2.b()) {
            try {
                b();
                ThreadLocal<sg2> threadLocal = d;
                if (threadLocal.get().a != 0) {
                    WXLogUtils.w("Stopwatch", "Stopwatch is not reset");
                }
                threadLocal.get().a = System.nanoTime();
                threadLocal.get().c = System.currentTimeMillis();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
