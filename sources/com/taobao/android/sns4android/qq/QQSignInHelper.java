package com.taobao.android.sns4android.qq;

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
public class QQSignInHelper extends SNSSignInAbstractHelper {
    public static String SNS_TYPE = LoginType.ServerLoginType.LoginTypeQQ.getType();
    private static final String TAG = "login.QQ";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.sns4android.qq.QQSignInHelper$a */
    /* loaded from: classes11.dex */
    public class C6622a implements OauthCallback {
        final /* synthetic */ SNSSignInListener a;
        final /* synthetic */ Activity b;

        C6622a(SNSSignInListener sNSSignInListener, Activity activity) {
            this.a = sNSSignInListener;
            this.b = activity;
        }

        @Override // com.ali.user.open.oauth.OauthCallback
        public void onFail(String str, int i, String str2) {
            QQSignInHelper.this.resultUT(UTConstans.PageName.UT_PAGE_EXTENT_QQ, UTConstant.Args.UT_SUCCESS_F);
            SNSSignInListener sNSSignInListener = this.a;
            if (sNSSignInListener != null) {
                if (i == 504) {
                    sNSSignInListener.onCancel(this.b, QQSignInHelper.SNS_TYPE);
                } else {
                    sNSSignInListener.onError(this.b, QQSignInHelper.SNS_TYPE, 702, DataProviderFactory.getApplicationContext().getString(R.string.aliuser_SNS_platform_auth_fail));
                }
            }
        }

        @Override // com.ali.user.open.oauth.OauthCallback
        public void onSuccess(String str, Map map) {
            QQSignInHelper.this.resultUT(UTConstans.PageName.UT_PAGE_EXTENT_QQ, "T");
            if (this.a != null) {
                SNSSignInAccount sNSSignInAccount = new SNSSignInAccount();
                sNSSignInAccount.token = (String) map.get(XStateConstants.KEY_ACCESS_TOKEN);
                sNSSignInAccount.userId = (String) map.get("openId");
                sNSSignInAccount.snsType = QQSignInHelper.SNS_TYPE;
                this.a.onSucceed(this.b, sNSSignInAccount);
            }
        }
    }

    private QQSignInHelper() {
    }

    public static QQSignInHelper create(String str, String str2) {
        try {
            AppCredential appCredential = new AppCredential();
            appCredential.appKey = str;
            appCredential.appSecret = str2;
            OauthPlatformConfig.setOauthConfig(Site.QQ, appCredential);
        } catch (Throwable unused) {
        }
        return new QQSignInHelper();
    }

    @Override // com.taobao.android.sns4android.SNSSignInAbstractHelper
    public void auth(Activity activity, SNSSignInListener sNSSignInListener) {
        UserTrackAdapter.sendControlUT(UTConstans.PageName.UT_PAGE_EXTENT_QQ, "Btn_Login");
        HashMap hashMap = new HashMap();
        hashMap.put(ParamsConstants.Key.PARAM_ONLY_AUTHCODE, "1");
        if (AliMemberSDK.getService(OauthService.class) != null) {
            ((OauthService) AliMemberSDK.getService(OauthService.class)).oauth(activity, Site.QQ, hashMap, new C6622a(sNSSignInListener, activity));
        } else if (sNSSignInListener != null) {
            sNSSignInListener.onError(activity, SNS_TYPE, 10012, activity.getString(R.string.aliuser_SNS_platform_auth_not_init_ucc));
        }
    }

    @Override // com.taobao.android.sns4android.SNSSignInAbstractHelper
    public void signIn(Activity activity) {
        auth(activity, this.snsSignInListener);
    }
}
