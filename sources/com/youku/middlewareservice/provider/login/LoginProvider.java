package com.youku.middlewareservice.provider.login;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public interface LoginProvider {
    void clearSession();

    String getAvatarUrl();

    String getEcode();

    String getEncryptedYtId();

    String getNick();

    String getSid();

    String getUserId();

    String getYid();

    String getYoukuUid();

    void goLogin(Context context);

    void goLogin(Context context, int i);

    void goLogin(Context context, String str);

    void goLoginForResult(Activity activity, int i);

    void goLoginForResult(Activity activity, int i, String str);

    void goUserProfilePage(Activity activity, String str);

    LoginProvider init(Application application, LoginConfig loginConfig);

    boolean isLogin();

    boolean isVip();

    void logout();

    void release();
}
