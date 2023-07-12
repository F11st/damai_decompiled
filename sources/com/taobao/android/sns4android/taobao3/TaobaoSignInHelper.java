package com.taobao.android.sns4android.taobao3;

import android.app.Activity;
import android.text.TextUtils;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.base.helper.BroadCastHelper;
import com.ali.user.mobile.base.helper.LoginDataHelper;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.model.LoginType;
import com.ali.user.mobile.model.SNSSignInAccount;
import com.ali.user.mobile.rpc.login.model.LoginReturnData;
import com.ali.user.open.callback.LoginCallback;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.util.ParamsConstants;
import com.ali.user.open.session.Session;
import com.ali.user.open.tbauth.TbAuthService;
import com.ali.user.open.ucc.UccCallback;
import com.ali.user.open.ucc.UccService;
import com.ali.user.open.ucc.util.UccConstants;
import com.alibaba.fastjson.JSON;
import com.taobao.android.sns4android.R;
import com.taobao.android.sns4android.SNSSignInAbstractHelper;
import com.taobao.android.sns4android.SNSSignInListener;
import com.taobao.android.sns4android.util.UTConstans;
import com.taobao.login4android.constants.LoginConstants;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes11.dex */
public class TaobaoSignInHelper extends SNSSignInAbstractHelper {
    public static String SNS_TYPE = "taobao";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.taobao.android.sns4android.taobao3.TaobaoSignInHelper$a */
    /* loaded from: classes11.dex */
    public class C6623a implements LoginCallback {
        final /* synthetic */ Activity a;

        C6623a(Activity activity) {
            this.a = activity;
        }

        @Override // com.ali.user.open.core.callback.FailureCallback
        public void onFailure(int i, String str) {
            TaobaoSignInHelper.this.resultUT(UTConstans.PageName.UT_PAGE_EXTENT_TAOBAO3, UTConstant.Args.UT_SUCCESS_F);
            SNSSignInListener sNSSignInListener = TaobaoSignInHelper.this.snsSignInListener;
            if (sNSSignInListener != null) {
                if (i != 10003 && i != 10004) {
                    sNSSignInListener.onError(this.a, TaobaoSignInHelper.SNS_TYPE, i, DataProviderFactory.getApplicationContext().getString(R.string.aliuser_SNS_platform_auth_fail));
                } else {
                    sNSSignInListener.onCancel(this.a, TaobaoSignInHelper.SNS_TYPE);
                }
            }
        }

        @Override // com.ali.user.open.callback.LoginCallback
        public void onSuccess(Session session) {
            TaobaoSignInHelper.this.resultUT(UTConstans.PageName.UT_PAGE_EXTENT_TAOBAO3, "T");
            if (TaobaoSignInHelper.this.snsSignInListener == null || session == null) {
                return;
            }
            SNSSignInAccount sNSSignInAccount = new SNSSignInAccount();
            sNSSignInAccount.token = session.topAuthCode;
            sNSSignInAccount.snsType = TaobaoSignInHelper.SNS_TYPE;
            TaobaoSignInHelper.this.snsSignInListener.onSucceed(this.a, sNSSignInAccount);
        }
    }

    /* renamed from: com.taobao.android.sns4android.taobao3.TaobaoSignInHelper$b */
    /* loaded from: classes11.dex */
    class C6624b implements LoginCallback {
        final /* synthetic */ SNSSignInListener a;
        final /* synthetic */ Activity b;

        C6624b(SNSSignInListener sNSSignInListener, Activity activity) {
            this.a = sNSSignInListener;
            this.b = activity;
        }

        @Override // com.ali.user.open.core.callback.FailureCallback
        public void onFailure(int i, String str) {
            TaobaoSignInHelper.this.resultUT(UTConstans.PageName.UT_PAGE_EXTENT_TAOBAO3, UTConstant.Args.UT_SUCCESS_F);
            SNSSignInListener sNSSignInListener = this.a;
            if (sNSSignInListener != null) {
                if (i != 10003 && i != 10004) {
                    sNSSignInListener.onError(this.b, TaobaoSignInHelper.SNS_TYPE, i, DataProviderFactory.getApplicationContext().getString(R.string.aliuser_SNS_platform_auth_fail));
                } else {
                    sNSSignInListener.onCancel(this.b, TaobaoSignInHelper.SNS_TYPE);
                }
            }
        }

        @Override // com.ali.user.open.callback.LoginCallback
        public void onSuccess(Session session) {
            TaobaoSignInHelper.this.resultUT(UTConstans.PageName.UT_PAGE_EXTENT_TAOBAO3, "T");
            if (this.a == null || session == null) {
                return;
            }
            SNSSignInAccount sNSSignInAccount = new SNSSignInAccount();
            sNSSignInAccount.token = session.topAuthCode;
            sNSSignInAccount.snsType = TaobaoSignInHelper.SNS_TYPE;
            this.a.onSucceed(this.b, sNSSignInAccount);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.taobao.android.sns4android.taobao3.TaobaoSignInHelper$c */
    /* loaded from: classes11.dex */
    public class C6625c implements UccCallback {
        C6625c(TaobaoSignInHelper taobaoSignInHelper) {
        }

        @Override // com.ali.user.open.ucc.UccCallback
        public void onFail(String str, int i, String str2) {
            if (i != 10003 && i != 10004 && i != 15) {
                BroadCastHelper.sendLoginFailBroadcast(i, str2);
            } else {
                BroadCastHelper.sendLoginFailBroadcast(701, "user cancel");
            }
        }

        @Override // com.ali.user.open.ucc.UccCallback
        public void onSuccess(String str, Map map) {
            if (map != null) {
                String str2 = (String) map.get(UccConstants.PARAM_LOGIN_DATA);
                if (!TextUtils.isEmpty(str2)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(LoginConstants.LOGIN_TYPE, LoginType.ServerLoginType.TaobaoSSOLogin.getType());
                    LoginDataHelper.processLoginReturnData(true, (LoginReturnData) JSON.parseObject(str2, LoginReturnData.class), (Map<String, String>) hashMap);
                    return;
                }
                BroadCastHelper.sendLoginFailBroadcast(702, "");
                return;
            }
            BroadCastHelper.sendLoginFailBroadcast(702, "");
        }
    }

    private void auth(Activity activity, Map<String, String> map) {
        UserTrackAdapter.sendControlUT(UTConstans.PageName.UT_PAGE_EXTENT_TAOBAO3, "Btn_Login");
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(ParamsConstants.Key.PARAM_ONLY_AUTHCODE, "1");
        ((TbAuthService) AliMemberSDK.getService(TbAuthService.class)).auth(map, new C6623a(activity));
    }

    public static TaobaoSignInHelper create() {
        return new TaobaoSignInHelper();
    }

    @Override // com.taobao.android.sns4android.SNSSignInAbstractHelper
    public void signIn(Activity activity) {
        auth(activity, new HashMap());
    }

    public void uccOAuthLogin(Activity activity) {
        ((UccService) AliMemberSDK.getService(UccService.class)).uccOAuthLogin(activity, "taobao", null, new C6625c(this));
    }

    @Override // com.taobao.android.sns4android.SNSSignInAbstractHelper
    public void signIn(Activity activity, Map<String, String> map) {
        auth(activity, map);
    }

    @Override // com.taobao.android.sns4android.SNSSignInAbstractHelper
    public void auth(Activity activity, SNSSignInListener sNSSignInListener) {
        UserTrackAdapter.sendControlUT(UTConstans.PageName.UT_PAGE_EXTENT_TAOBAO3, "Btn_Login");
        HashMap hashMap = new HashMap();
        hashMap.put(ParamsConstants.Key.PARAM_ONLY_AUTHCODE, "1");
        ((TbAuthService) AliMemberSDK.getService(TbAuthService.class)).auth(hashMap, new C6624b(sNSSignInListener, activity));
    }
}
