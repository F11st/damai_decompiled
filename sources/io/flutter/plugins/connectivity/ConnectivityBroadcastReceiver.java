package io.flutter.plugins.connectivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import io.flutter.plugin.common.EventChannel;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class ConnectivityBroadcastReceiver extends BroadcastReceiver implements EventChannel.StreamHandler {
    public static final String CONNECTIVITY_ACTION = "android.net.conn.CONNECTIVITY_CHANGE";
    private Connectivity connectivity;
    private Context context;
    private EventChannel.EventSink events;
    private Handler mainHandler = new Handler(Looper.getMainLooper());
    private ConnectivityManager.NetworkCallback networkCallback;

    public ConnectivityBroadcastReceiver(Context context, Connectivity connectivity) {
        this.context = context;
        this.connectivity = connectivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendEvent() {
        this.mainHandler.post(new Runnable() { // from class: io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver.2
            @Override // java.lang.Runnable
            public void run() {
                ConnectivityBroadcastReceiver.this.events.success(ConnectivityBroadcastReceiver.this.connectivity.getNetworkType());
            }
        });
    }

    public ConnectivityManager.NetworkCallback getNetworkCallback() {
        return this.networkCallback;
    }

    @Override // io.flutter.plugin.common.EventChannel.StreamHandler
    public void onCancel(Object obj) {
        if (Build.VERSION.SDK_INT >= 24) {
            if (this.networkCallback != null) {
                this.connectivity.getConnectivityManager().unregisterNetworkCallback(this.networkCallback);
                this.networkCallback = null;
                return;
            }
            return;
        }
        this.context.unregisterReceiver(this);
    }

    @Override // io.flutter.plugin.common.EventChannel.StreamHandler
    public void onListen(Object obj, EventChannel.EventSink eventSink) {
        this.events = eventSink;
        if (Build.VERSION.SDK_INT >= 24) {
            this.networkCallback = new ConnectivityManager.NetworkCallback() { // from class: io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver.1
                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onAvailable(Network network) {
                    ConnectivityBroadcastReceiver.this.sendEvent();
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onLost(Network network) {
                    ConnectivityBroadcastReceiver.this.sendEvent();
                }
            };
            this.connectivity.getConnectivityManager().registerDefaultNetworkCallback(this.networkCallback);
            return;
        }
        this.context.registerReceiver(this, new IntentFilter(CONNECTIVITY_ACTION));
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        EventChannel.EventSink eventSink = this.events;
        if (eventSink != null) {
            eventSink.success(this.connectivity.getNetworkType());
        }
    }
}
