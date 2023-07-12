package com.taobao.alivfssdk.fresco.cache.common;

import androidx.annotation.Nullable;
import com.taobao.alivfssdk.fresco.cache.common.CacheEventListener;
import java.io.IOException;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public interface CacheEvent {
    @Nullable
    CacheKey getCacheKey();

    long getCacheLimit();

    long getCacheSize();

    long getElapsed();

    @Nullable
    CacheEventListener.EvictionReason getEvictionReason();

    @Nullable
    IOException getException();

    long getItemSize();

    @Nullable
    String getResourceId();
}
