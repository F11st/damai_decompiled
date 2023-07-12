package com.alibaba.security.biometrics.service.state;

import android.os.Message;
import com.alibaba.security.biometrics.jni.ALBiometricsJni;
import com.alibaba.security.biometrics.service.model.ABDetectContext;
import com.alibaba.security.biometrics.service.model.ABDetectPhase;
import com.alibaba.security.biometrics.service.model.ALBiometricsType;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import com.alibaba.security.common.d.h;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class InitialState extends BaseState {
    public InitialState(ABStateMachine aBStateMachine) {
        super(aBStateMachine);
    }

    @Override // com.alibaba.security.biometrics.service.state.BaseState
    protected String currentState() {
        return "InitialState";
    }

    @Override // com.alibaba.security.biometrics.service.state.BaseState, com.alibaba.security.biometrics.service.util.state.State, com.alibaba.security.biometrics.service.util.state.IState
    public void enter() {
        super.enter();
        ABDetectContext.getInstance().setCurrentPhase(ABDetectPhase.INIT);
        HashMap hashMap = new HashMap();
        hashMap.put("detectType", ALBiometricsType.isDazzle(this.mABParams.mBiometricsType) ? "colorful" : "action");
        hashMap.put("actionType", h.a(ABDetectContext.getInstance().getActions()));
        hashMap.put("maxRetryTimes", Integer.valueOf(this.mABParams.retryThreshold + 1));
        ALBiometricsJni.bhL(9, h.a((Object) hashMap));
    }

    @Override // com.alibaba.security.biometrics.service.util.state.State, com.alibaba.security.biometrics.service.util.state.IState
    public boolean processMessage(Message message) {
        int i = message.what;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    deferMessage(message);
                    transitionTo(this.mABStateMachine.getAdjustBeginState());
                } else if (i == 3) {
                    deferMessage(message);
                    transitionTo(this.mABStateMachine.getAdjustEndState());
                } else if (i == 4) {
                    deferMessage(message);
                    transitionTo(this.mABStateMachine.getActionDetectBeginState());
                } else if (i == 5) {
                    deferMessage(message);
                    transitionTo(this.mABStateMachine.getActionDetectEndState());
                } else if (i == 99) {
                    deferMessage(message);
                    transitionTo(this.mABStateMachine.getFaceDetectState());
                } else if (i == 100 || i == 887) {
                    deferMessage(message);
                    transitionTo(this.mABStateMachine.getFinishState());
                } else if (i == 998) {
                    transitionTo(this.mABStateMachine.getFinishState());
                } else if (i != 999) {
                    return false;
                } else {
                    Object obj = message.obj;
                    if (obj != null) {
                        setParams((ALBiometricsParams) obj);
                    }
                }
            } else if (this.mABParams.stepAdjust) {
                this.mABStateMachine.sendMessage(2);
            } else {
                this.mABStateMachine.sendMessage(4, ABDetectContext.getInstance().offerAction());
            }
        }
        return true;
    }
}
