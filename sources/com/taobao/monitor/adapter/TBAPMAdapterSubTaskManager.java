package com.taobao.monitor.adapter;

import android.os.Looper;
import android.os.SystemClock;
import com.taobao.monitor.procedure.C6817d;
import com.taobao.monitor.procedure.IProcedure;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import tb.ho2;
import tb.tu1;
import tb.uu1;
import tb.wu1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class TBAPMAdapterSubTaskManager {
    private static Map<String, C6755a> a = new HashMap();
    private static Map<String, IProcedure> b = new HashMap();
    private static boolean c = true;

    /* compiled from: Taobao */
    /* renamed from: com.taobao.monitor.adapter.TBAPMAdapterSubTaskManager$a */
    /* loaded from: classes11.dex */
    private static class C6755a {
        private long a;
        private long b;
        private long c;
        private long d;
        private boolean e;
        private String f;

        private C6755a() {
        }
    }

    private static void e(Runnable runnable) {
        uu1.d().b().post(runnable);
    }

    public static void f(final String str) {
        final long a2 = ho2.a();
        final long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        e(new Runnable() { // from class: com.taobao.monitor.adapter.TBAPMAdapterSubTaskManager.2
            @Override // java.lang.Runnable
            public void run() {
                if (!TBAPMAdapterSubTaskManager.c) {
                    IProcedure iProcedure = (IProcedure) TBAPMAdapterSubTaskManager.b.get(str);
                    C6755a c6755a = (C6755a) TBAPMAdapterSubTaskManager.a.get(str);
                    if (iProcedure == null && c6755a != null) {
                        C6817d f = new C6817d.C6819b().g(false).k(false).i(false).h(wu1.b.getLauncherProcedure()).f();
                        tu1 tu1Var = tu1.b;
                        iProcedure = tu1Var.createProcedure("/" + str, f);
                        iProcedure.begin();
                        iProcedure.stage("taskStart", c6755a.a);
                        iProcedure.stage("cpuStartTime", c6755a.c);
                        iProcedure.addProperty("isMainThread", Boolean.valueOf(c6755a.e));
                        iProcedure.addProperty("threadName", c6755a.f);
                        TBAPMAdapterSubTaskManager.a.remove(str);
                    }
                    if (iProcedure != null) {
                        iProcedure.stage("taskEnd", a2);
                        iProcedure.stage("cpuEndTime", currentThreadTimeMillis);
                        iProcedure.end();
                        TBAPMAdapterSubTaskManager.b.remove(str);
                    }
                } else if (TBAPMAdapterSubTaskManager.a.keySet().contains(str)) {
                    C6755a c6755a2 = (C6755a) TBAPMAdapterSubTaskManager.a.get(str);
                    c6755a2.b = a2;
                    c6755a2.d = currentThreadTimeMillis;
                }
            }
        });
    }

    public static void g(final String str) {
        final long a2 = ho2.a();
        final long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        final String name = Thread.currentThread().getName();
        final boolean z = Thread.currentThread() == Looper.getMainLooper().getThread();
        e(new Runnable() { // from class: com.taobao.monitor.adapter.TBAPMAdapterSubTaskManager.1
            @Override // java.lang.Runnable
            public void run() {
                if (TBAPMAdapterSubTaskManager.c) {
                    if (TBAPMAdapterSubTaskManager.a.keySet().contains(str)) {
                        return;
                    }
                    C6755a c6755a = new C6755a();
                    c6755a.a = a2;
                    c6755a.c = currentThreadTimeMillis;
                    c6755a.e = z;
                    c6755a.f = name;
                    TBAPMAdapterSubTaskManager.a.put(str, c6755a);
                    return;
                }
                C6817d f = new C6817d.C6819b().g(false).k(false).i(false).h(wu1.b.getLauncherProcedure()).f();
                tu1 tu1Var = tu1.b;
                IProcedure createProcedure = tu1Var.createProcedure("/" + str, f);
                TBAPMAdapterSubTaskManager.b.put(str, createProcedure);
                createProcedure.begin();
                createProcedure.stage("taskStart", a2);
                createProcedure.stage("cpuStartTime", currentThreadTimeMillis);
                createProcedure.addProperty("threadName", name);
                createProcedure.addProperty("isMainThread", Boolean.valueOf(z));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void h() {
        e(new Runnable() { // from class: com.taobao.monitor.adapter.TBAPMAdapterSubTaskManager.3
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = TBAPMAdapterSubTaskManager.a.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    String str = (String) entry.getKey();
                    C6755a c6755a = (C6755a) entry.getValue();
                    if (c6755a.b != 0) {
                        C6817d f = new C6817d.C6819b().g(false).k(false).i(false).h(wu1.b.getLauncherProcedure()).f();
                        tu1 tu1Var = tu1.b;
                        IProcedure createProcedure = tu1Var.createProcedure("/" + str, f);
                        createProcedure.begin();
                        createProcedure.stage("taskStart", c6755a.a);
                        createProcedure.stage("cpuStartTime", c6755a.c);
                        createProcedure.addProperty("isMainThread", Boolean.valueOf(c6755a.e));
                        createProcedure.addProperty("threadName", c6755a.f);
                        createProcedure.stage("taskEnd", c6755a.b);
                        createProcedure.stage("cpuEndTime", c6755a.d);
                        createProcedure.end();
                        it.remove();
                    }
                }
                boolean unused = TBAPMAdapterSubTaskManager.c = false;
            }
        });
    }
}
