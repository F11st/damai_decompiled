package cn.damai.seat.bean;

import android.text.TextUtils;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.seat.SeatNew;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.cb2;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class ItemSeatV2 {
    private static transient /* synthetic */ IpChange $ipChange;
    public String formatFloorName;
    public final boolean isPackageSeat;
    public final long priceId;
    public List<SeatNew> seatList;

    public ItemSeatV2(SeatNew seatNew, boolean z) {
        ArrayList arrayList = new ArrayList();
        this.seatList = arrayList;
        this.isPackageSeat = z;
        this.priceId = z ? seatNew.packagedPriceIndexId : seatNew.priceLevel;
        arrayList.add(seatNew);
        if (TextUtils.isEmpty(seatNew.kanTaiName)) {
            this.formatFloorName = null;
            return;
        }
        String str = seatNew.kanTaiName;
        if (str.length() > 12) {
            str = str.substring(0, 11) + "…";
        }
        this.formatFloorName = jn1.BRACKET_START_STR + str + jn1.BRACKET_END_STR;
    }

    public void addPackageSeat(SeatNew seatNew) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "983660414")) {
            ipChange.ipc$dispatch("983660414", new Object[]{this, seatNew});
        } else {
            this.seatList.add(seatNew);
        }
    }

    public SeatNew firstSeat() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2145307193")) {
            return (SeatNew) ipChange.ipc$dispatch("2145307193", new Object[]{this});
        }
        if (cb2.d(this.seatList)) {
            return null;
        }
        return this.seatList.get(0);
    }
}
