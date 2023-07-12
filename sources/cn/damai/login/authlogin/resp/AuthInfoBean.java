package cn.damai.login.authlogin.resp;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class AuthInfoBean implements Serializable {
    public String fromIconUrl;
    public ArrayList<String> infoList;
    public String infoTitle;
    public ArrayList<ProtocolInfo> protocolList;
    public String protocolTitle;
    public String toIconUrl;

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public static class ProtocolInfo implements Serializable {
        private static transient /* synthetic */ IpChange $ipChange;
        public String protocolName;
        public String protocolUrl;

        public boolean isValid() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-516555157") ? ((Boolean) ipChange.ipc$dispatch("-516555157", new Object[]{this})).booleanValue() : (wh2.j(this.protocolName) || wh2.j(this.protocolUrl)) ? false : true;
        }
    }
}
