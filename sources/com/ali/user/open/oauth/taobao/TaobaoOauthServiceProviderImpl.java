package com.ali.user.open.oauth.taobao;

import android.app.Activity;
import android.content.Context;
import com.ali.user.open.callback.LoginCallback;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.Site;
import com.ali.user.open.core.model.LoginReturnData;
import com.ali.user.open.oauth.AppCredential;
import com.ali.user.open.oauth.OauthCallback;
import com.ali.user.open.oauth.base.BaseOauthServiceProviderImpl;
import com.ali.user.open.service.SessionService;
import com.ali.user.open.service.impl.SessionManager;
import com.ali.user.open.session.Session;
import com.ali.user.open.tbauth.TbAuthService;
import com.alibaba.fastjson.JSON;
import java.util.HashMap;
import java.util.Map;
import mtopsdk.security.util.SignConstants;
import mtopsdk.xstate.util.XStateConstants;

/* loaded from: classes9.dex */
public class TaobaoOauthServiceProviderImpl extends BaseOauthServiceProviderImpl {
    public static final String TAG = "oa.AlipayOauthServiceProviderImpl";

    private void authTask(Activity activity, final String str, AppCredential appCredential, Map<String, String> map, final OauthCallback oauthCallback) {
        ((TbAuthService) AliMemberSDK.getService(TbAuthService.class)).auth(map, new LoginCallback() { // from class: com.ali.user.open.oauth.taobao.TaobaoOauthServiceProviderImpl.1
            @Override // com.ali.user.open.core.callback.FailureCallback
            public void onFailure(int i, String str2) {
                oauthCallback.onFail(str, i, str2);
            }

            @Override // com.ali.user.open.callback.LoginCallback
            public void onSuccess(Session session) {
                HashMap hashMap = new HashMap();
                hashMap.put("openId", session.openId);
                hashMap.put(XStateConstants.KEY_ACCESS_TOKEN, session.topAccessToken);
                hashMap.put(SignConstants.MIDDLE_PARAM_AUTHCODE, session.topAuthCode);
                if (Site.DING.equals(AliMemberSDK.getMasterSite())) {
                    SessionManager sessionManager = SessionManager.INSTANCE;
                    hashMap.put("userId", sessionManager.getInternalSession().userId);
                    hashMap.put("sid", sessionManager.getInternalSession().sid);
                }
                hashMap.put("openSid", session.openSid);
                oauthCallback.onSuccess(str, hashMap);
            }
        });
    }

    @Override // com.ali.user.open.oauth.base.BaseOauthServiceProviderImpl, com.ali.user.open.oauth.OauthServiceProvider
    public boolean isAppAuthSurpport(Context context) {
        return ((TbAuthService) AliMemberSDK.getService(TbAuthService.class)).isAppAuthSurpport(context);
    }

    @Override // com.ali.user.open.oauth.OauthServiceProvider
    public boolean isLoginUrl(String str) {
        return ((TbAuthService) AliMemberSDK.getService(TbAuthService.class)).isLoginUrl(str);
    }

    @Override // com.ali.user.open.oauth.OauthServiceProvider
    public void logout(Context context, String str) {
        ((TbAuthService) AliMemberSDK.getService(TbAuthService.class)).logout(null);
    }

    @Override // com.ali.user.open.oauth.OauthServiceProvider
    public void oauth(Activity activity, String str, AppCredential appCredential, Map<String, String> map, OauthCallback oauthCallback) {
        authTask(activity, str, appCredential, map, oauthCallback);
    }

    @Override // com.ali.user.open.oauth.base.BaseOauthServiceProviderImpl, com.ali.user.open.oauth.OauthServiceProvider
    public void refreshWhenLogin(String str, boolean z) {
        LoginReturnData loginReturnData = (LoginReturnData) JSON.parseObject(str, LoginReturnData.class);
        if (z) {
            ((SessionService) AliMemberSDK.getService(SessionService.class)).refreshCookie("taobao", loginReturnData);
        } else {
            ((SessionService) AliMemberSDK.getService(SessionService.class)).refreshWhenLogin("taobao", loginReturnData);
        }
    }

    @Override // com.ali.user.open.oauth.base.BaseOauthServiceProviderImpl, com.ali.user.open.oauth.OauthServiceProvider
    public void tokenLogin(String str, String str2, String str3, Map<String, String> map, final OauthCallback oauthCallback) {
        ((TbAuthService) AliMemberSDK.getService(TbAuthService.class)).tokenLogin(0, str, str2, str3, new LoginCallback() { // from class: com.ali.user.open.oauth.taobao.TaobaoOauthServiceProviderImpl.2
            @Override // com.ali.user.open.core.callback.FailureCallback
            public void onFailure(int i, String str4) {
                oauthCallback.onFail("taobao", i, str4);
            }

            @Override // com.ali.user.open.callback.LoginCallback
            public void onSuccess(Session session) {
                HashMap hashMap = new HashMap();
                if (Site.DING.equals(AliMemberSDK.getMasterSite())) {
                    SessionManager sessionManager = SessionManager.INSTANCE;
                    hashMap.put("userId", sessionManager.getInternalSession().userId);
                    hashMap.put("sid", sessionManager.getInternalSession().sid);
                }
                oauthCallback.onSuccess("taobao", hashMap);
            }
        });
    }
}
