package com.huawei.hms.framework.network.grs.g;

import android.content.Context;
import android.net.Uri;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.concurrent.Callable;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class a {
    protected d a;
    private final String b;
    private final c c;
    private final int d;
    private final Context e;
    private final String f;
    private final GrsBaseInfo g;
    private final com.huawei.hms.framework.network.grs.e.c h;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.huawei.hms.framework.network.grs.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public enum EnumC0252a {
        GRSPOST,
        GRSGET,
        GRSDEFAULT
    }

    public a(String str, int i, c cVar, Context context, String str2, GrsBaseInfo grsBaseInfo, com.huawei.hms.framework.network.grs.e.c cVar2) {
        this.b = str;
        this.c = cVar;
        this.d = i;
        this.e = context;
        this.f = str2;
        this.g = grsBaseInfo;
        this.h = cVar2;
    }

    private String a(String str) {
        return Uri.parse(str).getPath();
    }

    private EnumC0252a h() {
        if (this.b.isEmpty()) {
            return EnumC0252a.GRSDEFAULT;
        }
        String a = a(this.b);
        return a.contains("1.0") ? EnumC0252a.GRSGET : a.contains("2.0") ? EnumC0252a.GRSPOST : EnumC0252a.GRSDEFAULT;
    }

    public Context a() {
        return this.e;
    }

    public c b() {
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

    public com.huawei.hms.framework.network.grs.e.c f() {
        return this.h;
    }

    public Callable<d> g() {
        if (EnumC0252a.GRSDEFAULT.equals(h())) {
            return null;
        }
        return EnumC0252a.GRSGET.equals(h()) ? new f(this.b, this.d, this.c, this.e, this.f, this.g) : new g(this.b, this.d, this.c, this.e, this.f, this.g, this.h);
    }
}
