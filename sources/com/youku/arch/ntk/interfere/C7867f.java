package com.youku.arch.ntk.interfere;

import com.alibaba.fastjson.JSON;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.b.a.C7892a;

/* compiled from: Taobao */
/* renamed from: com.youku.arch.ntk.interfere.f */
/* loaded from: classes2.dex */
public class C7867f {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final String a = C7865e.class.getSimpleName();
    private static volatile boolean b = false;

    public static void a(C7864d c7864d) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1788254439")) {
            ipChange.ipc$dispatch("-1788254439", new Object[]{c7864d});
            return;
        }
        if (!b) {
            b = true;
            AppMonitor.register("vpm", "ntk_interfere", MeasureSet.create().addMeasure("resCode").addMeasure("bandwidth_ori").addMeasure("bandwidth_new"), DimensionSet.create().addDimension("msg").addDimension("domain").addDimension("impairmentIp").addDimension("used_ips").addDimension("backupDomains").addDimension("isDispatcherDomain").addDimension("ref_ip").addDimension("ref_domain"));
        }
        DimensionValueSet create = DimensionValueSet.create();
        create.setValue("msg", c7864d.d).setValue("domain", c7864d.e).setValue("impairmentIp", c7864d.f).setValue("used_ips", c7864d.g).setValue("backupDomains", c7864d.h).setValue("isDispatcherDomain", c7864d.i).setValue("ref_ip", c7864d.j).setValue("ref_domain", c7864d.k);
        MeasureValueSet create2 = MeasureValueSet.create();
        create2.setValue("resCode", c7864d.a);
        create2.setValue("bandwidth_ori", c7864d.b);
        create2.setValue("bandwidth_new", c7864d.c);
        AppMonitor.Stat.commit("vpm", "ntk_interfere", create, create2);
        C7892a.a(a, JSON.toJSONString(c7864d));
    }
}
