package com.huawei.hms.hatool;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class m {
    public k a;
    public k b;
    public k c;
    public k d;

    public m(String str) {
    }

    public k a() {
        return this.c;
    }

    public k a(String str) {
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
        y.f("hmsSdk", "HiAnalyticsInstData.getConfig(type): wrong type: " + str);
        return null;
    }

    public void a(k kVar) {
        this.a = kVar;
    }

    public k b() {
        return this.a;
    }

    public void b(k kVar) {
        this.b = kVar;
    }

    public k c() {
        return this.b;
    }

    public k d() {
        return this.d;
    }
}
