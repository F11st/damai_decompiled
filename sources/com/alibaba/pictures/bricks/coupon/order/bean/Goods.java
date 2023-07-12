package com.alibaba.pictures.bricks.coupon.order.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class Goods implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String goodsAmount;
    @Nullable
    private List<Good> goodsList;
    @Nullable
    private String goodsUseTitle;

    @Nullable
    public final String getGoodsAmount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "325422878") ? (String) ipChange.ipc$dispatch("325422878", new Object[]{this}) : this.goodsAmount;
    }

    @Nullable
    public final List<Good> getGoodsList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1431224779") ? (List) ipChange.ipc$dispatch("1431224779", new Object[]{this}) : this.goodsList;
    }

    @Nullable
    public final String getGoodsUseTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1610292887") ? (String) ipChange.ipc$dispatch("1610292887", new Object[]{this}) : this.goodsUseTitle;
    }

    public final void setGoodsAmount(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-801776616")) {
            ipChange.ipc$dispatch("-801776616", new Object[]{this, str});
        } else {
            this.goodsAmount = str;
        }
    }

    public final void setGoodsList(@Nullable List<Good> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "707588345")) {
            ipChange.ipc$dispatch("707588345", new Object[]{this, list});
        } else {
            this.goodsList = list;
        }
    }

    public final void setGoodsUseTitle(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "805775551")) {
            ipChange.ipc$dispatch("805775551", new Object[]{this, str});
        } else {
            this.goodsUseTitle = str;
        }
    }
}
