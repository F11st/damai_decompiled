package com.amap.api.col.s;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.amap.api.col.s.dc;
import com.amap.api.col.s.df;
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

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class bl {
    private static volatile boolean C = false;
    public static int a = -1;
    public static String b = "";
    public static Context c = null;
    private static String k = "6";
    private static String l = "4";
    private static String m = "9";
    private static String n = "8";
    private static volatile boolean o = true;
    private static Vector<e> p = new Vector<>();
    private static Map<String, Integer> q = new HashMap();
    private static String r = null;
    private static long s = 0;
    public static volatile boolean d = false;
    private static volatile ConcurrentHashMap<String, Long> t = new ConcurrentHashMap<>(8);
    private static volatile ConcurrentHashMap<String, Long> u = new ConcurrentHashMap<>(8);
    private static volatile ConcurrentHashMap<String, d> v = new ConcurrentHashMap<>(8);
    private static boolean w = false;
    public static int e = 5000;
    public static boolean f = true;
    public static boolean g = false;
    private static int x = 3;
    public static boolean h = true;
    public static boolean i = false;
    private static int y = 3;
    public static boolean j = false;
    private static ConcurrentHashMap<String, Boolean> z = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, Boolean> A = new ConcurrentHashMap<>();
    private static ArrayList<dc.a> B = new ArrayList<>();
    private static Queue<dc.c> D = new LinkedList();

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface a {
        void a(b bVar);
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class b {
        @Deprecated
        public JSONObject a;
        @Deprecated
        public JSONObject b;
        public String c;
        public int d = -1;
        public long e = 0;
        public JSONObject f;
        public a g;
        public C0208b h;
        private boolean i;

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public static class a {
            public boolean a;
            public boolean b;
            public JSONObject c;
        }

        /* compiled from: Taobao */
        /* renamed from: com.amap.api.col.s.bl$b$b  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public static class C0208b {
            public boolean a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class c extends da {
        private String d;
        private Map<String, String> e;
        private String f;
        private String k;
        private String l;

        c(Context context, bv bvVar, String str, String str2, String str3, String str4) {
            super(context, bvVar);
            this.d = str;
            this.e = null;
            this.f = str2;
            this.k = str3;
            this.l = str4;
            a(df.c.HTTPS);
            a(df.a.FIX);
        }

        @Override // com.amap.api.col.s.br, com.amap.api.col.s.df
        public final String a() {
            return a("https://dualstack-arestapi.amap.com/v3/iasdkauth", this.k);
        }

        @Override // com.amap.api.col.s.da
        public final byte[] b() {
            String q = bo.q(((da) this).a);
            if (!TextUtils.isEmpty(q)) {
                q = bs.a(new StringBuilder(q).reverse().toString());
            }
            HashMap hashMap = new HashMap();
            hashMap.put("authkey", TextUtils.isEmpty(this.d) ? "" : this.d);
            hashMap.put("plattype", "android");
            hashMap.put("product", ((da) this).b.b());
            hashMap.put("version", ((da) this).b.c());
            hashMap.put("output", Preloader.KEY_JSON);
            StringBuilder sb = new StringBuilder();
            sb.append(Build.VERSION.SDK_INT);
            hashMap.put("androidversion", sb.toString());
            hashMap.put("deviceId", q);
            hashMap.put("manufacture", com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMANUFACTURER());
            Map<String, String> map = this.e;
            if (map != null && !map.isEmpty()) {
                hashMap.putAll(this.e);
            }
            hashMap.put("abitype", bw.a(((da) this).a));
            hashMap.put("ext", ((da) this).b.e());
            return bw.a(bw.a(hashMap));
        }

        @Override // com.amap.api.col.s.da
        protected final String d() {
            return LiveFullInfo.VER;
        }

        @Override // com.amap.api.col.s.df
        public final Map<String, String> f() {
            if (TextUtils.isEmpty(this.l)) {
                return null;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("host", this.l);
            return hashMap;
        }

        @Override // com.amap.api.col.s.df
        public final String h() {
            return a("https://restsdk.amap.com/v3/iasdkauth", this.f);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.amap.api.col.s.df
        public final String i() {
            if (!TextUtils.isEmpty(this.l)) {
                return this.l;
            }
            return super.i();
        }

        private static String a(String str, String str2) {
            try {
                return !TextUtils.isEmpty(str2) ? Uri.parse(str).buildUpon().encodedAuthority(str2).build().toString() : str;
            } catch (Throwable unused) {
                return str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class d {
        bv a;
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

        public final void a(String str) {
            this.b = str;
        }

        public final String b() {
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

        public final int a() {
            AtomicInteger atomicInteger = this.c;
            if (atomicInteger == null) {
                return 0;
            }
            return atomicInteger.get();
        }

        public static e b(String str) {
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

    public static boolean a(String str, boolean z2) {
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

    /* JADX WARN: Removed duplicated region for block: B:100:0x01b7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01b8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.amap.api.col.s.bl.b b(android.content.Context r22, com.amap.api.col.s.bv r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27) {
        /*
            Method dump skipped, instructions count: 635
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.s.bl.b(android.content.Context, com.amap.api.col.s.bv, java.lang.String, java.lang.String, java.lang.String, java.lang.String):com.amap.api.col.s.bl$b");
    }

    private static void c(Context context) {
        if (context == null) {
            return;
        }
        f = co.a(context, "open_common", "a13", true);
        h = co.a(context, "open_common", "a6", true);
        g = co.a(context, "open_common", "a7", false);
        e = co.a(context, "open_common", "a8", 5000);
        x = co.a(context, "open_common", "a9", 3);
        i = co.a(context, "open_common", "a10", false);
        y = co.a(context, "open_common", "a11", 3);
        j = co.a(context, "open_common", "a12", false);
    }

    public static void d() {
        if (d) {
            return;
        }
        try {
            Context context = c;
            if (context == null) {
                return;
            }
            d = true;
            bq.a().a(context);
            b(context);
            c(context);
            f.a = co.a(context, "open_common", "ucf", f.a);
            f.b = co.a(context, "open_common", "fsv2", f.b);
            f.c = co.a(context, "open_common", "usc", f.c);
            f.d = co.a(context, "open_common", "umv", f.d);
            f.e = co.a(context, "open_common", "ust", f.e);
            f.f = co.a(context, "open_common", "ustv", f.f);
        } catch (Throwable unused) {
        }
    }

    public static boolean e(String str) {
        e a2;
        if (!TextUtils.isEmpty(str) && i) {
            if (A.get(str) == null) {
                Context context = c;
                if (context == null || (a2 = a(context, b(str, "a15"), "open_common")) == null) {
                    return true;
                }
                return a2.a() < y;
            }
            return false;
        }
        return false;
    }

    public static dc.c f() {
        synchronized (D) {
            dc.c poll = D.poll();
            if (poll != null) {
                return poll;
            }
            return null;
        }
    }

    private static void h() {
        try {
            Context context = c;
            if (context != null) {
                String p2 = bo.p(context);
                if (!TextUtils.isEmpty(r) && !TextUtils.isEmpty(p2) && r.equals(p2) && System.currentTimeMillis() - s < DateUtils.MILLIS_PER_MINUTE) {
                    return;
                }
                if (!TextUtils.isEmpty(p2)) {
                    r = p2;
                }
            } else if (System.currentTimeMillis() - s < 10000) {
                return;
            }
            s = System.currentTimeMillis();
            q.clear();
            Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            while (it.hasNext()) {
                NetworkInterface networkInterface = (NetworkInterface) it.next();
                if (!networkInterface.getInterfaceAddresses().isEmpty()) {
                    String displayName = networkInterface.getDisplayName();
                    int i2 = 0;
                    for (InterfaceAddress interfaceAddress : networkInterface.getInterfaceAddresses()) {
                        InetAddress address = interfaceAddress.getAddress();
                        if (address instanceof Inet6Address) {
                            if (!a((Inet6Address) address)) {
                                i2 |= 2;
                            }
                        } else if (address instanceof Inet4Address) {
                            Inet4Address inet4Address = (Inet4Address) address;
                            if (!a(inet4Address) && !inet4Address.getHostAddress().startsWith(bw.c("FMTkyLjE2OC40My4"))) {
                                i2 |= 1;
                            }
                        }
                    }
                    if (i2 != 0) {
                        if (displayName != null && displayName.startsWith("wlan")) {
                            q.put("WIFI", Integer.valueOf(i2));
                        } else if (displayName != null && displayName.startsWith("rmnet")) {
                            q.put("MOBILE", Integer.valueOf(i2));
                        }
                    }
                }
            }
        } catch (Throwable th) {
            ci.a(th, "at", "ipstack");
        }
    }

    private static boolean i() {
        Integer num;
        Context context = c;
        if (context == null) {
            return false;
        }
        String p2 = bo.p(context);
        return (TextUtils.isEmpty(p2) || (num = q.get(p2.toUpperCase())) == null || num.intValue() != 2) ? false : true;
    }

    public static dc.a e() {
        if (C) {
            return null;
        }
        synchronized (B) {
            if (C) {
                return null;
            }
            Collections.sort(B);
            if (B.size() > 0) {
                dc.a clone = B.get(0).clone();
                C = true;
                return clone;
            }
            return null;
        }
    }

    public static b a(Context context, bv bvVar, String str, String str2, String str3, String str4) {
        return b(context, bvVar, str, str2, str3, str4);
    }

    public static void a(Context context) {
        if (context != null) {
            c = context.getApplicationContext();
        }
    }

    public static synchronized long c(String str) {
        synchronized (bl.class) {
            try {
                if (t == null) {
                    t = new ConcurrentHashMap<>(8);
                }
                if (t.containsKey(str)) {
                    return t.get(str).longValue();
                }
            } finally {
                return 0L;
            }
            return 0L;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:152:0x02c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x02a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0208 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:169:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(android.content.Context r20, com.amap.api.col.s.bv r21, java.lang.String r22, com.amap.api.col.s.bl.b r23, org.json.JSONObject r24) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 759
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.s.bl.a(android.content.Context, com.amap.api.col.s.bv, java.lang.String, com.amap.api.col.s.bl$b, org.json.JSONObject):void");
    }

    private static void d(Context context) {
        try {
            if (w) {
                return;
            }
            cf.d = co.a(context, "open_common", "a4", true);
            cf.e = co.a(context, "open_common", "a5", true);
            w = true;
        } catch (Throwable unused) {
        }
    }

    public static void c(dc.c cVar) {
        if (cVar != null && j) {
            synchronized (D) {
                D.offer(cVar);
                dc.a();
            }
        }
    }

    public static boolean d(String str) {
        e a2;
        try {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            if (f) {
                if (z.get(str) == null) {
                    Context context = c;
                    if (context == null || (a2 = a(context, b(str, "a14"), "open_common")) == null) {
                        return true;
                    }
                    return a2.a() < x;
                }
                return false;
            }
            return false;
        } catch (Throwable unused) {
            return true;
        }
    }

    public static void c() {
        try {
            e a2 = a(c, "IPV6_CONFIG_NAME", "open_common");
            String a3 = bw.a(System.currentTimeMillis(), "yyyyMMdd");
            if (!a3.equals(a2.b)) {
                a2.a(a3);
                a2.c.set(0);
            }
            a2.c.incrementAndGet();
            a(c, "IPV6_CONFIG_NAME", "open_common", a2);
        } catch (Throwable unused) {
        }
    }

    public static boolean b() {
        Integer num;
        Context context = c;
        if (context == null) {
            return false;
        }
        String p2 = bo.p(context);
        return (TextUtils.isEmpty(p2) || (num = q.get(p2.toUpperCase())) == null || num.intValue() < 2) ? false : true;
    }

    private static void b(Context context) {
        if (context == null) {
            return;
        }
        o = co.a(context, "open_common", "a2", true);
    }

    public static synchronized void b(String str, boolean z2) {
        synchronized (bl.class) {
            a(str, z2, (String) null, (String) null, (String) null);
        }
    }

    public static synchronized void b(String str) {
        synchronized (bl.class) {
            if (u == null) {
                return;
            }
            if (u.containsKey(str)) {
                u.remove(str);
            }
        }
    }

    private static synchronized void b(String str, long j2) {
        synchronized (bl.class) {
            try {
                if (v != null && v.containsKey(str)) {
                    if (t == null) {
                        t = new ConcurrentHashMap<>(8);
                    }
                    t.put(str, Long.valueOf(j2));
                    Context context = c;
                    if (context != null) {
                        SharedPreferences.Editor a2 = co.a(context, "open_common");
                        co.a(a2, str, j2);
                        co.a(a2);
                    }
                }
            } catch (Throwable th) {
                ci.a(th, "at", "ucut");
            }
        }
    }

    private static String b(String str, String str2) {
        String a2 = bs.a(str.getBytes());
        return str2 + JSMethod.NOT_SET + a2;
    }

    public static void b(dc.c cVar) {
        synchronized (B) {
            boolean z2 = false;
            for (int i2 = 0; i2 < B.size(); i2++) {
                dc.a aVar = B.get(i2);
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
                B.add(new dc.a(cVar));
            }
            dc.a();
        }
    }

    private static void a(Context context, bv bvVar, Throwable th) {
        a(context, bvVar, th.getMessage());
    }

    public static void a(String str, boolean z2, boolean z3, boolean z4) {
        if (TextUtils.isEmpty(str) || c == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        hashMap.put("downLevel", String.valueOf(z2));
        hashMap.put("ant", bo.n(c) == 0 ? "0" : "1");
        if (z4) {
            hashMap.put("type", z2 ? m : n);
        } else {
            hashMap.put("type", z2 ? k : l);
        }
        hashMap.put("status", z3 ? "0" : "1");
        String jSONObject = new JSONObject(hashMap).toString();
        if (TextUtils.isEmpty(jSONObject)) {
            return;
        }
        try {
            dl dlVar = new dl(c, StatServices.CATEGORY, "2.0", "O002");
            dlVar.a(jSONObject);
            dm.a(dlVar, c);
        } catch (bj unused) {
        }
    }

    public static void a(dc.c cVar) {
        if (cVar == null || c == null) {
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
        dc.a();
        if (TextUtils.isEmpty(jSONObject)) {
            return;
        }
        try {
            dl dlVar = new dl(c, StatServices.CATEGORY, "2.0", "O008");
            dlVar.a(jSONObject);
            dm.a(dlVar, c);
        } catch (bj unused) {
        }
    }

    private static void a(Context context, bv bvVar, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("amap_sdk_auth_fail", "1");
        hashMap.put("amap_sdk_auth_fail_type", str);
        hashMap.put("amap_sdk_name", bvVar.b());
        hashMap.put("amap_sdk_version", bvVar.d());
        String jSONObject = new JSONObject(hashMap).toString();
        if (TextUtils.isEmpty(jSONObject)) {
            return;
        }
        try {
            dl dlVar = new dl(context, StatServices.CATEGORY, "2.0", "O001");
            dlVar.a(jSONObject);
            dm.a(dlVar, context);
        } catch (bj unused) {
        }
    }

    public static boolean a() {
        e a2;
        if (c != null) {
            h();
            if (!b()) {
                return false;
            }
            if (i()) {
                return true;
            }
        }
        return o && (a2 = a(c, "IPV6_CONFIG_NAME", "open_common")) != null && a2.a() < 5;
    }

    private static boolean a(InetAddress inetAddress) {
        return inetAddress.isLoopbackAddress() || inetAddress.isLinkLocalAddress() || inetAddress.isAnyLocalAddress();
    }

    private static void a(Context context, String str, String str2, e eVar) {
        if (eVar == null || TextUtils.isEmpty(eVar.a)) {
            return;
        }
        String b2 = eVar.b();
        if (TextUtils.isEmpty(b2) || context == null) {
            return;
        }
        SharedPreferences.Editor a2 = co.a(context, str2);
        a2.putString(str, b2);
        co.a(a2);
    }

    public static synchronized void a(Context context, bv bvVar, String str, a aVar) {
        synchronized (bl.class) {
            if (context == null || bvVar == null) {
                return;
            }
            try {
                if (c == null) {
                    c = context.getApplicationContext();
                }
                String b2 = bvVar.b();
                if (TextUtils.isEmpty(b2)) {
                    return;
                }
                a(bvVar);
                if (v == null) {
                    v = new ConcurrentHashMap<>(8);
                }
                if (u == null) {
                    u = new ConcurrentHashMap<>(8);
                }
                if (t == null) {
                    t = new ConcurrentHashMap<>(8);
                }
                if (!v.containsKey(b2)) {
                    d dVar = new d((byte) 0);
                    dVar.a = bvVar;
                    dVar.b = str;
                    dVar.c = aVar;
                    v.put(b2, dVar);
                    t.put(b2, Long.valueOf(co.b(c, "open_common", b2)));
                    d(c);
                }
            } catch (Throwable th) {
                ci.a(th, "at", "rglc");
            }
        }
    }

    public static synchronized boolean a(String str, long j2) {
        synchronized (bl.class) {
            boolean z2 = false;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (j2 > c(str)) {
                long j3 = 0;
                if (u != null && u.containsKey(str)) {
                    j3 = u.get(str).longValue();
                }
                if (SystemClock.elapsedRealtime() - j3 > 30000) {
                    z2 = true;
                }
            }
            return z2;
        }
    }

    public static synchronized void a(final String str, boolean z2, final String str2, final String str3, final String str4) {
        synchronized (bl.class) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (u == null) {
                    u = new ConcurrentHashMap<>(8);
                }
                u.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
                if (v == null) {
                    return;
                }
                if (v.containsKey(str)) {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    if (z2) {
                        db.a(true, str);
                    }
                    ed.a().b(new ee() { // from class: com.amap.api.col.s.bl.1
                        @Override // com.amap.api.col.s.ee
                        public final void a() {
                            d dVar = (d) bl.v.get(str);
                            if (dVar == null) {
                                return;
                            }
                            a aVar = dVar.c;
                            b a2 = bl.a(bl.c, dVar.a, dVar.b, str2, str3, str4);
                            if (a2 == null || aVar == null) {
                                return;
                            }
                            aVar.a(a2);
                        }
                    });
                }
            } catch (Throwable th) {
                ci.a(th, "at", "lca");
            }
        }
    }

    public static synchronized boolean a(String str) {
        synchronized (bl.class) {
            try {
            } finally {
                return false;
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (v == null) {
                return false;
            }
            if (u == null) {
                u = new ConcurrentHashMap<>(8);
            }
            if (v.containsKey(str) && !u.containsKey(str)) {
                u.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
                return true;
            }
            return false;
        }
    }

    private static void a(bv bvVar) {
        if (bvVar != null) {
            try {
                if (TextUtils.isEmpty(bvVar.b())) {
                    return;
                }
                String d2 = bvVar.d();
                if (TextUtils.isEmpty(d2)) {
                    d2 = bvVar.c();
                }
                if (TextUtils.isEmpty(d2)) {
                    return;
                }
                cf.a(bvVar.b(), d2);
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(boolean z2, String str) {
        try {
            "--markHostNameFailed---hostname=".concat(String.valueOf(str));
            dc.a();
            if (f || z2) {
                if ((i || !z2) && !TextUtils.isEmpty(str)) {
                    if (!z2) {
                        if (z.get(str) != null) {
                            return;
                        }
                        z.put(str, Boolean.TRUE);
                        a(b(str, "a14"), "open_common");
                    } else if (A.get(str) != null) {
                    } else {
                        A.put(str, Boolean.TRUE);
                        a(b(str, "a15"), "open_common");
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static void a(String str, String str2) {
        e a2 = a(c, str, str2);
        String a3 = bw.a(System.currentTimeMillis(), "yyyyMMdd");
        if (!a3.equals(a2.b)) {
            a2.a(a3);
            a2.c.set(0);
        }
        a2.c.incrementAndGet();
        a(c, str, str2, a2);
    }

    public static void a(boolean z2, dc.a aVar) {
        if (!C || aVar == null) {
            return;
        }
        synchronized (B) {
            if (z2) {
                Iterator<dc.a> it = B.iterator();
                while (it.hasNext()) {
                    dc.a next = it.next();
                    if (next.b.equals(aVar.b) && next.e.equals(aVar.e) && next.f == aVar.f) {
                        if (next.j == aVar.j) {
                            it.remove();
                            dc.a();
                        } else {
                            next.j.set(next.j.get() - aVar.j.get());
                            dc.a();
                        }
                    }
                }
            }
            C = false;
            Iterator<dc.a> it2 = B.iterator();
            dc.a();
            while (it2.hasNext()) {
                dc.a next2 = it2.next();
                String str = next2.e;
                Objects.toString(next2.j);
                dc.a();
            }
            dc.a();
        }
    }

    private static synchronized e a(Context context, String str, String str2) {
        e eVar;
        synchronized (bl.class) {
            if (!TextUtils.isEmpty(str)) {
                for (int i2 = 0; i2 < p.size(); i2++) {
                    eVar = p.get(i2);
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
            e b2 = e.b(co.b(context, str2, str, ""));
            String a2 = bw.a(System.currentTimeMillis(), "yyyyMMdd");
            if (b2 == null) {
                b2 = new e(str, a2, 0);
            }
            if (!a2.equals(b2.b)) {
                b2.a(a2);
                b2.c.set(0);
            }
            p.add(b2);
            return b2;
        }
    }
}
