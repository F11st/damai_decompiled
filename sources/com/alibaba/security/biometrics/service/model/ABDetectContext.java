package com.alibaba.security.biometrics.service.model;

import android.os.Bundle;
import com.alibaba.security.biometrics.service.model.detector.ABDetectType;
import com.alibaba.security.biometrics.service.model.detector.ABFaceFrame;
import com.alibaba.security.biometrics.service.model.result.ABActionResult;
import com.alibaba.security.biometrics.service.model.result.ALBiometricsResult;
import com.youku.live.dago.liveplayback.widget.plugins.resize.AntiShakeOrientationEventListener;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ABDetectContext {
    private static ABDetectContext INSTANCE = null;
    private static final String TAG = "ABDetectContext";
    private boolean everFaceDetected;
    private int lastDetectFailedType;
    private ALBiometricsResult mABResult;
    private List<ABDetectType> mActions;
    private ABFaceFrame mBestFrame;
    private ABActionResult mCurrentActionResult;
    private int retryTimes = 0;
    private int frameCount = 0;
    private int displayWidth = 0;
    private int displayHeight = 0;
    private int rotationAngle = AntiShakeOrientationEventListener.SCREEN_ORIENTATION_LANDSCAPE;
    private long qualityImageTime = -1;
    private int qualityImageCount = 0;
    private boolean needContinueImage = false;
    private int mCurActionIndex = -1;
    private ABDetectType mCurDetectType = ABDetectType.DONE;
    private boolean bRunning = false;
    private Bundle mRecordData = new Bundle();
    private ABDetectPhase mCurrentPhase = ABDetectPhase.INIT;

    private ABDetectContext() {
    }

    private void doReset() {
        this.everFaceDetected = false;
        this.lastDetectFailedType = -100;
        this.frameCount = 0;
        this.mBestFrame = null;
        this.qualityImageCount = 0;
        this.qualityImageTime = 0L;
        this.needContinueImage = false;
    }

    public static ABDetectContext getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ABDetectContext();
        }
        return INSTANCE;
    }

    public void destroy() {
        List<ABDetectType> list = this.mActions;
        if (list != null) {
            list.clear();
        }
    }

    public int getActionCount() {
        List<ABDetectType> list = this.mActions;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public List<ABDetectType> getActions() {
        return this.mActions;
    }

    public ABFaceFrame getBestFrame() {
        return this.mBestFrame;
    }

    public ABDetectType getCurrentAction() {
        return this.mCurDetectType;
    }

    public int getCurrentActionIndex() {
        return this.mCurActionIndex;
    }

    public ABActionResult getCurrentActionResult() {
        return this.mCurrentActionResult;
    }

    public int getCurrentActionStep() {
        return this.mCurActionIndex + 1;
    }

    public ABDetectPhase getCurrentPhase() {
        return this.mCurrentPhase;
    }

    public int getDisplayHeight() {
        return this.displayHeight;
    }

    public int getDisplayWidth() {
        return this.displayWidth;
    }

    public int getFrameCount() {
        return this.frameCount;
    }

    public int getLastDetectFailedType() {
        return this.lastDetectFailedType;
    }

    public int getQualityImageCount() {
        return this.qualityImageCount;
    }

    public long getQualityImageTime() {
        return this.qualityImageTime;
    }

    public Bundle getRecordData() {
        return this.mRecordData;
    }

    public ALBiometricsResult getResult() {
        if (this.mABResult == null) {
            this.mABResult = new ALBiometricsResult();
        }
        return this.mABResult;
    }

    public int getRetryTimes() {
        return this.retryTimes;
    }

    public int getRotationAngle() {
        return this.rotationAngle;
    }

    public boolean isEverFaceDetected() {
        return this.everFaceDetected;
    }

    public boolean isLastAction() {
        List<ABDetectType> list = this.mActions;
        return list == null || this.mCurActionIndex >= list.size() - 1;
    }

    public boolean isNeedContinueImage() {
        return this.needContinueImage;
    }

    public boolean isRunning() {
        return this.bRunning;
    }

    public ABDetectType offerAction() {
        this.mCurDetectType = ABDetectType.DONE;
        List<ABDetectType> list = this.mActions;
        if (list != null && this.mCurActionIndex < list.size() - 1) {
            int i = this.mCurActionIndex + 1;
            this.mCurActionIndex = i;
            this.mCurDetectType = this.mActions.get(i);
        }
        return this.mCurDetectType;
    }

    public void reset() {
        doReset();
    }

    public void setActions(List<ABDetectType> list) {
        this.mActions = list;
        this.mCurActionIndex = -1;
        this.mCurDetectType = ABDetectType.NONE;
    }

    public void setBestFrame(ABFaceFrame aBFaceFrame) {
        this.mBestFrame = aBFaceFrame;
    }

    public void setCurrentActionResult(ABActionResult aBActionResult) {
        this.mCurrentActionResult = aBActionResult;
    }

    public void setCurrentPhase(ABDetectPhase aBDetectPhase) {
        this.mCurrentPhase = aBDetectPhase;
    }

    public void setDisplayHeight(int i) {
        this.displayHeight = i;
    }

    public void setDisplayWidth(int i) {
        this.displayWidth = i;
    }

    public void setEverFaceDetected(boolean z) {
        this.everFaceDetected = z;
    }

    public void setFrameCount(int i) {
        this.frameCount = i;
    }

    public void setLastDetectFailedType(int i) {
        this.lastDetectFailedType = i;
    }

    public void setNeedContinueImage(boolean z) {
        this.needContinueImage = z;
    }

    public void setQualityImageCount(int i) {
        this.qualityImageCount = i;
    }

    public void setQualityImageTime(long j) {
        this.qualityImageTime = j;
    }

    public void setResult(ALBiometricsResult aLBiometricsResult) {
        this.mABResult = aLBiometricsResult;
    }

    public void setRetryTimes(int i) {
        this.retryTimes = i;
    }

    public void setRotationAngle(int i) {
        this.rotationAngle = i;
    }

    public void start() {
        this.bRunning = true;
        this.mCurrentPhase = ABDetectPhase.INIT;
        setRetryTimes(0);
    }

    public void stop() {
        this.bRunning = false;
    }
}
