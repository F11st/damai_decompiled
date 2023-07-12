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

/* compiled from: Taobao */
/* renamed from: com.youku.arch.ntk.b.d */
/* loaded from: classes2.dex */
public class C7848d extends AbstractC7841a {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* renamed from: com.youku.arch.ntk.b.d$a */
    /* loaded from: classes2.dex */
    public static class C7849a {
        @JSONField(name = "type")
        public int a;
        @JSONField(name = "domain")
        public String b;
    }

    /* compiled from: Taobao */
    /* renamed from: com.youku.arch.ntk.b.d$b */
    /* loaded from: classes2.dex */
    private static class C7850b {
        private static final C7848d a = new C7848d();
    }

    /* compiled from: Taobao */
    /* renamed from: com.youku.arch.ntk.b.d$c */
    /* loaded from: classes2.dex */
    public static class C7851c {
        @JSONField(name = "domain")
        public String a;
        @JSONField(name = RemoteMessageConst.INPUT_TYPE)
        public int b;
        @JSONField(name = "time")
        public int c;
        @JSONField(name = BaseMonitor.COUNT_POINT_DNS)
        public C7849a[] d;
    }

    private C7848d() {
    }

    public static C7848d a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-742223823") ? (C7848d) ipChange.ipc$dispatch("-742223823", new Object[0]) : C7850b.a;
    }

    public void a(C7833g c7833g, JSONObject jSONObject, C7832f c7832f) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-1038313915")) {
            ipChange.ipc$dispatch("-1038313915", new Object[]{this, c7833g, jSONObject, c7832f});
            return;
        }
        C7892a.a("ntk_implementer", "do DnsResolve");
        C7851c c7851c = (C7851c) JSON.toJavaObject(jSONObject, C7851c.class);
        if (c7851c != null) {
            if (c7851c.b == 1 || TextUtils.isEmpty(c7851c.a)) {
                if (TextUtils.isEmpty(c7832f.b.x)) {
                    C7892a.b("ntk_implementer", "empty resolve domain, stop.");
                    return;
                }
                c7851c.a = c7832f.b.x;
            }
            C7849a[] c7849aArr = c7851c.d;
            int[] iArr = new int[c7849aArr.length];
            String[] strArr = new String[c7849aArr.length];
            while (true) {
                C7849a[] c7849aArr2 = c7851c.d;
                if (i >= c7849aArr2.length) {
                    break;
                }
                iArr[i] = c7849aArr2[i].a;
                strArr[i] = c7849aArr2[i].b;
                i++;
            }
            NtkWrapper a = NtkWrapper.a();
            String str = c7851c.a;
            int i2 = c7851c.c;
            a.inspect_resolve(c7833g, str, strArr, iArr, i2 < 0 ? 200 : i2);
        }
    }
}
