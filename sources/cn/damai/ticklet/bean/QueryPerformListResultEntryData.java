package cn.damai.ticklet.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class QueryPerformListResultEntryData implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = 1;
    public String globalHeadTips;
    public String hasMore;
    public Boolean isLocationData = Boolean.FALSE;
    public long loadTime = 0;
    public int pageNo;
    public int pageSize;
    public Long serverTimestamp;
    private String transferRecvNum;
    public List<PerformTable> userPerformVOList;

    public String getHasMore() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2016896167") ? (String) ipChange.ipc$dispatch("2016896167", new Object[]{this}) : this.hasMore;
    }

    public long getLoadTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1212210429") ? ((Long) ipChange.ipc$dispatch("-1212210429", new Object[]{this})).longValue() : this.loadTime;
    }

    public Boolean getLocationData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "388758432") ? (Boolean) ipChange.ipc$dispatch("388758432", new Object[]{this}) : this.isLocationData;
    }

    public int getPageNo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1634185915") ? ((Integer) ipChange.ipc$dispatch("-1634185915", new Object[]{this})).intValue() : this.pageNo;
    }

    public Long getServerTimestamp() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1595828000") ? (Long) ipChange.ipc$dispatch("-1595828000", new Object[]{this}) : this.serverTimestamp;
    }

    public String getTransferRecvNum() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-688030483") ? (String) ipChange.ipc$dispatch("-688030483", new Object[]{this}) : this.transferRecvNum;
    }

    public List<PerformTable> getUserPerformVOList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-960295220") ? (List) ipChange.ipc$dispatch("-960295220", new Object[]{this}) : this.userPerformVOList;
    }

    public void setHasMore(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "777985455")) {
            ipChange.ipc$dispatch("777985455", new Object[]{this, str});
        } else {
            this.hasMore = str;
        }
    }

    public void setLoadTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1986965665")) {
            ipChange.ipc$dispatch("1986965665", new Object[]{this, Long.valueOf(j)});
        } else {
            this.loadTime = j;
        }
    }

    public void setLocationData(Boolean bool) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1623724950")) {
            ipChange.ipc$dispatch("1623724950", new Object[]{this, bool});
        } else {
            this.isLocationData = bool;
        }
    }

    public void setPageNo(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1654005245")) {
            ipChange.ipc$dispatch("1654005245", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.pageNo = i;
        }
    }

    public void setServerTimestamp(Long l) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1492548576")) {
            ipChange.ipc$dispatch("1492548576", new Object[]{this, l});
        } else {
            this.serverTimestamp = l;
        }
    }

    public void setTransferRecvNum(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "427704873")) {
            ipChange.ipc$dispatch("427704873", new Object[]{this, str});
        } else {
            this.transferRecvNum = str;
        }
    }

    public void setUserPerformVOList(List<PerformTable> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1482979352")) {
            ipChange.ipc$dispatch("1482979352", new Object[]{this, list});
        } else {
            this.userPerformVOList = list;
        }
    }
}
