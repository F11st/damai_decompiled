package com.taobao.android.dinamicx.videoc.expose.core;

import androidx.annotation.NonNull;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface IExposureZone<ExposeKey, ExposeData> {

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface Builder<ExposeKey, ExposeData> {
        IExposureZone<ExposeKey, ExposeData> build(@NonNull IExposure<ExposeKey, ExposeData> iExposure);

        IExposureZone<ExposeKey, ExposeData> build(@NonNull IExposure<ExposeKey, ExposeData> iExposure, @NonNull String str);
    }

    void attach();

    void detach();

    @NonNull
    IExposure<ExposeKey, ExposeData> exposure();

    boolean isAttached();

    @NonNull
    String key();
}
