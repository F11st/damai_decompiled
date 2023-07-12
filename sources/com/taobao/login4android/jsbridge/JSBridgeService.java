package com.taobao.login4android.jsbridge;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import android.taobao.windvane.webview.IWVWebView;
import android.text.TextUtils;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.base.UIBaseConstants;
import com.ali.user.mobile.base.ui.BaseActivity;
import com.ali.user.mobile.callback.CommonDataCallback;
import com.ali.user.mobile.callback.RpcRequestCallbackWithCode;
import com.ali.user.mobile.coordinator.CoordinatorWrapper;
import com.ali.user.mobile.info.AppInfo;
import com.ali.user.mobile.log.TLogAdapter;
import com.ali.user.mobile.login.LoginFrom;
import com.ali.user.mobile.login.service.impl.FingerprintLoginServiceImpl;
import com.ali.user.mobile.model.CommonCallback;
import com.ali.user.mobile.model.NumAuthTokenCallback;
import com.ali.user.mobile.model.RegistParam;
import com.ali.user.mobile.model.UrlParam;
import com.ali.user.mobile.rpc.ApiConstants;
import com.ali.user.mobile.rpc.HistoryAccount;
import com.ali.user.mobile.rpc.RpcRequest;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.rpc.login.model.WUAData;
import com.ali.user.mobile.security.AlibabaSecurityTokenService;
import com.ali.user.mobile.security.SSOSecurityService;
import com.ali.user.mobile.security.SecurityGuardManagerWraper;
import com.ali.user.mobile.service.NavigatorService;
import com.ali.user.mobile.service.NumberAuthService;
import com.ali.user.mobile.service.RpcService;
import com.ali.user.mobile.service.ServiceFactory;
import com.ali.user.mobile.service.UIService;
import com.alibaba.fastjson.JSON;
import com.alibaba.wireless.security.aopsdk.config.ConfigManager;
import com.taobao.login4android.Login;
import com.taobao.login4android.biz.getAlipayCookies.mtop.GetThirdCookiesResponseData;
import com.taobao.login4android.broadcast.LoginAction;
import com.taobao.login4android.broadcast.LoginBroadcastHelper;
import com.taobao.login4android.constants.LoginConstants;
import com.taobao.login4android.login.LoginController;
import com.taobao.weex.common.Constants;
import com.taomai.android.h5container.api.TMNavigationBarPlugin;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class JSBridgeService extends WVApiPlugin {
    private String Tag = "JSBridgeService";
    private Handler mHandler;
    private BroadcastReceiver mLoginReceiver;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.login4android.jsbridge.JSBridgeService$a */
    /* loaded from: classes11.dex */
    public class C6713a implements NumAuthTokenCallback {
        final /* synthetic */ WVCallBackContext a;

        C6713a(WVCallBackContext wVCallBackContext) {
            this.a = wVCallBackContext;
        }

        @Override // com.ali.user.mobile.model.NumAuthTokenCallback
        public void onGetAuthTokenFail(int i, String str) {
            JSBridgeService.this.failCallback(this.a, str, String.valueOf(i));
        }

        @Override // com.ali.user.mobile.model.NumAuthTokenCallback
        public void onGetAuthTokenSuccess(String str) {
            WVResult wVResult = new WVResult();
            wVResult.addData("token", str);
            this.a.success(wVResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.login4android.jsbridge.JSBridgeService$b */
    /* loaded from: classes11.dex */
    public class C6714b implements CommonDataCallback {
        final /* synthetic */ WVCallBackContext a;

        C6714b(WVCallBackContext wVCallBackContext) {
            this.a = wVCallBackContext;
        }

        @Override // com.ali.user.mobile.callback.CommonDataCallback
        public void onFail(int i, String str) {
            JSBridgeService.this.failCallback(this.a, str, String.valueOf(i));
        }

        @Override // com.ali.user.mobile.callback.CommonDataCallback
        public void onSuccess(Map<String, String> map) {
            if (map != null) {
                this.a.success(JSON.toJSONString(map));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.login4android.jsbridge.JSBridgeService$c */
    /* loaded from: classes11.dex */
    public class C6715c implements CommonCallback {
        final /* synthetic */ WVCallBackContext a;

        C6715c(JSBridgeService jSBridgeService, WVCallBackContext wVCallBackContext) {
            this.a = wVCallBackContext;
        }

        @Override // com.ali.user.mobile.model.CommonCallback
        public void onFail(int i, String str) {
            WVResult wVResult = new WVResult();
            wVResult.addData("code", Integer.valueOf(i));
            wVResult.addData("msg", str);
            this.a.error(wVResult);
        }

        @Override // com.ali.user.mobile.model.CommonCallback
        public void onSuccess() {
            this.a.success();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.login4android.jsbridge.JSBridgeService$d */
    /* loaded from: classes11.dex */
    public class C6716d implements RpcRequestCallbackWithCode {
        final /* synthetic */ WVCallBackContext a;

        /* compiled from: Taobao */
        /* renamed from: com.taobao.login4android.jsbridge.JSBridgeService$d$a */
        /* loaded from: classes11.dex */
        class AsyncTaskC6717a extends AsyncTask<Object, Void, RpcResponse> {
            final /* synthetic */ String[] a;

            AsyncTaskC6717a(String[] strArr) {
                this.a = strArr;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* renamed from: a */
            public RpcResponse doInBackground(Object... objArr) {
                Login.session.injectExternalCookies(this.a);
                return null;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* renamed from: b */
            public void onPostExecute(RpcResponse rpcResponse) {
                WVResult wVResult = new WVResult();
                wVResult.setResult(WVResult.SUCCESS);
                C6716d.this.a.success(wVResult);
            }
        }

        C6716d(WVCallBackContext wVCallBackContext) {
            this.a = wVCallBackContext;
        }

        @Override // com.ali.user.mobile.callback.RpcRequestCallbackWithCode
        public void onError(String str, RpcResponse rpcResponse) {
            JSBridgeService.this.failCallback(this.a, str, rpcResponse != null ? String.valueOf(rpcResponse.code) : "-1");
        }

        @Override // com.ali.user.mobile.callback.RpcRequestCallbackWithCode
        public void onSuccess(RpcResponse rpcResponse) {
            if (rpcResponse == null) {
                JSBridgeService.this.failCallback(this.a, "mtop response=null", "-1");
            } else if (!(rpcResponse instanceof GetThirdCookiesResponseData)) {
                JSBridgeService.this.failCallback(this.a, "mtop response=null", "-1");
            } else {
                String[] strArr = ((GetThirdCookiesResponseData) rpcResponse).returnValue;
                if (strArr == null || strArr.length <= 0) {
                    JSBridgeService.this.failCallback(this.a, "mtop response=null", "-1");
                } else {
                    new CoordinatorWrapper().execute(new AsyncTaskC6717a(strArr), new Object[0]);
                }
            }
        }

        @Override // com.ali.user.mobile.callback.RpcRequestCallbackWithCode
        public void onSystemError(String str, RpcResponse rpcResponse) {
            JSBridgeService.this.failCallback(this.a, str, "-1");
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.login4android.jsbridge.JSBridgeService$e */
    /* loaded from: classes11.dex */
    static /* synthetic */ class C6718e {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[LoginAction.values().length];
            a = iArr;
            try {
                iArr[LoginAction.NOTIFY_LOGIN_SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[LoginAction.NOTIFY_LOGIN_CANCEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[LoginAction.NOTIFY_REGISTER_CANCEL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private synchronized void checkLogin(WVCallBackContext wVCallBackContext, String str) {
        if (wVCallBackContext == null) {
            return;
        }
        if (Login.checkSessionValid()) {
            WVResult wVResult = new WVResult();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("isLogin", true);
            } catch (Exception unused) {
            }
            wVResult.setData(jSONObject);
            wVCallBackContext.success(wVResult);
        } else {
            WVResult wVResult2 = new WVResult();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("isLogin", false);
            } catch (Exception unused2) {
            }
            wVResult2.setData(jSONObject2);
            wVCallBackContext.success(wVResult2);
        }
    }

    private synchronized void closeNaviBar(WVCallBackContext wVCallBackContext, String str) {
        if (wVCallBackContext == null) {
            TLogAdapter.e(this.Tag, "Callback is null");
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                String str2 = (String) new JSONObject(str).get("hidden");
                if ("1".equals(str2)) {
                    ((UIService) ServiceFactory.getService(UIService.class)).setWebViewTitleBarVisibility(this.mContext, false);
                    wVCallBackContext.success();
                } else if ("0".equals(str2)) {
                    ((UIService) ServiceFactory.getService(UIService.class)).setWebViewTitleBarVisibility(this.mContext, true);
                    wVCallBackContext.success();
                } else {
                    setErrorCallback(wVCallBackContext);
                }
            } catch (Exception unused) {
                setErrorCallback(wVCallBackContext);
            }
        } else {
            setErrorCallback(wVCallBackContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doWhenReceiveSuccess(WVCallBackContext wVCallBackContext) {
        if (wVCallBackContext != null) {
            wVCallBackContext.success();
        }
        if (this.mLoginReceiver != null) {
            LoginBroadcastHelper.unregisterLoginReceiver(DataProviderFactory.getApplicationContext(), this.mLoginReceiver);
            this.mLoginReceiver = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doWhenReceivedCancel(WVCallBackContext wVCallBackContext) {
        if (wVCallBackContext != null) {
            wVCallBackContext.error();
        }
        if (this.mLoginReceiver != null) {
            LoginBroadcastHelper.unregisterLoginReceiver(DataProviderFactory.getApplicationContext(), this.mLoginReceiver);
            this.mLoginReceiver = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void failCallback(WVCallBackContext wVCallBackContext, String str, String str2) {
        WVResult wVResult = new WVResult();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("message", str);
            jSONObject.put("code", str2);
        } catch (Exception unused) {
        }
        wVResult.setData(jSONObject);
        wVResult.setResult("HY_FAILED");
        wVCallBackContext.error(wVResult);
    }

    private synchronized void getAtlasSign(WVCallBackContext wVCallBackContext, String str) {
        if (wVCallBackContext == null) {
            TLogAdapter.e(this.Tag, "Callback is null");
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                try {
                    String string = new JSONObject(str).getString("data");
                    if (!TextUtils.isEmpty(string) && string.length() < 64) {
                        SSOSecurityService.getInstace(DataProviderFactory.getApplicationContext());
                        String sign = SSOSecurityService.sign(DataProviderFactory.getDataProvider().getAppkey(), string);
                        if (!TextUtils.isEmpty(sign)) {
                            WVResult wVResult = new WVResult();
                            wVResult.setResult(WVResult.SUCCESS);
                            wVResult.addData("signedData", sign);
                            wVResult.addData("appKey", DataProviderFactory.getDataProvider().getAppkey());
                            wVCallBackContext.success(wVResult);
                            return;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        setErrorCallback(wVCallBackContext);
    }

    private synchronized void getLoginFrom(WVCallBackContext wVCallBackContext, String str) {
        if (wVCallBackContext == null) {
            TLogAdapter.e(this.Tag, "Callback is null");
            return;
        }
        try {
            String loginFrom = LoginFrom.getLoginFrom();
            WVResult wVResult = new WVResult();
            wVResult.setResult(WVResult.SUCCESS);
            wVResult.addData("loginEntrance", loginFrom);
            wVResult.addData("isLogin", Boolean.valueOf(Login.checkSessionValid()));
            wVResult.addData("hasLoginToken", Boolean.valueOf(!TextUtils.isEmpty(Login.getLoginToken())));
            if (!Login.checkSessionValid() && TextUtils.isEmpty(Login.getLoginToken())) {
                wVResult.addData("isNew", Boolean.TRUE);
            } else {
                wVResult.addData("isNew", Boolean.FALSE);
            }
            wVCallBackContext.success(wVResult);
        } catch (Exception unused) {
            setErrorCallback(wVCallBackContext);
        }
    }

    private synchronized void getSDKVersion(WVCallBackContext wVCallBackContext, String str) {
        if (wVCallBackContext == null) {
            TLogAdapter.e(this.Tag, "Callback is null");
            return;
        }
        try {
            WVResult wVResult = new WVResult();
            wVResult.setResult(WVResult.SUCCESS);
            wVResult.addData("sdkVersion", AppInfo.getInstance().getSdkVersion());
            wVCallBackContext.success(wVResult);
        } catch (Exception unused) {
            setErrorCallback(wVCallBackContext);
        }
    }

    private synchronized void getSign(WVCallBackContext wVCallBackContext, String str) {
        if (wVCallBackContext == null) {
            TLogAdapter.e(this.Tag, "Callback is null");
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                try {
                    String string = new JSONObject(str).getString("data");
                    String userId = Login.getUserId();
                    if (!TextUtils.isEmpty(userId) && !TextUtils.isEmpty(string) && string.length() < 128) {
                        HistoryAccount findHistoryAccount = SecurityGuardManagerWraper.findHistoryAccount(Long.parseLong(userId));
                        String sign = AlibabaSecurityTokenService.sign(findHistoryAccount.tokenKey, string);
                        if (!TextUtils.isEmpty(sign)) {
                            WVResult wVResult = new WVResult();
                            wVResult.setResult(WVResult.SUCCESS);
                            wVResult.addData("signedData", sign);
                            wVResult.addData("tokenKey", findHistoryAccount.tokenKey);
                            wVCallBackContext.success(wVResult);
                            return;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        setErrorCallback(wVCallBackContext);
    }

    private synchronized void getWuaData(WVCallBackContext wVCallBackContext, String str) {
        if (wVCallBackContext == null) {
            TLogAdapter.e(this.Tag, "Callback is null");
            return;
        }
        try {
            WUAData wua = SecurityGuardManagerWraper.getWUA();
            WVResult wVResult = new WVResult();
            wVResult.setResult(WVResult.SUCCESS);
            wVResult.addData("wua", JSON.toJSONString(wua));
            wVCallBackContext.success(wVResult);
        } catch (Exception unused) {
            setErrorCallback(wVCallBackContext);
        }
    }

    private synchronized void isBiometricsOpen(WVCallBackContext wVCallBackContext, String str) {
        if (wVCallBackContext == null) {
            TLogAdapter.e(this.Tag, "Callback is null");
            return;
        }
        WVResult wVResult = new WVResult();
        wVResult.setResult(WVResult.SUCCESS);
        wVResult.addData(ConfigManager.q, String.valueOf(FingerprintLoginServiceImpl.getInstance().isFingerprintLoginOpen()));
        wVCallBackContext.success(wVResult);
    }

    private synchronized void isBiometricsSupport(WVCallBackContext wVCallBackContext, String str) {
        if (wVCallBackContext == null) {
            TLogAdapter.e(this.Tag, "Callback is null");
            return;
        }
        WVResult wVResult = new WVResult();
        wVResult.setResult(WVResult.SUCCESS);
        wVResult.addData("supported", String.valueOf(FingerprintLoginServiceImpl.getInstance().isFingerprintLoginSetable()));
        wVCallBackContext.success(wVResult);
    }

    private synchronized void isMemberSDK(WVCallBackContext wVCallBackContext, String str) {
        if (wVCallBackContext == null) {
            TLogAdapter.e(this.Tag, "Callback is null");
            return;
        }
        if (((UIService) ServiceFactory.getService(UIService.class)).isWebViewActivity(this.mContext)) {
            WVResult wVResult = new WVResult();
            wVResult.setResult(WVResult.SUCCESS);
            wVCallBackContext.success(wVResult);
        } else {
            WVResult wVResult2 = new WVResult();
            wVResult2.setResult("HY_FAILED");
            wVCallBackContext.error(wVResult2);
        }
    }

    private synchronized void isOldLogin(WVCallBackContext wVCallBackContext) {
        if (TextUtils.isEmpty(Login.getOldUserId())) {
            wVCallBackContext.error();
        } else {
            wVCallBackContext.success();
        }
    }

    private synchronized void miniProgram(WVCallBackContext wVCallBackContext, String str) {
        if (wVCallBackContext == null) {
            TLogAdapter.e(this.Tag, "Callback is null");
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                LoginController.getInstance().navByScheme(jSONObject.getString("slaveAppKey"), jSONObject.getString("packageName"), jSONObject.getString("jumpPage"), null, new C6715c(this, wVCallBackContext));
            } catch (Exception e) {
                e.printStackTrace();
                setErrorCallback(wVCallBackContext);
            }
        } else {
            setErrorCallback(wVCallBackContext);
        }
    }

    private synchronized void mockLogin(WVCallBackContext wVCallBackContext, String str) {
        if (wVCallBackContext == null) {
            TLogAdapter.e(this.Tag, "Callback is null");
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                Bundle bundle = new Bundle();
                bundle.putBoolean("easylogin2", true);
                bundle.putString("username", (String) jSONObject.opt("username"));
                bundle.putString(Constants.Value.PASSWORD, (String) jSONObject.opt(Constants.Value.PASSWORD));
                Login.login(true, bundle);
            } catch (Exception e) {
                e.printStackTrace();
                setErrorCallback(wVCallBackContext);
            }
        } else {
            setErrorCallback(wVCallBackContext);
        }
    }

    private synchronized void refreshAlipayCookieWithRemoteBiz(WVCallBackContext wVCallBackContext, String str) {
        refreshThirdCookie(ApiConstants.ApiName.GET_ALIPAY_COOKIES, wVCallBackContext, str);
    }

    private synchronized void refreshThirdCookie(String str, WVCallBackContext wVCallBackContext, String str2) {
        if (wVCallBackContext == null) {
            TLogAdapter.e(this.Tag, "callback is null");
        } else if (TextUtils.isEmpty(str2)) {
            setErrorCallback(wVCallBackContext);
        } else {
            try {
                new JSONObject(str2);
                RpcRequest rpcRequest = new RpcRequest();
                rpcRequest.API_NAME = str;
                rpcRequest.VERSION = "1.0";
                rpcRequest.NEED_SESSION = true;
                rpcRequest.NEED_ECODE = true;
                rpcRequest.addParam("umidToken", AppInfo.getInstance().getUmidToken());
                rpcRequest.addParam("ext", str2);
                rpcRequest.requestSite = DataProviderFactory.getDataProvider().getSite();
                ((RpcService) ServiceFactory.getService(RpcService.class)).remoteBusiness(rpcRequest, GetThirdCookiesResponseData.class, new C6716d(wVCallBackContext));
            } catch (Exception e) {
                e.printStackTrace();
                setErrorCallback(wVCallBackContext);
            }
        }
    }

    private void registerBroadcast(final WVCallBackContext wVCallBackContext, boolean z) {
        this.mLoginReceiver = new BroadcastReceiver() { // from class: com.taobao.login4android.jsbridge.JSBridgeService.3
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                LoginAction valueOf;
                if (intent == null || (valueOf = LoginAction.valueOf(intent.getAction())) == null) {
                    return;
                }
                int i = C6718e.a[valueOf.ordinal()];
                if (i == 1) {
                    JSBridgeService.this.doWhenReceiveSuccess(wVCallBackContext);
                } else if (i == 2) {
                    JSBridgeService.this.doWhenReceivedCancel(wVCallBackContext);
                } else if (i != 3) {
                } else {
                    JSBridgeService.this.doWhenReceivedCancel(wVCallBackContext);
                }
            }
        };
        LoginBroadcastHelper.registerLoginReceiver(DataProviderFactory.getApplicationContext(), this.mLoginReceiver);
    }

    private void sdkLogin(WVCallBackContext wVCallBackContext, String str) {
        registerBroadcast(wVCallBackContext, false);
        Bundle bundle = new Bundle();
        bundle.putString(LoginConstants.BROWSER_REF_URL, "jsbridge.sdkLogin");
        try {
            JSONObject jSONObject = new JSONObject(str);
            bundle.putString("source", jSONObject.getString("source"));
            bundle.putString("loginUIType", jSONObject.optString("loginUIType"));
            bundle.putString(UIBaseConstants.LoginPage.PAGE_LOGIN_TYPE, jSONObject.optString(UIBaseConstants.LoginPage.PAGE_LOGIN_TYPE));
        } catch (Throwable th) {
            th.printStackTrace();
        }
        Login.login(true, bundle);
    }

    private void sdkLogout(WVCallBackContext wVCallBackContext, String str) {
        Login.logout();
        wVCallBackContext.success();
    }

    private void sdkRegister(WVCallBackContext wVCallBackContext) {
        registerBroadcast(wVCallBackContext, true);
        RegistParam registParam = new RegistParam();
        registParam.registSite = DataProviderFactory.getDataProvider().getSite();
        Login.goRegister(registParam);
    }

    private void setErrorCallback(WVCallBackContext wVCallBackContext) {
        WVResult wVResult = new WVResult();
        wVResult.setResult("HY_PARAM_ERR");
        wVCallBackContext.error(wVResult);
    }

    private synchronized void toggleBiometrics(WVCallBackContext wVCallBackContext, String str) {
        if (wVCallBackContext == null) {
            TLogAdapter.e(this.Tag, "Callback is null");
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            if ("1".equals((String) new JSONObject(str).get("action"))) {
                FingerprintLoginServiceImpl.getInstance().openFingerprintLoginSet();
            } else {
                FingerprintLoginServiceImpl.getInstance().closeFingerprintLoginSet();
            }
            WVResult wVResult = new WVResult();
            wVResult.setResult(WVResult.SUCCESS);
            wVCallBackContext.success(wVResult);
        } else {
            setErrorCallback(wVCallBackContext);
        }
    }

    public void afterCancelAccount(WVCallBackContext wVCallBackContext, String str) {
        if (wVCallBackContext == null) {
            TLogAdapter.e(this.Tag, "Callback is null");
        } else if (!TextUtils.isEmpty(str)) {
            try {
                String str2 = (String) new JSONObject(str).get("maskHid");
                if (TextUtils.isEmpty(str2)) {
                    wVCallBackContext.error();
                    return;
                }
                SecurityGuardManagerWraper.afterCancelAccount(str2);
                wVCallBackContext.success();
            } catch (Throwable th) {
                wVCallBackContext.error();
                th.printStackTrace();
            }
        } else {
            setErrorCallback(wVCallBackContext);
        }
    }

    public synchronized void closeWebViewByUrl(WVCallBackContext wVCallBackContext, String str) {
        if (wVCallBackContext == null) {
            TLogAdapter.e(this.Tag, "Callback is null");
            return;
        }
        if (!((UIService) ServiceFactory.getService(UIService.class)).finishWebViewActivity(this.mContext)) {
            setErrorCallback(wVCallBackContext);
        }
    }

    public void enableHookNativeBack(WVCallBackContext wVCallBackContext) {
        Message obtain = Message.obtain();
        obtain.what = BaseActivity.HOOK_NATIVE_BACK;
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.sendMessage(obtain);
        }
        wVCallBackContext.success();
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if ("getUserInfo".equals(str)) {
            getUserInfo(wVCallBackContext);
        } else if ("getUmid".equals(str)) {
            getUmid(wVCallBackContext, str2);
        } else if ("getWua".equals(str)) {
            getWuaData(wVCallBackContext, str2);
        } else if ("getAppKey".equals(str)) {
            getAppKey(wVCallBackContext, str2);
        } else if ("getSdkVersion".equals(str)) {
            getSDKVersion(wVCallBackContext, str2);
        } else if ("aluOpenWebViewByUrl".equals(str)) {
            openWebViewByUrl(wVCallBackContext, str2);
        } else if ("aluCloseWebView".equals(str)) {
            closeWebViewByUrl(wVCallBackContext, str2);
        } else if ("aluMockLogin".equals(str)) {
            mockLogin(wVCallBackContext, str2);
        } else if ("refreshAlipayCookie".equals(str)) {
            refreshAlipayCookieWithRemoteBiz(wVCallBackContext, str2);
        } else if ("userIsLogin".equals(str)) {
            checkLogin(wVCallBackContext, str2);
        } else if ("isOldLogin".equals(str)) {
            isOldLogin(wVCallBackContext);
        } else if ("setNaviBarHidden".equals(str)) {
            closeNaviBar(wVCallBackContext, str2);
        } else if ("isMemberSDK".equals(str)) {
            isMemberSDK(wVCallBackContext, str2);
        } else if ("aluGetSign".equals(str)) {
            getSign(wVCallBackContext, str2);
        } else if ("aluGetAtlasSign".equals(str)) {
            getAtlasSign(wVCallBackContext, str2);
        } else if ("miniProgram".equals(str)) {
            miniProgram(wVCallBackContext, str2);
        } else if ("sdkLogin".equals(str)) {
            sdkLogin(wVCallBackContext, str2);
        } else if ("sdkRegister".equals(str)) {
            sdkRegister(wVCallBackContext);
        } else if ("sdkLogout".equals(str)) {
            sdkLogout(wVCallBackContext, str2);
        } else if (TMNavigationBarPlugin.ACTION_ENABLE_HOOK_BACK.equals(str)) {
            enableHookNativeBack(wVCallBackContext);
            return true;
        } else if ("getInfoByNative".equals(str)) {
            getLoginFrom(wVCallBackContext, str2);
        } else if ("toggleBiometrics".equals(str)) {
            toggleBiometrics(wVCallBackContext, str2);
        } else if ("isBiometricsOpen".equals(str)) {
            isBiometricsOpen(wVCallBackContext, str2);
        } else if ("isBiometricsSupport".equals(str)) {
            isBiometricsSupport(wVCallBackContext, str2);
        } else if ("afterCancelAccount".equals(str)) {
            afterCancelAccount(wVCallBackContext, str2);
        } else if ("getLoginMaskPhone".equals(str)) {
            getLoginMaskPhone(wVCallBackContext, str2);
        } else if (!"getOneKeyToken".equals(str)) {
            return false;
        } else {
            getOneKeyToken(wVCallBackContext, str2);
        }
        return true;
    }

    public void getAppKey(WVCallBackContext wVCallBackContext, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            WVResult wVResult = new WVResult();
            wVResult.setResult(WVResult.SUCCESS);
            wVResult.addData("aluAppKey", DataProviderFactory.getDataProvider().getAppkey());
            wVCallBackContext.success(wVResult);
        } catch (Exception unused) {
            setErrorCallback(wVCallBackContext);
        }
    }

    public void getLoginMaskPhone(WVCallBackContext wVCallBackContext, String str) {
        if (wVCallBackContext == null) {
            TLogAdapter.e(this.Tag, "Callback is null");
        } else if (!TextUtils.isEmpty(str)) {
            try {
                Login.getLoginMaskPhone(new JSONObject(str).getInt("timeout"), new C6714b(wVCallBackContext));
            } catch (Throwable unused) {
                setErrorCallback(wVCallBackContext);
            }
        } else {
            setErrorCallback(wVCallBackContext);
        }
    }

    public void getOneKeyToken(WVCallBackContext wVCallBackContext, String str) {
        if (wVCallBackContext == null) {
            TLogAdapter.e(this.Tag, "Callback is null");
        } else if (!TextUtils.isEmpty(str)) {
            try {
                new JSONObject(str);
                if (ServiceFactory.getService(NumberAuthService.class) != null) {
                    ((NumberAuthService) ServiceFactory.getService(NumberAuthService.class)).getLoginToken("jsbridge", new C6713a(wVCallBackContext));
                } else {
                    failCallback(wVCallBackContext, "sdk not init or don't have auth service", "-199");
                }
            } catch (Throwable th) {
                th.printStackTrace();
                setErrorCallback(wVCallBackContext);
            }
        } else {
            setErrorCallback(wVCallBackContext);
        }
    }

    public void getUMID(WVCallBackContext wVCallBackContext, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            WVResult wVResult = new WVResult();
            wVResult.setResult(WVResult.SUCCESS);
            wVResult.addData("aluUmid", AppInfo.getInstance().getUmidToken());
            wVCallBackContext.success(wVResult);
        } catch (Exception unused) {
            setErrorCallback(wVCallBackContext);
        } catch (Throwable unused2) {
            setErrorCallback(wVCallBackContext);
        }
    }

    public synchronized void getUmid(WVCallBackContext wVCallBackContext, String str) {
        getUMID(wVCallBackContext, str);
    }

    public void getUserInfo(WVCallBackContext wVCallBackContext) {
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("nick", (Object) Login.getNick());
        jSONObject.put("userId", (Object) Login.getUserId());
        jSONObject.put("sid", (Object) Login.getSid());
        wVCallBackContext.success(jSONObject.toJSONString());
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public void initialize(Context context, IWVWebView iWVWebView) {
        super.initialize(context, iWVWebView);
        Context context2 = this.mContext;
        if (context2 instanceof BaseActivity) {
            this.mHandler = ((BaseActivity) context2).getHandler();
        }
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin, com.uc.webview.export.extension.IEmbedViewContainer.OnStateChangedListener
    public void onDestroy() {
        super.onDestroy();
        if (this.mLoginReceiver != null) {
            LoginBroadcastHelper.unregisterLoginReceiver(DataProviderFactory.getApplicationContext(), this.mLoginReceiver);
        }
    }

    public synchronized void openWebViewByUrl(WVCallBackContext wVCallBackContext, String str) {
        if (wVCallBackContext == null) {
            TLogAdapter.e(this.Tag, "Callback is null");
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                UrlParam urlParam = new UrlParam();
                urlParam.scene = "";
                urlParam.url = (String) new JSONObject(str).get("url");
                urlParam.site = DataProviderFactory.getDataProvider().getSite();
                ((NavigatorService) ServiceFactory.getService(NavigatorService.class)).openWebViewPage(this.mContext, urlParam);
                WVResult wVResult = new WVResult();
                wVResult.setResult("success !!!");
                wVCallBackContext.success(wVResult);
            } catch (Exception e) {
                e.printStackTrace();
                setErrorCallback(wVCallBackContext);
            }
        } else {
            setErrorCallback(wVCallBackContext);
        }
    }
}
