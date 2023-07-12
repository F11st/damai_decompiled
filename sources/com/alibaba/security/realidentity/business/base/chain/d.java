package com.alibaba.security.realidentity.business.base.chain;

import com.alibaba.security.realidentity.business.bucket.BucketParams;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class d {
    private static final String d = "BusinessNode";
    int a;
    d b;
    d c;
    private com.alibaba.security.realidentity.business.b e;
    private final com.alibaba.security.realidentity.business.base.b f;

    public d(com.alibaba.security.realidentity.business.base.b bVar) {
        this.f = bVar;
    }

    private void b(d dVar) {
        this.b = dVar;
    }

    private void b(com.alibaba.security.realidentity.business.c cVar, BucketParams bucketParams, boolean z) {
        com.alibaba.security.realidentity.business.base.b bVar = this.f;
        if (bVar != null) {
            bVar.a(cVar);
        }
        a(cVar, bucketParams, z);
    }

    public d(com.alibaba.security.realidentity.business.base.b bVar, com.alibaba.security.realidentity.business.b bVar2) {
        this.f = bVar;
        this.e = bVar2;
    }

    private void a(int i) {
        this.a = i;
    }

    private int a() {
        return this.a;
    }

    private void b(BusinessType businessType, com.alibaba.security.realidentity.business.c cVar, BucketParams bucketParams, boolean z) {
        com.alibaba.security.realidentity.business.base.b bVar = this.f;
        if (bVar != null) {
            bVar.a(cVar, bucketParams);
        }
        a(businessType, cVar, bucketParams, z);
    }

    private void a(d dVar) {
        this.c = dVar;
    }

    public final void a(final com.alibaba.security.realidentity.business.c cVar) {
        this.f.a(cVar, new a() { // from class: com.alibaba.security.realidentity.business.base.chain.d.1
            @Override // com.alibaba.security.realidentity.business.base.chain.a
            public final void a(BucketParams bucketParams, boolean z) {
                d dVar = d.this;
                if (dVar.c != null) {
                    if (cVar.a()) {
                        d.this.c.a(cVar);
                        return;
                    }
                    return;
                }
                dVar.a(cVar, bucketParams, z);
            }

            @Override // com.alibaba.security.realidentity.business.base.chain.a
            public final void a(BusinessType businessType, BucketParams bucketParams, boolean z) {
                d.this.a(businessType, cVar, bucketParams, z);
            }

            @Override // com.alibaba.security.realidentity.business.base.chain.a
            public final void a(BusinessType businessType, BucketParams bucketParams, String str, boolean z) {
                d.this.a(businessType, cVar, bucketParams, str, z);
            }
        });
    }

    private void b(BusinessType businessType, com.alibaba.security.realidentity.business.c cVar, BucketParams bucketParams, String str, boolean z) {
        com.alibaba.security.realidentity.business.base.b bVar = this.f;
        if (bVar != null) {
            bVar.b(cVar, bucketParams);
        }
        a(businessType, cVar, bucketParams, str, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(com.alibaba.security.realidentity.business.c cVar, BucketParams bucketParams, boolean z) {
        d dVar = this.b;
        if (dVar != null) {
            dVar.b(cVar, bucketParams, z);
            return;
        }
        com.alibaba.security.realidentity.business.b bVar = this.e;
        if (bVar == null || !z) {
            return;
        }
        bVar.a(cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(BusinessType businessType, com.alibaba.security.realidentity.business.c cVar, BucketParams bucketParams, boolean z) {
        d dVar = this.b;
        if (dVar != null) {
            dVar.b(businessType, cVar, bucketParams, z);
            return;
        }
        com.alibaba.security.realidentity.business.b bVar = this.e;
        if (bVar == null || !z) {
            return;
        }
        bVar.a(businessType, cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(BusinessType businessType, com.alibaba.security.realidentity.business.c cVar, BucketParams bucketParams, String str, boolean z) {
        d dVar = this.b;
        if (dVar != null) {
            dVar.b(businessType, cVar, bucketParams, str, z);
            return;
        }
        com.alibaba.security.realidentity.business.b bVar = this.e;
        if (bVar == null || !z) {
            return;
        }
        bVar.a(cVar, str);
    }
}
