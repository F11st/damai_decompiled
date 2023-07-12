package tb;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionSeat3DVrInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.annotation.JSMethod;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class q82 extends kn1<i82> {
    private static transient /* synthetic */ IpChange $ipChange;
    private final String a;
    private final boolean b;
    private final long c;
    private final i82 d;

    private q82(boolean z, long j, RegionSeat3DVrInfo regionSeat3DVrInfo) {
        this.b = z;
        this.c = j;
        this.a = regionSeat3DVrInfo.seat3dvrEncodeUri;
        i82 i82Var = new i82();
        this.d = i82Var;
        i82Var.c(regionSeat3DVrInfo.seat3dvrEncodingType);
        i82Var.d(regionSeat3DVrInfo.seat3dvrStaticHash);
    }

    @Nullable
    public static q82 g(RegionSeat3DVrInfo regionSeat3DVrInfo, boolean z, long j) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-182909762") ? (q82) ipChange.ipc$dispatch("-182909762", new Object[]{regionSeat3DVrInfo, Boolean.valueOf(z), Long.valueOf(j)}) : new q82(z, j, regionSeat3DVrInfo);
    }

    @Override // tb.kn1
    @NonNull
    public String b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-934918899")) {
            return (String) ipChange.ipc$dispatch("-934918899", new Object[]{this});
        }
        return this.a + JSMethod.NOT_SET + this.c;
    }

    @Override // tb.kn1
    public long c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1023967857") ? ((Long) ipChange.ipc$dispatch("-1023967857", new Object[]{this})).longValue() : this.c;
    }

    @Override // tb.kn1
    @NonNull
    public String d() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-549698531") ? (String) ipChange.ipc$dispatch("-549698531", new Object[]{this}) : this.a;
    }

    @Override // tb.kn1
    public boolean e() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "459525858") ? ((Boolean) ipChange.ipc$dispatch("459525858", new Object[]{this})).booleanValue() : this.b;
    }

    @Override // tb.kn1
    /* renamed from: f */
    public i82 a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "872016633") ? (i82) ipChange.ipc$dispatch("872016633", new Object[]{this}) : this.d;
    }
}
