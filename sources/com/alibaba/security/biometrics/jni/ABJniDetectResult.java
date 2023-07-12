package com.alibaba.security.biometrics.jni;

import android.graphics.Rect;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.security.biometrics.service.common.ABLogRecorderKeys;
import com.taobao.weex.common.Constants;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ABJniDetectResult implements Serializable {
    @JSONField(name = "brightnessHistory")
    public String brightnessHistory;
    @JSONField(name = "brightnessScores")
    public String brightnessScores;
    @JSONField(serialize = false)
    public int faceHeight;
    @JSONField(serialize = false)
    public int faceLeft;
    @JSONField(serialize = false)
    public int faceTop;
    @JSONField(serialize = false)
    public int faceWidth;
    @JSONField(name = "leftEyeDataHeight")
    public int leftEyeDataHeight;
    @JSONField(name = "leftEyeDataWidth")
    public int leftEyeDataWidth;
    @JSONField(name = "reflectBrightnessFrames")
    public int reflectBrightnessFrames;
    @JSONField(name = "reflectBrightnessScore")
    public float reflectBrightnessScore;
    @JSONField(name = "reflectBrightnessScores")
    public float[] reflectBrightnessScores;
    @JSONField(name = "reflectDetectType")
    public int reflectDetectType;
    @JSONField(name = "reflectEyeFrames")
    public int reflectEyeFrames;
    @JSONField(name = "reflectEyeValidFrames")
    public int reflectEyeValidFrames;
    @JSONField(name = "reflectFrames")
    public int reflectFrames;
    @JSONField(name = "reflectScore")
    public float reflectScore;
    @JSONField(name = "rightEyeDataHeight")
    public int rightEyeDataHeight;
    @JSONField(name = "rightEyeDataWidth")
    public int rightEyeDataWidth;
    @JSONField(name = "faceExist")
    public boolean faceExist = false;
    @JSONField(serialize = false)
    public float[] faceKeyPoint = new float[36];
    @JSONField(serialize = false)
    public float[] faceKeyPointInBigImg = new float[36];
    @JSONField(serialize = false)
    public Rect faceRectSmooth = new Rect();
    @JSONField(serialize = false)
    public long initTime = 0;
    @JSONField(name = "iDetectType")
    protected int iDetectType = 0;
    @JSONField(name = "iDetectTypeOld")
    protected int iDetectTypeOld = 0;
    @JSONField(name = "iDetectState")
    protected int iDetectState = 0;
    @JSONField(serialize = false)
    public int msecChangeDetectType = 0;
    @JSONField(serialize = false)
    public int msecCurrentTime = 0;
    @JSONField(name = "outOfRegion")
    public boolean outOfRegion = false;
    @JSONField(name = "tooSmall")
    public boolean tooSmall = false;
    @JSONField(name = "tooBig")
    public boolean tooBig = false;
    @JSONField(name = "still")
    public boolean still = false;
    @JSONField(name = "brightness")
    public float brightness = 0.0f;
    @JSONField(name = Constants.Name.QUALITY)
    public float quality = 0.0f;
    @JSONField(name = "staticQuality")
    public float staticQuality = 0.0f;
    @JSONField(name = "pitchScore")
    public float pitchScore = 0.0f;
    @JSONField(name = "yawScore")
    public float yawScore = 0.0f;
    @JSONField(name = "mouthScore")
    public float mouthScore = 0.0f;
    @JSONField(name = "blinkScore")
    public float blinkScore = 0.0f;
    @JSONField(name = "landmarkScore")
    public float landmarkScore = -1.0f;
    @JSONField(name = "brightDiff")
    public float brightDiff = 0.0f;
    @JSONField(name = "backHightlight")
    public float backHightlight = 0.0f;
    @JSONField(name = "faceSpeed")
    public float faceSpeed = 0.0f;
    @JSONField(name = "gestureProgress")
    public float gestureProgress = 0.0f;
    @JSONField(name = "countPitch")
    public int countPitch = 0;
    @JSONField(name = "countYaw")
    public int countYaw = 0;
    @JSONField(name = "countMouth")
    public int countMouth = 0;
    @JSONField(name = "countBlink")
    public int countBlink = 0;
    @JSONField(name = "countFaceDisappear")
    public int countFaceDisappear = 0;
    @JSONField(name = "faceChange")
    public boolean faceChange = false;
    @JSONField(name = "mouthOcclusion")
    public boolean mouthOcclusion = false;
    @JSONField(name = "eyeOcclusionOnce")
    public boolean eyeOcclusionOnce = false;
    @JSONField(name = "confirm3D")
    public boolean confirm3D = false;
    @JSONField(serialize = false)
    public int msecLeft = 10000;
    @JSONField(name = "iPromptMessage")
    protected int iPromptMessage = 0;
    @JSONField(name = "iFailReason")
    protected int iFailReason = 0;
    @JSONField(serialize = false)
    public int bigImgWidth = 0;
    @JSONField(serialize = false)
    public int bigImgHeight = 0;
    @JSONField(serialize = false)
    public byte[] bigImgBuffer = null;
    @JSONField(serialize = false)
    public int globalImgWidth = 0;
    @JSONField(serialize = false)
    public int globalImgHeight = 0;
    @JSONField(serialize = false)
    public byte[] globalImgBuffer = null;
    @JSONField(serialize = false)
    public int localImgWidth = 0;
    @JSONField(serialize = false)
    public int localImgHeight = 0;
    @JSONField(serialize = false)
    public byte[] localImgBuffer = null;
    @JSONField(serialize = false)
    public int actionImgWidth = 0;
    @JSONField(serialize = false)
    public int actionImgHeight = 0;
    @JSONField(serialize = false)
    public byte[][] actionImgBuffer = null;
    @JSONField(serialize = false)
    public int frameWidth = 0;
    @JSONField(serialize = false)
    public int frameHeight = 0;
    @JSONField(serialize = false)
    public byte[] frameBuffer = null;
    @JSONField(serialize = false)
    public String failLog = null;
    @JSONField(name = "reflectResult")
    public int reflectResult = -1;
    @JSONField(name = "reflectBrightnessResult")
    public int reflectBrightnessResult = -1;
    @JSONField(name = "reflectEyeResult")
    public int reflectEyeResult = -1;
    @JSONField(name = "reflectLeftEyeResult")
    public int reflectLeftEyeResult = -1;
    @JSONField(name = "reflectRightEyeResult")
    public int reflectRightEyeResult = -1;
    @JSONField(name = ABLogRecorderKeys.FieldISO)
    public float iso = -1.0f;
    @JSONField(name = ABLogRecorderKeys.FieldIlluminance)
    public float illuminance = -1.0f;
    @JSONField(name = "reflectCmd")
    public int reflectCmd = -1;
    public byte[] leftEyeData = null;
    public byte[] rightEyeData = null;
    @JSONField(name = "ec")
    public int ec = -1;
    @JSONField(name = "ecpc")
    public int ecpc = -1;
    @JSONField(name = "etcc")
    public int etcc = -1;
    @JSONField(name = "ecResult")
    public String ecResult = "";

    public ABJniDetectState detectState() {
        return ABJniDetectState.values()[this.iDetectState];
    }

    public ABJniDetectType detectType() {
        return ABJniDetectType.valueOf(this.iDetectType);
    }

    public ABJniDetectType detectTypeOld() {
        return ABJniDetectType.valueOf(this.iDetectTypeOld);
    }

    public ABJniFailReason failReason() {
        return ABJniFailReason.valueOf(this.iFailReason);
    }

    public byte[][] getActionImgBuffer() {
        return this.actionImgBuffer;
    }

    public int getActionImgHeight() {
        return this.actionImgHeight;
    }

    public int getActionImgWidth() {
        return this.actionImgWidth;
    }

    public float getBackHightlight() {
        return this.backHightlight;
    }

    public byte[] getBigImgBuffer() {
        return this.bigImgBuffer;
    }

    public int getBigImgHeight() {
        return this.bigImgHeight;
    }

    public int getBigImgWidth() {
        return this.bigImgWidth;
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

    public String getBrightnessHistory() {
        return this.brightnessHistory;
    }

    public String getBrightnessScores() {
        return this.brightnessScores;
    }

    public int getCountBlink() {
        return this.countBlink;
    }

    public int getCountFaceDisappear() {
        return this.countFaceDisappear;
    }

    public int getCountMouth() {
        return this.countMouth;
    }

    public int getCountPitch() {
        return this.countPitch;
    }

    public int getCountYaw() {
        return this.countYaw;
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

    public int getFaceHeight() {
        return this.faceHeight;
    }

    public float[] getFaceKeyPoint() {
        return this.faceKeyPoint;
    }

    public float[] getFaceKeyPointInBigImg() {
        return this.faceKeyPointInBigImg;
    }

    public int getFaceLeft() {
        return this.faceLeft;
    }

    public Rect getFaceRectSmooth() {
        return this.faceRectSmooth;
    }

    public float getFaceSpeed() {
        return this.faceSpeed;
    }

    public int getFaceTop() {
        return this.faceTop;
    }

    public int getFaceWidth() {
        return this.faceWidth;
    }

    public String getFailLog() {
        return this.failLog;
    }

    public byte[] getFrameBuffer() {
        return this.frameBuffer;
    }

    public int getFrameHeight() {
        return this.frameHeight;
    }

    public int getFrameWidth() {
        return this.frameWidth;
    }

    public float getGestureProgress() {
        return this.gestureProgress;
    }

    public byte[] getGlobalImgBuffer() {
        return this.globalImgBuffer;
    }

    public int getGlobalImgHeight() {
        return this.globalImgHeight;
    }

    public int getGlobalImgWidth() {
        return this.globalImgWidth;
    }

    public float getIlluminance() {
        return this.illuminance;
    }

    public long getInitTime() {
        return this.initTime;
    }

    public float getIso() {
        return this.iso;
    }

    public float getLandmarkScore() {
        return this.landmarkScore;
    }

    public byte[] getLeftEyeData() {
        return this.leftEyeData;
    }

    public int getLeftEyeDataHeight() {
        return this.leftEyeDataHeight;
    }

    public int getLeftEyeDataWidth() {
        return this.leftEyeDataWidth;
    }

    public byte[] getLocalImgBuffer() {
        return this.localImgBuffer;
    }

    public int getLocalImgHeight() {
        return this.localImgHeight;
    }

    public int getLocalImgWidth() {
        return this.localImgWidth;
    }

    public float getMouthScore() {
        return this.mouthScore;
    }

    public int getMsecChangeDetectType() {
        return this.msecChangeDetectType;
    }

    public int getMsecCurrentTime() {
        return this.msecCurrentTime;
    }

    public int getMsecLeft() {
        return this.msecLeft;
    }

    public float getPitchScore() {
        return this.pitchScore;
    }

    public float getQuality() {
        return this.quality;
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

    public int getReflectCmd() {
        return this.reflectCmd;
    }

    public int getReflectDetectType() {
        return this.reflectDetectType;
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

    public byte[] getRightEyeData() {
        return this.rightEyeData;
    }

    public int getRightEyeDataHeight() {
        return this.rightEyeDataHeight;
    }

    public int getRightEyeDataWidth() {
        return this.rightEyeDataWidth;
    }

    public float getStaticQuality() {
        return this.staticQuality;
    }

    public float getYawScore() {
        return this.yawScore;
    }

    public int getiDetectState() {
        return this.iDetectState;
    }

    public int getiDetectType() {
        return this.iDetectType;
    }

    public int getiDetectTypeOld() {
        return this.iDetectTypeOld;
    }

    public int getiFailReason() {
        return this.iFailReason;
    }

    public int getiPromptMessage() {
        return this.iPromptMessage;
    }

    public boolean isConfirm3D() {
        return this.confirm3D;
    }

    public boolean isEyeOcclusionOnce() {
        return this.eyeOcclusionOnce;
    }

    public boolean isFaceChange() {
        return this.faceChange;
    }

    public boolean isFaceExist() {
        return this.faceExist;
    }

    public boolean isMouthOcclusion() {
        return this.mouthOcclusion;
    }

    public boolean isOutOfRegion() {
        return this.outOfRegion;
    }

    public boolean isStill() {
        return this.still;
    }

    public boolean isTooBig() {
        return this.tooBig;
    }

    public boolean isTooSmall() {
        return this.tooSmall;
    }

    public ABJniPromptMessage promptMessage() {
        return ABJniPromptMessage.values()[this.iPromptMessage];
    }

    public void setActionImgBuffer(byte[][] bArr) {
        this.actionImgBuffer = bArr;
    }

    public void setActionImgHeight(int i) {
        this.actionImgHeight = i;
    }

    public void setActionImgWidth(int i) {
        this.actionImgWidth = i;
    }

    public void setBackHightlight(float f) {
        this.backHightlight = f;
    }

    public void setBigImgBuffer(byte[] bArr) {
        this.bigImgBuffer = bArr;
    }

    public void setBigImgHeight(int i) {
        this.bigImgHeight = i;
    }

    public void setBigImgWidth(int i) {
        this.bigImgWidth = i;
    }

    public void setBlinkScore(float f) {
        this.blinkScore = f;
    }

    public void setBrightDiff(float f) {
        this.brightDiff = f;
    }

    public void setBrightness(float f) {
        this.brightness = f;
    }

    public void setBrightnessHistory(String str) {
        this.brightnessHistory = str;
    }

    public void setBrightnessScores(String str) {
        this.brightnessScores = str;
    }

    public void setConfirm3D(boolean z) {
        this.confirm3D = z;
    }

    public void setCountBlink(int i) {
        this.countBlink = i;
    }

    public void setCountFaceDisappear(int i) {
        this.countFaceDisappear = i;
    }

    public void setCountMouth(int i) {
        this.countMouth = i;
    }

    public void setCountPitch(int i) {
        this.countPitch = i;
    }

    public void setCountYaw(int i) {
        this.countYaw = i;
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

    public void setEyeOcclusionOnce(boolean z) {
        this.eyeOcclusionOnce = z;
    }

    public void setFaceChange(boolean z) {
        this.faceChange = z;
    }

    public void setFaceExist(boolean z) {
        this.faceExist = z;
    }

    public void setFaceHeight(int i) {
        this.faceHeight = i;
    }

    public void setFaceKeyPoint(float[] fArr) {
        this.faceKeyPoint = fArr;
    }

    public void setFaceKeyPointInBigImg(float[] fArr) {
        this.faceKeyPointInBigImg = fArr;
    }

    public void setFaceLeft(int i) {
        this.faceLeft = i;
    }

    public void setFaceRectSmooth(Rect rect) {
        this.faceRectSmooth = rect;
    }

    public void setFaceSpeed(float f) {
        this.faceSpeed = f;
    }

    public void setFaceTop(int i) {
        this.faceTop = i;
    }

    public void setFaceWidth(int i) {
        this.faceWidth = i;
    }

    public void setFailLog(String str) {
        this.failLog = str;
    }

    public void setFrameBuffer(byte[] bArr) {
        this.frameBuffer = bArr;
    }

    public void setFrameHeight(int i) {
        this.frameHeight = i;
    }

    public void setFrameWidth(int i) {
        this.frameWidth = i;
    }

    public void setGestureProgress(float f) {
        this.gestureProgress = f;
    }

    public void setGlobalImgBuffer(byte[] bArr) {
        this.globalImgBuffer = bArr;
    }

    public void setGlobalImgHeight(int i) {
        this.globalImgHeight = i;
    }

    public void setGlobalImgWidth(int i) {
        this.globalImgWidth = i;
    }

    public void setIlluminance(float f) {
        this.illuminance = f;
    }

    public void setInitTime(long j) {
        this.initTime = j;
    }

    public void setIso(float f) {
        this.iso = f;
    }

    public void setLandmarkScore(float f) {
        this.landmarkScore = f;
    }

    public void setLeftEyeData(byte[] bArr) {
        this.leftEyeData = bArr;
    }

    public void setLeftEyeDataHeight(int i) {
        this.leftEyeDataHeight = i;
    }

    public void setLeftEyeDataWidth(int i) {
        this.leftEyeDataWidth = i;
    }

    public void setLocalImgBuffer(byte[] bArr) {
        this.localImgBuffer = bArr;
    }

    public void setLocalImgHeight(int i) {
        this.localImgHeight = i;
    }

    public void setLocalImgWidth(int i) {
        this.localImgWidth = i;
    }

    public void setMouthOcclusion(boolean z) {
        this.mouthOcclusion = z;
    }

    public void setMouthScore(float f) {
        this.mouthScore = f;
    }

    public void setMsecChangeDetectType(int i) {
        this.msecChangeDetectType = i;
    }

    public void setMsecCurrentTime(int i) {
        this.msecCurrentTime = i;
    }

    public void setMsecLeft(int i) {
        this.msecLeft = i;
    }

    public void setOutOfRegion(boolean z) {
        this.outOfRegion = z;
    }

    public void setPitchScore(float f) {
        this.pitchScore = f;
    }

    public void setQuality(float f) {
        this.quality = f;
    }

    public void setReflectBrightnessFrames(int i) {
        this.reflectBrightnessFrames = i;
    }

    public void setReflectBrightnessResult(int i) {
        this.reflectBrightnessResult = i;
    }

    public void setReflectBrightnessScore(float f) {
        this.reflectBrightnessScore = f;
    }

    public void setReflectBrightnessScores(float[] fArr) {
        this.reflectBrightnessScores = fArr;
    }

    public void setReflectCmd(int i) {
        this.reflectCmd = i;
    }

    public void setReflectDetectType(int i) {
        this.reflectDetectType = i;
    }

    public void setReflectEyeFrames(int i) {
        this.reflectEyeFrames = i;
    }

    public void setReflectEyeResult(int i) {
        this.reflectEyeResult = i;
    }

    public void setReflectEyeValidFrames(int i) {
        this.reflectEyeValidFrames = i;
    }

    public void setReflectFrames(int i) {
        this.reflectFrames = i;
    }

    public void setReflectLeftEyeResult(int i) {
        this.reflectLeftEyeResult = i;
    }

    public void setReflectResult(int i) {
        this.reflectResult = i;
    }

    public void setReflectRightEyeResult(int i) {
        this.reflectRightEyeResult = i;
    }

    public void setReflectScore(float f) {
        this.reflectScore = f;
    }

    public void setRightEyeData(byte[] bArr) {
        this.rightEyeData = bArr;
    }

    public void setRightEyeDataHeight(int i) {
        this.rightEyeDataHeight = i;
    }

    public void setRightEyeDataWidth(int i) {
        this.rightEyeDataWidth = i;
    }

    public void setStaticQuality(float f) {
        this.staticQuality = f;
    }

    public void setStill(boolean z) {
        this.still = z;
    }

    public void setTooBig(boolean z) {
        this.tooBig = z;
    }

    public void setTooSmall(boolean z) {
        this.tooSmall = z;
    }

    public void setYawScore(float f) {
        this.yawScore = f;
    }

    public void setiDetectState(int i) {
        this.iDetectState = i;
    }

    public void setiDetectType(int i) {
        this.iDetectType = i;
    }

    public void setiDetectTypeOld(int i) {
        this.iDetectTypeOld = i;
    }

    public void setiFailReason(int i) {
        this.iFailReason = i;
    }

    public void setiPromptMessage(int i) {
        this.iPromptMessage = i;
    }

    public String toString() {
        return "face exist = " + this.faceExist + "，init time = " + this.initTime + "，current time = " + this.msecCurrentTime + "，detect type = " + detectType() + "，detect state = " + detectState() + "，change detect time = " + this.msecChangeDetectType + "，out of region = " + this.outOfRegion + "，too small = " + this.tooSmall + "，too big = " + this.tooBig + "，still = " + this.still + "，brightness = " + ((int) this.brightness) + " / " + this.brightDiff + " / " + ((int) this.backHightlight) + "，quality = " + ((int) this.quality) + " / " + ((int) this.staticQuality) + "，speed = " + this.faceSpeed + "，gesture = " + this.gestureProgress + "，yaw = " + this.countYaw + " / " + this.yawScore + "，pitch = " + this.countPitch + " / " + this.pitchScore + "，mouth = " + this.countMouth + " / " + this.mouthScore + "，blink = " + this.countBlink + " / " + this.blinkScore + "，disappear = " + this.countFaceDisappear + " / " + this.landmarkScore + "，face change = " + this.faceChange + "，occlusion = " + this.mouthOcclusion + " / " + this.eyeOcclusionOnce + "，confirm 3D = " + this.confirm3D + "，rect = " + this.faceRectSmooth + "，time left = " + this.msecLeft + "，detect type old = " + detectTypeOld() + "，fail reason = " + failReason() + "，fail reason message = " + failReason().getMessage() + "，failLog = " + this.failLog;
    }
}
