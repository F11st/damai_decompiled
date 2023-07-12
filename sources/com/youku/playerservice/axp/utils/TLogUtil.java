package com.youku.playerservice.axp.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.youku.media.arch.instruments.utils.RemoteLogger;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class TLogUtil {
    private static final String NETWORKTYPE_2G = "2G网络，";
    private static final String NETWORKTYPE_3G = "3G网络，";
    private static final String NETWORKTYPE_4G = "4G网络，";
    private static final String NETWORKTYPE_INVALID = "没有网络，";
    private static final String NETWORKTYPE_MOBILE = "未知移动网络，";
    private static final String NETWORKTYPE_WIFI = " wifi网络，";
    private static final String TAG_ALIX_USERACTION = "AlixUserAction";
    private static final String TAG_PLAYER = "YKPlayer-PlayFlow";
    private static final String TAG_PREFIX = "YKPlayer-";

    public static void flowLog(String str, String str2) {
        loge("[KeyFlow][MiddleLayer][axp][" + str + jn1.ARRAY_END_STR, str2);
    }

    public static void flowLog(String str, String str2, String str3) {
        loge("[KeyFlow][MiddleLayer][axp][" + str + "][" + str2 + jn1.ARRAY_END_STR, str3);
    }

    @SuppressLint({"MissingPermission"})
    private static int getDataNetworkType(TelephonyManager telephonyManager) {
        if (Build.VERSION.SDK_INT >= 24) {
            return com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getDataNetworkType(telephonyManager);
        }
        return 0;
    }

    private static String getMobileNetworkType(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return "获取移动网络状态失败，";
            }
            switch (Build.VERSION.SDK_INT < 30 ? com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getNetworkType(telephonyManager) : getDataNetworkType(telephonyManager)) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return NETWORKTYPE_2G;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return NETWORKTYPE_3G;
                case 13:
                    return NETWORKTYPE_4G;
                default:
                    return NETWORKTYPE_MOBILE;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return NETWORKTYPE_INVALID;
        }
    }

    public static String getNetWorkType(Context context) {
        if (NetworkUtil.hasInternet(context)) {
            if (NetworkUtil.isWifi(context)) {
                return NETWORKTYPE_WIFI;
            }
            try {
                return getMobileNetworkType(context);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return NETWORKTYPE_INVALID;
    }

    public static void httpLog(String str) {
        RemoteLogger.log(TAG_PLAYER, str);
    }

    public static void loge(String str, String str2) {
        RemoteLogger.log(str, str2);
    }

    public static void playLog(String str) {
        RemoteLogger.log(TAG_PLAYER, str);
    }

    public static void playUerActionLog(String str) {
        loge(TAG_ALIX_USERACTION, str);
    }
}
