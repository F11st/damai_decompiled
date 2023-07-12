package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.secure.android.common.encrypt.hash.SHA;
import java.util.UUID;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class z0 {
    public static z0 b;
    public Context a;

    /* compiled from: Taobao */
    /* renamed from: com.huawei.hms.hatool.z0$a */
    /* loaded from: classes10.dex */
    public static class C5655a extends a1 {
        public String a;
        public String b;

        public C5655a(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // com.huawei.hms.hatool.a1
        public String a() {
            return AbstractC5604a.d(this.a, this.b);
        }

        @Override // com.huawei.hms.hatool.a1
        public String a(String str) {
            return SHA.sha256Encrypt(str);
        }

        @Override // com.huawei.hms.hatool.a1
        public String b() {
            return AbstractC5604a.g(this.a, this.b);
        }

        @Override // com.huawei.hms.hatool.a1
        public String c() {
            return AbstractC5604a.j(this.a, this.b);
        }

        @Override // com.huawei.hms.hatool.a1
        public int d() {
            return (AbstractC5604a.k(this.a, this.b) ? 4 : 0) | 0 | (AbstractC5604a.e(this.a, this.b) ? 2 : 0) | (AbstractC5604a.h(this.a, this.b) ? 1 : 0);
        }
    }

    public static z0 a() {
        z0 z0Var;
        synchronized (z0.class) {
            if (b == null) {
                b = new z0();
            }
            z0Var = b;
        }
        return z0Var;
    }

    public String a(String str, String str2) {
        return AbstractC5620g.a(this.a, str, str2);
    }

    public String a(boolean z) {
        if (z) {
            String e = AbstractC5607b.e();
            if (TextUtils.isEmpty(e)) {
                e = C5621g0.a(this.a, "global_v2", "uuid", "");
                if (TextUtils.isEmpty(e)) {
                    e = UUID.randomUUID().toString().replace("-", "");
                    C5621g0.b(this.a, "global_v2", "uuid", e);
                }
                AbstractC5607b.h(e);
            }
            return e;
        }
        return "";
    }

    public void a(Context context) {
        if (this.a == null) {
            this.a = context;
        }
    }

    public String b(String str, String str2) {
        return AbstractC5620g.b(this.a, str, str2);
    }

    public x0 c(String str, String str2) {
        return new C5655a(str, str2).a(this.a);
    }

    public String d(String str, String str2) {
        return c1.b(str, str2);
    }

    public Pair<String, String> e(String str, String str2) {
        if (AbstractC5604a.f(str, str2)) {
            String p = C5624i.c().b().p();
            String q = C5624i.c().b().q();
            if (TextUtils.isEmpty(p) || TextUtils.isEmpty(q)) {
                Pair<String, String> e = b1.e(this.a);
                C5624i.c().b().k((String) e.first);
                C5624i.c().b().l((String) e.second);
                return e;
            }
            return new Pair<>(p, q);
        }
        return new Pair<>("", "");
    }

    public String f(String str, String str2) {
        return c1.a(str, str2);
    }
}
