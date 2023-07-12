package cn.damai.dramachannel.model;

import cn.damai.tetris.request.TetrisParams;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class DramaCommingParams extends TetrisParams {
    private static transient /* synthetic */ IpChange $ipChange;
    public String cityId = z20.c();
    public String comboDamaiCityId = z20.c();

    @Override // cn.damai.tetris.request.TetrisParams
    public String getPatternName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1290911427") ? (String) ipChange.ipc$dispatch("-1290911427", new Object[]{this}) : "category_drama_second";
    }
}
