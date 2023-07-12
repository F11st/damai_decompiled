package cn.damai.user.star;

import cn.damai.tetris.request.TetrisParams;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class StarRequest extends TetrisParams {
    private static transient /* synthetic */ IpChange $ipChange;
    public String artistId;
    public String cityId = z20.c();
    public String pageNum = "1";
    public int pageSize = 15;

    @Override // cn.damai.tetris.request.TetrisParams
    public String getPatternName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "677512647") ? (String) ipChange.ipc$dispatch("677512647", new Object[]{this}) : "starHome";
    }
}
