package cn.damai.commonbusiness.wannasee.bean;

import com.alibaba.pictures.bricks.component.project.bean.ProjectItemBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;
import tb.n91;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class RecommendProjects implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int TYPE_EMTYPE = 2;
    public static final int TYPE_SIMILAR = 1;
    public static final int TYPE_XIAJIA = 3;
    public List<ProjectItemBean> details;
    public boolean hasNext;
    public int index = 0;
    public int pageNo;
    public String recommendDesc;
    public String recommendTitle;
    public int recommendType;

    public ProjectItemBean getItem(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "862876284")) {
            return (ProjectItemBean) ipChange.ipc$dispatch("862876284", new Object[]{this, Integer.valueOf(i)});
        }
        try {
            return this.details.get(i);
        } catch (Exception unused) {
            return null;
        }
    }

    public String getSpmc() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1611352797")) {
            return (String) ipChange.ipc$dispatch("1611352797", new Object[]{this});
        }
        int i = this.recommendType;
        return i == 2 ? "recommendlist" : i == 1 ? "want_recommendlist" : i == 3 ? "oldproject_recommendlist" : "";
    }

    public boolean isValid() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "530888638") ? ((Boolean) ipChange.ipc$dispatch("530888638", new Object[]{this})).booleanValue() : !n91.b(this.details);
    }
}
