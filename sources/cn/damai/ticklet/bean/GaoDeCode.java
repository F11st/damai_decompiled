package cn.damai.ticklet.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class GaoDeCode {
    private static transient /* synthetic */ IpChange $ipChange;
    public String code;
    public String name;

    public String getCode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "817907942") ? (String) ipChange.ipc$dispatch("817907942", new Object[]{this}) : this.code;
    }

    public String getName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1328637308") ? (String) ipChange.ipc$dispatch("-1328637308", new Object[]{this}) : this.name;
    }

    public void setCode(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-707414344")) {
            ipChange.ipc$dispatch("-707414344", new Object[]{this, str});
        } else {
            this.code = str;
        }
    }

    public void setName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1469159642")) {
            ipChange.ipc$dispatch("1469159642", new Object[]{this, str});
        } else {
            this.name = str;
        }
    }
}
