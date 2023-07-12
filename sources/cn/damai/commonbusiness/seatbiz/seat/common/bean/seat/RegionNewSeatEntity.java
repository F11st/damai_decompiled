package cn.damai.commonbusiness.seatbiz.seat.common.bean.seat;

import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.cb2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class RegionNewSeatEntity {
    private static transient /* synthetic */ IpChange $ipChange;
    public List<String> floorNews;
    public List<SeatPrice> priceList;
    public RegionSeatNew regionSeatNew;
    public SeatState seatState;
    public ArrayList<SeatZh> seatZhs;

    @Deprecated
    public int getTotalSeatCount() {
        ArrayMap<String, List<SeatNew>> arrayMap;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "823877087")) {
            return ((Integer) ipChange.ipc$dispatch("823877087", new Object[]{this})).intValue();
        }
        RegionSeatNew regionSeatNew = this.regionSeatNew;
        if (regionSeatNew == null || (arrayMap = regionSeatNew.seatNewMap) == null || arrayMap.size() <= 0) {
            return 0;
        }
        ArrayMap<String, List<SeatNew>> arrayMap2 = this.regionSeatNew.seatNewMap;
        int i = 0;
        for (int i2 = 0; i2 < arrayMap2.size(); i2++) {
            List<SeatNew> valueAt = arrayMap2.valueAt(i2);
            i += valueAt == null ? 0 : valueAt.size();
        }
        return i;
    }

    @Deprecated
    public void resetSeat(List<SeatPrice> list) {
        ArrayMap<String, List<SeatNew>> arrayMap;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "661537541")) {
            ipChange.ipc$dispatch("661537541", new Object[]{this, list});
            return;
        }
        ArrayMap arrayMap2 = new ArrayMap();
        if (!cb2.d(list)) {
            for (SeatPrice seatPrice : list) {
                arrayMap2.put(Long.valueOf(seatPrice.priceLevelId), seatPrice);
            }
        }
        RegionSeatNew regionSeatNew = this.regionSeatNew;
        if (regionSeatNew == null || (arrayMap = regionSeatNew.seatNewMap) == null) {
            return;
        }
        int size = arrayMap.size();
        for (int i = 0; i < size; i++) {
            List<SeatNew> valueAt = arrayMap.valueAt(i);
            if (!cb2.d(valueAt)) {
                for (int i2 = 0; i2 < valueAt.size(); i2++) {
                    SeatNew seatNew = valueAt.get(i2);
                    seatNew.isSelected = false;
                    boolean z = seatNew.isPackaged;
                    SeatPrice seatPrice2 = (SeatPrice) arrayMap2.get(Long.valueOf(z ? seatNew.packagedPriceIndexId : seatNew.priceLevel));
                    if (seatPrice2 != null && seatPrice2.buyPermission && !TextUtils.isEmpty(seatPrice2.priceColor)) {
                        seatNew.seatValue = z ? seatPrice2.singlePriceValue : seatPrice2.priceValue;
                        seatNew.seatColor = seatPrice2.priceColorValue;
                        seatNew.valid4TaoPiao = z;
                        if (z) {
                            seatNew.seatTaoPiaoValue = seatPrice2.priceValue;
                        }
                    } else {
                        seatNew.seatValue = -1.0f;
                        seatNew.valid4TaoPiao = false;
                    }
                }
            }
        }
    }
}
