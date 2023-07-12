package com.ali.user.open.tbauth;

import android.content.Context;
import com.ali.user.open.callback.LoginCallback;
import com.ali.user.open.core.WebViewProxy;
import com.ali.user.open.core.callback.MemberCallback;
import com.ali.user.open.session.Session;
import com.ali.user.open.tbauth.callback.LogoutCallback;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public interface TbAuthService {
    void auth(LoginCallback loginCallback);

    void auth(Map<String, String> map, LoginCallback loginCallback);

    void autoLogin(LoginCallback loginCallback);

    boolean checkSessionValid();

    Session getSession();

    boolean isAppAuthSurpport(Context context);

    boolean isLoginUrl(String str);

    boolean isLogoutUrl(String str);

    void logout(LogoutCallback logoutCallback);

    void refreshCookie(MemberCallback memberCallback);

    void setLoginCallback(LoginCallback loginCallback);

    void setWebViewProxy(WebViewProxy webViewProxy);

    void tokenLogin(int i, String str, String str2, String str3, LoginCallback loginCallback);
}
