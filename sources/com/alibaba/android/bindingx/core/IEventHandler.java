package com.alibaba.android.bindingx.core;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.android.bindingx.core.BindingXCore;
import java.util.List;
import java.util.Map;
import tb.xg0;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public interface IEventHandler extends IEventInterceptor {
    void onActivityPause();

    void onActivityResume();

    void onBindExpression(@NonNull String str, @Nullable Map<String, Object> map, @Nullable xg0 xg0Var, @NonNull List<Map<String, Object>> list, @Nullable BindingXCore.JavaScriptCallback javaScriptCallback);

    boolean onCreate(@NonNull String str, @NonNull String str2);

    void onDestroy();

    boolean onDisable(@NonNull String str, @NonNull String str2);

    void onStart(@NonNull String str, @NonNull String str2);

    void setAnchorInstanceId(String str);

    void setExtensionParams(Object[] objArr);

    void setGlobalConfig(@Nullable Map<String, Object> map);

    void setHandlerCleaner(IHandlerCleanable iHandlerCleanable);

    void setOriginalParams(Map<String, Object> map);

    void setToken(String str);
}
