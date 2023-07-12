package com.amap.api.col.s;

import android.text.TextUtils;
import com.youku.playerservice.axp.playinfo.Point;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class bv {
    private String a;
    private String b;
    private int c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String[] l;

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.col.s.bv$a */
    /* loaded from: classes10.dex */
    public static class C4400a {
        private String a;
        private String b;
        private String c;
        private String d;
        private boolean e = true;
        private String f = Point.STANDARD;
        private String[] g = null;

        public C4400a(String str, String str2, String str3) {
            this.a = str2;
            this.b = str2;
            this.d = str3;
            this.c = str;
        }

        public final C4400a a(boolean z) {
            this.e = z;
            return this;
        }

        public final C4400a a(String[] strArr) {
            if (strArr != null) {
                this.g = (String[]) strArr.clone();
            }
            return this;
        }

        public final C4400a a(String str) {
            this.b = str;
            return this;
        }

        public final bv a() throws bj {
            if (this.g != null) {
                return new bv(this, (byte) 0);
            }
            throw new bj("sdk packages is null");
        }
    }

    /* synthetic */ bv(C4400a c4400a, byte b) {
        this(c4400a);
    }

    public final void a() {
        this.c = 1;
    }

    public final String b() {
        if (TextUtils.isEmpty(this.j) && !TextUtils.isEmpty(this.a)) {
            this.j = bw.c(this.a);
        }
        return this.j;
    }

    public final String c() {
        return this.g;
    }

    public final String d() {
        if (TextUtils.isEmpty(this.h) && !TextUtils.isEmpty(this.b)) {
            this.h = bw.c(this.b);
        }
        return this.h;
    }

    public final String e() {
        if (TextUtils.isEmpty(this.k) && !TextUtils.isEmpty(this.f)) {
            this.k = bw.c(this.f);
        }
        if (TextUtils.isEmpty(this.k)) {
            this.k = Point.STANDARD;
        }
        return this.k;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (bv.class != obj.getClass()) {
            return false;
        }
        try {
            if (this.j.equals(((bv) obj).j) && this.g.equals(((bv) obj).g)) {
                if (this.h.equals(((bv) obj).h)) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public final boolean f() {
        return this.c == 1;
    }

    public final String[] g() {
        String[] strArr = this.l;
        if ((strArr == null || strArr.length == 0) && !TextUtils.isEmpty(this.e)) {
            this.l = a(bw.c(this.e));
        }
        return (String[]) this.l.clone();
    }

    private bv() {
        this.c = 1;
        this.l = null;
    }

    private static String[] a(String str) {
        try {
            return str.split(";");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static String a(String[] strArr) {
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

    private bv(C4400a c4400a) {
        this.c = 1;
        this.l = null;
        this.g = c4400a.a;
        this.h = c4400a.b;
        this.j = c4400a.c;
        this.i = c4400a.d;
        this.c = c4400a.e ? 1 : 0;
        this.k = c4400a.f;
        this.l = c4400a.g;
        this.b = bw.b(this.h);
        this.a = bw.b(this.j);
        this.d = bw.b(this.i);
        this.e = bw.b(a(this.l));
        this.f = bw.b(this.k);
    }
}
