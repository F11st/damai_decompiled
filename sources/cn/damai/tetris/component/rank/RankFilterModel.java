package cn.damai.tetris.component.rank;

import cn.damai.tetris.component.rank.RankFilterContract;
import cn.damai.tetris.component.rank.bean.RankFilterBean;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class RankFilterModel extends AbsModel implements RankFilterContract.Model {
    private static transient /* synthetic */ IpChange $ipChange;
    RankFilterBean temp;

    @Override // cn.damai.tetris.component.rank.RankFilterContract.Model
    public RankFilterBean getData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-931673854") ? (RankFilterBean) ipChange.ipc$dispatch("-931673854", new Object[]{this}) : this.temp;
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1012691435")) {
            ipChange.ipc$dispatch("1012691435", new Object[]{this, baseNode});
        }
    }
}
