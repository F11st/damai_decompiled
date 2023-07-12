package com.youku.arch.ntk.interfere;

import android.content.Context;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.baseproject.utils.speedtest.C4666a;
import com.baseproject.utils.speedtest.C4668b;
import com.baseproject.utils.speedtest.C4673j;
import com.taobao.tlog.adapter.AdapterForTLog;
import com.youku.arch.ntk.C7839b;
import com.youku.arch.ntk.a.C7830d;
import com.youku.arch.ntk.a.C7833g;
import com.youku.arch.ntk.a.C7834h;
import com.youku.arch.ntk.a.C7836j;
import com.youku.arch.ntk.a.C7837k;
import com.youku.b.a.C7892a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import tb.q43;

/* compiled from: Taobao */
/* renamed from: com.youku.arch.ntk.interfere.e */
/* loaded from: classes2.dex */
public class C7865e {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String a = "e";
    private volatile boolean c;
    private C7861a d;
    private ExecutorService b = Executors.newSingleThreadExecutor();
    private String[] e = new String[3];

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.youku.arch.ntk.interfere.e$a */
    /* loaded from: classes2.dex */
    public class C7866a {
        int a;
        int b;
        String c;
        String d;
        int e;

        C7866a() {
        }
    }

    private C7865e() {
    }

    private int a(C7863c c7863c) {
        C4666a.C4667a[] c4667aArr;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1045103054")) {
            return ((Integer) ipChange.ipc$dispatch("1045103054", new Object[]{this, c7863c})).intValue();
        }
        C4673j.C4674a c4674a = new C4673j.C4674a();
        q43 q43Var = new q43();
        c4674a.a = q43Var;
        C7834h c7834h = c7863c.f;
        q43Var.a = c7834h.a;
        q43Var.j = c7834h.j;
        q43Var.q = c7834h.q;
        q43Var.b = c7834h.b;
        q43Var.t = c7834h.t;
        q43Var.s = c7834h.s;
        q43Var.o = c7834h.o;
        q43Var.f = c7834h.f;
        q43Var.c = c7834h.c;
        q43Var.d = c7834h.d;
        q43Var.l = c7834h.l;
        q43Var.m = c7834h.m;
        q43Var.r = c7834h.r;
        q43Var.i = c7834h.i;
        q43Var.n = c7834h.n;
        q43Var.h = c7834h.h;
        q43Var.p = c7834h.p;
        q43Var.g = c7834h.g;
        q43Var.e = c7834h.e;
        q43Var.k = c7834h.k;
        int a2 = new C4668b().a(null, c4674a);
        if (a2 >= 0) {
            C4666a c4666a = c4674a.b;
            if (c4666a == null || (c4667aArr = c4666a.d) == null) {
                a2 = -99;
            } else {
                for (C4666a.C4667a c4667a : c4667aArr) {
                    if (c4667a.a.contains("myqcloud.com")) {
                        this.e[2] = c4667a.a;
                    } else if (c4667a.a.contains("bcebos.com")) {
                        this.e[1] = c4667a.a;
                    } else {
                        this.e[0] = c4667a.a;
                    }
                }
            }
            if (this.e[0] == null) {
                return -98;
            }
            return a2;
        }
        return a2;
    }

    private C7866a a(C7836j c7836j) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "226118610")) {
            return (C7866a) ipChange.ipc$dispatch("226118610", new Object[]{this, c7836j});
        }
        C7866a c7866a = null;
        if (c7836j != null && c7836j.a != null) {
            c7866a = new C7866a();
            c7866a.e = 0;
            c7866a.a = 0;
            c7866a.b = 99999;
            while (true) {
                C7830d[] c7830dArr = c7836j.a;
                if (i >= c7830dArr.length) {
                    break;
                }
                int parseInt = Integer.parseInt(c7830dArr[i].b);
                if (parseInt > 0) {
                    c7866a.e++;
                    if (parseInt > c7866a.a) {
                        c7866a.a = parseInt;
                        c7866a.d = c7836j.a[i].a;
                    }
                    if (parseInt < c7866a.b) {
                        c7866a.b = parseInt;
                        c7866a.c = c7836j.a[i].a;
                    }
                }
                i++;
            }
        }
        return c7866a;
    }

    private void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "454749983")) {
            ipChange.ipc$dispatch("454749983", new Object[]{this});
            return;
        }
        C7861a c7861a = this.d;
        if (c7861a == null || c7861a.a == null) {
            return;
        }
        C7864d c7864d = new C7864d();
        C7861a c7861a2 = this.d;
        c7864d.a = c7861a2.b;
        C7863c c7863c = c7861a2.a;
        c7864d.e = c7863c.a;
        c7864d.k = c7861a2.h;
        c7864d.j = c7861a2.g;
        String[] strArr = c7863c.d;
        if (strArr != null && strArr.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (String str : this.d.a.d) {
                sb.append(str);
                sb.append(",");
            }
            c7864d.h = sb.toString();
        }
        C7861a c7861a3 = this.d;
        c7864d.c = c7861a3.f;
        c7864d.b = c7861a3.e;
        C7863c c7863c2 = c7861a3.a;
        c7864d.f = c7863c2.b;
        String[] strArr2 = c7863c2.c;
        if (strArr2 != null && strArr2.length > 0) {
            StringBuilder sb2 = new StringBuilder();
            for (String str2 : this.d.a.c) {
                sb2.append(str2);
                sb2.append(",");
            }
            c7864d.g = sb2.toString();
        }
        c7864d.i = this.d.a.e ? "1" : "0";
        C7867f.a(c7864d);
    }

    private void a(InterfaceC7862b interfaceC7862b) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1045073276")) {
            ipChange.ipc$dispatch("1045073276", new Object[]{this, interfaceC7862b});
            return;
        }
        AdapterForTLog.loge("SpeedTest", "doAsyncAnalyze finish");
        if (interfaceC7862b != null) {
            interfaceC7862b.a(this.d);
        }
        if (this.d.d.isEmpty()) {
            return;
        }
        C7833g c7833g = this.d.d.get(0);
        for (int i = 1; i < this.d.d.size(); i++) {
            C7833g c7833g2 = this.d.d.get(i);
            C7836j[] c7836jArr = c7833g2.b;
            if (c7836jArr != null) {
                if (c7833g.b != null) {
                    ArrayList arrayList = new ArrayList(Arrays.asList(c7833g.b));
                    arrayList.addAll(Arrays.asList(c7833g2.b));
                    c7833g.b = (C7836j[]) arrayList.toArray(new C7836j[0]);
                } else {
                    c7833g.b = c7836jArr;
                }
            }
            List<C7837k> list = c7833g2.d;
            if (list != null) {
                List<C7837k> list2 = c7833g.d;
                if (list2 != null) {
                    list2.addAll(list);
                } else {
                    c7833g.b = c7833g2.b;
                }
            }
        }
        C7834h c7834h = this.d.a.f;
        if (c7834h != null) {
            c7833g.h = c7834h.u;
            c7833g.e = c7834h.e;
            c7833g.g = c7834h.v;
            c7833g.f = c7834h.w;
            c7833g.s = "impairmentAnalyze";
            c7833g.j = c7834h.t;
            c7833g.n = c7834h.j;
            c7833g.p = c7834h.o;
            c7833g.k = c7834h.c;
            c7833g.l = c7834h.d;
            c7833g.r = c7834h.l;
            c7833g.m = c7834h.i;
            c7833g.o = c7834h.n;
            c7833g.q = c7834h.h;
        }
        C7839b.b().a(this.d.a.f, c7833g);
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(C7863c c7863c, InterfaceC7862b interfaceC7862b) {
        Context context;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "924889144")) {
            ipChange.ipc$dispatch("924889144", new Object[]{this, c7863c, interfaceC7862b});
            return;
        }
        AdapterForTLog.loge("SpeedTest", "doAsyncAnalyze start");
        C7861a c7861a = new C7861a();
        this.d = c7861a;
        if (c7863c == null) {
            c7861a.b = -1;
            c7861a.c = "ntk analyze inputParam is null";
            a(interfaceC7862b);
            return;
        }
        c7861a.a = c7863c;
        C7834h c7834h = c7863c.f;
        if (c7834h != null && (context = c7834h.a) != null) {
            C7892a.a(context);
        }
        int a2 = a(c7863c);
        if (a2 >= 0) {
            if (c7863c.e) {
                c(c7863c, interfaceC7862b);
            } else {
                b(c7863c, interfaceC7862b);
            }
            a(interfaceC7862b);
            return;
        }
        C7861a c7861a2 = this.d;
        c7861a2.b = -2;
        c7861a2.c = "" + a2;
        a(interfaceC7862b);
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01d6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(com.youku.arch.ntk.interfere.C7863c r18, com.youku.arch.ntk.interfere.InterfaceC7862b r19) {
        /*
            Method dump skipped, instructions count: 604
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.arch.ntk.interfere.C7865e.b(com.youku.arch.ntk.interfere.c, com.youku.arch.ntk.interfere.b):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x008a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void c(com.youku.arch.ntk.interfere.C7863c r13, com.youku.arch.ntk.interfere.InterfaceC7862b r14) {
        /*
            Method dump skipped, instructions count: 321
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.arch.ntk.interfere.C7865e.c(com.youku.arch.ntk.interfere.c, com.youku.arch.ntk.interfere.b):void");
    }
}
