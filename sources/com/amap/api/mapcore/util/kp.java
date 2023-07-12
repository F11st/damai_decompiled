package com.amap.api.mapcore.util;

import android.os.SystemClock;
import android.util.LongSparseArray;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class kp {
    private static volatile kp g;
    private static Object h = new Object();
    private Object e = new Object();
    private Object f = new Object();
    private LongSparseArray<C4605a> a = new LongSparseArray<>();
    private LongSparseArray<C4605a> b = new LongSparseArray<>();
    private LongSparseArray<C4605a> c = new LongSparseArray<>();
    private LongSparseArray<C4605a> d = new LongSparseArray<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.kp$a */
    /* loaded from: classes10.dex */
    public static class C4605a {
        int a;
        long b;
        boolean c;

        private C4605a() {
        }

        /* synthetic */ C4605a(byte b) {
            this();
        }
    }

    private kp() {
    }

    public static kp a() {
        if (g == null) {
            synchronized (h) {
                if (g == null) {
                    g = new kp();
                }
            }
        }
        return g;
    }

    private static void a(List<ko> list, LongSparseArray<C4605a> longSparseArray, LongSparseArray<C4605a> longSparseArray2) {
        long b = b();
        int size = longSparseArray.size();
        Iterator<ko> it = list.iterator();
        if (size == 0) {
            while (it.hasNext()) {
                ko next = it.next();
                C4605a c4605a = new C4605a((byte) 0);
                c4605a.a = next.b();
                c4605a.b = b;
                c4605a.c = false;
                longSparseArray2.put(next.a(), c4605a);
            }
            return;
        }
        while (it.hasNext()) {
            ko next2 = it.next();
            long a = next2.a();
            C4605a c4605a2 = longSparseArray.get(a);
            if (c4605a2 == null) {
                c4605a2 = new C4605a((byte) 0);
            } else if (c4605a2.a == next2.b()) {
                longSparseArray2.put(a, c4605a2);
            }
            c4605a2.a = next2.b();
            c4605a2.b = b;
            c4605a2.c = true;
            longSparseArray2.put(a, c4605a2);
        }
    }

    private static long b() {
        return SystemClock.elapsedRealtime();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(List<ko> list) {
        if (list.isEmpty()) {
            return;
        }
        synchronized (this.e) {
            a(list, this.a, this.b);
            LongSparseArray<C4605a> longSparseArray = this.a;
            this.a = this.b;
            this.b = longSparseArray;
            longSparseArray.clear();
        }
    }
}
