package com.youku.motioncurvex;

import android.view.animation.Interpolator;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class MotionCurveXOvershootInterpolator implements Interpolator {
    private float d;
    private float x1;
    private float x2;
    private float x3;
    private float x4;
    private float y1;
    private float y2;
    private float y3;
    private float y4;

    public MotionCurveXOvershootInterpolator() {
        this.d = 1.2f;
        this.x1 = 0.33f;
        this.y1 = 0.0f;
        this.x2 = 0.3f;
        this.y2 = 1.0f;
        this.x3 = 0.33f;
        this.y3 = 0.0f;
        this.x4 = 0.5f;
        this.y4 = 1.0f;
    }

    private float mcx_standard_curve(float f, float f2, float f3, float f4, float f5) {
        float f6 = f;
        for (int i = 1; i < 14; i++) {
            float f7 = f2 * 3.0f;
            float f8 = ((f4 - f2) * 3.0f) - f7;
            float f9 = (1.0f - f7) - f8;
            float f10 = (((((f6 * f9) + f8) * f6) + f7) * f6) - f;
            if (Math.abs(f10) < 0.001d) {
                break;
            }
            f6 -= f10 / (f7 + (((f8 * 2.0f) + ((f9 * 3.0f) * f6)) * f6));
        }
        float f11 = f3 * 3.0f;
        float f12 = ((f5 - f3) * 3.0f) - f11;
        return f6 * (f11 + ((f12 + (((1.0f - f11) - f12) * f6)) * f6));
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        if (f <= 0.5f) {
            return this.d * mcx_standard_curve(f * 2.0f, this.x1, this.y1, this.x2, this.y2);
        }
        return (this.d * mcx_standard_curve(1.0f, this.x1, this.y1, this.x2, this.y2)) - ((this.d - 1.0f) * mcx_standard_curve((f - 0.5f) * 2.0f, this.x3, this.y3, this.x4, this.y4));
    }

    public MotionCurveXOvershootInterpolator setDamping(float f) {
        this.d = f;
        return this;
    }

    public MotionCurveXOvershootInterpolator(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        this.d = f;
        this.x1 = f2;
        this.y1 = f3;
        this.x2 = f4;
        this.y2 = f5;
        this.x3 = f6;
        this.y3 = f7;
        this.x4 = f8;
        this.y4 = f9;
    }
}
