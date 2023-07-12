package com.youku.motioncurvex;

import android.view.animation.Interpolator;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class MotionCurveXCosineInterpolator implements Interpolator {
    private float c;
    private float d;

    public MotionCurveXCosineInterpolator() {
        this.d = 1.0f;
        this.c = 1.0f;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return this.d * 0.5f * (1.0f - ((float) Math.cos(((f * 2.0f) * this.c) * 3.141592653589793d)));
    }

    public MotionCurveXCosineInterpolator(float f, float f2) {
        this.d = f;
        this.c = f2;
    }
}
