package com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.common.Constants;
import com.taobao.weex.ui.component.WXBasicComponentType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DagoCell extends BaseCellItem<DagoCell> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int TYPE_DEFAULT = 1;
    public String bgColor;
    public String borderColor;
    public int borderWidth;
    public String nBgColor;
    public int fontSize = 14;
    public List<BaseCellItem> cell = new ArrayList();

    public DagoCell(Map map) {
        parseCellItem(map);
    }

    public int getCellType() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1172577169")) {
            return ((Integer) ipChange.ipc$dispatch("1172577169", new Object[]{this})).intValue();
        }
        return 1;
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.BaseCellItem
    public String getType() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1753839296")) {
            return (String) ipChange.ipc$dispatch("1753839296", new Object[]{this});
        }
        return null;
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.BaseCellItem
    public DagoCell parseCellItem(Map map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2001180815")) {
            return (DagoCell) ipChange.ipc$dispatch("-2001180815", new Object[]{this, map});
        }
        if (map == null) {
            return this;
        }
        this.bgColor = getColor(map.get("bgColor"));
        this.nBgColor = getColor(map.get("nBgColor"));
        this.borderWidth = getInt(map.get(Constants.Name.BORDER_WIDTH));
        this.borderColor = getColor(map.get("borderColor"));
        this.fontSize = getInt(map.get("fontSize"));
        Object obj = map.get(WXBasicComponentType.CELL);
        if (obj instanceof List) {
            for (Map map2 : (List) obj) {
                String valueOf = map2.containsKey("type") ? String.valueOf(map2.get("type")) : null;
                if ("text".equals(valueOf)) {
                    this.cell.add(new TextCellItem(map2));
                } else if ("image".equals(valueOf)) {
                    this.cell.add(new ImageCellItem(map2));
                } else if (BaseCellItem.TYPE_FACE.equals(valueOf)) {
                    this.cell.add(new FaceCellItem(map2));
                } else if ("gift".equals(valueOf)) {
                    this.cell.add(new GiftCellItem(map2));
                } else if (BaseCellItem.TYPE_MEDAL.equals(valueOf)) {
                    this.cell.add(new MedalCellItem(map2));
                } else if (BaseCellItem.TYPE_MEDAL_ANCHOR_LEVEL.equals(valueOf)) {
                    this.cell.add(new AnchorLevelCellItem(map2));
                } else if (BaseCellItem.TYPE_MEDAL_USER_LEVEL.equals(valueOf)) {
                    this.cell.add(new UserLevelCellItem(map2));
                } else if (BaseCellItem.TYPE_BUTTON.equals(valueOf)) {
                    this.cell.add(new ButtonCellItem(map2));
                }
            }
            return this;
        }
        return this;
    }

    public DagoCell() {
    }
}
