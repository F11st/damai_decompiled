package cn.damai.tetris.component.star.content.base.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class Button {
    private static transient /* synthetic */ IpChange $ipChange;
    private String destination;
    private String name;

    public String getDestination() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-303062110") ? (String) ipChange.ipc$dispatch("-303062110", new Object[]{this}) : this.destination;
    }

    public String getName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1605281747") ? (String) ipChange.ipc$dispatch("-1605281747", new Object[]{this}) : this.name;
    }

    public void setDestination(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1190025236")) {
            ipChange.ipc$dispatch("1190025236", new Object[]{this, str});
        } else {
            this.destination = str;
        }
    }

    public void setName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1483116625")) {
            ipChange.ipc$dispatch("1483116625", new Object[]{this, str});
        } else {
            this.name = str;
        }
    }
}
