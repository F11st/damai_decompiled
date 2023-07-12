package com.youku.arch.ntk.interfere;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class NtkImpairmentAnalyzer$1 implements Runnable {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ e this$0;
    final /* synthetic */ b val$callback;
    final /* synthetic */ c val$inputParam;

    NtkImpairmentAnalyzer$1(e eVar, c cVar, b bVar) {
        this.this$0 = eVar;
        this.val$inputParam = cVar;
        this.val$callback = bVar;
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
