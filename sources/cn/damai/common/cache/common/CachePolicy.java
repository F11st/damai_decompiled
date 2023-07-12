package cn.damai.common.cache.common;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public interface CachePolicy<K, V> {
    V cacheValue(K k, V v);

    void clear();

    int computeValueSize(V v);

    int currentCacheSize();

    int evictionCount();

    int getHitCount();

    int getMissCount();

    V getValue(K k);

    int maxCacheSize();

    boolean shouldTrim();

    void trim();
}
