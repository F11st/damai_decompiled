package com.alibaba.security.biometrics.service.state;

import android.os.Bundle;
import android.os.Message;
import com.alibaba.security.biometrics.service.common.ABLogRecorder;
import com.alibaba.security.biometrics.service.common.ABLogRecorderKeys;
import com.alibaba.security.biometrics.service.model.ABDetectContext;
import com.alibaba.security.biometrics.service.model.ABDetectPhase;
import com.alibaba.security.biometrics.service.model.detector.ABDetectType;
import com.alibaba.security.biometrics.service.model.listener.ParamActionResult;
import com.alibaba.security.biometrics.service.model.result.ABActionResult;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ActionDetectBeginState extends BaseState {
    public ActionDetectBeginState(ABStateMachine aBStateMachine) {
        super(aBStateMachine);
    }

    private void doActionStart(ABDetectType aBDetectType) {
        ABDetectContext.getInstance().setCurrentPhase(ABDetectPhase.ACTION_BEGIN);
        Bundle bundle = new Bundle();
        bundle.putInt("act_type", aBDetectType.getValue());
        bundle.putInt("act_idx", ABDetectContext.getInstance().getCurrentActionIndex() + 1);
        ABLogRecorder.i().record(ABLogRecorderKeys.EventIdEnterAct, bundle);
        ABDetectContext.getInstance().setFrameCount(0);
        ABDetectContext.getInstance().setCurrentActionResult(new ABActionResult());
        ABDetectContext.getInstance().getCurrentActionResult().setBt(System.currentTimeMillis());
        ABDetectContext.getInstance().getCurrentActionResult().setAt(aBDetectType.getValue());
        ABDetectContext.getInstance().getResult().addActionResult(ABDetectContext.getInstance().getCurrentActionResult());
        this.mABStateMachine.triggerEventListener(5, new ParamActionResult(aBDetectType, ABDetectContext.getInstance().getCurrentActionIndex(), ABDetectContext.getInstance().getActionCount()));
        this.mABStateMachine.changeDetectType(aBDetectType, true, true);
    }

    @Override // com.alibaba.security.biometrics.service.state.BaseState
    protected String currentState() {
        return "ActionDetectBeginState";
    }

    @Override // com.alibaba.security.biometrics.service.state.BaseState, com.alibaba.security.biometrics.service.util.state.State, com.alibaba.security.biometrics.service.util.state.IState
    public void enter() {
        super.enter();
        if (ABDetectContext.getInstance().getCurrentPhase() != ABDetectPhase.ACTION_END) {
            ABDetectContext.getInstance().getResult().getAs().clear();
        }
    }

    @Override // com.alibaba.security.biometrics.service.util.state.State, com.alibaba.security.biometrics.service.util.state.IState
    public boolean processMessage(Message message) {
        if (message.what != 4) {
            return false;
        }
        Object obj = message.obj;
        if (obj != null) {
            doActionStart((ABDetectType) obj);
            return true;
        }
        return true;
    }
}
