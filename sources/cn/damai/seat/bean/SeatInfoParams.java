package cn.damai.seat.bean;

import cn.damai.commonbusiness.seatbiz.seat.common.bean.seat.SeatNew;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class SeatInfoParams implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String seatId;
    public String standId;

    public SeatInfoParams() {
    }

    public static String toSeatInfoJson(List<SeatNew> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1274498911")) {
            return (String) ipChange.ipc$dispatch("1274498911", new Object[]{list});
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (SeatNew seatNew : list) {
            arrayList.add(new SeatInfoParams(seatNew));
        }
        return JSON.toJSONString(arrayList);
    }

    public SeatInfoParams(SeatNew seatNew) {
        this.seatId = seatNew.sid + "";
        this.standId = seatNew.kanTaiId;
    }
}
