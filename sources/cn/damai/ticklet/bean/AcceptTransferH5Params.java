package cn.damai.ticklet.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class AcceptTransferH5Params implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = 1;
    String from;
    String transferId;

    public String getFrom() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1185286044") ? (String) ipChange.ipc$dispatch("-1185286044", new Object[]{this}) : this.from;
    }

    public String getTransferId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1233670688") ? (String) ipChange.ipc$dispatch("-1233670688", new Object[]{this}) : this.transferId;
    }

    public void setFrom(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1618081530")) {
            ipChange.ipc$dispatch("1618081530", new Object[]{this, str});
        } else {
            this.from = str;
        }
    }

    public void setTransferId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1698969090")) {
            ipChange.ipc$dispatch("-1698969090", new Object[]{this, str});
        } else {
            this.transferId = str;
        }
    }
}
