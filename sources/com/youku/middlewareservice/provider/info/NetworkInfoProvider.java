package com.youku.middlewareservice.provider.info;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public interface NetworkInfoProvider {
    int getNetworkType();

    int getNetworkTypeWithCache();

    String getWifiMacAdress();

    String getWifiSsid();

    boolean isMobile();

    boolean isMobileWithCache();

    boolean isNetworkAvailable();

    boolean isNetworkAvailableWithCache();

    boolean isWifi();

    boolean isWifiWithCache();
}
