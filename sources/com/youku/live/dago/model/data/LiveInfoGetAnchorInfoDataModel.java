package com.youku.live.dago.model.data;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class LiveInfoGetAnchorInfoDataModel implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String avatarUrl;
    public long fansCount;
    public boolean followed;
    public long income;
    public String liveId;
    public String nickName;
    public String title;

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1941276373")) {
            return (String) ipChange.ipc$dispatch("-1941276373", new Object[]{this});
        }
        return "LiveInfoGetAnchorInfoDataModel{avatarUrl='" + this.avatarUrl + "', fansCount=" + this.fansCount + ", followed=" + this.followed + ", income=" + this.income + ", liveId='" + this.liveId + "', nickName='" + this.nickName + "', title='" + this.title + "'}";
    }
}
