package com.amap.api.mapcore.util;

import android.content.Context;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class he {
    private static WeakReference<in> a = null;
    private static boolean b = true;
    private static WeakReference<jh> c;
    private static WeakReference<jh> d;
    private static String[] e = new String[10];
    private static int f;
    private static boolean g;
    private static int h;
    private static gm i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(Context context) {
        jf jfVar = new jf(b);
        b = false;
        a(context, jfVar, hb.c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(Context context) {
        WeakReference<jh> weakReference = c;
        if (weakReference == null || weakReference.get() == null) {
            c = new WeakReference<>(new jg(context, 3600000, "hKey", new ji(context, false)));
        }
        a(context, c.get(), hb.d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(Context context) {
        WeakReference<jh> weakReference = d;
        if (weakReference == null || weakReference.get() == null) {
            d = new WeakReference<>(new jg(context, 3600000, "gKey", new ji(context, false)));
        }
        a(context, d.get(), hb.b);
    }

    private static boolean a(gm gmVar) {
        return gmVar != null && gmVar.f();
    }

    private static void a(Context context, gm gmVar, int i2, String str, String str2) {
        String str3;
        String a2 = iu.a();
        String a3 = iu.a(gc.a(context), iu.a(context, gmVar), a2, i2, str, str2);
        if (a3 == null || "".equals(a3)) {
            return;
        }
        String c2 = gk.c(str2);
        if (i2 == 1) {
            str3 = hb.b;
        } else if (i2 == 2) {
            str3 = hb.d;
        } else if (i2 != 0) {
            return;
        } else {
            str3 = hb.c;
        }
        a(context, c2, str3, a3);
    }

    private static String b() {
        StringBuilder sb = new StringBuilder();
        try {
            for (int i2 = f; i2 < 10 && i2 <= 9; i2++) {
                sb.append(e[i2]);
            }
            for (int i3 = 0; i3 < f; i3++) {
                sb.append(e[i3]);
            }
        } catch (Throwable th) {
            hd.c(th, "alg", "gLI");
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context) {
        String a2;
        gm gmVar;
        List<gm> b2 = hb.b(context);
        if (b2 == null || b2.size() == 0 || (a2 = a(b2)) == null || "".equals(a2) || (gmVar = i) == null) {
            return;
        }
        a(context, gmVar, 2, "ANR", a2);
    }

    public static void a(Context context, gm gmVar, String str, int i2, String str2, String str3) {
        if (str2 == null || "".equals(str2)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("class:");
        sb.append(str2);
        if (str3 != null) {
            sb.append(" method:");
            sb.append(str3);
            sb.append("$");
            sb.append("<br/>");
        }
        sb.append(str);
        a(context, gmVar, i2, str2, sb.toString());
    }

    public static void a(Context context, Throwable th, int i2, String str, String str2) {
        String a2 = gn.a(th);
        gm a3 = a(context, a2);
        if (a(a3)) {
            String replaceAll = a2.replaceAll(StringUtils.LF, "<br/>");
            String a4 = a(th);
            if (a4 == null || "".equals(a4)) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            if (str != null) {
                sb.append("class:");
                sb.append(str);
            }
            if (str2 != null) {
                sb.append(" method:");
                sb.append(str2);
                sb.append("$");
                sb.append("<br/>");
            }
            sb.append(replaceAll);
            a(context, a3, i2, a4, sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(gm gmVar, Context context, String str, String str2) {
        if (!a(gmVar) || str == null || "".equals(str)) {
            return;
        }
        a(context, gmVar, 1, str, str2);
    }

    private static void a(Context context, String str, String str2, String str3) {
        in a2 = iu.a(a);
        iu.a(context, a2, str2, 1000, 40960, "1");
        if (a2.e == null) {
            a2.e = new ht(new hu(new hw(new hx())));
        }
        try {
            io.a(str, gn.a(str3.replaceAll(StringUtils.LF, "<br/>")), a2);
        } catch (Throwable unused) {
        }
    }

    private static void a(final Context context, final jh jhVar, final String str) {
        hd.d().submit(new Runnable() { // from class: com.amap.api.mapcore.util.he.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    synchronized (he.class) {
                        in a2 = iu.a(he.a);
                        iu.a(context, a2, str, 1000, 40960, "1");
                        a2.f = jhVar;
                        if (a2.g == null) {
                            a2.g = new iy(new ix(context, new jc(), new hu(new hw(new hx())), "EImtleSI6IiVzIiwicGxhdGZvcm0iOiJhbmRyb2lkIiwiZGl1IjoiJXMiLCJwa2ciOiIlcyIsIm1vZGVsIjoiJXMiLCJhcHBuYW1lIjoiJXMiLCJhcHB2ZXJzaW9uIjoiJXMiLCJzeXN2ZXJzaW9uIjoiJXMiLA=", gc.f(context), gg.w(context), gc.c(context), Build.getMODEL(), gc.b(context), gc.d(context), Build.VERSION.getRELEASE()));
                        }
                        a2.h = 3600000;
                        io.a(a2);
                    }
                } catch (Throwable th) {
                    hd.c(th, "lg", "pul");
                }
            }
        });
    }

    static gm a(Context context, String str) {
        List<gm> b2 = hb.b(context);
        if (b2 == null) {
            b2 = new ArrayList();
        }
        if (str != null && !"".equals(str)) {
            for (gm gmVar : b2) {
                if (hb.a(gmVar.g(), str)) {
                    return gmVar;
                }
            }
            if (str.contains("com.amap.api.col")) {
                try {
                    return gn.a();
                } catch (gb e2) {
                    e2.printStackTrace();
                }
            }
            if (str.contains("com.amap.co") || str.contains("com.amap.opensdk.co") || str.contains("com.amap.location")) {
                try {
                    gm b3 = gn.b();
                    b3.a(true);
                    return b3;
                } catch (gb e3) {
                    e3.printStackTrace();
                }
            }
        }
        return null;
    }

    private static String a(Throwable th) {
        return th.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:82:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00e8 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x0099 -> B:95:0x00df). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static java.lang.String a(java.util.List<com.amap.api.mapcore.util.gm> r10) {
        /*
            Method dump skipped, instructions count: 233
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.he.a(java.util.List):java.lang.String");
    }

    private static void a(String str) {
        try {
            if (f > 9) {
                f = 0;
            }
            String[] strArr = e;
            int i2 = f;
            strArr[i2] = str;
            f = i2 + 1;
        } catch (Throwable th) {
            hd.c(th, "alg", "aDa");
        }
    }
}
