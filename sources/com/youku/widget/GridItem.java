package com.youku.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baseproject.ui.R$styleable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class GridItem extends LinearLayout {
    private int height;
    private Paint mPaint;
    private float percent;
    private int width;

    public GridItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPaint = new Paint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.hisPercent);
        this.percent = obtainStyledAttributes.getFloat(R$styleable.hisPercent_percent, 0.0f);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.percent == 0.0f) {
            return;
        }
        this.mPaint.setColor(-13382401);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(4.0f);
        float f = this.percent;
        if (f <= 25.0f && f > 0.0f) {
            canvas.drawLine(0.0f, 0.0f, (f * this.width) / 25.0f, 0.0f, this.mPaint);
        } else if (f > 25.0f && f <= 50.0f) {
            canvas.drawLine(0.0f, 0.0f, this.width, 0.0f, this.mPaint);
            int i = this.width;
            canvas.drawLine(i, 0.0f, i, ((this.percent - 25.0f) * i) / 25.0f, this.mPaint);
        } else if (f > 50.0f && f <= 75.0f) {
            canvas.drawLine(0.0f, 0.0f, this.width, 0.0f, this.mPaint);
            int i2 = this.width;
            canvas.drawLine(i2, 0.0f, i2, i2, this.mPaint);
            int i3 = this.width;
            canvas.drawLine(i3 - (((this.percent - 50.0f) * i3) / 25.0f), i3, i3, i3, this.mPaint);
        } else if (f <= 75.0f || f > 100.0f) {
        } else {
            canvas.drawLine(0.0f, 0.0f, this.width, 0.0f, this.mPaint);
            int i4 = this.width;
            canvas.drawLine(i4, 0.0f, i4, i4, this.mPaint);
            int i5 = this.width;
            canvas.drawLine(i5, i5, 0.0f, i5, this.mPaint);
            int i6 = this.width;
            canvas.drawLine(0.0f, i6, 0.0f, i6 - (((this.percent - 75.0f) * i6) / 25.0f), this.mPaint);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        this.width = size;
        this.height = size;
        setMeasuredDimension(size, size);
    }

    public void setPercent(float f) {
        this.percent = f;
    }
}
