package com.youku.motioncurvex;

import android.view.animation.Interpolator;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class MotionCurveXBounceInterpolator implements Interpolator {
    private float d;
    private float v;

    public MotionCurveXBounceInterpolator() {
        this.v = 1.0f;
        this.d = 1.0f;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        float f2 = this.v * 2.75f;
        float f3 = 1.0f / f2;
        if (f < f3) {
            return ((float) Math.pow(f2, 2.0d)) * f * f;
        }
        float f4 = 2.0f / f2;
        if (f < f4) {
            float pow = (float) Math.pow(this.d * f2, 2.0d);
            float f5 = 1.5f / f2;
            float f6 = f - f5;
            double d = f3 - f5;
            return (pow * f6 * f6) + ((float) (1.0d - ((Math.pow(f2 * this.d, 2.0d) * d) * d)));
        }
        float f7 = 2.5f / f2;
        if (f < f7) {
            float f8 = 2.25f / f2;
            float f9 = f - f8;
            double d2 = f4 - f8;
            return (((float) Math.pow(this.d * f2, 2.0d)) * f9 * f9) + ((float) (1.0d - ((Math.pow(f2 * this.d, 2.0d) * d2) * d2)));
        }
        float f10 = 2.625f / f2;
        double d3 = f - f10;
        double d4 = f7 - f10;
        return (float) Math.min(1.0d, (Math.pow(this.d * f2, 2.0d) * d3 * d3) + ((float) (1.0d - ((Math.pow(f2 * this.d, 2.0d) * d4) * d4))));
    }

    public MotionCurveXBounceInterpolator(float f, float f2) {
        this.v = f;
        this.d = f2;
    }
}
