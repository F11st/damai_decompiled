package com.alibaba.security.biometrics.service.state;

import android.os.Bundle;
import android.os.Message;
import com.alibaba.security.biometrics.service.common.ABLogRecorder;
import com.alibaba.security.biometrics.service.common.ABLogRecorderKeys;
import com.alibaba.security.biometrics.service.model.ABDetectContext;
import com.alibaba.security.biometrics.service.model.ABDetectPhase;
import com.alibaba.security.biometrics.service.model.detector.ABFaceFrame;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class AdjustEndState extends BaseState {
    public AdjustEndState(ABStateMachine aBStateMachine) {
        super(aBStateMachine);
    }

    private void doAdjustEnd(ABFaceFrame aBFaceFrame) {
        if (ABDetectContext.getInstance().getCurrentPhase() != ABDetectPhase.ADJUST_BEGIN) {
            return;
        }
        ABDetectContext.getInstance().setCurrentPhase(ABDetectPhase.ADJUST_END);
        ABDetectContext.getInstance().setBestFrame(aBFaceFrame);
        this.mABStateMachine.saveFrameInfoToImageResult(aBFaceFrame, ABDetectContext.getInstance().getResult().getQi());
        ABDetectContext.getInstance().getResult().getAdjustAction().setEc(aBFaceFrame.getDetectInfo().getEc());
        ABDetectContext.getInstance().getResult().getAdjustAction().setEtcc(aBFaceFrame.getDetectInfo().getEtcc());
        ABDetectContext.getInstance().getResult().getAdjustAction().setEcpc(aBFaceFrame.getDetectInfo().getEcpc());
        ABDetectContext.getInstance().getResult().getAdjustAction().setEcResult(aBFaceFrame.getDetectInfo().getEcResult());
        this.mABStateMachine.triggerEventListener(4);
        Bundle bundle = new Bundle();
        bundle.putInt("result", 1);
        bundle.putInt("frm_c", ABDetectContext.getInstance().getFrameCount());
        ABLogRecorder.i().record(ABLogRecorderKeys.EventIdLeaveAdjust, bundle);
        if (this.mABParams.actionCount == 0) {
            this.mABStateMachine.sendMessage(StateKeys.CMD_DETECT_SUCCESS);
        }
        ALBiometricsParams aLBiometricsParams = this.mABParams;
        if (aLBiometricsParams.actionCount == 0 && aLBiometricsParams.needDisplayWaitingView && aLBiometricsParams.imageCount > 1) {
            ABDetectContext.getInstance().setQualityImageTime(System.currentTimeMillis());
            ABDetectContext.getInstance().setQualityImageCount(1);
            ABDetectContext.getInstance().setNeedContinueImage(true);
        }
    }

    @Override // com.alibaba.security.biometrics.service.state.BaseState
    protected String currentState() {
        return "AdjustEndState";
    }

    @Override // com.alibaba.security.biometrics.service.util.state.State, com.alibaba.security.biometrics.service.util.state.IState
    public boolean processMessage(Message message) {
        if (message.what != 3) {
            return false;
        }
        doAdjustEnd((ABFaceFrame) message.obj);
        return true;
    }
}
