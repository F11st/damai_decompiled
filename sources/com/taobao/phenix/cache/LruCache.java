package com.taobao.phenix.cache;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface LruCache<K, V> {
    void clear();

    int count();

    V get(K k);

    float hotPercent();

    boolean isEmpty();

    int maxSize();

    boolean put(int i, K k, V v);

    boolean put(K k, V v);

    V remove(K k);

    void resize(int i, float f);

    int size();

    boolean trimTo(int i);
}
