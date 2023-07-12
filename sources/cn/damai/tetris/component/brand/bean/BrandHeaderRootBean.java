package cn.damai.tetris.component.brand.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class BrandHeaderRootBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private BrandHeaderInfoBean accountPageResult;
    private ActivityInfo activityDO;
    private List<CommonCard> coupons;
    private List<ProjectVideoBean> projectVideoList;

    public BrandHeaderInfoBean getAccountPageResult() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-806654737") ? (BrandHeaderInfoBean) ipChange.ipc$dispatch("-806654737", new Object[]{this}) : this.accountPageResult;
    }

    public ActivityInfo getActivityDO() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2083721997") ? (ActivityInfo) ipChange.ipc$dispatch("-2083721997", new Object[]{this}) : this.activityDO;
    }

    public List<CommonCard> getCoupons() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-227508659") ? (List) ipChange.ipc$dispatch("-227508659", new Object[]{this}) : this.coupons;
    }

    public List<ProjectVideoBean> getProjectVideoList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2000177596") ? (List) ipChange.ipc$dispatch("-2000177596", new Object[]{this}) : this.projectVideoList;
    }

    public void setAccountPageResult(BrandHeaderInfoBean brandHeaderInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-782412543")) {
            ipChange.ipc$dispatch("-782412543", new Object[]{this, brandHeaderInfoBean});
        } else {
            this.accountPageResult = brandHeaderInfoBean;
        }
    }

    public void setActivityDO(ActivityInfo activityInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1190829277")) {
            ipChange.ipc$dispatch("1190829277", new Object[]{this, activityInfo});
        } else {
            this.activityDO = activityInfo;
        }
    }

    public void setCoupons(List<CommonCard> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "639113143")) {
            ipChange.ipc$dispatch("639113143", new Object[]{this, list});
        } else {
            this.coupons = list;
        }
    }

    public void setProjectVideoList(List<ProjectVideoBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-87523320")) {
            ipChange.ipc$dispatch("-87523320", new Object[]{this, list});
        } else {
            this.projectVideoList = list;
        }
    }
}
