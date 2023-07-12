package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableCollection;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.RetainedWith;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.du1;
import tb.nm1;

/* compiled from: Taobao */
@GwtCompatible
/* loaded from: classes10.dex */
public final class HashBiMap<K, V> extends AbstractMap<K, V> implements BiMap<K, V>, Serializable {
    private static final int ABSENT = -1;
    private static final int ENDPOINT = -2;
    private transient Set<Map.Entry<K, V>> entrySet;
    @NullableDecl
    private transient int firstInInsertionOrder;
    private transient int[] hashTableKToV;
    private transient int[] hashTableVToK;
    @RetainedWith
    @MonotonicNonNullDecl
    private transient BiMap<V, K> inverse;
    private transient Set<K> keySet;
    transient K[] keys;
    @NullableDecl
    private transient int lastInInsertionOrder;
    transient int modCount;
    private transient int[] nextInBucketKToV;
    private transient int[] nextInBucketVToK;
    private transient int[] nextInInsertionOrder;
    private transient int[] prevInInsertionOrder;
    transient int size;
    private transient Set<V> valueSet;
    transient V[] values;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class Inverse<K, V> extends AbstractMap<V, K> implements BiMap<V, K>, Serializable {
        private final HashBiMap<K, V> forward;
        private transient Set<Map.Entry<V, K>> inverseEntrySet;

        Inverse(HashBiMap<K, V> hashBiMap) {
            this.forward = hashBiMap;
        }

        @GwtIncompatible("serialization")
        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            ((HashBiMap) this.forward).inverse = this;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            this.forward.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@NullableDecl Object obj) {
            return this.forward.containsValue(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsValue(@NullableDecl Object obj) {
            return this.forward.containsKey(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<V, K>> entrySet() {
            Set<Map.Entry<V, K>> set = this.inverseEntrySet;
            if (set == null) {
                d dVar = new d(this.forward);
                this.inverseEntrySet = dVar;
                return dVar;
            }
            return set;
        }

        @Override // com.google.common.collect.BiMap
        @CanIgnoreReturnValue
        @NullableDecl
        public K forcePut(@NullableDecl V v, @NullableDecl K k) {
            return this.forward.putInverse(v, k, true);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @NullableDecl
        public K get(@NullableDecl Object obj) {
            return this.forward.getInverse(obj);
        }

        @Override // com.google.common.collect.BiMap
        public BiMap<K, V> inverse() {
            return this.forward;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<V> keySet() {
            return this.forward.values();
        }

        @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.BiMap
        @CanIgnoreReturnValue
        @NullableDecl
        public K put(@NullableDecl V v, @NullableDecl K k) {
            return this.forward.putInverse(v, k, false);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CanIgnoreReturnValue
        @NullableDecl
        public K remove(@NullableDecl Object obj) {
            return this.forward.removeInverse(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.forward.size;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> values() {
            return this.forward.keySet();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public final class a extends com.google.common.collect.b<K, V> {
        @NullableDecl
        final K a;
        int b;

        a(int i) {
            this.a = HashBiMap.this.keys[i];
            this.b = i;
        }

        void a() {
            int i = this.b;
            if (i != -1) {
                HashBiMap hashBiMap = HashBiMap.this;
                if (i <= hashBiMap.size && nm1.a(hashBiMap.keys[i], this.a)) {
                    return;
                }
            }
            this.b = HashBiMap.this.findEntryByKey(this.a);
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public K getKey() {
            return this.a;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        @NullableDecl
        public V getValue() {
            a();
            int i = this.b;
            if (i == -1) {
                return null;
            }
            return HashBiMap.this.values[i];
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public V setValue(V v) {
            a();
            int i = this.b;
            if (i == -1) {
                return (V) HashBiMap.this.put(this.a, v);
            }
            V v2 = HashBiMap.this.values[i];
            if (nm1.a(v2, v)) {
                return v;
            }
            HashBiMap.this.replaceValueInEntry(this.b, v, false);
            return v2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static final class b<K, V> extends com.google.common.collect.b<V, K> {
        final HashBiMap<K, V> a;
        final V b;
        int c;

        b(HashBiMap<K, V> hashBiMap, int i) {
            this.a = hashBiMap;
            this.b = hashBiMap.values[i];
            this.c = i;
        }

        private void a() {
            int i = this.c;
            if (i != -1) {
                HashBiMap<K, V> hashBiMap = this.a;
                if (i <= hashBiMap.size && nm1.a(this.b, hashBiMap.values[i])) {
                    return;
                }
            }
            this.c = this.a.findEntryByValue(this.b);
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public V getKey() {
            return this.b;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public K getValue() {
            a();
            int i = this.c;
            if (i == -1) {
                return null;
            }
            return this.a.keys[i];
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public K setValue(K k) {
            a();
            int i = this.c;
            if (i == -1) {
                return this.a.putInverse(this.b, k, false);
            }
            K k2 = this.a.keys[i];
            if (nm1.a(k2, k)) {
                return k;
            }
            this.a.replaceKeyInEntry(this.c, k, false);
            return k2;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    final class c extends g<K, V, Map.Entry<K, V>> {
        c() {
            super(HashBiMap.this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.HashBiMap.g
        /* renamed from: b */
        public Map.Entry<K, V> a(int i) {
            return new a(i);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Object value = entry.getValue();
                int findEntryByKey = HashBiMap.this.findEntryByKey(key);
                return findEntryByKey != -1 && nm1.a(value, HashBiMap.this.values[findEntryByKey]);
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @CanIgnoreReturnValue
        public boolean remove(@NullableDecl Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Object value = entry.getValue();
                int d = z.d(key);
                int findEntryByKey = HashBiMap.this.findEntryByKey(key, d);
                if (findEntryByKey == -1 || !nm1.a(value, HashBiMap.this.values[findEntryByKey])) {
                    return false;
                }
                HashBiMap.this.removeEntryKeyHashKnown(findEntryByKey, d);
                return true;
            }
            return false;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class d<K, V> extends g<K, V, Map.Entry<V, K>> {
        d(HashBiMap<K, V> hashBiMap) {
            super(hashBiMap);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.HashBiMap.g
        /* renamed from: b */
        public Map.Entry<V, K> a(int i) {
            return new b(this.a, i);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Object value = entry.getValue();
                int findEntryByValue = this.a.findEntryByValue(key);
                return findEntryByValue != -1 && nm1.a(this.a.keys[findEntryByValue], value);
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Object value = entry.getValue();
                int d = z.d(key);
                int findEntryByValue = this.a.findEntryByValue(key, d);
                if (findEntryByValue == -1 || !nm1.a(this.a.keys[findEntryByValue], value)) {
                    return false;
                }
                this.a.removeEntryValueHashKnown(findEntryByValue, d);
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public final class e extends g<K, V, K> {
        e() {
            super(HashBiMap.this);
        }

        @Override // com.google.common.collect.HashBiMap.g
        K a(int i) {
            return HashBiMap.this.keys[i];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            return HashBiMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@NullableDecl Object obj) {
            int d = z.d(obj);
            int findEntryByKey = HashBiMap.this.findEntryByKey(obj, d);
            if (findEntryByKey != -1) {
                HashBiMap.this.removeEntryKeyHashKnown(findEntryByKey, d);
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public final class f extends g<K, V, V> {
        f() {
            super(HashBiMap.this);
        }

        @Override // com.google.common.collect.HashBiMap.g
        V a(int i) {
            return HashBiMap.this.values[i];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            return HashBiMap.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@NullableDecl Object obj) {
            int d = z.d(obj);
            int findEntryByValue = HashBiMap.this.findEntryByValue(obj, d);
            if (findEntryByValue != -1) {
                HashBiMap.this.removeEntryValueHashKnown(findEntryByValue, d);
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static abstract class g<K, V, T> extends AbstractSet<T> {
        final HashBiMap<K, V> a;

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        class a implements Iterator<T> {
            private int a;
            private int b = -1;
            private int c;
            private int d;

            a() {
                this.a = ((HashBiMap) g.this.a).firstInInsertionOrder;
                HashBiMap<K, V> hashBiMap = g.this.a;
                this.c = hashBiMap.modCount;
                this.d = hashBiMap.size;
            }

            private void a() {
                if (g.this.a.modCount != this.c) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                a();
                return this.a != -2 && this.d > 0;
            }

            @Override // java.util.Iterator
            public T next() {
                if (hasNext()) {
                    T t = (T) g.this.a(this.a);
                    this.b = this.a;
                    this.a = ((HashBiMap) g.this.a).nextInInsertionOrder[this.a];
                    this.d--;
                    return t;
                }
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public void remove() {
                a();
                k.e(this.b != -1);
                g.this.a.removeEntry(this.b);
                int i = this.a;
                HashBiMap<K, V> hashBiMap = g.this.a;
                if (i == hashBiMap.size) {
                    this.a = this.b;
                }
                this.b = -1;
                this.c = hashBiMap.modCount;
            }
        }

        g(HashBiMap<K, V> hashBiMap) {
            this.a = hashBiMap;
        }

        abstract T a(int i);

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<T> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.a.size;
        }
    }

    private HashBiMap(int i) {
        init(i);
    }

    private int bucket(int i) {
        return i & (this.hashTableKToV.length - 1);
    }

    public static <K, V> HashBiMap<K, V> create() {
        return create(16);
    }

    private static int[] createFilledWithAbsent(int i) {
        int[] iArr = new int[i];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    private void deleteFromTableKToV(int i, int i2) {
        du1.d(i != -1);
        int bucket = bucket(i2);
        int[] iArr = this.hashTableKToV;
        if (iArr[bucket] == i) {
            int[] iArr2 = this.nextInBucketKToV;
            iArr[bucket] = iArr2[i];
            iArr2[i] = -1;
            return;
        }
        int i3 = iArr[bucket];
        int i4 = this.nextInBucketKToV[i3];
        while (true) {
            int i5 = i4;
            int i6 = i3;
            i3 = i5;
            if (i3 == -1) {
                throw new AssertionError("Expected to find entry with key " + this.keys[i]);
            } else if (i3 == i) {
                int[] iArr3 = this.nextInBucketKToV;
                iArr3[i6] = iArr3[i];
                iArr3[i] = -1;
                return;
            } else {
                i4 = this.nextInBucketKToV[i3];
            }
        }
    }

    private void deleteFromTableVToK(int i, int i2) {
        du1.d(i != -1);
        int bucket = bucket(i2);
        int[] iArr = this.hashTableVToK;
        if (iArr[bucket] == i) {
            int[] iArr2 = this.nextInBucketVToK;
            iArr[bucket] = iArr2[i];
            iArr2[i] = -1;
            return;
        }
        int i3 = iArr[bucket];
        int i4 = this.nextInBucketVToK[i3];
        while (true) {
            int i5 = i4;
            int i6 = i3;
            i3 = i5;
            if (i3 == -1) {
                throw new AssertionError("Expected to find entry with value " + this.values[i]);
            } else if (i3 == i) {
                int[] iArr3 = this.nextInBucketVToK;
                iArr3[i6] = iArr3[i];
                iArr3[i] = -1;
                return;
            } else {
                i4 = this.nextInBucketVToK[i3];
            }
        }
    }

    private void ensureCapacity(int i) {
        int[] iArr = this.nextInBucketKToV;
        if (iArr.length < i) {
            int e2 = ImmutableCollection.b.e(iArr.length, i);
            this.keys = (K[]) Arrays.copyOf(this.keys, e2);
            this.values = (V[]) Arrays.copyOf(this.values, e2);
            this.nextInBucketKToV = expandAndFillWithAbsent(this.nextInBucketKToV, e2);
            this.nextInBucketVToK = expandAndFillWithAbsent(this.nextInBucketVToK, e2);
            this.prevInInsertionOrder = expandAndFillWithAbsent(this.prevInInsertionOrder, e2);
            this.nextInInsertionOrder = expandAndFillWithAbsent(this.nextInInsertionOrder, e2);
        }
        if (this.hashTableKToV.length < i) {
            int a2 = z.a(i, 1.0d);
            this.hashTableKToV = createFilledWithAbsent(a2);
            this.hashTableVToK = createFilledWithAbsent(a2);
            for (int i2 = 0; i2 < this.size; i2++) {
                int bucket = bucket(z.d(this.keys[i2]));
                int[] iArr2 = this.nextInBucketKToV;
                int[] iArr3 = this.hashTableKToV;
                iArr2[i2] = iArr3[bucket];
                iArr3[bucket] = i2;
                int bucket2 = bucket(z.d(this.values[i2]));
                int[] iArr4 = this.nextInBucketVToK;
                int[] iArr5 = this.hashTableVToK;
                iArr4[i2] = iArr5[bucket2];
                iArr5[bucket2] = i2;
            }
        }
    }

    private static int[] expandAndFillWithAbsent(int[] iArr, int i) {
        int length = iArr.length;
        int[] copyOf = Arrays.copyOf(iArr, i);
        Arrays.fill(copyOf, length, i, -1);
        return copyOf;
    }

    private void insertIntoTableKToV(int i, int i2) {
        du1.d(i != -1);
        int bucket = bucket(i2);
        int[] iArr = this.nextInBucketKToV;
        int[] iArr2 = this.hashTableKToV;
        iArr[i] = iArr2[bucket];
        iArr2[bucket] = i;
    }

    private void insertIntoTableVToK(int i, int i2) {
        du1.d(i != -1);
        int bucket = bucket(i2);
        int[] iArr = this.nextInBucketVToK;
        int[] iArr2 = this.hashTableVToK;
        iArr[i] = iArr2[bucket];
        iArr2[bucket] = i;
    }

    private void moveEntryToIndex(int i, int i2) {
        int i3;
        int i4;
        if (i == i2) {
            return;
        }
        int i5 = this.prevInInsertionOrder[i];
        int i6 = this.nextInInsertionOrder[i];
        setSucceeds(i5, i2);
        setSucceeds(i2, i6);
        K[] kArr = this.keys;
        K k = kArr[i];
        V[] vArr = this.values;
        V v = vArr[i];
        kArr[i2] = k;
        vArr[i2] = v;
        int bucket = bucket(z.d(k));
        int[] iArr = this.hashTableKToV;
        if (iArr[bucket] == i) {
            iArr[bucket] = i2;
        } else {
            int i7 = iArr[bucket];
            int i8 = this.nextInBucketKToV[i7];
            while (true) {
                int i9 = i8;
                i3 = i7;
                i7 = i9;
                if (i7 == i) {
                    break;
                }
                i8 = this.nextInBucketKToV[i7];
            }
            this.nextInBucketKToV[i3] = i2;
        }
        int[] iArr2 = this.nextInBucketKToV;
        iArr2[i2] = iArr2[i];
        iArr2[i] = -1;
        int bucket2 = bucket(z.d(v));
        int[] iArr3 = this.hashTableVToK;
        if (iArr3[bucket2] == i) {
            iArr3[bucket2] = i2;
        } else {
            int i10 = iArr3[bucket2];
            int i11 = this.nextInBucketVToK[i10];
            while (true) {
                int i12 = i11;
                i4 = i10;
                i10 = i12;
                if (i10 == i) {
                    break;
                }
                i11 = this.nextInBucketVToK[i10];
            }
            this.nextInBucketVToK[i4] = i2;
        }
        int[] iArr4 = this.nextInBucketVToK;
        iArr4[i2] = iArr4[i];
        iArr4[i] = -1;
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int h = f0.h(objectInputStream);
        init(16);
        f0.c(this, objectInputStream, h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void replaceKeyInEntry(int i, @NullableDecl K k, boolean z) {
        du1.d(i != -1);
        int d2 = z.d(k);
        int findEntryByKey = findEntryByKey(k, d2);
        int i2 = this.lastInInsertionOrder;
        int i3 = -2;
        if (findEntryByKey != -1) {
            if (z) {
                i2 = this.prevInInsertionOrder[findEntryByKey];
                i3 = this.nextInInsertionOrder[findEntryByKey];
                removeEntryKeyHashKnown(findEntryByKey, d2);
                if (i == this.size) {
                    i = findEntryByKey;
                }
            } else {
                throw new IllegalArgumentException("Key already present in map: " + k);
            }
        }
        if (i2 == i) {
            i2 = this.prevInInsertionOrder[i];
        } else if (i2 == this.size) {
            i2 = findEntryByKey;
        }
        if (i3 == i) {
            findEntryByKey = this.nextInInsertionOrder[i];
        } else if (i3 != this.size) {
            findEntryByKey = i3;
        }
        setSucceeds(this.prevInInsertionOrder[i], this.nextInInsertionOrder[i]);
        deleteFromTableKToV(i, z.d(this.keys[i]));
        this.keys[i] = k;
        insertIntoTableKToV(i, z.d(k));
        setSucceeds(i2, i);
        setSucceeds(i, findEntryByKey);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void replaceValueInEntry(int i, @NullableDecl V v, boolean z) {
        du1.d(i != -1);
        int d2 = z.d(v);
        int findEntryByValue = findEntryByValue(v, d2);
        if (findEntryByValue != -1) {
            if (z) {
                removeEntryValueHashKnown(findEntryByValue, d2);
                if (i == this.size) {
                    i = findEntryByValue;
                }
            } else {
                throw new IllegalArgumentException("Value already present in map: " + v);
            }
        }
        deleteFromTableVToK(i, z.d(this.values[i]));
        this.values[i] = v;
        insertIntoTableVToK(i, d2);
    }

    private void setSucceeds(int i, int i2) {
        if (i == -2) {
            this.firstInInsertionOrder = i2;
        } else {
            this.nextInInsertionOrder[i] = i2;
        }
        if (i2 == -2) {
            this.lastInInsertionOrder = i;
        } else {
            this.prevInInsertionOrder[i2] = i;
        }
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        f0.i(this, objectOutputStream);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Arrays.fill(this.keys, 0, this.size, (Object) null);
        Arrays.fill(this.values, 0, this.size, (Object) null);
        Arrays.fill(this.hashTableKToV, -1);
        Arrays.fill(this.hashTableVToK, -1);
        Arrays.fill(this.nextInBucketKToV, 0, this.size, -1);
        Arrays.fill(this.nextInBucketVToK, 0, this.size, -1);
        Arrays.fill(this.prevInInsertionOrder, 0, this.size, -1);
        Arrays.fill(this.nextInInsertionOrder, 0, this.size, -1);
        this.size = 0;
        this.firstInInsertionOrder = -2;
        this.lastInInsertionOrder = -2;
        this.modCount++;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@NullableDecl Object obj) {
        return findEntryByKey(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@NullableDecl Object obj) {
        return findEntryByValue(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set == null) {
            c cVar = new c();
            this.entrySet = cVar;
            return cVar;
        }
        return set;
    }

    int findEntry(@NullableDecl Object obj, int i, int[] iArr, int[] iArr2, Object[] objArr) {
        int i2 = iArr[bucket(i)];
        while (i2 != -1) {
            if (nm1.a(objArr[i2], obj)) {
                return i2;
            }
            i2 = iArr2[i2];
        }
        return -1;
    }

    int findEntryByKey(@NullableDecl Object obj) {
        return findEntryByKey(obj, z.d(obj));
    }

    int findEntryByValue(@NullableDecl Object obj) {
        return findEntryByValue(obj, z.d(obj));
    }

    @Override // com.google.common.collect.BiMap
    @CanIgnoreReturnValue
    @NullableDecl
    public V forcePut(@NullableDecl K k, @NullableDecl V v) {
        return put(k, v, true);
    }

    @Override // java.util.AbstractMap, java.util.Map
    @NullableDecl
    public V get(@NullableDecl Object obj) {
        int findEntryByKey = findEntryByKey(obj);
        if (findEntryByKey == -1) {
            return null;
        }
        return this.values[findEntryByKey];
    }

    @NullableDecl
    K getInverse(@NullableDecl Object obj) {
        int findEntryByValue = findEntryByValue(obj);
        if (findEntryByValue == -1) {
            return null;
        }
        return this.keys[findEntryByValue];
    }

    void init(int i) {
        k.b(i, "expectedSize");
        int a2 = z.a(i, 1.0d);
        this.size = 0;
        this.keys = (K[]) new Object[i];
        this.values = (V[]) new Object[i];
        this.hashTableKToV = createFilledWithAbsent(a2);
        this.hashTableVToK = createFilledWithAbsent(a2);
        this.nextInBucketKToV = createFilledWithAbsent(i);
        this.nextInBucketVToK = createFilledWithAbsent(i);
        this.firstInInsertionOrder = -2;
        this.lastInInsertionOrder = -2;
        this.prevInInsertionOrder = createFilledWithAbsent(i);
        this.nextInInsertionOrder = createFilledWithAbsent(i);
    }

    @Override // com.google.common.collect.BiMap
    public BiMap<V, K> inverse() {
        BiMap<V, K> biMap = this.inverse;
        if (biMap == null) {
            Inverse inverse = new Inverse(this);
            this.inverse = inverse;
            return inverse;
        }
        return biMap;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set == null) {
            e eVar = new e();
            this.keySet = eVar;
            return eVar;
        }
        return set;
    }

    @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.BiMap
    @CanIgnoreReturnValue
    public V put(@NullableDecl K k, @NullableDecl V v) {
        return put(k, v, false);
    }

    @NullableDecl
    K putInverse(@NullableDecl V v, @NullableDecl K k, boolean z) {
        int d2 = z.d(v);
        int findEntryByValue = findEntryByValue(v, d2);
        if (findEntryByValue != -1) {
            K k2 = this.keys[findEntryByValue];
            if (nm1.a(k2, k)) {
                return k;
            }
            replaceKeyInEntry(findEntryByValue, k, z);
            return k2;
        }
        int i = this.lastInInsertionOrder;
        int d3 = z.d(k);
        int findEntryByKey = findEntryByKey(k, d3);
        if (!z) {
            du1.k(findEntryByKey == -1, "Key already present: %s", k);
        } else if (findEntryByKey != -1) {
            i = this.prevInInsertionOrder[findEntryByKey];
            removeEntryKeyHashKnown(findEntryByKey, d3);
        }
        ensureCapacity(this.size + 1);
        K[] kArr = this.keys;
        int i2 = this.size;
        kArr[i2] = k;
        this.values[i2] = v;
        insertIntoTableKToV(i2, d3);
        insertIntoTableVToK(this.size, d2);
        int i3 = i == -2 ? this.firstInInsertionOrder : this.nextInInsertionOrder[i];
        setSucceeds(i, this.size);
        setSucceeds(this.size, i3);
        this.size++;
        this.modCount++;
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    @NullableDecl
    public V remove(@NullableDecl Object obj) {
        int d2 = z.d(obj);
        int findEntryByKey = findEntryByKey(obj, d2);
        if (findEntryByKey == -1) {
            return null;
        }
        V v = this.values[findEntryByKey];
        removeEntryKeyHashKnown(findEntryByKey, d2);
        return v;
    }

    void removeEntry(int i) {
        removeEntryKeyHashKnown(i, z.d(this.keys[i]));
    }

    void removeEntryKeyHashKnown(int i, int i2) {
        removeEntry(i, i2, z.d(this.values[i]));
    }

    void removeEntryValueHashKnown(int i, int i2) {
        removeEntry(i, z.d(this.keys[i]), i2);
    }

    @NullableDecl
    K removeInverse(@NullableDecl Object obj) {
        int d2 = z.d(obj);
        int findEntryByValue = findEntryByValue(obj, d2);
        if (findEntryByValue == -1) {
            return null;
        }
        K k = this.keys[findEntryByValue];
        removeEntryValueHashKnown(findEntryByValue, d2);
        return k;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    public static <K, V> HashBiMap<K, V> create(int i) {
        return new HashBiMap<>(i);
    }

    private void removeEntry(int i, int i2, int i3) {
        du1.d(i != -1);
        deleteFromTableKToV(i, i2);
        deleteFromTableVToK(i, i3);
        setSucceeds(this.prevInInsertionOrder[i], this.nextInInsertionOrder[i]);
        moveEntryToIndex(this.size - 1, i);
        K[] kArr = this.keys;
        int i4 = this.size;
        kArr[i4 - 1] = null;
        this.values[i4 - 1] = null;
        this.size = i4 - 1;
        this.modCount++;
    }

    int findEntryByKey(@NullableDecl Object obj, int i) {
        return findEntry(obj, i, this.hashTableKToV, this.nextInBucketKToV, this.keys);
    }

    int findEntryByValue(@NullableDecl Object obj, int i) {
        return findEntry(obj, i, this.hashTableVToK, this.nextInBucketVToK, this.values);
    }

    @NullableDecl
    V put(@NullableDecl K k, @NullableDecl V v, boolean z) {
        int d2 = z.d(k);
        int findEntryByKey = findEntryByKey(k, d2);
        if (findEntryByKey != -1) {
            V v2 = this.values[findEntryByKey];
            if (nm1.a(v2, v)) {
                return v;
            }
            replaceValueInEntry(findEntryByKey, v, z);
            return v2;
        }
        int d3 = z.d(v);
        int findEntryByValue = findEntryByValue(v, d3);
        if (!z) {
            du1.k(findEntryByValue == -1, "Value already present: %s", v);
        } else if (findEntryByValue != -1) {
            removeEntryValueHashKnown(findEntryByValue, d3);
        }
        ensureCapacity(this.size + 1);
        K[] kArr = this.keys;
        int i = this.size;
        kArr[i] = k;
        this.values[i] = v;
        insertIntoTableKToV(i, d2);
        insertIntoTableVToK(this.size, d3);
        setSucceeds(this.lastInInsertionOrder, this.size);
        setSucceeds(this.size, -2);
        this.size++;
        this.modCount++;
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<V> values() {
        Set<V> set = this.valueSet;
        if (set == null) {
            f fVar = new f();
            this.valueSet = fVar;
            return fVar;
        }
        return set;
    }

    public static <K, V> HashBiMap<K, V> create(Map<? extends K, ? extends V> map) {
        HashBiMap<K, V> create = create(map.size());
        create.putAll(map);
        return create;
    }
}
