package com.taobao.android.dinamicx.videoc.expose.core;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface IExposure<ExposeKey, ExposeData> {

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface Builder<ExposeKey, ExposeData> {
        IExposure<ExposeKey, ExposeData> build();
    }

    void cancelExpose(@Nullable ExposeKey exposekey, String str);

    void cancelExpose(@Nullable ExposeKey exposekey, String str, boolean z);

    void clearCache();

    void destroy();

    void expose(@NonNull ExposeKey exposekey, @Nullable ExposeData exposedata, String str);

    void exposeAtOnce(@NonNull ExposeKey exposekey, @Nullable ExposeData exposedata, String str);

    void exposeCache();

    void prepare();

    Map<ExposeKey, ExposeData> removeAllExposeData();

    ExposeData removeCache(@Nullable ExposeKey exposekey, String str);

    void removeExposeData(@NonNull ExposeKey exposekey, String str);

    void storeExposeData(@NonNull ExposeKey exposekey, @Nullable ExposeData exposedata);

    void triggerExpose(@NonNull String str);

    void triggerExposeAtOnce(@NonNull String str);
}
