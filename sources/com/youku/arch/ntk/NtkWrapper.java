package com.youku.arch.ntk;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.ntk.C7825a;
import com.youku.arch.ntk.a.C7833g;
import com.youku.b.a.C7892a;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class NtkWrapper {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* renamed from: com.youku.arch.ntk.NtkWrapper$a */
    /* loaded from: classes2.dex */
    private static class C7824a {
        private static final NtkWrapper a = new NtkWrapper();
    }

    static {
        C7892a.a("NetworkInspector", "load ntkso begin");
        System.loadLibrary("ntk");
        System.loadLibrary("speedtest");
        C7892a.a("NetworkInspector", "load ntkso end");
    }

    private NtkWrapper() {
    }

    public static NtkWrapper a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1531743075")) {
            return (NtkWrapper) ipChange.ipc$dispatch("1531743075", new Object[0]);
        }
        C7892a.a("NetworkInspector", "getInstance");
        return C7824a.a;
    }

    public void a(C7825a.InterfaceC7826a interfaceC7826a) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-997371569")) {
            ipChange.ipc$dispatch("-997371569", new Object[]{this, interfaceC7826a});
        } else {
            C7825a.a(interfaceC7826a);
        }
    }

    public native boolean cronet_so_loaded();

    public native void inspect_dns(C7833g c7833g, String str, int i);

    public native void inspect_ext_resolve(C7833g c7833g, String str, String[] strArr, int[] iArr, int i);

    public native void inspect_resolve(C7833g c7833g, String str, String[] strArr, int[] iArr, int i);

    public native void inspect_trace(C7833g c7833g, String str, int i, int i2);

    public native void set_cronet_host(String str, int[] iArr);
}
