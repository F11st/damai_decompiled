package cn.damai.discover.main.param;

import cn.damai.tetris.request.TetrisParams;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class LiveHeaderParam extends TetrisParams {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = 4691762288987561894L;
    public String currentCityId = z20.c();
    public String funcVersion = "1.0";

    @Override // cn.damai.tetris.request.TetrisParams
    public String getPatternName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2010487383") ? (String) ipChange.ipc$dispatch("-2010487383", new Object[]{this}) : "live";
    }
}
