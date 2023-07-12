package cn.damai.tetris.component.discover.mvp;

import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.tetris.component.discover.mvp.FeedProjectContract;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.m61;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class FeedProjectModel extends AbsModel implements FeedProjectContract.Model {
    private static transient /* synthetic */ IpChange $ipChange;
    ProjectItemBean mBean;

    @Override // cn.damai.tetris.component.discover.mvp.FeedProjectContract.Model
    public ProjectItemBean getBean() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1769511566") ? (ProjectItemBean) ipChange.ipc$dispatch("1769511566", new Object[]{this}) : this.mBean;
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1782812099")) {
            ipChange.ipc$dispatch("1782812099", new Object[]{this, baseNode});
            return;
        }
        ProjectItemBean projectItemBean = (ProjectItemBean) m61.d(baseNode.getItem(), ProjectItemBean.class);
        this.mBean = projectItemBean;
        projectItemBean.pos = baseNode.getOffset();
    }
}
