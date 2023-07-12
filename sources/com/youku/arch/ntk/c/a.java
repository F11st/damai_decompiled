package com.youku.arch.ntk.c;

import com.alibaba.fastjson.JSON;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.ntk.a.g;
import com.youku.ups.data.RequestParams;
import com.youku.vpm.constants.TableField;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class a {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String a = "a";
    private static volatile boolean b;

    public static void a(g gVar) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1236942413")) {
            ipChange.ipc$dispatch("-1236942413", new Object[]{gVar});
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
        create.setValue("resolves", JSON.toJSONString(gVar.b)).setValue("nameservers", JSON.toJSONString(gVar.a)).setValue("traceroutes", JSON.toJSONString(gVar.c)).setValue("speedtests", JSON.toJSONString(gVar.d)).setValue("vid", gVar.g).setValue(TableField.IS_VIP, gVar.h).setValue(RequestParams.client_ip, gVar.k).setValue("ccode", gVar.i).setValue("network", gVar.m).setValue("ytid", gVar.f).setValue("ruleId", gVar.s).setValue(str, gVar.j);
        MeasureValueSet create2 = MeasureValueSet.create();
        create2.setValue("noise", 0.0d);
        AppMonitor.Stat.commit("vpm", "network_probe", create, create2);
        String str2 = a;
        com.youku.b.a.a.a(str2, "stat:" + create + "," + create2);
    }
}
