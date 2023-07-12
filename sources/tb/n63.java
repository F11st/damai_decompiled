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
    private LongSparseArray<a> a = new LongSparseArray<>();
    private LongSparseArray<a> b = new LongSparseArray<>();
    private LongSparseArray<a> c = new LongSparseArray<>();
    private LongSparseArray<a> d = new LongSparseArray<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class a {
        int a;
        long b;
        boolean c;

        private a() {
        }

        /* synthetic */ a(byte b) {
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

    private static short c(LongSparseArray<a> longSparseArray, long j) {
        synchronized (longSparseArray) {
            a aVar = longSparseArray.get(j);
            if (aVar == null) {
                return (short) 0;
            }
            short max = (short) Math.max(1L, Math.min(32767L, (f() - aVar.b) / 1000));
            if (!aVar.c) {
                max = (short) (-max);
            }
            return max;
        }
    }

    private static void e(List<com.loc.dl> list, LongSparseArray<a> longSparseArray, LongSparseArray<a> longSparseArray2) {
        long f = f();
        int size = longSparseArray.size();
        Iterator<com.loc.dl> it = list.iterator();
        if (size == 0) {
            while (it.hasNext()) {
                com.loc.dl next = it.next();
                a aVar = new a((byte) 0);
                aVar.a = next.b();
                aVar.b = f;
                aVar.c = false;
                longSparseArray2.put(next.a(), aVar);
            }
            return;
        }
        while (it.hasNext()) {
            com.loc.dl next2 = it.next();
            long a2 = next2.a();
            a aVar2 = longSparseArray.get(a2);
            if (aVar2 == null) {
                aVar2 = new a((byte) 0);
            } else if (aVar2.a == next2.b()) {
                longSparseArray2.put(a2, aVar2);
            }
            aVar2.a = next2.b();
            aVar2.b = f;
            aVar2.c = true;
            longSparseArray2.put(a2, aVar2);
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
            LongSparseArray<a> longSparseArray = this.a;
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
            LongSparseArray<a> longSparseArray = this.c;
            this.c = this.d;
            this.d = longSparseArray;
            longSparseArray.clear();
        }
    }
}
