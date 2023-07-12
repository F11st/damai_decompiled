package com.alibaba.pictures.bricks.component.instructions;

import com.alibaba.pictures.bricks.bean.ServiceNoteInfoBean;
import com.alibaba.pictures.bricks.component.instructions.PurchaseInstructionsContract;
import com.alient.onearch.adapter.view.AbsModel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class PurchaseInstructionsModel extends AbsModel<GenericItem<ItemValue>, ServiceNoteInfoBean> implements PurchaseInstructionsContract.Model {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.alibaba.pictures.bricks.component.instructions.PurchaseInstructionsContract.Model
    @Nullable
    public String getContent() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1980892513") ? (String) ipChange.ipc$dispatch("-1980892513", new Object[]{this}) : getValue().content;
    }

    @Override // com.alibaba.pictures.bricks.component.instructions.PurchaseInstructionsContract.Model
    @Nullable
    public String getTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1209844290") ? (String) ipChange.ipc$dispatch("-1209844290", new Object[]{this}) : getValue().title;
    }
}
