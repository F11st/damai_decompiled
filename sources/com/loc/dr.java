package com.loc;

import java.io.Serializable;
import tb.b73;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class dr implements Serializable {
    public String a;
    public String b;
    public int c;
    public int d;
    public long e;
    public long f;
    public int g;
    public boolean h;
    public boolean i;

    public dr() {
        this.a = "";
        this.b = "";
        this.c = 99;
        this.d = Integer.MAX_VALUE;
        this.e = 0L;
        this.f = 0L;
        this.g = 0;
        this.i = true;
    }

    public dr(boolean z, boolean z2) {
        this.a = "";
        this.b = "";
        this.c = 99;
        this.d = Integer.MAX_VALUE;
        this.e = 0L;
        this.f = 0L;
        this.g = 0;
        this.i = true;
        this.h = z;
        this.i = z2;
    }

    private static int a(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            b73.a(e);
            return 0;
        }
    }

    @Override // 
    /* renamed from: a */
    public abstract dr clone();

    public final void a(dr drVar) {
        this.a = drVar.a;
        this.b = drVar.b;
        this.c = drVar.c;
        this.d = drVar.d;
        this.e = drVar.e;
        this.f = drVar.f;
        this.g = drVar.g;
        this.h = drVar.h;
        this.i = drVar.i;
    }

    public final int b() {
        return a(this.a);
    }

    public final int c() {
        return a(this.b);
    }

    public String toString() {
        return "AmapCell{mcc=" + this.a + ", mnc=" + this.b + ", signalStrength=" + this.c + ", asulevel=" + this.d + ", lastUpdateSystemMills=" + this.e + ", lastUpdateUtcMills=" + this.f + ", age=" + this.g + ", main=" + this.h + ", newapi=" + this.i + '}';
    }
}
