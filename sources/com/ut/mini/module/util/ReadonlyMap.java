package com.ut.mini.module.util;

import android.annotation.TargetApi;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ReadonlyMap<K, V> extends HashMap<K, V> {
    public ReadonlyMap(int i, float f) {
        super(i, f);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void clear() {
    }

    @Override // java.util.HashMap, java.util.AbstractMap
    @NonNull
    @TargetApi(24)
    public Object clone() {
        return super.clone();
    }

    @Override // java.util.HashMap, java.util.Map
    @Nullable
    @TargetApi(24)
    public V compute(K k, @NonNull BiFunction<? super K, ? super V, ? extends V> biFunction) {
        return null;
    }

    @Override // java.util.HashMap, java.util.Map
    @Nullable
    @TargetApi(24)
    public V computeIfAbsent(K k, @NonNull Function<? super K, ? extends V> function) {
        return null;
    }

    @Override // java.util.HashMap, java.util.Map
    @Nullable
    @TargetApi(24)
    public V computeIfPresent(K k, @NonNull BiFunction<? super K, ? super V, ? extends V> biFunction) {
        return null;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public boolean containsKey(@Nullable Object obj) {
        return super.containsKey(obj);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public boolean containsValue(@Nullable Object obj) {
        return super.containsValue(obj);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    @NonNull
    public Set<Map.Entry<K, V>> entrySet() {
        return super.entrySet();
    }

    @Override // java.util.HashMap, java.util.Map
    @TargetApi(24)
    public void forEach(@NonNull BiConsumer<? super K, ? super V> biConsumer) {
        super.forEach(biConsumer);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    @Nullable
    public V get(@Nullable Object obj) {
        return (V) super.get(obj);
    }

    @Override // java.util.HashMap, java.util.Map
    @Nullable
    @TargetApi(24)
    public V getOrDefault(@Nullable Object obj, @Nullable V v) {
        return (V) super.getOrDefault(obj, v);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    @NonNull
    public Set<K> keySet() {
        return super.keySet();
    }

    @Override // java.util.HashMap, java.util.Map
    @Nullable
    @TargetApi(24)
    public V merge(K k, @NonNull V v, @NonNull BiFunction<? super V, ? super V, ? extends V> biFunction) {
        return null;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    @Nullable
    public V put(K k, V v) {
        return null;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void putAll(@NonNull Map<? extends K, ? extends V> map) {
    }

    @Override // java.util.HashMap, java.util.Map
    @Nullable
    @TargetApi(24)
    public V putIfAbsent(K k, V v) {
        return null;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    @Nullable
    public V remove(@Nullable Object obj) {
        return null;
    }

    @Override // java.util.HashMap, java.util.Map
    public boolean remove(@Nullable Object obj, @Nullable Object obj2) {
        return false;
    }

    @Override // java.util.HashMap, java.util.Map
    @Nullable
    @TargetApi(24)
    public V replace(K k, V v) {
        return null;
    }

    @Override // java.util.HashMap, java.util.Map
    @TargetApi(24)
    public boolean replace(K k, @Nullable V v, V v2) {
        return false;
    }

    @Override // java.util.HashMap, java.util.Map
    @TargetApi(24)
    public void replaceAll(@NonNull BiFunction<? super K, ? super V, ? extends V> biFunction) {
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public int size() {
        return super.size();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    @NonNull
    public Collection<V> values() {
        return super.values();
    }

    public ReadonlyMap(int i) {
        super(i);
    }

    public ReadonlyMap() {
    }

    public ReadonlyMap(@NonNull Map<? extends K, ? extends V> map) {
        super(map);
    }
}
