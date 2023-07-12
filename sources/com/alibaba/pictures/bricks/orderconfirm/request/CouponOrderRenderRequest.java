package com.alibaba.pictures.bricks.orderconfirm.request;

import com.alibaba.pictures.bricks.base.DamaiBaseRequest;
import com.alibaba.pictures.bricks.orderconfirm.bean.CouponOrderRenderBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class CouponOrderRenderRequest extends DamaiBaseRequest<CouponOrderRenderBean> {
    private static transient /* synthetic */ IpChange $ipChange;
    private int buyAmount;
    @Nullable
    private String dmChannel;
    @Nullable
    private String itemId;
    @Nullable
    private String skuId;

    public CouponOrderRenderRequest() {
        this.API_NAME = "mtop.damai.wireless.trade.common.order.confirm";
        this.VERSION = "1.0";
        this.NEED_ECODE = true;
        this.NEED_SESSION = true;
        this.buyAmount = 1;
    }

    public final int getBuyAmount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1769262674") ? ((Integer) ipChange.ipc$dispatch("1769262674", new Object[]{this})).intValue() : this.buyAmount;
    }

    @Nullable
    public final String getDmChannel() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1952180189") ? (String) ipChange.ipc$dispatch("1952180189", new Object[]{this}) : this.dmChannel;
    }

    @Nullable
    public final String getItemId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "353554049") ? (String) ipChange.ipc$dispatch("353554049", new Object[]{this}) : this.itemId;
    }

    @Nullable
    public final String getSkuId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-462397509") ? (String) ipChange.ipc$dispatch("-462397509", new Object[]{this}) : this.skuId;
    }

    public final void setBuyAmount(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1476122360")) {
            ipChange.ipc$dispatch("1476122360", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.buyAmount = i;
        }
    }

    public final void setDmChannel(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1577161159")) {
            ipChange.ipc$dispatch("-1577161159", new Object[]{this, str});
        } else {
            this.dmChannel = str;
        }
    }

    public final void setItemId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "975148925")) {
            ipChange.ipc$dispatch("975148925", new Object[]{this, str});
        } else {
            this.itemId = str;
        }
    }

    public final void setSkuId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1041946651")) {
            ipChange.ipc$dispatch("1041946651", new Object[]{this, str});
        } else {
            this.skuId = str;
        }
    }
}
