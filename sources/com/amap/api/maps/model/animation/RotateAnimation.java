package com.amap.api.maps.model.animation;

import android.view.animation.Interpolator;
import com.autonavi.amap.mapcore.animation.GLRotateAnimation;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class RotateAnimation extends Animation {
    public RotateAnimation(float f, float f2, float f3, float f4, float f5) {
        this.glAnimation = new GLRotateAnimation(f, f2, f3, f4, f5);
    }

    @Override // com.amap.api.maps.model.animation.Animation
    public void setDuration(long j) {
        this.glAnimation.setDuration(j);
    }

    @Override // com.amap.api.maps.model.animation.Animation
    public void setInterpolator(Interpolator interpolator) {
        this.glAnimation.setInterpolator(interpolator);
    }

    public RotateAnimation(float f, float f2) {
        this.glAnimation = new GLRotateAnimation(f, f2, 0.0f, 0.0f, 0.0f);
    }
}
