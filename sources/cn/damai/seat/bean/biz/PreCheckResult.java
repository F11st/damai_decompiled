package cn.damai.seat.bean.biz;

import androidx.annotation.Nullable;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.seat.SeatNew;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tb.cb2;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class PreCheckResult implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String STATUE_LOCK_SUCCESS = "1";
    public List<Long> greySeats;
    public String serialNumber;
    public String status;

    @Nullable
    public List<SeatNew> findGraySeatAfterNextRefresh(List<SeatNew> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1987853576")) {
            return (List) ipChange.ipc$dispatch("-1987853576", new Object[]{this, list});
        }
        if (cb2.d(this.greySeats) || cb2.d(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            SeatNew seatNew = list.get(i);
            if (this.greySeats.contains(Long.valueOf(seatNew.sid))) {
                arrayList.add(seatNew);
            }
        }
        return arrayList;
    }

    public boolean isCanOpenNextPage() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "54724849") ? ((Boolean) ipChange.ipc$dispatch("54724849", new Object[]{this})).booleanValue() : "1".equals(this.status);
    }
}
