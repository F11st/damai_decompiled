package cn.damai.tetris.component.drama.mvp;

import cn.damai.tetris.component.drama.bean.AnchorList;
import cn.damai.tetris.component.drama.mvp.AnchorFloatingContract;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class AnchorFloatingModel extends AbsModel implements AnchorFloatingContract.Model {
    private static transient /* synthetic */ IpChange $ipChange;
    private AnchorList mBean;

    @Override // cn.damai.tetris.component.drama.mvp.AnchorFloatingContract.Model
    public AnchorList getBean() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1523534454")) {
            return (AnchorList) ipChange.ipc$dispatch("-1523534454", new Object[]{this});
        }
        return null;
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-820322975")) {
            ipChange.ipc$dispatch("-820322975", new Object[]{this, baseNode});
        }
    }
}
