package com.taobao.alivfssdk.fresco.cache.common;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public interface CacheEventListener {

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public enum EvictionReason {
        CACHE_FULL,
        CONTENT_STALE,
        USER_FORCED,
        CACHE_MANAGER_TRIMMED
    }

    boolean onEviction(CacheEvent cacheEvent);

    void onHit(CacheEvent cacheEvent);

    void onMiss(CacheEvent cacheEvent);

    void onReadException(CacheEvent cacheEvent);

    void onRemoveSuccess(CacheEvent cacheEvent);

    void onWriteAttempt(CacheEvent cacheEvent);

    void onWriteException(CacheEvent cacheEvent);

    void onWriteSuccess(CacheEvent cacheEvent);
}
