package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Map;

/* compiled from: Taobao */
@GwtCompatible(emulated = true, serializable = true)
/* loaded from: classes10.dex */
public abstract class ImmutableBiMap<K, V> extends ImmutableMap<K, V> implements BiMap<K, V> {

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private static class SerializedForm extends ImmutableMap.SerializedForm {
        private static final long serialVersionUID = 0;

        SerializedForm(ImmutableBiMap<?, ?> immutableBiMap) {
            super(immutableBiMap);
        }

        @Override // com.google.common.collect.ImmutableMap.SerializedForm
        Object readResolve() {
            return createMap(new C4964a());
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.ImmutableBiMap$a */
    /* loaded from: classes10.dex */
    public static final class C4964a<K, V> extends ImmutableMap.C4977b<K, V> {
        public C4964a() {
        }

        @Override // com.google.common.collect.ImmutableMap.C4977b
        /* renamed from: h */
        public ImmutableBiMap<K, V> a() {
            if (this.c == 0) {
                return ImmutableBiMap.of();
            }
            g();
            this.d = true;
            return new RegularImmutableBiMap(this.b, this.c);
        }

        @Override // com.google.common.collect.ImmutableMap.C4977b
        @CanIgnoreReturnValue
        /* renamed from: i */
        public C4964a<K, V> c(K k, V v) {
            super.c(k, v);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.C4977b
        @CanIgnoreReturnValue
        /* renamed from: j */
        public C4964a<K, V> d(Map.Entry<? extends K, ? extends V> entry) {
            super.d(entry);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.C4977b
        @CanIgnoreReturnValue
        @Beta
        /* renamed from: k */
        public C4964a<K, V> e(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            super.e(iterable);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.C4977b
        @CanIgnoreReturnValue
        /* renamed from: l */
        public C4964a<K, V> f(Map<? extends K, ? extends V> map) {
            super.f(map);
            return this;
        }

        C4964a(int i) {
            super(i);
        }
    }

    public static <K, V> C4964a<K, V> builder() {
        return new C4964a<>();
    }

    @Beta
    public static <K, V> C4964a<K, V> builderWithExpectedSize(int i) {
        C5191k.b(i, "expectedSize");
        return new C4964a<>(i);
    }

    public static <K, V> ImmutableBiMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        if (map instanceof ImmutableBiMap) {
            ImmutableBiMap<K, V> immutableBiMap = (ImmutableBiMap) map;
            if (!immutableBiMap.isPartialView()) {
                return immutableBiMap;
            }
        }
        return copyOf((Iterable) map.entrySet());
    }

    public static <K, V> ImmutableBiMap<K, V> of() {
        return RegularImmutableBiMap.EMPTY;
    }

    @Override // com.google.common.collect.BiMap
    @CanIgnoreReturnValue
    @Deprecated
    public V forcePut(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.BiMap
    public abstract ImmutableBiMap<V, K> inverse();

    @Override // com.google.common.collect.ImmutableMap
    Object writeReplace() {
        return new SerializedForm(this);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k, V v) {
        C5191k.a(k, v);
        return new RegularImmutableBiMap(new Object[]{k, v}, 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableMap
    public final ImmutableSet<V> createValues() {
        throw new AssertionError("should never be called");
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k, V v, K k2, V v2) {
        C5191k.a(k, v);
        C5191k.a(k2, v2);
        return new RegularImmutableBiMap(new Object[]{k, v, k2, v2}, 2);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public ImmutableSet<V> values() {
        return inverse().keySet();
    }

    @Beta
    public static <K, V> ImmutableBiMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return new C4964a(iterable instanceof Collection ? ((Collection) iterable).size() : 4).e(iterable).a();
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3) {
        C5191k.a(k, v);
        C5191k.a(k2, v2);
        C5191k.a(k3, v3);
        return new RegularImmutableBiMap(new Object[]{k, v, k2, v2, k3, v3}, 3);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        C5191k.a(k, v);
        C5191k.a(k2, v2);
        C5191k.a(k3, v3);
        C5191k.a(k4, v4);
        return new RegularImmutableBiMap(new Object[]{k, v, k2, v2, k3, v3, k4, v4}, 4);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        C5191k.a(k, v);
        C5191k.a(k2, v2);
        C5191k.a(k3, v3);
        C5191k.a(k4, v4);
        C5191k.a(k5, v5);
        return new RegularImmutableBiMap(new Object[]{k, v, k2, v2, k3, v3, k4, v4, k5, v5}, 5);
    }
}
