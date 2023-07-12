package com.alibaba.security.realidentity.business.submit;

import android.content.Context;
import com.alibaba.security.common.d.C3811h;
import com.alibaba.security.common.track.model.C3834a;
import com.alibaba.security.realidentity.a.C3850i;
import com.alibaba.security.realidentity.business.C3873c;
import com.alibaba.security.realidentity.business.base.AbstractC3862b;
import com.alibaba.security.realidentity.business.base.chain.AbstractC3866c;
import com.alibaba.security.realidentity.business.base.chain.BusinessType;
import com.alibaba.security.realidentity.business.biometrics.BiometricsBucketParams;
import com.alibaba.security.realidentity.business.bucket.BucketParams;
import com.alibaba.security.realidentity.business.bucket.HttpBucketParams;
import com.alibaba.security.realidentity.http.IHttpInvoker;
import com.alibaba.security.realidentity.http.base.BusinessHttpWrapper;

/* compiled from: Taobao */
/* renamed from: com.alibaba.security.realidentity.business.submit.a */
/* loaded from: classes8.dex */
public final class C3877a extends AbstractC3862b {
    BiometricsBucketParams d;
    SubmitHttpParams e;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.realidentity.business.submit.a$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    final class AnonymousClass1 extends AbstractC3866c {
        final /* synthetic */ AbstractC3862b.InterfaceC3863a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(HttpBucketParams httpBucketParams, AbstractC3862b.InterfaceC3863a interfaceC3863a) {
            super(httpBucketParams);
            this.a = interfaceC3863a;
        }

        @Override // com.alibaba.security.realidentity.business.base.chain.AbstractC3866c
        public final void a(HttpBucketParams httpBucketParams) {
            C3877a c3877a = C3877a.this;
            c3877a.e = (SubmitHttpParams) httpBucketParams;
            AbstractC3862b.InterfaceC3863a interfaceC3863a = this.a;
            if (interfaceC3863a != null) {
                interfaceC3863a.a(httpBucketParams, !c3877a.d.isNeedBioResultPage);
            }
        }

        @Override // com.alibaba.security.realidentity.business.base.chain.AbstractC3866c
        public final void b(HttpBucketParams httpBucketParams) {
            C3877a c3877a = C3877a.this;
            SubmitHttpParams submitHttpParams = (SubmitHttpParams) httpBucketParams;
            c3877a.e = submitHttpParams;
            AbstractC3862b.InterfaceC3863a interfaceC3863a = this.a;
            if (interfaceC3863a != null) {
                interfaceC3863a.b(submitHttpParams, !c3877a.d.isNeedBioResultPage);
            }
        }

        @Override // com.alibaba.security.realidentity.business.base.chain.AbstractC3866c, com.alibaba.security.realidentity.http.base.RetrofitHttpCallback
        public final void onNetError(Exception exc) {
            AbstractC3862b.InterfaceC3863a interfaceC3863a = this.a;
            if (interfaceC3863a != null) {
                C3877a c3877a = C3877a.this;
                interfaceC3863a.a(c3877a.e, exc, !c3877a.d.isNeedBioResultPage);
            }
        }
    }

    public C3877a(Context context) {
        super(context);
    }

    @Override // com.alibaba.security.realidentity.business.base.AbstractC3862b
    public final void a(C3873c c3873c) {
    }

    @Override // com.alibaba.security.realidentity.business.base.AbstractC3862b
    public final void a(C3873c c3873c, BucketParams bucketParams) {
    }

    @Override // com.alibaba.security.realidentity.business.base.AbstractC3862b
    public final void b(C3873c c3873c, BucketParams bucketParams) {
    }

    @Override // com.alibaba.security.realidentity.business.base.AbstractC3862b
    public final String c() {
        SubmitHttpParams submitHttpParams = this.e;
        return submitHttpParams == null ? "" : C3811h.a(submitHttpParams.getmHttpResponse());
    }

    @Override // com.alibaba.security.realidentity.business.base.AbstractC3862b
    public final String d() {
        return C3834a.C3837c.a;
    }

    @Override // com.alibaba.security.realidentity.business.base.AbstractC3862b
    public final String e() {
        return C3834a.C3836b.C;
    }

    @Override // com.alibaba.security.realidentity.business.base.AbstractC3862b
    public final String f() {
        return C3834a.C3836b.D;
    }

    @Override // com.alibaba.security.realidentity.business.base.AbstractC3862b
    public final String g() {
        return "";
    }

    @Override // com.alibaba.security.realidentity.business.base.AbstractC3862b
    public final void h() {
    }

    @Override // com.alibaba.security.realidentity.business.base.AbstractC3862b
    public final BusinessType i() {
        return BusinessType.SUBMIT;
    }

    @Override // com.alibaba.security.realidentity.business.base.AbstractC3862b
    public final String b() {
        SubmitHttpParams submitHttpParams = this.e;
        return submitHttpParams == null ? "" : C3811h.a(submitHttpParams.getRpcRequest().httpRequest.httpRequest);
    }

    @Override // com.alibaba.security.realidentity.business.base.AbstractC3862b
    public final void a(C3873c c3873c, AbstractC3862b.InterfaceC3863a interfaceC3863a) {
        this.d = c3873c.d;
        a();
        if (this.d.isCalledFinishSuccessfully()) {
            if (this.e == null) {
                this.e = c3873c.g;
            }
            interfaceC3863a.a(this.e, !this.d.isNeedBioResultPage);
            return;
        }
        SubmitHttpParams submitHttpParams = c3873c.g;
        this.e = submitHttpParams;
        BusinessHttpWrapper rpcRequest = submitHttpParams.getRpcRequest();
        IHttpInvoker e = C3850i.C3851a.a.e();
        if (e != null) {
            e.submit(rpcRequest, new AnonymousClass1(this.e, interfaceC3863a));
        }
    }

    private void a(BusinessHttpWrapper businessHttpWrapper, AbstractC3862b.InterfaceC3863a interfaceC3863a) {
        IHttpInvoker e = C3850i.C3851a.a.e();
        if (e != null) {
            e.submit(businessHttpWrapper, new AnonymousClass1(this.e, interfaceC3863a));
        }
    }
}
