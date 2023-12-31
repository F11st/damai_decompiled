package androidx.constraintlayout.motion.widget;

import android.view.animation.Interpolator;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public abstract class MotionInterpolator implements Interpolator {
    @Override // android.animation.TimeInterpolator
    public abstract float getInterpolation(float f);

    public abstract float getVelocity();
}
