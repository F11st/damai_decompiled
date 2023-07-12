package com.alibaba.android.bindingx.core;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;
import tb.xg0;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public interface IEventInterceptor {
    void performInterceptIfNeeded(@NonNull String str, @NonNull xg0 xg0Var, @NonNull Map<String, Object> map);

    void setInterceptors(@Nullable Map<String, xg0> map);
}
