package cn.damai.commonbusiness.citycopy.model;

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
        return AndroidInstantRuntime.support(ipChange, "-299121392") ? (List) ipChange.ipc$dispatch("-299121392", new Object[]{this}) : this.sites;
    }

    public String getSpellCode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1720355118") ? (String) ipChange.ipc$dispatch("-1720355118", new Object[]{this}) : this.spellCode;
    }

    public void setSites(List<SitesBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1641266260")) {
            ipChange.ipc$dispatch("1641266260", new Object[]{this, list});
        } else {
            this.sites = list;
        }
    }

    public void setSpellCode(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "538361316")) {
            ipChange.ipc$dispatch("538361316", new Object[]{this, str});
        } else {
            this.spellCode = str;
        }
    }
}
