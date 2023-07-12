package com.loc;

import android.content.Context;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import tb.h53;
import tb.i53;
import tb.j53;
import tb.k53;
import tb.u43;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class ao {
    private static WeakReference<u43> a = null;
    private static boolean b = true;
    private static WeakReference<j53> c;
    private static WeakReference<j53> d;
    private static String[] e = new String[10];
    private static int f;
    private static boolean g;
    private static int h;
    private static u1 i;

    private static u1 a(String str) {
        List<u1> b2 = al.b();
        if (b2 == null) {
            b2 = new ArrayList();
        }
        if (str != null && !"".equals(str)) {
            for (u1 u1Var : b2) {
                if (al.f(u1Var.i(), str)) {
                    return u1Var;
                }
            }
            if (str.contains("com.amap.api.col")) {
                try {
                    return v1.a();
                } catch (C5844k e2) {
                    e2.printStackTrace();
                }
            }
            if (str.contains("com.amap.co") || str.contains("com.amap.opensdk.co") || str.contains("com.amap.location")) {
                try {
                    u1 q = v1.q();
                    q.c(true);
                    return q;
                } catch (C5844k e3) {
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
    private static java.lang.String b(java.util.List<com.loc.u1> r11) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.ao.b(java.util.List):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(Context context) {
        String b2;
        u1 u1Var;
        List<u1> b3 = al.b();
        if (b3 == null || b3.size() == 0 || (b2 = b(b3)) == null || "".equals(b2) || (u1Var = i) == null) {
            return;
        }
        e(context, u1Var, 2, "ANR", b2);
    }

    private static void e(Context context, u1 u1Var, int i2, String str, String str2) {
        String str3;
        String a2 = C5822e0.a();
        String b2 = C5822e0.b(context, u1Var);
        C5846l.a(context);
        String c2 = C5822e0.c(b2, a2, i2, str, str2);
        if (c2 == null || "".equals(c2)) {
            return;
        }
        String d2 = r1.d(str2);
        if (i2 == 1) {
            str3 = al.b;
        } else if (i2 == 2) {
            str3 = al.d;
        } else if (i2 != 0) {
            return;
        } else {
            str3 = al.c;
        }
        String str4 = str3;
        u43 d3 = C5822e0.d(a);
        C5822e0.e(context, d3, str4, 1000, 4096000, "1");
        if (d3.e == null) {
            d3.e = new C5868p(new C5871q(new C5877s(new C5884u())));
        }
        try {
            C5792b0.c(d2, v1.p(c2.replaceAll(StringUtils.LF, "<br/>")), d3);
        } catch (Throwable unused) {
        }
    }

    public static void f(Context context, Throwable th, int i2, String str, String str2) {
        String e2 = v1.e(th);
        u1 a2 = a(e2);
        if (i(a2)) {
            String replaceAll = e2.replaceAll(StringUtils.LF, "<br/>");
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
            e(context, a2, i2, th2, sb.toString());
        }
    }

    private static void g(final Context context, final j53 j53Var, final String str) {
        C5866o0.f().d(new ck() { // from class: com.loc.ao.1
            @Override // com.loc.ck
            public final void a() {
                try {
                    synchronized (ao.class) {
                        u43 d2 = C5822e0.d(ao.a);
                        C5822e0.e(context, d2, str, 1000, 4096000, "1");
                        d2.f = j53Var;
                        if (d2.g == null) {
                            d2.g = new C5840i0(new C5837h0(context, new C5860n0(), new C5871q(new C5877s(new C5884u())), "QImtleSI6IiVzIiwicGxhdGZvcm0iOiJhbmRyb2lkIiwiZGl1IjoiJXMiLCJhZGl1IjoiJXMiLCJwa2ciOiIlcyIsIm1vZGVsIjoiJXMiLCJhcHBuYW1lIjoiJXMiLCJhcHB2ZXJzaW9uIjoiJXMiLCJzeXN2ZXJzaW9uIjoiJXMi", C5846l.j(context), C5861o.h0(context), C5861o.g0(context), C5846l.g(context), Build.getMODEL(), C5846l.e(context), C5846l.h(context), Build.VERSION.getRELEASE()));
                        }
                        d2.h = 3600000;
                        C5792b0.a(d2);
                    }
                } catch (Throwable th) {
                    an.m(th, "lg", "pul");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void h(u1 u1Var, Context context, String str, String str2) {
        if (!i(u1Var) || str == null || "".equals(str)) {
            return;
        }
        e(context, u1Var, 1, str, str2);
    }

    private static boolean i(u1 u1Var) {
        return u1Var != null && u1Var.h();
    }

    private static String j() {
        StringBuilder sb = new StringBuilder();
        try {
            for (int i2 = f; i2 < 10 && i2 <= 9; i2++) {
                sb.append(e[i2]);
            }
            for (int i3 = 0; i3 < f; i3++) {
                sb.append(e[i3]);
            }
        } catch (Throwable th) {
            an.m(th, "alg", "gLI");
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void k(Context context) {
        h53 h53Var = new h53(b);
        b = false;
        g(context, h53Var, al.c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void l(Context context) {
        WeakReference<j53> weakReference = c;
        if (weakReference == null || weakReference.get() == null) {
            c = new WeakReference<>(new i53(context, 3600000, "hKey", new k53(context)));
        }
        g(context, c.get(), al.d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void m(Context context) {
        WeakReference<j53> weakReference = d;
        if (weakReference == null || weakReference.get() == null) {
            d = new WeakReference<>(new i53(context, 3600000, "gKey", new k53(context)));
        }
        g(context, d.get(), al.b);
    }
}
