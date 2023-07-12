package com.taobao.zcache.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.taobao.android.riverlogger.RVLLevel;
import com.taobao.android.riverlogger.RVLLog;
import com.taobao.zcache.ZCache;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class NetworkUtils {
    private static BroadcastReceiver broadcastReceiver;
    private static NetworkListener networkListener;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface NetworkListener {
        void onNetworkChanged(int i);
    }

    NetworkUtils() {
    }

    public static int networkStatus() {
        NetworkInfo.State state;
        Context context = ZCache.getContext();
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        int i = 0;
        if (connectivityManager == null) {
            return 0;
        }
        NetworkInfo networkInfo = null;
        try {
            networkInfo = com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo(connectivityManager);
        } catch (Exception unused) {
        }
        if (networkInfo == null || !networkInfo.isAvailable()) {
            return 0;
        }
        NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
        if (networkInfo2 == null || (state = networkInfo2.getState()) == null || !(state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING)) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (Build.VERSION.SDK_INT >= 29) {
                try {
                    i = com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getDataNetworkType(telephonyManager);
                } catch (SecurityException unused2) {
                }
            } else {
                i = com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getNetworkType(telephonyManager);
            }
            return (i == 1 || i == 2 || i == 4 || i == 7 || i == 11 || i == 16) ? 2 : 3;
        }
        return 1;
    }

    public static void setListener(NetworkListener networkListener2) {
        if (networkListener2 == null) {
            return;
        }
        if (broadcastReceiver == null) {
            try {
                broadcastReceiver = new BroadcastReceiver() { // from class: com.taobao.zcache.core.NetworkUtils.1
                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context, Intent intent) {
                        if (NetworkUtils.networkListener == null) {
                            return;
                        }
                        NetworkUtils.networkListener.onNetworkChanged(NetworkUtils.networkStatus());
                    }
                };
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION);
                ZCache.getContext().getApplicationContext().registerReceiver(broadcastReceiver, intentFilter);
            } catch (Throwable th) {
                RVLLog.a(RVLLevel.Error, "ZCache/Setup").f("networkListener").e(101, th.getLocalizedMessage(), new Object[0]).d();
            }
        }
        networkListener = networkListener2;
    }
}
