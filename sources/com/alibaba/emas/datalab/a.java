package com.alibaba.emas.datalab;

import android.content.Context;
import android.util.Log;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tb.l30;
import tb.n30;
import tb.o30;
import tb.ve2;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class a {
    public Map<DatalabBizType, DatalabListener> a;
    public com.alibaba.emas.datalab.decision.make.a b;
    private com.alibaba.emas.datalab.controller.a c;
    public Boolean d;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.emas.datalab.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static class C0137a {
        private static a a = new a(null);
    }

    /* synthetic */ a(DatalabService$1 datalabService$1) {
        this();
    }

    public static a b() {
        return C0137a.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        Log.w("Datalab.DatalabService", str);
        l30.c().b("update", DatalabBizType.update, "200", str);
    }

    public void c(Context context, String str) {
        this.b = new com.alibaba.emas.datalab.decision.make.a();
        ve2.b().d(context, DatalabBizType.zcache);
        try {
            l30.c().d();
            com.alibaba.emas.datalab.controller.a aVar = new com.alibaba.emas.datalab.controller.a();
            this.c = aVar;
            aVar.a(context);
        } catch (Exception e) {
            Log.e("Datalab.DatalabService", "orange controller error", e);
        }
        o30.a().c(new n30());
    }

    private a() {
        this.a = new ConcurrentHashMap();
        this.d = Boolean.FALSE;
    }
}
