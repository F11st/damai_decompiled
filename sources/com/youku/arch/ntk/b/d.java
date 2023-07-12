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

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class d extends com.youku.arch.ntk.b.a {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class a {
        @JSONField(name = "type")
        public int a;
        @JSONField(name = "domain")
        public String b;
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    private static class b {
        private static final d a = new d();
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class c {
        @JSONField(name = "domain")
        public String a;
        @JSONField(name = RemoteMessageConst.INPUT_TYPE)
        public int b;
        @JSONField(name = "time")
        public int c;
        @JSONField(name = BaseMonitor.COUNT_POINT_DNS)
        public a[] d;
    }

    private d() {
    }

    public static d a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-742223823") ? (d) ipChange.ipc$dispatch("-742223823", new Object[0]) : b.a;
    }

    public void a(g gVar, JSONObject jSONObject, com.youku.arch.ntk.a.f fVar) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-1038313915")) {
            ipChange.ipc$dispatch("-1038313915", new Object[]{this, gVar, jSONObject, fVar});
            return;
        }
        com.youku.b.a.a.a("ntk_implementer", "do DnsResolve");
        c cVar = (c) JSON.toJavaObject(jSONObject, c.class);
        if (cVar != null) {
            if (cVar.b == 1 || TextUtils.isEmpty(cVar.a)) {
                if (TextUtils.isEmpty(fVar.b.x)) {
                    com.youku.b.a.a.b("ntk_implementer", "empty resolve domain, stop.");
                    return;
                }
                cVar.a = fVar.b.x;
            }
            a[] aVarArr = cVar.d;
            int[] iArr = new int[aVarArr.length];
            String[] strArr = new String[aVarArr.length];
            while (true) {
                a[] aVarArr2 = cVar.d;
                if (i >= aVarArr2.length) {
                    break;
                }
                iArr[i] = aVarArr2[i].a;
                strArr[i] = aVarArr2[i].b;
                i++;
            }
            NtkWrapper a2 = NtkWrapper.a();
            String str = cVar.a;
            int i2 = cVar.c;
            a2.inspect_resolve(gVar, str, strArr, iArr, i2 < 0 ? 200 : i2);
        }
    }
}
