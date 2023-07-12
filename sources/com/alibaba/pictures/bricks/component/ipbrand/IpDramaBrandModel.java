package com.alibaba.pictures.bricks.component.ipbrand;

import com.alibaba.pictures.bricks.bean.IpDramaBrandArchBean;
import com.alibaba.pictures.bricks.component.ipbrand.IpDramaBrandContract;
import com.alibaba.pictures.bricks.onearch.AbsModel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class IpDramaBrandModel extends AbsModel<IItem<ItemValue>, Object> implements IpDramaBrandContract.Model<IItem<ItemValue>> {
    private static transient /* synthetic */ IpChange $ipChange;
    private IpDramaBrandArchBean ipDramaBrandArchBean;

    @Override // com.alibaba.pictures.bricks.component.ipbrand.IpDramaBrandContract.Model
    public IpDramaBrandArchBean getIpDramaBrandArchBean() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1731943606") ? (IpDramaBrandArchBean) ipChange.ipc$dispatch("1731943606", new Object[]{this}) : this.ipDramaBrandArchBean;
    }

    @Override // com.alient.onearch.adapter.view.AbsModel
    public void parseModelImpl(IItem<ItemValue> iItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "284527374")) {
            ipChange.ipc$dispatch("284527374", new Object[]{this, iItem});
        } else {
            this.ipDramaBrandArchBean = (IpDramaBrandArchBean) iItem.getProperty().getData().toJavaObject(IpDramaBrandArchBean.class);
        }
    }
}
