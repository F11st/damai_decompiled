package com.alibaba.security.biometrics.service.state;

import android.os.Message;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class DefaultState extends BaseState {
    public DefaultState(ABStateMachine aBStateMachine) {
        super(aBStateMachine);
    }

    @Override // com.alibaba.security.biometrics.service.state.BaseState
    protected String currentState() {
        return "DefaultState";
    }

    @Override // com.alibaba.security.biometrics.service.util.state.State, com.alibaba.security.biometrics.service.util.state.IState
    public boolean processMessage(Message message) {
        return true;
    }
}
