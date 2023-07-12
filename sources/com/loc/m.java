package com.loc;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.loc.bj;
import com.loc.bl;
import com.taobao.update.datasource.mtop.MtopUpdater;
import com.taobao.weex.annotation.JSMethod;
import com.youku.live.livesdk.model.mtop.LiveFullInfo;
import com.youku.live.livesdk.preloader.Preloader;
import io.flutter.stat.StatServices;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.lang3.time.DateUtils;
import org.json.JSONObject;
import tb.b43;
import tb.s43;
import tb.w33;
import tb.y33;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class m {
    private static volatile boolean C = false;
    public static int a = -1;
    public static String b = "";
    private static String c = "6";
    private static String d = "4";
    private static String e = "9";
    private static String f = "8";
    public static Context g = null;
    private static volatile boolean h = true;
    private static Vector<e> i = new Vector<>();
    private static Map<String, Integer> j = new HashMap();
    private static String k = null;
    private static long l = 0;
    public static volatile boolean m = false;
    private static volatile ConcurrentHashMap<String, Long> n = new ConcurrentHashMap<>(8);
    private static volatile ConcurrentHashMap<String, Long> o = new ConcurrentHashMap<>(8);
    private static volatile ConcurrentHashMap<String, d> p = new ConcurrentHashMap<>(8);
    private static boolean q = false;
    public static int r = 5000;
    public static boolean s = true;
    public static boolean t = false;
    private static int u = 3;
    public static boolean v = true;
    public static boolean w = false;
    private static int x = 3;
    public static boolean y = false;
    private static ConcurrentHashMap<String, Boolean> z = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, Boolean> A = new ConcurrentHashMap<>();
    private static ArrayList<bj.a> B = new ArrayList<>();
    private static Queue<bj.c> D = new LinkedList();

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface a {
        void a(b bVar);
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class b {
        public long a = 0;
        public JSONObject b;
        public a c;
        private boolean d;

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public static class a {
            public boolean a;
            public JSONObject b;
        }

        /* compiled from: Taobao */
        /* renamed from: com.loc.m$b$b  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public static class C0256b {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class c extends s43 {
        private String o;
        private Map<String, String> p;
        private String q;
        private String r;
        private String s;

        c(Context context, u1 u1Var, String str, String str2, String str3, String str4) {
            super(context, u1Var);
            this.o = str;
            this.p = null;
            this.q = str2;
            this.r = str3;
            this.s = str4;
            f(bl.c.HTTPS);
            d(bl.a.FIX);
        }

        private static String U(String str, String str2) {
            try {
                return !TextUtils.isEmpty(str2) ? Uri.parse(str).buildUpon().encodedAuthority(str2).build().toString() : str;
            } catch (Throwable unused) {
                return str;
            }
        }

        @Override // tb.s43
        public final byte[] O() {
            return null;
        }

        @Override // tb.s43
        public final byte[] P() {
            String g0 = o.g0(this.l);
            if (!TextUtils.isEmpty(g0)) {
                g0 = r1.a(new StringBuilder(g0).reverse().toString());
            }
            HashMap hashMap = new HashMap();
            hashMap.put("authkey", TextUtils.isEmpty(this.o) ? "" : this.o);
            hashMap.put("plattype", "android");
            hashMap.put("product", this.m.a());
            hashMap.put("version", this.m.e());
            hashMap.put("output", Preloader.KEY_JSON);
            StringBuilder sb = new StringBuilder();
            sb.append(Build.VERSION.SDK_INT);
            hashMap.put("androidversion", sb.toString());
            hashMap.put("deviceId", g0);
            hashMap.put("manufacture", com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMANUFACTURER());
            Map<String, String> map = this.p;
            if (map != null && !map.isEmpty()) {
                hashMap.putAll(this.p);
            }
            hashMap.put("abitype", v1.d(this.l));
            hashMap.put("ext", this.m.g());
            return v1.p(v1.f(hashMap));
        }

        @Override // tb.s43
        protected final String Q() {
            return LiveFullInfo.VER;
        }

        @Override // com.loc.bl
        public final Map<String, String> b() {
            if (TextUtils.isEmpty(this.s)) {
                return null;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("host", this.s);
            return hashMap;
        }

        @Override // com.loc.bl
        public final String j() {
            return U("https://restsdk.amap.com/v3/iasdkauth", this.q);
        }

        @Override // tb.o83, com.loc.bl
        public final String m() {
            return U("https://dualstack-arestapi.amap.com/v3/iasdkauth", this.r);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.loc.bl
        public final String s() {
            return !TextUtils.isEmpty(this.s) ? this.s : super.s();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class d {
        u1 a;
        String b;
        a c;

        private d() {
        }

        /* synthetic */ d(byte b) {
            this();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class e {
        private String a;
        private String b;
        private AtomicInteger c;

        public e(String str, String str2, int i) {
            this.a = str;
            this.b = str2;
            this.c = new AtomicInteger(i);
        }

        public static e d(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                return new e(jSONObject.optString("a"), jSONObject.optString("f"), jSONObject.optInt("h"));
            } catch (Throwable unused) {
                return null;
            }
        }

        public final int a() {
            AtomicInteger atomicInteger = this.c;
            if (atomicInteger == null) {
                return 0;
            }
            return atomicInteger.get();
        }

        public final void c(String str) {
            this.b = str;
        }

        public final String e() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("a", this.a);
                jSONObject.put("f", this.b);
                jSONObject.put("h", this.c.get());
                return jSONObject.toString();
            } catch (Throwable unused) {
                return "";
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class f {
        public static boolean a = true;
        public static boolean b = false;
        public static boolean c = true;
        public static int d;
        public static boolean e;
        public static int f;
    }

    private static synchronized void A(String str, long j2) {
        synchronized (m.class) {
            try {
                if (p != null && p.containsKey(str)) {
                    if (n == null) {
                        n = new ConcurrentHashMap<>(8);
                    }
                    n.put(str, Long.valueOf(j2));
                    Context context = g;
                    if (context != null) {
                        SharedPreferences.Editor b2 = b43.b(context, "open_common");
                        b43.h(b2, str, j2);
                        b43.e(b2);
                    }
                }
            } catch (Throwable th) {
                y33.e(th, "at", "ucut");
            }
        }
    }

    public static synchronized void B(String str, boolean z2) {
        synchronized (m.class) {
            m(str, z2, null, null, null);
        }
    }

    public static boolean C() {
        Integer num;
        Context context = g;
        if (context == null) {
            return false;
        }
        String f0 = o.f0(context);
        return (TextUtils.isEmpty(f0) || (num = j.get(f0.toUpperCase())) == null || num.intValue() != 2) ? false : true;
    }

    public static synchronized long D(String str) {
        synchronized (m.class) {
            try {
                if (n == null) {
                    n = new ConcurrentHashMap<>(8);
                }
                if (n.containsKey(str)) {
                    return n.get(str).longValue();
                }
            } finally {
                return 0L;
            }
            return 0L;
        }
    }

    private static void E(Context context) {
        if (context == null) {
            return;
        }
        s = b43.k(context, "open_common", "a13", true);
        v = b43.k(context, "open_common", "a6", true);
        t = b43.k(context, "open_common", "a7", false);
        r = b43.a(context, "open_common", "a8", 5000);
        u = b43.a(context, "open_common", "a9", 3);
        w = b43.k(context, "open_common", "a10", false);
        x = b43.a(context, "open_common", "a11", 3);
        y = b43.k(context, "open_common", "a12", false);
    }

    public static void F(bj.c cVar) {
        if (cVar != null && y) {
            synchronized (D) {
                D.offer(cVar);
                bj.f();
            }
        }
    }

    public static boolean G() {
        Integer num;
        Context context = g;
        if (context == null) {
            return false;
        }
        String f0 = o.f0(context);
        return (TextUtils.isEmpty(f0) || (num = j.get(f0.toUpperCase())) == null || num.intValue() < 2) ? false : true;
    }

    public static void H() {
        try {
            e b2 = b(g, "IPV6_CONFIG_NAME", "open_common");
            String c2 = v1.c(System.currentTimeMillis(), "yyyyMMdd");
            if (!c2.equals(b2.b)) {
                b2.c(c2);
                b2.c.set(0);
            }
            b2.c.incrementAndGet();
            i(g, "IPV6_CONFIG_NAME", "open_common", b2);
        } catch (Throwable unused) {
        }
    }

    private static void I(Context context) {
        try {
            if (q) {
                return;
            }
            w33.e = b43.k(context, "open_common", "a4", true);
            w33.k = b43.k(context, "open_common", "a5", true);
            q = true;
        } catch (Throwable unused) {
        }
    }

    public static boolean J(String str) {
        e b2;
        try {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            if (s) {
                if (z.get(str) == null) {
                    Context context = g;
                    if (context == null || (b2 = b(context, w(str, "a14"), "open_common")) == null) {
                        return true;
                    }
                    return b2.a() < u;
                }
                return false;
            }
            return false;
        } catch (Throwable unused) {
            return true;
        }
    }

    public static void K() {
        if (m) {
            return;
        }
        try {
            Context context = g;
            if (context == null) {
                return;
            }
            m = true;
            q1.a().c(context);
            x(context);
            E(context);
            f.a = b43.k(context, "open_common", "ucf", f.a);
            f.b = b43.k(context, "open_common", "fsv2", f.b);
            f.c = b43.k(context, "open_common", "usc", f.c);
            f.d = b43.a(context, "open_common", "umv", f.d);
            f.e = b43.k(context, "open_common", "ust", f.e);
            f.f = b43.a(context, "open_common", "ustv", f.f);
        } catch (Throwable unused) {
        }
    }

    public static boolean L(String str) {
        e b2;
        if (!TextUtils.isEmpty(str) && w) {
            if (A.get(str) == null) {
                Context context = g;
                if (context == null || (b2 = b(context, w(str, "a15"), "open_common")) == null) {
                    return true;
                }
                return b2.a() < x;
            }
            return false;
        }
        return false;
    }

    public static bj.a M() {
        if (C) {
            return null;
        }
        synchronized (B) {
            if (C) {
                return null;
            }
            Collections.sort(B);
            if (B.size() > 0) {
                bj.a clone = B.get(0).clone();
                C = true;
                return clone;
            }
            return null;
        }
    }

    public static bj.c N() {
        synchronized (D) {
            bj.c poll = D.poll();
            if (poll != null) {
                return poll;
            }
            return null;
        }
    }

    private static void P() {
        Map<String, Integer> map;
        String str;
        Integer valueOf;
        try {
            Context context = g;
            if (context != null) {
                String f0 = o.f0(context);
                if (!TextUtils.isEmpty(k) && !TextUtils.isEmpty(f0) && k.equals(f0) && System.currentTimeMillis() - l < DateUtils.MILLIS_PER_MINUTE) {
                    return;
                }
                if (!TextUtils.isEmpty(f0)) {
                    k = f0;
                }
            } else if (System.currentTimeMillis() - l < 10000) {
                return;
            }
            l = System.currentTimeMillis();
            j.clear();
            Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            while (it.hasNext()) {
                NetworkInterface networkInterface = (NetworkInterface) it.next();
                if (!networkInterface.getInterfaceAddresses().isEmpty()) {
                    String displayName = networkInterface.getDisplayName();
                    int i2 = 0;
                    for (InterfaceAddress interfaceAddress : networkInterface.getInterfaceAddresses()) {
                        InetAddress address = interfaceAddress.getAddress();
                        if (address instanceof Inet6Address) {
                            if (!u((Inet6Address) address)) {
                                i2 |= 2;
                            }
                        } else if (address instanceof Inet4Address) {
                            Inet4Address inet4Address = (Inet4Address) address;
                            if (!u(inet4Address) && !inet4Address.getHostAddress().startsWith(v1.v("FMTkyLjE2OC40My4"))) {
                                i2 |= 1;
                            }
                        }
                    }
                    if (i2 != 0) {
                        if (displayName != null && displayName.startsWith("wlan")) {
                            map = j;
                            str = "WIFI";
                            valueOf = Integer.valueOf(i2);
                        } else if (displayName != null && displayName.startsWith("rmnet")) {
                            map = j;
                            str = "MOBILE";
                            valueOf = Integer.valueOf(i2);
                        }
                        map.put(str, valueOf);
                    }
                }
            }
        } catch (Throwable th) {
            y33.e(th, "at", "ipstack");
        }
    }

    public static b a(Context context, u1 u1Var, String str, String str2, String str3, String str4) {
        return v(context, u1Var, str, str2, str3, str4);
    }

    private static synchronized e b(Context context, String str, String str2) {
        e eVar;
        synchronized (m.class) {
            if (!TextUtils.isEmpty(str)) {
                for (int i2 = 0; i2 < i.size(); i2++) {
                    eVar = i.get(i2);
                    if (eVar != null && str.equals(eVar.a)) {
                        break;
                    }
                }
            }
            eVar = null;
            if (eVar != null) {
                return eVar;
            }
            if (context == null) {
                return null;
            }
            e d2 = e.d(b43.o(context, str2, str, ""));
            String c2 = v1.c(System.currentTimeMillis(), "yyyyMMdd");
            if (d2 == null) {
                d2 = new e(str, c2, 0);
            }
            if (!c2.equals(d2.b)) {
                d2.c(c2);
                d2.c.set(0);
            }
            i.add(d2);
            return d2;
        }
    }

    public static void c(Context context) {
        if (context != null) {
            g = context.getApplicationContext();
        }
    }

    private static void d(Context context, u1 u1Var, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("amap_sdk_auth_fail", "1");
        hashMap.put("amap_sdk_auth_fail_type", str);
        hashMap.put("amap_sdk_name", u1Var.a());
        hashMap.put("amap_sdk_version", u1Var.f());
        String jSONObject = new JSONObject(hashMap).toString();
        if (TextUtils.isEmpty(jSONObject)) {
            return;
        }
        try {
            d0 d0Var = new d0(context, StatServices.CATEGORY, "2.0", "O001");
            d0Var.a(jSONObject);
            bs.d(d0Var, context);
        } catch (k unused) {
        }
    }

    public static synchronized void e(Context context, u1 u1Var, String str, a aVar) {
        synchronized (m.class) {
            if (context == null || u1Var == null) {
                return;
            }
            try {
                if (g == null) {
                    g = context.getApplicationContext();
                }
                String a2 = u1Var.a();
                if (TextUtils.isEmpty(a2)) {
                    return;
                }
                k(u1Var);
                if (p == null) {
                    p = new ConcurrentHashMap<>(8);
                }
                if (o == null) {
                    o = new ConcurrentHashMap<>(8);
                }
                if (n == null) {
                    n = new ConcurrentHashMap<>(8);
                }
                if (!p.containsKey(a2)) {
                    d dVar = new d((byte) 0);
                    dVar.a = u1Var;
                    dVar.b = str;
                    dVar.c = aVar;
                    p.put(a2, dVar);
                    n.put(a2, Long.valueOf(b43.n(g, "open_common", a2)));
                    I(g);
                }
            } catch (Throwable th) {
                y33.e(th, "at", "rglc");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:143:0x02b6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x029e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01fd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:168:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void f(android.content.Context r20, com.loc.u1 r21, java.lang.String r22, com.loc.m.b r23, org.json.JSONObject r24) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 748
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.m.f(android.content.Context, com.loc.u1, java.lang.String, com.loc.m$b, org.json.JSONObject):void");
    }

    private static void g(Context context, u1 u1Var, Throwable th) {
        d(context, u1Var, th.getMessage());
    }

    public static void h(Context context, String str) {
        l.b(context, str);
    }

    private static void i(Context context, String str, String str2, e eVar) {
        if (eVar == null || TextUtils.isEmpty(eVar.a)) {
            return;
        }
        String e2 = eVar.e();
        if (TextUtils.isEmpty(e2) || context == null) {
            return;
        }
        SharedPreferences.Editor b2 = b43.b(context, str2);
        b2.putString(str, e2);
        b43.e(b2);
    }

    public static void j(bj.c cVar) {
        if (cVar == null || g == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("serverip", cVar.c);
        hashMap.put("hostname", cVar.e);
        hashMap.put(com.alibaba.security.realidentity.jsbridge.a.V, cVar.d);
        hashMap.put("csid", cVar.a);
        hashMap.put(MtopUpdater.DEGRADE, String.valueOf(cVar.b.a()));
        hashMap.put("errorcode", String.valueOf(cVar.m));
        hashMap.put("errorsubcode", String.valueOf(cVar.n));
        hashMap.put("connecttime", String.valueOf(cVar.h));
        hashMap.put("writetime", String.valueOf(cVar.i));
        hashMap.put("readtime", String.valueOf(cVar.j));
        hashMap.put("datasize", String.valueOf(cVar.l));
        hashMap.put("totaltime", String.valueOf(cVar.f));
        String jSONObject = new JSONObject(hashMap).toString();
        "--埋点--".concat(String.valueOf(jSONObject));
        bj.f();
        if (TextUtils.isEmpty(jSONObject)) {
            return;
        }
        try {
            d0 d0Var = new d0(g, StatServices.CATEGORY, "2.0", "O008");
            d0Var.a(jSONObject);
            bs.d(d0Var, g);
        } catch (k unused) {
        }
    }

    private static void k(u1 u1Var) {
        if (u1Var != null) {
            try {
                if (TextUtils.isEmpty(u1Var.a())) {
                    return;
                }
                String f2 = u1Var.f();
                if (TextUtils.isEmpty(f2)) {
                    f2 = u1Var.e();
                }
                if (TextUtils.isEmpty(f2)) {
                    return;
                }
                w33.b(u1Var.a(), f2);
            } catch (Throwable unused) {
            }
        }
    }

    private static void l(String str, String str2) {
        e b2 = b(g, str, str2);
        String c2 = v1.c(System.currentTimeMillis(), "yyyyMMdd");
        if (!c2.equals(b2.b)) {
            b2.c(c2);
            b2.c.set(0);
        }
        b2.c.incrementAndGet();
        i(g, str, str2, b2);
    }

    public static synchronized void m(final String str, boolean z2, final String str2, final String str3, final String str4) {
        synchronized (m.class) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (o == null) {
                    o = new ConcurrentHashMap<>(8);
                }
                o.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
                if (p == null) {
                    return;
                }
                if (p.containsKey(str)) {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    if (z2) {
                        y.j(true, str);
                    }
                    o0.f().d(new ck() { // from class: com.loc.m.1
                        @Override // com.loc.ck
                        public final void a() {
                            d dVar = (d) m.p.get(str);
                            if (dVar == null) {
                                return;
                            }
                            a aVar = dVar.c;
                            b a2 = m.a(m.g, dVar.a, dVar.b, str2, str3, str4);
                            if (a2 == null || aVar == null) {
                                return;
                            }
                            aVar.a(a2);
                        }
                    });
                }
            } catch (Throwable th) {
                y33.e(th, "at", "lca");
            }
        }
    }

    public static void n(String str, boolean z2, boolean z3, boolean z4) {
        if (TextUtils.isEmpty(str) || g == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        hashMap.put("downLevel", String.valueOf(z2));
        hashMap.put("ant", o.a0(g) == 0 ? "0" : "1");
        hashMap.put("type", z4 ? z2 ? e : f : z2 ? c : d);
        hashMap.put("status", z3 ? "0" : "1");
        String jSONObject = new JSONObject(hashMap).toString();
        if (TextUtils.isEmpty(jSONObject)) {
            return;
        }
        try {
            d0 d0Var = new d0(g, StatServices.CATEGORY, "2.0", "O002");
            d0Var.a(jSONObject);
            bs.d(d0Var, g);
        } catch (k unused) {
        }
    }

    public static void o(boolean z2, bj.a aVar) {
        if (!C || aVar == null) {
            return;
        }
        synchronized (B) {
            if (z2) {
                Iterator<bj.a> it = B.iterator();
                while (it.hasNext()) {
                    bj.a next = it.next();
                    if (next.b.equals(aVar.b) && next.e.equals(aVar.e) && next.f == aVar.f) {
                        if (next.j == aVar.j) {
                            it.remove();
                        } else {
                            next.j.set(next.j.get() - aVar.j.get());
                        }
                        bj.f();
                    }
                }
            }
            C = false;
            Iterator<bj.a> it2 = B.iterator();
            while (true) {
                bj.f();
                if (it2.hasNext()) {
                    bj.a next2 = it2.next();
                    String str = next2.e;
                    Objects.toString(next2.j);
                } else {
                    bj.f();
                }
            }
        }
    }

    public static void p(boolean z2, String str) {
        try {
            "--markHostNameFailed---hostname=".concat(String.valueOf(str));
            bj.f();
            if (s || z2) {
                if ((w || !z2) && !TextUtils.isEmpty(str)) {
                    if (z2) {
                        if (A.get(str) != null) {
                            return;
                        }
                        A.put(str, Boolean.TRUE);
                        l(w(str, "a15"), "open_common");
                    } else if (z.get(str) != null) {
                    } else {
                        z.put(str, Boolean.TRUE);
                        l(w(str, "a14"), "open_common");
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean q() {
        e b2;
        if (g != null) {
            P();
            if (!G()) {
                return false;
            }
            if (C()) {
                return true;
            }
        }
        return h && (b2 = b(g, "IPV6_CONFIG_NAME", "open_common")) != null && b2.a() < 5;
    }

    public static synchronized boolean r(String str) {
        synchronized (m.class) {
            try {
            } finally {
                return false;
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (p == null) {
                return false;
            }
            if (o == null) {
                o = new ConcurrentHashMap<>(8);
            }
            if (p.containsKey(str) && !o.containsKey(str)) {
                o.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
                return true;
            }
            return false;
        }
    }

    public static synchronized boolean s(String str, long j2) {
        synchronized (m.class) {
            boolean z2 = false;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (j2 > D(str)) {
                long j3 = 0;
                if (o != null && o.containsKey(str)) {
                    j3 = o.get(str).longValue();
                }
                if (SystemClock.elapsedRealtime() - j3 > 30000) {
                    z2 = true;
                }
            }
            return z2;
        }
    }

    public static boolean t(String str, boolean z2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return z2;
            }
            String[] split = URLDecoder.decode(str).split("/");
            return split[split.length - 1].charAt(4) % 2 == 1;
        } catch (Throwable unused) {
            return z2;
        }
    }

    private static boolean u(InetAddress inetAddress) {
        return inetAddress.isLoopbackAddress() || inetAddress.isLinkLocalAddress() || inetAddress.isAnyLocalAddress();
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01b1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.loc.m.b v(android.content.Context r22, com.loc.u1 r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27) {
        /*
            Method dump skipped, instructions count: 622
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.m.v(android.content.Context, com.loc.u1, java.lang.String, java.lang.String, java.lang.String, java.lang.String):com.loc.m$b");
    }

    private static String w(String str, String str2) {
        String b2 = r1.b(str.getBytes());
        return str2 + JSMethod.NOT_SET + b2;
    }

    public static void x(Context context) {
        if (context == null) {
            return;
        }
        h = b43.k(context, "open_common", "a2", true);
    }

    public static void y(bj.c cVar) {
        synchronized (B) {
            boolean z2 = false;
            for (int i2 = 0; i2 < B.size(); i2++) {
                bj.a aVar = B.get(i2);
                if (cVar.c.equals(aVar.b) && cVar.d.equals(aVar.e)) {
                    int i3 = cVar.m;
                    int i4 = aVar.f;
                    if (i3 == i4) {
                        if (i4 == 1) {
                            aVar.i = ((aVar.j.get() * aVar.i) + cVar.f) / (aVar.j.get() + 1);
                        }
                        aVar.j.getAndIncrement();
                        z2 = true;
                    }
                }
            }
            if (!z2) {
                B.add(new bj.a(cVar));
            }
            bj.f();
        }
    }

    public static synchronized void z(String str) {
        synchronized (m.class) {
            if (o == null) {
                return;
            }
            if (o.containsKey(str)) {
                o.remove(str);
            }
        }
    }
}
