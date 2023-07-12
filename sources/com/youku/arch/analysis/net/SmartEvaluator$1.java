package com.youku.arch.analysis.net;

import android.content.Context;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class SmartEvaluator$1 extends Thread {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ C7812c this$0;
    final /* synthetic */ String val$info;

    SmartEvaluator$1(C7812c c7812c, String str) {
        this.this$0 = c7812c;
        this.val$info = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Context context;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "82068951")) {
            ipChange.ipc$dispatch("82068951", new Object[]{this});
            return;
        }
        C7812c c7812c = this.this$0;
        context = c7812c.c;
        c7812c.a(context, this.val$info);
    }
}
