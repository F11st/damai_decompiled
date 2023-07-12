package com.taobao.login4android.biz.unifysso;

import android.text.TextUtils;
import com.ali.user.mobile.app.LoginContext;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.base.helper.BroadCastHelper;
import com.ali.user.mobile.base.helper.LoginDataHelper;
import com.ali.user.mobile.base.helper.LoginResultHelper;
import com.ali.user.mobile.common.api.AliUserLogin;
import com.ali.user.mobile.common.api.OnLoginCaller;
import com.ali.user.mobile.log.TLogAdapter;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.login.service.impl.UserLoginServiceImpl;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.model.LoginType;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.rpc.login.model.LoginReturnData;
import com.ali.user.mobile.utils.BackgroundExecutor;
import com.ali.user.mobile.utils.MainThreadExecutor;
import com.taobao.login4android.constants.LoginConstants;
import com.taobao.login4android.constants.LoginStatus;
import com.taobao.login4android.session.ISession;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class UnifySsoLogin {
    public static final String TAG = "Login.UnifySsoLogin";

    public static void tokenLogin(int i, String str, ISession iSession) {
        tokenLogin(i, str, false, iSession);
    }

    public static void tokenLogin(final int i, String str, final boolean z, ISession iSession) {
        String str2;
        final LoginParam loginParam = new LoginParam();
        loginParam.token = str;
        loginParam.loginSite = i;
        LoginParam loginParam2 = LoginContext.sCurrentLoginParam;
        if (loginParam2 != null && TextUtils.equals(loginParam2.loginSourceType, LoginType.LocalLoginType.SCAN_FACE_LOGIN)) {
            Properties properties = new Properties();
            if (LoginContext.sCurrentLoginParam != null) {
                properties.setProperty("sdkTraceId", LoginContext.sCurrentLoginParam.traceId + "");
                str2 = LoginContext.sCurrentLoginParam.loginSourcePage;
            } else {
                str2 = UTConstant.PageName.UT_PAGE_EXTEND;
            }
            properties.setProperty("monitor", "T");
            properties.setProperty("site", DataProviderFactory.getDataProvider().getSite() + "");
            UserTrackAdapter.sendUT(str2, UTConstant.CustomEvent.UT_SINGLE_LOGIN_COMMIT, "", LoginType.LocalLoginType.SCAN_FACE_LOGIN, properties);
        }
        BackgroundExecutor.execute(new Runnable() { // from class: com.taobao.login4android.biz.unifysso.UnifySsoLogin.1
            @Override // java.lang.Runnable
            public void run() {
                final RpcResponse rpcResponse;
                try {
                    rpcResponse = UserLoginServiceImpl.getInstance().unifySsoTokenLogin(LoginParam.this);
                } catch (Throwable th) {
                    th.printStackTrace();
                    rpcResponse = null;
                }
                MainThreadExecutor.execute(new Runnable() { // from class: com.taobao.login4android.biz.unifysso.UnifySsoLogin.1.1
                    private void loginFailHit() {
                        LoginParam loginParam3 = LoginContext.sCurrentLoginParam;
                        if (loginParam3 == null || !TextUtils.equals(loginParam3.loginSourceType, LoginType.LocalLoginType.SCAN_FACE_LOGIN)) {
                            return;
                        }
                        Properties properties2 = new Properties();
                        RpcResponse rpcResponse2 = rpcResponse;
                        String valueOf = rpcResponse2 != null ? String.valueOf(rpcResponse2.code) : UTConstant.CustomEvent.UT_NETWORK_FAIL;
                        properties2.setProperty(UTConstant.Args.UT_PROPERTY_SUCCESS, UTConstant.Args.UT_SUCCESS_F);
                        properties2.setProperty("sdkTraceId", LoginContext.sCurrentLoginParam.traceId + "");
                        properties2.setProperty("loginId", LoginContext.sCurrentLoginParam.loginAccount + "");
                        properties2.setProperty("site", LoginContext.sCurrentLoginParam.loginSite + "");
                        UserTrackAdapter.sendUT(LoginContext.sCurrentLoginParam.loginSourcePage, UTConstant.CustomEvent.UT_LOGIN_FAIL, valueOf, LoginType.LocalLoginType.SCAN_FACE_LOGIN, properties2);
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        String str3;
                        T t;
                        try {
                            RpcResponse rpcResponse2 = rpcResponse;
                            if (rpcResponse2 != null && rpcResponse2.returnValue != 0 && rpcResponse2.code == 3000) {
                                LoginParam loginParam3 = LoginContext.sCurrentLoginParam;
                                if (loginParam3 != null && TextUtils.equals(loginParam3.loginSourceType, LoginType.LocalLoginType.SCAN_FACE_LOGIN)) {
                                    Properties properties2 = new Properties();
                                    properties2.setProperty("sdkTraceId", LoginContext.sCurrentLoginParam.traceId + "");
                                    properties2.setProperty("loginId", LoginContext.sCurrentLoginParam.loginAccount + "");
                                    properties2.setProperty("site", i + "");
                                    UserTrackAdapter.sendUT(LoginContext.sCurrentLoginParam.loginSourcePage, UTConstant.CustomEvent.UT_LOGIN_SUCCESS, "", LoginType.LocalLoginType.SCAN_FACE_LOGIN, properties2);
                                    Properties properties3 = new Properties();
                                    properties3.setProperty("sdkTraceId", LoginContext.sCurrentLoginParam.traceId + "");
                                    properties3.setProperty("monitor", "T");
                                    properties3.setProperty("site", DataProviderFactory.getDataProvider().getSite() + "");
                                    UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, UTConstant.CustomEvent.UT_SINGLE_LOGIN_SUCCESS, "", LoginType.LocalLoginType.SCAN_FACE_LOGIN, properties3);
                                }
                                OnLoginCaller onLoginCaller = AliUserLogin.mLoginCaller;
                                if (onLoginCaller != null) {
                                    onLoginCaller.filterLogin(rpcResponse);
                                    return;
                                }
                                HashMap hashMap = new HashMap();
                                hashMap.put(LoginConstants.LOGIN_TYPE, LoginType.ServerLoginType.UnifySsoLogin.getType());
                                LoginDataHelper.processLoginReturnData(true, (LoginReturnData) rpcResponse.returnValue, (Map<String, String>) hashMap);
                            } else if (rpcResponse2 != null && "H5".equals(rpcResponse2.actionType) && (t = rpcResponse.returnValue) != 0 && ((LoginReturnData) t).token != null) {
                                if (z) {
                                    LoginStatus.resetLoginFlag();
                                    return;
                                }
                                loginFailHit();
                                LoginResultHelper.gotoH5PlaceHolder(DataProviderFactory.getApplicationContext(), (LoginReturnData) rpcResponse.returnValue, LoginContext.sCurrentLoginParam);
                            } else if (z) {
                                LoginStatus.resetLoginFlag();
                            } else {
                                LoginParam loginParam4 = LoginContext.sCurrentLoginParam;
                                if (loginParam4 != null && TextUtils.equals(loginParam4.loginSourceType, LoginType.LocalLoginType.SCAN_FACE_LOGIN)) {
                                    loginFailHit();
                                    String str4 = UTConstant.CustomEvent.UT_NETWORK_FAIL;
                                    RpcResponse rpcResponse3 = rpcResponse;
                                    if (rpcResponse3 != null) {
                                        str4 = String.valueOf(rpcResponse3.code);
                                    }
                                    Properties properties4 = new Properties();
                                    properties4.setProperty("monitor", "T");
                                    properties4.setProperty("site", DataProviderFactory.getDataProvider().getSite() + "");
                                    properties4.setProperty("loginId", LoginContext.sCurrentLoginParam.loginAccount + "");
                                    properties4.setProperty("site", LoginContext.sCurrentLoginParam.loginSite + "");
                                    UserTrackAdapter.sendUT(LoginContext.sCurrentLoginParam.loginSourcePage, UTConstant.CustomEvent.UT_SINGLE_LOGIN_FAILURE, str4, LoginType.LocalLoginType.SCAN_FACE_LOGIN, properties4);
                                }
                                StringBuilder sb = new StringBuilder();
                                sb.append("unifySsoLoginFail : code!= 3000 && actionType!= h5");
                                if (rpcResponse != null) {
                                    str3 = rpcResponse.code + "," + rpcResponse.message;
                                } else {
                                    str3 = "";
                                }
                                sb.append(str3);
                                TLogAdapter.e(UnifySsoLogin.TAG, sb.toString());
                                LoginStatus.resetLoginFlag();
                                BroadCastHelper.sendLoginFailBroadcast(714, "");
                            }
                        } catch (Throwable unused) {
                            LoginStatus.resetLoginFlag();
                            if (z) {
                                return;
                            }
                            BroadCastHelper.sendLoginFailBroadcast(714, "");
                        }
                    }
                });
            }
        });
    }
}
