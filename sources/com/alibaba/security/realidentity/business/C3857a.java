package com.alibaba.security.realidentity.business;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.alibaba.security.common.c.C3800a;
import com.alibaba.security.common.d.C3805b;
import com.alibaba.security.realidentity.RPDetail;
import com.alibaba.security.realidentity.RPEventListener;
import com.alibaba.security.realidentity.RPResult;
import com.alibaba.security.realidentity.business.C3873c;
import com.alibaba.security.realidentity.business.base.chain.BusinessHeadParams;
import com.alibaba.security.realidentity.business.base.chain.BusinessType;
import com.alibaba.security.realidentity.business.base.chain.C3865b;
import com.alibaba.security.realidentity.business.biometrics.AbsBiometricsBucketParams;
import com.alibaba.security.realidentity.business.biometrics.BiometricsBucketParams;
import com.alibaba.security.realidentity.business.biometrics.C3869a;
import com.alibaba.security.realidentity.business.bucket.BucketParams;
import com.alibaba.security.realidentity.business.start.C3876a;
import com.alibaba.security.realidentity.business.submit.C3877a;
import com.alibaba.security.realidentity.business.upload.C3884d;
import com.alibaba.security.realidentity.business.uploadresult.C3886a;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* renamed from: com.alibaba.security.realidentity.business.a */
/* loaded from: classes8.dex */
public class C3857a {
    private static final String a = "a";
    private C3865b b;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.realidentity.business.a$a */
    /* loaded from: classes8.dex */
    static class C3858a implements InterfaceC3860b {
        final RPEventListener a;
        final HandlerC3859b b = new HandlerC3859b();
        private final C3865b c;
        private final ThreadPoolExecutor d;

        public C3858a(RPEventListener rPEventListener, C3865b c3865b) {
            this.a = rPEventListener;
            this.c = c3865b;
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.alibaba.security.realidentity.business.a.a.1
                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(Runnable runnable) {
                    return new Thread(runnable, "rpsdk-bitmapProcess_0");
                }
            });
            this.d = threadPoolExecutor;
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        }

        private static /* synthetic */ Bitmap c(C3873c c3873c) {
            BiometricsBucketParams biometricsBucketParams;
            AbsBiometricsBucketParams.ALBiometricsCallBackBean aLBiometricsCallBackBean;
            if (c3873c == null || (biometricsBucketParams = c3873c.d) == null || (aLBiometricsCallBackBean = biometricsBucketParams.biometricsCallBackBean) == null) {
                return null;
            }
            return C3805b.a(aLBiometricsCallBackBean.faceImage, aLBiometricsCallBackBean.faceImageWidth, aLBiometricsCallBackBean.faceImageHeight);
        }

        private static Bitmap b(C3873c c3873c) {
            BiometricsBucketParams biometricsBucketParams;
            AbsBiometricsBucketParams.ALBiometricsCallBackBean aLBiometricsCallBackBean;
            if (c3873c == null || (biometricsBucketParams = c3873c.d) == null || (aLBiometricsCallBackBean = biometricsBucketParams.biometricsCallBackBean) == null) {
                return null;
            }
            return C3805b.a(aLBiometricsCallBackBean.faceImage, aLBiometricsCallBackBean.faceImageWidth, aLBiometricsCallBackBean.faceImageHeight);
        }

        @Override // com.alibaba.security.realidentity.business.InterfaceC3860b
        public final void a(C3873c c3873c) {
            a(RPResult.AUDIT_PASS, "0", "0", c3873c, "");
            C3865b c3865b = this.c;
            if (c3865b != null) {
                c3865b.a();
            }
        }

        @Override // com.alibaba.security.realidentity.business.InterfaceC3860b
        public final void a(C3873c c3873c, String str) {
            a(RPResult.AUDIT_EXCEPTION, "-10300", "-10300", c3873c, "Network Failure: ".concat(String.valueOf(str)));
            C3865b c3865b = this.c;
            if (c3865b != null) {
                c3865b.a();
            }
        }

        private void a(final RPResult rPResult, final String str, final String str2, final C3873c c3873c, final String str3) {
            if (this.a == null) {
                return;
            }
            this.d.execute(new Runnable() { // from class: com.alibaba.security.realidentity.business.a.a.2
                @Override // java.lang.Runnable
                public final void run() {
                    BiometricsBucketParams biometricsBucketParams;
                    AbsBiometricsBucketParams.ALBiometricsCallBackBean aLBiometricsCallBackBean;
                    C3873c c3873c2 = c3873c;
                    final RPDetail rPDetail = new RPDetail(str, str2, str3, (c3873c2 == null || (biometricsBucketParams = c3873c2.d) == null || (aLBiometricsCallBackBean = biometricsBucketParams.biometricsCallBackBean) == null) ? null : C3805b.a(aLBiometricsCallBackBean.faceImage, aLBiometricsCallBackBean.faceImageWidth, aLBiometricsCallBackBean.faceImageHeight));
                    HandlerC3859b handlerC3859b = C3858a.this.b;
                    if (handlerC3859b == null) {
                        return;
                    }
                    handlerC3859b.post(new Runnable() { // from class: com.alibaba.security.realidentity.business.a.a.2.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            C3858a.this.a.onFinish(rPResult, rPDetail);
                        }
                    });
                }
            });
        }

        @Override // com.alibaba.security.realidentity.business.InterfaceC3860b
        public final void a(BusinessType businessType, C3873c c3873c) {
            BucketParams.ErrorCode errorCode;
            int i = C3873c.AnonymousClass1.a[businessType.ordinal()];
            if (i == 1) {
                errorCode = c3873c.c.getErrorCode();
            } else if (i == 2) {
                errorCode = c3873c.g.getErrorCode();
            } else if (i == 3) {
                errorCode = c3873c.e.getErrorCode();
            } else if (i != 4) {
                errorCode = i != 5 ? null : c3873c.d.getErrorCode();
            } else {
                errorCode = c3873c.f.getErrorCode();
            }
            a(errorCode.audit, errorCode.errorCode, String.valueOf(errorCode.globalErrorCode), c3873c, errorCode.errorMsg);
            C3865b c3865b = this.c;
            if (c3865b != null) {
                c3865b.a();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.realidentity.business.a$b */
    /* loaded from: classes8.dex */
    static class HandlerC3859b extends Handler {
        public HandlerC3859b() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public final void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
        }
    }

    public C3857a(Context context, String str, RPEventListener rPEventListener) {
        this(context, str, rPEventListener, false);
    }

    private void a() {
        a(null);
    }

    public C3857a(Context context, String str, RPEventListener rPEventListener, boolean z) {
        try {
            C3865b c3865b = new C3865b(str);
            this.b = c3865b;
            if (z) {
                c3865b.a(new C3869a(context), new C3858a(rPEventListener, this.b)).a(new C3884d(context)).a(new C3886a(context));
            } else {
                c3865b.a(new C3876a(context), new C3858a(rPEventListener, this.b)).a(new C3869a(context)).a(new C3884d(context)).a(new C3886a(context)).a(new C3877a(context));
            }
        } catch (IllegalAccessException unused) {
            C3800a.b();
        }
    }

    public final void a(BusinessHeadParams businessHeadParams) {
        C3865b c3865b = this.b;
        if (c3865b != null) {
            c3865b.a(businessHeadParams);
        }
    }
}
