package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class eo {
    private static boolean a;
    private static boolean b;
    private static boolean c;
    private static boolean d;
    private static boolean e;
    private static boolean f;
    private static boolean g;
    private static boolean h;
    private static boolean i;
    private static HashMap<String, Boolean> j = new HashMap<>();

    public static void a(Context context, boolean z) {
        try {
            String a2 = a(z);
            is isVar = new is(context, "3dmap", "7.4.0", "O001");
            isVar.a(a2);
            it.a(isVar, context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void b(Context context, boolean z) {
        if (a) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_stylemap", Integer.valueOf(z ? 1 : 0));
            a(context, "O006", a(hashMap));
            a = true;
        } catch (Throwable unused) {
        }
    }

    public static void c(Context context, boolean z) {
        if (b) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_indoormap", Integer.valueOf(z ? 1 : 0));
            a(context, "O007", a(hashMap));
            b = true;
        } catch (Throwable unused) {
        }
    }

    public static void d(Context context) {
        if (g) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_bzmapreview", 1);
            a(context, "O012", a(hashMap));
            g = true;
        } catch (Throwable unused) {
        }
    }

    public static void e(Context context) {
        if (h) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_wxmapreview", 1);
            a(context, "O013", a(hashMap));
            h = true;
        } catch (Throwable unused) {
        }
    }

    public static void f(Context context) {
        if (f) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_renderfps", 1);
            a(context, "O014", a(hashMap));
            f = true;
        } catch (Throwable unused) {
        }
    }

    public static void g(Context context) {
        if (i) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_buildingoverlay", 1);
            a(context, "O015", a(hashMap));
            i = true;
        } catch (Throwable unused) {
        }
    }

    private static String a(boolean z) {
        try {
            return "{\"Quest\":" + z + "}";
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static void b(Context context) {
        if (d) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_offlinemap", 1);
            a(context, "O010", a(hashMap));
            d = true;
        } catch (Throwable unused) {
        }
    }

    public static void c(Context context) {
        if (e) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_particleoverlay", 1);
            a(context, "O011", a(hashMap));
            e = true;
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context, long j2) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_rendertime", Long.valueOf(j2));
            hashMap.put("amap_3dmap_render_background", 0L);
            a(context, "O005", a(hashMap));
        } catch (Throwable unused) {
        }
    }

    public static synchronized void a(Context context, String str) {
        synchronized (eo.class) {
            if (j != null && !TextUtils.isEmpty(str)) {
                if (j.containsKey(str) && j.get(str).booleanValue()) {
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("amap_3dmap_coordinate", str);
                a(context, "O008", a(hashMap));
                if (!j.containsKey(str)) {
                    j.put(str, Boolean.TRUE);
                }
            }
        }
    }

    public static void a(Context context) {
        if (c) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_heatmap", 1);
            a(context, "O009", a(hashMap));
            c = true;
        } catch (Throwable unused) {
        }
    }

    private static <T> String a(Map<String, T> map) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(jn1.BLOCK_START_STR);
            for (Map.Entry<String, T> entry : map.entrySet()) {
                sb.append("\"" + entry.getKey() + "\":");
                sb.append(entry.getValue());
                sb.append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("}");
            return sb.toString();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static void a(Context context, String str, String str2) {
        if (context == null) {
            return;
        }
        try {
            is isVar = new is(context, "3dmap", "7.4.0", str);
            isVar.a(str2);
            it.a(isVar, context);
        } catch (Throwable unused) {
        }
    }
}
