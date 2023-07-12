package com.alibaba.security.biometrics.service.detector;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.alibaba.security.biometrics.jni.ABJniDetectResult;
import com.alibaba.security.biometrics.jni.ABJniDetectState;
import com.alibaba.security.biometrics.jni.ABJniDetectType;
import com.alibaba.security.biometrics.jni.ABJniFailReason;
import com.alibaba.security.biometrics.jni.ABJniPromptMessage;
import com.alibaba.security.biometrics.jni.ALBiometricsJni;
import com.alibaba.security.biometrics.service.ALBiometricsServiceEventListener;
import com.alibaba.security.biometrics.service.common.GetCacheDataManager;
import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.alibaba.security.biometrics.service.model.ABDetectFrame;
import com.alibaba.security.biometrics.service.model.ABResultFrame;
import com.alibaba.security.biometrics.service.model.detector.ABDetectType;
import com.alibaba.security.biometrics.service.model.detector.ABDetector;
import com.alibaba.security.biometrics.service.model.detector.ABFaceFrame;
import com.alibaba.security.biometrics.service.model.params.ABParamsHelper;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import com.alibaba.security.biometrics.service.model.result.ALBiometricsCodes;
import com.alibaba.security.biometrics.service.state.ABDetectListener;
import com.alibaba.security.biometrics.service.state.ABStateMachine;
import com.alibaba.security.common.d.e;
import com.alibaba.security.common.d.h;
import com.alibaba.security.common.d.p;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.realidentity.jsbridge.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ABFrameDetector extends ABDetector {
    public static final String FC_NAME = "faceContinuity.bin";
    public static final String FD_NAME = "fdmodel.bin";
    public static final String LD_CLA_NAME = "ldClassifier.bin";
    public static final String LD_NAME = "ldmodel.bin";
    private static final String TAG = "ABFrameDetector";
    private ABDetectType currentDetectType;
    private byte[] globalImage;
    private Rect imageFaceSize;
    private boolean isLoaded;
    private byte[] localImage;
    private final ABStateMachine mABStateMachine;
    private final ALBiometricsServiceEventListener mALBiometricsEventListener;
    protected Context mContext;
    private ABFaceRecapDetector mFaceRecapDetector;
    private String mModelDirPath;
    private ALBiometricsParams mParams;
    private FaceImage mPreFaceImage;
    private ArrayList<ABFaceFrame> mValidFrames;
    private byte[] originImage;
    private float[] originImageLandmarks;
    private byte[] qualityImage;
    private float[] qualityImageLandmarks;
    private byte[] recapYuv;
    private int reflectDetectType;
    private int initWidth = 0;
    private int initHeight = 0;
    private int initAngle = 0;
    private int reflectCmd = -1;
    private float mIlluminance = -1.0f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class FaceImage {
        private float brightScore;
        private byte[] faceImageBuffer;
        private boolean hasFaceDetected;
        private boolean hasFaceInRegion;
        private float score;

        private FaceImage() {
        }

        public float getBrightScore() {
            return this.brightScore;
        }

        public byte[] getFaceImageBuffer() {
            return this.faceImageBuffer;
        }

        public float getScore() {
            return this.score;
        }

        public boolean hasFaceDetected() {
            return this.hasFaceDetected;
        }

        public boolean hasFaceInRegion() {
            return this.hasFaceInRegion;
        }

        public void setBrightScore(float f) {
            this.brightScore = f;
        }

        public void setFaceImageBuffer(byte[] bArr) {
            this.faceImageBuffer = bArr;
        }

        public void setHasFaceDetected(boolean z) {
            this.hasFaceDetected = z;
        }

        public void setHasFaceInRegion(boolean z) {
            this.hasFaceInRegion = z;
        }

        public void setScore(float f) {
            this.score = f;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    static class MainHandler extends Handler {
        private final WeakReference<ABFrameDetector> mABFrameDetectorWeakReference;

        public MainHandler(ABFrameDetector aBFrameDetector) {
            this.mABFrameDetectorWeakReference = new WeakReference<>(aBFrameDetector);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            this.mABFrameDetectorWeakReference.get();
            super.handleMessage(message);
        }
    }

    public ABFrameDetector(ABStateMachine aBStateMachine, ALBiometricsServiceEventListener aLBiometricsServiceEventListener) {
        this.mABStateMachine = aBStateMachine;
        this.mALBiometricsEventListener = aLBiometricsServiceEventListener;
    }

    private void cacheFaceImage(byte[] bArr, ABJniDetectResult aBJniDetectResult) {
        FaceImage faceImage = this.mPreFaceImage;
        if (faceImage == null) {
            FaceImage faceImage2 = new FaceImage();
            this.mPreFaceImage = faceImage2;
            faceImage2.setFaceImageBuffer(bArr);
            this.mPreFaceImage.setScore(0.0f);
            this.mPreFaceImage.setBrightScore(0.0f);
            this.mPreFaceImage.setHasFaceDetected(false);
            this.mPreFaceImage.setHasFaceInRegion(false);
        } else if (isGetQualityFaceImage(faceImage, aBJniDetectResult)) {
            this.mPreFaceImage.setFaceImageBuffer(bArr);
            this.mPreFaceImage.setScore(aBJniDetectResult.staticQuality);
            this.mPreFaceImage.setBrightScore(aBJniDetectResult.brightness);
        }
    }

    private void collectLog(TrackLog trackLog) {
        ABDetectListener aBDetectListener = this.mDetectEventListener;
        if (aBDetectListener != null) {
            aBDetectListener.collectLog(trackLog);
        }
    }

    private String copyModel(Context context) {
        ArrayList arrayList = new ArrayList();
        if (copyModel(context, FD_NAME, this.mModelDirPath + FD_NAME)) {
            arrayList.add(FD_NAME);
            if (copyModel(context, LD_NAME, this.mModelDirPath + LD_NAME)) {
                arrayList.add(LD_NAME);
                if (copyModel(context, LD_CLA_NAME, this.mModelDirPath + LD_CLA_NAME)) {
                    arrayList.add(LD_CLA_NAME);
                    if (copyModel(context, FC_NAME, this.mModelDirPath + FC_NAME)) {
                        arrayList.add(FC_NAME);
                        return null;
                    }
                    return FC_NAME;
                }
                return LD_CLA_NAME;
            }
            return LD_NAME;
        }
        return FD_NAME;
    }

    private ABJniDetectResult createJniDetectResult() {
        ABJniDetectResult aBJniDetectResult = new ABJniDetectResult();
        aBJniDetectResult.reflectCmd = this.reflectCmd;
        aBJniDetectResult.reflectDetectType = this.reflectDetectType;
        aBJniDetectResult.illuminance = this.mIlluminance;
        return aBJniDetectResult;
    }

    private boolean enableAndInitBioJni(int i, int i2, int i3) {
        int i4;
        ALBiometricsParams aLBiometricsParams;
        if (ALBiometricsJni.IsEnabled()) {
            i4 = i3;
        } else {
            ALBiometricsJni.SetParameter(1, this.mParams.validRegionLeft);
            ALBiometricsJni.SetParameter(2, this.mParams.validRegionTop);
            ALBiometricsJni.SetParameter(3, this.mParams.validRegionRight);
            ALBiometricsJni.SetParameter(4, this.mParams.validRegionBottom);
            if (this.mParams.lessImageMode) {
                ALBiometricsJni.SetParameter(26, aLBiometricsParams.bigImageSize);
            }
            ALBiometricsJni.SetParameter(37, this.mParams.detectWrongAction ? 1.0f : 0.0f);
            ALBiometricsJni.SetParameter(38, this.mParams.detectOcclusion ? 1.0f : 0.0f);
            int i5 = this.mParams.bgDetectTimeIntervals;
            if (i5 >= 0) {
                ALBiometricsJni.SetParameter(39, i5);
            }
            int i6 = this.mParams.bgDetectColorThreshold;
            if (i6 >= 0) {
                ALBiometricsJni.SetParameter(40, i6);
            }
            this.reflectCmd = -1;
            this.reflectDetectType = -1;
            ALBiometricsParams aLBiometricsParams2 = this.mParams;
            int init = ALBiometricsJni.init(i, i2, i3, this.mModelDirPath + FD_NAME, this.mModelDirPath + LD_NAME, this.mModelDirPath + LD_CLA_NAME, this.mModelDirPath + FC_NAME, aLBiometricsParams2.secToken, aLBiometricsParams2.mBiometricsType);
            HashMap hashMap = new HashMap();
            hashMap.put("width", Integer.valueOf(i));
            hashMap.put("height", Integer.valueOf(i2));
            hashMap.put("rotation", Integer.valueOf(i3));
            hashMap.put("fdPath", this.mModelDirPath + FD_NAME);
            hashMap.put("ldPath", this.mModelDirPath + LD_NAME);
            hashMap.put("ldClaPath", this.mModelDirPath + LD_CLA_NAME);
            hashMap.put("fcPath", this.mModelDirPath + FC_NAME);
            hashMap.put("errorCode", Integer.valueOf(init));
            hashMap.put(a.d, this.mParams.secToken);
            ALBiometricsJni.bhL(8, h.a((Object) hashMap));
            if (init != 0) {
                handleError(GlobalErrorCode.ERROR_ALGO_INIT_FAIL, h.a((Object) hashMap));
                return false;
            }
            this.initWidth = i;
            this.initHeight = i2;
            i4 = i3;
            this.initAngle = i4;
            changeDetectType(getCurrentDetectType(), false);
        }
        if (ALBiometricsJni.IsEnabled()) {
            if (i == this.initWidth && i2 == this.initHeight && i4 == this.initAngle) {
                return true;
            }
            ALBiometricsJni.release();
            return true;
        }
        return true;
    }

    private void handleError(int i, String str) {
        if (this.mDetectEventListener != null) {
            Bundle bundle = new Bundle();
            bundle.putString(ALBiometricsKeys.KEY_ERROR_MESSAGE, str);
            this.mDetectEventListener.onError(i, bundle);
        }
    }

    private boolean handleMockResult(byte[] bArr, int i, int i2, int i3, ABJniDetectResult aBJniDetectResult) {
        this.mDetectEventListener.onError(GlobalErrorCode.ERROR_ALGO_MUCH_MINE, new Bundle());
        return true;
    }

    private void handleRecap(ABJniDetectResult aBJniDetectResult) {
        ABFaceRecapDetector aBFaceRecapDetector;
        float[] fArr;
        if (!this.mParams.recapEnable || (aBFaceRecapDetector = this.mFaceRecapDetector) == null || !aBFaceRecapDetector.isLoaded() || aBJniDetectResult == null || (fArr = aBJniDetectResult.faceKeyPoint) == null || !aBJniDetectResult.faceExist || aBJniDetectResult.outOfRegion) {
            return;
        }
        float[] fArr2 = {aBJniDetectResult.brightness, aBJniDetectResult.quality, aBJniDetectResult.staticQuality, aBJniDetectResult.pitchScore, aBJniDetectResult.yawScore, aBJniDetectResult.mouthScore, aBJniDetectResult.blinkScore, aBJniDetectResult.landmarkScore, aBJniDetectResult.brightDiff, aBJniDetectResult.backHightlight, aBJniDetectResult.faceSpeed};
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        if (this.recapYuv == null) {
            this.recapYuv = new byte[38400];
        }
        int GetRecapPatch = ALBiometricsJni.GetRecapPatch(this.recapYuv);
        if (GetRecapPatch == 0) {
            GetRecapPatch = this.mFaceRecapDetector.doDetect(this.recapYuv, 160, 160, 0, fArr2, copyOf);
        }
        if (GetRecapPatch != 0) {
            trackFaceRecapError(GetRecapPatch);
        }
    }

    private boolean handleResult(byte[] bArr, int i, int i2, int i3, ABJniDetectResult aBJniDetectResult) {
        if (aBJniDetectResult == null || this.mDetectEventListener == null) {
            return false;
        }
        if (this.reflectCmd == 1 && (aBJniDetectResult.reflectResult == 0 || aBJniDetectResult.reflectFrames >= 5)) {
            this.reflectCmd = 2;
        }
        if (this.reflectCmd == 0) {
            this.reflectCmd = 1;
        }
        ABDetectFrame aBDetectFrame = new ABDetectFrame(aBJniDetectResult, bArr, i, i2, i3);
        if (GetCacheDataManager.getInstance().isNeedCollectLocalImage()) {
            cacheFaceImage(bArr, aBJniDetectResult);
            aBDetectFrame.setFaceImage(this.mPreFaceImage.getFaceImageBuffer());
        }
        if (aBJniDetectResult.detectState() == ABJniDetectState.DETECT_STATE_FAIL) {
            int transferFailReason = transferFailReason(aBJniDetectResult.failReason());
            Bundle bundle = new Bundle();
            bundle.putString("alg_m", aBJniDetectResult.failLog);
            bundle.putInt("alg_fr", aBJniDetectResult.failReason() == null ? -101 : aBJniDetectResult.failReason().getValue());
            bundle.putString(ALBiometricsKeys.KEY_RESULT_MESSAGE, aBJniDetectResult.failReason().getMessage());
            bundle.putInt("ec", aBJniDetectResult.ec);
            bundle.putInt("etcc", aBJniDetectResult.etcc);
            bundle.putInt("ecpc", aBJniDetectResult.ecpc);
            bundle.putString("ecResult", aBJniDetectResult.ecResult);
            bundle.putString(ALBiometricsKeys.KEY_ERROR_MESSAGE, "algo detect fail");
            this.mDetectEventListener.onDetectFailed(transferFailReason, bundle);
        } else if (aBJniDetectResult.detectState() == ABJniDetectState.DETECT_STATE_SUC) {
            this.qualityImage = aBJniDetectResult.bigImgBuffer;
            this.qualityImageLandmarks = aBJniDetectResult.faceKeyPointInBigImg;
            this.globalImage = aBJniDetectResult.globalImgBuffer;
            this.localImage = aBJniDetectResult.localImgBuffer;
            this.originImage = aBJniDetectResult.frameBuffer;
            this.originImageLandmarks = aBJniDetectResult.faceKeyPoint;
            int i4 = aBJniDetectResult.faceLeft;
            int i5 = aBJniDetectResult.faceTop;
            int i6 = aBJniDetectResult.faceWidth;
            this.imageFaceSize = new Rect(i4, i5, i4 + i6, i6 + i5);
            this.mValidFrames.clear();
            this.mValidFrames.add(new ABResultFrame(aBJniDetectResult.actionImgBuffer[0], aBJniDetectResult.actionImgWidth, aBJniDetectResult.actionImgHeight, 0, 1, aBJniDetectResult.iso));
            this.mValidFrames.add(new ABResultFrame(aBJniDetectResult.actionImgBuffer[1], aBJniDetectResult.actionImgWidth, aBJniDetectResult.actionImgHeight, 0, 1, aBJniDetectResult.iso));
            ABDetectType onDetectSuccess = this.mDetectEventListener.onDetectSuccess(aBDetectFrame, this.currentDetectType);
            if (onDetectSuccess != ABDetectType.DONE || onDetectSuccess != ABDetectType.NONE) {
                changeDetectType(onDetectSuccess, true);
            }
        } else if (aBJniDetectResult.detectState() == ABJniDetectState.DETECT_STATE_DETECTING) {
            String message = aBJniDetectResult.promptMessage().getMessage();
            Bundle bundle2 = new Bundle();
            bundle2.putInt(ALBiometricsKeys.KEY_RESULT_CODE, aBJniDetectResult.promptMessage().getValue());
            bundle2.putString(ALBiometricsKeys.KEY_RESULT_MESSAGE, message);
            aBDetectFrame.setMsgCode(transferMessageCode(aBJniDetectResult.promptMessage()));
            this.mDetectEventListener.onMessage(aBDetectFrame.getMsgCode(), bundle2);
        }
        this.mDetectEventListener.onFrameDetected(10L, aBDetectFrame);
        return true;
    }

    private boolean isGetQualityFaceImage(FaceImage faceImage, ABJniDetectResult aBJniDetectResult) {
        if (aBJniDetectResult != null && faceImage != null) {
            if (!faceImage.hasFaceDetected() && !aBJniDetectResult.faceExist && faceImage.getBrightScore() < aBJniDetectResult.brightness) {
                return true;
            }
            if (aBJniDetectResult.faceExist) {
                faceImage.setHasFaceDetected(true);
                if (!aBJniDetectResult.outOfRegion) {
                    faceImage.setHasFaceInRegion(true);
                    return faceImage.getScore() < aBJniDetectResult.staticQuality;
                } else if (!faceImage.hasFaceInRegion()) {
                    return true;
                }
            }
        }
        return false;
    }

    private void trackFaceRecapError(int i) {
        collectLog(TrackLog.createSdkExceptionLog("face recap fail: ".concat(String.valueOf(i))));
    }

    private ABJniDetectType transferDetectType(ABDetectType aBDetectType) {
        if (aBDetectType == ABDetectType.AIMLESS) {
            return ABJniDetectType.DETECT_TYPE_AIMLESS;
        }
        if (aBDetectType == ABDetectType.BLINK) {
            return ABJniDetectType.DETECT_TYPE_BLINK;
        }
        if (aBDetectType == ABDetectType.POS_PITCH) {
            return ABJniDetectType.DETECT_TYPE_PITCH;
        }
        if (aBDetectType == ABDetectType.POS_PITCH_DOWN) {
            return ABJniDetectType.DETECT_TYPE_PITCH;
        }
        if (aBDetectType == ABDetectType.POS_PITCH_UP) {
            return ABJniDetectType.DETECT_TYPE_PITCH;
        }
        if (aBDetectType == ABDetectType.KEEP_STILL) {
            return ABJniDetectType.DETECT_TYPE_STILL;
        }
        if (aBDetectType == ABDetectType.POS_YAW) {
            return ABJniDetectType.DETECT_TYPE_YAW;
        }
        if (aBDetectType == ABDetectType.MOUTH) {
            return ABJniDetectType.DETECT_TYPE_MOUTH;
        }
        if (aBDetectType == ABDetectType.PITCH_STILL) {
            return ABJniDetectType.DETECT_TYPE_PITCH_STILL;
        }
        if (aBDetectType == ABDetectType.YAW_STILL) {
            return ABJniDetectType.DETECT_TYPE_YAW_STILL;
        }
        if (aBDetectType == ABDetectType.MOUTH_STILL) {
            return ABJniDetectType.DETECT_TYPE_MOUTH_STILL;
        }
        if (aBDetectType == ABDetectType.BLINK_STILL) {
            return ABJniDetectType.DETECT_TYPE_BLINK_STILL;
        }
        return ABJniDetectType.DETECT_TYPE_AIMLESS;
    }

    private int transferFailReason(ABJniFailReason aBJniFailReason) {
        if (ABJniFailReason.FAIL_ACTION_MOUTH_OCCLUSION.equals(aBJniFailReason)) {
            return 6;
        }
        if (ABJniFailReason.FAIL_ACTION_PITCH_FACE_DISAPPEAR.equals(aBJniFailReason) || ABJniFailReason.FAIL_ACTION_PITCH_FACE_CHANGE.equals(aBJniFailReason) || ABJniFailReason.FAIL_ACTION_YAW_FACE_DISAPPEAR.equals(aBJniFailReason) || ABJniFailReason.FAIL_ACTION_YAW_FACE_CHANGE.equals(aBJniFailReason) || ABJniFailReason.FAIL_ACTION_MOUTH_FACE_DISAPPEAR.equals(aBJniFailReason) || ABJniFailReason.FAIL_ACTION_MOUTH_FACE_CHANGE.equals(aBJniFailReason) || ABJniFailReason.FAIL_ACTION_BLINK_OCCLUSION.equals(aBJniFailReason) || ABJniFailReason.FAIL_ACTION_BLINK_FACE_DISAPPEAR.equals(aBJniFailReason) || ABJniFailReason.FAIL_ACTION_BLINK_FACE_CHANGE.equals(aBJniFailReason)) {
            return 1;
        }
        if (ABJniFailReason.FAIL_ACTION_PITCH_GET_YAW.equals(aBJniFailReason) || ABJniFailReason.FAIL_ACTION_PITCH_GET_MOUTH.equals(aBJniFailReason) || ABJniFailReason.FAIL_ACTION_YAW_GET_PITCH.equals(aBJniFailReason) || ABJniFailReason.FAIL_ACTION_YAW_GET_MOUTH.equals(aBJniFailReason) || ABJniFailReason.FAIL_ACTION_MOUTH_GET_PITCH.equals(aBJniFailReason) || ABJniFailReason.FAIL_ACTION_MOUTH_GET_YAW.equals(aBJniFailReason) || ABJniFailReason.FAIL_ACTION_BLINK_GET_YAW.equals(aBJniFailReason) || ABJniFailReason.FAIL_ACTION_BLINK_GET_MOUTH.equals(aBJniFailReason) || ABJniFailReason.FAIL_ACTION_BLINK_GET_PITCH.equals(aBJniFailReason)) {
            return 0;
        }
        if (ABJniFailReason.FAIL_STILL_TIMEOUT.equals(aBJniFailReason) || ABJniFailReason.FAIL_ACTION_YAW_TIMEOUT.equals(aBJniFailReason) || ABJniFailReason.FAIL_ACTION_MOUTH_TIMEOUT.equals(aBJniFailReason) || ABJniFailReason.FAIL_ACTION_PITCH_TIMEOUT.equals(aBJniFailReason) || ABJniFailReason.FAIL_ACTION_BLINK_TIMEOUT.equals(aBJniFailReason) || ABJniFailReason.FAIL_NO_FACE_DETECT.equals(aBJniFailReason)) {
            return 2;
        }
        if (ABJniFailReason.FAIL_ACTION_PITCH_NOT_3D.equals(aBJniFailReason) || ABJniFailReason.FAIL_ACTION_YAW_NOT_3D.equals(aBJniFailReason)) {
            return 5;
        }
        if (ABJniFailReason.FAIL_NONE.equals(aBJniFailReason)) {
            return -1;
        }
        if (ABJniFailReason.FAIL_STILL_OUT_OF_REGION.equals(aBJniFailReason) || ABJniFailReason.FAIL_STILL_TOO_SMALL.equals(aBJniFailReason) || ABJniFailReason.FAIL_STILL_TOO_BIG.equals(aBJniFailReason) || ABJniFailReason.FAIL_STILL_LIGHT_UNEVEN.equals(aBJniFailReason) || ABJniFailReason.FAIL_STILL_NOT_STILL.equals(aBJniFailReason) || ABJniFailReason.FAIL_STILL_TOO_DARK.equals(aBJniFailReason) || ABJniFailReason.FAIL_STILL_PITCH_TOO_BIG.equals(aBJniFailReason) || ABJniFailReason.FAIL_STILL_YAW_TOO_BIG.equals(aBJniFailReason)) {
            return 2;
        }
        if (aBJniFailReason != null) {
            return aBJniFailReason.getValue();
        }
        return -1;
    }

    private int transferMessageCode(ABJniPromptMessage aBJniPromptMessage) {
        if (ABJniPromptMessage.PROMPT_PUT_FACE_IN_REGION.equals(aBJniPromptMessage)) {
            return 1002;
        }
        if (ABJniPromptMessage.PROMPT_MOVE_CLOSE.equals(aBJniPromptMessage)) {
            return 1008;
        }
        if (ABJniPromptMessage.PROMPT_MOVE_FAR.equals(aBJniPromptMessage)) {
            return 1007;
        }
        if (ABJniPromptMessage.PROMPT_FACE_YAW_TOO_BIG.equals(aBJniPromptMessage)) {
            return 1013;
        }
        if (ABJniPromptMessage.PROMPT_FACE_PITCH_TOO_BIG.equals(aBJniPromptMessage)) {
            return ALBiometricsCodes.TIP_RAISE_PHONE;
        }
        if (ABJniPromptMessage.PROMPT_TOO_DARK.equals(aBJniPromptMessage)) {
            return 1001;
        }
        if (ABJniPromptMessage.PROMPT_FACE_UNEVEN.equals(aBJniPromptMessage)) {
            return ALBiometricsCodes.TIP_FACE_LIGHT;
        }
        if (ABJniPromptMessage.PROMPT_KEEP_STILL.equals(aBJniPromptMessage)) {
            return 1004;
        }
        if (ABJniPromptMessage.PROMPT_GESTURE_SMALL.equals(aBJniPromptMessage)) {
            return ALBiometricsCodes.TIP_ACTION_TOO_SMALL;
        }
        return 0;
    }

    @Override // com.alibaba.security.biometrics.service.model.detector.ABDetector
    public void changeDetectType(ABDetectType aBDetectType, boolean z) {
        if (this.isLoaded) {
            this.currentDetectType = aBDetectType;
            if (ALBiometricsJni.IsEnabled()) {
                ALBiometricsJni.changeDetectType(transferDetectType(aBDetectType), z);
            }
        }
    }

    @Override // com.alibaba.security.biometrics.service.model.detector.ABDetector
    public boolean doDetect(byte[] bArr, int i, int i2, int i3) {
        if (this.isLoaded && enableAndInitBioJni(i, i2, i3)) {
            if (!ALBiometricsJni.IsEnabled()) {
                handleError(GlobalErrorCode.ERROR_ALGO_CONFIG_FAIL, "");
                return false;
            }
            this.mABStateMachine.startMachine();
            ABJniDetectResult createJniDetectResult = createJniDetectResult();
            int doDetect = ALBiometricsJni.doDetect(bArr, createJniDetectResult, GetCacheDataManager.getInstance().getUmidToken());
            if (doDetect != 0) {
                handleError(GlobalErrorCode.ERROR_ALGO_DETECTING_FAIL, doDetect + " " + createJniDetectResult.toString());
                return false;
            }
            handleRecap(createJniDetectResult);
            return handleResult(bArr, i, i2, i3, createJniDetectResult);
        }
        return false;
    }

    @Override // com.alibaba.security.biometrics.service.model.detector.ABDetector
    public Bundle doDetectContinue(byte[] bArr, int i, int i2, int i3) {
        try {
            if (this.isLoaded) {
                if ((!ALBiometricsJni.IsEnabled() || (i == this.initWidth && i2 == this.initHeight && i3 == this.initAngle)) && ALBiometricsJni.IsEnabled()) {
                    ABJniDetectResult aBJniDetectResult = new ABJniDetectResult();
                    if (ALBiometricsJni.doDetectContinue(bArr, aBJniDetectResult, GetCacheDataManager.getInstance().getUmidToken()) == 0 && aBJniDetectResult.faceExist) {
                        Bundle bundle = new Bundle();
                        byte[] bArr2 = aBJniDetectResult.bigImgBuffer;
                        if (bArr2 != null) {
                            bundle.putByteArray("img", bArr2);
                        }
                        bundle.putInt("width", aBJniDetectResult.bigImgWidth);
                        bundle.putInt("height", aBJniDetectResult.bigImgHeight);
                        bundle.putIntArray("rect", new int[]{aBJniDetectResult.faceLeft, aBJniDetectResult.faceTop, aBJniDetectResult.faceWidth, aBJniDetectResult.faceHeight});
                        float[] fArr = aBJniDetectResult.faceKeyPointInBigImg;
                        if (fArr != null) {
                            bundle.putFloatArray("landmarks", fArr);
                        }
                        return bundle;
                    }
                    return null;
                }
                return null;
            }
            return null;
        } catch (Throwable unused) {
            com.alibaba.security.common.c.a.b();
            return null;
        }
    }

    @Override // com.alibaba.security.biometrics.service.model.detector.ABDetector
    public ABDetectType getCurrentDetectType() {
        return this.currentDetectType;
    }

    @Override // com.alibaba.security.biometrics.service.model.detector.ABDetector
    public byte[] getGlobalImage() {
        if (this.isLoaded) {
            return this.globalImage;
        }
        return null;
    }

    public float getIlluminance() {
        return this.mIlluminance;
    }

    @Override // com.alibaba.security.biometrics.service.model.detector.ABDetector
    public Rect getImageFaceSize() {
        return this.imageFaceSize;
    }

    @Override // com.alibaba.security.biometrics.service.model.detector.ABDetector
    public byte[] getLocalImage() {
        if (this.isLoaded) {
            return this.localImage;
        }
        return null;
    }

    @Override // com.alibaba.security.biometrics.service.model.detector.ABDetector
    public String getLog() {
        return null;
    }

    @Override // com.alibaba.security.biometrics.service.model.detector.ABDetector
    public byte[] getOriginImage() {
        if (this.isLoaded) {
            return this.originImage;
        }
        return null;
    }

    @Override // com.alibaba.security.biometrics.service.model.detector.ABDetector
    public float[] getOriginImageLandmarks() {
        return this.originImageLandmarks;
    }

    @Override // com.alibaba.security.biometrics.service.model.detector.ABDetector
    public byte[] getQualityImage() {
        if (this.isLoaded) {
            return this.qualityImage;
        }
        return null;
    }

    @Override // com.alibaba.security.biometrics.service.model.detector.ABDetector
    public float[] getQualityImageLandmarks() {
        return this.qualityImageLandmarks;
    }

    @Override // com.alibaba.security.biometrics.service.model.detector.ABDetector
    public ArrayList<ABFaceFrame> getValidFrames() {
        if (this.isLoaded) {
            return this.mValidFrames;
        }
        return null;
    }

    @Override // com.alibaba.security.biometrics.service.model.detector.ABDetector
    public String getVersion() {
        return !this.isLoaded ? ALBiometricsJni.getVersion() : "";
    }

    @Override // com.alibaba.security.biometrics.service.model.detector.ABDetector
    public boolean init(Context context, ALBiometricsParams aLBiometricsParams) {
        int checkLicense;
        if (!p.g()) {
            handleError(GlobalErrorCode.ERROR_DEVICE_NOT_SUPPORT_NEON, "");
            return false;
        }
        this.mContext = context;
        this.mParams = aLBiometricsParams;
        this.mValidFrames = new ArrayList<>();
        if (this.mParams == null) {
            this.mParams = new ABParamsHelper(new Bundle()).getParams();
        }
        this.mModelDirPath = context.getFilesDir() + "/flm/";
        String copyModel = copyModel(context);
        if (!TextUtils.isEmpty(copyModel)) {
            handleError(GlobalErrorCode.ERROR_ALGO_MODEL_COPY_FAIL, copyModel);
            return false;
        }
        ALBiometricsJni.bhL(4, "");
        ALBiometricsParams aLBiometricsParams2 = this.mParams;
        byte[] bArr = aLBiometricsParams2.licenseData;
        if (bArr == null && aLBiometricsParams2.licenseTimeData == null) {
            checkLicense = ALBiometricsJni.checkLicense(context, this.mALBiometricsEventListener);
        } else {
            checkLicense = ALBiometricsJni.checkLicense(context, bArr, aLBiometricsParams2.licenseTimeData);
        }
        boolean z = checkLicense == 0;
        this.isLoaded = z;
        if (!z) {
            handleError(GlobalErrorCode.ERROR_ALGO_SO_LOAD_FAIL, String.valueOf(checkLicense));
            return this.isLoaded;
        }
        this.initWidth = 0;
        this.initHeight = 0;
        this.initAngle = 0;
        this.reflectCmd = -1;
        this.reflectDetectType = -1;
        ALBiometricsJni.release();
        if (this.mParams.recapEnable) {
            ABFaceRecapDetector aBFaceRecapDetector = ABFaceRecapDetector.getInstance();
            this.mFaceRecapDetector = aBFaceRecapDetector;
            aBFaceRecapDetector.init(this.mContext, this.mParams, this.mALBiometricsEventListener);
        }
        return this.isLoaded;
    }

    @Override // com.alibaba.security.biometrics.service.model.detector.ABDetector
    public boolean isEnable() {
        return this.isLoaded && ALBiometricsJni.IsEnabled();
    }

    @Override // com.alibaba.security.biometrics.service.model.detector.ABDetector
    public void release() {
        this.mValidFrames = null;
        if (this.isLoaded) {
            ALBiometricsJni.release();
        }
        ABFaceRecapDetector aBFaceRecapDetector = this.mFaceRecapDetector;
        if (aBFaceRecapDetector != null) {
            aBFaceRecapDetector.release();
        }
    }

    @Override // com.alibaba.security.biometrics.service.model.detector.ABDetector
    public void reset(boolean z) {
        if (this.isLoaded) {
            ALBiometricsJni.Reset(z);
        }
    }

    public void setIlluminance(float f) {
        this.mIlluminance = f;
    }

    public ABFrameDetector setImageFaceSize(Rect rect) {
        this.imageFaceSize = rect;
        return this;
    }

    @Override // com.alibaba.security.biometrics.service.model.detector.ABDetector
    public void startReflectDetect(int i) {
        this.reflectCmd = 0;
        this.reflectDetectType = i;
    }

    private boolean copyModel(Context context, String str, String str2) {
        byte[] a = e.a(context, str);
        if (a == null) {
            return false;
        }
        return e.a(str2, a);
    }
}
