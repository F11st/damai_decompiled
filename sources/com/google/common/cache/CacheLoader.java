package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import tb.du1;

/* compiled from: Taobao */
@GwtCompatible(emulated = true)
/* loaded from: classes10.dex */
public abstract class CacheLoader<K, V> {

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private static final class FunctionToCacheLoader<K, V> extends CacheLoader<K, V> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Function<K, V> computingFunction;

        public FunctionToCacheLoader(Function<K, V> function) {
            this.computingFunction = (Function) du1.p(function);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.cache.CacheLoader
        public V load(K k) {
            return (V) this.computingFunction.apply(du1.p(k));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static final class InvalidCacheLoadException extends RuntimeException {
        public InvalidCacheLoadException(String str) {
            super(str);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private static final class SupplierToCacheLoader<V> extends CacheLoader<Object, V> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Supplier<V> computingSupplier;

        public SupplierToCacheLoader(Supplier<V> supplier) {
            this.computingSupplier = (Supplier) du1.p(supplier);
        }

        @Override // com.google.common.cache.CacheLoader
        public V load(Object obj) {
            du1.p(obj);
            return this.computingSupplier.get();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static final class UnsupportedLoadingOperationException extends UnsupportedOperationException {
        UnsupportedLoadingOperationException() {
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.common.cache.CacheLoader$a */
    /* loaded from: classes10.dex */
    static class C4850a extends CacheLoader<K, V> {
        final /* synthetic */ Executor b;

        /* compiled from: Taobao */
        /* renamed from: com.google.common.cache.CacheLoader$a$a */
        /* loaded from: classes10.dex */
        class CallableC4851a implements Callable<V> {
            final /* synthetic */ Object a;
            final /* synthetic */ Object b;

            CallableC4851a(Object obj, Object obj2) {
                this.a = obj;
                this.b = obj2;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public V call() throws Exception {
                return CacheLoader.this.reload(this.a, this.b).get();
            }
        }

        C4850a(Executor executor) {
            this.b = executor;
        }

        @Override // com.google.common.cache.CacheLoader
        public V load(K k) throws Exception {
            return (V) CacheLoader.this.load(k);
        }

        @Override // com.google.common.cache.CacheLoader
        public Map<K, V> loadAll(Iterable<? extends K> iterable) throws Exception {
            return CacheLoader.this.loadAll(iterable);
        }

        @Override // com.google.common.cache.CacheLoader
        public ListenableFuture<V> reload(K k, V v) throws Exception {
            ListenableFutureTask create = ListenableFutureTask.create(new CallableC4851a(k, v));
            this.b.execute(create);
            return create;
        }
    }

    @GwtIncompatible
    public static <K, V> CacheLoader<K, V> asyncReloading(CacheLoader<K, V> cacheLoader, Executor executor) {
        du1.p(cacheLoader);
        du1.p(executor);
        return new C4850a(executor);
    }

    public static <K, V> CacheLoader<K, V> from(Function<K, V> function) {
        return new FunctionToCacheLoader(function);
    }

    public abstract V load(K k) throws Exception;

    public Map<K, V> loadAll(Iterable<? extends K> iterable) throws Exception {
        throw new UnsupportedLoadingOperationException();
    }

    @GwtIncompatible
    public ListenableFuture<V> reload(K k, V v) throws Exception {
        du1.p(k);
        du1.p(v);
        return Futures.f(load(k));
    }

    public static <V> CacheLoader<Object, V> from(Supplier<V> supplier) {
        return new SupplierToCacheLoader(supplier);
    }
}
