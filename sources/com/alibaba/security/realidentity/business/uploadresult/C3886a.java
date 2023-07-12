package com.alibaba.security.realidentity.business.uploadresult;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.security.biometrics.service.common.GetCacheDataManager;
import com.alibaba.security.biometrics.service.model.result.ALBiometricsResult;
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
import com.alibaba.security.realidentity.business.upload.UploadResultParams;
import com.alibaba.security.realidentity.http.IHttpInvoker;
import com.alibaba.security.realidentity.http.base.BusinessHttpWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: com.alibaba.security.realidentity.business.uploadresult.a */
/* loaded from: classes8.dex */
public final class C3886a extends AbstractC3862b {
    BiometricsBucketParams d;
    UploadResultParams e;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.realidentity.business.uploadresult.a$1  reason: invalid class name */
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
            C3886a c3886a = C3886a.this;
            c3886a.e = (UploadResultParams) httpBucketParams;
            AbstractC3862b.InterfaceC3863a interfaceC3863a = this.a;
            if (interfaceC3863a != null) {
                interfaceC3863a.a(httpBucketParams, !c3886a.d.isNeedBioResultPage);
            }
        }

        @Override // com.alibaba.security.realidentity.business.base.chain.AbstractC3866c
        public final void b(HttpBucketParams httpBucketParams) {
            C3886a c3886a = C3886a.this;
            UploadResultParams uploadResultParams = (UploadResultParams) httpBucketParams;
            c3886a.e = uploadResultParams;
            AbstractC3862b.InterfaceC3863a interfaceC3863a = this.a;
            if (interfaceC3863a != null) {
                interfaceC3863a.b(uploadResultParams, !c3886a.d.isNeedBioResultPage);
            }
        }

        @Override // com.alibaba.security.realidentity.business.base.chain.AbstractC3866c, com.alibaba.security.realidentity.http.base.RetrofitHttpCallback
        public final void onNetError(Exception exc) {
            AbstractC3862b.InterfaceC3863a interfaceC3863a = this.a;
            if (interfaceC3863a != null) {
                C3886a c3886a = C3886a.this;
                interfaceC3863a.a(c3886a.e, exc, !c3886a.d.isNeedBioResultPage);
            }
        }
    }

    public C3886a(Context context) {
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
        UploadResultParams uploadResultParams = this.e;
        return uploadResultParams == null ? "" : C3811h.a(uploadResultParams.getmHttpResponse());
    }

    @Override // com.alibaba.security.realidentity.business.base.AbstractC3862b
    public final String d() {
        return C3834a.C3837c.a;
    }

    @Override // com.alibaba.security.realidentity.business.base.AbstractC3862b
    public final String e() {
        return C3834a.C3836b.A;
    }

    @Override // com.alibaba.security.realidentity.business.base.AbstractC3862b
    public final String f() {
        return C3834a.C3836b.B;
    }

    @Override // com.alibaba.security.realidentity.business.base.AbstractC3862b
    public final String g() {
        ALBiometricsResult aLBiometricsResult;
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        UploadResultParams uploadResultParams = this.e;
        if (uploadResultParams != null && (aLBiometricsResult = uploadResultParams.biometricsResult) != null) {
            if (!TextUtils.isEmpty(aLBiometricsResult.getCollectedData())) {
                arrayList.add("sensorActionLog");
            }
            if (!TextUtils.isEmpty(this.e.biometricsResult.getBh())) {
                arrayList.add("flActionLog");
            }
        }
        hashMap.put("useLiteVM", Integer.valueOf(GetCacheDataManager.getInstance().isUseLiteVm() ? 1 : 0));
        hashMap.put("actionLogKeys", arrayList);
        return C3811h.a((Map) hashMap);
    }

    @Override // com.alibaba.security.realidentity.business.base.AbstractC3862b
    public final void h() {
    }

    @Override // com.alibaba.security.realidentity.business.base.AbstractC3862b
    public final BusinessType i() {
        return BusinessType.UPLOADRESULT;
    }

    @Override // com.alibaba.security.realidentity.business.base.AbstractC3862b
    public final String b() {
        UploadResultParams uploadResultParams = this.e;
        return uploadResultParams == null ? "" : C3811h.a(uploadResultParams.getRpcRequest().httpRequest.httpRequest);
    }

    @Override // com.alibaba.security.realidentity.business.base.AbstractC3862b
    public final void a(C3873c c3873c, AbstractC3862b.InterfaceC3863a interfaceC3863a) {
        this.d = c3873c.d;
        this.e = c3873c.f;
        a();
        if (this.d.isCalledFinishSuccessfully()) {
            interfaceC3863a.a(this.e, !this.d.isNeedBioResultPage);
            return;
        }
        BusinessHttpWrapper rpcRequest = this.e.getRpcRequest();
        IHttpInvoker e = C3850i.C3851a.a.e();
        if (e != null) {
            e.upload(rpcRequest, new AnonymousClass1(this.e, interfaceC3863a));
        }
    }

    private void a(BusinessHttpWrapper businessHttpWrapper, AbstractC3862b.InterfaceC3863a interfaceC3863a) {
        IHttpInvoker e = C3850i.C3851a.a.e();
        if (e != null) {
            e.upload(businessHttpWrapper, new AnonymousClass1(this.e, interfaceC3863a));
        }
    }
}
