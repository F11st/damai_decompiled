package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class ProjectDetailDataBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = 2192310044093519974L;
    public ProjectDynamicExtDataBean dynamicExtData;
    public ProjectItemDataBean item;
    public ProjectStaticDataBean staticData;

    public ProjectDynamicExtDataBean getDynamicExtData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "932742337") ? (ProjectDynamicExtDataBean) ipChange.ipc$dispatch("932742337", new Object[]{this}) : this.dynamicExtData;
    }

    public ProjectItemDataBean getItem() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "587392151") ? (ProjectItemDataBean) ipChange.ipc$dispatch("587392151", new Object[]{this}) : this.item;
    }

    public ProjectStaticDataBean getStaticData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "486297921") ? (ProjectStaticDataBean) ipChange.ipc$dispatch("486297921", new Object[]{this}) : this.staticData;
    }

    public void setItem(ProjectItemDataBean projectItemDataBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-960517003")) {
            ipChange.ipc$dispatch("-960517003", new Object[]{this, projectItemDataBean});
        } else {
            this.item = projectItemDataBean;
        }
    }
}
