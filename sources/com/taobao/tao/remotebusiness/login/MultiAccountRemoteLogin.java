package com.taobao.tao.remotebusiness.login;

import androidx.annotation.Nullable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class MultiAccountRemoteLogin implements IRemoteLogin {
    @Override // com.taobao.tao.remotebusiness.login.IRemoteLogin
    @Deprecated
    public LoginContext getLoginContext() {
        return getLoginContext(null);
    }

    public abstract LoginContext getLoginContext(@Nullable String str);

    @Override // com.taobao.tao.remotebusiness.login.IRemoteLogin
    @Deprecated
    public boolean isLogining() {
        return isLogining(null);
    }

    public abstract boolean isLogining(@Nullable String str);

    @Override // com.taobao.tao.remotebusiness.login.IRemoteLogin
    @Deprecated
    public boolean isSessionValid() {
        return isSessionValid(null);
    }

    public abstract boolean isSessionValid(@Nullable String str);

    @Override // com.taobao.tao.remotebusiness.login.IRemoteLogin
    @Deprecated
    public void login(onLoginListener onloginlistener, boolean z) {
        login(null, onloginlistener, z);
    }

    public abstract void login(@Nullable String str, onLoginListener onloginlistener, boolean z);
}
