package cn.damai.seatdecoder.common.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class StaticStandSeat {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<StaticSeat> seats;
    private Long stand;

    public List<StaticSeat> getSeats() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2064448099") ? (List) ipChange.ipc$dispatch("2064448099", new Object[]{this}) : this.seats;
    }

    public Long getStand() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1230786553") ? (Long) ipChange.ipc$dispatch("1230786553", new Object[]{this}) : this.stand;
    }

    public void setSeats(List<StaticSeat> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1897476449")) {
            ipChange.ipc$dispatch("1897476449", new Object[]{this, list});
        } else {
            this.seats = list;
        }
    }

    public void setStand(Long l) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2084469017")) {
            ipChange.ipc$dispatch("-2084469017", new Object[]{this, l});
        } else {
            this.stand = l;
        }
    }
}
