package tb;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionSeat3DVrInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.j82;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class n82 extends kn1<j82> {
    private static transient /* synthetic */ IpChange $ipChange;
    private final String a;
    private final long b;
    private final boolean c;
    private final j82 d;

    private n82(boolean z, long j, String str, long j2, String str2, String str3, String str4, RegionSeat3DVrInfo regionSeat3DVrInfo, boolean z2) {
        this.c = z;
        this.b = j;
        this.a = str3;
        j82 j82Var = new j82();
        this.d = j82Var;
        j82Var.i(z2);
        j82Var.j(regionSeat3DVrInfo);
        j82Var.k(j2);
        j82Var.h(str2);
        j82Var.l(str4);
        if (regionSeat3DVrInfo == null || regionSeat3DVrInfo.imgDecrypt == null) {
            return;
        }
        j82.C9302a c9302a = new j82.C9302a();
        c9302a.f(String.valueOf(regionSeat3DVrInfo.venueId));
        c9302a.d(str);
        c9302a.g(j);
        c9302a.e(regionSeat3DVrInfo.imgDecrypt.safeToken);
        j82Var.g(c9302a);
    }

    @Nullable
    public static n82 g(boolean z, long j, String str, long j2, String str2, String str3, String str4, RegionSeat3DVrInfo regionSeat3DVrInfo, boolean z2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "966250488") ? (n82) ipChange.ipc$dispatch("966250488", new Object[]{Boolean.valueOf(z), Long.valueOf(j), str, Long.valueOf(j2), str2, str3, str4, regionSeat3DVrInfo, Boolean.valueOf(z2)}) : new n82(z, j, str, j2, str2, str3, str4, regionSeat3DVrInfo, z2);
    }

    @Override // tb.kn1
    @NonNull
    public String b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-880364477") ? (String) ipChange.ipc$dispatch("-880364477", new Object[]{this}) : this.a;
    }

    @Override // tb.kn1
    public long c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-410977895") ? ((Long) ipChange.ipc$dispatch("-410977895", new Object[]{this})).longValue() : this.b;
    }

    @Override // tb.kn1
    @NonNull
    public String d() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-495144109") ? (String) ipChange.ipc$dispatch("-495144109", new Object[]{this}) : this.a;
    }

    @Override // tb.kn1
    public boolean e() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-157458792") ? ((Boolean) ipChange.ipc$dispatch("-157458792", new Object[]{this})).booleanValue() : this.c;
    }

    @Override // tb.kn1
    /* renamed from: f */
    public j82 a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1790454831") ? (j82) ipChange.ipc$dispatch("1790454831", new Object[]{this}) : this.d;
    }
}
