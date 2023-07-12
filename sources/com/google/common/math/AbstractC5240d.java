package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import tb.du1;

/* compiled from: Taobao */
@Beta
@GwtIncompatible
/* renamed from: com.google.common.math.d */
/* loaded from: classes10.dex */
public abstract class AbstractC5240d {

    /* compiled from: Taobao */
    /* renamed from: com.google.common.math.d$b */
    /* loaded from: classes10.dex */
    public static final class C5242b {
        private final double a;
        private final double b;

        public AbstractC5240d a(double d) {
            du1.d(!Double.isNaN(d));
            if (C5237b.c(d)) {
                return new C5244d(d, this.b - (this.a * d));
            }
            return new C5245e(this.a);
        }

        private C5242b(double d, double d2) {
            this.a = d;
            this.b = d2;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.common.math.d$c */
    /* loaded from: classes10.dex */
    private static final class C5243c extends AbstractC5240d {
        static final C5243c a = new C5243c();

        private C5243c() {
        }

        public String toString() {
            return "NaN";
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.common.math.d$d */
    /* loaded from: classes10.dex */
    private static final class C5244d extends AbstractC5240d {
        final double a;
        final double b;

        C5244d(double d, double d2) {
            this.a = d;
            this.b = d2;
        }

        public String toString() {
            return String.format("y = %g * x + %g", Double.valueOf(this.a), Double.valueOf(this.b));
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.common.math.d$e */
    /* loaded from: classes10.dex */
    private static final class C5245e extends AbstractC5240d {
        final double a;

        C5245e(double d) {
            this.a = d;
        }

        public String toString() {
            return String.format("x = %g", Double.valueOf(this.a));
        }
    }

    public static AbstractC5240d a() {
        return C5243c.a;
    }

    public static AbstractC5240d b(double d) {
        du1.d(C5237b.c(d));
        return new C5244d(0.0d, d);
    }

    public static C5242b c(double d, double d2) {
        du1.d(C5237b.c(d) && C5237b.c(d2));
        return new C5242b(d, d2);
    }

    public static AbstractC5240d d(double d) {
        du1.d(C5237b.c(d));
        return new C5245e(d);
    }
}
