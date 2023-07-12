package cn.damai.commonbusiness.seatbiz.seat.qilin.listener.net;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.common.net.mtop.netfit.DMMtopResultRequestListener;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionData;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionDataNew;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.e11;
import tb.i12;
import tb.jh1;
import tb.w92;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public abstract class MtopRegionDataListener extends DMMtopResultRequestListener<RegionDataNew> {
    private static transient /* synthetic */ IpChange $ipChange;
    private final String cityId;
    private boolean isRequest4Preload;
    private final long itemId;
    private i12 mManager;
    private jh1 mMonitor;
    private final long performId;
    private final long xorPerformId;

    public MtopRegionDataListener(long j, String str, long j2, long j3) {
        super(RegionDataNew.class);
        this.mMonitor = new jh1(true);
        this.isRequest4Preload = false;
        this.itemId = j;
        this.cityId = str;
        this.performId = j2;
        this.xorPerformId = j3;
    }

    public abstract void onBizFail(String str, String str2);

    @Override // cn.damai.common.net.mtop.netfit.DMMtopResultRequestListener
    public void onFail(String str, String str2) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "509346621")) {
            ipChange.ipc$dispatch("509346621", new Object[]{this, str, str2});
            return;
        }
        jh1.e("mtop.damai.wireless.project.getB2B2CAreaInfo", str, str2);
        if (!e11.b().c(str)) {
            if (!((this.isRequest4Preload && TextUtils.equals("result为空", str2)) ? false : false)) {
                if (TextUtils.equals("数据异常，请退出重试!", str2)) {
                    w92.b("mtop.damai.wireless.project.getB2B2CAreaInfo", this.performId + "", this.itemId + "");
                } else {
                    w92.c("mtop.damai.wireless.project.getB2B2CAreaInfo", TextUtils.isEmpty(str) ? "unknown" : str, TextUtils.isEmpty(str2) ? "unknown" : str2, this.performId + "", this.itemId + "");
                }
            }
        }
        onBizFail(str, (TextUtils.equals("1000", str) || TextUtils.equals(str2, "数据异常，请退出重试!") || TextUtils.equals(str2, "区域异常，请退出重试!")) ? "麦麦开小差了，请稍后重试哦" : "麦麦开小差了，请稍后重试哦");
    }

    public abstract void onRegionData(@NonNull RegionData regionData);

    public void setRequest4Preload(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1391132848")) {
            ipChange.ipc$dispatch("1391132848", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.isRequest4Preload = z;
        }
    }

    @Override // cn.damai.common.net.mtop.netfit.DMMtopResultRequestListener
    public void onSuccess(RegionDataNew regionDataNew) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "611373695")) {
            ipChange.ipc$dispatch("611373695", new Object[]{this, regionDataNew});
            return;
        }
        this.mMonitor.a("mtop.damai.wireless.project.getB2B2CAreaInfo");
        if (regionDataNew == null) {
            onFail("", "区域异常，请退出重试!");
            return;
        }
        if (this.mManager == null) {
            this.mManager = new i12();
        }
        regionDataNew.cityId = this.cityId;
        long j = this.xorPerformId;
        regionDataNew.xorPerfromId = j;
        RegionData b = this.mManager.b(regionDataNew, j);
        if (b != null && b.checkBaseValid()) {
            jh1.f("mtop.damai.wireless.project.getB2B2CAreaInfo");
            onRegionData(b);
            return;
        }
        onFail("", "数据异常，请退出重试!");
    }

    public MtopRegionDataListener(long j, String str, long j2, long j3, @Nullable i12 i12Var) {
        super(RegionDataNew.class);
        this.mMonitor = new jh1(true);
        this.isRequest4Preload = false;
        this.itemId = j;
        this.cityId = str;
        this.performId = j2;
        this.xorPerformId = j3;
        this.mManager = i12Var;
    }
}
