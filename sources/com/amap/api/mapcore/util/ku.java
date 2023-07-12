package com.amap.api.mapcore.util;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class ku extends ks {
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;

    public ku(boolean z, boolean z2) {
        super(z, z2);
        this.j = 0;
        this.k = 0;
        this.l = Integer.MAX_VALUE;
        this.m = Integer.MAX_VALUE;
        this.n = Integer.MAX_VALUE;
        this.o = Integer.MAX_VALUE;
    }

    @Override // com.amap.api.mapcore.util.ks
    /* renamed from: a */
    public final ks clone() {
        ku kuVar = new ku(this.h, this.i);
        kuVar.a(this);
        kuVar.j = this.j;
        kuVar.k = this.k;
        kuVar.l = this.l;
        kuVar.m = this.m;
        kuVar.n = this.n;
        kuVar.o = this.o;
        return kuVar;
    }

    @Override // com.amap.api.mapcore.util.ks
    public final String toString() {
        return "AmapCellGsm{lac=" + this.j + ", cid=" + this.k + ", psc=" + this.l + ", arfcn=" + this.m + ", bsic=" + this.n + ", timingAdvance=" + this.o + '}' + super.toString();
    }
}
