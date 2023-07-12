package com.loc;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alimm.xadsdk.base.ut.AdUtConstants;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.loc.m;
import io.flutter.wpkbridge.U4WPKAdapter;
import java.util.ArrayList;
import org.apache.commons.lang3.time.DateUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import tb.a83;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class i1 {
    private static String A = null;
    private static long B = 0;
    public static boolean C = false;
    public static boolean D = false;
    public static int E = 0;
    public static int F = 0;
    private static volatile boolean a = false;
    private static boolean b = true;
    private static int c = 1000;
    private static int d = 200;
    private static boolean e = false;
    private static int f = 20;
    private static int g;
    private static volatile int h;
    private static volatile boolean i;
    private static boolean j;
    private static long k;
    private static boolean l;
    private static double m;
    private static boolean n;
    private static int o;
    static long p;
    private static boolean q;
    private static boolean r;
    static boolean s;
    private static boolean t;
    private static long u;
    private static boolean v;
    private static int w;
    private static boolean x;
    private static int y;
    private static boolean z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class a implements m.a {
        final /* synthetic */ Context a;

        a(Context context) {
            this.a = context;
        }

        @Override // com.loc.m.a
        public final void a(m.b bVar) {
            i1.g(this.a, bVar);
        }
    }

    static {
        new ArrayList();
        new ArrayList();
        i = false;
        j = true;
        k = 300000L;
        l = false;
        m = 0.618d;
        n = true;
        o = 80;
        p = DateUtils.MILLIS_PER_HOUR;
        q = true;
        r = false;
        s = true;
        t = true;
        u = -1L;
        v = true;
        w = 1;
        x = false;
        y = 5;
        z = false;
        A = "CMjAzLjEwNy4xLjEvMTU0MDgxL2Q";
        B = 0L;
        C = false;
        D = false;
        E = 20480;
        F = 10800000;
    }

    public static boolean A() {
        return r;
    }

    public static boolean B() {
        return s;
    }

    public static boolean C() {
        return t;
    }

    public static long D() {
        return u;
    }

    public static boolean E() {
        return z;
    }

    public static boolean F() {
        return x;
    }

    public static String G() {
        return v1.v(A);
    }

    public static boolean H() {
        return v && w > 0;
    }

    public static int I() {
        return w;
    }

    public static long J() {
        return B;
    }

    public static void a(Context context) {
        if (a) {
            return;
        }
        a = true;
        m.e(context, j1.q(), j1.s(), new a(context));
    }

    private static void b(Context context, JSONObject jSONObject, SharedPreferences.Editor editor) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("13S");
            if (optJSONObject != null) {
                long optInt = optJSONObject.optInt("at", 123) * 60 * 1000;
                p = optInt;
                a83.i(editor, "13S_at", optInt);
                p(optJSONObject, editor);
                try {
                    boolean t2 = m.t(optJSONObject.optString("nla"), true);
                    q = t2;
                    a83.k(editor, "13S_nla", t2);
                } catch (Throwable unused) {
                }
                try {
                    boolean t3 = m.t(optJSONObject.optString("asw"), true);
                    t = t3;
                    a83.k(editor, "asw", t3);
                } catch (Throwable unused2) {
                }
                try {
                    JSONArray optJSONArray = optJSONObject.optJSONArray("mlpl");
                    if (optJSONArray == null || optJSONArray.length() <= 0 || context == null) {
                        r = false;
                        a83.g(editor, "13S_mlpl");
                        return;
                    }
                    a83.j(editor, "13S_mlpl", v1.r(optJSONArray.toString()));
                    r = h(context, optJSONArray);
                } catch (Throwable unused3) {
                }
            }
        } catch (Throwable th) {
            j1.h(th, "AuthUtil", "loadConfigAbleStatus");
        }
    }

    private static void c(m.b bVar, SharedPreferences.Editor editor) {
        try {
            m.b.a aVar = bVar.c;
            if (aVar != null) {
                boolean z2 = aVar.a;
                b = z2;
                a83.k(editor, "exception", z2);
                JSONObject jSONObject = aVar.b;
                if (jSONObject != null) {
                    c = jSONObject.optInt("fn", c);
                    int optInt = jSONObject.optInt("mpn", d);
                    d = optInt;
                    if (optInt > 500) {
                        d = 500;
                    }
                    if (d < 30) {
                        d = 30;
                    }
                    e = m.t(jSONObject.optString("igu"), false);
                    f = jSONObject.optInt("ms", f);
                    h = jSONObject.optInt("rot", 0);
                    g = jSONObject.optInt("pms", 0);
                }
                bq.b(c, e, f, g);
                bs.f(e, g);
                a83.h(editor, "fn", c);
                a83.h(editor, "mpn", d);
                a83.k(editor, "igu", e);
                a83.h(editor, "ms", f);
                a83.h(editor, "rot", h);
                a83.h(editor, "pms", g);
            }
        } catch (Throwable th) {
            j1.h(th, "AuthUtil", "loadConfigDataUploadException");
        }
    }

    private static void d(JSONObject jSONObject, SharedPreferences.Editor editor) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("11G");
            if (optJSONObject != null) {
                boolean t2 = m.t(optJSONObject.optString("able"), true);
                j = t2;
                if (t2) {
                    k = optJSONObject.optInt(com.huawei.hms.opendevice.c.a, 300) * 1000;
                }
                l = m.t(optJSONObject.optString("fa"), false);
                m = Math.min(1.0d, Math.max(0.2d, optJSONObject.optDouble("ms", 0.618d)));
                a83.k(editor, AdUtConstants.XAD_UT_ARG_CA, j);
                a83.i(editor, IRequestConst.CT, k);
                a83.k(editor, "11G_fa", l);
                a83.j(editor, "11G_ms", String.valueOf(m));
            }
        } catch (Throwable th) {
            j1.h(th, "AuthUtil", "loadConfigDataCacheAble");
        }
    }

    public static boolean e() {
        return b;
    }

    public static boolean f(long j2) {
        if (j) {
            long g2 = m1.g() - j2;
            long j3 = k;
            return j3 < 0 || g2 < j3;
        }
        return false;
    }

    static boolean g(Context context, m.b bVar) {
        SharedPreferences.Editor editor;
        try {
            editor = a83.c(context, "pref");
            try {
                c(bVar, editor);
                m(context);
                JSONObject jSONObject = bVar.b;
                if (jSONObject == null) {
                    if (editor != null) {
                        try {
                            a83.f(editor);
                        } catch (Throwable unused) {
                        }
                    }
                    return true;
                }
                b(context, jSONObject, editor);
                d(jSONObject, editor);
                n(jSONObject, editor);
                q(jSONObject, editor);
                v(jSONObject, editor);
                s(jSONObject, editor);
                w(jSONObject, editor);
                k(jSONObject, editor);
                if (editor != null) {
                    try {
                        a83.f(editor);
                    } catch (Throwable unused2) {
                    }
                }
                return true;
            } catch (Throwable unused3) {
                if (editor != null) {
                    try {
                        a83.f(editor);
                        return false;
                    } catch (Throwable unused4) {
                        return false;
                    }
                }
                return false;
            }
        } catch (Throwable unused5) {
            editor = null;
        }
    }

    private static boolean h(Context context, JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() > 0 && context != null) {
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        if (m1.F(context, jSONArray.getString(i2))) {
                            return true;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static int i() {
        return d;
    }

    public static void j(Context context) {
        if (i) {
            return;
        }
        i = true;
        try {
            b = a83.l(context, "pref", "exception", b);
            m(context);
        } catch (Throwable th) {
            j1.h(th, "AuthUtil", "loadLastAbleState p1");
        }
        try {
            c = a83.a(context, "pref", "fn", c);
            d = a83.a(context, "pref", "mpn", d);
            e = a83.l(context, "pref", "igu", e);
            f = a83.a(context, "pref", "ms", f);
            h = a83.a(context, "pref", "rot", 0);
            int a2 = a83.a(context, "pref", "pms", 0);
            g = a2;
            bq.b(c, e, f, a2);
            bs.f(e, g);
        } catch (Throwable th2) {
            j1.h(th2, "AuthUtil", "loadLastAbleState p2");
        }
        try {
            j = a83.l(context, "pref", AdUtConstants.XAD_UT_ARG_CA, j);
            k = a83.b(context, "pref", IRequestConst.CT, k);
            l = a83.l(context, "pref", "11G_fa", l);
            double doubleValue = Double.valueOf(a83.e(context, "pref", "11G_ms", String.valueOf(m))).doubleValue();
            m = doubleValue;
            m = Math.max(0.2d, doubleValue);
        } catch (Throwable th3) {
            j1.h(th3, "AuthUtil", "loadLastAbleState p3");
        }
        try {
            s = a83.l(context, "pref", "fr", s);
        } catch (Throwable th4) {
            j1.h(th4, "AuthUtil", "loadLastAbleState p4");
        }
        try {
            t = a83.l(context, "pref", "asw", t);
        } catch (Throwable th5) {
            j1.h(th5, "AuthUtil", "loadLastAbleState p5");
        }
        try {
            u = a83.b(context, "pref", "awsi", u);
        } catch (Throwable th6) {
            j1.h(th6, "AuthUtil", "loadLastAbleState p6");
        }
        try {
            v = a83.l(context, "pref", "15ua", v);
            w = a83.a(context, "pref", "15un", w);
            B = a83.b(context, "pref", "15ust", B);
        } catch (Throwable th7) {
            j1.h(th7, "AuthUtil", "loadLastAbleState p7");
        }
        try {
            x = a83.l(context, "pref", "ok9", x);
            y = a83.a(context, "pref", "ok10", y);
            A = a83.e(context, "pref", "ok11", A);
        } catch (Throwable th8) {
            j1.h(th8, "AuthUtil", "loadLastAbleState p8");
        }
        try {
            C = a83.l(context, "pref", "17ya", false);
            D = a83.l(context, "pref", "17ym", false);
            F = a83.a(context, "pref", "17yi", 2) * 60 * 60 * 1000;
            E = a83.a(context, "pref", "17yx", 100) * 1024;
        } catch (Throwable th9) {
            j1.h(th9, "AuthUtil", "loadLastAbleState p9");
        }
        try {
            m1.B();
            p = a83.b(context, "pref", "13S_at", p);
            q = a83.l(context, "pref", "13S_nla", q);
            n = a83.l(context, "pref", "13J_able", n);
            o = a83.a(context, "pref", "13J_c", o);
        } catch (Throwable th10) {
            j1.h(th10, "AuthUtil", "loadLastAbleState p10");
        }
        m.x(context);
        try {
            String e2 = a83.e(context, "pref", "13S_mlpl", null);
            if (!TextUtils.isEmpty(e2)) {
                r = h(context, new JSONArray(v1.v(e2)));
            }
        } catch (Throwable th11) {
            j1.h(th11, "AuthUtil", "loadLastAbleState p11");
        }
        try {
            boolean l2 = a83.l(context, "pref", "197a", false);
            String e3 = a83.e(context, "pref", "197dv", "");
            String e4 = a83.e(context, "pref", "197tv", "");
            if (l2 && j1.a.equals(e3)) {
                for (String str : j1.b) {
                    if (str.equals(e4)) {
                        j1.a = e4;
                    }
                }
            }
        } catch (Throwable th12) {
            j1.h(th12, "AuthUtil", "loadLastAbleState p12");
        }
    }

    private static void k(JSONObject jSONObject, SharedPreferences.Editor editor) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("197");
            if (jSONObject2 != null) {
                boolean t2 = m.t(jSONObject2.optString("able"), false);
                a83.k(editor, "197a", t2);
                if (t2) {
                    a83.j(editor, "197dv", jSONObject2.optString(com.alipay.sdk.m.s.a.t, ""));
                    a83.j(editor, "197tv", jSONObject2.optString("tv", ""));
                    return;
                }
                a83.j(editor, "197dv", "");
                a83.j(editor, "197tv", "");
            }
        } catch (Throwable unused) {
        }
    }

    public static int l() {
        if (h < 0) {
            h = 0;
        }
        return h;
    }

    public static void m(Context context) {
        try {
            u1 q2 = j1.q();
            q2.c(b);
            an.g(context, q2);
        } catch (Throwable unused) {
        }
    }

    private static void n(JSONObject jSONObject, SharedPreferences.Editor editor) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("13J");
            if (optJSONObject != null) {
                boolean t2 = m.t(optJSONObject.optString("able"), true);
                n = t2;
                if (t2) {
                    o = optJSONObject.optInt(com.huawei.hms.opendevice.c.a, o);
                }
                a83.k(editor, "13J_able", n);
                a83.h(editor, "13J_c", o);
            }
        } catch (Throwable th) {
            j1.h(th, "AuthUtil", "loadConfigDataGpsGeoAble");
        }
    }

    public static long o() {
        return k;
    }

    private static void p(JSONObject jSONObject, SharedPreferences.Editor editor) {
        if (jSONObject == null) {
            return;
        }
        try {
            boolean t2 = m.t(jSONObject.optString("re"), true);
            s = t2;
            a83.k(editor, "fr", t2);
        } catch (Throwable th) {
            j1.h(th, "AuthUtil", "checkReLocationAble");
        }
    }

    private static void q(JSONObject jSONObject, SharedPreferences.Editor editor) {
        JSONArray optJSONArray;
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("15O");
            if (optJSONObject != null) {
                if (m.t(optJSONObject.optString("able"), false) && ((optJSONArray = optJSONObject.optJSONArray("fl")) == null || optJSONArray.length() <= 0 || optJSONArray.toString().contains(Build.getMANUFACTURER()))) {
                    u = optJSONObject.optInt("iv", 30) * 1000;
                } else {
                    u = -1L;
                }
                a83.i(editor, "awsi", u);
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean r() {
        return j;
    }

    private static void s(JSONObject jSONObject, SharedPreferences.Editor editor) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("17Y");
            if (jSONObject2 != null) {
                boolean t2 = m.t(jSONObject2.optString("able"), false);
                C = t2;
                a83.k(editor, "17ya", t2);
                boolean t3 = m.t(jSONObject2.optString("mup"), false);
                D = t3;
                a83.k(editor, "17ym", t3);
                int optInt = jSONObject2.optInt("max", 20);
                if (optInt > 0) {
                    a83.h(editor, "17yx", optInt);
                    E = optInt * 1024;
                }
                int optInt2 = jSONObject2.optInt("inv", 3);
                if (optInt2 > 0) {
                    a83.h(editor, "17yi", optInt2);
                    F = optInt2 * 60 * 60 * 1000;
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean t() {
        return l;
    }

    public static double u() {
        return m;
    }

    private static void v(JSONObject jSONObject, SharedPreferences.Editor editor) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("15U");
            if (optJSONObject != null) {
                boolean t2 = m.t(optJSONObject.optString("able"), true);
                int optInt = optJSONObject.optInt("yn", w);
                B = optJSONObject.optLong("sysTime", B);
                a83.k(editor, "15ua", t2);
                a83.h(editor, "15un", optInt);
                a83.i(editor, "15ust", B);
            }
        } catch (Throwable unused) {
        }
    }

    private static void w(JSONObject jSONObject, SharedPreferences.Editor editor) {
        int parseInt;
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("17J");
            if (optJSONObject != null) {
                boolean t2 = m.t(optJSONObject.optString("able"), false);
                x = t2;
                a83.k(editor, "ok9", t2);
                if (t2) {
                    String optString = optJSONObject.optString("auth");
                    String optString2 = optJSONObject.optString("ht");
                    A = optString2;
                    a83.j(editor, "ok11", optString2);
                    m.t(optString, false);
                    z = m.t(optJSONObject.optString("nr"), false);
                    String optString3 = optJSONObject.optString(U4WPKAdapter.KEY_TM);
                    if (TextUtils.isEmpty(optString3) || (parseInt = Integer.parseInt(optString3)) <= 0 || parseInt >= 20) {
                        return;
                    }
                    y = parseInt;
                    a83.h(editor, "ok10", parseInt);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean x() {
        return n;
    }

    public static int y() {
        return o;
    }

    public static boolean z() {
        return q;
    }
}
