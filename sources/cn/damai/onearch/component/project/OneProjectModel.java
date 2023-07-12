package cn.damai.onearch.component.project;

import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.onearch.component.project.OneProject;
import com.alient.onearch.adapter.view.AbsModel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class OneProjectModel extends AbsModel<GenericItem<ItemValue>, ProjectItemBean> implements OneProject.Model {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.onearch.component.project.OneProject.Model
    @NotNull
    public ProjectItemBean getProject() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-385704600") ? (ProjectItemBean) ipChange.ipc$dispatch("-385704600", new Object[]{this}) : getValue();
    }
}
