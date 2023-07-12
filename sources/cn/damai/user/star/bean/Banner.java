package cn.damai.user.star.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class Banner implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String pic;
    public String url;

    public String getPic() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2038049928") ? (String) ipChange.ipc$dispatch("2038049928", new Object[]{this}) : this.pic;
    }

    public String getUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "411458541") ? (String) ipChange.ipc$dispatch("411458541", new Object[]{this}) : this.url;
    }

    public void setPic(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "173586414")) {
            ipChange.ipc$dispatch("173586414", new Object[]{this, str});
        } else {
            this.pic = str;
        }
    }

    public void setUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1288860969")) {
            ipChange.ipc$dispatch("1288860969", new Object[]{this, str});
        } else {
            this.url = str;
        }
    }
}
