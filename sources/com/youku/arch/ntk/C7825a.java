package com.youku.arch.ntk;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* renamed from: com.youku.arch.ntk.a */
/* loaded from: classes2.dex */
public class C7825a {
    private static transient /* synthetic */ IpChange $ipChange;
    private static InterfaceC7826a a;

    /* compiled from: Taobao */
    /* renamed from: com.youku.arch.ntk.a$a */
    /* loaded from: classes2.dex */
    public interface InterfaceC7826a {
    }

    public static synchronized void a(InterfaceC7826a interfaceC7826a) {
        synchronized (C7825a.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1576383874")) {
                ipChange.ipc$dispatch("1576383874", new Object[]{interfaceC7826a});
            } else {
                a = interfaceC7826a;
            }
        }
    }
}
