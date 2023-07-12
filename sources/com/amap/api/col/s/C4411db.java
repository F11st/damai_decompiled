package com.amap.api.col.s;

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
import tb.jn1;

/* compiled from: Taobao */
/* renamed from: com.amap.api.col.s.db */
/* loaded from: classes10.dex */
public final class C4411db {
    public static volatile ConcurrentHashMap<String, C4414c> a = new ConcurrentHashMap<>(8);
    public static volatile List<String> b = Collections.synchronizedList(new ArrayList(8));
    private static volatile ConcurrentHashMap<String, C4413b> c = new ConcurrentHashMap<>(8);
    private static Random d = new Random();
    private static ConcurrentHashMap<String, String> e = new ConcurrentHashMap<>(8);
    private static List<dl> f = Collections.synchronizedList(new ArrayList(16));

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.amap.api.col.s.db$a */
    /* loaded from: classes10.dex */
    public static class C4412a {
        String a;
        int b;
        double c;

        private C4412a() {
        }

        /* synthetic */ C4412a(byte b) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.amap.api.col.s.db$b */
    /* loaded from: classes10.dex */
    public static class C4413b {
        dg a;
        long b;

        private C4413b() {
        }

        /* synthetic */ C4413b(byte b) {
            this();
        }
    }

    public static synchronized void a(bv bvVar, JSONObject jSONObject) {
        synchronized (C4411db.class) {
            if (bvVar == null) {
                return;
            }
            try {
                String b2 = bvVar.b();
                if (TextUtils.isEmpty(b2)) {
                    return;
                }
                if (jSONObject == null) {
                    a(b2);
                }
                if (!bl.a(jSONObject.optString("able", null), false)) {
                    a(b2);
                    return;
                }
                co.a(bl.c, "Yb3Blbl9odHRwX2NvbnRyb2w", b2, jSONObject.toString());
                a(b2, jSONObject);
            } catch (Throwable th) {
                ci.a(th, "hlUtil", "par");
            }
        }
    }

    public static dg b(String str, String str2) {
        Uri parse;
        if (c == null) {
            return null;
        }
        if (c.containsKey("app")) {
            C4413b c4413b = c.get("app");
            if (SystemClock.elapsedRealtime() <= c4413b.b) {
                dg dgVar = c4413b.a;
                if (dgVar != null) {
                    dgVar.e = false;
                }
                a(true, str2, str, 1);
                return dgVar;
            }
            c.remove("app");
        } else if (!TextUtils.isEmpty(str) && (parse = Uri.parse(str)) != null) {
            String path = parse.getPath();
            if (c.containsKey(path)) {
                C4413b c4413b2 = c.get(path);
                if (SystemClock.elapsedRealtime() <= c4413b2.b) {
                    dg dgVar2 = c4413b2.a;
                    if (dgVar2 != null) {
                        dgVar2.e = false;
                    }
                    a(true, str2, str, 2);
                    return dgVar2;
                }
                c.remove(path);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.amap.api.col.s.db$c */
    /* loaded from: classes10.dex */
    public static class C4414c {
        Map<String, List<C4412a>> a;
        Map<String, String> b;

        private C4414c() {
            this.a = new HashMap(8);
            this.b = new HashMap(8);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && C4414c.class == obj.getClass()) {
                C4414c c4414c = (C4414c) obj;
                if (this.a.equals(c4414c.a) && this.b.equals(c4414c.b)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            Map<String, List<C4412a>> map = this.a;
            int hashCode = map != null ? map.hashCode() : 0;
            Map<String, String> map2 = this.b;
            return hashCode + (map2 != null ? map2.hashCode() : 0);
        }

        /* synthetic */ C4414c(byte b) {
            this();
        }
    }

    private static void a(String str, JSONObject jSONObject) {
        try {
            C4414c c4414c = new C4414c((byte) 0);
            a(c4414c, jSONObject);
            b(c4414c, jSONObject);
            if (c4414c.b == null && c4414c.a == null) {
                a(str);
            } else {
                a(str, c4414c);
            }
        } catch (Throwable unused) {
        }
    }

    private static void b(C4414c c4414c, JSONObject jSONObject) {
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
            c4414c.b = hashMap;
        } catch (Throwable th) {
            ci.a(th, "hlUtil", "pdr");
        }
    }

    public static synchronized String a(String str, String str2) throws bj {
        synchronized (C4411db.class) {
            try {
                try {
                    System.currentTimeMillis();
                    if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                        Context context = bl.c;
                        if (b == null) {
                            b = Collections.synchronizedList(new ArrayList(8));
                        }
                        if (context != null && !b.contains(str2)) {
                            b.add(str2);
                            String a2 = co.a(context, "Yb3Blbl9odHRwX2NvbnRyb2w", str2);
                            if (!TextUtils.isEmpty(a2)) {
                                a(str2, new JSONObject(a2));
                            }
                        }
                        if (a != null && a.size() > 0) {
                            if (a.containsKey(str2)) {
                                C4414c c4414c = a.get(str2);
                                if (c4414c == null) {
                                    return str;
                                }
                                if (!a(str, c4414c, str2)) {
                                    return b(str, c4414c, str2);
                                }
                                throw new bj("服务QPS超限");
                            }
                            return str;
                        }
                        return str;
                    }
                    return str;
                } catch (bj e2) {
                    throw e2;
                } catch (Throwable th) {
                    ci.a(th, "hlUtil", "pcr");
                    return str;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private static String b(String str, C4414c c4414c, String str2) {
        try {
            Map<String, String> map = c4414c.b;
            if (map != null && map.size() > 0) {
                Uri parse = Uri.parse(str);
                String authority = parse.getAuthority();
                if (map.containsKey(authority)) {
                    String str3 = map.get(authority);
                    str = parse.buildUpon().authority(str3).toString();
                    a(str2, authority, str3);
                    return str;
                }
                return str;
            }
            return str;
        } catch (Throwable th) {
            ci.a(th, "hlUtil", "pdr");
            return str;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0028 -> B:16:0x0024). Please submit an issue!!! */
    private static List<dl> b() {
        ArrayList arrayList;
        Throwable th;
        ArrayList arrayList2 = null;
        try {
            synchronized (f) {
                try {
                    List<dl> list = f;
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

    public static void a(URL url, dg dgVar) {
        List<String> list;
        try {
            if (c == null) {
                c = new ConcurrentHashMap<>(8);
            }
            Map<String, List<String>> map = dgVar.b;
            if (map != null && map.containsKey("nb") && (list = dgVar.b.get("nb")) != null && list.size() > 0) {
                String[] split = list.get(0).split(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                if (split.length < 2) {
                    return;
                }
                int parseInt = Integer.parseInt(split[0]);
                long parseInt2 = Integer.parseInt(split[1]);
                C4413b c4413b = new C4413b((byte) 0);
                c4413b.a = dgVar;
                if (parseInt2 <= 0) {
                    parseInt2 = 30;
                }
                c4413b.b = SystemClock.elapsedRealtime() + (parseInt2 * 1000);
                if (parseInt == 1) {
                    c.put("app", c4413b);
                } else if (parseInt != 2 || url == null) {
                } else {
                    c.put(url.getPath(), c4413b);
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static void a(String str, C4414c c4414c) {
        try {
            if (a == null) {
                a = new ConcurrentHashMap<>(8);
            }
            a.put(str, c4414c);
        } catch (Throwable th) {
            ci.a(th, "hlUtil", "ucr");
        }
    }

    private static void a(C4414c c4414c, JSONObject jSONObject) {
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
                                C4412a c4412a = new C4412a((byte) 0);
                                c4412a.a = optJSONObject2.optString(OnePlayTrack.PlayType.BEGIN);
                                c4412a.b = optJSONObject2.optInt("duration");
                                c4412a.c = optJSONObject2.optDouble("percent");
                                arrayList.add(c4412a);
                            }
                        }
                        hashMap.put(optString, arrayList);
                    }
                }
            }
            c4414c.a = hashMap;
        } catch (Throwable th) {
            ci.a(th, "hlUtil", "pbr");
        }
    }

    private static synchronized void a(String str) {
        synchronized (C4411db.class) {
            try {
                if (a.containsKey(str)) {
                    a.remove(str);
                }
                SharedPreferences.Editor a2 = co.a(bl.c, "Yb3Blbl9odHRwX2NvbnRyb2w");
                co.a(a2, str);
                co.a(a2);
            } catch (Throwable th) {
                ci.a(th, "hlUtil", "rc");
            }
        }
    }

    private static boolean a(String str, C4414c c4414c, String str2) {
        Map<String, List<C4412a>> map;
        try {
            map = c4414c.a;
        } catch (Throwable th) {
            ci.a(th, "hlUtil", "inb");
        }
        if (map != null && map.size() > 0) {
            if (map.containsKey(jn1.MUL)) {
                for (Map.Entry<String, List<C4412a>> entry : map.entrySet()) {
                    if (a(entry.getValue())) {
                        a(false, str2, str, 1);
                        return true;
                    }
                }
            } else {
                String path = Uri.parse(str).getPath();
                if (map.containsKey(path) && a(map.get(path))) {
                    a(false, str2, str, 2);
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private static boolean a(List<C4412a> list) {
        if (list != null && list.size() > 0) {
            for (C4412a c4412a : list) {
                if (a(c4412a)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean a(C4412a c4412a) {
        if (c4412a == null || c4412a.c == 1.0d) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (!TextUtils.isEmpty(c4412a.a) && c4412a.b > 0) {
            long timeInMillis = currentTimeMillis - bw.a(c4412a.a, "HH:mm:ss").getTimeInMillis();
            if (timeInMillis > 0 && timeInMillis < c4412a.b * 1000) {
                if (c4412a.c == 0.0d) {
                    return true;
                }
                if (d == null) {
                    d = new Random();
                }
                d.setSeed(UUID.randomUUID().hashCode() + currentTimeMillis);
                if (d.nextDouble() > c4412a.c) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void a(boolean z, String str) {
        try {
            Context context = bl.c;
            if (context != null && !TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("timestamp", Long.valueOf(System.currentTimeMillis()));
                if (z) {
                    jSONObject.put("type", cf.g);
                } else {
                    jSONObject.put("type", cf.f);
                }
                jSONObject.put("name", str);
                jSONObject.put("version", cf.a(str));
                String jSONObject2 = jSONObject.toString();
                dl dlVar = new dl(context, StatServices.CATEGORY, "2.0", "O005");
                dlVar.a(jSONObject2);
                dm.a(dlVar, context);
            }
        } catch (Throwable unused) {
        }
    }

    private static void a(String str, String str2, String str3) {
        try {
            Context context = bl.c;
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
                    jSONObject.put("type", cf.j);
                    jSONObject.put("name", str);
                    jSONObject.put("version", cf.a(str));
                    jSONObject.put("hostname", str2 + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + str3);
                    String jSONObject2 = jSONObject.toString();
                    if (TextUtils.isEmpty(jSONObject2)) {
                        return;
                    }
                    dl dlVar = new dl(context, StatServices.CATEGORY, "2.0", "O005");
                    dlVar.a(jSONObject2);
                    dm.a(dlVar, context);
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static void a(boolean z, String str, String str2, int i) {
        try {
            Context context = bl.c;
            if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("timestamp", System.currentTimeMillis());
                String a2 = cf.a(str);
                if (z) {
                    jSONObject.put("type", cf.i);
                } else {
                    jSONObject.put("type", cf.h);
                }
                jSONObject.put("name", str);
                jSONObject.put("version", a2);
                jSONObject.put("uri", Uri.parse(str2).getPath());
                jSONObject.put("blockLevel", i);
                String jSONObject2 = jSONObject.toString();
                if (TextUtils.isEmpty(jSONObject2)) {
                    return;
                }
                dl dlVar = new dl(context, StatServices.CATEGORY, "2.0", "O005");
                dlVar.a(jSONObject2);
                if (f == null) {
                    f = Collections.synchronizedList(new ArrayList(16));
                }
                synchronized (f) {
                    f.add(dlVar);
                    if (f.size() >= 15) {
                        a();
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void a() {
        try {
            Context context = bl.c;
            if (context == null) {
                return;
            }
            dm.a(b(), context);
        } catch (Throwable unused) {
        }
    }
}
