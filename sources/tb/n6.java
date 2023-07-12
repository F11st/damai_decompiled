package tb;

import android.app.Application;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import cn.damai.common.AppConfig;
import com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class n6 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String APN_3G_NET = "3GNet";
    public static final String APN_3G_WAP = "3GWap";
    public static final String APN_NET = "Net";
    public static final String APN_UNKNOWN = "N/A";
    public static final String APN_WAP = "Wap";
    public static final String APN_WIFI = "Wifi";
    public static final String HTTP_PRESSED_TYPE = "gzip";
    public static final int TYPE_3G_NET = 2;
    public static final int TYPE_3G_WAP = 3;
    public static final int TYPE_NET = 1;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_WAP = 4;
    public static final int TYPE_WIFI = 5;
    public static int a = 5;
    public static String b = null;
    public static String c = "cmwap";
    public static final int connectTime = 30000;
    public static String d = "cmnet";
    public static String e = "3gwap";
    public static String f = "3gnet";
    public static String g = "uniwap";
    public static String h = "uninet";
    public static String i = "ctwap";
    public static String j = "ctnet";
    public static String k = "";
    public static String l = "";
    public static String m = "";
    public static String q = null;
    public static final int readTime = 30000;
    public static final int writeTime = 30000;
    public static final String osVersion = e80.e();
    public static final String model = e80.b();
    public static String n = "";
    public static String o = "";
    public static int p = 0;

    public static String a(int i2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1122864208") ? (String) ipChange.ipc$dispatch("1122864208", new Object[]{Integer.valueOf(i2)}) : i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? APN_UNKNOWN : APN_WIFI : APN_WAP : APN_3G_WAP : APN_3G_NET : APN_NET;
    }

    public static Map<String, String> b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "482395822")) {
            return (Map) ipChange.ipc$dispatch("482395822", new Object[0]);
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, String> entry : d(false).entrySet()) {
            String value = entry.getValue();
            if (!wh2.j(value)) {
                try {
                    hashMap.put(entry.getKey(), URLEncoder.encode(value, "UTF-8"));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        return hashMap;
    }

    public static String c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "315228135")) {
            return (String) ipChange.ipc$dispatch("315228135", new Object[0]);
        }
        if (TextUtils.isEmpty(m)) {
            qw2.d("apn", "before version: " + m);
            m = AppConfig.q();
            qw2.d("apn", "after version: " + m);
        }
        return String.format("damaiapp_android_v%s", m);
    }

    public static Map<String, String> d(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1504382096")) {
            return (Map) ipChange.ipc$dispatch("-1504382096", new Object[]{Boolean.valueOf(z)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("version", m);
        hashMap.put("connmode", n);
        hashMap.put("model", model);
        hashMap.put("osVersion", osVersion);
        hashMap.put("posmode", "gps,wifi");
        hashMap.put("ispos", "" + p);
        hashMap.put("iscard", o);
        hashMap.put("company", k);
        hashMap.put("user-agent", f());
        hashMap.put("Damai-UA", c());
        hashMap.put("Content-Type", IRequestConst.CONTENT_TYPE_POST);
        if (!wh2.j(z20.F())) {
            hashMap.put(IRequestConst.COOKIE, "damai_cn_user=" + z20.F());
        }
        if (!z) {
            hashMap.put("imei", l);
            hashMap.put("x-hm-imei", l);
        }
        qw2.d("apn", " head map = " + hashMap);
        return hashMap;
    }

    public static Map<String, String> e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-390136806")) {
            return (Map) ipChange.ipc$dispatch("-390136806", new Object[0]);
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, String> entry : d(true).entrySet()) {
            String value = entry.getValue();
            if (!wh2.j(value)) {
                try {
                    hashMap.put(entry.getKey(), URLEncoder.encode(value, "UTF-8"));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        return hashMap;
    }

    public static String f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1140627613")) {
            return (String) ipChange.ipc$dispatch("1140627613", new Object[0]);
        }
        if (TextUtils.isEmpty(m)) {
            qw2.d("apn", "before version: " + m);
            m = AppConfig.q();
            qw2.d("apn", "after version: " + m);
        }
        if (TextUtils.isEmpty(q)) {
            qw2.d("apn", "before language: " + q);
            q = "zh";
            qw2.d("apn", "after language: " + q);
        }
        return String.format("%s rv:%s (Android; Android OS %s;%s)", new SimpleDateFormat("yyMMdd", Locale.CHINA).format(new Date()), m, osVersion, q);
    }

    public static void g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "182261527")) {
            ipChange.ipc$dispatch("182261527", new Object[0]);
            return;
        }
        Application a2 = mu0.a();
        try {
            NetworkInfo activeNetworkInfo = ConnectivityManager.getActiveNetworkInfo((android.net.ConnectivityManager) a2.getSystemService("connectivity"));
            TelephonyManager telephonyManager = (TelephonyManager) a2.getSystemService("phone");
            if (telephonyManager != null && telephonyManager.getSimState() == 5) {
                o = "1";
            } else {
                o = "0";
            }
            l = e80.a(a2);
            m = AppConfig.q();
            q = a2.getResources().getConfiguration().locale.getLanguage();
            int i2 = -1;
            a = 0;
            String str = null;
            if (activeNetworkInfo != null) {
                i2 = activeNetworkInfo.getType();
                str = activeNetworkInfo.getExtraInfo();
                if (str == null) {
                    a = 0;
                } else {
                    str = str.trim().toLowerCase();
                }
            }
            if (i2 == 1) {
                a = 5;
            } else {
                if (str == null) {
                    a = 0;
                } else {
                    if (!str.contains(c) && !str.contains(g) && !str.contains(i)) {
                        if (str.contains(e)) {
                            a = 3;
                        } else {
                            if (!str.contains(d) && !str.contains(h) && !str.contains(j)) {
                                if (str.contains(f)) {
                                    a = 2;
                                } else {
                                    a = 0;
                                }
                            }
                            a = 1;
                        }
                    }
                    a = 4;
                }
                if (h(a)) {
                    b = Proxy.getDefaultHost();
                    Proxy.getDefaultPort();
                    String str2 = b;
                    if (str2 != null) {
                        b = str2.trim();
                    }
                    String str3 = b;
                    if (str3 != null && !"".equals(str3)) {
                        a = 4;
                    } else {
                        a = 1;
                    }
                }
            }
            n = a(a);
        } catch (Exception e2) {
            qw2.a("Apn", "init() called with: e = " + e2.getMessage());
            e2.printStackTrace();
        }
    }

    private static boolean h(int i2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "929699467") ? ((Boolean) ipChange.ipc$dispatch("929699467", new Object[]{Integer.valueOf(i2)})).booleanValue() : i2 == 4 || i2 == 0;
    }
}
