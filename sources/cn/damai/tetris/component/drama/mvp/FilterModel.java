package cn.damai.tetris.component.drama.mvp;

import cn.damai.tetris.component.drama.bean.FilterBean;
import cn.damai.tetris.component.drama.mvp.FilterContract;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class FilterModel extends AbsModel implements FilterContract.Model {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.tetris.component.drama.mvp.FilterContract.Model
    public FilterBean getBean() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "36359474")) {
            return (FilterBean) ipChange.ipc$dispatch("36359474", new Object[]{this});
        }
        return null;
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "881292158")) {
            ipChange.ipc$dispatch("881292158", new Object[]{this, baseNode});
        }
    }
}
