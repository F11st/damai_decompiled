package tb;

import com.taobao.weex.annotation.JSMethod;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import tb.n73;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class e83 extends w23 {
    private ConcurrentHashMap<String, a> b = new ConcurrentHashMap<>(10);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class a {
        String a;
        String b;
        String c;
        AtomicInteger d = new AtomicInteger(0);

        a(String str, String str2, String str3) {
            this.a = str;
            this.b = str2;
            this.c = str3;
        }
    }

    @Override // tb.w23
    public final void a() {
        n73 n73Var;
        try {
            if (this.a != null) {
                for (Map.Entry<String, a> entry : this.b.entrySet()) {
                    a value = entry.getValue();
                    int i = value.d.get();
                    if (i > 0) {
                        com.efs.sdk.base.a.d.a aVar = this.a;
                        String str = value.a;
                        String str2 = value.b;
                        String str3 = value.c;
                        n73Var = n73.a.a;
                        o43 o43Var = new o43("efs_core", "req_succ_rate", n73Var.a.c);
                        o43Var.a("rep_code", str);
                        o43Var.a("px_code", str2);
                        o43Var.a(com.alibaba.security.realidentity.jsbridge.a.V, str3);
                        o43Var.a("cnt", Integer.valueOf(i));
                        aVar.b(o43Var);
                        value.d.addAndGet(i * (-1));
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(String str, String str2, String str3) {
        String str4 = str + JSMethod.NOT_SET + str2 + JSMethod.NOT_SET + str3.trim();
        if (!this.b.containsKey(str4) || this.b.get(str4) == null) {
            this.b.putIfAbsent(str4, new a(str, str2, str3));
        }
        this.b.get(str4).d.incrementAndGet();
    }
}
