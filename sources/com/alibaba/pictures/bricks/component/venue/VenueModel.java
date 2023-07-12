package com.alibaba.pictures.bricks.component.venue;

import com.alibaba.pictures.bricks.bean.VenueBean;
import com.alibaba.pictures.bricks.component.venue.VenueContract;
import com.alibaba.pictures.bricks.onearch.AbsModel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class VenueModel extends AbsModel<IItem<ItemValue>, Object> implements VenueContract.Model<IItem<ItemValue>> {
    private static transient /* synthetic */ IpChange $ipChange;
    private VenueBean venue;

    @Override // com.alibaba.pictures.bricks.component.venue.VenueContract.Model
    public VenueBean getVenue() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "529418101") ? (VenueBean) ipChange.ipc$dispatch("529418101", new Object[]{this}) : this.venue;
    }

    @Override // com.alient.onearch.adapter.view.AbsModel
    public void parseModelImpl(IItem<ItemValue> iItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1331988035")) {
            ipChange.ipc$dispatch("1331988035", new Object[]{this, iItem});
        } else {
            this.venue = (VenueBean) iItem.getProperty().getData().toJavaObject(VenueBean.class);
        }
    }
}
