package cn.damai.login.authlogin.resp;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class CookieBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String domain;
    public String expires;
    public String name;
    public String path;
    public String secure;
    public String value;

    public String toCookieString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "979545303")) {
            return (String) ipChange.ipc$dispatch("979545303", new Object[]{this});
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append("=");
        sb.append(this.value);
        sb.append(";");
        if (!wh2.j(this.domain)) {
            sb.append("domain=");
            sb.append(this.domain);
            sb.append(";");
        }
        if (!wh2.j(this.path)) {
            sb.append("path=");
            sb.append(this.path);
            sb.append(";");
        }
        return sb.toString();
    }
}
