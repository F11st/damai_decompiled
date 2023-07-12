package com.taobao.android.sns4android.jsbridge;

import android.app.Activity;
import android.content.Intent;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import android.text.TextUtils;
import com.ali.user.mobile.log.ApiReferer;
import com.ali.user.mobile.log.TLogAdapter;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.model.SNSSignInAccount;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.oauth.OauthService;
import com.taobao.android.sns4android.R;
import com.taobao.android.sns4android.SNSAuth;
import com.taobao.android.sns4android.SNSPlatform;
import com.taobao.android.sns4android.SNSSignInListener;
import java.util.Properties;
import mtopsdk.security.util.SignConstants;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class SNSJsbridge extends WVApiPlugin {
    public static final int AUHT_UNINSTALL_CODE = 10011;
    public static final int AUTH_CANCEL_CODE = 1009;
    public static final String AUTH_CANCEL_MESSAGE = "用户取消";
    public static final int AUTH_FAIL_CODE = 10010;
    public static final String AUTH_FAIL_MESSAGE = "用户授权失败";
    public static final String AUTH_UNINSTALL_MESSAGE = "当前授权应用未安装";
    public static int PARAM_ERROR_CODE = 1003;
    public static String PARAM_ERROR_MESSAGE = "参数错误";
    public static final int SNS_AUTH_NOT_INITED = 10012;
    public static int SYSTEM_ERROR_CODE = 1000;
    public static String SYSTEM_ERROR_MESSAGE = "E_SYSTEM_ERROR";
    public static final int TAOBAO_CANCEL_CODE = 1007;
    public static final String TAOBAO_CANCEL_MESSAGE = "用户取消";
    public static final int TAOBAO_ERROR_CODE = 1008;
    public static final String TAOBAO_ERROR_MESSAGE = "免登失败";
    public static final int TAOBAO_UNINSTALLED_OR_LAUNCH_ERROR = 10006;
    public static SNSSignInListener mWeixinListener;
    protected WVCallBackContext mCallback;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.sns4android.jsbridge.SNSJsbridge$a */
    /* loaded from: classes11.dex */
    public class C6618a implements SNSSignInListener {
        C6618a() {
        }

        @Override // com.taobao.android.sns4android.SNSSignInListener
        public void onCancel(Activity activity, String str) {
            TLogAdapter.e(ApiReferer.TAG, "auth jsbridge oncancel");
            SNSJsbridge.mWeixinListener = null;
            SNSJsbridge.this.setErrorCallback(1009, "用户取消");
        }

        @Override // com.taobao.android.sns4android.SNSSignInListener
        public void onError(Activity activity, String str, int i, String str2) {
            Properties properties = new Properties();
            properties.setProperty("code", String.valueOf(i));
            UserTrackAdapter.sendUT("SNSJsbridgeAuthFail", properties);
            TLogAdapter.e(ApiReferer.TAG, "auth jsbridge onError:" + i + "," + str2);
            SNSJsbridge.mWeixinListener = null;
            if (i != 10011 || TextUtils.isEmpty(str2)) {
                SNSJsbridge.this.setErrorCallback(10010, SNSJsbridge.AUTH_FAIL_MESSAGE);
            } else {
                SNSJsbridge.this.setErrorCallback(i, str2);
            }
        }

        @Override // com.taobao.android.sns4android.SNSSignInListener
        public void onSucceed(Activity activity, SNSSignInAccount sNSSignInAccount) {
            SNSJsbridge.mWeixinListener = null;
            if (SNSJsbridge.this.mCallback != null) {
                WVResult wVResult = new WVResult();
                TLogAdapter.d(ApiReferer.TAG, "token=" + sNSSignInAccount.token);
                wVResult.addData(SignConstants.MIDDLE_PARAM_AUTHCODE, sNSSignInAccount.token);
                wVResult.addData("token", sNSSignInAccount.token);
                wVResult.addData("userId", sNSSignInAccount.userId);
                wVResult.setResult(WVResult.SUCCESS);
                SNSJsbridge.this.mCallback.success(wVResult);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setErrorCallback(int i, String str) {
        if (this.mCallback != null) {
            WVResult wVResult = new WVResult();
            wVResult.addData("code", Integer.valueOf(i));
            wVResult.addData("message", str);
            this.mCallback.error(wVResult);
        }
    }

    private void setSuccessCallback(boolean z) {
        if (this.mCallback != null) {
            WVResult wVResult = new WVResult();
            wVResult.setResult(WVResult.SUCCESS);
            wVResult.addData("supported", Boolean.valueOf(z));
            this.mCallback.success(wVResult);
        }
    }

    public synchronized void auth(String str, WVCallBackContext wVCallBackContext) {
        JSONObject jSONObject;
        SNSPlatform convertSNSPlatform;
        this.mCallback = wVCallBackContext;
        try {
            jSONObject = new JSONObject(str);
            convertSNSPlatform = AccountBindJSBridge.convertSNSPlatform(jSONObject.getString("type"));
        } catch (Exception unused) {
            setErrorCallback(PARAM_ERROR_CODE, PARAM_ERROR_MESSAGE);
        }
        if (convertSNSPlatform == null) {
            setErrorCallback(PARAM_ERROR_CODE, PARAM_ERROR_MESSAGE);
            return;
        }
        Activity activity = (Activity) this.mContext;
        C6618a c6618a = new C6618a();
        if (SNSPlatform.PLATFORM_WEIXIN == convertSNSPlatform) {
            mWeixinListener = c6618a;
        }
        SNSAuth.auth(convertSNSPlatform, activity, c6618a, jSONObject);
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if ("auth".equals(str)) {
            auth(str2, wVCallBackContext);
            return true;
        } else if ("isAppAuthSupport".equals(str)) {
            isAppAuthSupport(str2, wVCallBackContext);
            return true;
        } else {
            return false;
        }
    }

    public synchronized void isAppAuthSupport(String str, WVCallBackContext wVCallBackContext) {
        this.mCallback = wVCallBackContext;
        String string = new JSONObject(str).getString("type");
        SNSPlatform convertSNSPlatform = AccountBindJSBridge.convertSNSPlatform(string);
        if (convertSNSPlatform == null) {
            setErrorCallback(PARAM_ERROR_CODE, PARAM_ERROR_MESSAGE);
            return;
        }
        Activity activity = (Activity) this.mContext;
        if (!SNSAuth.isGoogle(convertSNSPlatform) && !SNSAuth.isFacebook(convertSNSPlatform) && !SNSAuth.isTwitter(convertSNSPlatform) && !SNSAuth.isLinkedin(convertSNSPlatform) && !SNSAuth.isLine(convertSNSPlatform)) {
            if (AliMemberSDK.getService(OauthService.class) != null) {
                if ("weixin".equals(string)) {
                    string = "wechat";
                }
                setSuccessCallback(((OauthService) AliMemberSDK.getService(OauthService.class)).isAppAuthSurpport(activity, string));
            } else {
                setErrorCallback(10012, activity.getString(R.string.aliuser_SNS_platform_auth_not_init_ucc));
            }
        }
        setSuccessCallback(false);
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 11101) {
            SNSAuth.onActivityResult(SNSPlatform.PLATFORM_QQ, i, i2, intent);
        } else {
            SNSAuth.onActivityResult(SNSPlatform.PLATFORM_WEIBO, i, i2, intent);
            SNSAuth.onActivityResult(SNSPlatform.PLATFORM_WEIXIN, i, i2, intent);
            SNSAuth.onActivityResult(SNSPlatform.PLATFORM_ALIPAY, i, i2, intent);
        }
        super.onActivityResult(i, i2, intent);
    }
}
