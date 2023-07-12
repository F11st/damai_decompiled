package com.youku.arch.ntk;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.ntk.a.C7834h;
import com.youku.b.a.C7892a;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class NetworkInspector$2 implements Runnable {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ C7839b this$0;
    final /* synthetic */ C7834h val$info;

    NetworkInspector$2(C7839b c7839b, C7834h c7834h) {
        this.this$0 = c7839b;
        this.val$info = c7834h;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String str2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1292425732")) {
            ipChange.ipc$dispatch("-1292425732", new Object[]{this});
            return;
        }
        str = C7839b.a;
        C7892a.b(str, "start inspectNetwork:" + this.val$info.t);
        this.this$0.c = true;
        this.this$0.a(this.val$info);
        this.this$0.c = false;
        str2 = C7839b.a;
        C7892a.b(str2, "finish inspectNetwork:" + this.val$info.t);
    }
}
