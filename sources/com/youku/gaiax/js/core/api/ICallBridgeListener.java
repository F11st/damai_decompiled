package com.youku.gaiax.js.core.api;

import com.alibaba.fastjson.JSONArray;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J*\u0010\b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&J(\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¨\u0006\f"}, d2 = {"Lcom/youku/gaiax/js/core/api/ICallBridgeListener;", "", "", "contextId", "moduleId", "methodId", "Lcom/alibaba/fastjson/JSONArray;", "args", "callSync", "Ltb/wt2;", "callAsync", "callPromise", "GaiaX-Android-JS"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface ICallBridgeListener {
    void callAsync(long j, long j2, long j3, @NotNull JSONArray jSONArray);

    void callPromise(long j, long j2, long j3, @NotNull JSONArray jSONArray);

    @Nullable
    Object callSync(long j, long j2, long j3, @NotNull JSONArray jSONArray);
}
