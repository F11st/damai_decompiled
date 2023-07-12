package com.youku.live.dago.widgetlib.ailpbaselib.utils;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class NetworkUtils {
    private static transient /* synthetic */ IpChange $ipChange;

    public static boolean hasInternet() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1506692365")) {
            return ((Boolean) ipChange.ipc$dispatch("1506692365", new Object[0])).booleanValue();
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) AppContextUtils.getApp().getSystemService("connectivity");
        if (connectivityManager == null) {
            ((ILog) Dsl.getService(ILog.class)).d("NetWorkState", "Unavailabel");
            return false;
        }
        NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
        if (allNetworkInfo != null) {
            for (NetworkInfo networkInfo : allNetworkInfo) {
                if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                    ((ILog) Dsl.getService(ILog.class)).d("NetWorkState", "Availabel");
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isWifi() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-548619541")) {
            return ((Boolean) ipChange.ipc$dispatch("-548619541", new Object[0])).booleanValue();
        }
        NetworkInfo activeNetworkInfo = com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo((ConnectivityManager) AppContextUtils.getApp().getSystemService("connectivity"));
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
    }
}
