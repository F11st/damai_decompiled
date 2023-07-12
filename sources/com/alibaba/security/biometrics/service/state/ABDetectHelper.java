package com.alibaba.security.biometrics.service.state;

import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.SensorEvent;
import android.os.Bundle;
import android.os.Message;
import com.alibaba.security.biometrics.service.ALBiometricsService;
import com.alibaba.security.biometrics.service.common.ABLogRecorder;
import com.alibaba.security.biometrics.service.common.ABShakeListener;
import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.alibaba.security.biometrics.service.detector.ABFrameDetector;
import com.alibaba.security.biometrics.service.model.ABDetectContext;
import com.alibaba.security.biometrics.service.model.detector.ABDetectType;
import com.alibaba.security.biometrics.service.model.detector.ABDetector;
import com.alibaba.security.biometrics.service.model.detector.ABFaceFrame;
import com.alibaba.security.biometrics.service.model.detector.DetectInfo;
import com.alibaba.security.biometrics.service.model.listener.ABListenerOperator;
import com.alibaba.security.biometrics.service.model.listener.ParamBundleResult;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import com.alibaba.security.biometrics.service.model.result.ABActionResult;
import com.alibaba.security.biometrics.service.model.result.ABImageResult;
import com.alibaba.security.biometrics.service.model.result.ALBiometricsCodes;
import com.alibaba.security.biometrics.service.model.result.ALBiometricsResult;
import com.alibaba.security.common.c.a;
import com.alibaba.security.common.d.e;
import com.alibaba.security.common.d.j;
import com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect;
import com.taobao.weex.annotation.JSMethod;
import com.youku.arch.v3.view.render.RenderConstant;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ABDetectHelper {
    private static final int RESULT_ERROR = 1;
    private static final String TAG = "ABDetectHelper";
    private ALBiometricsParams mABParams;
    private ALBiometricsService mABService;
    private Context mContext;
    private ABFrameDetector mDetector;
    private ABListenerOperator mListenerOperator;
    private ABShakeListener mShakeListener;

    public ABDetectHelper(Context context, ALBiometricsService aLBiometricsService, ABFrameDetector aBFrameDetector) {
        this.mContext = context;
        this.mABService = aLBiometricsService;
        this.mDetector = aBFrameDetector;
        this.mABParams = aLBiometricsService.getParams();
        this.mShakeListener = new ABShakeListener(this.mContext);
        this.mListenerOperator = new ABListenerOperator(this.mABService);
    }

    public void changeDetectType(ABDetectType aBDetectType, boolean z, boolean z2) {
        ABFrameDetector aBFrameDetector = this.mDetector;
        if (aBFrameDetector != null) {
            if (z) {
                aBFrameDetector.reset(z2);
            }
            this.mDetector.changeDetectType(aBDetectType, z2);
        }
    }

    public int checkFrame(ABFaceFrame aBFaceFrame) {
        if (isShaking()) {
            return 1004;
        }
        if (isIlluminanceOK()) {
            return 0;
        }
        return ALBiometricsCodes.TIP_ENV_TOO_BRIGHT;
    }

    public void doDetectContinue(byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5;
        byte[] byteArray;
        try {
            ABDetectContext aBDetectContext = ABDetectContext.getInstance();
            if (this.mDetector == null || aBDetectContext == null || !aBDetectContext.isNeedContinueImage()) {
                return;
            }
            int qualityImageCount = aBDetectContext.getQualityImageCount();
            ALBiometricsParams aLBiometricsParams = this.mABParams;
            int i6 = aLBiometricsParams.imageCount;
            if (qualityImageCount < i6 && i6 <= 3) {
                int i7 = i6 - 1;
                int i8 = aLBiometricsParams.imageIntervals;
                long qualityImageTime = aBDetectContext.getQualityImageTime();
                long j = i8;
                long currentTimeMillis = System.currentTimeMillis();
                int i9 = 0;
                if (currentTimeMillis > (i7 * i8) + qualityImageTime + j) {
                    aBDetectContext.setNeedContinueImage(false);
                    return;
                }
                while (i9 < i7) {
                    int i10 = i9 + 1;
                    long j2 = (i10 * i8) + qualityImageTime;
                    long j3 = j2 + j;
                    if (currentTimeMillis <= j2 || currentTimeMillis >= j3 || aBDetectContext.getQualityImageCount() >= i9 + 2) {
                        i4 = i8;
                    } else {
                        i4 = i8;
                        Bundle doDetectContinue = this.mDetector.doDetectContinue(bArr, i, i2, i3);
                        if (doDetectContinue != null && (byteArray = doDetectContinue.getByteArray("img")) != null) {
                            ABImageResult aBImageResult = new ABImageResult();
                            i5 = i7;
                            if (saveDataToImageResult(byteArray, "continue".concat(String.valueOf(i9)), aBImageResult)) {
                                aBDetectContext.setQualityImageCount(aBDetectContext.getQualityImageCount() + 1);
                                if (aBDetectContext.getResult() != null) {
                                    aBDetectContext.getResult().getContinueImages().add(aBImageResult);
                                }
                                triggerEventListener(2, aBImageResult);
                            }
                            i9 = i10;
                            i8 = i4;
                            i7 = i5;
                        }
                    }
                    i5 = i7;
                    i9 = i10;
                    i8 = i4;
                    i7 = i5;
                }
            }
        } catch (Throwable unused) {
            a.b();
        }
    }

    public Bundle getErrorLogData(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("succ", 0);
        bundle.putInt("reason", i);
        bundle.putInt("retry_tt", ABDetectContext.getInstance().getRetryTimes());
        if (ABDetectContext.getInstance().getResult() != null) {
            bundle.putString("r_json", ABDetectContext.getInstance().getResult().toJson());
        }
        bundle.putInt("time_adj_enable", this.mABParams.stepAdjust ? 1 : 0);
        return bundle;
    }

    public Bundle getResultData(int i) {
        Bundle bundle = new Bundle();
        long currentTimeMillis = System.currentTimeMillis();
        if (ABDetectContext.getInstance().getResult() != null) {
            ABDetectContext.getInstance().getResult().setEt(currentTimeMillis);
            ABDetectContext.getInstance().getResult().setR(i);
            ABDetectContext.getInstance().getResult().setRt(ABDetectContext.getInstance().getRetryTimes());
            if (ABDetectContext.getInstance().getCurrentActionResult() != null) {
                ABDetectContext.getInstance().getCurrentActionResult().setEt(currentTimeMillis);
                ABDetectContext.getInstance().getCurrentActionResult().setR(i);
            }
            bundle.putSerializable(ALBiometricsKeys.KEY_RESULT_DATA, ABDetectContext.getInstance().getResult());
            bundle.putInt(ALBiometricsKeys.KEY_RESULT_RETRYTIMES, ABDetectContext.getInstance().getRetryTimes());
        }
        return bundle;
    }

    public Bundle getSuccessLogData() {
        Bundle bundle = new Bundle();
        bundle.putInt("succ", 1);
        bundle.putInt("reason", 0);
        bundle.putInt("retry_tt", ABDetectContext.getInstance().getRetryTimes());
        if (ABDetectContext.getInstance().getResult() != null) {
            bundle.putString("r_json", ABDetectContext.getInstance().getResult().toJson());
        }
        bundle.putInt("time_adj_enable", this.mABParams.stepAdjust ? 1 : 0);
        return bundle;
    }

    public boolean hasQualityFrame() {
        return (ABDetectContext.getInstance().getResult() == null || ABDetectContext.getInstance().getResult().getQi() == null || ABDetectContext.getInstance().getResult().getQi().getP() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isAlertDialogError(int i) {
        if (i == -10407 || i == -10405 || i == -10217 || i == -10106 || i == -10100) {
            return true;
        }
        switch (i) {
            case GlobalErrorCode.ERROR_DETECT_NOT_ENOUNGH_IMAGE /* -10212 */:
            case GlobalErrorCode.ERROR_ALGO_REFLECT_FAIL /* -10211 */:
            case GlobalErrorCode.ERROR_ALGO_REFLECT_NO_FACE /* -10210 */:
            case GlobalErrorCode.ERROR_ALGO_RECAP_FAIL /* -10209 */:
                return true;
            default:
                switch (i) {
                    case GlobalErrorCode.ERROR_ALGO_MODEL_COPY_FAIL /* -10207 */:
                    case GlobalErrorCode.ERROR_ALGO_MUCH_MINE /* -10206 */:
                    case GlobalErrorCode.ERROR_ALGO_TIMEOUT_ADJUST /* -10205 */:
                    case GlobalErrorCode.ERROR_ALGO_TIMEOUT_ACTION /* -10204 */:
                        return true;
                    default:
                        switch (i) {
                            case GlobalErrorCode.ERROR_ALGO_CONFIG_FAIL /* -10202 */:
                            case GlobalErrorCode.ERROR_ALGO_INIT_FAIL /* -10201 */:
                            case GlobalErrorCode.ERROR_ALGO_SO_LOAD_FAIL /* -10200 */:
                                return true;
                            default:
                                return false;
                        }
                }
        }
    }

    public boolean isDistanceOK(ABFaceFrame aBFaceFrame) {
        if (aBFaceFrame != null) {
            try {
                if (aBFaceFrame.facesDetected() > 0) {
                    return ((float) (Rect.width(aBFaceFrame.getFaceSize()) * 2)) >= this.mABParams.reflectDistanceThreshold * ((float) Math.min(aBFaceFrame.getImageWidth(), aBFaceFrame.getImageHeight()));
                }
                return true;
            } catch (Exception unused) {
                a.b();
                return true;
            }
        }
        return true;
    }

    public boolean isEyeOpen(DetectInfo detectInfo) {
        if (detectInfo != null && detectInfo.getLandmarks() != null && detectInfo.getLandmarks().length >= 20) {
            int i = (int) (detectInfo.getLandmarks()[12] - detectInfo.getLandmarks()[8]);
            int i2 = (int) (detectInfo.getLandmarks()[15] - detectInfo.getLandmarks()[11]);
            int i3 = (int) (detectInfo.getLandmarks()[20] - detectInfo.getLandmarks()[16]);
            int i4 = (int) (detectInfo.getLandmarks()[23] - detectInfo.getLandmarks()[19]);
            if (i2 <= 0 || i2 <= 0 || i2 * 7 <= i) {
                return i4 > 0 && i4 > 0 && i4 * 7 > i3;
            }
            return true;
        }
        a.d(TAG, "isEyeOpen... fail, detectInfo == null || detectInfo.getLandmarks() == null || detectInfo.getLandmarks().length < 20");
        return false;
    }

    public boolean isIlluminanceOK() {
        return this.mABParams.reflectILThreshold > 0 && ((double) this.mDetector.getIlluminance()) >= -0.1d && this.mDetector.getIlluminance() < ((float) this.mABParams.reflectILThreshold);
    }

    public boolean isShaking() {
        return this.mShakeListener.isShaking();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isTipError(int i) {
        if (i == -10219 || i == 1004 || i == 1013 || i == 1060 || i == 1090 || i == 1001 || i == 1002) {
            return true;
        }
        switch (i) {
            case GlobalErrorCode.ERROR_TOUCH_TOO_MUCH_MINE_OCCLUSION /* -10215 */:
            case GlobalErrorCode.ERROR_TOUCH_TOO_MUCH_MINE_FACE /* -10214 */:
            case GlobalErrorCode.ERROR_TOUCH_TOO_MUCH_MINE_ACTION /* -10213 */:
                return true;
            default:
                switch (i) {
                    case 1006:
                    case 1007:
                    case 1008:
                        return true;
                    default:
                        switch (i) {
                            case ALBiometricsCodes.TIP_ACTION_TOO_SMALL /* 1053 */:
                            case ALBiometricsCodes.TIP_RAISE_PHONE /* 1054 */:
                            case ALBiometricsCodes.TIP_FACE_LIGHT /* 1055 */:
                                return true;
                            default:
                                return false;
                        }
                }
        }
    }

    public Message obtainEventMessage(int i) {
        return this.mListenerOperator.obtainMessage(i);
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        this.mShakeListener.onSensorChanged(sensorEvent);
    }

    public int readReflectPrevFailTimes() {
        return this.mABService.getContext().getSharedPreferences("reflect", 0).getInt("abrpft", 0);
    }

    public boolean saveActionImages(ABDetector aBDetector, ABActionResult aBActionResult) {
        try {
            aBActionResult.getIs().clear();
            for (int i = 0; i < 2; i++) {
                ABImageResult aBImageResult = new ABImageResult();
                byte[] imageData = aBDetector.getValidFrames().get(i).getImageData();
                if (saveDataToImageResult(imageData, "action_" + ABDetectContext.getInstance().getCurrentActionIndex() + JSMethod.NOT_SET + i, aBImageResult)) {
                    aBActionResult.addImageResult(aBImageResult);
                }
            }
            return true;
        } catch (Throwable th) {
            ABLogRecorder.i().record(th);
            return false;
        }
    }

    public boolean saveDataToImageResult(byte[] bArr, String str, ABImageResult aBImageResult) {
        return saveDataToImageResult(bArr, str, aBImageResult, ".jpeg");
    }

    public void saveFrameInfoToImageResult(ABFaceFrame aBFaceFrame, ABImageResult aBImageResult) {
        aBImageResult.setMb(aBFaceFrame.getDetectInfo().getMotionBlur());
        aBImageResult.setGb(aBFaceFrame.getDetectInfo().getGaussianBlur());
        aBImageResult.setQ(aBFaceFrame.getDetectInfo().getFaceQuality());
        aBImageResult.setB(aBFaceFrame.getDetectInfo().getBrightness());
        aBImageResult.setT(System.currentTimeMillis());
    }

    public boolean saveGlobalImage(ABDetector aBDetector) {
        try {
            if (ABDetectContext.getInstance().getResult().getGi() == null) {
                ABDetectContext.getInstance().getResult().setGi(new ABImageResult());
            }
            ABDetectContext.getInstance().getResult().getGi().setT(System.currentTimeMillis());
            byte[] globalImage = aBDetector.getGlobalImage();
            if (globalImage == null) {
                return false;
            }
            saveGlobalImageData(ABDetectContext.getInstance().getResult(), globalImage);
            return true;
        } catch (Throwable th) {
            a.b();
            ABLogRecorder.i().record(th);
            return false;
        }
    }

    public void saveGlobalImageData(ALBiometricsResult aLBiometricsResult, byte[] bArr) {
        if (bArr == null) {
            return;
        }
        ABImageResult gi = ABDetectContext.getInstance().getResult().getGi();
        if (gi == null) {
            gi = new ABImageResult();
        }
        if (saveDataToImageResult(bArr, RenderConstant.GLOBAL, gi, ".png")) {
            aLBiometricsResult.setGi(gi);
        }
    }

    public boolean saveLocalImage(ABDetector aBDetector) {
        try {
            if (ABDetectContext.getInstance().getResult().getLi() == null) {
                ABDetectContext.getInstance().getResult().setLi(new ABImageResult());
            }
            ABDetectContext.getInstance().getResult().getLi().setT(System.currentTimeMillis());
            byte[] localImage = aBDetector.getLocalImage();
            if (localImage == null) {
                return false;
            }
            saveLocalImageData(ABDetectContext.getInstance().getResult(), localImage);
            return true;
        } catch (Throwable th) {
            a.b();
            ABLogRecorder.i().record(th);
            return false;
        }
    }

    public void saveLocalImageData(ALBiometricsResult aLBiometricsResult, byte[] bArr) {
        if (bArr == null) {
            return;
        }
        ABImageResult li = ABDetectContext.getInstance().getResult().getLi();
        if (li == null) {
            li = new ABImageResult();
        }
        if (saveDataToImageResult(bArr, "local", li, ".png")) {
            aLBiometricsResult.setLi(li);
        }
    }

    public void saveOriginImageData(ALBiometricsResult aLBiometricsResult, byte[] bArr) {
        if (bArr == null) {
            a.d(TAG, "saveOriginImageData... Save origin image fail imageData=null");
            return;
        }
        ABImageResult oi = ABDetectContext.getInstance().getResult().getOi();
        if (oi == null) {
            oi = new ABImageResult();
        }
        if (saveDataToImageResult(bArr, "origin", oi)) {
            aLBiometricsResult.setOi(oi);
        }
    }

    public boolean saveQualityImage(ABDetector aBDetector) {
        byte[] originImage;
        byte[] originImage2;
        try {
            ABDetectContext.getInstance().getResult().getQi().setT(System.currentTimeMillis());
            if (this.mABParams.lessImageMode) {
                originImage = aBDetector.getQualityImage();
                ABDetectContext.getInstance().getResult().getQi().setLandmarks(aBDetector.getQualityImageLandmarks());
            } else {
                originImage = aBDetector.getOriginImage();
                ABDetectContext.getInstance().getResult().getQi().setLandmarks(aBDetector.getOriginImageLandmarks());
            }
            if (originImage == null) {
                return false;
            }
            saveQualityImageData(ABDetectContext.getInstance().getResult(), originImage);
            if (this.mABParams.needOriginalImage && (originImage2 = aBDetector.getOriginImage()) != null) {
                saveOriginImageData(ABDetectContext.getInstance().getResult(), originImage2);
            }
            if (aBDetector.getImageFaceSize() != null) {
                ABDetectContext.getInstance().getResult().getQi().setFr(new int[]{aBDetector.getImageFaceSize().left, aBDetector.getImageFaceSize().top, Rect.width(aBDetector.getImageFaceSize()), Rect.height(aBDetector.getImageFaceSize())});
            }
            return true;
        } catch (Throwable th) {
            a.b();
            ABLogRecorder.i().record(th);
            return false;
        }
    }

    public void saveQualityImageData(ALBiometricsResult aLBiometricsResult, byte[] bArr) {
        if (bArr == null) {
            a.d(TAG, "saveQualityImageData... save best quality image fail imageData=null");
            return;
        }
        ABImageResult qi = ABDetectContext.getInstance().getResult().getQi();
        if (qi == null) {
            qi = new ABImageResult();
        }
        if (saveDataToImageResult(bArr, "best", qi)) {
            aLBiometricsResult.setQi(qi);
        }
    }

    public void setParams(ALBiometricsParams aLBiometricsParams) {
        if (aLBiometricsParams != null) {
            this.mABParams = aLBiometricsParams;
        }
    }

    public void triggerDetectError(int i, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        bundle2.putBundle(ALBiometricsKeys.KEY_RESULT_LOG_DATA, getErrorLogData(i));
        bundle2.putAll(getResultData(i));
        bundle2.putInt(ALBiometricsKeys.KEY_ERROR_CODE, i);
        triggerEventListener(13, new ParamBundleResult(1, bundle2));
    }

    public void triggerDetectSuccess() {
        Bundle bundle = new Bundle();
        bundle.putBundle(ALBiometricsKeys.KEY_RESULT_LOG_DATA, getSuccessLogData());
        bundle.putAll(getResultData(0));
        triggerEventListener(13, new ParamBundleResult(0, bundle));
    }

    public void triggerEventListener(int i) {
        this.mListenerOperator.sendEvent(obtainEventMessage(i));
    }

    public void writeReflectPrevFailTimes(int i) {
        SharedPreferences.Editor edit = this.mABService.getContext().getSharedPreferences("reflect", 0).edit();
        edit.putInt("abrpft", i);
        edit.commit();
    }

    public Message obtainEventMessage(int i, Object obj) {
        return this.mListenerOperator.obtainMessage(i, obj);
    }

    public boolean saveDataToImageResult(byte[] bArr, String str, ABImageResult aBImageResult, String str2) {
        aBImageResult.setBf(bArr);
        aBImageResult.setD(j.a(bArr));
        aBImageResult.setDt(0);
        if (this.mABParams.saveImagesFile) {
            String str3 = this.mContext.getFilesDir().toString() + File.separator + (j.a(str) + str2);
            boolean a = e.a(new File(str3), bArr);
            aBImageResult.setP(str3);
            return a;
        }
        return true;
    }

    public void triggerEventListener(int i, Object obj) {
        this.mListenerOperator.sendEvent(obtainEventMessage(i, obj));
    }
}
