package cn.damai.livehouse.model;

import android.text.TextUtils;
import cn.damai.tetris.request.TetrisParams;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class LiveHouseParams extends TetrisParams {
    private static transient /* synthetic */ IpChange $ipChange;
    public String outPatternName;
    public String outPatternVersion;
    public String pageNum;
    public String cityId = z20.c();
    public String comboDamaiCityId = z20.c();
    public String pageSize = "15";

    public LiveHouseParams() {
    }

    @Override // cn.damai.tetris.request.TetrisParams
    public String getPatternName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1153929646") ? (String) ipChange.ipc$dispatch("-1153929646", new Object[]{this}) : !TextUtils.isEmpty(this.outPatternName) ? this.outPatternName : "dm_livehouse_perform_page";
    }

    @Override // cn.damai.tetris.request.TetrisParams
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-451916177") ? (String) ipChange.ipc$dispatch("-451916177", new Object[]{this}) : !TextUtils.isEmpty(this.outPatternVersion) ? this.outPatternVersion : "1.0";
    }

    public LiveHouseParams(int i) {
        this.pageNum = i + "";
    }
}
