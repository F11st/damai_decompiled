package com.youku.player.util;

import android.annotation.SuppressLint;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import androidx.annotation.Keep;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.youku.e.C7901a;
import java.util.HashMap;

/* compiled from: Taobao */
@Keep
/* loaded from: classes13.dex */
public class TLogUtilNative {
    private static final String ERROR_BEFORE_PALY = "播放前出错";
    private static final String ERROR_IN_PALY = "播放中出错";
    public static final String ERROR_USER_REPORT = "灰度用户主动上传-1";
    public static final String ERROR_VIP_MID_AD = "会员播中插";
    public static final String ERROR_VIP_PRE_AD = "会员播前贴";
    private static final String NETWORKTYPE_2G = "2G网络，";
    private static final String NETWORKTYPE_3G = "3G网络，";
    private static final String NETWORKTYPE_4G = "4G网络，";
    private static final String NETWORKTYPE_INVALID = "没有网络，";
    private static final String NETWORKTYPE_MOBILE = "未知移动网络，";
    private static final String NETWORKTYPE_WAP = "wap网络，";
    private static final String NETWORKTYPE_WIFI = " wifi网络，";
    private static final String TAG_ALIPLAYER = "YKPlayer.AliMediaPlayer";
    private static final String TAG_HTTP = "YKPlayer.HttpConnect";
    private static final String TAG_PLAYER = "YKPlayer.PlayFlow";
    private static final String TAG_PREFIX = "YKPlayer.";
    private static String user_ip = "";

    public static void aliplayerLog(String str) {
        loge(TAG_ALIPLAYER, str);
    }

    @SuppressLint({"MissingPermission"})
    private static int getDataNetworkType(TelephonyManager telephonyManager) {
        if (Build.VERSION.SDK_INT >= 24) {
            return com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getDataNetworkType(telephonyManager);
        }
        return 0;
    }

    public static String getErrorMsg(int i, int i2) {
        if ((i >= 30000 && i < 40000) || i == 11010) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(i2 & 255);
                sb.append('.');
                sb.append((i2 >> 8) & 255);
                sb.append('.');
                sb.append((i2 >> 16) & 255);
                sb.append('.');
                sb.append((i2 >> 24) & 255);
                return sb.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return String.valueOf(i2);
    }

    private static String getMobileNetworkType() {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) C7901a.a.getSystemService("phone");
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

    public static String getNetWorkType() {
        if (hasInternet()) {
            if (isWifi()) {
                return NETWORKTYPE_WIFI;
            }
            try {
                return getMobileNetworkType();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return NETWORKTYPE_INVALID;
    }

    public static boolean hasInternet() {
        ConnectivityManager connectivityManager = (ConnectivityManager) C7901a.a.getSystemService("connectivity");
        if (connectivityManager == null) {
            C8063c.a("NetWorkState", "Unavailabel");
            return false;
        }
        NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
        if (allNetworkInfo != null) {
            for (NetworkInfo networkInfo : allNetworkInfo) {
                if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                    C8063c.a("NetWorkState", "Availabel");
                    return true;
                }
            }
        }
        return false;
    }

    public static void httpLog(String str) {
        logi(TAG_HTTP, str);
    }

    public static boolean isWifi() {
        NetworkInfo activeNetworkInfo = com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo((ConnectivityManager) C7901a.a.getSystemService("connectivity"));
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
    }

    public static void logd(String str, String str2) {
        C8068f.a().a(str, str2);
    }

    public static void loge(String str, String str2) {
        C8068f.a().a(str, str2);
    }

    public static void logi(String str, String str2) {
        C8068f.a().a(str, str2);
    }

    public static void logv(String str, String str2) {
        C8068f.a().a(str, str2);
    }

    public static void logw(String str, String str2) {
        C8068f.a().a(str, str2);
    }

    public static void playErrorLog(String str, int i, int i2) {
        playErrorLog(str, i, i2, -1);
    }

    public static void playErrorLog(String str, int i, int i2, int i3) {
        String str2;
        if (i3 != -1) {
            str2 = getNetWorkType() + AVFSCacheConstants.COMMA_SEP + str + ", what=" + i + "， extra=" + i2 + "， msg(ip) =" + i3 + ", cdnip =" + getErrorMsg(i2, i3);
        } else {
            str2 = getNetWorkType() + AVFSCacheConstants.COMMA_SEP + str + ", what=" + i + "， extra=" + i2;
        }
        playLog(str2);
        playLog("用户IP：" + user_ip);
        uploadTlogPlayError(i2);
    }

    public static void playLog(String str) {
        loge(TAG_PLAYER, str);
    }

    public static void setUserIP(String str) {
        user_ip = str;
    }

    public static void uploadTlogFile(String str) {
        new HashMap().put("type", str);
        playLog(str + "， 上传TLog日志!");
        C8068f.a().a(str);
    }

    private static void uploadTlogPlayError(int i) {
    }
}
