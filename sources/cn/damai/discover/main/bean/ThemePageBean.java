package cn.damai.discover.main.bean;

import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.discover.main.ui.bean.ThemeRankBean;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class ThemePageBean {
    private static transient /* synthetic */ IpChange $ipChange;
    public String bannerUrl;
    public List<JSONObject> cards;
    public boolean hasNext;
    public ThemeRankBean rankInfo;
    public ThemeInfo themeInfo;

    public List<ProjectItemBean> getProjectList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "330026487")) {
            return (List) ipChange.ipc$dispatch("330026487", new Object[]{this});
        }
        ThemeInfo themeInfo = this.themeInfo;
        if (themeInfo != null) {
            return themeInfo.projectInfo;
        }
        return null;
    }
}
