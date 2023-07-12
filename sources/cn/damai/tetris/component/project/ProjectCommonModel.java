package cn.damai.tetris.component.project;

import cn.damai.commonbusiness.search.Daojishi;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.tetris.component.project.ProjectContract;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.m61;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ProjectCommonModel extends AbsModel implements ProjectContract.Model {
    private static transient /* synthetic */ IpChange $ipChange;
    private ProjectItemBean bean;
    private Daojishi daojishi;
    int index;
    private boolean showDis;

    @Override // cn.damai.tetris.component.project.ProjectContract.Model
    public boolean ShowDis() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1484893184") ? ((Boolean) ipChange.ipc$dispatch("1484893184", new Object[]{this})).booleanValue() : this.showDis;
    }

    @Override // cn.damai.tetris.component.project.ProjectContract.Model
    public ProjectItemBean getBean() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "879885149") ? (ProjectItemBean) ipChange.ipc$dispatch("879885149", new Object[]{this}) : this.bean;
    }

    @Override // cn.damai.tetris.component.project.ProjectContract.Model
    public Daojishi getDaojishi() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1610654948") ? (Daojishi) ipChange.ipc$dispatch("1610654948", new Object[]{this}) : this.daojishi;
    }

    @Override // cn.damai.tetris.component.project.ProjectContract.Model
    public int getIndex() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1546787700") ? ((Integer) ipChange.ipc$dispatch("1546787700", new Object[]{this})).intValue() : this.index;
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2094388306")) {
            ipChange.ipc$dispatch("2094388306", new Object[]{this, baseNode});
            return;
        }
        this.bean = (ProjectItemBean) m61.d(baseNode.getItem(), ProjectItemBean.class);
        this.index = baseNode.getOffset();
    }
}
