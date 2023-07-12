package com.alibaba.security.realidentity.business.base.chain;

import com.alibaba.security.realidentity.business.C3873c;
import com.alibaba.security.realidentity.business.InterfaceC3860b;
import com.alibaba.security.realidentity.business.base.AbstractC3862b;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* renamed from: com.alibaba.security.realidentity.business.base.chain.b */
/* loaded from: classes8.dex */
public final class C3865b {
    private C3867d a;
    private C3867d b;
    private final List<BusinessType> c = new ArrayList();
    private C3873c d;
    private final String e;

    public C3865b(String str) {
        this.e = str;
    }

    private String b() {
        return this.e;
    }

    private boolean c() {
        return this.a == null;
    }

    public final C3865b a(AbstractC3862b abstractC3862b, InterfaceC3860b interfaceC3860b) throws IllegalAccessException {
        if (c()) {
            abstractC3862b.c = this.e;
            C3867d c3867d = new C3867d(abstractC3862b, interfaceC3860b);
            a(abstractC3862b.i());
            a(c3867d);
            return this;
        }
        throw new IllegalAccessException("Please addBeginBusinessWorker First");
    }

    public final C3865b a(AbstractC3862b abstractC3862b) {
        abstractC3862b.c = this.e;
        C3867d c3867d = new C3867d(abstractC3862b);
        a(abstractC3862b.i());
        a(c3867d);
        return this;
    }

    private void a(BusinessType businessType) {
        this.c.add(businessType);
    }

    private C3865b a(C3867d c3867d) {
        if (c()) {
            c3867d.a = 0;
            this.b = c3867d;
            this.a = c3867d;
            return this;
        }
        C3867d c3867d2 = this.a;
        c3867d.b = c3867d2;
        c3867d.a = c3867d2.a + 1;
        c3867d2.c = c3867d;
        this.a = c3867d;
        return this;
    }

    public final void a(BusinessHeadParams businessHeadParams) {
        if (this.b != null) {
            C3873c c3873c = new C3873c(businessHeadParams);
            this.d = c3873c;
            c3873c.a(this.c, this.e);
            this.d.a();
            this.b.a(this.d);
        }
    }

    public final void a() {
        C3873c c3873c = this.d;
        if (c3873c != null) {
            c3873c.c();
        }
    }
}
