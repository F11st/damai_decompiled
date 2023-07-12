package com.alibaba.security.biometrics.service.state;

import android.os.Bundle;
import com.alibaba.security.biometrics.service.ALBiometricsService;
import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.alibaba.security.biometrics.service.detector.ABFrameDetector;
import com.alibaba.security.biometrics.service.model.ABDetectContext;
import com.alibaba.security.biometrics.service.model.ABDetectFrame;
import com.alibaba.security.biometrics.service.model.ABDetectPhase;
import com.alibaba.security.biometrics.service.model.detector.ABDetectType;
import com.alibaba.security.biometrics.service.model.detector.ABFaceFrame;
import com.alibaba.security.biometrics.service.model.detector.DetectEventListener;
import com.alibaba.security.biometrics.service.model.detector.MineInfo;
import com.alibaba.security.biometrics.service.model.listener.ParamBundleResult;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import com.alibaba.security.common.track.model.TrackLog;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ABDetectListener implements DetectEventListener, StateKeys {
    private static final String TAG = "ABDetectListener";
    private ALBiometricsParams mABParams;
    private ALBiometricsService mABService;
    private ABStateMachine mABStateMachine;
    private ABDetectHelper mDetectHelper;

    public ABDetectListener(ABStateMachine aBStateMachine) {
        this.mABStateMachine = aBStateMachine;
        ALBiometricsService aLBiometricsService = aBStateMachine.getALBiometricsService();
        this.mABService = aLBiometricsService;
        this.mABParams = aLBiometricsService.getParams();
        this.mDetectHelper = this.mABStateMachine.getDetectHelper();
    }

    private int convertMineFailType2ErrorCode(int i) {
        return i != 0 ? i != 1 ? i != 6 ? GlobalErrorCode.ERROR_TOUCH_TOO_MUCH_MINE_OTHER : GlobalErrorCode.ERROR_TOUCH_TOO_MUCH_MINE_OCCLUSION : GlobalErrorCode.ERROR_TOUCH_TOO_MUCH_MINE_FACE : GlobalErrorCode.ERROR_TOUCH_TOO_MUCH_MINE_ACTION;
    }

    private void doDetectFailed(int i, Bundle bundle) {
        int value = ABDetectContext.getInstance().getCurrentPhase().getValue();
        ABDetectPhase aBDetectPhase = ABDetectPhase.FINISH;
        if (value < aBDetectPhase.getValue() && ABDetectContext.getInstance().getCurrentPhase() != ABDetectPhase.ACTION_END) {
            if (2 == i) {
                ABDetectContext.getInstance().stop();
                if (ABDetectContext.getInstance().getCurrentPhase().getValue() <= ABDetectPhase.ADJUST_END.getValue()) {
                    onDetectError(GlobalErrorCode.ERROR_ALGO_TIMEOUT_ADJUST, bundle);
                    return;
                } else {
                    onDetectError(GlobalErrorCode.ERROR_ALGO_TIMEOUT_ACTION, bundle);
                    return;
                }
            }
            int value2 = ABDetectContext.getInstance().getCurrentPhase().getValue();
            ABDetectPhase aBDetectPhase2 = ABDetectPhase.ACTION_BEGIN;
            if (value2 < aBDetectPhase2.getValue()) {
                ABDetectContext.getInstance().setBestFrame(null);
                return;
            }
            ABDetectContext.getInstance().getCurrentActionResult().setEc(bundle.getInt("ec", -1));
            ABDetectContext.getInstance().getCurrentActionResult().setEtcc(bundle.getInt("etcc", -1));
            ABDetectContext.getInstance().getCurrentActionResult().setEcpc(bundle.getInt("ecpc", -1));
            ABDetectContext.getInstance().getCurrentActionResult().setEcResult(bundle.getString("ecResult", ""));
            if (ABDetectContext.getInstance().getCurrentPhase().getValue() < aBDetectPhase2.getValue() || ABDetectContext.getInstance().getCurrentPhase().getValue() >= aBDetectPhase.getValue()) {
                return;
            }
            this.mDetectHelper.changeDetectType(handleMine(i, bundle), true, false);
        }
    }

    private void doDetectStart() {
        this.mABStateMachine.triggerEventListener(1);
        this.mABStateMachine.sendMessage(1);
    }

    private ABDetectType handleMine(int i, Bundle bundle) {
        ABDetectContext.getInstance().setLastDetectFailedType(i);
        ABDetectContext.getInstance().getCurrentActionResult().addMine(new MineInfo(i, System.currentTimeMillis()));
        ABDetectContext.getInstance().getCurrentActionResult().setEt(System.currentTimeMillis());
        onDetectError(convertMineFailType2ErrorCode(i));
        return ABDetectContext.getInstance().getCurrentAction();
    }

    public void collectLog(TrackLog trackLog) {
        if (this.mABService.getABEventListener() != null) {
            this.mABService.getABEventListener().onLogTrack(trackLog);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void onDetectError(int i) {
        onDetectError(i, new Bundle());
    }

    @Override // com.alibaba.security.biometrics.service.model.detector.DetectEventListener
    public void onDetectFailed(int i, Bundle bundle) {
        doDetectFailed(i, bundle);
    }

    @Override // com.alibaba.security.biometrics.service.model.detector.DetectEventListener
    public ABDetectType onDetectSuccess(ABFaceFrame aBFaceFrame, ABDetectType aBDetectType) {
        ABFrameDetector detector = this.mABStateMachine.getDetector();
        if (ABDetectContext.getInstance().getCurrentPhase().getValue() >= ABDetectPhase.FINISH.getValue()) {
            return ABDetectType.DONE;
        }
        int value = ABDetectContext.getInstance().getCurrentPhase().getValue();
        ABDetectPhase aBDetectPhase = ABDetectPhase.ACTION_BEGIN;
        if (value < aBDetectPhase.getValue()) {
            if (!this.mDetectHelper.saveQualityImage(detector)) {
                onDetectError(GlobalErrorCode.ERROR_DETECT_NOT_ENOUNGH_IMAGE);
                return ABDetectType.AIMLESS;
            }
            this.mDetectHelper.saveGlobalImage(detector);
            this.mDetectHelper.saveLocalImage(detector);
            this.mABStateMachine.sendMessage(3, aBFaceFrame);
            return ABDetectType.AIMLESS;
        } else if (aBDetectType == ABDetectType.KEEP_STILL) {
            return ABDetectType.AIMLESS;
        } else {
            if (ABDetectContext.getInstance().getCurrentPhase() != aBDetectPhase) {
                return ABDetectType.AIMLESS;
            }
            this.mABStateMachine.sendMessage(5, aBFaceFrame);
            if (!ABDetectContext.getInstance().isLastAction()) {
                return ABDetectType.AIMLESS;
            }
            return ABDetectType.DONE;
        }
    }

    @Override // com.alibaba.security.biometrics.service.model.detector.DetectEventListener
    public void onError(int i, Bundle bundle) {
        onDetectError(i, bundle);
    }

    @Override // com.alibaba.security.biometrics.service.model.detector.DetectEventListener
    public void onFrameDetected(long j, ABDetectFrame aBDetectFrame) {
        int value = ABDetectContext.getInstance().getCurrentPhase().getValue();
        ABDetectPhase aBDetectPhase = ABDetectPhase.FINISH;
        if (value >= aBDetectPhase.getValue()) {
            return;
        }
        if (this.mABParams.faceOnly) {
            this.mABStateMachine.sendMessage(99, aBDetectFrame);
            return;
        }
        ABDetectContext.getInstance().setFrameCount(ABDetectContext.getInstance().getFrameCount() + 1);
        if (aBDetectFrame != null && aBDetectFrame.facesDetected() > 0 && !ABDetectContext.getInstance().isEverFaceDetected()) {
            ABDetectContext.getInstance().setEverFaceDetected(true);
        }
        if (ABDetectContext.getInstance().getCurrentPhase() == ABDetectPhase.INIT) {
            doDetectStart();
        }
        this.mABStateMachine.triggerEventListener(11, aBDetectFrame);
        if (ABDetectContext.getInstance().getCurrentPhase() == ABDetectPhase.ADJUST_END && this.mABParams.actionCount > 0) {
            this.mABStateMachine.sendMessage(4, ABDetectContext.getInstance().offerAction());
        }
        if (this.mABStateMachine.isTimeOut()) {
            ABDetectContext.getInstance().stop();
            onDetectError(GlobalErrorCode.ERROR_BIO_TIMEOUT);
        }
        int checkFrame = this.mDetectHelper.checkFrame(aBDetectFrame);
        if (checkFrame == 0 || ABDetectContext.getInstance().getCurrentPhase().getValue() >= aBDetectPhase.getValue()) {
            return;
        }
        onDetectError(checkFrame);
    }

    @Override // com.alibaba.security.biometrics.service.model.detector.DetectEventListener
    public void onMessage(int i, Bundle bundle) {
        onDetectError(i, bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setParams(ALBiometricsParams aLBiometricsParams) {
        if (aLBiometricsParams != null) {
            this.mABParams = aLBiometricsParams;
        }
    }

    final void onDetectError(int i, Bundle bundle) {
        if (this.mDetectHelper.isAlertDialogError(i)) {
            this.mABService.stop();
            this.mABStateMachine.triggerDetectError(i, bundle);
        } else if (this.mDetectHelper.isTipError(i)) {
            this.mABStateMachine.triggerEventListener(12, new ParamBundleResult(i, bundle));
        }
    }
}
