package cn.damai.commonbusiness.city.model;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class SitesBean {
    private static transient /* synthetic */ IpChange $ipChange;
    private String cityId;
    private String cityName;

    public String getCityId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1894704542") ? (String) ipChange.ipc$dispatch("-1894704542", new Object[]{this}) : this.cityId;
    }

    public String getCityName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "325951698") ? (String) ipChange.ipc$dispatch("325951698", new Object[]{this}) : this.cityName;
    }

    public void setCityId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1390660")) {
            ipChange.ipc$dispatch("-1390660", new Object[]{this, str});
        } else {
            this.cityId = str;
        }
    }

    public void setCityName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1632240204")) {
            ipChange.ipc$dispatch("1632240204", new Object[]{this, str});
        } else {
            this.cityName = str;
        }
    }
}
