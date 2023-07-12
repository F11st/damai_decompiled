package tb;

import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionData;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class hs extends i12 {
    private static transient /* synthetic */ IpChange $ipChange;

    public boolean e(RegionData regionData) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-176779807") ? ((Boolean) ipChange.ipc$dispatch("-176779807", new Object[]{this, regionData})).booleanValue() : new bb().d(regionData);
    }

    public boolean f(RegionData regionData) {
        RegionInfo regionInfo;
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1339799144") ? ((Boolean) ipChange.ipc$dispatch("1339799144", new Object[]{this, regionData})).booleanValue() : (regionData == null || (regionInfo = regionData.ri) == null || regionInfo.venueScale != 1) ? false : true;
    }
}
