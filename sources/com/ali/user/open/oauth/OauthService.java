package com.ali.user.open.oauth;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public interface OauthService {
    void cleanUp();

    boolean isAppAuthSurpport(Context context, String str);

    boolean isLoginUrl(String str, String str2);

    void logout(Context context, String str);

    List<String> logoutAll(Context context);

    void oauth(Activity activity, String str, OauthCallback oauthCallback);

    void oauth(Activity activity, String str, Map<String, String> map, OauthCallback oauthCallback);

    void onActivityResult(String str, int i, int i2, Intent intent);

    void refreshWhenLogin(String str, String str2, boolean z);

    void tokenLogin(String str, String str2, String str3, String str4, Map<String, String> map, OauthCallback oauthCallback);
}
