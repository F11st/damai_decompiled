package com.huawei.hms.hatool;

import android.content.Context;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class m1 {
    public C5628k a;
    public C5628k b;
    public Context c;
    public String d;

    public m1(Context context) {
        if (context != null) {
            this.c = context.getApplicationContext();
        }
        this.a = new C5628k();
        this.b = new C5628k();
    }

    public m1 a(int i, String str) {
        C5628k c5628k;
        C5653y.c("hmsSdk", "Builder.setCollectURL(int type,String collectURL) is execute.TYPE : " + i);
        if (!v0.b(str)) {
            str = "";
        }
        if (i == 0) {
            c5628k = this.a;
        } else if (i != 1) {
            C5653y.f("hmsSdk", "Builder.setCollectURL(int type,String collectURL): invalid type!");
            return this;
        } else {
            c5628k = this.b;
        }
        c5628k.b(str);
        return this;
    }

    public m1 a(String str) {
        C5653y.c("hmsSdk", "Builder.setAppID is execute");
        this.d = str;
        return this;
    }

    @Deprecated
    public m1 a(boolean z) {
        C5653y.c("hmsSdk", "Builder.setEnableImei(boolean isReportAndroidImei) is execute.");
        this.a.j().a(z);
        this.b.j().a(z);
        return this;
    }

    public void a() {
        if (this.c == null) {
            C5653y.b("hmsSdk", "analyticsConf create(): context is null,create failed!");
            return;
        }
        C5653y.c("hmsSdk", "Builder.create() is execute.");
        j1 j1Var = new j1("_hms_config_tag");
        j1Var.b(new C5628k(this.a));
        j1Var.a(new C5628k(this.b));
        h1.a().a(this.c);
        i1.a().a(this.c);
        o1.c().a(j1Var);
        h1.a().a(this.d);
    }

    @Deprecated
    public m1 b(boolean z) {
        C5653y.c("hmsSdk", "Builder.setEnableSN(boolean isReportSN) is execute.");
        this.a.j().b(z);
        this.b.j().b(z);
        return this;
    }

    @Deprecated
    public m1 c(boolean z) {
        C5653y.c("hmsSdk", "Builder.setEnableUDID(boolean isReportUDID) is execute.");
        this.a.j().c(z);
        this.b.j().c(z);
        return this;
    }
}
