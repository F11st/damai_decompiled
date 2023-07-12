package com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.huawei.hms.opendevice.c;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class MedalCellItem extends BaseCellItem<MedalCellItem> {
    private static transient /* synthetic */ IpChange $ipChange;
    public String c;
    public int id;

    public MedalCellItem(Map map) {
        parseCellItem(map);
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.BaseCellItem
    public String getType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "778536625") ? (String) ipChange.ipc$dispatch("778536625", new Object[]{this}) : BaseCellItem.TYPE_MEDAL;
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.BaseCellItem
    public MedalCellItem parseCellItem(Map map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "763014497")) {
            return (MedalCellItem) ipChange.ipc$dispatch("763014497", new Object[]{this, map});
        }
        if (map.containsKey("id")) {
            this.id = getInt(map.get("id"));
        }
        if (map.containsKey(c.a)) {
            this.c = getString(map.get(c.a));
        }
        return this;
    }

    public MedalCellItem() {
    }
}
