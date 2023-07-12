package com.alibaba.security.realidentity.business.base.chain;

import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class b {
    private d a;
    private d b;
    private final List<BusinessType> c = new ArrayList();
    private com.alibaba.security.realidentity.business.c d;
    private final String e;

    public b(String str) {
        this.e = str;
    }

    private String b() {
        return this.e;
    }

    private boolean c() {
        return this.a == null;
    }

    public final b a(com.alibaba.security.realidentity.business.base.b bVar, com.alibaba.security.realidentity.business.b bVar2) throws IllegalAccessException {
        if (c()) {
            bVar.c = this.e;
            d dVar = new d(bVar, bVar2);
            a(bVar.i());
            a(dVar);
            return this;
        }
        throw new IllegalAccessException("Please addBeginBusinessWorker First");
    }

    public final b a(com.alibaba.security.realidentity.business.base.b bVar) {
        bVar.c = this.e;
        d dVar = new d(bVar);
        a(bVar.i());
        a(dVar);
        return this;
    }

    private void a(BusinessType businessType) {
        this.c.add(businessType);
    }

    private b a(d dVar) {
        if (c()) {
            dVar.a = 0;
            this.b = dVar;
            this.a = dVar;
            return this;
        }
        d dVar2 = this.a;
        dVar.b = dVar2;
        dVar.a = dVar2.a + 1;
        dVar2.c = dVar;
        this.a = dVar;
        return this;
    }

    public final void a(BusinessHeadParams businessHeadParams) {
        if (this.b != null) {
            com.alibaba.security.realidentity.business.c cVar = new com.alibaba.security.realidentity.business.c(businessHeadParams);
            this.d = cVar;
            cVar.a(this.c, this.e);
            this.d.a();
            this.b.a(this.d);
        }
    }

    public final void a() {
        com.alibaba.security.realidentity.business.c cVar = this.d;
        if (cVar != null) {
            cVar.c();
        }
    }
}
