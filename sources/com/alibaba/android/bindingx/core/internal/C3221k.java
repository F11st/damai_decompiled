package com.alibaba.android.bindingx.core.internal;

import androidx.annotation.Nullable;

/* compiled from: Taobao */
/* renamed from: com.alibaba.android.bindingx.core.internal.k */
/* loaded from: classes5.dex */
class C3221k {
    private Double b;
    private Double c;
    private Double d;
    private C3222l a = new C3222l(0.0d, 0.0d, 0.0d, 1.0d);
    private double e = 0.0d;
    private double f = 0.0d;
    private double g = 0.0d;
    private final C3228p h = new C3228p(0.0d, 0.0d, 1.0d);
    private final C3218h i = new C3218h();
    private final C3222l j = new C3222l();
    private final C3222l k = new C3222l(-Math.sqrt(0.5d), 0.0d, 0.0d, Math.sqrt(0.5d));

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3221k(@Nullable Double d, @Nullable Double d2, @Nullable Double d3) {
        this.b = null;
        this.c = null;
        this.d = null;
        this.b = d;
        this.c = d2;
        this.d = d3;
    }

    private void b(C3222l c3222l, double d, double d2, double d3, double d4) {
        this.i.a(d2, d, -d3, "YXZ");
        c3222l.d(this.i);
        c3222l.a(this.k);
        c3222l.a(this.j.c(this.h, -d4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3222l a(double d, double d2, double d3, double d4) {
        Double d5 = this.b;
        double radians = Math.toRadians(d5 != null ? d5.doubleValue() : d4 + this.e);
        Double d6 = this.c;
        double radians2 = Math.toRadians(d6 != null ? d6.doubleValue() : this.f + d2);
        Double d7 = this.d;
        b(this.a, radians, radians2, Math.toRadians(d7 != null ? d7.doubleValue() : d3 + this.g), 0.0d);
        return this.a;
    }
}
