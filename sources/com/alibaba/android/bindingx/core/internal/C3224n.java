package com.alibaba.android.bindingx.core.internal;

import androidx.annotation.NonNull;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: com.alibaba.android.bindingx.core.internal.n */
/* loaded from: classes5.dex */
class C3224n extends PhysicsAnimationDriver {
    private long g;
    private boolean h;
    private double i;
    private double j;
    private double k;
    private double l;
    private boolean m;
    private final C3226b n = new C3226b();
    private double o;
    private double p;
    private double q;
    private double r;
    private double s;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.android.bindingx.core.internal.n$b */
    /* loaded from: classes5.dex */
    public static class C3226b {
        double a;
        double b;

        private C3226b() {
        }
    }

    private void j(double d) {
        double d2;
        double d3;
        if (l()) {
            return;
        }
        this.s += d <= 0.064d ? d : 0.064d;
        double d4 = this.j;
        double d5 = this.k;
        double d6 = this.i;
        double d7 = -this.l;
        double sqrt = d4 / (Math.sqrt(d6 * d5) * 2.0d);
        double sqrt2 = Math.sqrt(d6 / d5);
        double sqrt3 = Math.sqrt(1.0d - (sqrt * sqrt)) * sqrt2;
        double d8 = this.p - this.o;
        double d9 = this.s;
        if (sqrt < 1.0d) {
            double exp = Math.exp((-sqrt) * sqrt2 * d9);
            double d10 = sqrt * sqrt2;
            double d11 = d7 + (d10 * d8);
            double d12 = d9 * sqrt3;
            d3 = this.p - ((((d11 / sqrt3) * Math.sin(d12)) + (Math.cos(d12) * d8)) * exp);
            d2 = ((d10 * exp) * (((Math.sin(d12) * d11) / sqrt3) + (Math.cos(d12) * d8))) - (((Math.cos(d12) * d11) - ((sqrt3 * d8) * Math.sin(d12))) * exp);
        } else {
            double exp2 = Math.exp((-sqrt2) * d9);
            double d13 = this.p - (((((sqrt2 * d8) + d7) * d9) + d8) * exp2);
            d2 = exp2 * ((d7 * ((d9 * sqrt2) - 1.0d)) + (d9 * d8 * sqrt2 * sqrt2));
            d3 = d13;
        }
        C3226b c3226b = this.n;
        c3226b.a = d3;
        c3226b.b = d2;
        if (l() || (this.m && m())) {
            if (this.i > 0.0d) {
                double d14 = this.p;
                this.o = d14;
                this.n.a = d14;
            } else {
                double d15 = this.n.a;
                this.p = d15;
                this.o = d15;
            }
            this.n.b = 0.0d;
        }
    }

    private double k(C3226b c3226b) {
        return Math.abs(this.p - c3226b.a);
    }

    private boolean m() {
        if (this.i > 0.0d) {
            double d = this.o;
            double d2 = this.p;
            if ((d < d2 && this.n.a > d2) || (d > d2 && this.n.a < d2)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.alibaba.android.bindingx.core.internal.PhysicsAnimationDriver
    void e(@NonNull Map<String, Object> map) {
        C3226b c3226b = this.n;
        double d = C3227o.d(map, "initialVelocity", 0.0d);
        c3226b.b = d;
        this.e = d;
        this.i = C3227o.d(map, "stiffness", 100.0d);
        this.j = C3227o.d(map, "damping", 10.0d);
        this.k = C3227o.d(map, "mass", 1.0d);
        this.l = this.n.b;
        this.d = C3227o.d(map, "fromValue", 0.0d);
        this.p = C3227o.d(map, "toValue", 1.0d);
        this.q = C3227o.d(map, "restSpeedThreshold", 0.001d);
        this.r = C3227o.d(map, "restDisplacementThreshold", 0.001d);
        this.m = C3227o.b(map, "overshootClamping", false);
        this.f = false;
        this.s = 0.0d;
        this.h = false;
    }

    @Override // com.alibaba.android.bindingx.core.internal.PhysicsAnimationDriver
    void f(long j) {
        if (!this.h) {
            C3226b c3226b = this.n;
            double d = this.d;
            c3226b.a = d;
            this.o = d;
            this.g = j;
            this.s = 0.0d;
            this.h = true;
        }
        j((j - this.g) / 1000.0d);
        this.g = j;
        C3226b c3226b2 = this.n;
        this.d = c3226b2.a;
        this.e = c3226b2.b;
        if (l()) {
            this.f = true;
        }
    }

    boolean l() {
        return Math.abs(this.n.b) <= this.q && (k(this.n) <= this.r || this.i == 0.0d);
    }
}
