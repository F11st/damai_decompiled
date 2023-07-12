package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class ProjectDetailComponentResultBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = 3861725969356194416L;
    private ProjectDetailViewComponentMap detailViewComponentMap;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public static class ProjectDetailViewComponentMap implements Serializable {
        private static transient /* synthetic */ IpChange $ipChange = null;
        private static final long serialVersionUID = 6526084183062419198L;
        private ProjectDetailDataBean item;

        public ProjectDetailDataBean getItem() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-632771721") ? (ProjectDetailDataBean) ipChange.ipc$dispatch("-632771721", new Object[]{this}) : this.item;
        }

        public void setItem(ProjectDetailDataBean projectDetailDataBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2066316007")) {
                ipChange.ipc$dispatch("-2066316007", new Object[]{this, projectDetailDataBean});
            } else {
                this.item = projectDetailDataBean;
            }
        }
    }

    public ProjectDetailViewComponentMap getDetailViewComponentMap() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-338492551") ? (ProjectDetailViewComponentMap) ipChange.ipc$dispatch("-338492551", new Object[]{this}) : this.detailViewComponentMap;
    }

    public void setDetailViewComponentMap(ProjectDetailViewComponentMap projectDetailViewComponentMap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1441049217")) {
            ipChange.ipc$dispatch("1441049217", new Object[]{this, projectDetailViewComponentMap});
        } else {
            this.detailViewComponentMap = projectDetailViewComponentMap;
        }
    }
}
