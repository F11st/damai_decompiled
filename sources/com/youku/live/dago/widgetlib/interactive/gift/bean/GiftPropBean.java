package com.youku.live.dago.widgetlib.interactive.gift.bean;

import android.graphics.Color;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import com.youku.live.livesdk.wkit.component.Constants;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class GiftPropBean extends BaseInfoBean {
    private static transient /* synthetic */ IpChange $ipChange;
    public String alpha;
    public String btn;
    public String desc;
    public String expire;
    public String icon;
    public String id;
    public String name;
    public int num;
    public String rgb;
    public String tips;
    public String typeId;
    private final String PROP_TYPE_GIFT = "gift";
    public int propType = -1;
    public int taskMarkBg = -1;
    public long time = -1;
    public boolean isChecked = false;
    public boolean isMoreBtn = false;
    private final String NULL = "null";

    public int getColor(String str, String str2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "19740289")) {
            return ((Integer) ipChange.ipc$dispatch("19740289", new Object[]{this, str, str2, Integer.valueOf(i)})).intValue();
        }
        int color = getColor(str, str2);
        return color == -1 ? i : color;
    }

    public boolean isGift() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1572657624") ? ((Boolean) ipChange.ipc$dispatch("1572657624", new Object[]{this})).booleanValue() : "gift".equals(this.typeId);
    }

    public void replace(GiftPropBean giftPropBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1478197918")) {
            ipChange.ipc$dispatch("1478197918", new Object[]{this, giftPropBean});
        } else if (giftPropBean != null) {
            this.id = giftPropBean.id;
            if (!TextUtils.isEmpty(giftPropBean.name) && !"null".equals(giftPropBean.name)) {
                this.name = giftPropBean.name;
            }
            if (!TextUtils.isEmpty(giftPropBean.icon) && !"null".equals(giftPropBean.icon)) {
                this.icon = giftPropBean.icon;
            }
            if (!TextUtils.isEmpty(giftPropBean.desc) && !"null".equals(giftPropBean.desc)) {
                this.desc = giftPropBean.desc;
            }
            ((ILog) Dsl.getService(ILog.class)).i("liule-prop", "update type = " + giftPropBean.typeId);
            if (!TextUtils.isEmpty(giftPropBean.typeId) && !"null".equals(giftPropBean.typeId)) {
                ((ILog) Dsl.getService(ILog.class)).i("liule-prop", "update typeID ");
                this.typeId = giftPropBean.typeId;
            }
            int i = giftPropBean.num;
            if (i != -1) {
                this.num = i;
            }
            if (!TextUtils.isEmpty(giftPropBean.tips) && !"null".equals(giftPropBean.tips)) {
                this.tips = giftPropBean.tips;
            }
            long j = giftPropBean.time;
            if (j != -1) {
                this.time = j;
            }
            this.isChecked = giftPropBean.isChecked;
            if (!TextUtils.isEmpty(giftPropBean.rgb) && !"null".equals(giftPropBean.rgb)) {
                this.rgb = giftPropBean.rgb;
            }
            if (!TextUtils.isEmpty(giftPropBean.alpha) && !"null".equals(giftPropBean.alpha)) {
                this.alpha = giftPropBean.alpha;
            }
            int i2 = giftPropBean.propType;
            if (i2 != -1) {
                this.propType = i2;
            }
            int i3 = giftPropBean.taskMarkBg;
            if (i3 != -1) {
                this.taskMarkBg = i3;
            }
        }
    }

    private int getColor(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1246290168")) {
            return ((Integer) ipChange.ipc$dispatch("-1246290168", new Object[]{this, str, str2})).intValue();
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
}
