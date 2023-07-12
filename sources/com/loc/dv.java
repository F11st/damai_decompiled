package com.loc;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class dv extends dr {
    public int j;
    public int k;
    public int l;
    public int m;

    public dv() {
        this.j = 0;
        this.k = 0;
        this.l = Integer.MAX_VALUE;
        this.m = Integer.MAX_VALUE;
    }

    public dv(boolean z, boolean z2) {
        super(z, z2);
        this.j = 0;
        this.k = 0;
        this.l = Integer.MAX_VALUE;
        this.m = Integer.MAX_VALUE;
    }

    @Override // com.loc.dr
    /* renamed from: a */
    public final dr clone() {
        dv dvVar = new dv(this.h, this.i);
        dvVar.a(this);
        dvVar.j = this.j;
        dvVar.k = this.k;
        dvVar.l = this.l;
        dvVar.m = this.m;
        return dvVar;
    }

    @Override // com.loc.dr
    public final String toString() {
        return "AmapCellWcdma{lac=" + this.j + ", cid=" + this.k + ", psc=" + this.l + ", uarfcn=" + this.m + ", mcc='" + this.a + "', mnc='" + this.b + "', signalStrength=" + this.c + ", asuLevel=" + this.d + ", lastUpdateSystemMills=" + this.e + ", lastUpdateUtcMills=" + this.f + ", age=" + this.g + ", main=" + this.h + ", newApi=" + this.i + '}';
    }
}
