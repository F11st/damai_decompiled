package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import tb.du1;

/* compiled from: Taobao */
@Beta
@GwtIncompatible
/* loaded from: classes10.dex */
public abstract class d {

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static final class b {
        private final double a;
        private final double b;

        public d a(double d) {
            du1.d(!Double.isNaN(d));
            if (com.google.common.math.b.c(d)) {
                return new C0239d(d, this.b - (this.a * d));
            }
            return new e(this.a);
        }

        private b(double d, double d2) {
            this.a = d;
            this.b = d2;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private static final class c extends d {
        static final c a = new c();

        private c() {
        }

        public String toString() {
            return "NaN";
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.common.math.d$d  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private static final class C0239d extends d {
        final double a;
        final double b;

        C0239d(double d, double d2) {
            this.a = d;
            this.b = d2;
        }

        public String toString() {
            return String.format("y = %g * x + %g", Double.valueOf(this.a), Double.valueOf(this.b));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private static final class e extends d {
        final double a;

        e(double d) {
            this.a = d;
        }

        public String toString() {
            return String.format("x = %g", Double.valueOf(this.a));
        }
    }

    public static d a() {
        return c.a;
    }

    public static d b(double d) {
        du1.d(com.google.common.math.b.c(d));
        return new C0239d(0.0d, d);
    }

    public static b c(double d, double d2) {
        du1.d(com.google.common.math.b.c(d) && com.google.common.math.b.c(d2));
        return new b(d, d2);
    }

    public static d d(double d) {
        du1.d(com.google.common.math.b.c(d));
        return new e(d);
    }
}
