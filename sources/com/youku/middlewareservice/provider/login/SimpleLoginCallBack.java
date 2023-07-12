package com.youku.middlewareservice.provider.login;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class SimpleLoginCallBack extends LoginCallBack {
    @Override // com.youku.middlewareservice.provider.login.LoginCallBack, com.youku.middlewareservice.provider.login.ILoginCallBack
    public final void isInLoginState() {
        onFailed(LoginActionEnum.NOTIFY_IS_IN_LOGIN);
    }

    @Override // com.youku.middlewareservice.provider.login.LoginCallBack, com.youku.middlewareservice.provider.login.ILoginCallBack
    public final void onCancel() {
        onFailed(LoginActionEnum.NOTIFY_LOGIN_CANCEL);
    }

    @Override // com.youku.middlewareservice.provider.login.LoginCallBack, com.youku.middlewareservice.provider.login.ILoginCallBack
    public final void onFailed() {
        onFailed(LoginActionEnum.NOTIFY_LOGIN_FAILED);
    }

    public void onFailed(LoginActionEnum loginActionEnum) {
    }

    @Override // com.youku.middlewareservice.provider.login.LoginCallBack, com.youku.middlewareservice.provider.login.ILoginCallBack
    public final void onLogout() {
        onFailed(LoginActionEnum.NOTIFY_LOGOUT);
    }

    @Override // com.youku.middlewareservice.provider.login.LoginCallBack, com.youku.middlewareservice.provider.login.ILoginCallBack
    public void onSuccess() {
    }
}
