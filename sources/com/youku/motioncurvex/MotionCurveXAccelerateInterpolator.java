package com.youku.motioncurvex;

import android.view.animation.Interpolator;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class MotionCurveXAccelerateInterpolator implements Interpolator {
    private float x1;
    private float x2;
    private float y1;
    private float y2;

    public MotionCurveXAccelerateInterpolator() {
        this.x1 = 0.4f;
        this.y1 = 0.0f;
        this.x2 = 1.0f;
        this.y2 = 1.0f;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        float f2 = f;
        for (int i = 1; i < 14; i++) {
            float f3 = this.x1;
            float f4 = f3 * 3.0f;
            float f5 = ((this.x2 - f3) * 3.0f) - f4;
            float f6 = (1.0f - f4) - f5;
            float f7 = (((((f2 * f6) + f5) * f2) + f4) * f2) - f;
            if (Math.abs(f7) < 0.001d) {
                break;
            }
            f2 -= f7 / (f4 + (((f5 * 2.0f) + ((f6 * 3.0f) * f2)) * f2));
        }
        float f8 = this.y1;
        float f9 = f8 * 3.0f;
        float f10 = ((this.y2 - f8) * 3.0f) - f9;
        return f2 * (f9 + ((f10 + (((1.0f - f9) - f10) * f2)) * f2));
    }

    public MotionCurveXAccelerateInterpolator(float f, float f2, float f3, float f4) {
        this.x1 = f;
        this.y1 = f2;
        this.x2 = f3;
        this.y2 = f4;
    }
}
