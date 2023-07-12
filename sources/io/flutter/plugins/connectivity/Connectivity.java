package io.flutter.plugins.connectivity;

import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class Connectivity {
    private ConnectivityManager connectivityManager;

    public Connectivity(ConnectivityManager connectivityManager) {
        this.connectivityManager = connectivityManager;
    }

    private String getNetworkTypeLegacy() {
        NetworkInfo activeNetworkInfo = com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo(this.connectivityManager);
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return "none";
        }
        int type = activeNetworkInfo.getType();
        return type != 0 ? type != 1 ? (type == 4 || type == 5) ? "mobile" : (type == 6 || type == 9) ? "wifi" : "none" : "wifi" : "mobile";
    }

    public ConnectivityManager getConnectivityManager() {
        return this.connectivityManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getNetworkType() {
        if (Build.VERSION.SDK_INT >= 23) {
            NetworkCapabilities networkCapabilities = this.connectivityManager.getNetworkCapabilities(this.connectivityManager.getActiveNetwork());
            if (networkCapabilities == null) {
                return "none";
            }
            if (networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(3)) {
                return "wifi";
            }
            if (networkCapabilities.hasTransport(0)) {
                return "mobile";
            }
        }
        return getNetworkTypeLegacy();
    }
}
