package com.youku.live.dago.widgetlib.interactive.gift.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class GiftInfoBean extends BaseInfoBean {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int ID_STAR = -9;
    public static final int TYPE_GIFT = 0;
    public static final int TYPE_RED_PACKET = 2;
    public static final int TYPE_STAR = 1;
    public String bIcon;
    public String coins;
    public int copies;
    public String desc;
    public boolean event;
    public String giftId;
    public boolean god;
    public String icon;
    public String id;
    public boolean isChecked;
    public String label;
    public boolean lucky;
    public String mIcon;
    public String name;
    public List<GiftNumBean> numList;
    public long price;
    public String sIcon;
    public String tagIcon;
    public boolean vip;
    public boolean weak;
    private int mGiftTags = 0;
    public int girdViewType = 0;
    public String btn = "赠送";
    public boolean multiSend = true;
    public boolean continuousSend = true;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public enum GiftTag {
        NONE("NULL"),
        WEEK_STAR("周星礼物"),
        LUCKY("幸运礼物"),
        EVENT("活动礼物"),
        JINKU("金库礼物"),
        TIME_LIMIT("限时"),
        DICE("骰子礼物"),
        ORDER_LUCKY("跑马灯幸运礼物"),
        VIP("VIP礼物"),
        NEW_USER("新手礼物"),
        GOD("天神礼物"),
        GRAFFITI("涂鸦礼物");
        
        String tagString;

        GiftTag(String str) {
            this.tagString = str;
        }

        public static GiftTag toGiftTag(String str) {
            GiftTag[] values;
            for (GiftTag giftTag : values()) {
                if (giftTag.tagString.equals(str)) {
                    return giftTag;
                }
            }
            return NONE;
        }

        public int getBit() {
            return 1 << ordinal();
        }
    }

    public void addGiftTag(GiftTag giftTag) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "593115445")) {
            ipChange.ipc$dispatch("593115445", new Object[]{this, giftTag});
        } else {
            this.mGiftTags = giftTag.getBit() | this.mGiftTags;
        }
    }

    public boolean checkGiftTag(GiftTag giftTag) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1146202912") ? ((Boolean) ipChange.ipc$dispatch("1146202912", new Object[]{this, giftTag})).booleanValue() : (giftTag.getBit() & this.mGiftTags) > 0;
    }

    public boolean hasMoreNum() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-234378362")) {
            return ((Boolean) ipChange.ipc$dispatch("-234378362", new Object[]{this})).booleanValue();
        }
        List<GiftNumBean> list = this.numList;
        return list != null && list.size() > 0;
    }

    public void removeGiftTag(GiftTag giftTag) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2030522960")) {
            ipChange.ipc$dispatch("2030522960", new Object[]{this, giftTag});
        } else {
            this.mGiftTags = (~giftTag.getBit()) & this.mGiftTags;
        }
    }
}
