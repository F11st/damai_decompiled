package tb;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.ali.user.open.core.Site;
import com.ali.user.open.oauth.AppCredential;
import com.ali.user.open.oauth.OauthCallback;
import com.ali.user.open.oauth.base.BaseOauthServiceProviderImpl;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.common.UiError;
import com.sina.weibo.sdk.openapi.IWBAPI;
import com.sina.weibo.sdk.openapi.WBAPIFactory;
import java.util.HashMap;
import java.util.Map;
import mtopsdk.xstate.util.XStateConstants;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class nk1 extends BaseOauthServiceProviderImpl {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String TAG = "oa.WeiboOauthServiceProviderImpl";
    private IWBAPI a;
    Activity b;

    /* compiled from: Taobao */
    /* renamed from: tb.nk1$a */
    /* loaded from: classes5.dex */
    public static class C9475a implements WbAuthListener {
        private static transient /* synthetic */ IpChange $ipChange;
        OauthCallback a;

        public C9475a(OauthCallback oauthCallback) {
            this.a = oauthCallback;
        }

        @Override // com.sina.weibo.sdk.auth.WbAuthListener
        public void onCancel() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1323701837")) {
                ipChange.ipc$dispatch("1323701837", new Object[]{this});
                return;
            }
            OauthCallback oauthCallback = this.a;
            if (oauthCallback != null) {
                oauthCallback.onFail(Site.WEIBO, 604, "");
            }
        }

        @Override // com.sina.weibo.sdk.auth.WbAuthListener
        public void onComplete(Oauth2AccessToken oauth2AccessToken) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1875560116")) {
                ipChange.ipc$dispatch("-1875560116", new Object[]{this, oauth2AccessToken});
            } else if (oauth2AccessToken.isSessionValid()) {
                if (this.a != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(XStateConstants.KEY_ACCESS_TOKEN, oauth2AccessToken.getAccessToken());
                    hashMap.put("openId", oauth2AccessToken.getUid());
                    this.a.onSuccess(Site.WEIBO, hashMap);
                }
            } else {
                OauthCallback oauthCallback = this.a;
                if (oauthCallback != null) {
                    oauthCallback.onFail(Site.WEIBO, 603, "");
                }
            }
        }

        @Override // com.sina.weibo.sdk.auth.WbAuthListener
        public void onError(UiError uiError) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1630858430")) {
                ipChange.ipc$dispatch("-1630858430", new Object[]{this, uiError});
                return;
            }
            OauthCallback oauthCallback = this.a;
            if (oauthCallback != null) {
                oauthCallback.onFail(Site.WEIBO, 603, uiError != null ? uiError.errorMessage : "");
            }
        }
    }

    @Override // com.ali.user.open.oauth.OauthServiceProvider
    public boolean isLoginUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-652555135")) {
            return ((Boolean) ipChange.ipc$dispatch("-652555135", new Object[]{this, str})).booleanValue();
        }
        return false;
    }

    @Override // com.ali.user.open.oauth.OauthServiceProvider
    public void logout(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "516966585")) {
            ipChange.ipc$dispatch("516966585", new Object[]{this, context, str});
        }
    }

    @Override // com.ali.user.open.oauth.OauthServiceProvider
    public void oauth(Activity activity, String str, AppCredential appCredential, Map<String, String> map, OauthCallback oauthCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1598719149")) {
            ipChange.ipc$dispatch("1598719149", new Object[]{this, activity, str, appCredential, map, oauthCallback});
        } else if (activity == null) {
            oauthCallback.onFail(Site.WEIBO, 601, "activity is null");
        } else {
            this.b = activity;
            if (appCredential == null) {
                oauthCallback.onFail(Site.WEIBO, 602, "appCredential is null");
                return;
            }
            try {
                AuthInfo authInfo = new AuthInfo(activity, appCredential.appKey, appCredential.redirectUrl, "email");
                IWBAPI createWBAPI = WBAPIFactory.createWBAPI(activity);
                this.a = createWBAPI;
                createWBAPI.registerApp(activity, authInfo);
                this.a.authorize(activity, new C9475a(oauthCallback));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.ali.user.open.oauth.base.BaseOauthServiceProviderImpl, com.ali.user.open.oauth.OauthServiceProvider
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1063072779")) {
            ipChange.ipc$dispatch("-1063072779", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        IWBAPI iwbapi = this.a;
        if (iwbapi != null) {
            iwbapi.authorizeCallback(this.b, i, i2, intent);
        }
    }
}
