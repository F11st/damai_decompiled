package com.taobao.login4android.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.taobao.login4android.constants.LoginConstants;
import com.taobao.login4android.constants.LoginStatus;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class LoginBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "login.LoginBroadcastReceiver";

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[LoginAction.values().length];
            a = iArr;
            try {
                iArr[LoginAction.NOTIFY_LOGIN_SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[LoginAction.NOTIFY_LOGIN_CANCEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[LoginAction.NOTIFY_LOGIN_FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[LoginAction.NOTIFY_RESET_STATUS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[LoginAction.NOTIFY_USER_LOGIN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[LoginAction.NOTIFY_LOGOUT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            LoginAction valueOf = LoginAction.valueOf(intent.getAction());
            if (valueOf == null) {
                return;
            }
            switch (a.a[valueOf.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                    LoginStatus.resetLoginFlag();
                    return;
                case 5:
                    LoginStatus.setUserLogin(true);
                    return;
                case 6:
                    if (TextUtils.equals(intent.getStringExtra(LoginConstants.LOGOUT_TYPE), LoginConstants.LogoutType.CHANGE_ACCOUNT.getType())) {
                        return;
                    }
                    LoginStatus.resetLoginFlag();
                    return;
                default:
                    return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
