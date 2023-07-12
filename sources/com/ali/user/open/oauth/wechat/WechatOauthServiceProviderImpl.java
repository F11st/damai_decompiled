package com.ali.user.open.oauth.wechat;

import android.app.Activity;
import android.content.Context;
import com.ali.user.open.oauth.AppCredential;
import com.ali.user.open.oauth.OauthCallback;
import com.ali.user.open.oauth.base.BaseOauthServiceProviderImpl;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class WechatOauthServiceProviderImpl extends BaseOauthServiceProviderImpl {
    public static final String TAG = "oa.WechatOauthServiceProviderImpl";
    private OauthCallback mWechatOauthCallback;

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
            oauthCallback.onFail("wechat", 401, "activity is null");
        } else if (appCredential == null) {
            oauthCallback.onFail("wechat", 402, "appCredential is null");
        } else {
            WechatAuthRespHandler.getInstance().addOauthCallback(oauthCallback);
            IWXAPI createWXAPI = WXAPIFactory.createWXAPI(activity.getApplicationContext(), appCredential.appKey, true);
            createWXAPI.registerApp(appCredential.appKey);
            SendAuth.Req req = new SendAuth.Req();
            req.scope = "snsapi_userinfo";
            req.state = "none";
            createWXAPI.sendReq(req);
        }
    }
}
