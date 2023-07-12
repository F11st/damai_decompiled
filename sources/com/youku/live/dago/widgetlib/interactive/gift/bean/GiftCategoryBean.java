package com.youku.live.dago.widgetlib.interactive.gift.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class GiftCategoryBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public ArrayList<GiftInfoBean> giftInfos = new ArrayList<>();
    public String groupId;
    public String name;

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-680290045")) {
            return (String) ipChange.ipc$dispatch("-680290045", new Object[]{this});
        }
        return "CategoryGiftBean{gid=" + this.groupId + ", name='" + this.name + "', infos=" + this.giftInfos + '}';
    }
}
