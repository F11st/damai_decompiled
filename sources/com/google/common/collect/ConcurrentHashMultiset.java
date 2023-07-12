package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Multiset;
import com.google.common.collect.f0;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.du1;
import tb.fp0;

/* compiled from: Taobao */
@GwtIncompatible
/* loaded from: classes10.dex */
public final class ConcurrentHashMultiset<E> extends com.google.common.collect.d<E> implements Serializable {
    private static final long serialVersionUID = 1;
    private final transient ConcurrentMap<E, AtomicInteger> countMap;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    class b extends AbstractIterator<Multiset.Entry<E>> {
        private final Iterator<Map.Entry<E, AtomicInteger>> c;

        b() {
            this.c = ConcurrentHashMultiset.this.countMap.entrySet().iterator();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.AbstractIterator
        /* renamed from: d */
        public Multiset.Entry<E> a() {
            while (this.c.hasNext()) {
                Map.Entry<E, AtomicInteger> next = this.c.next();
                int i = next.getValue().get();
                if (i != 0) {
                    return Multisets.g(next.getKey(), i);
                }
            }
            return b();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    class c extends fp0<Multiset.Entry<E>> {
        @NullableDecl
        private Multiset.Entry<E> a;
        final /* synthetic */ Iterator b;

        c(Iterator it) {
            this.b = it;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.t
        /* renamed from: a */
        public Iterator<Multiset.Entry<E>> delegate() {
            return this.b;
        }

        @Override // tb.fp0, java.util.Iterator
        /* renamed from: b */
        public Multiset.Entry<E> next() {
            Multiset.Entry<E> entry = (Multiset.Entry) super.next();
            this.a = entry;
            return entry;
        }

        @Override // java.util.Iterator
        public void remove() {
            k.e(this.a != null);
            ConcurrentHashMultiset.this.setCount(this.a.getElement(), 0);
            this.a = null;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private class d extends com.google.common.collect.d<E>.b {
        private d() {
            super();
        }

        private List<Multiset.Entry<E>> c() {
            ArrayList m = Lists.m(size());
            Iterators.a(m, iterator());
            return m;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.d.b, com.google.common.collect.Multisets.d
        /* renamed from: b */
        public ConcurrentHashMultiset<E> a() {
            return ConcurrentHashMultiset.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return c().toArray();
        }

        /* synthetic */ d(ConcurrentHashMultiset concurrentHashMultiset, a aVar) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) c().toArray(tArr);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private static class e {
        static final f0.b<ConcurrentHashMultiset> a = f0.a(ConcurrentHashMultiset.class, "countMap");
    }

    @VisibleForTesting
    ConcurrentHashMultiset(ConcurrentMap<E, AtomicInteger> concurrentMap) {
        du1.k(concurrentMap.isEmpty(), "the backing map (%s) must be empty", concurrentMap);
        this.countMap = concurrentMap;
    }

    public static <E> ConcurrentHashMultiset<E> create() {
        return new ConcurrentHashMultiset<>(new ConcurrentHashMap());
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        e.a.b(this, (ConcurrentMap) objectInputStream.readObject());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private List<E> snapshot() {
        ArrayList m = Lists.m(size());
        for (Multiset.Entry entry : entrySet()) {
            Object element = entry.getElement();
            for (int count = entry.getCount(); count > 0; count--) {
                m.add(element);
            }
        }
        return m;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.countMap);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x005a, code lost:
        r2 = new java.util.concurrent.atomic.AtomicInteger(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0065, code lost:
        if (r4.countMap.putIfAbsent(r5, r2) == null) goto L31;
     */
    @Override // com.google.common.collect.d, com.google.common.collect.Multiset
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int add(E r5, int r6) {
        /*
            r4 = this;
            tb.du1.p(r5)
            if (r6 != 0) goto La
            int r5 = r4.count(r5)
            return r5
        La:
            java.lang.String r0 = "occurences"
            com.google.common.collect.k.d(r6, r0)
        Lf:
            java.util.concurrent.ConcurrentMap<E, java.util.concurrent.atomic.AtomicInteger> r0 = r4.countMap
            java.lang.Object r0 = com.google.common.collect.Maps.x(r0, r5)
            java.util.concurrent.atomic.AtomicInteger r0 = (java.util.concurrent.atomic.AtomicInteger) r0
            r1 = 0
            if (r0 != 0) goto L2a
            java.util.concurrent.ConcurrentMap<E, java.util.concurrent.atomic.AtomicInteger> r0 = r4.countMap
            java.util.concurrent.atomic.AtomicInteger r2 = new java.util.concurrent.atomic.AtomicInteger
            r2.<init>(r6)
            java.lang.Object r0 = r0.putIfAbsent(r5, r2)
            java.util.concurrent.atomic.AtomicInteger r0 = (java.util.concurrent.atomic.AtomicInteger) r0
            if (r0 != 0) goto L2a
            return r1
        L2a:
            int r2 = r0.get()
            if (r2 == 0) goto L5a
            int r3 = com.google.common.math.c.a(r2, r6)     // Catch: java.lang.ArithmeticException -> L3b
            boolean r3 = r0.compareAndSet(r2, r3)     // Catch: java.lang.ArithmeticException -> L3b
            if (r3 == 0) goto L2a
            return r2
        L3b:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Overflow adding "
            r0.append(r1)
            r0.append(r6)
            java.lang.String r6 = " occurrences to a count of "
            r0.append(r6)
            r0.append(r2)
            java.lang.String r6 = r0.toString()
            r5.<init>(r6)
            throw r5
        L5a:
            java.util.concurrent.atomic.AtomicInteger r2 = new java.util.concurrent.atomic.AtomicInteger
            r2.<init>(r6)
            java.util.concurrent.ConcurrentMap<E, java.util.concurrent.atomic.AtomicInteger> r3 = r4.countMap
            java.lang.Object r3 = r3.putIfAbsent(r5, r2)
            if (r3 == 0) goto L6f
            java.util.concurrent.ConcurrentMap<E, java.util.concurrent.atomic.AtomicInteger> r3 = r4.countMap
            boolean r0 = r3.replace(r5, r0, r2)
            if (r0 == 0) goto Lf
        L6f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.ConcurrentHashMultiset.add(java.lang.Object, int):int");
    }

    @Override // com.google.common.collect.d, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.countMap.clear();
    }

    @Override // com.google.common.collect.d, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ boolean contains(@NullableDecl Object obj) {
        return super.contains(obj);
    }

    @Override // com.google.common.collect.Multiset
    public int count(@NullableDecl Object obj) {
        AtomicInteger atomicInteger = (AtomicInteger) Maps.x(this.countMap, obj);
        if (atomicInteger == null) {
            return 0;
        }
        return atomicInteger.get();
    }

    @Override // com.google.common.collect.d
    Set<E> createElementSet() {
        return new a(this, this.countMap.keySet());
    }

    @Override // com.google.common.collect.d
    @Deprecated
    public Set<Multiset.Entry<E>> createEntrySet() {
        return new d(this, null);
    }

    @Override // com.google.common.collect.d
    int distinctElements() {
        return this.countMap.size();
    }

    @Override // com.google.common.collect.d
    Iterator<E> elementIterator() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.d, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set elementSet() {
        return super.elementSet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.d
    public Iterator<Multiset.Entry<E>> entryIterator() {
        return new c(new b());
    }

    @Override // com.google.common.collect.d, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.d, java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.countMap.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
    public Iterator<E> iterator() {
        return Multisets.i(this);
    }

    @Override // com.google.common.collect.d, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int remove(@NullableDecl Object obj, int i) {
        int i2;
        int max;
        if (i == 0) {
            return count(obj);
        }
        k.d(i, "occurences");
        AtomicInteger atomicInteger = (AtomicInteger) Maps.x(this.countMap, obj);
        if (atomicInteger == null) {
            return 0;
        }
        do {
            i2 = atomicInteger.get();
            if (i2 == 0) {
                return 0;
            }
            max = Math.max(0, i2 - i);
        } while (!atomicInteger.compareAndSet(i2, max));
        if (max == 0) {
            this.countMap.remove(obj, atomicInteger);
        }
        return i2;
    }

    @CanIgnoreReturnValue
    public boolean removeExactly(@NullableDecl Object obj, int i) {
        int i2;
        int i3;
        if (i == 0) {
            return true;
        }
        k.d(i, "occurences");
        AtomicInteger atomicInteger = (AtomicInteger) Maps.x(this.countMap, obj);
        if (atomicInteger == null) {
            return false;
        }
        do {
            i2 = atomicInteger.get();
            if (i2 < i) {
                return false;
            }
            i3 = i2 - i;
        } while (!atomicInteger.compareAndSet(i2, i3));
        if (i3 == 0) {
            this.countMap.remove(obj, atomicInteger);
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002c, code lost:
        if (r6 != 0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002e, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002f, code lost:
        r2 = new java.util.concurrent.atomic.AtomicInteger(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003a, code lost:
        if (r4.countMap.putIfAbsent(r5, r2) == null) goto L29;
     */
    @Override // com.google.common.collect.d, com.google.common.collect.Multiset
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int setCount(E r5, int r6) {
        /*
            r4 = this;
            tb.du1.p(r5)
            java.lang.String r0 = "count"
            com.google.common.collect.k.b(r6, r0)
        L8:
            java.util.concurrent.ConcurrentMap<E, java.util.concurrent.atomic.AtomicInteger> r0 = r4.countMap
            java.lang.Object r0 = com.google.common.collect.Maps.x(r0, r5)
            java.util.concurrent.atomic.AtomicInteger r0 = (java.util.concurrent.atomic.AtomicInteger) r0
            r1 = 0
            if (r0 != 0) goto L26
            if (r6 != 0) goto L16
            return r1
        L16:
            java.util.concurrent.ConcurrentMap<E, java.util.concurrent.atomic.AtomicInteger> r0 = r4.countMap
            java.util.concurrent.atomic.AtomicInteger r2 = new java.util.concurrent.atomic.AtomicInteger
            r2.<init>(r6)
            java.lang.Object r0 = r0.putIfAbsent(r5, r2)
            java.util.concurrent.atomic.AtomicInteger r0 = (java.util.concurrent.atomic.AtomicInteger) r0
            if (r0 != 0) goto L26
            return r1
        L26:
            int r2 = r0.get()
            if (r2 != 0) goto L45
            if (r6 != 0) goto L2f
            return r1
        L2f:
            java.util.concurrent.atomic.AtomicInteger r2 = new java.util.concurrent.atomic.AtomicInteger
            r2.<init>(r6)
            java.util.concurrent.ConcurrentMap<E, java.util.concurrent.atomic.AtomicInteger> r3 = r4.countMap
            java.lang.Object r3 = r3.putIfAbsent(r5, r2)
            if (r3 == 0) goto L44
            java.util.concurrent.ConcurrentMap<E, java.util.concurrent.atomic.AtomicInteger> r3 = r4.countMap
            boolean r0 = r3.replace(r5, r0, r2)
            if (r0 == 0) goto L8
        L44:
            return r1
        L45:
            boolean r3 = r0.compareAndSet(r2, r6)
            if (r3 == 0) goto L26
            if (r6 != 0) goto L52
            java.util.concurrent.ConcurrentMap<E, java.util.concurrent.atomic.AtomicInteger> r6 = r4.countMap
            r6.remove(r5, r0)
        L52:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.ConcurrentHashMultiset.setCount(java.lang.Object, int):int");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public int size() {
        long j = 0;
        for (AtomicInteger atomicInteger : this.countMap.values()) {
            j += atomicInteger.get();
        }
        return Ints.j(j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        return snapshot().toArray();
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    class a extends v<E> {
        final /* synthetic */ Set a;

        a(ConcurrentHashMultiset concurrentHashMultiset, Set set) {
            this.a = set;
        }

        @Override // com.google.common.collect.o, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            return obj != null && l.d(this.a, obj);
        }

        @Override // com.google.common.collect.o, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return standardContainsAll(collection);
        }

        @Override // com.google.common.collect.o, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return obj != null && l.e(this.a, obj);
        }

        @Override // com.google.common.collect.o, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return standardRemoveAll(collection);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.v, com.google.common.collect.o, com.google.common.collect.t
        public Set<E> delegate() {
            return this.a;
        }
    }

    public static <E> ConcurrentHashMultiset<E> create(Iterable<? extends E> iterable) {
        ConcurrentHashMultiset<E> create = create();
        a0.a(create, iterable);
        return create;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) snapshot().toArray(tArr);
    }

    @Beta
    public static <E> ConcurrentHashMultiset<E> create(ConcurrentMap<E, AtomicInteger> concurrentMap) {
        return new ConcurrentHashMultiset<>(concurrentMap);
    }

    @Override // com.google.common.collect.d, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public boolean setCount(E e2, int i, int i2) {
        du1.p(e2);
        k.b(i, "oldCount");
        k.b(i2, "newCount");
        AtomicInteger atomicInteger = (AtomicInteger) Maps.x(this.countMap, e2);
        if (atomicInteger == null) {
            if (i != 0) {
                return false;
            }
            return i2 == 0 || this.countMap.putIfAbsent(e2, new AtomicInteger(i2)) == null;
        }
        int i3 = atomicInteger.get();
        if (i3 == i) {
            if (i3 == 0) {
                if (i2 == 0) {
                    this.countMap.remove(e2, atomicInteger);
                    return true;
                }
                AtomicInteger atomicInteger2 = new AtomicInteger(i2);
                return this.countMap.putIfAbsent(e2, atomicInteger2) == null || this.countMap.replace(e2, atomicInteger, atomicInteger2);
            } else if (atomicInteger.compareAndSet(i3, i2)) {
                if (i2 == 0) {
                    this.countMap.remove(e2, atomicInteger);
                }
                return true;
            }
        }
        return false;
    }
}
