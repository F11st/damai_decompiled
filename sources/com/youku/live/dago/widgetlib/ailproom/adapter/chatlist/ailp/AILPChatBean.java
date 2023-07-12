package com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.ailp;

import android.graphics.Color;
import android.text.TextUtils;
import com.alipay.sdk.m.s.a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.common.Constants;
import com.taobao.weex.ui.component.WXComponent;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.BaseCellItem;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.span.ImageBean;
import com.youku.live.dago.widgetlib.ailproom.manager.ChatResourceManager;
import com.youku.live.livesdk.wkit.component.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class AILPChatBean {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String DEFAULT = "default";
    private static final String SHARE = "share";
    public static final int TYPE_ATTENTION = 3;
    public static final int TYPE_DEFAULT = 1;
    public static final int TYPE_SHARE = 2;
    private List<ImageBean> an;
    private int anchorColor;
    private String anchorName;
    private String anchorNameAlpha;
    private String anchorNameColor;
    private String bgAlpha;
    private String bgColor;
    private int bgColorValue;
    private List<ImageBean> bn;
    private String borderColor;
    private String borderWidth;
    private String cellType;
    private int concatColor;
    private String concatUserAndAnchor;
    private String concatUserAndAnchorAlpha;
    private String concatUserAndAnchorColor;
    private String data;
    private String face;
    private String faceIcon;
    private int lineNum;
    private String name;
    private String nameAlpha;
    private String nameColor;
    private String source;
    private String textAlpha;
    private String textColor;
    private String type;

    public AILPChatBean() {
        this.anchorColor = 0;
        this.concatColor = 0;
        this.bgColorValue = -1;
    }

    public List<ImageBean> getAn() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2092938682") ? (List) ipChange.ipc$dispatch("2092938682", new Object[]{this}) : this.an;
    }

    public String getAnchorName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-177297530") ? (String) ipChange.ipc$dispatch("-177297530", new Object[]{this}) : this.anchorName;
    }

    public int getAnchorNameColor() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "37521280")) {
            return ((Integer) ipChange.ipc$dispatch("37521280", new Object[]{this})).intValue();
        }
        if (this.anchorColor == 0) {
            this.anchorColor = getColor(this.anchorNameAlpha, this.anchorNameColor, -1);
        }
        return this.anchorColor;
    }

    public int getBgAlpha() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1535864054")) {
            return ((Integer) ipChange.ipc$dispatch("-1535864054", new Object[]{this})).intValue();
        }
        try {
            return Integer.parseInt(this.bgAlpha, 16);
        } catch (Exception e) {
            e.printStackTrace();
            return 255;
        }
    }

    public int getBgColor() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "209754853")) {
            return ((Integer) ipChange.ipc$dispatch("209754853", new Object[]{this})).intValue();
        }
        int i = this.bgColorValue;
        if (i != -1) {
            return i;
        }
        int color = getColor("ff", this.bgColor);
        this.bgColorValue = color;
        return color;
    }

    public List<ImageBean> getBn() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1684114457") ? (List) ipChange.ipc$dispatch("1684114457", new Object[]{this}) : this.bn;
    }

    public String getBorderColor() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1411304295") ? (String) ipChange.ipc$dispatch("1411304295", new Object[]{this}) : this.borderColor;
    }

    public int getBorderWidth() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1159935735")) {
            return ((Integer) ipChange.ipc$dispatch("-1159935735", new Object[]{this})).intValue();
        }
        if (TextUtils.isEmpty(this.borderWidth) || "null".equals(this.borderWidth)) {
            return 0;
        }
        if ("1".equals(this.borderWidth)) {
            return 2;
        }
        return Integer.valueOf(this.borderWidth).intValue();
    }

    public int getCellType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-760135887") ? ((Integer) ipChange.ipc$dispatch("-760135887", new Object[]{this})).intValue() : (TextUtils.isEmpty(this.cellType) || "default".equals(this.cellType) || !"share".equals(this.cellType)) ? 1 : 2;
    }

    public int getColor(String str, String str2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-812244427")) {
            return ((Integer) ipChange.ipc$dispatch("-812244427", new Object[]{this, str, str2, Integer.valueOf(i)})).intValue();
        }
        int color = getColor(str, str2);
        return color == -1 ? i : color;
    }

    public int getConcatColor() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1839538484")) {
            return ((Integer) ipChange.ipc$dispatch("1839538484", new Object[]{this})).intValue();
        }
        if (this.concatColor == 0) {
            this.concatColor = getColor(this.concatUserAndAnchorAlpha, this.concatUserAndAnchorColor, -1);
        }
        return this.concatColor;
    }

    public String getConcatUserAndAnchor() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1956058621") ? (String) ipChange.ipc$dispatch("1956058621", new Object[]{this}) : this.concatUserAndAnchor;
    }

    public String getData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2130772080") ? (String) ipChange.ipc$dispatch("-2130772080", new Object[]{this}) : this.data;
    }

    public String getFace() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1132163389") ? (String) ipChange.ipc$dispatch("-1132163389", new Object[]{this}) : this.face;
    }

    public String getFaceIcon() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2040349476") ? (String) ipChange.ipc$dispatch("-2040349476", new Object[]{this}) : this.faceIcon;
    }

    public int getLineNum() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-287506031") ? ((Integer) ipChange.ipc$dispatch("-287506031", new Object[]{this})).intValue() : this.lineNum;
    }

    public String getName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-573943823") ? (String) ipChange.ipc$dispatch("-573943823", new Object[]{this}) : this.name;
    }

    public int getNameColor() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1842952299") ? ((Integer) ipChange.ipc$dispatch("1842952299", new Object[]{this})).intValue() : getColor(this.nameAlpha, this.nameColor, -1);
    }

    public String getSource() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "846691009") ? (String) ipChange.ipc$dispatch("846691009", new Object[]{this}) : this.source;
    }

    public int getTextColor() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "515916045") ? ((Integer) ipChange.ipc$dispatch("515916045", new Object[]{this})).intValue() : getColor(this.textAlpha, this.textColor, -1);
    }

    public String getType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1309357856") ? (String) ipChange.ipc$dispatch("1309357856", new Object[]{this}) : this.type;
    }

    public List<ImageBean> parseImages(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1981990086")) {
            return (List) ipChange.ipc$dispatch("1981990086", new Object[]{this, obj});
        }
        ArrayList arrayList = new ArrayList();
        if (obj != null && (obj instanceof List)) {
            for (Object obj2 : (List) obj) {
                if (obj2 != null && (obj2 instanceof Map)) {
                    Map map = (Map) obj2;
                    ImageBean imageBean = new ImageBean();
                    if (map.containsKey("src")) {
                        imageBean.setSrc(String.valueOf(map.get("src")));
                    }
                    if (map.containsKey(WXComponent.PROP_FS_WRAP_CONTENT)) {
                        imageBean.setWidth(Float.valueOf(String.valueOf(map.get(WXComponent.PROP_FS_WRAP_CONTENT))).floatValue());
                    }
                    if (map.containsKey("h")) {
                        imageBean.setHeight(Float.valueOf(String.valueOf(map.get("h"))).floatValue());
                    }
                    int i = 4;
                    if (map.containsKey("a")) {
                        String valueOf = String.valueOf(map.get("a"));
                        if (valueOf.equalsIgnoreCase("center")) {
                            i = 4;
                        } else if (valueOf.equalsIgnoreCase("baseline")) {
                            i = 1;
                        } else if (valueOf.equalsIgnoreCase("top")) {
                            i = 3;
                        } else if (valueOf.equalsIgnoreCase("bottom")) {
                            i = 0;
                        }
                    }
                    imageBean.setAlignment(i);
                    arrayList.add(imageBean);
                }
            }
            return arrayList;
        }
        return arrayList;
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2101492430")) {
            return (String) ipChange.ipc$dispatch("-2101492430", new Object[]{this});
        }
        StringBuilder sb = new StringBuilder();
        sb.append("type" + this.type + StringUtils.LF);
        sb.append("cellType" + this.cellType + StringUtils.LF);
        sb.append("data" + this.data + StringUtils.LF);
        sb.append(BaseCellItem.TYPE_FACE + this.face + StringUtils.LF);
        sb.append("name" + this.name + StringUtils.LF);
        sb.append("rgb" + this.textColor + StringUtils.LF);
        sb.append("alpha" + this.textAlpha + StringUtils.LF);
        sb.append("borderColor" + this.borderColor + StringUtils.LF);
        sb.append("borderColor" + this.borderColor + StringUtils.LF);
        return sb.toString();
    }

    private int getColor(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-580391724")) {
            return ((Integer) ipChange.ipc$dispatch("-580391724", new Object[]{this, str, str2})).intValue();
        }
        if (!TextUtils.isEmpty(str2) && !"null".equals(str2)) {
            try {
                if (!TextUtils.isEmpty(str) && !"null".equals(str2)) {
                    return Color.parseColor(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + str + str2);
                }
                return Color.parseColor(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + str2);
            } catch (Exception unused) {
            }
        }
        return -1;
    }

    public AILPChatBean(Map<String, Object> map) {
        this.anchorColor = 0;
        this.concatColor = 0;
        this.bgColorValue = -1;
        map = map == null ? new HashMap<>() : map;
        this.type = map.get("type") == null ? "" : String.valueOf(map.get("type"));
        this.data = map.get("data") == null ? "" : String.valueOf(map.get("data"));
        this.face = map.get(BaseCellItem.TYPE_FACE) == null ? "" : String.valueOf(map.get(BaseCellItem.TYPE_FACE));
        this.name = map.get("nickName") == null ? "" : String.valueOf(map.get("nickName"));
        this.cellType = ChatResourceManager.getInstance().isOrangeDowngradeGif() ? "default" : String.valueOf(map.get("cellType"));
        this.textColor = map.get("rgb") == null ? "" : String.valueOf(map.get("rgb"));
        this.textAlpha = map.get("alpha") == null ? "" : String.valueOf(map.get("alpha"));
        this.faceIcon = map.get("faceIcon") == null ? "" : String.valueOf(map.get("faceIcon"));
        this.nameColor = map.get("nickNameColor") == null ? "" : String.valueOf(map.get("nickNameColor"));
        this.nameAlpha = map.get("nickNameAlpha") == null ? "" : String.valueOf(map.get("nickNameAlpha"));
        this.bgColor = map.get("bgColor") == null ? "" : String.valueOf(map.get("bgColor"));
        this.bgAlpha = map.get("bgAlpha") == null ? "" : String.valueOf(map.get("bgAlpha"));
        this.borderWidth = map.get(Constants.Name.BORDER_WIDTH) == null ? "" : String.valueOf(map.get(Constants.Name.BORDER_WIDTH));
        this.borderColor = map.get("borderColor") == null ? "" : String.valueOf(map.get("borderColor"));
        this.anchorName = map.get("anchorName") == null ? "" : String.valueOf(map.get("anchorName"));
        this.anchorNameColor = map.get("anchorNameColor") == null ? "" : String.valueOf(map.get("anchorNameColor"));
        this.anchorNameAlpha = map.get("anchorNameAlpha") == null ? "" : String.valueOf(map.get("anchorNameAlpha"));
        this.concatUserAndAnchor = map.get("concatUserAndAnchor") == null ? "" : String.valueOf(map.get("concatUserAndAnchor"));
        this.concatUserAndAnchorColor = map.get("concatUserAndAnchorColor") == null ? "" : String.valueOf(map.get("concatUserAndAnchorColor"));
        this.concatUserAndAnchorAlpha = map.get("concatUserAndAnchorAlpha") == null ? "" : String.valueOf(map.get("concatUserAndAnchorAlpha"));
        this.source = map.get("source") != null ? String.valueOf(map.get("source")) : "";
        this.concatColor = getColor(this.concatUserAndAnchorAlpha, this.concatUserAndAnchorColor, -1);
        this.anchorColor = getColor(this.anchorNameAlpha, this.anchorNameColor, -1);
        if (map.get("ln") != null && !"null".equals(map.get("ln"))) {
            if (map.get("ln") instanceof String) {
                this.lineNum = Integer.parseInt((String) map.get("ln"));
            } else if (map.get("ln") instanceof Integer) {
                this.lineNum = ((Integer) map.get("ln")).intValue();
            }
        } else {
            this.lineNum = 0;
        }
        this.bn = new ArrayList();
        this.an = new ArrayList();
        try {
            this.bn = parseImages(map.get("bn"));
            this.an = parseImages(map.get(a.u));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
