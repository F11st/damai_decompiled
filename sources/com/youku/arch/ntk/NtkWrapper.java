package com.youku.arch.ntk;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.ntk.a;
import com.youku.arch.ntk.a.g;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class NtkWrapper {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    private static class a {
        private static final NtkWrapper a = new NtkWrapper();
    }

    static {
        com.youku.b.a.a.a("NetworkInspector", "load ntkso begin");
        System.loadLibrary("ntk");
        System.loadLibrary("speedtest");
        com.youku.b.a.a.a("NetworkInspector", "load ntkso end");
    }

    private NtkWrapper() {
    }

    public static NtkWrapper a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1531743075")) {
            return (NtkWrapper) ipChange.ipc$dispatch("1531743075", new Object[0]);
        }
        com.youku.b.a.a.a("NetworkInspector", "getInstance");
        return a.a;
    }

    public void a(a.InterfaceC0365a interfaceC0365a) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-997371569")) {
            ipChange.ipc$dispatch("-997371569", new Object[]{this, interfaceC0365a});
        } else {
            com.youku.arch.ntk.a.a(interfaceC0365a);
        }
    }

    public native boolean cronet_so_loaded();

    public native void inspect_dns(g gVar, String str, int i);

    public native void inspect_ext_resolve(g gVar, String str, String[] strArr, int[] iArr, int i);

    public native void inspect_resolve(g gVar, String str, String[] strArr, int[] iArr, int i);

    public native void inspect_trace(g gVar, String str, int i, int i2);

    public native void set_cronet_host(String str, int[] iArr);
}
