package com.youku.arch.ntk.b;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.taobao.accs.utl.BaseMonitor;
import com.youku.arch.ntk.NtkWrapper;
import com.youku.arch.ntk.a.C7832f;
import com.youku.arch.ntk.a.C7833g;
import com.youku.b.a.C7892a;
import java.util.Date;

/* compiled from: Taobao */
/* renamed from: com.youku.arch.ntk.b.b */
/* loaded from: classes2.dex */
public class C7842b extends AbstractC7841a {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* renamed from: com.youku.arch.ntk.b.b$a */
    /* loaded from: classes2.dex */
    private static class C7843a {
        private static final C7842b a = new C7842b();
    }

    /* compiled from: Taobao */
    /* renamed from: com.youku.arch.ntk.b.b$b */
    /* loaded from: classes2.dex */
    public static class C7844b {
        @JSONField(name = "domain")
        public String a;
        @JSONField(name = RemoteMessageConst.INPUT_TYPE)
        public int b;
        @JSONField(name = "time")
        public int c;
    }

    private C7842b() {
    }

    public static C7842b a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1443823759") ? (C7842b) ipChange.ipc$dispatch("-1443823759", new Object[0]) : C7843a.a;
    }

    public synchronized void a(C7833g c7833g, JSONObject jSONObject, C7832f c7832f) {
        IpChange ipChange = $ipChange;
        int i = 3;
        if (AndroidInstantRuntime.support(ipChange, "-267580349")) {
            ipChange.ipc$dispatch("-267580349", new Object[]{this, c7833g, jSONObject, c7832f});
            return;
        }
        C7892a.a("ntk_implementer", "do dnsInfer");
        C7844b c7844b = (C7844b) JSON.toJavaObject(jSONObject, C7844b.class);
        if (c7844b != null) {
            if (c7844b.b == 1 || TextUtils.isEmpty(c7844b.a)) {
                c7844b.a = BaseMonitor.COUNT_POINT_DNS + (new Date().getTime() % 1024) + ".debug.danuoyi.alicdn.com";
            }
            NtkWrapper a = NtkWrapper.a();
            String str = c7844b.a;
            int i2 = c7844b.c;
            if (i2 > 0) {
                i = i2;
            }
            a.inspect_dns(c7833g, str, i);
        }
    }
}
