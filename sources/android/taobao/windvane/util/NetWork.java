package android.taobao.windvane.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import android.taobao.windvane.config.GlobalConfig;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpHost;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class NetWork {
    public static final int CHINA_MOBILE = 1;
    public static final int CHINA_TELECOM = 3;
    public static final int CHINA_UNICOM = 2;
    public static final String CONN_TYPE_GPRS = "gprs";
    public static final String CONN_TYPE_NONE = "none";
    public static final String CONN_TYPE_WIFI = "wifi";
    public static final int SIM_NO = -1;
    public static final int SIM_OK = 0;
    public static final int SIM_UNKNOW = -2;
    private static BroadcastReceiver connChangerRvr;
    public static boolean proxy;

    public static HttpHost getHttpsProxyInfo(Context context) {
        NetworkInfo networkInfo;
        if (Build.VERSION.SDK_INT < 11) {
            try {
                networkInfo = ConnectivityManager.getActiveNetworkInfo((android.net.ConnectivityManager) context.getSystemService("connectivity"));
            } catch (Exception e) {
                e.printStackTrace();
                networkInfo = null;
            }
            if (networkInfo != null && networkInfo.isAvailable() && networkInfo.getType() == 0) {
                String defaultHost = Proxy.getDefaultHost();
                int defaultPort = Proxy.getDefaultPort();
                if (defaultHost != null) {
                    return new HttpHost(defaultHost, defaultPort);
                }
                return null;
            }
            return null;
        }
        String property = System.getProperty("https.proxyHost");
        String property2 = System.getProperty("https.proxyPort");
        if (TextUtils.isEmpty(property)) {
            return null;
        }
        return new HttpHost(property, Integer.parseInt(property2));
    }

    public static int getNSP(Context context) {
        if (getSimState(context) == 0) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            String replaceAll = telephonyManager.getNetworkOperatorName().replaceAll(" ", "");
            String networkOperator = telephonyManager.getNetworkOperator();
            TaoLog.d("NSP: ", "operator = " + replaceAll + "  type = " + networkOperator);
            if (networkOperator != null) {
                replaceAll = networkOperator;
            }
            if (replaceAll == null || replaceAll.length() == 0) {
                return -2;
            }
            if (replaceAll.compareToIgnoreCase("中国移动") == 0 || replaceAll.compareToIgnoreCase("CMCC") == 0 || replaceAll.compareToIgnoreCase("ChinaMobile") == 0 || replaceAll.compareToIgnoreCase("46000") == 0) {
                return 1;
            }
            if (replaceAll.compareToIgnoreCase("中国电信") == 0 || replaceAll.compareToIgnoreCase("ChinaTelecom") == 0 || replaceAll.compareToIgnoreCase("46003") == 0 || replaceAll.compareToIgnoreCase("ChinaTelcom") == 0 || replaceAll.compareToIgnoreCase("460003") == 0) {
                return 3;
            }
            if (replaceAll.compareToIgnoreCase("中国联通") == 0 || replaceAll.compareToIgnoreCase("ChinaUnicom") == 0 || replaceAll.compareToIgnoreCase("46001") == 0 || replaceAll.compareToIgnoreCase("CU-GSM") == 0 || replaceAll.compareToIgnoreCase("CHN-CUGSM") == 0 || replaceAll.compareToIgnoreCase("CHNUnicom") == 0) {
                return 2;
            }
            String imsi = PhoneInfo.getImsi(context);
            if (imsi.startsWith("46000") || imsi.startsWith("46002") || imsi.startsWith("46007")) {
                return 1;
            }
            if (imsi.startsWith("46001")) {
                return 2;
            }
            return imsi.startsWith("46003") ? 3 : -2;
        }
        return -1;
    }

    public static String getNetConnType(Context context) {
        android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            TaoLog.w("Network", "can not get Context.CONNECTIVITY_SERVICE");
            return "none";
        }
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        if (networkInfo != null) {
            if (NetworkInfo.State.CONNECTED == networkInfo.getState()) {
                return "wifi";
            }
        } else {
            TaoLog.w("Network", "can not get ConnectivityManager.TYPE_WIFI");
        }
        NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
        if (networkInfo2 != null) {
            if (NetworkInfo.State.CONNECTED == networkInfo2.getState()) {
                return CONN_TYPE_GPRS;
            }
        } else {
            TaoLog.w("Network", "can not get ConnectivityManager.TYPE_MOBILE");
        }
        return "none";
    }

    public static Map<String, String> getNetWorkSubTypeMap(Context context) {
        String message;
        NetworkInfo networkInfo;
        HashMap hashMap = new HashMap(2);
        try {
            networkInfo = ConnectivityManager.getActiveNetworkInfo((android.net.ConnectivityManager) context.getSystemService("connectivity"));
            message = "";
        } catch (Throwable th) {
            message = th.getMessage();
            networkInfo = null;
        }
        if (networkInfo == null) {
            hashMap.put("message", message);
            hashMap.put("type", "NONE");
            return hashMap;
        } else if (networkInfo.getType() == 1) {
            hashMap.put("message", message);
            hashMap.put("type", "WIFI");
            return hashMap;
        } else {
            String str = "2G";
            switch (networkInfo.getSubtype()) {
                case 1:
                    message = "GPRS";
                    break;
                case 2:
                    message = "EDGE";
                    break;
                case 3:
                    message = "UMTS";
                    str = "3G";
                    break;
                case 4:
                    message = "CDMA";
                    break;
                case 5:
                    message = "EVDO_0";
                    str = "3G";
                    break;
                case 6:
                    message = "EVDO_A";
                    str = "3G";
                    break;
                case 7:
                    message = "1xRTT";
                    break;
                case 8:
                    message = "HSDPA";
                    str = "3G";
                    break;
                case 9:
                    message = "HSUPA";
                    str = "3G";
                    break;
                case 10:
                    message = "HSPA";
                    str = "3G";
                    break;
                case 11:
                    message = "IDEN";
                    break;
                case 12:
                    message = "EVDO_B";
                    str = "3G";
                    break;
                case 13:
                    message = "LTE";
                    str = "4G";
                    break;
                case 14:
                    message = "EHRPD";
                    str = "3G";
                    break;
                case 15:
                    message = "HSPAP";
                    str = "3G";
                    break;
                default:
                    str = "UNKNOWN";
                    break;
            }
            hashMap.put("message", message);
            hashMap.put("type", str);
            return hashMap;
        }
    }

    public static String getNetworkInfo(Context context) {
        NetworkInfo activeNetworkInfo;
        android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = ConnectivityManager.getActiveNetworkInfo(connectivityManager)) == null) {
            return null;
        }
        NetworkInfo.State state = activeNetworkInfo.getState();
        if (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING) {
            return activeNetworkInfo.getTypeName() + " " + activeNetworkInfo.getSubtypeName() + activeNetworkInfo.getExtraInfo();
        }
        return null;
    }

    public static int getNetworkType(Context context) {
        NetworkInfo activeNetworkInfo;
        android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = ConnectivityManager.getActiveNetworkInfo(connectivityManager)) == null || !activeNetworkInfo.isConnectedOrConnecting()) {
            return -9;
        }
        return activeNetworkInfo.getType();
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00ae, code lost:
        if (r12 == null) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.HashMap<java.lang.String, java.lang.String> getProxyInfo(android.content.Context r12, android.net.Uri r13) {
        /*
            java.lang.String r0 = "port"
            java.lang.String r1 = getNetworkInfo(r12)
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            r3 = 0
            if (r1 != 0) goto L10
            return r3
        L10:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "current network:"
            r4.append(r5)
            r4.append(r1)
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = "getProxyInfo"
            android.taobao.windvane.util.TaoLog.d(r5, r4)
            java.lang.String r4 = "WIFI"
            boolean r4 = r1.contains(r4)
            if (r4 != 0) goto Lb4
            java.lang.String r4 = "MOBILE UMTS"
            int r4 = r1.compareToIgnoreCase(r4)
            if (r4 != 0) goto L38
            goto Lb4
        L38:
            android.content.ContentResolver r6 = r12.getContentResolver()     // Catch: java.lang.Throwable -> La6 java.lang.Exception -> Lad
            r8 = 0
            java.lang.String r9 = "mcc =?"
            java.lang.String r12 = "460"
            java.lang.String[] r10 = new java.lang.String[]{r12}     // Catch: java.lang.Throwable -> La6 java.lang.Exception -> Lad
            r11 = 0
            r7 = r13
            android.database.Cursor r12 = r6.query(r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> La6 java.lang.Exception -> Lad
            boolean r13 = r12.moveToFirst()     // Catch: java.lang.Throwable -> La1 java.lang.Exception -> La4
            if (r13 == 0) goto Lb0
        L51:
            int r13 = r12.getCount()     // Catch: java.lang.Throwable -> La1 java.lang.Exception -> La4
            if (r13 <= 0) goto L9a
            java.lang.String r13 = "host"
            java.lang.String r4 = "proxy"
            int r4 = r12.getColumnIndex(r4)     // Catch: java.lang.Throwable -> La1 java.lang.Exception -> La4
            java.lang.String r4 = r12.getString(r4)     // Catch: java.lang.Throwable -> La1 java.lang.Exception -> La4
            r2.put(r13, r4)     // Catch: java.lang.Throwable -> La1 java.lang.Exception -> La4
            int r13 = r12.getColumnIndex(r0)     // Catch: java.lang.Throwable -> La1 java.lang.Exception -> La4
            java.lang.String r13 = r12.getString(r13)     // Catch: java.lang.Throwable -> La1 java.lang.Exception -> La4
            r2.put(r0, r13)     // Catch: java.lang.Throwable -> La1 java.lang.Exception -> La4
            java.lang.String r13 = "apn"
            int r13 = r12.getColumnIndex(r13)     // Catch: java.lang.Throwable -> La1 java.lang.Exception -> La4
            java.lang.String r13 = r12.getString(r13)     // Catch: java.lang.Throwable -> La1 java.lang.Exception -> La4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La1 java.lang.Exception -> La4
            r4.<init>()     // Catch: java.lang.Throwable -> La1 java.lang.Exception -> La4
            java.lang.String r6 = "apn:"
            r4.append(r6)     // Catch: java.lang.Throwable -> La1 java.lang.Exception -> La4
            r4.append(r13)     // Catch: java.lang.Throwable -> La1 java.lang.Exception -> La4
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> La1 java.lang.Exception -> La4
            android.taobao.windvane.util.TaoLog.d(r5, r4)     // Catch: java.lang.Throwable -> La1 java.lang.Exception -> La4
            boolean r13 = r1.contains(r13)     // Catch: java.lang.Throwable -> La1 java.lang.Exception -> La4
            if (r13 == 0) goto L9a
            r12.close()
            return r2
        L9a:
            boolean r13 = r12.moveToNext()     // Catch: java.lang.Throwable -> La1 java.lang.Exception -> La4
            if (r13 != 0) goto L51
            goto Lb0
        La1:
            r13 = move-exception
            r3 = r12
            goto La7
        La4:
            goto Lae
        La6:
            r13 = move-exception
        La7:
            if (r3 == 0) goto Lac
            r3.close()
        Lac:
            throw r13
        Lad:
            r12 = r3
        Lae:
            if (r12 == 0) goto Lb3
        Lb0:
            r12.close()
        Lb3:
            return r3
        Lb4:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: android.taobao.windvane.util.NetWork.getProxyInfo(android.content.Context, android.net.Uri):java.util.HashMap");
    }

    public static int getSimState(Context context) {
        int simState = ((TelephonyManager) context.getSystemService("phone")).getSimState();
        if (simState == 5) {
            return 0;
        }
        return simState == 1 ? -1 : -2;
    }

    public static boolean isAvailable(Context context) {
        return getNetworkType(context) >= 0;
    }

    public static boolean isConnectionInexpensive() {
        return isWiFiActive() || isEthernetActive(GlobalConfig.context);
    }

    public static boolean isEthernetActive(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return getNetworkType(context) == 9;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isWiFiActive() {
        return isWiFiActive(GlobalConfig.context);
    }

    public static void setProxy(String str, String str2) {
        if (str != null && str.length() != 0) {
            proxy = true;
            System.getProperties().put("proxySet", "true");
            System.getProperties().put("proxyHost", str);
            if (str2 != null && str2.length() > 0) {
                System.getProperties().put("proxyPort", str2);
                return;
            } else {
                System.getProperties().put("proxyPort", "80");
                return;
            }
        }
        System.getProperties().put("proxySet", "false");
        proxy = false;
    }

    public static void unRegNetWorkRev(Context context) {
        setProxy(null, null);
        try {
            BroadcastReceiver broadcastReceiver = connChangerRvr;
            if (broadcastReceiver != null) {
                context.unregisterReceiver(broadcastReceiver);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isWiFiActive(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return getNetworkType(context) == 1;
        } catch (Exception unused) {
            return false;
        }
    }
}
