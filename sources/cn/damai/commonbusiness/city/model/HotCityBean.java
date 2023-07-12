package cn.damai.commonbusiness.city.model;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class HotCityBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = -2528745449406752592L;
    private String cityId;
    private String cityName;
    private String url;

    public String getCityId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1948231954") ? (String) ipChange.ipc$dispatch("-1948231954", new Object[]{this}) : this.cityId;
    }

    public String getCityName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "425716318") ? (String) ipChange.ipc$dispatch("425716318", new Object[]{this}) : this.cityName;
    }

    public String getUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1906424477") ? (String) ipChange.ipc$dispatch("1906424477", new Object[]{this}) : this.url;
    }

    public void setCityId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1660740432")) {
            ipChange.ipc$dispatch("-1660740432", new Object[]{this, str});
        } else {
            this.cityId = str;
        }
    }

    public void setCityName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "429976128")) {
            ipChange.ipc$dispatch("429976128", new Object[]{this, str});
        } else {
            this.cityName = str;
        }
    }

    public void setUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "388164729")) {
            ipChange.ipc$dispatch("388164729", new Object[]{this, str});
        } else {
            this.url = str;
        }
    }
}
