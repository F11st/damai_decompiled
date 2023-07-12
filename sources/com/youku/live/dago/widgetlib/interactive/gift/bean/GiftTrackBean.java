package com.youku.live.dago.widgetlib.interactive.gift.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class GiftTrackBean extends BaseInfoBean {
    private static transient /* synthetic */ IpChange $ipChange;
    public String anchorIcon;
    public String anchorId;
    public String anchorName;
    public int comboCount;
    public int comboLevel;
    public String giftIcon;
    public String giftId;
    public String giftName;
    public String giftNum;
    public int giftType;
    public boolean isComboGift;
    public boolean isMe;
    public String key;
    public int marginTop;
    public int pathIndex;
    public String roomAnchorId;
    public String userIcon;
    public String userId;
    public String userName;
    public int lotteryCount = 0;
    public int lotteryTimes = 0;
    public boolean isLottery = false;

    public boolean isMulti() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1934901613")) {
            return ((Boolean) ipChange.ipc$dispatch("1934901613", new Object[]{this})).booleanValue();
        }
        if (TextUtils.isEmpty(this.anchorId)) {
            return false;
        }
        return !this.anchorId.equals(this.roomAnchorId);
    }
}
