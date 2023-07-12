package com.youku.playerservice.axp.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.text.format.Formatter;
import com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager;
import com.youku.playerservice.axp.constants.NetType;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class NetworkUtil {
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
    public static NetType getNetType(Context context) {
        TelephonyManager telephonyManager;
        NetType netType = NetType.NONE;
        try {
            NetworkInfo activeNetworkInfo = ConnectivityManager.getActiveNetworkInfo((android.net.ConnectivityManager) context.getSystemService("connectivity"));
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected()) {
                int type = activeNetworkInfo.getType();
                if (type == 1) {
                    return NetType.WIFI;
                }
                if (type != 0 || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null) {
                    return netType;
                }
                switch (Build.VERSION.SDK_INT < 30 ? com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getNetworkType(telephonyManager) : com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getDataNetworkType(telephonyManager)) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        return NetType.G2;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        return NetType.G3;
                    case 13:
                    default:
                        return NetType.G4;
                }
            }
            return NetType.NO;
        } catch (Exception e) {
            e.printStackTrace();
            return netType;
        }
    }

    @SuppressLint({"MissingPermission"})
    public static boolean hasInternet(Context context) {
        android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
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
        }
        return false;
    }

    public static boolean isConnectedCellular(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ConnectivityManager.getActiveNetworkInfo((android.net.ConnectivityManager) context.getSystemService("connectivity"));
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.getType() == 0;
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static boolean isConnectedWifi(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ConnectivityManager.getActiveNetworkInfo((android.net.ConnectivityManager) context.getSystemService("connectivity"));
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.getType() == 1;
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
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
}
