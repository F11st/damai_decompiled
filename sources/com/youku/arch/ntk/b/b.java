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
import com.youku.arch.ntk.a.g;
import java.util.Date;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class b extends com.youku.arch.ntk.b.a {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    private static class a {
        private static final b a = new b();
    }

    /* compiled from: Taobao */
    /* renamed from: com.youku.arch.ntk.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0366b {
        @JSONField(name = "domain")
        public String a;
        @JSONField(name = RemoteMessageConst.INPUT_TYPE)
        public int b;
        @JSONField(name = "time")
        public int c;
    }

    private b() {
    }

    public static b a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1443823759") ? (b) ipChange.ipc$dispatch("-1443823759", new Object[0]) : a.a;
    }

    public synchronized void a(g gVar, JSONObject jSONObject, com.youku.arch.ntk.a.f fVar) {
        IpChange ipChange = $ipChange;
        int i = 3;
        if (AndroidInstantRuntime.support(ipChange, "-267580349")) {
            ipChange.ipc$dispatch("-267580349", new Object[]{this, gVar, jSONObject, fVar});
            return;
        }
        com.youku.b.a.a.a("ntk_implementer", "do dnsInfer");
        C0366b c0366b = (C0366b) JSON.toJavaObject(jSONObject, C0366b.class);
        if (c0366b != null) {
            if (c0366b.b == 1 || TextUtils.isEmpty(c0366b.a)) {
                c0366b.a = BaseMonitor.COUNT_POINT_DNS + (new Date().getTime() % 1024) + ".debug.danuoyi.alicdn.com";
            }
            NtkWrapper a2 = NtkWrapper.a();
            String str = c0366b.a;
            int i2 = c0366b.c;
            if (i2 > 0) {
                i = i2;
            }
            a2.inspect_dns(gVar, str, i);
        }
    }
}
