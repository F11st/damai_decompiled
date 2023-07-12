package tb;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionSeat3DVrInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.j82;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class m82 extends kn1<j82.a> {
    private static transient /* synthetic */ IpChange $ipChange;
    private final long a;
    private final boolean b;
    private final j82.a c;

    private m82(boolean z, long j, String str, RegionSeat3DVrInfo regionSeat3DVrInfo) {
        this.b = z;
        this.a = j;
        j82.a aVar = new j82.a();
        this.c = aVar;
        if (regionSeat3DVrInfo == null || regionSeat3DVrInfo.imgDecrypt == null) {
            return;
        }
        aVar.f(String.valueOf(regionSeat3DVrInfo.venueId));
        aVar.d(str);
        aVar.g(j);
        aVar.e(regionSeat3DVrInfo.imgDecrypt.safeToken);
    }

    @Nullable
    public static m82 g(boolean z, long j, String str, RegionSeat3DVrInfo regionSeat3DVrInfo) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-586130576") ? (m82) ipChange.ipc$dispatch("-586130576", new Object[]{Boolean.valueOf(z), Long.valueOf(j), str, regionSeat3DVrInfo}) : new m82(z, j, str, regionSeat3DVrInfo);
    }

    @Override // tb.kn1
    @NonNull
    public String b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "831179448") ? (String) ipChange.ipc$dispatch("831179448", new Object[]{this}) : String.valueOf(this.a);
    }

    @Override // tb.kn1
    public long c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1229661308")) {
            return ((Long) ipChange.ipc$dispatch("-1229661308", new Object[]{this})).longValue();
        }
        return 0L;
    }

    @Override // tb.kn1
    @NonNull
    public String d() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1216399816") ? (String) ipChange.ipc$dispatch("1216399816", new Object[]{this}) : "";
    }

    @Override // tb.kn1
    public boolean e() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1564258509") ? ((Boolean) ipChange.ipc$dispatch("1564258509", new Object[]{this})).booleanValue() : this.b;
    }

    @Override // tb.kn1
    /* renamed from: f */
    public j82.a a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1872333252") ? (j82.a) ipChange.ipc$dispatch("-1872333252", new Object[]{this}) : this.c;
    }
}
