package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.alipay.sdk.m.m.a;
import com.alipay.sdk.m.s.a;
import com.alipay.sdk.m.s.b;
import com.alipay.sdk.m.u.h;
import com.alipay.sdk.m.u.l;
import com.alipay.sdk.m.u.n;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class AuthTask {
    public static final Object c = h.class;
    public Activity a;
    public com.alipay.sdk.m.x.a b;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class a implements h.g {
        public a() {
        }

        @Override // com.alipay.sdk.m.u.h.g
        public void a() {
            AuthTask.this.c();
        }

        @Override // com.alipay.sdk.m.u.h.g
        public void b() {
        }
    }

    public AuthTask(Activity activity) {
        this.a = activity;
        b.d().a(this.a);
        this.b = new com.alipay.sdk.m.x.a(activity, com.alipay.sdk.m.x.a.k);
    }

    private String b(com.alipay.sdk.m.s.a aVar, com.alipay.sdk.m.r.b bVar) {
        String[] c2 = bVar.c();
        Bundle bundle = new Bundle();
        bundle.putString("url", c2[0]);
        Intent intent = new Intent(this.a, H5AuthActivity.class);
        intent.putExtras(bundle);
        a.C0200a.a(aVar, intent);
        this.a.startActivity(intent);
        Object obj = c;
        synchronized (obj) {
            try {
                obj.wait();
            } catch (InterruptedException unused) {
                return com.alipay.sdk.m.j.b.a();
            }
        }
        String d = com.alipay.sdk.m.j.b.d();
        return TextUtils.isEmpty(d) ? com.alipay.sdk.m.j.b.a() : d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        com.alipay.sdk.m.x.a aVar = this.b;
        if (aVar != null) {
            aVar.a();
        }
    }

    private h.g d() {
        return new a();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String e(android.app.Activity r4, java.lang.String r5, com.alipay.sdk.m.s.a r6) {
        /*
            r3 = this;
            r3.f()
            r0 = 0
            com.alipay.sdk.m.q.a r1 = new com.alipay.sdk.m.q.a     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L57
            r1.<init>()     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L57
            com.alipay.sdk.m.p.b r4 = r1.a(r6, r4, r5)     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L57
            org.json.JSONObject r4 = r4.c()     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L57
            java.lang.String r5 = "form"
            org.json.JSONObject r4 = r4.optJSONObject(r5)     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L57
            java.lang.String r5 = "onload"
            org.json.JSONObject r4 = r4.optJSONObject(r5)     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L57
            java.util.List r4 = com.alipay.sdk.m.r.b.a(r4)     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L57
            r3.c()     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L57
            r5 = 0
        L25:
            int r1 = r4.size()     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L57
            if (r5 >= r1) goto L4a
            java.lang.Object r1 = r4.get(r5)     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L57
            com.alipay.sdk.m.r.b r1 = (com.alipay.sdk.m.r.b) r1     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L57
            com.alipay.sdk.m.r.a r1 = r1.a()     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L57
            com.alipay.sdk.m.r.a r2 = com.alipay.sdk.m.r.a.WapPay     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L57
            if (r1 != r2) goto L47
            java.lang.Object r4 = r4.get(r5)     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L57
            com.alipay.sdk.m.r.b r4 = (com.alipay.sdk.m.r.b) r4     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L57
            java.lang.String r4 = r3.b(r6, r4)     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L57
            r3.c()
            return r4
        L47:
            int r5 = r5 + 1
            goto L25
        L4a:
            r3.c()
            goto L6b
        L4e:
            r4 = move-exception
            java.lang.String r5 = "biz"
            java.lang.String r1 = "H5AuthDataAnalysisError"
            com.alipay.sdk.m.k.a.a(r6, r5, r1, r4)     // Catch: java.lang.Throwable -> L86
            goto L68
        L57:
            r4 = move-exception
            com.alipay.sdk.m.j.c r5 = com.alipay.sdk.m.j.c.NETWORK_ERROR     // Catch: java.lang.Throwable -> L86
            int r5 = r5.b()     // Catch: java.lang.Throwable -> L86
            com.alipay.sdk.m.j.c r5 = com.alipay.sdk.m.j.c.b(r5)     // Catch: java.lang.Throwable -> L86
            java.lang.String r0 = "net"
            com.alipay.sdk.m.k.a.a(r6, r0, r4)     // Catch: java.lang.Throwable -> L86
            r0 = r5
        L68:
            r3.c()
        L6b:
            if (r0 != 0) goto L77
            com.alipay.sdk.m.j.c r4 = com.alipay.sdk.m.j.c.FAILED
            int r4 = r4.b()
            com.alipay.sdk.m.j.c r0 = com.alipay.sdk.m.j.c.b(r4)
        L77:
            int r4 = r0.b()
            java.lang.String r5 = r0.a()
            java.lang.String r6 = ""
            java.lang.String r4 = com.alipay.sdk.m.j.b.a(r4, r5, r6)
            return r4
        L86:
            r4 = move-exception
            r3.c()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.AuthTask.e(android.app.Activity, java.lang.String, com.alipay.sdk.m.s.a):java.lang.String");
    }

    private void f() {
        com.alipay.sdk.m.x.a aVar = this.b;
        if (aVar != null) {
            aVar.d();
        }
    }

    public synchronized String auth(String str, boolean z) {
        return innerAuth(new com.alipay.sdk.m.s.a(this.a, str, "auth"), str, z);
    }

    public synchronized Map<String, String> authV2(String str, boolean z) {
        com.alipay.sdk.m.s.a aVar;
        aVar = new com.alipay.sdk.m.s.a(this.a, str, "authV2");
        return l.a(aVar, innerAuth(aVar, str, z));
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x00bf, code lost:
        if (com.alipay.sdk.m.m.a.D().s() != false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00c1, code lost:
        com.alipay.sdk.m.m.a.D().a(r7, r6.a, false, 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00ca, code lost:
        c();
        com.alipay.sdk.m.k.a.b(r6.a, r7, r8, r7.d);
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x006b, code lost:
        if (com.alipay.sdk.m.m.a.D().s() == false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized java.lang.String innerAuth(com.alipay.sdk.m.s.a r7, java.lang.String r8, boolean r9) {
        /*
            Method dump skipped, instructions count: 314
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.AuthTask.innerAuth(com.alipay.sdk.m.s.a, java.lang.String, boolean):java.lang.String");
    }

    private String a(Activity activity, String str, com.alipay.sdk.m.s.a aVar) {
        String a2 = aVar.a(str);
        List<a.b> l = com.alipay.sdk.m.m.a.D().l();
        if (!com.alipay.sdk.m.m.a.D().h || l == null) {
            l = com.alipay.sdk.m.j.a.d;
        }
        if (n.a(aVar, (Context) this.a, l, true)) {
            h hVar = new h(activity, aVar, d());
            String a3 = hVar.a(a2, false);
            hVar.a();
            if (!TextUtils.equals(a3, "failed") && !TextUtils.equals(a3, h.k)) {
                return TextUtils.isEmpty(a3) ? com.alipay.sdk.m.j.b.a() : a3;
            }
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.i0);
            return e(activity, a2, aVar);
        }
        com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.j0);
        return e(activity, a2, aVar);
    }
}
