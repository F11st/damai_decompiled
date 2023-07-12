package cn.damai.common.askpermission;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.tc1;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class MRequest$1$1 implements Runnable {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ tc1 this$1;

    MRequest$1$1(tc1 tc1Var) {
    }

    @Override // java.lang.Runnable
    public void run() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "133689470")) {
            throw null;
        }
        ipChange.ipc$dispatch("133689470", new Object[]{this});
    }
}
