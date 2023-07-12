package com.amap.api.maps.model.animation;

import android.view.animation.Interpolator;
import com.autonavi.amap.mapcore.animation.GLAlphaAnimation;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class AlphaAnimation extends Animation {
    public AlphaAnimation(float f, float f2) {
        this.glAnimation = new GLAlphaAnimation(f, f2);
    }

    @Override // com.amap.api.maps.model.animation.Animation
    public void setDuration(long j) {
        this.glAnimation.setDuration(j);
    }

    @Override // com.amap.api.maps.model.animation.Animation
    public void setInterpolator(Interpolator interpolator) {
        this.glAnimation.setInterpolator(interpolator);
    }
}
