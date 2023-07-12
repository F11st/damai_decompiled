package tb;

import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.Region;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionData;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class bb {
    private static transient /* synthetic */ IpChange $ipChange;

    @Nullable
    public Region a(RegionData regionData, String str) {
        RegionInfo regionInfo;
        ArrayMap<String, Region> arrayMap;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1892430383")) {
            return (Region) ipChange.ipc$dispatch("-1892430383", new Object[]{this, regionData, str});
        }
        if (regionData == null || (regionInfo = regionData.ri) == null || (arrayMap = regionInfo.mRegionArrayMap) == null) {
            return null;
        }
        return arrayMap.get(b(regionData, str));
    }

    @Nullable
    public String b(RegionData regionData, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1877945925")) {
            return (String) ipChange.ipc$dispatch("1877945925", new Object[]{this, regionData, str});
        }
        if (c(regionData) == null) {
            return null;
        }
        return c(regionData).get(str);
    }

    public ArrayMap<String, String> c(RegionData regionData) {
        RegionInfo regionInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1624697711")) {
            return (ArrayMap) ipChange.ipc$dispatch("1624697711", new Object[]{this, regionData});
        }
        if (regionData == null || (regionInfo = regionData.ri) == null) {
            return null;
        }
        return regionInfo.mRegionIdMatchList;
    }

    public boolean d(RegionData regionData) {
        RegionInfo regionInfo;
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1609882883") ? ((Boolean) ipChange.ipc$dispatch("1609882883", new Object[]{this, regionData})).booleanValue() : (regionData == null || (regionInfo = regionData.ri) == null || !regionInfo.rainbowSupportII) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x024f A[Catch: Exception -> 0x038e, TryCatch #2 {Exception -> 0x038e, blocks: (B:7:0x002f, B:8:0x0050, B:11:0x005c, B:13:0x0071, B:15:0x007a, B:19:0x009f, B:20:0x00a7, B:16:0x0083, B:21:0x00f1, B:23:0x014e, B:25:0x0158, B:27:0x015d, B:30:0x0169, B:31:0x0178, B:33:0x017b, B:34:0x018d, B:36:0x0198, B:37:0x01ad, B:39:0x01b5, B:41:0x01c7, B:44:0x01d1, B:48:0x01f8, B:50:0x01fc, B:52:0x0203, B:54:0x020c, B:56:0x020f, B:58:0x0213, B:60:0x021b, B:81:0x0268, B:63:0x0228, B:74:0x0247, B:76:0x024f, B:78:0x025c, B:77:0x0258, B:73:0x0244, B:82:0x0271, B:84:0x027b, B:85:0x029e, B:87:0x02ad, B:89:0x02b5, B:91:0x02bf, B:92:0x02d1, B:93:0x02e0, B:95:0x02e8, B:96:0x02ef, B:98:0x02f2, B:100:0x02fe, B:102:0x0310, B:103:0x0313, B:105:0x031f, B:47:0x01f4, B:43:0x01cd, B:106:0x0356, B:107:0x035a, B:109:0x035e, B:117:0x0375, B:110:0x0363, B:112:0x0367, B:114:0x036e, B:116:0x0373, B:26:0x015b, B:17:0x0087, B:45:0x01f0), top: B:126:0x002f, inners: #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0258 A[Catch: Exception -> 0x038e, TryCatch #2 {Exception -> 0x038e, blocks: (B:7:0x002f, B:8:0x0050, B:11:0x005c, B:13:0x0071, B:15:0x007a, B:19:0x009f, B:20:0x00a7, B:16:0x0083, B:21:0x00f1, B:23:0x014e, B:25:0x0158, B:27:0x015d, B:30:0x0169, B:31:0x0178, B:33:0x017b, B:34:0x018d, B:36:0x0198, B:37:0x01ad, B:39:0x01b5, B:41:0x01c7, B:44:0x01d1, B:48:0x01f8, B:50:0x01fc, B:52:0x0203, B:54:0x020c, B:56:0x020f, B:58:0x0213, B:60:0x021b, B:81:0x0268, B:63:0x0228, B:74:0x0247, B:76:0x024f, B:78:0x025c, B:77:0x0258, B:73:0x0244, B:82:0x0271, B:84:0x027b, B:85:0x029e, B:87:0x02ad, B:89:0x02b5, B:91:0x02bf, B:92:0x02d1, B:93:0x02e0, B:95:0x02e8, B:96:0x02ef, B:98:0x02f2, B:100:0x02fe, B:102:0x0310, B:103:0x0313, B:105:0x031f, B:47:0x01f4, B:43:0x01cd, B:106:0x0356, B:107:0x035a, B:109:0x035e, B:117:0x0375, B:110:0x0363, B:112:0x0367, B:114:0x036e, B:116:0x0373, B:26:0x015b, B:17:0x0087, B:45:0x01f0), top: B:126:0x002f, inners: #1, #3 }] */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionData e(cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionDataNew r21, long r22) {
        /*
            Method dump skipped, instructions count: 916
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.bb.e(cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionDataNew, long):cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionData");
    }
}
