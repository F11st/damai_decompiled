package cn.damai.tool2.bufferkit;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class BufferSwitch implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;

    public boolean isGroupTypeSupport(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "598462600")) {
            return ((Boolean) ipChange.ipc$dispatch("598462600", new Object[]{this, str})).booleanValue();
        }
        return true;
    }
}
