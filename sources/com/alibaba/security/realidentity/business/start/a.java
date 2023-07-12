package com.alibaba.security.realidentity.business.start;

import android.content.Context;
import com.alibaba.security.biometrics.service.model.result.SensorInfo;
import com.alibaba.security.biometrics.service.sensor.SensorGetter;
import com.alibaba.security.common.d.h;
import com.alibaba.security.common.track.model.a;
import com.alibaba.security.realidentity.a.i;
import com.alibaba.security.realidentity.business.base.b;
import com.alibaba.security.realidentity.business.base.chain.BusinessType;
import com.alibaba.security.realidentity.business.base.chain.c;
import com.alibaba.security.realidentity.business.bucket.BucketParams;
import com.alibaba.security.realidentity.business.bucket.HttpBucketParams;
import com.alibaba.security.realidentity.http.IHttpInvoker;
import com.alibaba.security.realidentity.http.base.BusinessHttpWrapper;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class a extends b {
    protected StartHttpParams d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.realidentity.business.start.a$2  reason: invalid class name */
    /* loaded from: classes8.dex */
    public final class AnonymousClass2 extends c {
        final /* synthetic */ b.a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(HttpBucketParams httpBucketParams, b.a aVar) {
            super(httpBucketParams);
            this.a = aVar;
        }

        @Override // com.alibaba.security.realidentity.business.base.chain.c
        public final void a(HttpBucketParams httpBucketParams) {
            StartHttpParams startHttpParams = (StartHttpParams) httpBucketParams;
            a.this.d = startHttpParams;
            b.a aVar = this.a;
            if (aVar != null) {
                aVar.a(startHttpParams, true);
            }
        }

        @Override // com.alibaba.security.realidentity.business.base.chain.c
        public final void b(HttpBucketParams httpBucketParams) {
            StartHttpParams startHttpParams = (StartHttpParams) httpBucketParams;
            a.this.d = startHttpParams;
            b.a aVar = this.a;
            if (aVar != null) {
                aVar.b(startHttpParams, true);
            }
        }

        @Override // com.alibaba.security.realidentity.business.base.chain.c, com.alibaba.security.realidentity.http.base.RetrofitHttpCallback
        public final void onNetError(Exception exc) {
            b.a aVar = this.a;
            if (aVar != null) {
                aVar.a(a.this.d, exc, true);
            }
        }
    }

    public a(Context context) {
        super(context);
    }

    @Override // com.alibaba.security.realidentity.business.base.b
    public final void a(com.alibaba.security.realidentity.business.c cVar) {
    }

    @Override // com.alibaba.security.realidentity.business.base.b
    public final void a(com.alibaba.security.realidentity.business.c cVar, BucketParams bucketParams) {
    }

    @Override // com.alibaba.security.realidentity.business.base.b
    public final String b() {
        StartHttpParams startHttpParams = this.d;
        return startHttpParams == null ? "" : h.a(startHttpParams.getRpcRequest().httpRequest.httpRequest);
    }

    @Override // com.alibaba.security.realidentity.business.base.b
    public final void b(com.alibaba.security.realidentity.business.c cVar, BucketParams bucketParams) {
    }

    @Override // com.alibaba.security.realidentity.business.base.b
    public final String c() {
        StartHttpParams startHttpParams = this.d;
        return startHttpParams == null ? "" : h.a(startHttpParams.getmHttpResponse());
    }

    @Override // com.alibaba.security.realidentity.business.base.b
    public final String d() {
        return a.c.a;
    }

    @Override // com.alibaba.security.realidentity.business.base.b
    public final String e() {
        return a.b.w;
    }

    @Override // com.alibaba.security.realidentity.business.base.b
    public final String f() {
        return a.b.x;
    }

    @Override // com.alibaba.security.realidentity.business.base.b
    public final String g() {
        return "";
    }

    @Override // com.alibaba.security.realidentity.business.base.b
    public final void h() {
    }

    @Override // com.alibaba.security.realidentity.business.base.b
    public final BusinessType i() {
        return BusinessType.START;
    }

    @Override // com.alibaba.security.realidentity.business.base.b
    public final void a(com.alibaba.security.realidentity.business.c cVar, final b.a aVar) {
        if (cVar == null) {
            return;
        }
        this.d = cVar.c;
        SensorGetter.getDefault().collectLightSensorInfo(new SensorGetter.SensorCallback() { // from class: com.alibaba.security.realidentity.business.start.a.1
            @Override // com.alibaba.security.biometrics.service.sensor.SensorGetter.SensorCallback
            public final void onGetSensorValue(float f) {
                a.this.d.setSensorInfo(new SensorInfo(f));
                a.this.a();
                a aVar2 = a.this;
                a.a(aVar2, aVar2.d.getRpcRequest(), aVar);
            }
        });
    }

    private void a(BusinessHttpWrapper businessHttpWrapper, b.a aVar) {
        IHttpInvoker e = i.a.a.e();
        if (e != null) {
            e.start(businessHttpWrapper, new AnonymousClass2(this.d, aVar));
        }
    }

    static /* synthetic */ void a(a aVar, BusinessHttpWrapper businessHttpWrapper, b.a aVar2) {
        IHttpInvoker e = i.a.a.e();
        if (e != null) {
            e.start(businessHttpWrapper, new AnonymousClass2(aVar.d, aVar2));
        }
    }
}
