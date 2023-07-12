package com.taobao.phenix.cache.memory;

import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import com.taobao.pexode.mimetype.C6838a;
import com.taobao.pexode.mimetype.MimeType;
import com.taobao.phenix.bitmap.BitmapPool;
import com.taobao.phenix.cache.LruCache;
import com.taobao.phenix.cache.memory.StaticCachedImage;
import com.taobao.phenix.request.C6865a;
import com.taobao.phenix.request.C6866b;
import com.taobao.rxm.consume.Consumer;
import com.taobao.rxm.produce.BaseChainProducer;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import tb.cu1;
import tb.ef;
import tb.oe0;
import tb.op0;
import tb.tq1;
import tb.ur1;
import tb.v5;
import tb.xt2;
import tb.z40;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class MemoryCacheProducer extends BaseChainProducer<tq1, z40, C6865a> {
    private static final StaticCachedImage.StaticImageRecycleListener l = new C6850a();
    private final LruCache<String, ef> j;
    private final LimitedQueue<String> k;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class LimitedQueue<E> extends ConcurrentLinkedQueue<E> {
        private int limit;

        public LimitedQueue(int i) {
            this.limit = i;
        }

        @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue
        public boolean add(E e) {
            boolean add = super.add(e);
            while (add && size() > this.limit) {
                super.remove();
            }
            return add;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.phenix.cache.memory.MemoryCacheProducer$a */
    /* loaded from: classes11.dex */
    static class C6850a implements StaticCachedImage.StaticImageRecycleListener {
        C6850a() {
        }

        @Override // com.taobao.phenix.cache.memory.StaticCachedImage.StaticImageRecycleListener
        public void recycle(StaticCachedImage staticCachedImage) {
            BitmapPool build = ur1.o().a().build();
            if (build != null) {
                build.putIntoPool(staticCachedImage);
            }
        }
    }

    public MemoryCacheProducer(LruCache<String, ef> lruCache) {
        super(1, 1);
        cu1.c(lruCache);
        this.j = lruCache;
        this.k = new LimitedQueue<>(1024);
    }

    private void I(Consumer<tq1, C6865a> consumer) {
        if (ur1.o().k() != null) {
            ur1.o().k().onStart(consumer.getContext().U());
        }
    }

    public static tq1 J(LruCache<String, ef> lruCache, String str, boolean z) {
        ef efVar = lruCache.get(str);
        if (efVar == null) {
            return null;
        }
        tq1 M = M(efVar, z);
        if (M != null) {
            M.fromMemory(true);
            Bitmap bitmap = M.getBitmap();
            if (bitmap != null && bitmap.isRecycled()) {
                lruCache.remove(str);
                xt2.i("MemoryCache", "remove image(exist cache but bitmap is recycled), key=%s, releasable=%b", str, Boolean.valueOf(z));
                return null;
            }
        }
        return M;
    }

    public static tq1 K(LruCache<String, ef> lruCache, String str, boolean z) {
        ef efVar = lruCache.get(str);
        if (efVar == null) {
            return null;
        }
        tq1 M = M(efVar, z);
        if (M != null) {
            M.fromMemory(true);
            Bitmap bitmap = M.getBitmap();
            if (bitmap != null && bitmap.isRecycled()) {
                lruCache.remove(str);
                xt2.i("MemoryCache", "remove image(exist cache but bitmap is recycled), key=%s, releasable=%b", str, Boolean.valueOf(z));
                return null;
            }
        }
        return M;
    }

    private static ef L(C6865a c6865a, z40 z40Var, StaticCachedImage.StaticImageRecycleListener staticImageRecycleListener) {
        C6866b G = c6865a.G();
        if (z40Var.f()) {
            return new StaticCachedImage(z40Var.b(), z40Var.c(), G.j(), G.f(), G.e(), c6865a.E()).l(staticImageRecycleListener);
        }
        return new v5(z40Var.a(), G.j(), G.f(), G.e(), c6865a.E());
    }

    private static tq1 M(ef efVar, boolean z) {
        return efVar.e(z, ur1.o().applicationContext() != null ? ur1.o().applicationContext().getResources() : null);
    }

    @Override // com.taobao.rxm.produce.BaseChainProducer, com.taobao.rxm.consume.ChainConsumer
    /* renamed from: H */
    public void consumeNewResult(Consumer<tq1, C6865a> consumer, boolean z, z40 z40Var) {
        boolean z2;
        ef L;
        C6865a context = consumer.getContext();
        boolean b0 = context.b0();
        String K = context.K();
        ef efVar = null;
        tq1 J = context.d0() ? null : J(this.j, K, b0);
        boolean z3 = J == null;
        MimeType g = z40Var.d() != null ? z40Var.d().g() : null;
        boolean z4 = ur1.w && Build.VERSION.SDK_INT == 28 && g != null && (g.g(C6838a.WEBP) || g.g(C6838a.WEBP_A));
        if (z3) {
            if (z4) {
                L = L(context, z40Var, null);
            } else {
                L = L(context, z40Var, l);
            }
            efVar = L;
            J = M(efVar, b0);
            z2 = context.k() && z && z40Var.g();
            oe0 d = z40Var.d();
            if (d != null) {
                J.fromDisk(d.k);
                J.fromSecondary(d.p);
                if (!z) {
                    d.release();
                }
            }
        } else {
            if (context.k()) {
                xt2.q("MemoryCache", context, "found existing cache before new CachedRootImage with pipeline consume result, key=%s", K);
            }
            z2 = false;
        }
        context.r0(System.currentTimeMillis());
        op0.g(context.U());
        xt2.o("Phenix", "Dispatch Image to UI Thread.", context, true);
        consumer.onNewResult(J, z);
        if (z2) {
            boolean put = this.j.put(context.L(), K, efVar);
            this.k.add(K);
            xt2.k("MemoryCache", context, "write into memcache with priority=%d, result=%B, value=%s", Integer.valueOf(context.L()), Boolean.valueOf(put), efVar);
        } else if (z3 && z && z40Var.g()) {
            xt2.q("MemoryCache", context, "skip to write into memcache cause the request is not pipeline, key=%s", K);
        }
    }

    @Override // tb.jh
    protected boolean a(Consumer<tq1, C6865a> consumer) {
        C6865a context = consumer.getContext();
        op0.e(context.U());
        if (consumer.getContext().d0()) {
            I(consumer);
            xt2.o("Phenix", "start & end ", context, true);
            return false;
        }
        xt2.o("Phenix", "start", context, true);
        o(consumer);
        String K = context.K();
        boolean b0 = context.b0();
        tq1 J = J(this.j, K, b0);
        boolean z = J != null;
        xt2.k("MemoryCache", context, "read from memcache, result=%B, key=%s", Boolean.valueOf(z), K);
        if (!z && ur1.o().p() && context.Y()) {
            String F = context.F();
            if (!TextUtils.isEmpty(F)) {
                Iterator<String> it = this.k.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String next = it.next();
                    if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(F) && next.contains(F)) {
                        J = K(this.j, next, b0);
                        break;
                    }
                }
            }
        }
        if (!z && J == null && context.T() != null) {
            String j = context.T().j();
            tq1 J2 = J(this.j, j, b0);
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(J2 != null);
            objArr[1] = j;
            xt2.k("MemoryCache", context, "secondary read from memcache, result=%B, key=%s", objArr);
            if (J2 != null) {
                J2.fromSecondary(true);
                context.x();
            }
            J = J2;
        }
        n(consumer, z);
        if (J != null) {
            consumer.onNewResult(J, z);
            context.U().u(true);
        } else {
            context.U().u(false);
        }
        if (!z && J == null && context.Z()) {
            consumer.onFailure(new MemOnlyFailedException());
            return true;
        }
        if (!z && J == null) {
            I(consumer);
        }
        xt2.o("Phenix", "End", context, z);
        return z;
    }
}
