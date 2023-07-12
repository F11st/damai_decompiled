package com.alibaba.pictures.bricks.component.text;

import android.text.TextUtils;
import com.alibaba.pictures.bricks.component.text.FoldTextViewContract;
import com.alient.onearch.adapter.view.AbsModel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class FoldTextViewModel extends AbsModel<GenericItem<ItemValue>, FoldTextViewBean> implements FoldTextViewContract.Model {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.alibaba.pictures.bricks.component.text.FoldTextViewContract.Model
    @NotNull
    public String getDesc() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "177735676") ? (String) ipChange.ipc$dispatch("177735676", new Object[]{this}) : TextUtils.isEmpty(getValue().getDesc()) ? "" : String.valueOf(getValue().getDesc());
    }
}
