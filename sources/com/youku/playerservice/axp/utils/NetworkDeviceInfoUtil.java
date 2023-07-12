package com.youku.playerservice.axp.utils;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.youku.core.context.YoukuContext;
import com.youku.media.arch.instruments.ConfigFetcher;
import com.youku.phone.deviceinfo.WifiInfoUtil;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class NetworkDeviceInfoUtil {
    private static final boolean APS_HAS_OPEN;
    private static final boolean APS_HTTP_GET_WAN_IP_OPEN;
    private static final String GETCELLULARIP_TAG = "Network.getCellularIp";
    private static String IpAndMacAndSimInfo_ = null;
    private static final String TAG = "NetworkDeviceInfoUtil";
    private static String WifiMac_;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    private static class CacheIpAndMacAndSimInfoHandler extends Handler {
        private static final CacheIpAndMacAndSimInfoHandler INSTANCE = new CacheIpAndMacAndSimInfoHandler();
        private static final int WORK_MESSAGE_ID = 222;

        private CacheIpAndMacAndSimInfoHandler() {
            super(CacheIpAndMacAndSimInfoHandlerThread.INSTANCE.getLooper());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void wantedToRefresh() {
            INSTANCE.sendEmptyMessageDelayed(222, 1000L);
        }

        @Override // android.os.Handler
        public final void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            if (message.what != 222) {
                return;
            }
            removeMessages(222);
            try {
                String access$100 = NetworkDeviceInfoUtil.access$100();
                Log.d(NetworkDeviceInfoUtil.TAG, "网络状态变化,缓存信息" + access$100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    private static class CacheIpAndMacAndSimInfoHandlerThread {
        public static final CacheIpAndMacAndSimInfoHandlerThread INSTANCE = new CacheIpAndMacAndSimInfoHandlerThread();
        private HandlerThread thread;

        private CacheIpAndMacAndSimInfoHandlerThread() {
            try {
                HandlerThread handlerThread = new HandlerThread("CacheIpAndMacAndSimInfo");
                this.thread = handlerThread;
                handlerThread.start();
            } catch (InternalError unused) {
                Log.e("CacheIpAndMacAndSimInfo", "some error occurred, can't cache info anymore");
            }
        }

        public Looper getLooper() {
            return this.thread.getLooper();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    private static class NetWorkChangReceiver extends BroadcastReceiver {
        private static final NetWorkChangReceiver INSTANCE = new NetWorkChangReceiver();

        private NetWorkChangReceiver() {
        }

        public static NetWorkChangReceiver getINSTANCE() {
            return INSTANCE;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || !ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION.equals(intent.getAction())) {
                return;
            }
            CacheIpAndMacAndSimInfoHandler.wantedToRefresh();
        }

        public void register() {
            Application application = YoukuContext.getApplication();
            if (application == null) {
                return;
            }
            application.registerReceiver(this, new IntentFilter(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION));
        }

        public void unregister() {
            Application application = YoukuContext.getApplication();
            if (application == null) {
                return;
            }
            application.unregisterReceiver(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static class SharedPreferencesHelp {
        private static final SharedPreferencesHelp INSTANCE = new SharedPreferencesHelp();
        private static SharedPreferences.Editor e;
        private static SharedPreferences s;

        private SharedPreferencesHelp() {
            Application application = YoukuContext.getApplication();
            SharedPreferences sharedPreferences = application.getSharedPreferences(application.getPackageName() + "_DeviceInfo_MAC_IP", 4);
            s = sharedPreferences;
            e = sharedPreferences.edit();
        }

        public static SharedPreferencesHelp getINSTANCE() {
            return INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String getIp(String str) {
            return s.getString(str, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void saveIp(String str, String str2) {
            e.putString(str, str2).apply();
        }
    }

    static {
        boolean equals = "1".equals(ConfigFetcher.getInstance().getConfig("player_new_core", "enable_speed_collect", "1"));
        APS_HAS_OPEN = equals;
        APS_HTTP_GET_WAN_IP_OPEN = "1".equals(ConfigFetcher.getInstance().getConfig("player_new_core", "enable_speed_collect_http_get_wan_ip", "1"));
        if (equals) {
            NetWorkChangReceiver.getINSTANCE().register();
        }
        IpAndMacAndSimInfo_ = null;
        WifiMac_ = null;
    }

    static /* synthetic */ String access$100() {
        return doRealRefresh();
    }

    private static void cacheWanIp(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        SharedPreferencesHelp.getINSTANCE().saveIp(str, str2);
    }

    public static void cacheWanIpWithUpsInfo(String str) {
        Context applicationContext;
        if (APS_HAS_OPEN && (applicationContext = YoukuContext.getApplicationContext()) != null) {
            try {
                NetworkInfo activeNetworkInfo = ConnectivityManager.getActiveNetworkInfo((android.net.ConnectivityManager) applicationContext.getSystemService("connectivity"));
                if (activeNetworkInfo == null) {
                    return;
                }
                String str2 = null;
                if (activeNetworkInfo.getType() == 1) {
                    SharedPreferencesHelp.getINSTANCE().saveIp(getWifiRouterMac(), str);
                    str2 = refreshWifiOrCellularInfoString(true);
                } else if (activeNetworkInfo.getType() == 0) {
                    SharedPreferencesHelp.getINSTANCE().saveIp(getSimCardIccId(), str);
                    str2 = refreshWifiOrCellularInfoString(false);
                }
                Log.d(TAG, "UPS请求结束后,缓存信息" + str2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static String doHttpGet(String str) {
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(str);
        httpGet.getParams().setParameter("http.useragent", "curl");
        httpGet.setHeader(IRequestConst.USER_AGENT, "curl/7.64.1");
        return EntityUtils.toString(defaultHttpClient.execute(httpGet).getEntity(), "utf-8");
    }

    private static String doRealRefresh() {
        Context applicationContext = YoukuContext.getApplicationContext();
        if (applicationContext == null) {
            return null;
        }
        try {
            NetworkInfo activeNetworkInfo = ConnectivityManager.getActiveNetworkInfo((android.net.ConnectivityManager) applicationContext.getSystemService("connectivity"));
            if (activeNetworkInfo == null) {
                return null;
            }
            if (activeNetworkInfo.getType() == 1) {
                return refreshWifiOrCellularInfoString(true);
            }
            if (activeNetworkInfo.getType() == 0) {
                return refreshWifiOrCellularInfoString(false);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String formatIp(long j) {
        int[] iArr = {(int) ((j >> 24) & 255), (int) ((j >> 16) & 255), (int) ((j >> 8) & 255), (int) (j & 255)};
        for (int i = 0; i < 4; i++) {
            if (iArr[i] < 0 || iArr[i] > 255) {
                return null;
            }
        }
        return Integer.toString(iArr[3]) + "." + Integer.toString(iArr[2]) + "." + Integer.toString(iArr[1]) + "." + Integer.toString(iArr[0]);
    }

    public static String getCacheIpAndMacAndSimInfo() {
        String str = IpAndMacAndSimInfo_;
        return str == null ? "" : str;
    }

    public static String getCachedWifiMac() {
        String str = WifiMac_;
        return str == null ? "" : str;
    }

    private static String getCellularInfoString() {
        String simCardIccId = getSimCardIccId();
        String cellularIp = getCellularIp(true);
        if (!TextUtils.isEmpty(cellularIp)) {
            return simCardIccId + "/" + cellularIp;
        }
        String wanIP = getWanIP(simCardIccId);
        String cellularIp2 = getCellularIp(false);
        return simCardIccId + "/" + wanIP + "/" + cellularIp2;
    }

    /* JADX WARN: Removed duplicated region for block: B:73:0x009a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00b1 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String getCellularIp(boolean r6) {
        /*
            Method dump skipped, instructions count: 429
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.playerservice.axp.utils.NetworkDeviceInfoUtil.getCellularIp(boolean):java.lang.String");
    }

    public static String getIpv4AndIpv6(Context context) {
        Exception e;
        SocketException e2;
        try {
            if (ConnectivityManager.getActiveNetworkInfo((android.net.ConnectivityManager) context.getSystemService("connectivity")) == null) {
                return "";
            }
            String formatIpAddress = Formatter.formatIpAddress(((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getIpAddress());
            try {
                if (!TextUtils.isEmpty(formatIpAddress) && !"0.0.0.0".equals(formatIpAddress)) {
                    return formatIpAddress;
                }
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                String str = "";
                String str2 = str;
                while (networkInterfaces.hasMoreElements()) {
                    Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if (!nextElement.isLoopbackAddress() && !nextElement.isLinkLocalAddress()) {
                            if (nextElement instanceof Inet4Address) {
                                str = nextElement.getHostAddress();
                            } else if ((nextElement instanceof Inet6Address) && "".equals(str2)) {
                                str2 = nextElement.getHostAddress();
                            }
                        }
                    }
                }
                return str + "/" + str2;
            } catch (SocketException e3) {
                e2 = e3;
                e2.printStackTrace();
                return "";
            } catch (Exception e4) {
                e = e4;
                e.printStackTrace();
                return "";
            }
        } catch (SocketException e5) {
            e2 = e5;
        } catch (Exception e6) {
            e = e6;
        }
    }

    private static String getSimCardIccId() {
        Context applicationContext;
        SubscriptionManager subscriptionManager;
        SubscriptionInfo subscriptionInfo;
        try {
            if (Build.VERSION.SDK_INT < 22 || (applicationContext = YoukuContext.getApplicationContext()) == null || ((TelephonyManager) applicationContext.getSystemService("phone")) == null || ContextCompat.checkSelfPermission(applicationContext, "android.permission.READ_PHONE_STATE") != 0 || (subscriptionManager = (SubscriptionManager) applicationContext.getSystemService("telephony_subscription_service")) == null || (subscriptionInfo = (SubscriptionInfo) SubscriptionManager.class.getMethod("getDefaultDataSubscriptionInfo", new Class[0]).invoke(subscriptionManager, new Object[0])) == null) {
                return null;
            }
            return subscriptionInfo.getIccId();
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String getWanIP(String str) {
        String wanIpFromCache = getWanIpFromCache(str);
        if (TextUtils.isEmpty(wanIpFromCache)) {
            if (APS_HTTP_GET_WAN_IP_OPEN) {
                String wanIpFromHttpRequest = getWanIpFromHttpRequest();
                cacheWanIp(str, wanIpFromHttpRequest);
                return wanIpFromHttpRequest;
            }
            return null;
        }
        return wanIpFromCache;
    }

    private static String getWanIpFromCache(String str) {
        return SharedPreferencesHelp.getINSTANCE().getIp(str);
    }

    private static String getWanIpFromHttpRequest() {
        try {
            String trim = doHttpGet("http://ipaddr.host").trim();
            if (trim.length() <= 100 && !trim.contains("'") && !trim.contains("\"")) {
                if (!trim.contains(StringUtils.LF)) {
                    return trim;
                }
            }
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String getWiFiLocalIp() {
        WifiManager wifiManager;
        try {
            Context applicationContext = YoukuContext.getApplicationContext();
            if (applicationContext != null && (wifiManager = (WifiManager) applicationContext.getSystemService("wifi")) != null && wifiManager.isWifiEnabled()) {
                return Formatter.formatIpAddress(wifiManager.getConnectionInfo().getIpAddress());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getWifiInfoString(String str) {
        String wanIP = getWanIP(str);
        String wiFiLocalIp = getWiFiLocalIp();
        return str + "/" + wanIP + "/" + wiFiLocalIp;
    }

    private static String getWifiRouterMac() {
        Application application = YoukuContext.getApplication();
        return (application != null && Utils.isYoukuOrHuaweiBaipai(application)) ? WifiInfoUtil.getWifiRouterMac(application) : "";
    }

    private static String refreshWifiOrCellularInfoString(boolean z) {
        String cellularInfoString;
        String str;
        if (z) {
            str = getWifiRouterMac();
            cellularInfoString = getWifiInfoString(str);
        } else {
            cellularInfoString = getCellularInfoString();
            str = null;
        }
        WifiMac_ = str;
        IpAndMacAndSimInfo_ = cellularInfoString;
        return cellularInfoString;
    }
}
