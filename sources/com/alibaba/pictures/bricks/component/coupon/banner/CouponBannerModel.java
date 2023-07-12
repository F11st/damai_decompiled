package com.alibaba.pictures.bricks.component.coupon.banner;

import com.alibaba.pictures.bricks.bean.PicInfoBean;
import com.alibaba.pictures.bricks.component.coupon.banner.CouponBannerContract;
import com.alient.onearch.adapter.view.AbsModel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class CouponBannerModel extends AbsModel<GenericItem<ItemValue>, PicInfoBean> implements CouponBannerContract.Model {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.alibaba.pictures.bricks.component.coupon.banner.CouponBannerContract.Model
    @NotNull
    public PicInfoBean getContent() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1093222409") ? (PicInfoBean) ipChange.ipc$dispatch("-1093222409", new Object[]{this}) : getValue();
    }
}
