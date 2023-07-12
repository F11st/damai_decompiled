package com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class GiftCellItem extends BaseCellItem<GiftCellItem> {
    private static transient /* synthetic */ IpChange $ipChange;
    public int id;

    public GiftCellItem(Map map) {
        parseCellItem(map);
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.BaseCellItem
    public String getType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1965914882") ? (String) ipChange.ipc$dispatch("-1965914882", new Object[]{this}) : "gift";
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.BaseCellItem
    public GiftCellItem parseCellItem(Map map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "772417585")) {
            return (GiftCellItem) ipChange.ipc$dispatch("772417585", new Object[]{this, map});
        }
        if (map.containsKey("id")) {
            this.id = getInt(map.get("id"));
        }
        return this;
    }

    public GiftCellItem() {
    }
}
