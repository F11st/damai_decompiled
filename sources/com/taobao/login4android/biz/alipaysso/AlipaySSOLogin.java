package com.taobao.login4android.biz.alipaysso;

import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.base.helper.BroadCastHelper;
import com.ali.user.mobile.base.helper.LoginDataHelper;
import com.ali.user.mobile.base.helper.LoginResultHelper;
import com.ali.user.mobile.callback.DataCallback;
import com.ali.user.mobile.common.api.LoginApprearanceExtensions;
import com.ali.user.mobile.log.LongLifeCycleUserTrack;
import com.ali.user.mobile.log.TLogAdapter;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.login.service.impl.UserLoginServiceImpl;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.model.LoginType;
import com.ali.user.mobile.model.TokenType;
import com.ali.user.mobile.rpc.ApiConstants;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.rpc.login.model.LoginReturnData;
import com.taobao.login4android.constants.LoginConstants;
import com.taobao.login4android.constants.LoginStatus;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class AlipaySSOLogin {
    public static final String TAG = "Login.AlipaySSOLogin";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class a implements DataCallback<Boolean> {
        final /* synthetic */ Map a;
        final /* synthetic */ String b;
        final /* synthetic */ LoginParam c;

        a(Map map, String str, LoginParam loginParam) {
            this.a = map;
            this.b = str;
            this.c = loginParam;
        }

        @Override // com.ali.user.mobile.callback.DataCallback
        /* renamed from: a */
        public void result(Boolean bool) {
            if (bool != null && bool.booleanValue()) {
                Map map = this.a;
                if (map != null) {
                    map.remove(AlipayConstant.LOGIN_ALIPAY_ACCOUNT_CHECK_KEY);
                    this.a.remove(AlipayConstant.LOGIN_ALIPAY_HAVANA_ID_KEY);
                }
                AlipaySSOLogin.alipayLogin(this.b, this.a, this.c);
                return;
            }
            BroadCastHelper.sendLoginFailBroadcast(712, "");
        }
    }

    public static void alipayLogin(String str, Map<String, Object> map, LoginParam loginParam) {
        try {
            alipayLoginData(str, map, UserLoginServiceImpl.getInstance().loginByAlipaySSOToken(str, map, loginParam), loginParam);
        } catch (Throwable th) {
            BroadCastHelper.sendLoginFailBroadcast(712, "");
            LoginStatus.resetLoginFlag();
            th.printStackTrace();
        }
    }

    private static void alipayLoginData(String str, Map<String, Object> map, RpcResponse<LoginReturnData> rpcResponse, LoginParam loginParam) {
        String str2;
        String str3;
        LoginReturnData loginReturnData;
        if (rpcResponse != null && rpcResponse.returnValue != null && rpcResponse.code == 3000) {
            onReceiveSuccess(rpcResponse, loginParam);
            LongLifeCycleUserTrack.sendUT("Alipay_AuthCode_Login_SUCCESS");
        } else if (rpcResponse != null && "H5".equals(rpcResponse.actionType) && (loginReturnData = rpcResponse.returnValue) != null) {
            LoginReturnData loginReturnData2 = loginReturnData;
            LoginParam loginParam2 = new LoginParam();
            if (loginParam != null) {
                loginParam2.traceId = loginParam.traceId;
                loginParam2.loginSourcePage = loginParam.loginSourcePage;
                loginParam2.loginSourceSpm = loginParam.loginSourceSpm;
                loginParam2.loginSourceType = loginParam.loginSourceType;
            }
            loginParam2.tokenType = TokenType.ALIPAY_SSO;
            if (!DataProviderFactory.getDataProvider().isTaobaoApp()) {
                loginParam2.sendLoginFailWhenWebviewCancel = true;
            }
            LoginResultHelper.gotoH5PlaceHolder(DataProviderFactory.getApplicationContext(), loginReturnData2, loginParam2);
        } else if (rpcResponse != null && ApiConstants.ResultActionType.ALERT.equals(rpcResponse.actionType) && rpcResponse.code == 14077) {
            if (LoginApprearanceExtensions.AsoLoginFlow.getAsoLoginCallback() != null) {
                LoginApprearanceExtensions.AsoLoginFlow.getAsoLoginCallback().onNeedSwitch(rpcResponse.message, new a(map, str, loginParam));
            }
            LoginStatus.resetLoginFlag();
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("alipayLoginFail : code!= 3000 && actionType!= h5");
            if (rpcResponse != null) {
                str2 = rpcResponse.code + "," + rpcResponse.message;
            } else {
                str2 = "";
            }
            sb.append(str2);
            TLogAdapter.e(TAG, sb.toString());
            BroadCastHelper.sendLoginFailBroadcast(712, "");
            LoginStatus.resetLoginFlag();
            if (loginParam != null) {
                if (rpcResponse == null) {
                    str3 = "-1";
                } else {
                    str3 = rpcResponse.code + "";
                }
                Properties properties = new Properties();
                properties.setProperty("sdkTraceId", loginParam.traceId + "");
                properties.setProperty("continueLogin", UTConstant.Args.UT_SUCCESS_F);
                properties.setProperty("site", loginParam.loginSite + "");
                UserTrackAdapter.sendUT(loginParam.loginSourcePage, UTConstant.CustomEvent.UT_LOGIN_FAIL, str3, LoginType.LocalLoginType.ALIPAY_TRUST_LOGIN, properties);
                Properties properties2 = new Properties();
                properties2.setProperty("monitor", "T");
                properties2.setProperty("site", loginParam.loginSite + "");
                UserTrackAdapter.sendUT(loginParam.loginSourcePage, UTConstant.CustomEvent.UT_SINGLE_LOGIN_FAILURE, str3, LoginType.LocalLoginType.ALIPAY_TRUST_LOGIN, properties2);
            }
        }
    }

    private static void onReceiveSuccess(RpcResponse<LoginReturnData> rpcResponse, LoginParam loginParam) {
        if (loginParam != null) {
            Properties properties = new Properties();
            properties.setProperty("sdkTraceId", loginParam.traceId + "");
            properties.setProperty("continueLogin", UTConstant.Args.UT_SUCCESS_F);
            properties.setProperty("loginId", loginParam.loginAccount + "");
            properties.setProperty("site", loginParam.loginSite + "");
            UserTrackAdapter.sendUT(loginParam.loginSourcePage, UTConstant.CustomEvent.UT_LOGIN_SUCCESS, "", LoginType.LocalLoginType.ALIPAY_TRUST_LOGIN, properties);
            Properties properties2 = new Properties();
            properties2.setProperty("sdkTraceId", loginParam.traceId + "");
            properties2.setProperty("monitor", "T");
            properties2.setProperty("site", DataProviderFactory.getDataProvider().getSite() + "");
            properties2.setProperty("loginId", loginParam.loginAccount + "");
            UserTrackAdapter.sendUT(loginParam.loginSourcePage, UTConstant.CustomEvent.UT_SINGLE_LOGIN_SUCCESS, "", LoginType.LocalLoginType.ALIPAY_TRUST_LOGIN, properties2);
        }
        HashMap hashMap = new HashMap();
        hashMap.put(LoginConstants.LOGIN_TYPE, LoginType.LocalLoginType.ASO_LOGIN);
        LoginDataHelper.processLoginReturnData(true, rpcResponse.returnValue, (Map<String, String>) hashMap);
    }
}
