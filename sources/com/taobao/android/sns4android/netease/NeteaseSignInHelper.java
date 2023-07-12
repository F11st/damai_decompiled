package com.taobao.android.sns4android.netease;

import android.app.Activity;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.model.SNSSignInAccount;
import com.ali.user.mobile.utils.NetworkUtil;
import com.taobao.android.sns4android.R;
import com.taobao.android.sns4android.SNSSignInAbstractHelper;
import com.taobao.android.sns4android.SNSSignInListener;
import com.taobao.android.sns4android.util.UTConstans;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class NeteaseSignInHelper extends SNSSignInAbstractHelper {
    public static final String SNS_TYPE = "wangyi_mail";
    private static final String TAG = "login.netease";
    private static String mAppId;
    private static String mRedirectUrl;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class a implements SNSSignInListener {
        final /* synthetic */ Activity a;

        a(Activity activity) {
            this.a = activity;
        }

        @Override // com.taobao.android.sns4android.SNSSignInListener
        public void onCancel(Activity activity, String str) {
            SNSSignInListener sNSSignInListener = NeteaseSignInHelper.this.snsSignInListener;
            if (sNSSignInListener != null) {
                sNSSignInListener.onCancel(this.a, NeteaseSignInHelper.SNS_TYPE);
            }
        }

        @Override // com.taobao.android.sns4android.SNSSignInListener
        public void onError(Activity activity, String str, int i, String str2) {
            SNSSignInListener sNSSignInListener = NeteaseSignInHelper.this.snsSignInListener;
            if (sNSSignInListener != null) {
                sNSSignInListener.onError(this.a, NeteaseSignInHelper.SNS_TYPE, i, str2);
            }
        }

        @Override // com.taobao.android.sns4android.SNSSignInListener
        public void onSucceed(Activity activity, SNSSignInAccount sNSSignInAccount) {
            if (NeteaseSignInHelper.this.snsSignInListener != null) {
                SNSSignInAccount sNSSignInAccount2 = new SNSSignInAccount();
                sNSSignInAccount2.token = sNSSignInAccount.token;
                sNSSignInAccount2.snsType = NeteaseSignInHelper.SNS_TYPE;
                NeteaseSignInHelper.this.snsSignInListener.onSucceed(this.a, sNSSignInAccount2);
            }
        }
    }

    private NeteaseSignInHelper() {
    }

    public static NeteaseSignInHelper create(String str, String str2) {
        mAppId = str;
        mRedirectUrl = str2;
        return new NeteaseSignInHelper();
    }

    @Override // com.taobao.android.sns4android.SNSSignInAbstractHelper
    public void signIn(Activity activity) {
        UserTrackAdapter.sendControlUT(UTConstans.PageName.UT_PAGE_EXTENT_QQ, "Btn_Login");
        if (!NetworkUtil.isNetworkConnected()) {
            SNSSignInListener sNSSignInListener = this.snsSignInListener;
            if (sNSSignInListener != null) {
                sNSSignInListener.onError(activity, SNS_TYPE, -1, DataProviderFactory.getApplicationContext().getString(R.string.aliuser_network_error));
                return;
            }
            return;
        }
        try {
            NeteaseAuth.auth(mAppId, mRedirectUrl, new a(activity));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
