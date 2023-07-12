package tb;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Pair;
import anet.channel.statist.RequestStatistic;
import anet.channel.strategy.dispatch.HttpDispatcher;
import anet.channel.util.ALog;
import anetwork.channel.config.IRemoteConfig;
import anetwork.channel.http.NetworkSdkSetting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class rj1 {
    private static volatile IRemoteConfig L = null;
    public static final String MULTI_PATH_TRIGGER_TIME = "MULTI_PATH_TRIGGER_TIME";
    public static final String MULTI_PATH_WHITE_AB = "MULTI_PATH_WHITE_AB";
    public static final String MULTI_PATH_WHITE_BIZ = "MULTI_PATH_WHITE_BIZ";
    public static final String MULTI_PATH_WHITE_URL = "MULTI_PATH_WHITE_URL";
    public static final String NETWORK_MP_QUIC_ENABLE = "NETWORK_MP_QUIC_ENABLE";
    public static final String SERVICE_OPTIMIZE = "SERVICE_OPTIMIZE";
    public static final String SESSION_ASYNC_OPTIMIZE = "SESSION_ASYNC_OPTIMIZE";
    private static volatile boolean a = true;
    private static volatile boolean b = true;
    private static volatile boolean c = true;
    private static volatile int d = 5;
    private static volatile boolean e = true;
    private static volatile boolean f = true;
    private static volatile boolean g;
    private static volatile long h;
    private static volatile boolean i;
    private static volatile ConcurrentHashMap<String, List<String>> j;
    private static volatile CopyOnWriteArrayList<String> k;
    private static final List<String> l = new ArrayList();
    private static volatile int m = 10000;
    private static volatile boolean n = true;
    private static volatile boolean o = false;
    private static volatile int p = 60000;
    private static volatile CopyOnWriteArrayList<String> q = null;
    private static volatile CopyOnWriteArrayList<String> r = null;
    private static volatile ConcurrentHashMap<String, List<String>> s = null;
    private static volatile ConcurrentHashMap<String, List<String>> t = null;
    private static volatile boolean u = true;
    private static volatile boolean v = false;
    private static volatile boolean w = false;
    private static volatile boolean x = false;
    private static volatile boolean y = true;
    private static volatile boolean z = true;
    private static volatile boolean A = false;
    private static volatile long B = 1500;
    private static volatile CopyOnWriteArrayList<String> C = null;
    private static volatile ConcurrentHashMap<String, List<String>> D = null;
    private static volatile CopyOnWriteArrayList<Pair<String, String>> E = null;
    private static volatile ConcurrentHashMap<String, List<Pair<String, String>>> F = null;
    private static volatile CopyOnWriteArrayList<String> G = null;
    private static volatile boolean H = true;
    private static volatile boolean I = false;
    private static volatile boolean J = true;
    private static volatile boolean K = false;

    public static boolean A() {
        return c;
    }

    public static boolean B() {
        return u;
    }

    public static boolean C(RequestStatistic requestStatistic) {
        CopyOnWriteArrayList<String> copyOnWriteArrayList;
        if (requestStatistic == null || (copyOnWriteArrayList = q) == null || TextUtils.isEmpty(requestStatistic.host)) {
            return false;
        }
        Iterator<String> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            if (requestStatistic.host.equalsIgnoreCase(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean D() {
        return n;
    }

    public static boolean E() {
        return a;
    }

    public static boolean F() {
        return b;
    }

    public static boolean G(o01 o01Var) {
        ConcurrentHashMap<String, List<String>> concurrentHashMap;
        List<String> list;
        if (o01Var == null || (concurrentHashMap = s) == null || (list = concurrentHashMap.get(o01Var.d())) == null) {
            return false;
        }
        if (list == l) {
            return true;
        }
        for (String str : list) {
            if (o01Var.h().startsWith(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean H(o01 o01Var) {
        ConcurrentHashMap<String, List<String>> concurrentHashMap;
        List<String> list;
        if (o01Var == null || (concurrentHashMap = j) == null || (list = concurrentHashMap.get(o01Var.d())) == null) {
            return false;
        }
        if (list == l) {
            return true;
        }
        for (String str : list) {
            if (o01Var.h().startsWith(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean I() {
        return x;
    }

    public static void J(boolean z2) {
        A = z2;
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(NetworkSdkSetting.getContext()).edit();
        edit.putBoolean("ALLOW_ADD_AB_HEADER_IN_MTOP", A);
        edit.apply();
    }

    public static void K(String str) {
        if (ALog.g(2)) {
            ALog.f("anet.NetworkConfigCenter", "updateWhiteUrlList", null, "White List", str);
        }
        if (TextUtils.isEmpty(str)) {
            t = null;
            return;
        }
        ConcurrentHashMap<String, List<String>> concurrentHashMap = new ConcurrentHashMap<>();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = jSONObject.get(next);
                try {
                    if (obj instanceof JSONArray) {
                        JSONArray jSONArray = (JSONArray) obj;
                        int length = jSONArray.length();
                        ArrayList arrayList = new ArrayList(length);
                        for (int i2 = 0; i2 < length; i2++) {
                            Object obj2 = jSONArray.get(i2);
                            if (obj2 instanceof String) {
                                arrayList.add((String) obj2);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            concurrentHashMap.put(next, arrayList);
                        }
                    } else if (jn1.MUL.equals(obj)) {
                        concurrentHashMap.put(next, l);
                    }
                } catch (JSONException unused) {
                }
            }
        } catch (JSONException e2) {
            ALog.d("anet.NetworkConfigCenter", "parse jsonObject failed", null, e2, new Object[0]);
        }
        t = concurrentHashMap;
    }

    public static void L(boolean z2) {
        y = z2;
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(NetworkSdkSetting.getContext()).edit();
        edit.putBoolean("ALLOW_SPDY_WHEN_BIND_SERVICE_FAILED", y);
        edit.apply();
    }

    public static void M(String str) {
        if (hu0.j()) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                ArrayList arrayList = new ArrayList(length);
                for (int i2 = 0; i2 < length; i2++) {
                    String string = jSONArray.getString(i2);
                    if (lw2.a(string)) {
                        arrayList.add(string);
                    }
                }
                HttpDispatcher.f().a(arrayList);
            } catch (JSONException e2) {
                ALog.d("anet.NetworkConfigCenter", "parse hosts failed", null, e2, new Object[0]);
            }
        }
    }

    public static void N(int i2) {
        p = i2;
    }

    public static void O(boolean z2) {
        i = z2;
    }

    public static void P(boolean z2) {
        v = z2;
    }

    public static void Q(long j2) {
        if (j2 != h) {
            ALog.f("anet.NetworkConfigCenter", "set cache flag", null, "old", Long.valueOf(h), "new", Long.valueOf(j2));
            h = j2;
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(NetworkSdkSetting.getContext()).edit();
            edit.putLong("Cache.Flag", h);
            edit.apply();
            ze.b();
        }
    }

    public static void R(boolean z2) {
        w = z2;
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(NetworkSdkSetting.getContext()).edit();
        edit.putBoolean("CHANNEL_LOCAL_INSTANCE_ENABLE", w);
        edit.apply();
    }

    public static void S(boolean z2) {
        K = z2;
    }

    public static void T(String str) {
        if (ALog.g(2)) {
            ALog.f("anet.NetworkConfigCenter", "setDegradeRequestList", null, "Degrade List", str);
        }
        if (TextUtils.isEmpty(str)) {
            s = null;
            return;
        }
        ConcurrentHashMap<String, List<String>> concurrentHashMap = new ConcurrentHashMap<>();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = jSONObject.get(next);
                try {
                    if (jn1.MUL.equals(obj)) {
                        concurrentHashMap.put(next, l);
                    } else if (obj instanceof JSONArray) {
                        JSONArray jSONArray = (JSONArray) obj;
                        int length = jSONArray.length();
                        ArrayList arrayList = new ArrayList(length);
                        for (int i2 = 0; i2 < length; i2++) {
                            Object obj2 = jSONArray.get(i2);
                            if (obj2 instanceof String) {
                                arrayList.add((String) obj2);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            concurrentHashMap.put(next, arrayList);
                        }
                    }
                } catch (JSONException unused) {
                }
            }
        } catch (JSONException e2) {
            ALog.d("anet.NetworkConfigCenter", "parse jsonObject failed", null, e2, new Object[0]);
        }
        s = concurrentHashMap;
    }

    public static void U(boolean z2) {
        o = z2;
    }

    public static void V(boolean z2) {
        f = z2;
    }

    public static void W(boolean z2) {
        z = z2;
    }

    public static void X(String str) {
        if (ALog.g(2)) {
            ALog.f("anet.NetworkConfigCenter", "setMonitorRequestBizList", null, "White List", str);
        }
        if (TextUtils.isEmpty(str)) {
            r = null;
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            for (int i2 = 0; i2 < length; i2++) {
                String string = jSONArray.getString(i2);
                if (!string.isEmpty()) {
                    copyOnWriteArrayList.add(string);
                }
            }
            r = copyOnWriteArrayList;
        } catch (JSONException e2) {
            ALog.d("anet.NetworkConfigCenter", "parse bizId failed", null, e2, new Object[0]);
        }
    }

    public static void Y(String str) {
        if (TextUtils.isEmpty(str)) {
            q = null;
        }
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("host");
            int length = jSONArray.length();
            CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            for (int i2 = 0; i2 < length; i2++) {
                String string = jSONArray.getString(i2);
                if (lw2.a(string)) {
                    copyOnWriteArrayList.add(string);
                }
            }
            q = copyOnWriteArrayList;
        } catch (JSONException e2) {
            ALog.d("anet.NetworkConfigCenter", "parse hosts failed", null, e2, new Object[0]);
        }
    }

    public static void Z(boolean z2) {
        I = z2;
    }

    public static int a() {
        return p;
    }

    public static void a0(String str) {
        if (TextUtils.isEmpty(str)) {
            E = null;
            F = null;
            G = null;
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            ConcurrentHashMap<String, List<Pair<String, String>>> concurrentHashMap = new ConcurrentHashMap<>();
            CopyOnWriteArrayList<Pair<String, String>> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            CopyOnWriteArrayList<String> copyOnWriteArrayList2 = new CopyOnWriteArrayList<>();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                String string = jSONObject.getString(tx0.VALUE_MODEL_DEFAULT);
                if (!TextUtils.isEmpty(string)) {
                    Context c2 = hu0.c();
                    Boolean j2 = anet.channel.util.c.j(c2, "network_multi_path_" + string);
                    if (j2 != null && j2.booleanValue()) {
                        copyOnWriteArrayList2.add(string);
                        JSONObject optJSONObject = jSONObject.optJSONObject("url");
                        if (optJSONObject != null) {
                            Iterator<String> keys = optJSONObject.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                Object obj = optJSONObject.get(next);
                                if (obj instanceof JSONArray) {
                                    JSONArray jSONArray2 = (JSONArray) obj;
                                    int length = jSONArray2.length();
                                    ArrayList arrayList = new ArrayList(length);
                                    for (int i3 = 0; i3 < length; i3++) {
                                        arrayList.add(Pair.create(jSONArray2.getString(i3), string));
                                    }
                                    if (!arrayList.isEmpty()) {
                                        concurrentHashMap.put(next, arrayList);
                                    }
                                }
                            }
                        }
                        JSONArray optJSONArray = jSONObject.optJSONArray(com.alipay.sdk.m.k.b.l);
                        if (optJSONArray != null) {
                            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                                String string2 = optJSONArray.getString(i4);
                                if (!string2.isEmpty()) {
                                    copyOnWriteArrayList.add(Pair.create(string2, string));
                                }
                            }
                        }
                    }
                }
            }
            E = copyOnWriteArrayList;
            F = concurrentHashMap;
            G = copyOnWriteArrayList2;
        } catch (Exception e2) {
            ALog.d("anet.NetworkConfigCenter", "parse failed", null, e2, new Object[0]);
        }
    }

    public static long b() {
        return B;
    }

    public static void b0(long j2) {
        B = j2;
    }

    public static int c() {
        return m;
    }

    public static void c0(String str) {
        if (ALog.g(2)) {
            ALog.f("anet.NetworkConfigCenter", "setMultiPathWhiteBiz", null, "White List", str);
        }
        if (TextUtils.isEmpty(str)) {
            C = null;
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            for (int i2 = 0; i2 < length; i2++) {
                String string = jSONArray.getString(i2);
                if (!string.isEmpty()) {
                    copyOnWriteArrayList.add(string);
                }
            }
            C = copyOnWriteArrayList;
        } catch (JSONException e2) {
            ALog.d("anet.NetworkConfigCenter", "parse biz failed", null, e2, new Object[0]);
        }
    }

    public static int d() {
        return d;
    }

    public static void d0(String str) {
        if (ALog.g(2)) {
            ALog.f("anet.NetworkConfigCenter", "setMultiPathWhiteURL", null, "White List", str);
        }
        if (TextUtils.isEmpty(str)) {
            D = null;
            return;
        }
        ConcurrentHashMap<String, List<String>> concurrentHashMap = new ConcurrentHashMap<>();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = jSONObject.get(next);
                try {
                    if (jn1.MUL.equals(obj)) {
                        concurrentHashMap.put(next, l);
                    } else if (obj instanceof JSONArray) {
                        JSONArray jSONArray = (JSONArray) obj;
                        int length = jSONArray.length();
                        ArrayList arrayList = new ArrayList(length);
                        for (int i2 = 0; i2 < length; i2++) {
                            Object obj2 = jSONArray.get(i2);
                            if (obj2 instanceof String) {
                                arrayList.add((String) obj2);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            concurrentHashMap.put(next, arrayList);
                        }
                    }
                } catch (JSONException unused) {
                }
            }
        } catch (JSONException e2) {
            ALog.d("anet.NetworkConfigCenter", "parse jsonObject failed", null, e2, new Object[0]);
        }
        D = concurrentHashMap;
    }

    public static void e() {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(NetworkSdkSetting.getContext());
        h = defaultSharedPreferences.getLong("Cache.Flag", 0L);
        w = defaultSharedPreferences.getBoolean("CHANNEL_LOCAL_INSTANCE_ENABLE", false);
        x = defaultSharedPreferences.getBoolean("WIDGET_LOCAL_INSTANCE_ENABLE", false);
        y = defaultSharedPreferences.getBoolean("ALLOW_SPDY_WHEN_BIND_SERVICE_FAILED", true);
        A = defaultSharedPreferences.getBoolean("ALLOW_ADD_AB_HEADER_IN_MTOP", false);
        H = defaultSharedPreferences.getBoolean("MULTI_PATH_ENABLE", true);
        J = defaultSharedPreferences.getBoolean("NETWORK_DIAGNOSIS_ENABLE", true);
        c0(defaultSharedPreferences.getString(MULTI_PATH_WHITE_BIZ, ""));
        d0(defaultSharedPreferences.getString(MULTI_PATH_WHITE_URL, ""));
        a0(defaultSharedPreferences.getString(MULTI_PATH_WHITE_AB, ""));
        B = defaultSharedPreferences.getLong(MULTI_PATH_TRIGGER_TIME, 1500L);
        defaultSharedPreferences.getBoolean(NETWORK_MP_QUIC_ENABLE, false);
    }

    public static void e0(boolean z2) {
        J = z2;
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(NetworkSdkSetting.getContext()).edit();
        edit.putBoolean("NETWORK_DIAGNOSIS_ENABLE", J);
        edit.apply();
    }

    public static boolean f(o01 o01Var) {
        List<String> list;
        ConcurrentHashMap<String, List<String>> concurrentHashMap = t;
        if (concurrentHashMap != null && concurrentHashMap.size() > 0 && (list = concurrentHashMap.get(o01Var.d())) != null && list.size() > 0) {
            if (list == l) {
                return true;
            }
            for (String str : list) {
                if (o01Var.h().startsWith(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void f0(IRemoteConfig iRemoteConfig) {
        if (L != null) {
            L.unRegister();
        }
        if (iRemoteConfig != null) {
            iRemoteConfig.register();
        }
        L = iRemoteConfig;
    }

    public static boolean g() {
        return e && g;
    }

    public static void g0(boolean z2) {
        c = z2;
    }

    public static boolean h() {
        return y;
    }

    public static void h0(boolean z2) {
        u = z2;
    }

    public static boolean i() {
        return i;
    }

    public static void i0(int i2) {
        m = i2;
    }

    public static boolean j() {
        return v;
    }

    public static void j0(boolean z2) {
        n = z2;
    }

    public static boolean k(String str) {
        CopyOnWriteArrayList<String> copyOnWriteArrayList;
        if (TextUtils.isEmpty(str) || (copyOnWriteArrayList = r) == null) {
            return false;
        }
        Iterator<String> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            if (str.equalsIgnoreCase(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static void k0(boolean z2) {
        ALog.f("anet.NetworkConfigCenter", "[setSSLEnabled]", null, "enable", Boolean.valueOf(z2));
        a = z2;
    }

    public static boolean l(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        CopyOnWriteArrayList<String> copyOnWriteArrayList = k;
        if (k == null) {
            return false;
        }
        Iterator<String> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            if (str.equalsIgnoreCase(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static void l0(boolean z2) {
        ALog.f("anet.NetworkConfigCenter", "[setSpdyEnabled]", null, "enable", Boolean.valueOf(z2));
        b = z2;
    }

    public static boolean m() {
        return w;
    }

    public static void m0(boolean z2) {
        x = z2;
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(NetworkSdkSetting.getContext()).edit();
        edit.putBoolean("WIDGET_LOCAL_INSTANCE_ENABLE", x);
        edit.apply();
    }

    public static boolean n() {
        return K;
    }

    public static void n0(String str) {
        if (ALog.g(2)) {
            ALog.f("anet.NetworkConfigCenter", "updateRequestWhiteList", null, "White List", str);
        }
        if (TextUtils.isEmpty(str)) {
            k = null;
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            for (int i2 = 0; i2 < length; i2++) {
                String string = jSONArray.getString(i2);
                if (!string.isEmpty()) {
                    copyOnWriteArrayList.add(string);
                }
            }
            k = copyOnWriteArrayList;
        } catch (JSONException e2) {
            ALog.d("anet.NetworkConfigCenter", "parse bizId failed", null, e2, new Object[0]);
        }
    }

    public static boolean o() {
        return o;
    }

    public static void o0(String str) {
        if (ALog.g(2)) {
            ALog.f("anet.NetworkConfigCenter", "updateWhiteUrlList", null, "White List", str);
        }
        if (TextUtils.isEmpty(str)) {
            j = null;
            return;
        }
        ConcurrentHashMap<String, List<String>> concurrentHashMap = new ConcurrentHashMap<>();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = jSONObject.get(next);
                try {
                    if (jn1.MUL.equals(obj)) {
                        concurrentHashMap.put(next, l);
                    } else if (obj instanceof JSONArray) {
                        JSONArray jSONArray = (JSONArray) obj;
                        int length = jSONArray.length();
                        ArrayList arrayList = new ArrayList(length);
                        for (int i2 = 0; i2 < length; i2++) {
                            Object obj2 = jSONArray.get(i2);
                            if (obj2 instanceof String) {
                                arrayList.add((String) obj2);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            concurrentHashMap.put(next, arrayList);
                        }
                    }
                } catch (JSONException unused) {
                }
            }
        } catch (JSONException e2) {
            ALog.d("anet.NetworkConfigCenter", "parse jsonObject failed", null, e2, new Object[0]);
        }
        j = concurrentHashMap;
    }

    public static boolean p() {
        return f;
    }

    public static boolean q() {
        return e;
    }

    public static boolean r() {
        return z;
    }

    public static boolean s() {
        return I;
    }

    public static boolean t(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return v(str) || u(str);
    }

    private static boolean u(String str) {
        CopyOnWriteArrayList<Pair<String, String>> copyOnWriteArrayList = E;
        if (copyOnWriteArrayList == null) {
            return false;
        }
        Iterator<Pair<String, String>> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            Pair<String, String> next = it.next();
            if (str.equalsIgnoreCase((String) next.first)) {
                return G.contains(next.second);
            }
        }
        return false;
    }

    private static boolean v(String str) {
        CopyOnWriteArrayList<String> copyOnWriteArrayList = C;
        if (copyOnWriteArrayList == null) {
            return false;
        }
        Iterator<String> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            if (str.equalsIgnoreCase(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean w() {
        return H;
    }

    public static boolean x(o01 o01Var) {
        if (o01Var == null) {
            return false;
        }
        return z(o01Var) || y(o01Var);
    }

    private static boolean y(o01 o01Var) {
        List<Pair<String, String>> list;
        ConcurrentHashMap<String, List<Pair<String, String>>> concurrentHashMap = F;
        if (concurrentHashMap == null || (list = concurrentHashMap.get(o01Var.d())) == null) {
            return false;
        }
        for (Pair<String, String> pair : list) {
            if (o01Var.h().startsWith((String) pair.first)) {
                return G.contains(pair.second);
            }
        }
        return false;
    }

    private static boolean z(o01 o01Var) {
        List<String> list;
        ConcurrentHashMap<String, List<String>> concurrentHashMap = D;
        if (concurrentHashMap == null || (list = concurrentHashMap.get(o01Var.d())) == null) {
            return false;
        }
        if (list == l) {
            return true;
        }
        for (String str : list) {
            if (o01Var.h().startsWith(str)) {
                return true;
            }
        }
        return false;
    }
}
