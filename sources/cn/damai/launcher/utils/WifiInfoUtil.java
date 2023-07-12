package cn.damai.launcher.utils;

import android.content.Context;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import androidx.annotation.RequiresPermission;
import com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class WifiInfoUtil {
    private static transient /* synthetic */ IpChange $ipChange;
    private static String a;
    private static String b;

    @RequiresPermission("android.permission.ACCESS_WIFI_STATE")
    public static String a(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-817036291")) {
            return (String) ipChange.ipc$dispatch("-817036291", new Object[]{context});
        }
        if (a == null) {
            WifiInfo wifiInfo = null;
            try {
                NetworkInfo activeNetworkInfo = ConnectivityManager.getActiveNetworkInfo((android.net.ConnectivityManager) context.getSystemService("connectivity"));
                if (activeNetworkInfo == null || activeNetworkInfo.getType() != 1 || (wifiInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo()) == null || TextUtils.isEmpty(wifiInfo.getBSSID())) {
                    a = "";
                }
                if (wifiInfo != null) {
                    a = wifiInfo.getBSSID();
                } else {
                    a = "";
                }
            } catch (Exception unused) {
                a = "";
            }
        }
        return a;
    }

    @RequiresPermission("android.permission.ACCESS_WIFI_STATE")
    public static String b(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "952910149")) {
            return (String) ipChange.ipc$dispatch("952910149", new Object[]{context});
        }
        if (b == null) {
            WifiInfo wifiInfo = null;
            try {
                NetworkInfo activeNetworkInfo = ConnectivityManager.getActiveNetworkInfo((android.net.ConnectivityManager) context.getSystemService("connectivity"));
                if (activeNetworkInfo == null || activeNetworkInfo.getType() != 1 || (wifiInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo()) == null || TextUtils.isEmpty(wifiInfo.getSSID())) {
                    b = "";
                }
                if (wifiInfo != null) {
                    String trim = wifiInfo.getSSID().trim();
                    b = trim;
                    if (trim.startsWith("\"")) {
                        b = b.substring(1);
                    }
                    if (b.endsWith("\"")) {
                        String str = b;
                        b = str.substring(0, str.length() - 1);
                    }
                }
                if (b == null) {
                    b = "";
                }
            } catch (Exception unused) {
                b = "";
            }
        }
        return b;
    }
}
