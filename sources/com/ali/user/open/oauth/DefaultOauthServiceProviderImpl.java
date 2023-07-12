package com.ali.user.open.oauth;

import android.app.Activity;
import android.content.Context;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.oauth.base.BaseOauthServiceProviderImpl;
import com.ali.user.open.service.SessionService;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class DefaultOauthServiceProviderImpl extends BaseOauthServiceProviderImpl {
    @Override // com.ali.user.open.oauth.OauthServiceProvider
    public boolean isLoginUrl(String str) {
        return false;
    }

    @Override // com.ali.user.open.oauth.OauthServiceProvider
    public void logout(Context context, String str) {
        ((SessionService) AliMemberSDK.getService(SessionService.class)).logout(str);
    }

    @Override // com.ali.user.open.oauth.OauthServiceProvider
    public void oauth(Activity activity, String str, AppCredential appCredential, Map<String, String> map, OauthCallback oauthCallback) {
    }
}
