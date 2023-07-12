package com.airbnb.lottie.parser.moshi;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes17.dex */
public final class LinkedHashTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Comparator<Comparable> NATURAL_ORDER = new C2912a();
    Comparator<? super K> comparator;
    private LinkedHashTreeMap<K, V>.C2915d entrySet;
    final C2920g<K, V> header;
    private LinkedHashTreeMap<K, V>.C2917e keySet;
    int modCount;
    int size;
    C2920g<K, V>[] table;
    int threshold;

    /* compiled from: Taobao */
    /* renamed from: com.airbnb.lottie.parser.moshi.LinkedHashTreeMap$a */
    /* loaded from: classes17.dex */
    class C2912a implements Comparator<Comparable> {
        C2912a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.airbnb.lottie.parser.moshi.LinkedHashTreeMap$b */
    /* loaded from: classes17.dex */
    public static final class C2913b<K, V> {
        private C2920g<K, V> a;
        private int b;
        private int c;
        private int d;

        C2913b() {
        }

        void a(C2920g<K, V> c2920g) {
            c2920g.c = null;
            c2920g.a = null;
            c2920g.b = null;
            c2920g.i = 1;
            int i = this.b;
            if (i > 0) {
                int i2 = this.d;
                if ((i2 & 1) == 0) {
                    this.d = i2 + 1;
                    this.b = i - 1;
                    this.c++;
                }
            }
            c2920g.a = this.a;
            this.a = c2920g;
            int i3 = this.d + 1;
            this.d = i3;
            int i4 = this.b;
            if (i4 > 0 && (i3 & 1) == 0) {
                this.d = i3 + 1;
                this.b = i4 - 1;
                this.c++;
            }
            int i5 = 4;
            while (true) {
                int i6 = i5 - 1;
                if ((this.d & i6) != i6) {
                    return;
                }
                int i7 = this.c;
                if (i7 == 0) {
                    C2920g<K, V> c2920g2 = this.a;
                    C2920g<K, V> c2920g3 = c2920g2.a;
                    C2920g<K, V> c2920g4 = c2920g3.a;
                    c2920g3.a = c2920g4.a;
                    this.a = c2920g3;
                    c2920g3.b = c2920g4;
                    c2920g3.c = c2920g2;
                    c2920g3.i = c2920g2.i + 1;
                    c2920g4.a = c2920g3;
                    c2920g2.a = c2920g3;
                } else if (i7 == 1) {
                    C2920g<K, V> c2920g5 = this.a;
                    C2920g<K, V> c2920g6 = c2920g5.a;
                    this.a = c2920g6;
                    c2920g6.c = c2920g5;
                    c2920g6.i = c2920g5.i + 1;
                    c2920g5.a = c2920g6;
                    this.c = 0;
                } else if (i7 == 2) {
                    this.c = 0;
                }
                i5 *= 2;
            }
        }

        void b(int i) {
            this.b = ((Integer.highestOneBit(i) * 2) - 1) - i;
            this.d = 0;
            this.c = 0;
            this.a = null;
        }

        C2920g<K, V> c() {
            C2920g<K, V> c2920g = this.a;
            if (c2920g.a == null) {
                return c2920g;
            }
            throw new IllegalStateException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.airbnb.lottie.parser.moshi.LinkedHashTreeMap$c */
    /* loaded from: classes17.dex */
    public static class C2914c<K, V> {
        private C2920g<K, V> a;

        C2914c() {
        }

        public C2920g<K, V> a() {
            C2920g<K, V> c2920g = this.a;
            if (c2920g == null) {
                return null;
            }
            C2920g<K, V> c2920g2 = c2920g.a;
            c2920g.a = null;
            C2920g<K, V> c2920g3 = c2920g.c;
            while (true) {
                C2920g<K, V> c2920g4 = c2920g2;
                c2920g2 = c2920g3;
                if (c2920g2 != null) {
                    c2920g2.a = c2920g4;
                    c2920g3 = c2920g2.b;
                } else {
                    this.a = c2920g4;
                    return c2920g;
                }
            }
        }

        void b(C2920g<K, V> c2920g) {
            C2920g<K, V> c2920g2 = null;
            while (c2920g != null) {
                c2920g.a = c2920g2;
                c2920g2 = c2920g;
                c2920g = c2920g.b;
            }
            this.a = c2920g2;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.airbnb.lottie.parser.moshi.LinkedHashTreeMap$d */
    /* loaded from: classes17.dex */
    final class C2915d extends AbstractSet<Map.Entry<K, V>> {

        /* compiled from: Taobao */
        /* renamed from: com.airbnb.lottie.parser.moshi.LinkedHashTreeMap$d$a */
        /* loaded from: classes9.dex */
        class C2916a extends LinkedHashTreeMap<K, V>.AbstractC2919f<Map.Entry<K, V>> {
            C2916a(C2915d c2915d) {
                super();
            }

            @Override // java.util.Iterator
            /* renamed from: b */
            public Map.Entry<K, V> next() {
                return a();
            }
        }

        C2915d() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedHashTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && LinkedHashTreeMap.this.findByEntry((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new C2916a(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            C2920g<K, V> findByEntry;
            if ((obj instanceof Map.Entry) && (findByEntry = LinkedHashTreeMap.this.findByEntry((Map.Entry) obj)) != null) {
                LinkedHashTreeMap.this.removeInternal(findByEntry, true);
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedHashTreeMap.this.size;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.airbnb.lottie.parser.moshi.LinkedHashTreeMap$e */
    /* loaded from: classes17.dex */
    final class C2917e extends AbstractSet<K> {

        /* compiled from: Taobao */
        /* renamed from: com.airbnb.lottie.parser.moshi.LinkedHashTreeMap$e$a */
        /* loaded from: classes9.dex */
        class C2918a extends LinkedHashTreeMap<K, V>.AbstractC2919f<K> {
            C2918a(C2917e c2917e) {
                super();
            }

            @Override // java.util.Iterator
            public K next() {
                return a().f;
            }
        }

        C2917e() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedHashTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return LinkedHashTreeMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new C2918a(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return LinkedHashTreeMap.this.removeInternalByKey(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedHashTreeMap.this.size;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.airbnb.lottie.parser.moshi.LinkedHashTreeMap$f */
    /* loaded from: classes17.dex */
    public abstract class AbstractC2919f<T> implements Iterator<T> {
        C2920g<K, V> a;
        C2920g<K, V> b = null;
        int c;

        AbstractC2919f() {
            this.a = LinkedHashTreeMap.this.header.d;
            this.c = LinkedHashTreeMap.this.modCount;
        }

        final C2920g<K, V> a() {
            C2920g<K, V> c2920g = this.a;
            LinkedHashTreeMap linkedHashTreeMap = LinkedHashTreeMap.this;
            if (c2920g != linkedHashTreeMap.header) {
                if (linkedHashTreeMap.modCount == this.c) {
                    this.a = c2920g.d;
                    this.b = c2920g;
                    return c2920g;
                }
                throw new ConcurrentModificationException();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.a != LinkedHashTreeMap.this.header;
        }

        @Override // java.util.Iterator
        public final void remove() {
            C2920g<K, V> c2920g = this.b;
            if (c2920g != null) {
                LinkedHashTreeMap.this.removeInternal(c2920g, true);
                this.b = null;
                this.c = LinkedHashTreeMap.this.modCount;
                return;
            }
            throw new IllegalStateException();
        }
    }

    LinkedHashTreeMap() {
        this(null);
    }

    private void doubleCapacity() {
        C2920g<K, V>[] doubleCapacity = doubleCapacity(this.table);
        this.table = doubleCapacity;
        this.threshold = (doubleCapacity.length / 2) + (doubleCapacity.length / 4);
    }

    private boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private void rebalance(C2920g<K, V> c2920g, boolean z) {
        while (c2920g != null) {
            C2920g<K, V> c2920g2 = c2920g.b;
            C2920g<K, V> c2920g3 = c2920g.c;
            int i = c2920g2 != null ? c2920g2.i : 0;
            int i2 = c2920g3 != null ? c2920g3.i : 0;
            int i3 = i - i2;
            if (i3 == -2) {
                C2920g<K, V> c2920g4 = c2920g3.b;
                C2920g<K, V> c2920g5 = c2920g3.c;
                int i4 = (c2920g4 != null ? c2920g4.i : 0) - (c2920g5 != null ? c2920g5.i : 0);
                if (i4 != -1 && (i4 != 0 || z)) {
                    rotateRight(c2920g3);
                    rotateLeft(c2920g);
                } else {
                    rotateLeft(c2920g);
                }
                if (z) {
                    return;
                }
            } else if (i3 == 2) {
                C2920g<K, V> c2920g6 = c2920g2.b;
                C2920g<K, V> c2920g7 = c2920g2.c;
                int i5 = (c2920g6 != null ? c2920g6.i : 0) - (c2920g7 != null ? c2920g7.i : 0);
                if (i5 != 1 && (i5 != 0 || z)) {
                    rotateLeft(c2920g2);
                    rotateRight(c2920g);
                } else {
                    rotateRight(c2920g);
                }
                if (z) {
                    return;
                }
            } else if (i3 == 0) {
                c2920g.i = i + 1;
                if (z) {
                    return;
                }
            } else {
                c2920g.i = Math.max(i, i2) + 1;
                if (!z) {
                    return;
                }
            }
            c2920g = c2920g.a;
        }
    }

    private void replaceInParent(C2920g<K, V> c2920g, C2920g<K, V> c2920g2) {
        C2920g<K, V> c2920g3 = c2920g.a;
        c2920g.a = null;
        if (c2920g2 != null) {
            c2920g2.a = c2920g3;
        }
        if (c2920g3 != null) {
            if (c2920g3.b == c2920g) {
                c2920g3.b = c2920g2;
                return;
            } else {
                c2920g3.c = c2920g2;
                return;
            }
        }
        int i = c2920g.g;
        C2920g<K, V>[] c2920gArr = this.table;
        c2920gArr[i & (c2920gArr.length - 1)] = c2920g2;
    }

    private void rotateLeft(C2920g<K, V> c2920g) {
        C2920g<K, V> c2920g2 = c2920g.b;
        C2920g<K, V> c2920g3 = c2920g.c;
        C2920g<K, V> c2920g4 = c2920g3.b;
        C2920g<K, V> c2920g5 = c2920g3.c;
        c2920g.c = c2920g4;
        if (c2920g4 != null) {
            c2920g4.a = c2920g;
        }
        replaceInParent(c2920g, c2920g3);
        c2920g3.b = c2920g;
        c2920g.a = c2920g3;
        int max = Math.max(c2920g2 != null ? c2920g2.i : 0, c2920g4 != null ? c2920g4.i : 0) + 1;
        c2920g.i = max;
        c2920g3.i = Math.max(max, c2920g5 != null ? c2920g5.i : 0) + 1;
    }

    private void rotateRight(C2920g<K, V> c2920g) {
        C2920g<K, V> c2920g2 = c2920g.b;
        C2920g<K, V> c2920g3 = c2920g.c;
        C2920g<K, V> c2920g4 = c2920g2.b;
        C2920g<K, V> c2920g5 = c2920g2.c;
        c2920g.b = c2920g5;
        if (c2920g5 != null) {
            c2920g5.a = c2920g;
        }
        replaceInParent(c2920g, c2920g2);
        c2920g2.c = c2920g;
        c2920g.a = c2920g2;
        int max = Math.max(c2920g3 != null ? c2920g3.i : 0, c2920g5 != null ? c2920g5.i : 0) + 1;
        c2920g.i = max;
        c2920g2.i = Math.max(max, c2920g4 != null ? c2920g4.i : 0) + 1;
    }

    private static int secondaryHash(int i) {
        int i2 = i ^ ((i >>> 20) ^ (i >>> 12));
        return (i2 >>> 4) ^ ((i2 >>> 7) ^ i2);
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Arrays.fill(this.table, (Object) null);
        this.size = 0;
        this.modCount++;
        C2920g<K, V> c2920g = this.header;
        C2920g<K, V> c2920g2 = c2920g.d;
        while (c2920g2 != c2920g) {
            C2920g<K, V> c2920g3 = c2920g2.d;
            c2920g2.e = null;
            c2920g2.d = null;
            c2920g2 = c2920g3;
        }
        c2920g.e = c2920g;
        c2920g.d = c2920g;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return findByObject(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        LinkedHashTreeMap<K, V>.C2915d c2915d = this.entrySet;
        if (c2915d != null) {
            return c2915d;
        }
        LinkedHashTreeMap<K, V>.C2915d c2915d2 = new C2915d();
        this.entrySet = c2915d2;
        return c2915d2;
    }

    C2920g<K, V> find(K k, boolean z) {
        C2920g<K, V> c2920g;
        int i;
        C2920g<K, V> c2920g2;
        int compare;
        Comparator<? super K> comparator = this.comparator;
        C2920g<K, V>[] c2920gArr = this.table;
        int secondaryHash = secondaryHash(k.hashCode());
        int length = (c2920gArr.length - 1) & secondaryHash;
        C2920g<K, V> c2920g3 = c2920gArr[length];
        if (c2920g3 != null) {
            Comparable comparable = comparator == NATURAL_ORDER ? (Comparable) k : null;
            while (true) {
                if (comparable != null) {
                    compare = comparable.compareTo(c2920g3.f);
                } else {
                    compare = comparator.compare(k, (K) c2920g3.f);
                }
                if (compare == 0) {
                    return c2920g3;
                }
                C2920g<K, V> c2920g4 = compare < 0 ? c2920g3.b : c2920g3.c;
                if (c2920g4 == null) {
                    c2920g = c2920g3;
                    i = compare;
                    break;
                }
                c2920g3 = c2920g4;
            }
        } else {
            c2920g = c2920g3;
            i = 0;
        }
        if (z) {
            C2920g<K, V> c2920g5 = this.header;
            if (c2920g == null) {
                if (comparator == NATURAL_ORDER && !(k instanceof Comparable)) {
                    throw new ClassCastException(k.getClass().getName() + " is not Comparable");
                }
                c2920g2 = new C2920g<>(c2920g, k, secondaryHash, c2920g5, c2920g5.e);
                c2920gArr[length] = c2920g2;
            } else {
                c2920g2 = new C2920g<>(c2920g, k, secondaryHash, c2920g5, c2920g5.e);
                if (i < 0) {
                    c2920g.b = c2920g2;
                } else {
                    c2920g.c = c2920g2;
                }
                rebalance(c2920g, true);
            }
            int i2 = this.size;
            this.size = i2 + 1;
            if (i2 > this.threshold) {
                doubleCapacity();
            }
            this.modCount++;
            return c2920g2;
        }
        return null;
    }

    C2920g<K, V> findByEntry(Map.Entry<?, ?> entry) {
        C2920g<K, V> findByObject = findByObject(entry.getKey());
        if (findByObject != null && equal(findByObject.h, entry.getValue())) {
            return findByObject;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    C2920g<K, V> findByObject(Object obj) {
        if (obj != 0) {
            try {
                return find(obj, false);
            } catch (ClassCastException unused) {
                return null;
            }
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        C2920g<K, V> findByObject = findByObject(obj);
        if (findByObject != null) {
            return findByObject.h;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        LinkedHashTreeMap<K, V>.C2917e c2917e = this.keySet;
        if (c2917e != null) {
            return c2917e;
        }
        LinkedHashTreeMap<K, V>.C2917e c2917e2 = new C2917e();
        this.keySet = c2917e2;
        return c2917e2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        Objects.requireNonNull(k, "key == null");
        C2920g<K, V> find = find(k, true);
        V v2 = find.h;
        find.h = v;
        return v2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        C2920g<K, V> removeInternalByKey = removeInternalByKey(obj);
        if (removeInternalByKey != null) {
            return removeInternalByKey.h;
        }
        return null;
    }

    void removeInternal(C2920g<K, V> c2920g, boolean z) {
        int i;
        if (z) {
            C2920g<K, V> c2920g2 = c2920g.e;
            c2920g2.d = c2920g.d;
            c2920g.d.e = c2920g2;
            c2920g.e = null;
            c2920g.d = null;
        }
        C2920g<K, V> c2920g3 = c2920g.b;
        C2920g<K, V> c2920g4 = c2920g.c;
        C2920g<K, V> c2920g5 = c2920g.a;
        int i2 = 0;
        if (c2920g3 != null && c2920g4 != null) {
            C2920g<K, V> b = c2920g3.i > c2920g4.i ? c2920g3.b() : c2920g4.a();
            removeInternal(b, false);
            C2920g<K, V> c2920g6 = c2920g.b;
            if (c2920g6 != null) {
                i = c2920g6.i;
                b.b = c2920g6;
                c2920g6.a = b;
                c2920g.b = null;
            } else {
                i = 0;
            }
            C2920g<K, V> c2920g7 = c2920g.c;
            if (c2920g7 != null) {
                i2 = c2920g7.i;
                b.c = c2920g7;
                c2920g7.a = b;
                c2920g.c = null;
            }
            b.i = Math.max(i, i2) + 1;
            replaceInParent(c2920g, b);
            return;
        }
        if (c2920g3 != null) {
            replaceInParent(c2920g, c2920g3);
            c2920g.b = null;
        } else if (c2920g4 != null) {
            replaceInParent(c2920g, c2920g4);
            c2920g.c = null;
        } else {
            replaceInParent(c2920g, null);
        }
        rebalance(c2920g5, false);
        this.size--;
        this.modCount++;
    }

    C2920g<K, V> removeInternalByKey(Object obj) {
        C2920g<K, V> findByObject = findByObject(obj);
        if (findByObject != null) {
            removeInternal(findByObject, true);
        }
        return findByObject;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    LinkedHashTreeMap(Comparator<? super K> comparator) {
        this.size = 0;
        this.modCount = 0;
        this.comparator = comparator == null ? NATURAL_ORDER : comparator;
        this.header = new C2920g<>();
        C2920g<K, V>[] c2920gArr = new C2920g[16];
        this.table = c2920gArr;
        this.threshold = (c2920gArr.length / 2) + (c2920gArr.length / 4);
    }

    static <K, V> C2920g<K, V>[] doubleCapacity(C2920g<K, V>[] c2920gArr) {
        int length = c2920gArr.length;
        C2920g<K, V>[] c2920gArr2 = new C2920g[length * 2];
        C2914c c2914c = new C2914c();
        C2913b c2913b = new C2913b();
        C2913b c2913b2 = new C2913b();
        for (int i = 0; i < length; i++) {
            C2920g<K, V> c2920g = c2920gArr[i];
            if (c2920g != null) {
                c2914c.b(c2920g);
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    C2920g<K, V> a = c2914c.a();
                    if (a == null) {
                        break;
                    } else if ((a.g & length) == 0) {
                        i2++;
                    } else {
                        i3++;
                    }
                }
                c2913b.b(i2);
                c2913b2.b(i3);
                c2914c.b(c2920g);
                while (true) {
                    C2920g<K, V> a2 = c2914c.a();
                    if (a2 == null) {
                        break;
                    } else if ((a2.g & length) == 0) {
                        c2913b.a(a2);
                    } else {
                        c2913b2.a(a2);
                    }
                }
                c2920gArr2[i] = i2 > 0 ? c2913b.c() : null;
                c2920gArr2[i + length] = i3 > 0 ? c2913b2.c() : null;
            }
        }
        return c2920gArr2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.airbnb.lottie.parser.moshi.LinkedHashTreeMap$g */
    /* loaded from: classes17.dex */
    public static final class C2920g<K, V> implements Map.Entry<K, V> {
        C2920g<K, V> a;
        C2920g<K, V> b;
        C2920g<K, V> c;
        C2920g<K, V> d;
        C2920g<K, V> e;
        final K f;
        final int g;
        V h;
        int i;

        C2920g() {
            this.f = null;
            this.g = -1;
            this.e = this;
            this.d = this;
        }

        public C2920g<K, V> a() {
            C2920g<K, V> c2920g = this;
            for (C2920g<K, V> c2920g2 = this.b; c2920g2 != null; c2920g2 = c2920g2.b) {
                c2920g = c2920g2;
            }
            return c2920g;
        }

        public C2920g<K, V> b() {
            C2920g<K, V> c2920g = this;
            for (C2920g<K, V> c2920g2 = this.c; c2920g2 != null; c2920g2 = c2920g2.c) {
                c2920g = c2920g2;
            }
            return c2920g;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                K k = this.f;
                if (k == null) {
                    if (entry.getKey() != null) {
                        return false;
                    }
                } else if (!k.equals(entry.getKey())) {
                    return false;
                }
                V v = this.h;
                if (v == null) {
                    if (entry.getValue() != null) {
                        return false;
                    }
                } else if (!v.equals(entry.getValue())) {
                    return false;
                }
                return true;
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.h;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k = this.f;
            int hashCode = k == null ? 0 : k.hashCode();
            V v = this.h;
            return hashCode ^ (v != null ? v.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.h;
            this.h = v;
            return v2;
        }

        public String toString() {
            return this.f + "=" + this.h;
        }

        C2920g(C2920g<K, V> c2920g, K k, int i, C2920g<K, V> c2920g2, C2920g<K, V> c2920g3) {
            this.a = c2920g;
            this.f = k;
            this.g = i;
            this.i = 1;
            this.d = c2920g2;
            this.e = c2920g3;
            c2920g3.d = this;
            c2920g2.e = this;
        }
    }
}
