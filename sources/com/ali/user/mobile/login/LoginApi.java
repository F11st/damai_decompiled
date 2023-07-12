package com.ali.user.mobile.login;

import com.ali.user.mobile.base.BaseView;
import com.ali.user.mobile.callback.LoginTasksCallback;
import com.ali.user.mobile.login.tasks.FaceLoginTask;
import com.ali.user.mobile.login.tasks.FingerTask;
import com.ali.user.mobile.login.tasks.MobileVerifyLoginTask;
import com.ali.user.mobile.login.tasks.NickSmsLoginTask;
import com.ali.user.mobile.login.tasks.NickSmsSendTask;
import com.ali.user.mobile.login.tasks.PwdLoginTask;
import com.ali.user.mobile.login.tasks.SimLoginTask;
import com.ali.user.mobile.login.tasks.SmsLoginTask;
import com.ali.user.mobile.login.tasks.SmsSendTask;
import com.ali.user.mobile.login.tasks.TokenLoginTask;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.model.TrackingModel;
import com.ali.user.mobile.rpc.login.model.LoginReturnData;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class LoginApi {
    private static final String TAG = "LoginManager";
    private static LoginApi instance;

    private LoginApi() {
    }

    public static void faceLogin(LoginParam loginParam, TrackingModel trackingModel, BaseView baseView, LoginTasksCallback<LoginReturnData> loginTasksCallback) {
        new FaceLoginTask().login(loginParam, trackingModel, baseView, loginTasksCallback);
    }

    public static void fingerLogin(LoginParam loginParam, TrackingModel trackingModel, BaseView baseView, LoginTasksCallback<LoginReturnData> loginTasksCallback) {
        new FingerTask().login(loginParam, trackingModel, baseView, loginTasksCallback);
    }

    public static LoginApi getInstance() {
        if (instance == null) {
            synchronized (LoginApi.class) {
                if (instance == null) {
                    instance = new LoginApi();
                }
            }
        }
        return instance;
    }

    public static void mobileVerifyLogin(LoginParam loginParam, TrackingModel trackingModel, BaseView baseView, LoginTasksCallback<LoginReturnData> loginTasksCallback) {
        new MobileVerifyLoginTask().login(loginParam, trackingModel, baseView, loginTasksCallback);
    }

    public static void nickSmsLogin(LoginParam loginParam, TrackingModel trackingModel, BaseView baseView, LoginTasksCallback<LoginReturnData> loginTasksCallback) {
        new NickSmsLoginTask().login(loginParam, trackingModel, baseView, loginTasksCallback);
    }

    public static void nickSmsSend(LoginParam loginParam, TrackingModel trackingModel, BaseView baseView, LoginTasksCallback<LoginReturnData> loginTasksCallback) {
        new NickSmsSendTask().login(loginParam, trackingModel, baseView, loginTasksCallback);
    }

    public static void pwdLogin(LoginParam loginParam, TrackingModel trackingModel, BaseView baseView, LoginTasksCallback<LoginReturnData> loginTasksCallback) {
        new PwdLoginTask().login(loginParam, trackingModel, baseView, loginTasksCallback);
    }

    public static void simLogin(LoginParam loginParam, TrackingModel trackingModel, BaseView baseView, LoginTasksCallback<LoginReturnData> loginTasksCallback) {
        new SimLoginTask().login(loginParam, trackingModel, baseView, loginTasksCallback);
    }

    public static void smsLogin(LoginParam loginParam, TrackingModel trackingModel, BaseView baseView, LoginTasksCallback<LoginReturnData> loginTasksCallback) {
        new SmsLoginTask().login(loginParam, trackingModel, baseView, loginTasksCallback);
    }

    public static void smsSend(LoginParam loginParam, TrackingModel trackingModel, BaseView baseView, LoginTasksCallback<LoginReturnData> loginTasksCallback) {
        new SmsSendTask().login(loginParam, trackingModel, baseView, loginTasksCallback);
    }

    public static void tokenLogin(LoginParam loginParam, TrackingModel trackingModel, BaseView baseView, LoginTasksCallback<LoginReturnData> loginTasksCallback) {
        new TokenLoginTask().login(loginParam, trackingModel, baseView, loginTasksCallback);
    }
}
