package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Sets;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.du1;

/* compiled from: Taobao */
@GwtCompatible(emulated = true, serializable = true)
/* loaded from: classes10.dex */
public class LinkedListMultimap<K, V> extends AbstractC5159c<K, V> implements ListMultimap<K, V>, Serializable {
    @GwtIncompatible
    private static final long serialVersionUID = 0;
    @NullableDecl
    private transient C5016g<K, V> head;
    private transient Map<K, C5015f<K, V>> keyToKeyList;
    private transient int modCount;
    private transient int size;
    @NullableDecl
    private transient C5016g<K, V> tail;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.LinkedListMultimap$a */
    /* loaded from: classes10.dex */
    public class C5009a extends AbstractSequentialList<V> {
        final /* synthetic */ Object a;

        C5009a(Object obj) {
            this.a = obj;
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<V> listIterator(int i) {
            return new C5018i(this.a, i);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            C5015f c5015f = (C5015f) LinkedListMultimap.this.keyToKeyList.get(this.a);
            if (c5015f == null) {
                return 0;
            }
            return c5015f.c;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.LinkedListMultimap$b */
    /* loaded from: classes10.dex */
    public class C5010b extends AbstractSequentialList<Map.Entry<K, V>> {
        C5010b() {
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<Map.Entry<K, V>> listIterator(int i) {
            return new C5017h(i);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return LinkedListMultimap.this.size;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.LinkedListMultimap$c */
    /* loaded from: classes10.dex */
    class C5011c extends Sets.AbstractC5098a<K> {
        C5011c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return LinkedListMultimap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new C5014e(LinkedListMultimap.this, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return !LinkedListMultimap.this.removeAll(obj).isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedListMultimap.this.keyToKeyList.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.LinkedListMultimap$d */
    /* loaded from: classes10.dex */
    public class C5012d extends AbstractSequentialList<V> {

        /* compiled from: Taobao */
        /* renamed from: com.google.common.collect.LinkedListMultimap$d$a */
        /* loaded from: classes10.dex */
        class C5013a extends AbstractC5192k0<Map.Entry<K, V>, V> {
            final /* synthetic */ C5017h b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C5013a(C5012d c5012d, ListIterator listIterator, C5017h c5017h) {
                super(listIterator);
                this.b = c5017h;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.collect.AbstractC5190j0
            /* renamed from: c */
            public V a(Map.Entry<K, V> entry) {
                return entry.getValue();
            }

            @Override // com.google.common.collect.AbstractC5192k0, java.util.ListIterator
            public void set(V v) {
                this.b.f(v);
            }
        }

        C5012d() {
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<V> listIterator(int i) {
            C5017h c5017h = new C5017h(i);
            return new C5013a(this, c5017h, c5017h);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return LinkedListMultimap.this.size;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.LinkedListMultimap$f */
    /* loaded from: classes10.dex */
    public static class C5015f<K, V> {
        C5016g<K, V> a;
        C5016g<K, V> b;
        int c;

        C5015f(C5016g<K, V> c5016g) {
            this.a = c5016g;
            this.b = c5016g;
            c5016g.f = null;
            c5016g.e = null;
            this.c = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.LinkedListMultimap$g */
    /* loaded from: classes10.dex */
    public static final class C5016g<K, V> extends AbstractC5157b<K, V> {
        @NullableDecl
        final K a;
        @NullableDecl
        V b;
        @NullableDecl
        C5016g<K, V> c;
        @NullableDecl
        C5016g<K, V> d;
        @NullableDecl
        C5016g<K, V> e;
        @NullableDecl
        C5016g<K, V> f;

        C5016g(@NullableDecl K k, @NullableDecl V v) {
            this.a = k;
            this.b = v;
        }

        @Override // com.google.common.collect.AbstractC5157b, java.util.Map.Entry
        public K getKey() {
            return this.a;
        }

        @Override // com.google.common.collect.AbstractC5157b, java.util.Map.Entry
        public V getValue() {
            return this.b;
        }

        @Override // com.google.common.collect.AbstractC5157b, java.util.Map.Entry
        public V setValue(@NullableDecl V v) {
            V v2 = this.b;
            this.b = v;
            return v2;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.LinkedListMultimap$h */
    /* loaded from: classes10.dex */
    private class C5017h implements ListIterator<Map.Entry<K, V>> {
        int a;
        @NullableDecl
        C5016g<K, V> b;
        @NullableDecl
        C5016g<K, V> c;
        @NullableDecl
        C5016g<K, V> d;
        int e;

        C5017h(int i) {
            this.e = LinkedListMultimap.this.modCount;
            int size = LinkedListMultimap.this.size();
            du1.t(i, size);
            if (i >= size / 2) {
                this.d = LinkedListMultimap.this.tail;
                this.a = size;
                while (true) {
                    int i2 = i + 1;
                    if (i >= size) {
                        break;
                    }
                    previous();
                    i = i2;
                }
            } else {
                this.b = LinkedListMultimap.this.head;
                while (true) {
                    int i3 = i - 1;
                    if (i <= 0) {
                        break;
                    }
                    next();
                    i = i3;
                }
            }
            this.c = null;
        }

        private void b() {
            if (LinkedListMultimap.this.modCount != this.e) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.ListIterator
        /* renamed from: a */
        public void add(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        @CanIgnoreReturnValue
        /* renamed from: c */
        public C5016g<K, V> next() {
            b();
            LinkedListMultimap.checkElement(this.b);
            C5016g<K, V> c5016g = this.b;
            this.c = c5016g;
            this.d = c5016g;
            this.b = c5016g.c;
            this.a++;
            return c5016g;
        }

        @Override // java.util.ListIterator
        @CanIgnoreReturnValue
        /* renamed from: d */
        public C5016g<K, V> previous() {
            b();
            LinkedListMultimap.checkElement(this.d);
            C5016g<K, V> c5016g = this.d;
            this.c = c5016g;
            this.b = c5016g;
            this.d = c5016g.d;
            this.a--;
            return c5016g;
        }

        @Override // java.util.ListIterator
        /* renamed from: e */
        public void set(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        void f(V v) {
            du1.w(this.c != null);
            this.c.b = v;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            b();
            return this.b != null;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            b();
            return this.d != null;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.a;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.a - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            b();
            C5191k.e(this.c != null);
            C5016g<K, V> c5016g = this.c;
            if (c5016g != this.b) {
                this.d = c5016g.d;
                this.a--;
            } else {
                this.b = c5016g.c;
            }
            LinkedListMultimap.this.removeNode(c5016g);
            this.c = null;
            this.e = LinkedListMultimap.this.modCount;
        }
    }

    LinkedListMultimap() {
        this(12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @CanIgnoreReturnValue
    public C5016g<K, V> addNode(@NullableDecl K k, @NullableDecl V v, @NullableDecl C5016g<K, V> c5016g) {
        C5016g<K, V> c5016g2 = new C5016g<>(k, v);
        if (this.head == null) {
            this.tail = c5016g2;
            this.head = c5016g2;
            this.keyToKeyList.put(k, new C5015f<>(c5016g2));
            this.modCount++;
        } else if (c5016g == null) {
            C5016g<K, V> c5016g3 = this.tail;
            c5016g3.c = c5016g2;
            c5016g2.d = c5016g3;
            this.tail = c5016g2;
            C5015f<K, V> c5015f = this.keyToKeyList.get(k);
            if (c5015f == null) {
                this.keyToKeyList.put(k, new C5015f<>(c5016g2));
                this.modCount++;
            } else {
                c5015f.c++;
                C5016g<K, V> c5016g4 = c5015f.b;
                c5016g4.e = c5016g2;
                c5016g2.f = c5016g4;
                c5015f.b = c5016g2;
            }
        } else {
            this.keyToKeyList.get(k).c++;
            c5016g2.d = c5016g.d;
            c5016g2.f = c5016g.f;
            c5016g2.c = c5016g;
            c5016g2.e = c5016g;
            C5016g<K, V> c5016g5 = c5016g.f;
            if (c5016g5 == null) {
                this.keyToKeyList.get(k).a = c5016g2;
            } else {
                c5016g5.e = c5016g2;
            }
            C5016g<K, V> c5016g6 = c5016g.d;
            if (c5016g6 == null) {
                this.head = c5016g2;
            } else {
                c5016g6.c = c5016g2;
            }
            c5016g.d = c5016g2;
            c5016g.f = c5016g2;
        }
        this.size++;
        return c5016g2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void checkElement(@NullableDecl Object obj) {
        if (obj == null) {
            throw new NoSuchElementException();
        }
    }

    public static <K, V> LinkedListMultimap<K, V> create() {
        return new LinkedListMultimap<>();
    }

    private List<V> getCopy(@NullableDecl Object obj) {
        return Collections.unmodifiableList(Lists.k(new C5018i(obj)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.keyToKeyList = CompactLinkedHashMap.create();
        int readInt = objectInputStream.readInt();
        for (int i = 0; i < readInt; i++) {
            put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeAllNodes(@NullableDecl Object obj) {
        Iterators.d(new C5018i(obj));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeNode(C5016g<K, V> c5016g) {
        C5016g<K, V> c5016g2 = c5016g.d;
        if (c5016g2 != null) {
            c5016g2.c = c5016g.c;
        } else {
            this.head = c5016g.c;
        }
        C5016g<K, V> c5016g3 = c5016g.c;
        if (c5016g3 != null) {
            c5016g3.d = c5016g2;
        } else {
            this.tail = c5016g2;
        }
        if (c5016g.f == null && c5016g.e == null) {
            this.keyToKeyList.remove(c5016g.a).c = 0;
            this.modCount++;
        } else {
            C5015f<K, V> c5015f = this.keyToKeyList.get(c5016g.a);
            c5015f.c--;
            C5016g<K, V> c5016g4 = c5016g.f;
            if (c5016g4 == null) {
                c5015f.a = c5016g.e;
            } else {
                c5016g4.e = c5016g.e;
            }
            C5016g<K, V> c5016g5 = c5016g.e;
            if (c5016g5 == null) {
                c5015f.b = c5016g4;
            } else {
                c5016g5.f = c5016g4;
            }
        }
        this.size--;
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        for (Map.Entry<K, V> entry : entries()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    @Override // com.google.common.collect.AbstractC5159c, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public /* bridge */ /* synthetic */ Map asMap() {
        return super.asMap();
    }

    @Override // com.google.common.collect.Multimap
    public void clear() {
        this.head = null;
        this.tail = null;
        this.keyToKeyList.clear();
        this.size = 0;
        this.modCount++;
    }

    @Override // com.google.common.collect.AbstractC5159c, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean containsEntry(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsKey(@NullableDecl Object obj) {
        return this.keyToKeyList.containsKey(obj);
    }

    @Override // com.google.common.collect.AbstractC5159c, com.google.common.collect.Multimap
    public boolean containsValue(@NullableDecl Object obj) {
        return values().contains(obj);
    }

    @Override // com.google.common.collect.AbstractC5159c
    Map<K, Collection<V>> createAsMap() {
        return new Multimaps.C5074a(this);
    }

    @Override // com.google.common.collect.AbstractC5159c
    Set<K> createKeySet() {
        return new C5011c();
    }

    @Override // com.google.common.collect.AbstractC5159c
    Multiset<K> createKeys() {
        return new Multimaps.C5078c(this);
    }

    @Override // com.google.common.collect.AbstractC5159c
    Iterator<Map.Entry<K, V>> entryIterator() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.AbstractC5159c, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public /* bridge */ /* synthetic */ boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Collection get(@NullableDecl Object obj) {
        return get((LinkedListMultimap<K, V>) obj);
    }

    @Override // com.google.common.collect.AbstractC5159c, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.AbstractC5159c, com.google.common.collect.Multimap
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override // com.google.common.collect.AbstractC5159c, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    @Override // com.google.common.collect.AbstractC5159c, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Multiset keys() {
        return super.keys();
    }

    @Override // com.google.common.collect.AbstractC5159c, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public boolean put(@NullableDecl K k, @NullableDecl V v) {
        addNode(k, v, null);
        return true;
    }

    @Override // com.google.common.collect.AbstractC5159c, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean putAll(Multimap multimap) {
        return super.putAll(multimap);
    }

    @Override // com.google.common.collect.AbstractC5159c, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean remove(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return super.remove(obj, obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractC5159c, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ Collection replaceValues(@NullableDecl Object obj, Iterable iterable) {
        return replaceValues((LinkedListMultimap<K, V>) obj, iterable);
    }

    @Override // com.google.common.collect.Multimap
    public int size() {
        return this.size;
    }

    @Override // com.google.common.collect.AbstractC5159c
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    private LinkedListMultimap(int i) {
        this.keyToKeyList = C5172e0.c(i);
    }

    public static <K, V> LinkedListMultimap<K, V> create(int i) {
        return new LinkedListMultimap<>(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.AbstractC5159c
    public List<Map.Entry<K, V>> createEntries() {
        return new C5010b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.AbstractC5159c
    public List<V> createValues() {
        return new C5012d();
    }

    @Override // com.google.common.collect.AbstractC5159c, com.google.common.collect.Multimap
    public List<Map.Entry<K, V>> entries() {
        return (List) super.entries();
    }

    @Override // com.google.common.collect.Multimap
    public List<V> get(@NullableDecl K k) {
        return new C5009a(k);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractC5159c, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean putAll(@NullableDecl Object obj, Iterable iterable) {
        return super.putAll(obj, iterable);
    }

    @Override // com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public List<V> removeAll(@NullableDecl Object obj) {
        List<V> copy = getCopy(obj);
        removeAllNodes(obj);
        return copy;
    }

    @Override // com.google.common.collect.AbstractC5159c, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public List<V> replaceValues(@NullableDecl K k, Iterable<? extends V> iterable) {
        List<V> copy = getCopy(k);
        C5018i c5018i = new C5018i(k);
        Iterator<? extends V> it = iterable.iterator();
        while (c5018i.hasNext() && it.hasNext()) {
            c5018i.next();
            c5018i.set(it.next());
        }
        while (c5018i.hasNext()) {
            c5018i.next();
            c5018i.remove();
        }
        while (it.hasNext()) {
            c5018i.add(it.next());
        }
        return copy;
    }

    @Override // com.google.common.collect.AbstractC5159c, com.google.common.collect.Multimap
    public List<V> values() {
        return (List) super.values();
    }

    public static <K, V> LinkedListMultimap<K, V> create(Multimap<? extends K, ? extends V> multimap) {
        return new LinkedListMultimap<>(multimap);
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.LinkedListMultimap$e */
    /* loaded from: classes10.dex */
    private class C5014e implements Iterator<K> {
        final Set<K> a;
        C5016g<K, V> b;
        @NullableDecl
        C5016g<K, V> c;
        int d;

        private C5014e() {
            this.a = Sets.e(LinkedListMultimap.this.keySet().size());
            this.b = LinkedListMultimap.this.head;
            this.d = LinkedListMultimap.this.modCount;
        }

        private void a() {
            if (LinkedListMultimap.this.modCount != this.d) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            return this.b != null;
        }

        @Override // java.util.Iterator
        public K next() {
            C5016g<K, V> c5016g;
            a();
            LinkedListMultimap.checkElement(this.b);
            C5016g<K, V> c5016g2 = this.b;
            this.c = c5016g2;
            this.a.add(c5016g2.a);
            do {
                c5016g = this.b.c;
                this.b = c5016g;
                if (c5016g == null) {
                    break;
                }
            } while (!this.a.add(c5016g.a));
            return this.c.a;
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            C5191k.e(this.c != null);
            LinkedListMultimap.this.removeAllNodes(this.c.a);
            this.c = null;
            this.d = LinkedListMultimap.this.modCount;
        }

        /* synthetic */ C5014e(LinkedListMultimap linkedListMultimap, C5009a c5009a) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.LinkedListMultimap$i */
    /* loaded from: classes10.dex */
    public class C5018i implements ListIterator<V> {
        @NullableDecl
        final Object a;
        int b;
        @NullableDecl
        C5016g<K, V> c;
        @NullableDecl
        C5016g<K, V> d;
        @NullableDecl
        C5016g<K, V> e;

        C5018i(@NullableDecl Object obj) {
            this.a = obj;
            C5015f c5015f = (C5015f) LinkedListMultimap.this.keyToKeyList.get(obj);
            this.c = c5015f == null ? null : c5015f.a;
        }

        @Override // java.util.ListIterator
        public void add(V v) {
            this.e = LinkedListMultimap.this.addNode(this.a, v, this.c);
            this.b++;
            this.d = null;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.c != null;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.e != null;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        @CanIgnoreReturnValue
        public V next() {
            LinkedListMultimap.checkElement(this.c);
            C5016g<K, V> c5016g = this.c;
            this.d = c5016g;
            this.e = c5016g;
            this.c = c5016g.e;
            this.b++;
            return c5016g.b;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.b;
        }

        @Override // java.util.ListIterator
        @CanIgnoreReturnValue
        public V previous() {
            LinkedListMultimap.checkElement(this.e);
            C5016g<K, V> c5016g = this.e;
            this.d = c5016g;
            this.c = c5016g;
            this.e = c5016g.f;
            this.b--;
            return c5016g.b;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.b - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            C5191k.e(this.d != null);
            C5016g<K, V> c5016g = this.d;
            if (c5016g != this.c) {
                this.e = c5016g.f;
                this.b--;
            } else {
                this.c = c5016g.e;
            }
            LinkedListMultimap.this.removeNode(c5016g);
            this.d = null;
        }

        @Override // java.util.ListIterator
        public void set(V v) {
            du1.w(this.d != null);
            this.d.b = v;
        }

        public C5018i(@NullableDecl Object obj, int i) {
            C5015f c5015f = (C5015f) LinkedListMultimap.this.keyToKeyList.get(obj);
            int i2 = c5015f == null ? 0 : c5015f.c;
            du1.t(i, i2);
            if (i >= i2 / 2) {
                this.e = c5015f == null ? null : c5015f.b;
                this.b = i2;
                while (true) {
                    int i3 = i + 1;
                    if (i >= i2) {
                        break;
                    }
                    previous();
                    i = i3;
                }
            } else {
                this.c = c5015f == null ? null : c5015f.a;
                while (true) {
                    int i4 = i - 1;
                    if (i <= 0) {
                        break;
                    }
                    next();
                    i = i4;
                }
            }
            this.a = obj;
            this.d = null;
        }
    }

    private LinkedListMultimap(Multimap<? extends K, ? extends V> multimap) {
        this(multimap.keySet().size());
        putAll(multimap);
    }
}
