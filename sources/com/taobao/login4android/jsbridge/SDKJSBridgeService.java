package com.taobao.login4android.jsbridge;

import android.os.AsyncTask;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import android.text.TextUtils;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.app.init.Debuggable;
import com.ali.user.mobile.base.helper.LoginDataHelper;
import com.ali.user.mobile.common.api.AliUserLogin;
import com.ali.user.mobile.common.api.LoginApprearanceExtensions;
import com.ali.user.mobile.coordinator.CoordinatorWrapper;
import com.ali.user.mobile.log.TLogAdapter;
import com.ali.user.mobile.login.service.impl.UserLoginServiceImpl;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.rpc.login.model.LoginReturnData;
import com.ali.user.mobile.service.ServiceFactory;
import com.ali.user.mobile.service.UIService;
import com.ali.user.mobile.ui.WebConstant;
import com.alimm.xadsdk.base.expose.MonitorType;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class SDKJSBridgeService extends WVApiPlugin {
    private String Tag = "SDKJSBridgeService";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class a extends AsyncTask<Object, Void, RpcResponse<LoginReturnData>> {
        final /* synthetic */ String a;
        final /* synthetic */ WVCallBackContext b;

        a(String str, WVCallBackContext wVCallBackContext) {
            this.a = str;
            this.b = wVCallBackContext;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public RpcResponse<LoginReturnData> doInBackground(Object[] objArr) {
            LoginParam loginParam = new LoginParam();
            loginParam.token = this.a;
            loginParam.loginSite = DataProviderFactory.getDataProvider().getSite();
            try {
                return UserLoginServiceImpl.getInstance().unifySsoTokenLogin(loginParam);
            } catch (Exception unused) {
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(RpcResponse<LoginReturnData> rpcResponse) {
            String str;
            LoginReturnData loginReturnData;
            if (rpcResponse != null && (loginReturnData = rpcResponse.returnValue) != null && rpcResponse.code == 3000) {
                LoginDataHelper.processLoginReturnData(true, loginReturnData, "");
                WVResult wVResult = new WVResult();
                wVResult.setResult(WVResult.SUCCESS);
                WVCallBackContext wVCallBackContext = this.b;
                if (wVCallBackContext != null) {
                    wVCallBackContext.success(wVResult);
                    return;
                }
                return;
            }
            int i = -1;
            if (rpcResponse != null) {
                i = rpcResponse.code;
                str = rpcResponse.message;
            } else {
                str = "Error";
            }
            WVCallBackContext wVCallBackContext2 = this.b;
            if (wVCallBackContext2 != null) {
                SDKJSBridgeService.this.failCallback(wVCallBackContext2, str, String.valueOf(i));
            }
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

    private void paramError(WVCallBackContext wVCallBackContext) {
        WVResult wVResult = new WVResult();
        wVResult.setResult("HY_PARAM_ERR");
        wVCallBackContext.error(wVResult);
    }

    private void paramErrorCallback(WVCallBackContext wVCallBackContext) {
        if (wVCallBackContext != null) {
            paramError(wVCallBackContext);
        }
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if ("help".equals(str)) {
            setHelp(wVCallBackContext, str2);
            return true;
        } else if (WebConstant.SHOW_SKIP_MENU.equals(str)) {
            showSkipMenu(wVCallBackContext, str2);
            return true;
        } else if ("testAccountSsoLogin".equals(str)) {
            testSsoLogin(wVCallBackContext, str2);
            return true;
        } else {
            return false;
        }
    }

    public void requestHelp(WVCallBackContext wVCallBackContext, String str) {
        if (wVCallBackContext == null) {
            TLogAdapter.e(this.Tag, "Callback is null");
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (Debuggable.isDebug()) {
                String str2 = this.Tag;
                TLogAdapter.d(str2, "jsobj = " + jSONObject.toString());
            }
            ((UIService) ServiceFactory.getService(UIService.class)).switchWebViewTitleBarRightButton(this.mContext, true, (String) jSONObject.get("key1"));
            WVResult wVResult = new WVResult();
            wVResult.setResult("success");
            wVCallBackContext.success(wVResult);
        } catch (JSONException unused) {
            paramError(wVCallBackContext);
        }
    }

    public synchronized void setHelp(WVCallBackContext wVCallBackContext, String str) {
        LoginApprearanceExtensions loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions;
        if (loginApprearanceExtensions != null && loginApprearanceExtensions.needHelp()) {
            requestHelp(wVCallBackContext, str);
        }
    }

    public void showSkipMenu(WVCallBackContext wVCallBackContext, String str) {
        if (wVCallBackContext == null) {
            TLogAdapter.e(this.Tag, "Callback is null");
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (Debuggable.isDebug()) {
                String str2 = this.Tag;
                TLogAdapter.d(str2, "jsobj = " + jSONObject.toString());
            }
            ((UIService) ServiceFactory.getService(UIService.class)).switchWebViewTitleBarRightButton(this.mContext, true, MonitorType.SKIP);
            WVResult wVResult = new WVResult();
            wVResult.setResult("success");
            wVCallBackContext.success(wVResult);
        } catch (JSONException unused) {
            paramError(wVCallBackContext);
        }
    }

    public synchronized void testSsoLogin(WVCallBackContext wVCallBackContext, String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String str2 = (String) jSONObject.get("action");
                String str3 = (String) jSONObject.get("token");
                if (!TextUtils.isEmpty(str3) && "testAccountSso".equals(str2)) {
                    new CoordinatorWrapper().execute(new a(str3, wVCallBackContext), new Object[0]);
                }
                return;
            } catch (JSONException unused) {
                paramErrorCallback(wVCallBackContext);
                return;
            }
        }
        paramErrorCallback(wVCallBackContext);
    }
}
