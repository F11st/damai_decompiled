package com.youku.motioncurvex;

import android.view.animation.Interpolator;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class MotionCurveXSpringInterpolator implements Interpolator {
    private boolean MassSystem;
    private float d;
    private float iv;
    private float m;
    private float s;

    public MotionCurveXSpringInterpolator() {
        this.m = 0.7f;
        this.s = 380.0f;
        this.d = 10.0f;
        this.iv = -2.0f;
        this.MassSystem = true;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        float f2;
        float f3;
        float exp;
        float sqrt = (float) Math.sqrt(this.s / this.m);
        float sqrt2 = (float) (this.d / (Math.sqrt(this.s * this.m) * 2.0d));
        int i = (sqrt2 > 1.0f ? 1 : (sqrt2 == 1.0f ? 0 : -1));
        if (i < 0) {
            f2 = (float) (sqrt * Math.sqrt(1.0f - (sqrt2 * sqrt2)));
            f3 = ((sqrt2 * sqrt) + (-this.iv)) / f2;
        } else {
            f2 = 0.0f;
            f3 = (-this.iv) + sqrt;
        }
        if (i < 0) {
            double d = f2 * f;
            exp = (float) (Math.exp((-f) * sqrt2 * sqrt) * ((1.0f * Math.cos(d)) + (f3 * Math.sin(d))));
        } else {
            exp = (float) (((f3 * f) + 1.0f) * Math.exp((-f) * sqrt));
        }
        return 1.0f - exp;
    }

    public MotionCurveXSpringInterpolator(float f, float f2, float f3, float f4) {
        this.m = f;
        this.s = f2;
        this.d = f3;
        this.iv = f4;
        this.MassSystem = true;
    }
}
