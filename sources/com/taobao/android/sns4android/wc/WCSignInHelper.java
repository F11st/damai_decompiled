package com.taobao.android.sns4android.wc;

import android.app.Activity;
import android.text.TextUtils;
import cn.wh.auth.OnCallBack;
import com.ali.user.mobile.log.TLogAdapter;
import com.ali.user.mobile.model.SNSSignInAccount;
import com.alibaba.security.realidentity.C3839a;
import com.taobao.android.sns4android.SNSSignInAbstractHelper;
import com.taobao.android.sns4android.SNSSignInListener;
import tb.dz2;
import tb.ez2;
import tb.h32;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WCSignInHelper extends SNSSignInAbstractHelper {
    public static String TAG = "login.Huawei";
    private static String mAppId;
    private static String mOrgID;
    public String SNS_TYPE = "ctid";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.sns4android.wc.WCSignInHelper$a */
    /* loaded from: classes11.dex */
    public class C6628a implements OnCallBack {
        final /* synthetic */ SNSSignInListener a;
        final /* synthetic */ Activity b;

        C6628a(SNSSignInListener sNSSignInListener, Activity activity) {
            this.a = sNSSignInListener;
            this.b = activity;
        }

        @Override // cn.wh.auth.OnCallBack
        public void onResult(h32 h32Var) {
            if (h32Var != null && !TextUtils.isEmpty(h32Var.a())) {
                String a = h32Var.a();
                if (C3839a.q.equals(a)) {
                    String b = h32Var.b().b();
                    h32Var.b().a();
                    SNSSignInAccount sNSSignInAccount = new SNSSignInAccount();
                    sNSSignInAccount.snsType = WCSignInHelper.this.SNS_TYPE;
                    sNSSignInAccount.token = b;
                    this.a.onSucceed(this.b, sNSSignInAccount);
                    return;
                } else if (C3839a.s.equals(a)) {
                    this.a.onCancel(this.b, WCSignInHelper.this.SNS_TYPE);
                    return;
                } else {
                    WCSignInHelper.this.error(this.a, this.b, h32Var.a());
                    return;
                }
            }
            WCSignInHelper.this.error(this.a, this.b);
        }
    }

    public static WCSignInHelper create(String str, String str2) {
        mOrgID = str;
        mAppId = str2;
        return new WCSignInHelper();
    }

    @Override // com.taobao.android.sns4android.SNSSignInAbstractHelper
    public void auth(Activity activity, SNSSignInListener sNSSignInListener) {
        if (sNSSignInListener == null) {
            TLogAdapter.e(TAG, "empty listener");
            return;
        }
        try {
            new dz2(activity, new ez2(mOrgID, mAppId, "00520211229094537128225673984632", 0)).getAuthResult(new C6628a(sNSSignInListener, activity));
        } catch (Throwable th) {
            th.printStackTrace();
            error(sNSSignInListener, activity);
        }
    }

    protected void error(SNSSignInListener sNSSignInListener, Activity activity) {
        error(sNSSignInListener, activity, null);
    }

    @Override // com.taobao.android.sns4android.SNSSignInAbstractHelper
    public void signIn(Activity activity) {
        auth(activity, this.snsSignInListener);
    }

    protected void error(SNSSignInListener sNSSignInListener, Activity activity, String str) {
        String str2;
        if (sNSSignInListener != null) {
            if (TextUtils.isEmpty(str)) {
                str2 = "授权失败，请稍后重试";
            } else {
                str2 = "授权失败，请稍后重试:" + str;
            }
            sNSSignInListener.onError(activity, this.SNS_TYPE, 702, str2);
        }
    }
}
