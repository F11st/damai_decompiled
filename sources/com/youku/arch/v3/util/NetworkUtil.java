package com.youku.arch.v3.util;

import android.app.Application;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class NetworkUtil {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static final class NetworkType {
        public static final int CDMA = 4;
        public static final int EDGE = 2;
        public static final int EHRPD = 14;
        public static final int EVDO_0 = 5;
        public static final int EVDO_A = 6;
        public static final int EVDO_B = 12;
        public static final int GPRS = 1;
        public static final int HSDPA = 8;
        public static final int HSPA = 10;
        public static final int HSPAPlus = 15;
        public static final int HSUPA = 9;
        public static final int IDEN = 11;
        public static final int LTE = 13;
        public static final int LxRTT = 7;
        public static final int UMTS = 3;
        public static final int UNAVAILABLE = -1;
        public static final int UNKNOWN = 0;
        public static final int WIFI = 1000;
    }

    public static int getNetworkType(Application application) {
        NetworkInfo activeNetworkInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "318520607")) {
            return ((Integer) ipChange.ipc$dispatch("318520607", new Object[]{application})).intValue();
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) application.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo(connectivityManager)) == null) {
            return -1;
        }
        if (activeNetworkInfo.getType() == 1) {
            return 1000;
        }
        if (activeNetworkInfo.getType() == 0) {
            switch (activeNetworkInfo.getSubtype()) {
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 3;
                case 4:
                    return 4;
                case 5:
                    return 5;
                case 6:
                    return 6;
                case 7:
                    return 7;
                case 8:
                    return 8;
                case 9:
                    return 9;
                case 10:
                    return 10;
                case 11:
                    return 11;
                case 12:
                    return 12;
                case 13:
                    return 13;
                case 14:
                    return 14;
                case 15:
                    return 15;
                default:
                    return 0;
            }
        }
        return 0;
    }

    public static boolean isMobile(Application application) {
        NetworkInfo activeNetworkInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-464178358")) {
            return ((Boolean) ipChange.ipc$dispatch("-464178358", new Object[]{application})).booleanValue();
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) application.getSystemService("connectivity");
        return (connectivityManager == null || (activeNetworkInfo = com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo(connectivityManager)) == null || activeNetworkInfo.getType() != 0) ? false : true;
    }

    public static boolean isNetworkAvailable(Application application) {
        NetworkInfo activeNetworkInfo;
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "440475363") ? ((Boolean) ipChange.ipc$dispatch("440475363", new Object[]{application})).booleanValue() : (application == null || (activeNetworkInfo = com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo((ConnectivityManager) application.getSystemService("connectivity"))) == null || !activeNetworkInfo.isConnected()) ? false : true;
    }

    public static boolean isNetworkError(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1656536593") ? ((Boolean) ipChange.ipc$dispatch("-1656536593", new Object[]{str})).booleanValue() : "ANDROID_SYS_NETWORK_ERROR".equals(str) || "ANDROID_SYS_NO_NETWORK".equals(str);
    }

    public static boolean isWifi(Application application) {
        NetworkInfo activeNetworkInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1907643837")) {
            return ((Boolean) ipChange.ipc$dispatch("1907643837", new Object[]{application})).booleanValue();
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) application.getSystemService("connectivity");
        return (connectivityManager == null || (activeNetworkInfo = com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo(connectivityManager)) == null || activeNetworkInfo.getType() != 1) ? false : true;
    }
}
