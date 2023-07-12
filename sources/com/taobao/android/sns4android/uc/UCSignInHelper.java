package com.taobao.android.sns4android.uc;

import android.app.Activity;
import android.content.Intent;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.model.SNSSignInAccount;
import com.ali.user.mobile.utils.NetworkUtil;
import com.ali.user.open.core.AliMemberSDK;
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
public class UCSignInHelper extends SNSSignInAbstractHelper {
    public static final String SNS_TYPE = "jiuyou";

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.sns4android.uc.UCSignInHelper$a */
    /* loaded from: classes11.dex */
    class C6626a implements OauthCallback {
        final /* synthetic */ Activity a;

        C6626a(Activity activity) {
            this.a = activity;
        }

        @Override // com.ali.user.open.oauth.OauthCallback
        public void onFail(String str, int i, String str2) {
            UCSignInHelper.this.resultUT(UTConstans.PageName.UT_PAGE_EXTENT_UC, UTConstant.Args.UT_SUCCESS_F);
            SNSSignInListener sNSSignInListener = UCSignInHelper.this.snsSignInListener;
            if (sNSSignInListener != null) {
                sNSSignInListener.onError(this.a, "jiuyou", 702, DataProviderFactory.getApplicationContext().getString(R.string.aliuser_SNS_platform_auth_fail));
            }
        }

        @Override // com.ali.user.open.oauth.OauthCallback
        public void onSuccess(String str, Map map) {
            UCSignInHelper.this.resultUT(UTConstans.PageName.UT_PAGE_EXTENT_UC, "T");
            if (UCSignInHelper.this.snsSignInListener != null) {
                SNSSignInAccount sNSSignInAccount = new SNSSignInAccount();
                sNSSignInAccount.token = (String) map.get(XStateConstants.KEY_ACCESS_TOKEN);
                sNSSignInAccount.userId = (String) map.get("openId");
                sNSSignInAccount.snsType = "jiuyou";
                UCSignInHelper.this.snsSignInListener.onSucceed(this.a, sNSSignInAccount);
            }
        }
    }

    private UCSignInHelper() {
    }

    public static UCSignInHelper create(String str, String str2) {
        try {
            AppCredential appCredential = new AppCredential();
            appCredential.appKey = str;
            appCredential.redirectUrl = str2;
            OauthPlatformConfig.setOauthConfig("jiuyou", appCredential);
        } catch (Throwable unused) {
        }
        return new UCSignInHelper();
    }

    @Override // com.taobao.android.sns4android.SNSSignInAbstractHelper
    public void onActivityResult(int i, int i2, Intent intent) {
    }

    @Override // com.taobao.android.sns4android.SNSSignInAbstractHelper
    public void signIn(Activity activity) {
        UserTrackAdapter.sendControlUT(UTConstans.PageName.UT_PAGE_EXTENT_UC, "Btn_Login");
        if (!NetworkUtil.isNetworkConnected()) {
            SNSSignInListener sNSSignInListener = this.snsSignInListener;
            if (sNSSignInListener != null) {
                sNSSignInListener.onError(activity, "jiuyou", -1, DataProviderFactory.getApplicationContext().getString(R.string.aliuser_network_error));
                return;
            }
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(ParamsConstants.Key.PARAM_ONLY_AUTHCODE, "1");
            if (AliMemberSDK.getService(OauthService.class) != null) {
                ((OauthService) AliMemberSDK.getService(OauthService.class)).oauth(activity, "jiuyou", hashMap, new C6626a(activity));
            } else {
                SNSSignInListener sNSSignInListener2 = this.snsSignInListener;
                if (sNSSignInListener2 != null) {
                    sNSSignInListener2.onError(activity, "jiuyou", 10012, activity.getString(R.string.aliuser_SNS_platform_auth_not_init_ucc));
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.taobao.android.sns4android.SNSSignInAbstractHelper
    public void signOut(Activity activity) {
    }
}
