package com.alibaba.pictures.bricks.component.script;

import com.alibaba.pictures.bricks.bean.SearchScriptBean;
import com.alibaba.pictures.bricks.component.script.ScriptContract;
import com.alibaba.pictures.bricks.onearch.AbsModel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class ScriptModel extends AbsModel<GenericItem<ItemValue>, SearchScriptBean> implements ScriptContract.Model {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.alibaba.pictures.bricks.component.script.ScriptContract.Model
    @Nullable
    public SearchScriptBean getData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-638061608") ? (SearchScriptBean) ipChange.ipc$dispatch("-638061608", new Object[]{this}) : getValue();
    }
}
