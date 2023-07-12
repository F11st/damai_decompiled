package cn.damai.tetris.request;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class DiscoverRecParams extends TetrisParams {
    private static transient /* synthetic */ IpChange $ipChange;
    public String latitude;
    public String longitude;
    public String pageNo;
    public String topId;
    public String topType;
    public String currentCityId = z20.c();
    public String targetTypeList = "1,2,5";

    public DiscoverRecParams(String str) {
        this.pageNo = str;
    }

    @Override // cn.damai.tetris.request.TetrisParams
    public String getPatternName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1163192522") ? (String) ipChange.ipc$dispatch("-1163192522", new Object[]{this}) : "live";
    }

    @Override // cn.damai.tetris.request.TetrisParams
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1407387987") ? (String) ipChange.ipc$dispatch("1407387987", new Object[]{this}) : "2.0";
    }

    public DiscoverRecParams(String str, String str2, String str3) {
        this.pageNo = str;
        this.topType = str2;
        this.topId = str3;
    }
}
