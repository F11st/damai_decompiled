package com.youku.arch.probe.plugins;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.probe.a.C7876d;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class NetConnMonitorPlugin$2 extends Thread {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ C7884b this$0;
    final /* synthetic */ List val$speedInfoList;

    NetConnMonitorPlugin$2(C7884b c7884b, List list) {
        this.this$0 = c7884b;
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
            C7876d.a().b();
            C7876d.a().a(this.val$speedInfoList);
            Map<String, String> b = C7876d.a().b(this.val$speedInfoList);
            map = this.this$0.D;
            map.putAll(b);
            C7876d.a().a(b);
            str = this.this$0.y;
            this.this$0.z = C7876d.a().a(str);
            C7876d.a().c();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
