package com.alibaba.pictures.bricks.component.scriptcoupon;

import com.alibaba.pictures.bricks.bean.CouponInfoBean;
import com.alibaba.pictures.bricks.component.scriptcoupon.CouponInfoContract;
import com.alient.onearch.adapter.view.AbsModel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class CouponInfoModel extends AbsModel<GenericItem<ItemValue>, CouponInfoBean> implements CouponInfoContract.Model {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.alibaba.pictures.bricks.component.scriptcoupon.CouponInfoContract.Model
    @NotNull
    public CouponInfoBean getCouponInfoBean() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-975619648") ? (CouponInfoBean) ipChange.ipc$dispatch("-975619648", new Object[]{this}) : getValue();
    }
}
