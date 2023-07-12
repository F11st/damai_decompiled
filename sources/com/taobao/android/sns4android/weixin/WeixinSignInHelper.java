package com.taobao.android.sns4android.weixin;

import android.app.Activity;
import android.os.AsyncTask;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.coordinator.CoordinatorWrapper;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.model.LoginType;
import com.ali.user.mobile.model.SNSSignInAccount;
import com.ali.user.mobile.utils.BundleUtil;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.util.ParamsConstants;
import com.ali.user.open.oauth.AppCredential;
import com.ali.user.open.oauth.OauthCallback;
import com.ali.user.open.oauth.OauthPlatformConfig;
import com.ali.user.open.oauth.OauthService;
import com.alibaba.fastjson.JSON;
import com.taobao.android.sns4android.R;
import com.taobao.android.sns4android.SNSPlatform;
import com.taobao.android.sns4android.SNSSignInAbstractHelper;
import com.taobao.android.sns4android.SNSSignInListener;
import com.taobao.android.sns4android.TokenModel;
import com.taobao.android.sns4android.util.UTConstans;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import mtopsdk.security.util.SignConstants;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WeixinSignInHelper extends SNSSignInAbstractHelper {
    public static String SNS_TYPE = LoginType.ServerLoginType.LoginTypeWeixin.getType();
    protected static String appid;
    private static WeakReference<Activity> mActivity;

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.sns4android.weixin.WeixinSignInHelper$a */
    /* loaded from: classes12.dex */
    class AsyncTaskC6630a extends AsyncTask<Object, Void, Boolean> {
        final /* synthetic */ Activity a;
        final /* synthetic */ SNSSignInListener b;

        AsyncTaskC6630a(Activity activity, SNSSignInListener sNSSignInListener) {
            this.a = activity;
            this.b = sNSSignInListener;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Boolean doInBackground(Object[] objArr) {
            return Boolean.valueOf(BundleUtil.isAppInstalled(DataProviderFactory.getApplicationContext(), SNSPlatform.PLATFORM_WEIXIN.getPackageName()));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            if (bool.booleanValue()) {
                WeixinSignInHelper.this.auth(this.a, this.b, false);
                return;
            }
            SNSSignInListener sNSSignInListener = this.b;
            if (sNSSignInListener != null) {
                sNSSignInListener.onError(this.a, WeixinSignInHelper.SNS_TYPE, 10011, DataProviderFactory.getApplicationContext().getString(R.string.aliuser_wechat_uninstalled));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.sns4android.weixin.WeixinSignInHelper$b */
    /* loaded from: classes11.dex */
    public class C6631b implements OauthCallback {
        final /* synthetic */ SNSSignInListener a;
        final /* synthetic */ boolean b;

        C6631b(SNSSignInListener sNSSignInListener, boolean z) {
            this.a = sNSSignInListener;
            this.b = z;
        }

        @Override // com.ali.user.open.oauth.OauthCallback
        public void onFail(String str, int i, String str2) {
            WeixinSignInHelper.this.resultUT(UTConstans.PageName.UT_PAGE_EXTENT_WEIXIN, UTConstant.Args.UT_SUCCESS_F);
            SNSSignInListener sNSSignInListener = this.a;
            if (sNSSignInListener != null) {
                if (i == 404) {
                    sNSSignInListener.onCancel(WeixinSignInHelper.getContext(), WeixinSignInHelper.SNS_TYPE);
                } else {
                    sNSSignInListener.onError(WeixinSignInHelper.getContext(), WeixinSignInHelper.SNS_TYPE, 702, DataProviderFactory.getApplicationContext().getString(R.string.aliuser_SNS_platform_auth_fail));
                }
            }
        }

        @Override // com.ali.user.open.oauth.OauthCallback
        public void onSuccess(String str, Map map) {
            WeixinSignInHelper.this.resultUT(UTConstans.PageName.UT_PAGE_EXTENT_WEIXIN, "T");
            if (this.a != null) {
                SNSSignInAccount sNSSignInAccount = new SNSSignInAccount();
                if (this.b) {
                    TokenModel tokenModel = new TokenModel();
                    tokenModel.authToken = (String) map.get(SignConstants.MIDDLE_PARAM_AUTHCODE);
                    tokenModel.consumerKey = WeixinSignInHelper.appid;
                    sNSSignInAccount.token = JSON.toJSONString(tokenModel);
                } else {
                    sNSSignInAccount.token = (String) map.get(SignConstants.MIDDLE_PARAM_AUTHCODE);
                }
                sNSSignInAccount.snsType = WeixinSignInHelper.SNS_TYPE;
                this.a.onSucceed(WeixinSignInHelper.getContext(), sNSSignInAccount);
            }
        }
    }

    public static WeixinSignInHelper create(String str, String str2) {
        try {
            AppCredential appCredential = new AppCredential();
            appid = str;
            appCredential.appKey = str;
            appCredential.appSecret = str2;
            OauthPlatformConfig.setOauthConfig("wechat", appCredential);
        } catch (Throwable unused) {
        }
        return new WeixinSignInHelper();
    }

    public static Activity getContext() {
        WeakReference<Activity> weakReference = mActivity;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @Override // com.taobao.android.sns4android.SNSSignInAbstractHelper
    public void auth(Activity activity, SNSSignInListener sNSSignInListener) {
        new CoordinatorWrapper().execute(new AsyncTaskC6630a(activity, sNSSignInListener), new Object[0]);
    }

    @Override // com.taobao.android.sns4android.SNSSignInAbstractHelper
    public void signIn(Activity activity) {
        mActivity = new WeakReference<>(activity);
        UserTrackAdapter.sendControlUT(UTConstans.PageName.UT_PAGE_EXTENT_WEIXIN, "Btn_Login");
        auth(activity, this.snsSignInListener, true);
    }

    public void auth(Activity activity, SNSSignInListener sNSSignInListener, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put(ParamsConstants.Key.PARAM_ONLY_AUTHCODE, "1");
        if (AliMemberSDK.getService(OauthService.class) != null) {
            ((OauthService) AliMemberSDK.getService(OauthService.class)).oauth(activity, "wechat", hashMap, new C6631b(sNSSignInListener, z));
        } else if (sNSSignInListener != null) {
            sNSSignInListener.onError(activity, SNS_TYPE, 10012, activity.getString(R.string.aliuser_SNS_platform_auth_not_init_ucc));
        }
    }
}
