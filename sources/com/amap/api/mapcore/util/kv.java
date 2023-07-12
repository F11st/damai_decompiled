package com.amap.api.mapcore.util;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class kv extends ks {
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;

    public kv(boolean z) {
        super(z, true);
        this.j = 0;
        this.k = 0;
        this.l = Integer.MAX_VALUE;
        this.m = Integer.MAX_VALUE;
        this.n = Integer.MAX_VALUE;
    }

    @Override // com.amap.api.mapcore.util.ks
    /* renamed from: a */
    public final ks clone() {
        kv kvVar = new kv(this.h);
        kvVar.a(this);
        kvVar.j = this.j;
        kvVar.k = this.k;
        kvVar.l = this.l;
        kvVar.m = this.m;
        kvVar.n = this.n;
        return kvVar;
    }

    @Override // com.amap.api.mapcore.util.ks
    public final String toString() {
        return "AmapCellLte{lac=" + this.j + ", cid=" + this.k + ", pci=" + this.l + ", earfcn=" + this.m + ", timingAdvance=" + this.n + '}' + super.toString();
    }
}
