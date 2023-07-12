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
    private static final C3191h0<animationInterpolatorC3189g0> cache = new C3191h0<>(4);

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.android.bindingx.core.internal.TimingFunctions$a */
    /* loaded from: classes5.dex */
    static class C3176a implements JSFunctionInterface {
        C3176a() {
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
    /* renamed from: com.alibaba.android.bindingx.core.internal.TimingFunctions$a0 */
    /* loaded from: classes5.dex */
    static class C3177a0 implements JSFunctionInterface {
        C3177a0() {
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
    /* renamed from: com.alibaba.android.bindingx.core.internal.TimingFunctions$b */
    /* loaded from: classes5.dex */
    static class C3178b implements JSFunctionInterface {
        C3178b() {
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
    /* renamed from: com.alibaba.android.bindingx.core.internal.TimingFunctions$b0 */
    /* loaded from: classes5.dex */
    static class C3179b0 implements JSFunctionInterface {
        C3179b0() {
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
    /* renamed from: com.alibaba.android.bindingx.core.internal.TimingFunctions$c */
    /* loaded from: classes5.dex */
    static class C3180c implements JSFunctionInterface {
        C3180c() {
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
    /* renamed from: com.alibaba.android.bindingx.core.internal.TimingFunctions$c0 */
    /* loaded from: classes5.dex */
    static class C3181c0 implements JSFunctionInterface {
        C3181c0() {
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
    /* renamed from: com.alibaba.android.bindingx.core.internal.TimingFunctions$d */
    /* loaded from: classes5.dex */
    static class C3182d implements JSFunctionInterface {
        C3182d() {
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
    /* renamed from: com.alibaba.android.bindingx.core.internal.TimingFunctions$d0 */
    /* loaded from: classes5.dex */
    static class C3183d0 implements JSFunctionInterface {
        C3183d0() {
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
    /* renamed from: com.alibaba.android.bindingx.core.internal.TimingFunctions$e */
    /* loaded from: classes5.dex */
    static class C3184e implements JSFunctionInterface {
        C3184e() {
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
    /* renamed from: com.alibaba.android.bindingx.core.internal.TimingFunctions$e0 */
    /* loaded from: classes5.dex */
    static class C3185e0 implements JSFunctionInterface {
        C3185e0() {
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
    /* renamed from: com.alibaba.android.bindingx.core.internal.TimingFunctions$f */
    /* loaded from: classes5.dex */
    static class C3186f implements JSFunctionInterface {
        C3186f() {
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
    /* renamed from: com.alibaba.android.bindingx.core.internal.TimingFunctions$f0 */
    /* loaded from: classes5.dex */
    static class C3187f0 implements JSFunctionInterface {
        C3187f0() {
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
    /* renamed from: com.alibaba.android.bindingx.core.internal.TimingFunctions$g */
    /* loaded from: classes5.dex */
    static class C3188g implements JSFunctionInterface {
        C3188g() {
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
    /* renamed from: com.alibaba.android.bindingx.core.internal.TimingFunctions$g0  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static class animationInterpolatorC3189g0 implements Interpolator {
        float a;
        float b;
        float c;
        float d;
        private Interpolator e;

        animationInterpolatorC3189g0(float f, float f2, float f3, float f4) {
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
    /* renamed from: com.alibaba.android.bindingx.core.internal.TimingFunctions$h */
    /* loaded from: classes5.dex */
    static class C3190h implements JSFunctionInterface {
        C3190h() {
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
    /* renamed from: com.alibaba.android.bindingx.core.internal.TimingFunctions$h0 */
    /* loaded from: classes5.dex */
    public static class C3191h0<T> {
        private final ArrayDeque<T> a;

        C3191h0(int i) {
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
    /* renamed from: com.alibaba.android.bindingx.core.internal.TimingFunctions$i */
    /* loaded from: classes5.dex */
    static class C3192i implements JSFunctionInterface {
        C3192i() {
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
    /* renamed from: com.alibaba.android.bindingx.core.internal.TimingFunctions$j */
    /* loaded from: classes5.dex */
    static class C3193j implements JSFunctionInterface {
        C3193j() {
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
    /* renamed from: com.alibaba.android.bindingx.core.internal.TimingFunctions$k */
    /* loaded from: classes5.dex */
    static class C3194k implements JSFunctionInterface {
        C3194k() {
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
    /* renamed from: com.alibaba.android.bindingx.core.internal.TimingFunctions$l */
    /* loaded from: classes5.dex */
    static class C3195l implements JSFunctionInterface {
        C3195l() {
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
    /* renamed from: com.alibaba.android.bindingx.core.internal.TimingFunctions$m */
    /* loaded from: classes5.dex */
    static class C3196m implements JSFunctionInterface {
        C3196m() {
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
    /* renamed from: com.alibaba.android.bindingx.core.internal.TimingFunctions$n */
    /* loaded from: classes5.dex */
    static class C3197n implements JSFunctionInterface {
        C3197n() {
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
    /* renamed from: com.alibaba.android.bindingx.core.internal.TimingFunctions$o */
    /* loaded from: classes5.dex */
    static class C3198o implements JSFunctionInterface {
        C3198o() {
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
    /* renamed from: com.alibaba.android.bindingx.core.internal.TimingFunctions$p */
    /* loaded from: classes5.dex */
    static class C3199p implements JSFunctionInterface {
        C3199p() {
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
    /* renamed from: com.alibaba.android.bindingx.core.internal.TimingFunctions$q */
    /* loaded from: classes5.dex */
    static class C3200q implements JSFunctionInterface {
        C3200q() {
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
    /* renamed from: com.alibaba.android.bindingx.core.internal.TimingFunctions$r */
    /* loaded from: classes5.dex */
    static class C3201r implements JSFunctionInterface {
        C3201r() {
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
    /* renamed from: com.alibaba.android.bindingx.core.internal.TimingFunctions$s */
    /* loaded from: classes5.dex */
    static class C3202s implements JSFunctionInterface {
        C3202s() {
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
    /* renamed from: com.alibaba.android.bindingx.core.internal.TimingFunctions$t */
    /* loaded from: classes5.dex */
    static class C3203t implements JSFunctionInterface {
        C3203t() {
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
    /* renamed from: com.alibaba.android.bindingx.core.internal.TimingFunctions$u */
    /* loaded from: classes5.dex */
    static class C3204u implements JSFunctionInterface {
        C3204u() {
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
    /* renamed from: com.alibaba.android.bindingx.core.internal.TimingFunctions$v */
    /* loaded from: classes5.dex */
    static class C3205v implements JSFunctionInterface {
        C3205v() {
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
                animationInterpolatorC3189g0 isCacheHit = TimingFunctions.isCacheHit(f, f2, f3, f4);
                if (isCacheHit == null) {
                    isCacheHit = new animationInterpolatorC3189g0(f, f2, f3, f4);
                    TimingFunctions.cache.a(isCacheHit);
                }
                return Double.valueOf((doubleValue3 * isCacheHit.getInterpolation((float) (min / doubleValue4))) + doubleValue2);
            }
            return Double.valueOf(doubleValue2 + doubleValue3);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.android.bindingx.core.internal.TimingFunctions$w */
    /* loaded from: classes5.dex */
    static class C3206w implements JSFunctionInterface {
        C3206w() {
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
    /* renamed from: com.alibaba.android.bindingx.core.internal.TimingFunctions$x */
    /* loaded from: classes5.dex */
    static class C3207x implements JSFunctionInterface {
        C3207x() {
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
    /* renamed from: com.alibaba.android.bindingx.core.internal.TimingFunctions$y */
    /* loaded from: classes5.dex */
    static class C3208y implements JSFunctionInterface {
        C3208y() {
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
    /* renamed from: com.alibaba.android.bindingx.core.internal.TimingFunctions$z */
    /* loaded from: classes5.dex */
    static class C3209z implements JSFunctionInterface {
        C3209z() {
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
        return new C3205v();
    }

    public static Object easeInBack() {
        return new C3202s();
    }

    public static Object easeInBounce() {
        return new C3206w();
    }

    public static Object easeInCirc() {
        return new C3196m();
    }

    public static Object easeInCubic() {
        return new C3181c0();
    }

    public static Object easeInElastic() {
        return new C3199p();
    }

    public static Object easeInExpo() {
        return new C3192i();
    }

    public static Object easeInOutBack() {
        return new C3204u();
    }

    public static Object easeInOutBounce() {
        return new C3208y();
    }

    public static Object easeInOutCirc() {
        return new C3198o();
    }

    public static Object easeInOutCubic() {
        return new C3185e0();
    }

    public static Object easeInOutElastic() {
        return new C3201r();
    }

    public static Object easeInOutExpo() {
        return new C3195l();
    }

    public static Object easeInOutQuad() {
        return new C3179b0();
    }

    public static Object easeInOutQuart() {
        return new C3178b();
    }

    public static Object easeInOutQuint() {
        return new C3184e();
    }

    public static Object easeInOutSine() {
        return new C3190h();
    }

    public static Object easeInQuad() {
        return new C3209z();
    }

    public static Object easeInQuart() {
        return new C3187f0();
    }

    public static Object easeInQuint() {
        return new C3180c();
    }

    public static Object easeInSine() {
        return new C3186f();
    }

    public static Object easeOutBack() {
        return new C3203t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double easeOutBounce(double d, double d2, double d3, double d4) {
        double d5;
        double d6;
        double d7;
        double d8 = d / d4;
        if (d8 < 0.36363636363636365d) {
            d7 = 7.5625d * d8 * d8;
        } else {
            if (d8 < 0.7272727272727273d) {
                double d9 = d8 - 0.5454545454545454d;
                d5 = 7.5625d * d9 * d9;
                d6 = 0.75d;
            } else if (d8 < 0.9090909090909091d) {
                double d10 = d8 - 0.8181818181818182d;
                d5 = 7.5625d * d10 * d10;
                d6 = 0.9375d;
            } else {
                double d11 = d8 - 0.9545454545454546d;
                d5 = 7.5625d * d11 * d11;
                d6 = 0.984375d;
            }
            d7 = d5 + d6;
        }
        return (d3 * d7) + d2;
    }

    public static Object easeOutBounce() {
        return new C3207x();
    }

    public static Object easeOutCirc() {
        return new C3197n();
    }

    public static Object easeOutCubic() {
        return new C3183d0();
    }

    public static Object easeOutElastic() {
        return new C3200q();
    }

    public static Object easeOutExpo() {
        return new C3193j();
    }

    public static Object easeOutQuad() {
        return new C3177a0();
    }

    public static Object easeOutQuart() {
        return new C3176a();
    }

    public static Object easeOutQuint() {
        return new C3182d();
    }

    public static Object easeOutSine() {
        return new C3188g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public static animationInterpolatorC3189g0 isCacheHit(float f, float f2, float f3, float f4) {
        for (animationInterpolatorC3189g0 animationinterpolatorc3189g0 : cache.b()) {
            if (Float.compare(animationinterpolatorc3189g0.a, f) == 0 && Float.compare(animationinterpolatorc3189g0.c, f3) == 0 && Float.compare(animationinterpolatorc3189g0.b, f2) == 0 && Float.compare(animationinterpolatorc3189g0.d, f4) == 0) {
                return animationinterpolatorc3189g0;
            }
        }
        return null;
    }

    public static Object linear() {
        return new C3194k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double easeInBounce(double d, double d2, double d3, double d4) {
        return (d3 - easeOutBounce(d4 - d, 0.0d, d3, d4)) + d2;
    }
}
