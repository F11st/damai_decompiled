package com.loc;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import com.youku.live.livesdk.wkit.component.Constants;
import com.youku.vpm.track.OnePlayTrack;
import io.flutter.stat.StatServices;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;
import tb.b43;
import tb.jn1;
import tb.t43;
import tb.w33;
import tb.y33;

/* compiled from: Taobao */
/* renamed from: com.loc.y */
/* loaded from: classes10.dex */
public final class C5900y {
    public static volatile ConcurrentHashMap<String, C5903c> a = new ConcurrentHashMap<>(8);
    public static volatile List<String> b = Collections.synchronizedList(new ArrayList(8));
    private static volatile ConcurrentHashMap<String, C5902b> c = new ConcurrentHashMap<>(8);
    private static Random d = new Random();
    private static ConcurrentHashMap<String, String> e = new ConcurrentHashMap<>(8);
    private static List<C5818d0> f = Collections.synchronizedList(new ArrayList(16));

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.loc.y$a */
    /* loaded from: classes10.dex */
    public static class C5901a {
        String a;
        int b;
        double c;

        private C5901a() {
        }

        /* synthetic */ C5901a(byte b) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.loc.y$b */
    /* loaded from: classes10.dex */
    public static class C5902b {
        t43 a;
        long b;

        private C5902b() {
        }

        /* synthetic */ C5902b(byte b) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.loc.y$c */
    /* loaded from: classes10.dex */
    public static class C5903c {
        Map<String, List<C5901a>> a;
        Map<String, String> b;

        private C5903c() {
            this.a = new HashMap(8);
            this.b = new HashMap(8);
        }

        /* synthetic */ C5903c(byte b) {
            this();
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && C5903c.class == obj.getClass()) {
                C5903c c5903c = (C5903c) obj;
                if (this.a.equals(c5903c.a) && this.b.equals(c5903c.b)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            Map<String, List<C5901a>> map = this.a;
            int hashCode = map != null ? map.hashCode() : 0;
            Map<String, String> map2 = this.b;
            return hashCode + (map2 != null ? map2.hashCode() : 0);
        }
    }

    public static synchronized String a(String str, String str2) throws C5844k {
        synchronized (C5900y.class) {
            try {
                try {
                    System.currentTimeMillis();
                    if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                        Context context = C5849m.g;
                        if (b == null) {
                            b = Collections.synchronizedList(new ArrayList(8));
                        }
                        if (context != null && !b.contains(str2)) {
                            b.add(str2);
                            String c2 = b43.c(context, "Yb3Blbl9odHRwX2NvbnRyb2w", str2);
                            if (!TextUtils.isEmpty(c2)) {
                                h(str2, new JSONObject(c2));
                            }
                        }
                        if (a != null && a.size() > 0) {
                            if (a.containsKey(str2)) {
                                C5903c c5903c = a.get(str2);
                                if (c5903c == null) {
                                    return str;
                                }
                                if (m(str, c5903c, str2)) {
                                    throw new C5844k("服务QPS超限");
                                }
                                return o(str, c5903c, str2);
                            }
                            return str;
                        }
                        return str;
                    }
                    return str;
                } catch (C5844k e2) {
                    throw e2;
                } catch (Throwable th) {
                    y33.e(th, "hlUtil", "pcr");
                    return str;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void b() {
        try {
            Context context = C5849m.g;
            if (context == null) {
                return;
            }
            bs.e(p(), context);
        } catch (Throwable unused) {
        }
    }

    private static void c(C5903c c5903c, JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("block");
            if (optJSONArray == null) {
                return;
            }
            HashMap hashMap = new HashMap(8);
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("api");
                    if (!TextUtils.isEmpty(optString)) {
                        if (!optString.startsWith("/")) {
                            optString = "/".concat(optString);
                        }
                        if (optString.endsWith("/")) {
                            optString = optString.substring(0, optString.length() - 1);
                        }
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray("periods");
                        ArrayList arrayList = new ArrayList();
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i2);
                            if (optJSONObject2 != null) {
                                C5901a c5901a = new C5901a((byte) 0);
                                c5901a.a = optJSONObject2.optString(OnePlayTrack.PlayType.BEGIN);
                                c5901a.b = optJSONObject2.optInt("duration");
                                c5901a.c = optJSONObject2.optDouble("percent");
                                arrayList.add(c5901a);
                            }
                        }
                        hashMap.put(optString, arrayList);
                    }
                }
            }
            c5903c.a = hashMap;
        } catch (Throwable th) {
            y33.e(th, "hlUtil", "pbr");
        }
    }

    public static synchronized void d(u1 u1Var, JSONObject jSONObject) {
        synchronized (C5900y.class) {
            if (u1Var == null) {
                return;
            }
            try {
                String a2 = u1Var.a();
                if (TextUtils.isEmpty(a2)) {
                    return;
                }
                if (jSONObject == null) {
                    e(a2);
                }
                if (!C5849m.t(jSONObject.optString("able", null), false)) {
                    e(a2);
                    return;
                }
                b43.d(C5849m.g, "Yb3Blbl9odHRwX2NvbnRyb2w", a2, jSONObject.toString());
                h(a2, jSONObject);
            } catch (Throwable th) {
                y33.e(th, "hlUtil", "par");
            }
        }
    }

    private static synchronized void e(String str) {
        synchronized (C5900y.class) {
            try {
                if (a.containsKey(str)) {
                    a.remove(str);
                }
                SharedPreferences.Editor b2 = b43.b(C5849m.g, "Yb3Blbl9odHRwX2NvbnRyb2w");
                b43.f(b2, str);
                b43.e(b2);
            } catch (Throwable th) {
                y33.e(th, "hlUtil", "rc");
            }
        }
    }

    private static void f(String str, C5903c c5903c) {
        try {
            if (a == null) {
                a = new ConcurrentHashMap<>(8);
            }
            a.put(str, c5903c);
        } catch (Throwable th) {
            y33.e(th, "hlUtil", "ucr");
        }
    }

    private static void g(String str, String str2, String str3) {
        try {
            Context context = C5849m.g;
            if (context != null && !TextUtils.isEmpty(str)) {
                if (e == null) {
                    e = new ConcurrentHashMap<>(8);
                }
                synchronized (e) {
                    if (e.containsKey(str2)) {
                        return;
                    }
                    e.put(str2, str3);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("timestamp", System.currentTimeMillis());
                    jSONObject.put("type", w33.j);
                    jSONObject.put("name", str);
                    jSONObject.put("version", w33.a(str));
                    jSONObject.put("hostname", str2 + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + str3);
                    String jSONObject2 = jSONObject.toString();
                    if (TextUtils.isEmpty(jSONObject2)) {
                        return;
                    }
                    C5818d0 c5818d0 = new C5818d0(context, StatServices.CATEGORY, "2.0", "O005");
                    c5818d0.a(jSONObject2);
                    bs.d(c5818d0, context);
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static void h(String str, JSONObject jSONObject) {
        try {
            C5903c c5903c = new C5903c((byte) 0);
            c(c5903c, jSONObject);
            r(c5903c, jSONObject);
            if (c5903c.b == null && c5903c.a == null) {
                e(str);
            } else {
                f(str, c5903c);
            }
        } catch (Throwable unused) {
        }
    }

    public static void i(URL url, t43 t43Var) {
        List<String> list;
        try {
            if (c == null) {
                c = new ConcurrentHashMap<>(8);
            }
            Map<String, List<String>> map = t43Var.b;
            if (map != null && map.containsKey("nb") && (list = t43Var.b.get("nb")) != null && list.size() > 0) {
                String[] split = list.get(0).split(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                if (split.length < 2) {
                    return;
                }
                int parseInt = Integer.parseInt(split[0]);
                long parseInt2 = Integer.parseInt(split[1]);
                C5902b c5902b = new C5902b((byte) 0);
                c5902b.a = t43Var;
                if (parseInt2 <= 0) {
                    parseInt2 = 30;
                }
                c5902b.b = SystemClock.elapsedRealtime() + (parseInt2 * 1000);
                if (parseInt == 1) {
                    c.put("app", c5902b);
                } else if (parseInt != 2 || url == null) {
                } else {
                    c.put(url.getPath(), c5902b);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void j(boolean z, String str) {
        try {
            Context context = C5849m.g;
            if (context != null && !TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("timestamp", Long.valueOf(System.currentTimeMillis()));
                jSONObject.put("type", z ? w33.g : w33.f);
                jSONObject.put("name", str);
                jSONObject.put("version", w33.a(str));
                String jSONObject2 = jSONObject.toString();
                C5818d0 c5818d0 = new C5818d0(context, StatServices.CATEGORY, "2.0", "O005");
                c5818d0.a(jSONObject2);
                bs.d(c5818d0, context);
            }
        } catch (Throwable unused) {
        }
    }

    private static void k(boolean z, String str, String str2, int i) {
        String str3;
        Integer num;
        try {
            Context context = C5849m.g;
            if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("timestamp", System.currentTimeMillis());
                String a2 = w33.a(str);
                if (z) {
                    str3 = "type";
                    num = w33.i;
                } else {
                    str3 = "type";
                    num = w33.h;
                }
                jSONObject.put(str3, num);
                jSONObject.put("name", str);
                jSONObject.put("version", a2);
                jSONObject.put("uri", Uri.parse(str2).getPath());
                jSONObject.put("blockLevel", i);
                String jSONObject2 = jSONObject.toString();
                if (TextUtils.isEmpty(jSONObject2)) {
                    return;
                }
                C5818d0 c5818d0 = new C5818d0(context, StatServices.CATEGORY, "2.0", "O005");
                c5818d0.a(jSONObject2);
                if (f == null) {
                    f = Collections.synchronizedList(new ArrayList(16));
                }
                synchronized (f) {
                    f.add(c5818d0);
                    if (f.size() >= 15) {
                        b();
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static boolean l(C5901a c5901a) {
        if (c5901a == null || c5901a.c == 1.0d) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (!TextUtils.isEmpty(c5901a.a) && c5901a.b > 0) {
            long timeInMillis = currentTimeMillis - v1.i(c5901a.a, "HH:mm:ss").getTimeInMillis();
            if (timeInMillis > 0 && timeInMillis < c5901a.b * 1000) {
                if (c5901a.c == 0.0d) {
                    return true;
                }
                if (d == null) {
                    d = new Random();
                }
                d.setSeed(UUID.randomUUID().hashCode() + currentTimeMillis);
                if (d.nextDouble() > c5901a.c) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean m(String str, C5903c c5903c, String str2) {
        Map<String, List<C5901a>> map;
        try {
            map = c5903c.a;
        } catch (Throwable th) {
            y33.e(th, "hlUtil", "inb");
        }
        if (map != null && map.size() > 0) {
            if (map.containsKey(jn1.MUL)) {
                for (Map.Entry<String, List<C5901a>> entry : map.entrySet()) {
                    if (n(entry.getValue())) {
                        k(false, str2, str, 1);
                        return true;
                    }
                }
            } else {
                String path = Uri.parse(str).getPath();
                if (map.containsKey(path) && n(map.get(path))) {
                    k(false, str2, str, 2);
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private static boolean n(List<C5901a> list) {
        if (list != null && list.size() > 0) {
            for (C5901a c5901a : list) {
                if (l(c5901a)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static String o(String str, C5903c c5903c, String str2) {
        try {
            Map<String, String> map = c5903c.b;
            if (map != null && map.size() > 0) {
                Uri parse = Uri.parse(str);
                String authority = parse.getAuthority();
                if (map.containsKey(authority)) {
                    String str3 = map.get(authority);
                    str = parse.buildUpon().authority(str3).toString();
                    g(str2, authority, str3);
                    return str;
                }
                return str;
            }
            return str;
        } catch (Throwable th) {
            y33.e(th, "hlUtil", "pdr");
            return str;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0028 -> B:16:0x0024). Please submit an issue!!! */
    public static List<C5818d0> p() {
        ArrayList arrayList;
        Throwable th;
        ArrayList arrayList2 = null;
        try {
            synchronized (f) {
                try {
                    List<C5818d0> list = f;
                    if (list != null && list.size() > 0) {
                        arrayList = new ArrayList();
                        try {
                            arrayList.addAll(f);
                            f.clear();
                            arrayList2 = arrayList;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                    return arrayList2;
                } catch (Throwable th3) {
                    arrayList = arrayList2;
                    th = th3;
                }
            }
            try {
                throw th;
            } catch (Throwable unused) {
                return arrayList;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static t43 q(String str, String str2) {
        Uri parse;
        String str3 = "app";
        if (c == null) {
            return null;
        }
        if (!c.containsKey("app")) {
            if (!TextUtils.isEmpty(str) && (parse = Uri.parse(str)) != null) {
                str3 = parse.getPath();
                if (c.containsKey(str3)) {
                    C5902b c5902b = c.get(str3);
                    if (SystemClock.elapsedRealtime() <= c5902b.b) {
                        t43 t43Var = c5902b.a;
                        k(true, str2, str, 2);
                        return t43Var;
                    }
                }
            }
            return null;
        }
        C5902b c5902b2 = c.get("app");
        if (SystemClock.elapsedRealtime() <= c5902b2.b) {
            t43 t43Var2 = c5902b2.a;
            k(true, str2, str, 1);
            return t43Var2;
        }
        c.remove(str3);
        return null;
    }

    private static void r(C5903c c5903c, JSONObject jSONObject) {
        JSONArray names;
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("domainMap");
            if (optJSONObject == null || (names = optJSONObject.names()) == null) {
                return;
            }
            HashMap hashMap = new HashMap(8);
            int length = names.length();
            for (int i = 0; i < length; i++) {
                String optString = names.optString(i);
                hashMap.put(optString, optJSONObject.optString(optString));
            }
            c5903c.b = hashMap;
        } catch (Throwable th) {
            y33.e(th, "hlUtil", "pdr");
        }
    }
}
