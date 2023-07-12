package com.ali.user.mobile.webview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.taobao.windvane.extra.uc.WVUCWebChromeClient;
import android.taobao.windvane.extra.uc.WVUCWebViewClient;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVPluginManager;
import android.taobao.windvane.util.EnvUtil;
import android.taobao.windvane.util.TaoLog;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.ValueCallback;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.app.init.Debuggable;
import com.ali.user.mobile.base.UIBaseConstants;
import com.ali.user.mobile.base.helper.BroadCastHelper;
import com.ali.user.mobile.base.ui.BaseActivity;
import com.ali.user.mobile.common.api.AliUserLogin;
import com.ali.user.mobile.common.api.LoginApprearanceExtensions;
import com.ali.user.mobile.coordinator.CoordinatorWrapper;
import com.ali.user.mobile.eventbus.EventBus;
import com.ali.user.mobile.filter.LoginFilterCallback;
import com.ali.user.mobile.log.AppMonitorAdapter;
import com.ali.user.mobile.log.LongLifeCycleUserTrack;
import com.ali.user.mobile.log.TLogAdapter;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.login.action.LoginResActions;
import com.ali.user.mobile.login.model.LoginConstant;
import com.ali.user.mobile.login.ui.UserLoginActivity;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.model.LoginType;
import com.ali.user.mobile.model.TokenType;
import com.ali.user.mobile.model.UrlParam;
import com.ali.user.mobile.rpc.ApiConstants;
import com.ali.user.mobile.rpc.login.model.LoginReturnData;
import com.ali.user.mobile.service.NavigatorService;
import com.ali.user.mobile.service.ServiceFactory;
import com.ali.user.mobile.ui.R;
import com.ali.user.mobile.ui.WebConstant;
import com.ali.user.mobile.utils.BundleUtil;
import com.ali.user.mobile.utils.StringUtil;
import com.ali.user.mobile.verify.impl.VerifyServiceImpl;
import com.ali.user.mobile.verify.model.VerifyParam;
import com.ali.user.mobile.verify.model.VerifyTokenConsumedResponse;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taobao.login4android.biz.unifysso.UnifySsoLogin;
import com.taobao.login4android.broadcast.LoginAction;
import com.taobao.login4android.config.LoginSwitch;
import com.taobao.login4android.constants.LoginConstants;
import com.taobao.login4android.constants.LoginStatus;
import com.taobao.login4android.session.SessionManager;
import com.taobao.weex.ui.module.WXModalUIModule;
import com.uc.webview.export.JsPromptResult;
import com.uc.webview.export.JsResult;
import com.uc.webview.export.WebView;
import com.ut.mini.UTAnalytics;
import com.youku.media.arch.instruments.statistics.ConfigReporter;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class WebViewActivity extends BaseActivity {
    public static final String PAGE_NAME = "Page_LoginH5";
    public static final String TAG = "login.web";
    protected static final String WINDVANECLOSEALL = "aliusersdkwindvane=closeAll";
    protected String eventName;
    protected RelativeLayout mAPRelativeLayout;
    private String mHelpUrl;
    protected String mIVScene;
    protected String mLoginId;
    protected String mLoginType;
    protected String mNativeLoginType;
    protected String mOriginalLoginParam;
    protected ProgressBar mProgressBar;
    protected int mRequestCode;
    protected String mSNSTrustLoginToken;
    protected String mScene;
    protected String mSecurityId;
    protected int mSite;
    protected String mToken;
    protected String mTokenType;
    protected String mUrl;
    protected String mUserId;
    protected LoginWebView mWebView;
    protected boolean needCancelBroadcast;
    private LoginParam ssoLoginParam;
    public boolean allowReadTitle = true;
    protected boolean isWebviewAlive = true;
    protected boolean isLoginPost = false;
    protected boolean skipLogin = false;
    private boolean isShowHelpMenu = false;
    private boolean isShowSkipMenu = false;
    private final int SKIP_MENU_ITEM_ID = 257;

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public static class LoginWebChromeClient extends WVUCWebChromeClient {
        private static final String KEY_CANCEL;
        private static final String KEY_CONFIRM;
        private static final String KEY_FROM;
        WeakReference<WebViewActivity> reference;

        static {
            KEY_FROM = EnvUtil.isCN() ? "来自于：" : "From: ";
            KEY_CONFIRM = EnvUtil.isCN() ? "确定" : WXModalUIModule.OK;
            KEY_CANCEL = EnvUtil.isCN() ? "取消" : WXModalUIModule.CANCEL;
        }

        public LoginWebChromeClient(WebViewActivity webViewActivity) {
            super(webViewActivity);
            this.reference = new WeakReference<>(webViewActivity);
        }

        @Override // android.taobao.windvane.extra.uc.WVUCWebChromeClient, com.uc.webview.export.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, final JsResult jsResult) {
            if ((webView.getContext() instanceof Activity) && ((Activity) webView.getContext()).isFinishing()) {
                jsResult.confirm();
                return true;
            }
            try {
                AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper((Activity) webView.getContext(), 16973939));
                String host = Uri.parse(str).getHost();
                builder.setTitle(KEY_FROM + host).setMessage(str2).setPositiveButton(KEY_CONFIRM, new DialogInterface.OnClickListener() { // from class: com.ali.user.mobile.webview.WebViewActivity.LoginWebChromeClient.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        jsResult.confirm();
                    }
                });
                builder.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.ali.user.mobile.webview.WebViewActivity.LoginWebChromeClient.2
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        jsResult.cancel();
                    }
                });
                AlertDialog create = builder.create();
                create.setCanceledOnTouchOutside(false);
                create.show();
            } catch (Throwable th) {
                TaoLog.e(WebViewActivity.TAG, th.getMessage());
                jsResult.confirm();
            }
            return true;
        }

        @Override // android.taobao.windvane.extra.uc.WVUCWebChromeClient, com.uc.webview.export.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            try {
                return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
            } catch (Throwable unused) {
                return false;
            }
        }

        @Override // android.taobao.windvane.extra.uc.WVUCWebChromeClient, com.uc.webview.export.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            WebViewActivity webViewActivity = this.reference.get();
            if (webViewActivity != null && webViewActivity.allowReadTitle && webViewActivity.getSupportActionBar() != null) {
                try {
                    webViewActivity.getSupportActionBar().setTitle(str);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            super.onReceivedTitle(webView, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public static class MyLoginWebViewClient extends LoginWebViewClient {
        WeakReference<WebViewActivity> reference;

        public MyLoginWebViewClient(WebViewActivity webViewActivity) {
            super(webViewActivity);
            this.reference = new WeakReference<>(webViewActivity);
        }

        @Override // android.taobao.windvane.extra.uc.WVUCWebViewClient, com.uc.webview.export.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            ProgressBar progressBar;
            WebViewActivity webViewActivity = this.reference.get();
            if (webViewActivity != null && (progressBar = webViewActivity.mProgressBar) != null) {
                progressBar.setVisibility(8);
            }
            super.onPageFinished(webView, str);
        }

        @Override // com.ali.user.mobile.webview.LoginWebViewClient
        protected boolean overrideUrlLoading(WebView webView, String str) {
            WebViewActivity webViewActivity = this.reference.get();
            if (webViewActivity != null) {
                return webViewActivity.overrideUrlLoading(webView, str);
            }
            return false;
        }
    }

    public static Intent getCallingIntent(Activity activity, String str, LoginParam loginParam, LoginReturnData loginReturnData, boolean z) {
        Intent intent = new Intent(activity, WebViewActivity.class);
        intent.putExtra(WebConstant.WEBURL, str);
        if (loginParam != null) {
            intent.putExtra(WebConstant.WEB_LOGIN_TYPE, loginParam.loginType);
            intent.putExtra(WebConstant.WEB_NATIVE_LOGIN_TYPE, loginParam.nativeLoginType);
            intent.putExtra(WebConstant.WEB_SNS_TRUST_LOGIN_TOKEN, loginParam.snsToken);
            intent.putExtra(WebConstant.WEB_LOGIN_TOKEN_TYPE, loginParam.tokenType);
            intent.putExtra(UIBaseConstants.IntentExtrasNamesConstants.PARAM_LOGIN_PARAM, JSON.toJSONString(loginParam));
            intent.putExtra(WebConstant.WEB_CANCEL_BROADCAST, loginParam.sendLoginFailWhenWebviewCancel);
        }
        if (loginReturnData != null) {
            intent.putExtra("scene", loginReturnData.scene);
            intent.putExtra("token", loginReturnData.token);
            String str2 = loginReturnData.showLoginId;
            if (str2 != null) {
                intent.putExtra(WebConstant.WEB_LOGIN_ID, str2);
            } else if (loginParam != null && !TextUtils.isEmpty(loginParam.loginAccount)) {
                intent.putExtra(WebConstant.WEB_LOGIN_ID, loginParam.loginAccount);
            }
            intent.putExtra("site", loginReturnData.site);
        }
        intent.putExtra(WebConstant.WEB_ALLOW_TITLE, z);
        return intent;
    }

    @NonNull
    private LoginParam getLoginParam(String str, String str2, String str3, String str4, String str5, boolean z, boolean z2, String str6) {
        LoginParam loginParam = new LoginParam();
        if (str != null && !str.equals("null")) {
            loginParam.loginAccount = str;
        }
        loginParam.loginType = str3;
        loginParam.h5QueryString = str5;
        loginParam.isFromRegister = z;
        loginParam.isFoundPassword = z2;
        loginParam.loginSite = this.mSite;
        if (str2 != null) {
            loginParam.token = str2;
            loginParam.scene = str4;
            loginParam.tokenType = str6;
        }
        loginParam.snsToken = this.mSNSTrustLoginToken;
        loginParam.nativeLoginType = this.mNativeLoginType;
        return loginParam;
    }

    public static void goFistLoginPage(Activity activity, boolean z, boolean z2, LoginParam loginParam) {
        if (activity == null) {
            return;
        }
        Class<?> userLoginActivity = AliUserLogin.mAppreanceExtentions.getUserLoginActivity();
        if (userLoginActivity == null) {
            userLoginActivity = UserLoginActivity.class;
        }
        Intent intent = new Intent(activity, userLoginActivity);
        intent.putExtra(LoginConstant.LAUNCH_PASS_GUIDE_FRAGMENT, true);
        intent.putExtra(LoginConstant.LAUCNH_MOBILE_LOGIN_FRAGMENT_LABEL, true);
        intent.putExtra(UIBaseConstants.UT_FROM_REGIST_KEY, z2);
        if (loginParam != null) {
            intent.putExtra(UIBaseConstants.IntentExtrasNamesConstants.PARAM_LOGIN_PARAM, JSON.toJSONString(loginParam));
        }
        intent.putExtra(LoginConstant.FORCE_HIDE_ALL, true);
        if (z) {
            intent.addFlags(ConfigReporter.BIT_GETTER_IMP);
            intent.addFlags(536870912);
            activity.finish();
        }
        intent.putExtra("check", true);
        intent.putExtra(LoginConstant.FORCE_NORMAL_MODE, true);
        activity.startActivity(intent);
    }

    private void initDataFromIntent() {
        try {
            LoginParam loginParam = (LoginParam) getIntent().getSerializableExtra(WebConstant.SSO_LOGIN_PARAM);
            this.ssoLoginParam = loginParam;
            if (loginParam != null) {
                this.mOriginalLoginParam = JSON.toJSONString(loginParam);
                String loginTypeByTraceId = UTConstant.getLoginTypeByTraceId(this.ssoLoginParam.traceId + "");
                if (TextUtils.isEmpty(loginTypeByTraceId)) {
                    loginTypeByTraceId = UTConstant.getLoginTypeByTokenType(this.ssoLoginParam.tokenType);
                }
                if (TextUtils.isEmpty(loginTypeByTraceId)) {
                    return;
                }
                Properties properties = new Properties();
                properties.setProperty("monitor", "T");
                properties.setProperty("h5_code", this.ssoLoginParam.errorCode + "");
                UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, UTConstant.CustomEvent.UT_LOGIN_TO_H5_COMMIT, "", loginTypeByTraceId, properties);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean isProtocalUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("http://ab.alipay.com/agreement/contract.htm") || str.startsWith("http://www.taobao.com/go/chn/member/agreement.php") || str.startsWith("https://rule.alibaba.com/rule/detail/2042.htm") || str.startsWith("https://render.alipay.com/p/f/fd-j1m1vl4o/index.html") || str.startsWith("https://render.alipay.com/p/f/fd-jm7jym6r/alipay/multi-agreement.html") || str.startsWith("https://terms.alicdn.com/legal-agreement/terms") || str.contains("agreement");
    }

    private void loginHit(String str, String str2, String str3) {
        LoginParam loginParam;
        try {
            if (TextUtils.isEmpty(this.mOriginalLoginParam) || (loginParam = (LoginParam) JSON.parseObject(this.mOriginalLoginParam, LoginParam.class)) == null) {
                return;
            }
            Properties properties = new Properties();
            properties.setProperty("sdkTraceId", loginParam.traceId + "");
            UserTrackAdapter.sendUT(TextUtils.isEmpty(loginParam.loginSourcePage) ? PAGE_NAME : loginParam.loginSourcePage, str, properties);
            String loginTypeByTraceId = UTConstant.getLoginTypeByTraceId(loginParam.traceId + "");
            if (TextUtils.isEmpty(loginTypeByTraceId)) {
                loginTypeByTraceId = UTConstant.getLoginTypeByTokenType(loginParam.tokenType);
            }
            if (TextUtils.isEmpty(loginTypeByTraceId)) {
                return;
            }
            Properties properties2 = new Properties();
            properties2.setProperty("monitor", "T");
            properties2.setProperty("scene", str3 + "");
            properties2.setProperty("h5_code", loginParam.errorCode + "");
            UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, str2, "", loginTypeByTraceId, properties2);
        } catch (Exception unused) {
        }
    }

    public void cancleOperation() {
        LoginFilterCallback loginFilterCallback;
        LoginParam loginParam;
        if (onPanelKeyDown()) {
            return;
        }
        if (isProtocalUrl(this.mWebView.getUrl())) {
            if (this.mWebView.canGoBack()) {
                this.mWebView.goBack();
                return;
            } else {
                finish();
                return;
            }
        }
        setResult(0);
        sendCancelBroadcast();
        if (!TextUtils.isEmpty(this.eventName)) {
            HashMap hashMap = new HashMap();
            hashMap.put("result", "cancel");
            EventBus.getDefault().sendEvent(this.eventName, hashMap);
        }
        if (!TextUtils.isEmpty(LongLifeCycleUserTrack.getResultScene())) {
            LongLifeCycleUserTrack.sendUT(LongLifeCycleUserTrack.getResultScene() + "_FAILURE");
        }
        if (!TextUtils.isEmpty(this.mOriginalLoginParam) && (loginParam = (LoginParam) JSON.parseObject(this.mOriginalLoginParam, LoginParam.class)) != null) {
            String str = loginParam.traceId + "";
            String loginTypeByTraceId = UTConstant.getLoginTypeByTraceId(str);
            if (TextUtils.isEmpty(loginTypeByTraceId)) {
                loginTypeByTraceId = UTConstant.getLoginTypeByTokenType(loginParam.tokenType);
            }
            if (!TextUtils.isEmpty(loginTypeByTraceId)) {
                Properties properties = new Properties();
                properties.setProperty("sdkTraceId", str + "");
                properties.setProperty("monitor", "T");
                properties.setProperty("site", loginParam.loginSite + "");
                UserTrackAdapter.sendUT(TextUtils.isEmpty(loginParam.loginSourcePage) ? PAGE_NAME : loginParam.loginSourcePage, UTConstant.CustomEvent.UT_SINGLE_LOGIN_CANCEL, "", loginTypeByTraceId, properties);
                properties.setProperty("h5_code", loginParam.errorCode + "");
                UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, UTConstant.CustomEvent.UT_LOGIN_TO_H5_CANCEL, "", loginTypeByTraceId, properties);
            }
        }
        if (this.isLoginPost && (loginFilterCallback = LoginPostHandler.sCallback) != null) {
            loginFilterCallback.onSuccess();
            LoginPostHandler.sCallback = null;
            UserTrackAdapter.sendUT("UserCancelPostUrl");
        }
        finish();
    }

    protected void createWebView() {
        this.mWebView = new LoginWebView(this);
        this.mWebView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    }

    @Override // com.ali.user.mobile.base.ui.BaseActivity
    protected int getLayoutContent() {
        return R.layout.aliuser_activity_webview;
    }

    protected void goConsumeIV(final VerifyParam verifyParam) {
        new CoordinatorWrapper().execute(new AsyncTask<Object, Void, VerifyTokenConsumedResponse>() { // from class: com.ali.user.mobile.webview.WebViewActivity.2
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.AsyncTask
            public VerifyTokenConsumedResponse doInBackground(Object[] objArr) {
                try {
                    return VerifyServiceImpl.getInstance().goNonLoginConsume(verifyParam);
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public void onPostExecute(VerifyTokenConsumedResponse verifyTokenConsumedResponse) {
                if (verifyTokenConsumedResponse == null) {
                    BroadCastHelper.sendBroadcast(LoginAction.NOTIFY_IV_FAIL, false, -1, "RET_NULL", "");
                    WebViewActivity.this.finish();
                    return;
                }
                int i = verifyTokenConsumedResponse.code;
                if (i != 3000) {
                    BroadCastHelper.sendBroadcast(LoginAction.NOTIFY_IV_FAIL, false, i, verifyTokenConsumedResponse.message, "");
                    WebViewActivity.this.finish();
                    return;
                }
                BroadCastHelper.sendBroadcast(LoginAction.NOTIFY_IV_SUCCESS);
                WebViewActivity.this.finish();
            }
        }, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void goLogin(String str, String str2, String str3, boolean z, String str4, String str5, boolean z2, boolean z3, boolean z4, String str6) {
        goLogin(str2, z, z2, getLoginParam(str, str2, str3, str4, str5, z2, z3, str6));
    }

    @SuppressLint({"SetJavaScriptEnabled", "NewApi"})
    protected void init() {
        this.mAPRelativeLayout.addView(this.mWebView);
        this.mWebView.init();
        setWebChromClient();
        setWebViewClient();
        loadUrl(this.mUrl);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ali.user.mobile.base.ui.BaseActivity
    public void initViews() {
        this.mAPRelativeLayout = (RelativeLayout) findViewById(R.id.aliuser_id_webview);
        this.mProgressBar = (ProgressBar) findViewById(R.id.aliuser_web_progress_bar);
        try {
            createWebView();
            init();
        } catch (Throwable th) {
            th.printStackTrace();
            if (!TextUtils.isEmpty(this.eventName)) {
                HashMap hashMap = new HashMap();
                hashMap.put("result", "cancel");
                EventBus.getDefault().sendEvent(this.eventName, hashMap);
            }
            finish();
        }
    }

    protected void loadUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        TLogAdapter.d(TAG, "load url=" + str);
        this.mWebView.loadUrl(str);
    }

    @Override // com.ali.user.mobile.base.ui.BaseActivity
    protected boolean needToolbar() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == 720) {
            loadUrl(intent.getStringExtra("windvane"));
        } else if (i2 != 721) {
            LoginWebView loginWebView = this.mWebView;
            if (loginWebView != null) {
                loginWebView.onActivityResult(i, i2, intent);
            }
        } else {
            finish();
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        cancleOperation();
    }

    @Override // com.ali.user.mobile.base.ui.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        LoginParam loginParam;
        try {
            Intent intent = getIntent();
            this.mToken = intent.getStringExtra("token");
            this.mTokenType = intent.getStringExtra(WebConstant.WEB_LOGIN_TOKEN_TYPE);
            this.mUrl = intent.getStringExtra(WebConstant.WEBURL);
            this.mSecurityId = intent.getStringExtra("securityId");
            this.mLoginId = intent.getStringExtra(WebConstant.WEB_LOGIN_ID);
            this.mScene = intent.getStringExtra("scene");
            this.mLoginType = intent.getStringExtra(WebConstant.WEB_LOGIN_TYPE);
            this.mNativeLoginType = intent.getStringExtra(WebConstant.WEB_NATIVE_LOGIN_TYPE);
            this.mSNSTrustLoginToken = intent.getStringExtra(WebConstant.WEB_SNS_TRUST_LOGIN_TOKEN);
            this.mSite = intent.getIntExtra("site", DataProviderFactory.getDataProvider().getSite());
            this.mTokenType = intent.getStringExtra(WebConstant.WEB_LOGIN_TOKEN_TYPE);
            this.mIVScene = intent.getStringExtra(WebConstant.WEB_IV_SCENE);
            this.mUserId = intent.getStringExtra("USERID");
            this.eventName = intent.getStringExtra("eventName");
            this.mOriginalLoginParam = intent.getStringExtra(UIBaseConstants.IntentExtrasNamesConstants.PARAM_LOGIN_PARAM);
            JSONObject parseObject = JSON.parseObject(intent.getStringExtra("ext"));
            if (parseObject != null && parseObject.containsKey(WebConstant.SHOW_SKIP_MENU)) {
                this.isShowSkipMenu = ((Boolean) parseObject.get(WebConstant.SHOW_SKIP_MENU)).booleanValue();
            }
            if (parseObject != null && parseObject.containsKey(WebConstant.SKIP_LOGIN)) {
                this.skipLogin = ((Boolean) parseObject.get(WebConstant.SKIP_LOGIN)).booleanValue();
            }
            this.needCancelBroadcast = getIntent().getBooleanExtra(WebConstant.WEB_CANCEL_BROADCAST, false);
            this.mRequestCode = intent.getIntExtra("requestCode", 0);
            this.isLoginPost = intent.getBooleanExtra(WebConstant.WEB_POST_LOGIN, false);
            if (!TextUtils.isEmpty(this.mOriginalLoginParam) && (loginParam = (LoginParam) JSON.parseObject(this.mOriginalLoginParam, LoginParam.class)) != null) {
                String loginTypeByTraceId = UTConstant.getLoginTypeByTraceId(loginParam.traceId + "");
                if (TextUtils.isEmpty(loginTypeByTraceId)) {
                    loginTypeByTraceId = UTConstant.getLoginTypeByTokenType(loginParam.tokenType);
                }
                if (!TextUtils.isEmpty(loginTypeByTraceId)) {
                    Properties properties = new Properties();
                    properties.setProperty("monitor", "T");
                    properties.setProperty("h5_code", loginParam.errorCode + "");
                    UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, UTConstant.CustomEvent.UT_LOGIN_TO_H5_COMMIT, "", loginTypeByTraceId, properties);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        registerPlugin();
        initDataFromIntent();
        super.onCreate(bundle);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.clear();
        getMenuInflater().inflate(R.menu.aliuser_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override // com.ali.user.mobile.base.ui.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.isWebviewAlive) {
            try {
                this.mAPRelativeLayout.removeView(this.mWebView);
                this.mWebView.removeAllViews();
                this.mWebView.setVisibility(8);
                this.mWebView.destroy();
            } finally {
                try {
                } finally {
                }
            }
        }
        if (LoginSwitch.getSwitch("reset_in_destroy", "false")) {
            LoginStatus.resetLoginFlag();
        }
        WVPluginManager.unregisterPlugin("Verify");
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            cancleOperation();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initDataFromIntent();
        loadUrl(this.mUrl);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.aliuser_menu_item_help) {
            UrlParam urlParam = new UrlParam();
            urlParam.scene = "";
            urlParam.url = this.mHelpUrl;
            urlParam.site = DataProviderFactory.getDataProvider().getSite();
            ((NavigatorService) ServiceFactory.getService(NavigatorService.class)).openWebViewPage(this, urlParam);
        } else if (itemId == 257) {
            BroadCastHelper.sendBroadcast(LoginAction.WEB_ACTIVITY_SKIP);
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    protected boolean onPanelKeyDown() {
        LoginWebView loginWebView = this.mWebView;
        if (loginWebView == null) {
            return false;
        }
        if (this.isHookNativeBack && !this.isHookNativeBackByJs) {
            loginWebView.evaluateJavascript("(function() {if(typeof(_windvane_backControl)!=='undefined') return _windvane_backControl(); else return 'false';})()", new ValueCallback<String>() { // from class: com.ali.user.mobile.webview.WebViewActivity.1
                @Override // android.webkit.ValueCallback
                public void onReceiveValue(String str) {
                    if (WebViewActivity.this.mWebView == null) {
                        return;
                    }
                    if (TextUtils.isEmpty(str) ? false : !"false".equals(str.replace("\"", "").replace("'", ""))) {
                        WebViewActivity.this.mWebView.getWVCallBackContext().fireEvent("wvBackClickEvent", "{}");
                        return;
                    }
                    try {
                        Runtime.getRuntime().exec("input keyevent 4");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    WebViewActivity.this.isHookNativeBackByJs = true;
                }
            });
            return true;
        }
        this.isHookNativeBackByJs = false;
        loginWebView.getWVCallBackContext().fireEvent("WV.Event.Key.Back", "{}");
        return false;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        UTAnalytics.getInstance().getDefaultTracker().pageDisAppear(this);
        LoginWebView loginWebView = this.mWebView;
        if (loginWebView != null) {
            loginWebView.onPause();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (menu != null) {
            int i = R.id.aliuser_menu_item_more;
            if (menu.findItem(i) != null) {
                int i2 = R.id.aliuser_menu_item_help;
                if (menu.findItem(i2) != null) {
                    menu.findItem(i).setVisible(false);
                    if (this.isShowHelpMenu && !TextUtils.isEmpty(this.mHelpUrl)) {
                        LoginApprearanceExtensions loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions;
                        if (loginApprearanceExtensions != null && !loginApprearanceExtensions.needHelp()) {
                            menu.findItem(i2).setVisible(false);
                        } else {
                            menu.findItem(i2).setVisible(true);
                        }
                    } else {
                        menu.findItem(i2).setVisible(false);
                    }
                    if (this.isShowSkipMenu) {
                        if (menu.findItem(257) == null) {
                            menu.add(0, 257, 0, R.string.aliuser_skip).setVisible(true).setShowAsAction(1);
                        }
                    } else if (menu.findItem(257) != null) {
                        menu.removeItem(257);
                    }
                }
            }
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // com.ali.user.mobile.base.ui.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        UTAnalytics.getInstance().getDefaultTracker().updatePageName(this, PAGE_NAME);
        LoginWebView loginWebView = this.mWebView;
        if (loginWebView != null) {
            loginWebView.onResume();
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SuppressLint({"NewApi"})
    public boolean overrideUrlLoading(WebView webView, String str) {
        LoginFilterCallback loginFilterCallback;
        if (Debuggable.isDebug()) {
            TLogAdapter.d(TAG, "override url=" + str);
        }
        Uri parse = Uri.parse(str);
        Bundle serialBundle = BundleUtil.serialBundle(parse.getQuery());
        if (serialBundle == null) {
            serialBundle = new Bundle();
        }
        serialBundle.putInt("site", this.mSite);
        String string = serialBundle.getString("havana_mobile_reg_otherWebView");
        boolean startsWith = str.startsWith(WVUCWebViewClient.SCHEME_SMS);
        String str2 = PAGE_NAME;
        if (startsWith) {
            UserTrackAdapter.sendUT(PAGE_NAME, "SMS");
            try {
                startActivity(new Intent("android.intent.action.SENDTO", Uri.parse(str)));
            } catch (Exception unused) {
                TLogAdapter.e("WebViewActivity", "sms exception" + str);
            }
            return true;
        } else if (StringUtil.checkWebviewBridge(str)) {
            if (!TextUtils.isEmpty(this.mSecurityId)) {
                serialBundle.putString("securityId", this.mSecurityId);
            }
            String string2 = serialBundle.getString("action");
            String string3 = serialBundle.getString("loginId");
            String string4 = serialBundle.getString("token");
            String string5 = serialBundle.getString("scene");
            String string6 = serialBundle.getString("actionType");
            String string7 = serialBundle.getString("mergedAccount");
            if ("open_password_logincheck".equals(string6)) {
                goLogin(string3, serialBundle.getString("havana_iv_token"), null, true, "open_password_logincheck", parse.getQuery(), false, true, false, this.mTokenType);
                return true;
            } else if (!TextUtils.isEmpty(string2) && !"quit".equals(string2) && !"close".equals(string2)) {
                if ("relogin".equals(string2)) {
                    UserTrackAdapter.sendUT(PAGE_NAME, "LoginH5_Relogin");
                    serialBundle.putString("aliusersdk_h5querystring", parse.getQuery());
                    setResult(257, getIntent().putExtras(serialBundle));
                    finish();
                    return true;
                } else if ("mobile_confirm_login".equals(string2)) {
                    UserTrackAdapter.sendUT(PAGE_NAME, "LoginH5_MobileConfirmLogin");
                    goLogin((TextUtils.isEmpty(string3) || string3.equals("null")) ? this.mLoginId : string3, string4, this.mLoginType, true, "1014", null, false, true, false, this.mTokenType);
                    return true;
                } else if (ApiConstants.ApiField.TRUST_LOGIN.equals(string2)) {
                    loginHit(UTConstant.CustomEvent.UT_LOGIN_TO_H5_TRUST_LOGIN, UTConstant.CustomEvent.UT_LOGIN_TO_H5_SUCCESS, ApiConstants.ApiField.TRUST_LOGIN);
                    if (this.skipLogin && TextUtils.equals(this.mScene, "changePassword")) {
                        Intent intent = new Intent(LoginResActions.WEB_ACTIVITY_RESULT);
                        Bundle bundle = new Bundle();
                        bundle.putString("bizType", "changePassword");
                        bundle.putString("isSuc", "true");
                        intent.putExtras(bundle);
                        BroadCastHelper.sendLocalBroadCast(intent);
                        finish();
                        return true;
                    }
                    String str3 = (TextUtils.isEmpty(string3) || string3.equals("null")) ? this.mLoginId : string3;
                    String str4 = TextUtils.isEmpty(string5) ? this.mScene : string5;
                    if ("true".equals(string7)) {
                        BroadCastHelper.sendBroadcast(LoginAction.NOTIFY_ACCOUNT_MERGERED_SUCCESS);
                        this.mTokenType = TokenType.MERGE_ACCOUNT;
                    } else {
                        BroadCastHelper.sendBroadcast(LoginAction.NOTIFY_FOUND_PASSWORD_SUCCESS);
                    }
                    goLogin(str3, string4, this.mLoginType, true, str4, null, false, true, false, this.mTokenType);
                    return true;
                } else if (TextUtils.equals("continueLogin", string2)) {
                    loginHit(UTConstant.CustomEvent.UT_LOGIN_TO_H5_CONTINUE_LOGIN, UTConstant.CustomEvent.UT_LOGIN_TO_H5_SUCCESS, "continueLogin");
                    goLogin(this.mLoginId, this.mToken, this.mLoginType, true, this.mScene, parse.getQuery(), false, true, false, this.mTokenType);
                    return true;
                } else if (TextUtils.equals("passIVToken", string2)) {
                    UserTrackAdapter.sendUT(PAGE_NAME, "LoginH5_passIVToken");
                    String string8 = serialBundle.getString("havana_iv_token");
                    HashMap hashMap = new HashMap();
                    hashMap.put("token", string8);
                    hashMap.put("scene", string5);
                    BroadCastHelper.sendBroadcast(LoginAction.NOTIFY_IV_SUCCESS, false, 0, "", (Map<String, String>) hashMap, "");
                    finish();
                    return true;
                } else if (TextUtils.equals("consumeIVToken", string2)) {
                    VerifyParam verifyParam = new VerifyParam();
                    verifyParam.userId = this.mUserId;
                    verifyParam.actionType = this.mIVScene;
                    verifyParam.ivToken = serialBundle.getString("havana_iv_token");
                    verifyParam.fromSite = DataProviderFactory.getDataProvider().getSite();
                    goConsumeIV(verifyParam);
                    return true;
                } else if (TextUtils.equals("testAccountSso", string2)) {
                    UnifySsoLogin.tokenLogin(DataProviderFactory.getDataProvider().getSite(), string4, SessionManager.getInstance(DataProviderFactory.getApplicationContext()));
                    finish();
                    return true;
                } else if (TextUtils.equals("unityTrustLogin", string2)) {
                    loginHit(UTConstant.CustomEvent.UT_LOGIN_TO_H5_CONTINUE_LOGIN, UTConstant.CustomEvent.UT_LOGIN_TO_H5_SUCCESS, "unityTrustLogin");
                    UnifySsoLogin.tokenLogin(DataProviderFactory.getDataProvider().getSite(), string4, SessionManager.getInstance(DataProviderFactory.getApplicationContext()));
                    finish();
                    return true;
                } else if ("loginAfterRegister".equals(string2)) {
                    AppMonitorAdapter.commitSuccess("Page_Member_Register", "Register_Result_AutoLogin");
                    finish();
                    goLogin(string3, serialBundle.getString("token"), "", true, "1012", null, true, false, false, UTConstant.CustomEvent.UT_TYPE_SMS_LOGIN_TO_REG);
                    return true;
                } else if ("h5_fingerprint_open".equals(string2)) {
                    return sendTokenBack(serialBundle.getString("havana_iv_token"));
                } else {
                    return false;
                }
            } else if (this.isLoginPost && (loginFilterCallback = LoginPostHandler.sCallback) != null) {
                loginFilterCallback.onSuccess();
                LoginPostHandler.sCallback = null;
                UserTrackAdapter.sendUT("QuitPostUrl");
                finish();
                return true;
            } else {
                try {
                    if (!TextUtils.isEmpty(this.mOriginalLoginParam)) {
                        LoginParam loginParam = (LoginParam) JSON.parseObject(this.mOriginalLoginParam, LoginParam.class);
                        if (loginParam != null) {
                            Properties properties = new Properties();
                            properties.setProperty("sdkTraceId", loginParam.traceId + "");
                            if (!TextUtils.isEmpty(loginParam.loginSourcePage)) {
                                str2 = loginParam.loginSourcePage;
                            }
                            UserTrackAdapter.sendUT(str2, UTConstant.CustomEvent.UT_LOGIN_TO_H5_QUIT, properties);
                        }
                    } else {
                        UserTrackAdapter.sendUT(PAGE_NAME, UTConstant.CustomEvent.UT_LOGIN_TO_H5_QUIT);
                    }
                } catch (Exception unused2) {
                }
                LoginParam loginParam2 = this.ssoLoginParam;
                if (loginParam2 == null) {
                    Intent intent2 = new Intent(LoginResActions.WEB_ACTIVITY_RESULT);
                    intent2.putExtras(serialBundle);
                    BroadCastHelper.sendLocalBroadCast(intent2);
                    serialBundle.putSerializable(WebConstant.SSO_LOGIN_PARAM, this.ssoLoginParam);
                    setResult(258, getIntent().putExtras(serialBundle));
                    finish();
                    return true;
                }
                goLogin("", true, false, loginParam2);
                return true;
            }
        } else if (isProtocalUrl(str)) {
            Intent intent3 = new Intent();
            intent3.setClass(this, HtmlActivity.class);
            intent3.putExtra(WebConstant.WEBURL, str);
            startActivity(intent3);
            return true;
        } else if (string != null && "true".equals(string)) {
            Intent intent4 = new Intent();
            intent4.setClass(this, HtmlActivity.class);
            intent4.putExtra(WebConstant.WEBURL, str);
            startActivity(intent4);
            return true;
        } else if (str.contains(WINDVANECLOSEALL)) {
            finish();
            return true;
        } else {
            return false;
        }
    }

    protected void registerPlugin() {
        WVPluginManager.registerPlugin("Verify", (Class<? extends WVApiPlugin>) SecurityGuardBridge.class);
    }

    protected void sendCancelBroadcast() {
        if (!TextUtils.isEmpty(this.mIVScene)) {
            BroadCastHelper.sendBroadcast(LoginAction.NOTIFY_IV_FAIL, false, -5, LoginConstant.FETCH_IV_FAIL_CANCEL, "");
            return;
        }
        Intent intent = new Intent(LoginResActions.WEB_ACTIVITY_CANCEL);
        intent.putExtra(LoginConstants.H5_SEND_CANCEL_BROADCAST, this.needCancelBroadcast);
        BroadCastHelper.sendLocalBroadCast(intent);
    }

    protected boolean sendTokenBack(String str) {
        try {
            if (!TextUtils.isEmpty(this.eventName)) {
                HashMap hashMap = new HashMap();
                hashMap.put("token", str);
                hashMap.put("result", "success");
                EventBus.getDefault().sendEvent(this.eventName, hashMap);
            }
            finish();
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    protected void setWebChromClient() {
        this.mWebView.setWebChromeClient(new LoginWebChromeClient(this));
    }

    protected void setWebViewClient() {
        try {
            this.mWebView.setWebViewClient(new MyLoginWebViewClient(this));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @SuppressLint({"RestrictedApi"})
    public void switchHelpMenu(boolean z, String str) {
        this.mHelpUrl = str;
        this.isShowHelpMenu = z;
        invalidateOptionsMenu();
    }

    public void switchSkipMenu(boolean z) {
        this.isShowSkipMenu = z;
        invalidateOptionsMenu();
    }

    protected void goLogin(String str, boolean z, boolean z2, LoginParam loginParam) {
        try {
            if (!TextUtils.isEmpty(this.mOriginalLoginParam)) {
                LoginParam loginParam2 = (LoginParam) JSON.parseObject(this.mOriginalLoginParam, LoginParam.class);
                loginParam.loginSourcePage = loginParam2.loginSourcePage;
                loginParam.loginSourceSpm = loginParam2.loginSourceSpm;
                loginParam.loginSourceType = loginParam2.loginSourceType;
                loginParam.traceId = loginParam2.traceId;
                loginParam.spm = loginParam2.spm;
                loginParam.source = loginParam2.source;
                String str2 = loginParam2.traceId + "";
                if (!TextUtils.isEmpty(str) && TextUtils.equals(LoginType.LocalLoginType.RETRIVE_PWD_LOGIN, UTConstant.getLoginTypeByTraceId(str2))) {
                    Properties properties = new Properties();
                    properties.setProperty("sdkTraceId", str2 + "");
                    properties.setProperty("monitor", "T");
                    UserTrackAdapter.sendUT(loginParam.loginSourcePage, UTConstant.CustomEvent.UT_SINGLE_LOGIN_COMMIT, "", LoginType.LocalLoginType.RETRIVE_PWD_LOGIN, properties);
                }
            }
            if (!TextUtils.isEmpty(this.eventName)) {
                HashMap hashMap = new HashMap();
                hashMap.put(UIBaseConstants.IntentExtrasNamesConstants.PARAM_LOGIN_PARAM, JSON.toJSONString(loginParam));
                hashMap.put("result", "success");
                EventBus.getDefault().sendEvent(this.eventName, hashMap);
                finish();
                return;
            }
            goFistLoginPage(this, z, z2, loginParam);
        } catch (Exception unused) {
        }
    }
}
