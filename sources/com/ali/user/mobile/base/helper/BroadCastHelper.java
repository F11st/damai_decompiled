package com.ali.user.mobile.base.helper;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.log.TLogAdapter;
import com.ali.user.mobile.login.action.LoginResActions;
import com.ali.user.mobile.model.LoginParam;
import com.taobao.login4android.broadcast.LoginAction;
import com.taobao.login4android.constants.LoginConstants;
import com.taobao.login4android.constants.LoginStatus;
import com.taobao.login4android.log.LoginTLogAdapter;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class BroadCastHelper {
    public static final String TAG = "login.BroadCastHelper";
    public static Bundle sLoginBundle;

    protected static boolean isLoginBroadcast(String str) {
        return LoginAction.NOTIFY_LOGIN_SUCCESS.name().equals(str) || LoginAction.NOTIFY_LOGIN_FAILED.equals(str) || LoginAction.NOTIFY_LOGIN_CANCEL.equals(str);
    }

    public static void sendBroadcast(LoginAction loginAction) {
        sendBroadcast(loginAction, false, "");
    }

    public static void sendCancelBroadcast(String str, String str2) {
        Intent intent = new Intent(LoginResActions.LOGIN_CANCEL_ACTION);
        try {
            intent.putExtra("errorCode", str);
            intent.putExtra("message", str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        sendLocalBroadCast(intent);
    }

    public static boolean sendLocalBroadCast(Intent intent) {
        boolean sendBroadcast = LocalBroadcastManager.getInstance(DataProviderFactory.getApplicationContext()).sendBroadcast(intent);
        TLogAdapter.d(TAG, intent.getAction() + "; sendResult=" + sendBroadcast);
        return sendBroadcast;
    }

    public static void sendLoginFailBroadcast(int i, String str) {
        sendLoginFailBroadcast(null, i, str);
    }

    public static void sendBroadcast(LoginAction loginAction, boolean z, String str) {
        sendBroadcast(loginAction, z, 0, "", str);
    }

    public static void sendLoginFailBroadcast(LoginParam loginParam, int i, String str) {
        Intent intent = new Intent(LoginResActions.LOGIN_FAIL_ACTION);
        if (loginParam != null) {
            try {
                if (!TextUtils.isEmpty(loginParam.loginAccount)) {
                    intent.putExtra("username", loginParam.loginAccount);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        intent.putExtra("errorCode", i);
        intent.putExtra("message", str);
        sendLocalBroadCast(intent);
    }

    public static void sendBroadcast(LoginAction loginAction, boolean z, Map<String, String> map, String str) {
        sendBroadcast(loginAction, z, 0, "", map, str);
    }

    public static void sendBroadcast(LoginAction loginAction, boolean z, int i, String str, String str2) {
        sendBroadcast(loginAction, z, i, str, (Map<String, String>) null, str2);
    }

    public static void sendBroadcast(LoginAction loginAction, Map<String, String> map) {
        sendBroadcast(loginAction, false, 0, "", map, "");
    }

    public static void sendBroadcast(LoginAction loginAction, boolean z, int i, String str, Map<String, String> map, String str2) {
        if (loginAction != null) {
            sendBroadcast(loginAction.name(), z, i, str, map, str2);
        }
    }

    public static void sendBroadcast(String str, boolean z, int i, String str2, Map<String, String> map, String str3) {
        if (str != null) {
            Intent intent = new Intent();
            intent.setAction(str);
            intent.setPackage(DataProviderFactory.getApplicationContext().getPackageName());
            intent.putExtra(LoginConstants.SHOW_TOAST, z);
            if (!TextUtils.isEmpty(str2)) {
                intent.putExtra("message", str2);
            }
            intent.putExtra("errorCode", i);
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (key != null && value != null) {
                        intent.putExtra(entry.getKey(), entry.getValue());
                    }
                }
            }
            if (sLoginBundle != null) {
                TLogAdapter.d(TAG, "sLoginBundle not null:");
                try {
                    intent.putExtras((Bundle) sLoginBundle.clone());
                } catch (Throwable unused) {
                }
                if (isLoginBroadcast(str)) {
                    sLoginBundle = null;
                }
            }
            intent.putExtra(LoginConstants.BROWSER_REF_URL, str3);
            try {
                DataProviderFactory.getApplicationContext().sendBroadcast(intent);
                LoginTLogAdapter.i(TAG, "sendBroadcast: " + str);
                if (isLoginBroadcast(str)) {
                    LoginStatus.resetLoginFlag();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
