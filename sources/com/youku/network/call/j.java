package com.youku.network.call;

import android.text.TextUtils;
import anet.channel.fulltrace.IFullTraceAnalysisV3;
import anet.channel.monitor.BandWidthSampler;
import anet.channel.status.NetworkStatusHelper;
import anetwork.channel.statist.StatisticData;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.youku.network.config.YKNetworkConfig;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class j implements e {
    private static volatile boolean k;
    public String a;
    public String b;
    public long c;
    public long d;
    public long e;
    public long f;
    public long g;
    public long h;
    public long i;
    public long j;
    private a l;
    private long m;
    private long n;
    private String o;
    private String p;
    private String q;
    private String r;
    private String s;
    private int t;
    private String u;
    private int v;
    private int w;
    private int x;

    private int b(com.youku.network.d dVar) {
        if (dVar == null) {
            return 0;
        }
        a aVar = this.l;
        if (aVar instanceof k) {
            if (dVar.g() != null) {
                return dVar.g().retryTime;
            }
        } else if (aVar instanceof m) {
            return ((m) aVar).d();
        }
        return 0;
    }

    private String b(a aVar) {
        return String.valueOf(aVar instanceof k ? YKNetworkConfig.CallType.NETWORKSDK : YKNetworkConfig.CallType.OKHTTP);
    }

    private String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new URL(str).getPath();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return "";
        }
    }

    private String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new URL(str).getHost();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.youku.network.call.e
    public void a(a aVar) {
        this.l = aVar;
        this.m = System.currentTimeMillis();
        com.youku.network.c c = aVar.c();
        String e = c.e();
        this.o = c(e);
        this.p = b(e);
        this.u = c.O();
        this.q = b(aVar);
        this.v = c.f();
        this.x = c.g();
        this.w = c.j();
    }

    @Override // com.youku.network.call.e
    public void a(com.youku.network.d dVar) {
        this.n = System.currentTimeMillis() - this.m;
        this.r = String.valueOf(dVar.d());
        this.s = String.valueOf(dVar.b());
        this.t = b(dVar);
        StatisticData g = dVar.g();
        if (g != null) {
            this.a = g.connectionType;
            this.b = String.valueOf(g.isSSL);
            this.d = g.firstDataTime;
            this.e = g.recDataTime;
            this.c = g.oneWayTime_ANet;
            this.f = g.serverRT;
            this.h = g.totalSize;
            this.g = g.dataSpeed;
        }
        if (dVar.e() != null) {
            this.j = dVar.e().length;
        }
        this.i = (long) BandWidthSampler.f().g();
        a("after");
    }

    public void a(String str) {
        String str2;
        String str3;
        String str4;
        try {
            boolean z = k;
            String str5 = "netSpeed";
            String str6 = "revSize";
            String str7 = "dataSpeed";
            String str8 = IFullTraceAnalysisV3.Stage.SERVE_RT;
            String str9 = "recDataTime";
            String str10 = "firstDataTime";
            String str11 = "oneWayTime_ANet";
            if (z) {
                str2 = "setting_conn";
                str3 = com.alibaba.poplayer.trigger.c.KEY_RETRY_TIME;
                str4 = "cost";
            } else {
                try {
                    k = true;
                    DimensionSet addDimension = DimensionSet.create().addDimension("host").addDimension(com.alibaba.security.realidentity.jsbridge.a.V).addDimension("connType").addDimension("httpCode").addDimension("errorCode").addDimension("connectionType").addDimension("state").addDimension("setting_conn").addDimension("setting_read").addDimension("setting_retry").addDimension("net").addDimension("bizType").addDimension("isSSL");
                    str2 = "setting_conn";
                    MeasureSet addMeasure = MeasureSet.create().addMeasure("cost").addMeasure(com.alibaba.poplayer.trigger.c.KEY_RETRY_TIME);
                    str3 = com.alibaba.poplayer.trigger.c.KEY_RETRY_TIME;
                    MeasureSet addMeasure2 = addMeasure.addMeasure(str11);
                    str11 = str11;
                    MeasureSet addMeasure3 = addMeasure2.addMeasure(str10);
                    str10 = str10;
                    MeasureSet addMeasure4 = addMeasure3.addMeasure(str9);
                    str9 = str9;
                    MeasureSet addMeasure5 = addMeasure4.addMeasure(str8);
                    str8 = str8;
                    MeasureSet addMeasure6 = addMeasure5.addMeasure(str7);
                    str7 = str7;
                    MeasureSet addMeasure7 = addMeasure6.addMeasure(str6);
                    str6 = str6;
                    MeasureSet addMeasure8 = addMeasure7.addMeasure(str5);
                    str5 = str5;
                    str4 = "cost";
                    AppMonitor.register("network_api", "api_request", addMeasure8.addMeasure("contentLength"), addDimension);
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    return;
                }
            }
            DimensionValueSet create = DimensionValueSet.create();
            String str12 = str2;
            create.setValue("host", this.o);
            create.setValue(com.alibaba.security.realidentity.jsbridge.a.V, this.p);
            create.setValue("connType", this.q);
            create.setValue("httpCode", this.r);
            create.setValue("errorCode", this.s);
            create.setValue("connectionType", this.a);
            create.setValue("isSSL", this.b);
            create.setValue("state", str);
            create.setValue(str12, String.valueOf(this.v));
            create.setValue("setting_retry", String.valueOf(this.w));
            create.setValue("setting_read", String.valueOf(this.x));
            create.setValue("net", NetworkStatusHelper.n() ? "1" : "0");
            create.setValue("bizType", String.valueOf(this.u));
            MeasureValueSet create2 = MeasureValueSet.create();
            create2.setValue(str4, this.n);
            create2.setValue(str3, this.t);
            create2.setValue(str11, this.c);
            create2.setValue(str10, this.d);
            create2.setValue(str9, this.e);
            create2.setValue(str8, this.f);
            create2.setValue(str7, this.g);
            create2.setValue(str6, this.h);
            create2.setValue(str5, this.i);
            create2.setValue("contentLength", this.j);
            AppMonitor.Stat.commit("network_api", "api_request", create, create2);
        } catch (Exception e2) {
            e = e2;
        }
    }
}
