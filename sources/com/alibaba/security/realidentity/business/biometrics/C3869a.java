package com.alibaba.security.realidentity.business.biometrics;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.security.biometrics.ALBiometricsEventListener;
import com.alibaba.security.biometrics.ALBiometricsNavigator;
import com.alibaba.security.biometrics.service.listener.OnRetryListener;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.alibaba.security.biometrics.service.model.result.ALBiometricsResult;
import com.alibaba.security.biometrics.theme.ALBiometricsConfig;
import com.alibaba.security.common.d.C3805b;
import com.alibaba.security.common.d.C3808e;
import com.alibaba.security.common.track.model.C3834a;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.realidentity.AbstractC3853b;
import com.alibaba.security.realidentity.C3839a;
import com.alibaba.security.realidentity.RPDetail;
import com.alibaba.security.realidentity.RPEventListener;
import com.alibaba.security.realidentity.RPResult;
import com.alibaba.security.realidentity.a.AbstractC3841b;
import com.alibaba.security.realidentity.a.C3847g;
import com.alibaba.security.realidentity.business.C3873c;
import com.alibaba.security.realidentity.business.base.AbstractC3862b;
import com.alibaba.security.realidentity.business.base.chain.BusinessType;
import com.alibaba.security.realidentity.business.biometrics.AbsBiometricsBucketParams;
import com.alibaba.security.realidentity.business.bucket.BucketParams;
import com.alibaba.security.realidentity.business.start.ExtrasBean;
import com.alibaba.security.realidentity.business.start.StartHttpParams;
import com.alibaba.security.realidentity.f.C3892a;
import com.alibaba.security.realidentity.http.RpcInvoker;
import com.alibaba.security.realidentity.jsbridge.AbstractC3893a;
import com.alibaba.security.realidentity.upload.C3918b;
import com.alibaba.security.realidentity.upload.UploadFileModel;
import com.alibaba.security.realidentity.upload.a.AbstractC3917a;
import com.alibaba.security.realidentity.upload.b.InterfaceC3921b;
import com.taobao.android.abilitykit.AKBaseAbility;
import com.uc.webview.export.media.MessageID;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* renamed from: com.alibaba.security.realidentity.business.biometrics.a */
/* loaded from: classes8.dex */
public final class C3869a extends AbstractC3862b {
    public static final String d = "4";
    public static final String e = "10";
    private static final String j = "BiometricFail";
    private static final String k = "INITIATIVE_QUIT";
    final C3892a f;
    AbsBiometricsBucketParams g;
    ALBiometricsResult h;
    boolean i;
    private final AbstractC3917a l;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.realidentity.business.biometrics.a$a */
    /* loaded from: classes8.dex */
    class C3870a implements ALBiometricsEventListener {
        private final AbstractC3862b.InterfaceC3863a b;
        private final C3869a d;
        private byte[] e;
        private int f;
        private int g;
        private final ThreadPoolExecutor h;
        private final RPEventListener c = C3847g.C3848a.a.h;
        private HandlerC3871b i = new HandlerC3871b();

        C3870a(AbstractC3862b.InterfaceC3863a interfaceC3863a) {
            this.b = interfaceC3863a;
            this.d = C3869a.this;
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.alibaba.security.realidentity.business.biometrics.a.a.1
                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(Runnable runnable) {
                    return new Thread(runnable, "rpsdk-bitmapProcess_1");
                }
            });
            this.h = threadPoolExecutor;
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        }

        @Override // com.alibaba.security.biometrics.jni.listener.OnSgProcessListener
        public final String getAppKey() {
            return C3847g.C3848a.a.i.d();
        }

        @Override // com.alibaba.security.biometrics.ALBiometricsEventListener
        public final void onBeforeRetry(OnRetryListener onRetryListener, String str, String str2) {
            C3869a c3869a = C3869a.this;
            AbsBiometricsBucketParams absBiometricsBucketParams = c3869a.g;
            if (absBiometricsBucketParams == null) {
                onRetryListener.onRetry(0);
            } else {
                absBiometricsBucketParams.riskEvent(c3869a.b, onRetryListener, str, str2, C3869a.j, "1");
            }
        }

        @Override // com.alibaba.security.biometrics.ALBiometricsEventListener
        public final void onBiometricsFinish(int i) {
            RPEventListener rPEventListener = this.c;
            if (rPEventListener != null) {
                rPEventListener.onBiometricsFinish(i);
            }
        }

        @Override // com.alibaba.security.biometrics.ALBiometricsEventListener
        public final void onBiometricsStart() {
            RPEventListener rPEventListener = this.c;
            if (rPEventListener != null) {
                rPEventListener.onBiometricsStart();
            }
        }

        @Override // com.alibaba.security.biometrics.ALBiometricsEventListener
        public final void onBusinessOk() {
            final AbstractC3853b abstractC3853b = C3847g.C3848a.a.h;
            if (abstractC3853b == null) {
                return;
            }
            this.h.execute(new Runnable() { // from class: com.alibaba.security.realidentity.business.biometrics.a.a.2
                @Override // java.lang.Runnable
                public final void run() {
                    final RPDetail rPDetail = new RPDetail("0", "0", "", C3805b.a(C3870a.this.e, C3870a.this.f, C3870a.this.g));
                    if (C3870a.this.i != null) {
                        C3870a.this.i.post(new Runnable() { // from class: com.alibaba.security.realidentity.business.biometrics.a.a.2.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                abstractC3853b.onFinish(RPResult.AUDIT_PASS, rPDetail);
                                C3847g.C3848a.a.h = null;
                            }
                        });
                    }
                }
            });
        }

        @Override // com.alibaba.security.biometrics.ALBiometricsEventListener
        public final void onCancel(int i, String str, String str2) {
            onSensorStop();
            C3869a c3869a = C3869a.this;
            c3869a.g.riskEvent(c3869a.b, null, str, str2, C3869a.k, "6");
            AbsBiometricsBucketParams.ALBiometricsCallBackBean aLBiometricsCallBackBean = new AbsBiometricsBucketParams.ALBiometricsCallBackBean();
            aLBiometricsCallBackBean.errorCode = i;
            aLBiometricsCallBackBean.errorMsg = "onCancel";
            aLBiometricsCallBackBean.faceImage = this.e;
            aLBiometricsCallBackBean.faceImageWidth = this.f;
            aLBiometricsCallBackBean.faceImageHeight = this.g;
            C3869a.this.g.setBiometricsCallBackBean(aLBiometricsCallBackBean);
            AbstractC3862b.InterfaceC3863a interfaceC3863a = this.b;
            if (interfaceC3863a != null) {
                interfaceC3863a.b(C3869a.this.g, true);
            }
        }

        @Override // com.alibaba.security.biometrics.ALBiometricsEventListener
        public final void onError(int i, Bundle bundle) {
            if (bundle == null || !bundle.containsKey(ALBiometricsKeys.KEY_RESULT_DATA)) {
                return;
            }
            ALBiometricsResult aLBiometricsResult = (ALBiometricsResult) bundle.getSerializable(ALBiometricsKeys.KEY_RESULT_DATA);
            onSensorStop();
            C3869a.a(C3869a.this, a(aLBiometricsResult, false), false, "4");
            this.d.h = aLBiometricsResult;
            if (this.b != null) {
                AbsBiometricsBucketParams.ALBiometricsCallBackBean aLBiometricsCallBackBean = new AbsBiometricsBucketParams.ALBiometricsCallBackBean();
                aLBiometricsCallBackBean.errorCode = i;
                aLBiometricsCallBackBean.errorMsg = MessageID.onError;
                aLBiometricsCallBackBean.faceImage = this.e;
                aLBiometricsCallBackBean.faceImageWidth = this.f;
                aLBiometricsCallBackBean.faceImageHeight = this.g;
                C3869a.this.g.setBiometricsCallBackBean(aLBiometricsCallBackBean);
                C3869a.this.g.setAlBiometricsResult(aLBiometricsResult);
                this.d.i = false;
                this.b.b(C3869a.this.g, true);
            }
        }

        @Override // com.alibaba.security.biometrics.ALBiometricsEventListener
        public final void onFinish(int i, boolean z) {
            if (z) {
                AbsBiometricsBucketParams.ALBiometricsCallBackBean aLBiometricsCallBackBean = new AbsBiometricsBucketParams.ALBiometricsCallBackBean();
                aLBiometricsCallBackBean.errorCode = i;
                aLBiometricsCallBackBean.errorMsg = "";
                C3869a.this.g.setBiometricsCallBackBean(aLBiometricsCallBackBean);
                if (i == 0) {
                    onSensorStop();
                    this.d.g.setCalledFinishSuccessfully(true);
                    this.b.a(C3869a.this.g, true);
                    return;
                }
                this.b.b(C3869a.this.g, true);
            }
        }

        @Override // com.alibaba.security.biometrics.ALBiometricsEventListener
        public final void onFrameResult(byte[] bArr, int i, int i2) {
            if (bArr == null || i <= 0 || i2 <= 0) {
                return;
            }
            this.e = bArr;
            this.f = i;
            this.g = i2;
        }

        @Override // com.alibaba.security.biometrics.service.listener.OnLogTrackListener
        public final void onLogTrack(TrackLog trackLog) {
            C3847g unused = C3847g.C3848a.a;
            C3847g.a(C3869a.this.c, trackLog);
        }

        @Override // com.alibaba.security.biometrics.service.listener.OnLogTrackListener
        public final void onOldLogRecord(Bundle bundle) {
            HashMap hashMap = new HashMap();
            if (bundle != null) {
                for (String str : bundle.keySet()) {
                    hashMap.put(str, bundle.get(str));
                }
                try {
                    AbstractC3841b.a().a(hashMap);
                } catch (Throwable unused) {
                }
            }
        }

        @Override // com.alibaba.security.biometrics.service.listener.OnSensorTrackListener
        public final void onSensorReset() {
            C3847g unused = C3847g.C3848a.a;
        }

        @Override // com.alibaba.security.biometrics.service.listener.OnSensorTrackListener
        public final void onSensorStart() {
            C3847g unused = C3847g.C3848a.a;
        }

        @Override // com.alibaba.security.biometrics.service.listener.OnSensorTrackListener
        public final void onSensorStop() {
            C3847g unused = C3847g.C3848a.a;
        }

        @Override // com.alibaba.security.biometrics.ALBiometricsEventListener
        public final void onSuccess(ALBiometricsResult aLBiometricsResult) {
            AbsBiometricsBucketParams.ALBiometricsCallBackBean aLBiometricsCallBackBean = new AbsBiometricsBucketParams.ALBiometricsCallBackBean();
            this.d.h = aLBiometricsResult;
            aLBiometricsCallBackBean.errorMsg = "";
            aLBiometricsCallBackBean.errorCode = 0;
            aLBiometricsCallBackBean.faceImage = this.e;
            aLBiometricsCallBackBean.faceImageWidth = this.f;
            aLBiometricsCallBackBean.faceImageHeight = this.g;
            C3869a.this.g.setBiometricsCallBackBean(aLBiometricsCallBackBean);
            if (aLBiometricsResult == null) {
                aLBiometricsCallBackBean.errorCode = -10000;
                aLBiometricsCallBackBean.errorMsg = "biometricsResult is null";
                this.b.b(C3869a.this.g, true);
                return;
            }
            C3869a.this.g.setAlBiometricsResult(aLBiometricsResult);
            if (aLBiometricsResult.getQi() == null) {
                aLBiometricsCallBackBean.errorCode = -10000;
                aLBiometricsCallBackBean.errorMsg = "biometricsResult qi result is null";
                this.b.b(C3869a.this.g, true);
                return;
            }
            C3869a.a(C3869a.this, a(aLBiometricsResult, true), true, "4");
            onSensorStop();
            this.d.i = true;
            this.b.a(C3869a.this.g, true);
        }

        @Override // com.alibaba.security.biometrics.jni.listener.OnSgProcessListener
        public final String sign(String str) {
            return C3847g.C3848a.a.i.b(str);
        }

        private static String a(ALBiometricsResult aLBiometricsResult, boolean z) {
            if (aLBiometricsResult == null) {
                return null;
            }
            return z ? aLBiometricsResult.getVideoS() : aLBiometricsResult.getVideoF();
        }

        private static String a(ALBiometricsResult aLBiometricsResult) {
            if (aLBiometricsResult == null) {
                return null;
            }
            return aLBiometricsResult.getDazzleVideoPath();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.realidentity.business.biometrics.a$b */
    /* loaded from: classes8.dex */
    static class HandlerC3871b extends Handler {
        public HandlerC3871b() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public final void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
        }
    }

    public C3869a(Context context) {
        super(context);
        this.h = null;
        this.i = false;
        C3918b unused = C3918b.C3919a.a;
        AbstractC3917a a = C3918b.a(context);
        this.l = a;
        a.b = this.c;
        this.f = new C3892a(context);
    }

    @Override // com.alibaba.security.realidentity.business.base.AbstractC3862b
    public final String b() {
        return "";
    }

    @Override // com.alibaba.security.realidentity.business.base.AbstractC3862b
    public final String c() {
        return "";
    }

    @Override // com.alibaba.security.realidentity.business.base.AbstractC3862b
    public final String d() {
        return C3834a.C3837c.e;
    }

    @Override // com.alibaba.security.realidentity.business.base.AbstractC3862b
    public final String e() {
        return C3834a.C3836b.G;
    }

    @Override // com.alibaba.security.realidentity.business.base.AbstractC3862b
    public final String f() {
        return C3834a.C3836b.G;
    }

    @Override // com.alibaba.security.realidentity.business.base.AbstractC3862b
    public final String g() {
        return "";
    }

    @Override // com.alibaba.security.realidentity.business.base.AbstractC3862b
    public final void h() {
        this.g.finishTask(this.b, this.i, new BucketParams.InterfaceC3872a() { // from class: com.alibaba.security.realidentity.business.biometrics.a.2
            @Override // com.alibaba.security.realidentity.business.bucket.BucketParams.InterfaceC3872a
            public final void a() {
            }
        }, this.h);
    }

    @Override // com.alibaba.security.realidentity.business.base.AbstractC3862b
    public final BusinessType i() {
        return BusinessType.ALBIOMETERICS;
    }

    private void c(C3873c c3873c, BucketParams bucketParams) {
        ALBiometricsNavigator aLBiometricsNavigator = c3873c.d.biometricsNavigator;
        int i = bucketParams.getErrorCode().globalErrorCode;
        String str = bucketParams.getErrorCode().errorMsg;
        if (this.g.isNeedBioResultPage) {
            Bundle bundle = new Bundle();
            bundle.putInt(ALBiometricsKeys.KEY_ERROR_DETECT_K, i);
            bundle.putString(ALBiometricsKeys.KEY_ERROR_DETECT_MSG_K, str);
            aLBiometricsNavigator.restart(this.b, bundle);
            c3873c.d();
            return;
        }
        aLBiometricsNavigator.finish(this.b);
    }

    @Override // com.alibaba.security.realidentity.business.base.AbstractC3862b
    public final void b(C3873c c3873c, BucketParams bucketParams) {
        c(c3873c, bucketParams);
    }

    private void b(C3873c c3873c) {
        ALBiometricsNavigator aLBiometricsNavigator = c3873c.d.biometricsNavigator;
        if (this.g.isNeedBioResultPage) {
            aLBiometricsNavigator.restart(this.b, null);
        } else {
            aLBiometricsNavigator.finish(this.b);
        }
    }

    @Override // com.alibaba.security.realidentity.business.base.AbstractC3862b
    public final void a(C3873c c3873c, BucketParams bucketParams) {
        c(c3873c, bucketParams);
    }

    @Override // com.alibaba.security.realidentity.business.base.AbstractC3862b
    public final void a(C3873c c3873c, final AbstractC3862b.InterfaceC3863a interfaceC3863a) {
        ExtrasBean extrasBean;
        this.g = c3873c.d;
        ALBiometricsConfig biometricsConfig = C3847g.C3848a.a.b() != null ? C3847g.C3848a.a.b().getBiometricsConfig() : null;
        StartHttpParams startHttpParams = c3873c.c;
        if (startHttpParams != null) {
            this.g.isNeedBioResultPage = startHttpParams.mShowResult;
        }
        this.g.setCalledFinishSuccessfully(false);
        StartHttpParams startHttpParams2 = c3873c.c;
        if (startHttpParams2 == null || (extrasBean = startHttpParams2.mExtrasBean) == null || TextUtils.isEmpty(extrasBean.getSgConfig())) {
            C3847g unused = C3847g.C3848a.a;
        } else {
            C3847g unused2 = C3847g.C3848a.a;
            startHttpParams2.mExtrasBean.getSgConfig();
        }
        ALBiometricsNavigator aLBiometricsNavigator = new ALBiometricsNavigator(this.b) { // from class: com.alibaba.security.realidentity.business.biometrics.a.1
            @Override // com.alibaba.security.biometrics.ALBiometricsNavigator
            public final ALBiometricsEventListener getEventListener() {
                return new C3870a(interfaceC3863a);
            }

            @Override // com.alibaba.security.biometrics.ALBiometricsNavigator
            public final Bundle getParams() {
                return C3869a.this.g.getBundle();
            }
        };
        this.g.biometricsNavigator = aLBiometricsNavigator;
        aLBiometricsNavigator.start(this.b, biometricsConfig);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.realidentity.business.biometrics.a$3  reason: invalid class name */
    /* loaded from: classes8.dex */
    public final class AnonymousClass3 implements InterfaceC3921b {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;

        AnonymousClass3(String str, String str2, String str3, String str4, String str5) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.e = str5;
        }

        @Override // com.alibaba.security.realidentity.upload.b.InterfaceC3921b
        public final void a(long j, long j2) {
        }

        @Override // com.alibaba.security.realidentity.upload.b.InterfaceC3921b
        public final void a(String str) {
            C3869a c3869a = C3869a.this;
            C3892a c3892a = c3869a.f;
            String str2 = this.a;
            String str3 = this.b;
            boolean z = c3869a.g.getBundle().getBoolean(ALBiometricsKeys.KEY_SESSION_LESS);
            String str4 = this.c;
            String str5 = this.d;
            HashMap hashMap = new HashMap();
            hashMap.put(AbstractC3893a.d, str2);
            hashMap.put("eventCode", str4);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("timestamp", (Object) Long.valueOf(System.currentTimeMillis()));
            jSONObject.put("type", (Object) str3);
            jSONObject.put("url", (Object) str);
            jSONObject.put("conf", (Object) str5);
            hashMap.put("eventData", jSONObject.toJSONString());
            RpcInvoker.callMtopAsync(c3892a.a, z ? C3839a.b : C3839a.a, "1.0", true, hashMap);
            C3808e.b(this.e);
        }

        @Override // com.alibaba.security.realidentity.upload.b.InterfaceC3921b
        public final void b(String str) {
            C3808e.b(this.e);
        }

        @Override // com.alibaba.security.realidentity.upload.b.InterfaceC3921b
        public final void a() {
            C3808e.b(this.e);
        }
    }

    private static void a(StartHttpParams startHttpParams) {
        ExtrasBean extrasBean;
        if (startHttpParams == null || (extrasBean = startHttpParams.mExtrasBean) == null || TextUtils.isEmpty(extrasBean.getSgConfig())) {
            C3847g unused = C3847g.C3848a.a;
            return;
        }
        C3847g unused2 = C3847g.C3848a.a;
        startHttpParams.mExtrasBean.getSgConfig();
    }

    private void a(String str, boolean z, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        UploadFileModel uploadFileModel = new UploadFileModel();
        String str4 = this.c;
        String format = new SimpleDateFormat("yyyyMMdd").format(Long.valueOf(System.currentTimeMillis()));
        String str5 = z ? "success" : AKBaseAbility.CALLBACK_FAILURE;
        uploadFileModel.setDestDir("biometric/video/" + format + "/" + str4 + "/" + str5);
        uploadFileModel.setFileType("h264");
        uploadFileModel.setLocalFilePath(str);
        uploadFileModel.setRemoteFileName(new File(str).getName());
        this.l.a(uploadFileModel, new AnonymousClass3(str4, str5, str2, str3, str));
    }

    @Override // com.alibaba.security.realidentity.business.base.AbstractC3862b
    public final void a(C3873c c3873c) {
        ALBiometricsNavigator aLBiometricsNavigator = c3873c.d.biometricsNavigator;
        if (this.g.isNeedBioResultPage) {
            aLBiometricsNavigator.restart(this.b, null);
        } else {
            aLBiometricsNavigator.finish(this.b);
        }
    }

    static /* synthetic */ void a(C3869a c3869a, String str, boolean z, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        UploadFileModel uploadFileModel = new UploadFileModel();
        String str3 = c3869a.c;
        String format = new SimpleDateFormat("yyyyMMdd").format(Long.valueOf(System.currentTimeMillis()));
        String str4 = z ? "success" : AKBaseAbility.CALLBACK_FAILURE;
        uploadFileModel.setDestDir("biometric/video/" + format + "/" + str3 + "/" + str4);
        uploadFileModel.setFileType("h264");
        uploadFileModel.setLocalFilePath(str);
        uploadFileModel.setRemoteFileName(new File(str).getName());
        c3869a.l.a(uploadFileModel, new AnonymousClass3(str3, str4, str2, null, str));
    }
}
