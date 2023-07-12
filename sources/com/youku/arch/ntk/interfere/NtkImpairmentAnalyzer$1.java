package com.youku.arch.ntk.interfere;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class NtkImpairmentAnalyzer$1 implements Runnable {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ C7865e this$0;
    final /* synthetic */ InterfaceC7862b val$callback;
    final /* synthetic */ C7863c val$inputParam;

    NtkImpairmentAnalyzer$1(C7865e c7865e, C7863c c7863c, InterfaceC7862b interfaceC7862b) {
        this.this$0 = c7865e;
        this.val$inputParam = c7863c;
        this.val$callback = interfaceC7862b;
    }

    @Override // java.lang.Runnable
    public void run() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "159266854")) {
            ipChange.ipc$dispatch("159266854", new Object[]{this});
            return;
        }
        this.this$0.c = true;
        this.this$0.a(this.val$inputParam, this.val$callback);
        this.this$0.c = false;
    }
}
