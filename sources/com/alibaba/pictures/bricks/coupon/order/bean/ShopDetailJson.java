package com.alibaba.pictures.bricks.coupon.order.bean;

import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class ShopDetailJson implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final JSONObject shopJson;

    public ShopDetailJson(@NotNull JSONObject jSONObject) {
        b41.i(jSONObject, "shopJson");
        this.shopJson = jSONObject;
    }

    @NotNull
    public final JSONObject getShopJson() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-818554439") ? (JSONObject) ipChange.ipc$dispatch("-818554439", new Object[]{this}) : this.shopJson;
    }
}
