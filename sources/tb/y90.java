package tb;

import android.text.TextUtils;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class y90 {
    public static final String AB_STRATEGY = "abStrategy";
    public static final String ANDROID = "android";
    public static final String APPKEY = "appkey";
    public static final String APP_NAME = "appName";
    public static final String APP_VERSION = "appVersion";
    public static final String BSSID = "bssid";
    public static final String CARRIER = "carrier";
    public static final String CHANNEL = "channel";
    public static final String CONFIG_VERSION = "cv";
    public static final String DEVICEID = "deviceId";
    public static final String DOMAIN = "domain";
    public static final String HOSTS = "hosts";
    public static final String LATITUDE = "lat";
    public static final String LONGTITUDE = "lng";
    public static final String MACHINE = "machine";
    public static final String MNC = "mnc";
    public static final String NETWORK_ID = "networkId";
    public static final String NET_TYPE = "netType";
    public static final String OTHER = "other";
    public static final String PLATFORM = "platform";
    public static final String PLATFORM_VERSION = "platformVersion";
    public static final String PRE_IP = "preIp";
    public static final String SID = "sid";
    public static final String SIGN = "sign";
    public static final String SIGNTYPE = "signType";
    public static final String SIGN_SPLIT_SYMBOL = "&";
    public static final String STACK_TYPE = "stackType";
    public static final String TIMESTAMP = "t";
    public static final String VERSION = "v";
    public static final String VER_CODE = "5.2";
    public static final String VER_CODE_OLD = "5.1";
    public static final String VER_CODE_UPGRADE = "6.0";
    public static String[] a = new String[0];
    public static String[] b = {"amdc.m.taobao.com", "amdc.wapa.taobao.com", "amdc.taobao.net"};
    public static String[][] c = {new String[]{lw2.e(203119206064L), lw2.e(203119211219L)}, new String[]{lw2.e(106011052006L)}, null};
    public static String[][] d = {new String[]{lw2.g("7f1*-00f-1004-8042"), lw2.g("77*-01f-1004-8042")}, new String[]{lw2.g("7f1*-00f-1004-8042"), lw2.g("77*-01f-1004-8042")}, null};
    public static final String serverPath = "/amdc/mobileDispatch";

    public static String a() {
        return b[hu0.e().getEnvMode()];
    }

    public static String[] b() {
        return c[hu0.e().getEnvMode()];
    }

    public static String[] c() {
        return d[hu0.e().getEnvMode()];
    }

    public static boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equalsIgnoreCase(a());
    }
}
