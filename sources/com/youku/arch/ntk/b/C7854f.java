package com.youku.arch.ntk.b;

import com.alibaba.fastjson.annotation.JSONField;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.taobao.tao.log.TLogConstant;
import com.youku.arch.ntk.a.C7830d;
import com.youku.arch.ntk.a.C7833g;
import com.youku.arch.ntk.a.C7836j;

/* compiled from: Taobao */
/* renamed from: com.youku.arch.ntk.b.f */
/* loaded from: classes2.dex */
public class C7854f extends AbstractC7841a {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* renamed from: com.youku.arch.ntk.b.f$a */
    /* loaded from: classes2.dex */
    public static class C7855a {
        @JSONField(name = "type")
        public int a;
        @JSONField(name = "domain")
        public String b;
        @JSONField(name = RemoteMessageConst.INPUT_TYPE)
        public int c;
        @JSONField(name = TLogConstant.PERSIST_TASK_ID)
        public String d;
        @JSONField(name = "maxHopNum")
        public int e;
        @JSONField(name = "time")
        public int f;
    }

    /* compiled from: Taobao */
    /* renamed from: com.youku.arch.ntk.b.f$b */
    /* loaded from: classes2.dex */
    private static class C7856b {
        private static final C7854f a = new C7854f();
    }

    private C7854f() {
    }

    public static C7854f a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-40623887") ? (C7854f) ipChange.ipc$dispatch("-40623887", new Object[0]) : C7856b.a;
    }

    private String a(C7833g c7833g) {
        C7836j[] c7836jArr;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1832145809")) {
            return (String) ipChange.ipc$dispatch("1832145809", new Object[]{this, c7833g});
        }
        String str = null;
        int i = 65535;
        if (c7833g != null && (c7836jArr = c7833g.b) != null) {
            for (C7836j c7836j : c7836jArr) {
                C7830d[] c7830dArr = c7836j.a;
                if (c7830dArr != null) {
                    for (C7830d c7830d : c7830dArr) {
                        try {
                            if (Integer.parseInt(c7830d.b) > 0 && Integer.parseInt(c7830d.b) < i) {
                                i = Integer.parseInt(c7830d.b);
                                str = c7830d.a;
                            }
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return str;
    }

    private String b(C7833g c7833g) {
        C7836j[] c7836jArr;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "131405330")) {
            return (String) ipChange.ipc$dispatch("131405330", new Object[]{this, c7833g});
        }
        String str = null;
        if (c7833g != null && (c7836jArr = c7833g.b) != null) {
            int i = 0;
            for (C7836j c7836j : c7836jArr) {
                C7830d[] c7830dArr = c7836j.a;
                if (c7830dArr != null) {
                    for (C7830d c7830d : c7830dArr) {
                        try {
                            if (Integer.parseInt(c7830d.b) > 0 && Integer.parseInt(c7830d.b) > i) {
                                i = Integer.parseInt(c7830d.b);
                                str = c7830d.a;
                            }
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004a A[Catch: all -> 0x0059, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x000d, B:8:0x0021, B:10:0x0034, B:11:0x0038, B:14:0x0042, B:16:0x004a, B:13:0x003d), top: B:22:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void a(com.youku.arch.ntk.a.C7833g r7, com.alibaba.fastjson.JSONObject r8, com.youku.arch.ntk.a.C7832f r9) {
        /*
            r6 = this;
            monitor-enter(r6)
            com.android.alibaba.ip.runtime.IpChange r0 = com.youku.arch.ntk.b.C7854f.$ipChange     // Catch: java.lang.Throwable -> L59
            java.lang.String r1 = "-1809047481"
            boolean r1 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)     // Catch: java.lang.Throwable -> L59
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L21
            java.lang.String r1 = "-1809047481"
            r4 = 4
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L59
            r5 = 0
            r4[r5] = r6     // Catch: java.lang.Throwable -> L59
            r4[r3] = r7     // Catch: java.lang.Throwable -> L59
            r4[r2] = r8     // Catch: java.lang.Throwable -> L59
            r7 = 3
            r4[r7] = r9     // Catch: java.lang.Throwable -> L59
            r0.ipc$dispatch(r1, r4)     // Catch: java.lang.Throwable -> L59
            monitor-exit(r6)
            return
        L21:
            java.lang.String r9 = "ntk_implementer"
            java.lang.String r0 = "do trace"
            com.youku.b.a.C7892a.a(r9, r0)     // Catch: java.lang.Throwable -> L59
            java.lang.Class<com.youku.arch.ntk.b.f$a> r9 = com.youku.arch.ntk.b.C7854f.C7855a.class
            java.lang.Object r8 = com.alibaba.fastjson.JSON.toJavaObject(r8, r9)     // Catch: java.lang.Throwable -> L59
            com.youku.arch.ntk.b.f$a r8 = (com.youku.arch.ntk.b.C7854f.C7855a) r8     // Catch: java.lang.Throwable -> L59
            int r9 = r8.c     // Catch: java.lang.Throwable -> L59
            if (r9 != r3) goto L3b
            java.lang.String r9 = r6.a(r7)     // Catch: java.lang.Throwable -> L59
        L38:
            r8.b = r9     // Catch: java.lang.Throwable -> L59
            goto L42
        L3b:
            if (r9 != r2) goto L42
            java.lang.String r9 = r6.b(r7)     // Catch: java.lang.Throwable -> L59
            goto L38
        L42:
            java.lang.String r9 = r8.b     // Catch: java.lang.Throwable -> L59
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch: java.lang.Throwable -> L59
            if (r9 != 0) goto L57
            com.youku.arch.ntk.NtkWrapper r9 = com.youku.arch.ntk.NtkWrapper.a()     // Catch: java.lang.Throwable -> L59
            java.lang.String r0 = r8.b     // Catch: java.lang.Throwable -> L59
            int r1 = r8.e     // Catch: java.lang.Throwable -> L59
            int r8 = r8.f     // Catch: java.lang.Throwable -> L59
            r9.inspect_trace(r7, r0, r1, r8)     // Catch: java.lang.Throwable -> L59
        L57:
            monitor-exit(r6)
            return
        L59:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.arch.ntk.b.C7854f.a(com.youku.arch.ntk.a.g, com.alibaba.fastjson.JSONObject, com.youku.arch.ntk.a.f):void");
    }
}
