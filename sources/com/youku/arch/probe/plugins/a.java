package com.youku.arch.probe.plugins;

import android.content.BroadcastReceiver;
import android.os.RemoteException;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.huawei.hms.wireless.IQoeCallBack;
import com.huawei.hms.wireless.IQoeService;
import com.youku.arch.probe.plugins.BasePlugin;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class a extends BasePlugin {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static String c = "a";
    private volatile com.youku.arch.probe.b.a[] d;
    private volatile InterfaceC0367a e;
    private IQoeService f;
    private boolean g;
    private IQoeCallBack h;
    private BroadcastReceiver i;

    /* compiled from: Taobao */
    /* renamed from: com.youku.arch.probe.plugins.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0367a {
    }

    @Override // com.youku.arch.probe.plugins.BasePlugin
    public com.youku.arch.analysis.net.a a(com.youku.arch.analysis.net.a aVar) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1409726966") ? (com.youku.arch.analysis.net.a) ipChange.ipc$dispatch("-1409726966", new Object[]{this, aVar}) : aVar;
    }

    @Override // com.youku.arch.probe.plugins.BasePlugin
    public void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-991937562")) {
            ipChange.ipc$dispatch("-991937562", new Object[]{this});
            return;
        }
        this.b.unregisterReceiver(this.i);
        this.e = null;
        try {
            com.youku.b.a.a.b("HmsMonitorPlugin", "unRegisterNetQoeCallBack");
            this.f.unRegisterNetQoeCallBack(this.b.getPackageName(), this.h);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.youku.arch.probe.plugins.BasePlugin
    public void a(BasePlugin.NotiType notiType) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1806431720")) {
            ipChange.ipc$dispatch("-1806431720", new Object[]{this, notiType});
        } else if (this.f == null) {
            com.youku.b.a.a.b("HmsMonitorPlugin", "qoeService is null");
        }
    }

    public int b() {
        com.youku.arch.probe.b.a aVar;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-991907784")) {
            return ((Integer) ipChange.ipc$dispatch("-991907784", new Object[]{this})).intValue();
        }
        if (com.youku.arch.probe.a.a.q > 0) {
            int a = com.youku.arch.probe.a.b.a(this.b);
            int i = 0;
            for (int i2 = 0; i2 < 4; i2++) {
                if (this.d[i2].i >= 0) {
                    if (this.d[i2].i < 2) {
                        if (a == 0 && this.d[i2].d > i) {
                            aVar = this.d[i2];
                            i = aVar.d;
                        }
                    } else if (a == 1 && this.d[i2].d > i) {
                        aVar = this.d[i2];
                        i = aVar.d;
                    }
                }
            }
            return i;
        }
        return 0;
    }

    public Map<String, Integer> c() {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "139741145")) {
            return (Map) ipChange.ipc$dispatch("139741145", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        String str = "hmsQoe";
        if (this.g) {
            int a = com.youku.arch.probe.a.b.a(this.b);
            com.youku.arch.probe.b.a aVar = null;
            for (int i2 = 0; i2 < 4; i2++) {
                if (this.d[i2].i >= 0) {
                    if (this.d[i2].i < 2) {
                        if (a == 0 && this.d[i2].d > 0) {
                            aVar = this.d[i2];
                        }
                    } else if (a == 1 && this.d[i2].d > 0) {
                        aVar = this.d[i2];
                    }
                }
            }
            hashMap.put("hmsQoe", Integer.valueOf(aVar != null ? aVar.h : -1));
            hashMap.put("hmsBw", Integer.valueOf(aVar != null ? aVar.d : -1));
            i = Integer.valueOf(aVar != null ? aVar.b : -1);
            str = "hmsRt";
        } else {
            i = -1;
        }
        hashMap.put(str, i);
        return hashMap;
    }
}
