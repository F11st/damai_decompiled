package tb;

import android.graphics.Picture;
import android.graphics.drawable.PictureDrawable;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.Region;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionData;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.SeatBox;
import cn.damai.commonbusiness.seatbiz.view.svgview.core.model.PointLocation;
import cn.damai.commonbusiness.seatbiz.view.svgview.core.model.RegionBound;
import cn.damai.seat.listener.RegionSeatRequestChecker;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class s92 {
    private static transient /* synthetic */ IpChange $ipChange;
    public RegionSeatRequestChecker a;
    public SeatBox b;
    public Picture c;
    public PictureDrawable d;
    public List<List<PointLocation>> e;
    public List<RegionBound> f;
    public float g = 1.0f;
    public g92 h;
    public RegionData i;
    public List<Region> j;

    public void a(RegionSeatRequestChecker regionSeatRequestChecker, SeatBox seatBox) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-419805875")) {
            ipChange.ipc$dispatch("-419805875", new Object[]{this, regionSeatRequestChecker, seatBox});
            return;
        }
        this.a = regionSeatRequestChecker;
        this.b = seatBox;
    }

    public void b(ms1 ms1Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-832470413")) {
            ipChange.ipc$dispatch("-832470413", new Object[]{this, ms1Var});
            return;
        }
        this.d = ms1Var.b;
        this.c = ms1Var.a;
        this.e = ms1Var.c;
        this.f = ms1Var.d;
        this.g = ms1Var.e;
    }

    public void c(g92 g92Var, RegionData regionData, List<Region> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2073685262")) {
            ipChange.ipc$dispatch("-2073685262", new Object[]{this, g92Var, regionData, list});
            return;
        }
        this.i = regionData;
        this.h = g92Var;
        this.j = list;
    }
}
