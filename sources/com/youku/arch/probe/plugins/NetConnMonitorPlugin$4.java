package com.youku.arch.probe.plugins;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.probe.a.C7873a;
import com.youku.arch.probe.a.C7874b;
import com.youku.arch.probe.a.C7876d;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class NetConnMonitorPlugin$4 extends Thread {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ C7884b this$0;

    NetConnMonitorPlugin$4(C7884b c7884b) {
        this.this$0 = c7884b;
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
            C7876d.a().b();
            Map<String, String> d = C7876d.a().d();
            map = this.this$0.D;
            map.putAll(d);
            C7876d.a().e();
            this.this$0.C = C7876d.a().f();
            String b = C7874b.b(this.this$0.b);
            this.this$0.y = b;
            this.this$0.z = C7876d.a().a(b);
            if (C7873a.r > 0) {
                HashMap hashMap = new HashMap();
                C7884b c7884b = this.this$0;
                C7876d a = C7876d.a();
                i = this.this$0.C;
                c7884b.A = a.a(i, hashMap);
                this.this$0.B = C7876d.a().b(hashMap);
            }
            C7876d.a().c();
            this.this$0.h();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
