package tb;

import android.os.SystemClock;
import android.util.LongSparseArray;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class n63 {
    private static volatile n63 g;
    private static Object h = new Object();
    private Object e = new Object();
    private Object f = new Object();
    private LongSparseArray<C9461a> a = new LongSparseArray<>();
    private LongSparseArray<C9461a> b = new LongSparseArray<>();
    private LongSparseArray<C9461a> c = new LongSparseArray<>();
    private LongSparseArray<C9461a> d = new LongSparseArray<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: tb.n63$a */
    /* loaded from: classes10.dex */
    public static class C9461a {
        int a;
        long b;
        boolean c;

        private C9461a() {
        }

        /* synthetic */ C9461a(byte b) {
            this();
        }
    }

    private n63() {
    }

    public static n63 a() {
        if (g == null) {
            synchronized (h) {
                if (g == null) {
                    g = new n63();
                }
            }
        }
        return g;
    }

    private static short c(LongSparseArray<C9461a> longSparseArray, long j) {
        synchronized (longSparseArray) {
            C9461a c9461a = longSparseArray.get(j);
            if (c9461a == null) {
                return (short) 0;
            }
            short max = (short) Math.max(1L, Math.min(32767L, (f() - c9461a.b) / 1000));
            if (!c9461a.c) {
                max = (short) (-max);
            }
            return max;
        }
    }

    private static void e(List<com.loc.dl> list, LongSparseArray<C9461a> longSparseArray, LongSparseArray<C9461a> longSparseArray2) {
        long f = f();
        int size = longSparseArray.size();
        Iterator<com.loc.dl> it = list.iterator();
        if (size == 0) {
            while (it.hasNext()) {
                com.loc.dl next = it.next();
                C9461a c9461a = new C9461a((byte) 0);
                c9461a.a = next.b();
                c9461a.b = f;
                c9461a.c = false;
                longSparseArray2.put(next.a(), c9461a);
            }
            return;
        }
        while (it.hasNext()) {
            com.loc.dl next2 = it.next();
            long a = next2.a();
            C9461a c9461a2 = longSparseArray.get(a);
            if (c9461a2 == null) {
                c9461a2 = new C9461a((byte) 0);
            } else if (c9461a2.a == next2.b()) {
                longSparseArray2.put(a, c9461a2);
            }
            c9461a2.a = next2.b();
            c9461a2.b = f;
            c9461a2.c = true;
            longSparseArray2.put(a, c9461a2);
        }
    }

    private static long f() {
        return SystemClock.elapsedRealtime();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final short b(long j) {
        return c(this.a, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(List<com.loc.dl> list) {
        if (list.isEmpty()) {
            return;
        }
        synchronized (this.e) {
            e(list, this.a, this.b);
            LongSparseArray<C9461a> longSparseArray = this.a;
            this.a = this.b;
            this.b = longSparseArray;
            longSparseArray.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final short g(long j) {
        return c(this.c, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void h(List<com.loc.dl> list) {
        if (list.isEmpty()) {
            return;
        }
        synchronized (this.f) {
            e(list, this.c, this.d);
            LongSparseArray<C9461a> longSparseArray = this.c;
            this.c = this.d;
            this.d = longSparseArray;
            longSparseArray.clear();
        }
    }
}
