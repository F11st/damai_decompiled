package com.alibaba.aliweex.adapter.module.net;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public interface IWXConnection {
    public static final String TYPE_BLUETOOTH = "bluetooth";
    public static final String TYPE_CELLULAR = "cellular";
    public static final String TYPE_ETHERNET = "ethernet";
    public static final String TYPE_MIXED = "mixed";
    public static final String TYPE_MOBILE_2G = "2g";
    public static final String TYPE_MOBILE_3G = "3g";
    public static final String TYPE_MOBILE_4G = "4g";
    public static final String TYPE_NONE = "none";
    public static final String TYPE_OTHER = "other";
    public static final String TYPE_UNKNOWN = "unknown";
    public static final String TYPE_WIFI = "wifi";
    public static final String TYPE_WIMAX = "wimax";

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface OnNetworkChangeListener {
        void onNetworkChange();
    }

    /* compiled from: Taobao */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes15.dex */
    public @interface Type {
    }

    void addNetworkChangeListener(@Nullable OnNetworkChangeListener onNetworkChangeListener);

    void destroy();

    double getDownlinkMax();

    @NonNull
    String getNetworkType();

    @NonNull
    String getType();
}
