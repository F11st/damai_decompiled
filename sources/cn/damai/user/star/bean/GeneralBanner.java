package cn.damai.user.star.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class GeneralBanner implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String picUrl;
    public String targetUrl;

    public String getPic() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1594879630") ? (String) ipChange.ipc$dispatch("1594879630", new Object[]{this}) : this.picUrl;
    }

    public String getUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-31711757") ? (String) ipChange.ipc$dispatch("-31711757", new Object[]{this}) : this.targetUrl;
    }

    public void setPic(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-679790936")) {
            ipChange.ipc$dispatch("-679790936", new Object[]{this, str});
        } else {
            this.picUrl = str;
        }
    }

    public void setUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "435483619")) {
            ipChange.ipc$dispatch("435483619", new Object[]{this, str});
        } else {
            this.targetUrl = str;
        }
    }
}
