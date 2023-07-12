package com.alibaba.pictures.bricks.component.project;

import cn.damai.tetris.component.drama.bean.ProjectShowBean;
import com.alibaba.pictures.bricks.component.project.ProjectContract;
import com.alibaba.pictures.bricks.component.project.bean.ProjectItemBean;
import com.alibaba.pictures.bricks.component.project.bean.SearchYouKuHelper;
import com.alibaba.pictures.bricks.component.project.bean.SearchYouKuProjectBean;
import com.alibaba.pictures.bricks.onearch.AbsModel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ProjectModel extends AbsModel<IItem<ItemValue>, Object> implements ProjectContract.Model<IItem<ItemValue>> {
    private static transient /* synthetic */ IpChange $ipChange;
    private ProjectItemBean projectItemBean;
    private long nativeDiffTime = 0;
    private long serverTime = 0;

    @Override // com.alibaba.pictures.bricks.component.project.ProjectContract.Model
    public long getNativeDiffTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1693403858") ? ((Long) ipChange.ipc$dispatch("-1693403858", new Object[]{this})).longValue() : this.nativeDiffTime;
    }

    @Override // com.alibaba.pictures.bricks.component.project.ProjectContract.Model
    public ProjectItemBean getProjectItemBean() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2113871823") ? (ProjectItemBean) ipChange.ipc$dispatch("-2113871823", new Object[]{this}) : this.projectItemBean;
    }

    @Override // com.alibaba.pictures.bricks.component.project.ProjectContract.Model
    public long getServerTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "171578311") ? ((Long) ipChange.ipc$dispatch("171578311", new Object[]{this})).longValue() : this.serverTime;
    }

    @Override // com.alient.onearch.adapter.view.AbsModel
    public void parseModelImpl(IItem<ItemValue> iItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-851844713")) {
            ipChange.ipc$dispatch("-851844713", new Object[]{this, iItem});
            return;
        }
        GenericItem genericItem = (GenericItem) iItem;
        if (genericItem.getRawNode().getParent() != null && genericItem.getRawNode().getParent().getData() != null) {
            if (genericItem.getRawNode().getParent().getData().containsKey("nativeDiffTime")) {
                this.nativeDiffTime = ((Long) genericItem.getRawNode().getParent().getData().get("nativeDiffTime")).longValue();
            }
            if (genericItem.getRawNode().getParent().getData().containsKey(ProjectShowBean.SERVER_TIME)) {
                this.serverTime = ((Long) genericItem.getRawNode().getParent().getData().get(ProjectShowBean.SERVER_TIME)).longValue();
            }
        }
        this.projectItemBean = SearchYouKuHelper.parseOneProductInner((SearchYouKuProjectBean) iItem.getProperty().getData().toJavaObject(SearchYouKuProjectBean.class));
    }
}
