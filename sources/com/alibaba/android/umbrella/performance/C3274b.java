package com.alibaba.android.umbrella.performance;

import android.text.TextUtils;
import java.util.Map;
import tb.jt2;
import tb.zu1;

/* compiled from: Taobao */
/* renamed from: com.alibaba.android.umbrella.performance.b */
/* loaded from: classes15.dex */
public class C3274b {
    public static void a(C3271a c3271a) {
        ProcessEntity c;
        if (d(c3271a) || (c = zu1.b().c(c3271a.b)) == null) {
            return;
        }
        c.addAbTest(c3271a.d, c3271a.e);
    }

    protected static void b() {
        Map<String, ProcessEntity> d = zu1.b().d();
        if (d != null || d.size() <= 0) {
            for (String str : d.keySet()) {
                ProcessEntity processEntity = d.get(str);
                if (processEntity == null) {
                    d.remove(str);
                } else {
                    d.remove(str);
                    f(processEntity);
                }
            }
        }
    }

    protected static boolean c(C3271a c3271a) {
        jt2 jt2Var;
        return c3271a == null || TextUtils.isEmpty(c3271a.b) || (jt2Var = c3271a.g) == null || TextUtils.isEmpty(jt2Var.a()) || !zu1.b().e(c3271a.b);
    }

    protected static boolean d(C3271a c3271a) {
        return c3271a == null || TextUtils.isEmpty(c3271a.b) || !zu1.b().e(c3271a.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void e(C3271a c3271a) {
        ProcessEntity c = zu1.b().c(c3271a.b);
        if (c == null) {
            return;
        }
        zu1.b().f(c);
        if (c.pageLoad > 0) {
            f(c);
        }
    }

    protected static void f(ProcessEntity processEntity) {
        PerformanceEngine.commitPerformancePage(processEntity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void g(C3271a c3271a) {
        ProcessEntity c;
        Map<String, String> map;
        if (d(c3271a) || (c = zu1.b().c(c3271a.b)) == null || (map = c3271a.j) == null || map.size() <= 0) {
            return;
        }
        c.addArgs(c3271a.j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void h(C3271a c3271a) {
        ProcessEntity c;
        if (c(c3271a) || (c = zu1.b().c(c3271a.b)) == null) {
            return;
        }
        Map<String, String> map = c3271a.j;
        if (map != null && map.size() > 0) {
            c.addArgs(c3271a.j);
        }
        if (jt2.PAGELOAD.equals(c3271a.g)) {
            c.addPageLoad(c3271a.i);
        } else {
            c.addProcess(c3271a.g.a(), c3271a.i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void i(C3271a c3271a) {
        ProcessEntity c;
        if (c(c3271a) || TextUtils.isEmpty(c3271a.f) || (c = zu1.b().c(c3271a.b)) == null) {
            return;
        }
        Map<String, String> map = c3271a.j;
        if (map != null && map.size() > 0) {
            c.addArgs(c3271a.j);
        }
        jt2 jt2Var = c3271a.g;
        if (jt2Var == jt2.INIT) {
            c.addInit(c3271a.f, c3271a.i);
        } else if (jt2Var == jt2.LIFECYCLE) {
            c.addLifeCycle(c3271a.f, c3271a.i);
        } else if (jt2Var == jt2.NETWORK) {
            c.addNetwork(c3271a.f, c3271a.i);
        } else if (jt2Var == jt2.DATAPARSE) {
            c.addDataParse(c3271a.f, c3271a.i);
        } else if (jt2Var == jt2.SUB_CREATE_VIEW) {
            c.addCreateView(c3271a.f, c3271a.i);
        } else if (jt2Var == jt2.SUB_BIND_VIEW) {
            c.addBindView(c3271a.f, c3271a.i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void j(C3271a c3271a) {
        b();
        zu1.b().a(new ProcessEntity(c3271a.b, c3271a.h));
    }

    public static void k(C3271a c3271a) {
        ProcessEntity c;
        if (d(c3271a) || (c = zu1.b().c(c3271a.b)) == null) {
            return;
        }
        c.setChildBizName(c3271a.c);
    }
}
