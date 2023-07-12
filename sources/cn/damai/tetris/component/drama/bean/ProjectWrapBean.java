package cn.damai.tetris.component.drama.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class ProjectWrapBean {
    private static transient /* synthetic */ IpChange $ipChange;
    public ProjectShowBean mBean;
    public CardTitleBean mTitleBean;
    public int pos;

    public ProjectWrapBean(ProjectShowBean projectShowBean, CardTitleBean cardTitleBean, int i) {
        this.mBean = projectShowBean;
        this.mTitleBean = cardTitleBean;
        this.pos = i;
    }

    public String getUrl() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1530570235")) {
            return (String) ipChange.ipc$dispatch("1530570235", new Object[]{this});
        }
        CardTitleBean cardTitleBean = this.mTitleBean;
        if (cardTitleBean != null) {
            return cardTitleBean.url;
        }
        return null;
    }

    public ProjectWrapBean() {
    }
}
