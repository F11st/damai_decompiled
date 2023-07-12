package tb;

import androidx.collection.LongSparseArray;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionData;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class j12 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static volatile j12 b;
    private LongSparseArray<RegionData> a = new LongSparseArray<>();

    private j12() {
    }

    public static j12 b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "132134101")) {
            return (j12) ipChange.ipc$dispatch("132134101", new Object[0]);
        }
        if (b == null) {
            synchronized (j12.class) {
                if (b == null) {
                    b = new j12();
                }
            }
        }
        return b;
    }

    public void a(long j, RegionData regionData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1789109802")) {
            ipChange.ipc$dispatch("-1789109802", new Object[]{this, Long.valueOf(j), regionData});
            return;
        }
        LongSparseArray<RegionData> longSparseArray = this.a;
        if (longSparseArray == null) {
            return;
        }
        longSparseArray.put(j, regionData);
    }

    public RegionData c(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1873788578")) {
            return (RegionData) ipChange.ipc$dispatch("-1873788578", new Object[]{this, Long.valueOf(j)});
        }
        LongSparseArray<RegionData> longSparseArray = this.a;
        if (longSparseArray == null) {
            return null;
        }
        return longSparseArray.get(j);
    }

    public void d(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1374692102")) {
            ipChange.ipc$dispatch("-1374692102", new Object[]{this, Long.valueOf(j)});
            return;
        }
        LongSparseArray<RegionData> longSparseArray = this.a;
        if (longSparseArray != null) {
            longSparseArray.remove(j);
        }
    }
}
