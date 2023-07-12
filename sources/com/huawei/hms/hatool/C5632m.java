package com.huawei.hms.hatool;

/* compiled from: Taobao */
/* renamed from: com.huawei.hms.hatool.m */
/* loaded from: classes10.dex */
public class C5632m {
    public C5628k a;
    public C5628k b;
    public C5628k c;
    public C5628k d;

    public C5632m(String str) {
    }

    public C5628k a() {
        return this.c;
    }

    public C5628k a(String str) {
        if (str.equals("oper")) {
            return c();
        }
        if (str.equals("maint")) {
            return b();
        }
        if (str.equals("diffprivacy")) {
            return a();
        }
        if (str.equals("preins")) {
            return d();
        }
        C5653y.f("hmsSdk", "HiAnalyticsInstData.getConfig(type): wrong type: " + str);
        return null;
    }

    public void a(C5628k c5628k) {
        this.a = c5628k;
    }

    public C5628k b() {
        return this.a;
    }

    public void b(C5628k c5628k) {
        this.b = c5628k;
    }

    public C5628k c() {
        return this.b;
    }

    public C5628k d() {
        return this.d;
    }
}
