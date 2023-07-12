package com.alibaba.analytics.core.sync;

import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.utils.Logger;
import com.alibaba.fastjson.JSON;
import com.alimm.xadsdk.base.ut.AdUtConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.bt2;
import tb.ea2;
import tb.fa2;
import tb.qa1;
import tb.qo2;
import tb.tc;
import tb.to2;

/* compiled from: Taobao */
/* renamed from: com.alibaba.analytics.core.sync.e */
/* loaded from: classes5.dex */
public class C3133e extends UploadLog {
    private static C3133e k;
    public final fa2 d = new fa2();
    private int e = 0;
    private boolean f = false;
    private int g = 0;
    private volatile boolean h = false;
    private List<qa1> i = new ArrayList();
    private List<qa1> j = new ArrayList();

    private Map<String, String> g() {
        int i;
        if (this.i.size() == 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            this.j.clear();
            int f = bt2.g().f() * 1000;
            long currentTimeMillis = System.currentTimeMillis();
            i = 0;
            for (int i2 = 0; i2 < this.i.size(); i2++) {
                qa1 qa1Var = this.i.get(i2);
                if (currentTimeMillis - Long.parseLong(qa1Var.d) > f) {
                    arrayList.add(qa1Var);
                } else {
                    this.j.add(qa1Var);
                    StringBuilder sb = (StringBuilder) hashMap.get("" + qa1Var.c());
                    if (sb == null) {
                        sb = new StringBuilder();
                        hashMap.put("" + qa1Var.c(), sb);
                    } else {
                        sb.append((char) 1);
                        i++;
                    }
                    String b = this.i.get(i2).b();
                    sb.append(b);
                    i += b.length();
                }
            }
            if (!arrayList.isEmpty()) {
                if (Variables.n().O()) {
                    this.d.onEvent(ea2.a(ea2.s, null, Double.valueOf(arrayList.size())));
                }
                this.i.removeAll(arrayList);
            }
        }
        HashMap hashMap2 = new HashMap();
        this.e = i;
        for (String str : hashMap.keySet()) {
            hashMap2.put(str, ((StringBuilder) hashMap.get(str)).toString());
        }
        if (Logger.n()) {
            Logger.f("", "mUploadByteSize", Integer.valueOf(this.e), AdUtConstants.XAD_UT_ARG_COUNT, Integer.valueOf(this.j.size()), "timeoutLogs count", Integer.valueOf(arrayList.size()));
        }
        return hashMap2;
    }

    public static C3133e h() {
        if (k == null) {
            synchronized (C3133e.class) {
                if (k == null) {
                    k = new C3133e();
                }
            }
        }
        return k;
    }

    private void i() {
        synchronized (this) {
            this.i.removeAll(this.j);
            this.j.clear();
        }
    }

    private boolean k() throws Exception {
        byte[] bArr;
        Logger.d();
        Map<String, String> g = g();
        if (g != null && g.size() != 0) {
            try {
                bArr = C3127a.f(g);
            } catch (Exception e) {
                Logger.h(null, e, new Object[0]);
                bArr = null;
            }
            if (bArr == null) {
                Logger.f("", "packRequest is null");
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (C3130d.w()) {
                qo2 e2 = C3129c.b().e();
                Logger.f("UploadLogFromCache", "CreateSession tnet host", e2.a(), "port", Integer.valueOf(e2.b()), "type", Integer.valueOf(e2.d()));
                if (e2.d() == 1) {
                    to2.b().g(true);
                } else {
                    to2.b().g(false);
                }
            }
            tc v = C3130d.v(bArr);
            boolean a = v.a();
            if (a) {
                Variables.n().t0();
                this.f = true;
                this.g = 0;
                i();
                try {
                    b(v.e);
                } catch (Exception e3) {
                    Logger.f(null, e3);
                }
            } else {
                this.g++;
                if (Variables.n().J()) {
                    return true;
                }
                if (Variables.n().O() && this.f && this.g <= 10) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("rt", String.valueOf(v.c));
                    hashMap.put("pSize", String.valueOf(this.e));
                    hashMap.put("errCode", String.valueOf(v.a));
                    hashMap.put("type", "2");
                    this.d.onEvent(ea2.a(ea2.j, JSON.toJSONString(hashMap), Double.valueOf(1.0d)));
                }
            }
            if (Logger.n()) {
                Logger.f("", "isSendSuccess", Boolean.valueOf(a), "cost time", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            }
            try {
                Thread.sleep(100L);
            } catch (Throwable th) {
                Logger.v(null, "thread sleep interrupted", th);
            }
            return false;
        }
        this.h = false;
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0050, code lost:
        r4.h = false;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void l() {
        /*
            r4 = this;
            com.alibaba.analytics.utils.Logger.d()
            com.alibaba.analytics.core.Variables r0 = com.alibaba.analytics.core.Variables.n()
            android.content.Context r0 = r0.j()
            boolean r0 = com.alibaba.analytics.core.network.NetworkUtil.m(r0)
            if (r0 != 0) goto L12
            return
        L12:
            com.alibaba.analytics.core.sync.UploadLog$NetworkStatus r0 = com.alibaba.analytics.core.sync.UploadLog.NetworkStatus.ALL
            com.alibaba.analytics.core.sync.UploadLog$NetworkStatus r1 = r4.c
            r2 = 1
            r3 = 0
            if (r0 == r1) goto L3d
            com.alibaba.analytics.core.sync.UploadLog$NetworkStatus r0 = r4.a()
            if (r1 == r0) goto L3d
            r0 = 4
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r1 = "current networkstatus"
            r0[r3] = r1
            com.alibaba.analytics.core.sync.UploadLog$NetworkStatus r1 = r4.a()
            r0[r2] = r1
            r1 = 2
            java.lang.String r2 = "mAllowedNetworkStatus"
            r0[r1] = r2
            r1 = 3
            com.alibaba.analytics.core.sync.UploadLog$NetworkStatus r2 = r4.c
            r0[r1] = r2
            java.lang.String r1 = "network not match,return"
            com.alibaba.analytics.utils.Logger.v(r1, r0)
            return
        L3d:
            boolean r0 = r4.h
            if (r0 != 0) goto L6d
            r4.h = r2
            r0 = 0
        L44:
            int r1 = r4.a     // Catch: java.lang.Throwable -> L60
            if (r0 >= r1) goto L5d
            java.util.List<tb.qa1> r1 = r4.i     // Catch: java.lang.Throwable -> L60
            int r1 = r1.size()     // Catch: java.lang.Throwable -> L60
            if (r1 != 0) goto L53
            r4.h = r3     // Catch: java.lang.Throwable -> L60
            goto L5d
        L53:
            boolean r1 = r4.k()     // Catch: java.lang.Throwable -> L60
            if (r1 == 0) goto L5a
            goto L5d
        L5a:
            int r0 = r0 + 1
            goto L44
        L5d:
            r4.h = r3
            goto L68
        L60:
            r0 = move-exception
            r1 = 0
            java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L69
            com.alibaba.analytics.utils.Logger.h(r1, r0, r2)     // Catch: java.lang.Throwable -> L69
            goto L5d
        L68:
            return
        L69:
            r0 = move-exception
            r4.h = r3
            throw r0
        L6d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.analytics.core.sync.C3133e.l():void");
    }

    public void f(qa1 qa1Var) {
        synchronized (this) {
            if (this.i.size() >= 300) {
                for (int i = 99; i >= 0; i--) {
                    this.i.remove(i);
                }
            }
            this.i.add(qa1Var);
        }
        UploadQueueMgr.getInstance().add(UploadQueueMgr.MSGTYPE_REALTIME);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        Logger.d();
        try {
            if (bt2.g().j()) {
                return;
            }
            l();
        } catch (Throwable th) {
            Logger.h(null, th, new Object[0]);
        }
    }
}
