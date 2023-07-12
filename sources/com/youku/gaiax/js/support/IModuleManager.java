package com.youku.gaiax.js.support;

import com.alibaba.fastjson.JSONArray;
import com.youku.gaiax.js.api.GaiaXBaseModule;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b`\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H&J\u0018\u0010\u0007\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H&J\b\u0010\t\u001a\u00020\bH&J\"\u0010\u000f\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH&J \u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH&J \u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH&¨\u0006\u0012"}, d2 = {"Lcom/youku/gaiax/js/support/IModuleManager;", "", "Ljava/lang/Class;", "Lcom/youku/gaiax/js/api/GaiaXBaseModule;", "moduleClazz", "Ltb/wt2;", "registerModule", "unregisterModule", "", "buildModulesScript", "", "moduleId", "methodId", "Lcom/alibaba/fastjson/JSONArray;", "args", "invokeMethodSync", "invokeMethodAsync", "invokePromiseMethod", "GaiaX-Android-JS"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface IModuleManager {
    @NotNull
    String buildModulesScript();

    void invokeMethodAsync(long j, long j2, @NotNull JSONArray jSONArray);

    @Nullable
    Object invokeMethodSync(long j, long j2, @NotNull JSONArray jSONArray);

    void invokePromiseMethod(long j, long j2, @NotNull JSONArray jSONArray);

    void registerModule(@NotNull Class<? extends GaiaXBaseModule> cls);

    void unregisterModule(@NotNull Class<? extends GaiaXBaseModule> cls);
}
