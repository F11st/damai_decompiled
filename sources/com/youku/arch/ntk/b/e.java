package com.youku.arch.ntk.b;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.baseproject.utils.speedtest.SpeedTestRequest;
import com.baseproject.utils.speedtest.a;
import com.youku.arch.ntk.a.g;
import com.youku.arch.ntk.a.i;
import com.youku.arch.ntk.a.k;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class e extends com.youku.arch.ntk.b.a {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    private static class a {
        private static final e a = new e();
    }

    private e() {
    }

    public static e a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-391423855") ? (e) ipChange.ipc$dispatch("-391423855", new Object[0]) : a.a;
    }

    public void a(g gVar, JSONObject jSONObject, com.youku.arch.ntk.a.f fVar) {
        i iVar;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1423680698")) {
            ipChange.ipc$dispatch("-1423680698", new Object[]{this, gVar, jSONObject, fVar});
            return;
        }
        com.youku.b.a.a.a("ntk_implementer", "do speed test");
        a.C0218a c0218a = (a.C0218a) JSON.toJavaObject(jSONObject, a.C0218a.class);
        com.baseproject.utils.speedtest.a aVar = new com.baseproject.utils.speedtest.a();
        aVar.d = new a.C0218a[]{c0218a};
        if (fVar != null && (iVar = fVar.a) != null) {
            aVar.f = iVar.b;
            aVar.b = iVar.d;
            aVar.e = iVar.c;
            aVar.c = iVar.e;
            aVar.a = iVar.a;
        }
        SpeedTestRequest speedTestRequest = new SpeedTestRequest(fVar.b.a, aVar, c0218a, 0, 1);
        k kVar = new k();
        kVar.a(speedTestRequest.h());
        gVar.d.add(kVar);
    }
}
