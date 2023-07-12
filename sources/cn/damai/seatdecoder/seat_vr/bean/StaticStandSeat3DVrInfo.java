package cn.damai.seatdecoder.seat_vr.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class StaticStandSeat3DVrInfo {
    private static transient /* synthetic */ IpChange $ipChange;
    private Long floorId;
    private List<StaticSeat3DVrInfo> seats;

    public Long getFloorId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1372833372") ? (Long) ipChange.ipc$dispatch("1372833372", new Object[]{this}) : this.floorId;
    }

    public List<StaticSeat3DVrInfo> getSeats() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2018698709") ? (List) ipChange.ipc$dispatch("2018698709", new Object[]{this}) : this.seats;
    }

    public void setFloorId(Long l) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-903165468")) {
            ipChange.ipc$dispatch("-903165468", new Object[]{this, l});
        } else {
            this.floorId = l;
        }
    }

    public void setSeats(List<StaticSeat3DVrInfo> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "479245359")) {
            ipChange.ipc$dispatch("479245359", new Object[]{this, list});
        } else {
            this.seats = list;
        }
    }
}
