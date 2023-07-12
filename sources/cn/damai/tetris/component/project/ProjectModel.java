package cn.damai.tetris.component.project;

import cn.damai.commonbusiness.search.Daojishi;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.tetris.component.project.ProjectContract;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.NodeData;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.db;
import tb.m61;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ProjectModel extends AbsModel implements ProjectContract.Model {
    private static transient /* synthetic */ IpChange $ipChange;
    private ProjectItemBean bean;
    private Daojishi daojishi;
    int index;
    private boolean showDis;

    @Override // cn.damai.tetris.component.project.ProjectContract.Model
    public boolean ShowDis() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-139648459") ? ((Boolean) ipChange.ipc$dispatch("-139648459", new Object[]{this})).booleanValue() : this.showDis;
    }

    @Override // cn.damai.tetris.component.project.ProjectContract.Model
    public ProjectItemBean getBean() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1863659794") ? (ProjectItemBean) ipChange.ipc$dispatch("1863659794", new Object[]{this}) : this.bean;
    }

    @Override // cn.damai.tetris.component.project.ProjectContract.Model
    public Daojishi getDaojishi() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1201364889") ? (Daojishi) ipChange.ipc$dispatch("1201364889", new Object[]{this}) : this.daojishi;
    }

    @Override // cn.damai.tetris.component.project.ProjectContract.Model
    public int getIndex() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1569362977") ? ((Integer) ipChange.ipc$dispatch("-1569362977", new Object[]{this})).intValue() : this.index;
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-998015673")) {
            ipChange.ipc$dispatch("-998015673", new Object[]{this, baseNode});
            return;
        }
        NodeData item = baseNode.getItem();
        this.bean = (ProjectItemBean) m61.d(item.getJSONObject(db.KEY_PROJECT), ProjectItemBean.class);
        if (item.getJSONObject(db.KEY_DAOJISHI) != null) {
            this.daojishi = (Daojishi) m61.d(item.getJSONObject(db.KEY_DAOJISHI), Daojishi.class);
        }
        if (item.getBoolean(db.KEY_SHOW_DIS) != null) {
            this.showDis = item.getBoolean(db.KEY_SHOW_DIS).booleanValue();
        }
        this.index = baseNode.getOffset();
    }
}
