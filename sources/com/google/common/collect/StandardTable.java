package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.base.Supplier;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.collect.Table;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.du1;
import tb.gp0;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
@GwtCompatible
/* loaded from: classes10.dex */
public class StandardTable<R, C, V> extends com.google.common.collect.h<R, C, V> implements Serializable {
    private static final long serialVersionUID = 0;
    @GwtTransient
    final Map<R, Map<C, V>> backingMap;
    @MonotonicNonNullDecl
    private transient Set<C> columnKeySet;
    @MonotonicNonNullDecl
    private transient StandardTable<R, C, V>.f columnMap;
    @GwtTransient
    final Supplier<? extends Map<C, V>> factory;
    @MonotonicNonNullDecl
    private transient Map<R, Map<C, V>> rowMap;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private class b implements Iterator<Table.Cell<R, C, V>> {
        final Iterator<Map.Entry<R, Map<C, V>>> a;
        @NullableDecl
        Map.Entry<R, Map<C, V>> b;
        Iterator<Map.Entry<C, V>> c;

        private b() {
            this.a = StandardTable.this.backingMap.entrySet().iterator();
            this.c = Iterators.j();
        }

        @Override // java.util.Iterator
        /* renamed from: a */
        public Table.Cell<R, C, V> next() {
            if (!this.c.hasNext()) {
                Map.Entry<R, Map<C, V>> next = this.a.next();
                this.b = next;
                this.c = next.getValue().entrySet().iterator();
            }
            Map.Entry<C, V> next2 = this.c.next();
            return Tables.c(this.b.getKey(), next2.getKey(), next2.getValue());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a.hasNext() || this.c.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.c.remove();
            if (this.b.getValue().isEmpty()) {
                this.a.remove();
                this.b = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class c extends Maps.t<R, V> {
        final C d;

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        private class a extends Sets.a<Map.Entry<R, V>> {
            private a() {
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                c.this.d(Predicates.b());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    return StandardTable.this.containsMapping(entry.getKey(), c.this.d, entry.getValue());
                }
                return false;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean isEmpty() {
                c cVar = c.this;
                return !StandardTable.this.containsColumn(cVar.d);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<R, V>> iterator() {
                return new b();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    return StandardTable.this.removeMapping(entry.getKey(), c.this.d, entry.getValue());
                }
                return false;
            }

            @Override // com.google.common.collect.Sets.a, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                return c.this.d(Predicates.g(Predicates.e(collection)));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                int i = 0;
                for (Map<C, V> map : StandardTable.this.backingMap.values()) {
                    if (map.containsKey(c.this.d)) {
                        i++;
                    }
                }
                return i;
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        private class b extends AbstractIterator<Map.Entry<R, V>> {
            final Iterator<Map.Entry<R, Map<C, V>>> c;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: Taobao */
            /* loaded from: classes10.dex */
            public class a extends com.google.common.collect.b<R, V> {
                final /* synthetic */ Map.Entry a;

                a(Map.Entry entry) {
                    this.a = entry;
                }

                @Override // com.google.common.collect.b, java.util.Map.Entry
                public R getKey() {
                    return (R) this.a.getKey();
                }

                @Override // com.google.common.collect.b, java.util.Map.Entry
                public V getValue() {
                    return (V) ((Map) this.a.getValue()).get(c.this.d);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.common.collect.b, java.util.Map.Entry
                public V setValue(V v) {
                    return (V) ((Map) this.a.getValue()).put(c.this.d, du1.p(v));
                }
            }

            private b() {
                this.c = StandardTable.this.backingMap.entrySet().iterator();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: d */
            public Map.Entry<R, V> a() {
                while (this.c.hasNext()) {
                    Map.Entry<R, Map<C, V>> next = this.c.next();
                    if (next.getValue().containsKey(c.this.d)) {
                        return new a(next);
                    }
                }
                return b();
            }
        }

        /* compiled from: Taobao */
        /* renamed from: com.google.common.collect.StandardTable$c$c  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        private class C0233c extends Maps.l<R, V> {
            C0233c() {
                super(c.this);
            }

            @Override // com.google.common.collect.Maps.l, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                c cVar = c.this;
                return StandardTable.this.contains(obj, cVar.d);
            }

            @Override // com.google.common.collect.Maps.l, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                c cVar = c.this;
                return StandardTable.this.remove(obj, cVar.d) != null;
            }

            @Override // com.google.common.collect.Sets.a, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                return c.this.d(Maps.o(Predicates.g(Predicates.e(collection))));
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        private class d extends Maps.s<R, V> {
            d() {
                super(c.this);
            }

            @Override // com.google.common.collect.Maps.s, java.util.AbstractCollection, java.util.Collection
            public boolean remove(Object obj) {
                return obj != null && c.this.d(Maps.N(Predicates.d(obj)));
            }

            @Override // com.google.common.collect.Maps.s, java.util.AbstractCollection, java.util.Collection
            public boolean removeAll(Collection<?> collection) {
                return c.this.d(Maps.N(Predicates.e(collection)));
            }

            @Override // com.google.common.collect.Maps.s, java.util.AbstractCollection, java.util.Collection
            public boolean retainAll(Collection<?> collection) {
                return c.this.d(Maps.N(Predicates.g(Predicates.e(collection))));
            }
        }

        c(C c) {
            this.d = (C) du1.p(c);
        }

        @Override // com.google.common.collect.Maps.t
        Set<Map.Entry<R, V>> a() {
            return new a();
        }

        @Override // com.google.common.collect.Maps.t
        Set<R> b() {
            return new C0233c();
        }

        @Override // com.google.common.collect.Maps.t
        Collection<V> c() {
            return new d();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return StandardTable.this.contains(obj, this.d);
        }

        @CanIgnoreReturnValue
        boolean d(Predicate<? super Map.Entry<R, V>> predicate) {
            Iterator<Map.Entry<R, Map<C, V>>> it = StandardTable.this.backingMap.entrySet().iterator();
            boolean z = false;
            while (it.hasNext()) {
                Map.Entry<R, Map<C, V>> next = it.next();
                Map<C, V> value = next.getValue();
                V v = value.get(this.d);
                if (v != null && predicate.apply(Maps.j(next.getKey(), v))) {
                    value.remove(this.d);
                    z = true;
                    if (value.isEmpty()) {
                        it.remove();
                    }
                }
            }
            return z;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            return (V) StandardTable.this.get(obj, this.d);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(R r, V v) {
            return (V) StandardTable.this.put(r, this.d, v);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object obj) {
            return (V) StandardTable.this.remove(obj, this.d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class d extends AbstractIterator<C> {
        final Map<C, V> c;
        final Iterator<Map<C, V>> d;
        Iterator<Map.Entry<C, V>> e;

        private d() {
            this.c = StandardTable.this.factory.get();
            this.d = StandardTable.this.backingMap.values().iterator();
            this.e = Iterators.h();
        }

        @Override // com.google.common.collect.AbstractIterator
        protected C a() {
            while (true) {
                if (this.e.hasNext()) {
                    Map.Entry<C, V> next = this.e.next();
                    if (!this.c.containsKey(next.getKey())) {
                        this.c.put(next.getKey(), next.getValue());
                        return next.getKey();
                    }
                } else if (this.d.hasNext()) {
                    this.e = this.d.next().entrySet().iterator();
                } else {
                    return b();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class e extends StandardTable<R, C, V>.i<C> {
        private e() {
            super();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return StandardTable.this.containsColumn(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<C> iterator() {
            return StandardTable.this.createColumnKeyIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            boolean z = false;
            if (obj == null) {
                return false;
            }
            Iterator<Map<C, V>> it = StandardTable.this.backingMap.values().iterator();
            while (it.hasNext()) {
                Map<C, V> next = it.next();
                if (next.keySet().remove(obj)) {
                    z = true;
                    if (next.isEmpty()) {
                        it.remove();
                    }
                }
            }
            return z;
        }

        @Override // com.google.common.collect.Sets.a, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            du1.p(collection);
            Iterator<Map<C, V>> it = StandardTable.this.backingMap.values().iterator();
            boolean z = false;
            while (it.hasNext()) {
                Map<C, V> next = it.next();
                if (Iterators.r(next.keySet().iterator(), collection)) {
                    z = true;
                    if (next.isEmpty()) {
                        it.remove();
                    }
                }
            }
            return z;
        }

        @Override // com.google.common.collect.Sets.a, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            du1.p(collection);
            Iterator<Map<C, V>> it = StandardTable.this.backingMap.values().iterator();
            boolean z = false;
            while (it.hasNext()) {
                Map<C, V> next = it.next();
                if (next.keySet().retainAll(collection)) {
                    z = true;
                    if (next.isEmpty()) {
                        it.remove();
                    }
                }
            }
            return z;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Iterators.u(iterator());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class f extends Maps.t<C, Map<R, V>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public class a extends StandardTable<R, C, V>.i<Map.Entry<C, Map<R, V>>> {

            /* compiled from: Taobao */
            /* renamed from: com.google.common.collect.StandardTable$f$a$a  reason: collision with other inner class name */
            /* loaded from: classes10.dex */
            class C0234a implements Function<C, Map<R, V>> {
                C0234a() {
                }

                @Override // com.google.common.base.Function
                /* renamed from: a */
                public Map<R, V> apply(C c) {
                    return StandardTable.this.column(c);
                }
            }

            a() {
                super();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    if (StandardTable.this.containsColumn(entry.getKey())) {
                        return f.this.get(entry.getKey()).equals(entry.getValue());
                    }
                    return false;
                }
                return false;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<C, Map<R, V>>> iterator() {
                return Maps.d(StandardTable.this.columnKeySet(), new C0234a());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (contains(obj)) {
                    StandardTable.this.removeColumn(((Map.Entry) obj).getKey());
                    return true;
                }
                return false;
            }

            @Override // com.google.common.collect.Sets.a, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection<?> collection) {
                du1.p(collection);
                return Sets.i(this, collection.iterator());
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.Sets.a, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                du1.p(collection);
                Iterator it = Lists.k(StandardTable.this.columnKeySet().iterator()).iterator();
                boolean z = false;
                while (it.hasNext()) {
                    Object next = it.next();
                    if (!collection.contains(Maps.j(next, StandardTable.this.column(next)))) {
                        StandardTable.this.removeColumn(next);
                        z = true;
                    }
                }
                return z;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return StandardTable.this.columnKeySet().size();
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        private class b extends Maps.s<C, Map<R, V>> {
            b() {
                super(f.this);
            }

            @Override // com.google.common.collect.Maps.s, java.util.AbstractCollection, java.util.Collection
            public boolean remove(Object obj) {
                for (Map.Entry<C, Map<R, V>> entry : f.this.entrySet()) {
                    if (entry.getValue().equals(obj)) {
                        StandardTable.this.removeColumn(entry.getKey());
                        return true;
                    }
                }
                return false;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.Maps.s, java.util.AbstractCollection, java.util.Collection
            public boolean removeAll(Collection<?> collection) {
                du1.p(collection);
                Iterator it = Lists.k(StandardTable.this.columnKeySet().iterator()).iterator();
                boolean z = false;
                while (it.hasNext()) {
                    Object next = it.next();
                    if (collection.contains(StandardTable.this.column(next))) {
                        StandardTable.this.removeColumn(next);
                        z = true;
                    }
                }
                return z;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.Maps.s, java.util.AbstractCollection, java.util.Collection
            public boolean retainAll(Collection<?> collection) {
                du1.p(collection);
                Iterator it = Lists.k(StandardTable.this.columnKeySet().iterator()).iterator();
                boolean z = false;
                while (it.hasNext()) {
                    Object next = it.next();
                    if (!collection.contains(StandardTable.this.column(next))) {
                        StandardTable.this.removeColumn(next);
                        z = true;
                    }
                }
                return z;
            }
        }

        private f() {
        }

        @Override // com.google.common.collect.Maps.t
        public Set<Map.Entry<C, Map<R, V>>> a() {
            return new a();
        }

        @Override // com.google.common.collect.Maps.t
        Collection<Map<R, V>> c() {
            return new b();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return StandardTable.this.containsColumn(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: d */
        public Map<R, V> get(Object obj) {
            if (StandardTable.this.containsColumn(obj)) {
                return StandardTable.this.column(obj);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: e */
        public Map<R, V> remove(Object obj) {
            if (StandardTable.this.containsColumn(obj)) {
                return StandardTable.this.removeColumn(obj);
            }
            return null;
        }

        @Override // com.google.common.collect.Maps.t, java.util.AbstractMap, java.util.Map
        public Set<C> keySet() {
            return StandardTable.this.columnKeySet();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class g extends Maps.k<C, V> {
        final R a;
        @NullableDecl
        Map<C, V> b;

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        class a implements Iterator<Map.Entry<C, V>> {
            final /* synthetic */ Iterator a;

            a(Iterator it) {
                this.a = it;
            }

            @Override // java.util.Iterator
            /* renamed from: a */
            public Map.Entry<C, V> next() {
                return g.this.e((Map.Entry) this.a.next());
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.a.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.a.remove();
                g.this.d();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public class b extends gp0<C, V> {
            final /* synthetic */ Map.Entry a;

            b(g gVar, Map.Entry entry) {
                this.a = entry;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.t
            /* renamed from: a */
            public Map.Entry<C, V> delegate() {
                return this.a;
            }

            @Override // tb.gp0, java.util.Map.Entry
            public boolean equals(Object obj) {
                return standardEquals(obj);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // tb.gp0, java.util.Map.Entry
            public V setValue(V v) {
                return (V) super.setValue(du1.p(v));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public g(R r) {
            this.a = (R) du1.p(r);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Maps.k
        public Iterator<Map.Entry<C, V>> a() {
            Map<C, V> b2 = b();
            if (b2 == null) {
                return Iterators.j();
            }
            return new a(b2.entrySet().iterator());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Map<C, V> b() {
            Map<C, V> map = this.b;
            if (map == null || (map.isEmpty() && StandardTable.this.backingMap.containsKey(this.a))) {
                Map<C, V> c = c();
                this.b = c;
                return c;
            }
            return this.b;
        }

        Map<C, V> c() {
            return StandardTable.this.backingMap.get(this.a);
        }

        @Override // com.google.common.collect.Maps.k, java.util.AbstractMap, java.util.Map
        public void clear() {
            Map<C, V> b2 = b();
            if (b2 != null) {
                b2.clear();
            }
            d();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            Map<C, V> b2 = b();
            return (obj == null || b2 == null || !Maps.w(b2, obj)) ? false : true;
        }

        void d() {
            if (b() == null || !this.b.isEmpty()) {
                return;
            }
            StandardTable.this.backingMap.remove(this.a);
            this.b = null;
        }

        Map.Entry<C, V> e(Map.Entry<C, V> entry) {
            return new b(this, entry);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            Map<C, V> b2 = b();
            if (obj == null || b2 == null) {
                return null;
            }
            return (V) Maps.x(b2, obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(C c, V v) {
            du1.p(c);
            du1.p(v);
            Map<C, V> map = this.b;
            if (map != null && !map.isEmpty()) {
                return this.b.put(c, v);
            }
            return (V) StandardTable.this.put(this.a, c, v);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object obj) {
            Map<C, V> b2 = b();
            if (b2 == null) {
                return null;
            }
            V v = (V) Maps.y(b2, obj);
            d();
            return v;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            Map<C, V> b2 = b();
            if (b2 == null) {
                return 0;
            }
            return b2.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class h extends Maps.t<R, Map<C, V>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public class a extends StandardTable<R, C, V>.i<Map.Entry<R, Map<C, V>>> {

            /* compiled from: Taobao */
            /* renamed from: com.google.common.collect.StandardTable$h$a$a  reason: collision with other inner class name */
            /* loaded from: classes10.dex */
            class C0235a implements Function<R, Map<C, V>> {
                C0235a() {
                }

                @Override // com.google.common.base.Function
                /* renamed from: a */
                public Map<C, V> apply(R r) {
                    return StandardTable.this.row(r);
                }
            }

            a() {
                super();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    return entry.getKey() != null && (entry.getValue() instanceof Map) && l.d(StandardTable.this.backingMap.entrySet(), entry);
                }
                return false;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<R, Map<C, V>>> iterator() {
                return Maps.d(StandardTable.this.backingMap.keySet(), new C0235a());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    return entry.getKey() != null && (entry.getValue() instanceof Map) && StandardTable.this.backingMap.entrySet().remove(entry);
                }
                return false;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return StandardTable.this.backingMap.size();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public h() {
        }

        @Override // com.google.common.collect.Maps.t
        protected Set<Map.Entry<R, Map<C, V>>> a() {
            return new a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return StandardTable.this.containsRow(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: d */
        public Map<C, V> get(Object obj) {
            if (StandardTable.this.containsRow(obj)) {
                return StandardTable.this.row(obj);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: e */
        public Map<C, V> remove(Object obj) {
            if (obj == null) {
                return null;
            }
            return StandardTable.this.backingMap.remove(obj);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private abstract class i<T> extends Sets.a<T> {
        private i() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            StandardTable.this.backingMap.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return StandardTable.this.backingMap.isEmpty();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public StandardTable(Map<R, Map<C, V>> map, Supplier<? extends Map<C, V>> supplier) {
        this.backingMap = map;
        this.factory = supplier;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean containsMapping(Object obj, Object obj2, Object obj3) {
        return obj3 != null && obj3.equals(get(obj, obj2));
    }

    private Map<C, V> getOrCreate(R r) {
        Map<C, V> map = this.backingMap.get(r);
        if (map == null) {
            Map<C, V> map2 = this.factory.get();
            this.backingMap.put(r, map2);
            return map2;
        }
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @CanIgnoreReturnValue
    public Map<R, V> removeColumn(Object obj) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<Map.Entry<R, Map<C, V>>> it = this.backingMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<R, Map<C, V>> next = it.next();
            V remove = next.getValue().remove(obj);
            if (remove != null) {
                linkedHashMap.put(next.getKey(), remove);
                if (next.getValue().isEmpty()) {
                    it.remove();
                }
            }
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean removeMapping(Object obj, Object obj2, Object obj3) {
        if (containsMapping(obj, obj2, obj3)) {
            remove(obj, obj2);
            return true;
        }
        return false;
    }

    @Override // com.google.common.collect.h
    Iterator<Table.Cell<R, C, V>> cellIterator() {
        return new b();
    }

    @Override // com.google.common.collect.h, com.google.common.collect.Table
    public Set<Table.Cell<R, C, V>> cellSet() {
        return super.cellSet();
    }

    @Override // com.google.common.collect.h, com.google.common.collect.Table
    public void clear() {
        this.backingMap.clear();
    }

    @Override // com.google.common.collect.Table
    public Map<R, V> column(C c2) {
        return new c(c2);
    }

    @Override // com.google.common.collect.h, com.google.common.collect.Table
    public Set<C> columnKeySet() {
        Set<C> set = this.columnKeySet;
        if (set == null) {
            e eVar = new e();
            this.columnKeySet = eVar;
            return eVar;
        }
        return set;
    }

    @Override // com.google.common.collect.Table
    public Map<C, Map<R, V>> columnMap() {
        StandardTable<R, C, V>.f fVar = this.columnMap;
        if (fVar == null) {
            StandardTable<R, C, V>.f fVar2 = new f();
            this.columnMap = fVar2;
            return fVar2;
        }
        return fVar;
    }

    @Override // com.google.common.collect.h, com.google.common.collect.Table
    public boolean contains(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return (obj == null || obj2 == null || !super.contains(obj, obj2)) ? false : true;
    }

    @Override // com.google.common.collect.h, com.google.common.collect.Table
    public boolean containsColumn(@NullableDecl Object obj) {
        if (obj == null) {
            return false;
        }
        for (Map<C, V> map : this.backingMap.values()) {
            if (Maps.w(map, obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.common.collect.h, com.google.common.collect.Table
    public boolean containsRow(@NullableDecl Object obj) {
        return obj != null && Maps.w(this.backingMap, obj);
    }

    @Override // com.google.common.collect.h, com.google.common.collect.Table
    public boolean containsValue(@NullableDecl Object obj) {
        return obj != null && super.containsValue(obj);
    }

    Iterator<C> createColumnKeyIterator() {
        return new d();
    }

    Map<R, Map<C, V>> createRowMap() {
        return new h();
    }

    @Override // com.google.common.collect.h, com.google.common.collect.Table
    public V get(@NullableDecl Object obj, @NullableDecl Object obj2) {
        if (obj == null || obj2 == null) {
            return null;
        }
        return (V) super.get(obj, obj2);
    }

    @Override // com.google.common.collect.h, com.google.common.collect.Table
    public boolean isEmpty() {
        return this.backingMap.isEmpty();
    }

    @Override // com.google.common.collect.h, com.google.common.collect.Table
    @CanIgnoreReturnValue
    public V put(R r, C c2, V v) {
        du1.p(r);
        du1.p(c2);
        du1.p(v);
        return getOrCreate(r).put(c2, v);
    }

    @Override // com.google.common.collect.h, com.google.common.collect.Table
    @CanIgnoreReturnValue
    public V remove(@NullableDecl Object obj, @NullableDecl Object obj2) {
        Map map;
        if (obj == null || obj2 == null || (map = (Map) Maps.x(this.backingMap, obj)) == null) {
            return null;
        }
        V v = (V) map.remove(obj2);
        if (map.isEmpty()) {
            this.backingMap.remove(obj);
        }
        return v;
    }

    @Override // com.google.common.collect.Table
    public Map<C, V> row(R r) {
        return new g(r);
    }

    @Override // com.google.common.collect.h, com.google.common.collect.Table
    public Set<R> rowKeySet() {
        return rowMap().keySet();
    }

    @Override // com.google.common.collect.Table
    public Map<R, Map<C, V>> rowMap() {
        Map<R, Map<C, V>> map = this.rowMap;
        if (map == null) {
            Map<R, Map<C, V>> createRowMap = createRowMap();
            this.rowMap = createRowMap;
            return createRowMap;
        }
        return map;
    }

    @Override // com.google.common.collect.Table
    public int size() {
        int i2 = 0;
        for (Map<C, V> map : this.backingMap.values()) {
            i2 += map.size();
        }
        return i2;
    }

    @Override // com.google.common.collect.h, com.google.common.collect.Table
    public Collection<V> values() {
        return super.values();
    }
}
