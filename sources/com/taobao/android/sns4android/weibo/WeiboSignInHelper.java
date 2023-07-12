package com.taobao.android.sns4android.weibo;

import android.app.Activity;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.model.LoginType;
import com.ali.user.mobile.model.SNSSignInAccount;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.Site;
import com.ali.user.open.core.util.ParamsConstants;
import com.ali.user.open.oauth.AppCredential;
import com.ali.user.open.oauth.OauthCallback;
import com.ali.user.open.oauth.OauthPlatformConfig;
import com.ali.user.open.oauth.OauthService;
import com.taobao.android.sns4android.R;
import com.taobao.android.sns4android.SNSSignInAbstractHelper;
import com.taobao.android.sns4android.SNSSignInListener;
import com.taobao.android.sns4android.util.UTConstans;
import java.util.HashMap;
import java.util.Map;
import mtopsdk.xstate.util.XStateConstants;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WeiboSignInHelper extends SNSSignInAbstractHelper {
    public static String SNS_TYPE = LoginType.ServerLoginType.LoginTypeWeibo.getType();
    public static final String TAG = "login.weibo";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.sns4android.weibo.WeiboSignInHelper$a */
    /* loaded from: classes11.dex */
    public class C6629a implements OauthCallback {
        final /* synthetic */ SNSSignInListener a;
        final /* synthetic */ Activity b;

        C6629a(SNSSignInListener sNSSignInListener, Activity activity) {
            this.a = sNSSignInListener;
            this.b = activity;
        }

        @Override // com.ali.user.open.oauth.OauthCallback
        public void onFail(String str, int i, String str2) {
            WeiboSignInHelper.this.resultUT(UTConstans.PageName.UT_PAGE_EXTENT_WEIBO, UTConstant.Args.UT_SUCCESS_F);
            SNSSignInListener sNSSignInListener = this.a;
            if (sNSSignInListener != null) {
                if (i == 604) {
                    sNSSignInListener.onCancel(this.b, WeiboSignInHelper.SNS_TYPE);
                } else {
                    sNSSignInListener.onError(this.b, WeiboSignInHelper.SNS_TYPE, 702, DataProviderFactory.getApplicationContext().getString(R.string.aliuser_SNS_platform_auth_fail));
                }
            }
        }

        @Override // com.ali.user.open.oauth.OauthCallback
        public void onSuccess(String str, Map map) {
            WeiboSignInHelper.this.resultUT(UTConstans.PageName.UT_PAGE_EXTENT_WEIBO, "T");
            if (this.a != null) {
                SNSSignInAccount sNSSignInAccount = new SNSSignInAccount();
                sNSSignInAccount.token = (String) map.get(XStateConstants.KEY_ACCESS_TOKEN);
                sNSSignInAccount.userId = (String) map.get("openId");
                sNSSignInAccount.snsType = WeiboSignInHelper.SNS_TYPE;
                this.a.onSucceed(this.b, sNSSignInAccount);
            }
        }
    }

    private WeiboSignInHelper() {
    }

    public static WeiboSignInHelper create(String str, String str2, String str3) {
        try {
            AppCredential appCredential = new AppCredential();
            appCredential.appKey = str;
            appCredential.appSecret = str2;
            appCredential.redirectUrl = str3;
            OauthPlatformConfig.setOauthConfig(Site.WEIBO, appCredential);
        } catch (Throwable unused) {
        }
        return new WeiboSignInHelper();
    }

    @Override // com.taobao.android.sns4android.SNSSignInAbstractHelper
    public void auth(Activity activity, SNSSignInListener sNSSignInListener) {
        UserTrackAdapter.sendControlUT(UTConstans.PageName.UT_PAGE_EXTENT_WEIBO, "Btn_Login");
        HashMap hashMap = new HashMap();
        hashMap.put(ParamsConstants.Key.PARAM_ONLY_AUTHCODE, "1");
        if (AliMemberSDK.getService(OauthService.class) != null) {
            ((OauthService) AliMemberSDK.getService(OauthService.class)).oauth(activity, Site.WEIBO, hashMap, new C6629a(sNSSignInListener, activity));
        }
    }

    @Override // com.taobao.android.sns4android.SNSSignInAbstractHelper
    public void signIn(Activity activity) {
        auth(activity, this.snsSignInListener);
    }
}
