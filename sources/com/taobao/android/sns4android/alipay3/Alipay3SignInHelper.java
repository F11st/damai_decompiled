package com.taobao.android.sns4android.alipay3;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.log.TLogAdapter;
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
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class Alipay3SignInHelper extends SNSSignInAbstractHelper {
    public static String SNS_TYPE = "alipay";
    public static String TAG = "Login.alipay3";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.sns4android.alipay3.Alipay3SignInHelper$a */
    /* loaded from: classes11.dex */
    public class C6601a implements OauthCallback {
        final /* synthetic */ SNSSignInListener a;
        final /* synthetic */ Activity b;
        final /* synthetic */ Context c;

        C6601a(SNSSignInListener sNSSignInListener, Activity activity, Context context) {
            this.a = sNSSignInListener;
            this.b = activity;
            this.c = context;
        }

        @Override // com.ali.user.open.oauth.OauthCallback
        public void onFail(String str, int i, String str2) {
            Alipay3SignInHelper.this.resultUT(UTConstans.PageName.UT_PAGE_EXTENT_ALIPAY3, UTConstant.Args.UT_SUCCESS_F);
            SNSSignInListener sNSSignInListener = this.a;
            if (sNSSignInListener != null) {
                if (i == 204) {
                    sNSSignInListener.onCancel(this.b, Alipay3SignInHelper.SNS_TYPE);
                } else {
                    sNSSignInListener.onError(this.b, Alipay3SignInHelper.SNS_TYPE, i, this.c.getString(R.string.aliuser_SNS_platform_auth_fail));
                }
            }
        }

        @Override // com.ali.user.open.oauth.OauthCallback
        public void onSuccess(String str, Map map) {
            Alipay3SignInHelper.this.resultUT(UTConstans.PageName.UT_PAGE_EXTENT_ALIPAY3, "T");
            if (this.a != null) {
                SNSSignInAccount sNSSignInAccount = new SNSSignInAccount();
                sNSSignInAccount.token = (String) map.get(SignConstants.MIDDLE_PARAM_AUTHCODE);
                sNSSignInAccount.snsType = Alipay3SignInHelper.SNS_TYPE;
                this.a.onSucceed(this.b, sNSSignInAccount);
            }
        }
    }

    private Alipay3SignInHelper() {
    }

    private void authInner(boolean z, Activity activity, SNSSignInListener sNSSignInListener) {
        authInner(z, activity, sNSSignInListener, null);
    }

    public static Alipay3SignInHelper create(SNSConfig sNSConfig) {
        try {
            TLogAdapter.e(TAG, "in Alipay3SignInHelper create");
            AppCredential appCredential = new AppCredential();
            appCredential.appKey = sNSConfig.app_id;
            appCredential.pid = sNSConfig.pid;
            appCredential.signType = sNSConfig.sign_type;
            appCredential.targetId = sNSConfig.target_id;
            appCredential.scope = sNSConfig.scope;
            OauthPlatformConfig.setOauthConfig("alipay", appCredential);
        } catch (Throwable unused) {
        }
        return new Alipay3SignInHelper();
    }

    @Override // com.taobao.android.sns4android.SNSSignInAbstractHelper
    public void auth(Activity activity, SNSSignInListener sNSSignInListener, JSONObject jSONObject) {
        authInner(false, activity, sNSSignInListener, jSONObject);
    }

    @Override // com.taobao.android.sns4android.SNSSignInAbstractHelper
    public void signIn(Activity activity) {
        authInner(true, activity, this.snsSignInListener);
    }

    private void authInner(boolean z, Activity activity, SNSSignInListener sNSSignInListener, JSONObject jSONObject) {
        authInner(z, activity, sNSSignInListener, jSONObject, null);
    }

    @Override // com.taobao.android.sns4android.SNSSignInAbstractHelper
    public void signIn(Activity activity, Map<String, String> map) {
        authInner(true, activity, this.snsSignInListener, null, map);
    }

    private void authInner(boolean z, Activity activity, SNSSignInListener sNSSignInListener, JSONObject jSONObject, Map<String, String> map) {
        UserTrackAdapter.sendControlUT(UTConstans.PageName.UT_PAGE_EXTENT_ALIPAY3, "Btn_Login");
        HashMap hashMap = new HashMap();
        hashMap.put(ParamsConstants.Key.PARAM_ONLY_AUTHCODE, "1");
        if (z && DataProviderFactory.getDataProvider().isTaobaoApp()) {
            hashMap.put(ParamsConstants.Key.PARAM_ALIPAY_QUICK_LOGIN, "1");
        }
        if (jSONObject != null) {
            try {
                hashMap.put(ParamsConstants.Key.PARAM_ALIPAY_URL, jSONObject.opt(ParamsConstants.Key.PARAM_ALIPAY_URL));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (map != null && !map.isEmpty()) {
            String remove = map.remove(UTConstant.PageName.UT_KEY_PAGE_NAME);
            if (!TextUtils.isEmpty(remove)) {
                UserTrackAdapter.sendControlUT(remove, "Btn_Login");
            }
            hashMap.putAll(map);
        }
        Context applicationContext = DataProviderFactory.getApplicationContext();
        if (AliMemberSDK.getService(OauthService.class) != null) {
            TLogAdapter.e(TAG, "oauthservice != null");
            ((OauthService) AliMemberSDK.getService(OauthService.class)).oauth(activity, "alipay", hashMap, new C6601a(sNSSignInListener, activity, applicationContext));
            return;
        }
        TLogAdapter.e(TAG, "OauthService is null");
        if (sNSSignInListener != null) {
            sNSSignInListener.onError(activity, SNS_TYPE, 10012, applicationContext.getString(R.string.aliuser_SNS_platform_auth_not_init_ucc));
        }
    }
}
