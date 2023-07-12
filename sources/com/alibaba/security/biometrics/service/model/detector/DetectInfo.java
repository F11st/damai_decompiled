package com.alibaba.security.biometrics.service.model.detector;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class DetectInfo {
    public static int CENTER = 5;
    public static int DOWN = 1;
    public static int LEFT = 2;
    public static int LEFTRIGHT = 4;
    public static int RIGHT = 0;
    public static int UP = 3;
    protected float backHightlight;
    protected float blinkScore;
    protected float brightDiff;
    String brightnessHistoryLog;
    String brightnessScoresLog;
    protected Bundle data;
    protected Rect faceSize;
    protected float faceSpeed;
    protected float landmarkScore;
    protected float[] landmarks;
    protected Rect leftEyeRect;
    protected Point leftPupilCenter;
    protected float mouthScore;
    protected float pitchScore;
    protected RectF position;
    int reflectBrightnessFrames;
    float reflectBrightnessScore;
    float[] reflectBrightnessScores;
    int reflectEyeFrames;
    int reflectEyeValidFrames;
    int reflectFrames;
    float reflectScore;
    protected Rect rightEyeRect;
    protected Point rightPupilCenter;
    protected float staticQuality;
    protected float yawScore;
    protected int checkResult = 0;
    protected int ec = -1;
    protected int ecpc = -1;
    protected int etcc = -1;
    protected String ecResult = "";
    protected float gestureProgress = -1.0f;
    protected int actionRange = -1;
    protected int actionPosition = -1;
    protected float yaw = 0.0f;
    protected float pitch = 0.0f;
    protected float gaussianBlur = 0.0f;
    protected float motionBlur = 0.0f;
    protected float brightness = 0.0f;
    protected float wearGlass = 0.0f;
    protected float faceQuality = 0.0f;
    protected float leftEyeHWRatio = 0.0f;
    protected float rightEyeHWRatio = 0.0f;
    protected float mouthHWRatio = 0.0f;
    protected float integrity = 0.0f;
    protected boolean pitch3d = false;
    protected boolean notVideo = false;
    protected boolean mouthOpen = false;
    protected boolean eyeBlink = false;
    protected float smoothYaw = 0.0f;
    protected float smoothPitch = 0.0f;
    int reflectBrightnessResult = -1;
    int reflectResult = -1;
    int reflectEyeResult = -1;
    int reflectLeftEyeResult = -1;
    int reflectRightEyeResult = -1;

    public int getActionPosition() {
        return this.actionPosition;
    }

    public int getActionRange() {
        return this.actionRange;
    }

    public float getBackHightlight() {
        return this.backHightlight;
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

    public String getBrightnessHistoryLog() {
        return this.brightnessHistoryLog;
    }

    public String getBrightnessScoresLog() {
        return this.brightnessScoresLog;
    }

    public int getCheckResult() {
        return this.checkResult;
    }

    public Bundle getData() {
        return this.data;
    }

    public int getEc() {
        return this.ec;
    }

    public String getEcResult() {
        return this.ecResult;
    }

    public int getEcpc() {
        return this.ecpc;
    }

    public int getEtcc() {
        return this.etcc;
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

    public float getGaussianBlur() {
        return this.gaussianBlur;
    }

    public float getGestureProgress() {
        return this.gestureProgress;
    }

    public float getIntegrity() {
        return this.integrity;
    }

    public float getLandmarkScore() {
        return this.landmarkScore;
    }

    public float[] getLandmarks() {
        return this.landmarks;
    }

    public float getLeftEyeHWRatio() {
        return this.leftEyeHWRatio;
    }

    public Rect getLeftEyeRect() {
        return this.leftEyeRect;
    }

    public Point getLeftPupilCenter() {
        return this.leftPupilCenter;
    }

    public float getMotionBlur() {
        return this.motionBlur;
    }

    public float getMouthHWRatio() {
        return this.mouthHWRatio;
    }

    public float getMouthScore() {
        return this.mouthScore;
    }

    public float getPitch() {
        return this.pitch;
    }

    public float getPitchScore() {
        return this.pitchScore;
    }

    public RectF getPosition() {
        return this.position;
    }

    public int getReflectBrightnessFrames() {
        return this.reflectBrightnessFrames;
    }

    public int getReflectBrightnessResult() {
        return this.reflectBrightnessResult;
    }

    public float getReflectBrightnessScore() {
        return this.reflectBrightnessScore;
    }

    public float[] getReflectBrightnessScores() {
        return this.reflectBrightnessScores;
    }

    public int getReflectEyeFrames() {
        return this.reflectEyeFrames;
    }

    public int getReflectEyeResult() {
        return this.reflectEyeResult;
    }

    public int getReflectEyeValidFrames() {
        return this.reflectEyeValidFrames;
    }

    public int getReflectFrames() {
        return this.reflectFrames;
    }

    public int getReflectLeftEyeResult() {
        return this.reflectLeftEyeResult;
    }

    public int getReflectResult() {
        return this.reflectResult;
    }

    public int getReflectRightEyeResult() {
        return this.reflectRightEyeResult;
    }

    public float getReflectScore() {
        return this.reflectScore;
    }

    public float getRightEyeHWRatio() {
        return this.rightEyeHWRatio;
    }

    public Rect getRightEyeRect() {
        return this.rightEyeRect;
    }

    public Point getRightPupilCenter() {
        return this.rightPupilCenter;
    }

    public float getSmoothPitch() {
        return this.smoothPitch;
    }

    public float getSmoothYaw() {
        return this.smoothYaw;
    }

    public float getStaticQuality() {
        return this.staticQuality;
    }

    public float getWearGlass() {
        return this.wearGlass;
    }

    public float getYaw() {
        return this.yaw;
    }

    public float getYawScore() {
        return this.yawScore;
    }

    public boolean isEyeBlink() {
        return this.eyeBlink;
    }

    public boolean isMouthOpen() {
        return this.mouthOpen;
    }

    public boolean isNotVideo() {
        return this.notVideo;
    }

    public boolean isPitch3d() {
        return this.pitch3d;
    }

    public DetectInfo setActionPosition(int i) {
        this.actionPosition = i;
        return this;
    }

    public DetectInfo setActionRange(int i) {
        this.actionRange = i;
        return this;
    }

    public DetectInfo setBackHightlight(float f) {
        this.backHightlight = f;
        return this;
    }

    public DetectInfo setBlinkScore(float f) {
        this.blinkScore = f;
        return this;
    }

    public DetectInfo setBrightDiff(float f) {
        this.brightDiff = f;
        return this;
    }

    public void setBrightness(float f) {
        this.brightness = f;
    }

    public DetectInfo setBrightnessHistoryLog(String str) {
        this.brightnessHistoryLog = str;
        return this;
    }

    public DetectInfo setBrightnessScoresLog(String str) {
        this.brightnessScoresLog = str;
        return this;
    }

    public DetectInfo setCheckResult(int i) {
        this.checkResult = i;
        return this;
    }

    public void setData(Bundle bundle) {
        this.data = bundle;
    }

    public void setEc(int i) {
        this.ec = i;
    }

    public void setEcResult(String str) {
        this.ecResult = str;
    }

    public void setEcpc(int i) {
        this.ecpc = i;
    }

    public void setEtcc(int i) {
        this.etcc = i;
    }

    public void setEyeBlink(boolean z) {
        this.eyeBlink = z;
    }

    public void setFaceQuality(float f) {
        this.faceQuality = f;
    }

    public void setFaceSize(Rect rect) {
        this.faceSize = rect;
    }

    public DetectInfo setFaceSpeed(float f) {
        this.faceSpeed = f;
        return this;
    }

    public void setGaussianBlur(float f) {
        this.gaussianBlur = f;
    }

    public DetectInfo setGestureProgress(float f) {
        this.gestureProgress = f;
        return this;
    }

    public void setIntegrity(float f) {
        this.integrity = f;
    }

    public DetectInfo setLandmarkScore(float f) {
        this.landmarkScore = f;
        return this;
    }

    public DetectInfo setLandmarks(float[] fArr) {
        this.landmarks = fArr;
        return this;
    }

    public void setLeftEyeHWRatio(float f) {
        this.leftEyeHWRatio = f;
    }

    public void setLeftEyeRect(Rect rect) {
        this.leftEyeRect = rect;
    }

    public void setLeftPupilCenter(Point point) {
        this.leftPupilCenter = point;
    }

    public void setMotionBlur(float f) {
        this.motionBlur = f;
    }

    public void setMouthHWRatio(float f) {
        this.mouthHWRatio = f;
    }

    public void setMouthOpen(boolean z) {
        this.mouthOpen = z;
    }

    public DetectInfo setMouthScore(float f) {
        this.mouthScore = f;
        return this;
    }

    public void setNotVideo(boolean z) {
        this.notVideo = z;
    }

    public void setPitch(float f) {
        this.pitch = f;
    }

    public void setPitch3d(boolean z) {
        this.pitch3d = z;
    }

    public DetectInfo setPitchScore(float f) {
        this.pitchScore = f;
        return this;
    }

    public void setPosition(RectF rectF) {
        this.position = rectF;
    }

    public DetectInfo setReflectBrightnessFrames(int i) {
        this.reflectBrightnessFrames = i;
        return this;
    }

    public DetectInfo setReflectBrightnessResult(int i) {
        this.reflectBrightnessResult = i;
        return this;
    }

    public DetectInfo setReflectBrightnessScore(float f) {
        this.reflectBrightnessScore = f;
        return this;
    }

    public DetectInfo setReflectBrightnessScores(float[] fArr) {
        this.reflectBrightnessScores = fArr;
        return this;
    }

    public DetectInfo setReflectEyeFrames(int i) {
        this.reflectEyeFrames = i;
        return this;
    }

    public DetectInfo setReflectEyeResult(int i) {
        this.reflectEyeResult = i;
        return this;
    }

    public DetectInfo setReflectEyeValidFrames(int i) {
        this.reflectEyeValidFrames = i;
        return this;
    }

    public DetectInfo setReflectFrames(int i) {
        this.reflectFrames = i;
        return this;
    }

    public DetectInfo setReflectLeftEyeResult(int i) {
        this.reflectLeftEyeResult = i;
        return this;
    }

    public DetectInfo setReflectResult(int i) {
        this.reflectResult = i;
        return this;
    }

    public DetectInfo setReflectRightEyeResult(int i) {
        this.reflectRightEyeResult = i;
        return this;
    }

    public DetectInfo setReflectScore(float f) {
        this.reflectScore = f;
        return this;
    }

    public void setRightEyeHWRatio(float f) {
        this.rightEyeHWRatio = f;
    }

    public void setRightEyeRect(Rect rect) {
        this.rightEyeRect = rect;
    }

    public void setRightPupilCenter(Point point) {
        this.rightPupilCenter = point;
    }

    public void setSmoothPitch(float f) {
        this.smoothPitch = f;
    }

    public void setSmoothYaw(float f) {
        this.smoothYaw = f;
    }

    public DetectInfo setStaticQuality(float f) {
        this.staticQuality = f;
        return this;
    }

    public void setWearGlass(float f) {
        this.wearGlass = f;
    }

    public void setYaw(float f) {
        this.yaw = f;
    }

    public DetectInfo setYawScore(float f) {
        this.yawScore = f;
        return this;
    }

    public String toString() {
        return "DetectInfo{faceSize=" + this.faceSize + ", position=" + this.position + ", yaw=" + this.yaw + ", pitch=" + this.pitch + ", gaussianBlur=" + this.gaussianBlur + ", motionBlur=" + this.motionBlur + ", brightness=" + this.brightness + ", wearGlass=" + this.wearGlass + ", faceQuality=" + this.faceQuality + ", staticQuality=" + this.staticQuality + ", leftEyeHWRatio=" + this.leftEyeHWRatio + ", rightEyeHWRatio=" + this.rightEyeHWRatio + ", mouthHWRatio=" + this.mouthHWRatio + ", integrity=" + this.integrity + ", pitch3d=" + this.pitch3d + ", notVideo=" + this.notVideo + ", mouthOpen=" + this.mouthOpen + ", eyeBlink=" + this.eyeBlink + ", smoothYaw=" + this.smoothYaw + ", smoothPitch=" + this.smoothPitch + ", leftEyeRect=" + this.leftEyeRect + ", leftPupilCenter=" + this.leftPupilCenter + ", rightEyeRect=" + this.rightEyeRect + ", rightPupilCenter=" + this.rightPupilCenter + ", data=" + this.data + ", checkResult=" + this.checkResult + ", pitchScore=" + this.pitchScore + ", yawScore=" + this.yawScore + ", mouthScore=" + this.mouthScore + ", blinkScore=" + this.blinkScore + ", landmarkScore=" + this.landmarkScore + ", brightDiff=" + this.brightDiff + ", backHightlight=" + this.backHightlight + '}';
    }
}
