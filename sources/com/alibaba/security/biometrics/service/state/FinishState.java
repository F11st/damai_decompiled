package com.alibaba.security.biometrics.service.state;

import android.os.Bundle;
import android.os.Message;
import com.alibaba.security.biometrics.service.common.ABLogRecorder;
import com.alibaba.security.biometrics.service.common.ABLogRecorderKeys;
import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.alibaba.security.biometrics.service.detector.ABFaceRecapDetector;
import com.alibaba.security.biometrics.service.model.ABDetectContext;
import com.alibaba.security.biometrics.service.model.ABDetectPhase;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class FinishState extends BaseState {
    public FinishState(ABStateMachine aBStateMachine) {
        super(aBStateMachine);
    }

    private void detectSuccess() {
        doDetectSuccess();
    }

    private void doDetectSuccess() {
        ABDetectContext.getInstance().getResult().setEt(System.currentTimeMillis());
        Bundle bundle = new Bundle();
        bundle.putLong("img1_ts", ABDetectContext.getInstance().getResult().getQi().getT());
        bundle.putInt("result", 1);
        bundle.putFloat("bri", ABDetectContext.getInstance().getResult().getQi().getB());
        bundle.putFloat("mblur", ABDetectContext.getInstance().getResult().getQi().getMb());
        bundle.putFloat("gblur", ABDetectContext.getInstance().getResult().getQi().getGb());
        bundle.putFloat("qua", ABDetectContext.getInstance().getResult().getQi().getQ());
        if (ABDetectContext.getInstance().getResult() != null && ABDetectContext.getInstance().getResult().getAs() != null && ABDetectContext.getInstance().getResult().getAs().size() > 0 && ABDetectContext.getInstance().getResult().getAs().get(0).getIs() != null && ABDetectContext.getInstance().getResult().getAs().get(0).getIs().size() > 0) {
            bundle.putLong("img2_ts", ABDetectContext.getInstance().getResult().getAs().get(0).getIs().get(0).getT());
        }
        if (ABDetectContext.getInstance().getResult() != null && ABDetectContext.getInstance().getResult().getAs() != null && ABDetectContext.getInstance().getResult().getAs().size() > 0 && ABDetectContext.getInstance().getResult().getAs().get(0).getIs() != null && ABDetectContext.getInstance().getResult().getAs().get(0).getIs().size() > 1) {
            bundle.putLong("img3_ts", ABDetectContext.getInstance().getResult().getAs().get(0).getIs().get(1).getT());
        }
        if (ABDetectContext.getInstance().getResult() != null && ABDetectContext.getInstance().getResult().getAs() != null && ABDetectContext.getInstance().getResult().getAs().size() > 1 && ABDetectContext.getInstance().getResult().getAs().get(1).getIs() != null && ABDetectContext.getInstance().getResult().getAs().get(1).getIs().size() > 0) {
            bundle.putLong("img4_ts", ABDetectContext.getInstance().getResult().getAs().get(1).getIs().get(0).getT());
        }
        if (ABDetectContext.getInstance().getResult() != null && ABDetectContext.getInstance().getResult().getAs() != null && ABDetectContext.getInstance().getResult().getAs().size() > 1 && ABDetectContext.getInstance().getResult().getAs().get(1).getIs() != null && ABDetectContext.getInstance().getResult().getAs().get(1).getIs().size() > 1) {
            bundle.putLong("img5_ts", ABDetectContext.getInstance().getResult().getAs().get(1).getIs().get(1).getT());
        }
        bundle.putInt("retry_tt", ABDetectContext.getInstance().getRetryTimes());
        bundle.putString(ABLogRecorderKeys.FieldBgDetect, ABDetectContext.getInstance().getResult().getBgDetectResult());
        ABLogRecorder.i().record(ABLogRecorderKeys.EventIdLivenessSucc, bundle);
        if (this.mABParams.recapEnable) {
            ABFaceRecapDetector.getInstance().getRecapResult(new ABFaceRecapDetector.OnEventListener() { // from class: com.alibaba.security.biometrics.service.state.FinishState.1
                @Override // com.alibaba.security.biometrics.service.detector.ABFaceRecapDetector.OnEventListener
                public void onResult(int i, float[] fArr, String str) {
                    boolean z;
                    int i2;
                    ABDetectContext.getInstance().getResult().setRecapResult(i);
                    ABDetectContext.getInstance().getResult().setRecapScore(fArr);
                    ABDetectContext.getInstance().getResult().setRecapLog(str);
                    ABDetectContext.getInstance().getResult().setRecapFrames(ABFaceRecapDetector.getInstance().getFrameCount());
                    if (ABFaceRecapDetector.getInstance().getFrameCount() > 0) {
                        ABDetectContext.getInstance().getResult().setRecapAvgTime((int) (ABFaceRecapDetector.getInstance().getDetectTotalTime() / ABFaceRecapDetector.getInstance().getFrameCount()));
                    }
                    FinishState finishState = FinishState.this;
                    ALBiometricsParams aLBiometricsParams = finishState.mABParams;
                    if (aLBiometricsParams.recapEnable) {
                        float f = aLBiometricsParams.recapThreshold;
                        if (f > 0.0f && fArr != null && fArr.length > 0 && fArr[0] > f) {
                            z = true;
                            i2 = aLBiometricsParams.actionWhileCheckFail;
                            if (i2 < 0 && z) {
                                ALBiometricsParams params = finishState.mABService.getParams();
                                params.actionCount = i2;
                                FinishState finishState2 = FinishState.this;
                                params.strategy = finishState2.mABParams.strategyWhileCheckFail;
                                params.recapEnable = false;
                                params.actionWhileCheckFail = -1;
                                if (i2 > 0) {
                                    params.stepAdjust = false;
                                }
                                finishState2.mABStateMachine.initStrategy();
                                FinishState.this.mABStateMachine.startDetect();
                                return;
                            } else if (aLBiometricsParams.recapMode != 0 && z) {
                                finishState.mDetectListener.onDetectError(GlobalErrorCode.ERROR_ALGO_RECAP_FAIL);
                                return;
                            } else {
                                finishState.mABStateMachine.triggerDetectSuccess();
                            }
                        }
                    }
                    z = false;
                    i2 = aLBiometricsParams.actionWhileCheckFail;
                    if (i2 < 0) {
                    }
                    if (aLBiometricsParams.recapMode != 0) {
                    }
                    finishState.mABStateMachine.triggerDetectSuccess();
                }
            });
        } else {
            this.mABStateMachine.triggerDetectSuccess();
        }
    }

    @Override // com.alibaba.security.biometrics.service.state.BaseState
    protected String currentState() {
        return "FinishState";
    }

    @Override // com.alibaba.security.biometrics.service.state.BaseState, com.alibaba.security.biometrics.service.util.state.State, com.alibaba.security.biometrics.service.util.state.IState
    public void enter() {
        super.enter();
        ABDetectContext.getInstance().setCurrentPhase(ABDetectPhase.FINISH);
    }

    @Override // com.alibaba.security.biometrics.service.util.state.State, com.alibaba.security.biometrics.service.util.state.IState
    public boolean processMessage(Message message) {
        int i = message.what;
        if (i != 887) {
            return i == 998;
        }
        detectSuccess();
        return true;
    }
}
