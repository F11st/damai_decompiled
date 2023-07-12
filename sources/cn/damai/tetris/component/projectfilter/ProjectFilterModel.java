package cn.damai.tetris.component.projectfilter;

import cn.damai.tetris.component.projectfilter.ProjectFilterContract;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ProjectFilterModel extends AbsModel implements ProjectFilterContract.Model {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.tetris.component.projectfilter.ProjectFilterContract.Model
    public Object getBean() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "103419142")) {
            return ipChange.ipc$dispatch("103419142", new Object[]{this});
        }
        return null;
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1322598697")) {
            ipChange.ipc$dispatch("-1322598697", new Object[]{this, baseNode});
        }
    }
}
