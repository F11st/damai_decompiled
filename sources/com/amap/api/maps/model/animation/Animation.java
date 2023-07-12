package com.amap.api.maps.model.animation;

import android.view.animation.Interpolator;
import com.autonavi.amap.mapcore.animation.GLAnimation;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class Animation {
    public static final int FILL_MODE_BACKWARDS = 1;
    public static final int FILL_MODE_FORWARDS = 0;
    public static final int INFINITE = -1;
    public static final int RESTART = 1;
    public static final int REVERSE = 2;
    private int a = 0;
    public GLAnimation glAnimation;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface AnimationListener {
        void onAnimationEnd();

        void onAnimationStart();
    }

    public Animation() {
        this.glAnimation = null;
        this.glAnimation = new GLAnimation();
    }

    private void a(boolean z) {
        GLAnimation gLAnimation = this.glAnimation;
        if (gLAnimation != null) {
            gLAnimation.setFillEnabled(z);
        }
    }

    private void b(boolean z) {
        GLAnimation gLAnimation = this.glAnimation;
        if (gLAnimation != null) {
            gLAnimation.setFillAfter(z);
        }
    }

    private void c(boolean z) {
        GLAnimation gLAnimation = this.glAnimation;
        if (gLAnimation != null) {
            gLAnimation.setFillBefore(z);
        }
    }

    public int getFillMode() {
        return this.a;
    }

    public int getRepeatCount() {
        GLAnimation gLAnimation = this.glAnimation;
        if (gLAnimation != null) {
            return gLAnimation.getRepeatCount();
        }
        return 0;
    }

    public int getRepeatMode() {
        GLAnimation gLAnimation = this.glAnimation;
        if (gLAnimation != null) {
            return gLAnimation.getRepeatMode();
        }
        return 1;
    }

    public void setAnimationListener(AnimationListener animationListener) {
        this.glAnimation.setAnimationListener(animationListener);
    }

    public abstract void setDuration(long j);

    public void setFillMode(int i) {
        this.a = i;
        if (i == 0) {
            b(true);
            c(false);
            a(false);
            return;
        }
        b(false);
        a(true);
        c(true);
    }

    public abstract void setInterpolator(Interpolator interpolator);

    public void setRepeatCount(int i) {
        GLAnimation gLAnimation = this.glAnimation;
        if (gLAnimation != null) {
            gLAnimation.setRepeatCount(i);
        }
    }

    public void setRepeatMode(int i) {
        GLAnimation gLAnimation = this.glAnimation;
        if (gLAnimation != null) {
            gLAnimation.setRepeatMode(i);
        }
    }
}
