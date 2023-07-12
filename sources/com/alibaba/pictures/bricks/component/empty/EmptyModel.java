package com.alibaba.pictures.bricks.component.empty;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.bricks.component.empty.EmptyContract;
import com.alibaba.pictures.bricks.onearch.AbsModel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class EmptyModel extends AbsModel<IItem<ItemValue>, Object> implements EmptyContract.Model<IItem<ItemValue>> {
    private static transient /* synthetic */ IpChange $ipChange;
    private String content;

    @Override // com.alibaba.pictures.bricks.component.empty.EmptyContract.Model
    public String getContent() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1090747590") ? (String) ipChange.ipc$dispatch("-1090747590", new Object[]{this}) : this.content;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alient.onearch.adapter.view.AbsModel
    public void parseModelImpl(IItem<ItemValue> iItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-411052417")) {
            ipChange.ipc$dispatch("-411052417", new Object[]{this, iItem});
            return;
        }
        super.parseModelImpl(iItem);
        JSONObject data = iItem.getProperty().getData();
        if (data == null || !data.containsKey("content")) {
            return;
        }
        this.content = data.getString("content");
    }
}
