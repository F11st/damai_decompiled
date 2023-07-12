package com.taobao.tao.remotebusiness.login;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface IRemoteLogin {
    LoginContext getLoginContext();

    boolean isLogining();

    boolean isSessionValid();

    void login(onLoginListener onloginlistener, boolean z);
}
