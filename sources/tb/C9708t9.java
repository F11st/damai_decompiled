package tb;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import anet.channel.C0162c;
import anet.channel.strategy.C0227d;
import anet.channel.strategy.ConnProtocol;
import anet.channel.util.ALog;
import anet.channel.util.C0241c;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Taobao */
/* renamed from: tb.t9 */
/* loaded from: classes.dex */
public class C9708t9 {
    private static CopyOnWriteArrayList<String> A = null;
    public static final String AMDC_VERSION_DEGRADED_KEY = "network_amdc_version_degraded";
    private static volatile CopyOnWriteArrayList<String> B = null;
    private static volatile boolean C = false;
    private static volatile CopyOnWriteArrayList<String> D = null;
    public static final String DETECT_CENTER_ENABLE = "DETECT_CENTER_ENABLE";
    private static volatile boolean E = true;
    private static volatile boolean F = true;
    private static volatile boolean G = true;
    private static CopyOnWriteArrayList<String> H = null;
    public static final String HTTP3_BLACK_LIST_KEY = "network_http3_black_list";
    public static final String HTTP3_ENABLE = "HTTP3_ENABLE";
    public static final String HTTP_DETECT_ENABLE = "HTTP_DETECT_ENABLE";
    public static final String IPV6_DETECT_KEY = "network_ipv6_detect";
    public static final String IPV6_RATE_OPTIMIZE_EANBLE = "IPV6_RATE_OPTIMIZE_EANBLE";
    public static final String IPV6_RECTIFICATION_KEY = "network_ipv6_rectification";
    public static final String MULTI_PATH_HARMONY_WHITE_LIST = "multi_path_harmony_white_list";
    public static final String MULTI_PATH_MONITOR_KEY = "multi_path_monitor";
    public static final String NEXT_LAUNCH_FORBID = "NEXT_LAUNCH_FORBID";
    public static final String STRATEGY_UPDATE_KEY = "network_strategy_update";
    public static final String TICKET_STORE_KEY = "network_ticket_store";
    private static volatile boolean a = false;
    private static volatile boolean b = true;
    private static volatile boolean c = true;
    private static volatile boolean d = true;
    private static volatile boolean e = true;
    private static volatile long f = 43200000;
    private static volatile boolean g = true;
    private static volatile boolean h = false;
    private static volatile boolean i = true;
    private static volatile boolean j = true;
    private static volatile boolean k = false;
    private static volatile boolean l = true;
    private static boolean m = true;
    private static boolean n = false;
    private static volatile boolean o = false;
    private static volatile boolean p = false;
    private static volatile boolean q = false;
    private static volatile boolean r = false;
    private static volatile boolean s = false;
    private static volatile boolean t = false;
    private static volatile int u = 10000;
    private static volatile boolean v = false;
    private static volatile int w = -1;
    private static volatile boolean x = true;
    private static volatile boolean y = true;
    private static volatile boolean z = true;
    private static AtomicBoolean I = new AtomicBoolean(false);
    private static volatile boolean J = true;
    private static volatile boolean K = true;
    private static volatile boolean L = false;
    private static volatile boolean M = false;
    private static volatile boolean N = false;
    private static volatile boolean O = true;
    private static volatile CopyOnWriteArrayList<String> P = null;
    private static volatile long Q = 250;

    public static boolean A() {
        return h;
    }

    public static void A0(boolean z2) {
        z = z2;
    }

    public static boolean B() {
        return J;
    }

    public static void B0(boolean z2) {
        o = z2;
    }

    public static boolean C() {
        return g;
    }

    public static void C0(boolean z2) {
        M = z2;
    }

    public static boolean D() {
        return j;
    }

    public static void D0(boolean z2) {
        d = z2;
    }

    public static boolean E() {
        return i;
    }

    public static void E0(int i2) {
        if (i2 < 0) {
            return;
        }
        w = i2;
    }

    public static boolean F() {
        return l;
    }

    public static boolean G() {
        return r;
    }

    public static boolean H() {
        return q;
    }

    public static boolean I() {
        return G;
    }

    public static boolean J() {
        return p;
    }

    public static boolean K() {
        return K;
    }

    public static boolean L() {
        return y;
    }

    public static boolean M() {
        return z;
    }

    public static boolean N() {
        return N;
    }

    public static boolean O() {
        return o;
    }

    public static boolean P() {
        return M;
    }

    public static boolean Q() {
        return d;
    }

    public static void R(String str) {
        if (hu0.j() && !TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    String string = jSONObject.getString("host");
                    if (!lw2.a(string)) {
                        return;
                    }
                    C0227d.b().c(string, ConnProtocol.valueOf(jSONObject.getString("protocol"), jSONObject.getString("rtt"), jSONObject.getString("publicKey")));
                    if (jSONObject.getBoolean("isKeepAlive")) {
                        C0162c.k().C(xa2.a(string, true, false, null, null, null));
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void S(boolean z2) {
        s = z2;
    }

    public static void T(boolean z2) {
        C = z2;
    }

    public static void U(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        if (i2 > 600000) {
            i2 = 600000;
        }
        u = i2;
    }

    public static void V(boolean z2) {
        a = z2;
    }

    public static void W(boolean z2) {
        t = z2;
    }

    public static void X(long j2) {
        Q = j2;
    }

    public static void Y(boolean z2) {
        O = z2;
    }

    public static void Z(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            JSONArray jSONArray = new JSONArray(str);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                String string = jSONArray.getString(i2);
                if (!TextUtils.isEmpty(string)) {
                    copyOnWriteArrayList.add(string);
                }
            }
            P = copyOnWriteArrayList;
        } catch (Exception e2) {
            ALog.d("awcn.AwcnConfig", "[setComplexConnectWhiteList] error", null, e2, new Object[0]);
        }
    }

    public static int a() {
        return u;
    }

    public static void a0(boolean z2) {
        x = z2;
    }

    public static long b() {
        return Q;
    }

    public static void b0(boolean z2) {
        F = z2;
    }

    public static CopyOnWriteArrayList<String> c() {
        if (B == null) {
            B = new CopyOnWriteArrayList<>();
        }
        return B;
    }

    public static void c0(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            JSONArray jSONArray = new JSONArray(str);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                String string = jSONArray.getString(i2);
                if (!TextUtils.isEmpty(string)) {
                    copyOnWriteArrayList.add(string);
                }
            }
            B = copyOnWriteArrayList;
        } catch (Exception e2) {
            ALog.d("awcn.AwcnConfig", "[setExceptionDetectUrl] error", null, e2, new Object[0]);
        }
    }

    public static long d() {
        return f;
    }

    public static void d0(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            JSONArray jSONArray = new JSONArray(str);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                String string = jSONArray.getString(i2);
                if (!TextUtils.isEmpty(string)) {
                    copyOnWriteArrayList.add(string);
                }
            }
            H = copyOnWriteArrayList;
        } catch (Exception e2) {
            ALog.d("awcn.AwcnConfig", "[setHarmonyWhiteList] error", null, e2, new Object[0]);
        }
    }

    public static int e() {
        return w;
    }

    public static void e0(boolean z2) {
        c = z2;
    }

    public static void f(Context context) {
        if (I.compareAndSet(false, true)) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            G = defaultSharedPreferences.getBoolean(MULTI_PATH_MONITOR_KEY, true);
            d0(defaultSharedPreferences.getString(MULTI_PATH_HARMONY_WHITE_LIST, null));
            C = defaultSharedPreferences.getBoolean(AMDC_VERSION_DEGRADED_KEY, false);
            l = defaultSharedPreferences.getBoolean(IPV6_RECTIFICATION_KEY, true);
            Boolean j2 = C0241c.j(context, STRATEGY_UPDATE_KEY);
            if (j2 != null) {
                N = j2.booleanValue();
            }
            ALog.e("awcn.AwcnConfig", "isStrategyUpgradeEnable = " + N, null, new Object[0]);
        }
    }

    public static void f0(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            JSONArray jSONArray = new JSONArray(str);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                String string = jSONArray.getString(i2);
                if (!TextUtils.isEmpty(string)) {
                    copyOnWriteArrayList.add(string);
                }
            }
            A = copyOnWriteArrayList;
        } catch (Exception e2) {
            ALog.d("awcn.AwcnConfig", "[setHttp3BlackList] error", null, e2, new Object[0]);
        }
    }

    public static boolean g() {
        return s;
    }

    public static void g0(boolean z2) {
        v = z2;
        ALog.e("awcn.AwcnConfig", "[setHttp3Enable]", null, "enable", Boolean.valueOf(z2));
    }

    public static boolean h() {
        return C;
    }

    public static void h0(boolean z2) {
        E = z2;
    }

    public static boolean i() {
        return a;
    }

    public static void i0(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            JSONArray jSONArray = new JSONArray(str);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                String string = jSONArray.getString(i2);
                if (!TextUtils.isEmpty(string)) {
                    copyOnWriteArrayList.add(string);
                }
            }
            D = copyOnWriteArrayList;
        } catch (Exception e2) {
            ALog.d("awcn.AwcnConfig", "[setHttpDetectWhiteList] error", null, e2, new Object[0]);
        }
    }

    public static boolean j(String str) {
        if (P == null || TextUtils.isEmpty(str)) {
            return false;
        }
        if (P.contains(jn1.MUL)) {
            return true;
        }
        return P.contains(str);
    }

    public static void j0(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            JSONArray jSONArray = new JSONArray(str);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                String string = jSONArray.getString(i2);
                if (!TextUtils.isEmpty(string)) {
                    copyOnWriteArrayList.add(string);
                }
            }
        } catch (Exception e2) {
            ALog.d("awcn.AwcnConfig", "[setHttpDnsNotifyWhiteList] error", null, e2, new Object[0]);
        }
    }

    public static boolean k() {
        return k;
    }

    public static void k0(boolean z2) {
        b = z2;
    }

    public static boolean l(String str) {
        if (D == null || TextUtils.isEmpty(str)) {
            return false;
        }
        return D.contains(str);
    }

    public static void l0(boolean z2) {
        e = z2;
    }

    public static boolean m() {
        return m;
    }

    public static void m0(boolean z2) {
        L = z2;
    }

    public static boolean n() {
        return n;
    }

    public static void n0(boolean z2) {
        h = z2;
    }

    public static boolean o() {
        return t;
    }

    public static void o0(long j2) {
        f = j2;
    }

    public static boolean p() {
        return O;
    }

    public static void p0(boolean z2) {
        J = z2;
    }

    public static boolean q() {
        return x;
    }

    public static void q0(boolean z2) {
        g = z2;
    }

    public static boolean r() {
        return F;
    }

    public static void r0(boolean z2) {
        j = z2;
    }

    public static boolean s() {
        return c;
    }

    public static void s0(boolean z2) {
        i = z2;
        ALog.e("awcn.AwcnConfig", "[setIpv6RateOptimizeEnable]", null, "status", Boolean.valueOf(z2));
    }

    public static boolean t(String str) {
        CopyOnWriteArrayList<String> copyOnWriteArrayList;
        if (TextUtils.isEmpty(str) || (copyOnWriteArrayList = A) == null) {
            return false;
        }
        return copyOnWriteArrayList.contains(str);
    }

    public static void t0(boolean z2) {
        l = z2;
    }

    public static boolean u() {
        return v;
    }

    public static void u0(boolean z2) {
        k = z2;
    }

    public static boolean v() {
        return E;
    }

    public static void v0(boolean z2) {
        r = z2;
    }

    public static boolean w() {
        return b;
    }

    public static void w0(boolean z2) {
        q = z2;
    }

    public static boolean x() {
        return e;
    }

    public static void x0(boolean z2) {
        G = z2;
    }

    public static boolean y(String str) {
        CopyOnWriteArrayList<String> copyOnWriteArrayList = H;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            return false;
        }
        return H.contains(str) || H.contains(jn1.MUL);
    }

    public static void y0(boolean z2) {
        p = z2;
    }

    public static boolean z() {
        return L;
    }

    public static void z0(boolean z2) {
        y = z2;
    }
}
