package com.alibaba.security.realidentity.business.base.chain;

import com.alibaba.security.realidentity.business.C3873c;
import com.alibaba.security.realidentity.business.InterfaceC3860b;
import com.alibaba.security.realidentity.business.base.AbstractC3862b;
import com.alibaba.security.realidentity.business.bucket.BucketParams;

/* compiled from: Taobao */
/* renamed from: com.alibaba.security.realidentity.business.base.chain.d */
/* loaded from: classes8.dex */
public final class C3867d {
    private static final String d = "BusinessNode";
    int a;
    C3867d b;
    C3867d c;
    private InterfaceC3860b e;
    private final AbstractC3862b f;

    public C3867d(AbstractC3862b abstractC3862b) {
        this.f = abstractC3862b;
    }

    private void b(C3867d c3867d) {
        this.b = c3867d;
    }

    private void b(C3873c c3873c, BucketParams bucketParams, boolean z) {
        AbstractC3862b abstractC3862b = this.f;
        if (abstractC3862b != null) {
            abstractC3862b.a(c3873c);
        }
        a(c3873c, bucketParams, z);
    }

    public C3867d(AbstractC3862b abstractC3862b, InterfaceC3860b interfaceC3860b) {
        this.f = abstractC3862b;
        this.e = interfaceC3860b;
    }

    private void a(int i) {
        this.a = i;
    }

    private int a() {
        return this.a;
    }

    private void b(BusinessType businessType, C3873c c3873c, BucketParams bucketParams, boolean z) {
        AbstractC3862b abstractC3862b = this.f;
        if (abstractC3862b != null) {
            abstractC3862b.a(c3873c, bucketParams);
        }
        a(businessType, c3873c, bucketParams, z);
    }

    private void a(C3867d c3867d) {
        this.c = c3867d;
    }

    public final void a(final C3873c c3873c) {
        this.f.a(c3873c, new InterfaceC3864a() { // from class: com.alibaba.security.realidentity.business.base.chain.d.1
            @Override // com.alibaba.security.realidentity.business.base.chain.InterfaceC3864a
            public final void a(BucketParams bucketParams, boolean z) {
                C3867d c3867d = C3867d.this;
                if (c3867d.c != null) {
                    if (c3873c.a()) {
                        C3867d.this.c.a(c3873c);
                        return;
                    }
                    return;
                }
                c3867d.a(c3873c, bucketParams, z);
            }

            @Override // com.alibaba.security.realidentity.business.base.chain.InterfaceC3864a
            public final void a(BusinessType businessType, BucketParams bucketParams, boolean z) {
                C3867d.this.a(businessType, c3873c, bucketParams, z);
            }

            @Override // com.alibaba.security.realidentity.business.base.chain.InterfaceC3864a
            public final void a(BusinessType businessType, BucketParams bucketParams, String str, boolean z) {
                C3867d.this.a(businessType, c3873c, bucketParams, str, z);
            }
        });
    }

    private void b(BusinessType businessType, C3873c c3873c, BucketParams bucketParams, String str, boolean z) {
        AbstractC3862b abstractC3862b = this.f;
        if (abstractC3862b != null) {
            abstractC3862b.b(c3873c, bucketParams);
        }
        a(businessType, c3873c, bucketParams, str, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(C3873c c3873c, BucketParams bucketParams, boolean z) {
        C3867d c3867d = this.b;
        if (c3867d != null) {
            c3867d.b(c3873c, bucketParams, z);
            return;
        }
        InterfaceC3860b interfaceC3860b = this.e;
        if (interfaceC3860b == null || !z) {
            return;
        }
        interfaceC3860b.a(c3873c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(BusinessType businessType, C3873c c3873c, BucketParams bucketParams, boolean z) {
        C3867d c3867d = this.b;
        if (c3867d != null) {
            c3867d.b(businessType, c3873c, bucketParams, z);
            return;
        }
        InterfaceC3860b interfaceC3860b = this.e;
        if (interfaceC3860b == null || !z) {
            return;
        }
        interfaceC3860b.a(businessType, c3873c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(BusinessType businessType, C3873c c3873c, BucketParams bucketParams, String str, boolean z) {
        C3867d c3867d = this.b;
        if (c3867d != null) {
            c3867d.b(businessType, c3873c, bucketParams, str, z);
            return;
        }
        InterfaceC3860b interfaceC3860b = this.e;
        if (interfaceC3860b == null || !z) {
            return;
        }
        interfaceC3860b.a(c3873c, str);
    }
}
