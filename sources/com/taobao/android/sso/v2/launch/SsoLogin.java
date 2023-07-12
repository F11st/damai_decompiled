package com.taobao.android.sso.v2.launch;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.base.helper.BroadCastHelper;
import com.ali.user.mobile.info.AlipayInfo;
import com.ali.user.mobile.info.AppInfo;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.model.LoginType;
import com.ali.user.mobile.rpc.safe.Rsa;
import com.ali.user.mobile.security.SSOSecurityService;
import com.ali.user.mobile.utils.Constants;
import com.alibaba.wireless.security.open.SecException;
import com.alipay.auth.mobile.api.IAlipayAuthEventHandler;
import com.alipay.auth.mobile.exception.AlipayAuthIllegalArgumentException;
import com.alipay.auth.mobile.exception.PreAlipayAuthException;
import com.taobao.android.TBSsoLogin;
import com.taobao.android.sso.v2.launch.alipay.AlipayAuthManager;
import com.taobao.android.sso.v2.launch.exception.SSOException;
import com.taobao.android.sso.v2.launch.model.ISsoRemoteParam;
import com.taobao.android.sso.v2.launch.model.SSOSlaveParam;
import com.taobao.android.sso.v2.model.SSOIPCConstants;
import com.taobao.login4android.config.LoginSwitch;
import com.taobao.login4android.constants.LoginEnvType;
import java.util.Properties;
import java.util.UUID;
import tb.uj2;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class SsoLogin {
    public static final String TAG = "Login.TBSsoLogin";
    private static String uuid;

    public static void bindAuth(Activity activity, ISsoRemoteParam iSsoRemoteParam, String str) throws SSOException {
        if (activity == null || iSsoRemoteParam == null || TextUtils.isEmpty(str)) {
            return;
        }
        launchTao(activity, iSsoRemoteParam, str, true);
    }

    public static void getAlipaySsoToken(Activity activity, String str, String str2, String str3, String str4) throws PreAlipayAuthException, AlipayAuthIllegalArgumentException {
        DataProviderFactory.getDataProvider().setAlipaySsoDesKey(str);
        AlipayAuthManager.getInstance().getAlipayAuth().openAlipayAuth(activity, str, str2, str3, str4);
    }

    public static ISsoRemoteParam getSsoRemoteParam() {
        return new ISsoRemoteParam() { // from class: com.taobao.android.sso.v2.launch.SsoLogin.1
            @Override // com.taobao.android.sso.v2.launch.model.ISsoRemoteParam
            public String getApdid() {
                return AlipayInfo.getInstance().getApdid();
            }

            @Override // com.taobao.android.sso.v2.launch.model.ISsoRemoteParam
            public String getAppKey() {
                return DataProviderFactory.getDataProvider().getAppkey();
            }

            @Override // com.taobao.android.sso.v2.launch.model.ISsoRemoteParam
            public String getAtlas() {
                if (DataProviderFactory.getDataProvider().getEnvType() == LoginEnvType.DEV.getSdkEnvType()) {
                    return "daily";
                }
                return null;
            }

            @Override // com.taobao.android.sso.v2.launch.model.ISsoRemoteParam
            public String getDeviceId() {
                return DataProviderFactory.getDataProvider().getDeviceId();
            }

            @Override // com.taobao.android.sso.v2.launch.model.ISsoRemoteParam
            public String getTtid() {
                return DataProviderFactory.getDataProvider().getTTID();
            }

            @Override // com.taobao.android.sso.v2.launch.model.ISsoRemoteParam
            public String getUmidToken() {
                return AppInfo.getInstance().getUmidToken();
            }
        };
    }

    private static String getTargetUrl(Context context) {
        return context.getPackageName();
    }

    public static void handleAlipaySSOIntent(Intent intent, IAlipayAuthEventHandler iAlipayAuthEventHandler) {
        if (isAlipayAuthCallBack(intent)) {
            try {
                AlipayAuthManager.getInstance().getAlipayAuth().handleIntent(intent, iAlipayAuthEventHandler);
            } catch (AlipayAuthIllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }

    public static void handleAlipaySSOResultIntent(Intent intent, final ILoginListener iLoginListener) {
        if (isAlipayAuthCallBack(intent)) {
            try {
                AlipayAuthManager.getInstance().getAlipayAuth().handleIntent(intent, new IAlipayAuthEventHandler() { // from class: com.taobao.android.sso.v2.launch.SsoLogin.2
                    @Override // com.alipay.auth.mobile.api.IAlipayAuthEventHandler
                    public void alipayAuthDidCancel() {
                        ILoginListener.this.onFail(new SSOException("-1"));
                    }

                    @Override // com.alipay.auth.mobile.api.IAlipayAuthEventHandler
                    public void alipayAuthFailure() {
                        ILoginListener.this.onFail(new SSOException("-2"));
                    }

                    @Override // com.alipay.auth.mobile.api.IAlipayAuthEventHandler
                    public void alipayAuthSuccess(String str) {
                        ILoginListener.this.onSuccess(null);
                    }
                });
            } catch (AlipayAuthIllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }

    public static void handleResultIntent(ILoginListener iLoginListener, Intent intent) {
        if (iLoginListener == null) {
            return;
        }
        int i = -1;
        if (intent == null) {
            iLoginListener.onFail(new SSOException((Integer) (-1), "intent is null"));
            return;
        }
        Properties properties = new Properties();
        properties.setProperty("monitor", "T");
        LoginParam loginParam = TBSsoLogin.a;
        String str = loginParam == null ? UTConstant.PageName.UT_PAGE_EXTEND : loginParam.loginSourcePage;
        Bundle extras = intent.getExtras();
        if (extras != null) {
            try {
                i = extras.getInt(SSOIPCConstants.APPLY_SSO_RESULT);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (i == 500) {
                UserTrackAdapter.sendUT(str, UTConstant.CustomEvent.UT_SSO_AUTHCODE_SUCCESS, "", LoginType.LocalLoginType.SSO_LOGIN, properties);
                iLoginListener.onSuccess(intent);
                return;
            }
            if (i == 504) {
                UserTrackAdapter.sendUT(str, UTConstant.CustomEvent.UT_SSO_AUTHCODE_CANCEL, i + "", LoginType.LocalLoginType.SSO_LOGIN, properties);
            } else {
                UserTrackAdapter.sendUT(str, UTConstant.CustomEvent.UT_SSO_AUTHCODE_FAILURE, i + "", LoginType.LocalLoginType.SSO_LOGIN, properties);
            }
            iLoginListener.onFail(new SSOException(Integer.valueOf(i), ""));
            return;
        }
        UserTrackAdapter.sendUT(str, UTConstant.CustomEvent.UT_SSO_AUTHCODE_FAILURE, "", LoginType.LocalLoginType.SSO_LOGIN, properties);
        BroadCastHelper.sendLoginFailBroadcast(-1, "bundle is null");
        iLoginListener.onFail(new SSOException((Integer) (-1), "bundle is null"));
    }

    public static boolean isAlipayAuthCallBack(Intent intent) {
        try {
            return AlipayAuthManager.getInstance().getAlipayAuth().isAlipayAuthCallBack(intent);
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean isSchemeSupport(Context context, String str, String str2) {
        Intent intent;
        PackageManager packageManager = context.getPackageManager();
        try {
            packageManager.getPackageInfo("com.taobao.taobao", 1);
            intent = new Intent();
            intent.setAction(str);
            intent.setData(Uri.parse(str2));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return packageManager.queryIntentActivities(intent, 0).size() > 0;
    }

    public static boolean isSupportAliaySso() {
        return AlipayAuthManager.getInstance().getAlipayAuth().isAlipayAppInstalled() && AlipayAuthManager.getInstance().getAlipayAuth().isAlipayAppSurpportAPI();
    }

    public static boolean isSupportTBAuthBind(Context context) {
        return isSchemeSupport(context, "com.taobao.open.intent.action.BIND_AUTH", "tbopen://m.taobao.com/bind_auth?");
    }

    public static boolean isSupportTBSsoV2(Context context) {
        return isSchemeSupport(context, uj2.ACTION_CUSTOM, "tbopen://m.taobao.com/sso?");
    }

    public static boolean isTaobaoAppInstalled(Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.taobao.taobao", 0);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static void launchAlipay(Activity activity) throws Exception {
        launchAlipay(activity, DataProviderFactory.getDataProvider().getAlipaySsoDesKey());
    }

    public static void launchTao(Activity activity) throws SSOException {
        launchTao(activity, getSsoRemoteParam(), null);
    }

    public static void launchAlipay(Activity activity, String str) throws Exception {
        String apdidToken = AlipayInfo.getInstance().getApdidToken();
        String targetUrl = getTargetUrl(activity);
        launchAlipay(activity, str, apdidToken, targetUrl, getTargetUrl(activity) + ".ResultActivity");
    }

    public static void launchTao(Activity activity, ISsoRemoteParam iSsoRemoteParam) throws SSOException {
        launchTao(activity, iSsoRemoteParam, null);
    }

    public static void launchAlipay(Activity activity, String str, String str2, String str3, String str4) throws Exception {
        DataProviderFactory.getDataProvider().setAlipaySsoDesKey(str);
        AlipayAuthManager.getInstance().getAlipayAuth().openAlipayAuth(activity, str, str2, str3, str4);
        Properties properties = new Properties();
        properties.setProperty("monitor", "T");
        LoginParam loginParam = TBSsoLogin.a;
        UserTrackAdapter.sendUT(loginParam == null ? UTConstant.PageName.UT_PAGE_EXTEND : loginParam.loginSourcePage, UTConstant.CustomEvent.UT_SSO_AUTHCODE_COMMIT, "", LoginType.LocalLoginType.ASO_LOGIN, properties);
    }

    public static void launchTao(Activity activity, ISsoRemoteParam iSsoRemoteParam, String str) throws SSOException {
        launchTao(activity, iSsoRemoteParam, str, false);
    }

    private static void launchTao(Activity activity, ISsoRemoteParam iSsoRemoteParam, String str, boolean z) throws SSOException {
        UserTrackAdapter.sendUT(UTConstant.CustomEvent.UT_TBAUTH_OPEN);
        if (activity != null && iSsoRemoteParam != null) {
            SSOSlaveParam sSOSlaveParam = new SSOSlaveParam();
            sSOSlaveParam.appKey = iSsoRemoteParam.getAppKey();
            sSOSlaveParam.ssoVersion = SSOIPCConstants.CURRENT_SSO_VERSION;
            sSOSlaveParam.t = System.currentTimeMillis();
            sSOSlaveParam.targetUrl = getTargetUrl(activity);
            uuid = UUID.randomUUID().toString();
            activity.getSharedPreferences("uuid", 0).edit().putString("uuid", uuid).apply();
            sSOSlaveParam.uuidKey = Rsa.encrypt(uuid, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCN1SZgYt8OZk+Aq8PSAR2VqLKxvxvz7ASCnCTYJx1oS3dH9y/CWPh6nK6ndAWbnQG7sLyvFBTeZIc6Y7cmUFUiWJg9IZUattq6TO1Jg9OVWun4V2N2aqnOnzzVwFFyWqLMSK7E1aVZ5AXeL4KLJx14ZCxMtbqtAKdIc4Q7y1T3ywIDAQAB");
            try {
                sSOSlaveParam.sign = SSOSecurityService.getInstace(activity.getApplicationContext()).sign(iSsoRemoteParam.getAppKey(), sSOSlaveParam.toMap(), iSsoRemoteParam.getAtlas());
                Intent intent = new Intent();
                if (z) {
                    intent.setAction("com.taobao.open.intent.action.BIND_AUTH");
                } else {
                    intent.setAction(uj2.ACTION_CUSTOM);
                }
                String str2 = "tbopen://m.taobao.com/sso?";
                if (LoginSwitch.getSwitch("sso_simle", "true")) {
                    str2 = "tbopen://m.taobao.com/sso?sso_tao_simple=true&";
                }
                if (z) {
                    str2 = "tbopen://m.taobao.com/bind_auth?";
                }
                StringBuilder sb = new StringBuilder(str2);
                sb.append("appKey");
                sb.append("=");
                sb.append(sSOSlaveParam.appKey);
                sb.append("&");
                sb.append("ssoVersion");
                sb.append("=");
                sb.append(sSOSlaveParam.ssoVersion);
                sb.append("&");
                sb.append("t");
                sb.append("=");
                sb.append(sSOSlaveParam.t);
                sb.append("&");
                sb.append("uuidKey");
                sb.append("=");
                sb.append(sSOSlaveParam.uuidKey);
                sb.append("&");
                sb.append("targetUrl");
                sb.append("=");
                sb.append(sSOSlaveParam.targetUrl);
                sb.append("&");
                sb.append("sign");
                sb.append("=");
                sb.append(sSOSlaveParam.sign);
                if (!TextUtils.isEmpty(str)) {
                    sb.append("&");
                    sb.append(SSOIPCConstants.IPC_SLAVE_CALLBACK);
                    sb.append("=");
                    sb.append(str);
                }
                if (z) {
                    sb.append("&");
                    sb.append(Constants.AUTH_TYPE);
                    sb.append("=");
                    sb.append(Constants.AuthType.BIND_AUTH.getAuthType());
                }
                intent.setData(Uri.parse(sb.toString()));
                if (activity.getPackageManager().queryIntentActivities(intent, 0).size() > 0) {
                    intent.setFlags(268468224);
                    try {
                        activity.startActivity(intent);
                        Properties properties = new Properties();
                        properties.setProperty("monitor", "T");
                        LoginParam loginParam = TBSsoLogin.a;
                        UserTrackAdapter.sendUT(loginParam == null ? UTConstant.PageName.UT_PAGE_EXTEND : loginParam.loginSourcePage, UTConstant.CustomEvent.UT_SSO_AUTHCODE_COMMIT, "", LoginType.LocalLoginType.SSO_LOGIN, properties);
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                        UserTrackAdapter.sendUT(UTConstant.CustomEvent.UT_TBAUTH_START_ERROR);
                        throw new SSOException("startActivity Exception");
                    }
                }
                UserTrackAdapter.sendUT(UTConstant.CustomEvent.UT_TBAUTH_UNSUPPORT);
                throw new SSOException("taobao isn't support sso v2");
            } catch (SecException e2) {
                Properties properties2 = new Properties();
                properties2.setProperty("code", e2.getErrorCode() + "");
                UserTrackAdapter.sendUT(UTConstant.CustomEvent.UT_TBAUTH_SIGN_ERROR, properties2);
                throw new SSOException((Integer) 505, "errorCode=" + e2.getErrorCode());
            }
        }
        UserTrackAdapter.sendUT(UTConstant.CustomEvent.UT_TBAUTH_PARAM_ERROR);
        throw new SSOException("activity and remoteParam can't be null");
    }
}
