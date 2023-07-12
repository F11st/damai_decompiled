package com.alibaba.android.ultron.vfw.core;

import androidx.annotation.NonNull;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public interface IServiceManager {
    <T> T getService(@NonNull Class<T> cls);

    <T> void registerService(@NonNull Class<T> cls, @NonNull T t);
}
