package com.youku.arch.analysis.net;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class SmartEvaluator$2 extends Thread {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ C7812c this$0;

    SmartEvaluator$2(C7812c c7812c) {
        this.this$0 = c7812c;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-114444554")) {
            ipChange.ipc$dispatch("-114444554", new Object[]{this});
        } else {
            this.this$0.c();
        }
    }
}
