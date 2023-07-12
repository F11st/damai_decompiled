package com.youku.alixplayer.opensdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.youku.alixplayer.opensdk.IPlayer;
import com.youku.media.arch.instruments.utils.RemoteLogger;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class TLogUtil {
    private static final String NETWORKTYPE_2G = "2G网络，";
    private static final String NETWORKTYPE_3G = "3G网络，";
    private static final String NETWORKTYPE_4G = "4G网络，";
    private static final String NETWORKTYPE_INVALID = "没有网络，";
    private static final String NETWORKTYPE_MOBILE = "未知移动网络，";
    private static final String NETWORKTYPE_WIFI = " wifi网络，";
    private static final String TAG_HTTP = "AlixHttpConnect";
    private static final String TAG_PLAYER = "Alix-PlayFlow";
    private static final String TAG_PREFIX = "Alix";
    private static final String TAG_VPM = "Alix-VPM";
    public static final String TYPE_PLAYER_LIFE_CYCLE = "播放器生命周期异常";
    private static boolean mEnable;

    private static String getMobileNetworkType(Context context) {
        if (((TelephonyManager) context.getSystemService("phone")) == null) {
            return "获取移动网络状态失败，";
        }
        switch (getNetworkType30(context)) {
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
    }

    public static String getNetWorkType(Context context) {
        if (PlayerUtil.hasInternet(context)) {
            if (PlayerUtil.isWifi(context)) {
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

    @SuppressLint({"MissingPermission"})
    private static int getNetworkType30(Context context) {
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

    public static void httpLog(String str) {
        loge(TAG_HTTP, str);
    }

    public static void loge(String str, String str2) {
        RemoteLogger.log(str, str2);
    }

    public static void playErrorLog(Context context, String str, int i, int i2, String str2) {
        playLog(getNetWorkType(context) + AVFSCacheConstants.COMMA_SEP + str + ", what=" + i + "， extra=" + i2 + " msg=" + str2);
    }

    public static void playLog(String str) {
        loge("Alix-PlayFlow", str);
    }

    public static void setEnable(boolean z) {
        mEnable = z;
    }

    public static void vpmLog(String str) {
        loge(TAG_VPM, str);
    }

    public static void playLog(String str, IPlayer iPlayer) {
        loge("Alix-PlayFlow", str + " @" + iPlayer.hashCode());
    }
}
