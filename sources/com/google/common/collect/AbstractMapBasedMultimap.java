package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.AbstractC5159c;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimaps;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.du1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
@GwtCompatible
/* loaded from: classes10.dex */
public abstract class AbstractMapBasedMultimap<K, V> extends AbstractC5159c<K, V> implements Serializable {
    private static final long serialVersionUID = 2447537837011683357L;
    private transient Map<K, Collection<V>> map;
    private transient int totalSize;

    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.AbstractMapBasedMultimap$a */
    /* loaded from: classes10.dex */
    class C4900a extends AbstractMapBasedMultimap<K, V>.AbstractC4905d<V> {
        C4900a(AbstractMapBasedMultimap abstractMapBasedMultimap) {
            super();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.AbstractC4905d
        V a(K k, V v) {
            return v;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.AbstractMapBasedMultimap$b */
    /* loaded from: classes10.dex */
    class C4901b extends AbstractMapBasedMultimap<K, V>.AbstractC4905d<Map.Entry<K, V>> {
        C4901b(AbstractMapBasedMultimap abstractMapBasedMultimap) {
            super();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.AbstractMapBasedMultimap.AbstractC4905d
        /* renamed from: b */
        public Map.Entry<K, V> a(K k, V v) {
            return Maps.j(k, v);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.AbstractMapBasedMultimap$c */
    /* loaded from: classes10.dex */
    public class C4902c extends Maps.AbstractC5070t<K, Collection<V>> {
        final transient Map<K, Collection<V>> d;

        /* compiled from: Taobao */
        /* renamed from: com.google.common.collect.AbstractMapBasedMultimap$c$a */
        /* loaded from: classes10.dex */
        class C4903a extends Maps.AbstractC5059j<K, Collection<V>> {
            C4903a() {
            }

            @Override // com.google.common.collect.Maps.AbstractC5059j
            Map<K, Collection<V>> a() {
                return C4902c.this;
            }

            @Override // com.google.common.collect.Maps.AbstractC5059j, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                return C5193l.d(C4902c.this.d.entrySet(), obj);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return new C4904b();
            }

            @Override // com.google.common.collect.Maps.AbstractC5059j, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (contains(obj)) {
                    AbstractMapBasedMultimap.this.removeValuesForKey(((Map.Entry) obj).getKey());
                    return true;
                }
                return false;
            }
        }

        /* compiled from: Taobao */
        /* renamed from: com.google.common.collect.AbstractMapBasedMultimap$c$b */
        /* loaded from: classes10.dex */
        class C4904b implements Iterator<Map.Entry<K, Collection<V>>> {
            final Iterator<Map.Entry<K, Collection<V>>> a;
            @NullableDecl
            Collection<V> b;

            C4904b() {
                this.a = C4902c.this.d.entrySet().iterator();
            }

            @Override // java.util.Iterator
            /* renamed from: a */
            public Map.Entry<K, Collection<V>> next() {
                Map.Entry<K, Collection<V>> next = this.a.next();
                this.b = next.getValue();
                return C4902c.this.f(next);
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.a.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                C5191k.e(this.b != null);
                this.a.remove();
                AbstractMapBasedMultimap.this.totalSize -= this.b.size();
                this.b.clear();
                this.b = null;
            }
        }

        C4902c(Map<K, Collection<V>> map) {
            this.d = map;
        }

        @Override // com.google.common.collect.Maps.AbstractC5070t
        protected Set<Map.Entry<K, Collection<V>>> a() {
            return new C4903a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            if (this.d == AbstractMapBasedMultimap.this.map) {
                AbstractMapBasedMultimap.this.clear();
            } else {
                Iterators.d(new C4904b());
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return Maps.w(this.d, obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: d */
        public Collection<V> get(Object obj) {
            Collection<V> collection = (Collection) Maps.x(this.d, obj);
            if (collection == null) {
                return null;
            }
            return AbstractMapBasedMultimap.this.wrapCollection(obj, collection);
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: e */
        public Collection<V> remove(Object obj) {
            Collection<V> remove = this.d.remove(obj);
            if (remove == null) {
                return null;
            }
            Collection<V> createCollection = AbstractMapBasedMultimap.this.createCollection();
            createCollection.addAll(remove);
            AbstractMapBasedMultimap.this.totalSize -= remove.size();
            remove.clear();
            return createCollection;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean equals(@NullableDecl Object obj) {
            return this == obj || this.d.equals(obj);
        }

        Map.Entry<K, Collection<V>> f(Map.Entry<K, Collection<V>> entry) {
            K key = entry.getKey();
            return Maps.j(key, AbstractMapBasedMultimap.this.wrapCollection(key, entry.getValue()));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int hashCode() {
            return this.d.hashCode();
        }

        @Override // com.google.common.collect.Maps.AbstractC5070t, java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return AbstractMapBasedMultimap.this.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.d.size();
        }

        @Override // java.util.AbstractMap
        public String toString() {
            return this.d.toString();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.AbstractMapBasedMultimap$d */
    /* loaded from: classes10.dex */
    private abstract class AbstractC4905d<T> implements Iterator<T> {
        final Iterator<Map.Entry<K, Collection<V>>> a;
        @NullableDecl
        K b = null;
        @MonotonicNonNullDecl
        Collection<V> c = null;
        Iterator<V> d = Iterators.j();

        AbstractC4905d() {
            this.a = (Iterator<Map.Entry<K, V>>) AbstractMapBasedMultimap.this.map.entrySet().iterator();
        }

        abstract T a(K k, V v);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a.hasNext() || this.d.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            if (!this.d.hasNext()) {
                Map.Entry<K, Collection<V>> next = this.a.next();
                this.b = next.getKey();
                Collection<V> value = next.getValue();
                this.c = value;
                this.d = value.iterator();
            }
            return a(this.b, this.d.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            this.d.remove();
            if (this.c.isEmpty()) {
                this.a.remove();
            }
            AbstractMapBasedMultimap.access$210(AbstractMapBasedMultimap.this);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.AbstractMapBasedMultimap$e */
    /* loaded from: classes10.dex */
    private class C4906e extends Maps.C5062l<K, Collection<V>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Taobao */
        /* renamed from: com.google.common.collect.AbstractMapBasedMultimap$e$a */
        /* loaded from: classes10.dex */
        public class C4907a implements Iterator<K> {
            @NullableDecl
            Map.Entry<K, Collection<V>> a;
            final /* synthetic */ Iterator b;

            C4907a(Iterator it) {
                this.b = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.b.hasNext();
            }

            @Override // java.util.Iterator
            public K next() {
                Map.Entry<K, Collection<V>> entry = (Map.Entry) this.b.next();
                this.a = entry;
                return entry.getKey();
            }

            @Override // java.util.Iterator
            public void remove() {
                C5191k.e(this.a != null);
                Collection<V> value = this.a.getValue();
                this.b.remove();
                AbstractMapBasedMultimap.this.totalSize -= value.size();
                value.clear();
                this.a = null;
            }
        }

        C4906e(Map<K, Collection<V>> map) {
            super(map);
        }

        @Override // com.google.common.collect.Maps.C5062l, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Iterators.d(iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return a().keySet().containsAll(collection);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public boolean equals(@NullableDecl Object obj) {
            return this == obj || a().keySet().equals(obj);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return a().keySet().hashCode();
        }

        @Override // com.google.common.collect.Maps.C5062l, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new C4907a(a().entrySet().iterator());
        }

        @Override // com.google.common.collect.Maps.C5062l, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int i;
            Collection<V> remove = a().remove(obj);
            if (remove != null) {
                i = remove.size();
                remove.clear();
                AbstractMapBasedMultimap.this.totalSize -= i;
            } else {
                i = 0;
            }
            return i > 0;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.AbstractMapBasedMultimap$f */
    /* loaded from: classes10.dex */
    class C4908f extends AbstractMapBasedMultimap<K, V>.C4911i implements NavigableMap<K, Collection<V>> {
        C4908f(NavigableMap<K, Collection<V>> navigableMap) {
            super(navigableMap);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> ceilingEntry(K k) {
            Map.Entry<K, Collection<V>> ceilingEntry = i().ceilingEntry(k);
            if (ceilingEntry == null) {
                return null;
            }
            return f(ceilingEntry);
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K k) {
            return i().ceilingKey(k);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return descendingMap().navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> descendingMap() {
            return new C4908f(i().descendingMap());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> firstEntry() {
            Map.Entry<K, Collection<V>> firstEntry = i().firstEntry();
            if (firstEntry == null) {
                return null;
            }
            return f(firstEntry);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> floorEntry(K k) {
            Map.Entry<K, Collection<V>> floorEntry = i().floorEntry(k);
            if (floorEntry == null) {
                return null;
            }
            return f(floorEntry);
        }

        @Override // java.util.NavigableMap
        public K floorKey(K k) {
            return i().floorKey(k);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> higherEntry(K k) {
            Map.Entry<K, Collection<V>> higherEntry = i().higherEntry(k);
            if (higherEntry == null) {
                return null;
            }
            return f(higherEntry);
        }

        @Override // java.util.NavigableMap
        public K higherKey(K k) {
            return i().higherKey(k);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.AbstractMapBasedMultimap.C4911i
        /* renamed from: j */
        public NavigableSet<K> g() {
            return new C4909g(i());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.C4911i, java.util.SortedMap, java.util.NavigableMap
        /* renamed from: k */
        public NavigableMap<K, Collection<V>> headMap(K k) {
            return headMap(k, false);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.C4911i, com.google.common.collect.AbstractMapBasedMultimap.C4902c, com.google.common.collect.Maps.AbstractC5070t, java.util.AbstractMap, java.util.Map
        /* renamed from: l */
        public NavigableSet<K> keySet() {
            return (NavigableSet) super.keySet();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> lastEntry() {
            Map.Entry<K, Collection<V>> lastEntry = i().lastEntry();
            if (lastEntry == null) {
                return null;
            }
            return f(lastEntry);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> lowerEntry(K k) {
            Map.Entry<K, Collection<V>> lowerEntry = i().lowerEntry(k);
            if (lowerEntry == null) {
                return null;
            }
            return f(lowerEntry);
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K k) {
            return i().lowerKey(k);
        }

        Map.Entry<K, Collection<V>> m(Iterator<Map.Entry<K, Collection<V>>> it) {
            if (it.hasNext()) {
                Map.Entry<K, Collection<V>> next = it.next();
                Collection<V> createCollection = AbstractMapBasedMultimap.this.createCollection();
                createCollection.addAll(next.getValue());
                it.remove();
                return Maps.j(next.getKey(), AbstractMapBasedMultimap.this.unmodifiableCollectionSubclass(createCollection));
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.AbstractMapBasedMultimap.C4911i
        /* renamed from: n */
        public NavigableMap<K, Collection<V>> i() {
            return (NavigableMap) super.i();
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            return keySet();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.C4911i, java.util.SortedMap, java.util.NavigableMap
        /* renamed from: o */
        public NavigableMap<K, Collection<V>> subMap(K k, K k2) {
            return subMap(k, true, k2, false);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.C4911i, java.util.SortedMap, java.util.NavigableMap
        /* renamed from: p */
        public NavigableMap<K, Collection<V>> tailMap(K k) {
            return tailMap(k, true);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> pollFirstEntry() {
            return m(entrySet().iterator());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> pollLastEntry() {
            return m(descendingMap().entrySet().iterator());
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> headMap(K k, boolean z) {
            return new C4908f(i().headMap(k, z));
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> subMap(K k, boolean z, K k2, boolean z2) {
            return new C4908f(i().subMap(k, z, k2, z2));
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> tailMap(K k, boolean z) {
            return new C4908f(i().tailMap(k, z));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.AbstractMapBasedMultimap$g */
    /* loaded from: classes10.dex */
    public class C4909g extends AbstractMapBasedMultimap<K, V>.C4912j implements NavigableSet<K> {
        C4909g(NavigableMap<K, Collection<V>> navigableMap) {
            super(navigableMap);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.C4912j, java.util.SortedSet, java.util.NavigableSet
        /* renamed from: c */
        public NavigableSet<K> headSet(K k) {
            return headSet(k, false);
        }

        @Override // java.util.NavigableSet
        public K ceiling(K k) {
            return b().ceilingKey(k);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.AbstractMapBasedMultimap.C4912j
        /* renamed from: d */
        public NavigableMap<K, Collection<V>> b() {
            return (NavigableMap) super.b();
        }

        @Override // java.util.NavigableSet
        public Iterator<K> descendingIterator() {
            return descendingSet().iterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> descendingSet() {
            return new C4909g(b().descendingMap());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.C4912j, java.util.SortedSet, java.util.NavigableSet
        /* renamed from: e */
        public NavigableSet<K> subSet(K k, K k2) {
            return subSet(k, true, k2, false);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.C4912j, java.util.SortedSet, java.util.NavigableSet
        /* renamed from: f */
        public NavigableSet<K> tailSet(K k) {
            return tailSet(k, true);
        }

        @Override // java.util.NavigableSet
        public K floor(K k) {
            return b().floorKey(k);
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
            return (K) Iterators.q(iterator());
        }

        @Override // java.util.NavigableSet
        public K pollLast() {
            return (K) Iterators.q(descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> headSet(K k, boolean z) {
            return new C4909g(b().headMap(k, z));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> subSet(K k, boolean z, K k2, boolean z2) {
            return new C4909g(b().subMap(k, z, k2, z2));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> tailSet(K k, boolean z) {
            return new C4909g(b().tailMap(k, z));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.AbstractMapBasedMultimap$h */
    /* loaded from: classes10.dex */
    public class C4910h extends AbstractMapBasedMultimap<K, V>.C4915l implements RandomAccess {
        C4910h(@NullableDecl AbstractMapBasedMultimap abstractMapBasedMultimap, K k, @NullableDecl List<V> list, AbstractMapBasedMultimap<K, V>.C4913k c4913k) {
            super(k, list, c4913k);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.AbstractMapBasedMultimap$i */
    /* loaded from: classes10.dex */
    public class C4911i extends AbstractMapBasedMultimap<K, V>.C4902c implements SortedMap<K, Collection<V>> {
        @MonotonicNonNullDecl
        SortedSet<K> f;

        C4911i(SortedMap<K, Collection<V>> sortedMap) {
            super(sortedMap);
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            return i().comparator();
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return i().firstKey();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Maps.AbstractC5070t
        /* renamed from: g */
        public SortedSet<K> b() {
            return new C4912j(i());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.C4902c, com.google.common.collect.Maps.AbstractC5070t, java.util.AbstractMap, java.util.Map
        /* renamed from: h */
        public SortedSet<K> keySet() {
            SortedSet<K> sortedSet = this.f;
            if (sortedSet == null) {
                SortedSet<K> b = b();
                this.f = b;
                return b;
            }
            return sortedSet;
        }

        public SortedMap<K, Collection<V>> headMap(K k) {
            return new C4911i(i().headMap(k));
        }

        SortedMap<K, Collection<V>> i() {
            return (SortedMap) this.d;
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            return i().lastKey();
        }

        public SortedMap<K, Collection<V>> subMap(K k, K k2) {
            return new C4911i(i().subMap(k, k2));
        }

        public SortedMap<K, Collection<V>> tailMap(K k) {
            return new C4911i(i().tailMap(k));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.AbstractMapBasedMultimap$j */
    /* loaded from: classes10.dex */
    public class C4912j extends AbstractMapBasedMultimap<K, V>.C4906e implements SortedSet<K> {
        C4912j(SortedMap<K, Collection<V>> sortedMap) {
            super(sortedMap);
        }

        SortedMap<K, Collection<V>> b() {
            return (SortedMap) super.a();
        }

        @Override // java.util.SortedSet
        public Comparator<? super K> comparator() {
            return b().comparator();
        }

        @Override // java.util.SortedSet
        public K first() {
            return b().firstKey();
        }

        public SortedSet<K> headSet(K k) {
            return new C4912j(b().headMap(k));
        }

        @Override // java.util.SortedSet
        public K last() {
            return b().lastKey();
        }

        public SortedSet<K> subSet(K k, K k2) {
            return new C4912j(b().subMap(k, k2));
        }

        public SortedSet<K> tailSet(K k) {
            return new C4912j(b().tailMap(k));
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.AbstractMapBasedMultimap$m */
    /* loaded from: classes10.dex */
    class C4917m extends AbstractMapBasedMultimap<K, V>.C4919o implements NavigableSet<V> {
        /* JADX INFO: Access modifiers changed from: package-private */
        public C4917m(@NullableDecl K k, NavigableSet<V> navigableSet, @NullableDecl AbstractMapBasedMultimap<K, V>.C4913k c4913k) {
            super(k, navigableSet, c4913k);
        }

        private NavigableSet<V> i(NavigableSet<V> navigableSet) {
            return new C4917m(this.a, navigableSet, b() == null ? this : b());
        }

        @Override // java.util.NavigableSet
        public V ceiling(V v) {
            return g().ceiling(v);
        }

        @Override // java.util.NavigableSet
        public Iterator<V> descendingIterator() {
            return new C4913k.C4914a(g().descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> descendingSet() {
            return i(g().descendingSet());
        }

        @Override // java.util.NavigableSet
        public V floor(V v) {
            return g().floor(v);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.AbstractMapBasedMultimap.C4919o
        /* renamed from: h */
        public NavigableSet<V> g() {
            return (NavigableSet) super.g();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> headSet(V v, boolean z) {
            return i(g().headSet(v, z));
        }

        @Override // java.util.NavigableSet
        public V higher(V v) {
            return g().higher(v);
        }

        @Override // java.util.NavigableSet
        public V lower(V v) {
            return g().lower(v);
        }

        @Override // java.util.NavigableSet
        public V pollFirst() {
            return (V) Iterators.q(iterator());
        }

        @Override // java.util.NavigableSet
        public V pollLast() {
            return (V) Iterators.q(descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> subSet(V v, boolean z, V v2, boolean z2) {
            return i(g().subSet(v, z, v2, z2));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> tailSet(V v, boolean z) {
            return i(g().tailSet(v, z));
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.AbstractMapBasedMultimap$n */
    /* loaded from: classes10.dex */
    class C4918n extends AbstractMapBasedMultimap<K, V>.C4913k implements Set<V> {
        /* JADX INFO: Access modifiers changed from: package-private */
        public C4918n(@NullableDecl K k, Set<V> set) {
            super(k, set, null);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.C4913k, java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean h = Sets.h((Set) this.b, collection);
            if (h) {
                int size2 = this.b.size();
                AbstractMapBasedMultimap.this.totalSize += size2 - size;
                f();
            }
            return h;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.AbstractMapBasedMultimap$o */
    /* loaded from: classes10.dex */
    public class C4919o extends AbstractMapBasedMultimap<K, V>.C4913k implements SortedSet<V> {
        /* JADX INFO: Access modifiers changed from: package-private */
        public C4919o(@NullableDecl K k, SortedSet<V> sortedSet, @NullableDecl AbstractMapBasedMultimap<K, V>.C4913k c4913k) {
            super(k, sortedSet, c4913k);
        }

        @Override // java.util.SortedSet
        public Comparator<? super V> comparator() {
            return g().comparator();
        }

        @Override // java.util.SortedSet
        public V first() {
            e();
            return g().first();
        }

        SortedSet<V> g() {
            return (SortedSet) c();
        }

        @Override // java.util.SortedSet
        public SortedSet<V> headSet(V v) {
            e();
            return new C4919o(d(), g().headSet(v), b() == null ? this : b());
        }

        @Override // java.util.SortedSet
        public V last() {
            e();
            return g().last();
        }

        @Override // java.util.SortedSet
        public SortedSet<V> subSet(V v, V v2) {
            e();
            return new C4919o(d(), g().subSet(v, v2), b() == null ? this : b());
        }

        @Override // java.util.SortedSet
        public SortedSet<V> tailSet(V v) {
            e();
            return new C4919o(d(), g().tailSet(v), b() == null ? this : b());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractMapBasedMultimap(Map<K, Collection<V>> map) {
        du1.d(map.isEmpty());
        this.map = map;
    }

    static /* synthetic */ int access$208(AbstractMapBasedMultimap abstractMapBasedMultimap) {
        int i = abstractMapBasedMultimap.totalSize;
        abstractMapBasedMultimap.totalSize = i + 1;
        return i;
    }

    static /* synthetic */ int access$210(AbstractMapBasedMultimap abstractMapBasedMultimap) {
        int i = abstractMapBasedMultimap.totalSize;
        abstractMapBasedMultimap.totalSize = i - 1;
        return i;
    }

    private Collection<V> getOrCreateCollection(@NullableDecl K k) {
        Collection<V> collection = this.map.get(k);
        if (collection == null) {
            Collection<V> createCollection = createCollection(k);
            this.map.put(k, createCollection);
            return createCollection;
        }
        return collection;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> Iterator<E> iteratorOrListIterator(Collection<E> collection) {
        if (collection instanceof List) {
            return ((List) collection).listIterator();
        }
        return collection.iterator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeValuesForKey(Object obj) {
        Collection collection = (Collection) Maps.y(this.map, obj);
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            this.totalSize -= size;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<K, Collection<V>> backingMap() {
        return this.map;
    }

    @Override // com.google.common.collect.Multimap
    public void clear() {
        for (Collection<V> collection : this.map.values()) {
            collection.clear();
        }
        this.map.clear();
        this.totalSize = 0;
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsKey(@NullableDecl Object obj) {
        return this.map.containsKey(obj);
    }

    @Override // com.google.common.collect.AbstractC5159c
    Map<K, Collection<V>> createAsMap() {
        return new C4902c(this.map);
    }

    abstract Collection<V> createCollection();

    /* JADX INFO: Access modifiers changed from: package-private */
    public Collection<V> createCollection(@NullableDecl K k) {
        return createCollection();
    }

    @Override // com.google.common.collect.AbstractC5159c
    Collection<Map.Entry<K, V>> createEntries() {
        if (this instanceof SetMultimap) {
            return new AbstractC5159c.C5161b(this);
        }
        return new AbstractC5159c.C5160a();
    }

    @Override // com.google.common.collect.AbstractC5159c
    Set<K> createKeySet() {
        return new C4906e(this.map);
    }

    @Override // com.google.common.collect.AbstractC5159c
    Multiset<K> createKeys() {
        return new Multimaps.C5078c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map<K, Collection<V>> createMaybeNavigableAsMap() {
        Map<K, Collection<V>> map = this.map;
        if (map instanceof NavigableMap) {
            return new C4908f((NavigableMap) this.map);
        }
        if (map instanceof SortedMap) {
            return new C4911i((SortedMap) this.map);
        }
        return new C4902c(this.map);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set<K> createMaybeNavigableKeySet() {
        Map<K, Collection<V>> map = this.map;
        if (map instanceof NavigableMap) {
            return new C4909g((NavigableMap) this.map);
        }
        if (map instanceof SortedMap) {
            return new C4912j((SortedMap) this.map);
        }
        return new C4906e(this.map);
    }

    Collection<V> createUnmodifiableEmptyCollection() {
        return (Collection<V>) unmodifiableCollectionSubclass(createCollection());
    }

    @Override // com.google.common.collect.AbstractC5159c
    Collection<V> createValues() {
        return new AbstractC5159c.C5162c();
    }

    @Override // com.google.common.collect.AbstractC5159c, com.google.common.collect.Multimap
    public Collection<Map.Entry<K, V>> entries() {
        return super.entries();
    }

    @Override // com.google.common.collect.AbstractC5159c
    Iterator<Map.Entry<K, V>> entryIterator() {
        return new C4901b(this);
    }

    @Override // com.google.common.collect.Multimap
    public Collection<V> get(@NullableDecl K k) {
        Collection<V> collection = this.map.get(k);
        if (collection == null) {
            collection = createCollection(k);
        }
        return wrapCollection(k, collection);
    }

    @Override // com.google.common.collect.AbstractC5159c, com.google.common.collect.Multimap
    public boolean put(@NullableDecl K k, @NullableDecl V v) {
        Collection<V> collection = this.map.get(k);
        if (collection == null) {
            Collection<V> createCollection = createCollection(k);
            if (createCollection.add(v)) {
                this.totalSize++;
                this.map.put(k, createCollection);
                return true;
            }
            throw new AssertionError("New Collection violated the Collection spec");
        } else if (collection.add(v)) {
            this.totalSize++;
            return true;
        } else {
            return false;
        }
    }

    @Override // com.google.common.collect.Multimap
    public Collection<V> removeAll(@NullableDecl Object obj) {
        Collection<V> remove = this.map.remove(obj);
        if (remove == null) {
            return createUnmodifiableEmptyCollection();
        }
        Collection createCollection = createCollection();
        createCollection.addAll(remove);
        this.totalSize -= remove.size();
        remove.clear();
        return (Collection<V>) unmodifiableCollectionSubclass(createCollection);
    }

    @Override // com.google.common.collect.AbstractC5159c, com.google.common.collect.Multimap
    public Collection<V> replaceValues(@NullableDecl K k, Iterable<? extends V> iterable) {
        Iterator<? extends V> it = iterable.iterator();
        if (!it.hasNext()) {
            return removeAll(k);
        }
        Collection<V> orCreateCollection = getOrCreateCollection(k);
        Collection createCollection = createCollection();
        createCollection.addAll(orCreateCollection);
        this.totalSize -= orCreateCollection.size();
        orCreateCollection.clear();
        while (it.hasNext()) {
            if (orCreateCollection.add(it.next())) {
                this.totalSize++;
            }
        }
        return (Collection<V>) unmodifiableCollectionSubclass(createCollection);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setMap(Map<K, Collection<V>> map) {
        this.map = map;
        this.totalSize = 0;
        for (Collection<V> collection : map.values()) {
            du1.d(!collection.isEmpty());
            this.totalSize += collection.size();
        }
    }

    @Override // com.google.common.collect.Multimap
    public int size() {
        return this.totalSize;
    }

    <E> Collection<E> unmodifiableCollectionSubclass(Collection<E> collection) {
        return Collections.unmodifiableCollection(collection);
    }

    @Override // com.google.common.collect.AbstractC5159c
    Iterator<V> valueIterator() {
        return new C4900a(this);
    }

    @Override // com.google.common.collect.AbstractC5159c, com.google.common.collect.Multimap
    public Collection<V> values() {
        return super.values();
    }

    Collection<V> wrapCollection(@NullableDecl K k, Collection<V> collection) {
        return new C4913k(k, collection, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<V> wrapList(@NullableDecl K k, List<V> list, @NullableDecl AbstractMapBasedMultimap<K, V>.C4913k c4913k) {
        return list instanceof RandomAccess ? new C4910h(this, k, list, c4913k) : new C4915l(k, list, c4913k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.AbstractMapBasedMultimap$k */
    /* loaded from: classes10.dex */
    public class C4913k extends AbstractCollection<V> {
        @NullableDecl
        final K a;
        Collection<V> b;
        @NullableDecl
        final AbstractMapBasedMultimap<K, V>.C4913k c;
        @NullableDecl
        final Collection<V> d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C4913k(@NullableDecl K k, Collection<V> collection, @NullableDecl AbstractMapBasedMultimap<K, V>.C4913k c4913k) {
            this.a = k;
            this.b = collection;
            this.c = c4913k;
            this.d = c4913k == null ? null : c4913k.c();
        }

        void a() {
            AbstractMapBasedMultimap<K, V>.C4913k c4913k = this.c;
            if (c4913k == null) {
                AbstractMapBasedMultimap.this.map.put(this.a, this.b);
            } else {
                c4913k.a();
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(V v) {
            e();
            boolean isEmpty = this.b.isEmpty();
            boolean add = this.b.add(v);
            if (add) {
                AbstractMapBasedMultimap.access$208(AbstractMapBasedMultimap.this);
                if (isEmpty) {
                    a();
                }
            }
            return add;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean addAll = this.b.addAll(collection);
            if (addAll) {
                int size2 = this.b.size();
                AbstractMapBasedMultimap.this.totalSize += size2 - size;
                if (size == 0) {
                    a();
                }
            }
            return addAll;
        }

        AbstractMapBasedMultimap<K, V>.C4913k b() {
            return this.c;
        }

        Collection<V> c() {
            return this.b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            int size = size();
            if (size == 0) {
                return;
            }
            this.b.clear();
            AbstractMapBasedMultimap.this.totalSize -= size;
            f();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            e();
            return this.b.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            e();
            return this.b.containsAll(collection);
        }

        K d() {
            return this.a;
        }

        void e() {
            Collection<V> collection;
            AbstractMapBasedMultimap<K, V>.C4913k c4913k = this.c;
            if (c4913k != null) {
                c4913k.e();
                if (this.c.c() != this.d) {
                    throw new ConcurrentModificationException();
                }
            } else if (!this.b.isEmpty() || (collection = (Collection) AbstractMapBasedMultimap.this.map.get(this.a)) == null) {
            } else {
                this.b = collection;
            }
        }

        @Override // java.util.Collection
        public boolean equals(@NullableDecl Object obj) {
            if (obj == this) {
                return true;
            }
            e();
            return this.b.equals(obj);
        }

        void f() {
            AbstractMapBasedMultimap<K, V>.C4913k c4913k = this.c;
            if (c4913k != null) {
                c4913k.f();
            } else if (this.b.isEmpty()) {
                AbstractMapBasedMultimap.this.map.remove(this.a);
            }
        }

        @Override // java.util.Collection
        public int hashCode() {
            e();
            return this.b.hashCode();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            e();
            return new C4914a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            e();
            boolean remove = this.b.remove(obj);
            if (remove) {
                AbstractMapBasedMultimap.access$210(AbstractMapBasedMultimap.this);
                f();
            }
            return remove;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean removeAll = this.b.removeAll(collection);
            if (removeAll) {
                int size2 = this.b.size();
                AbstractMapBasedMultimap.this.totalSize += size2 - size;
                f();
            }
            return removeAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            du1.p(collection);
            int size = size();
            boolean retainAll = this.b.retainAll(collection);
            if (retainAll) {
                int size2 = this.b.size();
                AbstractMapBasedMultimap.this.totalSize += size2 - size;
                f();
            }
            return retainAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            e();
            return this.b.size();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            e();
            return this.b.toString();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Taobao */
        /* renamed from: com.google.common.collect.AbstractMapBasedMultimap$k$a */
        /* loaded from: classes10.dex */
        public class C4914a implements Iterator<V> {
            final Iterator<V> a;
            final Collection<V> b;

            C4914a() {
                Collection<V> collection = C4913k.this.b;
                this.b = collection;
                this.a = AbstractMapBasedMultimap.iteratorOrListIterator(collection);
            }

            Iterator<V> a() {
                b();
                return this.a;
            }

            void b() {
                C4913k.this.e();
                if (C4913k.this.b != this.b) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                b();
                return this.a.hasNext();
            }

            @Override // java.util.Iterator
            public V next() {
                b();
                return this.a.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.a.remove();
                AbstractMapBasedMultimap.access$210(AbstractMapBasedMultimap.this);
                C4913k.this.f();
            }

            C4914a(Iterator<V> it) {
                this.b = C4913k.this.b;
                this.a = it;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.AbstractMapBasedMultimap$l */
    /* loaded from: classes10.dex */
    public class C4915l extends AbstractMapBasedMultimap<K, V>.C4913k implements List<V> {

        /* compiled from: Taobao */
        /* renamed from: com.google.common.collect.AbstractMapBasedMultimap$l$a */
        /* loaded from: classes10.dex */
        private class C4916a extends AbstractMapBasedMultimap<K, V>.C4913k.C4914a implements ListIterator<V> {
            C4916a() {
                super();
            }

            private ListIterator<V> c() {
                return (ListIterator) a();
            }

            @Override // java.util.ListIterator
            public void add(V v) {
                boolean isEmpty = C4915l.this.isEmpty();
                c().add(v);
                AbstractMapBasedMultimap.access$208(AbstractMapBasedMultimap.this);
                if (isEmpty) {
                    C4915l.this.a();
                }
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return c().hasPrevious();
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return c().nextIndex();
            }

            @Override // java.util.ListIterator
            public V previous() {
                return c().previous();
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return c().previousIndex();
            }

            @Override // java.util.ListIterator
            public void set(V v) {
                c().set(v);
            }

            public C4916a(int i) {
                super(C4915l.this.g().listIterator(i));
            }
        }

        C4915l(@NullableDecl K k, List<V> list, @NullableDecl AbstractMapBasedMultimap<K, V>.C4913k c4913k) {
            super(k, list, c4913k);
        }

        @Override // java.util.List
        public void add(int i, V v) {
            e();
            boolean isEmpty = c().isEmpty();
            g().add(i, v);
            AbstractMapBasedMultimap.access$208(AbstractMapBasedMultimap.this);
            if (isEmpty) {
                a();
            }
        }

        @Override // java.util.List
        public boolean addAll(int i, Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean addAll = g().addAll(i, collection);
            if (addAll) {
                int size2 = c().size();
                AbstractMapBasedMultimap.this.totalSize += size2 - size;
                if (size == 0) {
                    a();
                }
            }
            return addAll;
        }

        List<V> g() {
            return (List) c();
        }

        @Override // java.util.List
        public V get(int i) {
            e();
            return g().get(i);
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            e();
            return g().indexOf(obj);
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            e();
            return g().lastIndexOf(obj);
        }

        @Override // java.util.List
        public ListIterator<V> listIterator() {
            e();
            return new C4916a();
        }

        @Override // java.util.List
        public V remove(int i) {
            e();
            V remove = g().remove(i);
            AbstractMapBasedMultimap.access$210(AbstractMapBasedMultimap.this);
            f();
            return remove;
        }

        @Override // java.util.List
        public V set(int i, V v) {
            e();
            return g().set(i, v);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.List
        public List<V> subList(int i, int i2) {
            e();
            return AbstractMapBasedMultimap.this.wrapList(d(), g().subList(i, i2), b() == null ? this : b());
        }

        @Override // java.util.List
        public ListIterator<V> listIterator(int i) {
            e();
            return new C4916a(i);
        }
    }
}
