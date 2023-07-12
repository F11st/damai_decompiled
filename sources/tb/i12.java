package tb;

import android.text.TextUtils;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionData;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionDataNew;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class i12 {
    private static transient /* synthetic */ IpChange $ipChange;
    private long a;
    private j12 b = j12.b();

    public RegionData a(long j) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "422517340") ? (RegionData) ipChange.ipc$dispatch("422517340", new Object[]{this, Long.valueOf(j)}) : this.b.c(j);
    }

    public RegionData b(RegionDataNew regionDataNew, long j) {
        RegionInfo regionInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1240189812")) {
            return (RegionData) ipChange.ipc$dispatch("1240189812", new Object[]{this, regionDataNew, Long.valueOf(j)});
        }
        long j2 = this.a;
        if ((j2 != 0 && j2 != j) || regionDataNew == null || regionDataNew.seatQuYu == null) {
            return null;
        }
        RegionData e = new bb().e(regionDataNew, j);
        if (e != null && (regionInfo = e.ri) != null && regionInfo.seatStyle != 0) {
            h92.e().f(e.ri.seatStyle);
        }
        this.b.a(j, e);
        return e;
    }

    public bb c(RegionData regionData) {
        RegionInfo regionInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-147538221")) {
            return (bb) ipChange.ipc$dispatch("-147538221", new Object[]{this, regionData});
        }
        if (regionData != null && (regionInfo = regionData.ri) != null) {
            if (!regionInfo.rainbowSupport || TextUtils.isEmpty(regionInfo.seatSvgImg)) {
                RegionInfo regionInfo2 = regionData.ri;
                if (!regionInfo2.rainbowSupportII || TextUtils.isEmpty(regionInfo2.rainbowSvgImg)) {
                    if (!TextUtils.isEmpty(regionData.ri.seatSvgImg)) {
                        return new l52();
                    }
                    return new bb();
                }
            }
            return new k52();
        }
        return new bb();
    }

    public void d(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-580101274")) {
            ipChange.ipc$dispatch("-580101274", new Object[]{this, Long.valueOf(j)});
        } else {
            this.b.d(j);
        }
    }
}
