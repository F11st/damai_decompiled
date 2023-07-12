package com.alimm.xadsdk.base.connectivity;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Build;
import android.text.TextUtils;
import com.alimm.xadsdk.AdSdkManager;
import com.alimm.xadsdk.base.utils.LogUtils;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;
import java.util.LinkedList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class NetworkStateObserver {
    public static final int NETWORK_TYPE_ETHERNET = 9;
    public static final int NETWORK_TYPE_MOBILE = 0;
    public static final int NETWORK_TYPE_NONE = -1;
    public static final int NETWORK_TYPE_WIFI = 1;
    private static final String TAG = "NetworkStateObserver";
    private ConnectivityManager mConnectivityManager;
    private Context mContext;
    private int mCurrentNetworkType;
    private final BroadcastReceiver mNetworkBroadcastReceiver;
    @TargetApi(21)
    private ConnectivityManager.NetworkCallback mNetworkCallback;
    private List<NetworkChangeListener> mNetworkChangeListeners;
    private int mPrevNetworkType;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface NetworkChangeListener {
        void onNetworkChanged(int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class SingletonHolder {
        static final NetworkStateObserver INSTANCE = new NetworkStateObserver();

        private SingletonHolder() {
        }
    }

    private NetworkStateObserver() {
        this.mPrevNetworkType = -1;
        this.mCurrentNetworkType = -1;
        this.mNetworkBroadcastReceiver = new BroadcastReceiver() { // from class: com.alimm.xadsdk.base.connectivity.NetworkStateObserver.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if (LogUtils.DEBUG) {
                    LogUtils.d(NetworkStateObserver.TAG, "onReceive: action = " + action);
                }
                if (TextUtils.equals(action, ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION)) {
                    NetworkStateObserver.this.getActiveNetworkType();
                    if (NetworkStateObserver.this.mPrevNetworkType != NetworkStateObserver.this.mCurrentNetworkType) {
                        NetworkStateObserver.this.notifyNetworkStateChanged();
                        NetworkStateObserver networkStateObserver = NetworkStateObserver.this;
                        networkStateObserver.mPrevNetworkType = networkStateObserver.mCurrentNetworkType;
                    }
                }
            }
        };
        this.mContext = AdSdkManager.getInstance().getAppContext();
        this.mNetworkChangeListeners = new LinkedList();
        try {
            this.mConnectivityManager = (ConnectivityManager) this.mContext.getSystemService("connectivity");
        } catch (Exception e) {
            LogUtils.d(TAG, "get ConnectivityManager exception", e);
        }
        registerNetworkState();
        getActiveNetworkType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0049, code lost:
        if (r1.isConnected() != false) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void getActiveNetworkType() {
        /*
            r5 = this;
            java.lang.String r0 = "NetworkStateObserver"
            android.net.ConnectivityManager r1 = r5.mConnectivityManager     // Catch: java.lang.Exception -> L9
            android.net.NetworkInfo r1 = com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo(r1)     // Catch: java.lang.Exception -> L9
            goto L10
        L9:
            r1 = move-exception
            java.lang.String r2 = "getActiveNetworkType exception."
            com.alimm.xadsdk.base.utils.LogUtils.d(r0, r2, r1)
            r1 = 0
        L10:
            r2 = -1
            if (r1 != 0) goto L1f
            r5.mCurrentNetworkType = r2
            boolean r1 = com.alimm.xadsdk.base.utils.LogUtils.DEBUG
            if (r1 == 0) goto L1e
            java.lang.String r1 = "getActiveNetworkType with null network info."
            com.alimm.xadsdk.base.utils.LogUtils.d(r0, r1)
        L1e:
            return
        L1f:
            int r3 = r1.getType()
            r4 = 1
            if (r3 != r4) goto L2f
            boolean r3 = r1.isConnected()
            if (r3 == 0) goto L2f
        L2c:
            r5.mCurrentNetworkType = r4
            goto L4e
        L2f:
            int r3 = r1.getType()
            if (r3 != 0) goto L3d
            boolean r3 = r1.isConnected()
            if (r3 == 0) goto L3d
            r2 = 0
            goto L4c
        L3d:
            int r3 = r1.getType()
            r4 = 9
            if (r3 != r4) goto L4c
            boolean r3 = r1.isConnected()
            if (r3 == 0) goto L4c
            goto L2c
        L4c:
            r5.mCurrentNetworkType = r2
        L4e:
            boolean r2 = com.alimm.xadsdk.base.utils.LogUtils.DEBUG
            if (r2 == 0) goto L7a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "getActiveNetworkType: mPrevNetworkType = "
            r2.append(r3)
            int r3 = r5.mPrevNetworkType
            r2.append(r3)
            java.lang.String r3 = ", mCurrentNetworkType = "
            r2.append(r3)
            int r3 = r5.mCurrentNetworkType
            r2.append(r3)
            java.lang.String r3 = ", networkInfo = "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            com.alimm.xadsdk.base.utils.LogUtils.d(r0, r1)
        L7a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alimm.xadsdk.base.connectivity.NetworkStateObserver.getActiveNetworkType():void");
    }

    public static NetworkStateObserver getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void notifyNetworkStateChanged() {
        if (LogUtils.DEBUG) {
            LogUtils.d(TAG, "notifyNetworkStateChanged: mPrevNetworkType = " + this.mPrevNetworkType + ", mCurrentNetworkType = " + this.mCurrentNetworkType);
        }
        for (NetworkChangeListener networkChangeListener : this.mNetworkChangeListeners) {
            networkChangeListener.onNetworkChanged(this.mCurrentNetworkType);
        }
    }

    private void registerNetworkState() {
        try {
            if (Build.VERSION.SDK_INT < 23) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION);
                this.mContext.registerReceiver(this.mNetworkBroadcastReceiver, intentFilter);
                return;
            }
            NetworkRequest build = new NetworkRequest.Builder().build();
            if (this.mNetworkCallback == null) {
                this.mNetworkCallback = new ConnectivityManager.NetworkCallback() { // from class: com.alimm.xadsdk.base.connectivity.NetworkStateObserver.2
                    @Override // android.net.ConnectivityManager.NetworkCallback
                    public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
                        super.onCapabilitiesChanged(network, networkCapabilities);
                        if (networkCapabilities.hasCapability(16)) {
                            if (networkCapabilities.hasTransport(1)) {
                                NetworkStateObserver.this.mCurrentNetworkType = 1;
                            } else if (networkCapabilities.hasTransport(0)) {
                                NetworkStateObserver.this.getActiveNetworkType();
                            } else if (networkCapabilities.hasTransport(3)) {
                                NetworkStateObserver.this.mCurrentNetworkType = 9;
                            }
                        }
                        if (LogUtils.DEBUG) {
                            LogUtils.d(NetworkStateObserver.TAG, "onCapabilitiesChanged: cap = " + networkCapabilities + ", network = " + network + ", currentType = " + NetworkStateObserver.this.mCurrentNetworkType + ", prevType = " + NetworkStateObserver.this.mPrevNetworkType);
                        }
                        if (NetworkStateObserver.this.mPrevNetworkType != NetworkStateObserver.this.mCurrentNetworkType) {
                            NetworkStateObserver.this.notifyNetworkStateChanged();
                            NetworkStateObserver networkStateObserver = NetworkStateObserver.this;
                            networkStateObserver.mPrevNetworkType = networkStateObserver.mCurrentNetworkType;
                        }
                    }

                    @Override // android.net.ConnectivityManager.NetworkCallback
                    public void onLost(Network network) {
                        super.onLost(network);
                        if (LogUtils.DEBUG) {
                            LogUtils.d(NetworkStateObserver.TAG, "onLost: currentType = " + NetworkStateObserver.this.mCurrentNetworkType + ", prev = " + NetworkStateObserver.this.mPrevNetworkType + ", network = " + network);
                        }
                        NetworkStateObserver.this.getActiveNetworkType();
                        if (NetworkStateObserver.this.mPrevNetworkType != NetworkStateObserver.this.mCurrentNetworkType) {
                            NetworkStateObserver.this.notifyNetworkStateChanged();
                            NetworkStateObserver networkStateObserver = NetworkStateObserver.this;
                            networkStateObserver.mPrevNetworkType = networkStateObserver.mCurrentNetworkType;
                        }
                    }
                };
            }
            this.mConnectivityManager.registerNetworkCallback(build, this.mNetworkCallback);
        } catch (Throwable th) {
            LogUtils.d(TAG, "registerNetworkState exception.", th);
        }
    }

    private void unregisterNetworkState() {
        ConnectivityManager.NetworkCallback networkCallback;
        if (Build.VERSION.SDK_INT < 23) {
            this.mContext.unregisterReceiver(this.mNetworkBroadcastReceiver);
            return;
        }
        ConnectivityManager connectivityManager = this.mConnectivityManager;
        if (connectivityManager == null || (networkCallback = this.mNetworkCallback) == null) {
            return;
        }
        connectivityManager.unregisterNetworkCallback(networkCallback);
    }

    public synchronized void addNetworkChangeListener(NetworkChangeListener networkChangeListener) {
        if (LogUtils.DEBUG) {
            LogUtils.d(TAG, "addNetworkChangeListener: listener = " + networkChangeListener);
        }
        this.mNetworkChangeListeners.add(networkChangeListener);
        networkChangeListener.onNetworkChanged(this.mCurrentNetworkType);
    }

    public void dispose() {
        unregisterNetworkState();
    }

    public int getCurrentNetworkType() {
        return this.mCurrentNetworkType;
    }

    public boolean hasInternet() {
        return this.mCurrentNetworkType != -1;
    }

    public boolean isWifiConnected() {
        return this.mCurrentNetworkType == 1;
    }

    public synchronized void removeNetworkChangeListener(NetworkChangeListener networkChangeListener) {
        this.mNetworkChangeListeners.remove(networkChangeListener);
    }
}
