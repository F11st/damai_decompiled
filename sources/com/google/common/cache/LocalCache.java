package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.primitives.Ints;
import com.google.common.util.concurrent.ExecutionError;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.UncheckedExecutionException;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import com.google.j2objc.annotations.Weak;
import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractQueue;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.cf;
import tb.du1;
import tb.g2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
@GwtCompatible(emulated = true)
/* loaded from: classes10.dex */
public class LocalCache<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V> {
    static final Logger w = Logger.getLogger(LocalCache.class.getName());
    static final ValueReference<Object, Object> x = new a();
    static final Queue<?> y = new b();
    final int a;
    final int b;
    final Segment<K, V>[] c;
    final int d;
    final Equivalence<Object> e;
    final Equivalence<Object> f;
    final Strength g;
    final Strength h;
    final long i;
    final Weigher<K, V> j;
    final long k;
    final long l;
    final long m;
    final Queue<RemovalNotification<K, V>> n;
    final RemovalListener<K, V> o;
    final com.google.common.base.j p;
    final EntryFactory q;
    final AbstractCache$StatsCounter r;
    @NullableDecl
    final CacheLoader<? super K, V> s;
    @MonotonicNonNullDecl
    Set<K> t;
    @MonotonicNonNullDecl
    Collection<V> u;
    @MonotonicNonNullDecl
    Set<Map.Entry<K, V>> v;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public enum EntryFactory {
        STRONG { // from class: com.google.common.cache.LocalCache.EntryFactory.1
            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<Object, Object> newEntry(Segment<Object, Object> segment, Object obj, int i, @NullableDecl ReferenceEntry<Object, Object> referenceEntry) {
                return new o(obj, i, referenceEntry);
            }
        },
        STRONG_ACCESS { // from class: com.google.common.cache.LocalCache.EntryFactory.2
            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<Object, Object> copyEntry(Segment<Object, Object> segment, ReferenceEntry<Object, Object> referenceEntry, ReferenceEntry<Object, Object> referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyAccessEntry(referenceEntry, copyEntry);
                return copyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<Object, Object> newEntry(Segment<Object, Object> segment, Object obj, int i, @NullableDecl ReferenceEntry<Object, Object> referenceEntry) {
                return new m(obj, i, referenceEntry);
            }
        },
        STRONG_WRITE { // from class: com.google.common.cache.LocalCache.EntryFactory.3
            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<Object, Object> copyEntry(Segment<Object, Object> segment, ReferenceEntry<Object, Object> referenceEntry, ReferenceEntry<Object, Object> referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyWriteEntry(referenceEntry, copyEntry);
                return copyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<Object, Object> newEntry(Segment<Object, Object> segment, Object obj, int i, @NullableDecl ReferenceEntry<Object, Object> referenceEntry) {
                return new q(obj, i, referenceEntry);
            }
        },
        STRONG_ACCESS_WRITE { // from class: com.google.common.cache.LocalCache.EntryFactory.4
            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<Object, Object> copyEntry(Segment<Object, Object> segment, ReferenceEntry<Object, Object> referenceEntry, ReferenceEntry<Object, Object> referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyAccessEntry(referenceEntry, copyEntry);
                copyWriteEntry(referenceEntry, copyEntry);
                return copyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<Object, Object> newEntry(Segment<Object, Object> segment, Object obj, int i, @NullableDecl ReferenceEntry<Object, Object> referenceEntry) {
                return new n(obj, i, referenceEntry);
            }
        },
        WEAK { // from class: com.google.common.cache.LocalCache.EntryFactory.5
            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<Object, Object> newEntry(Segment<Object, Object> segment, Object obj, int i, @NullableDecl ReferenceEntry<Object, Object> referenceEntry) {
                return new v(segment.keyReferenceQueue, obj, i, referenceEntry);
            }
        },
        WEAK_ACCESS { // from class: com.google.common.cache.LocalCache.EntryFactory.6
            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<Object, Object> copyEntry(Segment<Object, Object> segment, ReferenceEntry<Object, Object> referenceEntry, ReferenceEntry<Object, Object> referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyAccessEntry(referenceEntry, copyEntry);
                return copyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<Object, Object> newEntry(Segment<Object, Object> segment, Object obj, int i, @NullableDecl ReferenceEntry<Object, Object> referenceEntry) {
                return new t(segment.keyReferenceQueue, obj, i, referenceEntry);
            }
        },
        WEAK_WRITE { // from class: com.google.common.cache.LocalCache.EntryFactory.7
            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<Object, Object> copyEntry(Segment<Object, Object> segment, ReferenceEntry<Object, Object> referenceEntry, ReferenceEntry<Object, Object> referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyWriteEntry(referenceEntry, copyEntry);
                return copyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<Object, Object> newEntry(Segment<Object, Object> segment, Object obj, int i, @NullableDecl ReferenceEntry<Object, Object> referenceEntry) {
                return new x(segment.keyReferenceQueue, obj, i, referenceEntry);
            }
        },
        WEAK_ACCESS_WRITE { // from class: com.google.common.cache.LocalCache.EntryFactory.8
            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<Object, Object> copyEntry(Segment<Object, Object> segment, ReferenceEntry<Object, Object> referenceEntry, ReferenceEntry<Object, Object> referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyAccessEntry(referenceEntry, copyEntry);
                copyWriteEntry(referenceEntry, copyEntry);
                return copyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<Object, Object> newEntry(Segment<Object, Object> segment, Object obj, int i, @NullableDecl ReferenceEntry<Object, Object> referenceEntry) {
                return new u(segment.keyReferenceQueue, obj, i, referenceEntry);
            }
        };
        
        static final int ACCESS_MASK = 1;
        static final int WEAK_MASK = 4;
        static final int WRITE_MASK = 2;
        static final EntryFactory[] factories = {STRONG, STRONG_ACCESS, STRONG_WRITE, STRONG_ACCESS_WRITE, WEAK, WEAK_ACCESS, WEAK_WRITE, WEAK_ACCESS_WRITE};

        static EntryFactory getFactory(Strength strength, boolean z, boolean z2) {
            return factories[(strength == Strength.WEAK ? 4 : 0) | (z ? 1 : 0) | (z2 ? 2 : 0)];
        }

        <K, V> void copyAccessEntry(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            referenceEntry2.setAccessTime(referenceEntry.getAccessTime());
            LocalCache.c(referenceEntry.getPreviousInAccessQueue(), referenceEntry2);
            LocalCache.c(referenceEntry2, referenceEntry.getNextInAccessQueue());
            LocalCache.x(referenceEntry);
        }

        <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            return newEntry(segment, referenceEntry.getKey(), referenceEntry.getHash(), referenceEntry2);
        }

        <K, V> void copyWriteEntry(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            referenceEntry2.setWriteTime(referenceEntry.getWriteTime());
            LocalCache.d(referenceEntry.getPreviousInWriteQueue(), referenceEntry2);
            LocalCache.d(referenceEntry2, referenceEntry.getNextInWriteQueue());
            LocalCache.y(referenceEntry);
        }

        abstract <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, @NullableDecl ReferenceEntry<K, V> referenceEntry);

        /* synthetic */ EntryFactory(a aVar) {
            this();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static final class LoadingSerializationProxy<K, V> extends ManualSerializationProxy<K, V> implements LoadingCache<K, V> {
        private static final long serialVersionUID = 1;
        @MonotonicNonNullDecl
        transient LoadingCache<K, V> autoDelegate;

        LoadingSerializationProxy(LocalCache<K, V> localCache) {
            super(localCache);
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.autoDelegate = (LoadingCache<K, V>) recreateCacheBuilder().b((CacheLoader<? super K, V>) this.loader);
        }

        private Object readResolve() {
            return this.autoDelegate;
        }

        @Override // com.google.common.cache.LoadingCache, com.google.common.base.Function
        public final V apply(K k) {
            return this.autoDelegate.apply(k);
        }

        @Override // com.google.common.cache.LoadingCache
        public V get(K k) throws ExecutionException {
            return this.autoDelegate.get(k);
        }

        @Override // com.google.common.cache.LoadingCache
        public ImmutableMap<K, V> getAll(Iterable<? extends K> iterable) throws ExecutionException {
            return this.autoDelegate.getAll(iterable);
        }

        @Override // com.google.common.cache.LoadingCache
        public V getUnchecked(K k) {
            return this.autoDelegate.getUnchecked(k);
        }

        @Override // com.google.common.cache.LoadingCache
        public void refresh(K k) {
            this.autoDelegate.refresh(k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class LocalLoadingCache<K, V> extends LocalManualCache<K, V> implements LoadingCache<K, V> {
        private static final long serialVersionUID = 1;

        /* JADX INFO: Access modifiers changed from: package-private */
        public LocalLoadingCache(CacheBuilder<? super K, ? super V> cacheBuilder, CacheLoader<? super K, V> cacheLoader) {
            super(new LocalCache(cacheBuilder, (CacheLoader) du1.p(cacheLoader)), null);
        }

        @Override // com.google.common.cache.LoadingCache, com.google.common.base.Function
        public final V apply(K k) {
            return getUnchecked(k);
        }

        @Override // com.google.common.cache.LoadingCache
        public V get(K k) throws ExecutionException {
            return this.localCache.p(k);
        }

        @Override // com.google.common.cache.LoadingCache
        public ImmutableMap<K, V> getAll(Iterable<? extends K> iterable) throws ExecutionException {
            return this.localCache.l(iterable);
        }

        @Override // com.google.common.cache.LoadingCache
        public V getUnchecked(K k) {
            try {
                return get(k);
            } catch (ExecutionException e) {
                throw new UncheckedExecutionException(e.getCause());
            }
        }

        @Override // com.google.common.cache.LoadingCache
        public void refresh(K k) {
            this.localCache.F(k);
        }

        @Override // com.google.common.cache.LocalCache.LocalManualCache
        Object writeReplace() {
            return new LoadingSerializationProxy(this.localCache);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class LocalManualCache<K, V> implements Cache<K, V>, Serializable {
        private static final long serialVersionUID = 1;
        final LocalCache<K, V> localCache;

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        class a extends CacheLoader<Object, V> {
            final /* synthetic */ Callable a;

            a(LocalManualCache localManualCache, Callable callable) {
                this.a = callable;
            }

            @Override // com.google.common.cache.CacheLoader
            public V load(Object obj) throws Exception {
                return (V) this.a.call();
            }
        }

        /* synthetic */ LocalManualCache(LocalCache localCache, a aVar) {
            this(localCache);
        }

        @Override // com.google.common.cache.Cache
        public ConcurrentMap<K, V> asMap() {
            return this.localCache;
        }

        @Override // com.google.common.cache.Cache
        public void cleanUp() {
            this.localCache.b();
        }

        @Override // com.google.common.cache.Cache
        public V get(K k, Callable<? extends V> callable) throws ExecutionException {
            du1.p(callable);
            return this.localCache.k(k, new a(this, callable));
        }

        @Override // com.google.common.cache.Cache
        public ImmutableMap<K, V> getAllPresent(Iterable<?> iterable) {
            return this.localCache.m(iterable);
        }

        @Override // com.google.common.cache.Cache
        @NullableDecl
        public V getIfPresent(Object obj) {
            return this.localCache.n(obj);
        }

        @Override // com.google.common.cache.Cache
        public void invalidate(Object obj) {
            du1.p(obj);
            this.localCache.remove(obj);
        }

        @Override // com.google.common.cache.Cache
        public void invalidateAll(Iterable<?> iterable) {
            this.localCache.r(iterable);
        }

        @Override // com.google.common.cache.Cache
        public void put(K k, V v) {
            this.localCache.put(k, v);
        }

        @Override // com.google.common.cache.Cache
        public void putAll(Map<? extends K, ? extends V> map) {
            this.localCache.putAll(map);
        }

        @Override // com.google.common.cache.Cache
        public long size() {
            return this.localCache.u();
        }

        @Override // com.google.common.cache.Cache
        public cf stats() {
            com.google.common.cache.a aVar = new com.google.common.cache.a();
            aVar.a(this.localCache.r);
            for (Segment<K, V> segment : this.localCache.c) {
                aVar.a(segment.statsCounter);
            }
            return aVar.snapshot();
        }

        Object writeReplace() {
            return new ManualSerializationProxy(this.localCache);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public LocalManualCache(CacheBuilder<? super K, ? super V> cacheBuilder) {
            this(new LocalCache(cacheBuilder, null));
        }

        @Override // com.google.common.cache.Cache
        public void invalidateAll() {
            this.localCache.clear();
        }

        private LocalManualCache(LocalCache<K, V> localCache) {
            this.localCache = localCache;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class ManualSerializationProxy<K, V> extends com.google.common.cache.b<K, V> implements Serializable {
        private static final long serialVersionUID = 1;
        final int concurrencyLevel;
        @MonotonicNonNullDecl
        transient Cache<K, V> delegate;
        final long expireAfterAccessNanos;
        final long expireAfterWriteNanos;
        final Equivalence<Object> keyEquivalence;
        final Strength keyStrength;
        final CacheLoader<? super K, V> loader;
        final long maxWeight;
        final RemovalListener<? super K, ? super V> removalListener;
        @NullableDecl
        final com.google.common.base.j ticker;
        final Equivalence<Object> valueEquivalence;
        final Strength valueStrength;
        final Weigher<K, V> weigher;

        ManualSerializationProxy(LocalCache<K, V> localCache) {
            this(localCache.g, localCache.h, localCache.e, localCache.f, localCache.l, localCache.k, localCache.i, localCache.j, localCache.d, localCache.o, localCache.p, localCache.s);
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.delegate = (Cache<K, V>) recreateCacheBuilder().a();
        }

        private Object readResolve() {
            return this.delegate;
        }

        CacheBuilder<K, V> recreateCacheBuilder() {
            CacheBuilder<K, V> cacheBuilder = (CacheBuilder<K, V>) CacheBuilder.y().A(this.keyStrength).B(this.valueStrength).v(this.keyEquivalence).D(this.valueEquivalence).e(this.concurrencyLevel).z((RemovalListener<? super K, ? super V>) this.removalListener);
            cacheBuilder.a = false;
            long j = this.expireAfterWriteNanos;
            if (j > 0) {
                cacheBuilder.g(j, TimeUnit.NANOSECONDS);
            }
            long j2 = this.expireAfterAccessNanos;
            if (j2 > 0) {
                cacheBuilder.f(j2, TimeUnit.NANOSECONDS);
            }
            Weigher weigher = this.weigher;
            if (weigher != CacheBuilder.OneWeigher.INSTANCE) {
                cacheBuilder.E(weigher);
                long j3 = this.maxWeight;
                if (j3 != -1) {
                    cacheBuilder.x(j3);
                }
            } else {
                long j4 = this.maxWeight;
                if (j4 != -1) {
                    cacheBuilder.w(j4);
                }
            }
            com.google.common.base.j jVar = this.ticker;
            if (jVar != null) {
                cacheBuilder.C(jVar);
            }
            return cacheBuilder;
        }

        private ManualSerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, long j, long j2, long j3, Weigher<K, V> weigher, int i, RemovalListener<? super K, ? super V> removalListener, com.google.common.base.j jVar, CacheLoader<? super K, V> cacheLoader) {
            this.keyStrength = strength;
            this.valueStrength = strength2;
            this.keyEquivalence = equivalence;
            this.valueEquivalence = equivalence2;
            this.expireAfterWriteNanos = j;
            this.expireAfterAccessNanos = j2;
            this.maxWeight = j3;
            this.weigher = weigher;
            this.concurrencyLevel = i;
            this.removalListener = removalListener;
            this.ticker = (jVar == com.google.common.base.j.b() || jVar == CacheBuilder.s) ? null : null;
            this.loader = cacheLoader;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.cache.b, com.google.common.collect.t
        public Cache<K, V> delegate() {
            return this.delegate;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public enum NullEntry implements ReferenceEntry<Object, Object> {
        INSTANCE;

        @Override // com.google.common.cache.ReferenceEntry
        public long getAccessTime() {
            return 0L;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public int getHash() {
            return 0;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public Object getKey() {
            return null;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<Object, Object> getNext() {
            return null;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<Object, Object> getNextInAccessQueue() {
            return this;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<Object, Object> getNextInWriteQueue() {
            return this;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<Object, Object> getPreviousInAccessQueue() {
            return this;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<Object, Object> getPreviousInWriteQueue() {
            return this;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ValueReference<Object, Object> getValueReference() {
            return null;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public long getWriteTime() {
            return 0L;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setAccessTime(long j) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setNextInAccessQueue(ReferenceEntry<Object, Object> referenceEntry) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setNextInWriteQueue(ReferenceEntry<Object, Object> referenceEntry) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setPreviousInAccessQueue(ReferenceEntry<Object, Object> referenceEntry) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setPreviousInWriteQueue(ReferenceEntry<Object, Object> referenceEntry) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setValueReference(ValueReference<Object, Object> valueReference) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setWriteTime(long j) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public enum Strength {
        STRONG { // from class: com.google.common.cache.LocalCache.Strength.1
            @Override // com.google.common.cache.LocalCache.Strength
            Equivalence<Object> defaultEquivalence() {
                return Equivalence.equals();
            }

            @Override // com.google.common.cache.LocalCache.Strength
            <K, V> ValueReference<Object, Object> referenceValue(Segment<Object, Object> segment, ReferenceEntry<Object, Object> referenceEntry, Object obj, int i) {
                return i == 1 ? new p(obj) : new z(obj, i);
            }
        },
        SOFT { // from class: com.google.common.cache.LocalCache.Strength.2
            @Override // com.google.common.cache.LocalCache.Strength
            Equivalence<Object> defaultEquivalence() {
                return Equivalence.identity();
            }

            @Override // com.google.common.cache.LocalCache.Strength
            <K, V> ValueReference<Object, Object> referenceValue(Segment<Object, Object> segment, ReferenceEntry<Object, Object> referenceEntry, Object obj, int i) {
                return i == 1 ? new l(segment.valueReferenceQueue, obj, referenceEntry) : new y(segment.valueReferenceQueue, obj, referenceEntry, i);
            }
        },
        WEAK { // from class: com.google.common.cache.LocalCache.Strength.3
            @Override // com.google.common.cache.LocalCache.Strength
            Equivalence<Object> defaultEquivalence() {
                return Equivalence.identity();
            }

            @Override // com.google.common.cache.LocalCache.Strength
            <K, V> ValueReference<Object, Object> referenceValue(Segment<Object, Object> segment, ReferenceEntry<Object, Object> referenceEntry, Object obj, int i) {
                return i == 1 ? new w(segment.valueReferenceQueue, obj, referenceEntry) : new a0(segment.valueReferenceQueue, obj, referenceEntry, i);
            }
        };

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract Equivalence<Object> defaultEquivalence();

        abstract <K, V> ValueReference<K, V> referenceValue(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, V v, int i);

        /* synthetic */ Strength(a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface ValueReference<K, V> {
        ValueReference<K, V> copyFor(ReferenceQueue<V> referenceQueue, @NullableDecl V v, ReferenceEntry<K, V> referenceEntry);

        @NullableDecl
        V get();

        @NullableDecl
        ReferenceEntry<K, V> getEntry();

        int getWeight();

        boolean isActive();

        boolean isLoading();

        void notifyNewValue(@NullableDecl V v);

        V waitForValue() throws ExecutionException;
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class a implements ValueReference<Object, Object> {
        a() {
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ValueReference<Object, Object> copyFor(ReferenceQueue<Object> referenceQueue, @NullableDecl Object obj, ReferenceEntry<Object, Object> referenceEntry) {
            return this;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public Object get() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ReferenceEntry<Object, Object> getEntry() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public int getWeight() {
            return 0;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isActive() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isLoading() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public void notifyNewValue(Object obj) {
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public Object waitForValue() {
            return null;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static final class a0<K, V> extends w<K, V> {
        final int b;

        a0(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry, int i) {
            super(referenceQueue, v, referenceEntry);
            this.b = i;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.LocalCache.ValueReference
        public ValueReference<K, V> copyFor(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            return new a0(referenceQueue, v, referenceEntry, this.b);
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.LocalCache.ValueReference
        public int getWeight() {
            return this.b;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class b extends AbstractQueue<Object> {
        b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<Object> iterator() {
            return ImmutableSet.of().iterator();
        }

        @Override // java.util.Queue
        public boolean offer(Object obj) {
            return true;
        }

        @Override // java.util.Queue
        public Object peek() {
            return null;
        }

        @Override // java.util.Queue
        public Object poll() {
            return null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static final class b0<K, V> extends AbstractQueue<ReferenceEntry<K, V>> {
        final ReferenceEntry<K, V> a = new a(this);

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        class a extends d<Object, Object> {
            ReferenceEntry<Object, Object> a = this;
            ReferenceEntry<Object, Object> b = this;

            a(b0 b0Var) {
            }

            @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.ReferenceEntry
            public ReferenceEntry<Object, Object> getNextInWriteQueue() {
                return this.a;
            }

            @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.ReferenceEntry
            public ReferenceEntry<Object, Object> getPreviousInWriteQueue() {
                return this.b;
            }

            @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.ReferenceEntry
            public long getWriteTime() {
                return AbsPerformance.LONG_NIL;
            }

            @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.ReferenceEntry
            public void setNextInWriteQueue(ReferenceEntry<Object, Object> referenceEntry) {
                this.a = referenceEntry;
            }

            @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.ReferenceEntry
            public void setPreviousInWriteQueue(ReferenceEntry<Object, Object> referenceEntry) {
                this.b = referenceEntry;
            }

            @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.ReferenceEntry
            public void setWriteTime(long j) {
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        class b extends g2<ReferenceEntry<K, V>> {
            b(ReferenceEntry referenceEntry) {
                super(referenceEntry);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // tb.g2
            /* renamed from: b */
            public ReferenceEntry<K, V> a(ReferenceEntry<K, V> referenceEntry) {
                ReferenceEntry<K, V> nextInWriteQueue = referenceEntry.getNextInWriteQueue();
                if (nextInWriteQueue == b0.this.a) {
                    return null;
                }
                return nextInWriteQueue;
            }
        }

        b0() {
        }

        @Override // java.util.Queue
        /* renamed from: a */
        public boolean offer(ReferenceEntry<K, V> referenceEntry) {
            LocalCache.d(referenceEntry.getPreviousInWriteQueue(), referenceEntry.getNextInWriteQueue());
            LocalCache.d(this.a.getPreviousInWriteQueue(), referenceEntry);
            LocalCache.d(referenceEntry, this.a);
            return true;
        }

        @Override // java.util.Queue
        /* renamed from: b */
        public ReferenceEntry<K, V> peek() {
            ReferenceEntry<K, V> nextInWriteQueue = this.a.getNextInWriteQueue();
            if (nextInWriteQueue == this.a) {
                return null;
            }
            return nextInWriteQueue;
        }

        @Override // java.util.Queue
        /* renamed from: c */
        public ReferenceEntry<K, V> poll() {
            ReferenceEntry<K, V> nextInWriteQueue = this.a.getNextInWriteQueue();
            if (nextInWriteQueue == this.a) {
                return null;
            }
            remove(nextInWriteQueue);
            return nextInWriteQueue;
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            ReferenceEntry<K, V> nextInWriteQueue = this.a.getNextInWriteQueue();
            while (true) {
                ReferenceEntry<K, V> referenceEntry = this.a;
                if (nextInWriteQueue != referenceEntry) {
                    ReferenceEntry<K, V> nextInWriteQueue2 = nextInWriteQueue.getNextInWriteQueue();
                    LocalCache.y(nextInWriteQueue);
                    nextInWriteQueue = nextInWriteQueue2;
                } else {
                    referenceEntry.setNextInWriteQueue(referenceEntry);
                    ReferenceEntry<K, V> referenceEntry2 = this.a;
                    referenceEntry2.setPreviousInWriteQueue(referenceEntry2);
                    return;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return ((ReferenceEntry) obj).getNextInWriteQueue() != NullEntry.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.a.getNextInWriteQueue() == this.a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<ReferenceEntry<K, V>> iterator() {
            return new b(peek());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            ReferenceEntry referenceEntry = (ReferenceEntry) obj;
            ReferenceEntry<K, V> previousInWriteQueue = referenceEntry.getPreviousInWriteQueue();
            ReferenceEntry<K, V> nextInWriteQueue = referenceEntry.getNextInWriteQueue();
            LocalCache.d(previousInWriteQueue, nextInWriteQueue);
            LocalCache.y(referenceEntry);
            return nextInWriteQueue != NullEntry.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            int i = 0;
            for (ReferenceEntry<K, V> nextInWriteQueue = this.a.getNextInWriteQueue(); nextInWriteQueue != this.a; nextInWriteQueue = nextInWriteQueue.getNextInWriteQueue()) {
                i++;
            }
            return i;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    abstract class c<T> extends AbstractSet<T> {
        @Weak
        final ConcurrentMap<?, ?> a;

        c(LocalCache localCache, ConcurrentMap<?, ?> concurrentMap) {
            this.a = concurrentMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.a.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.a.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return LocalCache.J(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <E> E[] toArray(E[] eArr) {
            return (E[]) LocalCache.J(this).toArray(eArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public final class c0 implements Map.Entry<K, V> {
        final K a;
        V b;

        c0(K k, V v) {
            this.a = k;
            this.b = v;
        }

        @Override // java.util.Map.Entry
        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                return this.a.equals(entry.getKey()) && this.b.equals(entry.getValue());
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.a;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.a.hashCode() ^ this.b.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = (V) LocalCache.this.put(this.a, v);
            this.b = v;
            return v2;
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static abstract class d<K, V> implements ReferenceEntry<K, V> {
        d() {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public long getAccessTime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public int getHash() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public K getKey() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNext() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ValueReference<K, V> getValueReference() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public long getWriteTime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setAccessTime(long j) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setValueReference(ValueReference<K, V> valueReference) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setWriteTime(long j) {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static final class e<K, V> extends AbstractQueue<ReferenceEntry<K, V>> {
        final ReferenceEntry<K, V> a = new a(this);

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        class a extends d<Object, Object> {
            ReferenceEntry<Object, Object> a = this;
            ReferenceEntry<Object, Object> b = this;

            a(e eVar) {
            }

            @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.ReferenceEntry
            public long getAccessTime() {
                return AbsPerformance.LONG_NIL;
            }

            @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.ReferenceEntry
            public ReferenceEntry<Object, Object> getNextInAccessQueue() {
                return this.a;
            }

            @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.ReferenceEntry
            public ReferenceEntry<Object, Object> getPreviousInAccessQueue() {
                return this.b;
            }

            @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.ReferenceEntry
            public void setAccessTime(long j) {
            }

            @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.ReferenceEntry
            public void setNextInAccessQueue(ReferenceEntry<Object, Object> referenceEntry) {
                this.a = referenceEntry;
            }

            @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.ReferenceEntry
            public void setPreviousInAccessQueue(ReferenceEntry<Object, Object> referenceEntry) {
                this.b = referenceEntry;
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        class b extends g2<ReferenceEntry<K, V>> {
            b(ReferenceEntry referenceEntry) {
                super(referenceEntry);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // tb.g2
            /* renamed from: b */
            public ReferenceEntry<K, V> a(ReferenceEntry<K, V> referenceEntry) {
                ReferenceEntry<K, V> nextInAccessQueue = referenceEntry.getNextInAccessQueue();
                if (nextInAccessQueue == e.this.a) {
                    return null;
                }
                return nextInAccessQueue;
            }
        }

        e() {
        }

        @Override // java.util.Queue
        /* renamed from: a */
        public boolean offer(ReferenceEntry<K, V> referenceEntry) {
            LocalCache.c(referenceEntry.getPreviousInAccessQueue(), referenceEntry.getNextInAccessQueue());
            LocalCache.c(this.a.getPreviousInAccessQueue(), referenceEntry);
            LocalCache.c(referenceEntry, this.a);
            return true;
        }

        @Override // java.util.Queue
        /* renamed from: b */
        public ReferenceEntry<K, V> peek() {
            ReferenceEntry<K, V> nextInAccessQueue = this.a.getNextInAccessQueue();
            if (nextInAccessQueue == this.a) {
                return null;
            }
            return nextInAccessQueue;
        }

        @Override // java.util.Queue
        /* renamed from: c */
        public ReferenceEntry<K, V> poll() {
            ReferenceEntry<K, V> nextInAccessQueue = this.a.getNextInAccessQueue();
            if (nextInAccessQueue == this.a) {
                return null;
            }
            remove(nextInAccessQueue);
            return nextInAccessQueue;
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            ReferenceEntry<K, V> nextInAccessQueue = this.a.getNextInAccessQueue();
            while (true) {
                ReferenceEntry<K, V> referenceEntry = this.a;
                if (nextInAccessQueue != referenceEntry) {
                    ReferenceEntry<K, V> nextInAccessQueue2 = nextInAccessQueue.getNextInAccessQueue();
                    LocalCache.x(nextInAccessQueue);
                    nextInAccessQueue = nextInAccessQueue2;
                } else {
                    referenceEntry.setNextInAccessQueue(referenceEntry);
                    ReferenceEntry<K, V> referenceEntry2 = this.a;
                    referenceEntry2.setPreviousInAccessQueue(referenceEntry2);
                    return;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return ((ReferenceEntry) obj).getNextInAccessQueue() != NullEntry.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.a.getNextInAccessQueue() == this.a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<ReferenceEntry<K, V>> iterator() {
            return new b(peek());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            ReferenceEntry referenceEntry = (ReferenceEntry) obj;
            ReferenceEntry<K, V> previousInAccessQueue = referenceEntry.getPreviousInAccessQueue();
            ReferenceEntry<K, V> nextInAccessQueue = referenceEntry.getNextInAccessQueue();
            LocalCache.c(previousInAccessQueue, nextInAccessQueue);
            LocalCache.x(referenceEntry);
            return nextInAccessQueue != NullEntry.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            int i = 0;
            for (ReferenceEntry<K, V> nextInAccessQueue = this.a.getNextInAccessQueue(); nextInAccessQueue != this.a; nextInAccessQueue = nextInAccessQueue.getNextInAccessQueue()) {
                i++;
            }
            return i;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    final class f extends LocalCache<K, V>.h<Map.Entry<K, V>> {
        f(LocalCache localCache) {
            super();
        }

        @Override // java.util.Iterator
        /* renamed from: f */
        public Map.Entry<K, V> next() {
            return c();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    final class g extends LocalCache<K, V>.c<Map.Entry<K, V>> {
        g(ConcurrentMap<?, ?> concurrentMap) {
            super(LocalCache.this, concurrentMap);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry;
            Object key;
            Object obj2;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (obj2 = LocalCache.this.get(key)) != null && LocalCache.this.f.equivalent(entry.getValue(), obj2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new f(LocalCache.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry;
            Object key;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && LocalCache.this.remove(key, entry.getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public abstract class h<T> implements Iterator<T> {
        int a;
        int b = -1;
        @MonotonicNonNullDecl
        Segment<K, V> c;
        @MonotonicNonNullDecl
        AtomicReferenceArray<ReferenceEntry<K, V>> d;
        @NullableDecl
        ReferenceEntry<K, V> e;
        @NullableDecl
        LocalCache<K, V>.c0 f;
        @NullableDecl
        LocalCache<K, V>.c0 g;

        h() {
            this.a = LocalCache.this.c.length - 1;
            a();
        }

        final void a() {
            this.f = null;
            if (d() || e()) {
                return;
            }
            while (true) {
                int i = this.a;
                if (i < 0) {
                    return;
                }
                Segment<K, V>[] segmentArr = LocalCache.this.c;
                this.a = i - 1;
                Segment<K, V> segment = segmentArr[i];
                this.c = segment;
                if (segment.count != 0) {
                    AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.c.table;
                    this.d = atomicReferenceArray;
                    this.b = atomicReferenceArray.length() - 1;
                    if (e()) {
                        return;
                    }
                }
            }
        }

        boolean b(ReferenceEntry<K, V> referenceEntry) {
            boolean z;
            try {
                long a = LocalCache.this.p.a();
                K key = referenceEntry.getKey();
                Object o = LocalCache.this.o(referenceEntry, a);
                if (o != null) {
                    this.f = new c0(key, o);
                    z = true;
                } else {
                    z = false;
                }
                return z;
            } finally {
                this.c.postReadCleanup();
            }
        }

        LocalCache<K, V>.c0 c() {
            LocalCache<K, V>.c0 c0Var = this.f;
            if (c0Var != null) {
                this.g = c0Var;
                a();
                return this.g;
            }
            throw new NoSuchElementException();
        }

        boolean d() {
            ReferenceEntry<K, V> referenceEntry = this.e;
            if (referenceEntry == null) {
                return false;
            }
            while (true) {
                this.e = referenceEntry.getNext();
                ReferenceEntry<K, V> referenceEntry2 = this.e;
                if (referenceEntry2 == null) {
                    return false;
                }
                if (b(referenceEntry2)) {
                    return true;
                }
                referenceEntry = this.e;
            }
        }

        boolean e() {
            while (true) {
                int i = this.b;
                if (i < 0) {
                    return false;
                }
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.d;
                this.b = i - 1;
                ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(i);
                this.e = referenceEntry;
                if (referenceEntry != null && (b(referenceEntry) || d())) {
                    return true;
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            du1.w(this.g != null);
            LocalCache.this.remove(this.g.getKey());
            this.g = null;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    final class i extends LocalCache<K, V>.h<K> {
        i(LocalCache localCache) {
            super();
        }

        @Override // java.util.Iterator
        public K next() {
            return c().getKey();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    final class j extends LocalCache<K, V>.c<K> {
        j(ConcurrentMap<?, ?> concurrentMap) {
            super(LocalCache.this, concurrentMap);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.a.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new i(LocalCache.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return this.a.remove(obj) != null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class k<K, V> implements ValueReference<K, V> {
        volatile ValueReference<K, V> a;
        final com.google.common.util.concurrent.p<V> b;
        final com.google.common.base.g c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public class a implements Function<V, V> {
            a() {
            }

            @Override // com.google.common.base.Function
            public V apply(V v) {
                k.this.e(v);
                return v;
            }
        }

        public k() {
            this(LocalCache.K());
        }

        private ListenableFuture<V> b(Throwable th) {
            return Futures.e(th);
        }

        public long a() {
            return this.c.e(TimeUnit.NANOSECONDS);
        }

        public ValueReference<K, V> c() {
            return this.a;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ValueReference<K, V> copyFor(ReferenceQueue<V> referenceQueue, @NullableDecl V v, ReferenceEntry<K, V> referenceEntry) {
            return this;
        }

        public ListenableFuture<V> d(K k, CacheLoader<? super K, V> cacheLoader) {
            try {
                this.c.g();
                V v = this.a.get();
                if (v == null) {
                    V load = cacheLoader.load(k);
                    return e(load) ? this.b : Futures.f(load);
                }
                ListenableFuture<V> reload = cacheLoader.reload(k, v);
                if (reload == null) {
                    return Futures.f(null);
                }
                return Futures.g(reload, new a(), MoreExecutors.a());
            } catch (Throwable th) {
                ListenableFuture<V> b = f(th) ? this.b : b(th);
                if (th instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                }
                return b;
            }
        }

        public boolean e(@NullableDecl V v) {
            return this.b.set(v);
        }

        public boolean f(Throwable th) {
            return this.b.setException(th);
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public V get() {
            return this.a.get();
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ReferenceEntry<K, V> getEntry() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public int getWeight() {
            return this.a.getWeight();
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isActive() {
            return this.a.isActive();
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isLoading() {
            return true;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public void notifyNewValue(@NullableDecl V v) {
            if (v != null) {
                e(v);
            } else {
                this.a = LocalCache.K();
            }
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public V waitForValue() throws ExecutionException {
            return (V) com.google.common.util.concurrent.q.a(this.b);
        }

        public k(ValueReference<K, V> valueReference) {
            this.b = com.google.common.util.concurrent.p.a();
            this.c = com.google.common.base.g.d();
            this.a = valueReference;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class l<K, V> extends SoftReference<V> implements ValueReference<K, V> {
        final ReferenceEntry<K, V> a;

        l(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            super(v, referenceQueue);
            this.a = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ValueReference<K, V> copyFor(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            return new l(referenceQueue, v, referenceEntry);
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ReferenceEntry<K, V> getEntry() {
            return this.a;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public int getWeight() {
            return 1;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isActive() {
            return true;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isLoading() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public void notifyNewValue(V v) {
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public V waitForValue() {
            return get();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static final class m<K, V> extends o<K, V> {
        volatile long e;
        ReferenceEntry<K, V> f;
        ReferenceEntry<K, V> g;

        m(K k, int i, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
            super(k, i, referenceEntry);
            this.e = AbsPerformance.LONG_NIL;
            this.f = LocalCache.w();
            this.g = LocalCache.w();
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.ReferenceEntry
        public long getAccessTime() {
            return this.e;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInAccessQueue() {
            return this.f;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            return this.g;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.ReferenceEntry
        public void setAccessTime(long j) {
            this.e = j;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.ReferenceEntry
        public void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.f = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.ReferenceEntry
        public void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.g = referenceEntry;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static final class n<K, V> extends o<K, V> {
        volatile long e;
        ReferenceEntry<K, V> f;
        ReferenceEntry<K, V> g;
        volatile long h;
        ReferenceEntry<K, V> i;
        ReferenceEntry<K, V> j;

        n(K k, int i, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
            super(k, i, referenceEntry);
            this.e = AbsPerformance.LONG_NIL;
            this.f = LocalCache.w();
            this.g = LocalCache.w();
            this.h = AbsPerformance.LONG_NIL;
            this.i = LocalCache.w();
            this.j = LocalCache.w();
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.ReferenceEntry
        public long getAccessTime() {
            return this.e;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInAccessQueue() {
            return this.f;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInWriteQueue() {
            return this.i;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            return this.g;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            return this.j;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.ReferenceEntry
        public long getWriteTime() {
            return this.h;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.ReferenceEntry
        public void setAccessTime(long j) {
            this.e = j;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.ReferenceEntry
        public void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.f = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.ReferenceEntry
        public void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.i = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.ReferenceEntry
        public void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.g = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.ReferenceEntry
        public void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.j = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.ReferenceEntry
        public void setWriteTime(long j) {
            this.h = j;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class o<K, V> extends d<K, V> {
        final K a;
        final int b;
        @NullableDecl
        final ReferenceEntry<K, V> c;
        volatile ValueReference<K, V> d = LocalCache.K();

        o(K k, int i, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
            this.a = k;
            this.b = i;
            this.c = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.ReferenceEntry
        public int getHash() {
            return this.b;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.ReferenceEntry
        public K getKey() {
            return this.a;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNext() {
            return this.c;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.ReferenceEntry
        public ValueReference<K, V> getValueReference() {
            return this.d;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.ReferenceEntry
        public void setValueReference(ValueReference<K, V> valueReference) {
            this.d = valueReference;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class p<K, V> implements ValueReference<K, V> {
        final V a;

        p(V v) {
            this.a = v;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ValueReference<K, V> copyFor(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            return this;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public V get() {
            return this.a;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ReferenceEntry<K, V> getEntry() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public int getWeight() {
            return 1;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isActive() {
            return true;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isLoading() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public void notifyNewValue(V v) {
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public V waitForValue() {
            return get();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static final class q<K, V> extends o<K, V> {
        volatile long e;
        ReferenceEntry<K, V> f;
        ReferenceEntry<K, V> g;

        q(K k, int i, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
            super(k, i, referenceEntry);
            this.e = AbsPerformance.LONG_NIL;
            this.f = LocalCache.w();
            this.g = LocalCache.w();
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInWriteQueue() {
            return this.f;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            return this.g;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.ReferenceEntry
        public long getWriteTime() {
            return this.e;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.ReferenceEntry
        public void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.f = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.ReferenceEntry
        public void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.g = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.ReferenceEntry
        public void setWriteTime(long j) {
            this.e = j;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    final class r extends LocalCache<K, V>.h<V> {
        r(LocalCache localCache) {
            super();
        }

        @Override // java.util.Iterator
        public V next() {
            return c().getValue();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    final class s extends AbstractCollection<V> {
        private final ConcurrentMap<?, ?> a;

        s(ConcurrentMap<?, ?> concurrentMap) {
            this.a = concurrentMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return this.a.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.a.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new r(LocalCache.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.a.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return LocalCache.J(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <E> E[] toArray(E[] eArr) {
            return (E[]) LocalCache.J(this).toArray(eArr);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static final class t<K, V> extends v<K, V> {
        volatile long d;
        ReferenceEntry<K, V> e;
        ReferenceEntry<K, V> f;

        t(ReferenceQueue<K> referenceQueue, K k, int i, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
            super(referenceQueue, k, i, referenceEntry);
            this.d = AbsPerformance.LONG_NIL;
            this.e = LocalCache.w();
            this.f = LocalCache.w();
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.ReferenceEntry
        public long getAccessTime() {
            return this.d;
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInAccessQueue() {
            return this.e;
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            return this.f;
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.ReferenceEntry
        public void setAccessTime(long j) {
            this.d = j;
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.ReferenceEntry
        public void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.e = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.ReferenceEntry
        public void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.f = referenceEntry;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static final class u<K, V> extends v<K, V> {
        volatile long d;
        ReferenceEntry<K, V> e;
        ReferenceEntry<K, V> f;
        volatile long g;
        ReferenceEntry<K, V> h;
        ReferenceEntry<K, V> i;

        u(ReferenceQueue<K> referenceQueue, K k, int i, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
            super(referenceQueue, k, i, referenceEntry);
            this.d = AbsPerformance.LONG_NIL;
            this.e = LocalCache.w();
            this.f = LocalCache.w();
            this.g = AbsPerformance.LONG_NIL;
            this.h = LocalCache.w();
            this.i = LocalCache.w();
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.ReferenceEntry
        public long getAccessTime() {
            return this.d;
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInAccessQueue() {
            return this.e;
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInWriteQueue() {
            return this.h;
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            return this.f;
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            return this.i;
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.ReferenceEntry
        public long getWriteTime() {
            return this.g;
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.ReferenceEntry
        public void setAccessTime(long j) {
            this.d = j;
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.ReferenceEntry
        public void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.e = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.ReferenceEntry
        public void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.h = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.ReferenceEntry
        public void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.f = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.ReferenceEntry
        public void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.i = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.ReferenceEntry
        public void setWriteTime(long j) {
            this.g = j;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class v<K, V> extends WeakReference<K> implements ReferenceEntry<K, V> {
        final int a;
        @NullableDecl
        final ReferenceEntry<K, V> b;
        volatile ValueReference<K, V> c;

        v(ReferenceQueue<K> referenceQueue, K k, int i, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
            super(k, referenceQueue);
            this.c = LocalCache.K();
            this.a = i;
            this.b = referenceEntry;
        }

        public long getAccessTime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public int getHash() {
            return this.a;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public K getKey() {
            return get();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNext() {
            return this.b;
        }

        public ReferenceEntry<K, V> getNextInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getNextInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ValueReference<K, V> getValueReference() {
            return this.c;
        }

        public long getWriteTime() {
            throw new UnsupportedOperationException();
        }

        public void setAccessTime(long j) {
            throw new UnsupportedOperationException();
        }

        public void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setValueReference(ValueReference<K, V> valueReference) {
            this.c = valueReference;
        }

        public void setWriteTime(long j) {
            throw new UnsupportedOperationException();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class w<K, V> extends WeakReference<V> implements ValueReference<K, V> {
        final ReferenceEntry<K, V> a;

        w(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            super(v, referenceQueue);
            this.a = referenceEntry;
        }

        public ValueReference<K, V> copyFor(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            return new w(referenceQueue, v, referenceEntry);
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ReferenceEntry<K, V> getEntry() {
            return this.a;
        }

        public int getWeight() {
            return 1;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isActive() {
            return true;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isLoading() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public void notifyNewValue(V v) {
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public V waitForValue() {
            return get();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static final class x<K, V> extends v<K, V> {
        volatile long d;
        ReferenceEntry<K, V> e;
        ReferenceEntry<K, V> f;

        x(ReferenceQueue<K> referenceQueue, K k, int i, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
            super(referenceQueue, k, i, referenceEntry);
            this.d = AbsPerformance.LONG_NIL;
            this.e = LocalCache.w();
            this.f = LocalCache.w();
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInWriteQueue() {
            return this.e;
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            return this.f;
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.ReferenceEntry
        public long getWriteTime() {
            return this.d;
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.ReferenceEntry
        public void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.e = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.ReferenceEntry
        public void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.f = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.ReferenceEntry
        public void setWriteTime(long j) {
            this.d = j;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static final class y<K, V> extends l<K, V> {
        final int b;

        y(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry, int i) {
            super(referenceQueue, v, referenceEntry);
            this.b = i;
        }

        @Override // com.google.common.cache.LocalCache.l, com.google.common.cache.LocalCache.ValueReference
        public ValueReference<K, V> copyFor(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            return new y(referenceQueue, v, referenceEntry, this.b);
        }

        @Override // com.google.common.cache.LocalCache.l, com.google.common.cache.LocalCache.ValueReference
        public int getWeight() {
            return this.b;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static final class z<K, V> extends p<K, V> {
        final int b;

        z(V v, int i) {
            super(v);
            this.b = i;
        }

        @Override // com.google.common.cache.LocalCache.p, com.google.common.cache.LocalCache.ValueReference
        public int getWeight() {
            return this.b;
        }
    }

    LocalCache(CacheBuilder<? super K, ? super V> cacheBuilder, @NullableDecl CacheLoader<? super K, V> cacheLoader) {
        this.d = Math.min(cacheBuilder.h(), 65536);
        Strength m2 = cacheBuilder.m();
        this.g = m2;
        this.h = cacheBuilder.t();
        this.e = cacheBuilder.l();
        this.f = cacheBuilder.s();
        long n2 = cacheBuilder.n();
        this.i = n2;
        this.j = (Weigher<K, V>) cacheBuilder.u();
        this.k = cacheBuilder.i();
        this.l = cacheBuilder.j();
        this.m = cacheBuilder.o();
        RemovalListener<K, V> removalListener = (RemovalListener<K, V>) cacheBuilder.p();
        this.o = removalListener;
        this.n = removalListener == CacheBuilder.NullListener.INSTANCE ? g() : new ConcurrentLinkedQueue<>();
        this.p = cacheBuilder.r(D());
        this.q = EntryFactory.getFactory(m2, L(), P());
        this.r = cacheBuilder.q().get();
        this.s = cacheLoader;
        int min = Math.min(cacheBuilder.k(), 1073741824);
        if (h() && !f()) {
            min = (int) Math.min(min, n2);
        }
        int i2 = 0;
        int i3 = 1;
        int i4 = 1;
        int i5 = 0;
        while (i4 < this.d && (!h() || i4 * 20 <= this.i)) {
            i5++;
            i4 <<= 1;
        }
        this.b = 32 - i5;
        this.a = i4 - 1;
        this.c = v(i4);
        int i6 = min / i4;
        while (i3 < (i6 * i4 < min ? i6 + 1 : i6)) {
            i3 <<= 1;
        }
        if (h()) {
            long j2 = this.i;
            long j3 = i4;
            long j4 = (j2 / j3) + 1;
            long j5 = j2 % j3;
            while (true) {
                Segment<K, V>[] segmentArr = this.c;
                if (i2 >= segmentArr.length) {
                    return;
                }
                if (i2 == j5) {
                    j4--;
                }
                segmentArr[i2] = e(i3, j4, cacheBuilder.q().get());
                i2++;
            }
        } else {
            while (true) {
                Segment<K, V>[] segmentArr2 = this.c;
                if (i2 >= segmentArr2.length) {
                    return;
                }
                segmentArr2[i2] = e(i3, -1L, cacheBuilder.q().get());
                i2++;
            }
        }
    }

    static int H(int i2) {
        int i3 = i2 + ((i2 << 15) ^ (-12931));
        int i4 = i3 ^ (i3 >>> 10);
        int i5 = i4 + (i4 << 3);
        int i6 = i5 ^ (i5 >>> 6);
        int i7 = i6 + (i6 << 2) + (i6 << 14);
        return i7 ^ (i7 >>> 16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> ArrayList<E> J(Collection<E> collection) {
        ArrayList<E> arrayList = new ArrayList<>(collection.size());
        Iterators.a(arrayList, collection.iterator());
        return arrayList;
    }

    static <K, V> ValueReference<K, V> K() {
        return (ValueReference<K, V>) x;
    }

    static <K, V> void c(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
        referenceEntry.setNextInAccessQueue(referenceEntry2);
        referenceEntry2.setPreviousInAccessQueue(referenceEntry);
    }

    static <K, V> void d(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
        referenceEntry.setNextInWriteQueue(referenceEntry2);
        referenceEntry2.setPreviousInWriteQueue(referenceEntry);
    }

    static <E> Queue<E> g() {
        return (Queue<E>) y;
    }

    static <K, V> ReferenceEntry<K, V> w() {
        return NullEntry.INSTANCE;
    }

    static <K, V> void x(ReferenceEntry<K, V> referenceEntry) {
        ReferenceEntry<K, V> w2 = w();
        referenceEntry.setNextInAccessQueue(w2);
        referenceEntry.setPreviousInAccessQueue(w2);
    }

    static <K, V> void y(ReferenceEntry<K, V> referenceEntry) {
        ReferenceEntry<K, V> w2 = w();
        referenceEntry.setNextInWriteQueue(w2);
        referenceEntry.setPreviousInWriteQueue(w2);
    }

    void A(ReferenceEntry<K, V> referenceEntry) {
        int hash = referenceEntry.getHash();
        I(hash).reclaimKey(referenceEntry, hash);
    }

    void B(ValueReference<K, V> valueReference) {
        ReferenceEntry<K, V> entry = valueReference.getEntry();
        int hash = entry.getHash();
        I(hash).reclaimValue(entry.getKey(), hash, valueReference);
    }

    boolean C() {
        return i();
    }

    boolean D() {
        return E() || C();
    }

    boolean E() {
        return j() || G();
    }

    void F(K k2) {
        int q2 = q(du1.p(k2));
        I(q2).refresh(k2, q2, this.s, false);
    }

    boolean G() {
        return this.m > 0;
    }

    Segment<K, V> I(int i2) {
        return this.c[(i2 >>> this.b) & this.a];
    }

    boolean L() {
        return M() || C();
    }

    boolean M() {
        return i() || h();
    }

    boolean N() {
        return this.g != Strength.STRONG;
    }

    boolean O() {
        return this.h != Strength.STRONG;
    }

    boolean P() {
        return Q() || E();
    }

    boolean Q() {
        return j();
    }

    public void b() {
        for (Segment<K, V> segment : this.c) {
            segment.cleanUp();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        for (Segment<K, V> segment : this.c) {
            segment.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@NullableDecl Object obj) {
        if (obj == null) {
            return false;
        }
        int q2 = q(obj);
        return I(q2).containsKey(obj, q2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@NullableDecl Object obj) {
        if (obj == null) {
            return false;
        }
        long a2 = this.p.a();
        Segment<K, V>[] segmentArr = this.c;
        long j2 = -1;
        int i2 = 0;
        while (i2 < 3) {
            long j3 = 0;
            int length = segmentArr.length;
            int i3 = 0;
            while (i3 < length) {
                Segment<K, V> segment = segmentArr[i3];
                int i4 = segment.count;
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = segment.table;
                for (int i5 = 0; i5 < atomicReferenceArray.length(); i5++) {
                    ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(i5);
                    while (referenceEntry != null) {
                        Segment<K, V>[] segmentArr2 = segmentArr;
                        V liveValue = segment.getLiveValue(referenceEntry, a2);
                        long j4 = a2;
                        if (liveValue != null && this.f.equivalent(obj, liveValue)) {
                            return true;
                        }
                        referenceEntry = referenceEntry.getNext();
                        segmentArr = segmentArr2;
                        a2 = j4;
                    }
                }
                j3 += segment.modCount;
                i3++;
                a2 = a2;
            }
            long j5 = a2;
            Segment<K, V>[] segmentArr3 = segmentArr;
            if (j3 == j2) {
                return false;
            }
            i2++;
            j2 = j3;
            segmentArr = segmentArr3;
            a2 = j5;
        }
        return false;
    }

    Segment<K, V> e(int i2, long j2, AbstractCache$StatsCounter abstractCache$StatsCounter) {
        return new Segment<>(this, i2, j2, abstractCache$StatsCounter);
    }

    @Override // java.util.AbstractMap, java.util.Map
    @GwtIncompatible
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.v;
        if (set != null) {
            return set;
        }
        g gVar = new g(this);
        this.v = gVar;
        return gVar;
    }

    boolean f() {
        return this.j != CacheBuilder.OneWeigher.INSTANCE;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @NullableDecl
    public V get(@NullableDecl Object obj) {
        if (obj == null) {
            return null;
        }
        int q2 = q(obj);
        return I(q2).get(obj, q2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @NullableDecl
    public V getOrDefault(@NullableDecl Object obj, @NullableDecl V v2) {
        V v3 = get(obj);
        return v3 != null ? v3 : v2;
    }

    boolean h() {
        return this.i >= 0;
    }

    boolean i() {
        return this.k > 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        Segment<K, V>[] segmentArr = this.c;
        long j2 = 0;
        for (int i2 = 0; i2 < segmentArr.length; i2++) {
            if (segmentArr[i2].count != 0) {
                return false;
            }
            j2 += segmentArr[i2].modCount;
        }
        if (j2 != 0) {
            for (int i3 = 0; i3 < segmentArr.length; i3++) {
                if (segmentArr[i3].count != 0) {
                    return false;
                }
                j2 -= segmentArr[i3].modCount;
            }
            return j2 == 0;
        }
        return true;
    }

    boolean j() {
        return this.l > 0;
    }

    V k(K k2, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
        int q2 = q(du1.p(k2));
        return I(q2).get(k2, q2, cacheLoader);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.t;
        if (set != null) {
            return set;
        }
        j jVar = new j(this);
        this.t = jVar;
        return jVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    ImmutableMap<K, V> l(Iterable<? extends K> iterable) throws ExecutionException {
        LinkedHashMap s2 = Maps.s();
        LinkedHashSet g2 = Sets.g();
        int i2 = 0;
        int i3 = 0;
        for (K k2 : iterable) {
            Object obj = get(k2);
            if (!s2.containsKey(k2)) {
                s2.put(k2, obj);
                if (obj == null) {
                    i3++;
                    g2.add(k2);
                } else {
                    i2++;
                }
            }
        }
        try {
            if (!g2.isEmpty()) {
                try {
                    Map t2 = t(g2, this.s);
                    for (Object obj2 : g2) {
                        Object obj3 = t2.get(obj2);
                        if (obj3 != null) {
                            s2.put(obj2, obj3);
                        } else {
                            throw new CacheLoader.InvalidCacheLoadException("loadAll failed to return a value for " + obj2);
                        }
                    }
                } catch (CacheLoader.UnsupportedLoadingOperationException unused) {
                    for (Object obj4 : g2) {
                        i3--;
                        s2.put(obj4, k(obj4, this.s));
                    }
                }
            }
            return ImmutableMap.copyOf((Map) s2);
        } finally {
            this.r.recordHits(i2);
            this.r.recordMisses(i3);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    ImmutableMap<K, V> m(Iterable<?> iterable) {
        LinkedHashMap s2 = Maps.s();
        int i2 = 0;
        int i3 = 0;
        for (Object obj : iterable) {
            V v2 = get(obj);
            if (v2 == null) {
                i3++;
            } else {
                s2.put(obj, v2);
                i2++;
            }
        }
        this.r.recordHits(i2);
        this.r.recordMisses(i3);
        return ImmutableMap.copyOf((Map) s2);
    }

    @NullableDecl
    public V n(Object obj) {
        int q2 = q(du1.p(obj));
        V v2 = I(q2).get(obj, q2);
        if (v2 == null) {
            this.r.recordMisses(1);
        } else {
            this.r.recordHits(1);
        }
        return v2;
    }

    @NullableDecl
    V o(ReferenceEntry<K, V> referenceEntry, long j2) {
        V v2;
        if (referenceEntry.getKey() == null || (v2 = referenceEntry.getValueReference().get()) == null || s(referenceEntry, j2)) {
            return null;
        }
        return v2;
    }

    V p(K k2) throws ExecutionException {
        return k(k2, this.s);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k2, V v2) {
        du1.p(k2);
        du1.p(v2);
        int q2 = q(k2);
        return I(q2).put(k2, q2, v2, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V putIfAbsent(K k2, V v2) {
        du1.p(k2);
        du1.p(v2);
        int q2 = q(k2);
        return I(q2).put(k2, q2, v2, true);
    }

    int q(@NullableDecl Object obj) {
        return H(this.e.hash(obj));
    }

    void r(Iterable<?> iterable) {
        Iterator<?> it = iterable.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(@NullableDecl Object obj) {
        if (obj == null) {
            return null;
        }
        int q2 = q(obj);
        return I(q2).remove(obj, q2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(K k2, @NullableDecl V v2, V v3) {
        du1.p(k2);
        du1.p(v3);
        if (v2 == null) {
            return false;
        }
        int q2 = q(k2);
        return I(q2).replace(k2, q2, v2, v3);
    }

    boolean s(ReferenceEntry<K, V> referenceEntry, long j2) {
        du1.p(referenceEntry);
        if (!i() || j2 - referenceEntry.getAccessTime() < this.k) {
            return j() && j2 - referenceEntry.getWriteTime() >= this.l;
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return Ints.j(u());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b9  */
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    java.util.Map<K, V> t(java.util.Set<? extends K> r7, com.google.common.cache.CacheLoader<? super K, V> r8) throws java.util.concurrent.ExecutionException {
        /*
            r6 = this;
            tb.du1.p(r8)
            tb.du1.p(r7)
            com.google.common.base.g r0 = com.google.common.base.g.c()
            r1 = 1
            r2 = 0
            java.util.Map r7 = r8.loadAll(r7)     // Catch: java.lang.Throwable -> L8e java.lang.Error -> L91 java.lang.Exception -> L98 java.lang.RuntimeException -> L9f java.lang.InterruptedException -> La6 com.google.common.cache.CacheLoader.UnsupportedLoadingOperationException -> Lb4
            if (r7 == 0) goto L6c
            r0.h()
            java.util.Set r3 = r7.entrySet()
            java.util.Iterator r3 = r3.iterator()
        L1d:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L3c
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r5 = r4.getKey()
            java.lang.Object r4 = r4.getValue()
            if (r5 == 0) goto L3a
            if (r4 != 0) goto L36
            goto L3a
        L36:
            r6.put(r5, r4)
            goto L1d
        L3a:
            r2 = 1
            goto L1d
        L3c:
            if (r2 != 0) goto L4a
            com.google.common.cache.AbstractCache$StatsCounter r8 = r6.r
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r0 = r0.e(r1)
            r8.recordLoadSuccess(r0)
            return r7
        L4a:
            com.google.common.cache.AbstractCache$StatsCounter r7 = r6.r
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r0 = r0.e(r1)
            r7.recordLoadException(r0)
            com.google.common.cache.CacheLoader$InvalidCacheLoadException r7 = new com.google.common.cache.CacheLoader$InvalidCacheLoadException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r8)
            java.lang.String r8 = " returned null keys or values from loadAll"
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            r7.<init>(r8)
            throw r7
        L6c:
            com.google.common.cache.AbstractCache$StatsCounter r7 = r6.r
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r0 = r0.e(r1)
            r7.recordLoadException(r0)
            com.google.common.cache.CacheLoader$InvalidCacheLoadException r7 = new com.google.common.cache.CacheLoader$InvalidCacheLoadException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r8)
            java.lang.String r8 = " returned null map from loadAll"
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            r7.<init>(r8)
            throw r7
        L8e:
            r7 = move-exception
            r1 = 0
            goto Lb7
        L91:
            r7 = move-exception
            com.google.common.util.concurrent.ExecutionError r8 = new com.google.common.util.concurrent.ExecutionError     // Catch: java.lang.Throwable -> L8e
            r8.<init>(r7)     // Catch: java.lang.Throwable -> L8e
            throw r8     // Catch: java.lang.Throwable -> L8e
        L98:
            r7 = move-exception
            java.util.concurrent.ExecutionException r8 = new java.util.concurrent.ExecutionException     // Catch: java.lang.Throwable -> L8e
            r8.<init>(r7)     // Catch: java.lang.Throwable -> L8e
            throw r8     // Catch: java.lang.Throwable -> L8e
        L9f:
            r7 = move-exception
            com.google.common.util.concurrent.UncheckedExecutionException r8 = new com.google.common.util.concurrent.UncheckedExecutionException     // Catch: java.lang.Throwable -> L8e
            r8.<init>(r7)     // Catch: java.lang.Throwable -> L8e
            throw r8     // Catch: java.lang.Throwable -> L8e
        La6:
            r7 = move-exception
            java.lang.Thread r8 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L8e
            r8.interrupt()     // Catch: java.lang.Throwable -> L8e
            java.util.concurrent.ExecutionException r8 = new java.util.concurrent.ExecutionException     // Catch: java.lang.Throwable -> L8e
            r8.<init>(r7)     // Catch: java.lang.Throwable -> L8e
            throw r8     // Catch: java.lang.Throwable -> L8e
        Lb4:
            r7 = move-exception
            throw r7     // Catch: java.lang.Throwable -> Lb6
        Lb6:
            r7 = move-exception
        Lb7:
            if (r1 != 0) goto Lc4
            com.google.common.cache.AbstractCache$StatsCounter r8 = r6.r
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r0 = r0.e(r1)
            r8.recordLoadException(r0)
        Lc4:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.t(java.util.Set, com.google.common.cache.CacheLoader):java.util.Map");
    }

    long u() {
        long j2 = 0;
        for (Segment<K, V> segment : this.c) {
            j2 += Math.max(0, segment.count);
        }
        return j2;
    }

    final Segment<K, V>[] v(int i2) {
        return new Segment[i2];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.u;
        if (collection != null) {
            return collection;
        }
        s sVar = new s(this);
        this.u = sVar;
        return sVar;
    }

    void z() {
        while (true) {
            RemovalNotification<K, V> poll = this.n.poll();
            if (poll == null) {
                return;
            }
            try {
                this.o.onRemoval(poll);
            } catch (Throwable th) {
                w.log(Level.WARNING, "Exception thrown by removal listener", th);
            }
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean remove(@NullableDecl Object obj, @NullableDecl Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        int q2 = q(obj);
        return I(q2).remove(obj, q2, obj2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V replace(K k2, V v2) {
        du1.p(k2);
        du1.p(v2);
        int q2 = q(k2);
        return I(q2).replace(k2, q2, v2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class Segment<K, V> extends ReentrantLock {
        @GuardedBy("this")
        final Queue<ReferenceEntry<K, V>> accessQueue;
        volatile int count;
        @NullableDecl
        final ReferenceQueue<K> keyReferenceQueue;
        @Weak
        final LocalCache<K, V> map;
        final long maxSegmentWeight;
        int modCount;
        final AtomicInteger readCount = new AtomicInteger();
        final Queue<ReferenceEntry<K, V>> recencyQueue;
        final AbstractCache$StatsCounter statsCounter;
        @MonotonicNonNullDecl
        volatile AtomicReferenceArray<ReferenceEntry<K, V>> table;
        int threshold;
        @GuardedBy("this")
        long totalWeight;
        @NullableDecl
        final ReferenceQueue<V> valueReferenceQueue;
        @GuardedBy("this")
        final Queue<ReferenceEntry<K, V>> writeQueue;

        Segment(LocalCache<K, V> localCache, int i, long j, AbstractCache$StatsCounter abstractCache$StatsCounter) {
            this.map = localCache;
            this.maxSegmentWeight = j;
            this.statsCounter = (AbstractCache$StatsCounter) du1.p(abstractCache$StatsCounter);
            initTable(newEntryArray(i));
            this.keyReferenceQueue = localCache.N() ? new ReferenceQueue<>() : null;
            this.valueReferenceQueue = localCache.O() ? new ReferenceQueue<>() : null;
            this.recencyQueue = localCache.M() ? new ConcurrentLinkedQueue<>() : LocalCache.g();
            this.writeQueue = localCache.Q() ? new b0<>() : LocalCache.g();
            this.accessQueue = localCache.M() ? new e<>() : LocalCache.g();
        }

        void cleanUp() {
            runLockedCleanup(this.map.p.a());
            runUnlockedCleanup();
        }

        void clear() {
            RemovalCause removalCause;
            if (this.count != 0) {
                lock();
                try {
                    preWriteCleanup(this.map.p.a());
                    AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                    for (int i = 0; i < atomicReferenceArray.length(); i++) {
                        for (ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(i); referenceEntry != null; referenceEntry = referenceEntry.getNext()) {
                            if (referenceEntry.getValueReference().isActive()) {
                                K key = referenceEntry.getKey();
                                V v = referenceEntry.getValueReference().get();
                                if (key != null && v != null) {
                                    removalCause = RemovalCause.EXPLICIT;
                                    enqueueNotification(key, referenceEntry.getHash(), v, referenceEntry.getValueReference().getWeight(), removalCause);
                                }
                                removalCause = RemovalCause.COLLECTED;
                                enqueueNotification(key, referenceEntry.getHash(), v, referenceEntry.getValueReference().getWeight(), removalCause);
                            }
                        }
                    }
                    for (int i2 = 0; i2 < atomicReferenceArray.length(); i2++) {
                        atomicReferenceArray.set(i2, null);
                    }
                    clearReferenceQueues();
                    this.writeQueue.clear();
                    this.accessQueue.clear();
                    this.readCount.set(0);
                    this.modCount++;
                    this.count = 0;
                } finally {
                    unlock();
                    postWriteCleanup();
                }
            }
        }

        void clearKeyReferenceQueue() {
            do {
            } while (this.keyReferenceQueue.poll() != null);
        }

        void clearReferenceQueues() {
            if (this.map.N()) {
                clearKeyReferenceQueue();
            }
            if (this.map.O()) {
                clearValueReferenceQueue();
            }
        }

        void clearValueReferenceQueue() {
            do {
            } while (this.valueReferenceQueue.poll() != null);
        }

        boolean containsKey(Object obj, int i) {
            try {
                if (this.count != 0) {
                    ReferenceEntry<K, V> liveEntry = getLiveEntry(obj, i, this.map.p.a());
                    if (liveEntry == null) {
                        return false;
                    }
                    return liveEntry.getValueReference().get() != null;
                }
                return false;
            } finally {
                postReadCleanup();
            }
        }

        @VisibleForTesting
        boolean containsValue(Object obj) {
            try {
                if (this.count != 0) {
                    long a = this.map.p.a();
                    AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                    int length = atomicReferenceArray.length();
                    for (int i = 0; i < length; i++) {
                        for (ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(i); referenceEntry != null; referenceEntry = referenceEntry.getNext()) {
                            V liveValue = getLiveValue(referenceEntry, a);
                            if (liveValue != null && this.map.f.equivalent(obj, liveValue)) {
                                postReadCleanup();
                                return true;
                            }
                        }
                    }
                }
                return false;
            } finally {
                postReadCleanup();
            }
        }

        @GuardedBy("this")
        ReferenceEntry<K, V> copyEntry(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            if (referenceEntry.getKey() == null) {
                return null;
            }
            ValueReference<K, V> valueReference = referenceEntry.getValueReference();
            V v = valueReference.get();
            if (v == null && valueReference.isActive()) {
                return null;
            }
            ReferenceEntry<K, V> copyEntry = this.map.q.copyEntry(this, referenceEntry, referenceEntry2);
            copyEntry.setValueReference(valueReference.copyFor(this.valueReferenceQueue, v, copyEntry));
            return copyEntry;
        }

        @GuardedBy("this")
        void drainKeyReferenceQueue() {
            int i = 0;
            do {
                Reference<? extends K> poll = this.keyReferenceQueue.poll();
                if (poll == null) {
                    return;
                }
                this.map.A((ReferenceEntry) poll);
                i++;
            } while (i != 16);
        }

        @GuardedBy("this")
        void drainRecencyQueue() {
            while (true) {
                ReferenceEntry<K, V> poll = this.recencyQueue.poll();
                if (poll == null) {
                    return;
                }
                if (this.accessQueue.contains(poll)) {
                    this.accessQueue.add(poll);
                }
            }
        }

        @GuardedBy("this")
        void drainReferenceQueues() {
            if (this.map.N()) {
                drainKeyReferenceQueue();
            }
            if (this.map.O()) {
                drainValueReferenceQueue();
            }
        }

        @GuardedBy("this")
        void drainValueReferenceQueue() {
            int i = 0;
            do {
                Reference<? extends V> poll = this.valueReferenceQueue.poll();
                if (poll == null) {
                    return;
                }
                this.map.B((ValueReference) poll);
                i++;
            } while (i != 16);
        }

        @GuardedBy("this")
        void enqueueNotification(@NullableDecl K k, int i, @NullableDecl V v, int i2, RemovalCause removalCause) {
            this.totalWeight -= i2;
            if (removalCause.wasEvicted()) {
                this.statsCounter.recordEviction();
            }
            if (this.map.n != LocalCache.y) {
                this.map.n.offer(RemovalNotification.create(k, v, removalCause));
            }
        }

        @GuardedBy("this")
        void evictEntries(ReferenceEntry<K, V> referenceEntry) {
            if (this.map.h()) {
                drainRecencyQueue();
                if (referenceEntry.getValueReference().getWeight() > this.maxSegmentWeight && !removeEntry(referenceEntry, referenceEntry.getHash(), RemovalCause.SIZE)) {
                    throw new AssertionError();
                }
                while (this.totalWeight > this.maxSegmentWeight) {
                    ReferenceEntry<K, V> nextEvictable = getNextEvictable();
                    if (!removeEntry(nextEvictable, nextEvictable.getHash(), RemovalCause.SIZE)) {
                        throw new AssertionError();
                    }
                }
            }
        }

        @GuardedBy("this")
        void expand() {
            AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
            int length = atomicReferenceArray.length();
            if (length >= 1073741824) {
                return;
            }
            int i = this.count;
            AtomicReferenceArray<ReferenceEntry<K, V>> newEntryArray = newEntryArray(length << 1);
            this.threshold = (newEntryArray.length() * 3) / 4;
            int length2 = newEntryArray.length() - 1;
            for (int i2 = 0; i2 < length; i2++) {
                ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(i2);
                if (referenceEntry != null) {
                    ReferenceEntry<K, V> next = referenceEntry.getNext();
                    int hash = referenceEntry.getHash() & length2;
                    if (next == null) {
                        newEntryArray.set(hash, referenceEntry);
                    } else {
                        ReferenceEntry<K, V> referenceEntry2 = referenceEntry;
                        while (next != null) {
                            int hash2 = next.getHash() & length2;
                            if (hash2 != hash) {
                                referenceEntry2 = next;
                                hash = hash2;
                            }
                            next = next.getNext();
                        }
                        newEntryArray.set(hash, referenceEntry2);
                        while (referenceEntry != referenceEntry2) {
                            int hash3 = referenceEntry.getHash() & length2;
                            ReferenceEntry<K, V> copyEntry = copyEntry(referenceEntry, newEntryArray.get(hash3));
                            if (copyEntry != null) {
                                newEntryArray.set(hash3, copyEntry);
                            } else {
                                removeCollectedEntry(referenceEntry);
                                i--;
                            }
                            referenceEntry = referenceEntry.getNext();
                        }
                    }
                }
            }
            this.table = newEntryArray;
            this.count = i;
        }

        @GuardedBy("this")
        void expireEntries(long j) {
            ReferenceEntry<K, V> peek;
            ReferenceEntry<K, V> peek2;
            drainRecencyQueue();
            do {
                peek = this.writeQueue.peek();
                if (peek == null || !this.map.s(peek, j)) {
                    do {
                        peek2 = this.accessQueue.peek();
                        if (peek2 == null || !this.map.s(peek2, j)) {
                            return;
                        }
                    } while (removeEntry(peek2, peek2.getHash(), RemovalCause.EXPIRED));
                    throw new AssertionError();
                }
            } while (removeEntry(peek, peek.getHash(), RemovalCause.EXPIRED));
            throw new AssertionError();
        }

        V get(K k, int i, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
            ReferenceEntry<K, V> entry;
            du1.p(k);
            du1.p(cacheLoader);
            try {
                try {
                    if (this.count != 0 && (entry = getEntry(k, i)) != null) {
                        long a = this.map.p.a();
                        V liveValue = getLiveValue(entry, a);
                        if (liveValue != null) {
                            recordRead(entry, a);
                            this.statsCounter.recordHits(1);
                            return scheduleRefresh(entry, k, i, liveValue, a, cacheLoader);
                        }
                        ValueReference<K, V> valueReference = entry.getValueReference();
                        if (valueReference.isLoading()) {
                            return waitForLoadingValue(entry, k, valueReference);
                        }
                    }
                    return lockedGetOrLoad(k, i, cacheLoader);
                } catch (ExecutionException e) {
                    Throwable cause = e.getCause();
                    if (!(cause instanceof Error)) {
                        if (cause instanceof RuntimeException) {
                            throw new UncheckedExecutionException(cause);
                        }
                        throw e;
                    }
                    throw new ExecutionError((Error) cause);
                }
            } finally {
                postReadCleanup();
            }
        }

        V getAndRecordStats(K k, int i, k<K, V> kVar, ListenableFuture<V> listenableFuture) throws ExecutionException {
            V v;
            try {
                v = (V) com.google.common.util.concurrent.q.a(listenableFuture);
                try {
                    if (v != null) {
                        this.statsCounter.recordLoadSuccess(kVar.a());
                        storeLoadedValue(k, i, kVar, v);
                        return v;
                    }
                    throw new CacheLoader.InvalidCacheLoadException("CacheLoader returned null for key " + k + ".");
                } catch (Throwable th) {
                    th = th;
                    if (v == null) {
                        this.statsCounter.recordLoadException(kVar.a());
                        removeLoadingValue(k, i, kVar);
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                v = null;
            }
        }

        @NullableDecl
        ReferenceEntry<K, V> getEntry(Object obj, int i) {
            for (ReferenceEntry<K, V> first = getFirst(i); first != null; first = first.getNext()) {
                if (first.getHash() == i) {
                    K key = first.getKey();
                    if (key == null) {
                        tryDrainReferenceQueues();
                    } else if (this.map.e.equivalent(obj, key)) {
                        return first;
                    }
                }
            }
            return null;
        }

        ReferenceEntry<K, V> getFirst(int i) {
            AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
            return atomicReferenceArray.get(i & (atomicReferenceArray.length() - 1));
        }

        @NullableDecl
        ReferenceEntry<K, V> getLiveEntry(Object obj, int i, long j) {
            ReferenceEntry<K, V> entry = getEntry(obj, i);
            if (entry == null) {
                return null;
            }
            if (this.map.s(entry, j)) {
                tryExpireEntries(j);
                return null;
            }
            return entry;
        }

        V getLiveValue(ReferenceEntry<K, V> referenceEntry, long j) {
            if (referenceEntry.getKey() == null) {
                tryDrainReferenceQueues();
                return null;
            }
            V v = referenceEntry.getValueReference().get();
            if (v == null) {
                tryDrainReferenceQueues();
                return null;
            } else if (this.map.s(referenceEntry, j)) {
                tryExpireEntries(j);
                return null;
            } else {
                return v;
            }
        }

        @GuardedBy("this")
        ReferenceEntry<K, V> getNextEvictable() {
            for (ReferenceEntry<K, V> referenceEntry : this.accessQueue) {
                if (referenceEntry.getValueReference().getWeight() > 0) {
                    return referenceEntry;
                }
            }
            throw new AssertionError();
        }

        void initTable(AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray) {
            this.threshold = (atomicReferenceArray.length() * 3) / 4;
            if (!this.map.f()) {
                int i = this.threshold;
                if (i == this.maxSegmentWeight) {
                    this.threshold = i + 1;
                }
            }
            this.table = atomicReferenceArray;
        }

        @NullableDecl
        k<K, V> insertLoadingValueReference(K k, int i, boolean z) {
            lock();
            try {
                long a = this.map.p.a();
                preWriteCleanup(a);
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(length);
                for (ReferenceEntry<K, V> referenceEntry2 = referenceEntry; referenceEntry2 != null; referenceEntry2 = referenceEntry2.getNext()) {
                    K key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() == i && key != null && this.map.e.equivalent(k, key)) {
                        ValueReference<K, V> valueReference = referenceEntry2.getValueReference();
                        if (!valueReference.isLoading() && (!z || a - referenceEntry2.getWriteTime() >= this.map.m)) {
                            this.modCount++;
                            k<K, V> kVar = new k<>(valueReference);
                            referenceEntry2.setValueReference(kVar);
                            return kVar;
                        }
                        return null;
                    }
                }
                this.modCount++;
                k<K, V> kVar2 = new k<>();
                ReferenceEntry<K, V> newEntry = newEntry(k, i, referenceEntry);
                newEntry.setValueReference(kVar2);
                atomicReferenceArray.set(length, newEntry);
                return kVar2;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        ListenableFuture<V> loadAsync(final K k, final int i, final k<K, V> kVar, CacheLoader<? super K, V> cacheLoader) {
            final ListenableFuture<V> d = kVar.d(k, cacheLoader);
            d.addListener(new Runnable() { // from class: com.google.common.cache.LocalCache.Segment.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Segment.this.getAndRecordStats(k, i, kVar, d);
                    } catch (Throwable th) {
                        LocalCache.w.log(Level.WARNING, "Exception thrown during refresh", th);
                        kVar.f(th);
                    }
                }
            }, MoreExecutors.a());
            return d;
        }

        V loadSync(K k, int i, k<K, V> kVar, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
            return getAndRecordStats(k, i, kVar, kVar.d(k, cacheLoader));
        }

        V lockedGetOrLoad(K k, int i, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
            k<K, V> kVar;
            ValueReference<K, V> valueReference;
            boolean z;
            V loadSync;
            lock();
            try {
                long a = this.map.p.a();
                preWriteCleanup(a);
                int i2 = this.count - 1;
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(length);
                ReferenceEntry<K, V> referenceEntry2 = referenceEntry;
                while (true) {
                    kVar = null;
                    if (referenceEntry2 == null) {
                        valueReference = null;
                        break;
                    }
                    K key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() == i && key != null && this.map.e.equivalent(k, key)) {
                        ValueReference<K, V> valueReference2 = referenceEntry2.getValueReference();
                        if (valueReference2.isLoading()) {
                            z = false;
                            valueReference = valueReference2;
                        } else {
                            V v = valueReference2.get();
                            if (v == null) {
                                enqueueNotification(key, i, v, valueReference2.getWeight(), RemovalCause.COLLECTED);
                            } else if (this.map.s(referenceEntry2, a)) {
                                enqueueNotification(key, i, v, valueReference2.getWeight(), RemovalCause.EXPIRED);
                            } else {
                                recordLockedRead(referenceEntry2, a);
                                this.statsCounter.recordHits(1);
                                return v;
                            }
                            this.writeQueue.remove(referenceEntry2);
                            this.accessQueue.remove(referenceEntry2);
                            this.count = i2;
                            valueReference = valueReference2;
                        }
                    } else {
                        referenceEntry2 = referenceEntry2.getNext();
                    }
                }
                z = true;
                if (z) {
                    kVar = new k<>();
                    if (referenceEntry2 == null) {
                        referenceEntry2 = newEntry(k, i, referenceEntry);
                        referenceEntry2.setValueReference(kVar);
                        atomicReferenceArray.set(length, referenceEntry2);
                    } else {
                        referenceEntry2.setValueReference(kVar);
                    }
                }
                if (z) {
                    try {
                        synchronized (referenceEntry2) {
                            loadSync = loadSync(k, i, kVar, cacheLoader);
                        }
                        return loadSync;
                    } finally {
                        this.statsCounter.recordMisses(1);
                    }
                }
                return waitForLoadingValue(referenceEntry2, k, valueReference);
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @GuardedBy("this")
        ReferenceEntry<K, V> newEntry(K k, int i, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
            return this.map.q.newEntry(this, du1.p(k), i, referenceEntry);
        }

        AtomicReferenceArray<ReferenceEntry<K, V>> newEntryArray(int i) {
            return new AtomicReferenceArray<>(i);
        }

        void postReadCleanup() {
            if ((this.readCount.incrementAndGet() & 63) == 0) {
                cleanUp();
            }
        }

        void postWriteCleanup() {
            runUnlockedCleanup();
        }

        @GuardedBy("this")
        void preWriteCleanup(long j) {
            runLockedCleanup(j);
        }

        @NullableDecl
        V put(K k, int i, V v, boolean z) {
            int i2;
            lock();
            try {
                long a = this.map.p.a();
                preWriteCleanup(a);
                if (this.count + 1 > this.threshold) {
                    expand();
                }
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(length);
                ReferenceEntry<K, V> referenceEntry2 = referenceEntry;
                while (true) {
                    if (referenceEntry2 != null) {
                        K key = referenceEntry2.getKey();
                        if (referenceEntry2.getHash() == i && key != null && this.map.e.equivalent(k, key)) {
                            ValueReference<K, V> valueReference = referenceEntry2.getValueReference();
                            V v2 = valueReference.get();
                            if (v2 != null) {
                                if (z) {
                                    recordLockedRead(referenceEntry2, a);
                                } else {
                                    this.modCount++;
                                    enqueueNotification(k, i, v2, valueReference.getWeight(), RemovalCause.REPLACED);
                                    setValue(referenceEntry2, k, v, a);
                                    evictEntries(referenceEntry2);
                                }
                                return v2;
                            }
                            this.modCount++;
                            if (valueReference.isActive()) {
                                enqueueNotification(k, i, v2, valueReference.getWeight(), RemovalCause.COLLECTED);
                                setValue(referenceEntry2, k, v, a);
                                i2 = this.count;
                            } else {
                                setValue(referenceEntry2, k, v, a);
                                i2 = this.count + 1;
                            }
                            this.count = i2;
                            evictEntries(referenceEntry2);
                        } else {
                            referenceEntry2 = referenceEntry2.getNext();
                        }
                    } else {
                        this.modCount++;
                        ReferenceEntry<K, V> newEntry = newEntry(k, i, referenceEntry);
                        setValue(newEntry, k, v, a);
                        atomicReferenceArray.set(length, newEntry);
                        this.count++;
                        evictEntries(newEntry);
                        break;
                    }
                }
                return null;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        boolean reclaimKey(ReferenceEntry<K, V> referenceEntry, int i) {
            lock();
            try {
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                ReferenceEntry<K, V> referenceEntry2 = atomicReferenceArray.get(length);
                for (ReferenceEntry<K, V> referenceEntry3 = referenceEntry2; referenceEntry3 != null; referenceEntry3 = referenceEntry3.getNext()) {
                    if (referenceEntry3 == referenceEntry) {
                        this.modCount++;
                        atomicReferenceArray.set(length, removeValueFromChain(referenceEntry2, referenceEntry3, referenceEntry3.getKey(), i, referenceEntry3.getValueReference().get(), referenceEntry3.getValueReference(), RemovalCause.COLLECTED));
                        this.count--;
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        boolean reclaimValue(K k, int i, ValueReference<K, V> valueReference) {
            lock();
            try {
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(length);
                for (ReferenceEntry<K, V> referenceEntry2 = referenceEntry; referenceEntry2 != null; referenceEntry2 = referenceEntry2.getNext()) {
                    K key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() == i && key != null && this.map.e.equivalent(k, key)) {
                        if (referenceEntry2.getValueReference() == valueReference) {
                            this.modCount++;
                            atomicReferenceArray.set(length, removeValueFromChain(referenceEntry, referenceEntry2, key, i, valueReference.get(), valueReference, RemovalCause.COLLECTED));
                            this.count--;
                            return true;
                        }
                        unlock();
                        if (!isHeldByCurrentThread()) {
                            postWriteCleanup();
                        }
                        return false;
                    }
                }
                unlock();
                if (!isHeldByCurrentThread()) {
                    postWriteCleanup();
                }
                return false;
            } finally {
                unlock();
                if (!isHeldByCurrentThread()) {
                    postWriteCleanup();
                }
            }
        }

        @GuardedBy("this")
        void recordLockedRead(ReferenceEntry<K, V> referenceEntry, long j) {
            if (this.map.C()) {
                referenceEntry.setAccessTime(j);
            }
            this.accessQueue.add(referenceEntry);
        }

        void recordRead(ReferenceEntry<K, V> referenceEntry, long j) {
            if (this.map.C()) {
                referenceEntry.setAccessTime(j);
            }
            this.recencyQueue.add(referenceEntry);
        }

        @GuardedBy("this")
        void recordWrite(ReferenceEntry<K, V> referenceEntry, int i, long j) {
            drainRecencyQueue();
            this.totalWeight += i;
            if (this.map.C()) {
                referenceEntry.setAccessTime(j);
            }
            if (this.map.E()) {
                referenceEntry.setWriteTime(j);
            }
            this.accessQueue.add(referenceEntry);
            this.writeQueue.add(referenceEntry);
        }

        @NullableDecl
        V refresh(K k, int i, CacheLoader<? super K, V> cacheLoader, boolean z) {
            k<K, V> insertLoadingValueReference = insertLoadingValueReference(k, i, z);
            if (insertLoadingValueReference == null) {
                return null;
            }
            ListenableFuture<V> loadAsync = loadAsync(k, i, insertLoadingValueReference, cacheLoader);
            if (loadAsync.isDone()) {
                try {
                    return (V) com.google.common.util.concurrent.q.a(loadAsync);
                } catch (Throwable unused) {
                }
            }
            return null;
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0038, code lost:
            r9 = r5.getValueReference();
            r12 = r9.get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x0040, code lost:
            if (r12 == null) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0042, code lost:
            r2 = com.google.common.cache.RemovalCause.EXPLICIT;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0044, code lost:
            r10 = r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x004a, code lost:
            if (r9.isActive() == false) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x004c, code lost:
            r2 = com.google.common.cache.RemovalCause.COLLECTED;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x004f, code lost:
            r11.modCount++;
            r0.set(r1, removeValueFromChain(r4, r5, r6, r13, r12, r9, r10));
            r11.count--;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x006b, code lost:
            return r12;
         */
        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        V remove(java.lang.Object r12, int r13) {
            /*
                r11 = this;
                r11.lock()
                com.google.common.cache.LocalCache<K, V> r0 = r11.map     // Catch: java.lang.Throwable -> L78
                com.google.common.base.j r0 = r0.p     // Catch: java.lang.Throwable -> L78
                long r0 = r0.a()     // Catch: java.lang.Throwable -> L78
                r11.preWriteCleanup(r0)     // Catch: java.lang.Throwable -> L78
                java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.cache.ReferenceEntry<K, V>> r0 = r11.table     // Catch: java.lang.Throwable -> L78
                int r1 = r0.length()     // Catch: java.lang.Throwable -> L78
                int r1 = r1 + (-1)
                r1 = r1 & r13
                java.lang.Object r2 = r0.get(r1)     // Catch: java.lang.Throwable -> L78
                r4 = r2
                com.google.common.cache.ReferenceEntry r4 = (com.google.common.cache.ReferenceEntry) r4     // Catch: java.lang.Throwable -> L78
                r5 = r4
            L1f:
                r2 = 0
                if (r5 == 0) goto L6c
                java.lang.Object r6 = r5.getKey()     // Catch: java.lang.Throwable -> L78
                int r3 = r5.getHash()     // Catch: java.lang.Throwable -> L78
                if (r3 != r13) goto L73
                if (r6 == 0) goto L73
                com.google.common.cache.LocalCache<K, V> r3 = r11.map     // Catch: java.lang.Throwable -> L78
                com.google.common.base.Equivalence<java.lang.Object> r3 = r3.e     // Catch: java.lang.Throwable -> L78
                boolean r3 = r3.equivalent(r12, r6)     // Catch: java.lang.Throwable -> L78
                if (r3 == 0) goto L73
                com.google.common.cache.LocalCache$ValueReference r9 = r5.getValueReference()     // Catch: java.lang.Throwable -> L78
                java.lang.Object r12 = r9.get()     // Catch: java.lang.Throwable -> L78
                if (r12 == 0) goto L46
                com.google.common.cache.RemovalCause r2 = com.google.common.cache.RemovalCause.EXPLICIT     // Catch: java.lang.Throwable -> L78
            L44:
                r10 = r2
                goto L4f
            L46:
                boolean r3 = r9.isActive()     // Catch: java.lang.Throwable -> L78
                if (r3 == 0) goto L6c
                com.google.common.cache.RemovalCause r2 = com.google.common.cache.RemovalCause.COLLECTED     // Catch: java.lang.Throwable -> L78
                goto L44
            L4f:
                int r2 = r11.modCount     // Catch: java.lang.Throwable -> L78
                int r2 = r2 + 1
                r11.modCount = r2     // Catch: java.lang.Throwable -> L78
                r3 = r11
                r7 = r13
                r8 = r12
                com.google.common.cache.ReferenceEntry r13 = r3.removeValueFromChain(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L78
                int r2 = r11.count     // Catch: java.lang.Throwable -> L78
                int r2 = r2 + (-1)
                r0.set(r1, r13)     // Catch: java.lang.Throwable -> L78
                r11.count = r2     // Catch: java.lang.Throwable -> L78
                r11.unlock()
                r11.postWriteCleanup()
                return r12
            L6c:
                r11.unlock()
                r11.postWriteCleanup()
                return r2
            L73:
                com.google.common.cache.ReferenceEntry r5 = r5.getNext()     // Catch: java.lang.Throwable -> L78
                goto L1f
            L78:
                r12 = move-exception
                r11.unlock()
                r11.postWriteCleanup()
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.Segment.remove(java.lang.Object, int):java.lang.Object");
        }

        @GuardedBy("this")
        void removeCollectedEntry(ReferenceEntry<K, V> referenceEntry) {
            enqueueNotification(referenceEntry.getKey(), referenceEntry.getHash(), referenceEntry.getValueReference().get(), referenceEntry.getValueReference().getWeight(), RemovalCause.COLLECTED);
            this.writeQueue.remove(referenceEntry);
            this.accessQueue.remove(referenceEntry);
        }

        @VisibleForTesting
        @GuardedBy("this")
        boolean removeEntry(ReferenceEntry<K, V> referenceEntry, int i, RemovalCause removalCause) {
            AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
            int length = (atomicReferenceArray.length() - 1) & i;
            ReferenceEntry<K, V> referenceEntry2 = atomicReferenceArray.get(length);
            for (ReferenceEntry<K, V> referenceEntry3 = referenceEntry2; referenceEntry3 != null; referenceEntry3 = referenceEntry3.getNext()) {
                if (referenceEntry3 == referenceEntry) {
                    this.modCount++;
                    atomicReferenceArray.set(length, removeValueFromChain(referenceEntry2, referenceEntry3, referenceEntry3.getKey(), i, referenceEntry3.getValueReference().get(), referenceEntry3.getValueReference(), removalCause));
                    this.count--;
                    return true;
                }
            }
            return false;
        }

        @NullableDecl
        @GuardedBy("this")
        ReferenceEntry<K, V> removeEntryFromChain(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            int i = this.count;
            ReferenceEntry<K, V> next = referenceEntry2.getNext();
            while (referenceEntry != referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = copyEntry(referenceEntry, next);
                if (copyEntry != null) {
                    next = copyEntry;
                } else {
                    removeCollectedEntry(referenceEntry);
                    i--;
                }
                referenceEntry = referenceEntry.getNext();
            }
            this.count = i;
            return next;
        }

        boolean removeLoadingValue(K k, int i, k<K, V> kVar) {
            lock();
            try {
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(length);
                ReferenceEntry<K, V> referenceEntry2 = referenceEntry;
                while (true) {
                    if (referenceEntry2 == null) {
                        break;
                    }
                    K key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() == i && key != null && this.map.e.equivalent(k, key)) {
                        if (referenceEntry2.getValueReference() == kVar) {
                            if (kVar.isActive()) {
                                referenceEntry2.setValueReference(kVar.c());
                            } else {
                                atomicReferenceArray.set(length, removeEntryFromChain(referenceEntry, referenceEntry2));
                            }
                            return true;
                        }
                    } else {
                        referenceEntry2 = referenceEntry2.getNext();
                    }
                }
                return false;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        @NullableDecl
        @GuardedBy("this")
        ReferenceEntry<K, V> removeValueFromChain(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2, @NullableDecl K k, int i, V v, ValueReference<K, V> valueReference, RemovalCause removalCause) {
            enqueueNotification(k, i, v, valueReference.getWeight(), removalCause);
            this.writeQueue.remove(referenceEntry2);
            this.accessQueue.remove(referenceEntry2);
            if (valueReference.isLoading()) {
                valueReference.notifyNewValue(null);
                return referenceEntry;
            }
            return removeEntryFromChain(referenceEntry, referenceEntry2);
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x006f, code lost:
            return false;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        boolean replace(K r18, int r19, V r20, V r21) {
            /*
                r17 = this;
                r9 = r17
                r0 = r19
                r17.lock()
                com.google.common.cache.LocalCache<K, V> r1 = r9.map     // Catch: java.lang.Throwable -> Lb5
                com.google.common.base.j r1 = r1.p     // Catch: java.lang.Throwable -> Lb5
                long r7 = r1.a()     // Catch: java.lang.Throwable -> Lb5
                r9.preWriteCleanup(r7)     // Catch: java.lang.Throwable -> Lb5
                java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.cache.ReferenceEntry<K, V>> r10 = r9.table     // Catch: java.lang.Throwable -> Lb5
                int r1 = r10.length()     // Catch: java.lang.Throwable -> Lb5
                r11 = 1
                int r1 = r1 - r11
                r12 = r0 & r1
                java.lang.Object r1 = r10.get(r12)     // Catch: java.lang.Throwable -> Lb5
                r2 = r1
                com.google.common.cache.ReferenceEntry r2 = (com.google.common.cache.ReferenceEntry) r2     // Catch: java.lang.Throwable -> Lb5
                r13 = r2
            L24:
                r14 = 0
                if (r13 == 0) goto L69
                java.lang.Object r4 = r13.getKey()     // Catch: java.lang.Throwable -> Lb5
                int r1 = r13.getHash()     // Catch: java.lang.Throwable -> Lb5
                if (r1 != r0) goto Lab
                if (r4 == 0) goto Lab
                com.google.common.cache.LocalCache<K, V> r1 = r9.map     // Catch: java.lang.Throwable -> Lb5
                com.google.common.base.Equivalence<java.lang.Object> r1 = r1.e     // Catch: java.lang.Throwable -> Lb5
                r15 = r18
                boolean r1 = r1.equivalent(r15, r4)     // Catch: java.lang.Throwable -> Lb5
                if (r1 == 0) goto Lad
                com.google.common.cache.LocalCache$ValueReference r16 = r13.getValueReference()     // Catch: java.lang.Throwable -> Lb5
                java.lang.Object r6 = r16.get()     // Catch: java.lang.Throwable -> Lb5
                if (r6 != 0) goto L70
                boolean r1 = r16.isActive()     // Catch: java.lang.Throwable -> Lb5
                if (r1 == 0) goto L69
                int r1 = r9.modCount     // Catch: java.lang.Throwable -> Lb5
                int r1 = r1 + r11
                r9.modCount = r1     // Catch: java.lang.Throwable -> Lb5
                com.google.common.cache.RemovalCause r8 = com.google.common.cache.RemovalCause.COLLECTED     // Catch: java.lang.Throwable -> Lb5
                r1 = r17
                r3 = r13
                r5 = r19
                r7 = r16
                com.google.common.cache.ReferenceEntry r0 = r1.removeValueFromChain(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> Lb5
                int r1 = r9.count     // Catch: java.lang.Throwable -> Lb5
                int r1 = r1 - r11
                r10.set(r12, r0)     // Catch: java.lang.Throwable -> Lb5
                r9.count = r1     // Catch: java.lang.Throwable -> Lb5
            L69:
                r17.unlock()
                r17.postWriteCleanup()
                return r14
            L70:
                com.google.common.cache.LocalCache<K, V> r1 = r9.map     // Catch: java.lang.Throwable -> Lb5
                com.google.common.base.Equivalence<java.lang.Object> r1 = r1.f     // Catch: java.lang.Throwable -> Lb5
                r3 = r20
                boolean r1 = r1.equivalent(r3, r6)     // Catch: java.lang.Throwable -> Lb5
                if (r1 == 0) goto La7
                int r1 = r9.modCount     // Catch: java.lang.Throwable -> Lb5
                int r1 = r1 + r11
                r9.modCount = r1     // Catch: java.lang.Throwable -> Lb5
                int r5 = r16.getWeight()     // Catch: java.lang.Throwable -> Lb5
                com.google.common.cache.RemovalCause r10 = com.google.common.cache.RemovalCause.REPLACED     // Catch: java.lang.Throwable -> Lb5
                r1 = r17
                r2 = r18
                r3 = r19
                r4 = r6
                r6 = r10
                r1.enqueueNotification(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> Lb5
                r1 = r17
                r2 = r13
                r3 = r18
                r4 = r21
                r5 = r7
                r1.setValue(r2, r3, r4, r5)     // Catch: java.lang.Throwable -> Lb5
                r9.evictEntries(r13)     // Catch: java.lang.Throwable -> Lb5
                r17.unlock()
                r17.postWriteCleanup()
                return r11
            La7:
                r9.recordLockedRead(r13, r7)     // Catch: java.lang.Throwable -> Lb5
                goto L69
            Lab:
                r15 = r18
            Lad:
                r3 = r20
                com.google.common.cache.ReferenceEntry r13 = r13.getNext()     // Catch: java.lang.Throwable -> Lb5
                goto L24
            Lb5:
                r0 = move-exception
                r17.unlock()
                r17.postWriteCleanup()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.Segment.replace(java.lang.Object, int, java.lang.Object, java.lang.Object):boolean");
        }

        void runLockedCleanup(long j) {
            if (tryLock()) {
                try {
                    drainReferenceQueues();
                    expireEntries(j);
                    this.readCount.set(0);
                } finally {
                    unlock();
                }
            }
        }

        void runUnlockedCleanup() {
            if (isHeldByCurrentThread()) {
                return;
            }
            this.map.z();
        }

        V scheduleRefresh(ReferenceEntry<K, V> referenceEntry, K k, int i, V v, long j, CacheLoader<? super K, V> cacheLoader) {
            V refresh;
            return (!this.map.G() || j - referenceEntry.getWriteTime() <= this.map.m || referenceEntry.getValueReference().isLoading() || (refresh = refresh(k, i, cacheLoader, true)) == null) ? v : refresh;
        }

        @GuardedBy("this")
        void setValue(ReferenceEntry<K, V> referenceEntry, K k, V v, long j) {
            ValueReference<K, V> valueReference = referenceEntry.getValueReference();
            int weigh = this.map.j.weigh(k, v);
            du1.x(weigh >= 0, "Weights must be non-negative");
            referenceEntry.setValueReference(this.map.h.referenceValue(this, referenceEntry, v, weigh));
            recordWrite(referenceEntry, weigh, j);
            valueReference.notifyNewValue(v);
        }

        boolean storeLoadedValue(K k, int i, k<K, V> kVar, V v) {
            lock();
            try {
                long a = this.map.p.a();
                preWriteCleanup(a);
                int i2 = this.count + 1;
                if (i2 > this.threshold) {
                    expand();
                    i2 = this.count + 1;
                }
                int i3 = i2;
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(length);
                ReferenceEntry<K, V> referenceEntry2 = referenceEntry;
                while (true) {
                    if (referenceEntry2 != null) {
                        K key = referenceEntry2.getKey();
                        if (referenceEntry2.getHash() == i && key != null && this.map.e.equivalent(k, key)) {
                            ValueReference<K, V> valueReference = referenceEntry2.getValueReference();
                            V v2 = valueReference.get();
                            if (kVar != valueReference && (v2 != null || valueReference == LocalCache.x)) {
                                enqueueNotification(k, i, v, 0, RemovalCause.REPLACED);
                                return false;
                            }
                            this.modCount++;
                            if (kVar.isActive()) {
                                enqueueNotification(k, i, v2, kVar.getWeight(), v2 == null ? RemovalCause.COLLECTED : RemovalCause.REPLACED);
                                i3--;
                            }
                            setValue(referenceEntry2, k, v, a);
                            this.count = i3;
                            evictEntries(referenceEntry2);
                        } else {
                            referenceEntry2 = referenceEntry2.getNext();
                        }
                    } else {
                        this.modCount++;
                        ReferenceEntry<K, V> newEntry = newEntry(k, i, referenceEntry);
                        setValue(newEntry, k, v, a);
                        atomicReferenceArray.set(length, newEntry);
                        this.count = i3;
                        evictEntries(newEntry);
                        break;
                    }
                }
                return true;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        void tryDrainReferenceQueues() {
            if (tryLock()) {
                try {
                    drainReferenceQueues();
                } finally {
                    unlock();
                }
            }
        }

        void tryExpireEntries(long j) {
            if (tryLock()) {
                try {
                    expireEntries(j);
                } finally {
                    unlock();
                }
            }
        }

        V waitForLoadingValue(ReferenceEntry<K, V> referenceEntry, K k, ValueReference<K, V> valueReference) throws ExecutionException {
            if (valueReference.isLoading()) {
                du1.A(!Thread.holdsLock(referenceEntry), "Recursive load of: %s", k);
                try {
                    V waitForValue = valueReference.waitForValue();
                    if (waitForValue != null) {
                        recordRead(referenceEntry, this.map.p.a());
                        return waitForValue;
                    }
                    throw new CacheLoader.InvalidCacheLoadException("CacheLoader returned null for key " + k + ".");
                } finally {
                    this.statsCounter.recordMisses(1);
                }
            }
            throw new AssertionError();
        }

        @NullableDecl
        V get(Object obj, int i) {
            try {
                if (this.count != 0) {
                    long a = this.map.p.a();
                    ReferenceEntry<K, V> liveEntry = getLiveEntry(obj, i, a);
                    if (liveEntry == null) {
                        return null;
                    }
                    V v = liveEntry.getValueReference().get();
                    if (v != null) {
                        recordRead(liveEntry, a);
                        return scheduleRefresh(liveEntry, liveEntry.getKey(), i, v, a, this.map.s);
                    }
                    tryDrainReferenceQueues();
                }
                return null;
            } finally {
                postReadCleanup();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0038, code lost:
            r10 = r6.getValueReference();
            r9 = r10.get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x0048, code lost:
            if (r12.map.f.equivalent(r15, r9) == false) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x004a, code lost:
            r13 = com.google.common.cache.RemovalCause.EXPLICIT;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x004d, code lost:
            if (r9 != null) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0053, code lost:
            if (r10.isActive() == false) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0055, code lost:
            r13 = com.google.common.cache.RemovalCause.COLLECTED;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0057, code lost:
            r12.modCount++;
            r0.set(r1, removeValueFromChain(r5, r6, r7, r14, r9, r10, r13));
            r12.count--;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x006d, code lost:
            if (r13 != com.google.common.cache.RemovalCause.EXPLICIT) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0070, code lost:
            r2 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0077, code lost:
            return r2;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        boolean remove(java.lang.Object r13, int r14, java.lang.Object r15) {
            /*
                r12 = this;
                r12.lock()
                com.google.common.cache.LocalCache<K, V> r0 = r12.map     // Catch: java.lang.Throwable -> L84
                com.google.common.base.j r0 = r0.p     // Catch: java.lang.Throwable -> L84
                long r0 = r0.a()     // Catch: java.lang.Throwable -> L84
                r12.preWriteCleanup(r0)     // Catch: java.lang.Throwable -> L84
                java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.cache.ReferenceEntry<K, V>> r0 = r12.table     // Catch: java.lang.Throwable -> L84
                int r1 = r0.length()     // Catch: java.lang.Throwable -> L84
                r2 = 1
                int r1 = r1 - r2
                r1 = r1 & r14
                java.lang.Object r3 = r0.get(r1)     // Catch: java.lang.Throwable -> L84
                r5 = r3
                com.google.common.cache.ReferenceEntry r5 = (com.google.common.cache.ReferenceEntry) r5     // Catch: java.lang.Throwable -> L84
                r6 = r5
            L1f:
                r3 = 0
                if (r6 == 0) goto L78
                java.lang.Object r7 = r6.getKey()     // Catch: java.lang.Throwable -> L84
                int r4 = r6.getHash()     // Catch: java.lang.Throwable -> L84
                if (r4 != r14) goto L7f
                if (r7 == 0) goto L7f
                com.google.common.cache.LocalCache<K, V> r4 = r12.map     // Catch: java.lang.Throwable -> L84
                com.google.common.base.Equivalence<java.lang.Object> r4 = r4.e     // Catch: java.lang.Throwable -> L84
                boolean r4 = r4.equivalent(r13, r7)     // Catch: java.lang.Throwable -> L84
                if (r4 == 0) goto L7f
                com.google.common.cache.LocalCache$ValueReference r10 = r6.getValueReference()     // Catch: java.lang.Throwable -> L84
                java.lang.Object r9 = r10.get()     // Catch: java.lang.Throwable -> L84
                com.google.common.cache.LocalCache<K, V> r13 = r12.map     // Catch: java.lang.Throwable -> L84
                com.google.common.base.Equivalence<java.lang.Object> r13 = r13.f     // Catch: java.lang.Throwable -> L84
                boolean r13 = r13.equivalent(r15, r9)     // Catch: java.lang.Throwable -> L84
                if (r13 == 0) goto L4d
                com.google.common.cache.RemovalCause r13 = com.google.common.cache.RemovalCause.EXPLICIT     // Catch: java.lang.Throwable -> L84
                goto L57
            L4d:
                if (r9 != 0) goto L78
                boolean r13 = r10.isActive()     // Catch: java.lang.Throwable -> L84
                if (r13 == 0) goto L78
                com.google.common.cache.RemovalCause r13 = com.google.common.cache.RemovalCause.COLLECTED     // Catch: java.lang.Throwable -> L84
            L57:
                int r15 = r12.modCount     // Catch: java.lang.Throwable -> L84
                int r15 = r15 + r2
                r12.modCount = r15     // Catch: java.lang.Throwable -> L84
                r4 = r12
                r8 = r14
                r11 = r13
                com.google.common.cache.ReferenceEntry r14 = r4.removeValueFromChain(r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L84
                int r15 = r12.count     // Catch: java.lang.Throwable -> L84
                int r15 = r15 - r2
                r0.set(r1, r14)     // Catch: java.lang.Throwable -> L84
                r12.count = r15     // Catch: java.lang.Throwable -> L84
                com.google.common.cache.RemovalCause r14 = com.google.common.cache.RemovalCause.EXPLICIT     // Catch: java.lang.Throwable -> L84
                if (r13 != r14) goto L70
                goto L71
            L70:
                r2 = 0
            L71:
                r12.unlock()
                r12.postWriteCleanup()
                return r2
            L78:
                r12.unlock()
                r12.postWriteCleanup()
                return r3
            L7f:
                com.google.common.cache.ReferenceEntry r6 = r6.getNext()     // Catch: java.lang.Throwable -> L84
                goto L1f
            L84:
                r13 = move-exception
                r12.unlock()
                r12.postWriteCleanup()
                throw r13
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.Segment.remove(java.lang.Object, int, java.lang.Object):boolean");
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0072, code lost:
            return null;
         */
        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        V replace(K r18, int r19, V r20) {
            /*
                r17 = this;
                r9 = r17
                r0 = r19
                r17.lock()
                com.google.common.cache.LocalCache<K, V> r1 = r9.map     // Catch: java.lang.Throwable -> La7
                com.google.common.base.j r1 = r1.p     // Catch: java.lang.Throwable -> La7
                long r7 = r1.a()     // Catch: java.lang.Throwable -> La7
                r9.preWriteCleanup(r7)     // Catch: java.lang.Throwable -> La7
                java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.cache.ReferenceEntry<K, V>> r10 = r9.table     // Catch: java.lang.Throwable -> La7
                int r1 = r10.length()     // Catch: java.lang.Throwable -> La7
                int r1 = r1 + (-1)
                r11 = r0 & r1
                java.lang.Object r1 = r10.get(r11)     // Catch: java.lang.Throwable -> La7
                r2 = r1
                com.google.common.cache.ReferenceEntry r2 = (com.google.common.cache.ReferenceEntry) r2     // Catch: java.lang.Throwable -> La7
                r12 = r2
            L24:
                r13 = 0
                if (r12 == 0) goto L6c
                java.lang.Object r4 = r12.getKey()     // Catch: java.lang.Throwable -> La7
                int r1 = r12.getHash()     // Catch: java.lang.Throwable -> La7
                if (r1 != r0) goto L9f
                if (r4 == 0) goto L9f
                com.google.common.cache.LocalCache<K, V> r1 = r9.map     // Catch: java.lang.Throwable -> La7
                com.google.common.base.Equivalence<java.lang.Object> r1 = r1.e     // Catch: java.lang.Throwable -> La7
                r14 = r18
                boolean r1 = r1.equivalent(r14, r4)     // Catch: java.lang.Throwable -> La7
                if (r1 == 0) goto La1
                com.google.common.cache.LocalCache$ValueReference r15 = r12.getValueReference()     // Catch: java.lang.Throwable -> La7
                java.lang.Object r16 = r15.get()     // Catch: java.lang.Throwable -> La7
                if (r16 != 0) goto L73
                boolean r1 = r15.isActive()     // Catch: java.lang.Throwable -> La7
                if (r1 == 0) goto L6c
                int r1 = r9.modCount     // Catch: java.lang.Throwable -> La7
                int r1 = r1 + 1
                r9.modCount = r1     // Catch: java.lang.Throwable -> La7
                com.google.common.cache.RemovalCause r8 = com.google.common.cache.RemovalCause.COLLECTED     // Catch: java.lang.Throwable -> La7
                r1 = r17
                r3 = r12
                r5 = r19
                r6 = r16
                r7 = r15
                com.google.common.cache.ReferenceEntry r0 = r1.removeValueFromChain(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> La7
                int r1 = r9.count     // Catch: java.lang.Throwable -> La7
                int r1 = r1 + (-1)
                r10.set(r11, r0)     // Catch: java.lang.Throwable -> La7
                r9.count = r1     // Catch: java.lang.Throwable -> La7
            L6c:
                r17.unlock()
                r17.postWriteCleanup()
                return r13
            L73:
                int r1 = r9.modCount     // Catch: java.lang.Throwable -> La7
                int r1 = r1 + 1
                r9.modCount = r1     // Catch: java.lang.Throwable -> La7
                int r5 = r15.getWeight()     // Catch: java.lang.Throwable -> La7
                com.google.common.cache.RemovalCause r6 = com.google.common.cache.RemovalCause.REPLACED     // Catch: java.lang.Throwable -> La7
                r1 = r17
                r2 = r18
                r3 = r19
                r4 = r16
                r1.enqueueNotification(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> La7
                r1 = r17
                r2 = r12
                r3 = r18
                r4 = r20
                r5 = r7
                r1.setValue(r2, r3, r4, r5)     // Catch: java.lang.Throwable -> La7
                r9.evictEntries(r12)     // Catch: java.lang.Throwable -> La7
                r17.unlock()
                r17.postWriteCleanup()
                return r16
            L9f:
                r14 = r18
            La1:
                com.google.common.cache.ReferenceEntry r12 = r12.getNext()     // Catch: java.lang.Throwable -> La7
                goto L24
            La7:
                r0 = move-exception
                r17.unlock()
                r17.postWriteCleanup()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.Segment.replace(java.lang.Object, int, java.lang.Object):java.lang.Object");
        }
    }
}
