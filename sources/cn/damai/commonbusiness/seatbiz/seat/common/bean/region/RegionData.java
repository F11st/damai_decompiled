package cn.damai.commonbusiness.seatbiz.seat.common.bean.region;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.seat.SeatPrice;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.cb2;
import tb.j52;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class RegionData {
    private static transient /* synthetic */ IpChange $ipChange;
    public String cityId;
    public List<String> floors;
    public int intervalTime;
    public boolean isNeedPreCheck;
    public int performanceMaxSum;
    @Deprecated
    public List<SeatPrice> regionPriceList;
    public ArrayMap<String, SeatPrice> regionPriceMap;
    public RegionSeatData regionSeatData;
    public List<RegionTopListModel> regionTopListModelList;
    public RegionInfo ri;
    public boolean sameRowNotify;
    public boolean seatStaticUseCompress;
    public boolean seatStatusUseCompress;
    public SvgDecryptBean svgDecrypt;
    public long xorPerformId;
    @Deprecated
    public final List<SeatPrice> immutableSeatPriceList = new ArrayList();
    @Deprecated
    private boolean isConcatTaoPiao = false;

    private List<SeatPrice> fixedTaoPiao2SeatPrices() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1909059164")) {
            return (List) ipChange.ipc$dispatch("1909059164", new Object[]{this});
        }
        ArrayList arrayList = new ArrayList();
        if (!cb2.d(this.regionTopListModelList)) {
            for (RegionTopListModel regionTopListModel : this.regionTopListModelList) {
                SeatPrice fixedTaoPiao2SeatPrice = regionTopListModel.fixedTaoPiao2SeatPrice(this.immutableSeatPriceList);
                if (fixedTaoPiao2SeatPrice != null) {
                    arrayList.add(fixedTaoPiao2SeatPrice);
                }
            }
        }
        return arrayList;
    }

    public boolean checkBaseValid() {
        ArrayList<Region> arrayList;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-875623052")) {
            return ((Boolean) ipChange.ipc$dispatch("-875623052", new Object[]{this})).booleanValue();
        }
        RegionInfo regionInfo = this.ri;
        return (regionInfo == null || this.regionSeatData == null || (arrayList = regionInfo.regionList) == null || arrayList.size() <= 0) ? false : true;
    }

    @Deprecated
    public void concatTaoPiao2SeatPriceList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "503968658")) {
            ipChange.ipc$dispatch("503968658", new Object[]{this});
        } else if (!this.isConcatTaoPiao) {
            List<SeatPrice> fixedTaoPiao2SeatPrices = fixedTaoPiao2SeatPrices();
            if (cb2.d(fixedTaoPiao2SeatPrices)) {
                return;
            }
            List<SeatPrice> list = this.regionPriceList;
            if (list != null) {
                list.addAll(fixedTaoPiao2SeatPrices);
                this.isConcatTaoPiao = true;
            }
            if (this.regionPriceMap != null) {
                for (SeatPrice seatPrice : fixedTaoPiao2SeatPrices) {
                    ArrayMap<String, SeatPrice> arrayMap = this.regionPriceMap;
                    arrayMap.put(seatPrice.maitixPriceId + "", seatPrice);
                    ArrayMap<String, SeatPrice> arrayMap2 = this.regionPriceMap;
                    arrayMap2.put(seatPrice.priceLevelId + "", seatPrice);
                }
            }
        }
    }

    public boolean isJPG() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2106327132")) {
            return ((Boolean) ipChange.ipc$dispatch("-2106327132", new Object[]{this})).booleanValue();
        }
        RegionInfo regionInfo = this.ri;
        return regionInfo != null && TextUtils.equals(regionInfo.compressMode, "binary");
    }

    public boolean isSmallVenue() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1378163621")) {
            return ((Boolean) ipChange.ipc$dispatch("1378163621", new Object[]{this})).booleanValue();
        }
        RegionInfo regionInfo = this.ri;
        return regionInfo != null && regionInfo.venueScale == 1;
    }

    @Nullable
    public j52 makeDegradeAssist() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1275906243")) {
            return (j52) ipChange.ipc$dispatch("-1275906243", new Object[]{this});
        }
        SvgDecryptBean svgDecryptBean = this.svgDecrypt;
        if (svgDecryptBean == null || !svgDecryptBean.isNeedDecrypt()) {
            return null;
        }
        return new j52(this.svgDecrypt, this.cityId, this.xorPerformId);
    }
}
