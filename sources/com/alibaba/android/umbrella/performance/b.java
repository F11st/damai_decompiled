package com.alibaba.android.umbrella.performance;

import android.text.TextUtils;
import java.util.Map;
import tb.jt2;
import tb.zu1;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class b {
    public static void a(a aVar) {
        ProcessEntity c;
        if (d(aVar) || (c = zu1.b().c(aVar.b)) == null) {
            return;
        }
        c.addAbTest(aVar.d, aVar.e);
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

    protected static boolean c(a aVar) {
        jt2 jt2Var;
        return aVar == null || TextUtils.isEmpty(aVar.b) || (jt2Var = aVar.g) == null || TextUtils.isEmpty(jt2Var.a()) || !zu1.b().e(aVar.b);
    }

    protected static boolean d(a aVar) {
        return aVar == null || TextUtils.isEmpty(aVar.b) || !zu1.b().e(aVar.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void e(a aVar) {
        ProcessEntity c = zu1.b().c(aVar.b);
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
    public static void g(a aVar) {
        ProcessEntity c;
        Map<String, String> map;
        if (d(aVar) || (c = zu1.b().c(aVar.b)) == null || (map = aVar.j) == null || map.size() <= 0) {
            return;
        }
        c.addArgs(aVar.j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void h(a aVar) {
        ProcessEntity c;
        if (c(aVar) || (c = zu1.b().c(aVar.b)) == null) {
            return;
        }
        Map<String, String> map = aVar.j;
        if (map != null && map.size() > 0) {
            c.addArgs(aVar.j);
        }
        if (jt2.PAGELOAD.equals(aVar.g)) {
            c.addPageLoad(aVar.i);
        } else {
            c.addProcess(aVar.g.a(), aVar.i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void i(a aVar) {
        ProcessEntity c;
        if (c(aVar) || TextUtils.isEmpty(aVar.f) || (c = zu1.b().c(aVar.b)) == null) {
            return;
        }
        Map<String, String> map = aVar.j;
        if (map != null && map.size() > 0) {
            c.addArgs(aVar.j);
        }
        jt2 jt2Var = aVar.g;
        if (jt2Var == jt2.INIT) {
            c.addInit(aVar.f, aVar.i);
        } else if (jt2Var == jt2.LIFECYCLE) {
            c.addLifeCycle(aVar.f, aVar.i);
        } else if (jt2Var == jt2.NETWORK) {
            c.addNetwork(aVar.f, aVar.i);
        } else if (jt2Var == jt2.DATAPARSE) {
            c.addDataParse(aVar.f, aVar.i);
        } else if (jt2Var == jt2.SUB_CREATE_VIEW) {
            c.addCreateView(aVar.f, aVar.i);
        } else if (jt2Var == jt2.SUB_BIND_VIEW) {
            c.addBindView(aVar.f, aVar.i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void j(a aVar) {
        b();
        zu1.b().a(new ProcessEntity(aVar.b, aVar.h));
    }

    public static void k(a aVar) {
        ProcessEntity c;
        if (d(aVar) || (c = zu1.b().c(aVar.b)) == null) {
            return;
        }
        c.setChildBizName(aVar.c);
    }
}
