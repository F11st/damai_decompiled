package cn.damai.homepage.request;

import cn.damai.tetris.request.TetrisParams;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.wy0;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class HomeParams extends TetrisParams {
    private static transient /* synthetic */ IpChange $ipChange;
    public String comboDamaiCityId;

    @Override // cn.damai.tetris.request.TetrisParams
    public String getPatternName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1368786331") ? (String) ipChange.ipc$dispatch("-1368786331", new Object[]{this}) : wy0.patternName;
    }

    @Override // cn.damai.tetris.request.TetrisParams
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1631116290") ? (String) ipChange.ipc$dispatch("1631116290", new Object[]{this}) : "2.4";
    }
}
