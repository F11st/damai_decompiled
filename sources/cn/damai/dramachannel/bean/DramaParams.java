package cn.damai.dramachannel.bean;

import cn.damai.tetris.request.TetrisParams;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class DramaParams extends TetrisParams {
    private static transient /* synthetic */ IpChange $ipChange;
    public String cityId = z20.c();
    public String comboDamaiCityId = z20.c();
    public String currentCityId = z20.c();
    public String sortType = "10";

    @Override // cn.damai.tetris.request.TetrisParams
    public String getPatternName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1746091414") ? (String) ipChange.ipc$dispatch("-1746091414", new Object[]{this}) : "category_drama_new";
    }

    @Override // cn.damai.tetris.request.TetrisParams
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "109211271") ? (String) ipChange.ipc$dispatch("109211271", new Object[]{this}) : "1.0";
    }
}
