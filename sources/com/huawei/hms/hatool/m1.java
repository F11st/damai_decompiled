package com.huawei.hms.hatool;

import android.content.Context;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class m1 {
    public k a;
    public k b;
    public Context c;
    public String d;

    public m1(Context context) {
        if (context != null) {
            this.c = context.getApplicationContext();
        }
        this.a = new k();
        this.b = new k();
    }

    public m1 a(int i, String str) {
        k kVar;
        y.c("hmsSdk", "Builder.setCollectURL(int type,String collectURL) is execute.TYPE : " + i);
        if (!v0.b(str)) {
            str = "";
        }
        if (i == 0) {
            kVar = this.a;
        } else if (i != 1) {
            y.f("hmsSdk", "Builder.setCollectURL(int type,String collectURL): invalid type!");
            return this;
        } else {
            kVar = this.b;
        }
        kVar.b(str);
        return this;
    }

    public m1 a(String str) {
        y.c("hmsSdk", "Builder.setAppID is execute");
        this.d = str;
        return this;
    }

    @Deprecated
    public m1 a(boolean z) {
        y.c("hmsSdk", "Builder.setEnableImei(boolean isReportAndroidImei) is execute.");
        this.a.j().a(z);
        this.b.j().a(z);
        return this;
    }

    public void a() {
        if (this.c == null) {
            y.b("hmsSdk", "analyticsConf create(): context is null,create failed!");
            return;
        }
        y.c("hmsSdk", "Builder.create() is execute.");
        j1 j1Var = new j1("_hms_config_tag");
        j1Var.b(new k(this.a));
        j1Var.a(new k(this.b));
        h1.a().a(this.c);
        i1.a().a(this.c);
        o1.c().a(j1Var);
        h1.a().a(this.d);
    }

    @Deprecated
    public m1 b(boolean z) {
        y.c("hmsSdk", "Builder.setEnableSN(boolean isReportSN) is execute.");
        this.a.j().b(z);
        this.b.j().b(z);
        return this;
    }

    @Deprecated
    public m1 c(boolean z) {
        y.c("hmsSdk", "Builder.setEnableUDID(boolean isReportUDID) is execute.");
        this.a.j().c(z);
        this.b.j().c(z);
        return this;
    }
}
