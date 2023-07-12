package com.ali.user.open.oauth.weibo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.ali.user.open.core.Site;
import com.ali.user.open.oauth.AppCredential;
import com.ali.user.open.oauth.OauthCallback;
import com.ali.user.open.oauth.base.BaseOauthServiceProviderImpl;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.common.UiError;
import com.sina.weibo.sdk.openapi.IWBAPI;
import com.sina.weibo.sdk.openapi.WBAPIFactory;
import com.tencent.tauth.IUiListener;
import java.util.HashMap;
import java.util.Map;
import mtopsdk.xstate.util.XStateConstants;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class WeiboOauthServiceProviderImpl extends BaseOauthServiceProviderImpl {
    private static String SCOPE = "email,direct_messages_read,direct_messages_write,friendships_groups_read,friendships_groups_write,statuses_to_me_read,follow_app_official_microblog,invitation_write";
    public static final String TAG = "oa.WeiboOauthServiceProviderImpl";
    private IUiListener mQQAuthListener;
    private IWBAPI mSsoHandler;

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    private static class SelfWbAuthListener implements WbAuthListener {
        OauthCallback oauthCallback;

        public SelfWbAuthListener(OauthCallback oauthCallback) {
            this.oauthCallback = oauthCallback;
        }

        @Override // com.sina.weibo.sdk.auth.WbAuthListener
        public void onCancel() {
            OauthCallback oauthCallback = this.oauthCallback;
            if (oauthCallback != null) {
                oauthCallback.onFail(Site.WEIBO, 604, "");
            }
        }

        @Override // com.sina.weibo.sdk.auth.WbAuthListener
        public void onComplete(Oauth2AccessToken oauth2AccessToken) {
            if (oauth2AccessToken.isSessionValid()) {
                if (this.oauthCallback != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(XStateConstants.KEY_ACCESS_TOKEN, oauth2AccessToken.getAccessToken());
                    hashMap.put("openId", oauth2AccessToken.getUid());
                    this.oauthCallback.onSuccess(Site.WEIBO, hashMap);
                    return;
                }
                return;
            }
            OauthCallback oauthCallback = this.oauthCallback;
            if (oauthCallback != null) {
                oauthCallback.onFail(Site.WEIBO, 603, "");
            }
        }

        @Override // com.sina.weibo.sdk.auth.WbAuthListener
        public void onError(UiError uiError) {
            OauthCallback oauthCallback = this.oauthCallback;
            if (oauthCallback != null) {
                oauthCallback.onFail(Site.WEIBO, 603, uiError != null ? uiError.errorMessage : "");
            }
        }
    }

    @Override // com.ali.user.open.oauth.OauthServiceProvider
    public boolean isLoginUrl(String str) {
        return false;
    }

    @Override // com.ali.user.open.oauth.OauthServiceProvider
    public void logout(Context context, String str) {
    }

    @Override // com.ali.user.open.oauth.OauthServiceProvider
    public void oauth(Activity activity, String str, AppCredential appCredential, Map<String, String> map, OauthCallback oauthCallback) {
        if (activity == null) {
            oauthCallback.onFail(Site.WEIBO, 601, "activity is null");
        } else if (appCredential == null) {
            oauthCallback.onFail(Site.WEIBO, 602, "appCredential is null");
        } else {
            try {
                AuthInfo authInfo = new AuthInfo(activity, appCredential.appKey, appCredential.redirectUrl, "email");
                IWBAPI createWBAPI = WBAPIFactory.createWBAPI(activity);
                this.mSsoHandler = createWBAPI;
                createWBAPI.registerApp(activity, authInfo);
                this.mSsoHandler.authorize(new SelfWbAuthListener(oauthCallback));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.ali.user.open.oauth.base.BaseOauthServiceProviderImpl, com.ali.user.open.oauth.OauthServiceProvider
    public void onActivityResult(int i, int i2, Intent intent) {
        IWBAPI iwbapi = this.mSsoHandler;
        if (iwbapi != null) {
            iwbapi.authorizeCallback(i, i2, intent);
        }
    }
}
