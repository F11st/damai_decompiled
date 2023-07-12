package com.meizu.cloud.pushsdk.d.e;

import android.content.Context;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alimm.xadsdk.base.ut.AdUtConstants;
import com.meizu.cloud.pushsdk.d.f.C6030c;
import com.meizu.cloud.pushsdk.d.f.C6032e;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.d.e.c */
/* loaded from: classes10.dex */
public class C6026c {
    private static final String a = "c";
    private final HashMap<String, String> b;
    private final HashMap<String, Object> c;
    private final HashMap<String, String> d;

    /* compiled from: Taobao */
    /* renamed from: com.meizu.cloud.pushsdk.d.e.c$a */
    /* loaded from: classes10.dex */
    public static class C6027a {
        private Context a = null;

        public C6027a a(Context context) {
            this.a = context;
            return this;
        }

        public C6026c a() {
            return new C6026c(this);
        }
    }

    private C6026c(C6027a c6027a) {
        this.b = new HashMap<>();
        this.c = new HashMap<>();
        this.d = new HashMap<>();
        d();
        e();
        f();
        g();
        if (c6027a.a != null) {
            a(c6027a.a);
        }
        C6030c.c(a, "Subject created successfully.", new Object[0]);
    }

    private void a(String str, String str2) {
        if (str == null || str2 == null || str.isEmpty() || str2.isEmpty()) {
            return;
        }
        this.d.put(str, str2);
    }

    private void d() {
        a("ot", "android-" + Build.VERSION.getRELEASE());
    }

    private void e() {
        a("ov", android.os.Build.DISPLAY);
    }

    private void f() {
        a("dm", Build.getMODEL());
    }

    private void g() {
        a("df", Build.getMANUFACTURER());
    }

    public Map<String, Object> a() {
        return this.c;
    }

    public void a(Context context) {
        b(context);
    }

    public Map<String, String> b() {
        return this.d;
    }

    public void b(Context context) {
        String b = C6032e.b(context);
        if (b != null) {
            a(AdUtConstants.XAD_UT_ARG_CA, b);
        }
    }

    public Map<String, String> c() {
        return this.b;
    }
}
