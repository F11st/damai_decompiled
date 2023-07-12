package com.loc;

import android.text.TextUtils;
import com.loc.bg;
import java.net.Proxy;
import java.util.HashMap;
import java.util.Map;
import tb.s43;
import tb.w33;
import tb.y33;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class bl {
    bg.a c;
    private String g;
    private boolean h;
    private boolean i;
    int a = 20000;
    Proxy b = null;
    private boolean d = false;
    private int e = 20000;
    private boolean f = true;
    private a j = a.NORMAL;
    private b k = b.FIRST_NONDEGRADE;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public enum a {
        NORMAL(0),
        INTERRUPT_IO(1),
        NEVER(2),
        FIX(3),
        SINGLE(4);
        
        private int f;

        a(int i) {
            this.f = i;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public enum b {
        FIRST_NONDEGRADE(0),
        NEVER_GRADE(1),
        DEGRADE_BYERROR(2),
        DEGRADE_ONLY(3),
        FIX_NONDEGRADE(4),
        FIX_DEGRADE_BYERROR(5),
        FIX_DEGRADE_ONLY(6);
        
        private int h;

        b(int i2) {
            this.h = i2;
        }

        public final int a() {
            return this.h;
        }

        public final boolean b() {
            int i2 = this.h;
            return i2 == FIRST_NONDEGRADE.h || i2 == NEVER_GRADE.h || i2 == FIX_NONDEGRADE.h;
        }

        public final boolean c() {
            int i2 = this.h;
            return i2 == DEGRADE_BYERROR.h || i2 == DEGRADE_ONLY.h || i2 == FIX_DEGRADE_BYERROR.h || i2 == FIX_DEGRADE_ONLY.h;
        }

        public final boolean d() {
            int i2 = this.h;
            return i2 == DEGRADE_BYERROR.h || i2 == FIX_DEGRADE_BYERROR.h;
        }

        public final boolean e() {
            return this.h == NEVER_GRADE.h;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public enum c {
        HTTP(0),
        HTTPS(1);
        
        private int c;

        c(int i) {
            this.c = i;
        }
    }

    private static String a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        try {
            if (map.containsKey("platinfo")) {
                return n(map.get("platinfo"));
            }
            return null;
        } catch (Throwable th) {
            y33.e(th, "ht", "pnfh");
            return null;
        }
    }

    private String k(String str) {
        byte[] r = r();
        if (r == null || r.length == 0) {
            return str;
        }
        Map<String, String> q = q();
        HashMap<String, String> hashMap = bg.e;
        if (hashMap != null) {
            if (q != null) {
                q.putAll(hashMap);
            } else {
                q = hashMap;
            }
        }
        if (q == null) {
            return str;
        }
        String c2 = bj.c(q);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append("?");
        stringBuffer.append(c2);
        return stringBuffer.toString();
    }

    private static String n(String str) {
        String str2;
        String str3 = "";
        try {
            if (!TextUtils.isEmpty(str)) {
                String[] split = str.split("&");
                if (split.length > 1) {
                    int length = split.length;
                    int i = 0;
                    String str4 = "";
                    while (true) {
                        if (i >= length) {
                            str2 = "";
                            break;
                        }
                        str2 = split[i];
                        if (str2.contains("sdkversion")) {
                            str4 = str2;
                        }
                        if (str2.contains("product")) {
                            break;
                        }
                        i++;
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        String[] split2 = str2.split("=");
                        if (split2.length > 1) {
                            str3 = split2[1].trim();
                            if (!TextUtils.isEmpty(str4) && TextUtils.isEmpty(w33.a(str3))) {
                                String[] split3 = str4.split("=");
                                if (split3.length > 1) {
                                    w33.b(str3, split3[1].trim());
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            y33.e(th, "ht", "pnfp");
        }
        return str3;
    }

    public final void A() {
        this.d = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean B() {
        return this.i;
    }

    public final bg.a C() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final b D() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int E() {
        return this.e;
    }

    public final void F() {
        this.f = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String G() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean H() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String I() {
        String str;
        try {
            str = t();
        } catch (Throwable th) {
            th = th;
            str = "";
        }
        try {
            if (TextUtils.isEmpty(str)) {
                str = this.d ? n(((s43) this).S()) : a(b());
            }
        } catch (Throwable th2) {
            th = th2;
            y33.e(th, "ht", "pnfr");
            return str;
        }
        return str;
    }

    public abstract Map<String, String> b();

    public final void c(int i) {
        this.a = i;
    }

    public final void d(a aVar) {
        this.j = aVar;
    }

    public final void e(b bVar) {
        this.k = bVar;
    }

    public final void f(c cVar) {
        this.i = cVar == c.HTTPS;
    }

    public final void g(String str) {
        this.g = str;
    }

    public final void h(Proxy proxy) {
        this.b = proxy;
    }

    public final void i(boolean z) {
        this.h = z;
    }

    public abstract String j();

    public final void l(int i) {
    }

    public String m() {
        return j();
    }

    public final void o(int i) {
        this.e = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean p() {
        return this.f;
    }

    public abstract Map<String, String> q();

    public abstract byte[] r();

    /* JADX INFO: Access modifiers changed from: protected */
    public String s() {
        return "";
    }

    public String t() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String u() {
        return k(j());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String v() {
        return k(m());
    }

    public final int w() {
        return this.a;
    }

    public final Proxy x() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final a y() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean z() {
        return this.d;
    }
}
