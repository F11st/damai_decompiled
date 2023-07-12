package com.youku.usercenter.passport;

import android.net.Uri;
import android.webkit.WebView;
import com.youku.passport.result.AbsResult;
import com.youku.usercenter.passport.remote.ICallback;
import com.youku.usercenter.passport.result.Result;
import com.youku.usercenter.passport.result.UserInfo;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface IPassport {
    public static final String ACTION_COOKIE_REFRESHED = "passport_cookie_refreshed";
    public static final String ACTION_EXPIRE_LOGOUT = "passport_expire_logout";
    public static final String ACTION_LOGIN_CANCEL = "passport_login_cancel";
    public static final String ACTION_LOGIN_START = "passport_login_start";
    public static final String ACTION_NICKNAME_MODIFIED_SUCCESS = "passport_nickname_modified_successed";
    public static final String ACTION_TOKEN_REFRESHED = "passport_token_refreshed";
    public static final String ACTION_USER_LOGIN = "passport_user_login";
    public static final String ACTION_USER_LOOUT = "passport_user_logout";
    public static final String EXTRA_COOKIE = "passport_cookie";
    public static final String EXTRA_STOKEN = "passport_stoken";
    public static final String EXTRA_YTID = "passport_ytid";

    PassportConfig getConfig();

    @Deprecated
    String getCookie();

    String getLastLoginType();

    String getSToken();

    UserInfo getUserInfo();

    String getYktk();

    void h5ToNativeLogin(ICallback iCallback);

    boolean handleCookieError(int i, long j);

    boolean handleSchema(Uri uri);

    void init(PassportConfig passportConfig);

    void init(PassportConfig passportConfig, com.youku.usercenter.passport.callback.ICallback<Result> iCallback);

    boolean isBoundMobile();

    boolean isFingerprintAuthEnabled();

    boolean isLogin();

    boolean isLogining();

    void logout();

    void logout(String str);

    void refreshSToken();

    boolean shouldOverrideUrlLoading(WebView webView, String str);

    void uccTrustLogin(String str, Map map, com.youku.usercenter.passport.callback.ICallback<AbsResult> iCallback);
}
