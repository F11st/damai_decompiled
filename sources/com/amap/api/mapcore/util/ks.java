package com.amap.api.mapcore.util;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class ks {
    public String a = "";
    public String b = "";
    public int c = 99;
    public int d = Integer.MAX_VALUE;
    public long e = 0;
    public long f = 0;
    public int g = 0;
    public boolean h;
    public boolean i;

    public ks(boolean z, boolean z2) {
        this.i = true;
        this.h = z;
        this.i = z2;
    }

    @Override // 
    /* renamed from: a */
    public abstract ks clone();

    public final void a(ks ksVar) {
        if (ksVar != null) {
            this.a = ksVar.a;
            this.b = ksVar.b;
            this.c = ksVar.c;
            this.d = ksVar.d;
            this.e = ksVar.e;
            this.f = ksVar.f;
            this.g = ksVar.g;
            this.h = ksVar.h;
            this.i = ksVar.i;
        }
    }

    public String toString() {
        return "AmapCell{mcc=" + this.a + ", mnc=" + this.b + ", signalStrength=" + this.c + ", asulevel=" + this.d + ", lastUpdateSystemMills=" + this.e + ", lastUpdateUtcMills=" + this.f + ", age=" + this.g + ", main=" + this.h + ", newapi=" + this.i + '}';
    }
}
