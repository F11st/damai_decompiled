package com.amap.api.col.s;

import android.text.TextUtils;
import com.amap.api.col.s.cz;
import java.net.Proxy;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class df {
    private String d;
    private boolean e;
    private boolean f;
    cz.a j;
    int g = 20000;
    int h = 20000;
    Proxy i = null;
    private boolean a = false;
    private int b = 20000;
    private boolean c = true;
    private a k = a.NORMAL;
    private b l = b.FIRST_NONDEGRADE;

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

    private String a(String str) {
        byte[] g = g();
        if (g == null || g.length == 0) {
            return str;
        }
        Map<String, String> e = e();
        HashMap<String, String> hashMap = cz.e;
        if (hashMap != null) {
            if (e != null) {
                e.putAll(hashMap);
            } else {
                e = hashMap;
            }
        }
        if (e == null) {
            return str;
        }
        String a2 = dc.a(e);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append("?");
        stringBuffer.append(a2);
        return stringBuffer.toString();
    }

    public final void b(int i) {
        this.h = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean b_() {
        return this.c;
    }

    public String c() {
        return "";
    }

    public final void c(int i) {
        this.b = i;
    }

    public final void d(String str) {
        this.d = str;
    }

    public abstract Map<String, String> e();

    public abstract Map<String, String> f();

    public byte[] g() {
        return null;
    }

    public abstract String h();

    /* JADX INFO: Access modifiers changed from: protected */
    public String i() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String k() {
        return a(h());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String l() {
        return a(a());
    }

    public final int m() {
        return this.g;
    }

    public final Proxy n() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final a o() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean p() {
        return this.a;
    }

    public final void q() {
        this.a = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean r() {
        return this.f;
    }

    public final cz.a s() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final b t() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int u() {
        return this.b;
    }

    public final void v() {
        this.c = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String w() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean x() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String y() {
        String str;
        try {
            str = c();
        } catch (Throwable th) {
            th = th;
            str = "";
        }
        try {
            if (TextUtils.isEmpty(str)) {
                if (this.a) {
                    str = b(((da) this).j());
                } else {
                    str = a(f());
                }
            }
        } catch (Throwable th2) {
            th = th2;
            ci.a(th, "ht", "pnfr");
            return str;
        }
        return str;
    }

    private static String b(String str) {
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
                            if (!TextUtils.isEmpty(str4) && TextUtils.isEmpty(cf.a(str3))) {
                                String[] split3 = str4.split("=");
                                if (split3.length > 1) {
                                    cf.a(str3, split3[1].trim());
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            ci.a(th, "ht", "pnfp");
        }
        return str3;
    }

    public String a() {
        return h();
    }

    public final void a(int i) {
        this.g = i;
    }

    public final void a(a aVar) {
        this.k = aVar;
    }

    public final void a(c cVar) {
        this.f = cVar == c.HTTPS;
    }

    public final void a(b bVar) {
        this.l = bVar;
    }

    private static String a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        try {
            if (map.containsKey("platinfo")) {
                return b(map.get("platinfo"));
            }
            return null;
        } catch (Throwable th) {
            ci.a(th, "ht", "pnfh");
            return null;
        }
    }
}
