package com.alibaba.security.realidentity.a;

import android.content.Context;
import com.alibaba.security.realidentity.business.bucket.BucketParams;
import com.alibaba.security.realidentity.http.AbsHttpInvoker;
import com.alibaba.security.realidentity.http.IHttpInvoker;
import com.alibaba.security.realidentity.jsbridge.AbstractC3893a;
import com.alibaba.security.realidentity.jsbridge.C3905g;
import com.alibaba.security.realidentity.jsbridge.C3913n;
import com.alibaba.security.realidentity.jsbridge.a.C3895a;
import com.alibaba.security.realidentity.jsbridge.a.C3896b;
import com.alibaba.security.realidentity.jsbridge.a.C3897c;
import com.alibaba.security.realidentity.jsbridge.a.C3898d;
import com.alibaba.security.realidentity.jsbridge.a.C3899e;

/* compiled from: Taobao */
/* renamed from: com.alibaba.security.realidentity.a.i */
/* loaded from: classes8.dex */
public final class C3850i implements InterfaceC3844d {
    private static final String b = "RealIdentityAdapterWrapper";
    public InterfaceC3844d a;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.realidentity.a.i$a */
    /* loaded from: classes8.dex */
    public static final class C3851a {
        private static final C3850i a = new C3850i();

        private C3851a() {
        }
    }

    private void a(InterfaceC3844d interfaceC3844d) {
        this.a = interfaceC3844d;
        b();
    }

    private static C3850i f() {
        return C3851a.a;
    }

    @Override // com.alibaba.security.realidentity.a.InterfaceC3844d
    public final Class<? extends AbstractC3893a>[] b() {
        if (this.a == null) {
            return null;
        }
        C3905g.a();
        Class<? extends AbstractC3893a>[] b2 = this.a.b();
        C3905g.a(new Class[]{C3895a.class, C3897c.class, C3898d.class, C3899e.class, C3896b.class, C3913n.class});
        C3905g.a(b2);
        return b2;
    }

    @Override // com.alibaba.security.realidentity.a.InterfaceC3844d
    public final Class<? extends BucketParams>[] c() {
        InterfaceC3844d interfaceC3844d = this.a;
        if (interfaceC3844d != null) {
            return interfaceC3844d.c();
        }
        return null;
    }

    @Override // com.alibaba.security.realidentity.a.InterfaceC3844d
    public final AbstractC3841b d() {
        InterfaceC3844d interfaceC3844d = this.a;
        if (interfaceC3844d != null) {
            return interfaceC3844d.d();
        }
        return null;
    }

    public final IHttpInvoker e() {
        AbsHttpInvoker a = a();
        if (a == null) {
            return null;
        }
        return a.getHttpInvoker();
    }

    @Override // com.alibaba.security.realidentity.a.InterfaceC3844d
    public final AbsHttpInvoker a() {
        InterfaceC3844d interfaceC3844d = this.a;
        if (interfaceC3844d == null) {
            return null;
        }
        return interfaceC3844d.a();
    }

    @Override // com.alibaba.security.realidentity.a.InterfaceC3844d
    public final AbstractC3843c a(Context context) {
        InterfaceC3844d interfaceC3844d = this.a;
        if (interfaceC3844d != null) {
            return interfaceC3844d.a(context);
        }
        return null;
    }
}
