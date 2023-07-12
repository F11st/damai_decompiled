package com.ali.user.open.ucc.remote.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.ali.user.open.core.context.KernelContext;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class UccBroadcastHelper {
    private static IntentFilter mfilter;

    static {
        try {
            mfilter = new IntentFilter();
            for (UccResultAction uccResultAction : UccResultAction.values()) {
                mfilter.addAction(uccResultAction.name());
            }
            mfilter.addAction("NOTIFY_LOGIN_SUCCESS");
            mfilter.addAction("NOTIFY_LOGOUT");
            mfilter.setPriority(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void registerLoginReceiver(Context context, BroadcastReceiver broadcastReceiver) {
        registerLoginReceiver(context, broadcastReceiver, mfilter);
    }

    public static void sendBroadcast(Intent intent) {
        try {
            KernelContext.getApplicationContext().sendBroadcast(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void unregisterLoginReceiver(Context context, BroadcastReceiver broadcastReceiver) {
        if (broadcastReceiver == null || context == null) {
            return;
        }
        try {
            context.getApplicationContext().unregisterReceiver(broadcastReceiver);
        } catch (Throwable th) {
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
            th.printStackTrace();
        }
    }
}
