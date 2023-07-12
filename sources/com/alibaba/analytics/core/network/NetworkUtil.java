package com.alibaba.analytics.core.network;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.utils.Logger;
import com.alibaba.wireless.security.aopsdk.replace.java.net.NetworkInterface;
import com.alipay.sdk.m.u.c;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;
import tb.hl2;
import tb.xs2;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class NetworkUtil {
    public static final String NETWORK_CLASS_2_3_G = "2G/3G";
    public static final String NETWORK_CLASS_2_G = "2G";
    public static final String NETWORK_CLASS_3_G = "3G";
    public static final String NETWORK_CLASS_4_G = "4G";
    public static final String NETWORK_CLASS_5_G = "5G";
    public static final String NETWORK_CLASS_WIFI = "Wi-Fi";
    public static final String NETWORK_CLASS_UNKNOWN = "Unknown";
    private static String[] a = {NETWORK_CLASS_UNKNOWN, NETWORK_CLASS_UNKNOWN};
    private static boolean b = false;
    private static boolean c = false;
    private static boolean d = false;
    private static NetworkStatusReceiver e = new NetworkStatusReceiver();
    private static NetWorkStatusChecker f = new NetWorkStatusChecker();

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    private static class NetWorkStatusChecker implements Runnable {
        private Context context;

        private NetWorkStatusChecker() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Context context = this.context;
            if (context == null) {
                return;
            }
            NetworkUtil.g(context);
            NetworkOperatorUtil.f(this.context);
            xs2.k(this.context);
        }

        public NetWorkStatusChecker setContext(Context context) {
            this.context = context;
            return this;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    private static class NetworkStatusReceiver extends BroadcastReceiver {
        private NetworkStatusReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            hl2.c().f(NetworkUtil.f.setContext(context));
        }
    }

    public static String c(Context context) {
        try {
            return f(context)[0];
        } catch (Exception unused) {
            return NETWORK_CLASS_UNKNOWN;
        }
    }

    public static String d(Context context) {
        String[] f2;
        try {
            f2 = f(context);
        } catch (Exception unused) {
        }
        if (f2[0].equals(NETWORK_CLASS_2_3_G)) {
            return f2[1];
        }
        return f2[1].equals("5G") ? "5G" : NETWORK_CLASS_UNKNOWN;
    }

    private static String e(int i) {
        if (i != 20) {
            switch (i) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return "2G";
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return "3G";
                case 13:
                    return "4G";
                default:
                    return NETWORK_CLASS_UNKNOWN;
            }
        }
        return "4G";
    }

    public static String[] f(Context context) {
        if (!b) {
            g(context);
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void g(Context context) {
        synchronized (NetworkUtil.class) {
            if (context == null) {
                return;
            }
            try {
            } catch (Exception e2) {
                Logger.f("NetworkUtil", e2);
            }
            if (context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) != 0) {
                String[] strArr = a;
                strArr[0] = NETWORK_CLASS_UNKNOWN;
                strArr[1] = NETWORK_CLASS_UNKNOWN;
                return;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                String[] strArr2 = a;
                strArr2[0] = NETWORK_CLASS_UNKNOWN;
                strArr2[1] = NETWORK_CLASS_UNKNOWN;
                return;
            }
            NetworkInfo activeNetworkInfo = com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo(connectivityManager);
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                if (1 == activeNetworkInfo.getType()) {
                    a[0] = "Wi-Fi";
                    if (q(context)) {
                        a[1] = "5G";
                    } else {
                        a[1] = NETWORK_CLASS_UNKNOWN;
                    }
                } else if (activeNetworkInfo.getType() == 0) {
                    String[] strArr3 = a;
                    strArr3[0] = NETWORK_CLASS_2_3_G;
                    strArr3[1] = activeNetworkInfo.getSubtypeName();
                }
            } else {
                String[] strArr4 = a;
                strArr4[0] = NETWORK_CLASS_UNKNOWN;
                strArr4[1] = NETWORK_CLASS_UNKNOWN;
            }
            if (!b) {
                b = true;
            }
        }
    }

    public static String h() {
        NetworkInfo activeNetworkInfo;
        Context j = Variables.n().j();
        if (j == null) {
            return NETWORK_CLASS_UNKNOWN;
        }
        try {
            if (j.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", j.getPackageName()) == 0 && (activeNetworkInfo = com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo((ConnectivityManager) j.getSystemService("connectivity"))) != null && activeNetworkInfo.isConnected()) {
                if (activeNetworkInfo.getType() == 1) {
                    return "Wi-Fi";
                }
                if (activeNetworkInfo.getType() == 0) {
                    return e(activeNetworkInfo.getSubtype());
                }
            }
        } catch (Throwable unused) {
        }
        return NETWORK_CLASS_UNKNOWN;
    }

    public static String i(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            return k();
        }
        return j(context);
    }

    private static String j(Context context) {
        if (context != null) {
            try {
                WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
                if (connectionInfo != null) {
                    String macAddress = com.alibaba.wireless.security.aopsdk.replace.android.net.wifi.WifiInfo.getMacAddress(connectionInfo);
                    return TextUtils.isEmpty(macAddress) ? c.b : macAddress;
                }
                return c.b;
            } catch (Throwable unused) {
                return c.b;
            }
        }
        return c.b;
    }

    @TargetApi(23)
    private static String k() {
        try {
            byte[] hardwareAddress = NetworkInterface.getHardwareAddress(java.net.NetworkInterface.getByName("wlan0"));
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (i < hardwareAddress.length) {
                Object[] objArr = new Object[2];
                objArr[0] = Byte.valueOf(hardwareAddress[i]);
                objArr[1] = i < hardwareAddress.length - 1 ? ":" : "";
                sb.append(String.format("%02X%s", objArr));
                i++;
            }
            return sb.toString();
        } catch (Exception unused) {
            return c.b;
        }
    }

    private static boolean l(int i) {
        return i > 4900 && i < 5900;
    }

    public static boolean m(Context context) {
        if (context != null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager == null || context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) != 0) {
                    return true;
                }
                NetworkInfo activeNetworkInfo = com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo(connectivityManager);
                if (activeNetworkInfo != null) {
                    return activeNetworkInfo.isConnected();
                }
                return false;
            } catch (Exception unused) {
                return true;
            }
        }
        return true;
    }

    public static boolean n(Context context) {
        if (c) {
            return d;
        }
        try {
            try {
                WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
                if (Build.VERSION.SDK_INT >= 21) {
                    d = wifiManager.is5GHzBandSupported();
                } else {
                    d = false;
                }
                return d;
            } finally {
                c = true;
            }
        } catch (Throwable unused) {
            return d;
        }
    }

    public static boolean o(Context context) {
        if (context != null) {
            try {
                String str = f(context)[0];
                if (str.equals("2G") || str.equals("3G") || str.equals("4G") || str.equals(NETWORK_CLASS_2_3_G)) {
                    Logger.f("NetworkUtil", "isMobile");
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static boolean p(Context context) {
        if (context != null) {
            try {
                if (f(context)[0].equals("Wi-Fi")) {
                    Logger.f("NetworkUtil", "isWifi");
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private static boolean q(Context context) {
        WifiInfo connectionInfo;
        if (context == null || (connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo()) == null) {
            return false;
        }
        return l(Build.VERSION.SDK_INT >= 21 ? connectionInfo.getFrequency() : 0);
    }

    public static void r(Context context) {
        if (context == null) {
            return;
        }
        context.registerReceiver(e, new IntentFilter(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION));
        try {
            NetworkOperatorUtil.e(context);
        } catch (Exception unused) {
        }
        hl2.c().f(f.setContext(context));
    }

    public static void s(Context context) {
        NetworkStatusReceiver networkStatusReceiver;
        if (context == null || (networkStatusReceiver = e) == null) {
            return;
        }
        context.unregisterReceiver(networkStatusReceiver);
    }
}
