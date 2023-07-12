package com.youku.android.liveservice.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager;
import com.youku.alixplayer.opensdk.AXPParamsProvider;
import com.youku.alixplayer.opensdk.ups.request.UpsConstant;
import com.youku.media.arch.instruments.ConfigFetcher;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import tb.gn1;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class Utils {
    private static final int NET_2G = 2;
    private static final int NET_3G = 3;
    private static final int NET_4G = 4;
    private static final int NET_5G = 5;
    private static final int NET_NONE = 0;
    private static final int NET_WIFI = 1;
    private static volatile Method get;
    private static String mCpuName;

    public static String URLEncoder(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException | NullPointerException unused) {
            }
        }
        return "";
    }

    public static boolean enableNewDomain() {
        return "true".equals(ConfigFetcher.getInstance().getConfig("YKLiveRoom_ABTest", "use_live_acs", "true"));
    }

    public static String get(String str, String str2) {
        try {
            if (get == null) {
                synchronized (Utils.class) {
                    if (get == null) {
                        get = Class.forName("android.os.SystemProperties").getDeclaredMethod(gn1.TYPE_OPEN_URL_METHOD_GET, String.class, String.class);
                    }
                }
            }
            return (String) get.invoke(null, str, str2);
        } catch (Throwable th) {
            th.printStackTrace();
            return str2;
        }
    }

    public static String getCpuName() {
        if (!TextUtils.isEmpty(mCpuName)) {
            return mCpuName;
        }
        String str = get("ro.board.platform", "");
        mCpuName = str;
        return str;
    }

    public static int getNetType(Context context) {
        NetworkInfo activeNetworkInfo = ConnectivityManager.getActiveNetworkInfo((android.net.ConnectivityManager) context.getSystemService("connectivity"));
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected()) {
            int type = activeNetworkInfo.getType();
            if (type == 1) {
                return 1;
            }
            if (type == 0) {
                if (((TelephonyManager) context.getSystemService("phone")) != null) {
                    return getNetworkClassByType(getNetworkType(context));
                }
                return 4;
            }
            return 0;
        }
        return 0;
    }

    private static int getNetworkClassByType(int i) {
        if (i == 14 || i == 15) {
            return 3;
        }
        if (i != 20) {
            switch (i) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return 2;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                    return 3;
                default:
                    return 4;
            }
        }
        return 5;
    }

    @SuppressLint({"MissingPermission"})
    private static int getNetworkType(Context context) {
        int dataNetworkType;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (Build.VERSION.SDK_INT < 30) {
                dataNetworkType = com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getNetworkType(telephonyManager);
            } else {
                dataNetworkType = com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getDataNetworkType(telephonyManager);
            }
            return dataNetworkType;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String getUpsNetworkType(Context context) {
        int netType = getNetType(context);
        return netType != 1 ? (netType == 2 || netType == 3 || netType == 4 || netType == 5) ? UpsConstant.UPS_NETWORK_4G : UpsConstant.UPS_NETWORK_UNKOWN : "1000";
    }

    public static boolean isYoukuOrBaipai(Context context) {
        String str = context.getApplicationInfo().packageName;
        return AXPParamsProvider.ClientType.YOUKU.equals(str) || AXPParamsProvider.ClientType.YOUKU_HWBAIPAI.equals(str);
    }
}
