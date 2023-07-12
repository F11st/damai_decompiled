package cn.damai.login.api;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public interface IPassportListener {
    void onCookieRefreshed(String str);

    void onExpireLogout();

    void onLoginCancel();

    void onTokenRefreshed(String str);

    void onUserLogin();

    void onUserLogout();
}
