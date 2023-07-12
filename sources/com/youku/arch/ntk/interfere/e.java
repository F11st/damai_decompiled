package com.youku.arch.ntk.interfere;

import android.content.Context;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.baseproject.utils.speedtest.a;
import com.baseproject.utils.speedtest.j;
import com.taobao.tlog.adapter.AdapterForTLog;
import com.youku.arch.ntk.a.h;
import com.youku.arch.ntk.a.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import tb.q43;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class e {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String a = "e";
    private volatile boolean c;
    private com.youku.arch.ntk.interfere.a d;
    private ExecutorService b = Executors.newSingleThreadExecutor();
    private String[] e = new String[3];

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public class a {
        int a;
        int b;
        String c;
        String d;
        int e;

        a() {
        }
    }

    private e() {
    }

    private int a(c cVar) {
        a.C0218a[] c0218aArr;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1045103054")) {
            return ((Integer) ipChange.ipc$dispatch("1045103054", new Object[]{this, cVar})).intValue();
        }
        j.a aVar = new j.a();
        q43 q43Var = new q43();
        aVar.a = q43Var;
        h hVar = cVar.f;
        q43Var.a = hVar.a;
        q43Var.j = hVar.j;
        q43Var.q = hVar.q;
        q43Var.b = hVar.b;
        q43Var.t = hVar.t;
        q43Var.s = hVar.s;
        q43Var.o = hVar.o;
        q43Var.f = hVar.f;
        q43Var.c = hVar.c;
        q43Var.d = hVar.d;
        q43Var.l = hVar.l;
        q43Var.m = hVar.m;
        q43Var.r = hVar.r;
        q43Var.i = hVar.i;
        q43Var.n = hVar.n;
        q43Var.h = hVar.h;
        q43Var.p = hVar.p;
        q43Var.g = hVar.g;
        q43Var.e = hVar.e;
        q43Var.k = hVar.k;
        int a2 = new com.baseproject.utils.speedtest.b().a(null, aVar);
        if (a2 >= 0) {
            com.baseproject.utils.speedtest.a aVar2 = aVar.b;
            if (aVar2 == null || (c0218aArr = aVar2.d) == null) {
                a2 = -99;
            } else {
                for (a.C0218a c0218a : c0218aArr) {
                    if (c0218a.a.contains("myqcloud.com")) {
                        this.e[2] = c0218a.a;
                    } else if (c0218a.a.contains("bcebos.com")) {
                        this.e[1] = c0218a.a;
                    } else {
                        this.e[0] = c0218a.a;
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

    private a a(com.youku.arch.ntk.a.j jVar) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "226118610")) {
            return (a) ipChange.ipc$dispatch("226118610", new Object[]{this, jVar});
        }
        a aVar = null;
        if (jVar != null && jVar.a != null) {
            aVar = new a();
            aVar.e = 0;
            aVar.a = 0;
            aVar.b = 99999;
            while (true) {
                com.youku.arch.ntk.a.d[] dVarArr = jVar.a;
                if (i >= dVarArr.length) {
                    break;
                }
                int parseInt = Integer.parseInt(dVarArr[i].b);
                if (parseInt > 0) {
                    aVar.e++;
                    if (parseInt > aVar.a) {
                        aVar.a = parseInt;
                        aVar.d = jVar.a[i].a;
                    }
                    if (parseInt < aVar.b) {
                        aVar.b = parseInt;
                        aVar.c = jVar.a[i].a;
                    }
                }
                i++;
            }
        }
        return aVar;
    }

    private void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "454749983")) {
            ipChange.ipc$dispatch("454749983", new Object[]{this});
            return;
        }
        com.youku.arch.ntk.interfere.a aVar = this.d;
        if (aVar == null || aVar.a == null) {
            return;
        }
        d dVar = new d();
        com.youku.arch.ntk.interfere.a aVar2 = this.d;
        dVar.a = aVar2.b;
        c cVar = aVar2.a;
        dVar.e = cVar.a;
        dVar.k = aVar2.h;
        dVar.j = aVar2.g;
        String[] strArr = cVar.d;
        if (strArr != null && strArr.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (String str : this.d.a.d) {
                sb.append(str);
                sb.append(",");
            }
            dVar.h = sb.toString();
        }
        com.youku.arch.ntk.interfere.a aVar3 = this.d;
        dVar.c = aVar3.f;
        dVar.b = aVar3.e;
        c cVar2 = aVar3.a;
        dVar.f = cVar2.b;
        String[] strArr2 = cVar2.c;
        if (strArr2 != null && strArr2.length > 0) {
            StringBuilder sb2 = new StringBuilder();
            for (String str2 : this.d.a.c) {
                sb2.append(str2);
                sb2.append(",");
            }
            dVar.g = sb2.toString();
        }
        dVar.i = this.d.a.e ? "1" : "0";
        f.a(dVar);
    }

    private void a(b bVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1045073276")) {
            ipChange.ipc$dispatch("1045073276", new Object[]{this, bVar});
            return;
        }
        AdapterForTLog.loge("SpeedTest", "doAsyncAnalyze finish");
        if (bVar != null) {
            bVar.a(this.d);
        }
        if (this.d.d.isEmpty()) {
            return;
        }
        com.youku.arch.ntk.a.g gVar = this.d.d.get(0);
        for (int i = 1; i < this.d.d.size(); i++) {
            com.youku.arch.ntk.a.g gVar2 = this.d.d.get(i);
            com.youku.arch.ntk.a.j[] jVarArr = gVar2.b;
            if (jVarArr != null) {
                if (gVar.b != null) {
                    ArrayList arrayList = new ArrayList(Arrays.asList(gVar.b));
                    arrayList.addAll(Arrays.asList(gVar2.b));
                    gVar.b = (com.youku.arch.ntk.a.j[]) arrayList.toArray(new com.youku.arch.ntk.a.j[0]);
                } else {
                    gVar.b = jVarArr;
                }
            }
            List<k> list = gVar2.d;
            if (list != null) {
                List<k> list2 = gVar.d;
                if (list2 != null) {
                    list2.addAll(list);
                } else {
                    gVar.b = gVar2.b;
                }
            }
        }
        h hVar = this.d.a.f;
        if (hVar != null) {
            gVar.h = hVar.u;
            gVar.e = hVar.e;
            gVar.g = hVar.v;
            gVar.f = hVar.w;
            gVar.s = "impairmentAnalyze";
            gVar.j = hVar.t;
            gVar.n = hVar.j;
            gVar.p = hVar.o;
            gVar.k = hVar.c;
            gVar.l = hVar.d;
            gVar.r = hVar.l;
            gVar.m = hVar.i;
            gVar.o = hVar.n;
            gVar.q = hVar.h;
        }
        com.youku.arch.ntk.b.b().a(this.d.a.f, gVar);
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar, b bVar) {
        Context context;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "924889144")) {
            ipChange.ipc$dispatch("924889144", new Object[]{this, cVar, bVar});
            return;
        }
        AdapterForTLog.loge("SpeedTest", "doAsyncAnalyze start");
        com.youku.arch.ntk.interfere.a aVar = new com.youku.arch.ntk.interfere.a();
        this.d = aVar;
        if (cVar == null) {
            aVar.b = -1;
            aVar.c = "ntk analyze inputParam is null";
            a(bVar);
            return;
        }
        aVar.a = cVar;
        h hVar = cVar.f;
        if (hVar != null && (context = hVar.a) != null) {
            com.youku.b.a.a.a(context);
        }
        int a2 = a(cVar);
        if (a2 >= 0) {
            if (cVar.e) {
                c(cVar, bVar);
            } else {
                b(cVar, bVar);
            }
            a(bVar);
            return;
        }
        com.youku.arch.ntk.interfere.a aVar2 = this.d;
        aVar2.b = -2;
        aVar2.c = "" + a2;
        a(bVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01d6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(com.youku.arch.ntk.interfere.c r18, com.youku.arch.ntk.interfere.b r19) {
        /*
            Method dump skipped, instructions count: 604
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.arch.ntk.interfere.e.b(com.youku.arch.ntk.interfere.c, com.youku.arch.ntk.interfere.b):void");
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
    private void c(com.youku.arch.ntk.interfere.c r13, com.youku.arch.ntk.interfere.b r14) {
        /*
            Method dump skipped, instructions count: 321
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.arch.ntk.interfere.e.c(com.youku.arch.ntk.interfere.c, com.youku.arch.ntk.interfere.b):void");
    }
}
