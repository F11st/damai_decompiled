package cn.damai.commonbusiness.city.model;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class GroupsBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = -429185756935167669L;
    private List<SitesBean> sites;
    private String spellCode;

    public List<SitesBean> getSites() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1269536165") ? (List) ipChange.ipc$dispatch("-1269536165", new Object[]{this}) : this.sites;
    }

    public String getSpellCode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "88192989") ? (String) ipChange.ipc$dispatch("88192989", new Object[]{this}) : this.spellCode;
    }

    public void setSites(List<SitesBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1623179369")) {
            ipChange.ipc$dispatch("1623179369", new Object[]{this, list});
        } else {
            this.sites = list;
        }
    }

    public void setSpellCode(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "768777785")) {
            ipChange.ipc$dispatch("768777785", new Object[]{this, str});
        } else {
            this.spellCode = str;
        }
    }
}
