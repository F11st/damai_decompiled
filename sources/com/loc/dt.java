package com.loc;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class dt extends dr {
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;

    public dt() {
        this.j = 0;
        this.k = 0;
        this.l = Integer.MAX_VALUE;
        this.m = Integer.MAX_VALUE;
        this.n = Integer.MAX_VALUE;
        this.o = Integer.MAX_VALUE;
    }

    public dt(boolean z, boolean z2) {
        super(z, z2);
        this.j = 0;
        this.k = 0;
        this.l = Integer.MAX_VALUE;
        this.m = Integer.MAX_VALUE;
        this.n = Integer.MAX_VALUE;
        this.o = Integer.MAX_VALUE;
    }

    @Override // com.loc.dr
    /* renamed from: a */
    public final dr clone() {
        dt dtVar = new dt(this.h, this.i);
        dtVar.a(this);
        dtVar.j = this.j;
        dtVar.k = this.k;
        dtVar.l = this.l;
        dtVar.m = this.m;
        dtVar.n = this.n;
        dtVar.o = this.o;
        return dtVar;
    }

    @Override // com.loc.dr
    public final String toString() {
        return "AmapCellGsm{lac=" + this.j + ", cid=" + this.k + ", psc=" + this.l + ", arfcn=" + this.m + ", bsic=" + this.n + ", timingAdvance=" + this.o + ", mcc='" + this.a + "', mnc='" + this.b + "', signalStrength=" + this.c + ", asuLevel=" + this.d + ", lastUpdateSystemMills=" + this.e + ", lastUpdateUtcMills=" + this.f + ", age=" + this.g + ", main=" + this.h + ", newApi=" + this.i + '}';
    }
}
