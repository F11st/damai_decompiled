package com.taobao.android.sns4android.alipayinside;

import android.app.Activity;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.model.SNSSignInAccount;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.util.ParamsConstants;
import com.ali.user.open.oauth.AppCredential;
import com.ali.user.open.oauth.OauthCallback;
import com.ali.user.open.oauth.OauthPlatformConfig;
import com.ali.user.open.oauth.OauthService;
import com.taobao.android.sns4android.R;
import com.taobao.android.sns4android.SNSConfig;
import com.taobao.android.sns4android.SNSSignInAbstractHelper;
import com.taobao.android.sns4android.SNSSignInListener;
import com.taobao.android.sns4android.util.UTConstans;
import java.util.HashMap;
import java.util.Map;
import mtopsdk.security.util.SignConstants;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class AlipayInsideSignInHelper extends SNSSignInAbstractHelper {
    public static String SNS_TYPE = "alipay";
    public static String TAG = "login.alipayinside";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.sns4android.alipayinside.AlipayInsideSignInHelper$a */
    /* loaded from: classes11.dex */
    public class C6602a implements OauthCallback {
        final /* synthetic */ SNSSignInListener a;
        final /* synthetic */ Activity b;

        C6602a(SNSSignInListener sNSSignInListener, Activity activity) {
            this.a = sNSSignInListener;
            this.b = activity;
        }

        @Override // com.ali.user.open.oauth.OauthCallback
        public void onFail(String str, int i, String str2) {
            AlipayInsideSignInHelper.this.resultUT(UTConstans.PageName.UT_PAGE_EXTENT_ALIPAY3, UTConstant.Args.UT_SUCCESS_F);
            SNSSignInListener sNSSignInListener = this.a;
            if (sNSSignInListener != null) {
                if (i == 204) {
                    sNSSignInListener.onCancel(this.b, AlipayInsideSignInHelper.SNS_TYPE);
                } else {
                    sNSSignInListener.onError(this.b, AlipayInsideSignInHelper.SNS_TYPE, 702, DataProviderFactory.getApplicationContext().getString(R.string.aliuser_SNS_platform_auth_fail));
                }
            }
        }

        @Override // com.ali.user.open.oauth.OauthCallback
        public void onSuccess(String str, Map map) {
            AlipayInsideSignInHelper.this.resultUT(UTConstans.PageName.UT_PAGE_EXTENT_ALIPAY3, "T");
            if (this.a != null) {
                SNSSignInAccount sNSSignInAccount = new SNSSignInAccount();
                sNSSignInAccount.token = (String) map.get(SignConstants.MIDDLE_PARAM_AUTHCODE);
                sNSSignInAccount.snsType = AlipayInsideSignInHelper.SNS_TYPE;
                this.a.onSucceed(this.b, sNSSignInAccount);
            }
        }
    }

    public static AlipayInsideSignInHelper create(SNSConfig sNSConfig) {
        try {
            AppCredential appCredential = new AppCredential();
            appCredential.appKey = sNSConfig.app_id;
            appCredential.pid = sNSConfig.pid;
            appCredential.signType = sNSConfig.sign_type;
            appCredential.targetId = sNSConfig.target_id;
            OauthPlatformConfig.setOauthConfig("alipay", appCredential);
        } catch (Throwable unused) {
        }
        return new AlipayInsideSignInHelper();
    }

    @Override // com.taobao.android.sns4android.SNSSignInAbstractHelper
    public void auth(Activity activity, SNSSignInListener sNSSignInListener) {
        UserTrackAdapter.sendControlUT(UTConstans.PageName.UT_PAGE_EXTENT_ALIPAY3, "Btn_Login");
        HashMap hashMap = new HashMap();
        hashMap.put(ParamsConstants.Key.PARAM_ONLY_AUTHCODE, "1");
        hashMap.put(ParamsConstants.Key.PARAM_INSIDE_ALIPAY, "1");
        if (AliMemberSDK.getService(OauthService.class) != null) {
            ((OauthService) AliMemberSDK.getService(OauthService.class)).oauth(activity, "alipay", hashMap, new C6602a(sNSSignInListener, activity));
        }
    }

    @Override // com.taobao.android.sns4android.SNSSignInAbstractHelper
    public void signIn(Activity activity) {
        auth(activity, this.snsSignInListener);
    }
}
