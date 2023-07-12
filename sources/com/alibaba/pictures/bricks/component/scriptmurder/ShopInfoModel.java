package com.alibaba.pictures.bricks.component.scriptmurder;

import com.alibaba.pictures.bricks.bean.ShopInfoBean;
import com.alibaba.pictures.bricks.component.scriptmurder.ShopInfoContract;
import com.alient.onearch.adapter.view.AbsModel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class ShopInfoModel extends AbsModel<GenericItem<ItemValue>, ShopInfoBean> implements ShopInfoContract.Model {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.alibaba.pictures.bricks.component.scriptmurder.ShopInfoContract.Model
    @NotNull
    public ShopInfoBean getShopInfo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1414923393") ? (ShopInfoBean) ipChange.ipc$dispatch("-1414923393", new Object[]{this}) : getValue();
    }
}
