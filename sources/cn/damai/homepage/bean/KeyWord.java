package cn.damai.homepage.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class KeyWord {
    private static transient /* synthetic */ IpChange $ipChange;
    public String alg;
    public String comboDispatchId;
    public String comboDispatchSystem;
    String keyword;

    public String getKeyword() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1314023922") ? (String) ipChange.ipc$dispatch("-1314023922", new Object[]{this}) : this.keyword;
    }

    public void setKeyword(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "598677800")) {
            ipChange.ipc$dispatch("598677800", new Object[]{this, str});
        } else {
            this.keyword = str;
        }
    }
}
