package cn.damai.seat.bean.biz;

import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import cn.damai.seat.support.combine.SeatStateChild;
import cn.damai.seat.support.combine.SeatStateParent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.HashMap;
import tb.cb2;
import tb.jh1;
import tb.r92;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class CompressSeatStatus implements SeatStateParent, Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private ArrayMap<String, RegionCompressSeatState> regionId2SeatStateMap;
    public HashMap<String, String> seatStatus;

    public void decompress() {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "559029503")) {
            ipChange.ipc$dispatch("559029503", new Object[]{this});
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (!cb2.f(this.seatStatus)) {
            jh1 jh1Var = new jh1(true);
            this.regionId2SeatStateMap = new ArrayMap<>();
            for (String str : this.seatStatus.keySet()) {
                i++;
                this.regionId2SeatStateMap.put(str, new RegionCompressSeatState(str, this.seatStatus.get(str)));
            }
            jh1Var.c(jh1.TYPE_SEAT_STATE_DECOMPRESS, 0L);
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        r92.f("动态压缩还原" + i + "个区域座位状态耗时" + currentTimeMillis2 + "ms");
    }

    public RegionCompressSeatState get(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2052041345")) {
            return (RegionCompressSeatState) ipChange.ipc$dispatch("-2052041345", new Object[]{this, str});
        }
        ArrayMap<String, RegionCompressSeatState> arrayMap = this.regionId2SeatStateMap;
        if (arrayMap != null) {
            return arrayMap.get(str);
        }
        return null;
    }

    @Override // cn.damai.seat.support.combine.SeatStateParent
    @Nullable
    public SeatStateChild getChild(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "172381712") ? (SeatStateChild) ipChange.ipc$dispatch("172381712", new Object[]{this, str}) : get(str);
    }

    @Override // cn.damai.seat.support.combine.SeatStateParent
    public boolean isCompress() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1727926118")) {
            return ((Boolean) ipChange.ipc$dispatch("-1727926118", new Object[]{this})).booleanValue();
        }
        return true;
    }
}
