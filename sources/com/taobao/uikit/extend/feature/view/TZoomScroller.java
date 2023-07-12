package com.taobao.uikit.extend.feature.view;

import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class TZoomScroller {
    private float mCurrX;
    private float mCurrY;
    private float mCurrZ;
    private float mDeltaX;
    private float mDeltaY;
    private float mDeltaZ;
    private int mDuration;
    private float mDurationReciprocal;
    private float mFinalX;
    private float mFinalY;
    private float mFinalZ;
    private boolean mFinished = true;
    private Interpolator mInterPolator;
    private long mStartTime;
    private float mStartX;
    private float mStartY;
    private float mStartZ;

    public TZoomScroller(Interpolator interpolator) {
        this.mInterPolator = interpolator;
        if (interpolator == null) {
            this.mInterPolator = new AccelerateDecelerateInterpolator();
        }
    }

    public boolean computeScrollOffset() {
        if (this.mFinished) {
            return false;
        }
        int currentAnimationTimeMillis = (int) (AnimationUtils.currentAnimationTimeMillis() - this.mStartTime);
        if (currentAnimationTimeMillis < this.mDuration) {
            float interpolation = this.mInterPolator.getInterpolation(currentAnimationTimeMillis * this.mDurationReciprocal);
            this.mCurrX = this.mStartX + (this.mDeltaX * interpolation);
            this.mCurrY = this.mStartY + (this.mDeltaY * interpolation);
            this.mCurrZ = this.mStartZ + (interpolation * this.mDeltaZ);
        } else {
            this.mCurrX = this.mFinalX;
            this.mCurrY = this.mFinalY;
            this.mCurrZ = this.mFinalZ;
            this.mFinished = true;
        }
        return true;
    }

    public float getCurrX() {
        return this.mCurrX;
    }

    public float getCurrY() {
        return this.mCurrY;
    }

    public float getCurrZ() {
        return this.mCurrZ;
    }

    public void startScroll(float f, float f2, float f3, float f4, float f5, float f6, int i) {
        this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
        this.mDuration = i;
        this.mDurationReciprocal = 1.0f / i;
        this.mFinished = false;
        this.mStartX = f;
        this.mStartY = f2;
        this.mStartZ = f3;
        this.mFinalX = f + f4;
        this.mFinalY = f2 + f5;
        this.mFinalZ = f3 + f6;
        this.mDeltaX = f4;
        this.mDeltaY = f5;
        this.mDeltaZ = f6;
    }
}
