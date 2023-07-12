package com.youku.alixplayer.opensdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.text.format.Formatter;
import com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager;
import com.taobao.phenix.request.ImageStatistics;
import com.taobao.weex.annotation.JSMethod;
import com.youku.alixplayer.opensdk.ups.data.MediaMap;
import com.youku.live.dago.widgetlib.ailplive.LiveManager;
import com.youku.media.arch.instruments.ConfigFetcher;
import java.io.UnsupportedEncodingException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URLEncoder;
import java.util.Enumeration;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class PlayerUtil {
    public static final int NET_2G = 2;
    public static final int NET_3G = 3;
    public static final int NET_4G = 4;
    public static final int NET_NONE = 0;
    public static final int NET_WIFI = 1;
    public static boolean has265Failed;

    public static String getAbilityJson(boolean z) {
        return getAbilityJsonInJsonObject(z).toString();
    }

    public static JSONObject getAbilityJsonInJsonObject(boolean z) {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("hbrPlay", ConfigFetcher.getInstance().getConfig("z_real_config", "live_z_real_enable", "0"));
            jSONObject.put("ahbrPlay", 1);
            jSONObject.put("abrPlay", ConfigFetcher.getInstance().getConfig("network_retry_config_live", "live_enable_abr", "1"));
            String str2 = LiveManager.StreamConfig.QTY_1080P;
            if ("1".equals(ConfigFetcher.getInstance().getConfig("youku_player_config", "force_show_4k", "0")) || (MediaMap.supporth265() && "1".equals(ConfigFetcher.getInstance().getConfig("player_config", "4k_support", "0")))) {
                str2 = "4k";
            }
            String config = ConfigFetcher.getInstance().getConfig("z_real_config", "max_fps", "50");
            jSONObject.put("decode_resolution_FPS", str2 + JSMethod.NOT_SET + config);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (!has265Failed && z) {
            str = getDecode();
            jSONObject.put(ImageStatistics.KEY_BITMAP_DECODE, str);
            jSONObject.put("decodeMode", getDecodeMode());
            return jSONObject;
        }
        str = "H264";
        TLogUtil.playLog("播放器h265播放报错或者业务层指定不使用h265，则能力改为不支持h265");
        jSONObject.put(ImageStatistics.KEY_BITMAP_DECODE, str);
        jSONObject.put("decodeMode", getDecodeMode());
        return jSONObject;
    }

    public static String getDecode() {
        return ConfigFetcher.getInstance().getConfig("live_player_config", ImageStatistics.KEY_BITMAP_DECODE, "H265");
    }

    public static String getDecodeMode() {
        return ConfigFetcher.getInstance().getConfig("live_player_config", "decode_mode", "HW");
    }

    public static String getDrmAuthCode(Context context) {
        String str;
        String packageName = context.getPackageName();
        if (packageName != null) {
            if (packageName.equals("com.wondertek.miguaikan")) {
                str = "0275";
            } else if (packageName.equals("com.huawei.himovie")) {
                str = "0ce5_himovie";
            } else if (packageName.equals("com.huawei.hwvplayer")) {
                str = "0ce5_hwvplayer";
            } else if (packageName.equals("com.youku.playerdemo")) {
                str = "0275_demo";
            } else if (packageName.equals("yanhua.tv.ykshell")) {
                str = "0275_yanhua";
            }
            Logger.d("authCode=" + str);
            return str;
        }
        str = "";
        Logger.d("authCode=" + str);
        return str;
    }

    public static String getIp(Context context) {
        Exception e;
        String str;
        SocketException e2;
        String str2 = "";
        try {
            if (ConnectivityManager.getActiveNetworkInfo((android.net.ConnectivityManager) context.getSystemService("connectivity")) == null) {
                return "";
            }
            str = Formatter.formatIpAddress(((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getIpAddress());
            try {
                if (TextUtils.isEmpty(str)) {
                    str2 = str;
                } else if (!"0.0.0.0".equals(str)) {
                    return str;
                }
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if (!nextElement.isLoopbackAddress() && !nextElement.isLinkLocalAddress() && nextElement.isSiteLocalAddress() && (nextElement instanceof Inet4Address)) {
                            return nextElement.getHostAddress();
                        }
                    }
                }
                return str2;
            } catch (SocketException e3) {
                e2 = e3;
                e2.printStackTrace();
                return str;
            } catch (Exception e4) {
                e = e4;
                e.printStackTrace();
                return str;
            }
        } catch (SocketException e5) {
            String str3 = str2;
            e2 = e5;
            str = str3;
        } catch (Exception e6) {
            String str4 = str2;
            e = e6;
            str = str4;
        }
    }

    @SuppressLint({"MissingPermission"})
    public static int getNetType(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ConnectivityManager.getActiveNetworkInfo((android.net.ConnectivityManager) context.getSystemService("connectivity"));
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected()) {
                int type = activeNetworkInfo.getType();
                if (type == 1) {
                    return 1;
                }
                if (type != 0 || ((TelephonyManager) context.getSystemService("phone")) == null) {
                    return 0;
                }
                return getNetworkClassByType(getNetworkType(context));
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    private static int getNetworkClassByType(int i) {
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
            case 14:
            case 15:
                return 3;
            case 13:
            default:
                return 4;
        }
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

    public static String getVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @SuppressLint({"MissingPermission"})
    public static boolean hasInternet(Context context) {
        android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        try {
            NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
            if (allNetworkInfo != null) {
                for (NetworkInfo networkInfo : allNetworkInfo) {
                    if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String intToIP(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(i & 255);
        sb.append('.');
        sb.append((i >> 8) & 255);
        sb.append('.');
        sb.append((i >> 16) & 255);
        sb.append('.');
        sb.append((i >> 24) & 255);
        return sb.toString();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [boolean, int] */
    public static boolean isShowid(String str) {
        int length = str.length();
        ?? startsWith = str.startsWith("z");
        int i = length - startsWith;
        if (i != 20) {
            return false;
        }
        for (int i2 = startsWith; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if ((charAt < '0' || charAt > '9') && ((charAt < 'A' || charAt > 'F') && (charAt < 'a' || charAt > 'f'))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isVid(String str) {
        return TextUtils.isEmpty(str) || !isShowid(str);
    }

    @SuppressLint({"MissingPermission"})
    public static boolean isWifi(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ConnectivityManager.getActiveNetworkInfo((android.net.ConnectivityManager) context.getSystemService("connectivity"));
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.getType() == 1;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String urlEncoder(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        }
    }

    public static String getAbilityJson() {
        return getAbilityJson(true);
    }

    public static JSONObject getAbilityJsonInJsonObject() {
        return getAbilityJsonInJsonObject(true);
    }
}
