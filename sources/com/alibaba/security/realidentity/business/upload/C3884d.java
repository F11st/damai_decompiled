package com.alibaba.security.realidentity.business.upload;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.alibaba.security.biometrics.service.model.result.ABActionResult;
import com.alibaba.security.biometrics.service.model.result.ABImageResult;
import com.alibaba.security.biometrics.service.model.result.ALBiometricsResult;
import com.alibaba.security.common.track.model.C3834a;
import com.alibaba.security.common.track.model.CommonTrackResult;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.realidentity.a.AbstractC3840a;
import com.alibaba.security.realidentity.a.C3847g;
import com.alibaba.security.realidentity.business.C3873c;
import com.alibaba.security.realidentity.business.base.AbstractC3862b;
import com.alibaba.security.realidentity.business.base.chain.BusinessType;
import com.alibaba.security.realidentity.business.biometrics.BiometricsBucketParams;
import com.alibaba.security.realidentity.business.bucket.BucketParams;
import com.alibaba.security.realidentity.business.start.ExtrasBean;
import com.alibaba.security.realidentity.business.start.StartHttpParams;
import com.alibaba.security.realidentity.business.upload.AbstractAsyncTaskC3880a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* compiled from: Taobao */
/* renamed from: com.alibaba.security.realidentity.business.upload.d */
/* loaded from: classes8.dex */
public final class C3884d extends AbstractC3862b {
    BiometricsBucketParams d;
    UploadFileParams e;
    private StartHttpParams f;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.realidentity.business.upload.d$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    final class AnonymousClass1 implements AbstractAsyncTaskC3880a.InterfaceC3881a {
        final /* synthetic */ long a;
        final /* synthetic */ List b;
        final /* synthetic */ AbstractC3862b.InterfaceC3863a c;

        AnonymousClass1(long j, List list, AbstractC3862b.InterfaceC3863a interfaceC3863a) {
            this.a = j;
            this.b = list;
            this.c = interfaceC3863a;
        }

        @Override // com.alibaba.security.realidentity.business.upload.AbstractAsyncTaskC3880a.InterfaceC3881a
        public final void a() {
            C3884d.this.a(TrackLog.createBioMonitorUploadFinishLog(new CommonTrackResult(), true, System.currentTimeMillis() - this.a));
            C3884d.this.e.setUploadTaskList(this.b);
            C3884d.this.e.setUploadErrorCode(0);
            AbstractC3862b.InterfaceC3863a interfaceC3863a = this.c;
            if (interfaceC3863a != null) {
                C3884d c3884d = C3884d.this;
                interfaceC3863a.a(c3884d.e, !c3884d.d.isNeedBioResultPage);
            }
        }

        @Override // com.alibaba.security.realidentity.business.upload.AbstractAsyncTaskC3880a.InterfaceC3881a
        public final void b() {
            C3884d.this.a(TrackLog.createBioMonitorUploadFinishLog(new CommonTrackResult(-1, "uploadFile onError"), false, System.currentTimeMillis() - this.a));
            this.b.clear();
            C3884d.this.e.setUploadErrorCode(GlobalErrorCode.ERROR_UPLOAD_BIO_PIC_ERROR);
            AbstractC3862b.InterfaceC3863a interfaceC3863a = this.c;
            if (interfaceC3863a != null) {
                C3884d c3884d = C3884d.this;
                interfaceC3863a.b(c3884d.e, !c3884d.d.isNeedBioResultPage);
            }
        }
    }

    public C3884d(Context context) {
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
        return "";
    }

    @Override // com.alibaba.security.realidentity.business.base.AbstractC3862b
    public final void b(C3873c c3873c, BucketParams bucketParams) {
    }

    @Override // com.alibaba.security.realidentity.business.base.AbstractC3862b
    public final String c() {
        return "";
    }

    @Override // com.alibaba.security.realidentity.business.base.AbstractC3862b
    public final String d() {
        return C3834a.C3837c.a;
    }

    @Override // com.alibaba.security.realidentity.business.base.AbstractC3862b
    public final String e() {
        return C3834a.C3836b.y;
    }

    @Override // com.alibaba.security.realidentity.business.base.AbstractC3862b
    public final String f() {
        return C3834a.C3836b.z;
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
        return BusinessType.UPLOADFILE;
    }

    @Override // com.alibaba.security.realidentity.business.base.AbstractC3862b
    public final boolean j() {
        return false;
    }

    @Override // com.alibaba.security.realidentity.business.base.AbstractC3862b
    public final void a(C3873c c3873c, AbstractC3862b.InterfaceC3863a interfaceC3863a) {
        ABImageResult oi;
        ABImageResult aBImageResult;
        this.f = c3873c.c;
        this.d = c3873c.d;
        a(TrackLog.createBioMonitorUploadStartLog());
        if (this.d.isCalledFinishSuccessfully()) {
            if (this.e == null) {
                this.e = c3873c.e;
            }
            interfaceC3863a.a(this.e, !this.d.isNeedBioResultPage);
            return;
        }
        this.e = c3873c.e;
        Context context = this.b;
        ALBiometricsResult aLBiometricsResult = this.d.biometricsResult;
        ABImageResult qi = aLBiometricsResult.getQi();
        ArrayList<AsyncTaskC3885e> arrayList = new ArrayList();
        C3847g c3847g = C3847g.C3848a.a;
        if (qi != null) {
            arrayList.add(a(AbstractC3840a.K, AbstractC3840a.K, this.f.mUploadToken.path, c3847g.a(qi.getBf(), AbstractC3840a.K)));
        }
        if (this.f.mNeedActionImage) {
            for (int i = 0; i < aLBiometricsResult.getAs().size(); i++) {
                ABActionResult aBActionResult = aLBiometricsResult.getAs().get(i);
                if (aBActionResult != null && aBActionResult.getIs().size() > 0 && (aBImageResult = aBActionResult.getIs().get(aBActionResult.getIs().size() - 1)) != null) {
                    arrayList.add(a("action".concat(String.valueOf(i)), "action".concat(String.valueOf(i)), this.f.mUploadToken.path, c3847g.a(aBImageResult.getBf(), AbstractC3840a.O.concat(String.valueOf(i)))));
                }
            }
        }
        if (this.f.mNeedOriginalImage && (oi = aLBiometricsResult.getOi()) != null) {
            arrayList.add(a(AbstractC3840a.N, AbstractC3840a.N, this.f.mUploadToken.path, c3847g.a(oi.getBf(), AbstractC3840a.N)));
        }
        ExtrasBean extrasBean = this.f.mExtrasBean;
        if (extrasBean != null && !TextUtils.isEmpty(extrasBean.getSgConfig())) {
            arrayList.add(new AsyncTaskC3883c(this.b, this.c, AbstractC3840a.P, AbstractC3840a.P, this.f.mUploadToken.path));
        }
        ABImageResult gi = aLBiometricsResult.getGi();
        if (gi != null) {
            arrayList.add(a(AbstractC3840a.M, AbstractC3840a.M, this.f.mUploadToken.path, c3847g.a(gi.getBf(), AbstractC3840a.M)));
        }
        ABImageResult li = aLBiometricsResult.getLi();
        if (li != null) {
            arrayList.add(a(AbstractC3840a.L, AbstractC3840a.L, this.f.mUploadToken.path, c3847g.a(li.getBf(), AbstractC3840a.L)));
        }
        if (aLBiometricsResult.getDazzleVideoPath() != null) {
            arrayList.add(new AsyncTaskC3882b(context, this.c, aLBiometricsResult.getDazzleVideoPath(), "10", aLBiometricsResult));
        }
        AtomicInteger atomicInteger = new AtomicInteger(arrayList.size());
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(new int[arrayList.size()]);
        long currentTimeMillis = System.currentTimeMillis();
        int i2 = 0;
        for (AsyncTaskC3885e asyncTaskC3885e : arrayList) {
            asyncTaskC3885e.c = atomicInteger;
            asyncTaskC3885e.d = atomicIntegerArray;
            asyncTaskC3885e.e = i2;
            asyncTaskC3885e.f = arrayList.size();
            asyncTaskC3885e.g = new AnonymousClass1(currentTimeMillis, arrayList, interfaceC3863a);
            i2++;
        }
        for (AsyncTaskC3885e asyncTaskC3885e2 : arrayList) {
            asyncTaskC3885e2.execute(this.f.mUploadToken);
        }
    }

    private void a(Context context, AbstractC3862b.InterfaceC3863a interfaceC3863a) {
        ABImageResult oi;
        ABImageResult aBImageResult;
        ALBiometricsResult aLBiometricsResult = this.d.biometricsResult;
        ABImageResult qi = aLBiometricsResult.getQi();
        ArrayList<AsyncTaskC3885e> arrayList = new ArrayList();
        C3847g c3847g = C3847g.C3848a.a;
        if (qi != null) {
            arrayList.add(a(AbstractC3840a.K, AbstractC3840a.K, this.f.mUploadToken.path, c3847g.a(qi.getBf(), AbstractC3840a.K)));
        }
        if (this.f.mNeedActionImage) {
            for (int i = 0; i < aLBiometricsResult.getAs().size(); i++) {
                ABActionResult aBActionResult = aLBiometricsResult.getAs().get(i);
                if (aBActionResult != null && aBActionResult.getIs().size() > 0 && (aBImageResult = aBActionResult.getIs().get(aBActionResult.getIs().size() - 1)) != null) {
                    arrayList.add(a("action".concat(String.valueOf(i)), "action".concat(String.valueOf(i)), this.f.mUploadToken.path, c3847g.a(aBImageResult.getBf(), AbstractC3840a.O.concat(String.valueOf(i)))));
                }
            }
        }
        if (this.f.mNeedOriginalImage && (oi = aLBiometricsResult.getOi()) != null) {
            arrayList.add(a(AbstractC3840a.N, AbstractC3840a.N, this.f.mUploadToken.path, c3847g.a(oi.getBf(), AbstractC3840a.N)));
        }
        ExtrasBean extrasBean = this.f.mExtrasBean;
        if (extrasBean != null && !TextUtils.isEmpty(extrasBean.getSgConfig())) {
            arrayList.add(new AsyncTaskC3883c(this.b, this.c, AbstractC3840a.P, AbstractC3840a.P, this.f.mUploadToken.path));
        }
        ABImageResult gi = aLBiometricsResult.getGi();
        if (gi != null) {
            arrayList.add(a(AbstractC3840a.M, AbstractC3840a.M, this.f.mUploadToken.path, c3847g.a(gi.getBf(), AbstractC3840a.M)));
        }
        ABImageResult li = aLBiometricsResult.getLi();
        if (li != null) {
            arrayList.add(a(AbstractC3840a.L, AbstractC3840a.L, this.f.mUploadToken.path, c3847g.a(li.getBf(), AbstractC3840a.L)));
        }
        if (aLBiometricsResult.getDazzleVideoPath() != null) {
            arrayList.add(new AsyncTaskC3882b(context, this.c, aLBiometricsResult.getDazzleVideoPath(), "10", aLBiometricsResult));
        }
        AtomicInteger atomicInteger = new AtomicInteger(arrayList.size());
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(new int[arrayList.size()]);
        long currentTimeMillis = System.currentTimeMillis();
        int i2 = 0;
        for (AsyncTaskC3885e asyncTaskC3885e : arrayList) {
            asyncTaskC3885e.c = atomicInteger;
            asyncTaskC3885e.d = atomicIntegerArray;
            asyncTaskC3885e.e = i2;
            asyncTaskC3885e.f = arrayList.size();
            asyncTaskC3885e.g = new AnonymousClass1(currentTimeMillis, arrayList, interfaceC3863a);
            i2++;
        }
        for (AsyncTaskC3885e asyncTaskC3885e2 : arrayList) {
            asyncTaskC3885e2.execute(this.f.mUploadToken);
        }
    }

    private AsyncTaskC3883c a(String str, String str2, String str3) {
        return new AsyncTaskC3883c(this.b, this.c, str, str2, str3);
    }

    private AsyncTaskC3885e a(String str, String str2, String str3, byte[] bArr) {
        return new AsyncTaskC3885e(this.b, this.c, str, str2, str3, bArr);
    }
}
