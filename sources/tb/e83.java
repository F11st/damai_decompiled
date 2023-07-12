package tb;

import com.alibaba.security.realidentity.jsbridge.AbstractC3893a;
import com.efs.sdk.base.a.d.C4786a;
import com.taobao.weex.annotation.JSMethod;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import tb.n73;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class e83 extends w23 {
    private ConcurrentHashMap<String, C9087a> b = new ConcurrentHashMap<>(10);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: tb.e83$a */
    /* loaded from: classes10.dex */
    public static class C9087a {
        String a;
        String b;
        String c;
        AtomicInteger d = new AtomicInteger(0);

        C9087a(String str, String str2, String str3) {
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
                for (Map.Entry<String, C9087a> entry : this.b.entrySet()) {
                    C9087a value = entry.getValue();
                    int i = value.d.get();
                    if (i > 0) {
                        C4786a c4786a = this.a;
                        String str = value.a;
                        String str2 = value.b;
                        String str3 = value.c;
                        n73Var = n73.C9462a.a;
                        o43 o43Var = new o43("efs_core", "req_succ_rate", n73Var.a.c);
                        o43Var.a("rep_code", str);
                        o43Var.a("px_code", str2);
                        o43Var.a(AbstractC3893a.V, str3);
                        o43Var.a("cnt", Integer.valueOf(i));
                        c4786a.b(o43Var);
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
            this.b.putIfAbsent(str4, new C9087a(str, str2, str3));
        }
        this.b.get(str4).d.incrementAndGet();
    }
}
