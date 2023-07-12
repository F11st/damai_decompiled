package com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.ui.component.WXComponent;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ImageCellItem extends BaseCellItem<ImageCellItem> {
    private static transient /* synthetic */ IpChange $ipChange;
    public boolean cache;
    public String clickData;
    public int h;
    public String src;
    public int w;

    public ImageCellItem(Map map) {
        parseCellItem(map);
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.BaseCellItem
    public String getType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1168648683") ? (String) ipChange.ipc$dispatch("-1168648683", new Object[]{this}) : "image";
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.BaseCellItem
    public ImageCellItem parseCellItem(Map map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1828848999")) {
            return (ImageCellItem) ipChange.ipc$dispatch("-1828848999", new Object[]{this, map});
        }
        if (map.containsKey("src")) {
            this.src = getString(map.get("src"));
        }
        if (map.containsKey(WXComponent.PROP_FS_WRAP_CONTENT)) {
            this.w = getInt(map.get(WXComponent.PROP_FS_WRAP_CONTENT));
        }
        if (map.containsKey("h")) {
            this.h = getInt(map.get("h"));
        }
        if (map.containsKey("cache")) {
            this.cache = getBoolean(map.get("cache"));
        }
        if (map.containsKey("clickData")) {
            this.clickData = getString(map.get("clickData"));
        }
        return this;
    }

    public ImageCellItem() {
    }
}
