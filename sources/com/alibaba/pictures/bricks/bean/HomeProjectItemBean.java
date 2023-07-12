package com.alibaba.pictures.bricks.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class HomeProjectItemBean extends HomepageMarketTabBase {
    private static transient /* synthetic */ IpChange $ipChange;
    public HomeProjectItemBottomLeft bottomLeft;
    public String bottomRight;
    public String id;
    public String interestInfo;
    public String isFollow;
    public String name;
    public String priceLow;
    public String schema;
    public String topLeft;
    public String topRight;
    public String verticalPic;

    public boolean followState() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-995694185") ? ((Boolean) ipChange.ipc$dispatch("-995694185", new Object[]{this})).booleanValue() : "true".equals(this.isFollow);
    }
}
