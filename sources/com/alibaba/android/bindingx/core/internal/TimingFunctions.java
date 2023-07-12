package com.alibaba.android.bindingx.core.internal;

import android.view.animation.Interpolator;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import org.json.JSONException;

/* compiled from: Taobao */
@Keep
/* loaded from: classes5.dex */
public class TimingFunctions {
    private static final h0<g0> cache = new h0<>(4);

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    static class a implements JSFunctionInterface {
        a() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) throws NumberFormatException, JSONException {
            double doubleValue = ((Double) arrayList.get(0)).doubleValue();
            double doubleValue2 = ((Double) arrayList.get(1)).doubleValue();
            double doubleValue3 = ((Double) arrayList.get(2)).doubleValue();
            double doubleValue4 = ((Double) arrayList.get(3)).doubleValue();
            double min = (Math.min(doubleValue, doubleValue4) / doubleValue4) - 1.0d;
            return Double.valueOf(((-doubleValue3) * ((((min * min) * min) * min) - 1.0d)) + doubleValue2);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    static class a0 implements JSFunctionInterface {
        a0() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) throws NumberFormatException, JSONException {
            double doubleValue = ((Double) arrayList.get(0)).doubleValue();
            double doubleValue2 = ((Double) arrayList.get(1)).doubleValue();
            double doubleValue3 = ((Double) arrayList.get(2)).doubleValue();
            double doubleValue4 = ((Double) arrayList.get(3)).doubleValue();
            double min = Math.min(doubleValue, doubleValue4) / doubleValue4;
            return Double.valueOf(((-doubleValue3) * min * (min - 2.0d)) + doubleValue2);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    static class b implements JSFunctionInterface {
        b() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) throws NumberFormatException, JSONException {
            double doubleValue = ((Double) arrayList.get(0)).doubleValue();
            double doubleValue2 = ((Double) arrayList.get(1)).doubleValue();
            double doubleValue3 = ((Double) arrayList.get(2)).doubleValue();
            double doubleValue4 = ((Double) arrayList.get(3)).doubleValue();
            double min = Math.min(doubleValue, doubleValue4) / (doubleValue4 / 2.0d);
            if (min < 1.0d) {
                return Double.valueOf(((doubleValue3 / 2.0d) * min * min * min * min) + doubleValue2);
            }
            double d = min - 2.0d;
            return Double.valueOf((((-doubleValue3) / 2.0d) * ((((d * d) * d) * d) - 2.0d)) + doubleValue2);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    static class b0 implements JSFunctionInterface {
        b0() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) throws NumberFormatException, JSONException {
            double doubleValue = ((Double) arrayList.get(0)).doubleValue();
            double doubleValue2 = ((Double) arrayList.get(1)).doubleValue();
            double doubleValue3 = ((Double) arrayList.get(2)).doubleValue();
            double doubleValue4 = ((Double) arrayList.get(3)).doubleValue();
            double min = Math.min(doubleValue, doubleValue4) / (doubleValue4 / 2.0d);
            if (min < 1.0d) {
                return Double.valueOf(((doubleValue3 / 2.0d) * min * min) + doubleValue2);
            }
            double d = min - 1.0d;
            return Double.valueOf((((-doubleValue3) / 2.0d) * ((d * (d - 2.0d)) - 1.0d)) + doubleValue2);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    static class c implements JSFunctionInterface {
        c() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) throws NumberFormatException, JSONException {
            double doubleValue = ((Double) arrayList.get(0)).doubleValue();
            double doubleValue2 = ((Double) arrayList.get(1)).doubleValue();
            double doubleValue3 = ((Double) arrayList.get(2)).doubleValue();
            double doubleValue4 = ((Double) arrayList.get(3)).doubleValue();
            double min = Math.min(doubleValue, doubleValue4) / doubleValue4;
            return Double.valueOf((doubleValue3 * min * min * min * min * min) + doubleValue2);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    static class c0 implements JSFunctionInterface {
        c0() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) throws NumberFormatException, JSONException {
            double doubleValue = ((Double) arrayList.get(0)).doubleValue();
            double doubleValue2 = ((Double) arrayList.get(1)).doubleValue();
            double doubleValue3 = ((Double) arrayList.get(2)).doubleValue();
            double doubleValue4 = ((Double) arrayList.get(3)).doubleValue();
            double min = Math.min(doubleValue, doubleValue4) / doubleValue4;
            return Double.valueOf((doubleValue3 * min * min * min) + doubleValue2);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    static class d implements JSFunctionInterface {
        d() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) throws NumberFormatException, JSONException {
            double doubleValue = ((Double) arrayList.get(0)).doubleValue();
            double doubleValue2 = ((Double) arrayList.get(1)).doubleValue();
            double doubleValue3 = ((Double) arrayList.get(2)).doubleValue();
            double doubleValue4 = ((Double) arrayList.get(3)).doubleValue();
            double min = (Math.min(doubleValue, doubleValue4) / doubleValue4) - 1.0d;
            return Double.valueOf((doubleValue3 * ((min * min * min * min * min) + 1.0d)) + doubleValue2);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    static class d0 implements JSFunctionInterface {
        d0() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) throws NumberFormatException, JSONException {
            double doubleValue = ((Double) arrayList.get(0)).doubleValue();
            double doubleValue2 = ((Double) arrayList.get(1)).doubleValue();
            double doubleValue3 = ((Double) arrayList.get(2)).doubleValue();
            double doubleValue4 = ((Double) arrayList.get(3)).doubleValue();
            double min = (Math.min(doubleValue, doubleValue4) / doubleValue4) - 1.0d;
            return Double.valueOf((doubleValue3 * ((min * min * min) + 1.0d)) + doubleValue2);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    static class e implements JSFunctionInterface {
        e() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) throws NumberFormatException, JSONException {
            double doubleValue = ((Double) arrayList.get(0)).doubleValue();
            double doubleValue2 = ((Double) arrayList.get(1)).doubleValue();
            double doubleValue3 = ((Double) arrayList.get(2)).doubleValue();
            double doubleValue4 = ((Double) arrayList.get(3)).doubleValue();
            double min = Math.min(doubleValue, doubleValue4) / (doubleValue4 / 2.0d);
            if (min < 1.0d) {
                return Double.valueOf(((doubleValue3 / 2.0d) * min * min * min * min * min) + doubleValue2);
            }
            double d = min - 2.0d;
            return Double.valueOf(((doubleValue3 / 2.0d) * ((d * d * d * d * d) + 2.0d)) + doubleValue2);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    static class e0 implements JSFunctionInterface {
        e0() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) throws NumberFormatException, JSONException {
            double doubleValue = ((Double) arrayList.get(0)).doubleValue();
            double doubleValue2 = ((Double) arrayList.get(1)).doubleValue();
            double doubleValue3 = ((Double) arrayList.get(2)).doubleValue();
            double doubleValue4 = ((Double) arrayList.get(3)).doubleValue();
            double min = Math.min(doubleValue, doubleValue4) / (doubleValue4 / 2.0d);
            if (min < 1.0d) {
                return Double.valueOf(((doubleValue3 / 2.0d) * min * min * min) + doubleValue2);
            }
            double d = min - 2.0d;
            return Double.valueOf(((doubleValue3 / 2.0d) * ((d * d * d) + 2.0d)) + doubleValue2);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    static class f implements JSFunctionInterface {
        f() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) throws NumberFormatException, JSONException {
            double doubleValue = ((Double) arrayList.get(0)).doubleValue();
            double doubleValue2 = ((Double) arrayList.get(1)).doubleValue();
            double doubleValue3 = ((Double) arrayList.get(2)).doubleValue();
            double doubleValue4 = ((Double) arrayList.get(3)).doubleValue();
            return Double.valueOf(((-doubleValue3) * Math.cos((Math.min(doubleValue, doubleValue4) / doubleValue4) * 1.5707963267948966d)) + doubleValue3 + doubleValue2);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    static class f0 implements JSFunctionInterface {
        f0() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) throws NumberFormatException, JSONException {
            double doubleValue = ((Double) arrayList.get(0)).doubleValue();
            double doubleValue2 = ((Double) arrayList.get(1)).doubleValue();
            double doubleValue3 = ((Double) arrayList.get(2)).doubleValue();
            double doubleValue4 = ((Double) arrayList.get(3)).doubleValue();
            double min = Math.min(doubleValue, doubleValue4) / doubleValue4;
            return Double.valueOf((doubleValue3 * min * min * min * min) + doubleValue2);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    static class g implements JSFunctionInterface {
        g() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) throws NumberFormatException, JSONException {
            double doubleValue = ((Double) arrayList.get(0)).doubleValue();
            double doubleValue2 = ((Double) arrayList.get(1)).doubleValue();
            double doubleValue3 = ((Double) arrayList.get(2)).doubleValue();
            double doubleValue4 = ((Double) arrayList.get(3)).doubleValue();
            return Double.valueOf((doubleValue3 * Math.sin((Math.min(doubleValue, doubleValue4) / doubleValue4) * 1.5707963267948966d)) + doubleValue2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public static class g0 implements Interpolator {
        float a;
        float b;
        float c;
        float d;
        private Interpolator e;

        g0(float f, float f2, float f3, float f4) {
            this.a = f;
            this.b = f2;
            this.c = f3;
            this.d = f4;
            this.e = PathInterpolatorCompat.create(f, f2, f3, f4);
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return this.e.getInterpolation(f);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    static class h implements JSFunctionInterface {
        h() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) throws NumberFormatException, JSONException {
            double doubleValue = ((Double) arrayList.get(0)).doubleValue();
            double doubleValue2 = ((Double) arrayList.get(1)).doubleValue();
            double doubleValue3 = ((Double) arrayList.get(2)).doubleValue();
            double doubleValue4 = ((Double) arrayList.get(3)).doubleValue();
            return Double.valueOf((((-doubleValue3) / 2.0d) * (Math.cos((Math.min(doubleValue, doubleValue4) * 3.141592653589793d) / doubleValue4) - 1.0d)) + doubleValue2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public static class h0<T> {
        private final ArrayDeque<T> a;

        h0(int i) {
            this.a = new ArrayDeque<>(i);
        }

        void a(T t) {
            if (this.a.size() >= 4) {
                this.a.removeFirst();
                this.a.addLast(t);
                return;
            }
            this.a.addLast(t);
        }

        Deque<T> b() {
            return this.a;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    static class i implements JSFunctionInterface {
        i() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) throws NumberFormatException, JSONException {
            double doubleValue = ((Double) arrayList.get(0)).doubleValue();
            double doubleValue2 = ((Double) arrayList.get(1)).doubleValue();
            double doubleValue3 = ((Double) arrayList.get(2)).doubleValue();
            double doubleValue4 = ((Double) arrayList.get(3)).doubleValue();
            double min = Math.min(doubleValue, doubleValue4);
            if (min != 0.0d) {
                doubleValue2 += doubleValue3 * Math.pow(2.0d, ((min / doubleValue4) - 1.0d) * 10.0d);
            }
            return Double.valueOf(doubleValue2);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    static class j implements JSFunctionInterface {
        j() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) throws NumberFormatException, JSONException {
            double doubleValue = ((Double) arrayList.get(0)).doubleValue();
            double doubleValue2 = ((Double) arrayList.get(1)).doubleValue();
            double doubleValue3 = ((Double) arrayList.get(2)).doubleValue();
            double doubleValue4 = ((Double) arrayList.get(3)).doubleValue();
            double min = Math.min(doubleValue, doubleValue4);
            return Double.valueOf(min == doubleValue4 ? doubleValue2 + doubleValue3 : doubleValue2 + (doubleValue3 * ((-Math.pow(2.0d, (min * (-10.0d)) / doubleValue4)) + 1.0d)));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    static class k implements JSFunctionInterface {
        k() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) throws NumberFormatException, JSONException {
            double doubleValue = ((Double) arrayList.get(0)).doubleValue();
            double doubleValue2 = ((Double) arrayList.get(1)).doubleValue();
            double doubleValue3 = ((Double) arrayList.get(2)).doubleValue();
            double doubleValue4 = ((Double) arrayList.get(3)).doubleValue();
            return Double.valueOf((doubleValue3 * (Math.min(doubleValue, doubleValue4) / doubleValue4)) + doubleValue2);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    static class l implements JSFunctionInterface {
        l() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) throws NumberFormatException, JSONException {
            double doubleValue = ((Double) arrayList.get(0)).doubleValue();
            double doubleValue2 = ((Double) arrayList.get(1)).doubleValue();
            double doubleValue3 = ((Double) arrayList.get(2)).doubleValue();
            double doubleValue4 = ((Double) arrayList.get(3)).doubleValue();
            double min = Math.min(doubleValue, doubleValue4);
            if (min == 0.0d) {
                return Double.valueOf(doubleValue2);
            }
            if (min == doubleValue4) {
                return Double.valueOf(doubleValue2 + doubleValue3);
            }
            double d = min / (doubleValue4 / 2.0d);
            if (d < 1.0d) {
                return Double.valueOf(((doubleValue3 / 2.0d) * Math.pow(2.0d, (d - 1.0d) * 10.0d)) + doubleValue2);
            }
            return Double.valueOf(((doubleValue3 / 2.0d) * ((-Math.pow(2.0d, (d - 1.0d) * (-10.0d))) + 2.0d)) + doubleValue2);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    static class m implements JSFunctionInterface {
        m() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) throws NumberFormatException, JSONException {
            double doubleValue = ((Double) arrayList.get(0)).doubleValue();
            double doubleValue2 = ((Double) arrayList.get(1)).doubleValue();
            double doubleValue3 = ((Double) arrayList.get(2)).doubleValue();
            double doubleValue4 = ((Double) arrayList.get(3)).doubleValue();
            double min = Math.min(doubleValue, doubleValue4) / doubleValue4;
            return Double.valueOf(((-doubleValue3) * (Math.sqrt(1.0d - (min * min)) - 1.0d)) + doubleValue2);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    static class n implements JSFunctionInterface {
        n() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) throws NumberFormatException, JSONException {
            double doubleValue = ((Double) arrayList.get(0)).doubleValue();
            double doubleValue2 = ((Double) arrayList.get(1)).doubleValue();
            double doubleValue3 = ((Double) arrayList.get(2)).doubleValue();
            double doubleValue4 = ((Double) arrayList.get(3)).doubleValue();
            double min = (Math.min(doubleValue, doubleValue4) / doubleValue4) - 1.0d;
            return Double.valueOf((doubleValue3 * Math.sqrt(1.0d - (min * min))) + doubleValue2);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    static class o implements JSFunctionInterface {
        o() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) throws NumberFormatException, JSONException {
            double doubleValue = ((Double) arrayList.get(0)).doubleValue();
            double doubleValue2 = ((Double) arrayList.get(1)).doubleValue();
            double doubleValue3 = ((Double) arrayList.get(2)).doubleValue();
            double doubleValue4 = ((Double) arrayList.get(3)).doubleValue();
            double min = Math.min(doubleValue, doubleValue4) / (doubleValue4 / 2.0d);
            if (min < 1.0d) {
                return Double.valueOf((((-doubleValue3) / 2.0d) * (Math.sqrt(1.0d - (min * min)) - 1.0d)) + doubleValue2);
            }
            double d = min - 2.0d;
            return Double.valueOf(((doubleValue3 / 2.0d) * (Math.sqrt(1.0d - (d * d)) + 1.0d)) + doubleValue2);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    static class p implements JSFunctionInterface {
        p() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) throws NumberFormatException, JSONException {
            double doubleValue = ((Double) arrayList.get(0)).doubleValue();
            double doubleValue2 = ((Double) arrayList.get(1)).doubleValue();
            double doubleValue3 = ((Double) arrayList.get(2)).doubleValue();
            double doubleValue4 = ((Double) arrayList.get(3)).doubleValue();
            double min = Math.min(doubleValue, doubleValue4);
            if (min == 0.0d) {
                return Double.valueOf(doubleValue2);
            }
            double d = min / doubleValue4;
            if (d == 1.0d) {
                return Double.valueOf(doubleValue2 + doubleValue3);
            }
            double d2 = 0.3d * doubleValue4;
            double d3 = d - 1.0d;
            return Double.valueOf((-(doubleValue3 * Math.pow(2.0d, d3 * 10.0d) * Math.sin((((d3 * doubleValue4) - (doubleValue3 < Math.abs(doubleValue3) ? d2 / 4.0d : (d2 / 6.283185307179586d) * Math.asin(doubleValue3 / doubleValue3))) * 6.283185307179586d) / d2))) + doubleValue2);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    static class q implements JSFunctionInterface {
        q() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) {
            double doubleValue = ((Double) arrayList.get(0)).doubleValue();
            double doubleValue2 = ((Double) arrayList.get(1)).doubleValue();
            double doubleValue3 = ((Double) arrayList.get(2)).doubleValue();
            double doubleValue4 = ((Double) arrayList.get(3)).doubleValue();
            double min = Math.min(doubleValue, doubleValue4);
            if (min == 0.0d) {
                return Double.valueOf(doubleValue2);
            }
            double d = min / doubleValue4;
            if (d == 1.0d) {
                return Double.valueOf(doubleValue2 + doubleValue3);
            }
            double d2 = 0.3d * doubleValue4;
            return Double.valueOf((Math.pow(2.0d, d * (-10.0d)) * doubleValue3 * Math.sin((((d * doubleValue4) - (doubleValue3 < Math.abs(doubleValue3) ? d2 / 4.0d : (d2 / 6.283185307179586d) * Math.asin(doubleValue3 / doubleValue3))) * 6.283185307179586d) / d2)) + doubleValue3 + doubleValue2);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    static class r implements JSFunctionInterface {
        r() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) {
            double doubleValue = ((Double) arrayList.get(0)).doubleValue();
            double doubleValue2 = ((Double) arrayList.get(1)).doubleValue();
            double doubleValue3 = ((Double) arrayList.get(2)).doubleValue();
            double doubleValue4 = ((Double) arrayList.get(3)).doubleValue();
            double min = Math.min(doubleValue, doubleValue4);
            if (min == 0.0d) {
                return Double.valueOf(doubleValue2);
            }
            double d = min / (doubleValue4 / 2.0d);
            if (d == 2.0d) {
                return Double.valueOf(doubleValue2 + doubleValue3);
            }
            double d2 = 0.44999999999999996d * doubleValue4;
            double asin = doubleValue3 < Math.abs(doubleValue3) ? d2 / 4.0d : (d2 / 6.283185307179586d) * Math.asin(doubleValue3 / doubleValue3);
            if (d < 1.0d) {
                double d3 = d - 1.0d;
                return Double.valueOf((doubleValue3 * Math.pow(2.0d, d3 * 10.0d) * Math.sin((((d3 * doubleValue4) - asin) * 6.283185307179586d) / d2) * (-0.5d)) + doubleValue2);
            }
            double d4 = d - 1.0d;
            return Double.valueOf((Math.pow(2.0d, (-10.0d) * d4) * doubleValue3 * Math.sin((((d4 * doubleValue4) - asin) * 6.283185307179586d) / d2) * 0.5d) + doubleValue3 + doubleValue2);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    static class s implements JSFunctionInterface {
        s() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) throws NumberFormatException, JSONException {
            double doubleValue = ((Double) arrayList.get(0)).doubleValue();
            double doubleValue2 = ((Double) arrayList.get(1)).doubleValue();
            double doubleValue3 = ((Double) arrayList.get(2)).doubleValue();
            double doubleValue4 = ((Double) arrayList.get(3)).doubleValue();
            double min = Math.min(doubleValue, doubleValue4) / doubleValue4;
            return Double.valueOf((doubleValue3 * min * min * ((2.70158d * min) - 1.70158d)) + doubleValue2);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    static class t implements JSFunctionInterface {
        t() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) throws NumberFormatException, JSONException {
            double doubleValue = ((Double) arrayList.get(0)).doubleValue();
            double doubleValue2 = ((Double) arrayList.get(1)).doubleValue();
            double doubleValue3 = ((Double) arrayList.get(2)).doubleValue();
            double doubleValue4 = ((Double) arrayList.get(3)).doubleValue();
            double min = (Math.min(doubleValue, doubleValue4) / doubleValue4) - 1.0d;
            return Double.valueOf((doubleValue3 * ((min * min * ((2.70158d * min) + 1.70158d)) + 1.0d)) + doubleValue2);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    static class u implements JSFunctionInterface {
        u() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) throws NumberFormatException, JSONException {
            double doubleValue = ((Double) arrayList.get(0)).doubleValue();
            double doubleValue2 = ((Double) arrayList.get(1)).doubleValue();
            double doubleValue3 = ((Double) arrayList.get(2)).doubleValue();
            double doubleValue4 = ((Double) arrayList.get(3)).doubleValue();
            double min = Math.min(doubleValue, doubleValue4) / (doubleValue4 / 2.0d);
            if (min < 1.0d) {
                return Double.valueOf(((doubleValue3 / 2.0d) * min * min * ((3.5949095d * min) - 2.5949095d)) + doubleValue2);
            }
            double d = min - 2.0d;
            return Double.valueOf(((doubleValue3 / 2.0d) * ((d * d * ((3.5949095d * d) + 2.5949095d)) + 2.0d)) + doubleValue2);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    static class v implements JSFunctionInterface {
        v() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) throws NumberFormatException, JSONException {
            double doubleValue = ((Double) arrayList.get(0)).doubleValue();
            double doubleValue2 = ((Double) arrayList.get(1)).doubleValue();
            double doubleValue3 = ((Double) arrayList.get(2)).doubleValue();
            double doubleValue4 = ((Double) arrayList.get(3)).doubleValue();
            double doubleValue5 = ((Double) arrayList.get(4)).doubleValue();
            double doubleValue6 = ((Double) arrayList.get(5)).doubleValue();
            double doubleValue7 = ((Double) arrayList.get(6)).doubleValue();
            double doubleValue8 = ((Double) arrayList.get(7)).doubleValue();
            double min = Math.min(doubleValue, doubleValue4);
            if (min != doubleValue4) {
                float f = (float) doubleValue5;
                float f2 = (float) doubleValue6;
                float f3 = (float) doubleValue7;
                float f4 = (float) doubleValue8;
                g0 isCacheHit = TimingFunctions.isCacheHit(f, f2, f3, f4);
                if (isCacheHit == null) {
                    isCacheHit = new g0(f, f2, f3, f4);
                    TimingFunctions.cache.a(isCacheHit);
                }
                return Double.valueOf((doubleValue3 * isCacheHit.getInterpolation((float) (min / doubleValue4))) + doubleValue2);
            }
            return Double.valueOf(doubleValue2 + doubleValue3);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    static class w implements JSFunctionInterface {
        w() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) throws NumberFormatException, JSONException {
            double doubleValue = ((Double) arrayList.get(0)).doubleValue();
            double doubleValue2 = ((Double) arrayList.get(1)).doubleValue();
            double doubleValue3 = ((Double) arrayList.get(2)).doubleValue();
            double doubleValue4 = ((Double) arrayList.get(3)).doubleValue();
            return Double.valueOf(TimingFunctions.easeInBounce(Math.min(doubleValue, doubleValue4), doubleValue2, doubleValue3, doubleValue4));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    static class x implements JSFunctionInterface {
        x() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) throws NumberFormatException, JSONException {
            double doubleValue = ((Double) arrayList.get(0)).doubleValue();
            double doubleValue2 = ((Double) arrayList.get(1)).doubleValue();
            double doubleValue3 = ((Double) arrayList.get(2)).doubleValue();
            double doubleValue4 = ((Double) arrayList.get(3)).doubleValue();
            return Double.valueOf(TimingFunctions.easeOutBounce(Math.min(doubleValue, doubleValue4), doubleValue2, doubleValue3, doubleValue4));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    static class y implements JSFunctionInterface {
        y() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) throws NumberFormatException, JSONException {
            double doubleValue = ((Double) arrayList.get(0)).doubleValue();
            double doubleValue2 = ((Double) arrayList.get(1)).doubleValue();
            double doubleValue3 = ((Double) arrayList.get(2)).doubleValue();
            double doubleValue4 = ((Double) arrayList.get(3)).doubleValue();
            double min = Math.min(doubleValue, doubleValue4);
            return min < doubleValue4 / 2.0d ? Double.valueOf((TimingFunctions.easeInBounce(min * 2.0d, 0.0d, doubleValue3, doubleValue4) * 0.5d) + doubleValue2) : Double.valueOf((TimingFunctions.easeOutBounce((min * 2.0d) - doubleValue4, 0.0d, doubleValue3, doubleValue4) * 0.5d) + (doubleValue3 * 0.5d) + doubleValue2);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    static class z implements JSFunctionInterface {
        z() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.JSFunctionInterface
        public Object execute(ArrayList<Object> arrayList) throws NumberFormatException, JSONException {
            double doubleValue = ((Double) arrayList.get(0)).doubleValue();
            double doubleValue2 = ((Double) arrayList.get(1)).doubleValue();
            double doubleValue3 = ((Double) arrayList.get(2)).doubleValue();
            double doubleValue4 = ((Double) arrayList.get(3)).doubleValue();
            double min = Math.min(doubleValue, doubleValue4) / doubleValue4;
            return Double.valueOf((doubleValue3 * min * min) + doubleValue2);
        }
    }

    private TimingFunctions() {
    }

    public static Object cubicBezier() {
        return new v();
    }

    public static Object easeInBack() {
        return new s();
    }

    public static Object easeInBounce() {
        return new w();
    }

    public static Object easeInCirc() {
        return new m();
    }

    public static Object easeInCubic() {
        return new c0();
    }

    public static Object easeInElastic() {
        return new p();
    }

    public static Object easeInExpo() {
        return new i();
    }

    public static Object easeInOutBack() {
        return new u();
    }

    public static Object easeInOutBounce() {
        return new y();
    }

    public static Object easeInOutCirc() {
        return new o();
    }

    public static Object easeInOutCubic() {
        return new e0();
    }

    public static Object easeInOutElastic() {
        return new r();
    }

    public static Object easeInOutExpo() {
        return new l();
    }

    public static Object easeInOutQuad() {
        return new b0();
    }

    public static Object easeInOutQuart() {
        return new b();
    }

    public static Object easeInOutQuint() {
        return new e();
    }

    public static Object easeInOutSine() {
        return new h();
    }

    public static Object easeInQuad() {
        return new z();
    }

    public static Object easeInQuart() {
        return new f0();
    }

    public static Object easeInQuint() {
        return new c();
    }

    public static Object easeInSine() {
        return new f();
    }

    public static Object easeOutBack() {
        return new t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double easeOutBounce(double d2, double d3, double d4, double d5) {
        double d6;
        double d7;
        double d8;
        double d9 = d2 / d5;
        if (d9 < 0.36363636363636365d) {
            d8 = 7.5625d * d9 * d9;
        } else {
            if (d9 < 0.7272727272727273d) {
                double d10 = d9 - 0.5454545454545454d;
                d6 = 7.5625d * d10 * d10;
                d7 = 0.75d;
            } else if (d9 < 0.9090909090909091d) {
                double d11 = d9 - 0.8181818181818182d;
                d6 = 7.5625d * d11 * d11;
                d7 = 0.9375d;
            } else {
                double d12 = d9 - 0.9545454545454546d;
                d6 = 7.5625d * d12 * d12;
                d7 = 0.984375d;
            }
            d8 = d6 + d7;
        }
        return (d4 * d8) + d3;
    }

    public static Object easeOutBounce() {
        return new x();
    }

    public static Object easeOutCirc() {
        return new n();
    }

    public static Object easeOutCubic() {
        return new d0();
    }

    public static Object easeOutElastic() {
        return new q();
    }

    public static Object easeOutExpo() {
        return new j();
    }

    public static Object easeOutQuad() {
        return new a0();
    }

    public static Object easeOutQuart() {
        return new a();
    }

    public static Object easeOutQuint() {
        return new d();
    }

    public static Object easeOutSine() {
        return new g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public static g0 isCacheHit(float f2, float f3, float f4, float f5) {
        for (g0 g0Var : cache.b()) {
            if (Float.compare(g0Var.a, f2) == 0 && Float.compare(g0Var.c, f4) == 0 && Float.compare(g0Var.b, f3) == 0 && Float.compare(g0Var.d, f5) == 0) {
                return g0Var;
            }
        }
        return null;
    }

    public static Object linear() {
        return new k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double easeInBounce(double d2, double d3, double d4, double d5) {
        return (d4 - easeOutBounce(d5 - d2, 0.0d, d4, d5)) + d3;
    }
}
