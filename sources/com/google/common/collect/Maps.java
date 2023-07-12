package com.google.common.collect;

import com.alipay.sdk.m.n.C4250a;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Converter;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;
import com.google.j2objc.annotations.RetainedWith;
import com.google.j2objc.annotations.Weak;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.du1;
import tb.jn1;
import tb.nm1;
import tb.yt2;

/* compiled from: Taobao */
@GwtCompatible(emulated = true)
/* loaded from: classes10.dex */
public final class Maps {

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private static final class BiMapConverter<A, B> extends Converter<A, B> implements Serializable {
        private static final long serialVersionUID = 0;
        private final BiMap<A, B> bimap;

        BiMapConverter(BiMap<A, B> biMap) {
            this.bimap = (BiMap) du1.p(biMap);
        }

        private static <X, Y> Y convert(BiMap<X, Y> biMap, X x) {
            Y y = biMap.get(x);
            du1.k(y != null, "No non-null mapping present for input: %s", x);
            return y;
        }

        @Override // com.google.common.base.Converter
        protected A doBackward(B b) {
            return (A) convert(this.bimap.inverse(), b);
        }

        @Override // com.google.common.base.Converter
        protected B doForward(A a) {
            return (B) convert(this.bimap, a);
        }

        @Override // com.google.common.base.Converter, com.google.common.base.Function
        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof BiMapConverter) {
                return this.bimap.equals(((BiMapConverter) obj).bimap);
            }
            return false;
        }

        public int hashCode() {
            return this.bimap.hashCode();
        }

        public String toString() {
            return "Maps.asConverter(" + this.bimap + jn1.BRACKET_END_STR;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public enum EntryFunction implements Function<Map.Entry<?, ?>, Object> {
        KEY { // from class: com.google.common.collect.Maps.EntryFunction.1
            @Override // com.google.common.base.Function
            @NullableDecl
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getKey();
            }
        },
        VALUE { // from class: com.google.common.collect.Maps.EntryFunction.2
            @Override // com.google.common.base.Function
            @NullableDecl
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getValue();
            }
        };

        /* synthetic */ EntryFunction(C5051c c5051c) {
            this();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface EntryTransformer<K, V1, V2> {
        V2 transformEntry(@NullableDecl K k, @NullableDecl V1 v1);
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private static class UnmodifiableBiMap<K, V> extends AbstractC5202q<K, V> implements BiMap<K, V>, Serializable {
        private static final long serialVersionUID = 0;
        final BiMap<? extends K, ? extends V> delegate;
        @RetainedWith
        @MonotonicNonNullDecl
        BiMap<V, K> inverse;
        final Map<K, V> unmodifiableMap;
        @MonotonicNonNullDecl
        transient Set<V> values;

        UnmodifiableBiMap(BiMap<? extends K, ? extends V> biMap, @NullableDecl BiMap<V, K> biMap2) {
            this.unmodifiableMap = Collections.unmodifiableMap(biMap);
            this.delegate = biMap;
            this.inverse = biMap2;
        }

        @Override // com.google.common.collect.BiMap
        public V forcePut(K k, V v) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.BiMap
        public BiMap<V, K> inverse() {
            BiMap<V, K> biMap = this.inverse;
            if (biMap == null) {
                UnmodifiableBiMap unmodifiableBiMap = new UnmodifiableBiMap(this.delegate.inverse(), this);
                this.inverse = unmodifiableBiMap;
                return unmodifiableBiMap;
            }
            return biMap;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.AbstractC5202q, com.google.common.collect.AbstractC5205t
        public Map<K, V> delegate() {
            return this.unmodifiableMap;
        }

        @Override // com.google.common.collect.AbstractC5202q, java.util.Map
        public Set<V> values() {
            Set<V> set = this.values;
            if (set == null) {
                Set<V> unmodifiableSet = Collections.unmodifiableSet(this.delegate.values());
                this.values = unmodifiableSet;
                return unmodifiableSet;
            }
            return set;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    @GwtIncompatible
    /* loaded from: classes10.dex */
    public static class UnmodifiableNavigableMap<K, V> extends AbstractC5208w<K, V> implements NavigableMap<K, V>, Serializable {
        private final NavigableMap<K, ? extends V> delegate;
        @MonotonicNonNullDecl
        private transient UnmodifiableNavigableMap<K, V> descendingMap;

        UnmodifiableNavigableMap(NavigableMap<K, ? extends V> navigableMap) {
            this.delegate = navigableMap;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> ceilingEntry(K k) {
            return Maps.J(this.delegate.ceilingEntry(k));
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K k) {
            return this.delegate.ceilingKey(k);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return Sets.j(this.delegate.descendingKeySet());
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            UnmodifiableNavigableMap<K, V> unmodifiableNavigableMap = this.descendingMap;
            if (unmodifiableNavigableMap == null) {
                UnmodifiableNavigableMap<K, V> unmodifiableNavigableMap2 = new UnmodifiableNavigableMap<>(this.delegate.descendingMap(), this);
                this.descendingMap = unmodifiableNavigableMap2;
                return unmodifiableNavigableMap2;
            }
            return unmodifiableNavigableMap;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> firstEntry() {
            return Maps.J(this.delegate.firstEntry());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> floorEntry(K k) {
            return Maps.J(this.delegate.floorEntry(k));
        }

        @Override // java.util.NavigableMap
        public K floorKey(K k) {
            return this.delegate.floorKey(k);
        }

        @Override // com.google.common.collect.AbstractC5208w, java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> headMap(K k) {
            return headMap(k, false);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> higherEntry(K k) {
            return Maps.J(this.delegate.higherEntry(k));
        }

        @Override // java.util.NavigableMap
        public K higherKey(K k) {
            return this.delegate.higherKey(k);
        }

        @Override // com.google.common.collect.AbstractC5202q, java.util.Map
        public Set<K> keySet() {
            return navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lastEntry() {
            return Maps.J(this.delegate.lastEntry());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lowerEntry(K k) {
            return Maps.J(this.delegate.lowerEntry(k));
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K k) {
            return this.delegate.lowerKey(k);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            return Sets.j(this.delegate.navigableKeySet());
        }

        @Override // java.util.NavigableMap
        public final Map.Entry<K, V> pollFirstEntry() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.NavigableMap
        public final Map.Entry<K, V> pollLastEntry() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.AbstractC5208w, java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> subMap(K k, K k2) {
            return subMap(k, true, k2, false);
        }

        @Override // com.google.common.collect.AbstractC5208w, java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> tailMap(K k) {
            return tailMap(k, true);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(K k, boolean z) {
            return Maps.I(this.delegate.headMap(k, z));
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(K k, boolean z, K k2, boolean z2) {
            return Maps.I(this.delegate.subMap(k, z, k2, z2));
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(K k, boolean z) {
            return Maps.I(this.delegate.tailMap(k, z));
        }

        UnmodifiableNavigableMap(NavigableMap<K, ? extends V> navigableMap, UnmodifiableNavigableMap<K, V> unmodifiableNavigableMap) {
            this.delegate = navigableMap;
            this.descendingMap = unmodifiableNavigableMap;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.AbstractC5208w, com.google.common.collect.AbstractC5202q, com.google.common.collect.AbstractC5205t
        public SortedMap<K, V> delegate() {
            return Collections.unmodifiableSortedMap(this.delegate);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [K, V2] */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.Maps$a */
    /* loaded from: classes10.dex */
    public static class C5049a<K, V2> extends AbstractC5157b<K, V2> {
        final /* synthetic */ Map.Entry a;
        final /* synthetic */ EntryTransformer b;

        C5049a(Map.Entry entry, EntryTransformer entryTransformer) {
            this.a = entry;
            this.b = entryTransformer;
        }

        @Override // com.google.common.collect.AbstractC5157b, java.util.Map.Entry
        public K getKey() {
            return (K) this.a.getKey();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.AbstractC5157b, java.util.Map.Entry
        public V2 getValue() {
            return (V2) this.b.transformEntry(this.a.getKey(), this.a.getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [K, V1, V2] */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.Maps$b */
    /* loaded from: classes10.dex */
    public static class C5050b<K, V1, V2> implements Function<Map.Entry<K, V1>, Map.Entry<K, V2>> {
        final /* synthetic */ EntryTransformer a;

        C5050b(EntryTransformer entryTransformer) {
            this.a = entryTransformer;
        }

        @Override // com.google.common.base.Function
        /* renamed from: a */
        public Map.Entry<K, V2> apply(Map.Entry<K, V1> entry) {
            return Maps.C(this.a, entry);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.Maps$c */
    /* loaded from: classes10.dex */
    public static class C5051c<K, V> extends AbstractC5190j0<Map.Entry<K, V>, K> {
        C5051c(Iterator it) {
            super(it);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.AbstractC5190j0
        /* renamed from: b */
        public K a(Map.Entry<K, V> entry) {
            return entry.getKey();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.Maps$d */
    /* loaded from: classes10.dex */
    public static class C5052d<K, V> extends AbstractC5190j0<Map.Entry<K, V>, V> {
        C5052d(Iterator it) {
            super(it);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.AbstractC5190j0
        /* renamed from: b */
        public V a(Map.Entry<K, V> entry) {
            return entry.getValue();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.Maps$e */
    /* loaded from: classes10.dex */
    static class C5053e<K, V> extends AbstractC5190j0<K, Map.Entry<K, V>> {
        final /* synthetic */ Function b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C5053e(Iterator it, Function function) {
            super(it);
            this.b = function;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.AbstractC5190j0
        /* renamed from: b */
        public Map.Entry<K, V> a(K k) {
            return Maps.j(k, this.b.apply(k));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.Maps$f */
    /* loaded from: classes10.dex */
    public static class C5054f<K, V> extends AbstractC5157b<K, V> {
        final /* synthetic */ Map.Entry a;

        C5054f(Map.Entry entry) {
            this.a = entry;
        }

        @Override // com.google.common.collect.AbstractC5157b, java.util.Map.Entry
        public K getKey() {
            return (K) this.a.getKey();
        }

        @Override // com.google.common.collect.AbstractC5157b, java.util.Map.Entry
        public V getValue() {
            return (V) this.a.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.Maps$g */
    /* loaded from: classes10.dex */
    public static class C5055g<K, V> extends yt2<Map.Entry<K, V>> {
        final /* synthetic */ Iterator a;

        C5055g(Iterator it) {
            this.a = it;
        }

        @Override // java.util.Iterator
        /* renamed from: a */
        public Map.Entry<K, V> next() {
            return Maps.F((Map.Entry) this.a.next());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a.hasNext();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [K, V1, V2] */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.Maps$h */
    /* loaded from: classes10.dex */
    public static class C5056h<K, V1, V2> implements EntryTransformer<K, V1, V2> {
        final /* synthetic */ Function a;

        C5056h(Function function) {
            this.a = function;
        }

        @Override // com.google.common.collect.Maps.EntryTransformer
        public V2 transformEntry(K k, V1 v1) {
            return (V2) this.a.apply(v1);
        }
    }

    /* compiled from: Taobao */
    @GwtIncompatible
    /* renamed from: com.google.common.collect.Maps$i */
    /* loaded from: classes10.dex */
    static abstract class AbstractC5057i<K, V> extends AbstractC5202q<K, V> implements NavigableMap<K, V> {
        @MonotonicNonNullDecl
        private transient Comparator<? super K> a;
        @MonotonicNonNullDecl
        private transient Set<Map.Entry<K, V>> b;
        @MonotonicNonNullDecl
        private transient NavigableSet<K> c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Taobao */
        /* renamed from: com.google.common.collect.Maps$i$a */
        /* loaded from: classes10.dex */
        public class C5058a extends AbstractC5059j<K, V> {
            C5058a() {
            }

            @Override // com.google.common.collect.Maps.AbstractC5059j
            Map<K, V> a() {
                return AbstractC5057i.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, V>> iterator() {
                return AbstractC5057i.this.b();
            }
        }

        private static <T> Ordering<T> d(Comparator<T> comparator) {
            return Ordering.from(comparator).reverse();
        }

        Set<Map.Entry<K, V>> a() {
            return new C5058a();
        }

        abstract Iterator<Map.Entry<K, V>> b();

        abstract NavigableMap<K, V> c();

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> ceilingEntry(K k) {
            return c().floorEntry(k);
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K k) {
            return c().floorKey(k);
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            Comparator<? super K> comparator = this.a;
            if (comparator == null) {
                Comparator<? super K> comparator2 = c().comparator();
                if (comparator2 == null) {
                    comparator2 = Ordering.natural();
                }
                Ordering d = d(comparator2);
                this.a = d;
                return d;
            }
            return comparator;
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return c().navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            return c();
        }

        @Override // com.google.common.collect.AbstractC5202q, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set = this.b;
            if (set == null) {
                Set<Map.Entry<K, V>> a = a();
                this.b = a;
                return a;
            }
            return set;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> firstEntry() {
            return c().lastEntry();
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return c().lastKey();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> floorEntry(K k) {
            return c().ceilingEntry(k);
        }

        @Override // java.util.NavigableMap
        public K floorKey(K k) {
            return c().ceilingKey(k);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(K k, boolean z) {
            return c().tailMap(k, z).descendingMap();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> higherEntry(K k) {
            return c().lowerEntry(k);
        }

        @Override // java.util.NavigableMap
        public K higherKey(K k) {
            return c().lowerKey(k);
        }

        @Override // com.google.common.collect.AbstractC5202q, java.util.Map
        public Set<K> keySet() {
            return navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lastEntry() {
            return c().firstEntry();
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            return c().firstKey();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lowerEntry(K k) {
            return c().higherEntry(k);
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K k) {
            return c().higherKey(k);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            NavigableSet<K> navigableSet = this.c;
            if (navigableSet == null) {
                C5063m c5063m = new C5063m(this);
                this.c = c5063m;
                return c5063m;
            }
            return navigableSet;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollFirstEntry() {
            return c().pollLastEntry();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollLastEntry() {
            return c().pollFirstEntry();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(K k, boolean z, K k2, boolean z2) {
            return c().subMap(k2, z2, k, z).descendingMap();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(K k, boolean z) {
            return c().headMap(k, z).descendingMap();
        }

        @Override // com.google.common.collect.AbstractC5205t
        public String toString() {
            return standardToString();
        }

        @Override // com.google.common.collect.AbstractC5202q, java.util.Map
        public Collection<V> values() {
            return new C5069s(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.AbstractC5202q, com.google.common.collect.AbstractC5205t
        public final Map<K, V> delegate() {
            return c();
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> headMap(K k) {
            return headMap(k, false);
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> subMap(K k, K k2) {
            return subMap(k, true, k2, false);
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> tailMap(K k) {
            return tailMap(k, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.Maps$j */
    /* loaded from: classes10.dex */
    public static abstract class AbstractC5059j<K, V> extends Sets.AbstractC5098a<Map.Entry<K, V>> {
        abstract Map<K, V> a();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Object x = Maps.x(a(), key);
                if (nm1.a(x, entry.getValue())) {
                    return x != null || a().containsKey(key);
                }
                return false;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return a().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (contains(obj)) {
                return a().keySet().remove(((Map.Entry) obj).getKey());
            }
            return false;
        }

        @Override // com.google.common.collect.Sets.AbstractC5098a, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            try {
                return super.removeAll((Collection) du1.p(collection));
            } catch (UnsupportedOperationException unused) {
                return Sets.i(this, collection.iterator());
            }
        }

        @Override // com.google.common.collect.Sets.AbstractC5098a, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            try {
                return super.retainAll((Collection) du1.p(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet e = Sets.e(collection.size());
                for (Object obj : collection) {
                    if (contains(obj)) {
                        e.add(((Map.Entry) obj).getKey());
                    }
                }
                return a().keySet().retainAll(e);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return a().size();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.Maps$k */
    /* loaded from: classes10.dex */
    static abstract class AbstractC5060k<K, V> extends AbstractMap<K, V> {

        /* compiled from: Taobao */
        /* renamed from: com.google.common.collect.Maps$k$a */
        /* loaded from: classes10.dex */
        class C5061a extends AbstractC5059j<K, V> {
            C5061a() {
            }

            @Override // com.google.common.collect.Maps.AbstractC5059j
            Map<K, V> a() {
                return AbstractC5060k.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, V>> iterator() {
                return AbstractC5060k.this.a();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract Iterator<Map.Entry<K, V>> a();

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            Iterators.d(a());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            return new C5061a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.Maps$l */
    /* loaded from: classes10.dex */
    public static class C5062l<K, V> extends Sets.AbstractC5098a<K> {
        @Weak
        final Map<K, V> a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C5062l(Map<K, V> map) {
            this.a = (Map) du1.p(map);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Map<K, V> a() {
            return this.a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return a().containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return a().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return Maps.m(a().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (contains(obj)) {
                a().remove(obj);
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return a().size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    @GwtIncompatible
    /* renamed from: com.google.common.collect.Maps$m */
    /* loaded from: classes10.dex */
    public static class C5063m<K, V> extends C5064n<K, V> implements NavigableSet<K> {
        /* JADX INFO: Access modifiers changed from: package-private */
        public C5063m(NavigableMap<K, V> navigableMap) {
            super(navigableMap);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Maps.C5064n
        /* renamed from: c */
        public NavigableMap<K, V> b() {
            return (NavigableMap) this.a;
        }

        @Override // java.util.NavigableSet
        public K ceiling(K k) {
            return b().ceilingKey(k);
        }

        @Override // java.util.NavigableSet
        public Iterator<K> descendingIterator() {
            return descendingSet().iterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> descendingSet() {
            return b().descendingKeySet();
        }

        @Override // java.util.NavigableSet
        public K floor(K k) {
            return b().floorKey(k);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> headSet(K k, boolean z) {
            return b().headMap(k, z).navigableKeySet();
        }

        @Override // java.util.NavigableSet
        public K higher(K k) {
            return b().higherKey(k);
        }

        @Override // java.util.NavigableSet
        public K lower(K k) {
            return b().lowerKey(k);
        }

        @Override // java.util.NavigableSet
        public K pollFirst() {
            return (K) Maps.n(b().pollFirstEntry());
        }

        @Override // java.util.NavigableSet
        public K pollLast() {
            return (K) Maps.n(b().pollLastEntry());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> subSet(K k, boolean z, K k2, boolean z2) {
            return b().subMap(k, z, k2, z2).navigableKeySet();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> tailSet(K k, boolean z) {
            return b().tailMap(k, z).navigableKeySet();
        }

        @Override // com.google.common.collect.Maps.C5064n, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> headSet(K k) {
            return headSet(k, false);
        }

        @Override // com.google.common.collect.Maps.C5064n, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> subSet(K k, K k2) {
            return subSet(k, true, k2, false);
        }

        @Override // com.google.common.collect.Maps.C5064n, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> tailSet(K k) {
            return tailSet(k, true);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.Maps$n */
    /* loaded from: classes10.dex */
    static class C5064n<K, V> extends C5062l<K, V> implements SortedSet<K> {
        /* JADX INFO: Access modifiers changed from: package-private */
        public C5064n(SortedMap<K, V> sortedMap) {
            super(sortedMap);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Maps.C5062l
        /* renamed from: b */
        public SortedMap<K, V> a() {
            return (SortedMap) super.a();
        }

        @Override // java.util.SortedSet
        public Comparator<? super K> comparator() {
            return a().comparator();
        }

        @Override // java.util.SortedSet
        public K first() {
            return a().firstKey();
        }

        public SortedSet<K> headSet(K k) {
            return new C5064n(a().headMap(k));
        }

        @Override // java.util.SortedSet
        public K last() {
            return a().lastKey();
        }

        public SortedSet<K> subSet(K k, K k2) {
            return new C5064n(a().subMap(k, k2));
        }

        public SortedSet<K> tailSet(K k) {
            return new C5064n(a().tailMap(k));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.Maps$o */
    /* loaded from: classes10.dex */
    public static class C5065o<K, V1, V2> extends AbstractC5060k<K, V2> {
        final Map<K, V1> a;
        final EntryTransformer<? super K, ? super V1, V2> b;

        C5065o(Map<K, V1> map, EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
            this.a = (Map) du1.p(map);
            this.b = (EntryTransformer) du1.p(entryTransformer);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Maps.AbstractC5060k
        public Iterator<Map.Entry<K, V2>> a() {
            return Iterators.w(this.a.entrySet().iterator(), Maps.b(this.b));
        }

        @Override // com.google.common.collect.Maps.AbstractC5060k, java.util.AbstractMap, java.util.Map
        public void clear() {
            this.a.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return this.a.containsKey(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V2 get(Object obj) {
            V1 v1 = this.a.get(obj);
            if (v1 != null || this.a.containsKey(obj)) {
                return this.b.transformEntry(obj, v1);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return this.a.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V2 remove(Object obj) {
            if (this.a.containsKey(obj)) {
                return this.b.transformEntry(obj, (V1) this.a.remove(obj));
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.a.size();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V2> values() {
            return new C5069s(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.Maps$p */
    /* loaded from: classes10.dex */
    public static class C5066p<K, V1, V2> extends C5065o<K, V1, V2> implements SortedMap<K, V2> {
        C5066p(SortedMap<K, V1> sortedMap, EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
            super(sortedMap, entryTransformer);
        }

        protected SortedMap<K, V1> b() {
            return (SortedMap) this.a;
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            return b().comparator();
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return b().firstKey();
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V2> headMap(K k) {
            return Maps.B(b().headMap(k), this.b);
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            return b().lastKey();
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V2> subMap(K k, K k2) {
            return Maps.B(b().subMap(k, k2), this.b);
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V2> tailMap(K k) {
            return Maps.B(b().tailMap(k), this.b);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.Maps$q */
    /* loaded from: classes10.dex */
    static class C5067q<K, V> extends AbstractC5200o<Map.Entry<K, V>> {
        private final Collection<Map.Entry<K, V>> a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C5067q(Collection<Map.Entry<K, V>> collection) {
            this.a = collection;
        }

        @Override // com.google.common.collect.AbstractC5200o, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return Maps.G(this.a.iterator());
        }

        @Override // com.google.common.collect.AbstractC5200o, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return standardToArray();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.AbstractC5200o, com.google.common.collect.AbstractC5205t
        public Collection<Map.Entry<K, V>> delegate() {
            return this.a;
        }

        @Override // com.google.common.collect.AbstractC5200o, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) standardToArray(tArr);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.Maps$r */
    /* loaded from: classes10.dex */
    static class C5068r<K, V> extends C5067q<K, V> implements Set<Map.Entry<K, V>> {
        C5068r(Set<Map.Entry<K, V>> set) {
            super(set);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(@NullableDecl Object obj) {
            return Sets.a(this, obj);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return Sets.b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.Maps$s */
    /* loaded from: classes10.dex */
    public static class C5069s<K, V> extends AbstractCollection<V> {
        @Weak
        final Map<K, V> a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C5069s(Map<K, V> map) {
            this.a = (Map) du1.p(map);
        }

        final Map<K, V> a() {
            return this.a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@NullableDecl Object obj) {
            return a().containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return a().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return Maps.L(a().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            try {
                return super.remove(obj);
            } catch (UnsupportedOperationException unused) {
                for (Map.Entry<K, V> entry : a().entrySet()) {
                    if (nm1.a(obj, entry.getValue())) {
                        a().remove(entry.getKey());
                        return true;
                    }
                }
                return false;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            try {
                return super.removeAll((Collection) du1.p(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet d = Sets.d();
                for (Map.Entry<K, V> entry : a().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        d.add(entry.getKey());
                    }
                }
                return a().keySet().removeAll(d);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            try {
                return super.retainAll((Collection) du1.p(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet d = Sets.d();
                for (Map.Entry<K, V> entry : a().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        d.add(entry.getKey());
                    }
                }
                return a().keySet().retainAll(d);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return a().size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    @GwtCompatible
    /* renamed from: com.google.common.collect.Maps$t */
    /* loaded from: classes10.dex */
    public static abstract class AbstractC5070t<K, V> extends AbstractMap<K, V> {
        @MonotonicNonNullDecl
        private transient Set<Map.Entry<K, V>> a;
        @MonotonicNonNullDecl
        private transient Set<K> b;
        @MonotonicNonNullDecl
        private transient Collection<V> c;

        abstract Set<Map.Entry<K, V>> a();

        Set<K> b() {
            return new C5062l(this);
        }

        Collection<V> c() {
            return new C5069s(this);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set = this.a;
            if (set == null) {
                Set<Map.Entry<K, V>> a = a();
                this.a = a;
                return a;
            }
            return set;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            Set<K> set = this.b;
            if (set == null) {
                Set<K> b = b();
                this.b = b;
                return b;
            }
            return set;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V> values() {
            Collection<V> collection = this.c;
            if (collection == null) {
                Collection<V> c = c();
                this.c = c;
                return c;
            }
            return collection;
        }
    }

    public static <K, V1, V2> Map<K, V2> A(Map<K, V1> map, EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        return new C5065o(map, entryTransformer);
    }

    public static <K, V1, V2> SortedMap<K, V2> B(SortedMap<K, V1> sortedMap, EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        return new C5066p(sortedMap, entryTransformer);
    }

    static <V2, K, V1> Map.Entry<K, V2> C(EntryTransformer<? super K, ? super V1, V2> entryTransformer, Map.Entry<K, V1> entry) {
        du1.p(entryTransformer);
        du1.p(entry);
        return new C5049a(entry, entryTransformer);
    }

    public static <K, V1, V2> Map<K, V2> D(Map<K, V1> map, Function<? super V1, V2> function) {
        return A(map, c(function));
    }

    public static <K, V1, V2> SortedMap<K, V2> E(SortedMap<K, V1> sortedMap, Function<? super V1, V2> function) {
        return B(sortedMap, c(function));
    }

    static <K, V> Map.Entry<K, V> F(Map.Entry<? extends K, ? extends V> entry) {
        du1.p(entry);
        return new C5054f(entry);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> yt2<Map.Entry<K, V>> G(Iterator<Map.Entry<K, V>> it) {
        return new C5055g(it);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> Set<Map.Entry<K, V>> H(Set<Map.Entry<K, V>> set) {
        return new C5068r(Collections.unmodifiableSet(set));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @GwtIncompatible
    public static <K, V> NavigableMap<K, V> I(NavigableMap<K, ? extends V> navigableMap) {
        du1.p(navigableMap);
        return navigableMap instanceof UnmodifiableNavigableMap ? navigableMap : new UnmodifiableNavigableMap(navigableMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NullableDecl
    public static <K, V> Map.Entry<K, V> J(@NullableDecl Map.Entry<K, ? extends V> entry) {
        if (entry == null) {
            return null;
        }
        return F(entry);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <V> Function<Map.Entry<?, V>, V> K() {
        return EntryFunction.VALUE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> Iterator<V> L(Iterator<Map.Entry<K, V>> it) {
        return new C5052d(it);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NullableDecl
    public static <V> V M(@NullableDecl Map.Entry<?, V> entry) {
        if (entry == null) {
            return null;
        }
        return entry.getValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <V> Predicate<Map.Entry<?, V>> N(Predicate<? super V> predicate) {
        return Predicates.c(predicate, K());
    }

    static <K, V1, V2> Function<Map.Entry<K, V1>, Map.Entry<K, V2>> b(EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        du1.p(entryTransformer);
        return new C5050b(entryTransformer);
    }

    static <K, V1, V2> EntryTransformer<K, V1, V2> c(Function<? super V1, V2> function) {
        du1.p(function);
        return new C5056h(function);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> Iterator<Map.Entry<K, V>> d(Set<K> set, Function<? super K, V> function) {
        return new C5053e(set.iterator(), function);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(int i) {
        if (i < 3) {
            C5191k.b(i, "expectedSize");
            return i + 1;
        } else if (i < 1073741824) {
            return (int) ((i / 0.75f) + 1.0f);
        } else {
            return Integer.MAX_VALUE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> boolean f(Collection<Map.Entry<K, V>> collection, Object obj) {
        if (obj instanceof Map.Entry) {
            return collection.contains(F((Map.Entry) obj));
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean g(Map<?, ?> map, @NullableDecl Object obj) {
        return Iterators.f(m(map.entrySet().iterator()), obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean h(Map<?, ?> map, @NullableDecl Object obj) {
        return Iterators.f(L(map.entrySet().iterator()), obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean i(Map<?, ?> map, Object obj) {
        if (map == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return map.entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    @GwtCompatible(serializable = true)
    public static <K, V> Map.Entry<K, V> j(@NullableDecl K k, @NullableDecl V v) {
        return new ImmutableEntry(k, v);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> ImmutableMap<E, Integer> k(Collection<E> collection) {
        ImmutableMap.C4977b c4977b = new ImmutableMap.C4977b(collection.size());
        int i = 0;
        for (E e : collection) {
            c4977b.c(e, Integer.valueOf(i));
            i++;
        }
        return c4977b.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K> Function<Map.Entry<K, ?>, K> l() {
        return EntryFunction.KEY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> Iterator<K> m(Iterator<Map.Entry<K, V>> it) {
        return new C5051c(it);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NullableDecl
    public static <K> K n(@NullableDecl Map.Entry<K, ?> entry) {
        if (entry == null) {
            return null;
        }
        return entry.getKey();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K> Predicate<Map.Entry<K, ?>> o(Predicate<? super K> predicate) {
        return Predicates.c(predicate, l());
    }

    public static <K, V> HashMap<K, V> p() {
        return new HashMap<>();
    }

    public static <K, V> HashMap<K, V> q(int i) {
        return new HashMap<>(e(i));
    }

    public static <K, V> IdentityHashMap<K, V> r() {
        return new IdentityHashMap<>();
    }

    public static <K, V> LinkedHashMap<K, V> s() {
        return new LinkedHashMap<>();
    }

    public static <K, V> LinkedHashMap<K, V> t(int i) {
        return new LinkedHashMap<>(e(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> void u(Map<K, V> map, Map<? extends K, ? extends V> map2) {
        for (Map.Entry<? extends K, ? extends V> entry : map2.entrySet()) {
            map.put(entry.getKey(), entry.getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> boolean v(Collection<Map.Entry<K, V>> collection, Object obj) {
        if (obj instanceof Map.Entry) {
            return collection.remove(F((Map.Entry) obj));
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean w(Map<?, ?> map, Object obj) {
        du1.p(map);
        try {
            return map.containsKey(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <V> V x(Map<?, V> map, @NullableDecl Object obj) {
        du1.p(map);
        try {
            return map.get(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <V> V y(Map<?, V> map, Object obj) {
        du1.p(map);
        try {
            return map.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String z(Map<?, ?> map) {
        StringBuilder c = C5193l.c(map.size());
        c.append('{');
        boolean z = true;
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            if (!z) {
                c.append(AVFSCacheConstants.COMMA_SEP);
            }
            z = false;
            c.append(entry.getKey());
            c.append(C4250a.h);
            c.append(entry.getValue());
        }
        c.append('}');
        return c.toString();
    }
}
