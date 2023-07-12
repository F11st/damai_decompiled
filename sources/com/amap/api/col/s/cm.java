package com.amap.api.col.s;

import android.content.Context;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class cm {
    private static WeakReference<dh> a = null;
    private static boolean b = true;
    private static WeakReference<ea> c;
    private static WeakReference<ea> d;
    private static String[] e = new String[10];
    private static int f;
    private static boolean g;
    private static int h;
    private static bv i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(Context context) {
        dy dyVar = new dy(b);
        b = false;
        a(context, dyVar, cj.c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(Context context) {
        WeakReference<ea> weakReference = c;
        if (weakReference == null || weakReference.get() == null) {
            c = new WeakReference<>(new dz(context, 3600000, "hKey", new eb(context)));
        }
        a(context, c.get(), cj.d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(Context context) {
        WeakReference<ea> weakReference = d;
        if (weakReference == null || weakReference.get() == null) {
            d = new WeakReference<>(new dz(context, 3600000, "gKey", new eb(context)));
        }
        a(context, d.get(), cj.b);
    }

    private static boolean a(bv bvVar) {
        return bvVar != null && bvVar.f();
    }

    private static void a(Context context, bv bvVar, int i2, String str, String str2) {
        String str3;
        String a2 = dn.a();
        String a3 = dn.a(context, bvVar);
        bk.a(context);
        String a4 = dn.a(a3, a2, i2, str, str2);
        if (a4 == null || "".equals(a4)) {
            return;
        }
        String b2 = bs.b(str2);
        if (i2 == 1) {
            str3 = cj.b;
        } else if (i2 == 2) {
            str3 = cj.d;
        } else if (i2 != 0) {
            return;
        } else {
            str3 = cj.c;
        }
        String str4 = str3;
        dh a5 = dn.a(a);
        dn.a(context, a5, str4, 1000, 4096000, "1");
        if (a5.e == null) {
            a5.e = new cq(new cr(new ct(new cu())));
        }
        try {
            di.a(b2, bw.a(a4.replaceAll(StringUtils.LF, "<br/>")), a5);
        } catch (Throwable unused) {
        }
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
            cl.c(th, "alg", "gLI");
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context) {
        String a2;
        bv bvVar;
        List<bv> a3 = cj.a();
        if (a3 == null || a3.size() == 0 || (a2 = a(a3)) == null || "".equals(a2) || (bvVar = i) == null) {
            return;
        }
        a(context, bvVar, 2, "ANR", a2);
    }

    public static void a(Context context, Throwable th, int i2, String str, String str2) {
        String a2 = bw.a(th);
        bv a3 = a(a2);
        if (a(a3)) {
            String replaceAll = a2.replaceAll(StringUtils.LF, "<br/>");
            String th2 = th.toString();
            if (th2 == null || "".equals(th2)) {
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
                sb.append("$<br/>");
            }
            sb.append(replaceAll);
            a(context, a3, i2, th2, sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(bv bvVar, Context context, String str, String str2) {
        if (!a(bvVar) || str == null || "".equals(str)) {
            return;
        }
        a(context, bvVar, 1, str, str2);
    }

    private static void a(final Context context, final ea eaVar, final String str) {
        ed.a().b(new ee() { // from class: com.amap.api.col.s.cm.1
            @Override // com.amap.api.col.s.ee
            public final void a() {
                try {
                    synchronized (cm.class) {
                        dh a2 = dn.a(cm.a);
                        dn.a(context, a2, str, 1000, 4096000, "1");
                        a2.f = eaVar;
                        if (a2.g == null) {
                            a2.g = new dr(new dq(context, new dv(), new cr(new ct(new cu())), "QImtleSI6IiVzIiwicGxhdGZvcm0iOiJhbmRyb2lkIiwiZGl1IjoiJXMiLCJhZGl1IjoiJXMiLCJwa2ciOiIlcyIsIm1vZGVsIjoiJXMiLCJhcHBuYW1lIjoiJXMiLCJhcHB2ZXJzaW9uIjoiJXMiLCJzeXN2ZXJzaW9uIjoiJXMi", bk.f(context), bo.r(context), bo.q(context), bk.c(context), Build.getMODEL(), bk.b(context), bk.d(context), Build.VERSION.getRELEASE()));
                        }
                        a2.h = 3600000;
                        di.a(a2);
                    }
                } catch (Throwable th) {
                    cl.c(th, "lg", "pul");
                }
            }
        });
    }

    private static bv a(String str) {
        List<bv> a2 = cj.a();
        if (a2 == null) {
            a2 = new ArrayList();
        }
        if (str != null && !"".equals(str)) {
            for (bv bvVar : a2) {
                if (cj.a(bvVar.g(), str)) {
                    return bvVar;
                }
            }
            if (str.contains("com.amap.api.col")) {
                try {
                    return bw.a();
                } catch (bj e2) {
                    e2.printStackTrace();
                }
            }
            if (str.contains("com.amap.co") || str.contains("com.amap.opensdk.co") || str.contains("com.amap.location")) {
                try {
                    bv b2 = bw.b();
                    b2.a();
                    return b2;
                } catch (bj e3) {
                    e3.printStackTrace();
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:89:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00ff A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x00b0 -> B:104:0x00f6). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(java.util.List<com.amap.api.col.s.bv> r11) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.s.cm.a(java.util.List):java.lang.String");
    }
}
