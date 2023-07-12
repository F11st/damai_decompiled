package com.youku.arch.probe.plugins;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class NetConnMonitorPlugin$2 extends Thread {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ b this$0;
    final /* synthetic */ List val$speedInfoList;

    NetConnMonitorPlugin$2(b bVar, List list) {
        this.this$0 = bVar;
        this.val$speedInfoList = list;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Map map;
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1804550179")) {
            ipChange.ipc$dispatch("-1804550179", new Object[]{this});
            return;
        }
        try {
            com.youku.arch.probe.a.d.a().b();
            com.youku.arch.probe.a.d.a().a(this.val$speedInfoList);
            Map<String, String> b = com.youku.arch.probe.a.d.a().b(this.val$speedInfoList);
            map = this.this$0.D;
            map.putAll(b);
            com.youku.arch.probe.a.d.a().a(b);
            str = this.this$0.y;
            this.this$0.z = com.youku.arch.probe.a.d.a().a(str);
            com.youku.arch.probe.a.d.a().c();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
