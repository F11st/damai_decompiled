package com.alibaba.security.biometrics.service.model;

import android.graphics.Rect;
import android.graphics.RectF;
import com.alibaba.security.biometrics.jni.ABJniDetectResult;
import com.alibaba.security.biometrics.jni.ABJniDetectType;
import com.alibaba.security.biometrics.service.model.detector.ABFaceFrame;
import com.alibaba.security.biometrics.service.model.detector.DetectInfo;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ABDetectFrame extends ABFaceFrame {
    private static final String TAG = "ABDetectFrame";
    private byte[] faceImage;
    protected int imageAngle;
    protected byte[] imageData;
    protected int imageHeight;
    protected int imageWidth;
    private final float iso;
    protected ABJniDetectResult jniDetectResult;
    private int msgCode;

    public ABDetectFrame(ABJniDetectResult aBJniDetectResult, byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5;
        Rect rect;
        this.jniDetectResult = aBJniDetectResult;
        this.imageData = bArr;
        this.imageWidth = i;
        this.imageHeight = i2;
        this.imageAngle = i3;
        this.iso = aBJniDetectResult.iso;
        if (i3 == 90 || i3 == 270) {
            i4 = i;
            i5 = i2;
        } else {
            i5 = i;
            i4 = i2;
        }
        setDetectInfo(new DetectInfo());
        this.detectInfo.setFaceSize(aBJniDetectResult.faceRectSmooth);
        RectF rectF = new RectF();
        if (i5 > 1 && i4 > 1) {
            float f = i5;
            rectF.left = rect.left / f;
            rectF.right = rect.right / f;
            float f2 = i4;
            rectF.top = rect.top / f2;
            rectF.bottom = rect.bottom / f2;
        }
        this.detectInfo.setPosition(rectF);
        Rect rect2 = new Rect();
        float[] fArr = aBJniDetectResult.faceKeyPoint;
        rect2.left = (int) fArr[8];
        rect2.right = (int) fArr[12];
        rect2.top = (int) fArr[11];
        rect2.bottom = (int) fArr[15];
        int max = Math.max(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect2), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(rect2)) / 8;
        rect2.left = Math.max(0, rect2.left - max);
        rect2.right = Math.min(i, rect2.right + max);
        rect2.top = Math.max(0, rect2.top - max);
        rect2.bottom = Math.min(i2, rect2.bottom + max);
        this.detectInfo.setLeftEyeRect(rect2);
        Rect rect3 = new Rect();
        float[] fArr2 = aBJniDetectResult.faceKeyPoint;
        rect3.left = (int) fArr2[16];
        rect3.right = (int) fArr2[20];
        rect3.top = (int) fArr2[19];
        rect3.bottom = (int) fArr2[23];
        int max2 = Math.max(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect3), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(rect3)) / 8;
        rect3.left = Math.max(0, rect3.left - max2);
        rect3.right = Math.min(i, rect3.right + max2);
        rect3.top = Math.max(0, rect3.top - max2);
        rect3.bottom = Math.min(i2, rect3.bottom + max2);
        this.detectInfo.setRightEyeRect(rect3);
        this.detectInfo.setBrightness(aBJniDetectResult.brightness);
        this.detectInfo.setFaceQuality(aBJniDetectResult.quality);
        this.detectInfo.setStaticQuality(aBJniDetectResult.staticQuality);
        this.detectInfo.setCheckResult(aBJniDetectResult.promptMessage().getValue());
        this.detectInfo.setPitch3d(true);
        this.detectInfo.setPitchScore(aBJniDetectResult.pitchScore);
        this.detectInfo.setYawScore(aBJniDetectResult.yawScore);
        this.detectInfo.setMouthScore(aBJniDetectResult.mouthScore);
        this.detectInfo.setBlinkScore(aBJniDetectResult.blinkScore);
        this.detectInfo.setLandmarkScore(aBJniDetectResult.landmarkScore);
        this.detectInfo.setBrightDiff(aBJniDetectResult.brightDiff);
        this.detectInfo.setBackHightlight(aBJniDetectResult.backHightlight);
        this.detectInfo.setFaceSpeed(aBJniDetectResult.faceSpeed);
        this.detectInfo.setEc(aBJniDetectResult.ec);
        this.detectInfo.setEcpc(aBJniDetectResult.ecpc);
        this.detectInfo.setEtcc(aBJniDetectResult.etcc);
        this.detectInfo.setEcResult(aBJniDetectResult.ecResult);
        this.detectInfo.setLandmarks(aBJniDetectResult.faceKeyPoint);
        this.detectInfo.setGestureProgress(aBJniDetectResult.gestureProgress);
        this.detectInfo.setActionRange(0);
        if (this.detectInfo.getGestureProgress() > 0.0f && this.detectInfo.getGestureProgress() <= 0.5d) {
            this.detectInfo.setActionRange(1);
        } else if (this.detectInfo.getGestureProgress() > 0.5d && this.detectInfo.getGestureProgress() < 1.0f) {
            this.detectInfo.setActionRange(2);
        } else if (this.detectInfo.getGestureProgress() >= 1.0f) {
            this.detectInfo.setActionRange(3);
        }
        this.detectInfo.setActionPosition(-1);
        if (aBJniDetectResult.detectType() != ABJniDetectType.DETECT_TYPE_YAW && aBJniDetectResult.detectType() != ABJniDetectType.DETECT_TYPE_YAW_STILL) {
            if (aBJniDetectResult.detectType() != ABJniDetectType.DETECT_TYPE_PITCH && aBJniDetectResult.detectType() != ABJniDetectType.DETECT_TYPE_PITCH_STILL) {
                if (aBJniDetectResult.detectType() == ABJniDetectType.DETECT_TYPE_MOUTH || aBJniDetectResult.detectType() == ABJniDetectType.DETECT_TYPE_MOUTH_STILL || aBJniDetectResult.detectType() == ABJniDetectType.DETECT_TYPE_BLINK || aBJniDetectResult.detectType() == ABJniDetectType.DETECT_TYPE_BLINK_STILL) {
                    this.detectInfo.setActionPosition(DetectInfo.DOWN);
                }
            } else {
                float f3 = aBJniDetectResult.pitchScore;
                if (f3 > 0.0f) {
                    this.detectInfo.setActionPosition(DetectInfo.DOWN);
                } else if (f3 < 0.0f) {
                    this.detectInfo.setActionPosition(DetectInfo.DOWN);
                } else if (f3 == 0.0f) {
                    this.detectInfo.setActionPosition(DetectInfo.CENTER);
                }
            }
        } else {
            float f4 = aBJniDetectResult.yawScore;
            if (f4 > 0.0f) {
                this.detectInfo.setActionPosition(DetectInfo.LEFT);
            } else if (f4 < 0.0f) {
                this.detectInfo.setActionPosition(DetectInfo.RIGHT);
            } else if (f4 == 0.0f) {
                this.detectInfo.setActionPosition(DetectInfo.CENTER);
            }
        }
        if (aBJniDetectResult.reflectCmd == 1) {
            this.detectInfo.setReflectResult(aBJniDetectResult.reflectResult);
            this.detectInfo.setReflectFrames(aBJniDetectResult.reflectFrames);
            this.detectInfo.setReflectScore(aBJniDetectResult.reflectScore);
            this.detectInfo.setReflectBrightnessResult(aBJniDetectResult.reflectBrightnessResult);
            this.detectInfo.setReflectBrightnessScore(aBJniDetectResult.reflectBrightnessScore);
            this.detectInfo.setReflectBrightnessFrames(aBJniDetectResult.reflectBrightnessFrames);
            this.detectInfo.setReflectEyeResult(aBJniDetectResult.reflectEyeResult);
            this.detectInfo.setReflectLeftEyeResult(aBJniDetectResult.reflectLeftEyeResult);
            this.detectInfo.setReflectRightEyeResult(aBJniDetectResult.reflectRightEyeResult);
            this.detectInfo.setReflectEyeFrames(aBJniDetectResult.reflectEyeFrames);
            this.detectInfo.setReflectEyeValidFrames(aBJniDetectResult.reflectEyeValidFrames);
            this.detectInfo.setBrightnessHistoryLog(aBJniDetectResult.brightnessHistory);
            this.detectInfo.setBrightnessScoresLog(aBJniDetectResult.brightnessScores);
        }
    }

    @Override // com.alibaba.security.biometrics.service.model.detector.ABFaceFrame
    public int facesDetected() {
        ABJniDetectResult aBJniDetectResult = this.jniDetectResult;
        return (aBJniDetectResult == null || !aBJniDetectResult.faceExist) ? 0 : 1;
    }

    public ABJniDetectResult getDetectResult() {
        return this.jniDetectResult;
    }

    public byte[] getFaceImage() {
        return this.faceImage;
    }

    @Override // com.alibaba.security.biometrics.service.model.detector.ABFaceFrame
    public RectF getFacePos() {
        if (getDetectInfo() == null) {
            return null;
        }
        return getDetectInfo().getPosition();
    }

    @Override // com.alibaba.security.biometrics.service.model.detector.ABFaceFrame
    public float getFaceQuality() {
        return this.detectInfo.getFaceQuality();
    }

    @Override // com.alibaba.security.biometrics.service.model.detector.ABFaceFrame
    public int getImageAngle() {
        return this.imageAngle;
    }

    @Override // com.alibaba.security.biometrics.service.model.detector.ABFaceFrame
    public byte[] getImageData() {
        return this.imageData;
    }

    @Override // com.alibaba.security.biometrics.service.model.detector.ABFaceFrame
    public int getImageHeight() {
        return this.imageHeight;
    }

    @Override // com.alibaba.security.biometrics.service.model.detector.ABFaceFrame
    public int getImageWidth() {
        return this.imageWidth;
    }

    @Override // com.alibaba.security.biometrics.service.model.detector.ABFaceFrame
    public float getIso() {
        return this.iso;
    }

    public int getMsgCode() {
        return this.msgCode;
    }

    @Override // com.alibaba.security.biometrics.service.model.detector.ABFaceFrame
    public boolean hasFace() {
        if (this.msgCode == 1002) {
            return false;
        }
        return super.hasFace();
    }

    public void setDetectResult(ABJniDetectResult aBJniDetectResult) {
        this.jniDetectResult = aBJniDetectResult;
    }

    public void setFaceImage(byte[] bArr) {
        this.faceImage = bArr;
    }

    public void setMsgCode(int i) {
        this.msgCode = i;
    }
}
