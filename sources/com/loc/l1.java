package com.loc;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ali.user.open.tbauth.TbAuthConstants;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.weex.common.Constants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tb.a83;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class l1 {
    private static List<d0> g = new ArrayList();
    private static JSONArray h = null;
    static AMapLocation i = null;
    static boolean j = false;
    public SparseArray<Long> a = new SparseArray<>();
    public int b = -1;
    public long c = 0;
    String[] d = {"ol", "cl", "gl", "ha", "bs", "ds"};
    public int e = -1;
    public long f = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[AMapLocationClientOption.AMapLocationMode.values().length];
            a = iArr;
            try {
                iArr[AMapLocationClientOption.AMapLocationMode.Battery_Saving.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[AMapLocationClientOption.AMapLocationMode.Device_Sensors.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[AMapLocationClientOption.AMapLocationMode.Hight_Accuracy.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static String a(int i2) {
        if (i2 != 2011) {
            if (i2 != 2031) {
                if (i2 != 2041) {
                    if (i2 != 2081) {
                        if (i2 != 2091) {
                            if (i2 != 2111) {
                                if (i2 != 2121) {
                                    if (i2 != 2141) {
                                        if (i2 != 2021) {
                                            if (i2 != 2022) {
                                                if (i2 != 2061) {
                                                    if (i2 != 2062) {
                                                        switch (i2) {
                                                            case 2051:
                                                                return "NeedLoginNetWork\t";
                                                            case 2052:
                                                                return "MaybeIntercepted";
                                                            case 2053:
                                                                return "DecryptResponseException";
                                                            case 2054:
                                                                return "ParserDataException";
                                                            default:
                                                                switch (i2) {
                                                                    case 2101:
                                                                        return "BindAPSServiceException";
                                                                    case 2102:
                                                                        return "AuthClientScodeFail";
                                                                    case 2103:
                                                                        return "NotConfigAPSService";
                                                                    default:
                                                                        switch (i2) {
                                                                            case 2131:
                                                                                return "NoCgiOAndWifiInfo";
                                                                            case 2132:
                                                                                return "AirPlaneModeAndWifiOff";
                                                                            case 2133:
                                                                                return "NoCgiAndWifiOff";
                                                                            default:
                                                                                switch (i2) {
                                                                                    case 2151:
                                                                                        return "MaybeMockNetLoc";
                                                                                    case 2152:
                                                                                        return "MaybeMockGPSLoc";
                                                                                    case 2153:
                                                                                        return "UNSUPPORT_COARSE_LBSLOC";
                                                                                    case 2154:
                                                                                        return "UNSUPPORT_CONTINUE_LOC";
                                                                                    default:
                                                                                        return "";
                                                                                }
                                                                        }
                                                                }
                                                        }
                                                    }
                                                    return "ServerLocFail";
                                                }
                                                return "ServerRetypeError";
                                            }
                                            return "OnlyOneWifiButNotMain";
                                        }
                                        return "OnlyMainWifi";
                                    }
                                    return "NoEnoughStatellites";
                                }
                                return "NotLocPermission";
                            }
                            return "ErrorCgiInfo";
                        }
                        return "InitException";
                    }
                    return "LocalLocException";
                }
                return "ResponseResultIsNull";
            }
            return "CreateApsReqException";
        }
        return "ContextIsNull";
    }

    public static void b(long j2, long j3) {
        try {
            if (j) {
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("gpsTime:");
            stringBuffer.append(m1.j(j2, "yyyy-MM-dd HH:mm:ss.SSS"));
            stringBuffer.append(",");
            stringBuffer.append("sysTime:");
            stringBuffer.append(m1.j(j3, "yyyy-MM-dd HH:mm:ss.SSS"));
            stringBuffer.append(",");
            long J = i1.J();
            int i2 = (0L > J ? 1 : (0L == J ? 0 : -1));
            String j4 = i2 != 0 ? m1.j(J, "yyyy-MM-dd HH:mm:ss.SSS") : "0";
            stringBuffer.append("serverTime:");
            stringBuffer.append(j4);
            q("checkgpstime", stringBuffer.toString());
            if (i2 != 0 && Math.abs(j2 - J) < 31536000000L) {
                stringBuffer.append(", correctError");
                q("checkgpstimeerror", stringBuffer.toString());
            }
            stringBuffer.delete(0, stringBuffer.length());
            j = true;
        } catch (Throwable unused) {
        }
    }

    public static synchronized void c(Context context) {
        synchronized (l1.class) {
            if (context != null) {
                try {
                    if (i1.e()) {
                        List<d0> list = g;
                        if (list != null && list.size() > 0) {
                            ArrayList arrayList = new ArrayList();
                            arrayList.addAll(g);
                            bs.h(arrayList, context);
                            g.clear();
                        }
                        z(context);
                    }
                } catch (Throwable th) {
                    j1.h(th, "ReportUtil", Constants.Event.SLOT_LIFECYCLE.DESTORY);
                }
            }
        }
    }

    public static void e(Context context, int i2, int i3, long j2, long j3) {
        if (i2 == -1 || i3 == -1) {
            return;
        }
        try {
            k(context, "O012", i2, i3, j2, j3);
        } catch (Throwable th) {
            j1.h(th, "ReportUtil", "reportServiceAliveTime");
        }
    }

    public static void f(Context context, long j2, boolean z) {
        if (context != null) {
            try {
                if (i1.e()) {
                    g(context, j2, z, "O015");
                }
            } catch (Throwable th) {
                j1.h(th, "ReportUtil", "reportGPSLocUseTime");
            }
        }
    }

    private static void g(Context context, long j2, boolean z, String str) {
        l(context, str, !z ? "abroad" : "domestic", Long.valueOf(j2).intValue());
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0034 A[Catch: all -> 0x00f0, TRY_LEAVE, TryCatch #0 {all -> 0x00f0, blocks: (B:4:0x0003, B:8:0x000b, B:26:0x0034, B:37:0x0047, B:39:0x004b, B:40:0x0052, B:42:0x008b, B:45:0x0098, B:46:0x00d9, B:48:0x00eb, B:43:0x0091), top: B:58:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized void h(android.content.Context r8, com.amap.api.location.AMapLocation r9) {
        /*
            Method dump skipped, instructions count: 253
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.l1.h(android.content.Context, com.amap.api.location.AMapLocation):void");
    }

    public static void i(Context context, AMapLocation aMapLocation, ei eiVar) {
        int i2;
        if (aMapLocation == null) {
            return;
        }
        try {
            if (!GeocodeSearch.GPS.equalsIgnoreCase(aMapLocation.getProvider()) && aMapLocation.getLocationType() != 1) {
                String str = t(aMapLocation) ? "abroad" : "domestic";
                String str2 = "cache";
                if (aMapLocation.getErrorCode() != 0) {
                    int errorCode = aMapLocation.getErrorCode();
                    if (errorCode == 4 || errorCode == 5 || errorCode == 6 || errorCode == 11) {
                        str2 = "net";
                    }
                    i2 = 0;
                } else {
                    int locationType = aMapLocation.getLocationType();
                    if (locationType == 5 || locationType == 6) {
                        str2 = "net";
                    }
                    i2 = 1;
                }
                m(context, "O016", str2, str, i2, aMapLocation.getErrorCode(), eiVar);
            }
        } catch (Throwable th) {
            j1.h(th, "ReportUtil", "reportBatting");
        }
    }

    private static void k(Context context, String str, int i2, int i3, long j2, long j3) {
        if (context != null) {
            try {
                if (i1.e()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("param_int_first", i2);
                    jSONObject.put("param_int_second", i3);
                    jSONObject.put("param_long_first", j2);
                    jSONObject.put("param_long_second", j3);
                    n(context, str, jSONObject);
                }
            } catch (Throwable th) {
                j1.h(th, "ReportUtil", "applyStatisticsEx");
            }
        }
    }

    private static void l(Context context, String str, String str2, int i2) {
        if (context != null) {
            try {
                if (i1.e()) {
                    JSONObject jSONObject = new JSONObject();
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject.put("param_string_first", str2);
                    }
                    if (!TextUtils.isEmpty(null)) {
                        jSONObject.put("param_string_second", (Object) null);
                    }
                    if (i2 != Integer.MAX_VALUE) {
                        jSONObject.put("param_int_first", i2);
                    }
                    n(context, str, jSONObject);
                }
            } catch (Throwable th) {
                j1.h(th, "ReportUtil", "applyStatisticsEx");
            }
        }
    }

    private static void m(Context context, String str, String str2, String str3, int i2, int i3, ei eiVar) {
        if (context != null) {
            try {
                if (i1.e()) {
                    JSONObject jSONObject = new JSONObject();
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject.put("param_string_first", str2);
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        jSONObject.put("param_string_second", str3);
                    }
                    if (i2 != Integer.MAX_VALUE) {
                        jSONObject.put("param_int_first", i2);
                    }
                    if (i3 != Integer.MAX_VALUE) {
                        jSONObject.put("param_int_second", i3);
                    }
                    if (eiVar != null) {
                        if (!TextUtils.isEmpty(eiVar.d())) {
                            jSONObject.put(BaseMonitor.COUNT_POINT_DNS, eiVar.d());
                        }
                        if (!TextUtils.isEmpty(eiVar.e())) {
                            jSONObject.put("domain", eiVar.e());
                        }
                        if (!TextUtils.isEmpty(eiVar.f())) {
                            jSONObject.put("type", eiVar.f());
                        }
                        if (!TextUtils.isEmpty(eiVar.g())) {
                            jSONObject.put("reason", eiVar.g());
                        }
                        if (!TextUtils.isEmpty(eiVar.c())) {
                            jSONObject.put(TbAuthConstants.IP, eiVar.c());
                        }
                        if (!TextUtils.isEmpty(eiVar.b())) {
                            jSONObject.put("stack", eiVar.b());
                        }
                        if (eiVar.h() > 0) {
                            jSONObject.put("ctime", String.valueOf(eiVar.h()));
                        }
                        if (eiVar.a() > 0) {
                            jSONObject.put("ntime", String.valueOf(eiVar.a()));
                        }
                    }
                    n(context, str, jSONObject);
                }
            } catch (Throwable th) {
                j1.h(th, "ReportUtil", "applyStatisticsEx");
            }
        }
    }

    public static synchronized void n(Context context, String str, JSONObject jSONObject) {
        synchronized (l1.class) {
            if (context != null) {
                try {
                    if (i1.e()) {
                        d0 d0Var = new d0(context, "loc", "6.1.0", str);
                        if (jSONObject != null) {
                            d0Var.a(jSONObject.toString());
                        }
                        g.add(d0Var);
                        if (g.size() >= 30) {
                            ArrayList arrayList = new ArrayList();
                            arrayList.addAll(g);
                            bs.h(arrayList, context);
                            g.clear();
                        }
                    }
                } catch (Throwable th) {
                    j1.h(th, "ReportUtil", "applyStatistics");
                }
            }
        }
    }

    public static void o(AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        try {
            if (i == null) {
                if (!m1.q(aMapLocation)) {
                    i = aMapLocation2;
                    return;
                }
                i = aMapLocation.m216clone();
            }
            if (m1.q(i) && m1.q(aMapLocation2)) {
                AMapLocation m216clone = aMapLocation2.m216clone();
                if (i.getLocationType() != 1 && i.getLocationType() != 9 && !GeocodeSearch.GPS.equalsIgnoreCase(i.getProvider()) && i.getLocationType() != 7 && m216clone.getLocationType() != 1 && m216clone.getLocationType() != 9 && !GeocodeSearch.GPS.equalsIgnoreCase(m216clone.getProvider()) && m216clone.getLocationType() != 7) {
                    long abs = Math.abs(m216clone.getTime() - i.getTime()) / 1000;
                    if (abs <= 0) {
                        abs = 1;
                    }
                    if (abs <= 1800) {
                        float c = m1.c(i, m216clone);
                        float f = c / ((float) abs);
                        if (c > 30000.0f && f > 1000.0f) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(i.getLatitude());
                            sb.append(",");
                            sb.append(i.getLongitude());
                            sb.append(",");
                            sb.append(i.getAccuracy());
                            sb.append(",");
                            sb.append(i.getLocationType());
                            sb.append(",");
                            if (aMapLocation.getTime() != 0) {
                                sb.append(m1.j(i.getTime(), "yyyyMMdd_HH:mm:ss:SS"));
                            } else {
                                sb.append(i.getTime());
                            }
                            sb.append(com.youku.live.livesdk.wkit.component.Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                            sb.append(m216clone.getLatitude());
                            sb.append(",");
                            sb.append(m216clone.getLongitude());
                            sb.append(",");
                            sb.append(m216clone.getAccuracy());
                            sb.append(",");
                            sb.append(m216clone.getLocationType());
                            sb.append(",");
                            if (m216clone.getTime() != 0) {
                                sb.append(m1.j(m216clone.getTime(), "yyyyMMdd_HH:mm:ss:SS"));
                            } else {
                                sb.append(m216clone.getTime());
                            }
                            q("bigshiftstatistics", sb.toString());
                            sb.delete(0, sb.length());
                        }
                    }
                }
                i = m216clone;
            }
        } catch (Throwable unused) {
        }
    }

    public static void p(String str, int i2) {
        r(str, String.valueOf(i2), a(i2));
    }

    public static void q(String str, String str2) {
        try {
            an.l(j1.q(), str2, str);
        } catch (Throwable th) {
            j1.h(th, "ReportUtil", "reportLog");
        }
    }

    public static void r(String str, String str2, String str3) {
        try {
            an.i(j1.q(), "/mobile/binary", str3, str, str2);
        } catch (Throwable unused) {
        }
    }

    public static void s(String str, Throwable th) {
        try {
            if (th instanceof k) {
                an.h(j1.q(), str, (k) th);
            }
        } catch (Throwable unused) {
        }
    }

    private static boolean t(AMapLocation aMapLocation) {
        return m1.q(aMapLocation) ? !j1.i(aMapLocation.getLatitude(), aMapLocation.getLongitude()) : "http://abroad.apilocate.amap.com/mobile/binary".equals(j1.c);
    }

    public static void v(Context context, long j2, boolean z) {
        if (context != null) {
            try {
                if (i1.e()) {
                    g(context, j2, z, "O024");
                }
            } catch (Throwable th) {
                j1.h(th, "ReportUtil", "reportCoarseLocUseTime");
            }
        }
    }

    private static void z(Context context) {
        try {
            JSONArray jSONArray = h;
            if (jSONArray == null || jSONArray.length() <= 0) {
                return;
            }
            bq.d(new c0(context, j1.q(), h.toString()), context);
            h = null;
        } catch (Throwable th) {
            j1.h(th, "ReportUtil", "writeOfflineLocLog");
        }
    }

    public final void d(Context context, int i2) {
        try {
            int i3 = this.b;
            if (i3 == i2) {
                return;
            }
            if (i3 != -1 && i3 != i2) {
                this.a.append(this.b, Long.valueOf((m1.B() - this.c) + this.a.get(this.b, 0L).longValue()));
            }
            this.c = m1.B() - a83.b(context, "pref1", this.d[i2], 0L);
            this.b = i2;
        } catch (Throwable th) {
            j1.h(th, "ReportUtil", "setLocationType");
        }
    }

    public final void j(Context context, AMapLocationClientOption aMapLocationClientOption) {
        try {
            int i2 = a.a[aMapLocationClientOption.getLocationMode().ordinal()];
            int i3 = 3;
            if (i2 == 1) {
                i3 = 4;
            } else if (i2 == 2) {
                i3 = 5;
            } else if (i2 != 3) {
                i3 = -1;
            }
            int i4 = this.e;
            if (i4 == i3) {
                return;
            }
            if (i4 != -1 && i4 != i3) {
                this.a.append(this.e, Long.valueOf((m1.B() - this.f) + this.a.get(this.e, 0L).longValue()));
            }
            this.f = m1.B() - a83.b(context, "pref1", this.d[i3], 0L);
            this.e = i3;
        } catch (Throwable th) {
            j1.h(th, "ReportUtil", "setLocationMode");
        }
    }

    public final void u(Context context) {
        try {
            long B = m1.B() - this.c;
            int i2 = this.b;
            if (i2 != -1) {
                this.a.append(this.b, Long.valueOf(B + this.a.get(i2, 0L).longValue()));
            }
            long B2 = m1.B() - this.f;
            int i3 = this.e;
            if (i3 != -1) {
                this.a.append(this.e, Long.valueOf(B2 + this.a.get(i3, 0L).longValue()));
            }
            SharedPreferences.Editor c = a83.c(context, "pref1");
            for (int i4 = 0; i4 < this.d.length; i4++) {
                long longValue = this.a.get(i4, 0L).longValue();
                if (longValue > 0 && longValue > a83.b(context, "pref1", this.d[i4], 0L)) {
                    a83.i(c, this.d[i4], longValue);
                }
            }
            a83.f(c);
        } catch (Throwable th) {
            j1.h(th, "ReportUtil", "saveLocationTypeAndMode");
        }
    }

    public final int w(Context context) {
        try {
            long b = a83.b(context, "pref1", this.d[2], 0L);
            long b2 = a83.b(context, "pref1", this.d[0], 0L);
            long b3 = a83.b(context, "pref1", this.d[1], 0L);
            if (b == 0 && b2 == 0 && b3 == 0) {
                return -1;
            }
            long j2 = b2 - b;
            long j3 = b3 - b;
            return b > j2 ? b > j3 ? 2 : 1 : j2 > j3 ? 0 : 1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public final int x(Context context) {
        try {
            long b = a83.b(context, "pref1", this.d[3], 0L);
            long b2 = a83.b(context, "pref1", this.d[4], 0L);
            long b3 = a83.b(context, "pref1", this.d[5], 0L);
            if (b == 0 && b2 == 0 && b3 == 0) {
                return -1;
            }
            return b > b2 ? b > b3 ? 3 : 5 : b2 > b3 ? 4 : 5;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public final void y(Context context) {
        try {
            SharedPreferences.Editor c = a83.c(context, "pref1");
            int i2 = 0;
            while (true) {
                String[] strArr = this.d;
                if (i2 >= strArr.length) {
                    a83.f(c);
                    return;
                } else {
                    a83.i(c, strArr[i2], 0L);
                    i2++;
                }
            }
        } catch (Throwable unused) {
        }
    }
}
