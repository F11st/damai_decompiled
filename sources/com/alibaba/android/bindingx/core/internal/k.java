package com.alibaba.android.bindingx.core.internal;

import androidx.annotation.Nullable;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
class k {
    private Double b;
    private Double c;
    private Double d;
    private l a = new l(0.0d, 0.0d, 0.0d, 1.0d);
    private double e = 0.0d;
    private double f = 0.0d;
    private double g = 0.0d;
    private final p h = new p(0.0d, 0.0d, 1.0d);
    private final h i = new h();
    private final l j = new l();
    private final l k = new l(-Math.sqrt(0.5d), 0.0d, 0.0d, Math.sqrt(0.5d));

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(@Nullable Double d, @Nullable Double d2, @Nullable Double d3) {
        this.b = null;
        this.c = null;
        this.d = null;
        this.b = d;
        this.c = d2;
        this.d = d3;
    }

    private void b(l lVar, double d, double d2, double d3, double d4) {
        this.i.a(d2, d, -d3, "YXZ");
        lVar.d(this.i);
        lVar.a(this.k);
        lVar.a(this.j.c(this.h, -d4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l a(double d, double d2, double d3, double d4) {
        Double d5 = this.b;
        double radians = Math.toRadians(d5 != null ? d5.doubleValue() : d4 + this.e);
        Double d6 = this.c;
        double radians2 = Math.toRadians(d6 != null ? d6.doubleValue() : this.f + d2);
        Double d7 = this.d;
        b(this.a, radians, radians2, Math.toRadians(d7 != null ? d7.doubleValue() : d3 + this.g), 0.0d);
        return this.a;
    }
}
