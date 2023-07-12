package com.ali.user.open.oauth.eleme;

import android.app.Activity;
import android.content.Context;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.Site;
import com.ali.user.open.core.model.LoginReturnData;
import com.ali.user.open.oauth.AppCredential;
import com.ali.user.open.oauth.OauthCallback;
import com.ali.user.open.oauth.base.BaseOauthServiceProviderImpl;
import com.ali.user.open.service.SessionService;
import com.alibaba.fastjson.JSON;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class ElemeOauthServiceProviderImpl extends BaseOauthServiceProviderImpl {
    public static final String TAG = "oa.AlipayOauthServiceProviderImpl";

    @Override // com.ali.user.open.oauth.OauthServiceProvider
    public boolean isLoginUrl(String str) {
        return false;
    }

    @Override // com.ali.user.open.oauth.OauthServiceProvider
    public void logout(Context context, String str) {
        ((SessionService) AliMemberSDK.getService(SessionService.class)).logout(Site.ELEME);
    }

    @Override // com.ali.user.open.oauth.OauthServiceProvider
    public void oauth(Activity activity, String str, AppCredential appCredential, Map<String, String> map, OauthCallback oauthCallback) {
    }

    @Override // com.ali.user.open.oauth.base.BaseOauthServiceProviderImpl, com.ali.user.open.oauth.OauthServiceProvider
    public void refreshWhenLogin(String str, boolean z) {
        ((SessionService) AliMemberSDK.getService(SessionService.class)).refreshWhenLogin(Site.ELEME, (LoginReturnData) JSON.parseObject(str, LoginReturnData.class));
    }
}
