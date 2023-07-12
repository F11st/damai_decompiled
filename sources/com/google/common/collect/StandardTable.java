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
public class StandardTable<R, C, V> extends AbstractC5180h<R, C, V> implements Serializable {
    private static final long serialVersionUID = 0;
    @GwtTransient
    final Map<R, Map<C, V>> backingMap;
    @MonotonicNonNullDecl
    private transient Set<C> columnKeySet;
    @MonotonicNonNullDecl
    private transient StandardTable<R, C, V>.C5112f columnMap;
    @GwtTransient
    final Supplier<? extends Map<C, V>> factory;
    @MonotonicNonNullDecl
    private transient Map<R, Map<C, V>> rowMap;

    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.StandardTable$b */
    /* loaded from: classes10.dex */
    private class C5103b implements Iterator<Table.Cell<R, C, V>> {
        final Iterator<Map.Entry<R, Map<C, V>>> a;
        @NullableDecl
        Map.Entry<R, Map<C, V>> b;
        Iterator<Map.Entry<C, V>> c;

        private C5103b() {
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
    /* renamed from: com.google.common.collect.StandardTable$c */
    /* loaded from: classes10.dex */
    public class C5104c extends Maps.AbstractC5070t<R, V> {
        final C d;

        /* compiled from: Taobao */
        /* renamed from: com.google.common.collect.StandardTable$c$a */
        /* loaded from: classes10.dex */
        private class C5105a extends Sets.AbstractC5098a<Map.Entry<R, V>> {
            private C5105a() {
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                C5104c.this.d(Predicates.b());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    return StandardTable.this.containsMapping(entry.getKey(), C5104c.this.d, entry.getValue());
                }
                return false;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean isEmpty() {
                C5104c c5104c = C5104c.this;
                return !StandardTable.this.containsColumn(c5104c.d);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<R, V>> iterator() {
                return new C5106b();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    return StandardTable.this.removeMapping(entry.getKey(), C5104c.this.d, entry.getValue());
                }
                return false;
            }

            @Override // com.google.common.collect.Sets.AbstractC5098a, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                return C5104c.this.d(Predicates.g(Predicates.e(collection)));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                int i = 0;
                for (Map<C, V> map : StandardTable.this.backingMap.values()) {
                    if (map.containsKey(C5104c.this.d)) {
                        i++;
                    }
                }
                return i;
            }
        }

        /* compiled from: Taobao */
        /* renamed from: com.google.common.collect.StandardTable$c$b */
        /* loaded from: classes10.dex */
        private class C5106b extends AbstractIterator<Map.Entry<R, V>> {
            final Iterator<Map.Entry<R, Map<C, V>>> c;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: Taobao */
            /* renamed from: com.google.common.collect.StandardTable$c$b$a */
            /* loaded from: classes10.dex */
            public class C5107a extends AbstractC5157b<R, V> {
                final /* synthetic */ Map.Entry a;

                C5107a(Map.Entry entry) {
                    this.a = entry;
                }

                @Override // com.google.common.collect.AbstractC5157b, java.util.Map.Entry
                public R getKey() {
                    return (R) this.a.getKey();
                }

                @Override // com.google.common.collect.AbstractC5157b, java.util.Map.Entry
                public V getValue() {
                    return (V) ((Map) this.a.getValue()).get(C5104c.this.d);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.common.collect.AbstractC5157b, java.util.Map.Entry
                public V setValue(V v) {
                    return (V) ((Map) this.a.getValue()).put(C5104c.this.d, du1.p(v));
                }
            }

            private C5106b() {
                this.c = StandardTable.this.backingMap.entrySet().iterator();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: d */
            public Map.Entry<R, V> a() {
                while (this.c.hasNext()) {
                    Map.Entry<R, Map<C, V>> next = this.c.next();
                    if (next.getValue().containsKey(C5104c.this.d)) {
                        return new C5107a(next);
                    }
                }
                return b();
            }
        }

        /* compiled from: Taobao */
        /* renamed from: com.google.common.collect.StandardTable$c$c */
        /* loaded from: classes10.dex */
        private class C5108c extends Maps.C5062l<R, V> {
            C5108c() {
                super(C5104c.this);
            }

            @Override // com.google.common.collect.Maps.C5062l, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                C5104c c5104c = C5104c.this;
                return StandardTable.this.contains(obj, c5104c.d);
            }

            @Override // com.google.common.collect.Maps.C5062l, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                C5104c c5104c = C5104c.this;
                return StandardTable.this.remove(obj, c5104c.d) != null;
            }

            @Override // com.google.common.collect.Sets.AbstractC5098a, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                return C5104c.this.d(Maps.o(Predicates.g(Predicates.e(collection))));
            }
        }

        /* compiled from: Taobao */
        /* renamed from: com.google.common.collect.StandardTable$c$d */
        /* loaded from: classes10.dex */
        private class C5109d extends Maps.C5069s<R, V> {
            C5109d() {
                super(C5104c.this);
            }

            @Override // com.google.common.collect.Maps.C5069s, java.util.AbstractCollection, java.util.Collection
            public boolean remove(Object obj) {
                return obj != null && C5104c.this.d(Maps.N(Predicates.d(obj)));
            }

            @Override // com.google.common.collect.Maps.C5069s, java.util.AbstractCollection, java.util.Collection
            public boolean removeAll(Collection<?> collection) {
                return C5104c.this.d(Maps.N(Predicates.e(collection)));
            }

            @Override // com.google.common.collect.Maps.C5069s, java.util.AbstractCollection, java.util.Collection
            public boolean retainAll(Collection<?> collection) {
                return C5104c.this.d(Maps.N(Predicates.g(Predicates.e(collection))));
            }
        }

        C5104c(C c) {
            this.d = (C) du1.p(c);
        }

        @Override // com.google.common.collect.Maps.AbstractC5070t
        Set<Map.Entry<R, V>> a() {
            return new C5105a();
        }

        @Override // com.google.common.collect.Maps.AbstractC5070t
        Set<R> b() {
            return new C5108c();
        }

        @Override // com.google.common.collect.Maps.AbstractC5070t
        Collection<V> c() {
            return new C5109d();
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
    /* renamed from: com.google.common.collect.StandardTable$d */
    /* loaded from: classes10.dex */
    public class C5110d extends AbstractIterator<C> {
        final Map<C, V> c;
        final Iterator<Map<C, V>> d;
        Iterator<Map.Entry<C, V>> e;

        private C5110d() {
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
    /* renamed from: com.google.common.collect.StandardTable$e */
    /* loaded from: classes10.dex */
    public class C5111e extends StandardTable<R, C, V>.AbstractC5122i<C> {
        private C5111e() {
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

        @Override // com.google.common.collect.Sets.AbstractC5098a, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
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

        @Override // com.google.common.collect.Sets.AbstractC5098a, java.util.AbstractCollection, java.util.Collection, java.util.Set
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
    /* renamed from: com.google.common.collect.StandardTable$f */
    /* loaded from: classes10.dex */
    public class C5112f extends Maps.AbstractC5070t<C, Map<R, V>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Taobao */
        /* renamed from: com.google.common.collect.StandardTable$f$a */
        /* loaded from: classes10.dex */
        public class C5113a extends StandardTable<R, C, V>.AbstractC5122i<Map.Entry<C, Map<R, V>>> {

            /* compiled from: Taobao */
            /* renamed from: com.google.common.collect.StandardTable$f$a$a */
            /* loaded from: classes10.dex */
            class C5114a implements Function<C, Map<R, V>> {
                C5114a() {
                }

                @Override // com.google.common.base.Function
                /* renamed from: a */
                public Map<R, V> apply(C c) {
                    return StandardTable.this.column(c);
                }
            }

            C5113a() {
                super();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    if (StandardTable.this.containsColumn(entry.getKey())) {
                        return C5112f.this.get(entry.getKey()).equals(entry.getValue());
                    }
                    return false;
                }
                return false;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<C, Map<R, V>>> iterator() {
                return Maps.d(StandardTable.this.columnKeySet(), new C5114a());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (contains(obj)) {
                    StandardTable.this.removeColumn(((Map.Entry) obj).getKey());
                    return true;
                }
                return false;
            }

            @Override // com.google.common.collect.Sets.AbstractC5098a, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection<?> collection) {
                du1.p(collection);
                return Sets.i(this, collection.iterator());
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.Sets.AbstractC5098a, java.util.AbstractCollection, java.util.Collection, java.util.Set
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
        /* renamed from: com.google.common.collect.StandardTable$f$b */
        /* loaded from: classes10.dex */
        private class C5115b extends Maps.C5069s<C, Map<R, V>> {
            C5115b() {
                super(C5112f.this);
            }

            @Override // com.google.common.collect.Maps.C5069s, java.util.AbstractCollection, java.util.Collection
            public boolean remove(Object obj) {
                for (Map.Entry<C, Map<R, V>> entry : C5112f.this.entrySet()) {
                    if (entry.getValue().equals(obj)) {
                        StandardTable.this.removeColumn(entry.getKey());
                        return true;
                    }
                }
                return false;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.Maps.C5069s, java.util.AbstractCollection, java.util.Collection
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
            @Override // com.google.common.collect.Maps.C5069s, java.util.AbstractCollection, java.util.Collection
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

        private C5112f() {
        }

        @Override // com.google.common.collect.Maps.AbstractC5070t
        public Set<Map.Entry<C, Map<R, V>>> a() {
            return new C5113a();
        }

        @Override // com.google.common.collect.Maps.AbstractC5070t
        Collection<Map<R, V>> c() {
            return new C5115b();
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

        @Override // com.google.common.collect.Maps.AbstractC5070t, java.util.AbstractMap, java.util.Map
        public Set<C> keySet() {
            return StandardTable.this.columnKeySet();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.StandardTable$g */
    /* loaded from: classes10.dex */
    public class C5116g extends Maps.AbstractC5060k<C, V> {
        final R a;
        @NullableDecl
        Map<C, V> b;

        /* compiled from: Taobao */
        /* renamed from: com.google.common.collect.StandardTable$g$a */
        /* loaded from: classes10.dex */
        class C5117a implements Iterator<Map.Entry<C, V>> {
            final /* synthetic */ Iterator a;

            C5117a(Iterator it) {
                this.a = it;
            }

            @Override // java.util.Iterator
            /* renamed from: a */
            public Map.Entry<C, V> next() {
                return C5116g.this.e((Map.Entry) this.a.next());
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.a.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.a.remove();
                C5116g.this.d();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Taobao */
        /* renamed from: com.google.common.collect.StandardTable$g$b */
        /* loaded from: classes10.dex */
        public class C5118b extends gp0<C, V> {
            final /* synthetic */ Map.Entry a;

            C5118b(C5116g c5116g, Map.Entry entry) {
                this.a = entry;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.AbstractC5205t
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
        public C5116g(R r) {
            this.a = (R) du1.p(r);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Maps.AbstractC5060k
        public Iterator<Map.Entry<C, V>> a() {
            Map<C, V> b = b();
            if (b == null) {
                return Iterators.j();
            }
            return new C5117a(b.entrySet().iterator());
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

        @Override // com.google.common.collect.Maps.AbstractC5060k, java.util.AbstractMap, java.util.Map
        public void clear() {
            Map<C, V> b = b();
            if (b != null) {
                b.clear();
            }
            d();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            Map<C, V> b = b();
            return (obj == null || b == null || !Maps.w(b, obj)) ? false : true;
        }

        void d() {
            if (b() == null || !this.b.isEmpty()) {
                return;
            }
            StandardTable.this.backingMap.remove(this.a);
            this.b = null;
        }

        Map.Entry<C, V> e(Map.Entry<C, V> entry) {
            return new C5118b(this, entry);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            Map<C, V> b = b();
            if (obj == null || b == null) {
                return null;
            }
            return (V) Maps.x(b, obj);
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
            Map<C, V> b = b();
            if (b == null) {
                return null;
            }
            V v = (V) Maps.y(b, obj);
            d();
            return v;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            Map<C, V> b = b();
            if (b == null) {
                return 0;
            }
            return b.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.StandardTable$h */
    /* loaded from: classes10.dex */
    public class C5119h extends Maps.AbstractC5070t<R, Map<C, V>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Taobao */
        /* renamed from: com.google.common.collect.StandardTable$h$a */
        /* loaded from: classes10.dex */
        public class C5120a extends StandardTable<R, C, V>.AbstractC5122i<Map.Entry<R, Map<C, V>>> {

            /* compiled from: Taobao */
            /* renamed from: com.google.common.collect.StandardTable$h$a$a */
            /* loaded from: classes10.dex */
            class C5121a implements Function<R, Map<C, V>> {
                C5121a() {
                }

                @Override // com.google.common.base.Function
                /* renamed from: a */
                public Map<C, V> apply(R r) {
                    return StandardTable.this.row(r);
                }
            }

            C5120a() {
                super();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    return entry.getKey() != null && (entry.getValue() instanceof Map) && C5193l.d(StandardTable.this.backingMap.entrySet(), entry);
                }
                return false;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<R, Map<C, V>>> iterator() {
                return Maps.d(StandardTable.this.backingMap.keySet(), new C5121a());
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
        public C5119h() {
        }

        @Override // com.google.common.collect.Maps.AbstractC5070t
        protected Set<Map.Entry<R, Map<C, V>>> a() {
            return new C5120a();
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
    /* renamed from: com.google.common.collect.StandardTable$i */
    /* loaded from: classes10.dex */
    private abstract class AbstractC5122i<T> extends Sets.AbstractC5098a<T> {
        private AbstractC5122i() {
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

    @Override // com.google.common.collect.AbstractC5180h
    Iterator<Table.Cell<R, C, V>> cellIterator() {
        return new C5103b();
    }

    @Override // com.google.common.collect.AbstractC5180h, com.google.common.collect.Table
    public Set<Table.Cell<R, C, V>> cellSet() {
        return super.cellSet();
    }

    @Override // com.google.common.collect.AbstractC5180h, com.google.common.collect.Table
    public void clear() {
        this.backingMap.clear();
    }

    @Override // com.google.common.collect.Table
    public Map<R, V> column(C c) {
        return new C5104c(c);
    }

    @Override // com.google.common.collect.AbstractC5180h, com.google.common.collect.Table
    public Set<C> columnKeySet() {
        Set<C> set = this.columnKeySet;
        if (set == null) {
            C5111e c5111e = new C5111e();
            this.columnKeySet = c5111e;
            return c5111e;
        }
        return set;
    }

    @Override // com.google.common.collect.Table
    public Map<C, Map<R, V>> columnMap() {
        StandardTable<R, C, V>.C5112f c5112f = this.columnMap;
        if (c5112f == null) {
            StandardTable<R, C, V>.C5112f c5112f2 = new C5112f();
            this.columnMap = c5112f2;
            return c5112f2;
        }
        return c5112f;
    }

    @Override // com.google.common.collect.AbstractC5180h, com.google.common.collect.Table
    public boolean contains(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return (obj == null || obj2 == null || !super.contains(obj, obj2)) ? false : true;
    }

    @Override // com.google.common.collect.AbstractC5180h, com.google.common.collect.Table
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

    @Override // com.google.common.collect.AbstractC5180h, com.google.common.collect.Table
    public boolean containsRow(@NullableDecl Object obj) {
        return obj != null && Maps.w(this.backingMap, obj);
    }

    @Override // com.google.common.collect.AbstractC5180h, com.google.common.collect.Table
    public boolean containsValue(@NullableDecl Object obj) {
        return obj != null && super.containsValue(obj);
    }

    Iterator<C> createColumnKeyIterator() {
        return new C5110d();
    }

    Map<R, Map<C, V>> createRowMap() {
        return new C5119h();
    }

    @Override // com.google.common.collect.AbstractC5180h, com.google.common.collect.Table
    public V get(@NullableDecl Object obj, @NullableDecl Object obj2) {
        if (obj == null || obj2 == null) {
            return null;
        }
        return (V) super.get(obj, obj2);
    }

    @Override // com.google.common.collect.AbstractC5180h, com.google.common.collect.Table
    public boolean isEmpty() {
        return this.backingMap.isEmpty();
    }

    @Override // com.google.common.collect.AbstractC5180h, com.google.common.collect.Table
    @CanIgnoreReturnValue
    public V put(R r, C c, V v) {
        du1.p(r);
        du1.p(c);
        du1.p(v);
        return getOrCreate(r).put(c, v);
    }

    @Override // com.google.common.collect.AbstractC5180h, com.google.common.collect.Table
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
        return new C5116g(r);
    }

    @Override // com.google.common.collect.AbstractC5180h, com.google.common.collect.Table
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
        int i = 0;
        for (Map<C, V> map : this.backingMap.values()) {
            i += map.size();
        }
        return i;
    }

    @Override // com.google.common.collect.AbstractC5180h, com.google.common.collect.Table
    public Collection<V> values() {
        return super.values();
    }
}
