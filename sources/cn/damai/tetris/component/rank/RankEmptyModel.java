package cn.damai.tetris.component.rank;

import cn.damai.tetris.component.rank.RankEmptyContract;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class RankEmptyModel extends AbsModel implements RankEmptyContract.Model {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-718338668")) {
            ipChange.ipc$dispatch("-718338668", new Object[]{this, baseNode});
        }
    }
}
