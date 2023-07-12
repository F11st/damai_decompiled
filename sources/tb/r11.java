package tb;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionData;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionInfo;
import cn.damai.commonbusiness.seatbiz.seat.wolf.newtradeorder.model.region.image.RegionImageLoader;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.annotation.JSMethod;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class r11 extends kn1<l11> {
    private static transient /* synthetic */ IpChange $ipChange;
    private final boolean a;
    private final String b;
    private long c;
    private final boolean d;
    private final boolean e;
    private j52 f;

    public r11(boolean z, String str, long j, boolean z2, boolean z3, j52 j52Var) {
        this.a = z;
        this.b = str;
        this.c = j;
        this.d = z2;
        this.e = z3;
        this.f = j52Var;
    }

    @Nullable
    public static r11[] f(RegionData regionData, boolean z, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1692437124")) {
            return (r11[]) ipChange.ipc$dispatch("1692437124", new Object[]{regionData, Boolean.valueOf(z), Long.valueOf(j)});
        }
        if (regionData == null || regionData.ri == null) {
            return null;
        }
        j52 makeDegradeAssist = regionData.makeDegradeAssist();
        if (RegionImageLoader.getInstance().isSVGRegion(regionData)) {
            r11 r11Var = new r11(z, regionData.ri.seatSvgImg, j, true, false, makeDegradeAssist);
            RegionInfo regionInfo = regionData.ri;
            return regionInfo.rainbowSupportII ? new r11[]{r11Var, new r11(z, regionInfo.rainbowSvgImg, j, true, true, makeDegradeAssist)} : new r11[]{r11Var};
        }
        return new r11[]{h(z, regionData.ri.seatImg, j)};
    }

    public static r11 h(boolean z, String str, long j) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2030911968") ? (r11) ipChange.ipc$dispatch("2030911968", new Object[]{Boolean.valueOf(z), str, Long.valueOf(j)}) : new r11(z, str, j, false, false, null);
    }

    @Override // tb.kn1
    @NonNull
    public String b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1430614662")) {
            return (String) ipChange.ipc$dispatch("1430614662", new Object[]{this});
        }
        return this.b + JSMethod.NOT_SET + this.c;
    }

    @Override // tb.kn1
    public long c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-704801802") ? ((Long) ipChange.ipc$dispatch("-704801802", new Object[]{this})).longValue() : this.c;
    }

    @Override // tb.kn1
    @NonNull
    public String d() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1815835030") ? (String) ipChange.ipc$dispatch("1815835030", new Object[]{this}) : this.b;
    }

    @Override // tb.kn1
    public boolean e() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-322122981") ? ((Boolean) ipChange.ipc$dispatch("-322122981", new Object[]{this})).booleanValue() : this.a;
    }

    @Override // tb.kn1
    /* renamed from: g */
    public l11 a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "819370865") ? (l11) ipChange.ipc$dispatch("819370865", new Object[]{this}) : new l11(this.d, this.e, this.f);
    }
}
