package tb;

import anet.channel.util.ALog;
import anetwork.channel.cache.Cache;
import anetwork.channel.cache.CachePrediction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ze {
    private static List<a> a = new ArrayList();
    private static final ReentrantReadWriteLock b;
    private static final ReentrantReadWriteLock.ReadLock c;
    private static final ReentrantReadWriteLock.WriteLock d;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    private static class a implements Comparable<a> {
        final Cache a;
        final CachePrediction b;
        final int c;

        a(Cache cache, CachePrediction cachePrediction, int i) {
            this.a = cache;
            this.b = cachePrediction;
            this.c = i;
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(a aVar) {
            return this.c - aVar.c;
        }
    }

    static {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        b = reentrantReadWriteLock;
        c = reentrantReadWriteLock.readLock();
        d = reentrantReadWriteLock.writeLock();
    }

    public static void a(Cache cache, CachePrediction cachePrediction, int i) {
        try {
            if (cache == null) {
                throw new IllegalArgumentException("cache is null");
            }
            if (cachePrediction != null) {
                ReentrantReadWriteLock.WriteLock writeLock = d;
                writeLock.lock();
                a.add(new a(cache, cachePrediction, i));
                Collections.sort(a);
                writeLock.unlock();
                return;
            }
            throw new IllegalArgumentException("prediction is null");
        } catch (Throwable th) {
            d.unlock();
            throw th;
        }
    }

    public static void b() {
        ALog.k("anet.CacheManager", "clearAllCache", null, new Object[0]);
        for (a aVar : a) {
            try {
                aVar.a.clear();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001f, code lost:
        r3 = r1.a;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static anetwork.channel.cache.Cache c(java.lang.String r3, java.util.Map<java.lang.String, java.lang.String> r4) {
        /*
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = tb.ze.c     // Catch: java.lang.Throwable -> L29
            r0.lock()     // Catch: java.lang.Throwable -> L29
            java.util.List<tb.ze$a> r0 = tb.ze.a     // Catch: java.lang.Throwable -> L29
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L29
        Lb:
            boolean r1 = r0.hasNext()     // Catch: java.lang.Throwable -> L29
            if (r1 == 0) goto L27
            java.lang.Object r1 = r0.next()     // Catch: java.lang.Throwable -> L29
            tb.ze$a r1 = (tb.ze.a) r1     // Catch: java.lang.Throwable -> L29
            anetwork.channel.cache.CachePrediction r2 = r1.b     // Catch: java.lang.Throwable -> L29
            boolean r2 = r2.handleCache(r3, r4)     // Catch: java.lang.Throwable -> L29
            if (r2 == 0) goto Lb
            anetwork.channel.cache.Cache r3 = r1.a     // Catch: java.lang.Throwable -> L29
        L21:
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r4 = tb.ze.c
            r4.unlock()
            return r3
        L27:
            r3 = 0
            goto L21
        L29:
            r3 = move-exception
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r4 = tb.ze.c
            r4.unlock()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.ze.c(java.lang.String, java.util.Map):anetwork.channel.cache.Cache");
    }
}
