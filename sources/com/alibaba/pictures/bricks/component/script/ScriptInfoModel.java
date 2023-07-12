package com.alibaba.pictures.bricks.component.script;

import com.alibaba.pictures.bricks.component.script.ScriptInfoContract;
import com.alient.onearch.adapter.view.AbsModel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class ScriptInfoModel extends AbsModel<GenericItem<ItemValue>, ScriptInfoHeaderBean> implements ScriptInfoContract.Model {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.alibaba.pictures.bricks.component.script.ScriptInfoContract.Model
    @NotNull
    public ScriptInfoHeaderBean getScriptInfo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1650494799") ? (ScriptInfoHeaderBean) ipChange.ipc$dispatch("-1650494799", new Object[]{this}) : getValue();
    }
}
