package com.youku.playerservice.axp.cache.task;

import com.youku.playerservice.axp.cache.CachePreloadParams;
import com.youku.playerservice.axp.cache.CachePreloadResult;
import com.youku.playerservice.axp.cache.IInternalCachePreloadCallback;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class PlayInfoMultiCacheTask extends CacheTask {
    private IInternalCachePreloadCallback mInternalCallback;
    private String mKey;
    private CachePreloadParams mPreloadParams;

    public PlayInfoMultiCacheTask(String str, CachePreloadParams cachePreloadParams, IInternalCachePreloadCallback iInternalCachePreloadCallback) {
        this.mKey = str;
        this.mPreloadParams = cachePreloadParams;
        this.mInternalCallback = iInternalCachePreloadCallback;
    }

    @Override // com.youku.playerservice.axp.cache.task.CacheTask, java.util.concurrent.Callable
    public CachePreloadResult call() {
        return null;
    }
}
