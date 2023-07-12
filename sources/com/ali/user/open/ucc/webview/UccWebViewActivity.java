package com.ali.user.open.ucc.webview;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.ali.user.mobile.rpc.ApiConstants;
import com.ali.user.mobile.ui.WebConstant;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.callback.CallbackManager;
import com.ali.user.open.core.config.ConfigManager;
import com.ali.user.open.core.config.WebViewOption;
import com.ali.user.open.core.service.StatusBarService;
import com.ali.user.open.core.trace.SDKLogger;
import com.ali.user.open.core.util.DialogHelper;
import com.ali.user.open.core.util.ParamsConstants;
import com.ali.user.open.core.util.ToastUtil;
import com.ali.user.open.core.webview.BaseWebViewActivity;
import com.ali.user.open.core.webview.IWebViewProxy;
import com.ali.user.open.ucc.R;
import com.ali.user.open.ucc.UccCallback;
import com.ali.user.open.ucc.UccService;
import com.ali.user.open.ucc.UccServiceImpl;
import com.ali.user.open.ucc.biz.UccBindPresenter;
import com.ali.user.open.ucc.biz.UccOauthLoginPresenter;
import com.ali.user.open.ucc.biz.UccTrustLoginPresenter;
import com.ali.user.open.ucc.data.ApiConstants;
import com.ali.user.open.ucc.model.UccParams;
import com.ali.user.open.ucc.util.UTHitConstants;
import com.ali.user.open.ucc.util.UTHitUtils;
import com.ali.user.open.ucc.util.UccConstants;
import com.ali.user.open.ucc.util.Utils;
import com.alibaba.fastjson.JSON;
import com.taobao.orange.OrangeConfig;
import com.taomai.android.h5container.api.TMNavigationBarPlugin;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class UccWebViewActivity extends BaseWebViewActivity {
    protected String mH5RequestToken;
    protected Map<String, String> mParams;
    protected String mRequestToken;
    protected UccParams mUccParams;
    public String scene;
    public String token;
    private final String TAG = BaseWebViewActivity.class.getSimpleName();
    protected String mNeedSession = "0";
    private boolean isReassignNeedSession = false;
    protected String mNeedCookieOnly = "0";
    protected String mNeedToast = "0";
    protected String mNeedLocalSession = "1";

    private void addSessionParam(Bundle bundle) {
        if (this.mParams == null) {
            this.mParams = generateMap(bundle);
        }
        this.mParams.put("needSession", this.mNeedSession);
        this.mParams.put(ParamsConstants.Key.PARAM_NEED_LOCAL_SESSION, this.mNeedLocalSession);
    }

    private void checkUccParam(Bundle bundle) {
        if (this.mUccParams == null) {
            UccParams uccParams = new UccParams();
            this.mUccParams = uccParams;
            uccParams.traceId = Utils.generateTraceId("h5");
        }
        String string = bundle.getString("bindSite");
        String string2 = bundle.getString("userToken");
        if (!TextUtils.isEmpty(string)) {
            this.mUccParams.bindSite = string;
        }
        if (TextUtils.isEmpty(string2)) {
            return;
        }
        this.mUccParams.userToken = string2;
    }

    private Map<String, String> generateMap(Bundle bundle) {
        String string = bundle.getString("scene");
        String string2 = bundle.getString("site");
        String string3 = bundle.getString("bindSite");
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(string2)) {
            hashMap.put("site", string2);
        }
        if (!TextUtils.isEmpty(string3)) {
            hashMap.put("bindSite", string3);
        }
        if (!TextUtils.isEmpty(string)) {
            hashMap.put("scene", string);
        }
        return hashMap;
    }

    private void hideTitleBar(Uri uri) {
        if (uri == null) {
            return;
        }
        String queryParameter = uri.getQueryParameter(TMNavigationBarPlugin.ACTION_HIDE_TITLE_BAR);
        if (getSupportActionBar() == null || !TextUtils.equals(queryParameter, "true")) {
            return;
        }
        getSupportActionBar().hide();
    }

    private boolean overrideCallback(Uri uri) {
        Bundle serialBundle = serialBundle(uri.getQuery());
        if (serialBundle == null) {
            serialBundle = new Bundle();
        }
        checkUccParam(serialBundle);
        String string = serialBundle.getString("action");
        if (!TextUtils.isEmpty(string) && !TextUtils.equals("quit", string)) {
            if (TextUtils.equals("close", string)) {
                UTHitUtils.send(UTHitConstants.PageUccBind, "UccBind_Cancel", this.mUccParams, new HashMap());
                UccCallback uccCallback = (UccCallback) CallbackManager.getCallback(Integer.valueOf(UccConstants.UCC_H5_CALLBACK_TYPE));
                finish();
                if (uccCallback != null) {
                    uccCallback.onFail(this.mUccParams.bindSite, 1403, getResources().getString(R.string.member_sdk_cancel));
                    CallbackManager.unregisterCallback(UccConstants.UCC_H5_CALLBACK_TYPE);
                }
                return true;
            } else if (TextUtils.equals("bind", string)) {
                String string2 = serialBundle.getString("requestToken");
                String string3 = serialBundle.getString("bindUserToken");
                String string4 = serialBundle.getString("type");
                if (this.mUccParams == null) {
                    UccParams uccParams = new UccParams();
                    this.mUccParams = uccParams;
                    uccParams.traceId = Utils.generateTraceId("h5");
                }
                if (ApiConstants.ApiField.BIND_NEED_UPGRADE.equals(string4)) {
                    this.mUccParams.needUpgrade = "true";
                }
                if (!TextUtils.isEmpty(serialBundle.getString("scene"))) {
                    this.mUccParams.scene = serialBundle.getString("scene");
                }
                UccBindPresenter.getInstance().bindAfterRecommend(this, string2, this.mUccParams, string3, this.mNeedToast, this.mParams, (UccCallback) CallbackManager.getCallback(Integer.valueOf(UccConstants.UCC_H5_CALLBACK_TYPE)));
                return true;
            } else if (TextUtils.equals("bindAfterIdentify", string)) {
                String string5 = serialBundle.getString(ParamsConstants.UrlConstant.H5_REQUEST_TOKEN);
                String string6 = serialBundle.getString("havana_iv_token");
                String string7 = serialBundle.getString("userBindToken");
                addSessionParam(serialBundle);
                UccBindPresenter.getInstance().bindIdentify(this, string5, this.mUccParams, string6, string7, this.mNeedToast, this.mParams, (UccCallback) CallbackManager.getCallback(Integer.valueOf(UccConstants.UCC_H5_CALLBACK_TYPE)));
                return true;
            } else if (TextUtils.equals("continueLogin", string)) {
                String query = uri.getQuery();
                addSessionParam(serialBundle);
                UccTrustLoginPresenter.getInstance().tokenLogin(this, this.mUccParams, this.scene, this.token, query, this.mParams, (UccCallback) CallbackManager.getCallback(Integer.valueOf(UccConstants.UCC_H5_CALLBACK_TYPE)));
                return true;
            } else if (TextUtils.equals(ApiConstants.ApiField.TRUST_LOGIN, string)) {
                String string8 = serialBundle.getString("token");
                String string9 = serialBundle.getString("scene");
                String query2 = uri.getQuery();
                if (TextUtils.isEmpty(string9)) {
                    string9 = this.scene;
                }
                UccTrustLoginPresenter.getInstance().tokenLogin(this, this.mUccParams, string9, string8, query2, null, (UccCallback) CallbackManager.getCallback(Integer.valueOf(UccConstants.UCC_H5_CALLBACK_TYPE)));
                return true;
            } else {
                if (TextUtils.equals("login", string)) {
                    Map<String, String> generateMap = generateMap(serialBundle);
                    generateMap.put("needSession", "1");
                    UccBindPresenter.getInstance().bindByRequestToken(this, this.mUccParams, serialBundle.getString(ParamsConstants.UrlConstant.H5_REQUEST_TOKEN), serialBundle.getString("userToken"), serialBundle.getString(WebConstant.WEB_LOGIN_TOKEN_TYPE), generateMap, (UccCallback) CallbackManager.getCallback(Integer.valueOf(UccConstants.UCC_H5_CALLBACK_TYPE)));
                    return true;
                } else if (TextUtils.equals("taobao_auth_token", string)) {
                    addSessionParam(serialBundle);
                    Map<String, String> generateMap2 = generateMap(serialBundle);
                    if (ApiConstants.ApiName.BIND_BY_REQUEST_TOKEN.equals(serialBundle.getString("api"))) {
                        Map<String, String> map = this.mParams;
                        if (map != null && TextUtils.equals(map.get("scene"), ParamsConstants.UrlConstant.NEW_YOUKU_UPGRADE)) {
                            generateMap2.put("needSession", "1");
                        }
                        this.mUccParams.topAuthCode = serialBundle.getString("top_auth_code");
                        this.mUccParams.requestToken = serialBundle.getString(ParamsConstants.UrlConstant.H5_REQUEST_TOKEN);
                        UccBindPresenter.getInstance().bindByRequestToken(this, this.mUccParams, serialBundle.getString(ParamsConstants.UrlConstant.H5_REQUEST_TOKEN), serialBundle.getString("top_auth_code"), "oauthcode", generateMap2, (UccCallback) CallbackManager.getCallback(Integer.valueOf(UccConstants.UCC_H5_CALLBACK_TYPE)));
                        return true;
                    }
                    Map<String, String> map2 = this.mParams;
                    if (map2 != null && TextUtils.equals(map2.get("scene"), ParamsConstants.UrlConstant.NEW_YOUKU_UPGRADE)) {
                        generateMap2.put("needSession", "1");
                        UccBindPresenter.getInstance().getUserInfo(this, this.mUccParams, serialBundle.getString("top_auth_code"), "oauthcode", "h5", generateMap2, (UccCallback) CallbackManager.getCallback(Integer.valueOf(UccConstants.UCC_H5_CALLBACK_TYPE)));
                        return true;
                    }
                    generateMap2.put("needSession", this.mNeedSession);
                    generateMap2.put(ParamsConstants.Key.PARAM_NEED_LOCAL_SESSION, this.mNeedLocalSession);
                    generateMap2.put("requestToken", this.mRequestToken);
                    Map<String, String> map3 = this.mParams;
                    if (map3 != null) {
                        generateMap2.put(ParamsConstants.Key.PARAM_NEED_LOCAL_COOKIE_ONLY, map3.get(ParamsConstants.Key.PARAM_NEED_LOCAL_COOKIE_ONLY));
                    }
                    UccBindPresenter.getInstance().bindByNativeAuth(this, this.mUccParams, serialBundle.getString("top_auth_code"), "oauthcode", generateMap2, (UccCallback) CallbackManager.getCallback(Integer.valueOf(UccConstants.UCC_H5_CALLBACK_TYPE)));
                    return true;
                } else if (!TextUtils.equals("registerSuc", string) && !TextUtils.equals("afterBindMobile", string)) {
                    if (TextUtils.equals("UCC_ContinueLogin", string)) {
                        UTHitUtils.send(UTHitConstants.PageUccBind, "UccBindWithIbb_H5Skip", this.mUccParams, null);
                        String string10 = serialBundle.getString("requestToken");
                        String string11 = serialBundle.getString("userToken");
                        String string12 = serialBundle.getString(ApiConstants.ApiField.USER_ACTION);
                        if (TextUtils.isEmpty(string10)) {
                            finish();
                            return true;
                        }
                        Map<String, String> generateMap3 = generateMap(serialBundle);
                        generateMap3.put("needSession", "1");
                        generateMap3.put(ParamsConstants.Key.PARAM_NEED_LOCAL_SESSION, this.mNeedLocalSession);
                        UccParams uccParams2 = this.mUccParams;
                        uccParams2.requestToken = string10;
                        uccParams2.userToken = string11;
                        uccParams2.userAction = string12;
                        UccBindPresenter.getInstance().skipUpgrade(this, this.mUccParams, "h5", generateMap3, (UccCallback) CallbackManager.getCallback(Integer.valueOf(UccConstants.UCC_H5_CALLBACK_TYPE)));
                        return true;
                    } else if (TextUtils.equals("skip_bind", string)) {
                        UTHitUtils.send(UTHitConstants.PageUccBind, "UccBindWithIbb_H5Skip", this.mUccParams, null);
                        UccCallback uccCallback2 = (UccCallback) CallbackManager.getCallback(Integer.valueOf(UccConstants.UCC_H5_CALLBACK_TYPE));
                        if (uccCallback2 != null) {
                            uccCallback2.onFail(this.mUccParams.bindSite, 1011, "跳过绑定");
                            CallbackManager.unregisterCallback(UccConstants.UCC_H5_CALLBACK_TYPE);
                        }
                        finish();
                        return true;
                    } else if (TextUtils.equals("UCC_Upgrade", string)) {
                        if (this.mUccParams == null) {
                            UccParams uccParams3 = new UccParams();
                            this.mUccParams = uccParams3;
                            uccParams3.traceId = Utils.generateTraceId("h5");
                        }
                        String string13 = serialBundle.getString("bindSite");
                        String string14 = serialBundle.getString("requestToken");
                        String string15 = serialBundle.getString(ParamsConstants.Key.PARAM_SCENE_CODE);
                        String string16 = serialBundle.getString("scene");
                        String string17 = serialBundle.getString(ParamsConstants.Key.PARAM_H5ONLY);
                        String string18 = serialBundle.getString(ParamsConstants.Key.PARAM_H5URL);
                        Map<String, String> generateMap4 = generateMap(serialBundle);
                        if (this.isReassignNeedSession && !TextUtils.isEmpty(this.mNeedSession)) {
                            generateMap4.put("needSession", this.mNeedSession);
                        } else {
                            generateMap4.put("needSession", "1");
                        }
                        generateMap4.put(ParamsConstants.Key.PARAM_NEED_LOCAL_SESSION, this.mNeedLocalSession);
                        if (!TextUtils.isEmpty(string15)) {
                            generateMap4.put(ParamsConstants.Key.PARAM_SCENE_CODE, string15);
                        }
                        String string19 = serialBundle.getString("type");
                        if ("rpc".equals(string19)) {
                            UccTrustLoginPresenter.getInstance().upgradeLogin(this, this.mUccParams, string13, string16, string14, "h5", generateMap4, (UccCallback) CallbackManager.getCallback(Integer.valueOf(UccConstants.UCC_H5_CALLBACK_TYPE)));
                            return true;
                        } else if ("launchTao".equals(string19)) {
                            String string20 = serialBundle.getString("userToken");
                            if ("true".equals(string17)) {
                                generateMap4.put(ParamsConstants.Key.PARAM_H5ONLY, "1");
                            }
                            if (!TextUtils.isEmpty(string18)) {
                                String str = string18 + "&request_token=" + string14;
                                String string21 = serialBundle.getString("env");
                                if (!TextUtils.isEmpty(string21)) {
                                    str = str + "&env=" + string21;
                                }
                                String string22 = serialBundle.getString("appEntrance");
                                if (!TextUtils.isEmpty(string22)) {
                                    str = str + "&appEntrance=" + string22;
                                }
                                String string23 = serialBundle.getString("needTopToken");
                                if (!TextUtils.isEmpty(string23)) {
                                    str = str + "&needTopToken=" + string23;
                                }
                                if (!TextUtils.isEmpty(serialBundle.getString("topTokenAppName"))) {
                                    str = str + "&topTokenAppName=" + serialBundle.getString("topTokenAppName");
                                }
                                String string24 = serialBundle.getString("redirectUri");
                                if (!TextUtils.isEmpty(string24)) {
                                    str = str + "&redirectUri=" + string24;
                                }
                                generateMap4.put(UccConstants.PARAM_BIND_URL, str);
                            }
                            generateMap4.put("from", string);
                            generateMap4.put("requestToken", string14);
                            ((UccService) AliMemberSDK.getService(UccService.class)).bind(this, string20, string13, generateMap4, (UccCallback) CallbackManager.getCallback(Integer.valueOf(UccConstants.UCC_H5_CALLBACK_TYPE)));
                            return true;
                        } else {
                            finish();
                            return true;
                        }
                    } else if (TextUtils.equals("agreeAuthorize", string)) {
                        finish();
                        UccCallback uccCallback3 = (UccCallback) CallbackManager.getCallback(Integer.valueOf(UccConstants.UCC_H5_CALLBACK_TYPE));
                        if (uccCallback3 != null) {
                            uccCallback3.onSuccess(this.mUccParams.bindSite, null);
                            CallbackManager.unregisterCallback(UccConstants.UCC_H5_CALLBACK_TYPE);
                            return true;
                        }
                        return true;
                    } else if (TextUtils.equals("refuseAuthorize", string)) {
                        finish();
                        UccCallback uccCallback4 = (UccCallback) CallbackManager.getCallback(Integer.valueOf(UccConstants.UCC_H5_CALLBACK_TYPE));
                        if (uccCallback4 != null) {
                            uccCallback4.onFail(this.mUccParams.bindSite, 1201, "");
                            CallbackManager.unregisterCallback(UccConstants.UCC_H5_CALLBACK_TYPE);
                            return true;
                        }
                        return true;
                    } else if (TextUtils.equals("bindAlipayFail", string)) {
                        finish();
                        UccCallback uccCallback5 = (UccCallback) CallbackManager.getCallback(Integer.valueOf(UccConstants.UCC_H5_CALLBACK_TYPE));
                        if (uccCallback5 != null) {
                            uccCallback5.onFail(this.mUccParams.bindSite, 1007, "");
                            CallbackManager.unregisterCallback(UccConstants.UCC_H5_CALLBACK_TYPE);
                            return true;
                        }
                        return true;
                    } else if (TextUtils.equals("quitAndBind", string)) {
                        UccCallback uccCallback6 = (UccCallback) CallbackManager.getCallback(Integer.valueOf(UccConstants.UCC_H5_CALLBACK_TYPE));
                        if (uccCallback6 != null) {
                            CallbackManager.unregisterCallback(UccConstants.UCC_H5_CALLBACK_TYPE);
                        }
                        if (this.mUccParams != null) {
                            Map<String, String> map4 = this.mParams;
                            if (map4 == null) {
                                map4 = new HashMap<>();
                            }
                            Map<String, String> map5 = map4;
                            map5.put("needSession", "1");
                            map5.put(ParamsConstants.Key.PARAM_NEED_LOCAL_COOKIE_ONLY, UccOauthLoginPresenter.isCookieOnly(this.mParams) ? "1" : "0");
                            map5.put(ParamsConstants.Key.PARAM_NEED_TOAST, "0");
                            UccServiceImpl uccServiceImpl = UccServiceImpl.getInstance();
                            UccParams uccParams4 = this.mUccParams;
                            uccServiceImpl.bind(this, uccParams4.userToken, uccParams4.bindSite, map5, uccCallback6);
                            return true;
                        }
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    if (TextUtils.equals("registerSuc", string)) {
                        UTHitUtils.send(UTHitConstants.PageUccBind, "UccBind_registerSuc", this.mUccParams, null);
                    }
                    String string25 = serialBundle.getString("message");
                    if (TextUtils.equals(this.mNeedSession, "1")) {
                        UccBindPresenter.getInstance().tokenLoginAfterBind(this, this.mUccParams, serialBundle.getString("trustToken"), string, this.mNeedToast, string25, this.mParams, (UccCallback) CallbackManager.getCallback(Integer.valueOf(UccConstants.UCC_H5_CALLBACK_TYPE)));
                        return true;
                    }
                    if (!TextUtils.isEmpty(string25) && TextUtils.equals(this.mNeedToast, "1")) {
                        ToastUtil.showToast(getApplicationContext(), string25, 0);
                    }
                    UccCallback uccCallback7 = (UccCallback) CallbackManager.getCallback(Integer.valueOf(UccConstants.UCC_H5_CALLBACK_TYPE));
                    if (uccCallback7 != null) {
                        uccCallback7.onSuccess(this.mUccParams.bindSite, null);
                        CallbackManager.unregisterCallback(UccConstants.UCC_H5_CALLBACK_TYPE);
                    }
                    finish();
                    return true;
                }
            }
        }
        UTHitUtils.send(UTHitConstants.PageUccBind, "UccBind_Cancel", this.mUccParams, new HashMap());
        finish();
        UccCallback uccCallback8 = (UccCallback) CallbackManager.getCallback(Integer.valueOf(UccConstants.UCC_H5_CALLBACK_TYPE));
        if (uccCallback8 == null || !TextUtils.equals("true", serialBundle.getString("isSuc"))) {
            return true;
        }
        uccCallback8.onSuccess(this.mUccParams.bindSite, null);
        CallbackManager.unregisterCallback(UccConstants.UCC_H5_CALLBACK_TYPE);
        return true;
    }

    @Override // com.ali.user.open.core.webview.BaseWebViewActivity
    protected int getLayout() {
        if (AliMemberSDK.getService(StatusBarService.class) != null && ((StatusBarService) AliMemberSDK.getService(StatusBarService.class)).getWebLayout() > 0) {
            return ((StatusBarService) AliMemberSDK.getService(StatusBarService.class)).getWebLayout();
        }
        return R.C2996layout.member_sdk_ucc_webview;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ali.user.open.core.webview.BaseWebViewActivity
    public void initParams(Intent intent) {
        super.initParams(intent);
        if (intent != null) {
            this.mUccParams = (UccParams) JSON.parseObject(intent.getStringExtra(UccConstants.PARAM_UCC_PARAMS), UccParams.class);
            String stringExtra = intent.getStringExtra("needSession");
            this.mNeedSession = stringExtra;
            if (!TextUtils.isEmpty(stringExtra)) {
                this.isReassignNeedSession = true;
            }
            this.mNeedCookieOnly = intent.getStringExtra(ParamsConstants.Key.PARAM_NEED_LOCAL_COOKIE_ONLY);
            this.token = intent.getStringExtra("token");
            this.scene = intent.getStringExtra("scene");
            this.mNeedToast = intent.getStringExtra(ParamsConstants.Key.PARAM_NEED_TOAST);
            String stringExtra2 = intent.getStringExtra("params");
            if (!TextUtils.isEmpty(stringExtra2)) {
                this.mParams = Utils.convertJsonStrToMap(stringExtra2);
            }
            this.mNeedLocalSession = intent.getStringExtra(ParamsConstants.Key.PARAM_NEED_LOCAL_SESSION);
            this.mRequestToken = intent.getStringExtra("requestToken");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ali.user.open.core.webview.BaseWebViewActivity
    public void loadUrl(String str) {
        String str2 = this.TAG;
        Log.e(str2, "load url:" + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        IWebViewProxy iWebViewProxy = this.memberWebView;
        if (iWebViewProxy != null) {
            iWebViewProxy.loadUrl(str);
        }
        Bundle serialBundle = serialBundle(Uri.parse(str).getQuery());
        if (serialBundle != null) {
            this.mH5RequestToken = serialBundle.getString(ParamsConstants.UrlConstant.H5_REQUEST_TOKEN);
        }
    }

    @Override // com.ali.user.open.core.webview.BaseWebViewActivity
    public void onBackHistory() {
        IWebViewProxy iWebViewProxy = this.memberWebView;
        if (iWebViewProxy != null && iWebViewProxy.canGoBack() && (this.memberWebView.getUrl().contains("authorization-notice") || this.memberWebView.getUrl().contains("agreement"))) {
            this.memberWebView.goBack();
            return;
        }
        UTHitUtils.send(UTHitConstants.PageUccBind, "UccBind_Cancel", this.mUccParams, new HashMap());
        UccCallback uccCallback = (UccCallback) CallbackManager.getCallback(Integer.valueOf(UccConstants.UCC_H5_CALLBACK_TYPE));
        if (uccCallback != null) {
            if (this.mUccParams == null) {
                this.mUccParams = new UccParams();
            }
            uccCallback.onFail(this.mUccParams.bindSite, 1403, getResources().getString(R.string.member_sdk_cancel));
            CallbackManager.unregisterCallback(UccConstants.UCC_H5_CALLBACK_TYPE);
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ali.user.open.core.webview.BaseWebViewActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        IWebViewProxy iWebViewProxy;
        try {
            if (AliMemberSDK.getService(StatusBarService.class) != null) {
                ((StatusBarService) AliMemberSDK.getService(StatusBarService.class)).setStatusBar(this);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        super.onCreate(bundle);
        IWebViewProxy iWebViewProxy2 = this.memberWebView;
        if (iWebViewProxy2 != null && iWebViewProxy2.getWebView() != null) {
            if (ConfigManager.getInstance().getWebViewOption() != WebViewOption.SYSTEM || (iWebViewProxy = this.memberWebView) == null) {
                return;
            }
            iWebViewProxy.addBridgeObject(UccSystemJSBridge.ALU_SYSTEM_JSBRIDGE, new UccSystemJSBridge());
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ali.user.open.core.webview.BaseWebViewActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        DialogHelper.getInstance().dismissAlertDialog(this);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ali.user.open.core.webview.BaseWebViewActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initParams(intent);
    }

    @Override // com.ali.user.open.core.webview.BaseWebViewActivity, com.ali.user.open.core.webview.IWebViewClient
    public void onPageFinished(String str) {
        String str2 = this.TAG;
        SDKLogger.d(str2, "onPageFinished url=" + str);
        showTitleBar(Uri.parse(str));
    }

    @Override // com.ali.user.open.core.webview.BaseWebViewActivity, com.ali.user.open.core.webview.IWebViewClient
    public void onPageStarted(String str) {
        hideTitleBar(Uri.parse(str));
        String str2 = this.TAG;
        SDKLogger.d(str2, "onPageStarted url=" + str);
    }

    @Override // com.ali.user.open.core.webview.BaseWebViewActivity
    protected String pipOrange() {
        try {
            return OrangeConfig.getInstance().getConfig("login4android", "progress", "true");
        } catch (Throwable unused) {
            return "true";
        }
    }

    @Override // com.ali.user.open.core.webview.BaseWebViewActivity, com.ali.user.open.core.webview.IWebViewClient
    public boolean shouldOverrideUrlLoading(String str) {
        String str2 = this.TAG;
        SDKLogger.d(str2, "shouldOverrideUrlLoading url=" + str);
        Uri parse = Uri.parse(str);
        if (checkWebviewBridge(str)) {
            return overrideCallback(parse);
        }
        if (!TextUtils.isEmpty(str) && !str.startsWith("http") && !str.startsWith("https")) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.setFlags(268435456);
                startActivity(intent);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        IWebViewProxy iWebViewProxy = this.memberWebView;
        if (iWebViewProxy != null) {
            iWebViewProxy.loadUrl(str);
        }
        return true;
    }

    protected void showTitleBar(Uri uri) {
        if (uri == null) {
            return;
        }
        String queryParameter = uri.getQueryParameter(TMNavigationBarPlugin.ACTION_HIDE_TITLE_BAR);
        if (getSupportActionBar() == null || TextUtils.equals(queryParameter, "true")) {
            return;
        }
        getSupportActionBar().show();
    }
}
