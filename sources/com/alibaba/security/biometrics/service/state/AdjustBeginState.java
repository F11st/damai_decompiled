package com.alibaba.security.biometrics.service.state;

import android.os.Bundle;
import android.os.Message;
import com.alibaba.security.biometrics.service.common.ABLogRecorder;
import com.alibaba.security.biometrics.service.common.ABLogRecorderKeys;
import com.alibaba.security.biometrics.service.model.ABDetectContext;
import com.alibaba.security.biometrics.service.model.ABDetectPhase;
import com.alibaba.security.biometrics.service.model.detector.ABDetectType;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class AdjustBeginState extends BaseState {
    public AdjustBeginState(ABStateMachine aBStateMachine) {
        super(aBStateMachine);
    }

    private void doAdjustStart() {
        ABDetectContext.getInstance().setCurrentPhase(ABDetectPhase.ADJUST_BEGIN);
        Bundle bundle = new Bundle();
        bundle.putInt("aju_c", ABDetectContext.getInstance().getRetryTimes() + 1);
        ABLogRecorder.i().record(ABLogRecorderKeys.EventIdEnterAdjust, bundle);
        this.mABStateMachine.changeDetectType(ABDetectType.KEEP_STILL, false, false);
        this.mABStateMachine.triggerEventListener(3);
    }

    @Override // com.alibaba.security.biometrics.service.state.BaseState
    protected String currentState() {
        return "AdjustBeginState";
    }

    @Override // com.alibaba.security.biometrics.service.state.BaseState, com.alibaba.security.biometrics.service.util.state.State, com.alibaba.security.biometrics.service.util.state.IState
    public void enter() {
        super.enter();
    }

    @Override // com.alibaba.security.biometrics.service.util.state.State, com.alibaba.security.biometrics.service.util.state.IState
    public boolean processMessage(Message message) {
        if (message.what != 2) {
            return false;
        }
        doAdjustStart();
        return true;
    }
}
