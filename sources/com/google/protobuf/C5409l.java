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
/* renamed from: com.google.protobuf.l */
/* loaded from: classes10.dex */
public class C5409l<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private final int a;
    private List<C5409l<K, V>.C5414c> b;
    private Map<K, V> c;
    private boolean d;
    private volatile C5409l<K, V>.C5416e e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [FieldDescriptorType] */
    /* compiled from: Taobao */
    /* renamed from: com.google.protobuf.l$a */
    /* loaded from: classes10.dex */
    public static class C5410a<FieldDescriptorType> extends C5409l<FieldDescriptorType, Object> {
        C5410a(int i) {
            super(i, null);
        }

        @Override // com.google.protobuf.C5409l
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

        @Override // com.google.protobuf.C5409l, java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
            return super.put((FieldSet.FieldDescriptorLite) obj, obj2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.google.protobuf.l$b */
    /* loaded from: classes10.dex */
    public static class C5411b {
        private static final Iterator<Object> a = new C5412a();
        private static final Iterable<Object> b = new C5413b();

        /* compiled from: Taobao */
        /* renamed from: com.google.protobuf.l$b$a */
        /* loaded from: classes10.dex */
        static class C5412a implements Iterator<Object> {
            C5412a() {
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
        /* renamed from: com.google.protobuf.l$b$b */
        /* loaded from: classes10.dex */
        static class C5413b implements Iterable<Object> {
            C5413b() {
            }

            @Override // java.lang.Iterable
            public Iterator<Object> iterator() {
                return C5411b.a;
            }
        }

        static <T> Iterable<T> b() {
            return (Iterable<T>) b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.google.protobuf.l$c */
    /* loaded from: classes10.dex */
    public class C5414c implements Map.Entry<K, V>, Comparable<C5409l<K, V>.C5414c> {
        private final K a;
        private V b;

        C5414c(C5409l c5409l, Map.Entry<K, V> entry) {
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
        public int compareTo(C5409l<K, V>.C5414c c5414c) {
            return getKey().compareTo(c5414c.getKey());
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
            C5409l.this.f();
            V v2 = this.b;
            this.b = v;
            return v2;
        }

        public String toString() {
            return this.a + "=" + this.b;
        }

        C5414c(K k, V v) {
            this.a = k;
            this.b = v;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.google.protobuf.l$e */
    /* loaded from: classes10.dex */
    public class C5416e extends AbstractSet<Map.Entry<K, V>> {
        private C5416e() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        /* renamed from: a */
        public boolean add(Map.Entry<K, V> entry) {
            if (contains(entry)) {
                return false;
            }
            C5409l.this.put(entry.getKey(), entry.getValue());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            C5409l.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = C5409l.this.get(entry.getKey());
            Object value = entry.getValue();
            return obj2 == value || (obj2 != null && obj2.equals(value));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new C5415d(C5409l.this, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (contains(entry)) {
                C5409l.this.remove(entry.getKey());
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return C5409l.this.size();
        }

        /* synthetic */ C5416e(C5409l c5409l, C5410a c5410a) {
            this();
        }
    }

    /* synthetic */ C5409l(int i, C5410a c5410a) {
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
    public static <FieldDescriptorType extends FieldSet.FieldDescriptorLite<FieldDescriptorType>> C5409l<FieldDescriptorType, Object> o(int i) {
        return new C5410a(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public V q(int i) {
        f();
        V value = this.b.remove(i).getValue();
        if (!this.c.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = l().entrySet().iterator();
            this.b.add(new C5414c(this, it.next()));
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
            this.e = new C5416e(this, null);
        }
        return this.e;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C5409l)) {
            return super.equals(obj);
        }
        C5409l c5409l = (C5409l) obj;
        int size = size();
        if (size != c5409l.size()) {
            return false;
        }
        int i = i();
        if (i != c5409l.i()) {
            return entrySet().equals(c5409l.entrySet());
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (!h(i2).equals(c5409l.h(i2))) {
                return false;
            }
        }
        if (i != size) {
            return this.c.equals(c5409l.c);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int e = e(comparable);
        if (e >= 0) {
            return this.b.get(e).getValue();
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
            return C5411b.b();
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
        int e = e(k);
        if (e >= 0) {
            return this.b.get(e).setValue(v);
        }
        g();
        int i = -(e + 1);
        if (i >= this.a) {
            return l().put(k, v);
        }
        int size = this.b.size();
        int i2 = this.a;
        if (size == i2) {
            C5409l<K, V>.C5414c remove = this.b.remove(i2 - 1);
            l().put((K) remove.getKey(), remove.getValue());
        }
        this.b.add(i, new C5414c(k, v));
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        f();
        Comparable comparable = (Comparable) obj;
        int e = e(comparable);
        if (e >= 0) {
            return (V) q(e);
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
    /* renamed from: com.google.protobuf.l$d */
    /* loaded from: classes10.dex */
    private class C5415d implements Iterator<Map.Entry<K, V>> {
        private int a;
        private boolean b;
        private Iterator<Map.Entry<K, V>> c;

        private C5415d() {
            this.a = -1;
        }

        private Iterator<Map.Entry<K, V>> a() {
            if (this.c == null) {
                this.c = C5409l.this.c.entrySet().iterator();
            }
            return this.c;
        }

        @Override // java.util.Iterator
        /* renamed from: b */
        public Map.Entry<K, V> next() {
            this.b = true;
            int i = this.a + 1;
            this.a = i;
            if (i < C5409l.this.b.size()) {
                return (Map.Entry) C5409l.this.b.get(this.a);
            }
            return a().next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a + 1 < C5409l.this.b.size() || a().hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.b) {
                this.b = false;
                C5409l.this.f();
                if (this.a < C5409l.this.b.size()) {
                    C5409l c5409l = C5409l.this;
                    int i = this.a;
                    this.a = i - 1;
                    c5409l.q(i);
                    return;
                }
                a().remove();
                return;
            }
            throw new IllegalStateException("remove() was called before next()");
        }

        /* synthetic */ C5415d(C5409l c5409l, C5410a c5410a) {
            this();
        }
    }

    private C5409l(int i) {
        this.a = i;
        this.b = Collections.emptyList();
        this.c = Collections.emptyMap();
    }
}
