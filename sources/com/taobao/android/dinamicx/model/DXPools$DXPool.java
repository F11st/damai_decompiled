package com.taobao.android.dinamicx.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.android.dinamicx.model.DXPools$DXPoolItem;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface DXPools$DXPool<T extends DXPools$DXPoolItem> {
    @Nullable
    T acquire();

    @Nullable
    T acquire(Object obj);

    boolean release(@NonNull T t);
}
