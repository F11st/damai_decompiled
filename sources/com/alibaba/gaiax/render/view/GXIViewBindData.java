package com.alibaba.gaiax.render.view;

import com.alibaba.fastjson.JSONObject;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H\u0016¨\u0006\u0007"}, d2 = {"Lcom/alibaba/gaiax/render/view/GXIViewBindData;", "", "Lcom/alibaba/fastjson/JSONObject;", "data", "Ltb/wt2;", "onBindData", "onResetData", "GaiaX"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes6.dex */
public interface GXIViewBindData {

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public static final class a {
        public static void a(@NotNull GXIViewBindData gXIViewBindData) {
            b41.i(gXIViewBindData, "this");
        }
    }

    void onBindData(@Nullable JSONObject jSONObject);

    void onResetData();
}
