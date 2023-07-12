package com.taobao.phenix.cache.disk;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface DiskCacheKeyValueStore {
    String get(String str);

    long getCurrentTime();

    void init();

    boolean isExpectedTime(long j);

    boolean isTTLDomain(String str);

    boolean put(String str, long j);
}
