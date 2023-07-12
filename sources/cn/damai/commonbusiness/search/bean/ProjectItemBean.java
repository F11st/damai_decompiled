package cn.damai.commonbusiness.search.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.yh0;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class ProjectItemBean extends com.alibaba.pictures.bricks.component.project.bean.ProjectItemBean {
    private static transient /* synthetic */ IpChange $ipChange;

    public static ProjectItemBean toBricksBean(com.alibaba.pictures.bricks.component.project.bean.ProjectItemBean projectItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1925441975")) {
            return (ProjectItemBean) ipChange.ipc$dispatch("1925441975", new Object[]{projectItemBean});
        }
        try {
            yh0 yh0Var = yh0.INSTANCE;
            return (ProjectItemBean) yh0Var.c(yh0Var.d(projectItemBean), ProjectItemBean.class);
        } catch (Exception e) {
            e.printStackTrace();
            return new ProjectItemBean();
        }
    }
}
