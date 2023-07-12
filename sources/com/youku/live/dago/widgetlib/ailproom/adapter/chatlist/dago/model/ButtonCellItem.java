package com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ButtonCellItem extends BaseCellItem<ButtonCellItem> {
    private static transient /* synthetic */ IpChange $ipChange;
    public String[] bg;
    public String clickData;
    public String color;
    public boolean hiddenAfterClick;
    public String text;

    public ButtonCellItem(Map map) {
        this.bg = new String[2];
        parseCellItem(map);
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.BaseCellItem
    public String getType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1116154112") ? (String) ipChange.ipc$dispatch("-1116154112", new Object[]{this}) : BaseCellItem.TYPE_BUTTON;
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.BaseCellItem
    public ButtonCellItem parseCellItem(Map map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2067062321")) {
            return (ButtonCellItem) ipChange.ipc$dispatch("2067062321", new Object[]{this, map});
        }
        if (map.containsKey("text")) {
            this.text = getString(map.get("text"));
        }
        if (map.containsKey("color")) {
            this.color = getColor(map.get("color"));
        }
        if (map.containsKey("clickData")) {
            this.clickData = getString(map.get("clickData"));
        }
        if (map.containsKey("hiddenAfterClick")) {
            this.hiddenAfterClick = getBoolean(map.get("hiddenAfterClick"));
        }
        if (map.get("bg") instanceof List) {
            List list = (List) map.get("bg");
            this.bg[0] = getColor(list.get(0));
            this.bg[1] = getColor(list.get(1));
        }
        return this;
    }

    public ButtonCellItem() {
        this.bg = new String[2];
    }
}
