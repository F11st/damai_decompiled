package com.alibaba.security.biometrics.service.state;

import android.content.Context;
import android.hardware.SensorEvent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Display;
import android.view.WindowManager;
import com.alibaba.security.biometrics.jni.ALBiometricsJni;
import com.alibaba.security.biometrics.service.ALBiometricsService;
import com.alibaba.security.biometrics.service.common.ABLogRecorder;
import com.alibaba.security.biometrics.service.common.ABSensorManager;
import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.alibaba.security.biometrics.service.detector.ABFaceRecapDetector;
import com.alibaba.security.biometrics.service.detector.ABFrameDetector;
import com.alibaba.security.biometrics.service.model.ABDetectContext;
import com.alibaba.security.biometrics.service.model.ABDetectPhase;
import com.alibaba.security.biometrics.service.model.ABDetectTimerTask;
import com.alibaba.security.biometrics.service.model.ALBiometricsType;
import com.alibaba.security.biometrics.service.model.detector.ABDetectType;
import com.alibaba.security.biometrics.service.model.detector.ABFaceFrame;
import com.alibaba.security.biometrics.service.model.detector.DetectInfo;
import com.alibaba.security.biometrics.service.model.listener.ABListenerKeys;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import com.alibaba.security.biometrics.service.model.result.ABActionResult;
import com.alibaba.security.biometrics.service.model.result.ABImageResult;
import com.alibaba.security.biometrics.service.model.result.ALBiometricsResult;
import com.alibaba.security.biometrics.service.model.strategy.ActionStrategy;
import com.alibaba.security.biometrics.service.model.strategy.FixActionStrategy;
import com.alibaba.security.biometrics.service.model.strategy.GroupActionStrategy;
import com.alibaba.security.biometrics.service.util.state.IState;
import com.alibaba.security.biometrics.service.util.state.StateMachine;
import com.alibaba.security.common.d.h;
import com.alibaba.security.common.d.o;
import com.alibaba.security.common.d.p;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import tb.v;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ABStateMachine extends StateMachine implements ABListenerKeys, StateKeys {
    private static final String TAG = "ABStateMachine";
    private boolean inited;
    private ALBiometricsParams mABParams;
    private final ALBiometricsService mABService;
    private ActionDetectBeginState mActionDetectBeginState;
    private ActionDetectEndState mActionDetectEndState;
    private ActionStrategy mActionStrategy;
    private AdjustBeginState mAdjustBeginState;
    private AdjustEndState mAdjustEndState;
    private final Context mContext;
    private DefaultState mDefaultState;
    private final ABDetectHelper mDetectHelper;
    private final ABDetectListener mDetectListener;
    private ABDetectTimerTask mDetectTimerTask;
    private final ABFrameDetector mDetector;
    private FaceDetectState mFaceDetectState;
    private final ABSensorManager mFaceSensorManager;
    private FinishState mFinishState;
    private InitialState mInitialState;
    private final Handler mMainHandler;
    private final Handler mRecognizeHandler;
    private final WindowManager mWindowManager;

    public ABStateMachine(ALBiometricsService aLBiometricsService) {
        super(TAG);
        this.mABService = aLBiometricsService;
        this.mABParams = aLBiometricsService.getParams();
        Context context = aLBiometricsService.getContext();
        this.mContext = context;
        this.mWindowManager = (WindowManager) aLBiometricsService.getContext().getSystemService(v.ATTACH_MODE_WINDOW);
        ABSensorManager aBSensorManager = new ABSensorManager(context, this);
        this.mFaceSensorManager = aBSensorManager;
        aBSensorManager.init();
        this.mMainHandler = new Handler(Looper.getMainLooper());
        HandlerThread handlerThread = new HandlerThread("face_recognize_thread");
        handlerThread.start();
        this.mRecognizeHandler = new Handler(handlerThread.getLooper());
        ABFrameDetector aBFrameDetector = new ABFrameDetector(this, aLBiometricsService.getABEventListener());
        this.mDetector = aBFrameDetector;
        this.mDetectHelper = new ABDetectHelper(context, aLBiometricsService, aBFrameDetector);
        ABDetectListener aBDetectListener = new ABDetectListener(this);
        this.mDetectListener = aBDetectListener;
        aBFrameDetector.setDetectEventListener(aBDetectListener);
        initStrategy();
        instantiateState();
    }

    private void constructState() {
        addState(this.mDefaultState);
        addState(this.mInitialState, this.mDefaultState);
        if (!ALBiometricsType.isDazzle(this.mABParams.mBiometricsType)) {
            if (this.mABParams.faceOnly) {
                addState(this.mFaceDetectState, this.mInitialState);
            } else {
                addState(this.mAdjustBeginState, this.mInitialState);
                addState(this.mAdjustEndState, this.mInitialState);
                addState(this.mActionDetectBeginState, this.mInitialState);
                addState(this.mActionDetectEndState, this.mInitialState);
            }
        }
        addState(this.mFinishState, this.mInitialState);
    }

    private boolean init() {
        this.inited = false;
        boolean init = this.mDetector.init(this.mContext, this.mABParams);
        if (!init) {
            init = this.mDetector.init(this.mContext, this.mABParams);
        }
        this.inited = init;
        return init;
    }

    private void instantiateState() {
        this.mDefaultState = new DefaultState(this);
        this.mInitialState = new InitialState(this);
        if (!ALBiometricsType.isDazzle(this.mABParams.mBiometricsType)) {
            if (this.mABParams.faceOnly) {
                this.mFaceDetectState = new FaceDetectState(this);
            } else {
                this.mAdjustBeginState = new AdjustBeginState(this);
                this.mAdjustEndState = new AdjustEndState(this);
                this.mActionDetectBeginState = new ActionDetectBeginState(this);
                this.mActionDetectEndState = new ActionDetectEndState(this);
            }
        }
        this.mFinishState = new FinishState(this);
        constructState();
    }

    private boolean isNeedDetect() {
        return System.currentTimeMillis() - ABDetectContext.getInstance().getResult().getBt() > 200 && ABDetectContext.getInstance().getCurrentPhase().getValue() < ABDetectPhase.FINISH.getValue();
    }

    private void setDetectTimer() {
        HashMap hashMap = new HashMap();
        hashMap.put("detectType", ALBiometricsType.isDazzle(this.mABParams.mBiometricsType) ? "colorful" : "action");
        hashMap.put("timeout", Integer.valueOf(this.mABParams.timeout));
        ALBiometricsJni.bhL(6, h.a((Object) hashMap));
        resetBioTimeOut(this.mABParams.timeout);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void changeDetectType(ABDetectType aBDetectType, boolean z, boolean z2) {
        this.mDetectHelper.changeDetectType(aBDetectType, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void deferMsg(Message message) {
        deferMessage(message);
    }

    final void genStrategy() {
        ALBiometricsParams aLBiometricsParams = this.mABParams;
        if (aLBiometricsParams.faceOnly || ALBiometricsType.isDazzle(aLBiometricsParams.mBiometricsType)) {
            return;
        }
        List<ABDetectType> detectTypes = this.mActionStrategy.getDetectTypes(this.mABParams.actionCount);
        if (!this.mABParams.stepAdjust && detectTypes.size() > 0) {
            ABDetectType aBDetectType = detectTypes.get(0);
            if (aBDetectType == ABDetectType.BLINK) {
                aBDetectType = ABDetectType.BLINK_STILL;
            } else if (aBDetectType == ABDetectType.MOUTH) {
                aBDetectType = ABDetectType.MOUTH_STILL;
            } else if (aBDetectType == ABDetectType.POS_YAW) {
                aBDetectType = ABDetectType.YAW_STILL;
            } else if (aBDetectType == ABDetectType.POS_PITCH || aBDetectType == ABDetectType.POS_PITCH_UP || aBDetectType == ABDetectType.POS_PITCH_DOWN) {
                aBDetectType = ABDetectType.PITCH_STILL;
            }
            detectTypes.set(0, aBDetectType);
        }
        ABDetectContext.getInstance().setActions(detectTypes);
    }

    public ALBiometricsService getALBiometricsService() {
        return this.mABService;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ActionDetectBeginState getActionDetectBeginState() {
        return this.mActionDetectBeginState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ActionDetectEndState getActionDetectEndState() {
        return this.mActionDetectEndState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final AdjustBeginState getAdjustBeginState() {
        return this.mAdjustBeginState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final AdjustEndState getAdjustEndState() {
        return this.mAdjustEndState;
    }

    final DefaultState getDefaultState() {
        return this.mDefaultState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ABDetectHelper getDetectHelper() {
        return this.mDetectHelper;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ABDetectListener getDetectListener() {
        return this.mDetectListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ABFrameDetector getDetector() {
        return this.mDetector;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final FaceDetectState getFaceDetectState() {
        return this.mFaceDetectState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final FinishState getFinishState() {
        return this.mFinishState;
    }

    final InitialState getInitialState() {
        return this.mInitialState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Handler getMainHandler() {
        return this.mMainHandler;
    }

    final Handler getRecognizeHandler() {
        return this.mRecognizeHandler;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean hasQualityFrame() {
        return this.mDetectHelper.hasQualityFrame();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void initStrategy() {
        ALBiometricsParams aLBiometricsParams = this.mABParams;
        if (aLBiometricsParams.faceOnly || ALBiometricsType.isDazzle(aLBiometricsParams.mBiometricsType)) {
            return;
        }
        int[] iArr = this.mABParams.strategy;
        if (iArr != null && iArr.length > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i : this.mABParams.strategy) {
                arrayList.add(ABDetectType.valueOf(i));
            }
            this.mActionStrategy = new FixActionStrategy(arrayList);
            return;
        }
        this.mActionStrategy = new GroupActionStrategy();
    }

    final boolean isDistanceOK(ABFaceFrame aBFaceFrame) {
        return this.mDetectHelper.isDistanceOK(aBFaceFrame);
    }

    final boolean isEyeOpen(DetectInfo detectInfo) {
        return this.mDetectHelper.isEyeOpen(detectInfo);
    }

    final boolean isIlluminanceOK() {
        return this.mDetectHelper.isIlluminanceOK();
    }

    public boolean isTimeOut() {
        return this.mDetectTimerTask.isTimeOut();
    }

    public void onIlluminanceChanged(float f) {
        ABFrameDetector aBFrameDetector = this.mDetector;
        if (aBFrameDetector != null) {
            aBFrameDetector.setIlluminance(f);
        }
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (ABDetectContext.getInstance().isRunning()) {
            this.mDetectHelper.onSensorChanged(sensorEvent);
        }
    }

    public void processFrame(byte[] bArr, int i, int i2, int i3) {
        boolean z;
        if (ABDetectContext.getInstance().isRunning()) {
            if (bArr == null) {
                this.mDetectListener.onDetectError(GlobalErrorCode.ERROR_DEVICE_CAMERA_DATA_FAIL);
                return;
            }
            ABDetectContext.getInstance().setDisplayWidth(i);
            ABDetectContext.getInstance().setDisplayHeight(i2);
            ABDetectContext.getInstance().setRotationAngle(i3);
            if (isNeedDetect()) {
                this.mDetector.doDetect(bArr, i, i2, i3);
                z = true;
            } else {
                z = false;
            }
            if (z && (i3 == 90 || i3 == 270)) {
                i3 = 0;
                i2 = i;
                i = i2;
            }
            this.mDetectHelper.doDetectContinue(bArr, i, i2, i3);
        }
    }

    final int readReflectPrevFailTimes() {
        return this.mDetectHelper.readReflectPrevFailTimes();
    }

    public void release() {
        quit();
        ABFrameDetector aBFrameDetector = this.mDetector;
        if (aBFrameDetector != null) {
            aBFrameDetector.release();
        }
        ABFaceRecapDetector.dismiss();
        ABDetectContext.getInstance().destroy();
        ABDetectTimerTask aBDetectTimerTask = this.mDetectTimerTask;
        if (aBDetectTimerTask != null) {
            aBDetectTimerTask.setTimerTaskListener(null);
        }
        ABSensorManager aBSensorManager = this.mFaceSensorManager;
        if (aBSensorManager != null) {
            aBSensorManager.unRegisterABSensorListener();
        }
        this.inited = false;
    }

    public void resetBioTimeOut(int i) {
        if (this.mDetectTimerTask == null) {
            this.mDetectTimerTask = new ABDetectTimerTask(i);
        }
        this.mDetectTimerTask.reset();
        this.mDetectTimerTask.start();
    }

    public void restartDetect() {
        ABDetectContext.getInstance().getResult().increaseRetryTime();
        ABDetectContext.getInstance().setRetryTimes(ABDetectContext.getInstance().getRetryTimes() + 1);
        if (ABDetectContext.getInstance().getRetryTimes() > this.mABParams.retryThreshold) {
            this.mDetectListener.onDetectError(GlobalErrorCode.ERROR_USER_RETRY_LIMITED);
        } else {
            startDetect();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean saveActionImages(ABActionResult aBActionResult) {
        return this.mDetectHelper.saveActionImages(this.mDetector, aBActionResult);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void saveFrameInfoToImageResult(ABFaceFrame aBFaceFrame, ABImageResult aBImageResult) {
        this.mDetectHelper.saveFrameInfoToImageResult(aBFaceFrame, aBImageResult);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean saveGlobalImage() {
        return this.mDetectHelper.saveGlobalImage(this.mDetector);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean saveLocalImage() {
        return this.mDetectHelper.saveLocalImage(this.mDetector);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean saveQualityImage() {
        return this.mDetectHelper.saveQualityImage(this.mDetector);
    }

    public void setParams(ALBiometricsParams aLBiometricsParams) {
        if (aLBiometricsParams != null) {
            this.mABParams = aLBiometricsParams;
            ABDetectHelper aBDetectHelper = this.mDetectHelper;
            if (aBDetectHelper != null) {
                aBDetectHelper.setParams(aLBiometricsParams);
            }
            ABDetectListener aBDetectListener = this.mDetectListener;
            if (aBDetectListener != null) {
                aBDetectListener.setParams(this.mABParams);
            }
            sendMessage(999, this.mABParams);
        }
    }

    public void startDetect() {
        if (!this.mABParams.supportX86 && p.f()) {
            this.mDetectListener.onDetectError(GlobalErrorCode.ERROR_DEVICE_NOT_SUPPORT_X86);
        } else if (this.inited || init()) {
            if (ABDetectContext.getInstance().getCurrentPhase() != ABDetectPhase.INIT) {
                sendMessage(0);
            }
            ABLogRecorder.i().setSensorRecordIntervals(this.mABParams.sensorDataIntervals);
            setDetectTimer();
            initStrategy();
            instantiateState();
            genStrategy();
            ABDetectContext.getInstance().reset();
            ABDetectContext.getInstance().start();
            Display defaultDisplay = this.mWindowManager.getDefaultDisplay();
            ABDetectContext.getInstance().setDisplayWidth(defaultDisplay.getWidth());
            ABDetectContext.getInstance().setDisplayHeight(defaultDisplay.getHeight());
            ALBiometricsResult aLBiometricsResult = new ALBiometricsResult();
            aLBiometricsResult.setBt(System.currentTimeMillis());
            aLBiometricsResult.setAid(this.mABParams.appId);
            aLBiometricsResult.setDid(this.mABParams.deviceId);
            aLBiometricsResult.setSid(this.mABParams.sceneId);
            aLBiometricsResult.setUid(this.mABParams.uid);
            aLBiometricsResult.setQi(new ABImageResult());
            aLBiometricsResult.setK(o.a(ALBiometricsJni.generateKeyToken(this.mABParams.secToken)));
            aLBiometricsResult.setLid(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
            ABDetectContext.getInstance().setResult(aLBiometricsResult);
            changeDetectType(ABDetectType.AIMLESS, true, true);
            if (this.mABParams.recapEnable) {
                ABFaceRecapDetector.getInstance().reset();
            }
            ABLogRecorder.i().recordStartDetect(this.mABParams);
            setInitialState(this.mInitialState);
        }
    }

    public void startMachine() {
        start();
    }

    public void stopDetect() {
        try {
            ABDetectContext.getInstance().stop();
            ABDetectTimerTask aBDetectTimerTask = this.mDetectTimerTask;
            if (aBDetectTimerTask != null) {
                aBDetectTimerTask.stop();
            }
            sendMessage(998);
        } catch (Throwable th) {
            ABLogRecorder.i().record(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void transitionState(IState iState) {
        if (iState != null) {
            transitionTo(iState);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void triggerDetectError(int i, Bundle bundle) {
        this.mDetectHelper.triggerDetectError(i, bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void triggerDetectSuccess() {
        this.mABService.stop();
        this.mDetectHelper.triggerDetectSuccess();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void triggerEventListener(int i) {
        this.mDetectHelper.triggerEventListener(i);
    }

    final void writeReflectPrevFailTimes(int i) {
        this.mDetectHelper.writeReflectPrevFailTimes(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void triggerEventListener(int i, Object obj) {
        this.mDetectHelper.triggerEventListener(i, obj);
    }
}
