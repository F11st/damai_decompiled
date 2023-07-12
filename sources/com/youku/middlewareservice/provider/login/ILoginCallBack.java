package com.youku.middlewareservice.provider.login;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public interface ILoginCallBack {
    void isInLoginState();

    void onCancel();

    void onFailed();

    void onLogout();

    void onSuccess();
}
