package com.alibaba.security.biometrics.service.detector;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.alibaba.security.biometrics.jni.ALBiometricsJni;
import com.alibaba.security.biometrics.service.ALBiometricsServiceEventListener;
import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import org.apache.commons.net.SocketClient;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ABFaceRecapDetector {
    public static int ERROR_ANGLE_NOT_SUPPORT = -5;
    public static int ERROR_MODEL_NOT_FOUND = -2;
    public static int ERROR_NEON_NOT_SUPPORT = -3;
    public static int ERROR_NET_NOT_INITED = -6;
    public static int ERROR_PARAM_IS_NULL = -4;
    public static int ERROR_SO_NOTLOAD = -1;
    public static final int MODEL_LOAD_SUCCESS = 0;
    private static final String TAG = "ABFaceRecapDetector";
    private static ABFaceRecapDetector instance;
    private long detectTotalTime;
    private boolean isLoaded;
    private Context mContext;
    public ILocalFaceRecap mFaceRecapNet;
    private ALBiometricsParams mParams;
    private Handler mRecapHandler;
    private HandlerThread mRecapHandlerThread;
    private boolean detecting = false;
    private boolean generatingResult = false;
    private long lastDetectTime = 0;
    protected StringBuilder mRecapLogString = new StringBuilder(1024);
    private int frameCount = 0;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface OnEventListener {
        void onResult(int i, float[] fArr, String str);
    }

    private ABFaceRecapDetector() {
        this.detectTotalTime = 0L;
        this.detectTotalTime = 0L;
    }

    static /* synthetic */ int access$108(ABFaceRecapDetector aBFaceRecapDetector) {
        int i = aBFaceRecapDetector.frameCount;
        aBFaceRecapDetector.frameCount = i + 1;
        return i;
    }

    public static void dismiss() {
        instance = null;
    }

    public static ABFaceRecapDetector getInstance() {
        if (instance == null) {
            instance = new ABFaceRecapDetector();
        }
        return instance;
    }

    private void initRecap(Context context) {
        FaceRecapNetImpl faceRecapNetImpl = new FaceRecapNetImpl();
        this.mFaceRecapNet = faceRecapNetImpl;
        faceRecapNetImpl.prepare(context, new OnLocalRecapPreparedListener() { // from class: com.alibaba.security.biometrics.service.detector.ABFaceRecapDetector.1
            @Override // com.alibaba.security.biometrics.service.detector.OnLocalRecapPreparedListener
            public void onFailed(int i, Throwable th) {
                ABFaceRecapDetector.this.mFaceRecapNet = null;
            }

            @Override // com.alibaba.security.biometrics.service.detector.OnLocalRecapPreparedListener
            public void onProgressUpdate(int i) {
            }

            @Override // com.alibaba.security.biometrics.service.detector.OnLocalRecapPreparedListener
            public void onSucceeded(ILocalFaceRecap iLocalFaceRecap) {
                ABFaceRecapDetector.this.mFaceRecapNet = iLocalFaceRecap;
            }
        });
    }

    private void newRecapHandler() {
        if (this.mRecapHandlerThread == null) {
            HandlerThread handlerThread = new HandlerThread("ALBiometrics.ABFaceRecapDetector");
            this.mRecapHandlerThread = handlerThread;
            handlerThread.start();
            this.mRecapHandler = new Handler(this.mRecapHandlerThread.getLooper());
        }
    }

    public int doDetect(final byte[] bArr, final int i, final int i2, final int i3, float[] fArr, float[] fArr2) {
        if (ALBiometricsJni.isLoaded()) {
            if (fArr == null || fArr2 == null) {
                return ERROR_PARAM_IS_NULL;
            }
            if (i3 != 0) {
                return ERROR_ANGLE_NOT_SUPPORT;
            }
            if (this.mFaceRecapNet == null) {
                return ERROR_NET_NOT_INITED;
            }
            if (this.detecting || this.generatingResult || System.currentTimeMillis() - this.lastDetectTime <= 200) {
                return 0;
            }
            this.lastDetectTime = System.currentTimeMillis();
            newRecapHandler();
            this.mRecapHandler.post(new Runnable() { // from class: com.alibaba.security.biometrics.service.detector.ABFaceRecapDetector.2
                @Override // java.lang.Runnable
                public void run() {
                    if (ABFaceRecapDetector.this.detecting) {
                        return;
                    }
                    try {
                        ABFaceRecapDetector.this.detecting = true;
                        if (ALBiometricsJni.IsEnabled()) {
                            ABFaceRecapDetector.access$108(ABFaceRecapDetector.this);
                            long currentTimeMillis = System.currentTimeMillis();
                            ABFaceRecapDetector.this.mFaceRecapNet.inference(bArr, i, i2, i3);
                            ABFaceRecapDetector.this.detectTotalTime += System.currentTimeMillis() - currentTimeMillis;
                        }
                    } catch (Throwable unused) {
                    }
                    ABFaceRecapDetector.this.detecting = false;
                }
            });
            return 0;
        }
        return ERROR_SO_NOTLOAD;
    }

    public long getDetectTotalTime() {
        return this.detectTotalTime;
    }

    public int getFrameCount() {
        return this.frameCount;
    }

    public void getRecapResult(final OnEventListener onEventListener) {
        Handler handler;
        if (ALBiometricsJni.isLoaded() && ALBiometricsJni.IsEnabled() && this.frameCount > 0 && (handler = this.mRecapHandler) != null) {
            this.generatingResult = true;
            handler.post(new Runnable() { // from class: com.alibaba.security.biometrics.service.detector.ABFaceRecapDetector.3
                @Override // java.lang.Runnable
                public void run() {
                    float recapResult = ABFaceRecapDetector.this.mFaceRecapNet.getRecapResult();
                    StringBuilder sb = ABFaceRecapDetector.this.mRecapLogString;
                    sb.append("LivenessJni.GetCombinedRecapScore scoreResult scoreFinalResult=");
                    sb.append(recapResult);
                    sb.append(SocketClient.NETASCII_EOL);
                    OnEventListener onEventListener2 = onEventListener;
                    if (onEventListener2 != null) {
                        onEventListener2.onResult(0, new float[]{recapResult}, ABFaceRecapDetector.this.mRecapLogString.toString());
                    }
                }
            });
        } else if (onEventListener != null) {
            onEventListener.onResult(GlobalErrorCode.ERROR_ALGO_RECAP_INIT_FAIL, null, null);
        }
    }

    public int init(Context context, ALBiometricsParams aLBiometricsParams, ALBiometricsServiceEventListener aLBiometricsServiceEventListener) {
        this.mContext = context;
        this.mParams = aLBiometricsParams;
        if (!ALBiometricsJni.isLoaded()) {
            return ERROR_SO_NOTLOAD;
        }
        boolean z = ALBiometricsJni.checkLicense(context, aLBiometricsServiceEventListener) == 0;
        this.isLoaded = z;
        if (!z) {
            return ERROR_SO_NOTLOAD;
        }
        initRecap(context);
        reset();
        return 0;
    }

    public boolean isLoaded() {
        return ALBiometricsJni.isLoaded();
    }

    public void release() {
        Handler handler;
        if (ALBiometricsJni.isLoaded()) {
            ALBiometricsJni.release();
        }
        if (this.mFaceRecapNet != null && (handler = this.mRecapHandler) != null) {
            handler.post(new Runnable() { // from class: com.alibaba.security.biometrics.service.detector.ABFaceRecapDetector.4
                @Override // java.lang.Runnable
                public void run() {
                    ABFaceRecapDetector.this.mFaceRecapNet.release();
                }
            });
        }
        this.frameCount = 0;
        this.detectTotalTime = 0L;
        this.detecting = false;
    }

    public void reset() {
        initRecap(this.mContext);
        if (ALBiometricsJni.isLoaded()) {
            ALBiometricsJni.release();
        }
        this.frameCount = 0;
        this.detectTotalTime = 0L;
        this.detecting = false;
        this.generatingResult = false;
        StringBuilder sb = this.mRecapLogString;
        sb.delete(0, sb.length());
    }

    public ABFaceRecapDetector setDetectTotalTime(long j) {
        this.detectTotalTime = j;
        return this;
    }

    public ABFaceRecapDetector setFrameCount(int i) {
        this.frameCount = i;
        return this;
    }
}
