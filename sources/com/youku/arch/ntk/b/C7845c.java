package com.youku.arch.ntk.b;

import com.alibaba.fastjson.annotation.JSONField;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.huawei.hms.push.constant.RemoteMessageConst;

/* compiled from: Taobao */
/* renamed from: com.youku.arch.ntk.b.c */
/* loaded from: classes2.dex */
public class C7845c extends AbstractC7841a {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* renamed from: com.youku.arch.ntk.b.c$a */
    /* loaded from: classes2.dex */
    private static class C7846a {
        private static final C7845c a = new C7845c();
    }

    /* compiled from: Taobao */
    /* renamed from: com.youku.arch.ntk.b.c$b */
    /* loaded from: classes2.dex */
    public static class C7847b {
        @JSONField(name = "domain")
        public String a;
        @JSONField(name = RemoteMessageConst.INPUT_TYPE)
        public int b;
        @JSONField(name = "time")
        public int c;
        @JSONField(name = "ips")
        public String[] d;
    }

    private C7845c() {
    }

    public static C7845c a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1093023791") ? (C7845c) ipChange.ipc$dispatch("-1093023791", new Object[0]) : C7846a.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00e5 A[Catch: Exception -> 0x0110, LOOP:1: B:50:0x00df->B:52:0x00e5, LOOP_END, TryCatch #0 {Exception -> 0x0110, blocks: (B:17:0x0058, B:20:0x0068, B:24:0x006e, B:26:0x0073, B:28:0x0082, B:30:0x0089, B:29:0x0086, B:49:0x00d8, B:50:0x00df, B:52:0x00e5, B:53:0x00f4, B:31:0x008c, B:33:0x0094, B:36:0x009b, B:37:0x009f, B:39:0x00a5, B:41:0x00b1, B:43:0x00b9, B:45:0x00c3, B:47:0x00d0, B:48:0x00d4, B:54:0x010a), top: B:59:0x0058 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.youku.arch.ntk.a.C7833g r11, com.alibaba.fastjson.JSONObject r12, com.youku.arch.ntk.a.C7832f r13) {
        /*
            Method dump skipped, instructions count: 277
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.arch.ntk.b.C7845c.a(com.youku.arch.ntk.a.g, com.alibaba.fastjson.JSONObject, com.youku.arch.ntk.a.f):void");
    }
}
