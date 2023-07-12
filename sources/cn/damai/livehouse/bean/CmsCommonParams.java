package cn.damai.livehouse.bean;

import cn.damai.tetris.request.TetrisParams;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.xl2;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class CmsCommonParams extends TetrisParams {
    private static transient /* synthetic */ IpChange $ipChange;
    public String currentCityId = z20.c();
    public String cityId = z20.c();
    public String comboDamaiCityId = z20.c();

    @Override // cn.damai.tetris.request.TetrisParams
    public String getPatternName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-425081129") ? (String) ipChange.ipc$dispatch("-425081129", new Object[]{this}) : xl2.PROJECT_FILTER_OPTION_C_ID;
    }

    @Override // cn.damai.tetris.request.TetrisParams
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-953896588") ? (String) ipChange.ipc$dispatch("-953896588", new Object[]{this}) : "1.0";
    }
}
