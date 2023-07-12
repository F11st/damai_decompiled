package cn.damai.seat.bean;

import cn.damai.commonbusiness.seatbiz.seat.common.bean.seat.SeatNew;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import tb.cb2;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class SeatProfile {
    private static transient /* synthetic */ IpChange $ipChange;
    public int maxX;
    public int maxY;
    public int minX;
    public int minY;
    public List<SeatNew> seatList;

    public SeatProfile(List<SeatNew> list) {
        sort(list);
        format();
    }

    private void format() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2087497138")) {
            ipChange.ipc$dispatch("2087497138", new Object[]{this});
        } else if (!cb2.d(this.seatList)) {
            this.minX = Integer.MAX_VALUE;
            this.minY = Integer.MAX_VALUE;
            this.maxX = Integer.MIN_VALUE;
            this.maxY = Integer.MIN_VALUE;
            for (int i = 0; i < this.seatList.size(); i++) {
                SeatNew seatNew = this.seatList.get(i);
                this.minX = Math.min(seatNew.x, this.minX);
                this.minY = Math.min(seatNew.y, this.minY);
                this.maxX = Math.max(seatNew.x, this.maxX);
                this.maxY = Math.max(seatNew.y, this.maxY);
            }
        }
    }

    private void sort(List<SeatNew> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1569675620")) {
            ipChange.ipc$dispatch("-1569675620", new Object[]{this, list});
        } else if (list == null || list.isEmpty()) {
        } else {
            ArrayList arrayList = new ArrayList(list);
            this.seatList = arrayList;
            Collections.sort(arrayList);
        }
    }
}
