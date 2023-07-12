package cn.damai.common.badge.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class BadgeMarkResponse implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<BadgeDTO> badgeDTOList;
    private List<String> failNodes;
    private boolean status;

    public List<BadgeDTO> getBadgeDTOList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1982022519") ? (List) ipChange.ipc$dispatch("-1982022519", new Object[]{this}) : this.badgeDTOList;
    }

    public List<String> getFailNodes() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1508638744") ? (List) ipChange.ipc$dispatch("-1508638744", new Object[]{this}) : this.failNodes;
    }

    public boolean isStatus() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "435974500") ? ((Boolean) ipChange.ipc$dispatch("435974500", new Object[]{this})).booleanValue() : this.status;
    }

    public void setBadgeDTOList(List<BadgeDTO> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1777474659")) {
            ipChange.ipc$dispatch("1777474659", new Object[]{this, list});
        } else {
            this.badgeDTOList = list;
        }
    }

    public void setFailNodes(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-233867652")) {
            ipChange.ipc$dispatch("-233867652", new Object[]{this, list});
        } else {
            this.failNodes = list;
        }
    }

    public void setStatus(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1142040154")) {
            ipChange.ipc$dispatch("1142040154", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.status = z;
        }
    }
}
