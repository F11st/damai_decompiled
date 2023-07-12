package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.RetainedWith;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.du1;
import tb.gp0;
import tb.nm1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
@GwtCompatible(emulated = true)
/* loaded from: classes10.dex */
public abstract class AbstractBiMap<K, V> extends AbstractC5202q<K, V> implements BiMap<K, V>, Serializable {
    @GwtIncompatible
    private static final long serialVersionUID = 0;
    @MonotonicNonNullDecl
    private transient Map<K, V> delegate;
    @MonotonicNonNullDecl
    private transient Set<Map.Entry<K, V>> entrySet;
    @RetainedWith
    @MonotonicNonNullDecl
    transient AbstractBiMap<V, K> inverse;
    @MonotonicNonNullDecl
    private transient Set<K> keySet;
    @MonotonicNonNullDecl
    private transient Set<V> valueSet;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class Inverse<K, V> extends AbstractBiMap<K, V> {
        @GwtIncompatible
        private static final long serialVersionUID = 0;

        Inverse(Map<K, V> map, AbstractBiMap<V, K> abstractBiMap) {
            super(map, abstractBiMap, null);
        }

        @GwtIncompatible
        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            setInverse((AbstractBiMap) objectInputStream.readObject());
        }

        @GwtIncompatible
        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(inverse());
        }

        @Override // com.google.common.collect.AbstractBiMap
        K checkKey(K k) {
            return this.inverse.checkValue(k);
        }

        @Override // com.google.common.collect.AbstractBiMap
        V checkValue(V v) {
            return this.inverse.checkKey(v);
        }

        @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.AbstractC5202q, com.google.common.collect.AbstractC5205t
        protected /* bridge */ /* synthetic */ Object delegate() {
            return super.delegate();
        }

        @GwtIncompatible
        Object readResolve() {
            return inverse().inverse();
        }

        @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.AbstractC5202q, java.util.Map
        public /* bridge */ /* synthetic */ Collection values() {
            return super.values();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.AbstractBiMap$a */
    /* loaded from: classes10.dex */
    public class C4894a implements Iterator<Map.Entry<K, V>> {
        @NullableDecl
        Map.Entry<K, V> a;
        final /* synthetic */ Iterator b;

        C4894a(Iterator it) {
            this.b = it;
        }

        @Override // java.util.Iterator
        /* renamed from: a */
        public Map.Entry<K, V> next() {
            Map.Entry<K, V> entry = (Map.Entry) this.b.next();
            this.a = entry;
            return new C4895b(entry);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            C5191k.e(this.a != null);
            V value = this.a.getValue();
            this.b.remove();
            AbstractBiMap.this.removeFromInverseMap(value);
            this.a = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.AbstractBiMap$b */
    /* loaded from: classes10.dex */
    public class C4895b extends gp0<K, V> {
        private final Map.Entry<K, V> a;

        C4895b(Map.Entry<K, V> entry) {
            this.a = entry;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.AbstractC5205t
        /* renamed from: a */
        public Map.Entry<K, V> delegate() {
            return this.a;
        }

        @Override // tb.gp0, java.util.Map.Entry
        public V setValue(V v) {
            AbstractBiMap.this.checkValue(v);
            du1.x(AbstractBiMap.this.entrySet().contains(this), "entry no longer in map");
            if (nm1.a(v, getValue())) {
                return v;
            }
            du1.k(!AbstractBiMap.this.containsValue(v), "value already present: %s", v);
            V value = this.a.setValue(v);
            du1.x(nm1.a(v, AbstractBiMap.this.get(getKey())), "entry no longer in map");
            AbstractBiMap.this.updateInverseMap(getKey(), true, value, v);
            return value;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.AbstractBiMap$c */
    /* loaded from: classes10.dex */
    public class C4896c extends AbstractC5207v<Map.Entry<K, V>> {
        final Set<Map.Entry<K, V>> a;

        private C4896c() {
            this.a = AbstractBiMap.this.delegate.entrySet();
        }

        @Override // com.google.common.collect.AbstractC5200o, java.util.Collection, java.util.Set
        public void clear() {
            AbstractBiMap.this.clear();
        }

        @Override // com.google.common.collect.AbstractC5200o, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return Maps.f(delegate(), obj);
        }

        @Override // com.google.common.collect.AbstractC5200o, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return standardContainsAll(collection);
        }

        @Override // com.google.common.collect.AbstractC5200o, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return AbstractBiMap.this.entrySetIterator();
        }

        @Override // com.google.common.collect.AbstractC5200o, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (this.a.contains(obj)) {
                Map.Entry entry = (Map.Entry) obj;
                ((AbstractBiMap) AbstractBiMap.this.inverse).delegate.remove(entry.getValue());
                this.a.remove(entry);
                return true;
            }
            return false;
        }

        @Override // com.google.common.collect.AbstractC5200o, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return standardRemoveAll(collection);
        }

        @Override // com.google.common.collect.AbstractC5200o, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            return standardRetainAll(collection);
        }

        @Override // com.google.common.collect.AbstractC5200o, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // com.google.common.collect.AbstractC5200o, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) standardToArray(tArr);
        }

        /* synthetic */ C4896c(AbstractBiMap abstractBiMap, C4894a c4894a) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.AbstractC5207v, com.google.common.collect.AbstractC5200o, com.google.common.collect.AbstractC5205t
        public Set<Map.Entry<K, V>> delegate() {
            return this.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.AbstractBiMap$d */
    /* loaded from: classes10.dex */
    public class C4897d extends AbstractC5207v<K> {
        private C4897d() {
        }

        @Override // com.google.common.collect.AbstractC5200o, java.util.Collection, java.util.Set
        public void clear() {
            AbstractBiMap.this.clear();
        }

        @Override // com.google.common.collect.AbstractC5200o, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return Maps.m(AbstractBiMap.this.entrySet().iterator());
        }

        @Override // com.google.common.collect.AbstractC5200o, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (contains(obj)) {
                AbstractBiMap.this.removeFromBothMaps(obj);
                return true;
            }
            return false;
        }

        @Override // com.google.common.collect.AbstractC5200o, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return standardRemoveAll(collection);
        }

        @Override // com.google.common.collect.AbstractC5200o, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            return standardRetainAll(collection);
        }

        /* synthetic */ C4897d(AbstractBiMap abstractBiMap, C4894a c4894a) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.AbstractC5207v, com.google.common.collect.AbstractC5200o, com.google.common.collect.AbstractC5205t
        public Set<K> delegate() {
            return AbstractBiMap.this.delegate.keySet();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.AbstractBiMap$e */
    /* loaded from: classes10.dex */
    public class C4898e extends AbstractC5207v<V> {
        final Set<V> a;

        private C4898e() {
            this.a = AbstractBiMap.this.inverse.keySet();
        }

        @Override // com.google.common.collect.AbstractC5200o, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<V> iterator() {
            return Maps.L(AbstractBiMap.this.entrySet().iterator());
        }

        @Override // com.google.common.collect.AbstractC5200o, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // com.google.common.collect.AbstractC5205t
        public String toString() {
            return standardToString();
        }

        @Override // com.google.common.collect.AbstractC5200o, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) standardToArray(tArr);
        }

        /* synthetic */ C4898e(AbstractBiMap abstractBiMap, C4894a c4894a) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.AbstractC5207v, com.google.common.collect.AbstractC5200o, com.google.common.collect.AbstractC5205t
        public Set<V> delegate() {
            return this.a;
        }
    }

    /* synthetic */ AbstractBiMap(Map map, AbstractBiMap abstractBiMap, C4894a c4894a) {
        this(map, abstractBiMap);
    }

    private V putInBothMaps(@NullableDecl K k, @NullableDecl V v, boolean z) {
        checkKey(k);
        checkValue(v);
        boolean containsKey = containsKey(k);
        if (containsKey && nm1.a(v, get(k))) {
            return v;
        }
        if (z) {
            inverse().remove(v);
        } else {
            du1.k(!containsValue(v), "value already present: %s", v);
        }
        V put = this.delegate.put(k, v);
        updateInverseMap(k, containsKey, put, v);
        return put;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @CanIgnoreReturnValue
    public V removeFromBothMaps(Object obj) {
        V remove = this.delegate.remove(obj);
        removeFromInverseMap(remove);
        return remove;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeFromInverseMap(V v) {
        this.inverse.delegate.remove(v);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateInverseMap(K k, boolean z, V v, V v2) {
        if (z) {
            removeFromInverseMap(v);
        }
        this.inverse.delegate.put(v2, k);
    }

    @CanIgnoreReturnValue
    K checkKey(@NullableDecl K k) {
        return k;
    }

    @CanIgnoreReturnValue
    V checkValue(@NullableDecl V v) {
        return v;
    }

    @Override // com.google.common.collect.AbstractC5202q, java.util.Map
    public void clear() {
        this.delegate.clear();
        this.inverse.delegate.clear();
    }

    @Override // com.google.common.collect.AbstractC5202q, java.util.Map
    public boolean containsValue(@NullableDecl Object obj) {
        return this.inverse.containsKey(obj);
    }

    @Override // com.google.common.collect.AbstractC5202q, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set == null) {
            C4896c c4896c = new C4896c(this, null);
            this.entrySet = c4896c;
            return c4896c;
        }
        return set;
    }

    Iterator<Map.Entry<K, V>> entrySetIterator() {
        return new C4894a(this.delegate.entrySet().iterator());
    }

    @Override // com.google.common.collect.BiMap
    @CanIgnoreReturnValue
    public V forcePut(@NullableDecl K k, @NullableDecl V v) {
        return putInBothMaps(k, v, true);
    }

    @Override // com.google.common.collect.BiMap
    public BiMap<V, K> inverse() {
        return this.inverse;
    }

    @Override // com.google.common.collect.AbstractC5202q, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set == null) {
            C4897d c4897d = new C4897d(this, null);
            this.keySet = c4897d;
            return c4897d;
        }
        return set;
    }

    AbstractBiMap<V, K> makeInverse(Map<V, K> map) {
        return new Inverse(map, this);
    }

    @Override // com.google.common.collect.AbstractC5202q, java.util.Map, com.google.common.collect.BiMap
    @CanIgnoreReturnValue
    public V put(@NullableDecl K k, @NullableDecl V v) {
        return putInBothMaps(k, v, false);
    }

    @Override // com.google.common.collect.AbstractC5202q, java.util.Map, com.google.common.collect.BiMap
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.common.collect.AbstractC5202q, java.util.Map
    @CanIgnoreReturnValue
    public V remove(@NullableDecl Object obj) {
        if (containsKey(obj)) {
            return removeFromBothMaps(obj);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDelegates(Map<K, V> map, Map<V, K> map2) {
        du1.w(this.delegate == null);
        du1.w(this.inverse == null);
        du1.d(map.isEmpty());
        du1.d(map2.isEmpty());
        du1.d(map != map2);
        this.delegate = map;
        this.inverse = makeInverse(map2);
    }

    void setInverse(AbstractBiMap<V, K> abstractBiMap) {
        this.inverse = abstractBiMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractBiMap(Map<K, V> map, Map<V, K> map2) {
        setDelegates(map, map2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.AbstractC5202q, com.google.common.collect.AbstractC5205t
    public Map<K, V> delegate() {
        return this.delegate;
    }

    @Override // com.google.common.collect.AbstractC5202q, java.util.Map
    public Set<V> values() {
        Set<V> set = this.valueSet;
        if (set == null) {
            C4898e c4898e = new C4898e(this, null);
            this.valueSet = c4898e;
            return c4898e;
        }
        return set;
    }

    private AbstractBiMap(Map<K, V> map, AbstractBiMap<V, K> abstractBiMap) {
        this.delegate = map;
        this.inverse = abstractBiMap;
    }
}
