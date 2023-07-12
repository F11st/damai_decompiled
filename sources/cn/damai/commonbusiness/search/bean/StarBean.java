package cn.damai.commonbusiness.search.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class StarBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String archives;
    public String artFans;
    public String artId;
    public String artName;
    public String bgPic;
    public int followStatus;
    public String pic;

    public boolean isFollowState() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1345797728") ? ((Boolean) ipChange.ipc$dispatch("1345797728", new Object[]{this})).booleanValue() : this.followStatus != 0;
    }
}
