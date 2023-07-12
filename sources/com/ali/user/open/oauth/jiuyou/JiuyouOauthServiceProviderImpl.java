package com.ali.user.open.oauth.jiuyou;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.ali.user.open.oauth.AppCredential;
import com.ali.user.open.oauth.OauthCallback;
import com.ali.user.open.oauth.base.BaseOauthServiceProviderImpl;
import com.ali.user.open.oauth.ui.OAuthWebViewActivity;
import java.util.HashMap;
import java.util.Map;
import mtopsdk.xstate.util.XStateConstants;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class JiuyouOauthServiceProviderImpl extends BaseOauthServiceProviderImpl {
    public static final String TAG = "oa.AlipayOauthServiceProviderImpl";
    private final int REQUEST_CODE = 1001;
    private OauthCallback oauthCallback;

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
            oauthCallback.onFail("jiuyou", 801, "activity is null");
        } else if (appCredential == null) {
            oauthCallback.onFail("jiuyou", 802, "appCredential is null");
        } else {
            this.oauthCallback = oauthCallback;
            Intent intent = new Intent();
            intent.setClass(activity, OAuthWebViewActivity.class);
            intent.putExtra("url", "https://api.open.uc.cn/cas/login?v=1.1&change_uid=1&client_id=" + appCredential.appKey + "&browsertype=html5&redirect_uri=" + appCredential.redirectUrl);
            intent.putExtra("redirectUri", appCredential.redirectUrl);
            intent.putExtra("snsType", "jiuyou");
            intent.putExtra("hideToolBar", true);
            activity.startActivityForResult(intent, 1001);
        }
    }

    @Override // com.ali.user.open.oauth.base.BaseOauthServiceProviderImpl, com.ali.user.open.oauth.OauthServiceProvider
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            String stringExtra = intent.getStringExtra("token");
            if (this.oauthCallback != null) {
                HashMap hashMap = new HashMap();
                hashMap.put(XStateConstants.KEY_ACCESS_TOKEN, stringExtra);
                this.oauthCallback.onSuccess("jiuyou", hashMap);
                this.oauthCallback = null;
                return;
            }
            return;
        }
        OauthCallback oauthCallback = this.oauthCallback;
        if (oauthCallback != null) {
            oauthCallback.onFail("jiuyou", -1, "");
            this.oauthCallback = null;
        }
    }
}
