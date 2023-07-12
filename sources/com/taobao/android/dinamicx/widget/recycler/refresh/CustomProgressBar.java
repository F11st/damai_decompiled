package com.taobao.android.dinamicx.widget.recycler.refresh;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import tb.nz;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class CustomProgressBar extends View {
    private static final String TAG = "CustomProgressBar";
    private final float DEFAULT_START_ANGLE;
    private final float MAX_SWEEP_ANGLE;
    private final float MIN_START_ANGLE;
    private int mDistance;
    private boolean mIsLoading;
    private boolean mIsShow;
    private Paint mPaint;
    private RectF mRectF;
    private float mStartAngle;
    private float mSweepAngle;
    float preDistance;

    public CustomProgressBar(Context context) {
        this(context, null);
    }

    private void init() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setColor(-6710887);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setFlags(1);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(3.0f);
        this.mRectF = new RectF();
    }

    public void changeProgressBarState(int i) {
        if (i < 0) {
            this.mStartAngle = 260.0f;
            this.mSweepAngle = 0.0f;
            invalidate();
            return;
        }
        float f = i;
        float f2 = ((f - this.preDistance) / this.mDistance) * 340.0f;
        float f3 = this.mStartAngle - f2;
        this.mStartAngle = f3;
        this.mSweepAngle += f2;
        if (f3 < -80.0f) {
            nz.i(TAG, "不在距离范围之内");
            this.mStartAngle = -80.0f;
            this.mSweepAngle = 340.0f;
            float f4 = this.preDistance;
            int i2 = this.mDistance;
            if (f4 == i2) {
                return;
            }
            this.preDistance = i2;
        } else {
            nz.i(TAG, "在距离中");
            this.preDistance = f;
        }
        invalidate();
    }

    public void isInitShow(boolean z) {
        this.mIsShow = z;
        if (z) {
            this.mSweepAngle = 340.0f;
            this.mStartAngle = -80.0f;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.mRectF.set(3.0f, 3.0f, getWidth() - 3.0f, getHeight() - 3.0f);
        canvas.drawArc(this.mRectF, this.mStartAngle, this.mSweepAngle, false, this.mPaint);
        if (this.mIsLoading) {
            this.mStartAngle += 10.0f;
            invalidate();
        }
    }

    public void setPaintColor(int i) {
        Paint paint = this.mPaint;
        if (paint != null) {
            paint.setColor(i);
        }
    }

    public void setPullDownDistance(int i) {
        this.mDistance = i;
    }

    public void startLoadingAnimaton() {
        this.mSweepAngle = 340.0f;
        this.mStartAngle = -80.0f;
        this.mIsLoading = true;
        invalidate();
    }

    public void stopLoadingAnimation() {
        this.mIsLoading = false;
        this.preDistance = 0.0f;
        if (this.mIsShow) {
            this.mSweepAngle = 340.0f;
            this.mStartAngle = -80.0f;
        } else {
            this.mStartAngle = 260.0f;
            this.mSweepAngle = 0.0f;
        }
        invalidate();
    }

    public CustomProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CustomProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.MAX_SWEEP_ANGLE = 340.0f;
        this.MIN_START_ANGLE = -80.0f;
        this.DEFAULT_START_ANGLE = 260.0f;
        this.mIsLoading = false;
        this.mStartAngle = 260.0f;
        this.mSweepAngle = 0.0f;
        this.mIsShow = false;
        this.preDistance = 0.0f;
        init();
    }
}
