package com.youku.live.dago.liveplayback;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import tb.gn1;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class NetWorkUtil {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int NETWORK_2G = 11;
    public static final int NETWORK_3G = 12;
    public static final int NETWORK_4G = 13;
    private static final int NETWORK_CLASS_2_G = 1;
    private static final int NETWORK_CLASS_3_G = 2;
    private static final int NETWORK_CLASS_4_G = 3;
    private static final int NETWORK_CLASS_UNAVAILABLE = -1;
    private static final int NETWORK_CLASS_UNKNOWN = 0;
    private static final int NETWORK_CLASS_WIFI = -101;
    public static final int NETWORK_MOBILE_UNKNOWN = 2;
    public static final int NETWORK_TYPE_1xRTT = 7;
    public static final int NETWORK_TYPE_CDMA = 4;
    public static final int NETWORK_TYPE_EDGE = 2;
    public static final int NETWORK_TYPE_EHRPD = 14;
    public static final int NETWORK_TYPE_EVDO_0 = 5;
    public static final int NETWORK_TYPE_EVDO_A = 6;
    public static final int NETWORK_TYPE_EVDO_B = 12;
    public static final int NETWORK_TYPE_GPRS = 1;
    public static final int NETWORK_TYPE_HSDPA = 8;
    public static final int NETWORK_TYPE_HSPA = 10;
    public static final int NETWORK_TYPE_HSPAP = 15;
    public static final int NETWORK_TYPE_HSUPA = 9;
    public static final int NETWORK_TYPE_IDEN = 11;
    public static final int NETWORK_TYPE_LTE = 13;
    public static final int NETWORK_TYPE_UMTS = 3;
    private static final int NETWORK_TYPE_UNAVAILABLE = -1;
    public static final int NETWORK_TYPE_UNKNOWN = 0;
    private static final int NETWORK_TYPE_WIFI = -101;
    public static final int NETWORK_UNAVAILABLE = 1;
    public static final int NETWORK_UNKNOWN = 0;
    public static final int NETWORK_WIFI = 10;
    private static DecimalFormat df = new DecimalFormat("#.##");

    private static String formatIpAddress(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1423745671")) {
            return (String) ipChange.ipc$dispatch("-1423745671", new Object[]{Integer.valueOf(i)});
        }
        return (i & 255) + "." + ((i >> 8) & 255) + "." + ((i >> 16) & 255) + "." + ((i >> 24) & 255);
    }

    public static int getCurrentNetworkType(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1959111342")) {
            return ((Integer) ipChange.ipc$dispatch("1959111342", new Object[]{context})).intValue();
        }
        int networkClass = getNetworkClass(context);
        if (networkClass != -101) {
            if (networkClass != -1) {
                if (networkClass != 0) {
                    if (networkClass == 1) {
                        return 11;
                    }
                    if (networkClass == 2) {
                        return 12;
                    }
                    if (networkClass == 3) {
                        return 13;
                    }
                }
                return 0;
            }
            return 1;
        }
        return 10;
    }

    public static String getDNS() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-114320741")) {
            return (String) ipChange.ipc$dispatch("-114320741", new Object[0]);
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            Method method = Class.forName("android.os.SystemProperties").getMethod(gn1.TYPE_OPEN_URL_METHOD_GET, String.class);
            ArrayList arrayList = new ArrayList();
            String[] strArr = {"net.dns1", "net.dns2", "net.dns3", "net.dns4"};
            for (int i = 0; i < 4; i++) {
                String str = (String) method.invoke(null, strArr[i]);
                if (str != null && !"".equals(str) && !arrayList.contains(str)) {
                    arrayList.add(str);
                }
                stringBuffer.append(str);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
        }
        return stringBuffer.toString();
    }

    public static String getGPRSLocalIpAddress() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1385342000")) {
            return (String) ipChange.ipc$dispatch("-1385342000", new Object[0]);
        }
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress()) {
                        return nextElement.getHostAddress();
                    }
                }
            }
            return null;
        } catch (SocketException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getHostIp() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1074250317")) {
            return (String) ipChange.ipc$dispatch("-1074250317", new Object[0]);
        }
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress()) {
                        return nextElement.getHostAddress();
                    }
                }
            }
            return null;
        } catch (SocketException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getLocalIpAddress() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-300093978")) {
            return (String) ipChange.ipc$dispatch("-300093978", new Object[0]);
        }
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress()) {
                        return nextElement.getHostAddress();
                    }
                }
            }
            return null;
        } catch (SocketException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getMacAddress(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "413115823")) {
            return (String) ipChange.ipc$dispatch("413115823", new Object[]{context});
        }
        WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
        return com.alibaba.wireless.security.aopsdk.replace.android.net.wifi.WifiInfo.getMacAddress(connectionInfo) != null ? com.alibaba.wireless.security.aopsdk.replace.android.net.wifi.WifiInfo.getMacAddress(connectionInfo) : "null";
    }

    @SuppressLint({"MissingPermission"})
    private static int getNetworkClass(Context context) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "523776905")) {
            return ((Integer) ipChange.ipc$dispatch("523776905", new Object[]{context})).intValue();
        }
        try {
            NetworkInfo activeNetworkInfo = ConnectivityManager.getActiveNetworkInfo((android.net.ConnectivityManager) context.getSystemService("connectivity"));
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected()) {
                int type = activeNetworkInfo.getType();
                if (type == 1) {
                    i = -101;
                } else if (type == 0) {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    i = getNetworkType(context);
                }
            } else {
                i = -1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getNetworkClassByType(i);
    }

    private static int getNetworkClassByType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1831680427")) {
            return ((Integer) ipChange.ipc$dispatch("-1831680427", new Object[]{Integer.valueOf(i)})).intValue();
        }
        int i2 = -101;
        if (i != -101) {
            i2 = -1;
            if (i != -1) {
                switch (i) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        return 1;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        return 2;
                    case 13:
                        return 3;
                    default:
                        return 0;
                }
            }
        }
        return i2;
    }

    @SuppressLint({"MissingPermission"})
    private static int getNetworkType(Context context) {
        int dataNetworkType;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "995971221")) {
            return ((Integer) ipChange.ipc$dispatch("995971221", new Object[]{context})).intValue();
        }
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

    public static String getWIFILocalIpAdress(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1810804691")) {
            return (String) ipChange.ipc$dispatch("1810804691", new Object[]{context});
        }
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        if (!wifiManager.isWifiEnabled()) {
            wifiManager.setWifiEnabled(true);
        }
        return formatIpAddress(wifiManager.getConnectionInfo().getIpAddress());
    }

    @SuppressLint({"MissingPermission"})
    public static boolean isNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "313240601")) {
            return ((Boolean) ipChange.ipc$dispatch("313240601", new Object[]{context})).booleanValue();
        }
        if (context == null || (activeNetworkInfo = ConnectivityManager.getActiveNetworkInfo((android.net.ConnectivityManager) context.getSystemService("connectivity"))) == null) {
            return false;
        }
        return activeNetworkInfo.isAvailable();
    }

    @SuppressLint({"MissingPermission"})
    public static boolean isWifiConnected(Context context) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1354556580") ? ((Boolean) ipChange.ipc$dispatch("1354556580", new Object[]{context})).booleanValue() : ((android.net.ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1).isConnected();
    }
}
