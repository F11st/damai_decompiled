package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Equivalence;
import com.google.common.collect.MapMaker;
import com.google.common.collect.MapMakerInternalMap.InternalEntry;
import com.google.common.collect.MapMakerInternalMap.Segment;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import com.google.j2objc.annotations.Weak;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.du1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
@GwtIncompatible
/* loaded from: classes10.dex */
public class MapMakerInternalMap<K, V, E extends InternalEntry<K, V, E>, S extends Segment<K, V, E, S>> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable {
    static final long CLEANUP_EXECUTOR_DELAY_SECS = 60;
    static final int CONTAINS_VALUE_RETRIES = 3;
    static final int DRAIN_MAX = 16;
    static final int DRAIN_THRESHOLD = 63;
    static final int MAXIMUM_CAPACITY = 1073741824;
    static final int MAX_SEGMENTS = 65536;
    static final WeakValueReference<Object, Object, d> UNSET_WEAK_VALUE_REFERENCE = new a();
    private static final long serialVersionUID = 5;
    final int concurrencyLevel;
    final transient InternalEntryHelper<K, V, E, S> entryHelper;
    @MonotonicNonNullDecl
    transient Set<Map.Entry<K, V>> entrySet;
    final Equivalence<Object> keyEquivalence;
    @MonotonicNonNullDecl
    transient Set<K> keySet;
    final transient int segmentMask;
    final transient int segmentShift;
    final transient Segment<K, V, E, S>[] segments;
    @MonotonicNonNullDecl
    transient Collection<V> values;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static final class CleanupMapTask implements Runnable {
        final WeakReference<MapMakerInternalMap<?, ?, ?, ?>> mapReference;

        public CleanupMapTask(MapMakerInternalMap<?, ?, ?, ?> mapMakerInternalMap) {
            this.mapReference = new WeakReference<>(mapMakerInternalMap);
        }

        @Override // java.lang.Runnable
        public void run() {
            MapMakerInternalMap<?, ?, ?, ?> mapMakerInternalMap = this.mapReference.get();
            if (mapMakerInternalMap != null) {
                for (Segment<?, ?, ?, ?> segment : mapMakerInternalMap.segments) {
                    segment.runCleanup();
                }
                return;
            }
            throw new CancellationException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface InternalEntry<K, V, E extends InternalEntry<K, V, E>> {
        int getHash();

        K getKey();

        E getNext();

        V getValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface InternalEntryHelper<K, V, E extends InternalEntry<K, V, E>, S extends Segment<K, V, E, S>> {
        E copy(S s, E e, @NullableDecl E e2);

        Strength keyStrength();

        E newEntry(S s, K k, int i, @NullableDecl E e);

        S newSegment(MapMakerInternalMap<K, V, E, S> mapMakerInternalMap, int i, int i2);

        void setValue(S s, E e, V v);

        Strength valueStrength();
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private static final class SerializationProxy<K, V> extends AbstractSerializationProxy<K, V> {
        private static final long serialVersionUID = 3;

        SerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, int i, ConcurrentMap<K, V> concurrentMap) {
            super(strength, strength2, equivalence, equivalence2, i, concurrentMap);
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.delegate = readMapMaker(objectInputStream).i();
            readEntries(objectInputStream);
        }

        private Object readResolve() {
            return this.delegate;
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            writeMapTo(objectOutputStream);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public enum Strength {
        STRONG { // from class: com.google.common.collect.MapMakerInternalMap.Strength.1
            @Override // com.google.common.collect.MapMakerInternalMap.Strength
            Equivalence<Object> defaultEquivalence() {
                return Equivalence.equals();
            }
        },
        WEAK { // from class: com.google.common.collect.MapMakerInternalMap.Strength.2
            @Override // com.google.common.collect.MapMakerInternalMap.Strength
            Equivalence<Object> defaultEquivalence() {
                return Equivalence.identity();
            }
        };

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract Equivalence<Object> defaultEquivalence();

        /* synthetic */ Strength(a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static final class StrongKeyDummyValueSegment<K> extends Segment<K, MapMaker.Dummy, k<K>, StrongKeyDummyValueSegment<K>> {
        StrongKeyDummyValueSegment(MapMakerInternalMap<K, MapMaker.Dummy, k<K>, StrongKeyDummyValueSegment<K>> mapMakerInternalMap, int i, int i2) {
            super(mapMakerInternalMap, i, i2);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public StrongKeyDummyValueSegment<K> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public k<K> castForTesting(InternalEntry<K, MapMaker.Dummy, ?> internalEntry) {
            return (k) internalEntry;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static final class StrongKeyStrongValueSegment<K, V> extends Segment<K, V, l<K, V>, StrongKeyStrongValueSegment<K, V>> {
        StrongKeyStrongValueSegment(MapMakerInternalMap<K, V, l<K, V>, StrongKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i, int i2) {
            super(mapMakerInternalMap, i, i2);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public StrongKeyStrongValueSegment<K, V> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public l<K, V> castForTesting(InternalEntry<K, V, ?> internalEntry) {
            return (l) internalEntry;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static final class StrongKeyWeakValueSegment<K, V> extends Segment<K, V, m<K, V>, StrongKeyWeakValueSegment<K, V>> {
        private final ReferenceQueue<V> queueForValues;

        StrongKeyWeakValueSegment(MapMakerInternalMap<K, V, m<K, V>, StrongKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i, int i2) {
            super(mapMakerInternalMap, i, i2);
            this.queueForValues = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        ReferenceQueue<V> getValueReferenceQueueForTesting() {
            return this.queueForValues;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakValueReference<K, V, m<K, V>> getWeakValueReferenceForTesting(InternalEntry<K, V, ?> internalEntry) {
            return castForTesting((InternalEntry) internalEntry).getValueReference();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void maybeClearReferenceQueues() {
            clearReferenceQueue((ReferenceQueue<V>) this.queueForValues);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void maybeDrainReferenceQueues() {
            drainValueReferenceQueue(this.queueForValues);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakValueReference<K, V, m<K, V>> newWeakValueReferenceForTesting(InternalEntry<K, V, ?> internalEntry, V v) {
            return new s(this.queueForValues, v, castForTesting((InternalEntry) internalEntry));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public StrongKeyWeakValueSegment<K, V> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void setWeakValueReferenceForTesting(InternalEntry<K, V, ?> internalEntry, WeakValueReference<K, V, ? extends InternalEntry<K, V, ?>> weakValueReference) {
            m<K, V> castForTesting = castForTesting((InternalEntry) internalEntry);
            WeakValueReference weakValueReference2 = ((m) castForTesting).d;
            ((m) castForTesting).d = weakValueReference;
            weakValueReference2.clear();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public m<K, V> castForTesting(InternalEntry<K, V, ?> internalEntry) {
            return (m) internalEntry;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    interface StrongValueEntry<K, V, E extends InternalEntry<K, V, E>> extends InternalEntry<K, V, E> {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static final class WeakKeyDummyValueSegment<K> extends Segment<K, MapMaker.Dummy, p<K>, WeakKeyDummyValueSegment<K>> {
        private final ReferenceQueue<K> queueForKeys;

        WeakKeyDummyValueSegment(MapMakerInternalMap<K, MapMaker.Dummy, p<K>, WeakKeyDummyValueSegment<K>> mapMakerInternalMap, int i, int i2) {
            super(mapMakerInternalMap, i, i2);
            this.queueForKeys = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            return this.queueForKeys;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void maybeClearReferenceQueues() {
            clearReferenceQueue((ReferenceQueue<K>) this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakKeyDummyValueSegment<K> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public p<K> castForTesting(InternalEntry<K, MapMaker.Dummy, ?> internalEntry) {
            return (p) internalEntry;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static final class WeakKeyStrongValueSegment<K, V> extends Segment<K, V, q<K, V>, WeakKeyStrongValueSegment<K, V>> {
        private final ReferenceQueue<K> queueForKeys;

        WeakKeyStrongValueSegment(MapMakerInternalMap<K, V, q<K, V>, WeakKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i, int i2) {
            super(mapMakerInternalMap, i, i2);
            this.queueForKeys = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            return this.queueForKeys;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void maybeClearReferenceQueues() {
            clearReferenceQueue((ReferenceQueue<K>) this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakKeyStrongValueSegment<K, V> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public q<K, V> castForTesting(InternalEntry<K, V, ?> internalEntry) {
            return (q) internalEntry;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static final class WeakKeyWeakValueSegment<K, V> extends Segment<K, V, r<K, V>, WeakKeyWeakValueSegment<K, V>> {
        private final ReferenceQueue<K> queueForKeys;
        private final ReferenceQueue<V> queueForValues;

        WeakKeyWeakValueSegment(MapMakerInternalMap<K, V, r<K, V>, WeakKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i, int i2) {
            super(mapMakerInternalMap, i, i2);
            this.queueForKeys = new ReferenceQueue<>();
            this.queueForValues = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            return this.queueForKeys;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        ReferenceQueue<V> getValueReferenceQueueForTesting() {
            return this.queueForValues;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakValueReference<K, V, r<K, V>> getWeakValueReferenceForTesting(InternalEntry<K, V, ?> internalEntry) {
            return castForTesting((InternalEntry) internalEntry).getValueReference();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void maybeClearReferenceQueues() {
            clearReferenceQueue((ReferenceQueue<K>) this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
            drainValueReferenceQueue(this.queueForValues);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakValueReference<K, V, r<K, V>> newWeakValueReferenceForTesting(InternalEntry<K, V, ?> internalEntry, V v) {
            return new s(this.queueForValues, v, castForTesting((InternalEntry) internalEntry));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakKeyWeakValueSegment<K, V> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void setWeakValueReferenceForTesting(InternalEntry<K, V, ?> internalEntry, WeakValueReference<K, V, ? extends InternalEntry<K, V, ?>> weakValueReference) {
            r<K, V> castForTesting = castForTesting((InternalEntry) internalEntry);
            WeakValueReference weakValueReference2 = ((r) castForTesting).c;
            ((r) castForTesting).c = weakValueReference;
            weakValueReference2.clear();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public r<K, V> castForTesting(InternalEntry<K, V, ?> internalEntry) {
            return (r) internalEntry;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface WeakValueEntry<K, V, E extends InternalEntry<K, V, E>> extends InternalEntry<K, V, E> {
        void clearValue();

        WeakValueReference<K, V, E> getValueReference();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface WeakValueReference<K, V, E extends InternalEntry<K, V, E>> {
        void clear();

        WeakValueReference<K, V, E> copyFor(ReferenceQueue<V> referenceQueue, E e);

        @NullableDecl
        V get();

        E getEntry();
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class a implements WeakValueReference<Object, Object, d> {
        a() {
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueReference
        /* renamed from: a */
        public WeakValueReference<Object, Object, d> copyFor(ReferenceQueue<Object> referenceQueue, d dVar) {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueReference
        /* renamed from: b */
        public d getEntry() {
            return null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueReference
        public void clear() {
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueReference
        public Object get() {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static abstract class b<K, V, E extends InternalEntry<K, V, E>> implements InternalEntry<K, V, E> {
        final K a;
        final int b;
        @NullableDecl
        final E c;

        b(K k, int i, @NullableDecl E e) {
            this.a = k;
            this.b = i;
            this.c = e;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public int getHash() {
            return this.b;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public K getKey() {
            return this.a;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public E getNext() {
            return this.c;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static abstract class c<K, V, E extends InternalEntry<K, V, E>> extends WeakReference<K> implements InternalEntry<K, V, E> {
        final int a;
        @NullableDecl
        final E b;

        c(ReferenceQueue<K> referenceQueue, K k, int i, @NullableDecl E e) {
            super(k, referenceQueue);
            this.a = i;
            this.b = e;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public int getHash() {
            return this.a;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public K getKey() {
            return get();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public E getNext() {
            return this.b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static final class d implements InternalEntry<Object, Object, d> {
        private d() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        /* renamed from: a */
        public d getNext() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public int getHash() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public Object getKey() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public Object getValue() {
            throw new AssertionError();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    final class e extends MapMakerInternalMap<K, V, E, S>.g<Map.Entry<K, V>> {
        e(MapMakerInternalMap mapMakerInternalMap) {
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
    final class f extends j<Map.Entry<K, V>> {
        f() {
            super(null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            MapMakerInternalMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry;
            Object key;
            Object obj2;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (obj2 = MapMakerInternalMap.this.get(key)) != null && MapMakerInternalMap.this.valueEquivalence().equivalent(entry.getValue(), obj2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new e(MapMakerInternalMap.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry;
            Object key;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && MapMakerInternalMap.this.remove(key, entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return MapMakerInternalMap.this.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public abstract class g<T> implements Iterator<T> {
        int a;
        int b = -1;
        @MonotonicNonNullDecl
        Segment<K, V, E, S> c;
        @MonotonicNonNullDecl
        AtomicReferenceArray<E> d;
        @NullableDecl
        E e;
        @NullableDecl
        MapMakerInternalMap<K, V, E, S>.t f;
        @NullableDecl
        MapMakerInternalMap<K, V, E, S>.t g;

        g() {
            this.a = MapMakerInternalMap.this.segments.length - 1;
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
                Segment<K, V, E, S>[] segmentArr = MapMakerInternalMap.this.segments;
                this.a = i - 1;
                Segment<K, V, E, S> segment = segmentArr[i];
                this.c = segment;
                if (segment.count != 0) {
                    AtomicReferenceArray<E> atomicReferenceArray = this.c.table;
                    this.d = atomicReferenceArray;
                    this.b = atomicReferenceArray.length() - 1;
                    if (e()) {
                        return;
                    }
                }
            }
        }

        boolean b(E e) {
            boolean z;
            try {
                Object key = e.getKey();
                Object liveValue = MapMakerInternalMap.this.getLiveValue(e);
                if (liveValue != null) {
                    this.f = new t(key, liveValue);
                    z = true;
                } else {
                    z = false;
                }
                return z;
            } finally {
                this.c.postReadCleanup();
            }
        }

        MapMakerInternalMap<K, V, E, S>.t c() {
            MapMakerInternalMap<K, V, E, S>.t tVar = this.f;
            if (tVar != null) {
                this.g = tVar;
                a();
                return this.g;
            }
            throw new NoSuchElementException();
        }

        boolean d() {
            E e = this.e;
            if (e == null) {
                return false;
            }
            while (true) {
                this.e = (E) e.getNext();
                E e2 = this.e;
                if (e2 == null) {
                    return false;
                }
                if (b(e2)) {
                    return true;
                }
                e = this.e;
            }
        }

        boolean e() {
            while (true) {
                int i = this.b;
                if (i < 0) {
                    return false;
                }
                AtomicReferenceArray<E> atomicReferenceArray = this.d;
                this.b = i - 1;
                E e = atomicReferenceArray.get(i);
                this.e = e;
                if (e != null && (b(e) || d())) {
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
            com.google.common.collect.k.e(this.g != null);
            MapMakerInternalMap.this.remove(this.g.getKey());
            this.g = null;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    final class h extends MapMakerInternalMap<K, V, E, S>.g<K> {
        h(MapMakerInternalMap mapMakerInternalMap) {
            super();
        }

        @Override // java.util.Iterator
        public K next() {
            return c().getKey();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    final class i extends j<K> {
        i() {
            super(null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            MapMakerInternalMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return MapMakerInternalMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new h(MapMakerInternalMap.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return MapMakerInternalMap.this.remove(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return MapMakerInternalMap.this.size();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private static abstract class j<E> extends AbstractSet<E> {
        private j() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return MapMakerInternalMap.toArrayList(this).toArray();
        }

        /* synthetic */ j(a aVar) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) MapMakerInternalMap.toArrayList(this).toArray(tArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static final class k<K> extends b<K, MapMaker.Dummy, k<K>> implements StrongValueEntry<K, MapMaker.Dummy, k<K>> {

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        static final class a<K> implements InternalEntryHelper<K, MapMaker.Dummy, k<K>, StrongKeyDummyValueSegment<K>> {
            private static final a<?> a = new a<>();

            a() {
            }

            static <K> a<K> b() {
                return (a<K>) a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: a */
            public k<K> copy(StrongKeyDummyValueSegment<K> strongKeyDummyValueSegment, k<K> kVar, @NullableDecl k<K> kVar2) {
                return kVar.a(kVar2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: c */
            public k<K> newEntry(StrongKeyDummyValueSegment<K> strongKeyDummyValueSegment, K k, int i, @NullableDecl k<K> kVar) {
                return new k<>(k, i, kVar);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: d */
            public StrongKeyDummyValueSegment<K> newSegment(MapMakerInternalMap<K, MapMaker.Dummy, k<K>, StrongKeyDummyValueSegment<K>> mapMakerInternalMap, int i, int i2) {
                return new StrongKeyDummyValueSegment<>(mapMakerInternalMap, i, i2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: e */
            public void setValue(StrongKeyDummyValueSegment<K> strongKeyDummyValueSegment, k<K> kVar, MapMaker.Dummy dummy) {
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength keyStrength() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength valueStrength() {
                return Strength.STRONG;
            }
        }

        k(K k, int i, @NullableDecl k<K> kVar) {
            super(k, i, kVar);
        }

        k<K> a(k<K> kVar) {
            return new k<>(this.a, this.b, kVar);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        /* renamed from: b */
        public MapMaker.Dummy getValue() {
            return MapMaker.Dummy.VALUE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static final class l<K, V> extends b<K, V, l<K, V>> implements StrongValueEntry<K, V, l<K, V>> {
        @NullableDecl
        private volatile V d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public static final class a<K, V> implements InternalEntryHelper<K, V, l<K, V>, StrongKeyStrongValueSegment<K, V>> {
            private static final a<?, ?> a = new a<>();

            a() {
            }

            static <K, V> a<K, V> b() {
                return (a<K, V>) a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: a */
            public l<K, V> copy(StrongKeyStrongValueSegment<K, V> strongKeyStrongValueSegment, l<K, V> lVar, @NullableDecl l<K, V> lVar2) {
                return lVar.a(lVar2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: c */
            public l<K, V> newEntry(StrongKeyStrongValueSegment<K, V> strongKeyStrongValueSegment, K k, int i, @NullableDecl l<K, V> lVar) {
                return new l<>(k, i, lVar);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: d */
            public StrongKeyStrongValueSegment<K, V> newSegment(MapMakerInternalMap<K, V, l<K, V>, StrongKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i, int i2) {
                return new StrongKeyStrongValueSegment<>(mapMakerInternalMap, i, i2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: e */
            public void setValue(StrongKeyStrongValueSegment<K, V> strongKeyStrongValueSegment, l<K, V> lVar, V v) {
                lVar.b(v);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength keyStrength() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength valueStrength() {
                return Strength.STRONG;
            }
        }

        l(K k, int i, @NullableDecl l<K, V> lVar) {
            super(k, i, lVar);
            this.d = null;
        }

        l<K, V> a(l<K, V> lVar) {
            l<K, V> lVar2 = new l<>(this.a, this.b, lVar);
            lVar2.d = this.d;
            return lVar2;
        }

        void b(V v) {
            this.d = v;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        @NullableDecl
        public V getValue() {
            return this.d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static final class m<K, V> extends b<K, V, m<K, V>> implements WeakValueEntry<K, V, m<K, V>> {
        private volatile WeakValueReference<K, V, m<K, V>> d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public static final class a<K, V> implements InternalEntryHelper<K, V, m<K, V>, StrongKeyWeakValueSegment<K, V>> {
            private static final a<?, ?> a = new a<>();

            a() {
            }

            static <K, V> a<K, V> b() {
                return (a<K, V>) a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: a */
            public m<K, V> copy(StrongKeyWeakValueSegment<K, V> strongKeyWeakValueSegment, m<K, V> mVar, @NullableDecl m<K, V> mVar2) {
                if (Segment.isCollected(mVar)) {
                    return null;
                }
                return mVar.c(((StrongKeyWeakValueSegment) strongKeyWeakValueSegment).queueForValues, mVar2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: c */
            public m<K, V> newEntry(StrongKeyWeakValueSegment<K, V> strongKeyWeakValueSegment, K k, int i, @NullableDecl m<K, V> mVar) {
                return new m<>(k, i, mVar);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: d */
            public StrongKeyWeakValueSegment<K, V> newSegment(MapMakerInternalMap<K, V, m<K, V>, StrongKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i, int i2) {
                return new StrongKeyWeakValueSegment<>(mapMakerInternalMap, i, i2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: e */
            public void setValue(StrongKeyWeakValueSegment<K, V> strongKeyWeakValueSegment, m<K, V> mVar, V v) {
                mVar.d(v, ((StrongKeyWeakValueSegment) strongKeyWeakValueSegment).queueForValues);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength keyStrength() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength valueStrength() {
                return Strength.WEAK;
            }
        }

        m(K k, int i, @NullableDecl m<K, V> mVar) {
            super(k, i, mVar);
            this.d = MapMakerInternalMap.unsetWeakValueReference();
        }

        m<K, V> c(ReferenceQueue<V> referenceQueue, m<K, V> mVar) {
            m<K, V> mVar2 = new m<>(this.a, this.b, mVar);
            mVar2.d = this.d.copyFor(referenceQueue, mVar2);
            return mVar2;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueEntry
        public void clearValue() {
            this.d.clear();
        }

        void d(V v, ReferenceQueue<V> referenceQueue) {
            WeakValueReference<K, V, m<K, V>> weakValueReference = this.d;
            this.d = new s(referenceQueue, v, this);
            weakValueReference.clear();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public V getValue() {
            return this.d.get();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueEntry
        public WeakValueReference<K, V, m<K, V>> getValueReference() {
            return this.d;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    final class n extends MapMakerInternalMap<K, V, E, S>.g<V> {
        n(MapMakerInternalMap mapMakerInternalMap) {
            super();
        }

        @Override // java.util.Iterator
        public V next() {
            return c().getValue();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    final class o extends AbstractCollection<V> {
        o() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            MapMakerInternalMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return MapMakerInternalMap.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new n(MapMakerInternalMap.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return MapMakerInternalMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return MapMakerInternalMap.toArrayList(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) MapMakerInternalMap.toArrayList(this).toArray(tArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static final class p<K> extends c<K, MapMaker.Dummy, p<K>> implements StrongValueEntry<K, MapMaker.Dummy, p<K>> {

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        static final class a<K> implements InternalEntryHelper<K, MapMaker.Dummy, p<K>, WeakKeyDummyValueSegment<K>> {
            private static final a<?> a = new a<>();

            a() {
            }

            static <K> a<K> b() {
                return (a<K>) a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: a */
            public p<K> copy(WeakKeyDummyValueSegment<K> weakKeyDummyValueSegment, p<K> pVar, @NullableDecl p<K> pVar2) {
                if (pVar.getKey() == null) {
                    return null;
                }
                return pVar.a(((WeakKeyDummyValueSegment) weakKeyDummyValueSegment).queueForKeys, pVar2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: c */
            public p<K> newEntry(WeakKeyDummyValueSegment<K> weakKeyDummyValueSegment, K k, int i, @NullableDecl p<K> pVar) {
                return new p<>(((WeakKeyDummyValueSegment) weakKeyDummyValueSegment).queueForKeys, k, i, pVar);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: d */
            public WeakKeyDummyValueSegment<K> newSegment(MapMakerInternalMap<K, MapMaker.Dummy, p<K>, WeakKeyDummyValueSegment<K>> mapMakerInternalMap, int i, int i2) {
                return new WeakKeyDummyValueSegment<>(mapMakerInternalMap, i, i2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: e */
            public void setValue(WeakKeyDummyValueSegment<K> weakKeyDummyValueSegment, p<K> pVar, MapMaker.Dummy dummy) {
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength keyStrength() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength valueStrength() {
                return Strength.STRONG;
            }
        }

        p(ReferenceQueue<K> referenceQueue, K k, int i, @NullableDecl p<K> pVar) {
            super(referenceQueue, k, i, pVar);
        }

        p<K> a(ReferenceQueue<K> referenceQueue, p<K> pVar) {
            return new p<>(referenceQueue, getKey(), this.a, pVar);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        /* renamed from: b */
        public MapMaker.Dummy getValue() {
            return MapMaker.Dummy.VALUE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static final class q<K, V> extends c<K, V, q<K, V>> implements StrongValueEntry<K, V, q<K, V>> {
        @NullableDecl
        private volatile V c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public static final class a<K, V> implements InternalEntryHelper<K, V, q<K, V>, WeakKeyStrongValueSegment<K, V>> {
            private static final a<?, ?> a = new a<>();

            a() {
            }

            static <K, V> a<K, V> b() {
                return (a<K, V>) a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: a */
            public q<K, V> copy(WeakKeyStrongValueSegment<K, V> weakKeyStrongValueSegment, q<K, V> qVar, @NullableDecl q<K, V> qVar2) {
                if (qVar.getKey() == null) {
                    return null;
                }
                return qVar.a(((WeakKeyStrongValueSegment) weakKeyStrongValueSegment).queueForKeys, qVar2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: c */
            public q<K, V> newEntry(WeakKeyStrongValueSegment<K, V> weakKeyStrongValueSegment, K k, int i, @NullableDecl q<K, V> qVar) {
                return new q<>(((WeakKeyStrongValueSegment) weakKeyStrongValueSegment).queueForKeys, k, i, qVar);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: d */
            public WeakKeyStrongValueSegment<K, V> newSegment(MapMakerInternalMap<K, V, q<K, V>, WeakKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i, int i2) {
                return new WeakKeyStrongValueSegment<>(mapMakerInternalMap, i, i2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: e */
            public void setValue(WeakKeyStrongValueSegment<K, V> weakKeyStrongValueSegment, q<K, V> qVar, V v) {
                qVar.b(v);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength keyStrength() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength valueStrength() {
                return Strength.STRONG;
            }
        }

        q(ReferenceQueue<K> referenceQueue, K k, int i, @NullableDecl q<K, V> qVar) {
            super(referenceQueue, k, i, qVar);
            this.c = null;
        }

        q<K, V> a(ReferenceQueue<K> referenceQueue, q<K, V> qVar) {
            q<K, V> qVar2 = new q<>(referenceQueue, getKey(), this.a, qVar);
            qVar2.b(this.c);
            return qVar2;
        }

        void b(V v) {
            this.c = v;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        @NullableDecl
        public V getValue() {
            return this.c;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static final class r<K, V> extends c<K, V, r<K, V>> implements WeakValueEntry<K, V, r<K, V>> {
        private volatile WeakValueReference<K, V, r<K, V>> c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public static final class a<K, V> implements InternalEntryHelper<K, V, r<K, V>, WeakKeyWeakValueSegment<K, V>> {
            private static final a<?, ?> a = new a<>();

            a() {
            }

            static <K, V> a<K, V> b() {
                return (a<K, V>) a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: a */
            public r<K, V> copy(WeakKeyWeakValueSegment<K, V> weakKeyWeakValueSegment, r<K, V> rVar, @NullableDecl r<K, V> rVar2) {
                if (rVar.getKey() == null || Segment.isCollected(rVar)) {
                    return null;
                }
                return rVar.c(((WeakKeyWeakValueSegment) weakKeyWeakValueSegment).queueForKeys, ((WeakKeyWeakValueSegment) weakKeyWeakValueSegment).queueForValues, rVar2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: c */
            public r<K, V> newEntry(WeakKeyWeakValueSegment<K, V> weakKeyWeakValueSegment, K k, int i, @NullableDecl r<K, V> rVar) {
                return new r<>(((WeakKeyWeakValueSegment) weakKeyWeakValueSegment).queueForKeys, k, i, rVar);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: d */
            public WeakKeyWeakValueSegment<K, V> newSegment(MapMakerInternalMap<K, V, r<K, V>, WeakKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i, int i2) {
                return new WeakKeyWeakValueSegment<>(mapMakerInternalMap, i, i2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: e */
            public void setValue(WeakKeyWeakValueSegment<K, V> weakKeyWeakValueSegment, r<K, V> rVar, V v) {
                rVar.d(v, ((WeakKeyWeakValueSegment) weakKeyWeakValueSegment).queueForValues);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength keyStrength() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength valueStrength() {
                return Strength.WEAK;
            }
        }

        r(ReferenceQueue<K> referenceQueue, K k, int i, @NullableDecl r<K, V> rVar) {
            super(referenceQueue, k, i, rVar);
            this.c = MapMakerInternalMap.unsetWeakValueReference();
        }

        r<K, V> c(ReferenceQueue<K> referenceQueue, ReferenceQueue<V> referenceQueue2, r<K, V> rVar) {
            r<K, V> rVar2 = new r<>(referenceQueue, getKey(), this.a, rVar);
            rVar2.c = this.c.copyFor(referenceQueue2, rVar2);
            return rVar2;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueEntry
        public void clearValue() {
            this.c.clear();
        }

        void d(V v, ReferenceQueue<V> referenceQueue) {
            WeakValueReference<K, V, r<K, V>> weakValueReference = this.c;
            this.c = new s(referenceQueue, v, this);
            weakValueReference.clear();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public V getValue() {
            return this.c.get();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueEntry
        public WeakValueReference<K, V, r<K, V>> getValueReference() {
            return this.c;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static final class s<K, V, E extends InternalEntry<K, V, E>> extends WeakReference<V> implements WeakValueReference<K, V, E> {
        @Weak
        final E a;

        s(ReferenceQueue<V> referenceQueue, V v, E e) {
            super(v, referenceQueue);
            this.a = e;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueReference
        public WeakValueReference<K, V, E> copyFor(ReferenceQueue<V> referenceQueue, E e) {
            return new s(referenceQueue, get(), e);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueReference
        public E getEntry() {
            return this.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public final class t extends com.google.common.collect.b<K, V> {
        final K a;
        V b;

        t(K k, V v) {
            this.a = k;
            this.b = v;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                return this.a.equals(entry.getKey()) && this.b.equals(entry.getValue());
            }
            return false;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public K getKey() {
            return this.a;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public V getValue() {
            return this.b;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public int hashCode() {
            return this.a.hashCode() ^ this.b.hashCode();
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public V setValue(V v) {
            V v2 = (V) MapMakerInternalMap.this.put(this.a, v);
            this.b = v;
            return v2;
        }
    }

    private MapMakerInternalMap(MapMaker mapMaker, InternalEntryHelper<K, V, E, S> internalEntryHelper) {
        this.concurrencyLevel = Math.min(mapMaker.b(), 65536);
        this.keyEquivalence = mapMaker.d();
        this.entryHelper = internalEntryHelper;
        int min = Math.min(mapMaker.c(), 1073741824);
        int i2 = 0;
        int i3 = 1;
        int i4 = 1;
        int i5 = 0;
        while (i4 < this.concurrencyLevel) {
            i5++;
            i4 <<= 1;
        }
        this.segmentShift = 32 - i5;
        this.segmentMask = i4 - 1;
        this.segments = newSegmentArray(i4);
        int i6 = min / i4;
        while (i3 < (i4 * i6 < min ? i6 + 1 : i6)) {
            i3 <<= 1;
        }
        while (true) {
            Segment<K, V, E, S>[] segmentArr = this.segments;
            if (i2 >= segmentArr.length) {
                return;
            }
            segmentArr[i2] = createSegment(i3, -1);
            i2++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> MapMakerInternalMap<K, V, ? extends InternalEntry<K, V, ?>, ?> create(MapMaker mapMaker) {
        Strength e2 = mapMaker.e();
        Strength strength = Strength.STRONG;
        if (e2 == strength && mapMaker.f() == strength) {
            return new MapMakerInternalMap<>(mapMaker, l.a.b());
        }
        if (mapMaker.e() == strength && mapMaker.f() == Strength.WEAK) {
            return new MapMakerInternalMap<>(mapMaker, m.a.b());
        }
        Strength e3 = mapMaker.e();
        Strength strength2 = Strength.WEAK;
        if (e3 == strength2 && mapMaker.f() == strength) {
            return new MapMakerInternalMap<>(mapMaker, q.a.b());
        }
        if (mapMaker.e() == strength2 && mapMaker.f() == strength2) {
            return new MapMakerInternalMap<>(mapMaker, r.a.b());
        }
        throw new AssertionError();
    }

    static <K> MapMakerInternalMap<K, MapMaker.Dummy, ? extends InternalEntry<K, MapMaker.Dummy, ?>, ?> createWithDummyValues(MapMaker mapMaker) {
        Strength e2 = mapMaker.e();
        Strength strength = Strength.STRONG;
        if (e2 == strength && mapMaker.f() == strength) {
            return new MapMakerInternalMap<>(mapMaker, k.a.b());
        }
        Strength e3 = mapMaker.e();
        Strength strength2 = Strength.WEAK;
        if (e3 == strength2 && mapMaker.f() == strength) {
            return new MapMakerInternalMap<>(mapMaker, p.a.b());
        }
        if (mapMaker.f() == strength2) {
            throw new IllegalArgumentException("Map cannot have both weak and dummy values");
        }
        throw new AssertionError();
    }

    static int rehash(int i2) {
        int i3 = i2 + ((i2 << 15) ^ (-12931));
        int i4 = i3 ^ (i3 >>> 10);
        int i5 = i4 + (i4 << 3);
        int i6 = i5 ^ (i5 >>> 6);
        int i7 = i6 + (i6 << 2) + (i6 << 14);
        return i7 ^ (i7 >>> 16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> ArrayList<E> toArrayList(Collection<E> collection) {
        ArrayList<E> arrayList = new ArrayList<>(collection.size());
        Iterators.a(arrayList, collection.iterator());
        return arrayList;
    }

    static <K, V, E extends InternalEntry<K, V, E>> WeakValueReference<K, V, E> unsetWeakValueReference() {
        return (WeakValueReference<K, V, E>) UNSET_WEAK_VALUE_REFERENCE;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        for (Segment<K, V, E, S> segment : this.segments) {
            segment.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@NullableDecl Object obj) {
        if (obj == null) {
            return false;
        }
        int hash = hash(obj);
        return segmentFor(hash).containsKey(obj, hash);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@NullableDecl Object obj) {
        if (obj == null) {
            return false;
        }
        Segment<K, V, E, S>[] segmentArr = this.segments;
        long j2 = -1;
        int i2 = 0;
        while (i2 < 3) {
            long j3 = 0;
            for (StrongKeyDummyValueSegment strongKeyDummyValueSegment : segmentArr) {
                int i3 = strongKeyDummyValueSegment.count;
                AtomicReferenceArray<E> atomicReferenceArray = strongKeyDummyValueSegment.table;
                for (int i4 = 0; i4 < atomicReferenceArray.length(); i4++) {
                    for (E e2 = atomicReferenceArray.get(i4); e2 != null; e2 = e2.getNext()) {
                        Object liveValue = strongKeyDummyValueSegment.getLiveValue(e2);
                        if (liveValue != null && valueEquivalence().equivalent(obj, liveValue)) {
                            return true;
                        }
                    }
                }
                j3 += strongKeyDummyValueSegment.modCount;
            }
            if (j3 == j2) {
                return false;
            }
            i2++;
            j2 = j3;
        }
        return false;
    }

    @VisibleForTesting
    E copyEntry(E e2, E e3) {
        return segmentFor(e2.getHash()).copyEntry(e2, e3);
    }

    Segment<K, V, E, S> createSegment(int i2, int i3) {
        return (S) this.entryHelper.newSegment(this, i2, i3);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        f fVar = new f();
        this.entrySet = fVar;
        return fVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(@NullableDecl Object obj) {
        if (obj == null) {
            return null;
        }
        int hash = hash(obj);
        return segmentFor(hash).get(obj, hash);
    }

    E getEntry(@NullableDecl Object obj) {
        if (obj == null) {
            return null;
        }
        int hash = hash(obj);
        return segmentFor(hash).getEntry(obj, hash);
    }

    V getLiveValue(E e2) {
        if (e2.getKey() == null) {
            return null;
        }
        return (V) e2.getValue();
    }

    int hash(Object obj) {
        return rehash(this.keyEquivalence.hash(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        Segment<K, V, E, S>[] segmentArr = this.segments;
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

    @VisibleForTesting
    boolean isLiveForTesting(InternalEntry<K, V, ?> internalEntry) {
        return segmentFor(internalEntry.getHash()).getLiveValueForTesting(internalEntry) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        i iVar = new i();
        this.keySet = iVar;
        return iVar;
    }

    @VisibleForTesting
    Strength keyStrength() {
        return this.entryHelper.keyStrength();
    }

    final Segment<K, V, E, S>[] newSegmentArray(int i2) {
        return new Segment[i2];
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    public V put(K k2, V v) {
        du1.p(k2);
        du1.p(v);
        int hash = hash(k2);
        return segmentFor(hash).put(k2, hash, v, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public V putIfAbsent(K k2, V v) {
        du1.p(k2);
        du1.p(v);
        int hash = hash(k2);
        return segmentFor(hash).put(k2, hash, v, true);
    }

    void reclaimKey(E e2) {
        int hash = e2.getHash();
        segmentFor(hash).reclaimKey(e2, hash);
    }

    void reclaimValue(WeakValueReference<K, V, E> weakValueReference) {
        E entry = weakValueReference.getEntry();
        int hash = entry.getHash();
        segmentFor(hash).reclaimValue((K) entry.getKey(), hash, weakValueReference);
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    public V remove(@NullableDecl Object obj) {
        if (obj == null) {
            return null;
        }
        int hash = hash(obj);
        return segmentFor(hash).remove(obj, hash);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public boolean replace(K k2, @NullableDecl V v, V v2) {
        du1.p(k2);
        du1.p(v2);
        if (v == null) {
            return false;
        }
        int hash = hash(k2);
        return segmentFor(hash).replace(k2, hash, v, v2);
    }

    Segment<K, V, E, S> segmentFor(int i2) {
        return this.segments[(i2 >>> this.segmentShift) & this.segmentMask];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        long j2 = 0;
        for (Segment<K, V, E, S> segment : this.segments) {
            j2 += segment.count;
        }
        return Ints.j(j2);
    }

    @VisibleForTesting
    Equivalence<Object> valueEquivalence() {
        return this.entryHelper.valueStrength().defaultEquivalence();
    }

    @VisibleForTesting
    Strength valueStrength() {
        return this.entryHelper.valueStrength();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.values;
        if (collection != null) {
            return collection;
        }
        o oVar = new o();
        this.values = oVar;
        return oVar;
    }

    Object writeReplace() {
        return new SerializationProxy(this.entryHelper.keyStrength(), this.entryHelper.valueStrength(), this.keyEquivalence, this.entryHelper.valueStrength().defaultEquivalence(), this.concurrencyLevel, this);
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static abstract class AbstractSerializationProxy<K, V> extends com.google.common.collect.p<K, V> implements Serializable {
        private static final long serialVersionUID = 3;
        final int concurrencyLevel;
        transient ConcurrentMap<K, V> delegate;
        final Equivalence<Object> keyEquivalence;
        final Strength keyStrength;
        final Equivalence<Object> valueEquivalence;
        final Strength valueStrength;

        AbstractSerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, int i, ConcurrentMap<K, V> concurrentMap) {
            this.keyStrength = strength;
            this.valueStrength = strength2;
            this.keyEquivalence = equivalence;
            this.valueEquivalence = equivalence2;
            this.concurrencyLevel = i;
            this.delegate = concurrentMap;
        }

        /* JADX WARN: Multi-variable type inference failed */
        void readEntries(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            while (true) {
                Object readObject = objectInputStream.readObject();
                if (readObject == null) {
                    return;
                }
                this.delegate.put(readObject, objectInputStream.readObject());
            }
        }

        MapMaker readMapMaker(ObjectInputStream objectInputStream) throws IOException {
            return new MapMaker().g(objectInputStream.readInt()).j(this.keyStrength).k(this.valueStrength).h(this.keyEquivalence).a(this.concurrencyLevel);
        }

        void writeMapTo(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeInt(this.delegate.size());
            for (Map.Entry<K, V> entry : this.delegate.entrySet()) {
                objectOutputStream.writeObject(entry.getKey());
                objectOutputStream.writeObject(entry.getValue());
            }
            objectOutputStream.writeObject(null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.p, com.google.common.collect.q, com.google.common.collect.t
        public ConcurrentMap<K, V> delegate() {
            return this.delegate;
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public boolean remove(@NullableDecl Object obj, @NullableDecl Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        int hash = hash(obj);
        return segmentFor(hash).remove(obj, hash, obj2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public V replace(K k2, V v) {
        du1.p(k2);
        du1.p(v);
        int hash = hash(k2);
        return segmentFor(hash).replace(k2, hash, v);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static abstract class Segment<K, V, E extends InternalEntry<K, V, E>, S extends Segment<K, V, E, S>> extends ReentrantLock {
        volatile int count;
        @Weak
        final MapMakerInternalMap<K, V, E, S> map;
        final int maxSegmentSize;
        int modCount;
        final AtomicInteger readCount = new AtomicInteger();
        @MonotonicNonNullDecl
        volatile AtomicReferenceArray<E> table;
        int threshold;

        Segment(MapMakerInternalMap<K, V, E, S> mapMakerInternalMap, int i, int i2) {
            this.map = mapMakerInternalMap;
            this.maxSegmentSize = i2;
            initTable(newEntryArray(i));
        }

        static <K, V, E extends InternalEntry<K, V, E>> boolean isCollected(E e) {
            return e.getValue() == null;
        }

        abstract E castForTesting(InternalEntry<K, V, ?> internalEntry);

        void clear() {
            if (this.count != 0) {
                lock();
                try {
                    AtomicReferenceArray<E> atomicReferenceArray = this.table;
                    for (int i = 0; i < atomicReferenceArray.length(); i++) {
                        atomicReferenceArray.set(i, null);
                    }
                    maybeClearReferenceQueues();
                    this.readCount.set(0);
                    this.modCount++;
                    this.count = 0;
                } finally {
                    unlock();
                }
            }
        }

        <T> void clearReferenceQueue(ReferenceQueue<T> referenceQueue) {
            do {
            } while (referenceQueue.poll() != null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        boolean clearValueForTesting(K k, int i, WeakValueReference<K, V, ? extends InternalEntry<K, V, ?>> weakValueReference) {
            lock();
            try {
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                E e = atomicReferenceArray.get(length);
                for (InternalEntry internalEntry = e; internalEntry != null; internalEntry = internalEntry.getNext()) {
                    Object key = internalEntry.getKey();
                    if (internalEntry.getHash() == i && key != null && this.map.keyEquivalence.equivalent(k, key)) {
                        if (((WeakValueEntry) internalEntry).getValueReference() == weakValueReference) {
                            atomicReferenceArray.set(length, removeFromChain(e, internalEntry));
                            return true;
                        }
                        return false;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        boolean containsKey(Object obj, int i) {
            try {
                boolean z = false;
                if (this.count != 0) {
                    E liveEntry = getLiveEntry(obj, i);
                    if (liveEntry != null) {
                        if (liveEntry.getValue() != null) {
                            z = true;
                        }
                    }
                    return z;
                }
                return false;
            } finally {
                postReadCleanup();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @VisibleForTesting
        boolean containsValue(Object obj) {
            try {
                if (this.count != 0) {
                    AtomicReferenceArray<E> atomicReferenceArray = this.table;
                    int length = atomicReferenceArray.length();
                    for (int i = 0; i < length; i++) {
                        for (E e = atomicReferenceArray.get(i); e != null; e = e.getNext()) {
                            Object liveValue = getLiveValue(e);
                            if (liveValue != null && this.map.valueEquivalence().equivalent(obj, liveValue)) {
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

        E copyEntry(E e, E e2) {
            return this.map.entryHelper.copy(self(), e, e2);
        }

        E copyForTesting(InternalEntry<K, V, ?> internalEntry, @NullableDecl InternalEntry<K, V, ?> internalEntry2) {
            return this.map.entryHelper.copy(self(), castForTesting(internalEntry), castForTesting(internalEntry2));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @GuardedBy("this")
        void drainKeyReferenceQueue(ReferenceQueue<K> referenceQueue) {
            int i = 0;
            do {
                Reference<? extends K> poll = referenceQueue.poll();
                if (poll == null) {
                    return;
                }
                this.map.reclaimKey((InternalEntry) poll);
                i++;
            } while (i != 16);
        }

        @GuardedBy("this")
        void drainValueReferenceQueue(ReferenceQueue<V> referenceQueue) {
            int i = 0;
            do {
                Reference<? extends V> poll = referenceQueue.poll();
                if (poll == null) {
                    return;
                }
                this.map.reclaimValue((WeakValueReference) poll);
                i++;
            } while (i != 16);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @GuardedBy("this")
        void expand() {
            AtomicReferenceArray<E> atomicReferenceArray = this.table;
            int length = atomicReferenceArray.length();
            if (length >= 1073741824) {
                return;
            }
            int i = this.count;
            AtomicReferenceArray<E> atomicReferenceArray2 = (AtomicReferenceArray<E>) newEntryArray(length << 1);
            this.threshold = (atomicReferenceArray2.length() * 3) / 4;
            int length2 = atomicReferenceArray2.length() - 1;
            for (int i2 = 0; i2 < length; i2++) {
                E e = atomicReferenceArray.get(i2);
                if (e != null) {
                    InternalEntry next = e.getNext();
                    int hash = e.getHash() & length2;
                    if (next == null) {
                        atomicReferenceArray2.set(hash, e);
                    } else {
                        InternalEntry internalEntry = e;
                        while (next != null) {
                            int hash2 = next.getHash() & length2;
                            if (hash2 != hash) {
                                internalEntry = next;
                                hash = hash2;
                            }
                            next = next.getNext();
                        }
                        atomicReferenceArray2.set(hash, internalEntry);
                        while (e != internalEntry) {
                            int hash3 = e.getHash() & length2;
                            InternalEntry copyEntry = copyEntry(e, (InternalEntry) atomicReferenceArray2.get(hash3));
                            if (copyEntry != null) {
                                atomicReferenceArray2.set(hash3, copyEntry);
                            } else {
                                i--;
                            }
                            e = e.getNext();
                        }
                    }
                }
            }
            this.table = atomicReferenceArray2;
            this.count = i;
        }

        V get(Object obj, int i) {
            try {
                E liveEntry = getLiveEntry(obj, i);
                if (liveEntry == null) {
                    return null;
                }
                V v = (V) liveEntry.getValue();
                if (v == null) {
                    tryDrainReferenceQueues();
                }
                return v;
            } finally {
                postReadCleanup();
            }
        }

        E getEntry(Object obj, int i) {
            if (this.count != 0) {
                for (E first = getFirst(i); first != null; first = (E) first.getNext()) {
                    if (first.getHash() == i) {
                        Object key = first.getKey();
                        if (key == null) {
                            tryDrainReferenceQueues();
                        } else if (this.map.keyEquivalence.equivalent(obj, key)) {
                            return first;
                        }
                    }
                }
                return null;
            }
            return null;
        }

        E getFirst(int i) {
            AtomicReferenceArray<E> atomicReferenceArray = this.table;
            return atomicReferenceArray.get(i & (atomicReferenceArray.length() - 1));
        }

        ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            throw new AssertionError();
        }

        E getLiveEntry(Object obj, int i) {
            return getEntry(obj, i);
        }

        @NullableDecl
        V getLiveValue(E e) {
            if (e.getKey() == null) {
                tryDrainReferenceQueues();
                return null;
            }
            V v = (V) e.getValue();
            if (v == null) {
                tryDrainReferenceQueues();
                return null;
            }
            return v;
        }

        @NullableDecl
        V getLiveValueForTesting(InternalEntry<K, V, ?> internalEntry) {
            return getLiveValue(castForTesting(internalEntry));
        }

        ReferenceQueue<V> getValueReferenceQueueForTesting() {
            throw new AssertionError();
        }

        WeakValueReference<K, V, E> getWeakValueReferenceForTesting(InternalEntry<K, V, ?> internalEntry) {
            throw new AssertionError();
        }

        void initTable(AtomicReferenceArray<E> atomicReferenceArray) {
            int length = (atomicReferenceArray.length() * 3) / 4;
            this.threshold = length;
            if (length == this.maxSegmentSize) {
                this.threshold = length + 1;
            }
            this.table = atomicReferenceArray;
        }

        void maybeClearReferenceQueues() {
        }

        @GuardedBy("this")
        void maybeDrainReferenceQueues() {
        }

        AtomicReferenceArray<E> newEntryArray(int i) {
            return new AtomicReferenceArray<>(i);
        }

        E newEntryForTesting(K k, int i, @NullableDecl InternalEntry<K, V, ?> internalEntry) {
            return this.map.entryHelper.newEntry(self(), k, i, castForTesting(internalEntry));
        }

        WeakValueReference<K, V, E> newWeakValueReferenceForTesting(InternalEntry<K, V, ?> internalEntry, V v) {
            throw new AssertionError();
        }

        void postReadCleanup() {
            if ((this.readCount.incrementAndGet() & 63) == 0) {
                runCleanup();
            }
        }

        @GuardedBy("this")
        void preWriteCleanup() {
            runLockedCleanup();
        }

        /* JADX WARN: Multi-variable type inference failed */
        V put(K k, int i, V v, boolean z) {
            lock();
            try {
                preWriteCleanup();
                int i2 = this.count + 1;
                if (i2 > this.threshold) {
                    expand();
                    i2 = this.count + 1;
                }
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                E e = atomicReferenceArray.get(length);
                for (InternalEntry internalEntry = e; internalEntry != null; internalEntry = internalEntry.getNext()) {
                    Object key = internalEntry.getKey();
                    if (internalEntry.getHash() == i && key != null && this.map.keyEquivalence.equivalent(k, key)) {
                        V v2 = (V) internalEntry.getValue();
                        if (v2 == null) {
                            this.modCount++;
                            setValue(internalEntry, v);
                            this.count = this.count;
                            return null;
                        } else if (z) {
                            return v2;
                        } else {
                            this.modCount++;
                            setValue(internalEntry, v);
                            return v2;
                        }
                    }
                }
                this.modCount++;
                E newEntry = this.map.entryHelper.newEntry(self(), k, i, e);
                setValue(newEntry, v);
                atomicReferenceArray.set(length, newEntry);
                this.count = i2;
                return null;
            } finally {
                unlock();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        boolean reclaimKey(E e, int i) {
            lock();
            try {
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                E e2 = atomicReferenceArray.get(length);
                for (InternalEntry internalEntry = e2; internalEntry != null; internalEntry = internalEntry.getNext()) {
                    if (internalEntry == e) {
                        this.modCount++;
                        atomicReferenceArray.set(length, removeFromChain(e2, internalEntry));
                        this.count--;
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        boolean reclaimValue(K k, int i, WeakValueReference<K, V, E> weakValueReference) {
            lock();
            try {
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                E e = atomicReferenceArray.get(length);
                for (InternalEntry internalEntry = e; internalEntry != null; internalEntry = internalEntry.getNext()) {
                    Object key = internalEntry.getKey();
                    if (internalEntry.getHash() == i && key != null && this.map.keyEquivalence.equivalent(k, key)) {
                        if (((WeakValueEntry) internalEntry).getValueReference() == weakValueReference) {
                            this.modCount++;
                            atomicReferenceArray.set(length, removeFromChain(e, internalEntry));
                            this.count--;
                            return true;
                        }
                        return false;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        V remove(Object obj, int i) {
            lock();
            try {
                preWriteCleanup();
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                E e = atomicReferenceArray.get(length);
                for (InternalEntry internalEntry = e; internalEntry != null; internalEntry = internalEntry.getNext()) {
                    Object key = internalEntry.getKey();
                    if (internalEntry.getHash() == i && key != null && this.map.keyEquivalence.equivalent(obj, key)) {
                        V v = (V) internalEntry.getValue();
                        if (v == null && !isCollected(internalEntry)) {
                            return null;
                        }
                        this.modCount++;
                        atomicReferenceArray.set(length, removeFromChain(e, internalEntry));
                        this.count--;
                        return v;
                    }
                }
                return null;
            } finally {
                unlock();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @GuardedBy("this")
        boolean removeEntryForTesting(E e) {
            int hash = e.getHash();
            AtomicReferenceArray<E> atomicReferenceArray = this.table;
            int length = hash & (atomicReferenceArray.length() - 1);
            E e2 = atomicReferenceArray.get(length);
            for (InternalEntry internalEntry = e2; internalEntry != null; internalEntry = internalEntry.getNext()) {
                if (internalEntry == e) {
                    this.modCount++;
                    atomicReferenceArray.set(length, removeFromChain(e2, internalEntry));
                    this.count--;
                    return true;
                }
            }
            return false;
        }

        @GuardedBy("this")
        E removeFromChain(E e, E e2) {
            int i = this.count;
            E e3 = (E) e2.getNext();
            while (e != e2) {
                E copyEntry = copyEntry(e, e3);
                if (copyEntry != null) {
                    e3 = copyEntry;
                } else {
                    i--;
                }
                e = (E) e.getNext();
            }
            this.count = i;
            return e3;
        }

        E removeFromChainForTesting(InternalEntry<K, V, ?> internalEntry, InternalEntry<K, V, ?> internalEntry2) {
            return removeFromChain(castForTesting(internalEntry), castForTesting(internalEntry2));
        }

        @CanIgnoreReturnValue
        boolean removeTableEntryForTesting(InternalEntry<K, V, ?> internalEntry) {
            return removeEntryForTesting(castForTesting(internalEntry));
        }

        /* JADX WARN: Multi-variable type inference failed */
        boolean replace(K k, int i, V v, V v2) {
            lock();
            try {
                preWriteCleanup();
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                E e = atomicReferenceArray.get(length);
                for (InternalEntry internalEntry = e; internalEntry != null; internalEntry = internalEntry.getNext()) {
                    Object key = internalEntry.getKey();
                    if (internalEntry.getHash() == i && key != null && this.map.keyEquivalence.equivalent(k, key)) {
                        Object value = internalEntry.getValue();
                        if (value == null) {
                            if (isCollected(internalEntry)) {
                                this.modCount++;
                                atomicReferenceArray.set(length, removeFromChain(e, internalEntry));
                                this.count--;
                            }
                            return false;
                        } else if (this.map.valueEquivalence().equivalent(v, value)) {
                            this.modCount++;
                            setValue(internalEntry, v2);
                            return true;
                        } else {
                            return false;
                        }
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        void runCleanup() {
            runLockedCleanup();
        }

        void runLockedCleanup() {
            if (tryLock()) {
                try {
                    maybeDrainReferenceQueues();
                    this.readCount.set(0);
                } finally {
                    unlock();
                }
            }
        }

        abstract S self();

        void setTableEntryForTesting(int i, InternalEntry<K, V, ?> internalEntry) {
            this.table.set(i, castForTesting(internalEntry));
        }

        void setValue(E e, V v) {
            this.map.entryHelper.setValue(self(), e, v);
        }

        void setValueForTesting(InternalEntry<K, V, ?> internalEntry, V v) {
            this.map.entryHelper.setValue(self(), castForTesting(internalEntry), v);
        }

        void setWeakValueReferenceForTesting(InternalEntry<K, V, ?> internalEntry, WeakValueReference<K, V, ? extends InternalEntry<K, V, ?>> weakValueReference) {
            throw new AssertionError();
        }

        void tryDrainReferenceQueues() {
            if (tryLock()) {
                try {
                    maybeDrainReferenceQueues();
                } finally {
                    unlock();
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x003d, code lost:
            if (r8.map.valueEquivalence().equivalent(r11, r4.getValue()) == false) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x003f, code lost:
            r5 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0045, code lost:
            if (isCollected(r4) == false) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0047, code lost:
            r8.modCount++;
            r0.set(r1, removeFromChain(r3, r4));
            r8.count--;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x005b, code lost:
            return r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x005f, code lost:
            return false;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        boolean remove(java.lang.Object r9, int r10, java.lang.Object r11) {
            /*
                r8 = this;
                r8.lock()
                r8.preWriteCleanup()     // Catch: java.lang.Throwable -> L69
                java.util.concurrent.atomic.AtomicReferenceArray<E extends com.google.common.collect.MapMakerInternalMap$InternalEntry<K, V, E>> r0 = r8.table     // Catch: java.lang.Throwable -> L69
                int r1 = r0.length()     // Catch: java.lang.Throwable -> L69
                r2 = 1
                int r1 = r1 - r2
                r1 = r1 & r10
                java.lang.Object r3 = r0.get(r1)     // Catch: java.lang.Throwable -> L69
                com.google.common.collect.MapMakerInternalMap$InternalEntry r3 = (com.google.common.collect.MapMakerInternalMap.InternalEntry) r3     // Catch: java.lang.Throwable -> L69
                r4 = r3
            L16:
                r5 = 0
                if (r4 == 0) goto L65
                java.lang.Object r6 = r4.getKey()     // Catch: java.lang.Throwable -> L69
                int r7 = r4.getHash()     // Catch: java.lang.Throwable -> L69
                if (r7 != r10) goto L60
                if (r6 == 0) goto L60
                com.google.common.collect.MapMakerInternalMap<K, V, E extends com.google.common.collect.MapMakerInternalMap$InternalEntry<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> r7 = r8.map     // Catch: java.lang.Throwable -> L69
                com.google.common.base.Equivalence<java.lang.Object> r7 = r7.keyEquivalence     // Catch: java.lang.Throwable -> L69
                boolean r6 = r7.equivalent(r9, r6)     // Catch: java.lang.Throwable -> L69
                if (r6 == 0) goto L60
                java.lang.Object r9 = r4.getValue()     // Catch: java.lang.Throwable -> L69
                com.google.common.collect.MapMakerInternalMap<K, V, E extends com.google.common.collect.MapMakerInternalMap$InternalEntry<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> r10 = r8.map     // Catch: java.lang.Throwable -> L69
                com.google.common.base.Equivalence r10 = r10.valueEquivalence()     // Catch: java.lang.Throwable -> L69
                boolean r9 = r10.equivalent(r11, r9)     // Catch: java.lang.Throwable -> L69
                if (r9 == 0) goto L41
                r5 = 1
                goto L47
            L41:
                boolean r9 = isCollected(r4)     // Catch: java.lang.Throwable -> L69
                if (r9 == 0) goto L5c
            L47:
                int r9 = r8.modCount     // Catch: java.lang.Throwable -> L69
                int r9 = r9 + r2
                r8.modCount = r9     // Catch: java.lang.Throwable -> L69
                com.google.common.collect.MapMakerInternalMap$InternalEntry r9 = r8.removeFromChain(r3, r4)     // Catch: java.lang.Throwable -> L69
                int r10 = r8.count     // Catch: java.lang.Throwable -> L69
                int r10 = r10 - r2
                r0.set(r1, r9)     // Catch: java.lang.Throwable -> L69
                r8.count = r10     // Catch: java.lang.Throwable -> L69
                r8.unlock()
                return r5
            L5c:
                r8.unlock()
                return r5
            L60:
                com.google.common.collect.MapMakerInternalMap$InternalEntry r4 = r4.getNext()     // Catch: java.lang.Throwable -> L69
                goto L16
            L65:
                r8.unlock()
                return r5
            L69:
                r9 = move-exception
                r8.unlock()
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.MapMakerInternalMap.Segment.remove(java.lang.Object, int, java.lang.Object):boolean");
        }

        /* JADX WARN: Multi-variable type inference failed */
        V replace(K k, int i, V v) {
            lock();
            try {
                preWriteCleanup();
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                E e = atomicReferenceArray.get(length);
                for (InternalEntry internalEntry = e; internalEntry != null; internalEntry = internalEntry.getNext()) {
                    Object key = internalEntry.getKey();
                    if (internalEntry.getHash() == i && key != null && this.map.keyEquivalence.equivalent(k, key)) {
                        V v2 = (V) internalEntry.getValue();
                        if (v2 == null) {
                            if (isCollected(internalEntry)) {
                                this.modCount++;
                                atomicReferenceArray.set(length, removeFromChain(e, internalEntry));
                                this.count--;
                            }
                            return null;
                        }
                        this.modCount++;
                        setValue(internalEntry, v);
                        return v2;
                    }
                }
                return null;
            } finally {
                unlock();
            }
        }
    }
}
