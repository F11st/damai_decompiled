package cn.damai.tetris.component.drama.mvp;

import cn.damai.tetris.component.drama.bean.DramaMonthBean;
import cn.damai.tetris.component.drama.mvp.VerticalDramaByMonthContract;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class VerticalDramaByMonthModel extends AbsModel implements VerticalDramaByMonthContract.Model {
    private static transient /* synthetic */ IpChange $ipChange;
    private DramaMonthBean mBean;

    @Override // cn.damai.tetris.component.drama.mvp.VerticalDramaByMonthContract.Model
    public DramaMonthBean getBean() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1307564241")) {
            return (DramaMonthBean) ipChange.ipc$dispatch("1307564241", new Object[]{this});
        }
        return null;
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-290668834")) {
            ipChange.ipc$dispatch("-290668834", new Object[]{this, baseNode});
        }
    }
}
