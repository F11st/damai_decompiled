package cn.damai.performance.model;

import cn.damai.tetris.request.TetrisParams;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class OnlinePerformanceParams extends TetrisParams {
    private static transient /* synthetic */ IpChange $ipChange;
    public String pageNum;
    public String cityId = z20.c();
    public String comboDamaiCityId = z20.c();
    public String pageSize = "15";

    public OnlinePerformanceParams() {
    }

    @Override // cn.damai.tetris.request.TetrisParams
    public String getPatternName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "435831981") ? (String) ipChange.ipc$dispatch("435831981", new Object[]{this}) : "live_perform_page";
    }

    @Override // cn.damai.tetris.request.TetrisParams
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "81365578") ? (String) ipChange.ipc$dispatch("81365578", new Object[]{this}) : "1.0";
    }

    public OnlinePerformanceParams(int i) {
        this.pageNum = i + "";
    }
}
