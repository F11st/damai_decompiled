package com.alibaba.emas.datalab;

import android.content.Context;
import android.util.Log;
import com.alibaba.emas.datalab.controller.C3322a;
import com.alibaba.emas.datalab.decision.make.C3324a;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tb.l30;
import tb.n30;
import tb.o30;
import tb.ve2;

/* compiled from: Taobao */
/* renamed from: com.alibaba.emas.datalab.a */
/* loaded from: classes15.dex */
public class C3318a {
    public Map<DatalabBizType, DatalabListener> a;
    public C3324a b;
    private C3322a c;
    public Boolean d;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.emas.datalab.a$a */
    /* loaded from: classes15.dex */
    public static class C3319a {
        private static C3318a a = new C3318a(null);
    }

    /* synthetic */ C3318a(DatalabService$1 datalabService$1) {
        this();
    }

    public static C3318a b() {
        return C3319a.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        Log.w("Datalab.DatalabService", str);
        l30.c().b("update", DatalabBizType.update, "200", str);
    }

    public void c(Context context, String str) {
        this.b = new C3324a();
        ve2.b().d(context, DatalabBizType.zcache);
        try {
            l30.c().d();
            C3322a c3322a = new C3322a();
            this.c = c3322a;
            c3322a.a(context);
        } catch (Exception e) {
            Log.e("Datalab.DatalabService", "orange controller error", e);
        }
        o30.a().c(new n30());
    }

    private C3318a() {
        this.a = new ConcurrentHashMap();
        this.d = Boolean.FALSE;
    }
}
