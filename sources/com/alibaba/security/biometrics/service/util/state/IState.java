package com.alibaba.security.biometrics.service.util.state;

import android.os.Message;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public interface IState {
    public static final boolean HANDLED = true;
    public static final boolean NOT_HANDLED = false;

    void enter();

    void exit();

    String getName();

    boolean processMessage(Message message);
}
