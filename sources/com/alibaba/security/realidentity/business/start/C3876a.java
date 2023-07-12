package com.alibaba.security.realidentity.business.start;

import android.content.Context;
import com.alibaba.security.biometrics.service.model.result.SensorInfo;
import com.alibaba.security.biometrics.service.sensor.SensorGetter;
import com.alibaba.security.common.d.C3811h;
import com.alibaba.security.common.track.model.C3834a;
import com.alibaba.security.realidentity.a.C3850i;
import com.alibaba.security.realidentity.business.C3873c;
import com.alibaba.security.realidentity.business.base.AbstractC3862b;
import com.alibaba.security.realidentity.business.base.chain.AbstractC3866c;
import com.alibaba.security.realidentity.business.base.chain.BusinessType;
import com.alibaba.security.realidentity.business.bucket.BucketParams;
import com.alibaba.security.realidentity.business.bucket.HttpBucketParams;
import com.alibaba.security.realidentity.http.IHttpInvoker;
import com.alibaba.security.realidentity.http.base.BusinessHttpWrapper;

/* compiled from: Taobao */
/* renamed from: com.alibaba.security.realidentity.business.start.a */
/* loaded from: classes8.dex */
public final class C3876a extends AbstractC3862b {
    protected StartHttpParams d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.realidentity.business.start.a$2  reason: invalid class name */
    /* loaded from: classes8.dex */
    public final class AnonymousClass2 extends AbstractC3866c {
        final /* synthetic */ AbstractC3862b.InterfaceC3863a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(HttpBucketParams httpBucketParams, AbstractC3862b.InterfaceC3863a interfaceC3863a) {
            super(httpBucketParams);
            this.a = interfaceC3863a;
        }

        @Override // com.alibaba.security.realidentity.business.base.chain.AbstractC3866c
        public final void a(HttpBucketParams httpBucketParams) {
            StartHttpParams startHttpParams = (StartHttpParams) httpBucketParams;
            C3876a.this.d = startHttpParams;
            AbstractC3862b.InterfaceC3863a interfaceC3863a = this.a;
            if (interfaceC3863a != null) {
                interfaceC3863a.a(startHttpParams, true);
            }
        }

        @Override // com.alibaba.security.realidentity.business.base.chain.AbstractC3866c
        public final void b(HttpBucketParams httpBucketParams) {
            StartHttpParams startHttpParams = (StartHttpParams) httpBucketParams;
            C3876a.this.d = startHttpParams;
            AbstractC3862b.InterfaceC3863a interfaceC3863a = this.a;
            if (interfaceC3863a != null) {
                interfaceC3863a.b(startHttpParams, true);
            }
        }

        @Override // com.alibaba.security.realidentity.business.base.chain.AbstractC3866c, com.alibaba.security.realidentity.http.base.RetrofitHttpCallback
        public final void onNetError(Exception exc) {
            AbstractC3862b.InterfaceC3863a interfaceC3863a = this.a;
            if (interfaceC3863a != null) {
                interfaceC3863a.a(C3876a.this.d, exc, true);
            }
        }
    }

    public C3876a(Context context) {
        super(context);
    }

    @Override // com.alibaba.security.realidentity.business.base.AbstractC3862b
    public final void a(C3873c c3873c) {
    }

    @Override // com.alibaba.security.realidentity.business.base.AbstractC3862b
    public final void a(C3873c c3873c, BucketParams bucketParams) {
    }

    @Override // com.alibaba.security.realidentity.business.base.AbstractC3862b
    public final String b() {
        StartHttpParams startHttpParams = this.d;
        return startHttpParams == null ? "" : C3811h.a(startHttpParams.getRpcRequest().httpRequest.httpRequest);
    }

    @Override // com.alibaba.security.realidentity.business.base.AbstractC3862b
    public final void b(C3873c c3873c, BucketParams bucketParams) {
    }

    @Override // com.alibaba.security.realidentity.business.base.AbstractC3862b
    public final String c() {
        StartHttpParams startHttpParams = this.d;
        return startHttpParams == null ? "" : C3811h.a(startHttpParams.getmHttpResponse());
    }

    @Override // com.alibaba.security.realidentity.business.base.AbstractC3862b
    public final String d() {
        return C3834a.C3837c.a;
    }

    @Override // com.alibaba.security.realidentity.business.base.AbstractC3862b
    public final String e() {
        return C3834a.C3836b.w;
    }

    @Override // com.alibaba.security.realidentity.business.base.AbstractC3862b
    public final String f() {
        return C3834a.C3836b.x;
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
        return BusinessType.START;
    }

    @Override // com.alibaba.security.realidentity.business.base.AbstractC3862b
    public final void a(C3873c c3873c, final AbstractC3862b.InterfaceC3863a interfaceC3863a) {
        if (c3873c == null) {
            return;
        }
        this.d = c3873c.c;
        SensorGetter.getDefault().collectLightSensorInfo(new SensorGetter.SensorCallback() { // from class: com.alibaba.security.realidentity.business.start.a.1
            @Override // com.alibaba.security.biometrics.service.sensor.SensorGetter.SensorCallback
            public final void onGetSensorValue(float f) {
                C3876a.this.d.setSensorInfo(new SensorInfo(f));
                C3876a.this.a();
                C3876a c3876a = C3876a.this;
                C3876a.a(c3876a, c3876a.d.getRpcRequest(), interfaceC3863a);
            }
        });
    }

    private void a(BusinessHttpWrapper businessHttpWrapper, AbstractC3862b.InterfaceC3863a interfaceC3863a) {
        IHttpInvoker e = C3850i.C3851a.a.e();
        if (e != null) {
            e.start(businessHttpWrapper, new AnonymousClass2(this.d, interfaceC3863a));
        }
    }

    static /* synthetic */ void a(C3876a c3876a, BusinessHttpWrapper businessHttpWrapper, AbstractC3862b.InterfaceC3863a interfaceC3863a) {
        IHttpInvoker e = C3850i.C3851a.a.e();
        if (e != null) {
            e.start(businessHttpWrapper, new AnonymousClass2(c3876a.d, interfaceC3863a));
        }
    }
}
