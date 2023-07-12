package com.loc;

import com.youku.live.livesdk.wkit.component.Constants;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class b1 {
    public int l;
    public boolean n;
    public int a = 0;
    public int b = 0;
    public int c = 0;
    public int d = 0;
    public long e = 0;
    public int f = 0;
    public int g = 0;
    public int h = 0;
    public int i = 0;
    public int j = 0;
    public int k = -113;
    public short m = 0;
    public int o = 32767;
    public int p = Integer.MAX_VALUE;
    public int q = Integer.MAX_VALUE;
    public boolean r = true;
    public int s = 99;
    public long t = 0;

    public b1(int i, boolean z) {
        this.l = 0;
        this.n = false;
        this.l = i;
        this.n = z;
    }

    private String e() {
        int i = this.l;
        return this.l + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + this.a + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + this.b + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + 0L + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + a();
    }

    private String f() {
        return this.l + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + this.h + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + this.i + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + this.j;
    }

    public final long a() {
        return this.l == 5 ? this.e : this.d;
    }

    public final String b() {
        int i = this.l;
        if (i != 1) {
            if (i == 2) {
                return f();
            }
            if (i != 3 && i != 4 && i != 5) {
                return null;
            }
        }
        return e();
    }

    public final String c() {
        String b = b();
        if (b == null || b.length() <= 0) {
            return "";
        }
        boolean z = this.r;
        return (z ? 1 : 0) + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: d */
    public final b1 clone() {
        b1 b1Var = new b1(this.l, this.n);
        b1Var.a = this.a;
        b1Var.b = this.b;
        b1Var.c = this.c;
        b1Var.d = this.d;
        b1Var.e = this.e;
        b1Var.f = this.f;
        b1Var.g = this.g;
        b1Var.h = this.h;
        b1Var.i = this.i;
        b1Var.j = this.j;
        b1Var.k = this.k;
        b1Var.m = this.m;
        b1Var.o = this.o;
        b1Var.p = this.p;
        b1Var.q = this.q;
        b1Var.r = this.r;
        b1Var.s = this.s;
        b1Var.t = this.t;
        return b1Var;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof b1)) {
            b1 b1Var = (b1) obj;
            int i = b1Var.l;
            if (i != 1) {
                return i != 2 ? i != 3 ? i != 4 ? i == 5 && this.l == 5 && b1Var.c == this.c && b1Var.e == this.e && b1Var.q == this.q : this.l == 4 && b1Var.c == this.c && b1Var.d == this.d && b1Var.b == this.b : this.l == 3 && b1Var.c == this.c && b1Var.d == this.d && b1Var.b == this.b : this.l == 2 && b1Var.j == this.j && b1Var.i == this.i && b1Var.h == this.h;
            } else if (this.l == 1 && b1Var.c == this.c && b1Var.d == this.d && b1Var.b == this.b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        int i;
        int hashCode2 = String.valueOf(this.l).hashCode();
        if (this.l == 2) {
            hashCode = String.valueOf(this.j).hashCode() + String.valueOf(this.i).hashCode();
            i = this.h;
        } else {
            hashCode = String.valueOf(this.c).hashCode() + String.valueOf(this.d).hashCode();
            i = this.b;
        }
        return hashCode2 + hashCode + String.valueOf(i).hashCode();
    }
}
