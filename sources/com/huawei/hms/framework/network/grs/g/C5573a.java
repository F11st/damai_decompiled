package com.huawei.hms.framework.network.grs.g;

import android.content.Context;
import android.net.Uri;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.e.C5566c;
import java.util.concurrent.Callable;

/* compiled from: Taobao */
/* renamed from: com.huawei.hms.framework.network.grs.g.a */
/* loaded from: classes10.dex */
public class C5573a {
    protected C5578d a;
    private final String b;
    private final C5576c c;
    private final int d;
    private final Context e;
    private final String f;
    private final GrsBaseInfo g;
    private final C5566c h;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.huawei.hms.framework.network.grs.g.a$a */
    /* loaded from: classes10.dex */
    public enum EnumC5574a {
        GRSPOST,
        GRSGET,
        GRSDEFAULT
    }

    public C5573a(String str, int i, C5576c c5576c, Context context, String str2, GrsBaseInfo grsBaseInfo, C5566c c5566c) {
        this.b = str;
        this.c = c5576c;
        this.d = i;
        this.e = context;
        this.f = str2;
        this.g = grsBaseInfo;
        this.h = c5566c;
    }

    private String a(String str) {
        return Uri.parse(str).getPath();
    }

    private EnumC5574a h() {
        if (this.b.isEmpty()) {
            return EnumC5574a.GRSDEFAULT;
        }
        String a = a(this.b);
        return a.contains("1.0") ? EnumC5574a.GRSGET : a.contains("2.0") ? EnumC5574a.GRSPOST : EnumC5574a.GRSDEFAULT;
    }

    public Context a() {
        return this.e;
    }

    public C5576c b() {
        return this.c;
    }

    public String c() {
        return this.b;
    }

    public int d() {
        return this.d;
    }

    public String e() {
        return this.f;
    }

    public C5566c f() {
        return this.h;
    }

    public Callable<C5578d> g() {
        if (EnumC5574a.GRSDEFAULT.equals(h())) {
            return null;
        }
        return EnumC5574a.GRSGET.equals(h()) ? new CallableC5581f(this.b, this.d, this.c, this.e, this.f, this.g) : new CallableC5582g(this.b, this.d, this.c, this.e, this.f, this.g, this.h);
    }
}
