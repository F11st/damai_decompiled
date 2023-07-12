package com.youku.arch.ntk;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class a {
    private static transient /* synthetic */ IpChange $ipChange;
    private static InterfaceC0365a a;

    /* compiled from: Taobao */
    /* renamed from: com.youku.arch.ntk.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0365a {
    }

    public static synchronized void a(InterfaceC0365a interfaceC0365a) {
        synchronized (a.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1576383874")) {
                ipChange.ipc$dispatch("1576383874", new Object[]{interfaceC0365a});
            } else {
                a = interfaceC0365a;
            }
        }
    }
}
