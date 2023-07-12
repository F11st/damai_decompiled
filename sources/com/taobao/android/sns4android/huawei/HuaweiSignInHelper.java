package com.taobao.android.sns4android.huawei;

import android.app.Activity;
import com.ali.user.mobile.callback.CommonDataCallback;
import com.ali.user.mobile.model.SNSSignInAccount;
import com.ali.user.mobile.service.HuaweiService;
import com.ali.user.mobile.service.ServiceFactory;
import com.taobao.android.sns4android.R;
import com.taobao.android.sns4android.SNSSignInAbstractHelper;
import com.taobao.android.sns4android.SNSSignInListener;
import java.util.Map;
import mtopsdk.xstate.util.XStateConstants;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class HuaweiSignInHelper extends SNSSignInAbstractHelper {
    public static String TAG = "login.Huawei";
    public String SNS_TYPE = "huawei";

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.sns4android.huawei.HuaweiSignInHelper$a */
    /* loaded from: classes11.dex */
    class C6616a implements CommonDataCallback {
        final /* synthetic */ Activity a;

        C6616a(Activity activity) {
            this.a = activity;
        }

        @Override // com.ali.user.mobile.callback.CommonDataCallback
        public void onFail(int i, String str) {
            HuaweiSignInHelper huaweiSignInHelper = HuaweiSignInHelper.this;
            SNSSignInListener sNSSignInListener = huaweiSignInHelper.snsSignInListener;
            if (sNSSignInListener != null) {
                sNSSignInListener.onError(this.a, huaweiSignInHelper.SNS_TYPE, i, str);
            }
        }

        @Override // com.ali.user.mobile.callback.CommonDataCallback
        public void onSuccess(Map<String, String> map) {
            if (map != null) {
                SNSSignInAccount sNSSignInAccount = new SNSSignInAccount();
                sNSSignInAccount.snsType = HuaweiSignInHelper.this.SNS_TYPE;
                sNSSignInAccount.token = map.get(XStateConstants.KEY_ACCESS_TOKEN);
                SNSSignInListener sNSSignInListener = HuaweiSignInHelper.this.snsSignInListener;
                if (sNSSignInListener != null) {
                    sNSSignInListener.onSucceed(this.a, sNSSignInAccount);
                }
            }
        }
    }

    private HuaweiSignInHelper() {
        ServiceFactory.getService(HuaweiService.class);
    }

    public static HuaweiSignInHelper create() {
        return new HuaweiSignInHelper();
    }

    @Override // com.taobao.android.sns4android.SNSSignInAbstractHelper
    public void signIn(Activity activity) {
        if (ServiceFactory.getService(HuaweiService.class) != null) {
            ((HuaweiService) ServiceFactory.getService(HuaweiService.class)).launchAuth(activity, new C6616a(activity));
            return;
        }
        SNSSignInListener sNSSignInListener = this.snsSignInListener;
        if (sNSSignInListener != null) {
            sNSSignInListener.onError(activity, this.SNS_TYPE, 702, activity.getString(R.string.aliuser_network_error));
        }
    }
}
