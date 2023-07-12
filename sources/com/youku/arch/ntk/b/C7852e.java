package com.youku.arch.ntk.b;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.baseproject.utils.speedtest.C4666a;
import com.baseproject.utils.speedtest.SpeedTestRequest;
import com.youku.arch.ntk.a.C7832f;
import com.youku.arch.ntk.a.C7833g;
import com.youku.arch.ntk.a.C7835i;
import com.youku.arch.ntk.a.C7837k;
import com.youku.b.a.C7892a;

/* compiled from: Taobao */
/* renamed from: com.youku.arch.ntk.b.e */
/* loaded from: classes2.dex */
public class C7852e extends AbstractC7841a {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* renamed from: com.youku.arch.ntk.b.e$a */
    /* loaded from: classes2.dex */
    private static class C7853a {
        private static final C7852e a = new C7852e();
    }

    private C7852e() {
    }

    public static C7852e a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-391423855") ? (C7852e) ipChange.ipc$dispatch("-391423855", new Object[0]) : C7853a.a;
    }

    public void a(C7833g c7833g, JSONObject jSONObject, C7832f c7832f) {
        C7835i c7835i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1423680698")) {
            ipChange.ipc$dispatch("-1423680698", new Object[]{this, c7833g, jSONObject, c7832f});
            return;
        }
        C7892a.a("ntk_implementer", "do speed test");
        C4666a.C4667a c4667a = (C4666a.C4667a) JSON.toJavaObject(jSONObject, C4666a.C4667a.class);
        C4666a c4666a = new C4666a();
        c4666a.d = new C4666a.C4667a[]{c4667a};
        if (c7832f != null && (c7835i = c7832f.a) != null) {
            c4666a.f = c7835i.b;
            c4666a.b = c7835i.d;
            c4666a.e = c7835i.c;
            c4666a.c = c7835i.e;
            c4666a.a = c7835i.a;
        }
        SpeedTestRequest speedTestRequest = new SpeedTestRequest(c7832f.b.a, c4666a, c4667a, 0, 1);
        C7837k c7837k = new C7837k();
        c7837k.a(speedTestRequest.h());
        c7833g.d.add(c7837k);
    }
}
