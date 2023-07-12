package com.alibaba.pictures.bricks.component.imgcard;

import com.alibaba.pictures.bricks.component.imgcard.BannerContract;
import com.alient.onearch.adapter.view.AbsModel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class BannerModel extends AbsModel<GenericItem<ItemValue>, BannerBean> implements BannerContract.Model {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.alibaba.pictures.bricks.component.imgcard.BannerContract.Model
    @NotNull
    public BannerBean getContent() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1776575502") ? (BannerBean) ipChange.ipc$dispatch("-1776575502", new Object[]{this}) : getValue();
    }
}
