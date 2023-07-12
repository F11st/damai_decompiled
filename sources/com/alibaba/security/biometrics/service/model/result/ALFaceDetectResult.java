package com.alibaba.security.biometrics.service.model.result;

import android.graphics.Rect;
import android.graphics.RectF;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ALFaceDetectResult implements Serializable {
    public static final int FACE_CHECK_FACE_UNEVEN = 9;
    public static final int FACE_CHECK_GESTURE_SMALL = 7;
    public static final int FACE_CHECK_NONE = 0;
    public static final int FACE_CHECK_NOTINREGION = 1;
    public static final int FACE_CHECK_PITCH_TOO_BIG = 8;
    public static final int FACE_CHECK_SHAKE = 5;
    public static final int FACE_CHECK_TOOCLOSE = 6;
    public static final int FACE_CHECK_TOOFAR = 2;
    public static final int FACE_CHECK_TOO_DARK = 4;
    public static final int FACE_CHECK_YAW_TOO_BIG = 3;
    public static final String KEY_FACEDETECT_RESULT = "KEY_FACEDETECT_RESULT";
    private static final long serialVersionUID = 1;
    protected float backHighlight;
    protected byte[] bestImageData;
    protected float blinkScore;
    protected float brightDiff;
    protected int[] errors;
    protected RectF facePosition;
    protected Rect faceSize;
    protected float faceSpeed;
    protected int imageHeight;
    protected int imageWidth;
    protected float landmarkScore;
    protected float mouthScore;
    protected float pitchScore;
    protected float yawScore;
    protected int facesDetected = 0;
    protected float brightness = -1.0f;
    protected float gaussianBlur = -1.0f;
    protected float motionBlur = -1.0f;
    protected float faceQuality = -1.0f;
    protected int checkResult = 0;
    protected boolean success = false;

    public int facesDetected() {
        return this.facesDetected;
    }

    public float getBackHighlight() {
        return this.backHighlight;
    }

    public byte[] getBestImageData() {
        return this.bestImageData;
    }

    public float getBlinkScore() {
        return this.blinkScore;
    }

    public float getBrightDiff() {
        return this.brightDiff;
    }

    public float getBrightness() {
        return this.brightness;
    }

    public int getCheckResult() {
        return this.checkResult;
    }

    public int[] getErrors() {
        return this.errors;
    }

    public RectF getFacePosition() {
        return this.facePosition;
    }

    public float getFaceQuality() {
        return this.faceQuality;
    }

    public Rect getFaceSize() {
        return this.faceSize;
    }

    public float getFaceSpeed() {
        return this.faceSpeed;
    }

    public int getFacesDetected() {
        return this.facesDetected;
    }

    public float getGaussianBlur() {
        return this.gaussianBlur;
    }

    public int getImageHeight() {
        return this.imageHeight;
    }

    public int getImageWidth() {
        return this.imageWidth;
    }

    public float getLandmarkScore() {
        return this.landmarkScore;
    }

    public float getMotionBlur() {
        return this.motionBlur;
    }

    public float getMouthScore() {
        return this.mouthScore;
    }

    public float getPitchScore() {
        return this.pitchScore;
    }

    public float getYawScore() {
        return this.yawScore;
    }

    public boolean hasFace() {
        return facesDetected() > 0;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public ALFaceDetectResult setBackHighlight(float f) {
        this.backHighlight = f;
        return this;
    }

    public void setBestImageData(byte[] bArr) {
        this.bestImageData = bArr;
    }

    public ALFaceDetectResult setBlinkScore(float f) {
        this.blinkScore = f;
        return this;
    }

    public ALFaceDetectResult setBrightDiff(float f) {
        this.brightDiff = f;
        return this;
    }

    public void setBrightness(float f) {
        this.brightness = f;
    }

    public ALFaceDetectResult setCheckResult(int i) {
        this.checkResult = i;
        return this;
    }

    public void setErrors(int[] iArr) {
        this.errors = iArr;
    }

    public void setFacePosition(RectF rectF) {
        this.facePosition = rectF;
    }

    public void setFaceQuality(float f) {
        this.faceQuality = f;
    }

    public void setFaceSize(Rect rect) {
        this.faceSize = rect;
    }

    public ALFaceDetectResult setFaceSpeed(float f) {
        this.faceSpeed = f;
        return this;
    }

    public void setFacesDetected(int i) {
        this.facesDetected = i;
    }

    public void setGaussianBlur(float f) {
        this.gaussianBlur = f;
    }

    public void setImageHeight(int i) {
        this.imageHeight = i;
    }

    public void setImageWidth(int i) {
        this.imageWidth = i;
    }

    public ALFaceDetectResult setLandmarkScore(float f) {
        this.landmarkScore = f;
        return this;
    }

    public void setMotionBlur(float f) {
        this.motionBlur = f;
    }

    public ALFaceDetectResult setMouthScore(float f) {
        this.mouthScore = f;
        return this;
    }

    public ALFaceDetectResult setPitchScore(float f) {
        this.pitchScore = f;
        return this;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }

    public ALFaceDetectResult setYawScore(float f) {
        this.yawScore = f;
        return this;
    }
}
