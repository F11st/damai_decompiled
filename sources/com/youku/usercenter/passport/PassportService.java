package com.youku.usercenter.passport;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.webkit.WebView;
import com.ali.user.mobile.register.RegistConstants;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.ucc.UccCallback;
import com.ali.user.open.ucc.UccService;
import com.ali.user.open.ucc.util.UccConstants;
import com.taobao.accs.common.Constants;
import com.taobao.tlog.adapter.AdapterForTLog;
import com.taobao.weex.bridge.WXBridgeManager;
import com.youku.passport.result.AbsResult;
import com.youku.usercenter.passport.PassportManager;
import com.youku.usercenter.passport.remote.ICallback;
import com.youku.usercenter.passport.result.ConfigResult;
import com.youku.usercenter.passport.result.Result;
import com.youku.usercenter.passport.result.VerifyCookieResult;
import com.youku.usercenter.passport.statistics.PassportAppMonitor;
import com.youku.usercenter.passport.statistics.Statistics;
import com.youku.usercenter.passport.util.CookieUtil;
import com.youku.usercenter.passport.util.Logger;
import com.youku.usercenter.passport.util.MiscUtil;
import com.youku.usercenter.passport.util.SysUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class PassportService {
    private static final long DEFAULT_CLICK_SEC = 1000;
    private static final String DEFAULT_LOGIN = "https://account.youku.com/wap/login.htm";
    private static final String DEFAULT_LOGIN2 = "https://account.youku.com/";
    private static final String DEFAULT_LOGOUT = "passport://logout";
    private static final String DEFAULT_LOGOUT2 = "https://account.youku.com/logoutAll.htm";
    private static final String DEFAULT_REGISTER = "https://account.youku.com/wap/register.htm";
    private static final String LOGIN_FROM_H5 = "h5";
    private static final String LOGIN_FROM_QRAUTH = "qrAuth";
    private static long mLastClickTime;
    private Activity mActivity;
    private String mCallbackUrl;
    private PassportConfig mConfig;
    private boolean mLastLoginState;
    private long mLastVerifyTime;
    private PassportProcessor mProcessor;
    private String mQrAuthCode;
    private String mQrAuthShortUrl;
    private String mQrAuthUrl;
    private int mRequestCode = -1;
    private ArrayList<TaobaoLoginListener> mTaobaoLoginListeners;
    private ArrayList<TaobaoRegisterListener> mTaobaoRegisterListeners;
    private WebView mWebView;
    private ICallback mWebviewCallback;
    private boolean mWebviewLogout;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface TaobaoLoginListener {
        void onLoginCancel();

        void onLoginFail();

        void onLoginSuccess(boolean z);
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface TaobaoRegisterListener {
        void onRegisterCancel();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PassportService(Context context, PassportConfig passportConfig) {
        this.mConfig = passportConfig;
        this.mProcessor = new PassportProcessor(context, passportConfig);
    }

    private void doExpireLogout(int i) {
        if (PassportManager.getInstance().isLogin()) {
            PassportManager.getInstance().getAccount().clearAccount(false);
            PassportManager.getInstance().stopRefreshTask();
            PassportManager.getInstance().updateAuthorizeStatus(PassportManager.AuthorizeStatus.EXPIRE_LOGOUT);
            AdapterForTLog.loge("YKLogin.PassportService", "Broadcast EXPIRE_LOGOUT logout! Reason: " + i);
            MiscUtil.logoutTaobao(null);
            return;
        }
        AdapterForTLog.loge("YKLogin.PassportService", "doExpireLogout but not login! errorCode = " + i);
    }

    private String getCallbackUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return Uri.parse(str).getQueryParameter(WXBridgeManager.METHOD_CALLBACK);
    }

    private boolean isFastClickInSec(long j) {
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = currentTimeMillis - mLastClickTime;
        if (0 >= j2 || j2 >= j) {
            mLastClickTime = currentTimeMillis;
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processTaobaoLoginResult(String str, String str2) throws Exception {
        JSONObject jSONObject;
        boolean z;
        String str3;
        String str4;
        String str5;
        String str6;
        boolean z2;
        JSONObject jSONObject2 = new JSONObject(str);
        JSONObject jSONObject3 = new JSONObject(new JSONObject(jSONObject2.optString("youkuExt")).optString("content"));
        JSONObject optJSONObject = jSONObject3.optJSONObject("sessionInfo");
        long optLong = optJSONObject.optLong("cookieExpireTime");
        String optString = optJSONObject.optString("ptoken");
        JSONObject optJSONObject2 = jSONObject3.optJSONObject(Constants.KEY_USER_ID);
        String optString2 = optJSONObject2.optString(CookieUtil.COOKIE_KEY_YKTK);
        String optString3 = optJSONObject2.optString("ytid");
        String optString4 = optJSONObject2.optString("yid");
        String optString5 = optJSONObject2.optString("tid");
        String optString6 = optJSONObject2.optString("uid");
        String optString7 = optJSONObject2.optString("nickname");
        String optString8 = optJSONObject2.optString("avatar");
        JSONObject optJSONObject3 = jSONObject3.optJSONObject("userProfile");
        if (optJSONObject3 != null) {
            str5 = optJSONObject3.optString("email");
            String optString9 = optJSONObject3.optString(RegistConstants.REGION_INFO);
            String optString10 = optJSONObject3.optString("mobile");
            boolean optBoolean = optJSONObject3.optBoolean("hasMobile");
            str4 = optString10;
            z = optBoolean;
            z2 = optJSONObject3.optBoolean("isLoginMobile");
            str6 = optJSONObject3.optString("maskMobile");
            str3 = optString9;
            jSONObject = jSONObject2;
        } else {
            jSONObject = jSONObject2;
            z = false;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            z2 = false;
        }
        JSONObject optJSONObject4 = jSONObject3.optJSONObject("sdkCookieInfo");
        Account account = PassportManager.getInstance().getAccount();
        account.saveOrClearLastAccount(false);
        account.mPToken = optString;
        account.mUserName = str2;
        account.mYktk = optString2;
        account.mYtid = optString3;
        account.mYid = optString4;
        account.mTid = optString5;
        account.mYoukuUid = optString6;
        account.mNickName = optString7;
        account.mAvatarUrl = optString8;
        account.mExpireTime = optLong;
        account.mEmail = str5;
        account.mRegion = str3;
        account.mMobile = str4;
        account.mBoundMobile = z;
        account.mIsLoginMobile = z2;
        account.mMaskMobile = str6;
        account.updateExtraCookie(optJSONObject4);
        account.refreshSToken();
        account.save();
        PassportPreference.getInstance(this.mConfig.mContext).setCookieRefreshTime(PassportManager.getInstance().getTimestamp());
        if (TextUtils.isEmpty(optString)) {
            CookieUtil.clearStoken(this.mConfig.mContext);
            CookieUtil.syncCookie(this.mConfig.mContext, null, optString2);
            account.refreshCookie();
        } else {
            PassportManager.getInstance().startRefreshTask();
        }
        AdapterForTLog.loge("YKLogin.Login", "pToken is empty = " + TextUtils.isEmpty(optString) + " yktk is empty = " + TextUtils.isEmpty(optString2));
        Statistics.setLoginFrom(null);
        PassportPreference.getInstance(this.mConfig.mContext).setEncryptedYtId(jSONObject.optString("encryptYtId"));
    }

    public void getGlobalConfig(com.youku.usercenter.passport.callback.ICallback<ConfigResult> iCallback) {
        this.mProcessor.getGlobalConfig(iCallback);
    }

    public void h5ToNativeLogin(final ICallback iCallback) {
        if (this.mWebviewLogout) {
            new Handler().post(new Runnable() { // from class: com.youku.usercenter.passport.PassportService.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        iCallback.onResult(0, "");
                    } catch (Exception e) {
                        Logger.printStackTrace(e);
                    }
                }
            });
            this.mWebviewLogout = false;
            return;
        }
        this.mWebviewCallback = iCallback;
    }

    public boolean handleCookieError(int i, long j) {
        AdapterForTLog.loge("YKLogin.PassportService", "handleCookieError errorCode = " + i + " timeStamp = " + j + "trace = " + SysUtil.readThreadStack());
        if (i >= 400 && i <= 420) {
            doExpireLogout(i);
            return false;
        }
        if (i != 515 && i != 516 && i != 590 && i != 644) {
            if (i != 712) {
                if (i != 714) {
                    if (i != 715) {
                        return true;
                    }
                }
            }
            if (j > 0) {
                PassportManager.getInstance().updateSyncTime(j);
            }
            PassportManager.getInstance().getAccount().refreshSToken();
            PassportAppMonitor.commitSTokenExpire("server");
            return true;
        }
        doExpireLogout(i);
        return false;
    }

    public void logout(String str) {
        this.mProcessor.logout(str);
    }

    public void onAppForeground(boolean z) {
        if (PassportManager.getInstance().isLogin()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - this.mLastVerifyTime) >= 1000) {
                this.mLastVerifyTime = currentTimeMillis;
                com.youku.usercenter.passport.callback.ICallback<VerifyCookieResult> iCallback = new com.youku.usercenter.passport.callback.ICallback<VerifyCookieResult>() { // from class: com.youku.usercenter.passport.PassportService.5
                    @Override // com.youku.usercenter.passport.callback.ICallback
                    public void onFailure(VerifyCookieResult verifyCookieResult) {
                        PassportService.this.handleCookieError(verifyCookieResult.getResultCode(), -1L);
                    }

                    @Override // com.youku.usercenter.passport.callback.ICallback
                    public void onSuccess(VerifyCookieResult verifyCookieResult) {
                        PassportPreference passportPreference = PassportPreference.getInstance(PassportService.this.mConfig.mContext);
                        if (passportPreference.getCookieRefreshTime() + passportPreference.getCookieRefreshInterval() >= verifyCookieResult.mCurrentTime || TextUtils.isEmpty(PassportManager.getInstance().getAccount().mPToken)) {
                            return;
                        }
                        Logger.i("will extend PToken");
                        PassportService.this.mProcessor.extendCookie(new com.youku.usercenter.passport.callback.ICallback<Result>() { // from class: com.youku.usercenter.passport.PassportService.5.1
                            @Override // com.youku.usercenter.passport.callback.ICallback
                            public void onFailure(Result result) {
                                Logger.d("extendCookie failure " + result.getResultMsg());
                            }

                            @Override // com.youku.usercenter.passport.callback.ICallback
                            public void onSuccess(Result result) {
                                Logger.d("extendCookie success " + result.getResultMsg());
                            }
                        });
                    }
                };
                Account account = PassportManager.getInstance().getAccount();
                if (z) {
                    account.refreshSToken();
                }
                this.mProcessor.havanaVerifyCookie(iCallback);
            }
        }
    }

    public void processLoginResult(JSONObject jSONObject, String str, String str2) throws Exception {
        this.mProcessor.processLoginResult(jSONObject, str, str2);
    }

    public void registerTaobaoLoginListener(TaobaoLoginListener taobaoLoginListener) {
        if (this.mTaobaoLoginListeners == null) {
            this.mTaobaoLoginListeners = new ArrayList<>();
        }
        if (taobaoLoginListener != null) {
            this.mTaobaoLoginListeners.add(taobaoLoginListener);
        }
    }

    public void registerTaobaoRegListener(TaobaoRegisterListener taobaoRegisterListener) {
        if (this.mTaobaoRegisterListeners == null) {
            this.mTaobaoRegisterListeners = new ArrayList<>();
        }
        if (taobaoRegisterListener != null) {
            this.mTaobaoRegisterListeners.add(taobaoRegisterListener);
        }
    }

    public boolean shouldOverrideUrlLoading(final WebView webView, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            int indexOf = str.indexOf(63);
            String substring = indexOf > -1 ? str.substring(0, indexOf) : str;
            List<String> list = this.mConfig.mRegisterUrls;
            if (list != null && list.size() > 0) {
                for (int i = 0; i < this.mConfig.mRegisterUrls.size(); i++) {
                    if (substring.equals(this.mConfig.mRegisterUrls.get(i))) {
                        this.mWebView = webView;
                        this.mCallbackUrl = getCallbackUrl(str);
                        this.mLastLoginState = PassportManager.getInstance().isLogin();
                        startRegisterActivity(this.mConfig.mContext, "h5");
                        return true;
                    }
                }
            } else if (substring.equals(DEFAULT_REGISTER)) {
                this.mWebView = webView;
                this.mCallbackUrl = getCallbackUrl(str);
                this.mLastLoginState = PassportManager.getInstance().isLogin();
                startRegisterActivity(this.mConfig.mContext, "h5");
                return true;
            }
            List<String> list2 = this.mConfig.mLoginUrls;
            if (list2 != null && list2.size() > 0) {
                for (int i2 = 0; i2 < this.mConfig.mLoginUrls.size(); i2++) {
                    if (substring.equals(this.mConfig.mLoginUrls.get(i2))) {
                        this.mWebView = webView;
                        this.mCallbackUrl = getCallbackUrl(str);
                        this.mLastLoginState = PassportManager.getInstance().isLogin();
                        startLoginActivity(this.mConfig.mContext, "h5");
                        return true;
                    }
                }
            } else {
                if (!substring.equals(DEFAULT_LOGIN)) {
                    if (substring.equals(DEFAULT_LOGIN2)) {
                    }
                }
                this.mWebView = webView;
                this.mCallbackUrl = getCallbackUrl(str);
                this.mLastLoginState = PassportManager.getInstance().isLogin();
                startLoginActivity(this.mConfig.mContext, "h5");
                return true;
            }
            if (substring.equals(DEFAULT_LOGOUT) || substring.equals(DEFAULT_LOGOUT2)) {
                logout("h5");
                if (webView != null) {
                    webView.post(new Runnable() { // from class: com.youku.usercenter.passport.PassportService.2
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                webView.reload();
                            } catch (Exception e) {
                                Logger.printStackTrace(e);
                            }
                        }
                    });
                } else {
                    this.mWebviewLogout = true;
                }
                return true;
            }
        } catch (Exception e) {
            Logger.printStackTrace(e);
        }
        return false;
    }

    public void startLoginActivity(Context context, String str) {
        startLoginActivity(context, null, str);
    }

    public void startLoginActivity(Context context, String str, String str2, String str3, String str4, boolean z, Bundle bundle) {
    }

    public void startRegisterActivity(Context context, String str) {
    }

    public void uccTrustLogin(String str, Map map, final com.youku.usercenter.passport.callback.ICallback<AbsResult> iCallback) {
        UccService uccService = (UccService) AliMemberSDK.getService(UccService.class);
        if (uccService == null) {
            Result result = new Result();
            result.setResultCode(-201);
            result.setResultMsg(Result.MSG_ERROR_UCC_SERVICE_NULL);
            iCallback.onFailure(result);
            return;
        }
        uccService.trustLogin(str, map, new UccCallback() { // from class: com.youku.usercenter.passport.PassportService.4
            @Override // com.ali.user.open.ucc.UccCallback
            public void onFail(String str2, int i, String str3) {
                Result result2 = new Result();
                result2.setResultCode(i);
                result2.setResultMsg(str3);
                iCallback.onFailure(result2);
            }

            @Override // com.ali.user.open.ucc.UccCallback
            public void onSuccess(String str2, Map map2) {
                JSONObject optJSONObject;
                if (map2 != null && map2.containsKey(UccConstants.PARAM_LOGIN_DATA)) {
                    String str3 = (String) map2.get(UccConstants.PARAM_LOGIN_DATA);
                    try {
                        JSONObject jSONObject = new JSONObject(str3);
                        if (jSONObject.has("data") && (optJSONObject = jSONObject.optJSONObject("data")) != null && optJSONObject.has("loginServiceExt")) {
                            str3 = optJSONObject.optString("loginServiceExt");
                        }
                        PassportService.this.processTaobaoLoginResult(str3, null);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (iCallback != null) {
                        Result result2 = new Result();
                        result2.setResultCode(0);
                        iCallback.onSuccess(result2);
                        return;
                    }
                    return;
                }
                Result result3 = new Result();
                result3.setResultCode(-202);
                result3.setResultMsg(Result.MSG_ERROR_NO_DATA);
                iCallback.onFailure(result3);
            }
        });
    }

    public void unregisterTaobaoLoginListener(TaobaoLoginListener taobaoLoginListener) {
        ArrayList<TaobaoLoginListener> arrayList = this.mTaobaoLoginListeners;
        if (arrayList == null || taobaoLoginListener == null) {
            return;
        }
        arrayList.remove(taobaoLoginListener);
    }

    public void unregisterTaobaoRegListener(TaobaoRegisterListener taobaoRegisterListener) {
        ArrayList<TaobaoRegisterListener> arrayList = this.mTaobaoRegisterListeners;
        if (arrayList == null || taobaoRegisterListener == null) {
            return;
        }
        arrayList.remove(taobaoRegisterListener);
    }

    public void yktk4PToken() {
        Account account = PassportManager.getInstance().getAccount();
        if (TextUtils.isEmpty(account.mYktk) || !TextUtils.isEmpty(account.mPToken)) {
            return;
        }
        this.mProcessor.extendCookie(new com.youku.usercenter.passport.callback.ICallback<Result>() { // from class: com.youku.usercenter.passport.PassportService.1
            @Override // com.youku.usercenter.passport.callback.ICallback
            public void onFailure(Result result) {
                AdapterForTLog.loge("YKLogin.yktk4PToken", "yktk4PToken fail");
                Logger.d("yktk extendCookie failure " + result.getResultMsg());
            }

            @Override // com.youku.usercenter.passport.callback.ICallback
            public void onSuccess(Result result) {
                AdapterForTLog.loge("YKLogin.yktk4PToken", "yktk4PToken success");
                Logger.d("yktk extendCookie success " + result.getResultMsg());
            }
        });
    }

    public void startLoginActivity(Context context, String str, String str2) {
        startLoginActivity(context, str, str2, null, null, true);
    }

    public void startLoginActivity(Context context, String str, String str2, String str3, String str4, boolean z) {
        startLoginActivity(context, str, str2, str3, str4, z, new Bundle());
    }
}
