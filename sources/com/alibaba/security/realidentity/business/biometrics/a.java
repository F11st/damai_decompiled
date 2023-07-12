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
import com.alibaba.security.common.d.e;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.common.track.model.a;
import com.alibaba.security.realidentity.RPDetail;
import com.alibaba.security.realidentity.RPEventListener;
import com.alibaba.security.realidentity.RPResult;
import com.alibaba.security.realidentity.a.g;
import com.alibaba.security.realidentity.business.base.b;
import com.alibaba.security.realidentity.business.base.chain.BusinessType;
import com.alibaba.security.realidentity.business.biometrics.AbsBiometricsBucketParams;
import com.alibaba.security.realidentity.business.bucket.BucketParams;
import com.alibaba.security.realidentity.business.c;
import com.alibaba.security.realidentity.business.start.ExtrasBean;
import com.alibaba.security.realidentity.business.start.StartHttpParams;
import com.alibaba.security.realidentity.http.RpcInvoker;
import com.alibaba.security.realidentity.upload.UploadFileModel;
import com.alibaba.security.realidentity.upload.b;
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
/* loaded from: classes8.dex */
public final class a extends com.alibaba.security.realidentity.business.base.b {
    public static final String d = "4";
    public static final String e = "10";
    private static final String j = "BiometricFail";
    private static final String k = "INITIATIVE_QUIT";
    final com.alibaba.security.realidentity.f.a f;
    AbsBiometricsBucketParams g;
    ALBiometricsResult h;
    boolean i;
    private final com.alibaba.security.realidentity.upload.a.a l;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.realidentity.business.biometrics.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    class C0169a implements ALBiometricsEventListener {
        private final b.a b;
        private final a d;
        private byte[] e;
        private int f;
        private int g;
        private final ThreadPoolExecutor h;
        private final RPEventListener c = g.a.a.h;
        private b i = new b();

        C0169a(b.a aVar) {
            this.b = aVar;
            this.d = a.this;
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
            return g.a.a.i.d();
        }

        @Override // com.alibaba.security.biometrics.ALBiometricsEventListener
        public final void onBeforeRetry(OnRetryListener onRetryListener, String str, String str2) {
            a aVar = a.this;
            AbsBiometricsBucketParams absBiometricsBucketParams = aVar.g;
            if (absBiometricsBucketParams == null) {
                onRetryListener.onRetry(0);
            } else {
                absBiometricsBucketParams.riskEvent(aVar.b, onRetryListener, str, str2, a.j, "1");
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
            final com.alibaba.security.realidentity.b bVar = g.a.a.h;
            if (bVar == null) {
                return;
            }
            this.h.execute(new Runnable() { // from class: com.alibaba.security.realidentity.business.biometrics.a.a.2
                @Override // java.lang.Runnable
                public final void run() {
                    final RPDetail rPDetail = new RPDetail("0", "0", "", com.alibaba.security.common.d.b.a(C0169a.this.e, C0169a.this.f, C0169a.this.g));
                    if (C0169a.this.i != null) {
                        C0169a.this.i.post(new Runnable() { // from class: com.alibaba.security.realidentity.business.biometrics.a.a.2.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                bVar.onFinish(RPResult.AUDIT_PASS, rPDetail);
                                g.a.a.h = null;
                            }
                        });
                    }
                }
            });
        }

        @Override // com.alibaba.security.biometrics.ALBiometricsEventListener
        public final void onCancel(int i, String str, String str2) {
            onSensorStop();
            a aVar = a.this;
            aVar.g.riskEvent(aVar.b, null, str, str2, a.k, "6");
            AbsBiometricsBucketParams.ALBiometricsCallBackBean aLBiometricsCallBackBean = new AbsBiometricsBucketParams.ALBiometricsCallBackBean();
            aLBiometricsCallBackBean.errorCode = i;
            aLBiometricsCallBackBean.errorMsg = "onCancel";
            aLBiometricsCallBackBean.faceImage = this.e;
            aLBiometricsCallBackBean.faceImageWidth = this.f;
            aLBiometricsCallBackBean.faceImageHeight = this.g;
            a.this.g.setBiometricsCallBackBean(aLBiometricsCallBackBean);
            b.a aVar2 = this.b;
            if (aVar2 != null) {
                aVar2.b(a.this.g, true);
            }
        }

        @Override // com.alibaba.security.biometrics.ALBiometricsEventListener
        public final void onError(int i, Bundle bundle) {
            if (bundle == null || !bundle.containsKey(ALBiometricsKeys.KEY_RESULT_DATA)) {
                return;
            }
            ALBiometricsResult aLBiometricsResult = (ALBiometricsResult) bundle.getSerializable(ALBiometricsKeys.KEY_RESULT_DATA);
            onSensorStop();
            a.a(a.this, a(aLBiometricsResult, false), false, "4");
            this.d.h = aLBiometricsResult;
            if (this.b != null) {
                AbsBiometricsBucketParams.ALBiometricsCallBackBean aLBiometricsCallBackBean = new AbsBiometricsBucketParams.ALBiometricsCallBackBean();
                aLBiometricsCallBackBean.errorCode = i;
                aLBiometricsCallBackBean.errorMsg = MessageID.onError;
                aLBiometricsCallBackBean.faceImage = this.e;
                aLBiometricsCallBackBean.faceImageWidth = this.f;
                aLBiometricsCallBackBean.faceImageHeight = this.g;
                a.this.g.setBiometricsCallBackBean(aLBiometricsCallBackBean);
                a.this.g.setAlBiometricsResult(aLBiometricsResult);
                this.d.i = false;
                this.b.b(a.this.g, true);
            }
        }

        @Override // com.alibaba.security.biometrics.ALBiometricsEventListener
        public final void onFinish(int i, boolean z) {
            if (z) {
                AbsBiometricsBucketParams.ALBiometricsCallBackBean aLBiometricsCallBackBean = new AbsBiometricsBucketParams.ALBiometricsCallBackBean();
                aLBiometricsCallBackBean.errorCode = i;
                aLBiometricsCallBackBean.errorMsg = "";
                a.this.g.setBiometricsCallBackBean(aLBiometricsCallBackBean);
                if (i == 0) {
                    onSensorStop();
                    this.d.g.setCalledFinishSuccessfully(true);
                    this.b.a(a.this.g, true);
                    return;
                }
                this.b.b(a.this.g, true);
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
            g unused = g.a.a;
            g.a(a.this.c, trackLog);
        }

        @Override // com.alibaba.security.biometrics.service.listener.OnLogTrackListener
        public final void onOldLogRecord(Bundle bundle) {
            HashMap hashMap = new HashMap();
            if (bundle != null) {
                for (String str : bundle.keySet()) {
                    hashMap.put(str, bundle.get(str));
                }
                try {
                    com.alibaba.security.realidentity.a.b.a().a(hashMap);
                } catch (Throwable unused) {
                }
            }
        }

        @Override // com.alibaba.security.biometrics.service.listener.OnSensorTrackListener
        public final void onSensorReset() {
            g unused = g.a.a;
        }

        @Override // com.alibaba.security.biometrics.service.listener.OnSensorTrackListener
        public final void onSensorStart() {
            g unused = g.a.a;
        }

        @Override // com.alibaba.security.biometrics.service.listener.OnSensorTrackListener
        public final void onSensorStop() {
            g unused = g.a.a;
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
            a.this.g.setBiometricsCallBackBean(aLBiometricsCallBackBean);
            if (aLBiometricsResult == null) {
                aLBiometricsCallBackBean.errorCode = -10000;
                aLBiometricsCallBackBean.errorMsg = "biometricsResult is null";
                this.b.b(a.this.g, true);
                return;
            }
            a.this.g.setAlBiometricsResult(aLBiometricsResult);
            if (aLBiometricsResult.getQi() == null) {
                aLBiometricsCallBackBean.errorCode = -10000;
                aLBiometricsCallBackBean.errorMsg = "biometricsResult qi result is null";
                this.b.b(a.this.g, true);
                return;
            }
            a.a(a.this, a(aLBiometricsResult, true), true, "4");
            onSensorStop();
            this.d.i = true;
            this.b.a(a.this.g, true);
        }

        @Override // com.alibaba.security.biometrics.jni.listener.OnSgProcessListener
        public final String sign(String str) {
            return g.a.a.i.b(str);
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

    public a(Context context) {
        super(context);
        this.h = null;
        this.i = false;
        com.alibaba.security.realidentity.upload.b unused = b.a.a;
        com.alibaba.security.realidentity.upload.a.a a = com.alibaba.security.realidentity.upload.b.a(context);
        this.l = a;
        a.b = this.c;
        this.f = new com.alibaba.security.realidentity.f.a(context);
    }

    @Override // com.alibaba.security.realidentity.business.base.b
    public final String b() {
        return "";
    }

    @Override // com.alibaba.security.realidentity.business.base.b
    public final String c() {
        return "";
    }

    @Override // com.alibaba.security.realidentity.business.base.b
    public final String d() {
        return a.c.e;
    }

    @Override // com.alibaba.security.realidentity.business.base.b
    public final String e() {
        return a.b.G;
    }

    @Override // com.alibaba.security.realidentity.business.base.b
    public final String f() {
        return a.b.G;
    }

    @Override // com.alibaba.security.realidentity.business.base.b
    public final String g() {
        return "";
    }

    @Override // com.alibaba.security.realidentity.business.base.b
    public final void h() {
        this.g.finishTask(this.b, this.i, new BucketParams.a() { // from class: com.alibaba.security.realidentity.business.biometrics.a.2
            @Override // com.alibaba.security.realidentity.business.bucket.BucketParams.a
            public final void a() {
            }
        }, this.h);
    }

    @Override // com.alibaba.security.realidentity.business.base.b
    public final BusinessType i() {
        return BusinessType.ALBIOMETERICS;
    }

    private void c(c cVar, BucketParams bucketParams) {
        ALBiometricsNavigator aLBiometricsNavigator = cVar.d.biometricsNavigator;
        int i = bucketParams.getErrorCode().globalErrorCode;
        String str = bucketParams.getErrorCode().errorMsg;
        if (this.g.isNeedBioResultPage) {
            Bundle bundle = new Bundle();
            bundle.putInt(ALBiometricsKeys.KEY_ERROR_DETECT_K, i);
            bundle.putString(ALBiometricsKeys.KEY_ERROR_DETECT_MSG_K, str);
            aLBiometricsNavigator.restart(this.b, bundle);
            cVar.d();
            return;
        }
        aLBiometricsNavigator.finish(this.b);
    }

    @Override // com.alibaba.security.realidentity.business.base.b
    public final void b(c cVar, BucketParams bucketParams) {
        c(cVar, bucketParams);
    }

    private void b(c cVar) {
        ALBiometricsNavigator aLBiometricsNavigator = cVar.d.biometricsNavigator;
        if (this.g.isNeedBioResultPage) {
            aLBiometricsNavigator.restart(this.b, null);
        } else {
            aLBiometricsNavigator.finish(this.b);
        }
    }

    @Override // com.alibaba.security.realidentity.business.base.b
    public final void a(c cVar, BucketParams bucketParams) {
        c(cVar, bucketParams);
    }

    @Override // com.alibaba.security.realidentity.business.base.b
    public final void a(c cVar, final b.a aVar) {
        ExtrasBean extrasBean;
        this.g = cVar.d;
        ALBiometricsConfig biometricsConfig = g.a.a.b() != null ? g.a.a.b().getBiometricsConfig() : null;
        StartHttpParams startHttpParams = cVar.c;
        if (startHttpParams != null) {
            this.g.isNeedBioResultPage = startHttpParams.mShowResult;
        }
        this.g.setCalledFinishSuccessfully(false);
        StartHttpParams startHttpParams2 = cVar.c;
        if (startHttpParams2 == null || (extrasBean = startHttpParams2.mExtrasBean) == null || TextUtils.isEmpty(extrasBean.getSgConfig())) {
            g unused = g.a.a;
        } else {
            g unused2 = g.a.a;
            startHttpParams2.mExtrasBean.getSgConfig();
        }
        ALBiometricsNavigator aLBiometricsNavigator = new ALBiometricsNavigator(this.b) { // from class: com.alibaba.security.realidentity.business.biometrics.a.1
            @Override // com.alibaba.security.biometrics.ALBiometricsNavigator
            public final ALBiometricsEventListener getEventListener() {
                return new C0169a(aVar);
            }

            @Override // com.alibaba.security.biometrics.ALBiometricsNavigator
            public final Bundle getParams() {
                return a.this.g.getBundle();
            }
        };
        this.g.biometricsNavigator = aLBiometricsNavigator;
        aLBiometricsNavigator.start(this.b, biometricsConfig);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.realidentity.business.biometrics.a$3  reason: invalid class name */
    /* loaded from: classes8.dex */
    public final class AnonymousClass3 implements com.alibaba.security.realidentity.upload.b.b {
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

        @Override // com.alibaba.security.realidentity.upload.b.b
        public final void a(long j, long j2) {
        }

        @Override // com.alibaba.security.realidentity.upload.b.b
        public final void a(String str) {
            a aVar = a.this;
            com.alibaba.security.realidentity.f.a aVar2 = aVar.f;
            String str2 = this.a;
            String str3 = this.b;
            boolean z = aVar.g.getBundle().getBoolean(ALBiometricsKeys.KEY_SESSION_LESS);
            String str4 = this.c;
            String str5 = this.d;
            HashMap hashMap = new HashMap();
            hashMap.put(com.alibaba.security.realidentity.jsbridge.a.d, str2);
            hashMap.put("eventCode", str4);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("timestamp", (Object) Long.valueOf(System.currentTimeMillis()));
            jSONObject.put("type", (Object) str3);
            jSONObject.put("url", (Object) str);
            jSONObject.put("conf", (Object) str5);
            hashMap.put("eventData", jSONObject.toJSONString());
            RpcInvoker.callMtopAsync(aVar2.a, z ? com.alibaba.security.realidentity.a.b : com.alibaba.security.realidentity.a.a, "1.0", true, hashMap);
            e.b(this.e);
        }

        @Override // com.alibaba.security.realidentity.upload.b.b
        public final void b(String str) {
            e.b(this.e);
        }

        @Override // com.alibaba.security.realidentity.upload.b.b
        public final void a() {
            e.b(this.e);
        }
    }

    private static void a(StartHttpParams startHttpParams) {
        ExtrasBean extrasBean;
        if (startHttpParams == null || (extrasBean = startHttpParams.mExtrasBean) == null || TextUtils.isEmpty(extrasBean.getSgConfig())) {
            g unused = g.a.a;
            return;
        }
        g unused2 = g.a.a;
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

    @Override // com.alibaba.security.realidentity.business.base.b
    public final void a(c cVar) {
        ALBiometricsNavigator aLBiometricsNavigator = cVar.d.biometricsNavigator;
        if (this.g.isNeedBioResultPage) {
            aLBiometricsNavigator.restart(this.b, null);
        } else {
            aLBiometricsNavigator.finish(this.b);
        }
    }

    static /* synthetic */ void a(a aVar, String str, boolean z, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        UploadFileModel uploadFileModel = new UploadFileModel();
        String str3 = aVar.c;
        String format = new SimpleDateFormat("yyyyMMdd").format(Long.valueOf(System.currentTimeMillis()));
        String str4 = z ? "success" : AKBaseAbility.CALLBACK_FAILURE;
        uploadFileModel.setDestDir("biometric/video/" + format + "/" + str3 + "/" + str4);
        uploadFileModel.setFileType("h264");
        uploadFileModel.setLocalFilePath(str);
        uploadFileModel.setRemoteFileName(new File(str).getName());
        aVar.l.a(uploadFileModel, new AnonymousClass3(str3, str4, str2, null, str));
    }
}
