package cn.damai.common.badge.update;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public interface BadgeLoginMonitor {

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public interface LoginCallback {
        void onLoginSuccess();

        void onLogoutSuccess();
    }

    void setLoginCallback(LoginCallback loginCallback);

    void startLoginMonitor();

    void stopLoginMonitor();
}
