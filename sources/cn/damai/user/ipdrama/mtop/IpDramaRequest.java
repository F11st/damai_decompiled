package cn.damai.user.ipdrama.mtop;

import cn.damai.tetris.request.TetrisParams;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class IpDramaRequest extends TetrisParams {
    private static transient /* synthetic */ IpChange $ipChange;
    @Deprecated
    public String comboDamaiCity;
    public String comboDamaiCityId;
    public String funcVersion;
    public String ipId;
    public String cityId = z20.c();
    public String pageNo = "1";
    public int pageSize = 15;
    public boolean hasContent = true;

    @Override // cn.damai.tetris.request.TetrisParams
    public String getPatternName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-115758614") ? (String) ipChange.ipc$dispatch("-115758614", new Object[]{this}) : "baseIp";
    }
}
