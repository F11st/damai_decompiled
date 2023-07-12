package tb;

import android.content.Context;
import android.net.NetworkInfo;
import androidx.annotation.RequiresPermission;
import cn.damai.player.utils.network.NetworkType;
import com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class yj1 {
    private static transient /* synthetic */ IpChange $ipChange;

    @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
    private static NetworkInfo a(Context context) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-552749211") ? (NetworkInfo) ipChange.ipc$dispatch("-552749211", new Object[]{context}) : ConnectivityManager.getActiveNetworkInfo((android.net.ConnectivityManager) context.getSystemService("connectivity"));
    }

    @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
    public static NetworkType b(Context context) {
        NetworkType networkType;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "721686714")) {
            return (NetworkType) ipChange.ipc$dispatch("721686714", new Object[]{context});
        }
        NetworkType networkType2 = NetworkType.NETWORK_NO;
        NetworkInfo a = a(context);
        if (a == null || !a.isAvailable()) {
            return networkType2;
        }
        if (a.getType() == 1) {
            return NetworkType.NETWORK_WIFI;
        }
        if (a.getType() == 0) {
            NetworkType networkType3 = NetworkType.NETWORK_MOBILE;
            switch (a.getSubtype()) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                case 16:
                    networkType = NetworkType.NETWORK_2G;
                    break;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                    networkType = NetworkType.NETWORK_3G;
                    break;
                case 13:
                case 18:
                    networkType = NetworkType.NETWORK_4G;
                    break;
                default:
                    String subtypeName = a.getSubtypeName();
                    if (!subtypeName.equalsIgnoreCase("TD-SCDMA") && !subtypeName.equalsIgnoreCase("WCDMA") && !subtypeName.equalsIgnoreCase("CDMA2000")) {
                        networkType = NetworkType.NETWORK_UNKNOWN;
                        break;
                    } else {
                        networkType = NetworkType.NETWORK_3G;
                        break;
                    }
                    break;
            }
            return networkType;
        }
        return NetworkType.NETWORK_UNKNOWN;
    }
}
