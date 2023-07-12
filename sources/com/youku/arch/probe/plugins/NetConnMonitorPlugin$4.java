package com.youku.arch.probe.plugins;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class NetConnMonitorPlugin$4 extends Thread {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ b this$0;

    NetConnMonitorPlugin$4(b bVar) {
        this.this$0 = bVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Map map;
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2097390107")) {
            ipChange.ipc$dispatch("2097390107", new Object[]{this});
            return;
        }
        try {
            com.youku.arch.probe.a.d.a().b();
            Map<String, String> d = com.youku.arch.probe.a.d.a().d();
            map = this.this$0.D;
            map.putAll(d);
            com.youku.arch.probe.a.d.a().e();
            this.this$0.C = com.youku.arch.probe.a.d.a().f();
            String b = com.youku.arch.probe.a.b.b(this.this$0.b);
            this.this$0.y = b;
            this.this$0.z = com.youku.arch.probe.a.d.a().a(b);
            if (com.youku.arch.probe.a.a.r > 0) {
                HashMap hashMap = new HashMap();
                b bVar = this.this$0;
                com.youku.arch.probe.a.d a = com.youku.arch.probe.a.d.a();
                i = this.this$0.C;
                bVar.A = a.a(i, hashMap);
                this.this$0.B = com.youku.arch.probe.a.d.a().b(hashMap);
            }
            com.youku.arch.probe.a.d.a().c();
            this.this$0.h();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
