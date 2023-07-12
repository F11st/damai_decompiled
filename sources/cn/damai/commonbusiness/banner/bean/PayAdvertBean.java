package cn.damai.commonbusiness.banner.bean;

import cn.damai.commonbusiness.search.bean.BaccountInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class PayAdvertBean {
    private static transient /* synthetic */ IpChange $ipChange;
    public PageBanner advertisement;
    public BaccountInfo baccount;
    public PageVipInfo vipActivityInfo;
    public PayVipScore vipScore;

    public boolean isVipMember() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1136611197")) {
            return ((Boolean) ipChange.ipc$dispatch("1136611197", new Object[]{this})).booleanValue();
        }
        PayVipScore payVipScore = this.vipScore;
        return (payVipScore == null || payVipScore.memberFlag == 0) ? false : true;
    }
}
