package cn.damai.network;

import com.alibaba.analytics.core.network.NetworkUtil;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public enum NetworkType {
    NETWORK_WIFI("WiFi"),
    NETWORK_4G("4G"),
    NETWORK_2G("2G"),
    NETWORK_3G("3G"),
    NETWORK_UNKNOWN(NetworkUtil.NETWORK_CLASS_UNKNOWN),
    NETWORK_NO("No network"),
    NETWORK_MOBILE("mobile");
    
    private String desc;

    NetworkType(String str) {
        this.desc = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.desc;
    }
}
