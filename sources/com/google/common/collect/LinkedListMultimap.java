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
public class LinkedListMultimap<K, V> extends com.google.common.collect.c<K, V> implements ListMultimap<K, V>, Serializable {
    @GwtIncompatible
    private static final long serialVersionUID = 0;
    @NullableDecl
    private transient g<K, V> head;
    private transient Map<K, f<K, V>> keyToKeyList;
    private transient int modCount;
    private transient int size;
    @NullableDecl
    private transient g<K, V> tail;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class a extends AbstractSequentialList<V> {
        final /* synthetic */ Object a;

        a(Object obj) {
            this.a = obj;
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<V> listIterator(int i) {
            return new i(this.a, i);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            f fVar = (f) LinkedListMultimap.this.keyToKeyList.get(this.a);
            if (fVar == null) {
                return 0;
            }
            return fVar.c;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class b extends AbstractSequentialList<Map.Entry<K, V>> {
        b() {
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<Map.Entry<K, V>> listIterator(int i) {
            return new h(i);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return LinkedListMultimap.this.size;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    class c extends Sets.a<K> {
        c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return LinkedListMultimap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new e(LinkedListMultimap.this, null);
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
    /* loaded from: classes10.dex */
    public class d extends AbstractSequentialList<V> {

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        class a extends k0<Map.Entry<K, V>, V> {
            final /* synthetic */ h b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(d dVar, ListIterator listIterator, h hVar) {
                super(listIterator);
                this.b = hVar;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.collect.j0
            /* renamed from: c */
            public V a(Map.Entry<K, V> entry) {
                return entry.getValue();
            }

            @Override // com.google.common.collect.k0, java.util.ListIterator
            public void set(V v) {
                this.b.f(v);
            }
        }

        d() {
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<V> listIterator(int i) {
            h hVar = new h(i);
            return new a(this, hVar, hVar);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return LinkedListMultimap.this.size;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class f<K, V> {
        g<K, V> a;
        g<K, V> b;
        int c;

        f(g<K, V> gVar) {
            this.a = gVar;
            this.b = gVar;
            gVar.f = null;
            gVar.e = null;
            this.c = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static final class g<K, V> extends com.google.common.collect.b<K, V> {
        @NullableDecl
        final K a;
        @NullableDecl
        V b;
        @NullableDecl
        g<K, V> c;
        @NullableDecl
        g<K, V> d;
        @NullableDecl
        g<K, V> e;
        @NullableDecl
        g<K, V> f;

        g(@NullableDecl K k, @NullableDecl V v) {
            this.a = k;
            this.b = v;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public K getKey() {
            return this.a;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public V getValue() {
            return this.b;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public V setValue(@NullableDecl V v) {
            V v2 = this.b;
            this.b = v;
            return v2;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private class h implements ListIterator<Map.Entry<K, V>> {
        int a;
        @NullableDecl
        g<K, V> b;
        @NullableDecl
        g<K, V> c;
        @NullableDecl
        g<K, V> d;
        int e;

        h(int i) {
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
        public g<K, V> next() {
            b();
            LinkedListMultimap.checkElement(this.b);
            g<K, V> gVar = this.b;
            this.c = gVar;
            this.d = gVar;
            this.b = gVar.c;
            this.a++;
            return gVar;
        }

        @Override // java.util.ListIterator
        @CanIgnoreReturnValue
        /* renamed from: d */
        public g<K, V> previous() {
            b();
            LinkedListMultimap.checkElement(this.d);
            g<K, V> gVar = this.d;
            this.c = gVar;
            this.b = gVar;
            this.d = gVar.d;
            this.a--;
            return gVar;
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
            k.e(this.c != null);
            g<K, V> gVar = this.c;
            if (gVar != this.b) {
                this.d = gVar.d;
                this.a--;
            } else {
                this.b = gVar.c;
            }
            LinkedListMultimap.this.removeNode(gVar);
            this.c = null;
            this.e = LinkedListMultimap.this.modCount;
        }
    }

    LinkedListMultimap() {
        this(12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @CanIgnoreReturnValue
    public g<K, V> addNode(@NullableDecl K k, @NullableDecl V v, @NullableDecl g<K, V> gVar) {
        g<K, V> gVar2 = new g<>(k, v);
        if (this.head == null) {
            this.tail = gVar2;
            this.head = gVar2;
            this.keyToKeyList.put(k, new f<>(gVar2));
            this.modCount++;
        } else if (gVar == null) {
            g<K, V> gVar3 = this.tail;
            gVar3.c = gVar2;
            gVar2.d = gVar3;
            this.tail = gVar2;
            f<K, V> fVar = this.keyToKeyList.get(k);
            if (fVar == null) {
                this.keyToKeyList.put(k, new f<>(gVar2));
                this.modCount++;
            } else {
                fVar.c++;
                g<K, V> gVar4 = fVar.b;
                gVar4.e = gVar2;
                gVar2.f = gVar4;
                fVar.b = gVar2;
            }
        } else {
            this.keyToKeyList.get(k).c++;
            gVar2.d = gVar.d;
            gVar2.f = gVar.f;
            gVar2.c = gVar;
            gVar2.e = gVar;
            g<K, V> gVar5 = gVar.f;
            if (gVar5 == null) {
                this.keyToKeyList.get(k).a = gVar2;
            } else {
                gVar5.e = gVar2;
            }
            g<K, V> gVar6 = gVar.d;
            if (gVar6 == null) {
                this.head = gVar2;
            } else {
                gVar6.c = gVar2;
            }
            gVar.d = gVar2;
            gVar.f = gVar2;
        }
        this.size++;
        return gVar2;
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
        return Collections.unmodifiableList(Lists.k(new i(obj)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.keyToKeyList = CompactLinkedHashMap.create();
        int readInt = objectInputStream.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeAllNodes(@NullableDecl Object obj) {
        Iterators.d(new i(obj));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeNode(g<K, V> gVar) {
        g<K, V> gVar2 = gVar.d;
        if (gVar2 != null) {
            gVar2.c = gVar.c;
        } else {
            this.head = gVar.c;
        }
        g<K, V> gVar3 = gVar.c;
        if (gVar3 != null) {
            gVar3.d = gVar2;
        } else {
            this.tail = gVar2;
        }
        if (gVar.f == null && gVar.e == null) {
            this.keyToKeyList.remove(gVar.a).c = 0;
            this.modCount++;
        } else {
            f<K, V> fVar = this.keyToKeyList.get(gVar.a);
            fVar.c--;
            g<K, V> gVar4 = gVar.f;
            if (gVar4 == null) {
                fVar.a = gVar.e;
            } else {
                gVar4.e = gVar.e;
            }
            g<K, V> gVar5 = gVar.e;
            if (gVar5 == null) {
                fVar.b = gVar4;
            } else {
                gVar5.f = gVar4;
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

    @Override // com.google.common.collect.c, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
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

    @Override // com.google.common.collect.c, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean containsEntry(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsKey(@NullableDecl Object obj) {
        return this.keyToKeyList.containsKey(obj);
    }

    @Override // com.google.common.collect.c, com.google.common.collect.Multimap
    public boolean containsValue(@NullableDecl Object obj) {
        return values().contains(obj);
    }

    @Override // com.google.common.collect.c
    Map<K, Collection<V>> createAsMap() {
        return new Multimaps.a(this);
    }

    @Override // com.google.common.collect.c
    Set<K> createKeySet() {
        return new c();
    }

    @Override // com.google.common.collect.c
    Multiset<K> createKeys() {
        return new Multimaps.c(this);
    }

    @Override // com.google.common.collect.c
    Iterator<Map.Entry<K, V>> entryIterator() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.c, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public /* bridge */ /* synthetic */ boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Collection get(@NullableDecl Object obj) {
        return get((LinkedListMultimap<K, V>) obj);
    }

    @Override // com.google.common.collect.c, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.Multimap
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override // com.google.common.collect.c, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Multiset keys() {
        return super.keys();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public boolean put(@NullableDecl K k, @NullableDecl V v) {
        addNode(k, v, null);
        return true;
    }

    @Override // com.google.common.collect.c, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean putAll(Multimap multimap) {
        return super.putAll(multimap);
    }

    @Override // com.google.common.collect.c, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean remove(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return super.remove(obj, obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.c, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ Collection replaceValues(@NullableDecl Object obj, Iterable iterable) {
        return replaceValues((LinkedListMultimap<K, V>) obj, iterable);
    }

    @Override // com.google.common.collect.Multimap
    public int size() {
        return this.size;
    }

    @Override // com.google.common.collect.c
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    private LinkedListMultimap(int i2) {
        this.keyToKeyList = e0.c(i2);
    }

    public static <K, V> LinkedListMultimap<K, V> create(int i2) {
        return new LinkedListMultimap<>(i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.c
    public List<Map.Entry<K, V>> createEntries() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.c
    public List<V> createValues() {
        return new d();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.Multimap
    public List<Map.Entry<K, V>> entries() {
        return (List) super.entries();
    }

    @Override // com.google.common.collect.Multimap
    public List<V> get(@NullableDecl K k) {
        return new a(k);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.c, com.google.common.collect.Multimap
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

    @Override // com.google.common.collect.c, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public List<V> replaceValues(@NullableDecl K k, Iterable<? extends V> iterable) {
        List<V> copy = getCopy(k);
        i iVar = new i(k);
        Iterator<? extends V> it = iterable.iterator();
        while (iVar.hasNext() && it.hasNext()) {
            iVar.next();
            iVar.set(it.next());
        }
        while (iVar.hasNext()) {
            iVar.next();
            iVar.remove();
        }
        while (it.hasNext()) {
            iVar.add(it.next());
        }
        return copy;
    }

    @Override // com.google.common.collect.c, com.google.common.collect.Multimap
    public List<V> values() {
        return (List) super.values();
    }

    public static <K, V> LinkedListMultimap<K, V> create(Multimap<? extends K, ? extends V> multimap) {
        return new LinkedListMultimap<>(multimap);
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private class e implements Iterator<K> {
        final Set<K> a;
        g<K, V> b;
        @NullableDecl
        g<K, V> c;
        int d;

        private e() {
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
            g<K, V> gVar;
            a();
            LinkedListMultimap.checkElement(this.b);
            g<K, V> gVar2 = this.b;
            this.c = gVar2;
            this.a.add(gVar2.a);
            do {
                gVar = this.b.c;
                this.b = gVar;
                if (gVar == null) {
                    break;
                }
            } while (!this.a.add(gVar.a));
            return this.c.a;
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            k.e(this.c != null);
            LinkedListMultimap.this.removeAllNodes(this.c.a);
            this.c = null;
            this.d = LinkedListMultimap.this.modCount;
        }

        /* synthetic */ e(LinkedListMultimap linkedListMultimap, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class i implements ListIterator<V> {
        @NullableDecl
        final Object a;
        int b;
        @NullableDecl
        g<K, V> c;
        @NullableDecl
        g<K, V> d;
        @NullableDecl
        g<K, V> e;

        i(@NullableDecl Object obj) {
            this.a = obj;
            f fVar = (f) LinkedListMultimap.this.keyToKeyList.get(obj);
            this.c = fVar == null ? null : fVar.a;
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
            g<K, V> gVar = this.c;
            this.d = gVar;
            this.e = gVar;
            this.c = gVar.e;
            this.b++;
            return gVar.b;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.b;
        }

        @Override // java.util.ListIterator
        @CanIgnoreReturnValue
        public V previous() {
            LinkedListMultimap.checkElement(this.e);
            g<K, V> gVar = this.e;
            this.d = gVar;
            this.c = gVar;
            this.e = gVar.f;
            this.b--;
            return gVar.b;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.b - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            k.e(this.d != null);
            g<K, V> gVar = this.d;
            if (gVar != this.c) {
                this.e = gVar.f;
                this.b--;
            } else {
                this.c = gVar.e;
            }
            LinkedListMultimap.this.removeNode(gVar);
            this.d = null;
        }

        @Override // java.util.ListIterator
        public void set(V v) {
            du1.w(this.d != null);
            this.d.b = v;
        }

        public i(@NullableDecl Object obj, int i) {
            f fVar = (f) LinkedListMultimap.this.keyToKeyList.get(obj);
            int i2 = fVar == null ? 0 : fVar.c;
            du1.t(i, i2);
            if (i >= i2 / 2) {
                this.e = fVar == null ? null : fVar.b;
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
                this.c = fVar == null ? null : fVar.a;
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
