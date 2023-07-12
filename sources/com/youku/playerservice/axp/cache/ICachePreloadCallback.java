package com.youku.playerservice.axp.cache;

import com.youku.playerservice.axp.cache.CachePreloadResult;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public interface ICachePreloadCallback {
    void onResult(CachePreloadParams cachePreloadParams, CachePreloadResult.AXPCachePreloadStatus aXPCachePreloadStatus, CachePreloadResult cachePreloadResult);
}
