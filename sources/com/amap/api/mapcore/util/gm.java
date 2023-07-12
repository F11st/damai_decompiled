package com.amap.api.mapcore.util;

import android.text.TextUtils;
import com.youku.playerservice.axp.playinfo.Point;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
@hh(a = "a")
/* loaded from: classes10.dex */
public class gm {
    @hi(a = "a1", b = 6)
    private String a;
    @hi(a = "a2", b = 6)
    private String b;
    @hi(a = "a6", b = 2)
    private int c;
    @hi(a = "a3", b = 6)
    private String d;
    @hi(a = "a4", b = 6)
    private String e;
    @hi(a = "a5", b = 6)
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String[] l;

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.gm$a */
    /* loaded from: classes10.dex */
    public static class C4569a {
        private String a;
        private String b;
        private String c;
        private String d;
        private boolean e = true;
        private String f = Point.STANDARD;
        private String[] g = null;

        public C4569a(String str, String str2, String str3) {
            this.a = str2;
            this.b = str2;
            this.d = str3;
            this.c = str;
        }

        public C4569a a(String[] strArr) {
            if (strArr != null) {
                this.g = (String[]) strArr.clone();
            }
            return this;
        }

        public C4569a a(String str) {
            this.b = str;
            return this;
        }

        public gm a() throws gb {
            if (this.g != null) {
                return new gm(this);
            }
            throw new gb("sdk packages is null");
        }
    }

    public static String h() {
        return "a6=1";
    }

    public void a(boolean z) {
        this.c = z ? 1 : 0;
    }

    public String b() {
        return this.g;
    }

    public String c() {
        if (TextUtils.isEmpty(this.h) && !TextUtils.isEmpty(this.b)) {
            this.h = gn.c(this.b);
        }
        return this.h;
    }

    public String d() {
        if (TextUtils.isEmpty(this.i) && !TextUtils.isEmpty(this.d)) {
            this.i = gn.c(this.d);
        }
        return this.i;
    }

    public String e() {
        if (TextUtils.isEmpty(this.k) && !TextUtils.isEmpty(this.f)) {
            this.k = gn.c(this.f);
        }
        if (TextUtils.isEmpty(this.k)) {
            this.k = Point.STANDARD;
        }
        return this.k;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return getClass() == obj.getClass() && hashCode() == ((gm) obj).hashCode();
    }

    public boolean f() {
        return this.c == 1;
    }

    public String[] g() {
        String[] strArr = this.l;
        if ((strArr == null || strArr.length == 0) && !TextUtils.isEmpty(this.e)) {
            this.l = b(gn.c(this.e));
        }
        return (String[]) this.l.clone();
    }

    public int hashCode() {
        gz gzVar = new gz();
        gzVar.a(this.j).a(this.g).a(this.h).a((Object[]) this.l);
        return gzVar.a();
    }

    private gm() {
        this.c = 1;
        this.l = null;
    }

    private String[] b(String str) {
        try {
            return str.split(";");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public String a() {
        if (TextUtils.isEmpty(this.j) && !TextUtils.isEmpty(this.a)) {
            this.j = gn.c(this.a);
        }
        return this.j;
    }

    private gm(C4569a c4569a) {
        this.c = 1;
        this.l = null;
        this.g = c4569a.a;
        this.h = c4569a.b;
        this.j = c4569a.c;
        this.i = c4569a.d;
        this.c = c4569a.e ? 1 : 0;
        this.k = c4569a.f;
        this.l = c4569a.g;
        this.b = gn.b(this.h);
        this.a = gn.b(this.j);
        this.d = gn.b(this.i);
        this.e = gn.b(a(this.l));
        this.f = gn.b(this.k);
    }

    private String a(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            for (String str : strArr) {
                sb.append(str);
                sb.append(";");
            }
            return sb.toString();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String a(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("a1", gn.b(str));
        return hg.a((Map<String, String>) hashMap);
    }
}
