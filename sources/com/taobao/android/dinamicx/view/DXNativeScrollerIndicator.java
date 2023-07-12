package com.taobao.android.dinamicx.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class DXNativeScrollerIndicator extends View {
    private boolean isHorizontal;
    private float radii;
    private Paint rectPaint;
    private RectF scrollBarRectF;
    private int scrollBarThumbColor;
    private int scrollBarTrackColor;
    private RectF thumbRectF;

    public DXNativeScrollerIndicator(Context context) {
        super(context);
        this.scrollBarTrackColor = -2828066;
        this.scrollBarThumbColor = -37590;
        this.scrollBarRectF = new RectF();
        this.thumbRectF = new RectF();
        this.isHorizontal = true;
        Paint paint = new Paint();
        this.rectPaint = paint;
        paint.setAntiAlias(true);
        this.rectPaint.setStyle(Paint.Style.FILL);
    }

    public float getRadii() {
        return this.radii;
    }

    public boolean isHorizontal() {
        return this.isHorizontal;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.rectPaint.setColor(this.scrollBarTrackColor);
        RectF rectF = this.scrollBarRectF;
        float f = this.radii;
        canvas.drawRoundRect(rectF, f, f, this.rectPaint);
        this.rectPaint.setColor(this.scrollBarThumbColor);
        RectF rectF2 = this.thumbRectF;
        float f2 = this.radii;
        canvas.drawRoundRect(rectF2, f2, f2, this.rectPaint);
    }

    public void refreshScrollIndicator(double d, double d2, int i, int i2) {
        double max = Math.max(Math.min(d, 1.0d), 0.0d);
        int max2 = (int) (i * Math.max(Math.min(d2, 1.0d), 0.0d));
        int i3 = (int) ((i - max2) * max);
        float f = i2;
        this.thumbRectF.set(i3, 0.0f, i3 + max2, f);
        this.scrollBarRectF.set(0.0f, 0.0f, i, f);
        invalidate();
    }

    public void setHorizontal(boolean z) {
        this.isHorizontal = z;
    }

    public void setRadii(float f) {
        this.radii = f;
    }

    public void setScrollBarThumbColor(int i) {
        this.scrollBarThumbColor = i;
    }

    public void setScrollBarTrackColor(int i) {
        this.scrollBarTrackColor = i;
    }
}
