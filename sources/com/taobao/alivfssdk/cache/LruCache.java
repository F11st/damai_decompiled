package com.taobao.alivfssdk.cache;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public interface LruCache<K, V> {
    public static final int HIGH_PRIORITY = 34;
    public static final int MEDIUM_PRIORITY = 17;

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
