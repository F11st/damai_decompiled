package com.youku.usercenter.passport.mtop;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.ali.user.open.core.util.ParamsConstants;
import com.taobao.tao.remotebusiness.login.IRemoteLoginAdapter;
import com.taobao.tao.remotebusiness.login.LoginContext;
import com.taobao.tao.remotebusiness.login.onLoginListener;
import com.taobao.tlog.adapter.AdapterForTLog;
import com.youku.passport.result.AbsResult;
import com.youku.usercenter.passport.IPassport;
import com.youku.usercenter.passport.PassportConfig;
import com.youku.usercenter.passport.PassportManager;
import com.youku.usercenter.passport.callback.ICallback;
import com.youku.usercenter.passport.orange.RollBackSwitch;
import com.youku.usercenter.passport.result.UserInfo;
import com.youku.usercenter.passport.util.Logger;
import java.util.Date;
import java.util.HashMap;
import mtopsdk.mtop.intf.Mtop;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class LoginImpl extends BroadcastReceiver implements IRemoteLoginAdapter {
    private static final String DATE_KEY = "Date";
    private static final String ERROR_CODE_KEY = "x-session-ret";
    public String TAG = "Passport.LoginImpl";
    private Context mContext;
    private onLoginListener mOnLoginListener;

    public LoginImpl(Context context) {
        this.mContext = context.getApplicationContext();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(IPassport.ACTION_USER_LOGIN);
        intentFilter.addAction(IPassport.ACTION_USER_LOOUT);
        intentFilter.addAction(IPassport.ACTION_EXPIRE_LOGOUT);
        intentFilter.addAction(IPassport.ACTION_TOKEN_REFRESHED);
        intentFilter.addAction(IPassport.ACTION_LOGIN_CANCEL);
        LocalBroadcastManager.getInstance(this.mContext).registerReceiver(this, intentFilter);
    }

    private void onLoginCancel() {
        onLoginListener onloginlistener = this.mOnLoginListener;
        if (onloginlistener != null) {
            onloginlistener.onLoginCancel();
            this.mOnLoginListener = null;
        }
    }

    private void onLogout() {
        Mtop mtop;
        if (!RollBackSwitch.willRollBack(RollBackSwitch.ROLLBACK_REGISTER_MTOP)) {
            PassportConfig config = PassportManager.getInstance().getConfig();
            if (config != null && (mtop = config.mSessionMtop) != null) {
                try {
                    mtop.logout();
                    return;
                } catch (Throwable th) {
                    th.printStackTrace();
                    return;
                }
            }
            Logger.e(this.TAG, "did not set mtop in PassportConfig");
            return;
        }
        Logger.e(this.TAG, "rollback register mtop");
    }

    private void onTokenRefreshed(String str, String str2) {
    }

    private void onUserLogin() {
        onLoginListener onloginlistener = this.mOnLoginListener;
        if (onloginlistener != null) {
            onloginlistener.onLoginSuccess();
            this.mOnLoginListener = null;
        }
    }

    @Override // com.taobao.tao.remotebusiness.login.IRemoteLogin
    public LoginContext getLoginContext() {
        if (!PassportManager.getInstance().isInit()) {
            AdapterForTLog.loge("YKLogin.LoginImpl", "Passport not init when mtop call getLoginContext");
            return null;
        }
        String sToken = PassportManager.getInstance().getSToken();
        UserInfo userInfo = PassportManager.getInstance().getUserInfo();
        if (sToken == null || userInfo == null) {
            return null;
        }
        LoginContext loginContext = new LoginContext();
        loginContext.sid = sToken;
        loginContext.userId = userInfo.mUid;
        loginContext.nickname = userInfo.mNickName;
        return loginContext;
    }

    @Override // com.taobao.tao.remotebusiness.login.IRemoteLogin
    public boolean isLogining() {
        if (!PassportManager.getInstance().isInit()) {
            AdapterForTLog.loge("YKLogin.LoginImpl", "Passport not init when mtop call isLogining");
            return false;
        }
        return PassportManager.getInstance().isLogining();
    }

    @Override // com.taobao.tao.remotebusiness.login.IRemoteLogin
    public boolean isSessionValid() {
        if (!PassportManager.getInstance().isInit()) {
            AdapterForTLog.loge("YKLogin.LoginImpl", "Passport not init when mtop call isSessionValid");
            return false;
        }
        return PassportManager.getInstance().isLogin();
    }

    @Override // com.taobao.tao.remotebusiness.login.IRemoteLogin
    public void login(final onLoginListener onloginlistener, boolean z) {
        if (!PassportManager.getInstance().isInit()) {
            onloginlistener.onLoginFail();
            AdapterForTLog.loge("YKLogin.LoginImpl", "Passport not init when mtop call login");
        } else if (PassportManager.getInstance().isLogin()) {
            onloginlistener.onLoginSuccess();
            AdapterForTLog.loge("YKLogin.LoginImpl", "mtop consider login after cookie error handled");
        } else {
            HashMap hashMap = new HashMap();
            PassportConfig config = PassportManager.getInstance().getConfig();
            if (!config.mNeedBind) {
                hashMap.put(ParamsConstants.Key.PARAM_NEED_UI, "0");
            }
            PassportManager.getInstance().uccTrustLogin(!TextUtils.isEmpty(config.mSessionSite) ? config.mSessionSite : "youku", hashMap, new ICallback<AbsResult>() { // from class: com.youku.usercenter.passport.mtop.LoginImpl.1
                @Override // com.youku.usercenter.passport.callback.ICallback
                public void onFailure(AbsResult absResult) {
                    onloginlistener.onLoginFail();
                }

                @Override // com.youku.usercenter.passport.callback.ICallback
                public void onSuccess(AbsResult absResult) {
                    onloginlistener.onLoginSuccess();
                }
            });
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            String action = intent.getAction();
            if (TextUtils.equals(action, IPassport.ACTION_USER_LOGIN)) {
                onUserLogin();
            } else if (TextUtils.equals(action, IPassport.ACTION_USER_LOOUT)) {
                onLogout();
            } else if (TextUtils.equals(action, IPassport.ACTION_EXPIRE_LOGOUT)) {
                onLogout();
            } else if (TextUtils.equals(action, IPassport.ACTION_TOKEN_REFRESHED)) {
                onTokenRefreshed(intent.getStringExtra(IPassport.EXTRA_STOKEN), intent.getStringExtra(IPassport.EXTRA_YTID));
            } else if (TextUtils.equals(action, IPassport.ACTION_LOGIN_CANCEL)) {
                onLoginCancel();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.taobao.tao.remotebusiness.login.IRemoteLoginAdapter
    public void setSessionInvalid(Bundle bundle) {
        if (!PassportManager.getInstance().isInit()) {
            AdapterForTLog.loge("YKLogin.LoginImpl", "Passport not init when mtop call setSessionInvalid");
            return;
        }
        String string = bundle.getString("x-session-ret");
        String string2 = bundle.getString("Date");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        try {
            int parseInt = Integer.parseInt(string);
            PassportManager.getInstance().handleCookieError(parseInt, TextUtils.isEmpty(string2) ? -1L : new Date(string2).getTime());
            AdapterForTLog.loge("YKLogin.LoginImpl", "mtop setSessionInvalid errorCode = " + parseInt);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
