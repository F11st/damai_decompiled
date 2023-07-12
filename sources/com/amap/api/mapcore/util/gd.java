package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.taobao.weex.ui.component.WXComponent;
import com.youku.live.livesdk.model.mtop.LiveFullInfo;
import com.youku.live.livesdk.preloader.Preloader;
import io.flutter.stat.StatServices;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.URLDecoder;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.lang3.time.DateUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class gd {
    public static int a = -1;
    public static String b = "";
    private static Context c = null;
    private static volatile boolean d = true;
    private static Vector<C4563c> e = new Vector<>();
    private static Map<String, Integer> f = new HashMap();
    private static String g = null;
    private static long h = 0;

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.gd$a */
    /* loaded from: classes10.dex */
    public static class C4555a {
        @Deprecated
        public C4558c A;
        public C4558c B;
        public C4557b C;
        public C4557b D;
        public C4557b E;
        public C4557b F;
        public C4561f G;
        private boolean H;
        public String a;
        public int b = -1;
        @Deprecated
        public JSONObject c;
        @Deprecated
        public JSONObject d;
        @Deprecated
        public JSONObject e;
        @Deprecated
        public JSONObject f;
        @Deprecated
        public JSONObject g;
        @Deprecated
        public JSONObject h;
        @Deprecated
        public JSONObject i;
        @Deprecated
        public JSONObject j;
        @Deprecated
        public JSONObject k;
        @Deprecated
        public JSONObject l;
        @Deprecated
        public JSONObject m;
        @Deprecated
        public JSONObject n;
        @Deprecated
        public JSONObject o;
        @Deprecated
        public JSONObject p;
        @Deprecated
        public JSONObject q;
        @Deprecated
        public JSONObject r;
        @Deprecated
        public JSONObject s;
        @Deprecated
        public JSONObject t;
        @Deprecated
        public JSONObject u;
        @Deprecated
        public JSONObject v;
        public JSONObject w;
        public C4556a x;
        public C4559d y;
        public C4560e z;

        /* compiled from: Taobao */
        /* renamed from: com.amap.api.mapcore.util.gd$a$a */
        /* loaded from: classes10.dex */
        public static class C4556a {
            public boolean a;
            public boolean b;
            public JSONObject c;
        }

        /* compiled from: Taobao */
        /* renamed from: com.amap.api.mapcore.util.gd$a$b */
        /* loaded from: classes10.dex */
        public static class C4557b {
            public boolean a;
            public String b;
            public String c;
            public String d;
            public boolean e;
        }

        /* compiled from: Taobao */
        /* renamed from: com.amap.api.mapcore.util.gd$a$c */
        /* loaded from: classes10.dex */
        public static class C4558c {
            public String a;
            public String b;
        }

        /* compiled from: Taobao */
        /* renamed from: com.amap.api.mapcore.util.gd$a$d */
        /* loaded from: classes10.dex */
        public static class C4559d {
            public String a;
            public String b;
            public String c;
        }

        /* compiled from: Taobao */
        /* renamed from: com.amap.api.mapcore.util.gd$a$e */
        /* loaded from: classes10.dex */
        public static class C4560e {
            public boolean a;
        }

        /* compiled from: Taobao */
        /* renamed from: com.amap.api.mapcore.util.gd$a$f */
        /* loaded from: classes10.dex */
        public static class C4561f {
            public boolean a;
            public boolean b;
            public boolean c;
            public String d;
            public String e;
            public String f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.gd$b */
    /* loaded from: classes10.dex */
    public static class C4562b extends ie {
        private String f;
        private Map<String, String> g;
        private boolean h;

        C4562b(Context context, gm gmVar, String str, Map<String, String> map) {
            super(context, gmVar);
            this.f = str;
            this.g = map;
            this.h = Build.VERSION.SDK_INT != 19;
        }

        private Map<String, String> l() {
            String w = gg.w(this.d);
            if (TextUtils.isEmpty(w)) {
                w = gg.j(this.d);
            }
            if (!TextUtils.isEmpty(w)) {
                w = gk.b(new StringBuilder(w).reverse().toString());
            }
            HashMap hashMap = new HashMap();
            hashMap.put("authkey", this.f);
            hashMap.put("plattype", "android");
            hashMap.put("product", this.e.a());
            hashMap.put("version", this.e.b());
            hashMap.put("output", Preloader.KEY_JSON);
            hashMap.put("androidversion", Build.VERSION.SDK_INT + "");
            hashMap.put("deviceId", w);
            hashMap.put("manufacture", com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMANUFACTURER());
            Map<String, String> map = this.g;
            if (map != null && !map.isEmpty()) {
                hashMap.putAll(this.g);
            }
            hashMap.put("abitype", gn.a(this.d));
            hashMap.put("ext", this.e.e());
            return hashMap;
        }

        public boolean a() {
            return this.h;
        }

        @Override // com.amap.api.mapcore.util.ie
        public byte[] e() {
            return null;
        }

        @Override // com.amap.api.mapcore.util.ie
        public byte[] f() {
            return gn.a(gn.b(l()));
        }

        @Override // com.amap.api.mapcore.util.ie
        protected String g() {
            return LiveFullInfo.VER;
        }

        @Override // com.amap.api.mapcore.util.ii
        public Map<String, String> getRequestHead() {
            return null;
        }

        @Override // com.amap.api.mapcore.util.ii
        public String getURL() {
            return this.h ? "https://restapi.amap.com/v3/iasdkauth" : "http://restapi.amap.com/v3/iasdkauth";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.gd$c */
    /* loaded from: classes10.dex */
    public static class C4563c {
        private String a;
        private String b;
        private AtomicInteger c;

        public C4563c(String str, String str2, int i) {
            this.a = str;
            this.b = str2;
            this.c = new AtomicInteger(i);
        }

        public void a(String str) {
            this.b = str;
        }

        public String b() {
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

        public int a() {
            AtomicInteger atomicInteger = this.c;
            if (atomicInteger == null) {
                return 0;
            }
            return atomicInteger.get();
        }

        public static C4563c b(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                return new C4563c(jSONObject.optString("a"), jSONObject.optString("f"), jSONObject.optInt("h"));
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    public static void a(Context context, String str) {
        C4554gc.a(context, str);
    }

    private static void b(Context context, JSONObject jSONObject) {
        boolean a2;
        if (jSONObject == null || (a2 = a(jSONObject.optString("able"), false)) == d) {
            return;
        }
        d = a2;
        a(context, a2);
    }

    public static boolean c() {
        Integer num;
        Context context = c;
        if (context == null) {
            return false;
        }
        String v = gg.v(context);
        return (TextUtils.isEmpty(v) || (num = f.get(v.toUpperCase())) == null || num.intValue() != 2) ? false : true;
    }

    public static boolean d() {
        Integer num;
        Context context = c;
        if (context == null) {
            return false;
        }
        String v = gg.v(context);
        return (TextUtils.isEmpty(v) || (num = f.get(v.toUpperCase())) == null || num.intValue() < 2) ? false : true;
    }

    private static void e() {
        C4563c b2 = b(c, "IPV6_CONFIG_NAME");
        String a2 = gn.a(System.currentTimeMillis(), "yyyyMMdd");
        if (!a2.equals(b2.b)) {
            b2.a(a2);
            b2.c.set(0);
        }
        b2.c.incrementAndGet();
        a(c, b2);
    }

    public static boolean a(String str, boolean z) {
        try {
            if (TextUtils.isEmpty(str)) {
                return z;
            }
            String[] split = URLDecoder.decode(str).split("/");
            return split[split.length - 1].charAt(4) % 2 == 1;
        } catch (Throwable unused) {
            return z;
        }
    }

    public static void b() {
        try {
            Context context = c;
            if (context != null) {
                String v = gg.v(context);
                if (!TextUtils.isEmpty(g) && !TextUtils.isEmpty(v) && g.equals(v) && System.currentTimeMillis() - h < DateUtils.MILLIS_PER_MINUTE) {
                    return;
                }
                if (!TextUtils.isEmpty(v)) {
                    g = v;
                }
            } else if (System.currentTimeMillis() - h < 10000) {
                return;
            }
            h = System.currentTimeMillis();
            f.clear();
            Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            while (it.hasNext()) {
                NetworkInterface networkInterface = (NetworkInterface) it.next();
                if (!networkInterface.getInterfaceAddresses().isEmpty()) {
                    String displayName = networkInterface.getDisplayName();
                    int i = 0;
                    for (InterfaceAddress interfaceAddress : networkInterface.getInterfaceAddresses()) {
                        InetAddress address = interfaceAddress.getAddress();
                        if (address instanceof Inet6Address) {
                            if (!a((Inet6Address) address)) {
                                i |= 2;
                            }
                        } else if (address instanceof Inet4Address) {
                            Inet4Address inet4Address = (Inet4Address) address;
                            if (!a(inet4Address) && !inet4Address.getHostAddress().startsWith(gn.c("FMTkyLjE2OC40My4"))) {
                                i |= 1;
                            }
                        }
                    }
                    if (i != 0) {
                        if (displayName != null && displayName.startsWith("wlan")) {
                            f.put("WIFI", Integer.valueOf(i));
                        } else if (displayName != null && displayName.startsWith("rmnet")) {
                            f.put("MOBILE", Integer.valueOf(i));
                        }
                    }
                }
            }
        } catch (Throwable th) {
            C4573ha.a(th, "at", "ipstack");
        }
    }

    public static C4555a a(Context context, gm gmVar, String str, Map<String, String> map) {
        return a(context, gmVar, str, map, false);
    }

    public static C4555a a(Context context, gm gmVar, String str, Map<String, String> map, boolean z) {
        return a(context, gmVar, str, map, z, "DEF_ID");
    }

    public static void a(Context context) {
        if (context != null) {
            c = context.getApplicationContext();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x00de A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.amap.api.mapcore.util.gd.C4555a a(android.content.Context r16, com.amap.api.mapcore.util.gm r17, java.lang.String r18, java.util.Map<java.lang.String, java.lang.String> r19, boolean r20, java.lang.String r21) {
        /*
            Method dump skipped, instructions count: 403
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.gd.a(android.content.Context, com.amap.api.mapcore.util.gm, java.lang.String, java.util.Map, boolean, java.lang.String):com.amap.api.mapcore.util.gd$a");
    }

    public static void b(Context context) {
        if (context == null) {
            return;
        }
        d = new hr("IPV6_CONFIG_NAME").b(context, "k", true);
    }

    private static synchronized C4563c b(Context context, String str) {
        synchronized (gd.class) {
            C4563c a2 = a(str);
            if (a2 != null) {
                return a2;
            }
            if (context == null) {
                return null;
            }
            C4563c b2 = C4563c.b(new hr(str).a(context, "i"));
            String a3 = gn.a(System.currentTimeMillis(), "yyyyMMdd");
            if (b2 == null) {
                b2 = new C4563c("IPV6_CONFIG_NAME", a3, 0);
            }
            if (!a3.equals(b2.b)) {
                b2.a(a3);
                b2.c.set(0);
            }
            e.add(b2);
            return b2;
        }
    }

    private static void a(Context context, String str, C4555a c4555a, JSONObject jSONObject) throws JSONException {
        C4555a.C4556a c4556a = new C4555a.C4556a();
        c4556a.a = false;
        c4556a.b = false;
        c4555a.x = c4556a;
        try {
            String[] split = str.split(";");
            if (split != null && split.length > 0) {
                for (String str2 : split) {
                    if (jSONObject.has(str2)) {
                        c4555a.w.putOpt(str2, jSONObject.get(str2));
                    }
                }
            }
        } catch (Throwable th) {
            C4573ha.a(th, "at", "co");
        }
        if (gn.a(jSONObject, "16H")) {
            c4555a.H = a(jSONObject.getJSONObject("16H").optString("able"), false);
        }
        if (gn.a(jSONObject, "11K")) {
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject("11K");
                c4556a.a = a(jSONObject2.getString("able"), false);
                if (jSONObject2.has("off")) {
                    c4556a.c = jSONObject2.getJSONObject("off");
                }
            } catch (Throwable th2) {
                C4573ha.a(th2, "AuthConfigManager", "loadException");
            }
        }
        if (gn.a(jSONObject, "001")) {
            JSONObject jSONObject3 = jSONObject.getJSONObject("001");
            C4555a.C4559d c4559d = new C4555a.C4559d();
            a(jSONObject3, c4559d);
            c4555a.y = c4559d;
        }
        if (gn.a(jSONObject, "002")) {
            JSONObject jSONObject4 = jSONObject.getJSONObject("002");
            C4555a.C4558c c4558c = new C4555a.C4558c();
            a(jSONObject4, c4558c);
            c4555a.A = c4558c;
        }
        if (gn.a(jSONObject, "14S")) {
            JSONObject jSONObject5 = jSONObject.getJSONObject("14S");
            C4555a.C4558c c4558c2 = new C4555a.C4558c();
            a(jSONObject5, c4558c2);
            c4555a.B = c4558c2;
        }
        a(c4555a, jSONObject);
        if (gn.a(jSONObject, "14Z")) {
            JSONObject jSONObject6 = jSONObject.getJSONObject("14Z");
            C4555a.C4561f c4561f = new C4555a.C4561f();
            a(jSONObject6, c4561f);
            c4555a.G = c4561f;
        }
        if (gn.a(jSONObject, "151")) {
            JSONObject jSONObject7 = jSONObject.getJSONObject("151");
            C4555a.C4560e c4560e = new C4555a.C4560e();
            a(jSONObject7, c4560e);
            c4555a.z = c4560e;
        }
        if (gn.a(jSONObject, "17S")) {
            b(context, jSONObject.getJSONObject("17S"));
        }
        a(c4555a, jSONObject);
    }

    private static String a(byte[] bArr) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        byte[] bArr2 = new byte[16];
        byte[] bArr3 = new byte[bArr.length - 16];
        System.arraycopy(bArr, 0, bArr2, 0, 16);
        System.arraycopy(bArr, 16, bArr3, 0, bArr.length - 16);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKeySpec, new IvParameterSpec(gn.c()));
        return gn.a(cipher.doFinal(bArr3));
    }

    private static void a(Context context, gm gmVar, Throwable th) {
        a(context, gmVar, th != null ? th.getMessage() : "on exception");
    }

    public static void a(String str, boolean z, boolean z2, boolean z3, long j) {
        if (TextUtils.isEmpty(str) || c == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        hashMap.put("downLevel", String.valueOf(z2));
        hashMap.put("ant", gg.r(c) == 0 ? "0" : "1");
        hashMap.put("type", z ? "6" : "4");
        hashMap.put("status", z3 ? "0" : "1");
        hashMap.put("duration", "" + j);
        String jSONObject = new JSONObject(hashMap).toString();
        if (TextUtils.isEmpty(jSONObject)) {
            return;
        }
        try {
            is isVar = new is(c, StatServices.CATEGORY, "1.0", "O002");
            isVar.a(jSONObject);
            it.a(isVar, c);
        } catch (gb unused) {
        }
    }

    private static void a(Context context, gm gmVar, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("amap_sdk_auth_fail", "1");
        hashMap.put("amap_sdk_auth_fail_type", str);
        hashMap.put("amap_sdk_name", gmVar.a());
        hashMap.put("amap_sdk_version", gmVar.c());
        String jSONObject = new JSONObject(hashMap).toString();
        if (TextUtils.isEmpty(jSONObject)) {
            return;
        }
        try {
            is isVar = new is(context, StatServices.CATEGORY, "1.0", "O001");
            isVar.a(jSONObject);
            it.a(isVar, context);
        } catch (gb unused) {
        }
    }

    private static void a(Context context, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("15K");
            boolean a2 = a(jSONObject2.optString("isTargetAble"), false);
            if (!a(jSONObject2.optString("able"), false)) {
                gi.a().b(context);
            } else {
                gi.a().a(context, a2);
            }
        } catch (Throwable unused) {
        }
    }

    public static String a(JSONObject jSONObject, String str) throws JSONException {
        return (jSONObject == null || !jSONObject.has(str) || jSONObject.getString(str).equals("[]")) ? "" : jSONObject.optString(str);
    }

    private static void a(JSONObject jSONObject, C4555a.C4557b c4557b) {
        if (c4557b != null) {
            try {
                String a2 = a(jSONObject, WXComponent.PROP_FS_MATCH_PARENT);
                String a3 = a(jSONObject, IRequestConst.U);
                String a4 = a(jSONObject, "v");
                String a5 = a(jSONObject, "able");
                String a6 = a(jSONObject, "on");
                c4557b.c = a2;
                c4557b.b = a3;
                c4557b.d = a4;
                c4557b.a = a(a5, false);
                c4557b.e = a(a6, true);
            } catch (Throwable th) {
                C4573ha.a(th, "at", "pe");
            }
        }
    }

    private static void a(JSONObject jSONObject, C4555a.C4561f c4561f) {
        if (c4561f != null) {
            try {
                String a2 = a(jSONObject, "md5");
                String a3 = a(jSONObject, "md5info");
                String a4 = a(jSONObject, "url");
                String a5 = a(jSONObject, "able");
                String a6 = a(jSONObject, "on");
                String a7 = a(jSONObject, "mobileable");
                c4561f.e = a2;
                c4561f.f = a3;
                c4561f.d = a4;
                c4561f.a = a(a5, false);
                c4561f.b = a(a6, false);
                c4561f.c = a(a7, false);
            } catch (Throwable th) {
                C4573ha.a(th, "at", "pes");
            }
        }
    }

    private static void a(JSONObject jSONObject, C4555a.C4558c c4558c) {
        if (jSONObject != null) {
            try {
                String a2 = a(jSONObject, "md5");
                String a3 = a(jSONObject, "url");
                c4558c.b = a2;
                c4558c.a = a3;
            } catch (Throwable th) {
                C4573ha.a(th, "at", "psc");
            }
        }
    }

    private static void a(JSONObject jSONObject, C4555a.C4559d c4559d) {
        if (jSONObject != null) {
            try {
                String a2 = a(jSONObject, "md5");
                String a3 = a(jSONObject, "url");
                String a4 = a(jSONObject, "sdkversion");
                if (!TextUtils.isEmpty(a2) && !TextUtils.isEmpty(a3) && !TextUtils.isEmpty(a4)) {
                    c4559d.a = a3;
                    c4559d.b = a2;
                    c4559d.c = a4;
                }
            } catch (Throwable th) {
                C4573ha.a(th, "at", "psu");
            }
        }
    }

    private static void a(JSONObject jSONObject, C4555a.C4560e c4560e) {
        if (c4560e == null || jSONObject == null) {
            return;
        }
        c4560e.a = a(jSONObject.optString("able"), false);
    }

    private static void a(C4555a c4555a, JSONObject jSONObject) {
        try {
            if (gn.a(jSONObject, "11B")) {
                c4555a.h = jSONObject.getJSONObject("11B");
            }
            if (gn.a(jSONObject, "11C")) {
                c4555a.k = jSONObject.getJSONObject("11C");
            }
            if (gn.a(jSONObject, "11I")) {
                c4555a.l = jSONObject.getJSONObject("11I");
            }
            if (gn.a(jSONObject, "11H")) {
                c4555a.m = jSONObject.getJSONObject("11H");
            }
            if (gn.a(jSONObject, "11E")) {
                c4555a.n = jSONObject.getJSONObject("11E");
            }
            if (gn.a(jSONObject, "11F")) {
                c4555a.o = jSONObject.getJSONObject("11F");
            }
            if (gn.a(jSONObject, "13A")) {
                c4555a.q = jSONObject.getJSONObject("13A");
            }
            if (gn.a(jSONObject, "13J")) {
                c4555a.i = jSONObject.getJSONObject("13J");
            }
            if (gn.a(jSONObject, "11G")) {
                c4555a.p = jSONObject.getJSONObject("11G");
            }
            if (gn.a(jSONObject, "006")) {
                c4555a.r = jSONObject.getJSONObject("006");
            }
            if (gn.a(jSONObject, "010")) {
                c4555a.s = jSONObject.getJSONObject("010");
            }
            if (gn.a(jSONObject, "11Z")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("11Z");
                C4555a.C4557b c4557b = new C4555a.C4557b();
                a(jSONObject2, c4557b);
                c4555a.C = c4557b;
            }
            if (gn.a(jSONObject, "135")) {
                c4555a.j = jSONObject.getJSONObject("135");
            }
            if (gn.a(jSONObject, "13S")) {
                c4555a.g = jSONObject.getJSONObject("13S");
            }
            if (gn.a(jSONObject, "121")) {
                JSONObject jSONObject3 = jSONObject.getJSONObject("121");
                C4555a.C4557b c4557b2 = new C4555a.C4557b();
                a(jSONObject3, c4557b2);
                c4555a.D = c4557b2;
            }
            if (gn.a(jSONObject, "122")) {
                JSONObject jSONObject4 = jSONObject.getJSONObject("122");
                C4555a.C4557b c4557b3 = new C4555a.C4557b();
                a(jSONObject4, c4557b3);
                c4555a.E = c4557b3;
            }
            if (gn.a(jSONObject, "123")) {
                JSONObject jSONObject5 = jSONObject.getJSONObject("123");
                C4555a.C4557b c4557b4 = new C4555a.C4557b();
                a(jSONObject5, c4557b4);
                c4555a.F = c4557b4;
            }
            if (gn.a(jSONObject, "011")) {
                c4555a.c = jSONObject.getJSONObject("011");
            }
            if (gn.a(jSONObject, "012")) {
                c4555a.d = jSONObject.getJSONObject("012");
            }
            if (gn.a(jSONObject, "013")) {
                c4555a.e = jSONObject.getJSONObject("013");
            }
            if (gn.a(jSONObject, "014")) {
                c4555a.f = jSONObject.getJSONObject("014");
            }
            if (gn.a(jSONObject, "145")) {
                c4555a.t = jSONObject.getJSONObject("145");
            }
            if (gn.a(jSONObject, "14B")) {
                c4555a.u = jSONObject.getJSONObject("14B");
            }
            if (gn.a(jSONObject, "14D")) {
                c4555a.v = jSONObject.getJSONObject("14D");
            }
        } catch (Throwable th) {
            hd.c(th, "at", "pe");
        }
    }

    public static boolean a() {
        C4563c b2;
        if (c != null) {
            b();
            if (!d()) {
                return false;
            }
            if (c()) {
                return true;
            }
        }
        return d && (b2 = b(c, "IPV6_CONFIG_NAME")) != null && b2.a() < 5;
    }

    private static boolean a(InetAddress inetAddress) {
        return inetAddress.isLoopbackAddress() || inetAddress.isLinkLocalAddress() || inetAddress.isAnyLocalAddress();
    }

    public static void a(int i) {
        if (i != 2) {
            return;
        }
        try {
            e();
        } catch (Throwable unused) {
        }
    }

    private static void a(Context context, boolean z) {
        if (context == null) {
            return;
        }
        new hr("IPV6_CONFIG_NAME").a(context, "k", z);
    }

    private static void a(Context context, C4563c c4563c) {
        if (c4563c == null || TextUtils.isEmpty(c4563c.a)) {
            return;
        }
        String b2 = c4563c.b();
        if (TextUtils.isEmpty(b2) || context == null) {
            return;
        }
        new hr("IPV6_CONFIG_NAME").a(context, "i", b2);
    }

    private static C4563c a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (int i = 0; i < e.size(); i++) {
            C4563c c4563c = e.get(i);
            if (c4563c != null && str.equals(c4563c.a)) {
                return c4563c;
            }
        }
        return null;
    }
}
