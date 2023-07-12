package com.youku.arch.analysis.net;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* renamed from: com.youku.arch.analysis.net.d */
/* loaded from: classes11.dex */
public class C7814d {
    private static transient /* synthetic */ IpChange $ipChange;
    private String a = "";
    private double b = -1.0d;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.youku.arch.analysis.net.d$a */
    /* loaded from: classes11.dex */
    public static class C7815a {
        private static final C7814d a = new C7814d();
    }

    public static C7814d a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1293787797") ? (C7814d) ipChange.ipc$dispatch("1293787797", new Object[0]) : C7815a.a;
    }

    public double a(double d, double d2, double d3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-736625916")) {
            return ((Double) ipChange.ipc$dispatch("-736625916", new Object[]{this, Double.valueOf(d), Double.valueOf(d2), Double.valueOf(d3)})).doubleValue();
        }
        if (C7810b.a().c() == 1) {
            if (d2 > 0.0d && d2 < d) {
                d = d2;
            }
            return (d3 <= 0.0d || d3 >= d) ? d : d3;
        }
        return d;
    }
}
