package com.ali.user.open.oauth.qq;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.ali.user.open.core.Site;
import com.ali.user.open.oauth.AppCredential;
import com.ali.user.open.oauth.OauthCallback;
import com.ali.user.open.oauth.base.BaseOauthServiceProviderImpl;
import com.tencent.connect.common.Constants;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import java.util.HashMap;
import java.util.Map;
import mtopsdk.xstate.util.XStateConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class QQOauthServiceProviderImpl extends BaseOauthServiceProviderImpl {
    public static final String TAG = "oa.QQOauthServiceProviderImpl";
    private IUiListener mQQAuthListener;

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    private class BaseUiListener implements IUiListener {
        private OauthCallback oauthCallback;

        public BaseUiListener(OauthCallback oauthCallback) {
            this.oauthCallback = oauthCallback;
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            OauthCallback oauthCallback = this.oauthCallback;
            if (oauthCallback != null) {
                oauthCallback.onFail(Site.QQ, 504, "");
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            if (obj != null) {
                try {
                    JSONObject jSONObject = new JSONObject(obj.toString());
                    String optString = jSONObject.optString(Constants.PARAM_ACCESS_TOKEN);
                    String optString2 = jSONObject.optString("openid");
                    if (this.oauthCallback != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put(XStateConstants.KEY_ACCESS_TOKEN, optString);
                        hashMap.put("openId", optString2);
                        this.oauthCallback.onSuccess(Site.QQ, hashMap);
                    }
                } catch (JSONException unused) {
                    OauthCallback oauthCallback = this.oauthCallback;
                    if (oauthCallback != null) {
                        oauthCallback.onFail(Site.QQ, 503, "");
                    }
                }
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            OauthCallback oauthCallback = this.oauthCallback;
            if (oauthCallback != null) {
                oauthCallback.onFail(Site.QQ, 503, uiError.errorMessage);
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
            oauthCallback.onFail(Site.QQ, 501, "activity is null");
        } else if (appCredential == null) {
            oauthCallback.onFail(Site.QQ, 502, "appCredential is null");
        } else {
            try {
                Tencent createInstance = Tencent.createInstance(appCredential.appKey, activity.getApplicationContext());
                this.mQQAuthListener = new BaseUiListener(oauthCallback);
                if (createInstance.isSessionValid()) {
                    return;
                }
                createInstance.login(activity, "get_simple_userinfo", this.mQQAuthListener);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.ali.user.open.oauth.base.BaseOauthServiceProviderImpl, com.ali.user.open.oauth.OauthServiceProvider
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 11101) {
            Tencent.onActivityResultData(i, i2, intent, this.mQQAuthListener);
        }
    }
}
