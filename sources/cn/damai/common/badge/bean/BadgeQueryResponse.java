package cn.damai.common.badge.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class BadgeQueryResponse implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<BadgeDTO> badgeDTOList;

    public List<BadgeDTO> getBadgeDTOList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-854522406") ? (List) ipChange.ipc$dispatch("-854522406", new Object[]{this}) : this.badgeDTOList;
    }

    public void setBadgeDTOList(List<BadgeDTO> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1924727502")) {
            ipChange.ipc$dispatch("-1924727502", new Object[]{this, list});
        } else {
            this.badgeDTOList = list;
        }
    }
}
