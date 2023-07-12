package com.youku.gaiax.js.api;

import androidx.annotation.Keep;
import com.alibaba.fastjson.JSONArray;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u0003H&¨\u0006\b"}, d2 = {"Lcom/youku/gaiax/js/api/IGaiaXModuleMethod;", "", "obj", "Lcom/alibaba/fastjson/JSONArray;", "args", "invoke", "Ltb/wt2;", "convertArgsToArguments", "GaiaX-Android-JS"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface IGaiaXModuleMethod {
    void convertArgsToArguments(@NotNull JSONArray jSONArray);

    @Nullable
    Object invoke(@NotNull Object obj, @NotNull JSONArray jSONArray);
}
