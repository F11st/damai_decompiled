package com.alibaba.pictures.bricks.component.artist;

import com.alibaba.pictures.bricks.component.artist.ArtistContract;
import com.alibaba.pictures.bricks.onearch.AbsModel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ArtistModel extends AbsModel<IItem<ItemValue>, Object> implements ArtistContract.Model<IItem<ItemValue>> {
    private static transient /* synthetic */ IpChange $ipChange;
    private BaccountInfo artist;

    @Override // com.alibaba.pictures.bricks.component.artist.ArtistContract.Model
    public BaccountInfo getArtist() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "588012750") ? (BaccountInfo) ipChange.ipc$dispatch("588012750", new Object[]{this}) : this.artist;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alient.onearch.adapter.view.AbsModel
    public void parseModelImpl(IItem<ItemValue> iItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1133736771")) {
            ipChange.ipc$dispatch("1133736771", new Object[]{this, iItem});
        } else {
            this.artist = (BaccountInfo) iItem.getProperty().getData().toJavaObject(BaccountInfo.class);
        }
    }
}
