package com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.common.Constants;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class TextCellItem extends BaseCellItem<TextCellItem> {
    private static transient /* synthetic */ IpChange $ipChange;
    public boolean bold;
    public String clickData;
    public String color;
    public boolean emoji;
    public String text;

    public TextCellItem() {
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.BaseCellItem
    public String getType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-661619909") ? (String) ipChange.ipc$dispatch("-661619909", new Object[]{this}) : "text";
    }

    public TextCellItem(Map map) {
        parseCellItem(map);
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.BaseCellItem
    public TextCellItem parseCellItem(Map map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1305249425")) {
            return (TextCellItem) ipChange.ipc$dispatch("1305249425", new Object[]{this, map});
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
        if (map.containsKey("emoji")) {
            this.emoji = getBoolean(map.get("emoji"));
        }
        if (map.containsKey(Constants.Value.BOLD)) {
            this.bold = getBoolean(map.get(Constants.Value.BOLD));
        }
        return this;
    }
}
