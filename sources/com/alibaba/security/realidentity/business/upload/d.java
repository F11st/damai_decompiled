package com.alibaba.security.realidentity.business.upload;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.alibaba.security.biometrics.service.model.result.ABActionResult;
import com.alibaba.security.biometrics.service.model.result.ABImageResult;
import com.alibaba.security.biometrics.service.model.result.ALBiometricsResult;
import com.alibaba.security.common.track.model.CommonTrackResult;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.common.track.model.a;
import com.alibaba.security.realidentity.a.g;
import com.alibaba.security.realidentity.business.base.b;
import com.alibaba.security.realidentity.business.base.chain.BusinessType;
import com.alibaba.security.realidentity.business.biometrics.BiometricsBucketParams;
import com.alibaba.security.realidentity.business.bucket.BucketParams;
import com.alibaba.security.realidentity.business.start.ExtrasBean;
import com.alibaba.security.realidentity.business.start.StartHttpParams;
import com.alibaba.security.realidentity.business.upload.a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class d extends com.alibaba.security.realidentity.business.base.b {
    BiometricsBucketParams d;
    UploadFileParams e;
    private StartHttpParams f;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.realidentity.business.upload.d$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    final class AnonymousClass1 implements a.InterfaceC0170a {
        final /* synthetic */ long a;
        final /* synthetic */ List b;
        final /* synthetic */ b.a c;

        AnonymousClass1(long j, List list, b.a aVar) {
            this.a = j;
            this.b = list;
            this.c = aVar;
        }

        @Override // com.alibaba.security.realidentity.business.upload.a.InterfaceC0170a
        public final void a() {
            d.this.a(TrackLog.createBioMonitorUploadFinishLog(new CommonTrackResult(), true, System.currentTimeMillis() - this.a));
            d.this.e.setUploadTaskList(this.b);
            d.this.e.setUploadErrorCode(0);
            b.a aVar = this.c;
            if (aVar != null) {
                d dVar = d.this;
                aVar.a(dVar.e, !dVar.d.isNeedBioResultPage);
            }
        }

        @Override // com.alibaba.security.realidentity.business.upload.a.InterfaceC0170a
        public final void b() {
            d.this.a(TrackLog.createBioMonitorUploadFinishLog(new CommonTrackResult(-1, "uploadFile onError"), false, System.currentTimeMillis() - this.a));
            this.b.clear();
            d.this.e.setUploadErrorCode(GlobalErrorCode.ERROR_UPLOAD_BIO_PIC_ERROR);
            b.a aVar = this.c;
            if (aVar != null) {
                d dVar = d.this;
                aVar.b(dVar.e, !dVar.d.isNeedBioResultPage);
            }
        }
    }

    public d(Context context) {
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
        return "";
    }

    @Override // com.alibaba.security.realidentity.business.base.b
    public final void b(com.alibaba.security.realidentity.business.c cVar, BucketParams bucketParams) {
    }

    @Override // com.alibaba.security.realidentity.business.base.b
    public final String c() {
        return "";
    }

    @Override // com.alibaba.security.realidentity.business.base.b
    public final String d() {
        return a.c.a;
    }

    @Override // com.alibaba.security.realidentity.business.base.b
    public final String e() {
        return a.b.y;
    }

    @Override // com.alibaba.security.realidentity.business.base.b
    public final String f() {
        return a.b.z;
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
        return BusinessType.UPLOADFILE;
    }

    @Override // com.alibaba.security.realidentity.business.base.b
    public final boolean j() {
        return false;
    }

    @Override // com.alibaba.security.realidentity.business.base.b
    public final void a(com.alibaba.security.realidentity.business.c cVar, b.a aVar) {
        ABImageResult oi;
        ABImageResult aBImageResult;
        this.f = cVar.c;
        this.d = cVar.d;
        a(TrackLog.createBioMonitorUploadStartLog());
        if (this.d.isCalledFinishSuccessfully()) {
            if (this.e == null) {
                this.e = cVar.e;
            }
            aVar.a(this.e, !this.d.isNeedBioResultPage);
            return;
        }
        this.e = cVar.e;
        Context context = this.b;
        ALBiometricsResult aLBiometricsResult = this.d.biometricsResult;
        ABImageResult qi = aLBiometricsResult.getQi();
        ArrayList<e> arrayList = new ArrayList();
        g gVar = g.a.a;
        if (qi != null) {
            arrayList.add(a(com.alibaba.security.realidentity.a.a.K, com.alibaba.security.realidentity.a.a.K, this.f.mUploadToken.path, gVar.a(qi.getBf(), com.alibaba.security.realidentity.a.a.K)));
        }
        if (this.f.mNeedActionImage) {
            for (int i = 0; i < aLBiometricsResult.getAs().size(); i++) {
                ABActionResult aBActionResult = aLBiometricsResult.getAs().get(i);
                if (aBActionResult != null && aBActionResult.getIs().size() > 0 && (aBImageResult = aBActionResult.getIs().get(aBActionResult.getIs().size() - 1)) != null) {
                    arrayList.add(a("action".concat(String.valueOf(i)), "action".concat(String.valueOf(i)), this.f.mUploadToken.path, gVar.a(aBImageResult.getBf(), com.alibaba.security.realidentity.a.a.O.concat(String.valueOf(i)))));
                }
            }
        }
        if (this.f.mNeedOriginalImage && (oi = aLBiometricsResult.getOi()) != null) {
            arrayList.add(a(com.alibaba.security.realidentity.a.a.N, com.alibaba.security.realidentity.a.a.N, this.f.mUploadToken.path, gVar.a(oi.getBf(), com.alibaba.security.realidentity.a.a.N)));
        }
        ExtrasBean extrasBean = this.f.mExtrasBean;
        if (extrasBean != null && !TextUtils.isEmpty(extrasBean.getSgConfig())) {
            arrayList.add(new c(this.b, this.c, com.alibaba.security.realidentity.a.a.P, com.alibaba.security.realidentity.a.a.P, this.f.mUploadToken.path));
        }
        ABImageResult gi = aLBiometricsResult.getGi();
        if (gi != null) {
            arrayList.add(a(com.alibaba.security.realidentity.a.a.M, com.alibaba.security.realidentity.a.a.M, this.f.mUploadToken.path, gVar.a(gi.getBf(), com.alibaba.security.realidentity.a.a.M)));
        }
        ABImageResult li = aLBiometricsResult.getLi();
        if (li != null) {
            arrayList.add(a(com.alibaba.security.realidentity.a.a.L, com.alibaba.security.realidentity.a.a.L, this.f.mUploadToken.path, gVar.a(li.getBf(), com.alibaba.security.realidentity.a.a.L)));
        }
        if (aLBiometricsResult.getDazzleVideoPath() != null) {
            arrayList.add(new b(context, this.c, aLBiometricsResult.getDazzleVideoPath(), "10", aLBiometricsResult));
        }
        AtomicInteger atomicInteger = new AtomicInteger(arrayList.size());
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(new int[arrayList.size()]);
        long currentTimeMillis = System.currentTimeMillis();
        int i2 = 0;
        for (e eVar : arrayList) {
            eVar.c = atomicInteger;
            eVar.d = atomicIntegerArray;
            eVar.e = i2;
            eVar.f = arrayList.size();
            eVar.g = new AnonymousClass1(currentTimeMillis, arrayList, aVar);
            i2++;
        }
        for (e eVar2 : arrayList) {
            eVar2.execute(this.f.mUploadToken);
        }
    }

    private void a(Context context, b.a aVar) {
        ABImageResult oi;
        ABImageResult aBImageResult;
        ALBiometricsResult aLBiometricsResult = this.d.biometricsResult;
        ABImageResult qi = aLBiometricsResult.getQi();
        ArrayList<e> arrayList = new ArrayList();
        g gVar = g.a.a;
        if (qi != null) {
            arrayList.add(a(com.alibaba.security.realidentity.a.a.K, com.alibaba.security.realidentity.a.a.K, this.f.mUploadToken.path, gVar.a(qi.getBf(), com.alibaba.security.realidentity.a.a.K)));
        }
        if (this.f.mNeedActionImage) {
            for (int i = 0; i < aLBiometricsResult.getAs().size(); i++) {
                ABActionResult aBActionResult = aLBiometricsResult.getAs().get(i);
                if (aBActionResult != null && aBActionResult.getIs().size() > 0 && (aBImageResult = aBActionResult.getIs().get(aBActionResult.getIs().size() - 1)) != null) {
                    arrayList.add(a("action".concat(String.valueOf(i)), "action".concat(String.valueOf(i)), this.f.mUploadToken.path, gVar.a(aBImageResult.getBf(), com.alibaba.security.realidentity.a.a.O.concat(String.valueOf(i)))));
                }
            }
        }
        if (this.f.mNeedOriginalImage && (oi = aLBiometricsResult.getOi()) != null) {
            arrayList.add(a(com.alibaba.security.realidentity.a.a.N, com.alibaba.security.realidentity.a.a.N, this.f.mUploadToken.path, gVar.a(oi.getBf(), com.alibaba.security.realidentity.a.a.N)));
        }
        ExtrasBean extrasBean = this.f.mExtrasBean;
        if (extrasBean != null && !TextUtils.isEmpty(extrasBean.getSgConfig())) {
            arrayList.add(new c(this.b, this.c, com.alibaba.security.realidentity.a.a.P, com.alibaba.security.realidentity.a.a.P, this.f.mUploadToken.path));
        }
        ABImageResult gi = aLBiometricsResult.getGi();
        if (gi != null) {
            arrayList.add(a(com.alibaba.security.realidentity.a.a.M, com.alibaba.security.realidentity.a.a.M, this.f.mUploadToken.path, gVar.a(gi.getBf(), com.alibaba.security.realidentity.a.a.M)));
        }
        ABImageResult li = aLBiometricsResult.getLi();
        if (li != null) {
            arrayList.add(a(com.alibaba.security.realidentity.a.a.L, com.alibaba.security.realidentity.a.a.L, this.f.mUploadToken.path, gVar.a(li.getBf(), com.alibaba.security.realidentity.a.a.L)));
        }
        if (aLBiometricsResult.getDazzleVideoPath() != null) {
            arrayList.add(new b(context, this.c, aLBiometricsResult.getDazzleVideoPath(), "10", aLBiometricsResult));
        }
        AtomicInteger atomicInteger = new AtomicInteger(arrayList.size());
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(new int[arrayList.size()]);
        long currentTimeMillis = System.currentTimeMillis();
        int i2 = 0;
        for (e eVar : arrayList) {
            eVar.c = atomicInteger;
            eVar.d = atomicIntegerArray;
            eVar.e = i2;
            eVar.f = arrayList.size();
            eVar.g = new AnonymousClass1(currentTimeMillis, arrayList, aVar);
            i2++;
        }
        for (e eVar2 : arrayList) {
            eVar2.execute(this.f.mUploadToken);
        }
    }

    private c a(String str, String str2, String str3) {
        return new c(this.b, this.c, str, str2, str3);
    }

    private e a(String str, String str2, String str3, byte[] bArr) {
        return new e(this.b, this.c, str, str2, str3, bArr);
    }
}
