package com.airbnb.lottie.utils;

import android.view.Choreographer;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.airbnb.lottie.C2821a;
import tb.eg1;
import tb.f81;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class LottieValueAnimator extends BaseLottieAnimator implements Choreographer.FrameCallback {
    @Nullable
    private C2821a composition;
    private float speed = 1.0f;
    private boolean speedReversedForRepeatMode = false;
    private long lastFrameTimeNs = 0;
    private float frame = 0.0f;
    private int repeatCount = 0;
    private float minFrame = -2.1474836E9f;
    private float maxFrame = 2.1474836E9f;
    @VisibleForTesting
    protected boolean running = false;

    private float getFrameDurationNs() {
        C2821a c2821a = this.composition;
        if (c2821a == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / c2821a.h()) / Math.abs(this.speed);
    }

    private boolean isReversed() {
        return getSpeed() < 0.0f;
    }

    private void verifyFrame() {
        if (this.composition == null) {
            return;
        }
        float f = this.frame;
        if (f < this.minFrame || f > this.maxFrame) {
            throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.minFrame), Float.valueOf(this.maxFrame), Float.valueOf(this.frame)));
        }
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    @MainThread
    public void cancel() {
        notifyCancel();
        removeFrameCallback();
    }

    public void clearComposition() {
        this.composition = null;
        this.minFrame = -2.1474836E9f;
        this.maxFrame = 2.1474836E9f;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        postFrameCallback();
        if (this.composition == null || !isRunning()) {
            return;
        }
        f81.a("LottieValueAnimator#doFrame");
        long j2 = this.lastFrameTimeNs;
        float frameDurationNs = ((float) (j2 != 0 ? j - j2 : 0L)) / getFrameDurationNs();
        float f = this.frame;
        if (isReversed()) {
            frameDurationNs = -frameDurationNs;
        }
        float f2 = f + frameDurationNs;
        this.frame = f2;
        boolean z = !eg1.e(f2, getMinFrame(), getMaxFrame());
        this.frame = eg1.c(this.frame, getMinFrame(), getMaxFrame());
        this.lastFrameTimeNs = j;
        notifyUpdate();
        if (z) {
            if (getRepeatCount() != -1 && this.repeatCount >= getRepeatCount()) {
                this.frame = this.speed < 0.0f ? getMinFrame() : getMaxFrame();
                removeFrameCallback();
                notifyEnd(isReversed());
            } else {
                notifyRepeat();
                this.repeatCount++;
                if (getRepeatMode() == 2) {
                    this.speedReversedForRepeatMode = !this.speedReversedForRepeatMode;
                    reverseAnimationSpeed();
                } else {
                    this.frame = isReversed() ? getMaxFrame() : getMinFrame();
                }
                this.lastFrameTimeNs = j;
            }
        }
        verifyFrame();
        f81.b("LottieValueAnimator#doFrame");
    }

    @MainThread
    public void endAnimation() {
        removeFrameCallback();
        notifyEnd(isReversed());
    }

    @Override // android.animation.ValueAnimator
    @FloatRange(from = 0.0d, to = 1.0d)
    public float getAnimatedFraction() {
        float minFrame;
        float maxFrame;
        float minFrame2;
        if (this.composition == null) {
            return 0.0f;
        }
        if (isReversed()) {
            minFrame = getMaxFrame() - this.frame;
            maxFrame = getMaxFrame();
            minFrame2 = getMinFrame();
        } else {
            minFrame = this.frame - getMinFrame();
            maxFrame = getMaxFrame();
            minFrame2 = getMinFrame();
        }
        return minFrame / (maxFrame - minFrame2);
    }

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(getAnimatedValueAbsolute());
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getAnimatedValueAbsolute() {
        C2821a c2821a = this.composition;
        if (c2821a == null) {
            return 0.0f;
        }
        return (this.frame - c2821a.o()) / (this.composition.f() - this.composition.o());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        C2821a c2821a = this.composition;
        if (c2821a == null) {
            return 0L;
        }
        return c2821a.d();
    }

    public float getFrame() {
        return this.frame;
    }

    public float getMaxFrame() {
        C2821a c2821a = this.composition;
        if (c2821a == null) {
            return 0.0f;
        }
        float f = this.maxFrame;
        return f == 2.1474836E9f ? c2821a.f() : f;
    }

    public float getMinFrame() {
        C2821a c2821a = this.composition;
        if (c2821a == null) {
            return 0.0f;
        }
        float f = this.minFrame;
        return f == -2.1474836E9f ? c2821a.o() : f;
    }

    public float getSpeed() {
        return this.speed;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.running;
    }

    @MainThread
    public void pauseAnimation() {
        removeFrameCallback();
    }

    @MainThread
    public void playAnimation() {
        this.running = true;
        notifyStart(isReversed());
        setFrame((int) (isReversed() ? getMaxFrame() : getMinFrame()));
        this.lastFrameTimeNs = 0L;
        this.repeatCount = 0;
        postFrameCallback();
    }

    protected void postFrameCallback() {
        if (isRunning()) {
            removeFrameCallback(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    @MainThread
    protected void removeFrameCallback() {
        removeFrameCallback(true);
    }

    @MainThread
    public void resumeAnimation() {
        this.running = true;
        postFrameCallback();
        this.lastFrameTimeNs = 0L;
        if (isReversed() && getFrame() == getMinFrame()) {
            this.frame = getMaxFrame();
        } else if (isReversed() || getFrame() != getMaxFrame()) {
        } else {
            this.frame = getMinFrame();
        }
    }

    public void reverseAnimationSpeed() {
        setSpeed(-getSpeed());
    }

    public void setComposition(C2821a c2821a) {
        boolean z = this.composition == null;
        this.composition = c2821a;
        if (z) {
            setMinAndMaxFrames((int) Math.max(this.minFrame, c2821a.o()), (int) Math.min(this.maxFrame, c2821a.f()));
        } else {
            setMinAndMaxFrames((int) c2821a.o(), (int) c2821a.f());
        }
        float f = this.frame;
        this.frame = 0.0f;
        setFrame((int) f);
        notifyUpdate();
    }

    public void setFrame(float f) {
        if (this.frame == f) {
            return;
        }
        this.frame = eg1.c(f, getMinFrame(), getMaxFrame());
        this.lastFrameTimeNs = 0L;
        notifyUpdate();
    }

    public void setMaxFrame(float f) {
        setMinAndMaxFrames(this.minFrame, f);
    }

    public void setMinAndMaxFrames(float f, float f2) {
        if (f <= f2) {
            C2821a c2821a = this.composition;
            float o = c2821a == null ? -3.4028235E38f : c2821a.o();
            C2821a c2821a2 = this.composition;
            float f3 = c2821a2 == null ? Float.MAX_VALUE : c2821a2.f();
            this.minFrame = eg1.c(f, o, f3);
            this.maxFrame = eg1.c(f2, o, f3);
            setFrame((int) eg1.c(this.frame, f, f2));
            return;
        }
        throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", Float.valueOf(f), Float.valueOf(f2)));
    }

    public void setMinFrame(int i) {
        setMinAndMaxFrames(i, (int) this.maxFrame);
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i) {
        super.setRepeatMode(i);
        if (i == 2 || !this.speedReversedForRepeatMode) {
            return;
        }
        this.speedReversedForRepeatMode = false;
        reverseAnimationSpeed();
    }

    public void setSpeed(float f) {
        this.speed = f;
    }

    @MainThread
    protected void removeFrameCallback(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.running = false;
        }
    }
}
