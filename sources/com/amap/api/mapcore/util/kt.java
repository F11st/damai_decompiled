package com.amap.api.mapcore.util;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class kt extends ks {
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;

    public kt(boolean z, boolean z2) {
        super(z, z2);
        this.j = 0;
        this.k = 0;
        this.l = 0;
    }

    @Override // com.amap.api.mapcore.util.ks
    /* renamed from: a */
    public final ks clone() {
        kt ktVar = new kt(this.h, this.i);
        ktVar.a(this);
        this.j = ktVar.j;
        this.k = ktVar.k;
        this.l = ktVar.l;
        this.m = ktVar.m;
        this.n = ktVar.n;
        return ktVar;
    }

    @Override // com.amap.api.mapcore.util.ks
    public final String toString() {
        return "AmapCellCdma{sid=" + this.j + ", nid=" + this.k + ", bid=" + this.l + ", latitude=" + this.m + ", longitude=" + this.n + '}' + super.toString();
    }
}
