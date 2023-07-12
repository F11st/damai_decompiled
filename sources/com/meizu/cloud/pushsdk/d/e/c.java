package com.meizu.cloud.pushsdk.d.e;

import android.content.Context;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alimm.xadsdk.base.ut.AdUtConstants;
import com.meizu.cloud.pushsdk.d.f.e;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class c {
    private static final String a = "c";
    private final HashMap<String, String> b;
    private final HashMap<String, Object> c;
    private final HashMap<String, String> d;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class a {
        private Context a = null;

        public a a(Context context) {
            this.a = context;
            return this;
        }

        public c a() {
            return new c(this);
        }
    }

    private c(a aVar) {
        this.b = new HashMap<>();
        this.c = new HashMap<>();
        this.d = new HashMap<>();
        d();
        e();
        f();
        g();
        if (aVar.a != null) {
            a(aVar.a);
        }
        com.meizu.cloud.pushsdk.d.f.c.c(a, "Subject created successfully.", new Object[0]);
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
        String b = e.b(context);
        if (b != null) {
            a(AdUtConstants.XAD_UT_ARG_CA, b);
        }
    }

    public Map<String, String> c() {
        return this.b;
    }
}
