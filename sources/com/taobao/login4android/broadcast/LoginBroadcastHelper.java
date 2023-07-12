package com.taobao.login4android.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.taobao.login4android.constants.LoginConstants;
import com.taobao.login4android.log.LoginTLogAdapter;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class LoginBroadcastHelper {
    private static final String TAG = "login.LoginBroadcastHelper";
    public static final /* synthetic */ int a = 0;
    private static IntentFilter mfilter;

    static {
        try {
            mfilter = new IntentFilter();
            for (LoginAction loginAction : LoginAction.values()) {
                mfilter.addAction(loginAction.name());
            }
            mfilter.setPriority(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void registerLoginReceiver(Context context, BroadcastReceiver broadcastReceiver) {
        registerLoginReceiver(context, broadcastReceiver, mfilter);
    }

    public static void sentInitFailBroadcast(Context context) {
        Intent intent = new Intent(LoginAction.NOTIFY_LOGIN_FAILED.name());
        intent.putExtra(LoginConstants.LOGIN_FAIL_REASON, LoginConstants.LOGIN_FAIL_BY_APPKEY);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    public static void unregisterLoginReceiver(Context context, BroadcastReceiver broadcastReceiver) {
        if (broadcastReceiver == null || context == null) {
            return;
        }
        try {
            context.getApplicationContext().unregisterReceiver(broadcastReceiver);
        } catch (Throwable th) {
            LoginTLogAdapter.w(TAG, "unregisterLoginReceiver failed", th);
            th.printStackTrace();
        }
    }

    public static void registerLoginReceiver(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (broadcastReceiver == null || context == null) {
            return;
        }
        try {
            context.getApplicationContext().registerReceiver(broadcastReceiver, intentFilter);
        } catch (Throwable th) {
            LoginTLogAdapter.w(TAG, "registerLoginReceiver failed", th);
            th.printStackTrace();
        }
    }
}
