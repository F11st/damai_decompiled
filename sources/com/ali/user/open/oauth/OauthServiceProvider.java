package com.ali.user.open.oauth;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public interface OauthServiceProvider {
    void cleanUp();

    boolean isAppAuthSurpport(Context context);

    boolean isLoginUrl(String str);

    void logout(Context context, String str);

    void oauth(Activity activity, String str, AppCredential appCredential, Map<String, String> map, OauthCallback oauthCallback);

    void onActivityResult(int i, int i2, Intent intent);

    void refreshWhenLogin(String str, boolean z);

    void tokenLogin(String str, String str2, String str3, Map<String, String> map, OauthCallback oauthCallback);
}
