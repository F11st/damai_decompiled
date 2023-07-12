package com.taobao.android.dinamicx.videoc.expose.core;

import android.os.Handler;
import android.util.LruCache;
import androidx.annotation.NonNull;
import com.taobao.android.dinamicx.videoc.expose.core.listener.ExposureLifecycle;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface IExposureCenter<ExposeKey, ExposeData, CacheDataType> {
    @NonNull
    IExposure<ExposeKey, ExposeData> buildExposure(@NonNull ExposureLifecycle<ExposeKey, ExposeData> exposureLifecycle);

    @NonNull
    IExposure<ExposeKey, ExposeData> buildExposure(@NonNull ExposureLifecycle<ExposeKey, ExposeData> exposureLifecycle, long j);

    @NonNull
    LruCache<ExposeKey, CacheDataType> globalCache();

    @NonNull
    Handler globalHandler();
}
