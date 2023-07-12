package com.alibaba.gaiax.studio.third.socket.websocket;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;
import java.util.Map;
import tb.eb1;
import tb.jr1;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class NetworkChangedReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (!ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION.equals(intent.getAction()) || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return;
        }
        try {
            if (!jr1.a(context, "android.permission.ACCESS_NETWORK_STATE") || (activeNetworkInfo = com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo(connectivityManager)) == null) {
                return;
            }
            if (activeNetworkInfo.isConnected()) {
                if (activeNetworkInfo.getType() == 1) {
                    eb1.d("WSNetworkReceiver", "网络连接发生变化，当前WiFi连接可用，正在尝试重连。");
                } else if (activeNetworkInfo.getType() == 0) {
                    eb1.d("WSNetworkReceiver", "网络连接发生变化，当前移动连接可用，正在尝试重连。");
                }
                if (a.d() != null && a.d().l().k()) {
                    a.d().n();
                }
                if (a.c().isEmpty()) {
                    return;
                }
                Map<String, b> c = a.c();
                for (String str : c.keySet()) {
                    b bVar = c.get(str);
                    if (bVar != null && bVar.l().k()) {
                        bVar.n();
                    }
                }
                return;
            }
            eb1.d("WSNetworkReceiver", "当前没有可用网络");
        } catch (Exception e) {
            eb1.c("WSNetworkReceiver", "网络状态获取错误", e);
        }
    }
}
