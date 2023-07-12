package com.alibaba.analytics.core.logbuilder;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.alibaba.analytics.AnalyticsImp;
import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.core.config.e;
import com.alibaba.analytics.core.logbuilder.GoogleAdvertisingIdClient;
import com.alibaba.analytics.core.model.LogField;
import com.alibaba.analytics.core.model.UTMCLogFields;
import com.alibaba.analytics.core.network.NetworkUtil;
import com.alibaba.analytics.core.store.LogStoreMgr;
import com.alibaba.analytics.utils.Logger;
import com.taobao.weex.common.Constants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.ct2;
import tb.fd1;
import tb.fs1;
import tb.hi0;
import tb.hn;
import tb.jn1;
import tb.os2;
import tb.qa1;
import tb.ta1;
import tb.u6;
import tb.wd;
import tb.x70;
import tb.xs2;
import tb.yh2;
import tb.z70;
import tb.za2;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class a {
    private static volatile String a;
    private static volatile String b;

    public static String a(Map<String, String> map) {
        String str;
        String str2;
        StringBuilder sb;
        if (map != null && map.size() > 0) {
            Context j = Variables.n().j();
            if (j == null && AnalyticsImp.getApplication() != null) {
                j = AnalyticsImp.getApplication().getApplicationContext();
            }
            if (j == null) {
                return null;
            }
            z70 c = x70.c(j);
            if (c != null) {
                str2 = c.b();
                str = c.c();
            } else {
                str = null;
                str2 = null;
            }
            if (str2 != null && str != null) {
                LogField logField = LogField.IMEI;
                if (map.get(logField.toString()) == null) {
                    LogField logField2 = LogField.IMSI;
                    if (map.get(logField2.toString()) == null) {
                        map.put(logField.toString(), str2);
                        map.put(logField2.toString(), str);
                    }
                }
            }
            if (!yh2.f(Variables.n().C())) {
                map.put(LogField.USERNICK.toString(), Variables.n().C());
            }
            if (!yh2.f(Variables.n().p())) {
                map.put(LogField.LL_USERNICK.toString(), Variables.n().p());
            }
            if (!yh2.f(Variables.n().B())) {
                map.put(LogField.USERID.toString(), Variables.n().B());
            }
            if (!yh2.f(Variables.n().r())) {
                map.put(LogField.LL_USERID.toString(), Variables.n().r());
            }
            LogField logField3 = LogField.SDKVERSION;
            if (!map.containsKey(logField3.toString())) {
                map.put(logField3.toString(), os2.a().getFullSDKVersion());
            }
            LogField logField4 = LogField.APPKEY;
            if (!map.containsKey(logField4.toString())) {
                map.put(logField4.toString(), Variables.n().g());
            }
            if (!yh2.f(Variables.n().h())) {
                map.put(LogField.CHANNEL.toString(), Variables.n().h());
            }
            if (!yh2.f(Variables.n().f())) {
                map.put(LogField.APPVERSION.toString(), Variables.n().f());
            }
            LogField logField5 = LogField.RECORD_TIMESTAMP;
            if (map.containsKey(logField5.toString())) {
                map.put(logField5.toString(), "" + TimeStampAdjustMgr.k().j(map.get(logField5.toString())));
            } else {
                map.put(logField5.toString(), "" + TimeStampAdjustMgr.k().i());
            }
            LogField logField6 = LogField.START_SESSION_TIMESTAMP;
            if (!map.containsKey(logField6.toString())) {
                map.put(logField6.toString(), "" + za2.a().b());
            }
            LogField logField7 = LogField.SDKTYPE;
            if (!map.containsKey(logField7.toString())) {
                map.put(logField7.toString(), hn.a());
            }
            map.put(LogField.RESERVE5.toString(), b.d(j));
            Map<String, String> b2 = xs2.b(j);
            if (b2 != null) {
                k(map, b2);
                if (map.containsKey(UTMCLogFields.ALIYUN_PLATFORM_FLAG.toString())) {
                    map.put(LogField.OS.toString(), Constants.Name.Y);
                }
                String str3 = map.get(LogField.RESERVES.toString());
                if (!yh2.f(str3)) {
                    sb = new StringBuilder(str3);
                } else {
                    sb = new StringBuilder(100);
                }
                if (!wd.a()) {
                    if (yh2.f(b)) {
                        try {
                            if (j.checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE") == 0) {
                                b = NetworkUtil.i(j);
                            }
                        } catch (Exception unused) {
                        }
                    }
                    if (b != null) {
                        if (sb.length() > 0) {
                            sb.append(",_mac=");
                            sb.append(b);
                        } else {
                            sb.append("_mac=");
                            sb.append(b);
                        }
                        map.remove("_mac");
                    }
                    if (a == null) {
                        String f = f(j);
                        if (f == null) {
                            a = "";
                        } else {
                            a = f;
                        }
                    }
                    if (!yh2.f(a)) {
                        if (sb.length() > 0) {
                            sb.append(",_bssid=");
                            sb.append(a);
                        } else {
                            sb.append("_bssid=");
                            sb.append(a);
                        }
                    }
                    String c2 = fs1.c(j);
                    if (!TextUtils.isEmpty(c2)) {
                        if (sb.length() > 0) {
                            sb.append(",_ie=");
                            sb.append(c2);
                        } else {
                            sb.append("_ie=");
                            sb.append(c2);
                        }
                    }
                    String e = fs1.e(j);
                    if (!TextUtils.isEmpty(e)) {
                        if (sb.length() > 0) {
                            sb.append(",_is=");
                            sb.append(e);
                        } else {
                            sb.append("_is=");
                            sb.append(e);
                        }
                    }
                }
                if (NetworkUtil.n(j)) {
                    if (sb.length() > 0) {
                        sb.append(",_spt5g=1");
                    } else {
                        sb.append("_spt5g=1");
                    }
                } else if (sb.length() > 0) {
                    sb.append(",_spt5g=0");
                } else {
                    sb.append("_spt5g=0");
                }
                GoogleAdvertisingIdClient.b a2 = GoogleAdvertisingIdClient.a();
                if (a2 != null) {
                    if (a2.b()) {
                        if (sb.length() > 0) {
                            sb.append(",_glat=1");
                        } else {
                            sb.append("_glat=1");
                        }
                    } else {
                        if (sb.length() > 0) {
                            sb.append(",_glat=0");
                        } else {
                            sb.append("_glat=0");
                        }
                        String a3 = a2.a();
                        if (!TextUtils.isEmpty(a3)) {
                            if (sb.length() > 0) {
                                sb.append(",gps_adid=");
                                sb.append(a3);
                            } else {
                                sb.append("gps_adid=");
                                sb.append(a3);
                            }
                        }
                    }
                }
                UTMCLogFields uTMCLogFields = UTMCLogFields.DEVICE_ID;
                String str4 = map.get(uTMCLogFields.toString());
                if (str4 != null) {
                    if (sb.length() > 0) {
                        sb.append(",_did=");
                        sb.append(str4);
                    } else {
                        sb.append("_did=");
                        sb.append(str4);
                    }
                    map.remove(uTMCLogFields.toString());
                }
                String a4 = ta1.a(j);
                if (a4 != null) {
                    LogField logField8 = LogField.UTDID;
                    if (map.containsKey(logField8.toString()) && a4.equals(map.get(logField8.toString()))) {
                        a4 = "utdid";
                    }
                    if (sb.length() > 0) {
                        sb.append(",_umid=");
                        sb.append(a4);
                    } else {
                        sb.append("_umid=");
                        sb.append(a4);
                    }
                }
                if (Variables.n().H()) {
                    String v = Variables.n().v();
                    if (!TextUtils.isEmpty(v)) {
                        if (sb.length() > 0) {
                            sb.append(",_buildid=");
                            sb.append(v);
                        } else {
                            sb.append("_buildid=");
                            sb.append(v);
                        }
                    }
                }
                if (sb.length() > 0) {
                    sb.append(",_timeAdjust=");
                    sb.append(TimeStampAdjustMgr.k().h() ? "1" : "0");
                } else {
                    sb.append("_timeAdjust=");
                    sb.append(TimeStampAdjustMgr.k().h() ? "1" : "0");
                }
                String str5 = map.get(LogField.APPKEY.toString());
                String g = Variables.n().g();
                if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(g) && !g.equalsIgnoreCase(str5)) {
                    if (sb.length() > 0) {
                        sb.append(",_mak=");
                        sb.append(g);
                    } else {
                        sb.append("_mak=");
                        sb.append(g);
                    }
                }
                String str6 = xs2.e(Variables.n().j()) ? "1" : "0";
                if (sb.length() > 0) {
                    sb.append(",_pad=");
                    sb.append(str6);
                } else {
                    sb.append("_pad=");
                    sb.append(str6);
                }
                String c3 = u6.c(j);
                Logger.r("LogAssemble", "channel2", c3);
                if (!TextUtils.isEmpty(c3)) {
                    if (sb.length() > 0) {
                        sb.append(",_channel2=");
                        sb.append(c3);
                    } else {
                        sb.append("_channel2=");
                        sb.append(c3);
                    }
                }
                String u = Variables.n().u();
                if (!yh2.f(u)) {
                    if (sb.length() > 0) {
                        sb.append(",_openid=");
                        sb.append(u);
                    } else {
                        sb.append("_openid=");
                        sb.append(u);
                    }
                }
                String str7 = map.get("UTPVID_T");
                if (!TextUtils.isEmpty(str7)) {
                    if (sb.length() > 0) {
                        sb.append(",_t=");
                        sb.append(str7);
                    } else {
                        sb.append("_t=");
                        sb.append(str7);
                    }
                    map.remove("UTPVID_T");
                }
                String A = Variables.n().A();
                if (!TextUtils.isEmpty(A)) {
                    if (sb.length() > 0) {
                        sb.append(",_ut_site=");
                        sb.append(A);
                    } else {
                        sb.append("_ut_site=");
                        sb.append(A);
                    }
                }
                String q = Variables.n().q();
                if (!TextUtils.isEmpty(q)) {
                    if (sb.length() > 0) {
                        sb.append(",_ut_lsite=");
                        sb.append(q);
                    } else {
                        sb.append("_ut_lsite=");
                        sb.append(q);
                    }
                }
                Map<String, String> x = Variables.n().x();
                if (x != null && x.size() > 0) {
                    String b3 = yh2.b(x);
                    if (!yh2.f(b3)) {
                        if (sb.length() > 0) {
                            sb.append(",");
                            sb.append(b3);
                        } else {
                            sb.append(b3);
                        }
                    }
                }
                map.put(LogField.RESERVES.toString(), sb.toString());
                l(map);
                return b(map);
            }
        }
        return null;
    }

    public static String b(Map<String, String> map) {
        boolean z;
        String stringBuffer;
        LogField logField;
        Map<String, String> c = hi0.c(map);
        boolean z2 = true;
        boolean z3 = n(c, LogField.ARG3.toString()) || (n(c, LogField.ARG2.toString()) || n(c, LogField.ARG1.toString()));
        StringBuffer stringBuffer2 = new StringBuffer();
        LogField[] values = LogField.values();
        int length = values.length;
        int i = 0;
        while (true) {
            String str = null;
            if (i >= length || (logField = values[i]) == LogField.ARGS) {
                break;
            }
            if (c.containsKey(logField.toString())) {
                str = yh2.c(c.get(logField.toString()));
                c.remove(logField.toString());
            }
            stringBuffer2.append(c(str));
            stringBuffer2.append(jn1.OR);
            i++;
        }
        StringBuffer stringBuffer3 = new StringBuffer();
        LogField logField2 = LogField.ARGS;
        if (c.containsKey(logField2.toString())) {
            stringBuffer3.append(c(yh2.c(c.get(logField2.toString()))));
            c.remove(logField2.toString());
            z = false;
        } else {
            z = true;
        }
        for (String str2 : c.keySet()) {
            String c2 = c.containsKey(str2) ? yh2.c(c.get(str2)) : null;
            if (z) {
                if ("StackTrace".equals(str2)) {
                    stringBuffer3.append("StackTrace=====>");
                    stringBuffer3.append(c2);
                } else {
                    stringBuffer3.append(c(str2));
                    stringBuffer3.append("=");
                    stringBuffer3.append(c2);
                }
                z = false;
            } else if ("StackTrace".equals(str2)) {
                stringBuffer3.append(",");
                stringBuffer3.append("StackTrace=====>");
                stringBuffer3.append(c2);
            } else {
                stringBuffer3.append(",");
                stringBuffer3.append(c(str2));
                stringBuffer3.append("=");
                stringBuffer3.append(c2);
            }
        }
        int length2 = stringBuffer3.length();
        if (length2 < 1) {
            stringBuffer = "-";
        } else if (length2 > 40960) {
            String str3 = map.get(LogField.EVENTID.toString());
            if (!j(str3)) {
                if (!i(str3)) {
                    Logger.i("LogAssemble", "truncLog field", LogField.ARGS.toString(), "length", Integer.valueOf(length2));
                    stringBuffer = stringBuffer3.substring(0, 40960);
                } else if (length2 > 245760) {
                    Logger.i("LogAssemble", "truncLog field", LogField.ARGS.toString(), "length", Integer.valueOf(length2));
                    stringBuffer = stringBuffer3.substring(0, 245760);
                } else {
                    stringBuffer = stringBuffer3.toString();
                    z2 = z3;
                }
                z3 = z2;
            } else if (length2 > 409600) {
                Logger.i("LogAssemble", "truncLog field", LogField.ARGS.toString(), "length", Integer.valueOf(length2));
                stringBuffer = stringBuffer3.substring(0, 409600);
                z3 = z2;
            } else {
                stringBuffer = stringBuffer3.toString();
                z2 = z3;
                z3 = z2;
            }
        } else {
            stringBuffer = stringBuffer3.toString();
        }
        stringBuffer2.append(stringBuffer);
        String stringBuffer4 = stringBuffer2.toString();
        if (z3) {
            m(stringBuffer4);
        }
        return stringBuffer4;
    }

    private static String c(String str) {
        return yh2.f(str) ? "-" : str;
    }

    private static void d(String str, Map<String, String> map, Map<String, String> map2) {
        if (map.containsKey(str) || map2.get(str) == null) {
            return;
        }
        map.put(str, map2.get(str));
    }

    public static Map<String, String> e(String str) {
        LogField[] values;
        if (yh2.f(str)) {
            return null;
        }
        HashMap hashMap = new HashMap();
        String[] g = g(str, 34);
        if (g != null && g.length > 0) {
            int i = 0;
            for (LogField logField : LogField.values()) {
                if (i < g.length && g[i] != null) {
                    hashMap.put(logField.toString(), g[i]);
                }
                i++;
            }
        }
        return hashMap;
    }

    private static String f(Context context) {
        try {
            return ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getBSSID();
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String[] g(String str, int i) {
        int i2;
        String[] strArr = new String[i];
        int i3 = 0;
        int i4 = 0;
        while (true) {
            i2 = i - 1;
            if (i3 >= i2) {
                break;
            }
            int indexOf = str.indexOf(jn1.OR, i4);
            if (indexOf == -1) {
                strArr[i3] = str.substring(i4);
                break;
            }
            strArr[i3] = str.substring(i4, indexOf);
            i4 = indexOf + 2;
            i3++;
        }
        strArr[i2] = str.substring(i4);
        return strArr;
    }

    private static String h(String str) {
        return (TextUtils.isEmpty(str) || str.length() <= 1024) ? str : str.substring(0, 1024);
    }

    private static boolean i(String str) {
        return "19998".equalsIgnoreCase(str);
    }

    private static boolean j(String str) {
        return "65501".equalsIgnoreCase(str) || "65502".equalsIgnoreCase(str) || "65503".equalsIgnoreCase(str);
    }

    private static void k(Map<String, String> map, Map<String, String> map2) {
        LogField logField = LogField.BRAND;
        map.put(logField.toString(), map2.get(logField.toString()));
        LogField logField2 = LogField.DEVICE_MODEL;
        map.put(logField2.toString(), map2.get(logField2.toString()));
        LogField logField3 = LogField.RESOLUTION;
        map.put(logField3.toString(), map2.get(logField3.toString()));
        LogField logField4 = LogField.OS;
        map.put(logField4.toString(), map2.get(logField4.toString()));
        LogField logField5 = LogField.OSVERSION;
        map.put(logField5.toString(), map2.get(logField5.toString()));
        LogField logField6 = LogField.UTDID;
        map.put(logField6.toString(), map2.get(logField6.toString()));
        d(LogField.IMEI.toString(), map, map2);
        d(LogField.IMSI.toString(), map, map2);
        d(LogField.APPVERSION.toString(), map, map2);
        d(UTMCLogFields.DEVICE_ID.toString(), map, map2);
        d(LogField.LANGUAGE.toString(), map, map2);
        d(LogField.ACCESS.toString(), map, map2);
        d(LogField.ACCESS_SUBTYPE.toString(), map, map2);
        d(LogField.CARRIER.toString(), map, map2);
    }

    private static void l(Map<String, String> map) {
        try {
            List<String> c = e.d().c(map.get(LogField.EVENTID.toString()));
            if (c != null) {
                for (String str : c) {
                    map.remove(str);
                }
            }
        } catch (Exception unused) {
        }
    }

    private static void m(String str) {
        if (!ct2.d().f(19999, "TRUNC_LOG")) {
            Logger.f("sendTruncLogEvent", "TRUNC_LOG is discarded!");
            return;
        }
        Map<String, String> e = e(str);
        if (e == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("PN", e.get(LogField.PAGE.toString()));
        hashMap.put("EID", e.get(LogField.EVENTID.toString()));
        hashMap.put("A1", h(e.get(LogField.ARG1.toString())));
        hashMap.put("A2", h(e.get(LogField.ARG2.toString())));
        hashMap.put("A3", h(e.get(LogField.ARG3.toString())));
        hashMap.put("AS", h(e.get(LogField.ARGS.toString())));
        hashMap.put("R3", e.get(LogField.RESERVE3.toString()));
        LogStoreMgr.l().d(new qa1("UT_ANALYTICS", "19999", "TRUNC_LOG", "", "", fd1.c(hashMap)));
    }

    private static boolean n(Map<String, String> map, String str) {
        String str2 = map.get(str);
        if (TextUtils.isEmpty(str2) || str2.length() <= 40960) {
            return false;
        }
        Logger.i("LogAssemble truncLog", "field", str, "length", Integer.valueOf(str2.length()));
        map.put(str, str2.substring(0, 40960));
        return true;
    }
}
