package com.amap.api.mapcore.util;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class kw extends ks {
    public int j;
    public int k;
    public int l;
    public int m;

    public kw(boolean z, boolean z2) {
        super(z, z2);
        this.j = 0;
        this.k = 0;
        this.l = Integer.MAX_VALUE;
        this.m = Integer.MAX_VALUE;
    }

    @Override // com.amap.api.mapcore.util.ks
    /* renamed from: a */
    public final ks clone() {
        kw kwVar = new kw(this.h, this.i);
        kwVar.a(this);
        kwVar.j = this.j;
        kwVar.k = this.k;
        kwVar.l = this.l;
        kwVar.m = this.m;
        return kwVar;
    }

    @Override // com.amap.api.mapcore.util.ks
    public final String toString() {
        return "AmapCellWcdma{lac=" + this.j + ", cid=" + this.k + ", psc=" + this.l + ", uarfcn=" + this.m + '}' + super.toString();
    }
}
