package com.youku.arch.probe.plugins;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: com.youku.arch.probe.plugins.c */
/* loaded from: classes2.dex */
public class C7886c {
    private static transient /* synthetic */ IpChange $ipChange;
    public static Map<String, BasePlugin> a = new HashMap();
    public static volatile boolean b;

    public static BasePlugin a(String str) {
        IpChange ipChange = $ipChange;
        return (BasePlugin) (AndroidInstantRuntime.support(ipChange, "-594750168") ? ipChange.ipc$dispatch("-594750168", new Object[]{str}) : a.get(str));
    }
}
