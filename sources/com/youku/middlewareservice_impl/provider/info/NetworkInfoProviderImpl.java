package com.youku.middlewareservice_impl.provider.info;

import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager;
import com.alibaba.wireless.security.aopsdk.replace.android.net.wifi.WifiInfo;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import com.youku.middlewareservice.provider.info.NetworkInfoProvider;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class NetworkInfoProviderImpl implements NetworkInfoProvider {
    public static final int UNAVAILABLE = -1;
    private static NetworkInfo sLastActiveNetworkInfo;
    private static long sLastTime;

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public static final class NetworkType {
        public static final int MOBILE_2G = 2;
        public static final int MOBILE_3G = 3;
        public static final int MOBILE_4G = 4;
        public static final int MOBILE_5G = 5;
        public static final int MOBILE_WIFI = 1;
        public static final int UNKNOWN = -1;
    }

    private static NetworkInfo getActiveNetworkInfo() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - sLastTime;
        if (j > 1000 || j < 0 || sLastActiveNetworkInfo == null) {
            sLastActiveNetworkInfo = ConnectivityManager.getActiveNetworkInfo((android.net.ConnectivityManager) AppInfoProviderProxy.getAppContext().getSystemService("connectivity"));
            sLastTime = currentTimeMillis;
        }
        return sLastActiveNetworkInfo;
    }

    @Override // com.youku.middlewareservice.provider.info.NetworkInfoProvider
    public int getNetworkType() {
        NetworkInfo activeNetworkInfo;
        android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) AppInfoProviderProxy.getApplication().getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = ConnectivityManager.getActiveNetworkInfo(connectivityManager)) == null) {
            return -1;
        }
        if (activeNetworkInfo.getType() == 1) {
            return 1;
        }
        if (activeNetworkInfo.getType() == 0) {
            int subtype = activeNetworkInfo.getSubtype();
            if (subtype != 20) {
                switch (subtype) {
                    case 1:
                    case 2:
                    case 4:
                    case 11:
                        return 2;
                    case 3:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        return 3;
                    case 13:
                        return 4;
                    default:
                        return -1;
                }
            }
            return 5;
        }
        return -1;
    }

    @Override // com.youku.middlewareservice.provider.info.NetworkInfoProvider
    public int getNetworkTypeWithCache() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return -1;
        }
        return activeNetworkInfo.getType();
    }

    @Override // com.youku.middlewareservice.provider.info.NetworkInfoProvider
    public String getWifiMacAdress() {
        try {
            return WifiInfo.getMacAddress(((WifiManager) AppInfoProviderProxy.getApplication().getApplicationContext().getSystemService("wifi")).getConnectionInfo());
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.youku.middlewareservice.provider.info.NetworkInfoProvider
    public String getWifiSsid() {
        try {
            return ((WifiManager) AppInfoProviderProxy.getApplication().getApplicationContext().getSystemService("wifi")).getConnectionInfo().getSSID();
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.youku.middlewareservice.provider.info.NetworkInfoProvider
    public boolean isMobile() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 0;
    }

    @Override // com.youku.middlewareservice.provider.info.NetworkInfoProvider
    public boolean isMobileWithCache() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 0;
    }

    @Override // com.youku.middlewareservice.provider.info.NetworkInfoProvider
    public boolean isNetworkAvailable() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override // com.youku.middlewareservice.provider.info.NetworkInfoProvider
    public boolean isNetworkAvailableWithCache() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override // com.youku.middlewareservice.provider.info.NetworkInfoProvider
    public boolean isWifi() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
    }

    @Override // com.youku.middlewareservice.provider.info.NetworkInfoProvider
    public boolean isWifiWithCache() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
    }
}
