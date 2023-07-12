package com.youku.arch.ntk;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.ntk.a.h;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class NetworkInspector$2 implements Runnable {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ b this$0;
    final /* synthetic */ h val$info;

    NetworkInspector$2(b bVar, h hVar) {
        this.this$0 = bVar;
        this.val$info = hVar;
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
        str = b.a;
        com.youku.b.a.a.b(str, "start inspectNetwork:" + this.val$info.t);
        this.this$0.c = true;
        this.this$0.a(this.val$info);
        this.this$0.c = false;
        str2 = b.a;
        com.youku.b.a.a.b(str2, "finish inspectNetwork:" + this.val$info.t);
    }
}
