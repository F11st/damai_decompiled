package com.youku.arch.probe.plugins;

import android.content.BroadcastReceiver;
import android.os.RemoteException;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.huawei.hms.wireless.IQoeCallBack;
import com.huawei.hms.wireless.IQoeService;
import com.youku.arch.analysis.net.C7809a;
import com.youku.arch.probe.a.C7873a;
import com.youku.arch.probe.a.C7874b;
import com.youku.arch.probe.b.C7879a;
import com.youku.arch.probe.plugins.BasePlugin;
import com.youku.b.a.C7892a;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: com.youku.arch.probe.plugins.a */
/* loaded from: classes2.dex */
public class C7882a extends BasePlugin {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static String c = "a";
    private volatile C7879a[] d;
    private volatile InterfaceC7883a e;
    private IQoeService f;
    private boolean g;
    private IQoeCallBack h;
    private BroadcastReceiver i;

    /* compiled from: Taobao */
    /* renamed from: com.youku.arch.probe.plugins.a$a */
    /* loaded from: classes2.dex */
    public interface InterfaceC7883a {
    }

    @Override // com.youku.arch.probe.plugins.BasePlugin
    public C7809a a(C7809a c7809a) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1409726966") ? (C7809a) ipChange.ipc$dispatch("-1409726966", new Object[]{this, c7809a}) : c7809a;
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
            C7892a.b("HmsMonitorPlugin", "unRegisterNetQoeCallBack");
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
            C7892a.b("HmsMonitorPlugin", "qoeService is null");
        }
    }

    public int b() {
        C7879a c7879a;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-991907784")) {
            return ((Integer) ipChange.ipc$dispatch("-991907784", new Object[]{this})).intValue();
        }
        if (C7873a.q > 0) {
            int a = C7874b.a(this.b);
            int i = 0;
            for (int i2 = 0; i2 < 4; i2++) {
                if (this.d[i2].i >= 0) {
                    if (this.d[i2].i < 2) {
                        if (a == 0 && this.d[i2].d > i) {
                            c7879a = this.d[i2];
                            i = c7879a.d;
                        }
                    } else if (a == 1 && this.d[i2].d > i) {
                        c7879a = this.d[i2];
                        i = c7879a.d;
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
            int a = C7874b.a(this.b);
            C7879a c7879a = null;
            for (int i2 = 0; i2 < 4; i2++) {
                if (this.d[i2].i >= 0) {
                    if (this.d[i2].i < 2) {
                        if (a == 0 && this.d[i2].d > 0) {
                            c7879a = this.d[i2];
                        }
                    } else if (a == 1 && this.d[i2].d > 0) {
                        c7879a = this.d[i2];
                    }
                }
            }
            hashMap.put("hmsQoe", Integer.valueOf(c7879a != null ? c7879a.h : -1));
            hashMap.put("hmsBw", Integer.valueOf(c7879a != null ? c7879a.d : -1));
            i = Integer.valueOf(c7879a != null ? c7879a.b : -1);
            str = "hmsRt";
        } else {
            i = -1;
        }
        hashMap.put(str, i);
        return hashMap;
    }
}
