package com.alibaba.security.realidentity.a;

import android.content.Context;
import com.alibaba.security.realidentity.business.bucket.BucketParams;
import com.alibaba.security.realidentity.http.AbsHttpInvoker;
import com.alibaba.security.realidentity.http.IHttpInvoker;
import com.alibaba.security.realidentity.jsbridge.n;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class i implements d {
    private static final String b = "RealIdentityAdapterWrapper";
    public d a;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static final class a {
        private static final i a = new i();

        private a() {
        }
    }

    private void a(d dVar) {
        this.a = dVar;
        b();
    }

    private static i f() {
        return a.a;
    }

    @Override // com.alibaba.security.realidentity.a.d
    public final Class<? extends com.alibaba.security.realidentity.jsbridge.a>[] b() {
        if (this.a == null) {
            return null;
        }
        com.alibaba.security.realidentity.jsbridge.g.a();
        Class<? extends com.alibaba.security.realidentity.jsbridge.a>[] b2 = this.a.b();
        com.alibaba.security.realidentity.jsbridge.g.a(new Class[]{com.alibaba.security.realidentity.jsbridge.a.a.class, com.alibaba.security.realidentity.jsbridge.a.c.class, com.alibaba.security.realidentity.jsbridge.a.d.class, com.alibaba.security.realidentity.jsbridge.a.e.class, com.alibaba.security.realidentity.jsbridge.a.b.class, n.class});
        com.alibaba.security.realidentity.jsbridge.g.a(b2);
        return b2;
    }

    @Override // com.alibaba.security.realidentity.a.d
    public final Class<? extends BucketParams>[] c() {
        d dVar = this.a;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    @Override // com.alibaba.security.realidentity.a.d
    public final b d() {
        d dVar = this.a;
        if (dVar != null) {
            return dVar.d();
        }
        return null;
    }

    public final IHttpInvoker e() {
        AbsHttpInvoker a2 = a();
        if (a2 == null) {
            return null;
        }
        return a2.getHttpInvoker();
    }

    @Override // com.alibaba.security.realidentity.a.d
    public final AbsHttpInvoker a() {
        d dVar = this.a;
        if (dVar == null) {
            return null;
        }
        return dVar.a();
    }

    @Override // com.alibaba.security.realidentity.a.d
    public final c a(Context context) {
        d dVar = this.a;
        if (dVar != null) {
            return dVar.a(context);
        }
        return null;
    }
}
