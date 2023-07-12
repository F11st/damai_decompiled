package com.alibaba.pictures.bricks.component.home.grabhotrecommend;

import com.alibaba.fastjson.JSONObject;
import com.alient.onearch.adapter.component.banner.loop.LoopBannerContract;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public interface HomeGrabHotRecommendContainerContract extends LoopBannerContract {

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Model {
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Present {
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface View {
        void bindView(@Nullable JSONObject jSONObject, @Nullable String str);
    }
}
