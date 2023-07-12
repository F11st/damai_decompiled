package mtopsdk.xstate.network;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import java.util.Locale;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.util.MtopSDKThreadPoolExecutorFactory;
import mtopsdk.xstate.NetworkClassEnum;
import mtopsdk.xstate.XState;
import mtopsdk.xstate.util.XStateConstants;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class NetworkStateReceiver extends BroadcastReceiver {
    private static final String TAG = "mtopsdk.NetworkStateReceiver";
    static final int TYPE_BLUETOOTH = 7;
    static final int TYPE_DUMMY = 8;
    static final int TYPE_ETHERNET = 9;
    static final int TYPE_MOBILE = 0;
    static final int TYPE_MOBILE_CBS = 12;
    static final int TYPE_MOBILE_DUN = 4;
    static final int TYPE_MOBILE_EMERGENCY = 15;
    static final int TYPE_MOBILE_FOTA = 10;
    static final int TYPE_MOBILE_HIPRI = 5;
    static final int TYPE_MOBILE_IA = 14;
    static final int TYPE_MOBILE_IMS = 11;
    static final int TYPE_MOBILE_MMS = 2;
    static final int TYPE_MOBILE_SUPL = 3;
    static final int TYPE_PROXY = 16;
    static final int TYPE_VPN = 17;
    static final int TYPE_WIFI = 1;
    static final int TYPE_WIFI_P2P = 13;
    static final int TYPE_WIMAX = 6;
    public static volatile String apn = "unknown";
    public static volatile String bssid = "";
    private static ConnectivityManager mConnectivityManager = null;
    private static WifiManager mWifiManager = null;
    public static volatile String ssid = "";

    private static String getNetworkTypeName(int i) {
        switch (i) {
            case 0:
                return "MOBILE";
            case 1:
                return "WIFI";
            case 2:
                return "MOBILE_MMS";
            case 3:
                return "MOBILE_SUPL";
            case 4:
                return "MOBILE_DUN";
            case 5:
                return "MOBILE_HIPRI";
            case 6:
                return "WIMAX";
            case 7:
                return "BLUETOOTH";
            case 8:
                return "DUMMY";
            case 9:
                return "ETHERNET";
            case 10:
                return "MOBILE_FOTA";
            case 11:
                return "MOBILE_IMS";
            case 12:
                return "MOBILE_CBS";
            case 13:
                return "WIFI_P2P";
            case 14:
                return "MOBILE_IA";
            case 15:
                return "MOBILE_EMERGENCY";
            case 16:
                return "PROXY";
            case 17:
                return "VPN";
            default:
                return Integer.toString(i);
        }
    }

    private String parseExtraInfo(String str) {
        if (!TextUtils.isEmpty(str)) {
            String lowerCase = str.toLowerCase(Locale.US);
            if (lowerCase.contains("cmwap")) {
                return "cmwap";
            }
            if (lowerCase.contains("uniwap")) {
                return "uniwap";
            }
            if (lowerCase.contains("3gwap")) {
                return "3gwap";
            }
            if (lowerCase.contains("ctwap")) {
                return "ctwap";
            }
            if (lowerCase.contains("cmnet")) {
                return "cmnet";
            }
            if (lowerCase.contains("uninet")) {
                return "uninet";
            }
            if (lowerCase.contains("3gnet")) {
                return "3gnet";
            }
            if (lowerCase.contains("ctnet")) {
                return "ctnet";
            }
        }
        return "unknown";
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, Intent intent) {
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i(TAG, "[onReceive] networkStateReceiver onReceive");
        }
        MtopSDKThreadPoolExecutorFactory.submit(new Runnable() { // from class: mtopsdk.xstate.network.NetworkStateReceiver.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    NetworkStateReceiver.this.updateNetworkStatus(context);
                } catch (Throwable th) {
                    TBSdkLog.e(NetworkStateReceiver.TAG, "[onReceive] updateNetworkStatus error", th);
                }
            }
        });
    }

    @TargetApi(3)
    void updateNetworkStatus(Context context) {
        NetworkInfo networkInfo;
        if (context == null) {
            return;
        }
        WifiInfo wifiInfo = null;
        try {
            if (mConnectivityManager == null) {
                mConnectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            }
            networkInfo = com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo(mConnectivityManager);
        } catch (Throwable th) {
            TBSdkLog.e(TAG, "getNetworkInfo error.", th);
            networkInfo = null;
        }
        if (networkInfo != null && networkInfo.isConnected()) {
            int type = networkInfo.getType();
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i(TAG, "[updateNetworkStatus] NetworkInfo isConnected=" + networkInfo.isConnected() + ", isAvailable=" + networkInfo.isAvailable() + ", type=" + getNetworkTypeName(type));
            }
            if (type == 0) {
                int subtype = networkInfo.getSubtype();
                NetworkClassEnum networkClassByType = NetworkStatus.getNetworkClassByType(subtype);
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
                    TBSdkLog.d(TAG, "[updateNetworkStatus]Mobile network," + networkClassByType.getNetClass());
                }
                apn = parseExtraInfo(networkInfo.getExtraInfo());
                XState.setValue(XStateConstants.KEY_NQ, networkClassByType.getNetClass());
                XState.setValue("netType", NetworkStatus.getNetworkTypeName(subtype));
                return;
            } else if (type != 1) {
                if (type != 9) {
                    String networkTypeName = getNetworkTypeName(type);
                    XState.setValue(XStateConstants.KEY_NQ, networkTypeName);
                    XState.setValue("netType", networkTypeName);
                    return;
                }
                NetworkClassEnum networkClassEnum = NetworkClassEnum.NET_ETHERNET;
                XState.setValue(XStateConstants.KEY_NQ, networkClassEnum.getNetClass());
                XState.setValue("netType", networkClassEnum.getNetClass());
                return;
            } else {
                try {
                    if (mWifiManager == null) {
                        mWifiManager = (WifiManager) context.getSystemService("wifi");
                    }
                    wifiInfo = mWifiManager.getConnectionInfo();
                } catch (Throwable th2) {
                    TBSdkLog.e(TAG, "[updateNetworkStatus]getWifiInfo error.", th2);
                }
                if (wifiInfo != null) {
                    bssid = wifiInfo.getBSSID();
                    ssid = wifiInfo.getSSID();
                }
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                    TBSdkLog.i(TAG, "[updateNetworkStatus]WIFI network.ssid= " + ssid + ", bssid=" + bssid);
                }
                NetworkClassEnum networkClassEnum2 = NetworkClassEnum.NET_WIFI;
                XState.setValue(XStateConstants.KEY_NQ, networkClassEnum2.getNetClass());
                XState.setValue("netType", networkClassEnum2.getNetClass());
                return;
            }
        }
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i(TAG, "[updateNetworkStatus]no network");
        }
        NetworkClassEnum networkClassEnum3 = NetworkClassEnum.NET_NO;
        XState.setValue(XStateConstants.KEY_NQ, networkClassEnum3.getNetClass());
        XState.setValue("netType", networkClassEnum3.getNetClass());
    }
}
