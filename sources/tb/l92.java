package tb;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionData;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionSeatData;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.annotation.JSMethod;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class l92 extends kn1<e92> {
    private static transient /* synthetic */ IpChange $ipChange;
    private final boolean a;
    private final String b;
    private final String c;
    private final boolean d;
    private final long e;
    private final e92 f;

    private l92(long j, long j2, boolean z, long j3, int i, boolean z2, RegionData regionData) {
        this.d = z;
        this.e = j3;
        String str = regionData.regionSeatData.resourcesPath + "seatlist.zip";
        this.c = str;
        if (!TextUtils.isEmpty(regionData.regionSeatData.seatEncodingType) && !TextUtils.isEmpty(regionData.regionSeatData.seatEncodeUri) && c92.a()) {
            this.b = regionData.regionSeatData.seatEncodeUri;
            this.a = true;
        } else {
            r92.f("直接降级！Orange 配置是否使用压缩 ：" + c92.a() + " ，seatEncodingType = " + regionData.regionSeatData.seatEncodingType + " ，seatEncodeUri = " + regionData.regionSeatData.seatEncodeUri);
            this.b = str;
            this.a = false;
        }
        boolean z3 = this.a;
        RegionSeatData regionSeatData = regionData.regionSeatData;
        this.f = new e92(j, j2, z3, i, j3, z2, regionSeatData.seatEncodingType, regionSeatData.seatStaticHash);
    }

    @Nullable
    public static l92 g(long j, long j2, RegionData regionData, boolean z, long j3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1786090738")) {
            return (l92) ipChange.ipc$dispatch("-1786090738", new Object[]{Long.valueOf(j), Long.valueOf(j2), regionData, Boolean.valueOf(z), Long.valueOf(j3)});
        }
        if (regionData == null || regionData.regionSeatData == null) {
            return null;
        }
        return new l92(j, j2, z, j3, 1, r92.b(regionData), regionData);
    }

    @Override // tb.kn1
    @NonNull
    public String b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-57844096")) {
            return (String) ipChange.ipc$dispatch("-57844096", new Object[]{this});
        }
        return this.b + JSMethod.NOT_SET + this.e;
    }

    @Override // tb.kn1
    public long c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "762275516") ? ((Long) ipChange.ipc$dispatch("762275516", new Object[]{this})).longValue() : this.e;
    }

    @Override // tb.kn1
    @NonNull
    public String d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "327376272")) {
            return (String) ipChange.ipc$dispatch("327376272", new Object[]{this});
        }
        if (!this.f.b()) {
            return this.b;
        }
        return this.c;
    }

    @Override // tb.kn1
    public boolean e() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-208946539") ? ((Boolean) ipChange.ipc$dispatch("-208946539", new Object[]{this})).booleanValue() : this.d;
    }

    @Override // tb.kn1
    /* renamed from: f */
    public e92 a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-6971873") ? (e92) ipChange.ipc$dispatch("-6971873", new Object[]{this}) : this.f;
    }
}
