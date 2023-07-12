package com.youku.arch.ntk.c;

import com.alibaba.fastjson.JSON;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.ntk.a.C7833g;
import com.youku.b.a.C7892a;
import com.youku.ups.data.RequestParams;
import com.youku.vpm.constants.TableField;

/* compiled from: Taobao */
/* renamed from: com.youku.arch.ntk.c.a */
/* loaded from: classes2.dex */
public class C7858a {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String a = "a";
    private static volatile boolean b;

    public static void a(C7833g c7833g) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1236942413")) {
            ipChange.ipc$dispatch("-1236942413", new Object[]{c7833g});
            return;
        }
        if (b) {
            str = "triggerType";
        } else {
            b = true;
            str = "triggerType";
            AppMonitor.register("vpm", "network_probe", MeasureSet.create().addMeasure("noise"), DimensionSet.create().addDimension("resolves").addDimension("nameservers").addDimension("traceroutes").addDimension("speedtests").addDimension("vid").addDimension(TableField.IS_VIP).addDimension(RequestParams.client_ip).addDimension("ccode").addDimension("network").addDimension("ytid").addDimension("ruleId").addDimension("triggerType"));
        }
        DimensionValueSet create = DimensionValueSet.create();
        create.setValue("resolves", JSON.toJSONString(c7833g.b)).setValue("nameservers", JSON.toJSONString(c7833g.a)).setValue("traceroutes", JSON.toJSONString(c7833g.c)).setValue("speedtests", JSON.toJSONString(c7833g.d)).setValue("vid", c7833g.g).setValue(TableField.IS_VIP, c7833g.h).setValue(RequestParams.client_ip, c7833g.k).setValue("ccode", c7833g.i).setValue("network", c7833g.m).setValue("ytid", c7833g.f).setValue("ruleId", c7833g.s).setValue(str, c7833g.j);
        MeasureValueSet create2 = MeasureValueSet.create();
        create2.setValue("noise", 0.0d);
        AppMonitor.Stat.commit("vpm", "network_probe", create, create2);
        String str2 = a;
        C7892a.a(str2, "stat:" + create + "," + create2);
    }
}
