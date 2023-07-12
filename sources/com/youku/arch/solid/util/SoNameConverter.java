package com.youku.arch.solid.util;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class SoNameConverter {
    private static transient /* synthetic */ IpChange $ipChange;

    public static String parseLibName(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "594414529") ? (String) ipChange.ipc$dispatch("594414529", new Object[]{str}) : str.substring(3, str.length() - 3);
    }
}
