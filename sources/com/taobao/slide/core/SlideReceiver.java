package com.taobao.slide.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;
import tb.m42;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class SlideReceiver extends BroadcastReceiver {
    private static boolean a = true;

    public static boolean a() {
        return a;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null && ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION.equals(intent.getAction())) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                NetworkInfo activeNetworkInfo = com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo(connectivityManager);
                a = activeNetworkInfo != null && activeNetworkInfo.isAvailable();
            } else {
                a = false;
            }
            m42.c("Receiver", "onReceive", "networkValid", Boolean.valueOf(a));
        }
    }
}
