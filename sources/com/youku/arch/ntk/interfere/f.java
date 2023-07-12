package com.youku.arch.ntk.interfere;

import com.alibaba.fastjson.JSON;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class f {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final String a = e.class.getSimpleName();
    private static volatile boolean b = false;

    public static void a(d dVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1788254439")) {
            ipChange.ipc$dispatch("-1788254439", new Object[]{dVar});
            return;
        }
        if (!b) {
            b = true;
            AppMonitor.register("vpm", "ntk_interfere", MeasureSet.create().addMeasure("resCode").addMeasure("bandwidth_ori").addMeasure("bandwidth_new"), DimensionSet.create().addDimension("msg").addDimension("domain").addDimension("impairmentIp").addDimension("used_ips").addDimension("backupDomains").addDimension("isDispatcherDomain").addDimension("ref_ip").addDimension("ref_domain"));
        }
        DimensionValueSet create = DimensionValueSet.create();
        create.setValue("msg", dVar.d).setValue("domain", dVar.e).setValue("impairmentIp", dVar.f).setValue("used_ips", dVar.g).setValue("backupDomains", dVar.h).setValue("isDispatcherDomain", dVar.i).setValue("ref_ip", dVar.j).setValue("ref_domain", dVar.k);
        MeasureValueSet create2 = MeasureValueSet.create();
        create2.setValue("resCode", dVar.a);
        create2.setValue("bandwidth_ori", dVar.b);
        create2.setValue("bandwidth_new", dVar.c);
        AppMonitor.Stat.commit("vpm", "ntk_interfere", create, create2);
        com.youku.b.a.a.a(a, JSON.toJSONString(dVar));
    }
}
