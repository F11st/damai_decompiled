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

    private static void a(List<ko> list, LongSparseArray<a> longSparseArray, LongSparseArray<a> longSparseArray2) {
        long b = b();
        int size = longSparseArray.size();
        Iterator<ko> it = list.iterator();
        if (size == 0) {
            while (it.hasNext()) {
                ko next = it.next();
                a aVar = new a((byte) 0);
                aVar.a = next.b();
                aVar.b = b;
                aVar.c = false;
                longSparseArray2.put(next.a(), aVar);
            }
            return;
        }
        while (it.hasNext()) {
            ko next2 = it.next();
            long a2 = next2.a();
            a aVar2 = longSparseArray.get(a2);
            if (aVar2 == null) {
                aVar2 = new a((byte) 0);
            } else if (aVar2.a == next2.b()) {
                longSparseArray2.put(a2, aVar2);
            }
            aVar2.a = next2.b();
            aVar2.b = b;
            aVar2.c = true;
            longSparseArray2.put(a2, aVar2);
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
            LongSparseArray<a> longSparseArray = this.a;
            this.a = this.b;
            this.b = longSparseArray;
            longSparseArray.clear();
        }
    }
}
