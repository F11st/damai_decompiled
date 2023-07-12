package com.loc;

import android.text.TextUtils;
import com.youku.playerservice.axp.playinfo.Point;

/* compiled from: Taobao */
@as(a = "a")
/* loaded from: classes10.dex */
public final class u1 {
    @at(a = "a1", b = 6)
    private String a;
    @at(a = "a2", b = 6)
    private String b;
    @at(a = "a6", b = 2)
    private int c;
    @at(a = "a4", b = 6)
    private String d;
    @at(a = "a5", b = 6)
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String[] k;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class a {
        private String a;
        private String b;
        private String c;
        private String d;
        private boolean e = true;
        private String f = Point.STANDARD;
        private String[] g = null;

        public a(String str, String str2, String str3) {
            this.a = str2;
            this.b = str2;
            this.d = str3;
            this.c = str;
        }

        public final a a(String str) {
            this.b = str;
            return this;
        }

        public final a b(String[] strArr) {
            if (strArr != null) {
                this.g = (String[]) strArr.clone();
            }
            return this;
        }

        public final u1 c() throws k {
            if (this.g != null) {
                return new u1(this, (byte) 0);
            }
            throw new k("sdk packages is null");
        }
    }

    private u1() {
        this.c = 1;
        this.k = null;
    }

    private u1(a aVar) {
        this.c = 1;
        this.k = null;
        this.f = aVar.a;
        this.g = aVar.b;
        this.i = aVar.c;
        this.h = aVar.d;
        this.c = aVar.e ? 1 : 0;
        this.j = aVar.f;
        this.k = aVar.g;
        this.b = v1.r(this.g);
        this.a = v1.r(this.i);
        v1.r(this.h);
        this.d = v1.r(b(this.k));
        this.e = v1.r(this.j);
    }

    /* synthetic */ u1(a aVar, byte b) {
        this(aVar);
    }

    private static String b(String[] strArr) {
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

    private static String[] d(String str) {
        try {
            return str.split(";");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final String a() {
        if (TextUtils.isEmpty(this.i) && !TextUtils.isEmpty(this.a)) {
            this.i = v1.v(this.a);
        }
        return this.i;
    }

    public final void c(boolean z) {
        this.c = z ? 1 : 0;
    }

    public final String e() {
        return this.f;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (u1.class != obj.getClass()) {
            return false;
        }
        try {
            if (this.i.equals(((u1) obj).i) && this.f.equals(((u1) obj).f)) {
                if (this.g.equals(((u1) obj).g)) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public final String f() {
        if (TextUtils.isEmpty(this.g) && !TextUtils.isEmpty(this.b)) {
            this.g = v1.v(this.b);
        }
        return this.g;
    }

    public final String g() {
        if (TextUtils.isEmpty(this.j) && !TextUtils.isEmpty(this.e)) {
            this.j = v1.v(this.e);
        }
        if (TextUtils.isEmpty(this.j)) {
            this.j = Point.STANDARD;
        }
        return this.j;
    }

    public final boolean h() {
        return this.c == 1;
    }

    public final String[] i() {
        String[] strArr = this.k;
        if ((strArr == null || strArr.length == 0) && !TextUtils.isEmpty(this.d)) {
            this.k = d(v1.v(this.d));
        }
        return (String[]) this.k.clone();
    }
}
