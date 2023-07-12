package com.alibaba.security.biometrics.service.state;

import android.os.Message;
import com.alibaba.security.biometrics.service.ALBiometricsService;
import com.alibaba.security.biometrics.service.model.detector.ABDetector;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import com.alibaba.security.biometrics.service.util.state.IState;
import com.alibaba.security.biometrics.service.util.state.State;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes8.dex */
public abstract class BaseState extends State implements StateKeys {
    protected static final String TAG = "StateMachine";
    protected ALBiometricsParams mABParams;
    protected ALBiometricsService mABService;
    protected ABStateMachine mABStateMachine;
    protected ABDetectListener mDetectListener;
    protected ABDetector mDetector;

    public BaseState(ABStateMachine aBStateMachine) {
        this.mABStateMachine = aBStateMachine;
        ALBiometricsService aLBiometricsService = aBStateMachine.getALBiometricsService();
        this.mABService = aLBiometricsService;
        this.mABParams = aLBiometricsService.getParams();
        this.mDetector = this.mABStateMachine.getDetector();
        this.mDetectListener = this.mABStateMachine.getDetectListener();
    }

    protected abstract String currentState();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void deferMessage(Message message) {
        this.mABStateMachine.deferMsg(message);
    }

    @Override // com.alibaba.security.biometrics.service.util.state.State, com.alibaba.security.biometrics.service.util.state.IState
    public void enter() {
        super.enter();
    }

    @Override // com.alibaba.security.biometrics.service.util.state.State, com.alibaba.security.biometrics.service.util.state.IState
    public void exit() {
        super.exit();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setParams(ALBiometricsParams aLBiometricsParams) {
        if (aLBiometricsParams != null) {
            this.mABParams = aLBiometricsParams;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void transitionTo(IState iState) {
        this.mABStateMachine.transitionState(iState);
    }
}
