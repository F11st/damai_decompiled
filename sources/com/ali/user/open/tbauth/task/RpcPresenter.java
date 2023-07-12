package com.ali.user.open.tbauth.task;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.open.callback.LoginCallback;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.model.LoginReturnData;
import com.ali.user.open.core.model.ResultCode;
import com.ali.user.open.core.model.RpcRequestCallbackWithCode;
import com.ali.user.open.core.model.RpcResponse;
import com.ali.user.open.core.service.MemberExecutorService;
import com.ali.user.open.core.service.UserTrackerService;
import com.ali.user.open.core.trace.SDKLogger;
import com.ali.user.open.core.util.CommonUtils;
import com.ali.user.open.device.DeviceTokenAccount;
import com.ali.user.open.device.DeviceTokenManager;
import com.ali.user.open.service.SessionService;
import com.ali.user.open.session.Session;
import com.ali.user.open.tbauth.RequestCode;
import com.ali.user.open.tbauth.context.TbAuthContext;
import com.ali.user.open.tbauth.ui.TbAuthActivity;
import com.ali.user.open.tbauth.ui.TbAuthWebViewActivity;
import com.ali.user.open.tbauth.ui.context.CallbackContext;
import com.ali.user.open.tbauth.util.SessionConvert;
import com.alibaba.security.biometrics.service.common.ABLogRecorderKeys;
import com.ut.mini.UTHitBuilders;
import java.util.HashMap;
import tb.gn1;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class RpcPresenter {
    public static String TAG = "login.tbRpc";

    public static void doWhenResultFail(Activity activity, LoginCallback loginCallback, int i, String str) {
        if (loginCallback != null) {
            loginCallback.onFailure(i, str);
            HashMap hashMap = new HashMap();
            hashMap.put("code", i + "");
            hashMap.put(UTConstant.Args.UT_PROPERTY_SUCCESS, UTConstant.Args.UT_SUCCESS_F);
            hashMap.put(UTHitBuilders.UTHitBuilder.FIELD_ARG2, TbAuthContext.traceId);
            ((UserTrackerService) AliMemberSDK.getService(UserTrackerService.class)).send("Page_TaobaoOauth", "Page_TaobaoOauth_Result", hashMap);
        }
        LoginCallback loginCallback2 = CallbackContext.mGlobalLoginCallback;
        if (loginCallback2 != null) {
            loginCallback2.onFailure(i, str);
        }
        finishTempActivity(activity);
    }

    static void doWhenResultFail2(final LoginCallback loginCallback, final int i, final String str) {
        ((MemberExecutorService) AliMemberSDK.getService(MemberExecutorService.class)).postUITask(new Runnable() { // from class: com.ali.user.open.tbauth.task.RpcPresenter.5
            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put("code", i + "");
                hashMap.put(UTConstant.Args.UT_PROPERTY_SUCCESS, UTConstant.Args.UT_SUCCESS_F);
                hashMap.put(UTHitBuilders.UTHitBuilder.FIELD_ARG2, TbAuthContext.traceId);
                ((UserTrackerService) AliMemberSDK.getService(UserTrackerService.class)).send("Page_TaobaoOauth", "Page_TaobaoOauth_Result", hashMap);
                LoginCallback loginCallback2 = loginCallback;
                if (loginCallback2 != null) {
                    loginCallback2.onFailure(i, str);
                }
            }
        });
    }

    static void doWhenResultFail3(LoginCallback loginCallback, int i, String str) {
        if (loginCallback != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("code", i + "");
            hashMap.put(UTConstant.Args.UT_PROPERTY_SUCCESS, UTConstant.Args.UT_SUCCESS_F);
            hashMap.put(UTHitBuilders.UTHitBuilder.FIELD_ARG2, TbAuthContext.traceId);
            ((UserTrackerService) AliMemberSDK.getService(UserTrackerService.class)).send("Page_TaobaoOauth", "Page_TaobaoOauth_Result", hashMap);
            loginCallback.onFailure(i, str);
        }
    }

    public static void doWhenResultOk(Activity activity, LoginCallback loginCallback, Session session) {
        if (loginCallback != null) {
            String str = TAG;
            SDKLogger.d(str, "asyncExecute returnValue doWhenResultOk loginCallback not null,session = " + session.toString());
            loginCallback.onSuccess(session);
            HashMap hashMap = new HashMap();
            hashMap.put("type", gn1.TYPE_OPEN_URL_NATIVE);
            hashMap.put(UTConstant.Args.UT_PROPERTY_SUCCESS, "T");
            hashMap.put("authcode", session.topAuthCode);
            hashMap.put("openId", session.openId);
            hashMap.put(UTHitBuilders.UTHitBuilder.FIELD_ARG2, TbAuthContext.traceId);
            ((UserTrackerService) AliMemberSDK.getService(UserTrackerService.class)).send("Page_TaobaoOauth", "Page_TaobaoOauth_Result", hashMap);
        }
        LoginCallback loginCallback2 = CallbackContext.mGlobalLoginCallback;
        if (loginCallback2 != null) {
            loginCallback2.onSuccess(session);
        }
        finishTempActivity(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void doWhenResultOk2(final LoginCallback loginCallback, final Session session) {
        ((MemberExecutorService) AliMemberSDK.getService(MemberExecutorService.class)).postUITask(new Runnable() { // from class: com.ali.user.open.tbauth.task.RpcPresenter.6
            @Override // java.lang.Runnable
            public void run() {
                LoginCallback loginCallback2 = LoginCallback.this;
                if (loginCallback2 != null) {
                    loginCallback2.onSuccess(session);
                }
            }
        });
    }

    static void doWhenResultOk3(LoginCallback loginCallback, Session session) {
        if (loginCallback != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", gn1.TYPE_OPEN_URL_NATIVE);
            hashMap.put(UTConstant.Args.UT_PROPERTY_SUCCESS, "T");
            hashMap.put("authcode", session.topAuthCode);
            hashMap.put("openId", session.openId);
            hashMap.put(UTHitBuilders.UTHitBuilder.FIELD_ARG2, TbAuthContext.traceId);
            ((UserTrackerService) AliMemberSDK.getService(UserTrackerService.class)).send("Page_TaobaoOauth", "Page_TaobaoOauth_Result", hashMap);
            loginCallback.onSuccess(session);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void finishTempActivity(Activity activity) {
        if (activity == null || !(activity instanceof TbAuthActivity)) {
            return;
        }
        CallbackContext.activity = null;
        activity.finish();
    }

    public static void getAccessTokenWithAuthCode(final Activity activity, final String str, String str2, final LoginCallback loginCallback) {
        HashMap hashMap = new HashMap();
        hashMap.put("authcode", str);
        hashMap.put(UTHitBuilders.UTHitBuilder.FIELD_ARG2, TbAuthContext.traceId);
        ((UserTrackerService) AliMemberSDK.getService(UserTrackerService.class)).send("Page_TaobaoOauth", "Page_TaobaoOauth_openId", hashMap);
        RpcRepository.getAccessTokenWithAuthCode(str, str2, new RpcRequestCallbackWithCode() { // from class: com.ali.user.open.tbauth.task.RpcPresenter.8
            private void rpcResultFailHit(String str3) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put(UTConstant.Args.UT_PROPERTY_SUCCESS, UTConstant.Args.UT_SUCCESS_F);
                hashMap2.put("code", str3);
                hashMap2.put(UTHitBuilders.UTHitBuilder.FIELD_ARG2, TbAuthContext.traceId);
                ((UserTrackerService) AliMemberSDK.getService(UserTrackerService.class)).send("Page_TaobaoOauth", "Page_TaobaoOauth_openIdResult", hashMap2);
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onError(String str3, RpcResponse rpcResponse) {
                rpcResultFailHit(str3);
                RpcPresenter.finishTempActivity(activity);
                if (rpcResponse != null) {
                    CommonUtils.onFailure(loginCallback, rpcResponse.code, rpcResponse.message);
                } else {
                    CommonUtils.onFailure(loginCallback, ResultCode.create(10010, ""));
                }
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSuccess(RpcResponse rpcResponse) {
                if (ResultCode.SUCCESS.message.equals(rpcResponse.actionType)) {
                    final ConvertAuthCodeToAccessTokenData convertAuthCodeToAccessTokenData = (ConvertAuthCodeToAccessTokenData) rpcResponse.returnValue;
                    if (convertAuthCodeToAccessTokenData != null) {
                        RpcPresenter.saveDeviceToken(convertAuthCodeToAccessTokenData);
                        ((MemberExecutorService) AliMemberSDK.getService(MemberExecutorService.class)).postUITask(new Runnable() { // from class: com.ali.user.open.tbauth.task.RpcPresenter.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap2 = new HashMap();
                                hashMap2.put("authcode", str);
                                hashMap2.put(UTConstant.Args.UT_PROPERTY_SUCCESS, "T");
                                hashMap2.put("openId", convertAuthCodeToAccessTokenData.openId);
                                hashMap2.put(UTHitBuilders.UTHitBuilder.FIELD_ARG2, TbAuthContext.traceId);
                                ((UserTrackerService) AliMemberSDK.getService(UserTrackerService.class)).send("Page_TaobaoOauth", "Page_TaobaoOauth_openIdResult", hashMap2);
                                RpcPresenter.finishTempActivity(activity);
                                Session session = new Session();
                                ConvertAuthCodeToAccessTokenData convertAuthCodeToAccessTokenData2 = convertAuthCodeToAccessTokenData;
                                session.openId = convertAuthCodeToAccessTokenData2.openId;
                                session.bindToken = convertAuthCodeToAccessTokenData2.bindToken;
                                session.topAccessToken = convertAuthCodeToAccessTokenData2.accessToken;
                                session.topAuthCode = convertAuthCodeToAccessTokenData2.authCode;
                                session.openSid = convertAuthCodeToAccessTokenData2.openSid;
                                loginCallback.onSuccess(session);
                            }
                        });
                        return;
                    }
                    return;
                }
                rpcResultFailHit(ABLogRecorderKeys.EventIdActFail);
                CommonUtils.onFailure(loginCallback, ResultCode.create(10010, ""));
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSystemError(String str3, RpcResponse rpcResponse) {
                rpcResultFailHit(str3);
                RpcPresenter.finishTempActivity(activity);
                if (rpcResponse != null) {
                    CommonUtils.onFailure(loginCallback, rpcResponse.code, rpcResponse.message);
                } else {
                    CommonUtils.onFailure(loginCallback, ResultCode.create(10010, ""));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleSuccess(final RpcResponse rpcResponse, final Activity activity, final LoginCallback loginCallback) {
        LoginReturnData loginReturnData = (LoginReturnData) rpcResponse.returnValue;
        final int i = rpcResponse.code;
        String str = TAG;
        SDKLogger.d(str, "asyncExecute code = " + i);
        try {
            if (i == 3000) {
                final Session session = null;
                if (rpcResponse.returnValue != 0) {
                    SDKLogger.d(TAG, "asyncExecute returnValue not null ");
                    if (TbAuthContext.needSession && !TextUtils.equals(TbAuthContext.sSceneCode, ABLogRecorderKeys.EventIdActFail)) {
                        ((SessionService) AliMemberSDK.getService(SessionService.class)).refreshWhenLogin("taobao", loginReturnData);
                        session = ((SessionService) AliMemberSDK.getService(SessionService.class)).getSession();
                    } else {
                        session = SessionConvert.convertLoginDataToSeesion(loginReturnData);
                    }
                }
                ((MemberExecutorService) AliMemberSDK.getService(MemberExecutorService.class)).postUITask(new Runnable() { // from class: com.ali.user.open.tbauth.task.RpcPresenter.2
                    @Override // java.lang.Runnable
                    public void run() {
                        RpcPresenter.doWhenResultOk(activity, loginCallback, session);
                    }
                });
            } else if (i == 13060) {
                String str2 = loginReturnData.h5Url;
                String str3 = TAG;
                SDKLogger.d(str3, "asyncExecute doubleCheckUrl = " + str2);
                if (TextUtils.isEmpty(str2) || activity == null) {
                    return;
                }
                CallbackContext.setActivity(activity);
                Intent intent = new Intent(activity, TbAuthWebViewActivity.class);
                intent.putExtra("url", str2);
                intent.putExtra("token", loginReturnData.token);
                intent.putExtra("scene", loginReturnData.scene);
                TbAuthWebViewActivity.token = loginReturnData.token;
                TbAuthWebViewActivity.scene = loginReturnData.scene;
                activity.startActivityForResult(intent, RequestCode.OPEN_DOUBLE_CHECK);
            } else {
                ((MemberExecutorService) AliMemberSDK.getService(MemberExecutorService.class)).postUITask(new Runnable() { // from class: com.ali.user.open.tbauth.task.RpcPresenter.3
                    @Override // java.lang.Runnable
                    public void run() {
                        String str4 = RpcPresenter.TAG;
                        SDKLogger.d(str4, "15 : " + RpcResponse.this.message);
                        Activity activity2 = activity;
                        LoginCallback loginCallback2 = loginCallback;
                        RpcPresenter.doWhenResultFail(activity2, loginCallback2, 15, "login:code " + i + " " + RpcResponse.this.message);
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void loginByIVToken(final Activity activity, int i, String str, String str2, String str3, final LoginCallback loginCallback) {
        RpcRepository.loginByIVToken(i, str, str2, str3, new RpcRequestCallbackWithCode() { // from class: com.ali.user.open.tbauth.task.RpcPresenter.4
            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onError(String str4, RpcResponse rpcResponse) {
                T t;
                if (TextUtils.equals("H5", rpcResponse.actionType) && (t = rpcResponse.returnValue) != 0) {
                    LoginReturnData loginReturnData = (LoginReturnData) t;
                    String str5 = loginReturnData.h5Url;
                    String str6 = RpcPresenter.TAG;
                    SDKLogger.d(str6, "asyncExecute doubleCheckUrl = " + str5);
                    if (!TextUtils.isEmpty(str5) && activity != null) {
                        Intent intent = new Intent(activity, TbAuthWebViewActivity.class);
                        intent.putExtra("url", str5);
                        intent.putExtra("token", loginReturnData.token);
                        intent.putExtra("scene", loginReturnData.scene);
                        TbAuthWebViewActivity.token = loginReturnData.token;
                        TbAuthWebViewActivity.scene = loginReturnData.scene;
                        activity.startActivityForResult(intent, RequestCode.OPEN_DOUBLE_CHECK);
                        return;
                    }
                    RpcPresenter.doWhenResultFail2(LoginCallback.this, rpcResponse.code, rpcResponse.message);
                    return;
                }
                RpcPresenter.doWhenResultFail2(LoginCallback.this, rpcResponse.code, rpcResponse.message);
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSuccess(RpcResponse rpcResponse) {
                if (rpcResponse == null || rpcResponse.returnValue == 0) {
                    LoginCallback loginCallback2 = LoginCallback.this;
                    ResultCode resultCode = ResultCode.SYSTEM_EXCEPTION;
                    RpcPresenter.doWhenResultFail2(loginCallback2, resultCode.code, resultCode.message);
                }
                int i2 = rpcResponse.code;
                if (i2 == 3000) {
                    Activity activity2 = activity;
                    if (activity2 != null && (activity2 instanceof TbAuthActivity)) {
                        activity2.finish();
                    }
                    if (!TbAuthContext.needSession) {
                        RpcPresenter.doWhenResultOk2(LoginCallback.this, SessionConvert.convertLoginDataToSeesion((LoginReturnData) rpcResponse.returnValue));
                        return;
                    }
                    ((SessionService) AliMemberSDK.getService(SessionService.class)).refreshWhenLogin("taobao", (LoginReturnData) rpcResponse.returnValue);
                    RpcPresenter.doWhenResultOk2(LoginCallback.this, ((SessionService) AliMemberSDK.getService(SessionService.class)).getSession());
                    return;
                }
                RpcPresenter.doWhenResultFail2(LoginCallback.this, i2, rpcResponse.message);
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSystemError(String str4, RpcResponse rpcResponse) {
                RpcPresenter.doWhenResultFail2(LoginCallback.this, rpcResponse.code, rpcResponse.message);
            }
        });
    }

    public static void loginByRefreshToken(final LoginCallback loginCallback) {
        RpcRepository.loginByRefreshToken(new RpcRequestCallbackWithCode() { // from class: com.ali.user.open.tbauth.task.RpcPresenter.7
            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onError(String str, RpcResponse rpcResponse) {
                RpcPresenter.doWhenResultFail3(LoginCallback.this, rpcResponse.code, rpcResponse.message);
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSuccess(final RpcResponse rpcResponse) {
                final int i = rpcResponse.code;
                String str = RpcPresenter.TAG;
                SDKLogger.d(str, "asyncExecute code = " + i);
                try {
                    if (i == 3000) {
                        final Session session = null;
                        T t = rpcResponse.returnValue;
                        if (t != 0) {
                            if (TbAuthContext.needSession) {
                                ((SessionService) AliMemberSDK.getService(SessionService.class)).refreshWhenLogin("taobao", (LoginReturnData) rpcResponse.returnValue);
                                session = ((SessionService) AliMemberSDK.getService(SessionService.class)).getSession();
                            } else {
                                session = SessionConvert.convertLoginDataToSeesion((LoginReturnData) t);
                            }
                        }
                        ((MemberExecutorService) AliMemberSDK.getService(MemberExecutorService.class)).postUITask(new Runnable() { // from class: com.ali.user.open.tbauth.task.RpcPresenter.7.1
                            @Override // java.lang.Runnable
                            public void run() {
                                RpcPresenter.doWhenResultOk3(LoginCallback.this, session);
                            }
                        });
                        return;
                    }
                    ((MemberExecutorService) AliMemberSDK.getService(MemberExecutorService.class)).postUITask(new Runnable() { // from class: com.ali.user.open.tbauth.task.RpcPresenter.7.2
                        @Override // java.lang.Runnable
                        public void run() {
                            String str2 = RpcPresenter.TAG;
                            SDKLogger.d(str2, "15 : " + rpcResponse.message);
                            LoginCallback loginCallback2 = LoginCallback.this;
                            RpcPresenter.doWhenResultFail3(loginCallback2, 15, "login:code " + i + " " + rpcResponse.message);
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSystemError(String str, RpcResponse rpcResponse) {
                RpcPresenter.doWhenResultFail3(LoginCallback.this, rpcResponse.code, rpcResponse.message);
            }
        });
    }

    public static void refreshPageAfterOpenTb(final Activity activity, String str, final LoginCallback loginCallback) {
        RpcRepository.refreshPageAfterOpenTb(str, new RpcRequestCallbackWithCode() { // from class: com.ali.user.open.tbauth.task.RpcPresenter.1
            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onError(String str2, RpcResponse rpcResponse) {
                HashMap hashMap = new HashMap();
                hashMap.put("code", ABLogRecorderKeys.EventIdActFail);
                hashMap.put(UTConstant.Args.UT_PROPERTY_SUCCESS, UTConstant.Args.UT_SUCCESS_F);
                hashMap.put(UTHitBuilders.UTHitBuilder.FIELD_ARG2, TbAuthContext.traceId);
                ((UserTrackerService) AliMemberSDK.getService(UserTrackerService.class)).send("Page_TaobaoOauth", "Page_TaobaoOauth_Result", hashMap);
                CommonUtils.onFailure(loginCallback, ResultCode.create(10010, rpcResponse.message));
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSuccess(RpcResponse rpcResponse) {
                RpcPresenter.handleSuccess(rpcResponse, activity, loginCallback);
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSystemError(String str2, RpcResponse rpcResponse) {
                HashMap hashMap = new HashMap();
                hashMap.put("code", ABLogRecorderKeys.EventIdActFail);
                hashMap.put(UTConstant.Args.UT_PROPERTY_SUCCESS, UTConstant.Args.UT_SUCCESS_F);
                hashMap.put(UTHitBuilders.UTHitBuilder.FIELD_ARG2, TbAuthContext.traceId);
                ((UserTrackerService) AliMemberSDK.getService(UserTrackerService.class)).send("Page_TaobaoOauth", "Page_TaobaoOauth_Result", hashMap);
                CommonUtils.onFailure(loginCallback, ResultCode.create(10010, rpcResponse.message));
            }
        });
    }

    static void saveDeviceToken(ConvertAuthCodeToAccessTokenData convertAuthCodeToAccessTokenData) {
        if (convertAuthCodeToAccessTokenData == null || convertAuthCodeToAccessTokenData.deviceToken == null) {
            return;
        }
        DeviceTokenAccount deviceTokenAccount = new DeviceTokenAccount();
        deviceTokenAccount.site = "taobao";
        deviceTokenAccount.tokenKey = convertAuthCodeToAccessTokenData.deviceToken.key;
        deviceTokenAccount.openId = convertAuthCodeToAccessTokenData.openId;
        deviceTokenAccount.hid = convertAuthCodeToAccessTokenData.hid;
        DeviceTokenManager.getInstance().putDeviceToken(deviceTokenAccount, convertAuthCodeToAccessTokenData.deviceToken.salt);
    }

    public static void validataAuthCode(String str, String str2, String str3, final LoginCallback loginCallback) {
        RpcRepository.validateAuthCode(str, str2, str3, new RpcRequestCallbackWithCode() { // from class: com.ali.user.open.tbauth.task.RpcPresenter.9
            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onError(String str4, RpcResponse rpcResponse) {
                CommonUtils.onFailure(LoginCallback.this, rpcResponse.code, rpcResponse.message);
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSuccess(RpcResponse rpcResponse) {
                if (ResultCode.SUCCESS.message.equals(rpcResponse.actionType)) {
                    final ConvertAuthCodeToAccessTokenData convertAuthCodeToAccessTokenData = (ConvertAuthCodeToAccessTokenData) rpcResponse.returnValue;
                    if (convertAuthCodeToAccessTokenData != null) {
                        RpcPresenter.saveDeviceToken(convertAuthCodeToAccessTokenData);
                        ((MemberExecutorService) AliMemberSDK.getService(MemberExecutorService.class)).postUITask(new Runnable() { // from class: com.ali.user.open.tbauth.task.RpcPresenter.9.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Session session = new Session();
                                ConvertAuthCodeToAccessTokenData convertAuthCodeToAccessTokenData2 = convertAuthCodeToAccessTokenData;
                                session.openId = convertAuthCodeToAccessTokenData2.openId;
                                session.bindToken = convertAuthCodeToAccessTokenData2.bindToken;
                                session.topAccessToken = convertAuthCodeToAccessTokenData2.accessToken;
                                session.topAuthCode = convertAuthCodeToAccessTokenData2.authCode;
                                session.hid = convertAuthCodeToAccessTokenData2.hid;
                                LoginCallback.this.onSuccess(session);
                            }
                        });
                        return;
                    }
                    return;
                }
                CommonUtils.onFailure(LoginCallback.this, ResultCode.create(10010, ""));
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSystemError(String str4, RpcResponse rpcResponse) {
                CommonUtils.onFailure(LoginCallback.this, rpcResponse.code, rpcResponse.message);
            }
        });
    }
}
