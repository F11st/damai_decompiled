package cn.damai.user.brand;

import cn.damai.tetris.request.TetrisParams;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class BrandRequest extends TetrisParams {
    private static transient /* synthetic */ IpChange $ipChange;
    public String brandId;
    public String comboDamaiCityId = z20.c();
    public String pageNum = "1";
    public int pageSize = 15;
    public boolean needCoupon = true;
    public String funcVersion = "2";

    @Override // cn.damai.tetris.request.TetrisParams
    public String getPatternName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1050736169") ? (String) ipChange.ipc$dispatch("-1050736169", new Object[]{this}) : "brandDetail";
    }
}
