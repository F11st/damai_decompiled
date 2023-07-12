package cn.damai.tetris.component.ip.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class Rank implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String id;
    public String name;
    public String order;

    public String formatStr() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1337989035")) {
            return (String) ipChange.ipc$dispatch("-1337989035", new Object[]{this});
        }
        return this.name + "NO." + this.order;
    }
}
