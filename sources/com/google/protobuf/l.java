package com.google.protobuf;

import com.google.protobuf.FieldSet;
import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class l<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private final int a;
    private List<l<K, V>.c> b;
    private Map<K, V> c;
    private boolean d;
    private volatile l<K, V>.e e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [FieldDescriptorType] */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class a<FieldDescriptorType> extends l<FieldDescriptorType, Object> {
        a(int i) {
            super(i, null);
        }

        @Override // com.google.protobuf.l
        public void n() {
            if (!m()) {
                for (int i = 0; i < i(); i++) {
                    Map.Entry<FieldDescriptorType, Object> h = h(i);
                    if (((FieldSet.FieldDescriptorLite) h.getKey()).isRepeated()) {
                        h.setValue(Collections.unmodifiableList((List) h.getValue()));
                    }
                }
                for (Map.Entry<FieldDescriptorType, Object> entry : k()) {
                    if (((FieldSet.FieldDescriptorLite) entry.getKey()).isRepeated()) {
                        entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                    }
                }
            }
            super.n();
        }

        @Override // com.google.protobuf.l, java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
            return super.put((FieldSet.FieldDescriptorLite) obj, obj2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class b {
        private static final Iterator<Object> a = new a();
        private static final Iterable<Object> b = new C0244b();

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        static class a implements Iterator<Object> {
            a() {
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return false;
            }

            @Override // java.util.Iterator
            public Object next() {
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        }

        /* compiled from: Taobao */
        /* renamed from: com.google.protobuf.l$b$b  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        static class C0244b implements Iterable<Object> {
            C0244b() {
            }

            @Override // java.lang.Iterable
            public Iterator<Object> iterator() {
                return b.a;
            }
        }

        static <T> Iterable<T> b() {
            return (Iterable<T>) b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class c implements Map.Entry<K, V>, Comparable<l<K, V>.c> {
        private final K a;
        private V b;

        c(l lVar, Map.Entry<K, V> entry) {
            this(entry.getKey(), entry.getValue());
        }

        private boolean b(Object obj, Object obj2) {
            if (obj == null) {
                return obj2 == null;
            }
            return obj.equals(obj2);
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(l<K, V>.c cVar) {
            return getKey().compareTo(cVar.getKey());
        }

        @Override // java.util.Map.Entry
        /* renamed from: c */
        public K getKey() {
            return this.a;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                return b(this.a, entry.getKey()) && b(this.b, entry.getValue());
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k = this.a;
            int hashCode = k == null ? 0 : k.hashCode();
            V v = this.b;
            return hashCode ^ (v != null ? v.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            l.this.f();
            V v2 = this.b;
            this.b = v;
            return v2;
        }

        public String toString() {
            return this.a + "=" + this.b;
        }

        c(K k, V v) {
            this.a = k;
            this.b = v;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class e extends AbstractSet<Map.Entry<K, V>> {
        private e() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        /* renamed from: a */
        public boolean add(Map.Entry<K, V> entry) {
            if (contains(entry)) {
                return false;
            }
            l.this.put(entry.getKey(), entry.getValue());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            l.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = l.this.get(entry.getKey());
            Object value = entry.getValue();
            return obj2 == value || (obj2 != null && obj2.equals(value));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new d(l.this, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (contains(entry)) {
                l.this.remove(entry.getKey());
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return l.this.size();
        }

        /* synthetic */ e(l lVar, a aVar) {
            this();
        }
    }

    /* synthetic */ l(int i, a aVar) {
        this(i);
    }

    private int e(K k) {
        int size = this.b.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo(this.b.get(size).getKey());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i = 0;
        while (i <= size) {
            int i2 = (i + size) / 2;
            int compareTo2 = k.compareTo(this.b.get(i2).getKey());
            if (compareTo2 < 0) {
                size = i2 - 1;
            } else if (compareTo2 <= 0) {
                return i2;
            } else {
                i = i2 + 1;
            }
        }
        return -(i + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.d) {
            throw new UnsupportedOperationException();
        }
    }

    private void g() {
        f();
        if (!this.b.isEmpty() || (this.b instanceof ArrayList)) {
            return;
        }
        this.b = new ArrayList(this.a);
    }

    private SortedMap<K, V> l() {
        f();
        if (this.c.isEmpty() && !(this.c instanceof TreeMap)) {
            this.c = new TreeMap();
        }
        return (SortedMap) this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <FieldDescriptorType extends FieldSet.FieldDescriptorLite<FieldDescriptorType>> l<FieldDescriptorType, Object> o(int i) {
        return new a(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public V q(int i) {
        f();
        V value = this.b.remove(i).getValue();
        if (!this.c.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = l().entrySet().iterator();
            this.b.add(new c(this, it.next()));
            it.remove();
        }
        return value;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        f();
        if (!this.b.isEmpty()) {
            this.b.clear();
        }
        if (this.c.isEmpty()) {
            return;
        }
        this.c.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return e(comparable) >= 0 || this.c.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.e == null) {
            this.e = new e(this, null);
        }
        return this.e;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return super.equals(obj);
        }
        l lVar = (l) obj;
        int size = size();
        if (size != lVar.size()) {
            return false;
        }
        int i = i();
        if (i != lVar.i()) {
            return entrySet().equals(lVar.entrySet());
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (!h(i2).equals(lVar.h(i2))) {
                return false;
            }
        }
        if (i != size) {
            return this.c.equals(lVar.c);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int e2 = e(comparable);
        if (e2 >= 0) {
            return this.b.get(e2).getValue();
        }
        return this.c.get(comparable);
    }

    public Map.Entry<K, V> h(int i) {
        return this.b.get(i);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int i = i();
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += this.b.get(i3).hashCode();
        }
        return j() > 0 ? i2 + this.c.hashCode() : i2;
    }

    public int i() {
        return this.b.size();
    }

    public int j() {
        return this.c.size();
    }

    public Iterable<Map.Entry<K, V>> k() {
        if (this.c.isEmpty()) {
            return b.b();
        }
        return this.c.entrySet();
    }

    public boolean m() {
        return this.d;
    }

    public void n() {
        Map<K, V> unmodifiableMap;
        if (this.d) {
            return;
        }
        if (this.c.isEmpty()) {
            unmodifiableMap = Collections.emptyMap();
        } else {
            unmodifiableMap = Collections.unmodifiableMap(this.c);
        }
        this.c = unmodifiableMap;
        this.d = true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: p */
    public V put(K k, V v) {
        f();
        int e2 = e(k);
        if (e2 >= 0) {
            return this.b.get(e2).setValue(v);
        }
        g();
        int i = -(e2 + 1);
        if (i >= this.a) {
            return l().put(k, v);
        }
        int size = this.b.size();
        int i2 = this.a;
        if (size == i2) {
            l<K, V>.c remove = this.b.remove(i2 - 1);
            l().put((K) remove.getKey(), remove.getValue());
        }
        this.b.add(i, new c(k, v));
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        f();
        Comparable comparable = (Comparable) obj;
        int e2 = e(comparable);
        if (e2 >= 0) {
            return (V) q(e2);
        }
        if (this.c.isEmpty()) {
            return null;
        }
        return this.c.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.b.size() + this.c.size();
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private class d implements Iterator<Map.Entry<K, V>> {
        private int a;
        private boolean b;
        private Iterator<Map.Entry<K, V>> c;

        private d() {
            this.a = -1;
        }

        private Iterator<Map.Entry<K, V>> a() {
            if (this.c == null) {
                this.c = l.this.c.entrySet().iterator();
            }
            return this.c;
        }

        @Override // java.util.Iterator
        /* renamed from: b */
        public Map.Entry<K, V> next() {
            this.b = true;
            int i = this.a + 1;
            this.a = i;
            if (i < l.this.b.size()) {
                return (Map.Entry) l.this.b.get(this.a);
            }
            return a().next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a + 1 < l.this.b.size() || a().hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.b) {
                this.b = false;
                l.this.f();
                if (this.a < l.this.b.size()) {
                    l lVar = l.this;
                    int i = this.a;
                    this.a = i - 1;
                    lVar.q(i);
                    return;
                }
                a().remove();
                return;
            }
            throw new IllegalStateException("remove() was called before next()");
        }

        /* synthetic */ d(l lVar, a aVar) {
            this();
        }
    }

    private l(int i) {
        this.a = i;
        this.b = Collections.emptyList();
        this.c = Collections.emptyMap();
    }
}
