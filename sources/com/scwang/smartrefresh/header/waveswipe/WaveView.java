package com.scwang.smartrefresh.header.waveswipe;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;
import androidx.annotation.ColorInt;
import tb.cd0;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class WaveView extends View implements ViewTreeObserver.OnPreDrawListener {
    protected static final long DROP_BOUNCE_ANIMATOR_DURATION = 500;
    protected static final long DROP_CIRCLE_ANIMATOR_DURATION = 500;
    protected static final int DROP_REMOVE_ANIMATOR_DURATION = 200;
    protected static final long DROP_VERTEX_ANIMATION_DURATION = 500;
    protected static final float MAX_WAVE_HEIGHT = 0.2f;
    protected static final int SHADOW_COLOR = -1728053248;
    protected static final int WAVE_ANIMATOR_DURATION = 1000;
    protected ValueAnimator.AnimatorUpdateListener mAnimatorUpdateListener;
    protected float mCurrentCircleCenterY;
    protected ValueAnimator mDisappearCircleAnimator;
    protected ValueAnimator mDropBounceHorizontalAnimator;
    protected ValueAnimator mDropBounceVerticalAnimator;
    protected ValueAnimator mDropCircleAnimator;
    protected Path mDropCirclePath;
    protected float mDropCircleRadius;
    protected boolean mDropHeightUpdated;
    protected RectF mDropRect;
    protected Path mDropTangentPath;
    protected ValueAnimator mDropVertexAnimator;
    protected boolean mIsManualRefreshing;
    protected int mMaxDropHeight;
    protected Paint mPaint;
    protected Path mShadowPath;
    protected int mUpdateMaxDropHeight;
    protected Path mWavePath;
    protected ValueAnimator mWaveReverseAnimator;
    protected int mWidth;
    protected static final float[][] BEGIN_PHASE_POINTS = {new float[]{0.1655f, 0.0f}, new float[]{0.4188f, -0.0109f}, new float[]{0.4606f, -0.0049f}, new float[]{0.4893f, 0.0f}, new float[]{0.4893f, 0.0f}, new float[]{0.5f, 0.0f}};
    protected static final float[][] APPEAR_PHASE_POINTS = {new float[]{0.1655f, 0.0f}, new float[]{0.5237f, 0.0553f}, new float[]{0.4557f, 0.0936f}, new float[]{0.3908f, 0.1302f}, new float[]{0.4303f, 0.2173f}, new float[]{0.5f, 0.2173f}};
    protected static final float[][] EXPAND_PHASE_POINTS = {new float[]{0.1655f, 0.0f}, new float[]{0.5909f, 0.0f}, new float[]{0.4557f, 0.1642f}, new float[]{0.3941f, 0.2061f}, new float[]{0.4303f, 0.2889f}, new float[]{0.5f, 0.2889f}};

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            WaveView.this.postInvalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            WaveView.this.mCurrentCircleCenterY = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            WaveView waveView = WaveView.this;
            if (Build.VERSION.SDK_INT >= 16) {
                waveView.postInvalidateOnAnimation();
            } else {
                waveView.invalidate();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            WaveView.this.resetAnimator();
            WaveView.this.mIsManualRefreshing = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            WaveView.this.mWavePath.moveTo(0.0f, 0.0f);
            WaveView waveView = WaveView.this;
            Path path = waveView.mWavePath;
            int i = waveView.mWidth;
            float f = floatValue * 0.5f;
            path.quadTo(i * 0.25f, 0.0f, i * 0.333f, f);
            WaveView waveView2 = WaveView.this;
            Path path2 = waveView2.mWavePath;
            int i2 = waveView2.mWidth;
            path2.quadTo(i2 * 0.5f, floatValue * 1.4f, i2 * 0.666f, f);
            WaveView waveView3 = WaveView.this;
            Path path3 = waveView3.mWavePath;
            int i3 = waveView3.mWidth;
            path3.quadTo(i3 * 0.75f, 0.0f, i3, 0.0f);
            WaveView.this.postInvalidate();
        }
    }

    public WaveView(Context context) {
        super(context);
        this.mDropCircleRadius = 100.0f;
        this.mIsManualRefreshing = false;
        this.mDropHeightUpdated = false;
        this.mAnimatorUpdateListener = new a();
        float f = getResources().getDisplayMetrics().density;
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setColor(-14575885);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setShadowLayer((int) ((f * 2.0f) + 0.5f), 0.0f, 0.0f, -1728053248);
        this.mWavePath = new Path();
        this.mDropTangentPath = new Path();
        this.mDropCirclePath = new Path();
        this.mShadowPath = new Path();
        resetAnimator();
        this.mDropRect = new RectF();
        setLayerType(1, null);
        getViewTreeObserver().addOnPreDrawListener(this);
    }

    public void animationDropCircle() {
        if (this.mDisappearCircleAnimator.isRunning()) {
            return;
        }
        startDropAnimation();
        startWaveAnimation(0.1f);
    }

    public void appearPhase(float f, float f2) {
        onPreDragWave();
        this.mWavePath.moveTo(0.0f, 0.0f);
        Path path = this.mWavePath;
        int i = this.mWidth;
        float[][] fArr = APPEAR_PHASE_POINTS;
        float[][] fArr2 = BEGIN_PHASE_POINTS;
        path.cubicTo(fArr[0][0] * i, fArr[0][1] * i, Math.min(fArr2[1][0] + f2, fArr[1][0]) * i, Math.max((fArr2[1][1] + f) - f2, fArr[1][1]) * this.mWidth, Math.max(fArr2[2][0] - f2, fArr[2][0]) * this.mWidth, Math.max((fArr2[2][1] + f) - f2, fArr[2][1]) * this.mWidth);
        Path path2 = this.mWavePath;
        float max = this.mWidth * Math.max(fArr2[3][0] - f2, fArr[3][0]);
        float min = this.mWidth * Math.min(fArr2[3][1] + f + f2, fArr[3][1]);
        float max2 = this.mWidth * Math.max(fArr2[4][0] - f2, fArr[4][0]);
        float min2 = this.mWidth * Math.min(fArr2[4][1] + f + f2, fArr[4][1]);
        int i2 = this.mWidth;
        path2.cubicTo(max, min, max2, min2, i2 * fArr[5][0], i2 * Math.min(fArr2[0][1] + f + f2, fArr[5][1]));
        Path path3 = this.mWavePath;
        int i3 = this.mWidth;
        float max3 = i3 - (i3 * Math.max(fArr2[4][0] - f2, fArr[4][0]));
        float min3 = this.mWidth * Math.min(fArr2[4][1] + f + f2, fArr[4][1]);
        int i4 = this.mWidth;
        float max4 = i4 - (i4 * Math.max(fArr2[3][0] - f2, fArr[3][0]));
        float min4 = this.mWidth * Math.min(fArr2[3][1] + f + f2, fArr[3][1]);
        int i5 = this.mWidth;
        path3.cubicTo(max3, min3, max4, min4, i5 - (i5 * Math.max(fArr2[2][0] - f2, fArr[2][0])), this.mWidth * Math.max((fArr2[2][1] + f) - f2, fArr[2][1]));
        Path path4 = this.mWavePath;
        int i6 = this.mWidth;
        float min5 = i6 - (i6 * Math.min(fArr2[1][0] + f2, fArr[1][0]));
        float max5 = this.mWidth * Math.max((fArr2[1][1] + f) - f2, fArr[1][1]);
        int i7 = this.mWidth;
        path4.cubicTo(min5, max5, i7 - (i7 * fArr[0][0]), i7 * fArr[0][1], i7, 0.0f);
        this.mCurrentCircleCenterY = (this.mWidth * Math.min(fArr2[3][1] + f + f2, fArr[3][1])) + this.mDropCircleRadius;
        if (Build.VERSION.SDK_INT >= 16) {
            postInvalidateOnAnimation();
        } else {
            invalidate();
        }
    }

    public void beginPhase(float f) {
        onPreDragWave();
        this.mWavePath.moveTo(0.0f, 0.0f);
        Path path = this.mWavePath;
        int i = this.mWidth;
        float[][] fArr = BEGIN_PHASE_POINTS;
        path.cubicTo(fArr[0][0] * i, fArr[0][1], fArr[1][0] * i, (fArr[1][1] + f) * i, fArr[2][0] * i, i * (fArr[2][1] + f));
        Path path2 = this.mWavePath;
        int i2 = this.mWidth;
        path2.cubicTo(i2 * fArr[3][0], i2 * (fArr[3][1] + f), i2 * fArr[4][0], i2 * (fArr[4][1] + f), i2 * fArr[5][0], i2 * (fArr[5][1] + f));
        Path path3 = this.mWavePath;
        int i3 = this.mWidth;
        path3.cubicTo(i3 - (i3 * fArr[4][0]), i3 * (fArr[4][1] + f), i3 - (i3 * fArr[3][0]), i3 * (fArr[3][1] + f), i3 - (i3 * fArr[2][0]), i3 * (fArr[2][1] + f));
        Path path4 = this.mWavePath;
        int i4 = this.mWidth;
        path4.cubicTo(i4 - (i4 * fArr[1][0]), i4 * (fArr[1][1] + f), i4 - (i4 * fArr[0][0]), fArr[0][1], i4, 0.0f);
        if (Build.VERSION.SDK_INT >= 16) {
            postInvalidateOnAnimation();
        } else {
            invalidate();
        }
    }

    public void expandPhase(float f, float f2, float f3) {
        onPreDragWave();
        this.mWavePath.moveTo(0.0f, 0.0f);
        Path path = this.mWavePath;
        int i = this.mWidth;
        float[][] fArr = EXPAND_PHASE_POINTS;
        float[][] fArr2 = BEGIN_PHASE_POINTS;
        float[][] fArr3 = APPEAR_PHASE_POINTS;
        path.cubicTo(fArr[0][0] * i, fArr[0][1] * i, Math.min(Math.min(fArr2[1][0] + f2, fArr3[1][0]) + f3, fArr[1][0]) * i, Math.max(Math.max((fArr2[1][1] + f) - f2, fArr3[1][1]) - f3, fArr[1][1]) * this.mWidth, Math.max(fArr2[2][0] - f2, fArr[2][0]) * this.mWidth, Math.min(Math.max((fArr2[2][1] + f) - f2, fArr3[2][1]) + f3, fArr[2][1]) * this.mWidth);
        Path path2 = this.mWavePath;
        float min = this.mWidth * Math.min(Math.max(fArr2[3][0] - f2, fArr3[3][0]) + f3, fArr[3][0]);
        float min2 = this.mWidth * Math.min(Math.min(fArr2[3][1] + f + f2, fArr3[3][1]) + f3, fArr[3][1]);
        float max = this.mWidth * Math.max(fArr2[4][0] - f2, fArr[4][0]);
        float min3 = this.mWidth * Math.min(Math.min(fArr2[4][1] + f + f2, fArr3[4][1]) + f3, fArr[4][1]);
        int i2 = this.mWidth;
        path2.cubicTo(min, min2, max, min3, i2 * fArr[5][0], i2 * Math.min(Math.min(fArr2[0][1] + f + f2, fArr3[5][1]) + f3, fArr[5][1]));
        Path path3 = this.mWavePath;
        int i3 = this.mWidth;
        float max2 = i3 - (i3 * Math.max(fArr2[4][0] - f2, fArr[4][0]));
        float min4 = this.mWidth * Math.min(Math.min(fArr2[4][1] + f + f2, fArr3[4][1]) + f3, fArr[4][1]);
        int i4 = this.mWidth;
        float min5 = i4 - (i4 * Math.min(Math.max(fArr2[3][0] - f2, fArr3[3][0]) + f3, fArr[3][0]));
        float min6 = this.mWidth * Math.min(Math.min(fArr2[3][1] + f + f2, fArr3[3][1]) + f3, fArr[3][1]);
        int i5 = this.mWidth;
        path3.cubicTo(max2, min4, min5, min6, i5 - (i5 * Math.max(fArr2[2][0] - f2, fArr[2][0])), this.mWidth * Math.min(Math.max((fArr2[2][1] + f) - f2, fArr3[2][1]) + f3, fArr[2][1]));
        Path path4 = this.mWavePath;
        int i6 = this.mWidth;
        float min7 = i6 - (i6 * Math.min(Math.min(fArr2[1][0] + f2, fArr3[1][0]) + f3, fArr[1][0]));
        float max3 = this.mWidth * Math.max(Math.max((fArr2[1][1] + f) - f2, fArr3[1][1]) - f3, fArr[1][1]);
        int i7 = this.mWidth;
        path4.cubicTo(min7, max3, i7 - (i7 * fArr[0][0]), i7 * fArr[0][1], i7, 0.0f);
        this.mCurrentCircleCenterY = (this.mWidth * Math.min(Math.min(fArr2[3][1] + f + f2, fArr3[3][1]) + f3, fArr[3][1])) + this.mDropCircleRadius;
        if (Build.VERSION.SDK_INT >= 16) {
            postInvalidateOnAnimation();
        } else {
            invalidate();
        }
    }

    public float getCurrentCircleCenterY() {
        return this.mCurrentCircleCenterY;
    }

    public void manualRefresh() {
        if (this.mIsManualRefreshing) {
            return;
        }
        this.mIsManualRefreshing = true;
        int i = this.mMaxDropHeight;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(i, i);
        this.mDropCircleAnimator = ofFloat;
        ofFloat.start();
        int i2 = this.mMaxDropHeight;
        float f = this.mDropCircleRadius;
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(i2 - f, i2 - f);
        this.mDropVertexAnimator = ofFloat2;
        ofFloat2.start();
        this.mCurrentCircleCenterY = this.mMaxDropHeight;
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        ValueAnimator valueAnimator = this.mDisappearCircleAnimator;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.mDisappearCircleAnimator.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator2 = this.mDropCircleAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.end();
            this.mDropCircleAnimator.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator3 = this.mDropVertexAnimator;
        if (valueAnimator3 != null) {
            valueAnimator3.end();
            this.mDropVertexAnimator.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator4 = this.mWaveReverseAnimator;
        if (valueAnimator4 != null) {
            valueAnimator4.end();
            this.mWaveReverseAnimator.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator5 = this.mDropBounceHorizontalAnimator;
        if (valueAnimator5 != null) {
            valueAnimator5.end();
            this.mDropBounceHorizontalAnimator.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator6 = this.mDropBounceVerticalAnimator;
        if (valueAnimator6 != null) {
            valueAnimator6.end();
            this.mDropBounceVerticalAnimator.removeAllUpdateListeners();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float floatValue;
        super.onDraw(canvas);
        canvas.drawPath(this.mWavePath, this.mPaint);
        if (!isInEditMode()) {
            this.mWavePath.rewind();
            this.mDropTangentPath.rewind();
            this.mDropCirclePath.rewind();
        }
        float floatValue2 = ((Float) this.mDropCircleAnimator.getAnimatedValue()).floatValue();
        float f = this.mWidth / 2.0f;
        float floatValue3 = ((Float) this.mDisappearCircleAnimator.getAnimatedValue()).floatValue();
        float floatValue4 = ((Float) this.mDropBounceVerticalAnimator.getAnimatedValue()).floatValue();
        float floatValue5 = ((Float) this.mDropBounceHorizontalAnimator.getAnimatedValue()).floatValue();
        RectF rectF = this.mDropRect;
        float f2 = this.mDropCircleRadius;
        float f3 = floatValue4 + 1.0f;
        float f4 = 1.0f + floatValue5;
        rectF.set((f - ((f2 * f3) * floatValue3)) + ((f2 * floatValue5) / 2.0f), (((f2 * f4) * floatValue3) + floatValue2) - ((f2 * floatValue4) / 2.0f), (((f3 * f2) * floatValue3) + f) - ((floatValue5 * f2) / 2.0f), (floatValue2 - ((f4 * f2) * floatValue3)) + ((f2 * floatValue4) / 2.0f));
        this.mDropTangentPath.moveTo(f, ((Float) this.mDropVertexAnimator.getAnimatedValue()).floatValue());
        double d2 = floatValue2;
        double pow = ((Math.pow(this.mDropCircleRadius, 2.0d) + (floatValue2 * floatValue)) - Math.pow(d2, 2.0d)) / (floatValue - floatValue2);
        double d3 = (this.mWidth * (-2.0d)) / 2.0d;
        double d4 = -d3;
        double pow2 = (d3 * d3) - (((Math.pow(pow - d2, 2.0d) + Math.pow(f, 2.0d)) - Math.pow(this.mDropCircleRadius, 2.0d)) * 4.0d);
        float f5 = (float) pow;
        this.mDropTangentPath.lineTo((float) ((Math.sqrt(pow2) + d4) / 2.0d), f5);
        this.mDropTangentPath.lineTo((float) ((d4 - Math.sqrt(pow2)) / 2.0d), f5);
        this.mDropTangentPath.close();
        this.mShadowPath.set(this.mDropTangentPath);
        this.mShadowPath.addOval(this.mDropRect, Path.Direction.CCW);
        this.mDropCirclePath.addOval(this.mDropRect, Path.Direction.CCW);
        canvas.drawPath(this.mDropTangentPath, this.mPaint);
        canvas.drawPath(this.mDropCirclePath, this.mPaint);
    }

    protected void onPreDragWave() {
        ValueAnimator valueAnimator = this.mWaveReverseAnimator;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.mWaveReverseAnimator.cancel();
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        getViewTreeObserver().removeOnPreDrawListener(this);
        if (this.mDropHeightUpdated) {
            updateMaxDropHeight(this.mUpdateMaxDropHeight);
            return false;
        }
        return false;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        this.mWidth = i;
        this.mDropCircleRadius = i / 14.4f;
        updateMaxDropHeight((int) Math.min(Math.min(i, i2), getHeight() - this.mDropCircleRadius));
        super.onSizeChanged(i, i2, i3, i4);
    }

    protected void resetAnimator() {
        this.mDropVertexAnimator = ValueAnimator.ofFloat(0.0f, 0.0f);
        this.mDropBounceVerticalAnimator = ValueAnimator.ofFloat(0.0f, 0.0f);
        this.mDropBounceHorizontalAnimator = ValueAnimator.ofFloat(0.0f, 0.0f);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(-1000.0f, -1000.0f);
        this.mDropCircleAnimator = ofFloat;
        ofFloat.start();
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 1.0f);
        this.mDisappearCircleAnimator = ofFloat2;
        ofFloat2.setDuration(1L);
        this.mDisappearCircleAnimator.start();
    }

    public void setShadow(int i, int i2) {
        this.mPaint.setShadowLayer(i, 0.0f, 0.0f, i2);
    }

    public void setWaveColor(@ColorInt int i) {
        this.mPaint.setColor(i);
        invalidate();
    }

    public void startDisappearCircleAnimation() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.mDisappearCircleAnimator = ofFloat;
        ofFloat.addUpdateListener(this.mAnimatorUpdateListener);
        this.mDisappearCircleAnimator.setDuration(200L);
        this.mDisappearCircleAnimator.addListener(new c());
        this.mDisappearCircleAnimator.start();
    }

    public void startDropAnimation() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 1.0f);
        this.mDisappearCircleAnimator = ofFloat;
        ofFloat.setDuration(1L);
        this.mDisappearCircleAnimator.start();
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat((this.mWidth / 1440.0f) * 500.0f, this.mMaxDropHeight);
        this.mDropCircleAnimator = ofFloat2;
        ofFloat2.setDuration(500L);
        this.mDropCircleAnimator.addUpdateListener(new b());
        this.mDropCircleAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        this.mDropCircleAnimator.start();
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(0.0f, this.mMaxDropHeight - this.mDropCircleRadius);
        this.mDropVertexAnimator = ofFloat3;
        ofFloat3.setDuration(500L);
        this.mDropVertexAnimator.addUpdateListener(this.mAnimatorUpdateListener);
        this.mDropVertexAnimator.start();
        ValueAnimator ofFloat4 = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mDropBounceVerticalAnimator = ofFloat4;
        ofFloat4.setDuration(500L);
        this.mDropBounceVerticalAnimator.addUpdateListener(this.mAnimatorUpdateListener);
        this.mDropBounceVerticalAnimator.setInterpolator(new cd0());
        this.mDropBounceVerticalAnimator.setStartDelay(500L);
        this.mDropBounceVerticalAnimator.start();
        ValueAnimator ofFloat5 = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mDropBounceHorizontalAnimator = ofFloat5;
        ofFloat5.setDuration(500L);
        this.mDropBounceHorizontalAnimator.addUpdateListener(this.mAnimatorUpdateListener);
        this.mDropBounceHorizontalAnimator.setInterpolator(new cd0());
        this.mDropBounceHorizontalAnimator.setStartDelay(625L);
        this.mDropBounceHorizontalAnimator.start();
    }

    public void startWaveAnimation(float f) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(Math.min(f, 0.2f) * this.mWidth, 0.0f);
        this.mWaveReverseAnimator = ofFloat;
        ofFloat.setDuration(1000L);
        this.mWaveReverseAnimator.addUpdateListener(new d());
        this.mWaveReverseAnimator.setInterpolator(new BounceInterpolator());
        this.mWaveReverseAnimator.start();
    }

    protected void updateMaxDropHeight(int i) {
        float f = i;
        if ((this.mWidth / 1440.0f) * 500.0f > f) {
            return;
        }
        this.mMaxDropHeight = (int) Math.min(f, getHeight() - this.mDropCircleRadius);
        if (this.mIsManualRefreshing) {
            this.mIsManualRefreshing = false;
            manualRefresh();
        }
    }
}
