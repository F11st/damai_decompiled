package com.ali.user.mobile.base.helper;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.log.TLogAdapter;
import com.ali.user.mobile.login.LoginFrom;
import com.ali.user.mobile.login.action.LoginResActions;
import com.ali.user.mobile.model.LoginType;
import com.ali.user.mobile.utils.BackgroundExecutor;
import com.ali.user.mobile.utils.Constants;
import com.taobao.login4android.broadcast.LoginAction;
import com.taobao.login4android.constants.LoginConstants;
import com.taobao.login4android.constants.LoginSceneConstants;
import com.taobao.login4android.constants.LoginStatus;
import com.taobao.login4android.session.SessionManager;
import com.ut.mini.UTAnalytics;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class AliuserActionReceiver extends BroadcastReceiver {
    public static final String TAG = "login.AliuserActionReceiver";

    private void cleanGlobalResource() {
        LoginFrom.setCurrentLoginFrom("");
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        cleanGlobalResource();
        String action = intent.getAction();
        final SessionManager sessionManager = SessionManager.getInstance(DataProviderFactory.getApplicationContext());
        if (action.equals(LoginResActions.LOGIN_SUCCESS_ACTION)) {
            boolean booleanExtra = intent.getBooleanExtra(Constants.FROM_REGIST_KEY, false);
            String stringExtra = intent.getStringExtra("message");
            if (booleanExtra) {
                UTAnalytics.getInstance().userRegister(sessionManager.getNick());
            }
            HashMap hashMap = new HashMap();
            if (intent.hasExtra("nick")) {
                hashMap.put("nick", intent.getStringExtra("nick"));
                hashMap.put("uid", intent.getStringExtra("uid"));
            }
            if (intent.hasExtra(LoginConstants.LOGIN_TYPE)) {
                hashMap.put(LoginConstants.LOGIN_TYPE, intent.getStringExtra(LoginConstants.LOGIN_TYPE));
            }
            if (intent.hasExtra(LoginConstants.LOGIN_FROM)) {
                hashMap.put(LoginConstants.LOGIN_FROM, intent.getStringExtra(LoginConstants.LOGIN_FROM));
            }
            if (intent.hasExtra(LoginConstants.LOGIN_ACCOUNT)) {
                hashMap.put(LoginConstants.LOGIN_ACCOUNT, intent.getStringExtra(LoginConstants.LOGIN_ACCOUNT));
            }
            LoginStatus.resetLoginFlag();
            if (!TextUtils.equals(LoginType.ServerLoginType.AutoLogin.getType(), intent.getStringExtra(LoginConstants.LOGIN_TYPE))) {
                hashMap.put(LoginConstants.LOGIN_EXT_DATA, "true");
            }
            BroadCastHelper.sendBroadcast(LoginAction.NOTIFY_LOGIN_SUCCESS, false, 0, stringExtra, (Map<String, String>) hashMap, "");
            LoginStatus.browserRefUrl = "";
        } else if (action.equals(LoginResActions.LOGIN_FAIL_ACTION)) {
            LoginStatus.browserRefUrl = "";
            LoginStatus.resetLoginFlag();
            BroadCastHelper.sendBroadcast(LoginAction.NOTIFY_LOGIN_FAILED, false, intent.getIntExtra("errorCode", 0), intent.getStringExtra("message"), "");
        } else if (action.equals(LoginResActions.LOGIN_CANCEL_ACTION)) {
            LoginStatus.resetLoginFlag();
            sendBroadcast(LoginAction.NOTIFY_LOGIN_CANCEL);
            LoginStatus.browserRefUrl = "";
            if (LoginStatus.isFromChangeAccount()) {
                sessionManager.recoverCookie();
            }
        } else if (action.equals(LoginResActions.LOGIN_OPEN_ACTION)) {
            TLogAdapter.e(TAG, "clear sessionInfo in AliUserActionReceiver");
            BackgroundExecutor.execute(new Runnable() { // from class: com.ali.user.mobile.base.helper.AliuserActionReceiver.1
                @Override // java.lang.Runnable
                public void run() {
                    if (LoginStatus.isFromChangeAccount()) {
                        sessionManager.clearCookieManager();
                    } else {
                        sessionManager.clearSessionInfo();
                    }
                }
            });
            sendBroadcast(LoginAction.NOTIFY_USER_LOGIN);
        } else if (action.equals(Constants.RESET_LOGIN_STATUS)) {
            LoginStatus.resetLoginFlag();
            sendBroadcast(LoginAction.NOTIFY_RESET_STATUS);
        } else if (action.equals(LoginResActions.LOGIN_NETWORK_ERROR)) {
            LoginStatus.resetLoginFlag();
            sendBroadcast(LoginAction.NOTIFY_LOGIN_FAILED);
            LoginStatus.browserRefUrl = "";
        } else if (action.equals(LoginResActions.WEB_ACTIVITY_CANCEL)) {
            if (intent.getBooleanExtra(LoginConstants.H5_SEND_CANCEL_BROADCAST, false) && !LoginStatus.isFromChangeAccount()) {
                sendBroadcast(LoginAction.NOTIFY_LOGIN_CANCEL);
            } else {
                sendBroadcast(LoginAction.WEB_ACTIVITY_CANCEL);
            }
        } else if (action.equals(LoginResActions.WEB_ACTIVITY_RESULT)) {
            if ("true".equals(intent.getStringExtra("isSuc"))) {
                String stringExtra2 = intent.getStringExtra("bizType");
                if ("changePhoneNum".equals(stringExtra2)) {
                    sendBroadcast(LoginAction.NOTIFY_CHANGE_MOBILE_SUCCESS);
                } else if ("bindPhoneNum".equals(stringExtra2)) {
                    sendBroadcast(LoginAction.NOTIFY_BIND_MOBILE_SUCCESS);
                } else if ("changePassword".equals(stringExtra2)) {
                    sendBroadcast(LoginAction.NOTIFY_CHANGE_PASSWORD_SUCCESS);
                } else if (LoginSceneConstants.SCENE_CANCEL_SITE_ACCOUNT.equals(stringExtra2)) {
                    sendBroadcast(LoginAction.NOTIFY_H5_CANCEL_SITE_ACCOUNT_SUCCESS);
                } else if (LoginSceneConstants.SCENE_CANCEL_ACCOUNT.equals(stringExtra2)) {
                    sendBroadcast(LoginAction.NOTIFY_H5_CANCEL_ACCOUNT_SUCCESS);
                } else if (TextUtils.isEmpty(stringExtra2)) {
                } else {
                    sendBroadcast(stringExtra2);
                }
            }
        } else if (action.equals(LoginResActions.REG_CANCEL)) {
            sendBroadcast(LoginAction.NOTIFY_REGISTER_CANCEL);
        } else if (action.equals(LoginResActions.LOGIN_CLOSE_ACTION)) {
            LoginStatus.resetLoginFlag();
            sendBroadcast(LoginAction.NOTIFY_LOGIN_FAILED);
        }
    }

    public void sendBroadcast(LoginAction loginAction) {
        BroadCastHelper.sendBroadcast(loginAction, false, "");
    }

    public void sendBroadcast(String str) {
        BroadCastHelper.sendBroadcast(str, false, 0, "", (Map<String, String>) null, "");
    }
}
