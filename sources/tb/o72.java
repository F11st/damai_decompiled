package tb;

import android.content.Context;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class o72 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static float A = (float) (Math.log(0.78d) / Math.log(0.9d));
    private static final float[] B = new float[101];
    private final Interpolator a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private long m;
    private int n;
    private float o;
    private float p;
    private float q;
    private boolean s;
    private float t;
    private float u;
    private int v;
    private float x;
    private final float y;
    private float z;
    private float w = ViewConfiguration.getScrollFriction();
    private boolean r = true;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static class a implements Interpolator {
        private static transient /* synthetic */ IpChange $ipChange;
        private static final float a;
        private static final float b;

        static {
            float a2 = 1.0f / a(1.0f);
            a = a2;
            b = 1.0f - (a2 * a(1.0f));
        }

        a() {
        }

        private static float a(float f) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1595734725")) {
                return ((Float) ipChange.ipc$dispatch("-1595734725", new Object[]{Float.valueOf(f)})).floatValue();
            }
            float f2 = f * 8.0f;
            if (f2 < 1.0f) {
                return f2 - (1.0f - ((float) Math.exp(-f2)));
            }
            return ((1.0f - ((float) Math.exp(1.0f - f2))) * 0.63212055f) + 0.36787945f;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1103231081")) {
                return ((Float) ipChange.ipc$dispatch("1103231081", new Object[]{this, Float.valueOf(f)})).floatValue();
            }
            float a2 = a * a(f);
            return a2 > 0.0f ? a2 + b : a2;
        }
    }

    static {
        float f;
        float f2;
        float f3;
        float f4;
        float f5 = 0.0f;
        float f6 = 0.0f;
        for (int i = 0; i < 100; i++) {
            float f7 = i / 100.0f;
            float f8 = 1.0f;
            while (true) {
                f = ((f8 - f5) / 2.0f) + f5;
                f2 = 1.0f - f;
                f3 = f * 3.0f * f2;
                f4 = f * f * f;
                float f9 = (((0.175f * f2) + (0.35000002f * f)) * f3) + f4;
                if (Math.abs(f9 - f7) < 1.0E-5d) {
                    break;
                } else if (f9 > f7) {
                    f8 = f;
                } else {
                    f5 = f;
                }
            }
            B[i] = (f3 * ((f2 * 0.5f) + f)) + f4;
            float f10 = 1.0f;
            while (true) {
                float f11 = ((f10 - f6) / 2.0f) + f6;
                float f12 = 1.0f - f11;
                float f13 = (f11 * 3.0f * f12 * ((f12 * 0.5f) + f11)) + (f11 * f11 * f11);
                if (Math.abs(f13 - f7) < 1.0E-5d) {
                    break;
                } else if (f13 > f7) {
                    f10 = f11;
                } else {
                    f6 = f11;
                }
            }
        }
        B[100] = 1.0f;
    }

    public o72(Context context, Interpolator interpolator, boolean z) {
        if (interpolator == null) {
            this.a = new a();
        } else {
            this.a = interpolator;
        }
        this.y = context.getResources().getDisplayMetrics().density * 160.0f;
        this.x = b(ViewConfiguration.getScrollFriction());
        this.s = z;
        this.z = b(0.84f);
    }

    private float b(float f) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1293726500") ? ((Float) ipChange.ipc$dispatch("1293726500", new Object[]{this, Float.valueOf(f)})).floatValue() : this.y * 386.0878f * f;
    }

    private double h(float f) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1236200690") ? ((Double) ipChange.ipc$dispatch("1236200690", new Object[]{this, Float.valueOf(f)})).doubleValue() : Math.log((Math.abs(f) * 0.35f) / (this.w * this.z));
    }

    private double i(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1951155312")) {
            return ((Double) ipChange.ipc$dispatch("-1951155312", new Object[]{this, Float.valueOf(f)})).doubleValue();
        }
        double h = h(f);
        float f2 = A;
        return this.w * this.z * Math.exp((f2 / (f2 - 1.0d)) * h);
    }

    private int j(float f) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1396610484") ? ((Integer) ipChange.ipc$dispatch("1396610484", new Object[]{this, Float.valueOf(f)})).intValue() : (int) (Math.exp(h(f) / (A - 1.0d)) * 1000.0d);
    }

    public void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "86049364")) {
            ipChange.ipc$dispatch("86049364", new Object[]{this});
            return;
        }
        this.k = this.e;
        this.l = this.f;
        this.r = true;
    }

    public boolean c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1005307599")) {
            return ((Boolean) ipChange.ipc$dispatch("1005307599", new Object[]{this})).booleanValue();
        }
        if (this.r) {
            return false;
        }
        int currentAnimationTimeMillis = (int) (AnimationUtils.currentAnimationTimeMillis() - this.m);
        int i = this.n;
        if (currentAnimationTimeMillis < i) {
            int i2 = this.b;
            if (i2 == 0) {
                float interpolation = this.a.getInterpolation(currentAnimationTimeMillis * this.o);
                this.k = this.c + Math.round(this.p * interpolation);
                this.l = this.d + Math.round(interpolation * this.q);
            } else if (i2 == 1) {
                float f = currentAnimationTimeMillis / i;
                int i3 = (int) (f * 100.0f);
                float f2 = 1.0f;
                float f3 = 0.0f;
                if (i3 < 100) {
                    float f4 = i3 / 100.0f;
                    int i4 = i3 + 1;
                    float[] fArr = B;
                    float f5 = fArr[i3];
                    f3 = (fArr[i4] - f5) / ((i4 / 100.0f) - f4);
                    f2 = f5 + ((f - f4) * f3);
                }
                this.u = ((f3 * this.v) / i) * 1000.0f;
                int i5 = this.c;
                int round = i5 + Math.round((this.e - i5) * f2);
                this.k = round;
                int min = Math.min(round, this.h);
                this.k = min;
                this.k = Math.max(min, this.g);
                int i6 = this.d;
                int round2 = i6 + Math.round(f2 * (this.f - i6));
                this.l = round2;
                int min2 = Math.min(round2, this.j);
                this.l = min2;
                int max = Math.max(min2, this.i);
                this.l = max;
                if (this.k == this.e && max == this.f) {
                    this.r = true;
                }
            }
        } else {
            this.k = this.e;
            this.l = this.f;
            this.r = true;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d(int r14, int r15, int r16, int r17, int r18, int r19, int r20, int r21) {
        /*
            Method dump skipped, instructions count: 290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.o72.d(int, int, int, int, int, int, int, int):void");
    }

    public float e() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "500078189") ? ((Float) ipChange.ipc$dispatch("500078189", new Object[]{this})).floatValue() : this.b == 1 ? this.u : this.t - ((this.x * m()) / 2000.0f);
    }

    public final int f() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "270616298") ? ((Integer) ipChange.ipc$dispatch("270616298", new Object[]{this})).intValue() : this.l;
    }

    public final int g() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-489851204") ? ((Integer) ipChange.ipc$dispatch("-489851204", new Object[]{this})).intValue() : this.f;
    }

    public void k(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1526324378")) {
            ipChange.ipc$dispatch("-1526324378", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.f = i;
        this.q = i - this.d;
        this.r = false;
    }

    public final void l(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "600620218")) {
            ipChange.ipc$dispatch("600620218", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.x = b(f);
        this.w = f;
    }

    public int m() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "951806910") ? ((Integer) ipChange.ipc$dispatch("951806910", new Object[]{this})).intValue() : (int) (AnimationUtils.currentAnimationTimeMillis() - this.m);
    }
}
