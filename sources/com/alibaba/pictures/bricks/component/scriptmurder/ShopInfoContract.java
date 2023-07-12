package com.alibaba.pictures.bricks.component.scriptmurder;

import com.alibaba.pictures.bricks.bean.ShopInfoBean;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public interface ShopInfoContract {

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Model {
        @NotNull
        ShopInfoBean getShopInfo();
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Present {
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface View {
        @NotNull
        ShopInfoViewHolder getViewHolder();
    }
}
