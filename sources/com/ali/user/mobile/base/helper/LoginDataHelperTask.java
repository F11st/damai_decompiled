package com.ali.user.mobile.base.helper;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.log.TLogAdapter;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.rpc.login.model.AliUserResponseData;
import com.ali.user.mobile.rpc.login.model.LoginReturnData;
import com.alibaba.fastjson.JSON;
import com.taobao.login4android.config.LoginSwitch;
import com.taobao.login4android.constants.LoginConstants;
import com.taobao.login4android.session.SessionManager;
import com.taobao.login4android.thread.LoginThreadHelper;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class LoginDataHelperTask extends AsyncTask {
    private AliUserResponseData data;
    public Map<String, String> ext;
    public LoginReturnData loginData;
    public LoginParam loginParam;
    public String message;
    private String nick;
    public boolean sendBroadcast;
    private SessionManager session;
    private String userId;
    public String loginType = "";
    public String loginAccount = "";

    public LoginDataHelperTask(boolean z, LoginReturnData loginReturnData, LoginParam loginParam, String str, Map<String, String> map) {
        this.sendBroadcast = z;
        this.loginData = loginReturnData;
        this.message = str;
        this.loginParam = loginParam;
        this.ext = map;
        try {
            this.data = (AliUserResponseData) JSON.parseObject(loginReturnData.data, AliUserResponseData.class);
            this.session = SessionManager.getInstance(DataProviderFactory.getApplicationContext());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(Object obj) {
        LoginDataHelper.sendLoginResultBroadcast(this.sendBroadcast, this.userId, this.nick, this.loginParam, this.loginData, this.data, this.loginType, this.loginAccount);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        LoginDataHelper.beforeProcessLoginData(this.sendBroadcast, this.data, this.message);
    }

    @Override // android.os.AsyncTask
    public Void doInBackground(Object... objArr) {
        try {
            Map<String, String> map = this.ext;
            if (map != null && !TextUtils.isEmpty(map.get(LoginConstants.LOGIN_TYPE))) {
                this.loginType = this.ext.get(LoginConstants.LOGIN_TYPE);
            }
            Map<String, String> map2 = this.ext;
            if (map2 != null && !TextUtils.isEmpty(map2.get(LoginConstants.LOGIN_ACCOUNT))) {
                this.loginAccount = this.ext.get(LoginConstants.LOGIN_ACCOUNT);
            }
            if (this.data == null) {
                this.data = (AliUserResponseData) JSON.parseObject(this.loginData.data, AliUserResponseData.class);
            }
            if (this.session == null) {
                this.session = SessionManager.getInstance(DataProviderFactory.getApplicationContext());
            }
            SessionManager sessionManager = this.session;
            if (sessionManager != null && !TextUtils.isEmpty(sessionManager.getUserId()) && (!TextUtils.equals(this.session.getUserId(), this.data.userId) || LoginSwitch.getSwitch(LoginSwitch.CLEAR_SESSION_WHEN_AUTOLOGIN_SWITCH, "false"))) {
                if (LoginSwitch.getSwitch(LoginSwitch.CLEAR_COOKIE_WHEN_AUTOLOGIN, "true")) {
                    TLogAdapter.e(LoginThreadHelper.TAG, "start clear cookie in LoginDataHelperTask");
                    this.session.injectCookie(null, null, false, com.taobao.login4android.utils.LoginSwitch.getSwitch(com.taobao.login4android.utils.LoginSwitch.SGCOOKIE, "true"));
                    TLogAdapter.e(LoginThreadHelper.TAG, "end clear cookie in LoginDataHelperTask");
                } else {
                    TLogAdapter.e(LoginThreadHelper.TAG, "start clear session in LoginDataHelperTask");
                    this.session.clearSessionInfo();
                    TLogAdapter.e(LoginThreadHelper.TAG, "end clear sessoin in LoginDataHelperTask");
                }
                Thread.sleep(200L);
            }
            LoginDataHelper.onLoginSuccess(this.loginData, this.data, this.session);
            LoginDataHelper.handleHistory(this.loginData, this.session, this.data, this.ext);
            AliUserResponseData aliUserResponseData = this.data;
            this.nick = aliUserResponseData.nick;
            this.userId = aliUserResponseData.userId;
            if (LoginSwitch.getSwitch("sleepForMulProcessCookie", "true")) {
                Thread.sleep(100L);
            }
            return null;
        } catch (Throwable th) {
            TLogAdapter.e("LoginDataHelperTask", th.getMessage());
            return null;
        }
    }
}
