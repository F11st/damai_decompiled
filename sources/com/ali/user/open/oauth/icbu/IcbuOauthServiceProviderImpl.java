package com.ali.user.open.oauth.icbu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.ali.user.mobile.rpc.ApiConstants;
import com.ali.user.open.callback.LoginCallback;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.Site;
import com.ali.user.open.core.context.KernelContext;
import com.ali.user.open.core.model.LoginReturnData;
import com.ali.user.open.core.trace.SDKLogger;
import com.ali.user.open.core.util.ParamsConstants;
import com.ali.user.open.oauth.AppCredential;
import com.ali.user.open.oauth.OauthCallback;
import com.ali.user.open.oauth.base.BaseOauthServiceProviderImpl;
import com.ali.user.open.service.SessionService;
import com.ali.user.open.service.impl.SessionManager;
import com.ali.user.open.session.Session;
import com.ali.user.open.tbauth.TbAuthService;
import com.ali.user.open.tbauth.ui.ICBUAuthActivity;
import com.ali.user.open.tbauth.ui.context.CallbackContext;
import com.alibaba.fastjson.JSON;
import java.util.HashMap;
import java.util.Map;
import mtopsdk.security.util.SignConstants;
import mtopsdk.xstate.util.XStateConstants;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class IcbuOauthServiceProviderImpl extends BaseOauthServiceProviderImpl {
    public String TAG = "login.icbuOauthImpl";

    @Override // com.ali.user.open.oauth.base.BaseOauthServiceProviderImpl, com.ali.user.open.oauth.OauthServiceProvider
    public boolean isAppAuthSurpport(Context context) {
        return false;
    }

    @Override // com.ali.user.open.oauth.OauthServiceProvider
    public boolean isLoginUrl(String str) {
        return false;
    }

    @Override // com.ali.user.open.oauth.OauthServiceProvider
    public void logout(Context context, String str) {
        ((SessionService) AliMemberSDK.getService(SessionService.class)).logout(str);
    }

    @Override // com.ali.user.open.oauth.OauthServiceProvider
    public void oauth(Activity activity, final String str, AppCredential appCredential, Map<String, String> map, final OauthCallback oauthCallback) {
        showH5Login(activity);
        CallbackContext.loginCallback = new LoginCallback() { // from class: com.ali.user.open.oauth.icbu.IcbuOauthServiceProviderImpl.1
            @Override // com.ali.user.open.core.callback.FailureCallback
            public void onFailure(int i, String str2) {
                oauthCallback.onFail(str, i, str2);
            }

            @Override // com.ali.user.open.callback.LoginCallback
            public void onSuccess(Session session) {
                HashMap hashMap = new HashMap();
                hashMap.put("openId", session.openId);
                hashMap.put(ParamsConstants.Key.PARAM_BIND_TOKEN, session.bindToken);
                hashMap.put(XStateConstants.KEY_ACCESS_TOKEN, session.topAccessToken);
                hashMap.put(SignConstants.MIDDLE_PARAM_AUTHCODE, session.topAuthCode);
                hashMap.put(ApiConstants.ApiField.HID, session.hid);
                oauthCallback.onSuccess(str, hashMap);
            }
        };
    }

    @Override // com.ali.user.open.oauth.base.BaseOauthServiceProviderImpl, com.ali.user.open.oauth.OauthServiceProvider
    public void refreshWhenLogin(String str, boolean z) {
        LoginReturnData loginReturnData = (LoginReturnData) JSON.parseObject(str, LoginReturnData.class);
        if (z) {
            ((SessionService) AliMemberSDK.getService(SessionService.class)).refreshCookie(Site.ICBU, loginReturnData);
        } else {
            ((SessionService) AliMemberSDK.getService(SessionService.class)).refreshWhenLogin(Site.ICBU, loginReturnData);
        }
    }

    public void showH5Login(Activity activity) {
        SDKLogger.d(this.TAG, "open H5 login");
        Intent intent = new Intent(activity, ICBUAuthActivity.class);
        intent.setFlags(268435456);
        KernelContext.getApplicationContext().startActivity(intent);
    }

    @Override // com.ali.user.open.oauth.base.BaseOauthServiceProviderImpl, com.ali.user.open.oauth.OauthServiceProvider
    public void tokenLogin(String str, String str2, String str3, Map<String, String> map, final OauthCallback oauthCallback) {
        ((TbAuthService) AliMemberSDK.getService(TbAuthService.class)).tokenLogin(4, str, str2, str3, new LoginCallback() { // from class: com.ali.user.open.oauth.icbu.IcbuOauthServiceProviderImpl.2
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
