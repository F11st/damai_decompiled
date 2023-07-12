package com.alibaba.pictures.bricks.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class HomeGrabHotBean extends HomepageMarketTabBase {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String TYPE_VipPrePurchase = "VIP_PRIVILEGE_FIRST";
    public static final String TYPE_VipPrivilege = "VIP_PRIVILEGE_UNIQUE";
    private static final long serialVersionUID = -6005268060159456774L;
    public String artistName;
    public String broadcastProjectType;
    public String hotProjectSubTitle;
    public String ipvuv;
    public String itemId;
    public String name;
    public String priceLow;
    public String serverTime;
    public String snatchType;
    public String upTime;
    public String verticalPic;
    public String wantCountDesc;

    public boolean isArtist() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-650677665") ? ((Boolean) ipChange.ipc$dispatch("-650677665", new Object[]{this})).booleanValue() : "ARTIST".equals(this.broadcastProjectType);
    }

    public boolean isVipPrePurchase() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "242252863") ? ((Boolean) ipChange.ipc$dispatch("242252863", new Object[]{this})).booleanValue() : TYPE_VipPrePurchase.equalsIgnoreCase(this.snatchType);
    }

    public boolean isVipPrivilege() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1796498866") ? ((Boolean) ipChange.ipc$dispatch("1796498866", new Object[]{this})).booleanValue() : TYPE_VipPrivilege.equalsIgnoreCase(this.snatchType);
    }
}
