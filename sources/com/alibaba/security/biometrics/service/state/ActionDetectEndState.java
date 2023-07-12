package com.alibaba.security.biometrics.service.state;

import android.os.Bundle;
import android.os.Message;
import com.alibaba.security.biometrics.service.common.ABLogRecorder;
import com.alibaba.security.biometrics.service.common.ABLogRecorderKeys;
import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.alibaba.security.biometrics.service.model.ABDetectContext;
import com.alibaba.security.biometrics.service.model.ABDetectPhase;
import com.alibaba.security.biometrics.service.model.detector.ABDetectType;
import com.alibaba.security.biometrics.service.model.detector.ABFaceFrame;
import com.alibaba.security.biometrics.service.model.listener.ParamActionResult;
import com.alibaba.security.biometrics.service.model.result.ABActionResult;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ActionDetectEndState extends BaseState {
    public ActionDetectEndState(ABStateMachine aBStateMachine) {
        super(aBStateMachine);
    }

    private void continueDetectAction() {
        final ABDetectType currentAction = ABDetectContext.getInstance().getCurrentAction();
        if (currentAction == ABDetectType.DONE) {
            if (this.mABStateMachine.hasQualityFrame()) {
                this.mABStateMachine.sendMessage(StateKeys.CMD_DETECT_SUCCESS);
            } else {
                this.mDetectListener.onDetectError(GlobalErrorCode.ERROR_DETECT_NOT_ENOUNGH_IMAGE);
            }
        }
        this.mABStateMachine.getMainHandler().postDelayed(new Runnable() { // from class: com.alibaba.security.biometrics.service.state.ActionDetectEndState.1
            @Override // java.lang.Runnable
            public void run() {
                if (currentAction == ABDetectType.DONE || !ABDetectContext.getInstance().isRunning()) {
                    return;
                }
                ActionDetectEndState.this.mABStateMachine.sendMessage(4, currentAction);
            }
        }, 100L);
    }

    private void doActionEnd(ABFaceFrame aBFaceFrame) {
        if (ABDetectContext.getInstance().getCurrentPhase() != ABDetectPhase.ACTION_BEGIN) {
            return;
        }
        ABDetectContext.getInstance().setCurrentPhase(ABDetectPhase.ACTION_END);
        ABDetectContext.getInstance().getCurrentActionResult().setEt(System.currentTimeMillis());
        ABDetectContext.getInstance().getCurrentActionResult().setEc(aBFaceFrame.getDetectInfo().getEc());
        ABDetectContext.getInstance().getCurrentActionResult().setEtcc(aBFaceFrame.getDetectInfo().getEtcc());
        ABDetectContext.getInstance().getCurrentActionResult().setEcpc(aBFaceFrame.getDetectInfo().getEcpc());
        ABDetectContext.getInstance().getCurrentActionResult().setEcResult(aBFaceFrame.getDetectInfo().getEcResult());
        if (ABDetectContext.getInstance().getBestFrame() == null || this.mDetector.getCurrentDetectType() == ABDetectType.BLINK || this.mDetector.getCurrentDetectType() == ABDetectType.MOUTH || this.mDetector.getCurrentDetectType() == ABDetectType.BLINK_STILL || this.mDetector.getCurrentDetectType() == ABDetectType.MOUTH_STILL) {
            if (!this.mABStateMachine.saveQualityImage()) {
                this.mDetectListener.onDetectError(GlobalErrorCode.ERROR_DETECT_NOT_ENOUNGH_IMAGE);
                return;
            }
            this.mABStateMachine.saveGlobalImage();
            this.mABStateMachine.saveLocalImage();
            ABDetectContext.getInstance().setBestFrame(aBFaceFrame);
            this.mABStateMachine.saveFrameInfoToImageResult(aBFaceFrame, ABDetectContext.getInstance().getResult().getQi());
        }
        if (aBFaceFrame.getDetectInfo() != null) {
            ABDetectContext.getInstance().getCurrentActionResult().setTd(aBFaceFrame.getDetectInfo().isPitch3d() ? 1 : 0);
        }
        this.mABStateMachine.triggerEventListener(6, new ParamActionResult(ABDetectContext.getInstance().getCurrentAction(), ABDetectContext.getInstance().getCurrentActionIndex(), ABDetectContext.getInstance().getActionCount()));
        ABActionResult currentActionResult = ABDetectContext.getInstance().getCurrentActionResult();
        Bundle bundle = new Bundle();
        bundle.putInt("result", 1);
        bundle.putInt("act_idx", ABDetectContext.getInstance().getCurrentActionStep());
        bundle.putInt("act_type", ABDetectContext.getInstance().getCurrentAction().getValue());
        bundle.putInt("frm_c", ABDetectContext.getInstance().getFrameCount());
        bundle.putFloat("bri", aBFaceFrame.getDetectInfo().getBrightness());
        bundle.putFloat("gblur", aBFaceFrame.getDetectInfo().getGaussianBlur());
        bundle.putFloat("mblur", aBFaceFrame.getDetectInfo().getMotionBlur());
        bundle.putFloat("qua", aBFaceFrame.getDetectInfo().getFaceQuality());
        ABLogRecorder.i().record(ABLogRecorderKeys.EventIdActSucc, bundle);
        this.mABStateMachine.saveActionImages(currentActionResult);
        ABDetectContext.getInstance().offerAction();
        continueDetectAction();
    }

    @Override // com.alibaba.security.biometrics.service.state.BaseState
    protected String currentState() {
        return "ActionDetectEndState";
    }

    @Override // com.alibaba.security.biometrics.service.util.state.State, com.alibaba.security.biometrics.service.util.state.IState
    public boolean processMessage(Message message) {
        if (message.what != 5) {
            return false;
        }
        doActionEnd((ABFaceFrame) message.obj);
        return true;
    }
}
