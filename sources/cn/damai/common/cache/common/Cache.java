package cn.damai.common.cache.common;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public interface Cache<K, V> {
    void clear();

    V get(K k);

    void save(K k, V v);
}
