package com.alibaba.security.realidentity.business;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.alibaba.security.realidentity.RPDetail;
import com.alibaba.security.realidentity.RPEventListener;
import com.alibaba.security.realidentity.RPResult;
import com.alibaba.security.realidentity.business.base.chain.BusinessHeadParams;
import com.alibaba.security.realidentity.business.base.chain.BusinessType;
import com.alibaba.security.realidentity.business.biometrics.AbsBiometricsBucketParams;
import com.alibaba.security.realidentity.business.biometrics.BiometricsBucketParams;
import com.alibaba.security.realidentity.business.bucket.BucketParams;
import com.alibaba.security.realidentity.business.c;
import com.alibaba.security.realidentity.business.upload.d;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class a {
    private static final String a = "a";
    private com.alibaba.security.realidentity.business.base.chain.b b;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.realidentity.business.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    static class C0168a implements com.alibaba.security.realidentity.business.b {
        final RPEventListener a;
        final b b = new b();
        private final com.alibaba.security.realidentity.business.base.chain.b c;
        private final ThreadPoolExecutor d;

        public C0168a(RPEventListener rPEventListener, com.alibaba.security.realidentity.business.base.chain.b bVar) {
            this.a = rPEventListener;
            this.c = bVar;
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.alibaba.security.realidentity.business.a.a.1
                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(Runnable runnable) {
                    return new Thread(runnable, "rpsdk-bitmapProcess_0");
                }
            });
            this.d = threadPoolExecutor;
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        }

        private static /* synthetic */ Bitmap c(c cVar) {
            BiometricsBucketParams biometricsBucketParams;
            AbsBiometricsBucketParams.ALBiometricsCallBackBean aLBiometricsCallBackBean;
            if (cVar == null || (biometricsBucketParams = cVar.d) == null || (aLBiometricsCallBackBean = biometricsBucketParams.biometricsCallBackBean) == null) {
                return null;
            }
            return com.alibaba.security.common.d.b.a(aLBiometricsCallBackBean.faceImage, aLBiometricsCallBackBean.faceImageWidth, aLBiometricsCallBackBean.faceImageHeight);
        }

        private static Bitmap b(c cVar) {
            BiometricsBucketParams biometricsBucketParams;
            AbsBiometricsBucketParams.ALBiometricsCallBackBean aLBiometricsCallBackBean;
            if (cVar == null || (biometricsBucketParams = cVar.d) == null || (aLBiometricsCallBackBean = biometricsBucketParams.biometricsCallBackBean) == null) {
                return null;
            }
            return com.alibaba.security.common.d.b.a(aLBiometricsCallBackBean.faceImage, aLBiometricsCallBackBean.faceImageWidth, aLBiometricsCallBackBean.faceImageHeight);
        }

        @Override // com.alibaba.security.realidentity.business.b
        public final void a(c cVar) {
            a(RPResult.AUDIT_PASS, "0", "0", cVar, "");
            com.alibaba.security.realidentity.business.base.chain.b bVar = this.c;
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // com.alibaba.security.realidentity.business.b
        public final void a(c cVar, String str) {
            a(RPResult.AUDIT_EXCEPTION, "-10300", "-10300", cVar, "Network Failure: ".concat(String.valueOf(str)));
            com.alibaba.security.realidentity.business.base.chain.b bVar = this.c;
            if (bVar != null) {
                bVar.a();
            }
        }

        private void a(final RPResult rPResult, final String str, final String str2, final c cVar, final String str3) {
            if (this.a == null) {
                return;
            }
            this.d.execute(new Runnable() { // from class: com.alibaba.security.realidentity.business.a.a.2
                @Override // java.lang.Runnable
                public final void run() {
                    BiometricsBucketParams biometricsBucketParams;
                    AbsBiometricsBucketParams.ALBiometricsCallBackBean aLBiometricsCallBackBean;
                    c cVar2 = cVar;
                    final RPDetail rPDetail = new RPDetail(str, str2, str3, (cVar2 == null || (biometricsBucketParams = cVar2.d) == null || (aLBiometricsCallBackBean = biometricsBucketParams.biometricsCallBackBean) == null) ? null : com.alibaba.security.common.d.b.a(aLBiometricsCallBackBean.faceImage, aLBiometricsCallBackBean.faceImageWidth, aLBiometricsCallBackBean.faceImageHeight));
                    b bVar = C0168a.this.b;
                    if (bVar == null) {
                        return;
                    }
                    bVar.post(new Runnable() { // from class: com.alibaba.security.realidentity.business.a.a.2.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            C0168a.this.a.onFinish(rPResult, rPDetail);
                        }
                    });
                }
            });
        }

        @Override // com.alibaba.security.realidentity.business.b
        public final void a(BusinessType businessType, c cVar) {
            BucketParams.ErrorCode errorCode;
            int i = c.AnonymousClass1.a[businessType.ordinal()];
            if (i == 1) {
                errorCode = cVar.c.getErrorCode();
            } else if (i == 2) {
                errorCode = cVar.g.getErrorCode();
            } else if (i == 3) {
                errorCode = cVar.e.getErrorCode();
            } else if (i != 4) {
                errorCode = i != 5 ? null : cVar.d.getErrorCode();
            } else {
                errorCode = cVar.f.getErrorCode();
            }
            a(errorCode.audit, errorCode.errorCode, String.valueOf(errorCode.globalErrorCode), cVar, errorCode.errorMsg);
            com.alibaba.security.realidentity.business.base.chain.b bVar = this.c;
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    static class b extends Handler {
        public b() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public final void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
        }
    }

    public a(Context context, String str, RPEventListener rPEventListener) {
        this(context, str, rPEventListener, false);
    }

    private void a() {
        a(null);
    }

    public a(Context context, String str, RPEventListener rPEventListener, boolean z) {
        try {
            com.alibaba.security.realidentity.business.base.chain.b bVar = new com.alibaba.security.realidentity.business.base.chain.b(str);
            this.b = bVar;
            if (z) {
                bVar.a(new com.alibaba.security.realidentity.business.biometrics.a(context), new C0168a(rPEventListener, this.b)).a(new d(context)).a(new com.alibaba.security.realidentity.business.uploadresult.a(context));
            } else {
                bVar.a(new com.alibaba.security.realidentity.business.start.a(context), new C0168a(rPEventListener, this.b)).a(new com.alibaba.security.realidentity.business.biometrics.a(context)).a(new d(context)).a(new com.alibaba.security.realidentity.business.uploadresult.a(context)).a(new com.alibaba.security.realidentity.business.submit.a(context));
            }
        } catch (IllegalAccessException unused) {
            com.alibaba.security.common.c.a.b();
        }
    }

    public final void a(BusinessHeadParams businessHeadParams) {
        com.alibaba.security.realidentity.business.base.chain.b bVar = this.b;
        if (bVar != null) {
            bVar.a(businessHeadParams);
        }
    }
}
