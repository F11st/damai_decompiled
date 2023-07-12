package com.alibaba.security.biometrics.service.util.state;

import android.os.Message;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class State implements IState {
    @Override // com.alibaba.security.biometrics.service.util.state.IState
    public void enter() {
    }

    @Override // com.alibaba.security.biometrics.service.util.state.IState
    public void exit() {
    }

    @Override // com.alibaba.security.biometrics.service.util.state.IState
    public String getName() {
        String name = getClass().getName();
        return name.substring(name.lastIndexOf(36) + 1);
    }

    @Override // com.alibaba.security.biometrics.service.util.state.IState
    public boolean processMessage(Message message) {
        return false;
    }
}
