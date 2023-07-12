package cn.damai.category.ranking.ui;

import cn.damai.tetris.request.TetrisParams;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class RankListRequest extends TetrisParams {
    private static transient /* synthetic */ IpChange $ipChange;
    public String rankinglistId;

    public RankListRequest(String str) {
        this.rankinglistId = str;
    }

    @Override // cn.damai.tetris.request.TetrisParams
    public String getPatternName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "409783799") ? (String) ipChange.ipc$dispatch("409783799", new Object[]{this}) : "rankinglist";
    }
}
