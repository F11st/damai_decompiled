package cn.damai.tetris.core.config;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class ComponentConfig implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String componentId;
    public String layoutXml;
    public String mClass;
    public String pClass;
    public String vClass;

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-942167608")) {
            return (String) ipChange.ipc$dispatch("-942167608", new Object[]{this});
        }
        return "[ " + this.componentId + " , " + this.vClass + " , " + this.pClass + " , " + this.mClass + " , " + this.layoutXml + " ] ";
    }
}
